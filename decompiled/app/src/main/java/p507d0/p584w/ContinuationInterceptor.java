package p507d0.p584w;

import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.w.d, reason: use source file name */
/* JADX INFO: compiled from: ContinuationInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ContinuationInterceptor extends CoroutineContext.Element {

    /* JADX INFO: renamed from: e */
    public static final /* synthetic */ int f25235e = 0;

    /* JADX INFO: renamed from: d0.w.d$a */
    /* JADX INFO: compiled from: ContinuationInterceptor.kt */
    public static final class a {
        public static <E extends CoroutineContext.Element> E get(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<E> key) {
            Intrinsics3.checkNotNullParameter(key, "key");
            if (!(key instanceof CoroutineContextImpl2)) {
                int i = ContinuationInterceptor.f25235e;
                if (b.f25236a != key) {
                    return null;
                }
                Objects.requireNonNull(continuationInterceptor, "null cannot be cast to non-null type E");
                return continuationInterceptor;
            }
            CoroutineContextImpl2 coroutineContextImpl2 = (CoroutineContextImpl2) key;
            if (!coroutineContextImpl2.isSubKey$kotlin_stdlib(continuationInterceptor.getKey())) {
                return null;
            }
            E e = (E) coroutineContextImpl2.tryCast$kotlin_stdlib(continuationInterceptor);
            if (e instanceof CoroutineContext.Element) {
                return e;
            }
            return null;
        }

        public static CoroutineContext minusKey(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<?> key) {
            Intrinsics3.checkNotNullParameter(key, "key");
            if (key instanceof CoroutineContextImpl2) {
                CoroutineContextImpl2 coroutineContextImpl2 = (CoroutineContextImpl2) key;
                return (!coroutineContextImpl2.isSubKey$kotlin_stdlib(continuationInterceptor.getKey()) || coroutineContextImpl2.tryCast$kotlin_stdlib(continuationInterceptor) == null) ? continuationInterceptor : CoroutineContextImpl4.f25237j;
            }
            int i = ContinuationInterceptor.f25235e;
            return b.f25236a == key ? CoroutineContextImpl4.f25237j : continuationInterceptor;
        }
    }

    /* JADX INFO: renamed from: d0.w.d$b */
    /* JADX INFO: compiled from: ContinuationInterceptor.kt */
    public static final class b implements CoroutineContext.Key<ContinuationInterceptor> {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ b f25236a = new b();
    }

    <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation);

    void releaseInterceptedContinuation(Continuation<?> continuation);
}
