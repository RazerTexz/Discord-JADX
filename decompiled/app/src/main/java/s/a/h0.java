package s.a;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: Delay.kt */
/* loaded from: classes3.dex */
public interface h0 {
    void c(long j, CancellableContinuation<? super Unit> cancellableContinuation);

    m0 x(long j, Runnable runnable, CoroutineContext coroutineContext);
}
