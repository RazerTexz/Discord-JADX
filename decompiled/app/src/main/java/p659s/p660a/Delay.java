package p659s.p660a;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: Delay.kt */
/* renamed from: s.a.h0, reason: use source file name */
/* loaded from: classes3.dex */
public interface Delay {
    /* renamed from: c */
    void mo11195c(long j, CancellableContinuation<? super Unit> cancellableContinuation);

    /* renamed from: x */
    Job2 mo11196x(long j, Runnable runnable, CoroutineContext coroutineContext);
}
