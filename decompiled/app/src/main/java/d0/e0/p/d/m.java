package d0.e0.p.d;

import d0.e0.p.d.c0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.s;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KMutableProperty$Setter;
import kotlin.reflect.KProperty;
import kotlin.reflect.full.IllegalCallableAccessException;

/* compiled from: KProperty2Impl.kt */
/* loaded from: classes3.dex */
public final class m<D, E, V> extends r<D, E, V> implements KProperty, Function2 {
    public final c0.b<a<D, E, V>> w;

    /* compiled from: KProperty2Impl.kt */
    public static final class a<D, E, V> extends s.d<V> implements KMutableProperty$Setter, Function3 {
        public final m<D, E, V> q;

        public a(m<D, E, V> mVar) {
            d0.z.d.m.checkNotNullParameter(mVar, "property");
            this.q = mVar;
        }

        @Override // d0.e0.p.d.s.a
        public m<D, E, V> getProperty() {
            return this.q;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) throws IllegalCallableAccessException {
            m81invoke((a<D, E, V>) obj, obj2, obj3);
            return Unit.a;
        }

        @Override // d0.e0.p.d.s.a
        public /* bridge */ /* synthetic */ s getProperty() {
            return getProperty();
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public void m81invoke(D d, E e, V v) throws IllegalCallableAccessException {
            getProperty().set(d, e, v);
        }
    }

    /* compiled from: KProperty2Impl.kt */
    public static final class b extends d0.z.d.o implements Function0<a<D, E, V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<D, E, V> invoke() {
            return new a<>(m.this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(i iVar, n0 n0Var) {
        super(iVar, n0Var);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        c0.b<a<D, E, V>> bVarLazy = c0.lazy(new b());
        d0.z.d.m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Setter(this) }");
        this.w = bVarLazy;
    }

    public a<D, E, V> getSetter() {
        a<D, E, V> aVarInvoke = this.w.invoke();
        d0.z.d.m.checkNotNullExpressionValue(aVarInvoke, "_setter()");
        return aVarInvoke;
    }

    public void set(D d, E e, V v) throws IllegalCallableAccessException {
        getSetter().call(d, e, v);
    }
}
