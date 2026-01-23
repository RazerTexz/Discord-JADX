package p507d0.p584w.p586i.p587a;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import p507d0.p584w.CoroutineContextImpl4;

/* JADX INFO: renamed from: d0.w.i.a.i, reason: use source file name */
/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ContinuationImpl4 extends ContinuationImpl {
    public ContinuationImpl4(Continuation<Object> continuation) {
        super(continuation);
        if (continuation != null) {
            if (!(continuation.getContext() == CoroutineContextImpl4.f25237j)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return CoroutineContextImpl4.f25237j;
    }
}
