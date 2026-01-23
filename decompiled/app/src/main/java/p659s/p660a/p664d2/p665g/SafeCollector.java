package p659s.p660a.p664d2.p665g;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: s.a.d2.g.c, reason: use source file name */
/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SafeCollector implements CoroutineContext.Element {

    /* JADX INFO: renamed from: j */
    public static final a f27788j = new a(null);

    /* JADX INFO: renamed from: k */
    public final Throwable f27789k;

    /* JADX INFO: renamed from: s.a.d2.g.c$a */
    /* JADX INFO: compiled from: SafeCollector.kt */
    public static final class a implements CoroutineContext.Key<SafeCollector> {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public SafeCollector(Throwable th) {
        this.f27789k = th;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) CoroutineContext.Element.C12790a.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) CoroutineContext.Element.C12790a.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<?> getKey() {
        return f27788j;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return CoroutineContext.Element.C12790a.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.C12790a.plus(this, coroutineContext);
    }
}
