package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.c0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.s;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.full.IllegalCallableAccessException;

/* compiled from: KProperty0Impl.kt */
/* loaded from: classes3.dex */
public final class k<V> extends p<V> implements KMutableProperty0<V> {
    public final c0.b<a<V>> w;

    /* compiled from: KProperty0Impl.kt */
    public static final class a<R> extends s.d<R> implements KMutableProperty0.Setter<R> {
        public final k<R> q;

        public a(k<R> kVar) {
            d0.z.d.m.checkNotNullParameter(kVar, "property");
            this.q = kVar;
        }

        @Override // d0.e0.p.d.s.a
        public k<R> getProperty() {
            return this.q;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) throws IllegalCallableAccessException {
            invoke2((a<R>) obj);
            return Unit.a;
        }

        @Override // d0.e0.p.d.s.a
        public /* bridge */ /* synthetic */ s getProperty() {
            return getProperty();
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(R r) throws IllegalCallableAccessException {
            getProperty().set(r);
        }
    }

    /* compiled from: KProperty0Impl.kt */
    public static final class b extends d0.z.d.o implements Function0<a<V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<V> invoke() {
            return new a<>(k.this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(i iVar, n0 n0Var) {
        super(iVar, n0Var);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        c0.b<a<V>> bVarLazy = c0.lazy(new b());
        d0.z.d.m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Setter(this) }");
        this.w = bVarLazy;
    }

    @Override // kotlin.reflect.KMutableProperty0
    /* renamed from: getSetter */
    public /* bridge */ /* synthetic */ KMutableProperty0.Setter mo113getSetter() {
        return mo113getSetter();
    }

    public void set(V v) throws IllegalCallableAccessException {
        mo113getSetter().call(v);
    }

    @Override // kotlin.reflect.KMutableProperty0
    /* renamed from: getSetter */
    public a<V> mo113getSetter() {
        a<V> aVarInvoke = this.w.invoke();
        d0.z.d.m.checkNotNullExpressionValue(aVarInvoke, "_setter()");
        return aVarInvoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(i iVar, String str, String str2, Object obj) {
        super(iVar, str, str2, obj);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "signature");
        c0.b<a<V>> bVarLazy = c0.lazy(new b());
        d0.z.d.m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Setter(this) }");
        this.w = bVarLazy;
    }
}
