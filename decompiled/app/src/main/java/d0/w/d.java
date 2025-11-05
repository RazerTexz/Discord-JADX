package d0.w;

import d0.z.d.m;
import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* compiled from: ContinuationInterceptor.kt */
/* loaded from: classes3.dex */
public interface d extends CoroutineContext.Element {
    public static final /* synthetic */ int e = 0;

    /* compiled from: ContinuationInterceptor.kt */
    public static final class a {
        public static <E extends CoroutineContext.Element> E get(d dVar, CoroutineContext.Key<E> key) {
            m.checkNotNullParameter(key, "key");
            if (!(key instanceof d0.w.b)) {
                int i = d.e;
                if (b.a != key) {
                    return null;
                }
                Objects.requireNonNull(dVar, "null cannot be cast to non-null type E");
                return dVar;
            }
            d0.w.b bVar = (d0.w.b) key;
            if (!bVar.isSubKey$kotlin_stdlib(dVar.getKey())) {
                return null;
            }
            E e = (E) bVar.tryCast$kotlin_stdlib(dVar);
            if (e instanceof CoroutineContext.Element) {
                return e;
            }
            return null;
        }

        public static CoroutineContext minusKey(d dVar, CoroutineContext.Key<?> key) {
            m.checkNotNullParameter(key, "key");
            if (key instanceof d0.w.b) {
                d0.w.b bVar = (d0.w.b) key;
                return (!bVar.isSubKey$kotlin_stdlib(dVar.getKey()) || bVar.tryCast$kotlin_stdlib(dVar) == null) ? dVar : f.j;
            }
            int i = d.e;
            return b.a == key ? f.j : dVar;
        }
    }

    /* compiled from: ContinuationInterceptor.kt */
    public static final class b implements CoroutineContext.Key<d> {
        public static final /* synthetic */ b a = new b();
    }

    <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation);

    void releaseInterceptedContinuation(Continuation<?> continuation);
}
