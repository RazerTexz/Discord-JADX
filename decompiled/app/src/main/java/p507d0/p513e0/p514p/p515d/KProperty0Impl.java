package p507d0.p513e0.p514p.p515d;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty5;
import kotlin.reflect.full.exceptions;
import p507d0.p513e0.p514p.p515d.KPropertyImpl;
import p507d0.p513e0.p514p.p515d.ReflectProperties;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.k, reason: use source file name */
/* JADX INFO: compiled from: KProperty0Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KProperty0Impl<V> extends KProperty0Impl2<V> implements KProperty5<V> {

    /* JADX INFO: renamed from: w */
    public final ReflectProperties.b<a<V>> f22398w;

    /* JADX INFO: renamed from: d0.e0.p.d.k$a */
    /* JADX INFO: compiled from: KProperty0Impl.kt */
    public static final class a<R> extends KPropertyImpl.d<R> implements KProperty5.Setter<R> {

        /* JADX INFO: renamed from: q */
        public final KProperty0Impl<R> f22399q;

        public a(KProperty0Impl<R> kProperty0Impl) {
            Intrinsics3.checkNotNullParameter(kProperty0Impl, "property");
            this.f22399q = kProperty0Impl;
        }

        @Override // p507d0.p513e0.p514p.p515d.KPropertyImpl.a
        public KProperty0Impl<R> getProperty() {
            return this.f22399q;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) throws exceptions {
            invoke2(obj);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.KPropertyImpl.a
        public /* bridge */ /* synthetic */ KPropertyImpl getProperty() {
            return getProperty();
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(R r) throws exceptions {
            getProperty().set(r);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.k$b */
    /* JADX INFO: compiled from: KProperty0Impl.kt */
    public static final class b extends Lambda implements Function0<a<V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<V> invoke() {
            return new a<>(KProperty0Impl.this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty0Impl(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
        ReflectProperties.b<a<V>> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Setter(this) }");
        this.f22398w = bVarLazy;
    }

    @Override // kotlin.reflect.KProperty5
    /* JADX INFO: renamed from: getSetter */
    public /* bridge */ /* synthetic */ KProperty5.Setter mo11490getSetter() {
        return mo11490getSetter();
    }

    public void set(V v) throws exceptions {
        mo11490getSetter().call(v);
    }

    @Override // kotlin.reflect.KProperty5
    /* JADX INFO: renamed from: getSetter */
    public a<V> mo11490getSetter() {
        a<V> aVarInvoke = this.f22398w.invoke();
        Intrinsics3.checkNotNullExpressionValue(aVarInvoke, "_setter()");
        return aVarInvoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty0Impl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "signature");
        ReflectProperties.b<a<V>> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Setter(this) }");
        this.f22398w = bVarLazy;
    }
}
