package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.g;
import d0.e0.p.d.c0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.s;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* compiled from: KProperty1Impl.kt */
/* loaded from: classes3.dex */
public class q<T, V> extends s<V> implements d0.e0.g<T, V> {
    public final c0.b<a<T, V>> u;
    public final Lazy<Field> v;

    /* compiled from: KProperty1Impl.kt */
    public static final class a<T, V> extends s.c<V> implements g.a<T, V> {
        public final q<T, V> q;

        /* JADX WARN: Multi-variable type inference failed */
        public a(q<T, ? extends V> qVar) {
            d0.z.d.m.checkNotNullParameter(qVar, "property");
            this.q = qVar;
        }

        @Override // d0.e0.p.d.s.a
        public q<T, V> getProperty() {
            return this.q;
        }

        @Override // kotlin.jvm.functions.Function1
        public V invoke(T t) {
            return getProperty().get(t);
        }

        @Override // d0.e0.p.d.s.a
        public /* bridge */ /* synthetic */ s getProperty() {
            return getProperty();
        }
    }

    /* compiled from: KProperty1Impl.kt */
    public static final class b extends d0.z.d.o implements Function0<a<T, ? extends V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<T, V> invoke() {
            return new a<>(q.this);
        }
    }

    /* compiled from: KProperty1Impl.kt */
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
            return q.this.c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(i iVar, String str, String str2, Object obj) {
        super(iVar, str, str2, obj);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "signature");
        c0.b<a<T, V>> bVarLazy = c0.lazy(new b());
        d0.z.d.m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.u = bVarLazy;
        this.v = d0.g.lazy(d0.i.PUBLICATION, new c());
    }

    @Override // d0.e0.g
    public V get(T t) {
        return mo112getGetter().call(t);
    }

    @Override // d0.e0.g
    public /* bridge */ /* synthetic */ g.a getGetter() {
        return mo112getGetter();
    }

    @Override // kotlin.jvm.functions.Function1
    public V invoke(T t) {
        return get(t);
    }

    @Override // d0.e0.p.d.s, kotlin.reflect.KProperty0
    /* renamed from: getGetter */
    public /* bridge */ /* synthetic */ s.c mo112getGetter() {
        return mo112getGetter();
    }

    @Override // d0.e0.p.d.s, kotlin.reflect.KProperty0
    /* renamed from: getGetter */
    public a<T, V> mo112getGetter() {
        a<T, V> aVarInvoke = this.u.invoke();
        d0.z.d.m.checkNotNullExpressionValue(aVarInvoke, "_getter()");
        return aVarInvoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(i iVar, n0 n0Var) {
        super(iVar, n0Var);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        c0.b<a<T, V>> bVarLazy = c0.lazy(new b());
        d0.z.d.m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.u = bVarLazy;
        this.v = d0.g.lazy(d0.i.PUBLICATION, new c());
    }
}
