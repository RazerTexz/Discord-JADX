package d0.e0.p.d;

import d0.e0.p.d.c0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.s;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;

/* compiled from: KProperty2Impl.kt */
/* loaded from: classes3.dex */
public class r<D, E, V> extends s<V> implements KProperty, Function2 {
    public final c0.b<a<D, E, V>> u;
    public final Lazy<Field> v;

    /* compiled from: KProperty2Impl.kt */
    public static final class a<D, E, V> extends s.c<V> implements KProperty.Getter, Function2 {
        public final r<D, E, V> q;

        /* JADX WARN: Multi-variable type inference failed */
        public a(r<D, E, ? extends V> rVar) {
            d0.z.d.m.checkNotNullParameter(rVar, "property");
            this.q = rVar;
        }

        @Override // d0.e0.p.d.s.a
        public r<D, E, V> getProperty() {
            return this.q;
        }

        @Override // kotlin.jvm.functions.Function2
        public V invoke(D d, E e) {
            return getProperty().get(d, e);
        }

        @Override // d0.e0.p.d.s.a
        public /* bridge */ /* synthetic */ s getProperty() {
            return getProperty();
        }
    }

    /* compiled from: KProperty2Impl.kt */
    public static final class b extends d0.z.d.o implements Function0<a<D, E, ? extends V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<D, E, V> invoke() {
            return new a<>(r.this);
        }
    }

    /* compiled from: KProperty2Impl.kt */
    public static final class c extends d0.z.d.o implements Function0<Field> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Field invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Field invoke2() {
            return r.this.c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(i iVar, n0 n0Var) {
        super(iVar, n0Var);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        c0.b<a<D, E, V>> bVarLazy = c0.lazy(new b());
        d0.z.d.m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.u = bVarLazy;
        this.v = d0.g.lazy(d0.i.PUBLICATION, new c());
    }

    public V get(D d, E e) {
        return mo112getGetter().call(d, e);
    }

    @Override // d0.e0.p.d.s, kotlin.reflect.KProperty0
    /* renamed from: getGetter */
    public /* bridge */ /* synthetic */ s.c mo112getGetter() {
        return mo112getGetter();
    }

    @Override // kotlin.jvm.functions.Function2
    public V invoke(D d, E e) {
        return get(d, e);
    }

    @Override // d0.e0.p.d.s, kotlin.reflect.KProperty0
    /* renamed from: getGetter */
    public a<D, E, V> mo112getGetter() {
        a<D, E, V> aVarInvoke = this.u.invoke();
        d0.z.d.m.checkNotNullExpressionValue(aVarInvoke, "_getter()");
        return aVarInvoke;
    }
}
