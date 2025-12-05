package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: CancellableContinuation.kt */
/* loaded from: classes3.dex */
public interface CancellableContinuation<T> extends Continuation<T> {
    /* renamed from: a */
    boolean mo10900a();

    /* renamed from: c */
    Object mo10901c(T value, Object idempotent);

    /* renamed from: f */
    void mo10902f(Function1<? super Throwable, Unit> handler);

    /* renamed from: g */
    Object mo10903g(Throwable exception);

    /* renamed from: h */
    Object mo10904h(T value, Object idempotent, Function1<? super Throwable, Unit> onCancellation);

    /* renamed from: i */
    void mo10905i(CoroutineDispatcher coroutineDispatcher, T t);

    /* renamed from: k */
    boolean mo10906k(Throwable cause);

    /* renamed from: r */
    void mo10907r(Object token);
}
