package androidx.activity.contextaware;

import android.content.Context;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p585h.IntrinsicsJvm;
import p507d0.p584w.p586i.p587a.DebugProbes;
import p507d0.p592z.p594d.InlineMarker;
import p659s.p660a.CancellableContinuationImpl5;

/* JADX INFO: renamed from: androidx.activity.contextaware.ContextAwareKt, reason: use source file name */
/* JADX INFO: compiled from: ContextAware.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ContextAware2 {
    public static final <R> Object withContextAvailable(ContextAware contextAware, Function1<? super Context, ? extends R> function1, Continuation<? super R> continuation) {
        Context contextPeekAvailableContext = contextAware.peekAvailableContext();
        if (contextPeekAvailableContext != null) {
            return function1.invoke(contextPeekAvailableContext);
        }
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.m11318A();
        ContextAware3 contextAware3 = new ContextAware3(cancellableContinuationImpl5, contextAware, function1);
        contextAware.addOnContextAvailableListener(contextAware3);
        cancellableContinuationImpl5.mo10902f(new ContextAware4(contextAware3, contextAware, function1));
        Object objM11326u = cancellableContinuationImpl5.m11326u();
        if (objM11326u != Intrinsics2.getCOROUTINE_SUSPENDED()) {
            return objM11326u;
        }
        DebugProbes.probeCoroutineSuspended(continuation);
        return objM11326u;
    }

    private static final Object withContextAvailable$$forInline(ContextAware contextAware, Function1 function1, Continuation continuation) {
        Context contextPeekAvailableContext = contextAware.peekAvailableContext();
        if (contextPeekAvailableContext != null) {
            return function1.invoke(contextPeekAvailableContext);
        }
        InlineMarker.mark(0);
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.m11318A();
        ContextAware3 contextAware3 = new ContextAware3(cancellableContinuationImpl5, contextAware, function1);
        contextAware.addOnContextAvailableListener(contextAware3);
        cancellableContinuationImpl5.mo10902f(new ContextAware4(contextAware3, contextAware, function1));
        Object objM11326u = cancellableContinuationImpl5.m11326u();
        if (objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return objM11326u;
    }
}
