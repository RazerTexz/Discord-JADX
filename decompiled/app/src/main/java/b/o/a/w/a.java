package b.o.a.w;

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

/* compiled from: CameraPreview.java */
/* loaded from: classes3.dex */
public abstract class a<T extends View, Output> {
    public static final b.o.a.b a = new b.o.a.b(a.class.getSimpleName());

    /* renamed from: b, reason: collision with root package name */
    public c f1957b;
    public T c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    /* compiled from: CameraPreview.java */
    /* renamed from: b.o.a.w.a$a, reason: collision with other inner class name */
    public class RunnableC0180a implements Runnable {
        public final /* synthetic */ TaskCompletionSource j;

        public RunnableC0180a(TaskCompletionSource taskCompletionSource) {
            this.j = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewK = a.this.k();
            ViewParent parent = viewK.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(viewK);
            }
            this.j.a.s(null);
        }
    }

    /* compiled from: CameraPreview.java */
    public interface b {
        void a();
    }

    /* compiled from: CameraPreview.java */
    public interface c {
    }

    public a(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        this.c = (T) n(context, viewGroup);
    }

    public void e(@Nullable b bVar) {
    }

    public final void f(int i, int i2) {
        a.a(1, "dispatchOnSurfaceAvailable:", "w=", Integer.valueOf(i), "h=", Integer.valueOf(i2));
        this.e = i;
        this.f = i2;
        if (i > 0 && i2 > 0) {
            e(null);
        }
        c cVar = this.f1957b;
        if (cVar != null) {
            ((b.o.a.n.i) cVar).V();
        }
    }

    public final void g() {
        this.e = 0;
        this.f = 0;
        c cVar = this.f1957b;
        if (cVar != null) {
            b.o.a.n.i iVar = (b.o.a.n.i) cVar;
            b.o.a.n.i.j.a(1, "onSurfaceDestroyed");
            iVar.N0(false);
            iVar.M0(false);
        }
    }

    public final void h(int i, int i2) {
        a.a(1, "dispatchOnSurfaceSizeChanged:", "w=", Integer.valueOf(i), "h=", Integer.valueOf(i2));
        if (i == this.e && i2 == this.f) {
            return;
        }
        this.e = i;
        this.f = i2;
        if (i > 0 && i2 > 0) {
            e(null);
        }
        c cVar = this.f1957b;
        if (cVar != null) {
            b.o.a.n.g gVar = (b.o.a.n.g) cVar;
            Objects.requireNonNull(gVar);
            b.o.a.n.i.j.a(1, "onSurfaceChanged:", "Size is", gVar.U0(b.o.a.n.t.b.VIEW));
            b.o.a.n.v.f fVar = gVar.n;
            fVar.b("surface changed", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.BIND, new b.o.a.n.h(gVar)));
        }
    }

    @NonNull
    public abstract Output i();

    @NonNull
    public abstract Class<Output> j();

    @NonNull
    public abstract View k();

    @NonNull
    public final b.o.a.x.b l() {
        return new b.o.a.x.b(this.e, this.f);
    }

    public final boolean m() {
        return this.e > 0 && this.f > 0;
    }

    @NonNull
    public abstract T n(@NonNull Context context, @NonNull ViewGroup viewGroup);

    @CallSuper
    public void o() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            View viewK = k();
            ViewParent parent = viewK.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(viewK);
                return;
            }
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        handler.post(new RunnableC0180a(taskCompletionSource));
        try {
            b.i.a.f.e.o.f.j(taskCompletionSource.a);
        } catch (Exception unused) {
        }
    }

    public void p() {
    }

    public void q() {
    }

    public void r(int i) {
        this.i = i;
    }

    public void s(int i, int i2) {
        a.a(1, "setStreamSize:", "desiredW=", Integer.valueOf(i), "desiredH=", Integer.valueOf(i2));
        this.g = i;
        this.h = i2;
        if (i <= 0 || i2 <= 0) {
            return;
        }
        e(null);
    }

    public void t(@Nullable c cVar) {
        c cVar2;
        c cVar3;
        if (m() && (cVar3 = this.f1957b) != null) {
            b.o.a.n.i iVar = (b.o.a.n.i) cVar3;
            b.o.a.n.i.j.a(1, "onSurfaceDestroyed");
            iVar.N0(false);
            iVar.M0(false);
        }
        this.f1957b = cVar;
        if (!m() || (cVar2 = this.f1957b) == null) {
            return;
        }
        ((b.o.a.n.i) cVar2).V();
    }

    public boolean u() {
        return this instanceof d;
    }
}
