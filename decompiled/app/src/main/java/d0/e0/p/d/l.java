package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.c0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.s;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KMutableProperty$Setter;
import kotlin.reflect.full.IllegalCallableAccessException;

/* compiled from: KProperty1Impl.kt */
/* loaded from: classes3.dex */
public final class l<T, V> extends q<T, V> implements d0.e0.e<T, V> {
    public final c0.b<a<T, V>> w;

    /* compiled from: KProperty1Impl.kt */
    public static final class a<T, V> extends s.d<V> implements KMutableProperty$Setter, Function2 {
        public final l<T, V> q;

        public a(l<T, V> lVar) {
            d0.z.d.m.checkNotNullParameter(lVar, "property");
            this.q = lVar;
        }

        @Override // d0.e0.p.d.s.a
        public l<T, V> getProperty() {
            return this.q;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws IllegalCallableAccessException {
            m79invoke((a<T, V>) obj, obj2);
            return Unit.a;
        }

        @Override // d0.e0.p.d.s.a
        public /* bridge */ /* synthetic */ s getProperty() {
            return getProperty();
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public void m79invoke(T t, V v) throws IllegalCallableAccessException {
            getProperty().set(t, v);
        }
    }

    /* compiled from: KProperty1Impl.kt */
    public static final class b extends d0.z.d.o implements Function0<a<T, V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<T, V> invoke() {
            return new a<>(l.this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(i iVar, String str, String str2, Object obj) {
        super(iVar, str, str2, obj);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "signature");
        c0.b<a<T, V>> bVarLazy = c0.lazy(new b());
        d0.z.d.m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Setter(this) }");
        this.w = bVarLazy;
    }

    public a<T, V> getSetter() {
        a<T, V> aVarInvoke = this.w.invoke();
        d0.z.d.m.checkNotNullExpressionValue(aVarInvoke, "_setter()");
        return aVarInvoke;
    }

    public void set(T t, V v) throws IllegalCallableAccessException {
        getSetter().call(t, v);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(i iVar, n0 n0Var) {
        super(iVar, n0Var);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        c0.b<a<T, V>> bVarLazy = c0.lazy(new b());
        d0.z.d.m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Setter(this) }");
        this.w = bVarLazy;
    }
}
