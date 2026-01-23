package p659s.p660a;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result2;
import p507d0.p584w.p585h.Intrinsics2;
import p659s.p660a.p661a.DispatchedContinuation;
import p659s.p660a.p661a.DispatchedContinuation2;
import p659s.p660a.p661a.Symbol3;

/* JADX INFO: renamed from: s.a.l, reason: use source file name */
/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class CancellableContinuationImpl5<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame {

    /* JADX INFO: renamed from: m */
    public static final AtomicIntegerFieldUpdater f27869m = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl5.class, "_decision");

    /* JADX INFO: renamed from: n */
    public static final AtomicReferenceFieldUpdater f27870n = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl5.class, Object.class, "_state");
    public volatile int _decision;
    public volatile Object _parentHandle;
    public volatile Object _state;

    /* JADX INFO: renamed from: o */
    public final CoroutineContext f27871o;

    /* JADX INFO: renamed from: p */
    public final Continuation<T> f27872p;

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl5(Continuation<? super T> continuation, int i) {
        super(i);
        this.f27872p = continuation;
        this.f27871o = continuation.getContext();
        this._decision = 0;
        this._state = CancellableContinuationImpl2.f27726j;
        this._parentHandle = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
    
        if (r3 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003e, code lost:
    
        if (r0 != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0040, code lost:
    
        mo10906k(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0043, code lost:
    
        r0 = true;
     */
    /* JADX INFO: renamed from: A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m11318A() {
        Job job;
        boolean zM11327v = m11327v();
        if (this.f27864l == 2) {
            Continuation<T> continuation = this.f27872p;
            Throwable th = null;
            if (!(continuation instanceof DispatchedContinuation)) {
                continuation = null;
            }
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            if (dispatchedContinuation != null) {
                while (true) {
                    Object obj = dispatchedContinuation._reusableCancellableContinuation;
                    Symbol3 symbol3 = DispatchedContinuation2.f27682b;
                    if (obj == symbol3) {
                        if (DispatchedContinuation.f27675m.compareAndSet(dispatchedContinuation, symbol3, this)) {
                            break;
                        }
                    } else if (obj != null) {
                        if (!(obj instanceof Throwable)) {
                            throw new IllegalStateException(outline.m881v("Inconsistent state ", obj).toString());
                        }
                        if (!DispatchedContinuation.f27675m.compareAndSet(dispatchedContinuation, obj, null)) {
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        th = (Throwable) obj;
                    }
                }
            }
        }
        if (zM11327v || ((Job2) this._parentHandle) != null || (job = (Job) this.f27872p.getContext().get(Job.INSTANCE)) == null) {
            return;
        }
        Job2 job2M4356w0 = C3404f.m4356w0(job, true, false, new C13135o(job, this), 2, null);
        this._parentHandle = job2M4356w0;
        if (!m11327v() || m11328w()) {
            return;
        }
        job2M4356w0.dispose();
        this._parentHandle = Job3.f27880j;
    }

    /* JADX INFO: renamed from: B */
    public final Symbol3 m11319B(Object obj, Object obj2, Function1<? super Throwable, Unit> function1) {
        Object obj3;
        do {
            obj3 = this._state;
            if (!(obj3 instanceof CancellableContinuationImpl7)) {
                if ((obj3 instanceof CancellableContinuationImpl8) && obj2 != null && ((CancellableContinuationImpl8) obj3).f27909d == obj2) {
                    return CancellableContinuationImpl6.f27874a;
                }
                return null;
            }
        } while (!f27870n.compareAndSet(this, obj3, m11331z((CancellableContinuationImpl7) obj3, obj, this.f27864l, function1, obj2)));
        m11324s();
        return CancellableContinuationImpl6.f27874a;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    /* JADX INFO: renamed from: a */
    public boolean mo10900a() {
        return this._state instanceof CancellableContinuationImpl7;
    }

    @Override // p659s.p660a.DispatchedTask
    /* JADX INFO: renamed from: b */
    public void mo11145b(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof CancellableContinuationImpl7) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof CompletionState2) {
                return;
            }
            if (obj2 instanceof CancellableContinuationImpl8) {
                CancellableContinuationImpl8 cancellableContinuationImpl8 = (CancellableContinuationImpl8) obj2;
                if (!(!(cancellableContinuationImpl8.f27910e != null))) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (f27870n.compareAndSet(this, obj2, CancellableContinuationImpl8.m11349a(cancellableContinuationImpl8, null, null, null, null, th, 15))) {
                    CancellableContinuationImpl4 cancellableContinuationImpl4 = cancellableContinuationImpl8.f27907b;
                    if (cancellableContinuationImpl4 != null) {
                        m11321o(cancellableContinuationImpl4, th);
                    }
                    Function1<Throwable, Unit> function1 = cancellableContinuationImpl8.f27908c;
                    if (function1 != null) {
                        m11322p(function1, th);
                        return;
                    }
                    return;
                }
            } else if (f27870n.compareAndSet(this, obj2, new CancellableContinuationImpl8(obj2, null, null, null, th, 14))) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    /* JADX INFO: renamed from: c */
    public Object mo10901c(T t, Object obj) {
        return m11319B(t, obj, null);
    }

    @Override // p659s.p660a.DispatchedTask
    /* JADX INFO: renamed from: d */
    public final Continuation<T> mo11146d() {
        return this.f27872p;
    }

    @Override // p659s.p660a.DispatchedTask
    /* JADX INFO: renamed from: e */
    public Throwable mo11315e(Object obj) {
        Throwable thMo11315e = super.mo11315e(obj);
        if (thMo11315e != null) {
            return thMo11315e;
        }
        return null;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    /* JADX INFO: renamed from: f */
    public void mo10902f(Function1<? super Throwable, Unit> function1) {
        CancellableContinuationImpl4 cancellableContinuationImpl = function1 instanceof CancellableContinuationImpl4 ? (CancellableContinuationImpl4) function1 : new CancellableContinuationImpl(function1);
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof CancellableContinuationImpl2)) {
                if (obj instanceof CancellableContinuationImpl4) {
                    m11329x(function1, obj);
                    throw null;
                }
                boolean z2 = obj instanceof CompletionState2;
                if (z2) {
                    CompletionState2 completionState2 = (CompletionState2) obj;
                    Objects.requireNonNull(completionState2);
                    if (!CompletionState2.f27912a.compareAndSet(completionState2, 0, 1)) {
                        m11329x(function1, obj);
                        throw null;
                    }
                    if (obj instanceof CompletionState) {
                        if (!z2) {
                            obj = null;
                        }
                        CompletionState2 completionState22 = (CompletionState2) obj;
                        m11320n(function1, completionState22 != null ? completionState22.f27913b : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof CancellableContinuationImpl8) {
                    CancellableContinuationImpl8 cancellableContinuationImpl8 = (CancellableContinuationImpl8) obj;
                    if (cancellableContinuationImpl8.f27907b != null) {
                        m11329x(function1, obj);
                        throw null;
                    }
                    if (cancellableContinuationImpl instanceof CancellableContinuationImpl3) {
                        return;
                    }
                    Throwable th = cancellableContinuationImpl8.f27910e;
                    if (th != null) {
                        m11320n(function1, th);
                        return;
                    } else {
                        if (f27870n.compareAndSet(this, obj, CancellableContinuationImpl8.m11349a(cancellableContinuationImpl8, null, cancellableContinuationImpl, null, null, null, 29))) {
                            return;
                        }
                    }
                } else {
                    if (cancellableContinuationImpl instanceof CancellableContinuationImpl3) {
                        return;
                    }
                    if (f27870n.compareAndSet(this, obj, new CancellableContinuationImpl8(obj, cancellableContinuationImpl, null, null, null, 28))) {
                        return;
                    }
                }
            } else if (f27870n.compareAndSet(this, obj, cancellableContinuationImpl)) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    /* JADX INFO: renamed from: g */
    public Object mo10903g(Throwable th) {
        return m11319B(new CompletionState2(th, false, 2), null, null);
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f27871o;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    /* JADX INFO: renamed from: h */
    public Object mo10904h(T t, Object obj, Function1<? super Throwable, Unit> function1) {
        return m11319B(t, null, function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    /* JADX INFO: renamed from: i */
    public void mo10905i(CoroutineDispatcher coroutineDispatcher, T t) {
        Continuation<T> continuation = this.f27872p;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        m11330y(t, (dispatchedContinuation != null ? dispatchedContinuation.f27679q : null) == coroutineDispatcher ? 4 : this.f27864l, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p659s.p660a.DispatchedTask
    /* JADX INFO: renamed from: j */
    public <T> T mo11316j(Object obj) {
        return obj instanceof CancellableContinuationImpl8 ? (T) ((CancellableContinuationImpl8) obj).f27906a : obj;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    /* JADX INFO: renamed from: k */
    public boolean mo10906k(Throwable th) {
        Object obj;
        boolean z2;
        do {
            obj = this._state;
            if (!(obj instanceof CancellableContinuationImpl7)) {
                return false;
            }
            z2 = obj instanceof CancellableContinuationImpl4;
        } while (!f27870n.compareAndSet(this, obj, new CompletionState(this, th, z2)));
        if (!z2) {
            obj = null;
        }
        CancellableContinuationImpl4 cancellableContinuationImpl4 = (CancellableContinuationImpl4) obj;
        if (cancellableContinuationImpl4 != null) {
            m11321o(cancellableContinuationImpl4, th);
        }
        m11324s();
        m11325t(this.f27864l);
        return true;
    }

    @Override // p659s.p660a.DispatchedTask
    /* JADX INFO: renamed from: m */
    public Object mo11147m() {
        return this._state;
    }

    /* JADX INFO: renamed from: n */
    public final void m11320n(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            C3404f.m4348u0(this.f27871o, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    /* JADX INFO: renamed from: o */
    public final void m11321o(CancellableContinuationImpl4 cancellableContinuationImpl4, Throwable th) {
        try {
            cancellableContinuationImpl4.mo11193a(th);
        } catch (Throwable th2) {
            C3404f.m4348u0(this.f27871o, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    /* JADX INFO: renamed from: p */
    public final void m11322p(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            C3404f.m4348u0(this.f27871o, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    /* JADX INFO: renamed from: q */
    public final void m11323q() {
        Job2 job2 = (Job2) this._parentHandle;
        if (job2 != null) {
            job2.dispose();
        }
        this._parentHandle = Job3.f27880j;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    /* JADX INFO: renamed from: r */
    public void mo10907r(Object obj) {
        m11325t(this.f27864l);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        Throwable thM11476exceptionOrNullimpl = Result2.m11476exceptionOrNullimpl(obj);
        if (thM11476exceptionOrNullimpl != null) {
            obj = new CompletionState2(thM11476exceptionOrNullimpl, false, 2);
        }
        m11330y(obj, this.f27864l, null);
    }

    /* JADX INFO: renamed from: s */
    public final void m11324s() {
        if (m11328w()) {
            return;
        }
        m11323q();
    }

    /* JADX WARN: Finally extract failed */
    /* JADX INFO: renamed from: t */
    public final void m11325t(int i) {
        boolean z2;
        while (true) {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("Already resumed".toString());
                }
                z2 = false;
            } else if (f27869m.compareAndSet(this, 0, 2)) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            return;
        }
        Continuation<T> continuationMo11146d = mo11146d();
        boolean z3 = i == 4;
        if (z3 || !(continuationMo11146d instanceof DispatchedContinuation) || C3404f.m4193B0(i) != C3404f.m4193B0(this.f27864l)) {
            C3404f.m4262Y0(this, continuationMo11146d, z3);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) continuationMo11146d).f27679q;
        CoroutineContext context = continuationMo11146d.getContext();
        if (coroutineDispatcher.isDispatchNeeded(context)) {
            coroutineDispatcher.dispatch(context, this);
            return;
        }
        C13161w1 c13161w1 = C13161w1.f27916b;
        AbstractC13142q0 abstractC13142q0M11353a = C13161w1.m11353a();
        if (abstractC13142q0M11353a.m11338N()) {
            abstractC13142q0M11353a.m11336J(this);
            return;
        }
        abstractC13142q0M11353a.m11337L(true);
        try {
            C3404f.m4262Y0(this, mo11146d(), true);
            do {
            } while (abstractC13142q0M11353a.m11340R());
        } catch (Throwable th) {
            try {
                m11317l(th, null);
            } finally {
                abstractC13142q0M11353a.m11334H(true);
            }
        }
    }

    public String toString() {
        return "CancellableContinuation(" + C3404f.m4341s1(this.f27872p) + "){" + this._state + "}@" + C3404f.m4312l0(this);
    }

    /* JADX INFO: renamed from: u */
    public final Object m11326u() {
        boolean z2;
        Job job;
        m11318A();
        while (true) {
            int i = this._decision;
            z2 = false;
            if (i != 0) {
                if (i != 2) {
                    throw new IllegalStateException("Already suspended".toString());
                }
            } else if (f27869m.compareAndSet(this, 0, 1)) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            return Intrinsics2.getCOROUTINE_SUSPENDED();
        }
        Object obj = this._state;
        if (obj instanceof CompletionState2) {
            throw ((CompletionState2) obj).f27913b;
        }
        if (!C3404f.m4193B0(this.f27864l) || (job = (Job) this.f27871o.get(Job.INSTANCE)) == null || job.mo10910a()) {
            return mo11316j(obj);
        }
        CancellationException cancellationExceptionMo10914q = job.mo10914q();
        mo11145b(obj, cancellationExceptionMo10914q);
        throw cancellationExceptionMo10914q;
    }

    /* JADX INFO: renamed from: v */
    public boolean m11327v() {
        return !(this._state instanceof CancellableContinuationImpl7);
    }

    /* JADX INFO: renamed from: w */
    public final boolean m11328w() {
        Continuation<T> continuation = this.f27872p;
        if (!(continuation instanceof DispatchedContinuation)) {
            return false;
        }
        Object obj = ((DispatchedContinuation) continuation)._reusableCancellableContinuation;
        return obj != null && (!(obj instanceof CancellableContinuationImpl5) || obj == this);
    }

    /* JADX INFO: renamed from: x */
    public final void m11329x(Function1<? super Throwable, Unit> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    /* JADX INFO: renamed from: y */
    public final void m11330y(Object obj, int i, Function1<? super Throwable, Unit> function1) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof CancellableContinuationImpl7)) {
                if (obj2 instanceof CompletionState) {
                    CompletionState completionState = (CompletionState) obj2;
                    Objects.requireNonNull(completionState);
                    if (CompletionState.f27875c.compareAndSet(completionState, 0, 1)) {
                        if (function1 != null) {
                            m11322p(function1, completionState.f27913b);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(outline.m881v("Already resumed, but proposed with update ", obj).toString());
            }
        } while (!f27870n.compareAndSet(this, obj2, m11331z((CancellableContinuationImpl7) obj2, obj, i, function1, null)));
        m11324s();
        m11325t(i);
    }

    /* JADX INFO: renamed from: z */
    public final Object m11331z(CancellableContinuationImpl7 cancellableContinuationImpl7, Object obj, int i, Function1<? super Throwable, Unit> function1, Object obj2) {
        if (obj instanceof CompletionState2) {
            return obj;
        }
        if (!C3404f.m4193B0(i) && obj2 == null) {
            return obj;
        }
        if (function1 == null && ((!(cancellableContinuationImpl7 instanceof CancellableContinuationImpl4) || (cancellableContinuationImpl7 instanceof CancellableContinuationImpl3)) && obj2 == null)) {
            return obj;
        }
        if (!(cancellableContinuationImpl7 instanceof CancellableContinuationImpl4)) {
            cancellableContinuationImpl7 = null;
        }
        return new CancellableContinuationImpl8(obj, (CancellableContinuationImpl4) cancellableContinuationImpl7, function1, obj2, null, 16);
    }
}
