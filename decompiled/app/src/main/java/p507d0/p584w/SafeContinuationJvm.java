package p507d0.p584w;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Result2;
import p507d0.p584w.p585h.Intrinsics;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SafeContinuationJvm.kt */
/* renamed from: d0.w.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class SafeContinuationJvm<T> implements Continuation<T>, CoroutineStackFrame {

    /* renamed from: j */
    @Deprecated
    public static final AtomicReferenceFieldUpdater<SafeContinuationJvm<?>, Object> f25238j;

    /* renamed from: k */
    public final Continuation<T> f25239k;
    public volatile Object result;

    /* compiled from: SafeContinuationJvm.kt */
    /* renamed from: d0.w.g$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        f25238j = AtomicReferenceFieldUpdater.newUpdater(SafeContinuationJvm.class, Object.class, "result");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeContinuationJvm(Continuation<? super T> continuation, Object obj) {
        Intrinsics3.checkNotNullParameter(continuation, "delegate");
        this.f25239k = continuation;
        this.result = obj;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f25239k.getContext();
    }

    public final Object getOrThrow() throws Throwable {
        Object obj = this.result;
        Intrinsics intrinsics = Intrinsics.UNDECIDED;
        if (obj == intrinsics) {
            if (f25238j.compareAndSet(this, intrinsics, Intrinsics2.getCOROUTINE_SUSPENDED())) {
                return Intrinsics2.getCOROUTINE_SUSPENDED();
            }
            obj = this.result;
        }
        if (obj == Intrinsics.RESUMED) {
            return Intrinsics2.getCOROUTINE_SUSPENDED();
        }
        if (obj instanceof Result2.b) {
            throw ((Result2.b) obj).exception;
        }
        return obj;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            Intrinsics intrinsics = Intrinsics.UNDECIDED;
            if (obj2 == intrinsics) {
                if (f25238j.compareAndSet(this, intrinsics, obj)) {
                    return;
                }
            } else {
                if (obj2 != Intrinsics2.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (f25238j.compareAndSet(this, Intrinsics2.getCOROUTINE_SUSPENDED(), Intrinsics.RESUMED)) {
                    this.f25239k.resumeWith(obj);
                    return;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("SafeContinuation for ");
        sbM833U.append(this.f25239k);
        return sbM833U.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SafeContinuationJvm(Continuation<? super T> continuation) {
        this(continuation, Intrinsics.UNDECIDED);
        Intrinsics3.checkNotNullParameter(continuation, "delegate");
    }
}
