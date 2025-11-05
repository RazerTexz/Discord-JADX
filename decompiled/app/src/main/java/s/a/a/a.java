package s.a.a;

import java.util.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import s.a.v1;

/* compiled from: ThreadContext.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final t a = new t("ZERO");

    /* renamed from: b, reason: collision with root package name */
    public static final Function2<Object, CoroutineContext.Element, Object> f3825b = b.j;
    public static final Function2<v1<?>, CoroutineContext.Element, v1<?>> c = c.j;
    public static final Function2<x, CoroutineContext.Element, x> d = C0644a.k;
    public static final Function2<x, CoroutineContext.Element, x> e = C0644a.j;

    /* compiled from: kotlin-style lambda group */
    /* renamed from: s.a.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0644a extends d0.z.d.o implements Function2<x, CoroutineContext.Element, x> {
        public static final C0644a j = new C0644a(0);
        public static final C0644a k = new C0644a(1);
        public final /* synthetic */ int l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0644a(int i) {
            super(2);
            this.l = i;
        }

        @Override // kotlin.jvm.functions.Function2
        public final x invoke(x xVar, CoroutineContext.Element element) {
            int i = this.l;
            if (i == 0) {
                x xVar2 = xVar;
                CoroutineContext.Element element2 = element;
                if (element2 instanceof v1) {
                    CoroutineContext coroutineContext = xVar2.c;
                    Object[] objArr = xVar2.a;
                    int i2 = xVar2.f3832b;
                    xVar2.f3832b = i2 + 1;
                    ((v1) element2).y(coroutineContext, objArr[i2]);
                }
                return xVar2;
            }
            if (i != 1) {
                throw null;
            }
            x xVar3 = xVar;
            CoroutineContext.Element element3 = element;
            if (element3 instanceof v1) {
                Object objC = ((v1) element3).C(xVar3.c);
                Object[] objArr2 = xVar3.a;
                int i3 = xVar3.f3832b;
                xVar3.f3832b = i3 + 1;
                objArr2[i3] = objC;
            }
            return xVar3;
        }
    }

    /* compiled from: ThreadContext.kt */
    public static final class b extends d0.z.d.o implements Function2<Object, CoroutineContext.Element, Object> {
        public static final b j = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(Object obj, CoroutineContext.Element element) {
            CoroutineContext.Element element2 = element;
            if (!(element2 instanceof v1)) {
                return obj;
            }
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? element2 : Integer.valueOf(iIntValue + 1);
        }
    }

    /* compiled from: ThreadContext.kt */
    public static final class c extends d0.z.d.o implements Function2<v1<?>, CoroutineContext.Element, v1<?>> {
        public static final c j = new c();

        public c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public v1<?> invoke(v1<?> v1Var, CoroutineContext.Element element) {
            v1<?> v1Var2 = v1Var;
            CoroutineContext.Element element2 = element;
            if (v1Var2 != null) {
                return v1Var2;
            }
            if (!(element2 instanceof v1)) {
                element2 = null;
            }
            return (v1) element2;
        }
    }

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj == a) {
            return;
        }
        if (obj instanceof x) {
            ((x) obj).f3832b = 0;
            coroutineContext.fold(obj, e);
        } else {
            Object objFold = coroutineContext.fold(null, c);
            Objects.requireNonNull(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((v1) objFold).y(coroutineContext, obj);
        }
    }

    public static final Object b(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = coroutineContext.fold(0, f3825b);
            d0.z.d.m.checkNotNull(obj);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new x(coroutineContext, ((Number) obj).intValue()), d);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((v1) obj).C(coroutineContext);
    }
}
