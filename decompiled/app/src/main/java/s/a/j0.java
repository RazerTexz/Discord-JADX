package s.a;

import d0.k;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import s.a.a.a;

/* compiled from: DispatchedTask.kt */
/* loaded from: classes3.dex */
public abstract class j0<T> extends s.a.e2.h {
    public int l;

    public j0(int i) {
        this.l = i;
    }

    public void b(Object obj, Throwable th) {
    }

    public abstract Continuation<T> d();

    public Throwable e(Object obj) {
        if (!(obj instanceof w)) {
            obj = null;
        }
        w wVar = (w) obj;
        if (wVar != null) {
            return wVar.f3846b;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T j(Object obj) {
        return obj;
    }

    public final void l(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            d0.b.addSuppressed(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        d0.z.d.m.checkNotNull(th);
        b.i.a.f.e.o.f.u0(d().getContext(), new c0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object m();

    @Override // java.lang.Runnable
    public final void run() {
        Object objM97constructorimpl;
        Object objM97constructorimpl2;
        s.a.e2.i iVar = this.k;
        try {
            Continuation<T> continuationD = d();
            if (continuationD == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
            }
            s.a.a.g gVar = (s.a.a.g) continuationD;
            Continuation<T> continuation = gVar.r;
            CoroutineContext context = continuation.getContext();
            Object objM = m();
            Object objB = a.b(context, gVar.p);
            try {
                Throwable thE = e(objM);
                Job job = (thE == null && b.i.a.f.e.o.f.B0(this.l)) ? (Job) context.get(Job.INSTANCE) : null;
                if (job != null && !job.a()) {
                    CancellationException cancellationExceptionQ = job.q();
                    b(objM, cancellationExceptionQ);
                    k.a aVar = d0.k.j;
                    continuation.resumeWith(d0.k.m97constructorimpl(d0.l.createFailure(cancellationExceptionQ)));
                } else if (thE != null) {
                    k.a aVar2 = d0.k.j;
                    continuation.resumeWith(d0.k.m97constructorimpl(d0.l.createFailure(thE)));
                } else {
                    T tJ = j(objM);
                    k.a aVar3 = d0.k.j;
                    continuation.resumeWith(d0.k.m97constructorimpl(tJ));
                }
                Unit unit = Unit.a;
                try {
                    k.a aVar4 = d0.k.j;
                    iVar.f();
                    objM97constructorimpl2 = d0.k.m97constructorimpl(unit);
                } catch (Throwable th) {
                    k.a aVar5 = d0.k.j;
                    objM97constructorimpl2 = d0.k.m97constructorimpl(d0.l.createFailure(th));
                }
                l(null, d0.k.m99exceptionOrNullimpl(objM97constructorimpl2));
            } finally {
                a.a(context, objB);
            }
        } catch (Throwable th2) {
            try {
                k.a aVar6 = d0.k.j;
                iVar.f();
                objM97constructorimpl = d0.k.m97constructorimpl(Unit.a);
            } catch (Throwable th3) {
                k.a aVar7 = d0.k.j;
                objM97constructorimpl = d0.k.m97constructorimpl(d0.l.createFailure(th3));
            }
            l(th2, d0.k.m99exceptionOrNullimpl(objM97constructorimpl));
        }
    }
}
