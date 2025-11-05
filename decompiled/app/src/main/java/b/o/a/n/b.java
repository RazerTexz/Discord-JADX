package b.o.a.n;

import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.location.Location;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.o.a.l;
import b.o.a.n.i;
import b.o.a.p.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.tasks.Task;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: Camera1Engine.java */
/* loaded from: classes3.dex */
public class b extends b.o.a.n.g implements Camera.PreviewCallback, Camera.ErrorCallback, a.InterfaceC0175a {

    /* renamed from: d0, reason: collision with root package name */
    public final b.o.a.n.q.a f1913d0;

    /* renamed from: e0, reason: collision with root package name */
    public Camera f1914e0;

    /* renamed from: f0, reason: collision with root package name */
    @VisibleForTesting
    public int f1915f0;

    /* compiled from: Camera1Engine.java */
    public class a implements Runnable {
        public final /* synthetic */ b.o.a.t.b j;
        public final /* synthetic */ b.o.a.q.a k;
        public final /* synthetic */ PointF l;

        /* compiled from: Camera1Engine.java */
        /* renamed from: b.o.a.n.b$a$a, reason: collision with other inner class name */
        public class RunnableC0167a implements Runnable {
            public RunnableC0167a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                ((CameraView.b) b.this.m).d(aVar.k, false, aVar.l);
            }
        }

        /* compiled from: Camera1Engine.java */
        /* renamed from: b.o.a.n.b$a$b, reason: collision with other inner class name */
        public class C0168b implements Camera.AutoFocusCallback {

            /* compiled from: Camera1Engine.java */
            /* renamed from: b.o.a.n.b$a$b$a, reason: collision with other inner class name */
            public class RunnableC0169a implements Runnable {
                public RunnableC0169a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b.this.f1914e0.cancelAutoFocus();
                    Camera.Parameters parameters = b.this.f1914e0.getParameters();
                    int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                    int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                    if (maxNumFocusAreas > 0) {
                        parameters.setFocusAreas(null);
                    }
                    if (maxNumMeteringAreas > 0) {
                        parameters.setMeteringAreas(null);
                    }
                    b.this.c1(parameters);
                    b.this.f1914e0.setParameters(parameters);
                }
            }

