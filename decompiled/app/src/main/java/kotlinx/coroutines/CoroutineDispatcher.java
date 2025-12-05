package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.chat.input.MentionUtils;
import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p584w.ContinuationInterceptor;
import p507d0.p584w.CoroutineContextImpl;
import p507d0.p584w.CoroutineContextImpl2;
import p659s.p660a.CancellableContinuationImpl5;
import p659s.p660a.CoroutineDispatcher2;
import p659s.p660a.p661a.DispatchedContinuation;

/* compiled from: CoroutineDispatcher.kt */
/* loaded from: classes3.dex */
public abstract class CoroutineDispatcher extends CoroutineContextImpl implements ContinuationInterceptor {

    /* renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: CoroutineDispatcher.kt */
    /* renamed from: kotlinx.coroutines.CoroutineDispatcher$a, reason: from kotlin metadata */
    public static final class Companion extends CoroutineContextImpl2<ContinuationInterceptor, CoroutineDispatcher> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super(ContinuationInterceptor.b.f25236a, CoroutineDispatcher2.f27711j);
            int i = ContinuationInterceptor.f25235e;
        }
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.b.f25236a);
    }

    public abstract void dispatch(CoroutineContext context, Runnable block);

    public void dispatchYield(CoroutineContext context, Runnable block) {
        dispatch(context, block);
    }

    @Override // p507d0.p584w.CoroutineContextImpl, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) ContinuationInterceptor.a.get(this, key);
    }

    @Override // p507d0.p584w.ContinuationInterceptor
    public final <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation) {
        return new DispatchedContinuation(this, continuation);
    }

    public boolean isDispatchNeeded(CoroutineContext context) {
        return true;
    }

    @Override // p507d0.p584w.CoroutineContextImpl, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return ContinuationInterceptor.a.minusKey(this, key);
    }

    public final CoroutineDispatcher plus(CoroutineDispatcher other) {
        return other;
    }

    @Override // p507d0.p584w.ContinuationInterceptor
    public void releaseInterceptedContinuation(Continuation<?> continuation) {
        Objects.requireNonNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        Object obj = ((DispatchedContinuation) continuation)._reusableCancellableContinuation;
        if (!(obj instanceof CancellableContinuationImpl5)) {
            obj = null;
        }
        CancellableContinuationImpl5 cancellableContinuationImpl5 = (CancellableContinuationImpl5) obj;
        if (cancellableContinuationImpl5 != null) {
            cancellableContinuationImpl5.m11323q();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + MentionUtils.MENTIONS_CHAR + C3404f.m4312l0(this);
    }
}
