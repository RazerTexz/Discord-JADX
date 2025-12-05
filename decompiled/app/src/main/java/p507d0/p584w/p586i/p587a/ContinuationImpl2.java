package p507d0.p584w.p586i.p587a;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* compiled from: ContinuationImpl.kt */
/* renamed from: d0.w.i.a.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class ContinuationImpl2 implements Continuation<Object> {

    /* renamed from: j */
    public static final ContinuationImpl2 f25244j = new ContinuationImpl2();

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
