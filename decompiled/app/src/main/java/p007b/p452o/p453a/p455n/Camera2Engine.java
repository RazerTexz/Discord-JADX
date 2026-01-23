package p007b.p452o.p453a.p455n;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.location.Location;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.C4363g;
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
import p007b.p452o.p453a.p455n.p456o.Action2;
import p007b.p452o.p453a.p455n.p456o.ActionHolder;
import p007b.p452o.p453a.p455n.p456o.BaseAction;
import p007b.p452o.p453a.p455n.p456o.CompletionCallback;
import p007b.p452o.p453a.p455n.p456o.LogAction;
import p007b.p452o.p453a.p455n.p456o.SequenceAction;
import p007b.p452o.p453a.p455n.p456o.TimeoutAction;
import p007b.p452o.p453a.p455n.p458q.Camera2Mapper;
import p007b.p452o.p453a.p455n.p459r.BaseMeter;
import p007b.p452o.p453a.p455n.p459r.MeterAction;
import p007b.p452o.p453a.p455n.p459r.MeterResetAction;
import p007b.p452o.p453a.p455n.p461t.Angles;
import p007b.p452o.p453a.p455n.p461t.Reference2;
import p007b.p452o.p453a.p455n.p462u.Camera2Options;
import p007b.p452o.p453a.p455n.p463v.CameraState2;
import p007b.p452o.p453a.p455n.p463v.CameraStateOrchestrator;
import p007b.p452o.p453a.p455n.p463v.CameraStateOrchestrator3;
import p007b.p452o.p453a.p455n.p463v.CameraStateOrchestrator4;
import p007b.p452o.p453a.p465p.Frame2;
import p007b.p452o.p453a.p465p.FrameManager;
import p007b.p452o.p453a.p465p.ImageFrameManager;
import p007b.p452o.p453a.p466q.Gesture;
import p007b.p452o.p453a.p467r.FpsRangeValidator;
import p007b.p452o.p453a.p469t.MeteringRegions;
import p007b.p452o.p453a.p471v.Full2PictureRecorder;
import p007b.p452o.p453a.p471v.Snapshot2PictureRecorder;
import p007b.p452o.p453a.p472w.RendererCameraPreview;
import p007b.p452o.p453a.p473x.AspectRatio2;
import p007b.p452o.p453a.p473x.Size3;
import p007b.p452o.p453a.p473x.SizeSelector;
import p007b.p452o.p453a.p473x.SizeSelectors;
import p007b.p452o.p453a.p473x.SizeSelectors2;
import p007b.p452o.p453a.p473x.SizeSelectors3;
import p007b.p452o.p453a.p473x.SizeSelectors9;

