package b.o.a.n;

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
import b.o.a.l;
import b.o.a.n.i;
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

/* compiled from: Camera2Engine.java */
@RequiresApi(21)
/* loaded from: classes3.dex */
public class d extends b.o.a.n.g implements ImageReader.OnImageAvailableListener, b.o.a.n.o.c {

    /* renamed from: d0, reason: collision with root package name */
    public final CameraManager f1916d0;

    /* renamed from: e0, reason: collision with root package name */
    public String f1917e0;

    /* renamed from: f0, reason: collision with root package name */
    public CameraDevice f1918f0;

    /* renamed from: g0, reason: collision with root package name */
    public CameraCharacteristics f1919g0;

    /* renamed from: h0, reason: collision with root package name */
    public CameraCaptureSession f1920h0;

    /* renamed from: i0, reason: collision with root package name */
    public CaptureRequest.Builder f1921i0;

    /* renamed from: j0, reason: collision with root package name */
    public TotalCaptureResult f1922j0;
    public final b.o.a.n.q.b k0;
    public ImageReader l0;
    public Surface m0;
    public Surface n0;
    public ImageReader o0;
    public final List<b.o.a.n.o.a> p0;
    public b.o.a.n.r.g q0;
    public final CameraCaptureSession.CaptureCallback r0;

    /* compiled from: Camera2Engine.java */
    public class a implements Runnable {
        public final /* synthetic */ b.o.a.m.f j;
        public final /* synthetic */ b.o.a.m.f k;

        public a(b.o.a.m.f fVar, b.o.a.m.f fVar2) {
            this.j = fVar;
            this.k = fVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            boolean zH1 = dVar.h1(dVar.f1921i0, this.j);
            d dVar2 = d.this;
            if (!(dVar2.n.f == b.o.a.n.v.e.PREVIEW)) {
                if (zH1) {
                    dVar2.k1();
                    return;
                }
                return;
            }
            dVar2.w = b.o.a.m.f.OFF;
            dVar2.h1(dVar2.f1921i0, this.j);
            try {
                d dVar3 = d.this;
                dVar3.f1920h0.capture(dVar3.f1921i0.build(), null, null);
                d dVar4 = d.this;
                dVar4.w = this.k;
                dVar4.h1(dVar4.f1921i0, this.j);
                d.this.k1();
            } catch (CameraAccessException e) {
                throw d.this.o1(e);
            }
        }
    }

    /* compiled from: Camera2Engine.java */
    public class b implements Runnable {
        public final /* synthetic */ Location j;

        public b(Location location) {
            this.j = location;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            CaptureRequest.Builder builder = dVar.f1921i0;
            Location location = dVar.C;
            if (location != null) {
                builder.set(CaptureRequest.JPEG_GPS_LOCATION, location);
            }
            d.this.k1();
        }
    }

    /* compiled from: Camera2Engine.java */
    public class c implements Runnable {
        public final /* synthetic */ b.o.a.m.m j;

        public c(b.o.a.m.m mVar) {
            this.j = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            if (dVar.m1(dVar.f1921i0, this.j)) {
                d.this.k1();
            }
        }
    }

    /* compiled from: Camera2Engine.java */
    /* renamed from: b.o.a.n.d$d, reason: collision with other inner class name */
    public class RunnableC0171d implements Runnable {
        public final /* synthetic */ b.o.a.m.h j;

        public RunnableC0171d(b.o.a.m.h hVar) {
            this.j = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            if (dVar.i1(dVar.f1921i0, this.j)) {
                d.this.k1();
            }
        }
    }

    /* compiled from: Camera2Engine.java */
    public class e implements Runnable {
        public final /* synthetic */ float j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ float l;
        public final /* synthetic */ PointF[] m;

        public e(float f, boolean z2, float f2, PointF[] pointFArr) {
            this.j = f;
            this.k = z2;
            this.l = f2;
            this.m = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            if (dVar.n1(dVar.f1921i0, this.j)) {
                d.this.k1();
                if (this.k) {
                    ((CameraView.b) d.this.m).f(this.l, this.m);
                }
            }
        }
    }

    /* compiled from: Camera2Engine.java */
    public class f implements Runnable {
        public final /* synthetic */ float j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ float l;
        public final /* synthetic */ float[] m;
        public final /* synthetic */ PointF[] n;

        public f(float f, boolean z2, float f2, float[] fArr, PointF[] pointFArr) {
            this.j = f;
            this.k = z2;
            this.l = f2;
            this.m = fArr;
            this.n = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            if (dVar.g1(dVar.f1921i0, this.j)) {
                d.this.k1();
                if (this.k) {
                    ((CameraView.b) d.this.m).c(this.l, this.m, this.n);
                }
            }
        }
    }

    /* compiled from: Camera2Engine.java */
    public class g implements Runnable {
        public final /* synthetic */ float j;

        public g(float f) {
            this.j = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            if (dVar.j1(dVar.f1921i0, this.j)) {
                d.this.k1();
            }
        }
    }

