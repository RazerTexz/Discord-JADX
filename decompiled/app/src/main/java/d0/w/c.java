package d0.w;

import d0.z.d.m;
import d0.z.d.o;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes3.dex */
public final class c implements CoroutineContext, Serializable {
    private final CoroutineContext.Element element;
    private final CoroutineContext left;

    /* compiled from: CoroutineContextImpl.kt */
    public static final class a implements Serializable {
        private static final long serialVersionUID = 0;
        private final CoroutineContext[] elements;

        /* compiled from: CoroutineContextImpl.kt */
        /* renamed from: d0.w.c$a$a, reason: collision with other inner class name */
        public static final class C0599a {
            public C0599a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        static {
            new C0599a(null);
        }

        public a(CoroutineContext[] coroutineContextArr) {
            m.checkNotNullParameter(coroutineContextArr, "elements");
            this.elements = coroutineContextArr;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.elements;
            CoroutineContext coroutineContextPlus = f.j;
            for (CoroutineContext coroutineContext : coroutineContextArr) {
                coroutineContextPlus = coroutineContextPlus.plus(coroutineContext);
            }
            return coroutineContextPlus;
        }
    }

    /* compiled from: CoroutineContextImpl.kt */
    public static final class b extends o implements Function2<String, CoroutineContext.Element, String> {
        public static final b j = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ String invoke(String str, CoroutineContext.Element element) {
            return invoke2(str, element);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(String str, CoroutineContext.Element element) {
            m.checkNotNullParameter(str, "acc");
            m.checkNotNullParameter(element, "element");
            if (str.length() == 0) {
                return element.toString();
            }
            return str + ", " + element;
        }
    }

    /* compiled from: CoroutineContextImpl.kt */
    /* renamed from: d0.w.c$c, reason: collision with other inner class name */
    public static final class C0600c extends o implements Function2<Unit, CoroutineContext.Element, Unit> {
        public final /* synthetic */ CoroutineContext[] $elements;
        public final /* synthetic */ Ref$IntRef $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0600c(CoroutineContext[] coroutineContextArr, Ref$IntRef ref$IntRef) {
            super(2);
            this.$elements = coroutineContextArr;
            this.$index = ref$IntRef;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit, CoroutineContext.Element element) {
            invoke2(unit, element);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit, CoroutineContext.Element element) {
            m.checkNotNullParameter(unit, "<anonymous parameter 0>");
            m.checkNotNullParameter(element, "element");
            CoroutineContext[] coroutineContextArr = this.$elements;
            Ref$IntRef ref$IntRef = this.$index;
            int i = ref$IntRef.element;
            ref$IntRef.element = i + 1;
            coroutineContextArr[i] = element;
        }
    }

    public c(CoroutineContext coroutineContext, CoroutineContext.Element element) {
        m.checkNotNullParameter(coroutineContext, "left");
        m.checkNotNullParameter(element, "element");
        this.left = coroutineContext;
        this.element = element;
    }

    private final Object writeReplace() {
        int iC = c();
        CoroutineContext[] coroutineContextArr = new CoroutineContext[iC];
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        fold(Unit.a, new C0600c(coroutineContextArr, ref$IntRef));
        if (ref$IntRef.element == iC) {
            return new a(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final int c() {
        int i = 2;
        c cVar = this;
        while (true) {
            CoroutineContext coroutineContext = cVar.left;
            if (!(coroutineContext instanceof c)) {
                coroutineContext = null;
            }
            cVar = (c) coroutineContext;
            if (cVar == null) {
                return i;
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        boolean zAreEqual;
        if (this != obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (cVar.c() != c()) {
                return false;
            }
            Objects.requireNonNull(cVar);
            c cVar2 = this;
            while (true) {
                CoroutineContext.Element element = cVar2.element;
                if (!m.areEqual(cVar.get(element.getKey()), element)) {
                    zAreEqual = false;
                    break;
                }
                CoroutineContext coroutineContext = cVar2.left;
                if (!(coroutineContext instanceof c)) {
                    Objects.requireNonNull(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                    CoroutineContext.Element element2 = (CoroutineContext.Element) coroutineContext;
                    zAreEqual = m.areEqual(cVar.get(element2.getKey()), element2);
                    break;
                }
                cVar2 = (c) coroutineContext;
            }
            if (!zAreEqual) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        m.checkNotNullParameter(function2, "operation");
        return function2.invoke((Object) this.left.fold(r, function2), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        m.checkNotNullParameter(key, "key");
        c cVar = this;
        while (true) {
            E e = (E) cVar.element.get(key);
            if (e != null) {
                return e;
            }
            CoroutineContext coroutineContext = cVar.left;
            if (!(coroutineContext instanceof c)) {
                return (E) coroutineContext.get(key);
            }
            cVar = (c) coroutineContext;
        }
    }

    public int hashCode() {
        return this.element.hashCode() + this.left.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        m.checkNotNullParameter(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        CoroutineContext coroutineContextMinusKey = this.left.minusKey(key);
        return coroutineContextMinusKey == this.left ? this : coroutineContextMinusKey == f.j ? this.element : new c(coroutineContextMinusKey, this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        m.checkNotNullParameter(coroutineContext, "context");
        return CoroutineContext.a.plus(this, coroutineContext);
    }

    public String toString() {
        return b.d.b.a.a.J(b.d.b.a.a.U("["), (String) fold("", b.j), "]");
    }
}
