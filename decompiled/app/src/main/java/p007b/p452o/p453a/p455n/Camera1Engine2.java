package p007b.p452o.p453a.p455n;

import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.location.Location;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.tasks.Task;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.CameraOptions;
import p007b.p452o.p453a.PictureResult;
import p007b.p452o.p453a.p454m.Facing;
import p007b.p452o.p453a.p454m.Flash;
import p007b.p452o.p453a.p454m.Hdr;
import p007b.p452o.p453a.p454m.Mode3;
import p007b.p452o.p453a.p454m.PictureFormat;
import p007b.p452o.p453a.p454m.WhiteBalance;
import p007b.p452o.p453a.p455n.CameraEngine;
import p007b.p452o.p453a.p455n.p458q.Camera1Mapper;
import p007b.p452o.p453a.p455n.p460s.Camera1MeteringTransform;
import p007b.p452o.p453a.p455n.p461t.Angles;
import p007b.p452o.p453a.p455n.p461t.Reference2;
import p007b.p452o.p453a.p455n.p462u.Camera1Options;
import p007b.p452o.p453a.p455n.p463v.CameraState2;
import p007b.p452o.p453a.p455n.p463v.CameraStateOrchestrator;
import p007b.p452o.p453a.p455n.p463v.CameraStateOrchestrator3;
import p007b.p452o.p453a.p455n.p463v.CameraStateOrchestrator4;
import p007b.p452o.p453a.p465p.ByteBufferFrameManager;
import p007b.p452o.p453a.p465p.Frame2;
import p007b.p452o.p453a.p465p.FrameManager;
import p007b.p452o.p453a.p466q.Gesture;
import p007b.p452o.p453a.p469t.MeteringRegions;
import p007b.p452o.p453a.p471v.Full1PictureRecorder;
import p007b.p452o.p453a.p471v.Snapshot1PictureRecorder;
import p007b.p452o.p453a.p471v.SnapshotGlPictureRecorder;
import p007b.p452o.p453a.p472w.RendererCameraPreview;
import p007b.p452o.p453a.p473x.AspectRatio2;
import p007b.p452o.p453a.p473x.Size3;

/* compiled from: Camera1Engine.java */
/* renamed from: b.o.a.n.b, reason: use source file name */
/* loaded from: classes3.dex */
public class Camera1Engine2 extends CameraBaseEngine implements Camera.PreviewCallback, Camera.ErrorCallback, ByteBufferFrameManager.a {

    /* renamed from: d0 */
    public final Camera1Mapper f13771d0;

    /* renamed from: e0 */
    public Camera f13772e0;

    /* renamed from: f0 */
    @VisibleForTesting
    public int f13773f0;

    /* compiled from: Camera1Engine.java */
    /* renamed from: b.o.a.n.b$a */
    public class a implements Runnable {

        /* renamed from: j */
        public final /* synthetic */ MeteringRegions f13774j;

        /* renamed from: k */
        public final /* synthetic */ Gesture f13775k;

        /* renamed from: l */
        public final /* synthetic */ PointF f13776l;

        /* compiled from: Camera1Engine.java */
        /* renamed from: b.o.a.n.b$a$a, reason: collision with other inner class name */
        public class RunnableC13242a implements Runnable {
            public RunnableC13242a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                ((CameraView.C11195b) Camera1Engine2.this.f13921m).m9314d(aVar.f13775k, false, aVar.f13776l);
            }
        }

        /* compiled from: Camera1Engine.java */
        /* renamed from: b.o.a.n.b$a$b */
        public class b implements Camera.AutoFocusCallback {

            /* compiled from: Camera1Engine.java */
            /* renamed from: b.o.a.n.b$a$b$a, reason: collision with other inner class name */
            public class RunnableC13243a implements Runnable {
                public RunnableC13243a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Camera1Engine2.this.f13772e0.cancelAutoFocus();
                    Camera.Parameters parameters = Camera1Engine2.this.f13772e0.getParameters();
                    int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                    int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                    if (maxNumFocusAreas > 0) {
                        parameters.setFocusAreas(null);
                    }
                    if (maxNumMeteringAreas > 0) {
                        parameters.setMeteringAreas(null);
                    }
                    Camera1Engine2.this.m7206c1(parameters);
                    Camera1Engine2.this.f13772e0.setParameters(parameters);
                }
            }

