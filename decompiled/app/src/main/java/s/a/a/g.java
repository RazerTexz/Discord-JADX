package s.a.a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.j0;
import s.a.q0;
import s.a.w1;

/* compiled from: DispatchedContinuation.kt */
/* loaded from: classes3.dex */
public final class g<T> extends j0<T> implements CoroutineStackFrame, Continuation<T> {
    public static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_reusableCancellableContinuation");
    public volatile Object _reusableCancellableContinuation;
    public Object n;
    public final CoroutineStackFrame o;
    public final Object p;
    public final CoroutineDispatcher q;
    public final Continuation<T> r;

    /* JADX WARN: Multi-variable type inference failed */
    public g(CoroutineDispatcher coroutineDispatcher, Continuation<? super T> continuation) {
        super(-1);
        this.q = coroutineDispatcher;
        this.r = continuation;
        this.n = h.a;
        this.o = continuation instanceof CoroutineStackFrame ? continuation : (Continuation<? super T>) null;
        Object objFold = getContext().fold(0, a.f3825b);
        d0.z.d.m.checkNotNull(objFold);
        this.p = objFold;
        this._reusableCancellableContinuation = null;
    }

    @Override // s.a.j0
    public void b(Object obj, Throwable th) {
        if (obj instanceof s.a.x) {
            ((s.a.x) obj).f3848b.invoke(th);
        }
    }

    @Override // s.a.j0
    public Continuation<T> d() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.r.getContext();
    }

    @Override // s.a.j0
    public Object m() {
        Object obj = this.n;
        this.n = h.a;
        return obj;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        CoroutineContext context;
        Object objB;
        CoroutineContext context2 = this.r.getContext();
        Object objV1 = b.i.a.f.e.o.f.v1(obj, null);
        if (this.q.isDispatchNeeded(context2)) {
            this.n = objV1;
            this.l = 0;
            this.q.dispatch(context2, this);
            return;
        }
        w1 w1Var = w1.f3847b;
        q0 q0VarA = w1.a();
        if (q0VarA.N()) {
            this.n = objV1;
            this.l = 0;
            q0VarA.J(this);
            return;
        }
        q0VarA.L(true);
        try {
            context = getContext();
            objB = a.b(context, this.p);
        } finally {
            try {
            } finally {
            }
        }
        try {
            this.r.resumeWith(obj);
            while (q0VarA.R()) {
            }
        } finally {
            a.a(context, objB);
        }
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("DispatchedContinuation[");
        sbU.append(this.q);
        sbU.append(", ");
        sbU.append(b.i.a.f.e.o.f.s1(this.r));
        sbU.append(']');
        return sbU.toString();
    }
}
