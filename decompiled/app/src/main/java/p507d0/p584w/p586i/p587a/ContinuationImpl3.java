package p507d0.p584w.p586i.p587a;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import p507d0.p584w.ContinuationInterceptor;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ContinuationImpl.kt */
/* renamed from: d0.w.i.a.d, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ContinuationImpl3 extends ContinuationImpl {
    private final CoroutineContext _context;
    private transient Continuation<Object> intercepted;

    public ContinuationImpl3(Continuation<Object> continuation, CoroutineContext coroutineContext) {
        super(continuation);
        this._context = coroutineContext;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        Intrinsics3.checkNotNull(coroutineContext);
        return coroutineContext;
    }

    public final Continuation<Object> intercepted() {
        Continuation<Object> continuationInterceptContinuation = this.intercepted;
        if (continuationInterceptContinuation == null) {
            CoroutineContext context = getContext();
            int i = ContinuationInterceptor.f25235e;
            ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) context.get(ContinuationInterceptor.b.f25236a);
            if (continuationInterceptor == null || (continuationInterceptContinuation = continuationInterceptor.interceptContinuation(this)) == null) {
                continuationInterceptContinuation = this;
            }
            this.intercepted = continuationInterceptContinuation;
        }
        return continuationInterceptContinuation;
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public void releaseIntercepted() {
        Continuation<?> continuation = this.intercepted;
        if (continuation != null && continuation != this) {
            CoroutineContext context = getContext();
            int i = ContinuationInterceptor.f25235e;
            CoroutineContext.Element element = context.get(ContinuationInterceptor.b.f25236a);
            Intrinsics3.checkNotNull(element);
            ((ContinuationInterceptor) element).releaseInterceptedContinuation(continuation);
        }
        this.intercepted = ContinuationImpl2.f25244j;
    }

    public ContinuationImpl3(Continuation<Object> continuation) {
        this(continuation, continuation != null ? continuation.getContext() : null);
    }
}
