package p507d0.p584w;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: CoroutineContextImpl.kt */
/* renamed from: d0.w.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class CoroutineContextImpl implements CoroutineContext.Element {
    private final CoroutineContext.Key<?> key;

    public CoroutineContextImpl(CoroutineContext.Key<?> key) {
        Intrinsics3.checkNotNullParameter(key, "key");
        this.key = key;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics3.checkNotNullParameter(function2, "operation");
        return (R) CoroutineContext.Element.C12790a.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics3.checkNotNullParameter(key, "key");
        return (E) CoroutineContext.Element.C12790a.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<?> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics3.checkNotNullParameter(key, "key");
        return CoroutineContext.Element.C12790a.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        return CoroutineContext.Element.C12790a.plus(this, coroutineContext);
    }
}
