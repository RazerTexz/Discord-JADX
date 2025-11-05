package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.w.a;
import d0.w.b;
import d0.w.d;
import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import s.a.a.g;
import s.a.a0;
import s.a.l;

/* compiled from: CoroutineDispatcher.kt */
/* loaded from: classes3.dex */
public abstract class CoroutineDispatcher extends a implements d {

    /* renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: CoroutineDispatcher.kt */
    /* renamed from: kotlinx.coroutines.CoroutineDispatcher$a, reason: from kotlin metadata */
    public static final class Companion extends b<d, CoroutineDispatcher> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super(d.b.a, a0.j);
            int i = d.e;
        }
    }

    public CoroutineDispatcher() {
        super(d.b.a);
    }

    public abstract void dispatch(CoroutineContext context, Runnable block);

    public void dispatchYield(CoroutineContext context, Runnable block) {
        dispatch(context, block);
    }

    @Override // d0.w.a, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) d.a.get(this, key);
    }

    @Override // d0.w.d
    public final <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation) {
        return new g(this, continuation);
    }

    public boolean isDispatchNeeded(CoroutineContext context) {
        return true;
    }

    @Override // d0.w.a, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return d.a.minusKey(this, key);
    }

    public final CoroutineDispatcher plus(CoroutineDispatcher other) {
        return other;
    }

    @Override // d0.w.d
    public void releaseInterceptedContinuation(Continuation<?> continuation) {
        Objects.requireNonNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        Object obj = ((g) continuation)._reusableCancellableContinuation;
        if (!(obj instanceof l)) {
            obj = null;
        }
        l lVar = (l) obj;
        if (lVar != null) {
            lVar.q();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + MentionUtilsKt.MENTIONS_CHAR + f.l0(this);
    }
}
