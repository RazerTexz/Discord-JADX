package d0.w;

import d0.z.d.m;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function1;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes3.dex */
public abstract class b<B extends CoroutineContext.Element, E extends B> implements CoroutineContext.Key<E> {
    public final CoroutineContext.Key<?> a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1<CoroutineContext.Element, E> f3585b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.CoroutineContext$Key<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, kotlin.jvm.functions.Function1<? super kotlin.coroutines.CoroutineContext$Element, ? extends E extends B>, kotlin.jvm.functions.Function1<kotlin.coroutines.CoroutineContext$Element, E extends B>] */
    public b(CoroutineContext.Key<B> key, Function1<? super CoroutineContext.Element, ? extends E> function1) {
        m.checkNotNullParameter(key, "baseKey");
        m.checkNotNullParameter(function1, "safeCast");
        this.f3585b = function1;
        this.a = key instanceof b ? (CoroutineContext.Key<B>) ((b) key).a : key;
    }

    public final boolean isSubKey$kotlin_stdlib(CoroutineContext.Key<?> key) {
        m.checkNotNullParameter(key, "key");
        return key == this || this.a == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$Element;)TE; */
    public final CoroutineContext.Element tryCast$kotlin_stdlib(CoroutineContext.Element element) {
        m.checkNotNullParameter(element, "element");
        return (CoroutineContext.Element) this.f3585b.invoke(element);
    }
}
