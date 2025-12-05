package p659s.p660a;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Exceptions;
import p507d0.Result2;
import p507d0.Result3;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.p661a.DispatchedContinuation;
import p659s.p660a.p661a.ThreadContext;
import p659s.p660a.p666e2.Tasks4;
import p659s.p660a.p666e2.Tasks5;

/* compiled from: DispatchedTask.kt */
/* renamed from: s.a.j0, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class DispatchedTask<T> extends Tasks4 {

    /* renamed from: l */
    public int f27864l;

    public DispatchedTask(int i) {
        this.f27864l = i;
    }

    /* renamed from: b */
    public void mo11145b(Object obj, Throwable th) {
    }

    /* renamed from: d */
    public abstract Continuation<T> mo11146d();

    /* renamed from: e */
    public Throwable mo11315e(Object obj) {
        if (!(obj instanceof CompletionState2)) {
            obj = null;
        }
        CompletionState2 completionState2 = (CompletionState2) obj;
        if (completionState2 != null) {
            return completionState2.f27913b;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: j */
    public <T> T mo11316j(Object obj) {
        return obj;
    }

    /* renamed from: l */
    public final void m11317l(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            Exceptions.addSuppressed(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        Intrinsics3.checkNotNull(th);
        C3404f.m4348u0(mo11146d().getContext(), new C13052c0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    /* renamed from: m */
    public abstract Object mo11147m();

    @Override // java.lang.Runnable
    public final void run() {
        Object objM11474constructorimpl;
        Object objM11474constructorimpl2;
        Tasks5 tasks5 = this.f27829k;
        try {
            Continuation<T> continuationMo11146d = mo11146d();
            if (continuationMo11146d == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
            }
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuationMo11146d;
            Continuation<T> continuation = dispatchedContinuation.f27680r;
            CoroutineContext context = continuation.getContext();
            Object objMo11147m = mo11147m();
            Object objM11141b = ThreadContext.m11141b(context, dispatchedContinuation.f27678p);
            try {
                Throwable thMo11315e = mo11315e(objMo11147m);
                Job job = (thMo11315e == null && C3404f.m4193B0(this.f27864l)) ? (Job) context.get(Job.INSTANCE) : null;
                if (job != null && !job.mo10910a()) {
                    CancellationException cancellationExceptionMo10914q = job.mo10914q();
                    mo11145b(objMo11147m, cancellationExceptionMo10914q);
                    Result2.a aVar = Result2.f25169j;
                    continuation.resumeWith(Result2.m11474constructorimpl(Result3.createFailure(cancellationExceptionMo10914q)));
                } else if (thMo11315e != null) {
                    Result2.a aVar2 = Result2.f25169j;
                    continuation.resumeWith(Result2.m11474constructorimpl(Result3.createFailure(thMo11315e)));
                } else {
                    T tMo11316j = mo11316j(objMo11147m);
                    Result2.a aVar3 = Result2.f25169j;
                    continuation.resumeWith(Result2.m11474constructorimpl(tMo11316j));
                }
                Unit unit = Unit.f27425a;
                try {
                    Result2.a aVar4 = Result2.f25169j;
                    tasks5.mo11268f();
                    objM11474constructorimpl2 = Result2.m11474constructorimpl(unit);
                } catch (Throwable th) {
                    Result2.a aVar5 = Result2.f25169j;
                    objM11474constructorimpl2 = Result2.m11474constructorimpl(Result3.createFailure(th));
                }
                m11317l(null, Result2.m11476exceptionOrNullimpl(objM11474constructorimpl2));
            } finally {
                ThreadContext.m11140a(context, objM11141b);
            }
        } catch (Throwable th2) {
            try {
                Result2.a aVar6 = Result2.f25169j;
                tasks5.mo11268f();
                objM11474constructorimpl = Result2.m11474constructorimpl(Unit.f27425a);
            } catch (Throwable th3) {
                Result2.a aVar7 = Result2.f25169j;
                objM11474constructorimpl = Result2.m11474constructorimpl(Result3.createFailure(th3));
            }
            m11317l(th2, Result2.m11476exceptionOrNullimpl(objM11474constructorimpl));
        }
    }
}
