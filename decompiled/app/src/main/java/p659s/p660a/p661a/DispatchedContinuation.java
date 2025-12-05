package p659s.p660a.p661a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.CoroutineDispatcher;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.AbstractC13142q0;
import p659s.p660a.C13161w1;
import p659s.p660a.CompletionState3;
import p659s.p660a.DispatchedTask;

/* compiled from: DispatchedContinuation.kt */
/* renamed from: s.a.a.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {

    /* renamed from: m */
    public static final AtomicReferenceFieldUpdater f27675m = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    public volatile Object _reusableCancellableContinuation;

    /* renamed from: n */
    public Object f27676n;

    /* renamed from: o */
    public final CoroutineStackFrame f27677o;

    /* renamed from: p */
    public final Object f27678p;

    /* renamed from: q */
    public final CoroutineDispatcher f27679q;

    /* renamed from: r */
    public final Continuation<T> f27680r;

    /* JADX WARN: Multi-variable type inference failed */
    public DispatchedContinuation(CoroutineDispatcher coroutineDispatcher, Continuation<? super T> continuation) {
        super(-1);
        this.f27679q = coroutineDispatcher;
        this.f27680r = continuation;
        this.f27676n = DispatchedContinuation2.f27681a;
        this.f27677o = continuation instanceof CoroutineStackFrame ? continuation : (Continuation<? super T>) null;
        Object objFold = getContext().fold(0, ThreadContext.f27659b);
        Intrinsics3.checkNotNull(objFold);
        this.f27678p = objFold;
        this._reusableCancellableContinuation = null;
    }

    @Override // p659s.p660a.DispatchedTask
    /* renamed from: b */
    public void mo11145b(Object obj, Throwable th) {
        if (obj instanceof CompletionState3) {
            ((CompletionState3) obj).f27918b.invoke(th);
        }
    }

    @Override // p659s.p660a.DispatchedTask
    /* renamed from: d */
    public Continuation<T> mo11146d() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f27680r.getContext();
    }

    @Override // p659s.p660a.DispatchedTask
    /* renamed from: m */
    public Object mo11147m() {
        Object obj = this.f27676n;
        this.f27676n = DispatchedContinuation2.f27681a;
        return obj;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        CoroutineContext context;
        Object objM11141b;
        CoroutineContext context2 = this.f27680r.getContext();
        Object objM4353v1 = C3404f.m4353v1(obj, null);
        if (this.f27679q.isDispatchNeeded(context2)) {
            this.f27676n = objM4353v1;
            this.f27864l = 0;
            this.f27679q.dispatch(context2, this);
            return;
        }
        C13161w1 c13161w1 = C13161w1.f27916b;
        AbstractC13142q0 abstractC13142q0M11353a = C13161w1.m11353a();
        if (abstractC13142q0M11353a.m11338N()) {
            this.f27676n = objM4353v1;
            this.f27864l = 0;
            abstractC13142q0M11353a.m11336J(this);
            return;
        }
        abstractC13142q0M11353a.m11337L(true);
        try {
            context = getContext();
            objM11141b = ThreadContext.m11141b(context, this.f27678p);
        } finally {
            try {
            } finally {
            }
        }
        try {
            this.f27680r.resumeWith(obj);
            while (abstractC13142q0M11353a.m11340R()) {
            }
        } finally {
            ThreadContext.m11140a(context, objM11141b);
        }
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("DispatchedContinuation[");
        sbM833U.append(this.f27679q);
        sbM833U.append(", ");
        sbM833U.append(C3404f.m4341s1(this.f27680r));
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
