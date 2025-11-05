package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.c0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.s;
import java.lang.reflect.Field;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty0;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;

/* compiled from: KProperty0Impl.kt */
/* loaded from: classes3.dex */
public class p<V> extends s<V> implements KProperty0<V> {
    public final c0.b<a<V>> u;
    public final Lazy<Object> v;

    /* compiled from: KProperty0Impl.kt */
    public static final class a<R> extends s.c<R> implements KProperty0.Getter<R> {
        public final p<R> q;

        /* JADX WARN: Multi-variable type inference failed */
        public a(p<? extends R> pVar) {
            d0.z.d.m.checkNotNullParameter(pVar, "property");
            this.q = pVar;
        }

        @Override // d0.e0.p.d.s.a
        public p<R> getProperty() {
            return this.q;
        }

        @Override // kotlin.jvm.functions.Function0
        public R invoke() {
            return getProperty().get();
        }

        @Override // d0.e0.p.d.s.a
        public /* bridge */ /* synthetic */ s getProperty() {
            return getProperty();
        }
    }

    /* compiled from: KProperty0Impl.kt */
    public static final class b extends d0.z.d.o implements Function0<a<? extends V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<V> invoke() {
            return new a<>(p.this);
        }
    }

    /* compiled from: KProperty0Impl.kt */
    public static final class c extends d0.z.d.o implements Function0<Object> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() throws IllegalPropertyDelegateAccessException {
            p pVar = p.this;
            Field fieldC = pVar.c();
            Object boundReceiver = p.this.getBoundReceiver();
            Objects.requireNonNull(pVar);
            try {
                if (boundReceiver == s.n && pVar.getDescriptor().getExtensionReceiverParameter() == null) {
                    throw new RuntimeException('\'' + pVar + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
                }
                if (fieldC != null) {
                    return fieldC.get(boundReceiver);
                }
                return null;
            } catch (IllegalAccessException e) {
                throw new IllegalPropertyDelegateAccessException(e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(i iVar, n0 n0Var) {
        super(iVar, n0Var);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        c0.b<a<V>> bVarLazy = c0.lazy(new b());
        d0.z.d.m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.u = bVarLazy;
        this.v = d0.g.lazy(d0.i.PUBLICATION, new c());
    }

    @Override // kotlin.reflect.KProperty0
    public V get() {
        return mo112getGetter().call(new Object[0]);
    }

    @Override // kotlin.reflect.KProperty0
    public Object getDelegate() {
        return this.v.getValue();
    }

    @Override // kotlin.reflect.KProperty0
    /* renamed from: getGetter */
    public /* bridge */ /* synthetic */ KProperty0.Getter mo112getGetter() {
        return mo112getGetter();
    }

    @Override // kotlin.jvm.functions.Function0
    public V invoke() {
        return get();
    }

    @Override // d0.e0.p.d.s, kotlin.reflect.KProperty0
    /* renamed from: getGetter */
    public /* bridge */ /* synthetic */ s.c mo112getGetter() {
        return mo112getGetter();
    }

    @Override // d0.e0.p.d.s, kotlin.reflect.KProperty0
    /* renamed from: getGetter */
    public a<V> mo112getGetter() {
        a<V> aVarInvoke = this.u.invoke();
        d0.z.d.m.checkNotNullExpressionValue(aVarInvoke, "_getter()");
        return aVarInvoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(i iVar, String str, String str2, Object obj) {
        super(iVar, str, str2, obj);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "signature");
        c0.b<a<V>> bVarLazy = c0.lazy(new b());
        d0.z.d.m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.u = bVarLazy;
        this.v = d0.g.lazy(d0.i.PUBLICATION, new c());
    }
}
