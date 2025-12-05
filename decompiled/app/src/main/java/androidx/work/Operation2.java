package androidx.work;

import androidx.work.Operation;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.Continuation;
import p007b.p225i.p355b.p359d.p360a.ListenableFuture8;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p585h.IntrinsicsJvm;
import p507d0.p584w.p586i.p587a.DebugProbes;
import p507d0.p592z.p594d.InlineMarker;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.CancellableContinuationImpl5;

/* compiled from: Operation.kt */
/* renamed from: androidx.work.OperationKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Operation2 {
    public static final Object await(Operation operation, Continuation<? super Operation.State.SUCCESS> continuation) throws Throwable {
        ListenableFuture8<Operation.State.SUCCESS> result = operation.getResult();
        Intrinsics3.checkExpressionValueIsNotNull(result, "result");
        if (result.isDone()) {
            try {
                return result.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        }
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        result.addListener(new ListenableFuture6(cancellableContinuationImpl5, result), DirectExecutor.INSTANCE);
        Object objM11326u = cancellableContinuationImpl5.m11326u();
        if (objM11326u != Intrinsics2.getCOROUTINE_SUSPENDED()) {
            return objM11326u;
        }
        DebugProbes.probeCoroutineSuspended(continuation);
        return objM11326u;
    }

    private static final Object await$$forInline(Operation operation, Continuation continuation) throws Throwable {
        ListenableFuture8<Operation.State.SUCCESS> result = operation.getResult();
        Intrinsics3.checkExpressionValueIsNotNull(result, "result");
        if (result.isDone()) {
            try {
                return result.get();
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
        result.addListener(new ListenableFuture6(cancellableContinuationImpl5, result), DirectExecutor.INSTANCE);
        Object objM11326u = cancellableContinuationImpl5.m11326u();
        if (objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return objM11326u;
    }
}
