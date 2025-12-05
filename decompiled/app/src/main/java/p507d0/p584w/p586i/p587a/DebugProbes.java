package p507d0.p584w.p586i.p587a;

import kotlin.coroutines.Continuation;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: DebugProbes.kt */
/* renamed from: d0.w.i.a.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class DebugProbes {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<T> probeCoroutineCreated(Continuation<? super T> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return continuation;
    }

    public static final void probeCoroutineResumed(Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "frame");
    }

    public static final void probeCoroutineSuspended(Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "frame");
    }
}