/* JADX INFO: renamed from: b.o.a.n.d, reason: use source file name */
/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class Camera2Engine extends CameraBaseEngine implements ImageReader.OnImageAvailableListener, ActionHolder {

    /* JADX INFO: renamed from: d0 */
    public final CameraManager f13802d0;

    /* JADX INFO: renamed from: e0 */
    public String f13803e0;

    /* JADX INFO: renamed from: f0 */
    public CameraDevice f13804f0;

    /* JADX INFO: renamed from: g0 */
    public CameraCharacteristics f13805g0;

    /* JADX INFO: renamed from: h0 */
    public CameraCaptureSession f13806h0;

    /* JADX INFO: renamed from: i0 */
    public CaptureRequest.Builder f13807i0;

    /* JADX INFO: renamed from: j0 */
    public TotalCaptureResult f13808j0;

    /* JADX INFO: renamed from: k0 */
    public final Camera2Mapper f13809k0;

    /* JADX INFO: renamed from: l0 */
    public ImageReader f13810l0;

    /* JADX INFO: renamed from: m0 */
    public Surface f13811m0;

    /* JADX INFO: renamed from: n0 */
    public Surface f13812n0;

    /* JADX INFO: renamed from: o0 */
    public ImageReader f13813o0;

    /* JADX INFO: renamed from: p0 */
    public final List<Action2> f13814p0;

    /* JADX INFO: renamed from: q0 */
    public MeterAction f13815q0;

    /* JADX INFO: renamed from: r0 */
    public final CameraCaptureSession.CaptureCallback f13816r0;

    /* JADX INFO: renamed from: b.o.a.n.d$a */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Flash f13817j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Flash f13818k;

        public a(Flash flash, Flash flash2) {
            this.f13817j = flash;
            this.f13818k = flash2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            boolean zM7233h1 = camera2Engine.m7233h1(camera2Engine.f13807i0, this.f13817j);
            Camera2Engine camera2Engine2 = Camera2Engine.this;
            if (!(camera2Engine2.f13922n.f14028f == CameraState2.PREVIEW)) {
                if (zM7233h1) {
                    camera2Engine2.m7236k1();
                    return;
                }
                return;
            }
            camera2Engine2.f13903w = Flash.OFF;
            camera2Engine2.m7233h1(camera2Engine2.f13807i0, this.f13817j);
            try {
                Camera2Engine camera2Engine3 = Camera2Engine.this;
                camera2Engine3.f13806h0.capture(camera2Engine3.f13807i0.build(), null, null);
                Camera2Engine camera2Engine4 = Camera2Engine.this;
                camera2Engine4.f13903w = this.f13818k;
                camera2Engine4.m7233h1(camera2Engine4.f13807i0, this.f13817j);
                Camera2Engine.this.m7236k1();
            } catch (CameraAccessException e) {
                throw Camera2Engine.this.m7240o1(e);
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$b */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Location f13820j;

        public b(Location location) {
            this.f13820j = location;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            CaptureRequest.Builder builder = camera2Engine.f13807i0;
            Location location = camera2Engine.f13868C;
            if (location != null) {
                builder.set(CaptureRequest.JPEG_GPS_LOCATION, location);
            }
            Camera2Engine.this.m7236k1();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$c */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class c implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ WhiteBalance f13822j;

        public c(WhiteBalance whiteBalance) {
            this.f13822j = whiteBalance;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.m7238m1(camera2Engine.f13807i0, this.f13822j)) {
                Camera2Engine.this.m7236k1();
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$d */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class d implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Hdr f13824j;

        public d(Hdr hdr) {
            this.f13824j = hdr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.m7234i1(camera2Engine.f13807i0, this.f13824j)) {
                Camera2Engine.this.m7236k1();
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$e */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class e implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ float f13826j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ boolean f13827k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ float f13828l;

        /* JADX INFO: renamed from: m */
        public final /* synthetic */ PointF[] f13829m;

        public e(float f, boolean z2, float f2, PointF[] pointFArr) {
            this.f13826j = f;
            this.f13827k = z2;
            this.f13828l = f2;
            this.f13829m = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.m7239n1(camera2Engine.f13807i0, this.f13826j)) {
                Camera2Engine.this.m7236k1();
                if (this.f13827k) {
                    ((CameraView.C11195b) Camera2Engine.this.f13921m).m9316f(this.f13828l, this.f13829m);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$f */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class f implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ float f13831j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ boolean f13832k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ float f13833l;

        /* JADX INFO: renamed from: m */
        public final /* synthetic */ float[] f13834m;

        /* JADX INFO: renamed from: n */
        public final /* synthetic */ PointF[] f13835n;

        public f(float f, boolean z2, float f2, float[] fArr, PointF[] pointFArr) {
            this.f13831j = f;
            this.f13832k = z2;
            this.f13833l = f2;
            this.f13834m = fArr;
            this.f13835n = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.m7232g1(camera2Engine.f13807i0, this.f13831j)) {
                Camera2Engine.this.m7236k1();
                if (this.f13832k) {
                    ((CameraView.C11195b) Camera2Engine.this.f13921m).m9313c(this.f13833l, this.f13834m, this.f13835n);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$g */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class g implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ float f13837j;

        public g(float f) {
            this.f13837j = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.m7235j1(camera2Engine.f13807i0, this.f13837j)) {
                Camera2Engine.this.m7236k1();
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$h */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine.this.m7327X();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$i */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class i extends CameraCaptureSession.CaptureCallback {
        public i() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            Camera2Engine camera2Engine = Camera2Engine.this;
            camera2Engine.f13808j0 = totalCaptureResult;
            Iterator<Action2> it = camera2Engine.f13814p0.iterator();
            while (it.hasNext()) {
                it.next().mo7248b(Camera2Engine.this, captureRequest, totalCaptureResult);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
            Iterator<Action2> it = Camera2Engine.this.f13814p0.iterator();
            while (it.hasNext()) {
                it.next().mo7332d(Camera2Engine.this, captureRequest, captureResult);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j, long j2) {
            Iterator<Action2> it = Camera2Engine.this.f13814p0.iterator();
            while (it.hasNext()) {
                it.next().mo7331c(Camera2Engine.this, captureRequest);
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$j */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class j implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ boolean f13841j;

        public j(boolean z2) {
            this.f13841j = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraState2 cameraState2 = Camera2Engine.this.f13922n.f14028f;
            CameraState2 cameraState22 = CameraState2.BIND;
            if (cameraState2.m7367f(cameraState22) && Camera2Engine.this.m7324O()) {
                Camera2Engine.this.mo7217k0(this.f13841j);
                return;
            }
            Camera2Engine camera2Engine = Camera2Engine.this;
            camera2Engine.f13902v = this.f13841j;
            if (camera2Engine.f13922n.f14028f.m7367f(cameraState22)) {
                Camera2Engine.this.m7328Y();
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$k */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class k implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f13843j;

        public k(int i) {
            this.f13843j = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraState2 cameraState2 = Camera2Engine.this.f13922n.f14028f;
            CameraState2 cameraState22 = CameraState2.BIND;
            if (cameraState2.m7367f(cameraState22) && Camera2Engine.this.m7324O()) {
                Camera2Engine.this.mo7212g0(this.f13843j);
                return;
            }
            Camera2Engine camera2Engine = Camera2Engine.this;
            int i = this.f13843j;
            if (i <= 0) {
                i = 35;
            }
            camera2Engine.f13901u = i;
            if (camera2Engine.f13922n.f14028f.m7367f(cameraState22)) {
                Camera2Engine.this.m7328Y();
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$l */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class l implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Gesture f13845j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ PointF f13846k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ MeteringRegions f13847l;

        /* JADX INFO: renamed from: b.o.a.n.d$l$a */
        /* JADX INFO: compiled from: Camera2Engine.java */
        public class a extends CompletionCallback {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ MeterAction f13849a;

            /* JADX INFO: renamed from: b.o.a.n.d$l$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Camera2Engine.java */
            public class RunnableC13244a implements Runnable {
                public RunnableC13244a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Camera2Engine.m7226b1(Camera2Engine.this);
                }
            }

            public a(MeterAction meterAction) {
                this.f13849a = meterAction;
            }

            @Override // p007b.p452o.p453a.p455n.p456o.CompletionCallback
            /* JADX INFO: renamed from: b */
            public void mo7247b(@NonNull Action2 action2) {
                boolean z2;
                l lVar = l.this;
                CameraEngine.g gVar = Camera2Engine.this.f13921m;
                Gesture gesture = lVar.f13845j;
                Iterator<BaseMeter> it = this.f13849a.f13977f.iterator();
                while (true) {
                    z2 = true;
                    if (!it.hasNext()) {
                        MeterAction.f13976e.m7159a(1, "isSuccessful:", "returning true.");
                        break;
                    } else if (!it.next().f13967g) {
                        MeterAction.f13976e.m7159a(1, "isSuccessful:", "returning false.");
                        z2 = false;
                        break;
                    }
                }
                ((CameraView.C11195b) gVar).m9314d(gesture, z2, l.this.f13846k);
                Camera2Engine.this.f13922n.m7366e("reset metering", 0);
                if (Camera2Engine.this.m7278a1()) {
                    Camera2Engine camera2Engine = Camera2Engine.this;
                    CameraStateOrchestrator cameraStateOrchestrator = camera2Engine.f13922n;
                    cameraStateOrchestrator.m7364c("reset metering", true, camera2Engine.f13888W, new CameraStateOrchestrator4(cameraStateOrchestrator, CameraState2.PREVIEW, new RunnableC13244a()));
                }
            }
        }

        public l(Gesture gesture, PointF pointF, MeteringRegions meteringRegions) {
            this.f13845j = gesture;
            this.f13846k = pointF;
            this.f13847l = meteringRegions;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.f13896p.f13696o) {
                ((CameraView.C11195b) camera2Engine.f13921m).m9315e(this.f13845j, this.f13846k);
                MeterAction meterActionM7241p1 = Camera2Engine.this.m7241p1(this.f13847l);
                TimeoutAction timeoutAction = new TimeoutAction(5000L, meterActionM7241p1);
                timeoutAction.mo7333e(Camera2Engine.this);
                timeoutAction.m7337f(new a(meterActionM7241p1));
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$m */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class m extends CameraDevice.StateCallback {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ TaskCompletionSource f13852a;

        public m(TaskCompletionSource taskCompletionSource) {
            this.f13852a = taskCompletionSource;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            CameraException cameraException = new CameraException(3);
            if (this.f13852a.f20845a.mo6020o()) {
                CameraEngine.f13918j.m7159a(1, "CameraDevice.StateCallback reported disconnection.");
                throw cameraException;
            }
            this.f13852a.m9125a(cameraException);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i) {
            int i2 = 1;
            if (this.f13852a.f20845a.mo6020o()) {
                CameraEngine.f13918j.m7159a(3, "CameraDevice.StateCallback reported an error:", Integer.valueOf(i));
                throw new CameraException(3);
            }
            TaskCompletionSource taskCompletionSource = this.f13852a;
            Objects.requireNonNull(Camera2Engine.this);
            if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
                i2 = 0;
            }
            taskCompletionSource.m9125a(new CameraException(i2));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            int i;
            Camera2Engine.this.f13804f0 = cameraDevice;
            try {
                CameraEngine.f13918j.m7159a(1, "onStartEngine:", "Opened camera device.");
                Camera2Engine camera2Engine = Camera2Engine.this;
                camera2Engine.f13805g0 = camera2Engine.f13802d0.getCameraCharacteristics(camera2Engine.f13803e0);
                boolean zM7357b = Camera2Engine.this.f13877L.m7357b(Reference2.SENSOR, Reference2.VIEW);
                int iOrdinal = Camera2Engine.this.f13867B.ordinal();
                if (iOrdinal == 0) {
                    i = 256;
                } else {
                    if (iOrdinal != 1) {
                        throw new IllegalArgumentException("Unknown format:" + Camera2Engine.this.f13867B);
                    }
                    i = 32;
                }
                Camera2Engine camera2Engine2 = Camera2Engine.this;
                camera2Engine2.f13896p = new Camera2Options(camera2Engine2.f13802d0, camera2Engine2.f13803e0, zM7357b, i);
                Camera2Engine camera2Engine3 = Camera2Engine.this;
                Objects.requireNonNull(camera2Engine3);
                camera2Engine3.m7242q1(1);
                this.f13852a.m9126b(Camera2Engine.this.f13896p);
            } catch (CameraAccessException e) {
                this.f13852a.m9125a(Camera2Engine.this.m7240o1(e));
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$n */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class n implements Callable<Void> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Object f13854j;

        public n(Object obj) {
            this.f13854j = obj;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            SurfaceHolder surfaceHolder = (SurfaceHolder) this.f13854j;
            Size3 size3 = Camera2Engine.this.f13899s;
            surfaceHolder.setFixedSize(size3.f14251j, size3.f14252k);
            return null;
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$o */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class o extends CameraCaptureSession.StateCallback {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ TaskCompletionSource f13856a;

        public o(TaskCompletionSource taskCompletionSource) {
            this.f13856a = taskCompletionSource;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            RuntimeException runtimeException = new RuntimeException(CameraEngine.f13918j.m7159a(3, "onConfigureFailed! Session", cameraCaptureSession));
            if (this.f13856a.f20845a.mo6020o()) {
                throw new CameraException(3);
            }
            this.f13856a.m9125a(new CameraException(runtimeException, 2));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            Camera2Engine.this.f13806h0 = cameraCaptureSession;
            CameraEngine.f13918j.m7159a(1, "onStartBind:", "Completed");
            this.f13856a.m9126b(null);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
            super.onReady(cameraCaptureSession);
            CameraEngine.f13918j.m7159a(1, "CameraCaptureSession.StateCallback reported onReady.");
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$p */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class p extends BaseAction {

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ TaskCompletionSource f13858e;

        public p(Camera2Engine camera2Engine, TaskCompletionSource taskCompletionSource) {
            this.f13858e = taskCompletionSource;
        }

        @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
        /* JADX INFO: renamed from: b */
        public void mo7248b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            m7341l(Integer.MAX_VALUE);
            this.f13858e.m9126b(null);
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$q */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class q extends CompletionCallback {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ PictureResult.a f13859a;

        public q(PictureResult.a aVar) {
            this.f13859a = aVar;
        }

        @Override // p007b.p452o.p453a.p455n.p456o.CompletionCallback
        /* JADX INFO: renamed from: b */
        public void mo7247b(@NonNull Action2 action2) {
            Camera2Engine camera2Engine = Camera2Engine.this;
            camera2Engine.f13873H = false;
            camera2Engine.mo7270P0(this.f13859a);
            Camera2Engine.this.f13873H = true;
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$r */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class r extends CompletionCallback {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ PictureResult.a f13861a;

        public r(PictureResult.a aVar) {
            this.f13861a = aVar;
        }

        @Override // p007b.p452o.p453a.p455n.p456o.CompletionCallback
        /* JADX INFO: renamed from: b */
        public void mo7247b(@NonNull Action2 action2) {
            Camera2Engine camera2Engine = Camera2Engine.this;
            camera2Engine.f13872G = false;
            camera2Engine.mo7269O0(this.f13861a);
            Camera2Engine.this.f13872G = true;
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$s */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class s implements Runnable {
        public s() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine.m7226b1(Camera2Engine.this);
        }
    }

    public Camera2Engine(CameraEngine.g gVar) {
        super(gVar);
        if (Camera2Mapper.f13961a == null) {
            Camera2Mapper.f13961a = new Camera2Mapper();
        }
        this.f13809k0 = Camera2Mapper.f13961a;
        this.f13814p0 = new CopyOnWriteArrayList();
        this.f13816r0 = new i();
        this.f13802d0 = (CameraManager) ((CameraView.C11195b) this.f13921m).m9317g().getSystemService(ChatInputComponentTypes.CAMERA);
        new LogAction().mo7333e(this);
    }

    /* JADX INFO: renamed from: b1 */
    public static void m7226b1(Camera2Engine camera2Engine) {
        Objects.requireNonNull(camera2Engine);
        new SequenceAction(Arrays.asList(new Camera2Engine3(camera2Engine), new MeterResetAction())).mo7333e(camera2Engine);
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: F0 */
    public void mo7190F0(@NonNull WhiteBalance whiteBalance) {
        WhiteBalance whiteBalance2 = this.f13904x;
        this.f13904x = whiteBalance;
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b("white balance (" + whiteBalance + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new c(whiteBalance2)));
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: G0 */
    public void mo7191G0(float f2, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.f13869D;
        this.f13869D = f2;
        this.f13922n.m7366e("zoom", 20);
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b("zoom", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new e(f3, z2, f2, pointFArr)));
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: I0 */
    public void mo7192I0(@Nullable Gesture gesture, @NonNull MeteringRegions meteringRegions, @NonNull PointF pointF) {
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b("autofocus (" + gesture + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.PREVIEW, new l(gesture, pointF, meteringRegions)));
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: P */
    public Task<Void> mo7193P() {
        Handler handler;
        int i2;
        CameraLogger cameraLogger = CameraEngine.f13918j;
        cameraLogger.m7159a(1, "onStartBind:", "Started");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f13898r = m7271Q0(this.f13882Q);
        this.f13899s = m7272R0();
        ArrayList arrayList = new ArrayList();
        Class clsMo7430j = this.f13895o.mo7430j();
        Object objMo7429i = this.f13895o.mo7429i();
        if (clsMo7430j == SurfaceHolder.class) {
            try {
                cameraLogger.m7159a(1, "onStartBind:", "Waiting on UI thread...");
                C3404f.m4303j(C3404f.m4323o(C4363g.f11479a, new n(objMo7429i)));
                this.f13812n0 = ((SurfaceHolder) objMo7429i).getSurface();
            } catch (InterruptedException | ExecutionException e2) {
                throw new CameraException(e2, 1);
            }
        } else {
            if (clsMo7430j != SurfaceTexture.class) {
                throw new RuntimeException("Unknown CameraPreview output class.");
            }
            SurfaceTexture surfaceTexture = (SurfaceTexture) objMo7429i;
            Size3 size3 = this.f13899s;
            surfaceTexture.setDefaultBufferSize(size3.f14251j, size3.f14252k);
            this.f13812n0 = new Surface(surfaceTexture);
        }
        arrayList.add(this.f13812n0);
        if (this.f13882Q == Mode3.PICTURE) {
            int iOrdinal = this.f13867B.ordinal();
            if (iOrdinal == 0) {
                i2 = 256;
            } else {
                if (iOrdinal != 1) {
                    StringBuilder sbM833U = outline.m833U("Unknown format:");
                    sbM833U.append(this.f13867B);
                    throw new IllegalArgumentException(sbM833U.toString());
                }
                i2 = 32;
            }
            Size3 size32 = this.f13898r;
            ImageReader imageReaderNewInstance = ImageReader.newInstance(size32.f14251j, size32.f14252k, i2, 2);
            this.f13813o0 = imageReaderNewInstance;
            arrayList.add(imageReaderNewInstance.getSurface());
        }
        if (this.f13902v) {
            List<Size3> listM7244s1 = m7244s1();
            boolean zM7357b = this.f13877L.m7357b(Reference2.SENSOR, Reference2.VIEW);
            ArrayList<Size3> arrayList2 = (ArrayList) listM7244s1;
            ArrayList arrayList3 = new ArrayList(arrayList2.size());
            for (Size3 size3M7451f : arrayList2) {
                if (zM7357b) {
                    size3M7451f = size3M7451f.m7451f();
                }
                arrayList3.add(size3M7451f);
            }
            Size3 size33 = this.f13899s;
            AspectRatio2 aspectRatio2M7447f = AspectRatio2.m7447f(size33.f14251j, size33.f14252k);
            if (zM7357b) {
                aspectRatio2M7447f = AspectRatio2.m7447f(aspectRatio2M7447f.f14250l, aspectRatio2M7447f.f14249k);
            }
            int i3 = this.f13891Z;
            int i4 = this.f13892a0;
            if (i3 <= 0 || i3 == Integer.MAX_VALUE) {
                i3 = 640;
            }
            if (i4 <= 0 || i4 == Integer.MAX_VALUE) {
                i4 = 640;
            }
            Size3 size34 = new Size3(i3, i4);
            CameraLogger cameraLogger2 = CameraEngine.f13918j;
            cameraLogger2.m7159a(1, "computeFrameProcessingSize:", "targetRatio:", aspectRatio2M7447f, "targetMaxSize:", size34);
            SizeSelector sizeSelectorM4200D1 = C3404f.m4200D1(new SizeSelectors(aspectRatio2M7447f.m7450i(), 0.0f));
            SizeSelector sizeSelectorM4291g = C3404f.m4291g(C3404f.m4220K0(i4), C3404f.m4223L0(i3), new SizeSelectors2());
            Size3 size3M7451f2 = ((SizeSelectors9) C3404f.m4238Q0(C3404f.m4291g(sizeSelectorM4200D1, sizeSelectorM4291g), sizeSelectorM4291g, new SizeSelectors3())).mo7452a(arrayList3).get(0);
            if (!arrayList3.contains(size3M7451f2)) {
                throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
            }
            if (zM7357b) {
                size3M7451f2 = size3M7451f2.m7451f();
            }
            cameraLogger2.m7159a(1, "computeFrameProcessingSize:", "result:", size3M7451f2, "flip:", Boolean.valueOf(zM7357b));
            this.f13900t = size3M7451f2;
            ImageReader imageReaderNewInstance2 = ImageReader.newInstance(size3M7451f2.f14251j, size3M7451f2.f14252k, this.f13901u, this.f13893b0 + 1);
            this.f13810l0 = imageReaderNewInstance2;
            handler = null;
            imageReaderNewInstance2.setOnImageAvailableListener(this, null);
            Surface surface = this.f13810l0.getSurface();
            this.f13811m0 = surface;
            arrayList.add(surface);
        } else {
            handler = null;
            this.f13810l0 = null;
            this.f13900t = null;
            this.f13811m0 = null;
        }
        try {
            this.f13804f0.createCaptureSession(arrayList, new o(taskCompletionSource), handler);
            return taskCompletionSource.f20845a;
        } catch (CameraAccessException e3) {
            throw m7240o1(e3);
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    @SuppressLint({"MissingPermission"})
    /* JADX INFO: renamed from: Q */
    public Task<CameraOptions> mo7194Q() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            this.f13802d0.openCamera(this.f13803e0, new m(taskCompletionSource), (Handler) null);
            return taskCompletionSource.f20845a;
        } catch (CameraAccessException e2) {
            throw m7240o1(e2);
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: R */
    public Task<Void> mo7195R() {
        CameraLogger cameraLogger = CameraEngine.f13918j;
        cameraLogger.m7159a(1, "onStartPreview:", "Dispatching onCameraPreviewStreamSizeChanged.");
        ((CameraView.C11195b) this.f13921m).m9318h();
        Reference2 reference2 = Reference2.VIEW;
        Size3 size3Mo7254C = mo7254C(reference2);
        if (size3Mo7254C == null) {
            throw new IllegalStateException("previewStreamSize should not be null at this point.");
        }
        this.f13895o.m7439s(size3Mo7254C.f14251j, size3Mo7254C.f14252k);
        this.f13895o.mo7438r(this.f13877L.m7358c(Reference2.BASE, reference2, 1));
        if (this.f13902v) {
            m7273S0().mo7382e(this.f13901u, this.f13900t, this.f13877L);
        }
        cameraLogger.m7159a(1, "onStartPreview:", "Starting preview.");
        m7228c1(new Surface[0]);
        m7237l1(false, 2);
        cameraLogger.m7159a(1, "onStartPreview:", "Started preview.");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        new p(this, taskCompletionSource).mo7333e(this);
        return taskCompletionSource.f20845a;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: S */
    public Task<Void> mo7196S() {
        CameraLogger cameraLogger = CameraEngine.f13918j;
        cameraLogger.m7159a(1, "onStopBind:", "About to clean up.");
        this.f13811m0 = null;
        this.f13812n0 = null;
        this.f13899s = null;
        this.f13898r = null;
        this.f13900t = null;
        ImageReader imageReader = this.f13810l0;
        if (imageReader != null) {
            imageReader.close();
            this.f13810l0 = null;
        }
        ImageReader imageReader2 = this.f13813o0;
        if (imageReader2 != null) {
            imageReader2.close();
            this.f13813o0 = null;
        }
        this.f13806h0.close();
        this.f13806h0 = null;
        cameraLogger.m7159a(1, "onStopBind:", "Returning.");
        return C3404f.m4264Z(null);
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: T */
    public Task<Void> mo7197T() {
        try {
            CameraLogger cameraLogger = CameraEngine.f13918j;
            cameraLogger.m7159a(1, "onStopEngine:", "Clean up.", "Releasing camera.");
            this.f13804f0.close();
            cameraLogger.m7159a(1, "onStopEngine:", "Clean up.", "Released camera.");
        } catch (Exception e2) {
            CameraEngine.f13918j.m7159a(2, "onStopEngine:", "Clean up.", "Exception while releasing camera.", e2);
        }
        this.f13804f0 = null;
        CameraEngine.f13918j.m7159a(1, "onStopEngine:", "Aborting actions.");
        Iterator<Action2> it = this.f13814p0.iterator();
        while (it.hasNext()) {
            it.next().mo7330a(this);
        }
        this.f13805g0 = null;
        this.f13896p = null;
        this.f13807i0 = null;
        CameraEngine.f13918j.m7159a(2, "onStopEngine:", "Returning.");
        return C3404f.m4264Z(null);
    }

    @Override // p007b.p452o.p453a.p455n.CameraBaseEngine
    @NonNull
    /* JADX INFO: renamed from: T0 */
    public List<Size3> mo7198T0() {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f13802d0.getCameraCharacteristics(this.f13803e0).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
            }
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.f13895o.mo7430j());
            ArrayList arrayList = new ArrayList(outputSizes.length);
            for (Size size : outputSizes) {
                Size3 size3 = new Size3(size.getWidth(), size.getHeight());
                if (!arrayList.contains(size3)) {
                    arrayList.add(size3);
                }
            }
            return arrayList;
        } catch (CameraAccessException e2) {
            throw m7240o1(e2);
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: U */
    public Task<Void> mo7199U() {
        CameraLogger cameraLogger = CameraEngine.f13918j;
        cameraLogger.m7159a(1, "onStopPreview:", "Started.");
        this.f13897q = null;
        if (this.f13902v) {
            m7273S0().mo7381d();
        }
        this.f13807i0.removeTarget(this.f13812n0);
        Surface surface = this.f13811m0;
        if (surface != null) {
            this.f13807i0.removeTarget(surface);
        }
        this.f13808j0 = null;
        cameraLogger.m7159a(1, "onStopPreview:", "Returning.");
        return C3404f.m4264Z(null);
    }

    @Override // p007b.p452o.p453a.p455n.CameraBaseEngine
    @NonNull
    /* JADX INFO: renamed from: V0 */
    public FrameManager mo7200V0(int i2) {
        return new ImageFrameManager(i2);
    }

    @Override // p007b.p452o.p453a.p455n.CameraBaseEngine
    /* JADX INFO: renamed from: X0 */
    public void mo7201X0() {
        CameraEngine.f13918j.m7159a(1, "onPreviewStreamSizeChanged:", "Calling restartBind().");
        m7328Y();
    }

    @Override // p007b.p452o.p453a.p455n.CameraBaseEngine
    /* JADX INFO: renamed from: Y0 */
    public void mo7202Y0(@NonNull PictureResult.a aVar, boolean z2) {
        if (z2) {
            CameraEngine.f13918j.m7159a(1, "onTakePicture:", "doMetering is true. Delaying.");
            TimeoutAction timeoutAction = new TimeoutAction(2500L, m7241p1(null));
            timeoutAction.m7337f(new r(aVar));
            timeoutAction.mo7333e(this);
            return;
        }
        CameraEngine.f13918j.m7159a(1, "onTakePicture:", "doMetering is false. Performing.");
        Angles angles = this.f13877L;
        Reference2 reference2 = Reference2.SENSOR;
        Reference2 reference22 = Reference2.OUTPUT;
        aVar.f13717c = angles.m7358c(reference2, reference22, 2);
        aVar.f13718d = mo7309w(reference22);
        try {
            CaptureRequest.Builder builderCreateCaptureRequest = this.f13804f0.createCaptureRequest(2);
            m7229d1(builderCreateCaptureRequest, this.f13807i0);
            Full2PictureRecorder full2PictureRecorder = new Full2PictureRecorder(aVar, this, builderCreateCaptureRequest, this.f13813o0);
            this.f13897q = full2PictureRecorder;
            full2PictureRecorder.mo7417c();
        } catch (CameraAccessException e2) {
            throw m7240o1(e2);
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraBaseEngine
    /* JADX INFO: renamed from: Z0 */
    public void mo7203Z0(@NonNull PictureResult.a aVar, @NonNull AspectRatio2 aspectRatio2, boolean z2) {
        if (z2) {
            CameraEngine.f13918j.m7159a(1, "onTakePictureSnapshot:", "doMetering is true. Delaying.");
            TimeoutAction timeoutAction = new TimeoutAction(2500L, m7241p1(null));
            timeoutAction.m7337f(new q(aVar));
            timeoutAction.mo7333e(this);
            return;
        }
        CameraEngine.f13918j.m7159a(1, "onTakePictureSnapshot:", "doMetering is false. Performing.");
        if (!(this.f13895o instanceof RendererCameraPreview)) {
            throw new RuntimeException("takePictureSnapshot with Camera2 is only supported with Preview.GL_SURFACE");
        }
        Reference2 reference2 = Reference2.OUTPUT;
        aVar.f13718d = mo7260F(reference2);
        aVar.f13717c = this.f13877L.m7358c(Reference2.VIEW, reference2, 1);
        Snapshot2PictureRecorder snapshot2PictureRecorder = new Snapshot2PictureRecorder(aVar, this, (RendererCameraPreview) this.f13895o, aspectRatio2);
        this.f13897q = snapshot2PictureRecorder;
        snapshot2PictureRecorder.mo7417c();
    }

    @Override // p007b.p452o.p453a.p455n.CameraBaseEngine, p007b.p452o.p453a.p471v.PictureRecorder.a
    /* JADX INFO: renamed from: a */
    public void mo7227a(@Nullable PictureResult.a aVar, @Nullable Exception exc) {
        boolean z2 = this.f13897q instanceof Full2PictureRecorder;
        super.mo7227a(aVar, exc);
        if ((z2 && this.f13872G) || (!z2 && this.f13873H)) {
            CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
            cameraStateOrchestrator.m7363b("reset metering after picture", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.PREVIEW, new s()));
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: c */
    public final boolean mo7205c(@NonNull Facing facing) {
        Objects.requireNonNull(this.f13809k0);
        int iIntValue = Camera2Mapper.f13962b.get(facing).intValue();
        try {
            String[] cameraIdList = this.f13802d0.getCameraIdList();
            CameraEngine.f13918j.m7159a(1, "collectCameraInfo", "Facing:", facing, "Internal:", Integer.valueOf(iIntValue), "Cameras:", Integer.valueOf(cameraIdList.length));
            for (String str : cameraIdList) {
                try {
                    CameraCharacteristics cameraCharacteristics = this.f13802d0.getCameraCharacteristics(str);
                    if (iIntValue == ((Integer) m7246u1(cameraCharacteristics, CameraCharacteristics.LENS_FACING, -99)).intValue()) {
                        this.f13803e0 = str;
                        this.f13877L.m7361f(facing, ((Integer) m7246u1(cameraCharacteristics, CameraCharacteristics.SENSOR_ORIENTATION, 0)).intValue());
                        return true;
                    }
                    continue;
                } catch (CameraAccessException unused) {
                }
            }
            return false;
        } catch (CameraAccessException e2) {
            throw m7240o1(e2);
        }
    }

    /* JADX INFO: renamed from: c1 */
    public final void m7228c1(@NonNull Surface... surfaceArr) {
        this.f13807i0.addTarget(this.f13812n0);
        Surface surface = this.f13811m0;
        if (surface != null) {
            this.f13807i0.addTarget(surface);
        }
        for (Surface surface2 : surfaceArr) {
            if (surface2 == null) {
                throw new IllegalArgumentException("Should not add a null surface.");
            }
            this.f13807i0.addTarget(surface2);
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: d0 */
    public void mo7207d0(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.f13870E;
        this.f13870E = f2;
        this.f13922n.m7366e("exposure correction", 20);
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b("exposure correction", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new f(f3, z2, f2, fArr, pointFArr)));
    }

    /* JADX INFO: renamed from: d1 */
    public final void m7229d1(@NonNull CaptureRequest.Builder builder, @Nullable CaptureRequest.Builder builder2) {
        CameraEngine.f13918j.m7159a(1, "applyAllParameters:", "called for tag", builder.build().getTag());
        builder.set(CaptureRequest.CONTROL_MODE, 1);
        m7231f1(builder);
        m7233h1(builder, Flash.OFF);
        Location location = this.f13868C;
        if (location != null) {
            builder.set(CaptureRequest.JPEG_GPS_LOCATION, location);
        }
        m7238m1(builder, WhiteBalance.AUTO);
        m7234i1(builder, Hdr.OFF);
        m7239n1(builder, 0.0f);
        m7232g1(builder, 0.0f);
        m7235j1(builder, 0.0f);
        if (builder2 != null) {
            CaptureRequest.Key key = CaptureRequest.CONTROL_AF_REGIONS;
            builder.set(key, (MeteringRectangle[]) builder2.get(key));
            CaptureRequest.Key key2 = CaptureRequest.CONTROL_AE_REGIONS;
            builder.set(key2, (MeteringRectangle[]) builder2.get(key2));
            CaptureRequest.Key key3 = CaptureRequest.CONTROL_AWB_REGIONS;
            builder.set(key3, (MeteringRectangle[]) builder2.get(key3));
            CaptureRequest.Key key4 = CaptureRequest.CONTROL_AF_MODE;
            builder.set(key4, (Integer) builder2.get(key4));
        }
    }

    /* JADX INFO: renamed from: e1 */
    public void m7230e1(@NonNull Action2 action2, @NonNull CaptureRequest.Builder builder) throws CameraAccessException {
        if (this.f13922n.f14028f != CameraState2.PREVIEW || m7324O()) {
            return;
        }
        this.f13806h0.capture(builder.build(), this.f13816r0, null);
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: f0 */
    public void mo7210f0(@NonNull Flash flash) {
        Flash flash2 = this.f13903w;
        this.f13903w = flash;
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b("flash (" + flash + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new a(flash2, flash)));
    }

    /* JADX INFO: renamed from: f1 */
    public void m7231f1(@NonNull CaptureRequest.Builder builder) {
        int[] iArr = (int[]) m7245t1(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        if (this.f13882Q == Mode3.VIDEO && arrayList.contains(3)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
            return;
        }
        if (arrayList.contains(4)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
            return;
        }
        if (arrayList.contains(1)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (arrayList.contains(0)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 0);
            builder.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(0.0f));
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: g0 */
    public void mo7212g0(int i2) {
        if (this.f13901u == 0) {
            this.f13901u = 35;
        }
        this.f13922n.m7363b(outline.m873r("frame processing format (", i2, ")"), true, new k(i2));
    }

    /* JADX INFO: renamed from: g1 */
    public boolean m7232g1(@NonNull CaptureRequest.Builder builder, float f2) {
        if (!this.f13896p.f13693l) {
            this.f13870E = f2;
            return false;
        }
        Rational rational = (Rational) m7245t1(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP, new Rational(1, 1));
        builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(Math.round(rational.floatValue() * this.f13870E)));
        return true;
    }

    /* JADX INFO: renamed from: h1 */
    public boolean m7233h1(@NonNull CaptureRequest.Builder builder, @NonNull Flash flash) {
        if (this.f13896p.m7163c(this.f13903w)) {
            int[] iArr = (int[]) m7245t1(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES, new int[0]);
            ArrayList arrayList = new ArrayList();
            for (int i2 : iArr) {
                arrayList.add(Integer.valueOf(i2));
            }
            Camera2Mapper camera2Mapper = this.f13809k0;
            Flash flash2 = this.f13903w;
            Objects.requireNonNull(camera2Mapper);
            ArrayList<Pair> arrayList2 = new ArrayList();
            int iOrdinal = flash2.ordinal();
            if (iOrdinal == 0) {
                arrayList2.add(new Pair(1, 0));
                arrayList2.add(new Pair(0, 0));
            } else if (iOrdinal == 1) {
                arrayList2.add(new Pair(3, 0));
            } else if (iOrdinal == 2) {
                arrayList2.add(new Pair(2, 0));
                arrayList2.add(new Pair(4, 0));
            } else if (iOrdinal == 3) {
                arrayList2.add(new Pair(1, 2));
                arrayList2.add(new Pair(0, 2));
            }
            for (Pair pair : arrayList2) {
                if (arrayList.contains(pair.first)) {
                    CameraLogger cameraLogger = CameraEngine.f13918j;
                    cameraLogger.m7159a(1, "applyFlash: setting CONTROL_AE_MODE to", pair.first);
                    cameraLogger.m7159a(1, "applyFlash: setting FLASH_MODE to", pair.second);
                    builder.set(CaptureRequest.CONTROL_AE_MODE, (Integer) pair.first);
                    builder.set(CaptureRequest.FLASH_MODE, (Integer) pair.second);
                    return true;
                }
            }
        }
        this.f13903w = flash;
        return false;
    }

    /* JADX INFO: renamed from: i1 */
    public boolean m7234i1(@NonNull CaptureRequest.Builder builder, @NonNull Hdr hdr) {
        if (!this.f13896p.m7163c(this.f13866A)) {
            this.f13866A = hdr;
            return false;
        }
        Camera2Mapper camera2Mapper = this.f13809k0;
        Hdr hdr2 = this.f13866A;
        Objects.requireNonNull(camera2Mapper);
        builder.set(CaptureRequest.CONTROL_SCENE_MODE, Integer.valueOf(Camera2Mapper.f13964d.get(hdr2).intValue()));
        return true;
    }

    /* JADX INFO: renamed from: j1 */
    public boolean m7235j1(@NonNull CaptureRequest.Builder builder, float f2) {
        Range<Integer>[] rangeArr = (Range[]) m7245t1(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES, new Range[0]);
        Arrays.sort(rangeArr, new Camera2Engine2(this, this.f13875J && this.f13874I != 0.0f));
        float f3 = this.f13874I;
        if (f3 == 0.0f) {
            for (Range range : (ArrayList) m7243r1(rangeArr)) {
                if (range.contains(30) || range.contains(24)) {
                    builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
                    return true;
                }
            }
        } else {
            float fMin = Math.min(f3, this.f13896p.f13698q);
            this.f13874I = fMin;
            this.f13874I = Math.max(fMin, this.f13896p.f13697p);
            for (Range range2 : (ArrayList) m7243r1(rangeArr)) {
                if (range2.contains(Integer.valueOf(Math.round(this.f13874I)))) {
                    builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range2);
                    return true;
                }
            }
        }
        this.f13874I = f2;
        return false;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: k0 */
    public void mo7217k0(boolean z2) {
        this.f13922n.m7363b("has frame processors (" + z2 + ")", true, new j(z2));
    }

    /* JADX INFO: renamed from: k1 */
    public void m7236k1() {
        m7237l1(true, 3);
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: l0 */
    public void mo7219l0(@NonNull Hdr hdr) {
        Hdr hdr2 = this.f13866A;
        this.f13866A = hdr;
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b("hdr (" + hdr + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new d(hdr2)));
    }

    /* JADX INFO: renamed from: l1 */
    public final void m7237l1(boolean z2, int i2) {
        if ((this.f13922n.f14028f != CameraState2.PREVIEW || m7324O()) && z2) {
            return;
        }
        try {
            this.f13806h0.setRepeatingRequest(this.f13807i0.build(), this.f13816r0, null);
        } catch (CameraAccessException e2) {
            throw new CameraException(e2, i2);
        } catch (IllegalStateException e3) {
            CameraLogger cameraLogger = CameraEngine.f13918j;
            CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
            cameraLogger.m7159a(3, "applyRepeatingRequestBuilder: session is invalid!", e3, "checkStarted:", Boolean.valueOf(z2), "currentThread:", Thread.currentThread().getName(), "state:", cameraStateOrchestrator.f14028f, "targetState:", cameraStateOrchestrator.f14029g);
            throw new CameraException(3);
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: m0 */
    public void mo7221m0(@Nullable Location location) {
        Location location2 = this.f13868C;
        this.f13868C = location;
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b(ModelAuditLogEntry.CHANGE_KEY_LOCATION, true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new b(location2)));
    }

    /* JADX INFO: renamed from: m1 */
    public boolean m7238m1(@NonNull CaptureRequest.Builder builder, @NonNull WhiteBalance whiteBalance) {
        if (!this.f13896p.m7163c(this.f13904x)) {
            this.f13904x = whiteBalance;
            return false;
        }
        Camera2Mapper camera2Mapper = this.f13809k0;
        WhiteBalance whiteBalance2 = this.f13904x;
        Objects.requireNonNull(camera2Mapper);
        builder.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(Camera2Mapper.f13963c.get(whiteBalance2).intValue()));
        return true;
    }

    /* JADX INFO: renamed from: n1 */
    public boolean m7239n1(@NonNull CaptureRequest.Builder builder, float f2) {
        if (!this.f13896p.f13692k) {
            this.f13869D = f2;
            return false;
        }
        float fFloatValue = ((Float) m7245t1(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM, Float.valueOf(1.0f))).floatValue();
        float f3 = fFloatValue - 1.0f;
        float f4 = (this.f13869D * f3) + 1.0f;
        Rect rect = (Rect) m7245t1(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new Rect());
        int iWidth = (int) (rect.width() / fFloatValue);
        int iWidth2 = rect.width() - iWidth;
        int iHeight = rect.height() - ((int) (rect.height() / fFloatValue));
        float f5 = f4 - 1.0f;
        int i2 = (int) (((iWidth2 * f5) / f3) / 2.0f);
        int i3 = (int) (((iHeight * f5) / f3) / 2.0f);
        builder.set(CaptureRequest.SCALER_CROP_REGION, new Rect(i2, i3, rect.width() - i2, rect.height() - i3));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    @NonNull
    /* JADX INFO: renamed from: o1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CameraException m7240o1(@NonNull CameraAccessException cameraAccessException) {
        int reason = cameraAccessException.getReason();
        int i2 = 3;
        if (reason == 1) {
            i2 = 1;
        } else if (reason != 2 && reason != 3) {
            if (reason != 4 && reason != 5) {
                i2 = 0;
            }
        }
        return new CameraException(cameraAccessException, i2);
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader imageReader) {
        CameraEngine.f13918j.m7159a(0, "onImageAvailable:", "trying to acquire Image.");
        Image imageAcquireLatestImage = null;
        try {
            imageAcquireLatestImage = imageReader.acquireLatestImage();
        } catch (Exception unused) {
        }
        if (imageAcquireLatestImage == null) {
            CameraEngine.f13918j.m7159a(2, "onImageAvailable:", "failed to acquire Image!");
            return;
        }
        if (this.f13922n.f14028f != CameraState2.PREVIEW || m7324O()) {
            CameraEngine.f13918j.m7159a(1, "onImageAvailable:", "Image acquired in wrong state. Closing it now.");
            imageAcquireLatestImage.close();
            return;
        }
        Frame2 frame2M7385a = m7273S0().m7385a(imageAcquireLatestImage, System.currentTimeMillis());
        if (frame2M7385a == null) {
            CameraEngine.f13918j.m7159a(1, "onImageAvailable:", "Image acquired, but no free frames. DROPPING.");
        } else {
            CameraEngine.f13918j.m7159a(0, "onImageAvailable:", "Image acquired, dispatching.");
            ((CameraView.C11195b) this.f13921m).m9312b(frame2M7385a);
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: p0 */
    public void mo7223p0(@NonNull PictureFormat pictureFormat) {
        if (pictureFormat != this.f13867B) {
            this.f13867B = pictureFormat;
            CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
            cameraStateOrchestrator.m7363b("picture format (" + pictureFormat + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new h()));
        }
    }

    @NonNull
    /* JADX INFO: renamed from: p1 */
    public final MeterAction m7241p1(@Nullable MeteringRegions meteringRegions) {
        MeterAction meterAction = this.f13815q0;
        if (meterAction != null) {
            meterAction.mo7330a(this);
        }
        CaptureRequest.Builder builder = this.f13807i0;
        int[] iArr = (int[]) m7245t1(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        if (arrayList.contains(1)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (this.f13882Q == Mode3.VIDEO && arrayList.contains(3)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
        } else if (arrayList.contains(4)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
        }
        MeterAction meterAction2 = new MeterAction(this, meteringRegions, meteringRegions == null);
        this.f13815q0 = meterAction2;
        return meterAction2;
    }

    @NonNull
    /* JADX INFO: renamed from: q1 */
    public final CaptureRequest.Builder m7242q1(int i2) throws CameraAccessException {
        CaptureRequest.Builder builder = this.f13807i0;
        CaptureRequest.Builder builderCreateCaptureRequest = this.f13804f0.createCaptureRequest(i2);
        this.f13807i0 = builderCreateCaptureRequest;
        builderCreateCaptureRequest.setTag(Integer.valueOf(i2));
        m7229d1(this.f13807i0, builder);
        return this.f13807i0;
    }

    @NonNull
    /* JADX INFO: renamed from: r1 */
    public List<Range<Integer>> m7243r1(@NonNull Range<Integer>[] rangeArr) {
        ArrayList arrayList = new ArrayList();
        int iRound = Math.round(this.f13896p.f13697p);
        int iRound2 = Math.round(this.f13896p.f13698q);
        for (Range<Integer> range : rangeArr) {
            if (range.contains(Integer.valueOf(iRound)) || range.contains(Integer.valueOf(iRound2))) {
                CameraLogger cameraLogger = FpsRangeValidator.f14103a;
                String str = Build.MODEL;
                boolean z2 = true;
                String str2 = Build.MANUFACTURER;
                cameraLogger.m7159a(1, "Build.MODEL:", str, "Build.BRAND:", Build.BRAND, "Build.MANUFACTURER:", str2);
                List<Range<Integer>> list = FpsRangeValidator.f14104b.get(str2 + " " + str);
                if (list != null && list.contains(range)) {
                    cameraLogger.m7159a(1, "Dropping range:", range);
                    z2 = false;
                }
                if (z2) {
                    arrayList.add(range);
                }
            }
        }
        return arrayList;
    }

    @NonNull
    /* JADX INFO: renamed from: s1 */
    public List<Size3> m7244s1() {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f13802d0.getCameraCharacteristics(this.f13803e0).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
            }
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.f13901u);
            ArrayList arrayList = new ArrayList(outputSizes.length);
            for (Size size : outputSizes) {
                Size3 size3 = new Size3(size.getWidth(), size.getHeight());
                if (!arrayList.contains(size3)) {
                    arrayList.add(size3);
                }
            }
            return arrayList;
        } catch (CameraAccessException e2) {
            throw m7240o1(e2);
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: t0 */
    public void mo7224t0(boolean z2) {
        this.f13871F = z2;
        C3404f.m4264Z(null);
    }

    @NonNull
    @VisibleForTesting
    /* JADX INFO: renamed from: t1 */
    public <T> T m7245t1(@NonNull CameraCharacteristics.Key<T> key, @NonNull T t) {
        T t2 = (T) this.f13805g0.get(key);
        return t2 == null ? t : t2;
    }

    @NonNull
    /* JADX INFO: renamed from: u1 */
    public final <T> T m7246u1(@NonNull CameraCharacteristics cameraCharacteristics, @NonNull CameraCharacteristics.Key<T> key, @NonNull T t) {
        T t2 = (T) cameraCharacteristics.get(key);
        return t2 == null ? t : t2;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: v0 */
    public void mo7225v0(float f2) {
        float f3 = this.f13874I;
        this.f13874I = f2;
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b("preview fps (" + f2 + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new g(f3)));
    }
}