            public b() {
            }

            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z2, Camera camera) {
                Camera1Engine2.this.f13922n.m7366e("focus end", 0);
                Camera1Engine2.this.f13922n.m7366e("focus reset", 0);
                a aVar = a.this;
                ((CameraView.C11195b) Camera1Engine2.this.f13921m).m9314d(aVar.f13775k, z2, aVar.f13776l);
                if (Camera1Engine2.this.m7278a1()) {
                    Camera1Engine2 camera1Engine2 = Camera1Engine2.this;
                    CameraStateOrchestrator cameraStateOrchestrator = camera1Engine2.f13922n;
                    cameraStateOrchestrator.m7364c("focus reset", true, camera1Engine2.f13888W, new CameraStateOrchestrator4(cameraStateOrchestrator, CameraState2.ENGINE, new RunnableC13243a()));
                }
            }
        }

        public a(MeteringRegions meteringRegions, Gesture gesture, PointF pointF) {
            this.f13774j = meteringRegions;
            this.f13775k = gesture;
            this.f13776l = pointF;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Camera1Engine2.this.f13896p.f13696o) {
                Camera1Engine2 camera1Engine2 = Camera1Engine2.this;
                Camera1MeteringTransform camera1MeteringTransform = new Camera1MeteringTransform(camera1Engine2.f13877L, camera1Engine2.f13895o.m7432l());
                MeteringRegions meteringRegionsM7411c = this.f13774j.m7411c(camera1MeteringTransform);
                Camera.Parameters parameters = Camera1Engine2.this.f13772e0.getParameters();
                int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                if (maxNumFocusAreas > 0) {
                    parameters.setFocusAreas(meteringRegionsM7411c.m7410b(maxNumFocusAreas, camera1MeteringTransform));
                }
                if (maxNumMeteringAreas > 0) {
                    parameters.setMeteringAreas(meteringRegionsM7411c.m7410b(maxNumMeteringAreas, camera1MeteringTransform));
                }
                parameters.setFocusMode("auto");
                Camera1Engine2.this.f13772e0.setParameters(parameters);
                ((CameraView.C11195b) Camera1Engine2.this.f13921m).m9315e(this.f13775k, this.f13776l);
                Camera1Engine2.this.f13922n.m7366e("focus end", 0);
                Camera1Engine2.this.f13922n.m7364c("focus end", true, 2500L, new RunnableC13242a());
                try {
                    Camera1Engine2.this.f13772e0.autoFocus(new b());
                } catch (RuntimeException e) {
                    CameraEngine.f13918j.m7159a(3, "startAutoFocus:", "Error calling autoFocus", e);
                }
            }
        }
    }

    /* compiled from: Camera1Engine.java */
    /* renamed from: b.o.a.n.b$b */
    public class b implements Runnable {

        /* renamed from: j */
        public final /* synthetic */ Flash f13781j;

        public b(Flash flash) {
            this.f13781j = flash;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine2.this.f13772e0.getParameters();
            if (Camera1Engine2.this.m7209e1(parameters, this.f13781j)) {
                Camera1Engine2.this.f13772e0.setParameters(parameters);
            }
        }
    }

    /* compiled from: Camera1Engine.java */
    /* renamed from: b.o.a.n.b$c */
    public class c implements Runnable {

        /* renamed from: j */
        public final /* synthetic */ Location f13783j;

        public c(Location location) {
            this.f13783j = location;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine2.this.f13772e0.getParameters();
            Camera1Engine2.this.m7213g1(parameters);
            Camera1Engine2.this.f13772e0.setParameters(parameters);
        }
    }

    /* compiled from: Camera1Engine.java */
    /* renamed from: b.o.a.n.b$d */
    public class d implements Runnable {

        /* renamed from: j */
        public final /* synthetic */ WhiteBalance f13785j;

        public d(WhiteBalance whiteBalance) {
            this.f13785j = whiteBalance;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine2.this.f13772e0.getParameters();
            if (Camera1Engine2.this.m7216j1(parameters, this.f13785j)) {
                Camera1Engine2.this.f13772e0.setParameters(parameters);
            }
        }
    }

    /* compiled from: Camera1Engine.java */
    /* renamed from: b.o.a.n.b$e */
    public class e implements Runnable {

        /* renamed from: j */
        public final /* synthetic */ Hdr f13787j;

        public e(Hdr hdr) {
            this.f13787j = hdr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine2.this.f13772e0.getParameters();
            if (Camera1Engine2.this.m7211f1(parameters, this.f13787j)) {
                Camera1Engine2.this.f13772e0.setParameters(parameters);
            }
        }
    }

    /* compiled from: Camera1Engine.java */
    /* renamed from: b.o.a.n.b$f */
    public class f implements Runnable {

        /* renamed from: j */
        public final /* synthetic */ float f13789j;

        /* renamed from: k */
        public final /* synthetic */ boolean f13790k;

        /* renamed from: l */
        public final /* synthetic */ PointF[] f13791l;

        public f(float f, boolean z2, PointF[] pointFArr) {
            this.f13789j = f;
            this.f13790k = z2;
            this.f13791l = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine2.this.f13772e0.getParameters();
            if (Camera1Engine2.this.m7218k1(parameters, this.f13789j)) {
                Camera1Engine2.this.f13772e0.setParameters(parameters);
                if (this.f13790k) {
                    Camera1Engine2 camera1Engine2 = Camera1Engine2.this;
                    ((CameraView.C11195b) camera1Engine2.f13921m).m9316f(camera1Engine2.f13869D, this.f13791l);
                }
            }
        }
    }

    /* compiled from: Camera1Engine.java */
    /* renamed from: b.o.a.n.b$g */
    public class g implements Runnable {

        /* renamed from: j */
        public final /* synthetic */ float f13793j;

        /* renamed from: k */
        public final /* synthetic */ boolean f13794k;

        /* renamed from: l */
        public final /* synthetic */ float[] f13795l;

        /* renamed from: m */
        public final /* synthetic */ PointF[] f13796m;

        public g(float f, boolean z2, float[] fArr, PointF[] pointFArr) {
            this.f13793j = f;
            this.f13794k = z2;
            this.f13795l = fArr;
            this.f13796m = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine2.this.f13772e0.getParameters();
            if (Camera1Engine2.this.m7208d1(parameters, this.f13793j)) {
                Camera1Engine2.this.f13772e0.setParameters(parameters);
                if (this.f13794k) {
                    Camera1Engine2 camera1Engine2 = Camera1Engine2.this;
                    ((CameraView.C11195b) camera1Engine2.f13921m).m9313c(camera1Engine2.f13870E, this.f13795l, this.f13796m);
                }
            }
        }
    }

    /* compiled from: Camera1Engine.java */
    /* renamed from: b.o.a.n.b$h */
    public class h implements Runnable {

        /* renamed from: j */
        public final /* synthetic */ boolean f13798j;

        public h(boolean z2) {
            this.f13798j = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera1Engine2.this.m7214h1(this.f13798j);
        }
    }

    /* compiled from: Camera1Engine.java */
    /* renamed from: b.o.a.n.b$i */
    public class i implements Runnable {

        /* renamed from: j */
        public final /* synthetic */ float f13800j;

        public i(float f) {
            this.f13800j = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine2.this.f13772e0.getParameters();
            if (Camera1Engine2.this.m7215i1(parameters, this.f13800j)) {
                Camera1Engine2.this.f13772e0.setParameters(parameters);
            }
        }
    }

    public Camera1Engine2(@NonNull CameraEngine.g gVar) {
        super(gVar);
        this.f13771d0 = Camera1Mapper.m7346a();
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* renamed from: F0 */
    public void mo7190F0(@NonNull WhiteBalance whiteBalance) {
        WhiteBalance whiteBalance2 = this.f13904x;
        this.f13904x = whiteBalance;
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b("white balance (" + whiteBalance + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new d(whiteBalance2)));
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* renamed from: G0 */
    public void mo7191G0(float f2, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.f13869D;
        this.f13869D = f2;
        this.f13922n.m7366e("zoom", 20);
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b("zoom", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new f(f3, z2, pointFArr)));
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* renamed from: I0 */
    public void mo7192I0(@Nullable Gesture gesture, @NonNull MeteringRegions meteringRegions, @NonNull PointF pointF) {
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b("auto focus", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.BIND, new a(meteringRegions, gesture, pointF)));
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* renamed from: P */
    public Task<Void> mo7193P() {
        CameraLogger cameraLogger = CameraEngine.f13918j;
        cameraLogger.m7159a(1, "onStartBind:", "Started");
        try {
            if (this.f13895o.mo7430j() == SurfaceHolder.class) {
                this.f13772e0.setPreviewDisplay((SurfaceHolder) this.f13895o.mo7429i());
            } else {
                if (this.f13895o.mo7430j() != SurfaceTexture.class) {
                    throw new RuntimeException("Unknown CameraPreview output class.");
                }
                this.f13772e0.setPreviewTexture((SurfaceTexture) this.f13895o.mo7429i());
            }
            this.f13898r = m7271Q0(this.f13882Q);
            this.f13899s = m7272R0();
            cameraLogger.m7159a(1, "onStartBind:", "Returning");
            return C3404f.m4264Z(null);
        } catch (IOException e2) {
            CameraEngine.f13918j.m7159a(3, "onStartBind:", "Failed to bind.", e2);
            throw new CameraException(e2, 2);
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* renamed from: Q */
    public Task<CameraOptions> mo7194Q() {
        try {
            Camera cameraOpen = Camera.open(this.f13773f0);
            this.f13772e0 = cameraOpen;
            if (cameraOpen == null) {
                CameraEngine.f13918j.m7159a(3, "onStartEngine:", "Failed to connect. Camera is null, maybe in use by another app or already released?");
                throw new CameraException(1);
            }
            cameraOpen.setErrorCallback(this);
            CameraLogger cameraLogger = CameraEngine.f13918j;
            cameraLogger.m7159a(1, "onStartEngine:", "Applying default parameters.");
            try {
                Camera.Parameters parameters = this.f13772e0.getParameters();
                int i2 = this.f13773f0;
                Angles angles = this.f13877L;
                Reference2 reference2 = Reference2.SENSOR;
                Reference2 reference22 = Reference2.VIEW;
                this.f13896p = new Camera1Options(parameters, i2, angles.m7357b(reference2, reference22));
                m7204b1(parameters);
                this.f13772e0.setParameters(parameters);
                try {
                    this.f13772e0.setDisplayOrientation(this.f13877L.m7358c(reference2, reference22, 1));
                    cameraLogger.m7159a(1, "onStartEngine:", "Ended");
                    return C3404f.m4264Z(this.f13896p);
                } catch (Exception unused) {
                    CameraEngine.f13918j.m7159a(3, "onStartEngine:", "Failed to connect. Can't set display orientation, maybe preview already exists?");
                    throw new CameraException(1);
                }
            } catch (Exception e2) {
                CameraEngine.f13918j.m7159a(3, "onStartEngine:", "Failed to connect. Problem with camera params");
                throw new CameraException(e2, 1);
            }
        } catch (Exception e3) {
            CameraEngine.f13918j.m7159a(3, "onStartEngine:", "Failed to connect. Maybe in use by another app?");
            throw new CameraException(e3, 1);
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* renamed from: R */
    public Task<Void> mo7195R() {
        CameraLogger cameraLogger = CameraEngine.f13918j;
        cameraLogger.m7159a(1, "onStartPreview", "Dispatching onCameraPreviewStreamSizeChanged.");
        ((CameraView.C11195b) this.f13921m).m9318h();
        Size3 size3Mo7254C = mo7254C(Reference2.VIEW);
        if (size3Mo7254C == null) {
            throw new IllegalStateException("previewStreamSize should not be null at this point.");
        }
        this.f13895o.m7439s(size3Mo7254C.f14251j, size3Mo7254C.f14252k);
        this.f13895o.mo7438r(0);
        try {
            Camera.Parameters parameters = this.f13772e0.getParameters();
            parameters.setPreviewFormat(17);
            Size3 size3 = this.f13899s;
            parameters.setPreviewSize(size3.f14251j, size3.f14252k);
            Mode3 mode3 = this.f13882Q;
            Mode3 mode32 = Mode3.PICTURE;
            if (mode3 == mode32) {
                Size3 size32 = this.f13898r;
                parameters.setPictureSize(size32.f14251j, size32.f14252k);
            } else {
                Size3 size3M7271Q0 = m7271Q0(mode32);
                parameters.setPictureSize(size3M7271Q0.f14251j, size3M7271Q0.f14252k);
            }
            try {
                this.f13772e0.setParameters(parameters);
                this.f13772e0.setPreviewCallbackWithBuffer(null);
                this.f13772e0.setPreviewCallbackWithBuffer(this);
                m7220l1().mo7382e(17, this.f13899s, this.f13877L);
                cameraLogger.m7159a(1, "onStartPreview", "Starting preview with startPreview().");
                try {
                    this.f13772e0.startPreview();
                    cameraLogger.m7159a(1, "onStartPreview", "Started preview.");
                    return C3404f.m4264Z(null);
                } catch (Exception e2) {
                    CameraEngine.f13918j.m7159a(3, "onStartPreview", "Failed to start preview.", e2);
                    throw new CameraException(e2, 2);
                }
            } catch (Exception e3) {
                CameraEngine.f13918j.m7159a(3, "onStartPreview:", "Failed to set params for camera. Maybe incorrect parameter put in params?");
                throw new CameraException(e3, 2);
            }
        } catch (Exception e4) {
            CameraEngine.f13918j.m7159a(3, "onStartPreview:", "Failed to get params from camera. Maybe low level problem with camera or camera has already released?");
            throw new CameraException(e4, 2);
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* renamed from: S */
    public Task<Void> mo7196S() {
        this.f13899s = null;
        this.f13898r = null;
        try {
            if (this.f13895o.mo7430j() == SurfaceHolder.class) {
                this.f13772e0.setPreviewDisplay(null);
            } else {
                if (this.f13895o.mo7430j() != SurfaceTexture.class) {
                    throw new RuntimeException("Unknown CameraPreview output class.");
                }
                this.f13772e0.setPreviewTexture(null);
            }
        } catch (IOException e2) {
            CameraEngine.f13918j.m7159a(3, "onStopBind", "Could not release surface", e2);
        }
        return C3404f.m4264Z(null);
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* renamed from: T */
    public Task<Void> mo7197T() {
        CameraLogger cameraLogger = CameraEngine.f13918j;
        cameraLogger.m7159a(1, "onStopEngine:", "About to clean up.");
        this.f13922n.m7366e("focus reset", 0);
        this.f13922n.m7366e("focus end", 0);
        if (this.f13772e0 != null) {
            try {
                cameraLogger.m7159a(1, "onStopEngine:", "Clean up.", "Releasing camera.");
                this.f13772e0.release();
                cameraLogger.m7159a(1, "onStopEngine:", "Clean up.", "Released camera.");
            } catch (Exception e2) {
                CameraEngine.f13918j.m7159a(2, "onStopEngine:", "Clean up.", "Exception while releasing camera.", e2);
            }
            this.f13772e0 = null;
            this.f13896p = null;
        }
        this.f13896p = null;
        this.f13772e0 = null;
        CameraEngine.f13918j.m7159a(2, "onStopEngine:", "Clean up.", "Returning.");
        return C3404f.m4264Z(null);
    }

    @Override // p007b.p452o.p453a.p455n.CameraBaseEngine
    @NonNull
    /* renamed from: T0 */
    public List<Size3> mo7198T0() {
        try {
            List<Camera.Size> supportedPreviewSizes = this.f13772e0.getParameters().getSupportedPreviewSizes();
            ArrayList arrayList = new ArrayList(supportedPreviewSizes.size());
            for (Camera.Size size : supportedPreviewSizes) {
                Size3 size3 = new Size3(size.width, size.height);
                if (!arrayList.contains(size3)) {
                    arrayList.add(size3);
                }
            }
            CameraEngine.f13918j.m7159a(1, "getPreviewStreamAvailableSizes:", arrayList);
            return arrayList;
        } catch (Exception e2) {
            CameraEngine.f13918j.m7159a(3, "getPreviewStreamAvailableSizes:", "Failed to compute preview size. Camera params is empty");
            throw new CameraException(e2, 2);
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* renamed from: U */
    public Task<Void> mo7199U() {
        CameraLogger cameraLogger = CameraEngine.f13918j;
        cameraLogger.m7159a(1, "onStopPreview:", "Started.");
        this.f13897q = null;
        m7220l1().mo7381d();
        cameraLogger.m7159a(1, "onStopPreview:", "Releasing preview buffers.");
        this.f13772e0.setPreviewCallbackWithBuffer(null);
        try {
            cameraLogger.m7159a(1, "onStopPreview:", "Stopping preview.");
            this.f13772e0.stopPreview();
            cameraLogger.m7159a(1, "onStopPreview:", "Stopped preview.");
        } catch (Exception e2) {
            CameraEngine.f13918j.m7159a(3, "stopPreview", "Could not stop preview", e2);
        }
        return C3404f.m4264Z(null);
    }

    @Override // p007b.p452o.p453a.p455n.CameraBaseEngine
    @NonNull
    /* renamed from: V0 */
    public FrameManager mo7200V0(int i2) {
        return new ByteBufferFrameManager(i2, this);
    }

    @Override // p007b.p452o.p453a.p455n.CameraBaseEngine
    /* renamed from: X0 */
    public void mo7201X0() {
        CameraEngine.f13918j.m7159a(1, "RESTART PREVIEW:", "scheduled. State:", this.f13922n.f14028f);
        m7323N0(false);
        m7320K0();
    }

    @Override // p007b.p452o.p453a.p455n.CameraBaseEngine
    /* renamed from: Y0 */
    public void mo7202Y0(@NonNull PictureResult.a aVar, boolean z2) {
        CameraLogger cameraLogger = CameraEngine.f13918j;
        cameraLogger.m7159a(1, "onTakePicture:", "executing.");
        Angles angles = this.f13877L;
        Reference2 reference2 = Reference2.SENSOR;
        Reference2 reference22 = Reference2.OUTPUT;
        aVar.f13717c = angles.m7358c(reference2, reference22, 2);
        aVar.f13718d = mo7309w(reference22);
        Full1PictureRecorder full1PictureRecorder = new Full1PictureRecorder(aVar, this, this.f13772e0);
        this.f13897q = full1PictureRecorder;
        full1PictureRecorder.mo7417c();
        cameraLogger.m7159a(1, "onTakePicture:", "executed.");
    }

    @Override // p007b.p452o.p453a.p455n.CameraBaseEngine
    /* renamed from: Z0 */
    public void mo7203Z0(@NonNull PictureResult.a aVar, @NonNull AspectRatio2 aspectRatio2, boolean z2) {
        CameraLogger cameraLogger = CameraEngine.f13918j;
        cameraLogger.m7159a(1, "onTakePictureSnapshot:", "executing.");
        Reference2 reference2 = Reference2.OUTPUT;
        aVar.f13718d = mo7260F(reference2);
        if (this.f13895o instanceof RendererCameraPreview) {
            aVar.f13717c = this.f13877L.m7358c(Reference2.VIEW, reference2, 1);
            this.f13897q = new SnapshotGlPictureRecorder(aVar, this, (RendererCameraPreview) this.f13895o, aspectRatio2, this.f13894c0);
        } else {
            aVar.f13717c = this.f13877L.m7358c(Reference2.SENSOR, reference2, 2);
            this.f13897q = new Snapshot1PictureRecorder(aVar, this, this.f13772e0, aspectRatio2);
        }
        this.f13897q.mo7417c();
        cameraLogger.m7159a(1, "onTakePictureSnapshot:", "executed.");
    }

    /* renamed from: b1 */
    public final void m7204b1(@NonNull Camera.Parameters parameters) {
        parameters.setRecordingHint(this.f13882Q == Mode3.VIDEO);
        m7206c1(parameters);
        m7209e1(parameters, Flash.OFF);
        m7213g1(parameters);
        m7216j1(parameters, WhiteBalance.AUTO);
        m7211f1(parameters, Hdr.OFF);
        m7218k1(parameters, 0.0f);
        m7208d1(parameters, 0.0f);
        m7214h1(this.f13871F);
        m7215i1(parameters, 0.0f);
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* renamed from: c */
    public boolean mo7205c(@NonNull Facing facing) {
        Objects.requireNonNull(this.f13771d0);
        int iIntValue = Camera1Mapper.f13959d.get(facing).intValue();
        CameraEngine.f13918j.m7159a(1, "collectCameraInfo", "Facing:", facing, "Internal:", Integer.valueOf(iIntValue), "Cameras:", Integer.valueOf(Camera.getNumberOfCameras()));
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == iIntValue) {
                this.f13877L.m7361f(facing, cameraInfo.orientation);
                this.f13773f0 = i2;
                return true;
            }
        }
        return false;
    }

    /* renamed from: c1 */
    public final void m7206c1(@NonNull Camera.Parameters parameters) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (this.f13882Q == Mode3.VIDEO && supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
            return;
        }
        if (supportedFocusModes.contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
        } else if (supportedFocusModes.contains("infinity")) {
            parameters.setFocusMode("infinity");
        } else if (supportedFocusModes.contains("fixed")) {
            parameters.setFocusMode("fixed");
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* renamed from: d0 */
    public void mo7207d0(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.f13870E;
        this.f13870E = f2;
        this.f13922n.m7366e("exposure correction", 20);
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b("exposure correction", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new g(f3, z2, fArr, pointFArr)));
    }

    /* renamed from: d1 */
    public final boolean m7208d1(@NonNull Camera.Parameters parameters, float f2) {
        CameraOptions cameraOptions = this.f13896p;
        if (!cameraOptions.f13693l) {
            this.f13870E = f2;
            return false;
        }
        float f3 = cameraOptions.f13695n;
        float f4 = cameraOptions.f13694m;
        float f5 = this.f13870E;
        if (f5 < f4) {
            f3 = f4;
        } else if (f5 <= f3) {
            f3 = f5;
        }
        this.f13870E = f3;
        parameters.setExposureCompensation((int) (f3 / parameters.getExposureCompensationStep()));
        return true;
    }

    /* renamed from: e1 */
    public final boolean m7209e1(@NonNull Camera.Parameters parameters, @NonNull Flash flash) {
        if (!this.f13896p.m7163c(this.f13903w)) {
            this.f13903w = flash;
            return false;
        }
        Camera1Mapper camera1Mapper = this.f13771d0;
        Flash flash2 = this.f13903w;
        Objects.requireNonNull(camera1Mapper);
        parameters.setFlashMode(Camera1Mapper.f13957b.get(flash2));
        return true;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* renamed from: f0 */
    public void mo7210f0(@NonNull Flash flash) {
        Flash flash2 = this.f13903w;
        this.f13903w = flash;
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b("flash (" + flash + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new b(flash2)));
    }

    /* renamed from: f1 */
    public final boolean m7211f1(@NonNull Camera.Parameters parameters, @NonNull Hdr hdr) {
        if (!this.f13896p.m7163c(this.f13866A)) {
            this.f13866A = hdr;
            return false;
        }
        Camera1Mapper camera1Mapper = this.f13771d0;
        Hdr hdr2 = this.f13866A;
        Objects.requireNonNull(camera1Mapper);
        parameters.setSceneMode(Camera1Mapper.f13960e.get(hdr2));
        return true;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* renamed from: g0 */
    public void mo7212g0(int i2) {
        this.f13901u = 17;
    }

    /* renamed from: g1 */
    public final boolean m7213g1(@NonNull Camera.Parameters parameters) {
        Location location = this.f13868C;
        if (location == null) {
            return true;
        }
        parameters.setGpsLatitude(location.getLatitude());
        parameters.setGpsLongitude(this.f13868C.getLongitude());
        parameters.setGpsAltitude(this.f13868C.getAltitude());
        parameters.setGpsTimestamp(this.f13868C.getTime());
        parameters.setGpsProcessingMethod(this.f13868C.getProvider());
        return true;
    }

    @TargetApi(17)
    /* renamed from: h1 */
    public final boolean m7214h1(boolean z2) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.f13773f0, cameraInfo);
        if (cameraInfo.canDisableShutterSound) {
            try {
                return this.f13772e0.enableShutterSound(this.f13871F);
            } catch (RuntimeException unused) {
                return false;
            }
        }
        if (this.f13871F) {
            return true;
        }
        this.f13871F = z2;
        return false;
    }

    /* renamed from: i1 */
    public final boolean m7215i1(@NonNull Camera.Parameters parameters, float f2) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (!this.f13875J || this.f13874I == 0.0f) {
            Collections.sort(supportedPreviewFpsRange, new Camera1Engine(this));
        } else {
            Collections.sort(supportedPreviewFpsRange, new Camera1Engine3(this));
        }
        float f3 = this.f13874I;
        if (f3 == 0.0f) {
            for (int[] iArr : supportedPreviewFpsRange) {
                float f4 = iArr[0] / 1000.0f;
                float f5 = iArr[1] / 1000.0f;
                if ((f4 <= 30.0f && 30.0f <= f5) || (f4 <= 24.0f && 24.0f <= f5)) {
                    parameters.setPreviewFpsRange(iArr[0], iArr[1]);
                    return true;
                }
            }
        } else {
            float fMin = Math.min(f3, this.f13896p.f13698q);
            this.f13874I = fMin;
            this.f13874I = Math.max(fMin, this.f13896p.f13697p);
            for (int[] iArr2 : supportedPreviewFpsRange) {
                float f6 = iArr2[0] / 1000.0f;
                float f7 = iArr2[1] / 1000.0f;
                float fRound = Math.round(this.f13874I);
                if (f6 <= fRound && fRound <= f7) {
                    parameters.setPreviewFpsRange(iArr2[0], iArr2[1]);
                    return true;
                }
            }
        }
        this.f13874I = f2;
        return false;
    }

    /* renamed from: j1 */
    public final boolean m7216j1(@NonNull Camera.Parameters parameters, @NonNull WhiteBalance whiteBalance) {
        if (!this.f13896p.m7163c(this.f13904x)) {
            this.f13904x = whiteBalance;
            return false;
        }
        Camera1Mapper camera1Mapper = this.f13771d0;
        WhiteBalance whiteBalance2 = this.f13904x;
        Objects.requireNonNull(camera1Mapper);
        parameters.setWhiteBalance(Camera1Mapper.f13958c.get(whiteBalance2));
        parameters.remove("auto-whitebalance-lock");
        return true;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* renamed from: k0 */
    public void mo7217k0(boolean z2) {
        this.f13902v = z2;
    }

    /* renamed from: k1 */
    public final boolean m7218k1(@NonNull Camera.Parameters parameters, float f2) {
        if (!this.f13896p.f13692k) {
            this.f13869D = f2;
            return false;
        }
        parameters.setZoom((int) (this.f13869D * parameters.getMaxZoom()));
        this.f13772e0.setParameters(parameters);
        return true;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* renamed from: l0 */
    public void mo7219l0(@NonNull Hdr hdr) {
        Hdr hdr2 = this.f13866A;
        this.f13866A = hdr;
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b("hdr (" + hdr + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new e(hdr2)));
    }

    @NonNull
    /* renamed from: l1 */
    public ByteBufferFrameManager m7220l1() {
        return (ByteBufferFrameManager) m7273S0();
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* renamed from: m0 */
    public void mo7221m0(@Nullable Location location) {
        Location location2 = this.f13868C;
        this.f13868C = location;
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b(ModelAuditLogEntry.CHANGE_KEY_LOCATION, true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new c(location2)));
    }

    /* renamed from: m1 */
    public void m7222m1(@NonNull byte[] bArr) {
        CameraState2 cameraState2 = this.f13922n.f14028f;
        CameraState2 cameraState22 = CameraState2.ENGINE;
        if (cameraState2.m7367f(cameraState22) && this.f13922n.f14029g.m7367f(cameraState22)) {
            this.f13772e0.addCallbackBuffer(bArr);
        }
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i2, Camera camera) {
        throw new CameraException(new RuntimeException(CameraEngine.f13918j.m7159a(3, "Internal Camera1 error.", Integer.valueOf(i2))), (i2 == 1 || i2 == 2 || i2 == 100) ? 3 : 0);
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Frame2 frame2M7385a;
        if (bArr == null || (frame2M7385a = m7220l1().m7385a(bArr, System.currentTimeMillis())) == null) {
            return;
        }
        ((CameraView.C11195b) this.f13921m).m9312b(frame2M7385a);
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* renamed from: p0 */
    public void mo7223p0(@NonNull PictureFormat pictureFormat) {
        if (pictureFormat == PictureFormat.JPEG) {
            this.f13867B = pictureFormat;
            return;
        }
        throw new UnsupportedOperationException("Unsupported picture format: " + pictureFormat);
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* renamed from: t0 */
    public void mo7224t0(boolean z2) {
        boolean z3 = this.f13871F;
        this.f13871F = z2;
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b("play sounds (" + z2 + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new h(z3)));
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* renamed from: v0 */
    public void mo7225v0(float f2) {
        this.f13874I = f2;
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b("preview fps (" + f2 + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new i(f2)));
    }
}
