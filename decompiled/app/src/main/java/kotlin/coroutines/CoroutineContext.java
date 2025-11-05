package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import d0.w.c;
import d0.w.d;
import d0.w.f;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes3.dex */
public interface CoroutineContext {

    /* compiled from: CoroutineContext.kt */
    public interface Element extends CoroutineContext {

        /* compiled from: CoroutineContext.kt */
        public static final class a {
            public static <R> R fold(Element element, R r, Function2<? super R, ? super Element, ? extends R> function2) {
                m.checkNotNullParameter(function2, "operation");
                return function2.invoke(r, element);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends Element> E get(Element element, Key<E> key) {
                m.checkNotNullParameter(key, "key");
                if (m.areEqual(element.getKey(), key)) {
                    return element;
                }
                return null;
            }

            public static CoroutineContext minusKey(Element element, Key<?> key) {
                m.checkNotNullParameter(key, "key");
                return m.areEqual(element.getKey(), key) ? f.j : element;
            }

            public static CoroutineContext plus(Element element, CoroutineContext coroutineContext) {
                m.checkNotNullParameter(coroutineContext, "context");
                return a.plus(element, coroutineContext);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <E extends Element> E get(Key<E> key);

        Key<?> getKey();
    }

    /* compiled from: CoroutineContext.kt */
    public interface Key<E extends Element> {
    }

    /* compiled from: CoroutineContext.kt */
    public static final class a {

        /* compiled from: CoroutineContext.kt */
        /* renamed from: kotlin.coroutines.CoroutineContext$a$a, reason: collision with other inner class name */
        public static final class C0640a extends o implements Function2<CoroutineContext, Element, CoroutineContext> {
            public static final C0640a j = new C0640a();

            public C0640a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ CoroutineContext invoke(CoroutineContext coroutineContext, Element element) {
                return invoke2(coroutineContext, element);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CoroutineContext invoke2(CoroutineContext coroutineContext, Element element) {
                c cVar;
                m.checkNotNullParameter(coroutineContext, "acc");
                m.checkNotNullParameter(element, "element");
                CoroutineContext coroutineContextMinusKey = coroutineContext.minusKey(element.getKey());
                f fVar = f.j;
                if (coroutineContextMinusKey == fVar) {
                    return element;
                }
                int i = d.e;
                d.b bVar = d.b.a;
                d dVar = (d) coroutineContextMinusKey.get(bVar);
                if (dVar == null) {
                    cVar = new c(coroutineContextMinusKey, element);
                } else {
                    CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(bVar);
                    if (coroutineContextMinusKey2 == fVar) {
                        return new c(element, dVar);
                    }
                    cVar = new c(new c(coroutineContextMinusKey2, element), dVar);
                }
                return cVar;
            }
        }

        public static CoroutineContext plus(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
            m.checkNotNullParameter(coroutineContext2, "context");
            return coroutineContext2 == f.j ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, C0640a.j);
        }
    }

    <R> R fold(R initial, Function2<? super R, ? super Element, ? extends R> operation);

    <E extends Element> E get(Key<E> key);

    CoroutineContext minusKey(Key<?> key);

    CoroutineContext plus(CoroutineContext context);
}
