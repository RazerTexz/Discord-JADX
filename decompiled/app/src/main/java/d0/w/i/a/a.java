package d0.w.i.a;

import d0.k;
import d0.l;
import d0.z.d.m;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public abstract class a implements Continuation<Object>, CoroutineStackFrame, Serializable {
    private final Continuation<Object> completion;

    public a(Continuation<Object> continuation) {
        this.completion = continuation;
    }

    public Continuation<Unit> create(Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public CoroutineStackFrame getCallerFrame() {
        Continuation<Object> continuation = this.completion;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    public final Continuation<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return f.getStackTraceElement(this);
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object objInvokeSuspend;
        a aVar = this;
        while (true) {
            g.probeCoroutineResumed(aVar);
            Continuation<Object> continuation = aVar.completion;
            m.checkNotNull(continuation);
            try {
                objInvokeSuspend = aVar.invokeSuspend(obj);
            } catch (Throwable th) {
                k.a aVar2 = d0.k.j;
                obj = d0.k.m97constructorimpl(l.createFailure(th));
            }
            if (objInvokeSuspend == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                return;
            }
            k.a aVar3 = d0.k.j;
            obj = d0.k.m97constructorimpl(objInvokeSuspend);
            aVar.releaseIntercepted();
            if (!(continuation instanceof a)) {
                continuation.resumeWith(obj);
                return;
            }
            aVar = (a) continuation;
        }
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sbU.append(stackTraceElement);
        return sbU.toString();
    }

    public Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
