package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function2;
import p507d0.p584w.ContinuationInterceptor;
import p507d0.p584w.CoroutineContextImpl3;
import p507d0.p584w.CoroutineContextImpl4;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface CoroutineContext {

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public interface Element extends CoroutineContext {

        /* JADX INFO: renamed from: kotlin.coroutines.CoroutineContext$Element$a */
        /* JADX INFO: compiled from: CoroutineContext.kt */
        public static final class C12790a {
            public static <R> R fold(Element element, R r, Function2<? super R, ? super Element, ? extends R> function2) {
                Intrinsics3.checkNotNullParameter(function2, "operation");
                return function2.invoke(r, element);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends Element> E get(Element element, Key<E> key) {
                Intrinsics3.checkNotNullParameter(key, "key");
                if (Intrinsics3.areEqual(element.getKey(), key)) {
                    return element;
                }
                return null;
            }

            public static CoroutineContext minusKey(Element element, Key<?> key) {
                Intrinsics3.checkNotNullParameter(key, "key");
                return Intrinsics3.areEqual(element.getKey(), key) ? CoroutineContextImpl4.f25237j : element;
            }

            public static CoroutineContext plus(Element element, CoroutineContext coroutineContext) {
                Intrinsics3.checkNotNullParameter(coroutineContext, "context");
                return C12791a.plus(element, coroutineContext);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <E extends Element> E get(Key<E> key);

        Key<?> getKey();
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public interface Key<E extends Element> {
    }

    /* JADX INFO: renamed from: kotlin.coroutines.CoroutineContext$a */
    /* JADX INFO: compiled from: CoroutineContext.kt */
    public static final class C12791a {

        /* JADX INFO: renamed from: kotlin.coroutines.CoroutineContext$a$a */
        /* JADX INFO: compiled from: CoroutineContext.kt */
        public static final class a extends Lambda implements Function2<CoroutineContext, Element, CoroutineContext> {

            /* JADX INFO: renamed from: j */
            public static final a f27431j = new a();

            public a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ CoroutineContext invoke(CoroutineContext coroutineContext, Element element) {
                return invoke2(coroutineContext, element);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CoroutineContext invoke2(CoroutineContext coroutineContext, Element element) {
                CoroutineContextImpl3 coroutineContextImpl3;
                Intrinsics3.checkNotNullParameter(coroutineContext, "acc");
                Intrinsics3.checkNotNullParameter(element, "element");
                CoroutineContext coroutineContextMinusKey = coroutineContext.minusKey(element.getKey());
                CoroutineContextImpl4 coroutineContextImpl4 = CoroutineContextImpl4.f25237j;
                if (coroutineContextMinusKey == coroutineContextImpl4) {
                    return element;
                }
                int i = ContinuationInterceptor.f25235e;
                ContinuationInterceptor.b bVar = ContinuationInterceptor.b.f25236a;
                ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContextMinusKey.get(bVar);
                if (continuationInterceptor == null) {
                    coroutineContextImpl3 = new CoroutineContextImpl3(coroutineContextMinusKey, element);
                } else {
                    CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(bVar);
                    if (coroutineContextMinusKey2 == coroutineContextImpl4) {
                        return new CoroutineContextImpl3(element, continuationInterceptor);
                    }
                    coroutineContextImpl3 = new CoroutineContextImpl3(new CoroutineContextImpl3(coroutineContextMinusKey2, element), continuationInterceptor);
                }
                return coroutineContextImpl3;
            }
        }

        public static CoroutineContext plus(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
            Intrinsics3.checkNotNullParameter(coroutineContext2, "context");
            return coroutineContext2 == CoroutineContextImpl4.f25237j ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, a.f27431j);
        }
    }

    <R> R fold(R initial, Function2<? super R, ? super Element, ? extends R> operation);

    <E extends Element> E get(Key<E> key);

    CoroutineContext minusKey(Key<?> key);

    CoroutineContext plus(CoroutineContext context);
}