            public C0168b() {
            }

            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z2, Camera camera) {
                b.this.n.e("focus end", 0);
                b.this.n.e("focus reset", 0);
                a aVar = a.this;
                ((CameraView.b) b.this.m).d(aVar.k, z2, aVar.l);
                if (b.this.a1()) {
                    b bVar = b.this;
                    b.o.a.n.v.f fVar = bVar.n;
                    fVar.c("focus reset", true, bVar.W, new b.o.a.n.v.i(fVar, b.o.a.n.v.e.ENGINE, new RunnableC0169a()));
                }
            }
        }

        public a(b.o.a.t.b bVar, b.o.a.q.a aVar, PointF pointF) {
            this.j = bVar;
            this.k = aVar;
            this.l = pointF;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.p.o) {
                b bVar = b.this;
                b.o.a.n.s.a aVar = new b.o.a.n.s.a(bVar.L, bVar.o.l());
                b.o.a.t.b bVarC = this.j.c(aVar);
                Camera.Parameters parameters = b.this.f1914e0.getParameters();
                int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                if (maxNumFocusAreas > 0) {
                    parameters.setFocusAreas(bVarC.b(maxNumFocusAreas, aVar));
                }
                if (maxNumMeteringAreas > 0) {
                    parameters.setMeteringAreas(bVarC.b(maxNumMeteringAreas, aVar));
                }
                parameters.setFocusMode("auto");
                b.this.f1914e0.setParameters(parameters);
                ((CameraView.b) b.this.m).e(this.k, this.l);
                b.this.n.e("focus end", 0);
                b.this.n.c("focus end", true, 2500L, new RunnableC0167a());
                try {
                    b.this.f1914e0.autoFocus(new C0168b());
                } catch (RuntimeException e) {
                    b.o.a.n.i.j.a(3, "startAutoFocus:", "Error calling autoFocus", e);
                }
            }
        }
    }

    /* compiled from: Camera1Engine.java */
    /* renamed from: b.o.a.n.b$b, reason: collision with other inner class name */
    public class RunnableC0170b implements Runnable {
        public final /* synthetic */ b.o.a.m.f j;

        public RunnableC0170b(b.o.a.m.f fVar) {
            this.j = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = b.this.f1914e0.getParameters();
            if (b.this.e1(parameters, this.j)) {
                b.this.f1914e0.setParameters(parameters);
            }
        }
    }

    /* compiled from: Camera1Engine.java */
    public class c implements Runnable {
        public final /* synthetic */ Location j;

        public c(Location location) {
            this.j = location;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = b.this.f1914e0.getParameters();
            b.this.g1(parameters);
            b.this.f1914e0.setParameters(parameters);
        }
    }

    /* compiled from: Camera1Engine.java */
    public class d implements Runnable {
        public final /* synthetic */ b.o.a.m.m j;

        public d(b.o.a.m.m mVar) {
            this.j = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = b.this.f1914e0.getParameters();
            if (b.this.j1(parameters, this.j)) {
                b.this.f1914e0.setParameters(parameters);
            }
        }
    }

    /* compiled from: Camera1Engine.java */
    public class e implements Runnable {
        public final /* synthetic */ b.o.a.m.h j;

        public e(b.o.a.m.h hVar) {
            this.j = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = b.this.f1914e0.getParameters();
            if (b.this.f1(parameters, this.j)) {
                b.this.f1914e0.setParameters(parameters);
            }
        }
    }

    /* compiled from: Camera1Engine.java */
    public class f implements Runnable {
        public final /* synthetic */ float j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ PointF[] l;

        public f(float f, boolean z2, PointF[] pointFArr) {
            this.j = f;
            this.k = z2;
            this.l = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = b.this.f1914e0.getParameters();
            if (b.this.k1(parameters, this.j)) {
                b.this.f1914e0.setParameters(parameters);
                if (this.k) {
                    b bVar = b.this;
                    ((CameraView.b) bVar.m).f(bVar.D, this.l);
                }
            }
        }
    }

    /* compiled from: Camera1Engine.java */
    public class g implements Runnable {
        public final /* synthetic */ float j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ float[] l;
        public final /* synthetic */ PointF[] m;

        public g(float f, boolean z2, float[] fArr, PointF[] pointFArr) {
            this.j = f;
            this.k = z2;
            this.l = fArr;
            this.m = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = b.this.f1914e0.getParameters();
            if (b.this.d1(parameters, this.j)) {
                b.this.f1914e0.setParameters(parameters);
                if (this.k) {
                    b bVar = b.this;
                    ((CameraView.b) bVar.m).c(bVar.E, this.l, this.m);
                }
            }
        }
    }

    /* compiled from: Camera1Engine.java */
    public class h implements Runnable {
        public final /* synthetic */ boolean j;

        public h(boolean z2) {
            this.j = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.h1(this.j);
        }
    }

    /* compiled from: Camera1Engine.java */
    public class i implements Runnable {
        public final /* synthetic */ float j;

        public i(float f) {
            this.j = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = b.this.f1914e0.getParameters();
            if (b.this.i1(parameters, this.j)) {
                b.this.f1914e0.setParameters(parameters);
            }
        }
    }

    public b(@NonNull i.g gVar) {
        super(gVar);
        this.f1913d0 = b.o.a.n.q.a.a();
    }

    @Override // b.o.a.n.i
    public void F0(@NonNull b.o.a.m.m mVar) {
        b.o.a.m.m mVar2 = this.f1932x;
        this.f1932x = mVar;
        b.o.a.n.v.f fVar = this.n;
        fVar.b("white balance (" + mVar + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new d(mVar2)));
    }

    @Override // b.o.a.n.i
    public void G0(float f2, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.D;
        this.D = f2;
        this.n.e("zoom", 20);
        b.o.a.n.v.f fVar = this.n;
        fVar.b("zoom", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new f(f3, z2, pointFArr)));
    }

    @Override // b.o.a.n.i
    public void I0(@Nullable b.o.a.q.a aVar, @NonNull b.o.a.t.b bVar, @NonNull PointF pointF) {
        b.o.a.n.v.f fVar = this.n;
        fVar.b("auto focus", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.BIND, new a(bVar, aVar, pointF)));
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> P() {
        b.o.a.b bVar = b.o.a.n.i.j;
        bVar.a(1, "onStartBind:", "Started");
        try {
            if (this.o.j() == SurfaceHolder.class) {
                this.f1914e0.setPreviewDisplay((SurfaceHolder) this.o.i());
            } else {
                if (this.o.j() != SurfaceTexture.class) {
                    throw new RuntimeException("Unknown CameraPreview output class.");
                }
                this.f1914e0.setPreviewTexture((SurfaceTexture) this.o.i());
            }
            this.r = Q0(this.Q);
            this.f1931s = R0();
            bVar.a(1, "onStartBind:", "Returning");
            return b.i.a.f.e.o.f.Z(null);
        } catch (IOException e2) {
            b.o.a.n.i.j.a(3, "onStartBind:", "Failed to bind.", e2);
            throw new CameraException(e2, 2);
        }
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<b.o.a.c> Q() {
        try {
            Camera cameraOpen = Camera.open(this.f1915f0);
            this.f1914e0 = cameraOpen;
            if (cameraOpen == null) {
                b.o.a.n.i.j.a(3, "onStartEngine:", "Failed to connect. Camera is null, maybe in use by another app or already released?");
                throw new CameraException(1);
            }
            cameraOpen.setErrorCallback(this);
            b.o.a.b bVar = b.o.a.n.i.j;
            bVar.a(1, "onStartEngine:", "Applying default parameters.");
            try {
                Camera.Parameters parameters = this.f1914e0.getParameters();
                int i2 = this.f1915f0;
                b.o.a.n.t.a aVar = this.L;
                b.o.a.n.t.b bVar2 = b.o.a.n.t.b.SENSOR;
                b.o.a.n.t.b bVar3 = b.o.a.n.t.b.VIEW;
                this.p = new b.o.a.n.u.a(parameters, i2, aVar.b(bVar2, bVar3));
                b1(parameters);
                this.f1914e0.setParameters(parameters);
                try {
                    this.f1914e0.setDisplayOrientation(this.L.c(bVar2, bVar3, 1));
                    bVar.a(1, "onStartEngine:", "Ended");
                    return b.i.a.f.e.o.f.Z(this.p);
                } catch (Exception unused) {
                    b.o.a.n.i.j.a(3, "onStartEngine:", "Failed to connect. Can't set display orientation, maybe preview already exists?");
                    throw new CameraException(1);
                }
            } catch (Exception e2) {
                b.o.a.n.i.j.a(3, "onStartEngine:", "Failed to connect. Problem with camera params");
                throw new CameraException(e2, 1);
            }
        } catch (Exception e3) {
            b.o.a.n.i.j.a(3, "onStartEngine:", "Failed to connect. Maybe in use by another app?");
            throw new CameraException(e3, 1);
        }
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> R() {
        b.o.a.b bVar = b.o.a.n.i.j;
        bVar.a(1, "onStartPreview", "Dispatching onCameraPreviewStreamSizeChanged.");
        ((CameraView.b) this.m).h();
        b.o.a.x.b bVarC = C(b.o.a.n.t.b.VIEW);
        if (bVarC == null) {
            throw new IllegalStateException("previewStreamSize should not be null at this point.");
        }
        this.o.s(bVarC.j, bVarC.k);
        this.o.r(0);
        try {
            Camera.Parameters parameters = this.f1914e0.getParameters();
            parameters.setPreviewFormat(17);
            b.o.a.x.b bVar2 = this.f1931s;
            parameters.setPreviewSize(bVar2.j, bVar2.k);
            b.o.a.m.i iVar = this.Q;
            b.o.a.m.i iVar2 = b.o.a.m.i.PICTURE;
            if (iVar == iVar2) {
                b.o.a.x.b bVar3 = this.r;
                parameters.setPictureSize(bVar3.j, bVar3.k);
            } else {
                b.o.a.x.b bVarQ0 = Q0(iVar2);
                parameters.setPictureSize(bVarQ0.j, bVarQ0.k);
            }
            try {
                this.f1914e0.setParameters(parameters);
                this.f1914e0.setPreviewCallbackWithBuffer(null);
                this.f1914e0.setPreviewCallbackWithBuffer(this);
                l1().e(17, this.f1931s, this.L);
                bVar.a(1, "onStartPreview", "Starting preview with startPreview().");
                try {
                    this.f1914e0.startPreview();
                    bVar.a(1, "onStartPreview", "Started preview.");
                    return b.i.a.f.e.o.f.Z(null);
                } catch (Exception e2) {
                    b.o.a.n.i.j.a(3, "onStartPreview", "Failed to start preview.", e2);
                    throw new CameraException(e2, 2);
                }
            } catch (Exception e3) {
                b.o.a.n.i.j.a(3, "onStartPreview:", "Failed to set params for camera. Maybe incorrect parameter put in params?");
                throw new CameraException(e3, 2);
            }
        } catch (Exception e4) {
            b.o.a.n.i.j.a(3, "onStartPreview:", "Failed to get params from camera. Maybe low level problem with camera or camera has already released?");
            throw new CameraException(e4, 2);
        }
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> S() {
        this.f1931s = null;
        this.r = null;
        try {
            if (this.o.j() == SurfaceHolder.class) {
                this.f1914e0.setPreviewDisplay(null);
            } else {
                if (this.o.j() != SurfaceTexture.class) {
                    throw new RuntimeException("Unknown CameraPreview output class.");
                }
                this.f1914e0.setPreviewTexture(null);
            }
        } catch (IOException e2) {
            b.o.a.n.i.j.a(3, "onStopBind", "Could not release surface", e2);
        }
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> T() {
        b.o.a.b bVar = b.o.a.n.i.j;
        bVar.a(1, "onStopEngine:", "About to clean up.");
        this.n.e("focus reset", 0);
        this.n.e("focus end", 0);
        if (this.f1914e0 != null) {
            try {
                bVar.a(1, "onStopEngine:", "Clean up.", "Releasing camera.");
                this.f1914e0.release();
                bVar.a(1, "onStopEngine:", "Clean up.", "Released camera.");
            } catch (Exception e2) {
                b.o.a.n.i.j.a(2, "onStopEngine:", "Clean up.", "Exception while releasing camera.", e2);
            }
            this.f1914e0 = null;
            this.p = null;
        }
        this.p = null;
        this.f1914e0 = null;
        b.o.a.n.i.j.a(2, "onStopEngine:", "Clean up.", "Returning.");
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.g
    @NonNull
    public List<b.o.a.x.b> T0() {
        try {
            List<Camera.Size> supportedPreviewSizes = this.f1914e0.getParameters().getSupportedPreviewSizes();
            ArrayList arrayList = new ArrayList(supportedPreviewSizes.size());
            for (Camera.Size size : supportedPreviewSizes) {
                b.o.a.x.b bVar = new b.o.a.x.b(size.width, size.height);
                if (!arrayList.contains(bVar)) {
                    arrayList.add(bVar);
                }
            }
            b.o.a.n.i.j.a(1, "getPreviewStreamAvailableSizes:", arrayList);
            return arrayList;
        } catch (Exception e2) {
            b.o.a.n.i.j.a(3, "getPreviewStreamAvailableSizes:", "Failed to compute preview size. Camera params is empty");
            throw new CameraException(e2, 2);
        }
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> U() {
        b.o.a.b bVar = b.o.a.n.i.j;
        bVar.a(1, "onStopPreview:", "Started.");
        this.q = null;
        l1().d();
        bVar.a(1, "onStopPreview:", "Releasing preview buffers.");
        this.f1914e0.setPreviewCallbackWithBuffer(null);
        try {
            bVar.a(1, "onStopPreview:", "Stopping preview.");
            this.f1914e0.stopPreview();
            bVar.a(1, "onStopPreview:", "Stopped preview.");
        } catch (Exception e2) {
            b.o.a.n.i.j.a(3, "stopPreview", "Could not stop preview", e2);
        }
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.g
    @NonNull
    public b.o.a.p.c V0(int i2) {
        return new b.o.a.p.a(i2, this);
    }

    @Override // b.o.a.n.g
    public void X0() {
        b.o.a.n.i.j.a(1, "RESTART PREVIEW:", "scheduled. State:", this.n.f);
        N0(false);
        K0();
    }

    @Override // b.o.a.n.g
    public void Y0(@NonNull l.a aVar, boolean z2) {
        b.o.a.b bVar = b.o.a.n.i.j;
        bVar.a(1, "onTakePicture:", "executing.");
        b.o.a.n.t.a aVar2 = this.L;
        b.o.a.n.t.b bVar2 = b.o.a.n.t.b.SENSOR;
        b.o.a.n.t.b bVar3 = b.o.a.n.t.b.OUTPUT;
        aVar.c = aVar2.c(bVar2, bVar3, 2);
        aVar.d = w(bVar3);
        b.o.a.v.a aVar3 = new b.o.a.v.a(aVar, this, this.f1914e0);
        this.q = aVar3;
        aVar3.c();
        bVar.a(1, "onTakePicture:", "executed.");
    }

    @Override // b.o.a.n.g
    public void Z0(@NonNull l.a aVar, @NonNull b.o.a.x.a aVar2, boolean z2) {
        b.o.a.b bVar = b.o.a.n.i.j;
        bVar.a(1, "onTakePictureSnapshot:", "executing.");
        b.o.a.n.t.b bVar2 = b.o.a.n.t.b.OUTPUT;
        aVar.d = F(bVar2);
        if (this.o instanceof b.o.a.w.e) {
            aVar.c = this.L.c(b.o.a.n.t.b.VIEW, bVar2, 1);
            this.q = new b.o.a.v.g(aVar, this, (b.o.a.w.e) this.o, aVar2, this.f1930c0);
        } else {
            aVar.c = this.L.c(b.o.a.n.t.b.SENSOR, bVar2, 2);
            this.q = new b.o.a.v.e(aVar, this, this.f1914e0, aVar2);
        }
        this.q.c();
        bVar.a(1, "onTakePictureSnapshot:", "executed.");
    }

    public final void b1(@NonNull Camera.Parameters parameters) {
        parameters.setRecordingHint(this.Q == b.o.a.m.i.VIDEO);
        c1(parameters);
        e1(parameters, b.o.a.m.f.OFF);
        g1(parameters);
        j1(parameters, b.o.a.m.m.AUTO);
        f1(parameters, b.o.a.m.h.OFF);
        k1(parameters, 0.0f);
        d1(parameters, 0.0f);
        h1(this.F);
        i1(parameters, 0.0f);
    }

    @Override // b.o.a.n.i
    public boolean c(@NonNull b.o.a.m.e eVar) {
        Objects.requireNonNull(this.f1913d0);
        int iIntValue = b.o.a.n.q.a.d.get(eVar).intValue();
        b.o.a.n.i.j.a(1, "collectCameraInfo", "Facing:", eVar, "Internal:", Integer.valueOf(iIntValue), "Cameras:", Integer.valueOf(Camera.getNumberOfCameras()));
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == iIntValue) {
                this.L.f(eVar, cameraInfo.orientation);
                this.f1915f0 = i2;
                return true;
            }
        }
        return false;
    }

    public final void c1(@NonNull Camera.Parameters parameters) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (this.Q == b.o.a.m.i.VIDEO && supportedFocusModes.contains("continuous-video")) {
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

    @Override // b.o.a.n.i
    public void d0(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.E;
        this.E = f2;
        this.n.e("exposure correction", 20);
        b.o.a.n.v.f fVar = this.n;
        fVar.b("exposure correction", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new g(f3, z2, fArr, pointFArr)));
    }

    public final boolean d1(@NonNull Camera.Parameters parameters, float f2) {
        b.o.a.c cVar = this.p;
        if (!cVar.l) {
            this.E = f2;
            return false;
        }
        float f3 = cVar.n;
        float f4 = cVar.m;
        float f5 = this.E;
        if (f5 < f4) {
            f3 = f4;
        } else if (f5 <= f3) {
            f3 = f5;
        }
        this.E = f3;
        parameters.setExposureCompensation((int) (f3 / parameters.getExposureCompensationStep()));
        return true;
    }

    public final boolean e1(@NonNull Camera.Parameters parameters, @NonNull b.o.a.m.f fVar) {
        if (!this.p.c(this.w)) {
            this.w = fVar;
            return false;
        }
        b.o.a.n.q.a aVar = this.f1913d0;
        b.o.a.m.f fVar2 = this.w;
        Objects.requireNonNull(aVar);
        parameters.setFlashMode(b.o.a.n.q.a.f1936b.get(fVar2));
        return true;
    }

    @Override // b.o.a.n.i
    public void f0(@NonNull b.o.a.m.f fVar) {
        b.o.a.m.f fVar2 = this.w;
        this.w = fVar;
        b.o.a.n.v.f fVar3 = this.n;
        fVar3.b("flash (" + fVar + ")", true, new b.o.a.n.v.h(fVar3, b.o.a.n.v.e.ENGINE, new RunnableC0170b(fVar2)));
    }

    public final boolean f1(@NonNull Camera.Parameters parameters, @NonNull b.o.a.m.h hVar) {
        if (!this.p.c(this.A)) {
            this.A = hVar;
            return false;
        }
        b.o.a.n.q.a aVar = this.f1913d0;
        b.o.a.m.h hVar2 = this.A;
        Objects.requireNonNull(aVar);
        parameters.setSceneMode(b.o.a.n.q.a.e.get(hVar2));
        return true;
    }

    @Override // b.o.a.n.i
    public void g0(int i2) {
        this.u = 17;
    }

    public final boolean g1(@NonNull Camera.Parameters parameters) {
        Location location = this.C;
        if (location == null) {
            return true;
        }
        parameters.setGpsLatitude(location.getLatitude());
        parameters.setGpsLongitude(this.C.getLongitude());
        parameters.setGpsAltitude(this.C.getAltitude());
        parameters.setGpsTimestamp(this.C.getTime());
        parameters.setGpsProcessingMethod(this.C.getProvider());
        return true;
    }

    @TargetApi(17)
    public final boolean h1(boolean z2) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.f1915f0, cameraInfo);
        if (cameraInfo.canDisableShutterSound) {
            try {
                return this.f1914e0.enableShutterSound(this.F);
            } catch (RuntimeException unused) {
                return false;
            }
        }
        if (this.F) {
            return true;
        }
        this.F = z2;
        return false;
    }

    public final boolean i1(@NonNull Camera.Parameters parameters, float f2) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (!this.J || this.I == 0.0f) {
            Collections.sort(supportedPreviewFpsRange, new b.o.a.n.a(this));
        } else {
            Collections.sort(supportedPreviewFpsRange, new b.o.a.n.c(this));
        }
        float f3 = this.I;
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
            float fMin = Math.min(f3, this.p.q);
            this.I = fMin;
            this.I = Math.max(fMin, this.p.p);
            for (int[] iArr2 : supportedPreviewFpsRange) {
                float f6 = iArr2[0] / 1000.0f;
                float f7 = iArr2[1] / 1000.0f;
                float fRound = Math.round(this.I);
                if (f6 <= fRound && fRound <= f7) {
                    parameters.setPreviewFpsRange(iArr2[0], iArr2[1]);
                    return true;
                }
            }
        }
        this.I = f2;
        return false;
    }

    public final boolean j1(@NonNull Camera.Parameters parameters, @NonNull b.o.a.m.m mVar) {
        if (!this.p.c(this.f1932x)) {
            this.f1932x = mVar;
            return false;
        }
        b.o.a.n.q.a aVar = this.f1913d0;
        b.o.a.m.m mVar2 = this.f1932x;
        Objects.requireNonNull(aVar);
        parameters.setWhiteBalance(b.o.a.n.q.a.c.get(mVar2));
        parameters.remove("auto-whitebalance-lock");
        return true;
    }

    @Override // b.o.a.n.i
    public void k0(boolean z2) {
        this.v = z2;
    }

    public final boolean k1(@NonNull Camera.Parameters parameters, float f2) {
        if (!this.p.k) {
            this.D = f2;
            return false;
        }
        parameters.setZoom((int) (this.D * parameters.getMaxZoom()));
        this.f1914e0.setParameters(parameters);
        return true;
    }

    @Override // b.o.a.n.i
    public void l0(@NonNull b.o.a.m.h hVar) {
        b.o.a.m.h hVar2 = this.A;
        this.A = hVar;
        b.o.a.n.v.f fVar = this.n;
        fVar.b("hdr (" + hVar + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new e(hVar2)));
    }

    @NonNull
    public b.o.a.p.a l1() {
        return (b.o.a.p.a) S0();
    }

    @Override // b.o.a.n.i
    public void m0(@Nullable Location location) {
        Location location2 = this.C;
        this.C = location;
        b.o.a.n.v.f fVar = this.n;
        fVar.b(ModelAuditLogEntry.CHANGE_KEY_LOCATION, true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new c(location2)));
    }

    public void m1(@NonNull byte[] bArr) {
        b.o.a.n.v.e eVar = this.n.f;
        b.o.a.n.v.e eVar2 = b.o.a.n.v.e.ENGINE;
        if (eVar.f(eVar2) && this.n.g.f(eVar2)) {
            this.f1914e0.addCallbackBuffer(bArr);
        }
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i2, Camera camera) {
        throw new CameraException(new RuntimeException(b.o.a.n.i.j.a(3, "Internal Camera1 error.", Integer.valueOf(i2))), (i2 == 1 || i2 == 2 || i2 == 100) ? 3 : 0);
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        b.o.a.p.b bVarA;
        if (bArr == null || (bVarA = l1().a(bArr, System.currentTimeMillis())) == null) {
            return;
        }
        ((CameraView.b) this.m).b(bVarA);
    }

    @Override // b.o.a.n.i
    public void p0(@NonNull b.o.a.m.j jVar) {
        if (jVar == b.o.a.m.j.JPEG) {
            this.B = jVar;
            return;
        }
        throw new UnsupportedOperationException("Unsupported picture format: " + jVar);
    }

    @Override // b.o.a.n.i
    public void t0(boolean z2) {
        boolean z3 = this.F;
        this.F = z2;
        b.o.a.n.v.f fVar = this.n;
        fVar.b("play sounds (" + z2 + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new h(z3)));
    }

    @Override // b.o.a.n.i
    public void v0(float f2) {
        this.I = f2;
        b.o.a.n.v.f fVar = this.n;
        fVar.b("preview fps (" + f2 + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new i(f2)));
    }
}