    /* compiled from: Camera2Engine.java */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.X();
        }
    }

    /* compiled from: Camera2Engine.java */
    public class i extends CameraCaptureSession.CaptureCallback {
        public i() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            d dVar = d.this;
            dVar.f1922j0 = totalCaptureResult;
            Iterator<b.o.a.n.o.a> it = dVar.p0.iterator();
            while (it.hasNext()) {
                it.next().b(d.this, captureRequest, totalCaptureResult);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
            Iterator<b.o.a.n.o.a> it = d.this.p0.iterator();
            while (it.hasNext()) {
                it.next().d(d.this, captureRequest, captureResult);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j, long j2) {
            Iterator<b.o.a.n.o.a> it = d.this.p0.iterator();
            while (it.hasNext()) {
                it.next().c(d.this, captureRequest);
            }
        }
    }

    /* compiled from: Camera2Engine.java */
    public class j implements Runnable {
        public final /* synthetic */ boolean j;

        public j(boolean z2) {
            this.j = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.o.a.n.v.e eVar = d.this.n.f;
            b.o.a.n.v.e eVar2 = b.o.a.n.v.e.BIND;
            if (eVar.f(eVar2) && d.this.O()) {
                d.this.k0(this.j);
                return;
            }
            d dVar = d.this;
            dVar.v = this.j;
            if (dVar.n.f.f(eVar2)) {
                d.this.Y();
            }
        }
    }

    /* compiled from: Camera2Engine.java */
    public class k implements Runnable {
        public final /* synthetic */ int j;

        public k(int i) {
            this.j = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.o.a.n.v.e eVar = d.this.n.f;
            b.o.a.n.v.e eVar2 = b.o.a.n.v.e.BIND;
            if (eVar.f(eVar2) && d.this.O()) {
                d.this.g0(this.j);
                return;
            }
            d dVar = d.this;
            int i = this.j;
            if (i <= 0) {
                i = 35;
            }
            dVar.u = i;
            if (dVar.n.f.f(eVar2)) {
                d.this.Y();
            }
        }
    }

    /* compiled from: Camera2Engine.java */
    public class l implements Runnable {
        public final /* synthetic */ b.o.a.q.a j;
        public final /* synthetic */ PointF k;
        public final /* synthetic */ b.o.a.t.b l;

        /* compiled from: Camera2Engine.java */
        public class a extends b.o.a.n.o.f {
            public final /* synthetic */ b.o.a.n.r.g a;

            /* compiled from: Camera2Engine.java */
            /* renamed from: b.o.a.n.d$l$a$a, reason: collision with other inner class name */
            public class RunnableC0172a implements Runnable {
                public RunnableC0172a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    d.b1(d.this);
                }
            }

            public a(b.o.a.n.r.g gVar) {
                this.a = gVar;
            }

            @Override // b.o.a.n.o.f
            public void b(@NonNull b.o.a.n.o.a aVar) {
                boolean z2;
                l lVar = l.this;
                i.g gVar = d.this.m;
                b.o.a.q.a aVar2 = lVar.j;
                Iterator<b.o.a.n.r.a> it = this.a.f.iterator();
                while (true) {
                    z2 = true;
                    if (!it.hasNext()) {
                        b.o.a.n.r.g.e.a(1, "isSuccessful:", "returning true.");
                        break;
                    } else if (!it.next().g) {
                        b.o.a.n.r.g.e.a(1, "isSuccessful:", "returning false.");
                        z2 = false;
                        break;
                    }
                }
                ((CameraView.b) gVar).d(aVar2, z2, l.this.k);
                d.this.n.e("reset metering", 0);
                if (d.this.a1()) {
                    d dVar = d.this;
                    b.o.a.n.v.f fVar = dVar.n;
                    fVar.c("reset metering", true, dVar.W, new b.o.a.n.v.i(fVar, b.o.a.n.v.e.PREVIEW, new RunnableC0172a()));
                }
            }
        }

        public l(b.o.a.q.a aVar, PointF pointF, b.o.a.t.b bVar) {
            this.j = aVar;
            this.k = pointF;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            if (dVar.p.o) {
                ((CameraView.b) dVar.m).e(this.j, this.k);
                b.o.a.n.r.g gVarP1 = d.this.p1(this.l);
                b.o.a.n.o.i iVar = new b.o.a.n.o.i(5000L, gVarP1);
                iVar.e(d.this);
                iVar.f(new a(gVarP1));
            }
        }
    }

    /* compiled from: Camera2Engine.java */
    public class m extends CameraDevice.StateCallback {
        public final /* synthetic */ TaskCompletionSource a;

        public m(TaskCompletionSource taskCompletionSource) {
            this.a = taskCompletionSource;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            CameraException cameraException = new CameraException(3);
            if (this.a.a.o()) {
                b.o.a.n.i.j.a(1, "CameraDevice.StateCallback reported disconnection.");
                throw cameraException;
            }
            this.a.a(cameraException);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i) {
            int i2 = 1;
            if (this.a.a.o()) {
                b.o.a.n.i.j.a(3, "CameraDevice.StateCallback reported an error:", Integer.valueOf(i));
                throw new CameraException(3);
            }
            TaskCompletionSource taskCompletionSource = this.a;
            Objects.requireNonNull(d.this);
            if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
                i2 = 0;
            }
            taskCompletionSource.a(new CameraException(i2));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            int i;
            d.this.f1918f0 = cameraDevice;
            try {
                b.o.a.n.i.j.a(1, "onStartEngine:", "Opened camera device.");
                d dVar = d.this;
                dVar.f1919g0 = dVar.f1916d0.getCameraCharacteristics(dVar.f1917e0);
                boolean zB = d.this.L.b(b.o.a.n.t.b.SENSOR, b.o.a.n.t.b.VIEW);
                int iOrdinal = d.this.B.ordinal();
                if (iOrdinal == 0) {
                    i = 256;
                } else {
                    if (iOrdinal != 1) {
                        throw new IllegalArgumentException("Unknown format:" + d.this.B);
                    }
                    i = 32;
                }
                d dVar2 = d.this;
                dVar2.p = new b.o.a.n.u.b(dVar2.f1916d0, dVar2.f1917e0, zB, i);
                d dVar3 = d.this;
                Objects.requireNonNull(dVar3);
                dVar3.q1(1);
                this.a.b(d.this.p);
            } catch (CameraAccessException e) {
                this.a.a(d.this.o1(e));
            }
        }
    }

    /* compiled from: Camera2Engine.java */
    public class n implements Callable<Void> {
        public final /* synthetic */ Object j;

        public n(Object obj) {
            this.j = obj;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            SurfaceHolder surfaceHolder = (SurfaceHolder) this.j;
            b.o.a.x.b bVar = d.this.f1931s;
            surfaceHolder.setFixedSize(bVar.j, bVar.k);
            return null;
        }
    }

    /* compiled from: Camera2Engine.java */
    public class o extends CameraCaptureSession.StateCallback {
        public final /* synthetic */ TaskCompletionSource a;

        public o(TaskCompletionSource taskCompletionSource) {
            this.a = taskCompletionSource;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            RuntimeException runtimeException = new RuntimeException(b.o.a.n.i.j.a(3, "onConfigureFailed! Session", cameraCaptureSession));
            if (this.a.a.o()) {
                throw new CameraException(3);
            }
            this.a.a(new CameraException(runtimeException, 2));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            d.this.f1920h0 = cameraCaptureSession;
            b.o.a.n.i.j.a(1, "onStartBind:", "Completed");
            this.a.b(null);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
            super.onReady(cameraCaptureSession);
            b.o.a.n.i.j.a(1, "CameraCaptureSession.StateCallback reported onReady.");
        }
    }

    /* compiled from: Camera2Engine.java */
    public class p extends b.o.a.n.o.e {
        public final /* synthetic */ TaskCompletionSource e;

        public p(d dVar, TaskCompletionSource taskCompletionSource) {
            this.e = taskCompletionSource;
        }

        @Override // b.o.a.n.o.e, b.o.a.n.o.a
        public void b(@NonNull b.o.a.n.o.c cVar, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            l(Integer.MAX_VALUE);
            this.e.b(null);
        }
    }

    /* compiled from: Camera2Engine.java */
    public class q extends b.o.a.n.o.f {
        public final /* synthetic */ l.a a;

        public q(l.a aVar) {
            this.a = aVar;
        }

        @Override // b.o.a.n.o.f
        public void b(@NonNull b.o.a.n.o.a aVar) {
            d dVar = d.this;
            dVar.H = false;
            dVar.P0(this.a);
            d.this.H = true;
        }
    }

    /* compiled from: Camera2Engine.java */
    public class r extends b.o.a.n.o.f {
        public final /* synthetic */ l.a a;

        public r(l.a aVar) {
            this.a = aVar;
        }

        @Override // b.o.a.n.o.f
        public void b(@NonNull b.o.a.n.o.a aVar) {
            d dVar = d.this;
            dVar.G = false;
            dVar.O0(this.a);
            d.this.G = true;
        }
    }

    /* compiled from: Camera2Engine.java */
    public class s implements Runnable {
        public s() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b1(d.this);
        }
    }

    public d(i.g gVar) {
        super(gVar);
        if (b.o.a.n.q.b.a == null) {
            b.o.a.n.q.b.a = new b.o.a.n.q.b();
        }
        this.k0 = b.o.a.n.q.b.a;
        this.p0 = new CopyOnWriteArrayList();
        this.r0 = new i();
        this.f1916d0 = (CameraManager) ((CameraView.b) this.m).g().getSystemService(ChatInputComponentTypes.CAMERA);
        new b.o.a.n.o.g().e(this);
    }

    public static void b1(d dVar) {
        Objects.requireNonNull(dVar);
        new b.o.a.n.o.h(Arrays.asList(new b.o.a.n.f(dVar), new b.o.a.n.r.h())).e(dVar);
    }

    @Override // b.o.a.n.i
    public void F0(@NonNull b.o.a.m.m mVar) {
        b.o.a.m.m mVar2 = this.f1932x;
        this.f1932x = mVar;
        b.o.a.n.v.f fVar = this.n;
        fVar.b("white balance (" + mVar + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new c(mVar2)));
    }

    @Override // b.o.a.n.i
    public void G0(float f2, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.D;
        this.D = f2;
        this.n.e("zoom", 20);
        b.o.a.n.v.f fVar = this.n;
        fVar.b("zoom", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new e(f3, z2, f2, pointFArr)));
    }

    @Override // b.o.a.n.i
    public void I0(@Nullable b.o.a.q.a aVar, @NonNull b.o.a.t.b bVar, @NonNull PointF pointF) {
        b.o.a.n.v.f fVar = this.n;
        fVar.b("autofocus (" + aVar + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.PREVIEW, new l(aVar, pointF, bVar)));
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> P() {
        Handler handler;
        int i2;
        b.o.a.b bVar = b.o.a.n.i.j;
        bVar.a(1, "onStartBind:", "Started");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.r = Q0(this.Q);
        this.f1931s = R0();
        ArrayList arrayList = new ArrayList();
        Class clsJ = this.o.j();
        Object objI = this.o.i();
        if (clsJ == SurfaceHolder.class) {
            try {
                bVar.a(1, "onStartBind:", "Waiting on UI thread...");
                b.i.a.f.e.o.f.j(b.i.a.f.e.o.f.o(b.i.a.f.n.g.a, new n(objI)));
                this.n0 = ((SurfaceHolder) objI).getSurface();
            } catch (InterruptedException | ExecutionException e2) {
                throw new CameraException(e2, 1);
            }
        } else {
            if (clsJ != SurfaceTexture.class) {
                throw new RuntimeException("Unknown CameraPreview output class.");
            }
            SurfaceTexture surfaceTexture = (SurfaceTexture) objI;
            b.o.a.x.b bVar2 = this.f1931s;
            surfaceTexture.setDefaultBufferSize(bVar2.j, bVar2.k);
            this.n0 = new Surface(surfaceTexture);
        }
        arrayList.add(this.n0);
        if (this.Q == b.o.a.m.i.PICTURE) {
            int iOrdinal = this.B.ordinal();
            if (iOrdinal == 0) {
                i2 = 256;
            } else {
                if (iOrdinal != 1) {
                    StringBuilder sbU = b.d.b.a.a.U("Unknown format:");
                    sbU.append(this.B);
                    throw new IllegalArgumentException(sbU.toString());
                }
                i2 = 32;
            }
            b.o.a.x.b bVar3 = this.r;
            ImageReader imageReaderNewInstance = ImageReader.newInstance(bVar3.j, bVar3.k, i2, 2);
            this.o0 = imageReaderNewInstance;
            arrayList.add(imageReaderNewInstance.getSurface());
        }
        if (this.v) {
            List<b.o.a.x.b> listS1 = s1();
            boolean zB = this.L.b(b.o.a.n.t.b.SENSOR, b.o.a.n.t.b.VIEW);
            ArrayList<b.o.a.x.b> arrayList2 = (ArrayList) listS1;
            ArrayList arrayList3 = new ArrayList(arrayList2.size());
            for (b.o.a.x.b bVarF : arrayList2) {
                if (zB) {
                    bVarF = bVarF.f();
                }
                arrayList3.add(bVarF);
            }
            b.o.a.x.b bVar4 = this.f1931s;
            b.o.a.x.a aVarF = b.o.a.x.a.f(bVar4.j, bVar4.k);
            if (zB) {
                aVarF = b.o.a.x.a.f(aVarF.l, aVarF.k);
            }
            int i3 = this.Z;
            int i4 = this.f1928a0;
            if (i3 <= 0 || i3 == Integer.MAX_VALUE) {
                i3 = 640;
            }
            if (i4 <= 0 || i4 == Integer.MAX_VALUE) {
                i4 = 640;
            }
            b.o.a.x.b bVar5 = new b.o.a.x.b(i3, i4);
            b.o.a.b bVar6 = b.o.a.n.i.j;
            bVar6.a(1, "computeFrameProcessingSize:", "targetRatio:", aVarF, "targetMaxSize:", bVar5);
            b.o.a.x.c cVarD1 = b.i.a.f.e.o.f.D1(new b.o.a.x.d(aVarF.i(), 0.0f));
            b.o.a.x.c cVarG = b.i.a.f.e.o.f.g(b.i.a.f.e.o.f.K0(i4), b.i.a.f.e.o.f.L0(i3), new b.o.a.x.e());
            b.o.a.x.b bVarF2 = ((b.o.a.x.l) b.i.a.f.e.o.f.Q0(b.i.a.f.e.o.f.g(cVarD1, cVarG), cVarG, new b.o.a.x.f())).a(arrayList3).get(0);
            if (!arrayList3.contains(bVarF2)) {
                throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
            }
            if (zB) {
                bVarF2 = bVarF2.f();
            }
            bVar6.a(1, "computeFrameProcessingSize:", "result:", bVarF2, "flip:", Boolean.valueOf(zB));
            this.t = bVarF2;
            ImageReader imageReaderNewInstance2 = ImageReader.newInstance(bVarF2.j, bVarF2.k, this.u, this.f1929b0 + 1);
            this.l0 = imageReaderNewInstance2;
            handler = null;
            imageReaderNewInstance2.setOnImageAvailableListener(this, null);
            Surface surface = this.l0.getSurface();
            this.m0 = surface;
            arrayList.add(surface);
        } else {
            handler = null;
            this.l0 = null;
            this.t = null;
            this.m0 = null;
        }
        try {
            this.f1918f0.createCaptureSession(arrayList, new o(taskCompletionSource), handler);
            return taskCompletionSource.a;
        } catch (CameraAccessException e3) {
            throw o1(e3);
        }
    }

    @Override // b.o.a.n.i
    @NonNull
    @SuppressLint({"MissingPermission"})
    public Task<b.o.a.c> Q() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            this.f1916d0.openCamera(this.f1917e0, new m(taskCompletionSource), (Handler) null);
            return taskCompletionSource.a;
        } catch (CameraAccessException e2) {
            throw o1(e2);
        }
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> R() {
        b.o.a.b bVar = b.o.a.n.i.j;
        bVar.a(1, "onStartPreview:", "Dispatching onCameraPreviewStreamSizeChanged.");
        ((CameraView.b) this.m).h();
        b.o.a.n.t.b bVar2 = b.o.a.n.t.b.VIEW;
        b.o.a.x.b bVarC = C(bVar2);
        if (bVarC == null) {
            throw new IllegalStateException("previewStreamSize should not be null at this point.");
        }
        this.o.s(bVarC.j, bVarC.k);
        this.o.r(this.L.c(b.o.a.n.t.b.BASE, bVar2, 1));
        if (this.v) {
            S0().e(this.u, this.t, this.L);
        }
        bVar.a(1, "onStartPreview:", "Starting preview.");
        c1(new Surface[0]);
        l1(false, 2);
        bVar.a(1, "onStartPreview:", "Started preview.");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        new p(this, taskCompletionSource).e(this);
        return taskCompletionSource.a;
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> S() {
        b.o.a.b bVar = b.o.a.n.i.j;
        bVar.a(1, "onStopBind:", "About to clean up.");
        this.m0 = null;
        this.n0 = null;
        this.f1931s = null;
        this.r = null;
        this.t = null;
        ImageReader imageReader = this.l0;
        if (imageReader != null) {
            imageReader.close();
            this.l0 = null;
        }
        ImageReader imageReader2 = this.o0;
        if (imageReader2 != null) {
            imageReader2.close();
            this.o0 = null;
        }
        this.f1920h0.close();
        this.f1920h0 = null;
        bVar.a(1, "onStopBind:", "Returning.");
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> T() {
        try {
            b.o.a.b bVar = b.o.a.n.i.j;
            bVar.a(1, "onStopEngine:", "Clean up.", "Releasing camera.");
            this.f1918f0.close();
            bVar.a(1, "onStopEngine:", "Clean up.", "Released camera.");
        } catch (Exception e2) {
            b.o.a.n.i.j.a(2, "onStopEngine:", "Clean up.", "Exception while releasing camera.", e2);
        }
        this.f1918f0 = null;
        b.o.a.n.i.j.a(1, "onStopEngine:", "Aborting actions.");
        Iterator<b.o.a.n.o.a> it = this.p0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        this.f1919g0 = null;
        this.p = null;
        this.f1921i0 = null;
        b.o.a.n.i.j.a(2, "onStopEngine:", "Returning.");
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.g
    @NonNull
    public List<b.o.a.x.b> T0() {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f1916d0.getCameraCharacteristics(this.f1917e0).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
            }
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.o.j());
            ArrayList arrayList = new ArrayList(outputSizes.length);
            for (Size size : outputSizes) {
                b.o.a.x.b bVar = new b.o.a.x.b(size.getWidth(), size.getHeight());
                if (!arrayList.contains(bVar)) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        } catch (CameraAccessException e2) {
            throw o1(e2);
        }
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> U() {
        b.o.a.b bVar = b.o.a.n.i.j;
        bVar.a(1, "onStopPreview:", "Started.");
        this.q = null;
        if (this.v) {
            S0().d();
        }
        this.f1921i0.removeTarget(this.n0);
        Surface surface = this.m0;
        if (surface != null) {
            this.f1921i0.removeTarget(surface);
        }
        this.f1922j0 = null;
        bVar.a(1, "onStopPreview:", "Returning.");
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.g
    @NonNull
    public b.o.a.p.c V0(int i2) {
        return new b.o.a.p.e(i2);
    }

    @Override // b.o.a.n.g
    public void X0() {
        b.o.a.n.i.j.a(1, "onPreviewStreamSizeChanged:", "Calling restartBind().");
        Y();
    }

    @Override // b.o.a.n.g
    public void Y0(@NonNull l.a aVar, boolean z2) {
        if (z2) {
            b.o.a.n.i.j.a(1, "onTakePicture:", "doMetering is true. Delaying.");
            b.o.a.n.o.i iVar = new b.o.a.n.o.i(2500L, p1(null));
            iVar.f(new r(aVar));
            iVar.e(this);
            return;
        }
        b.o.a.n.i.j.a(1, "onTakePicture:", "doMetering is false. Performing.");
        b.o.a.n.t.a aVar2 = this.L;
        b.o.a.n.t.b bVar = b.o.a.n.t.b.SENSOR;
        b.o.a.n.t.b bVar2 = b.o.a.n.t.b.OUTPUT;
        aVar.c = aVar2.c(bVar, bVar2, 2);
        aVar.d = w(bVar2);
        try {
            CaptureRequest.Builder builderCreateCaptureRequest = this.f1918f0.createCaptureRequest(2);
            d1(builderCreateCaptureRequest, this.f1921i0);
            b.o.a.v.b bVar3 = new b.o.a.v.b(aVar, this, builderCreateCaptureRequest, this.o0);
            this.q = bVar3;
            bVar3.c();
        } catch (CameraAccessException e2) {
            throw o1(e2);
        }
    }

    @Override // b.o.a.n.g
    public void Z0(@NonNull l.a aVar, @NonNull b.o.a.x.a aVar2, boolean z2) {
        if (z2) {
            b.o.a.n.i.j.a(1, "onTakePictureSnapshot:", "doMetering is true. Delaying.");
            b.o.a.n.o.i iVar = new b.o.a.n.o.i(2500L, p1(null));
            iVar.f(new q(aVar));
            iVar.e(this);
            return;
        }
        b.o.a.n.i.j.a(1, "onTakePictureSnapshot:", "doMetering is false. Performing.");
        if (!(this.o instanceof b.o.a.w.e)) {
            throw new RuntimeException("takePictureSnapshot with Camera2 is only supported with Preview.GL_SURFACE");
        }
        b.o.a.n.t.b bVar = b.o.a.n.t.b.OUTPUT;
        aVar.d = F(bVar);
        aVar.c = this.L.c(b.o.a.n.t.b.VIEW, bVar, 1);
        b.o.a.v.f fVar = new b.o.a.v.f(aVar, this, (b.o.a.w.e) this.o, aVar2);
        this.q = fVar;
        fVar.c();
    }

    @Override // b.o.a.n.g, b.o.a.v.d.a
    public void a(@Nullable l.a aVar, @Nullable Exception exc) {
        boolean z2 = this.q instanceof b.o.a.v.b;
        super.a(aVar, exc);
        if ((z2 && this.G) || (!z2 && this.H)) {
            b.o.a.n.v.f fVar = this.n;
            fVar.b("reset metering after picture", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.PREVIEW, new s()));
        }
    }

    @Override // b.o.a.n.i
    public final boolean c(@NonNull b.o.a.m.e eVar) {
        CameraCharacteristics cameraCharacteristics;
        Objects.requireNonNull(this.k0);
        int iIntValue = b.o.a.n.q.b.f1937b.get(eVar).intValue();
        try {
            String[] cameraIdList = this.f1916d0.getCameraIdList();
            b.o.a.n.i.j.a(1, "collectCameraInfo", "Facing:", eVar, "Internal:", Integer.valueOf(iIntValue), "Cameras:", Integer.valueOf(cameraIdList.length));
            for (String str : cameraIdList) {
                try {
                    cameraCharacteristics = this.f1916d0.getCameraCharacteristics(str);
                } catch (CameraAccessException unused) {
                }
                if (iIntValue == ((Integer) u1(cameraCharacteristics, CameraCharacteristics.LENS_FACING, -99)).intValue()) {
                    this.f1917e0 = str;
                    this.L.f(eVar, ((Integer) u1(cameraCharacteristics, CameraCharacteristics.SENSOR_ORIENTATION, 0)).intValue());
                    return true;
                }
                continue;
            }
            return false;
        } catch (CameraAccessException e2) {
            throw o1(e2);
        }
    }

    public final void c1(@NonNull Surface... surfaceArr) {
        this.f1921i0.addTarget(this.n0);
        Surface surface = this.m0;
        if (surface != null) {
            this.f1921i0.addTarget(surface);
        }
        for (Surface surface2 : surfaceArr) {
            if (surface2 == null) {
                throw new IllegalArgumentException("Should not add a null surface.");
            }
            this.f1921i0.addTarget(surface2);
        }
    }

    @Override // b.o.a.n.i
    public void d0(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.E;
        this.E = f2;
        this.n.e("exposure correction", 20);
        b.o.a.n.v.f fVar = this.n;
        fVar.b("exposure correction", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new f(f3, z2, f2, fArr, pointFArr)));
    }

    public final void d1(@NonNull CaptureRequest.Builder builder, @Nullable CaptureRequest.Builder builder2) {
        b.o.a.n.i.j.a(1, "applyAllParameters:", "called for tag", builder.build().getTag());
        builder.set(CaptureRequest.CONTROL_MODE, 1);
        f1(builder);
        h1(builder, b.o.a.m.f.OFF);
        Location location = this.C;
        if (location != null) {
            builder.set(CaptureRequest.JPEG_GPS_LOCATION, location);
        }
        m1(builder, b.o.a.m.m.AUTO);
        i1(builder, b.o.a.m.h.OFF);
        n1(builder, 0.0f);
        g1(builder, 0.0f);
        j1(builder, 0.0f);
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

    public void e1(@NonNull b.o.a.n.o.a aVar, @NonNull CaptureRequest.Builder builder) throws CameraAccessException {
        if (this.n.f != b.o.a.n.v.e.PREVIEW || O()) {
            return;
        }
        this.f1920h0.capture(builder.build(), this.r0, null);
    }

    @Override // b.o.a.n.i
    public void f0(@NonNull b.o.a.m.f fVar) {
        b.o.a.m.f fVar2 = this.w;
        this.w = fVar;
        b.o.a.n.v.f fVar3 = this.n;
        fVar3.b("flash (" + fVar + ")", true, new b.o.a.n.v.h(fVar3, b.o.a.n.v.e.ENGINE, new a(fVar2, fVar)));
    }

    public void f1(@NonNull CaptureRequest.Builder builder) {
        int[] iArr = (int[]) t1(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        if (this.Q == b.o.a.m.i.VIDEO && arrayList.contains(3)) {
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

    @Override // b.o.a.n.i
    public void g0(int i2) {
        if (this.u == 0) {
            this.u = 35;
        }
        this.n.b(b.d.b.a.a.r("frame processing format (", i2, ")"), true, new k(i2));
    }

    public boolean g1(@NonNull CaptureRequest.Builder builder, float f2) {
        if (!this.p.l) {
            this.E = f2;
            return false;
        }
        Rational rational = (Rational) t1(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP, new Rational(1, 1));
        builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(Math.round(rational.floatValue() * this.E)));
        return true;
    }

    public boolean h1(@NonNull CaptureRequest.Builder builder, @NonNull b.o.a.m.f fVar) {
        if (this.p.c(this.w)) {
            int[] iArr = (int[]) t1(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES, new int[0]);
            ArrayList arrayList = new ArrayList();
            for (int i2 : iArr) {
                arrayList.add(Integer.valueOf(i2));
            }
            b.o.a.n.q.b bVar = this.k0;
            b.o.a.m.f fVar2 = this.w;
            Objects.requireNonNull(bVar);
            ArrayList<Pair> arrayList2 = new ArrayList();
            int iOrdinal = fVar2.ordinal();
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
                    b.o.a.b bVar2 = b.o.a.n.i.j;
                    bVar2.a(1, "applyFlash: setting CONTROL_AE_MODE to", pair.first);
                    bVar2.a(1, "applyFlash: setting FLASH_MODE to", pair.second);
                    builder.set(CaptureRequest.CONTROL_AE_MODE, (Integer) pair.first);
                    builder.set(CaptureRequest.FLASH_MODE, (Integer) pair.second);
                    return true;
                }
            }
        }
        this.w = fVar;
        return false;
    }

    public boolean i1(@NonNull CaptureRequest.Builder builder, @NonNull b.o.a.m.h hVar) {
        if (!this.p.c(this.A)) {
            this.A = hVar;
            return false;
        }
        b.o.a.n.q.b bVar = this.k0;
        b.o.a.m.h hVar2 = this.A;
        Objects.requireNonNull(bVar);
        builder.set(CaptureRequest.CONTROL_SCENE_MODE, Integer.valueOf(b.o.a.n.q.b.d.get(hVar2).intValue()));
        return true;
    }

    public boolean j1(@NonNull CaptureRequest.Builder builder, float f2) {
        Range<Integer>[] rangeArr = (Range[]) t1(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES, new Range[0]);
        Arrays.sort(rangeArr, new b.o.a.n.e(this, this.J && this.I != 0.0f));
        float f3 = this.I;
        if (f3 == 0.0f) {
            for (Range range : (ArrayList) r1(rangeArr)) {
                if (range.contains(30) || range.contains(24)) {
                    builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
                    return true;
                }
            }
        } else {
            float fMin = Math.min(f3, this.p.q);
            this.I = fMin;
            this.I = Math.max(fMin, this.p.p);
            for (Range range2 : (ArrayList) r1(rangeArr)) {
                if (range2.contains(Integer.valueOf(Math.round(this.I)))) {
                    builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range2);
                    return true;
                }
            }
        }
        this.I = f2;
        return false;
    }

    @Override // b.o.a.n.i
    public void k0(boolean z2) {
        this.n.b("has frame processors (" + z2 + ")", true, new j(z2));
    }

    public void k1() {
        l1(true, 3);
    }

    @Override // b.o.a.n.i
    public void l0(@NonNull b.o.a.m.h hVar) {
        b.o.a.m.h hVar2 = this.A;
        this.A = hVar;
        b.o.a.n.v.f fVar = this.n;
        fVar.b("hdr (" + hVar + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new RunnableC0171d(hVar2)));
    }

    public final void l1(boolean z2, int i2) {
        if ((this.n.f != b.o.a.n.v.e.PREVIEW || O()) && z2) {
            return;
        }
        try {
            this.f1920h0.setRepeatingRequest(this.f1921i0.build(), this.r0, null);
        } catch (CameraAccessException e2) {
            throw new CameraException(e2, i2);
        } catch (IllegalStateException e3) {
            b.o.a.b bVar = b.o.a.n.i.j;
            b.o.a.n.v.f fVar = this.n;
            bVar.a(3, "applyRepeatingRequestBuilder: session is invalid!", e3, "checkStarted:", Boolean.valueOf(z2), "currentThread:", Thread.currentThread().getName(), "state:", fVar.f, "targetState:", fVar.g);
            throw new CameraException(3);
        }
    }

    @Override // b.o.a.n.i
    public void m0(@Nullable Location location) {
        Location location2 = this.C;
        this.C = location;
        b.o.a.n.v.f fVar = this.n;
        fVar.b(ModelAuditLogEntry.CHANGE_KEY_LOCATION, true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new b(location2)));
    }

    public boolean m1(@NonNull CaptureRequest.Builder builder, @NonNull b.o.a.m.m mVar) {
        if (!this.p.c(this.f1932x)) {
            this.f1932x = mVar;
            return false;
        }
        b.o.a.n.q.b bVar = this.k0;
        b.o.a.m.m mVar2 = this.f1932x;
        Objects.requireNonNull(bVar);
        builder.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(b.o.a.n.q.b.c.get(mVar2).intValue()));
        return true;
    }

    public boolean n1(@NonNull CaptureRequest.Builder builder, float f2) {
        if (!this.p.k) {
            this.D = f2;
            return false;
        }
        float fFloatValue = ((Float) t1(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM, Float.valueOf(1.0f))).floatValue();
        float f3 = fFloatValue - 1.0f;
        float f4 = (this.D * f3) + 1.0f;
        Rect rect = (Rect) t1(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new Rect());
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CameraException o1(@NonNull CameraAccessException cameraAccessException) {
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
        b.o.a.n.i.j.a(0, "onImageAvailable:", "trying to acquire Image.");
        Image imageAcquireLatestImage = null;
        try {
            imageAcquireLatestImage = imageReader.acquireLatestImage();
        } catch (Exception unused) {
        }
        if (imageAcquireLatestImage == null) {
            b.o.a.n.i.j.a(2, "onImageAvailable:", "failed to acquire Image!");
            return;
        }
        if (this.n.f != b.o.a.n.v.e.PREVIEW || O()) {
            b.o.a.n.i.j.a(1, "onImageAvailable:", "Image acquired in wrong state. Closing it now.");
            imageAcquireLatestImage.close();
            return;
        }
        b.o.a.p.b bVarA = S0().a(imageAcquireLatestImage, System.currentTimeMillis());
        if (bVarA == null) {
            b.o.a.n.i.j.a(1, "onImageAvailable:", "Image acquired, but no free frames. DROPPING.");
        } else {
            b.o.a.n.i.j.a(0, "onImageAvailable:", "Image acquired, dispatching.");
            ((CameraView.b) this.m).b(bVarA);
        }
    }

    @Override // b.o.a.n.i
    public void p0(@NonNull b.o.a.m.j jVar) {
        if (jVar != this.B) {
            this.B = jVar;
            b.o.a.n.v.f fVar = this.n;
            fVar.b("picture format (" + jVar + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new h()));
        }
    }

    @NonNull
    public final b.o.a.n.r.g p1(@Nullable b.o.a.t.b bVar) {
        b.o.a.n.r.g gVar = this.q0;
        if (gVar != null) {
            gVar.a(this);
        }
        CaptureRequest.Builder builder = this.f1921i0;
        int[] iArr = (int[]) t1(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        if (arrayList.contains(1)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (this.Q == b.o.a.m.i.VIDEO && arrayList.contains(3)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
        } else if (arrayList.contains(4)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
        }
        b.o.a.n.r.g gVar2 = new b.o.a.n.r.g(this, bVar, bVar == null);
        this.q0 = gVar2;
        return gVar2;
    }

    @NonNull
    public final CaptureRequest.Builder q1(int i2) throws CameraAccessException {
        CaptureRequest.Builder builder = this.f1921i0;
        CaptureRequest.Builder builderCreateCaptureRequest = this.f1918f0.createCaptureRequest(i2);
        this.f1921i0 = builderCreateCaptureRequest;
        builderCreateCaptureRequest.setTag(Integer.valueOf(i2));
        d1(this.f1921i0, builder);
        return this.f1921i0;
    }

    @NonNull
    public List<Range<Integer>> r1(@NonNull Range<Integer>[] rangeArr) {
        ArrayList arrayList = new ArrayList();
        int iRound = Math.round(this.p.p);
        int iRound2 = Math.round(this.p.q);
        for (Range<Integer> range : rangeArr) {
            if (range.contains(Integer.valueOf(iRound)) || range.contains(Integer.valueOf(iRound2))) {
                b.o.a.b bVar = b.o.a.r.b.a;
                String str = Build.MODEL;
                boolean z2 = true;
                String str2 = Build.MANUFACTURER;
                bVar.a(1, "Build.MODEL:", str, "Build.BRAND:", Build.BRAND, "Build.MANUFACTURER:", str2);
                List<Range<Integer>> list = b.o.a.r.b.f1949b.get(str2 + " " + str);
                if (list != null && list.contains(range)) {
                    bVar.a(1, "Dropping range:", range);
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
    public List<b.o.a.x.b> s1() {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f1916d0.getCameraCharacteristics(this.f1917e0).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
            }
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.u);
            ArrayList arrayList = new ArrayList(outputSizes.length);
            for (Size size : outputSizes) {
                b.o.a.x.b bVar = new b.o.a.x.b(size.getWidth(), size.getHeight());
                if (!arrayList.contains(bVar)) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        } catch (CameraAccessException e2) {
            throw o1(e2);
        }
    }

    @Override // b.o.a.n.i
    public void t0(boolean z2) {
        this.F = z2;
        b.i.a.f.e.o.f.Z(null);
    }

    @NonNull
    @VisibleForTesting
    public <T> T t1(@NonNull CameraCharacteristics.Key<T> key, @NonNull T t) {
        T t2 = (T) this.f1919g0.get(key);
        return t2 == null ? t : t2;
    }

    @NonNull
    public final <T> T u1(@NonNull CameraCharacteristics cameraCharacteristics, @NonNull CameraCharacteristics.Key<T> key, @NonNull T t) {
        T t2 = (T) cameraCharacteristics.get(key);
        return t2 == null ? t : t2;
    }

    @Override // b.o.a.n.i
    public void v0(float f2) {
        float f3 = this.I;
        this.I = f2;
        b.o.a.n.v.f fVar = this.n;
        fVar.b("preview fps (" + f2 + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new g(f3)));
    }
}
