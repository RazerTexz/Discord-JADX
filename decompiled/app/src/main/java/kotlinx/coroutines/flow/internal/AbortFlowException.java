package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import s.a.d2.e;

/* compiled from: FlowExceptions.kt */
/* loaded from: classes3.dex */
public final class AbortFlowException extends CancellationException {
    private final e<?> owner;

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
