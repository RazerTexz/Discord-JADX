package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;

/* compiled from: FlowExceptions.kt */
/* renamed from: kotlinx.coroutines.flow.internal.ChildCancelledException, reason: use source file name */
/* loaded from: classes3.dex */
public final class FlowExceptions2 extends CancellationException {
    public FlowExceptions2() {
        super("Child of the scoped flow was cancelled");
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
