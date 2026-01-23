package p007b.p452o.p453a.p455n;

import android.graphics.PointF;
import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p007b.p225i.p226a.p288f.p340n.C4358c0;
import p007b.p225i.p226a.p288f.p340n.C4363g;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.CameraOptions;
import p007b.p452o.p453a.PictureResult;
import p007b.p452o.p453a.p454m.Audio;
import p007b.p452o.p453a.p454m.AudioCodec;
import p007b.p452o.p453a.p454m.Facing;
import p007b.p452o.p453a.p454m.Flash;
import p007b.p452o.p453a.p454m.Hdr;
import p007b.p452o.p453a.p454m.Mode3;
import p007b.p452o.p453a.p454m.PictureFormat;
import p007b.p452o.p453a.p454m.VideoCodec;
import p007b.p452o.p453a.p454m.WhiteBalance;
import p007b.p452o.p453a.p455n.p461t.Angles;
import p007b.p452o.p453a.p455n.p461t.Reference2;
import p007b.p452o.p453a.p455n.p463v.CameraOrchestrator;
import p007b.p452o.p453a.p455n.p463v.CameraState2;
import p007b.p452o.p453a.p455n.p463v.CameraStateOrchestrator;
import p007b.p452o.p453a.p466q.Gesture;
import p007b.p452o.p453a.p467r.WorkerHandler;
import p007b.p452o.p453a.p469t.MeteringRegions;
import p007b.p452o.p453a.p470u.Overlay;
import p007b.p452o.p453a.p471v.PictureRecorder;
import p007b.p452o.p453a.p472w.CameraPreview;
import p007b.p452o.p453a.p473x.Size3;
import p007b.p452o.p453a.p473x.SizeSelector;

