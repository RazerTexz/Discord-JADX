package p659s.p660a;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Job;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.p661a.DispatchedContinuation;
import p659s.p660a.p661a.DispatchedContinuation2;
import p659s.p660a.p661a.Symbol3;

/* compiled from: JobSupport.kt */
/* renamed from: s.a.o */
/* loaded from: classes3.dex */
public final class C13135o extends AbstractC13094e1<Job> {

    /* renamed from: n */
    public final CancellableContinuationImpl5<?> f27878n;

    public C13135o(Job job, CancellableContinuationImpl5<?> cancellableContinuationImpl5) {
        super(job);
        this.f27878n = cancellableContinuationImpl5;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        mo11198q(th);
        return Unit.f27425a;
    }

    @Override // p659s.p660a.CompletionHandler2
    /* renamed from: q */
    public void mo11198q(Throwable th) {
        CancellableContinuationImpl5<?> cancellableContinuationImpl5 = this.f27878n;
        J j = this.f27845m;
        Objects.requireNonNull(cancellableContinuationImpl5);
        CancellationException cancellationExceptionMo10914q = j.mo10914q();
        boolean z2 = true;
        boolean z3 = false;
        if (cancellableContinuationImpl5.f27864l == 2) {
            Continuation<?> continuation = cancellableContinuationImpl5.f27872p;
            if (!(continuation instanceof DispatchedContinuation)) {
                continuation = null;
            }
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            if (dispatchedContinuation != null) {
                while (true) {
                    Object obj = dispatchedContinuation._reusableCancellableContinuation;
                    Symbol3 symbol3 = DispatchedContinuation2.f27682b;
                    if (!Intrinsics3.areEqual(obj, symbol3)) {
                        if (obj instanceof Throwable) {
                            break;
                        } else if (DispatchedContinuation.f27675m.compareAndSet(dispatchedContinuation, obj, null)) {
                            z2 = false;
                            break;
                        }
                    } else if (DispatchedContinuation.f27675m.compareAndSet(dispatchedContinuation, symbol3, cancellationExceptionMo10914q)) {
                        break;
                    }
                }
                z3 = z2;
            }
        }
        if (z3) {
            return;
        }
        cancellableContinuationImpl5.mo10906k(cancellationExceptionMo10914q);
        cancellableContinuationImpl5.m11324s();
    }

    @Override // p659s.p660a.p661a.LockFreeLinkedList3
    public String toString() {
        StringBuilder sbM833U = outline.m833U("ChildContinuation[");
        sbM833U.append(this.f27878n);
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
