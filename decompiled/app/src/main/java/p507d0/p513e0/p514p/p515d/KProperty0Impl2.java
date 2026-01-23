package p507d0.p513e0.p514p.p515d;

import com.discord.models.domain.ModelAuditLogEntry;
import java.lang.reflect.Field;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty6;
import kotlin.reflect.full.exceptions2;
import p507d0.Lazy5;
import p507d0.LazyJVM;
import p507d0.p513e0.p514p.p515d.KPropertyImpl;
import p507d0.p513e0.p514p.p515d.ReflectProperties;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.p, reason: use source file name */
/* JADX INFO: compiled from: KProperty0Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class KProperty0Impl2<V> extends KPropertyImpl<V> implements KProperty6<V> {

    /* JADX INFO: renamed from: u */
    public final ReflectProperties.b<a<V>> f25039u;

    /* JADX INFO: renamed from: v */
    public final Lazy<Object> f25040v;

    /* JADX INFO: renamed from: d0.e0.p.d.p$a */
    /* JADX INFO: compiled from: KProperty0Impl.kt */
    public static final class a<R> extends KPropertyImpl.c<R> implements KProperty6.Getter<R> {

        /* JADX INFO: renamed from: q */
        public final KProperty0Impl2<R> f25041q;

        /* JADX WARN: Multi-variable type inference failed */
        public a(KProperty0Impl2<? extends R> kProperty0Impl2) {
            Intrinsics3.checkNotNullParameter(kProperty0Impl2, "property");
            this.f25041q = kProperty0Impl2;
        }

        @Override // p507d0.p513e0.p514p.p515d.KPropertyImpl.a
        public KProperty0Impl2<R> getProperty() {
            return this.f25041q;
        }

        @Override // kotlin.jvm.functions.Function0
        public R invoke() {
            return getProperty().get();
        }

        @Override // p507d0.p513e0.p514p.p515d.KPropertyImpl.a
        public /* bridge */ /* synthetic */ KPropertyImpl getProperty() {
            return getProperty();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.p$b */
    /* JADX INFO: compiled from: KProperty0Impl.kt */
    public static final class b extends Lambda implements Function0<a<? extends V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<V> invoke() {
            return new a<>(KProperty0Impl2.this);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.p$c */
    /* JADX INFO: compiled from: KProperty0Impl.kt */
    public static final class c extends Lambda implements Function0<Object> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() throws exceptions2 {
            KProperty0Impl2 kProperty0Impl2 = KProperty0Impl2.this;
            Field fieldM10056c = kProperty0Impl2.m10056c();
            Object boundReceiver = KProperty0Impl2.this.getBoundReceiver();
            Objects.requireNonNull(kProperty0Impl2);
            try {
                if (boundReceiver == KPropertyImpl.f25048n && kProperty0Impl2.getDescriptor().getExtensionReceiverParameter() == null) {
                    throw new RuntimeException('\'' + kProperty0Impl2 + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
                }
                if (fieldM10056c != null) {
                    return fieldM10056c.get(boundReceiver);
                }
                return null;
            } catch (IllegalAccessException e) {
                throw new exceptions2(e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty0Impl2(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
        ReflectProperties.b<a<V>> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.f25039u = bVarLazy;
        this.f25040v = LazyJVM.lazy(Lazy5.PUBLICATION, new c());
    }

    @Override // kotlin.reflect.KProperty6
    public V get() {
        return mo11489getGetter().call(new Object[0]);
    }

    @Override // kotlin.reflect.KProperty6
    public Object getDelegate() {
        return this.f25040v.getValue();
    }

    @Override // kotlin.reflect.KProperty6
    /* JADX INFO: renamed from: getGetter */
    public /* bridge */ /* synthetic */ KProperty6.Getter mo11489getGetter() {
        return mo11489getGetter();
    }

    @Override // kotlin.jvm.functions.Function0
    public V invoke() {
        return get();
    }

    @Override // p507d0.p513e0.p514p.p515d.KPropertyImpl, kotlin.reflect.KProperty6
    /* JADX INFO: renamed from: getGetter */
    public /* bridge */ /* synthetic */ KPropertyImpl.c mo11489getGetter() {
        return mo11489getGetter();
    }

    @Override // p507d0.p513e0.p514p.p515d.KPropertyImpl, kotlin.reflect.KProperty6
    /* JADX INFO: renamed from: getGetter */
    public a<V> mo11489getGetter() {
        a<V> aVarInvoke = this.f25039u.invoke();
        Intrinsics3.checkNotNullExpressionValue(aVarInvoke, "_getter()");
        return aVarInvoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty0Impl2(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "signature");
        ReflectProperties.b<a<V>> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.f25039u = bVarLazy;
        this.f25040v = LazyJVM.lazy(Lazy5.PUBLICATION, new c());
    }
}
