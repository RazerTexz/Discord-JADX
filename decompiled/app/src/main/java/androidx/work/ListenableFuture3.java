package androidx.work;

import androidx.annotation.RestrictTo;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.Continuation;
import p007b.p225i.p355b.p359d.p360a.ListenableFuture8;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p585h.IntrinsicsJvm;
import p507d0.p584w.p586i.p587a.DebugProbes;
import p507d0.p592z.p594d.InlineMarker;
import p659s.p660a.CancellableContinuationImpl5;

/* JADX INFO: renamed from: androidx.work.ListenableFutureKt, reason: use source file name */
/* JADX INFO: compiled from: ListenableFuture.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ListenableFuture3 {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <R> Object await(ListenableFuture8<R> listenableFuture8, Continuation<? super R> continuation) throws Throwable {
        if (listenableFuture8.isDone()) {
            try {
                return listenableFuture8.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        }
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        listenableFuture8.addListener(new ListenableFuture4(cancellableContinuationImpl5, listenableFuture8), DirectExecutor.INSTANCE);
        Object objM11326u = cancellableContinuationImpl5.m11326u();
        if (objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objM11326u;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private static final Object await$$forInline(ListenableFuture8 listenableFuture8, Continuation continuation) throws Throwable {
        if (listenableFuture8.isDone()) {
            try {
                return listenableFuture8.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        }
        InlineMarker.mark(0);
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        listenableFuture8.addListener(new ListenableFuture4(cancellableContinuationImpl5, listenableFuture8), DirectExecutor.INSTANCE);
        Object objM11326u = cancellableContinuationImpl5.m11326u();
        if (objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return objM11326u;
    }
}