/* JADX INFO: renamed from: b.o.a.n.i, reason: use source file name */
/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CameraEngine implements CameraPreview.c, PictureRecorder.a {

    /* JADX INFO: renamed from: j */
    public static final CameraLogger f13918j = new CameraLogger(CameraEngine.class.getSimpleName());

    /* JADX INFO: renamed from: k */
    public WorkerHandler f13919k;

    /* JADX INFO: renamed from: m */
    public final g f13921m;

    /* JADX INFO: renamed from: n */
    public final CameraStateOrchestrator f13922n = new CameraStateOrchestrator(new c());

    /* JADX INFO: renamed from: l */
    @VisibleForTesting
    public Handler f13920l = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b.o.a.n.i$a */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class a implements Callable<Task<Void>> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            return CameraEngine.this.mo7195R();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$b */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class b implements Callable<Task<Void>> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            return CameraEngine.this.mo7199U();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$c */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class c implements CameraOrchestrator.b {
        public c() {
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$d */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class d implements InterfaceC4357c<Void> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ CountDownLatch f13926a;

        public d(CameraEngine cameraEngine, CountDownLatch countDownLatch) {
            this.f13926a = countDownLatch;
        }

        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
        public void onComplete(@NonNull Task<Void> task) {
            this.f13926a.countDown();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$e */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class e implements Callable<Task<Void>> {
        public e() {
        }

        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            if (CameraEngine.this.mo7315z() != null && CameraEngine.this.mo7315z().m7433m()) {
                return CameraEngine.this.mo7193P();
            }
            C4358c0 c4358c0 = new C4358c0();
            c4358c0.m6026u();
            return c4358c0;
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$f */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class f implements Callable<Task<Void>> {
        public f() {
        }

        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            return CameraEngine.this.mo7196S();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$g */
    /* JADX INFO: compiled from: CameraEngine.java */
    public interface g {
    }

    /* JADX INFO: renamed from: b.o.a.n.i$h */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class h implements Thread.UncaughtExceptionHandler {
        public h(c cVar) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
            CameraEngine.m7317b(CameraEngine.this, th, true);
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$i */
    /* JADX INFO: compiled from: CameraEngine.java */
    public static class i implements Thread.UncaughtExceptionHandler {
        public i(c cVar) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
            CameraEngine.f13918j.m7159a(2, "EXCEPTION:", "In the NoOpExceptionHandler, probably while destroying.", "Thread:", thread, "Error:", th);
        }
    }

    public CameraEngine(@NonNull g gVar) {
        this.f13921m = gVar;
        m7326W(false);
    }

    /* JADX INFO: renamed from: b */
    public static void m7317b(CameraEngine cameraEngine, Throwable th, boolean z2) {
        Objects.requireNonNull(cameraEngine);
        if (z2) {
            f13918j.m7159a(3, "EXCEPTION:", "Handler thread is gone. Replacing.");
            cameraEngine.m7326W(false);
        }
        f13918j.m7159a(3, "EXCEPTION:", "Scheduling on the crash handler...");
        cameraEngine.f13920l.post(new CameraEngine2(cameraEngine, th));
    }

    /* JADX INFO: renamed from: A */
    public abstract float mo7250A();

    /* JADX INFO: renamed from: A0 */
    public abstract void mo7251A0(int i2);

    /* JADX INFO: renamed from: B */
    public abstract boolean mo7252B();

    /* JADX INFO: renamed from: B0 */
    public abstract void mo7253B0(@NonNull VideoCodec videoCodec);

    @Nullable
    /* JADX INFO: renamed from: C */
    public abstract Size3 mo7254C(@NonNull Reference2 reference2);

    /* JADX INFO: renamed from: C0 */
    public abstract void mo7255C0(int i2);

    /* JADX INFO: renamed from: D */
    public abstract int mo7256D();

    /* JADX INFO: renamed from: D0 */
    public abstract void mo7257D0(long j);

    /* JADX INFO: renamed from: E */
    public abstract int mo7258E();

    /* JADX INFO: renamed from: E0 */
    public abstract void mo7259E0(@NonNull SizeSelector sizeSelector);

    @Nullable
    /* JADX INFO: renamed from: F */
    public abstract Size3 mo7260F(@NonNull Reference2 reference2);

    /* JADX INFO: renamed from: F0 */
    public abstract void mo7190F0(@NonNull WhiteBalance whiteBalance);

    /* JADX INFO: renamed from: G */
    public abstract int mo7261G();

    /* JADX INFO: renamed from: G0 */
    public abstract void mo7191G0(float f2, @Nullable PointF[] pointFArr, boolean z2);

    @NonNull
    /* JADX INFO: renamed from: H */
    public abstract VideoCodec mo7262H();

    @NonNull
    /* JADX INFO: renamed from: H0 */
    public Task<Void> m7318H0() {
        f13918j.m7159a(1, "START:", "scheduled. State:", this.f13922n.f14028f);
        Task<Void> taskMo6022q = this.f13922n.m7368f(CameraState2.OFF, CameraState2.ENGINE, true, new CameraEngine4(this)).mo6022q(new CameraEngine3(this));
        m7319J0();
        m7320K0();
        return taskMo6022q;
    }

    /* JADX INFO: renamed from: I */
    public abstract int mo7263I();

    /* JADX INFO: renamed from: I0 */
    public abstract void mo7192I0(@Nullable Gesture gesture, @NonNull MeteringRegions meteringRegions, @NonNull PointF pointF);

    /* JADX INFO: renamed from: J */
    public abstract long mo7264J();

    @NonNull
    /* JADX INFO: renamed from: J0 */
    public final Task<Void> m7319J0() {
        return this.f13922n.m7368f(CameraState2.ENGINE, CameraState2.BIND, true, new e());
    }

    @Nullable
    /* JADX INFO: renamed from: K */
    public abstract Size3 mo7265K(@NonNull Reference2 reference2);

    @NonNull
    /* JADX INFO: renamed from: K0 */
    public final Task<Void> m7320K0() {
        return this.f13922n.m7368f(CameraState2.BIND, CameraState2.PREVIEW, true, new a());
    }

    @NonNull
    /* JADX INFO: renamed from: L */
    public abstract SizeSelector mo7266L();

    @NonNull
    /* JADX INFO: renamed from: L0 */
    public Task<Void> m7321L0(boolean z2) {
        f13918j.m7159a(1, "STOP:", "scheduled. State:", this.f13922n.f14028f);
        m7323N0(z2);
        m7322M0(z2);
        Task taskM7368f = this.f13922n.m7368f(CameraState2.ENGINE, CameraState2.OFF, !z2, new CameraEngine6(this));
        CameraEngine5 cameraEngine5 = new CameraEngine5(this);
        C4358c0 c4358c0 = (C4358c0) taskM7368f;
        Objects.requireNonNull(c4358c0);
        c4358c0.mo6012g(C4363g.f11479a, cameraEngine5);
        return c4358c0;
    }

    @NonNull
    /* JADX INFO: renamed from: M */
    public abstract WhiteBalance mo7267M();

    @NonNull
    /* JADX INFO: renamed from: M0 */
    public final Task<Void> m7322M0(boolean z2) {
        return this.f13922n.m7368f(CameraState2.BIND, CameraState2.ENGINE, !z2, new f());
    }

    /* JADX INFO: renamed from: N */
    public abstract float mo7268N();

    @NonNull
    /* JADX INFO: renamed from: N0 */
    public final Task<Void> m7323N0(boolean z2) {
        return this.f13922n.m7368f(CameraState2.PREVIEW, CameraState2.BIND, !z2, new b());
    }

    /* JADX INFO: renamed from: O */
    public final boolean m7324O() {
        boolean z2;
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        synchronized (cameraStateOrchestrator.f14009e) {
            Iterator<CameraOrchestrator.c<?>> it = cameraStateOrchestrator.f14007c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                CameraOrchestrator.c<?> next = it.next();
                if (next.f14011a.contains(" >> ") || next.f14011a.contains(" << ")) {
                    if (!next.f14012b.f20845a.mo6020o()) {
                        z2 = true;
                        break;
                    }
                }
            }
        }
        return z2;
    }

    /* JADX INFO: renamed from: O0 */
    public abstract void mo7269O0(@NonNull PictureResult.a aVar);

    @NonNull
    /* JADX INFO: renamed from: P */
    public abstract Task<Void> mo7193P();

    /* JADX INFO: renamed from: P0 */
    public abstract void mo7270P0(@NonNull PictureResult.a aVar);

    @NonNull
    /* JADX INFO: renamed from: Q */
    public abstract Task<CameraOptions> mo7194Q();

    @NonNull
    /* JADX INFO: renamed from: R */
    public abstract Task<Void> mo7195R();

    @NonNull
    /* JADX INFO: renamed from: S */
    public abstract Task<Void> mo7196S();

    @NonNull
    /* JADX INFO: renamed from: T */
    public abstract Task<Void> mo7197T();

    @NonNull
    /* JADX INFO: renamed from: U */
    public abstract Task<Void> mo7199U();

    /* JADX INFO: renamed from: V */
    public final void m7325V() {
        f13918j.m7159a(1, "onSurfaceAvailable:", "Size is", mo7315z().m7432l());
        m7319J0();
        m7320K0();
    }

    /* JADX INFO: renamed from: W */
    public final void m7326W(boolean z2) {
        WorkerHandler workerHandler = this.f13919k;
        if (workerHandler != null) {
            HandlerThread handlerThread = workerHandler.f14131e;
            if (handlerThread.isAlive()) {
                handlerThread.interrupt();
                handlerThread.quit();
            }
            WorkerHandler.f14128b.remove(workerHandler.f14130d);
        }
        WorkerHandler workerHandlerM7403b = WorkerHandler.m7403b("CameraViewEngine");
        this.f13919k = workerHandlerM7403b;
        workerHandlerM7403b.f14131e.setUncaughtExceptionHandler(new h(null));
        if (z2) {
            CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
            synchronized (cameraStateOrchestrator.f14009e) {
                HashSet hashSet = new HashSet();
                Iterator<CameraOrchestrator.c<?>> it = cameraStateOrchestrator.f14007c.iterator();
                while (it.hasNext()) {
                    hashSet.add(it.next().f14011a);
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    cameraStateOrchestrator.m7366e((String) it2.next(), 0);
                }
            }
        }
    }

    /* JADX INFO: renamed from: X */
    public void m7327X() {
        f13918j.m7159a(1, "RESTART:", "scheduled. State:", this.f13922n.f14028f);
        m7321L0(false);
        m7318H0();
    }

    @NonNull
    /* JADX INFO: renamed from: Y */
    public Task<Void> m7328Y() {
        f13918j.m7159a(1, "RESTART BIND:", "scheduled. State:", this.f13922n.f14028f);
        m7323N0(false);
        m7322M0(false);
        m7319J0();
        return m7320K0();
    }

    /* JADX INFO: renamed from: Z */
    public abstract void mo7276Z(@NonNull Audio audio);

    /* JADX INFO: renamed from: a0 */
    public abstract void mo7277a0(int i2);

    /* JADX INFO: renamed from: b0 */
    public abstract void mo7279b0(@NonNull AudioCodec audioCodec);

    /* JADX INFO: renamed from: c */
    public abstract boolean mo7205c(@NonNull Facing facing);

    /* JADX INFO: renamed from: c0 */
    public abstract void mo7280c0(long j);

    /* JADX INFO: renamed from: d */
    public final void m7329d(boolean z2, int i2) {
        CameraLogger cameraLogger = f13918j;
        cameraLogger.m7159a(1, "DESTROY:", "state:", this.f13922n.f14028f, "thread:", Thread.currentThread(), "depth:", Integer.valueOf(i2), "unrecoverably:", Boolean.valueOf(z2));
        if (z2) {
            this.f13919k.f14131e.setUncaughtExceptionHandler(new i(null));
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        m7321L0(true).mo6008c(this.f13919k.f14133g, new d(this, countDownLatch));
        try {
            if (!countDownLatch.await(6L, TimeUnit.SECONDS)) {
                cameraLogger.m7159a(3, "DESTROY: Could not destroy synchronously after 6 seconds.", "Current thread:", Thread.currentThread(), "Handler thread:", this.f13919k.f14131e);
                int i3 = i2 + 1;
                if (i3 < 2) {
                    m7326W(true);
                    cameraLogger.m7159a(3, "DESTROY: Trying again on thread:", this.f13919k.f14131e);
                    m7329d(z2, i3);
                } else {
                    cameraLogger.m7159a(2, "DESTROY: Giving up because DESTROY_RETRIES was reached.");
                }
            }
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: renamed from: d0 */
    public abstract void mo7207d0(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z2);

    @NonNull
    /* JADX INFO: renamed from: e */
    public abstract Angles mo7281e();

    /* JADX INFO: renamed from: e0 */
    public abstract void mo7282e0(@NonNull Facing facing);

    @NonNull
    /* JADX INFO: renamed from: f */
    public abstract Audio mo7283f();

    /* JADX INFO: renamed from: f0 */
    public abstract void mo7210f0(@NonNull Flash flash);

    /* JADX INFO: renamed from: g */
    public abstract int mo7284g();

    /* JADX INFO: renamed from: g0 */
    public abstract void mo7212g0(int i2);

    @NonNull
    /* JADX INFO: renamed from: h */
    public abstract AudioCodec mo7285h();

    /* JADX INFO: renamed from: h0 */
    public abstract void mo7286h0(int i2);

    /* JADX INFO: renamed from: i */
    public abstract long mo7287i();

    /* JADX INFO: renamed from: i0 */
    public abstract void mo7288i0(int i2);

    @Nullable
    /* JADX INFO: renamed from: j */
    public abstract CameraOptions mo7289j();

    /* JADX INFO: renamed from: j0 */
    public abstract void mo7290j0(int i2);

    /* JADX INFO: renamed from: k */
    public abstract float mo7291k();

    /* JADX INFO: renamed from: k0 */
    public abstract void mo7217k0(boolean z2);

    @NonNull
    /* JADX INFO: renamed from: l */
    public abstract Facing mo7292l();

    /* JADX INFO: renamed from: l0 */
    public abstract void mo7219l0(@NonNull Hdr hdr);

    @NonNull
    /* JADX INFO: renamed from: m */
    public abstract Flash mo7293m();

    /* JADX INFO: renamed from: m0 */
    public abstract void mo7221m0(@Nullable Location location);

    /* JADX INFO: renamed from: n */
    public abstract int mo7294n();

    /* JADX INFO: renamed from: n0 */
    public abstract void mo7295n0(@NonNull Mode3 mode3);

    /* JADX INFO: renamed from: o */
    public abstract int mo7296o();

    /* JADX INFO: renamed from: o0 */
    public abstract void mo7297o0(@Nullable Overlay overlay);

    /* JADX INFO: renamed from: p */
    public abstract int mo7298p();

    /* JADX INFO: renamed from: p0 */
    public abstract void mo7223p0(@NonNull PictureFormat pictureFormat);

    /* JADX INFO: renamed from: q */
    public abstract int mo7299q();

    /* JADX INFO: renamed from: q0 */
    public abstract void mo7300q0(boolean z2);

    @NonNull
    /* JADX INFO: renamed from: r */
    public abstract Hdr mo7301r();

    /* JADX INFO: renamed from: r0 */
    public abstract void mo7302r0(@NonNull SizeSelector sizeSelector);

    @Nullable
    /* JADX INFO: renamed from: s */
    public abstract Location mo7303s();

    /* JADX INFO: renamed from: s0 */
    public abstract void mo7304s0(boolean z2);

    @NonNull
    /* JADX INFO: renamed from: t */
    public abstract Mode3 mo7305t();

    /* JADX INFO: renamed from: t0 */
    public abstract void mo7224t0(boolean z2);

    @NonNull
    /* JADX INFO: renamed from: u */
    public abstract PictureFormat mo7306u();

    /* JADX INFO: renamed from: u0 */
    public abstract void mo7307u0(@NonNull CameraPreview cameraPreview);

    /* JADX INFO: renamed from: v */
    public abstract boolean mo7308v();

    /* JADX INFO: renamed from: v0 */
    public abstract void mo7225v0(float f2);

    @Nullable
    /* JADX INFO: renamed from: w */
    public abstract Size3 mo7309w(@NonNull Reference2 reference2);

    /* JADX INFO: renamed from: w0 */
    public abstract void mo7310w0(boolean z2);

    @NonNull
    /* JADX INFO: renamed from: x */
    public abstract SizeSelector mo7311x();

    /* JADX INFO: renamed from: x0 */
    public abstract void mo7312x0(@Nullable SizeSelector sizeSelector);

    /* JADX INFO: renamed from: y */
    public abstract boolean mo7313y();

    /* JADX INFO: renamed from: y0 */
    public abstract void mo7314y0(int i2);

    @Nullable
    /* JADX INFO: renamed from: z */
    public abstract CameraPreview mo7315z();

    /* JADX INFO: renamed from: z0 */
    public abstract void mo7316z0(int i2);
}
