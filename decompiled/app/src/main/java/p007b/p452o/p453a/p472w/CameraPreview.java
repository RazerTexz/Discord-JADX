package p007b.p452o.p453a.p472w;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p455n.CameraBaseEngine;
import p007b.p452o.p453a.p455n.CameraBaseEngine2;
import p007b.p452o.p453a.p455n.CameraEngine;
import p007b.p452o.p453a.p455n.p461t.Reference2;
import p007b.p452o.p453a.p455n.p463v.CameraState2;
import p007b.p452o.p453a.p455n.p463v.CameraStateOrchestrator;
import p007b.p452o.p453a.p455n.p463v.CameraStateOrchestrator3;
import p007b.p452o.p453a.p473x.Size3;

/* compiled from: CameraPreview.java */
/* renamed from: b.o.a.w.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class CameraPreview<T extends View, Output> {

    /* renamed from: a */
    public static final CameraLogger f14206a = new CameraLogger(CameraPreview.class.getSimpleName());

    /* renamed from: b */
    public c f14207b;

    /* renamed from: c */
    public T f14208c;

    /* renamed from: d */
    public boolean f14209d;

    /* renamed from: e */
    public int f14210e;

    /* renamed from: f */
    public int f14211f;

    /* renamed from: g */
    public int f14212g;

    /* renamed from: h */
    public int f14213h;

    /* renamed from: i */
    public int f14214i;

    /* compiled from: CameraPreview.java */
    /* renamed from: b.o.a.w.a$a */
    public class a implements Runnable {

        /* renamed from: j */
        public final /* synthetic */ TaskCompletionSource f14215j;

        public a(TaskCompletionSource taskCompletionSource) {
            this.f14215j = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewMo7431k = CameraPreview.this.mo7431k();
            ViewParent parent = viewMo7431k.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(viewMo7431k);
            }
            this.f14215j.f20845a.m6024s(null);
        }
    }

    /* compiled from: CameraPreview.java */
    /* renamed from: b.o.a.w.a$b */
    public interface b {
        /* renamed from: a */
        void m7442a();
    }

    /* compiled from: CameraPreview.java */
    /* renamed from: b.o.a.w.a$c */
    public interface c {
    }

    public CameraPreview(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        this.f14208c = (T) mo7434n(context, viewGroup);
    }

    /* renamed from: e */
    public void mo7425e(@Nullable b bVar) {
    }

    /* renamed from: f */
    public final void m7426f(int i, int i2) {
        f14206a.m7159a(1, "dispatchOnSurfaceAvailable:", "w=", Integer.valueOf(i), "h=", Integer.valueOf(i2));
        this.f14210e = i;
        this.f14211f = i2;
        if (i > 0 && i2 > 0) {
            mo7425e(null);
        }
        c cVar = this.f14207b;
        if (cVar != null) {
            ((CameraEngine) cVar).m7325V();
        }
    }

    /* renamed from: g */
    public final void m7427g() {
        this.f14210e = 0;
        this.f14211f = 0;
        c cVar = this.f14207b;
        if (cVar != null) {
            CameraEngine cameraEngine = (CameraEngine) cVar;
            CameraEngine.f13918j.m7159a(1, "onSurfaceDestroyed");
            cameraEngine.m7323N0(false);
            cameraEngine.m7322M0(false);
        }
    }

    /* renamed from: h */
    public final void m7428h(int i, int i2) {
        f14206a.m7159a(1, "dispatchOnSurfaceSizeChanged:", "w=", Integer.valueOf(i), "h=", Integer.valueOf(i2));
        if (i == this.f14210e && i2 == this.f14211f) {
            return;
        }
        this.f14210e = i;
        this.f14211f = i2;
        if (i > 0 && i2 > 0) {
            mo7425e(null);
        }
        c cVar = this.f14207b;
        if (cVar != null) {
            CameraBaseEngine cameraBaseEngine = (CameraBaseEngine) cVar;
            Objects.requireNonNull(cameraBaseEngine);
            CameraEngine.f13918j.m7159a(1, "onSurfaceChanged:", "Size is", cameraBaseEngine.m7274U0(Reference2.VIEW));
            CameraStateOrchestrator cameraStateOrchestrator = cameraBaseEngine.f13922n;
            cameraStateOrchestrator.m7363b("surface changed", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.BIND, new CameraBaseEngine2(cameraBaseEngine)));
        }
    }

    @NonNull
    /* renamed from: i */
    public abstract Output mo7429i();

    @NonNull
    /* renamed from: j */
    public abstract Class<Output> mo7430j();

    @NonNull
    /* renamed from: k */
    public abstract View mo7431k();

    @NonNull
    /* renamed from: l */
    public final Size3 m7432l() {
        return new Size3(this.f14210e, this.f14211f);
    }

    /* renamed from: m */
    public final boolean m7433m() {
        return this.f14210e > 0 && this.f14211f > 0;
    }

    @NonNull
    /* renamed from: n */
    public abstract T mo7434n(@NonNull Context context, @NonNull ViewGroup viewGroup);

    @CallSuper
    /* renamed from: o */
    public void mo7435o() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            View viewMo7431k = mo7431k();
            ViewParent parent = viewMo7431k.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(viewMo7431k);
                return;
            }
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        handler.post(new a(taskCompletionSource));
        try {
            C3404f.m4303j(taskCompletionSource.f20845a);
        } catch (Exception unused) {
        }
    }

    /* renamed from: p */
    public void mo7436p() {
    }

    /* renamed from: q */
    public void mo7437q() {
    }

    /* renamed from: r */
    public void mo7438r(int i) {
        this.f14214i = i;
    }

    /* renamed from: s */
    public void m7439s(int i, int i2) {
        f14206a.m7159a(1, "setStreamSize:", "desiredW=", Integer.valueOf(i), "desiredH=", Integer.valueOf(i2));
        this.f14212g = i;
        this.f14213h = i2;
        if (i <= 0 || i2 <= 0) {
            return;
        }
        mo7425e(null);
    }

    /* renamed from: t */
    public void m7440t(@Nullable c cVar) {
        c cVar2;
        c cVar3;
        if (m7433m() && (cVar3 = this.f14207b) != null) {
            CameraEngine cameraEngine = (CameraEngine) cVar3;
            CameraEngine.f13918j.m7159a(1, "onSurfaceDestroyed");
            cameraEngine.m7323N0(false);
            cameraEngine.m7322M0(false);
        }
        this.f14207b = cVar;
        if (!m7433m() || (cVar2 = this.f14207b) == null) {
            return;
        }
        ((CameraEngine) cVar2).m7325V();
    }

    /* renamed from: u */
    public boolean mo7441u() {
        return this instanceof GlCameraPreview2;
    }
}
