package p507d0.p513e0.p514p.p515d;

import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import p507d0.Lazy5;
import p507d0.LazyJVM;
import p507d0.p513e0.p514p.p515d.KPropertyImpl;
import p507d0.p513e0.p514p.p515d.ReflectProperties;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.r, reason: use source file name */
/* JADX INFO: compiled from: KProperty2Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class KProperty2Impl2<D, E, V> extends KPropertyImpl<V> implements KProperty, Function2 {

    /* JADX INFO: renamed from: u */
    public final ReflectProperties.b<a<D, E, V>> f25045u;

    /* JADX INFO: renamed from: v */
    public final Lazy<Field> f25046v;

    /* JADX INFO: renamed from: d0.e0.p.d.r$a */
    /* JADX INFO: compiled from: KProperty2Impl.kt */
    public static final class a<D, E, V> extends KPropertyImpl.c<V> implements KProperty.Getter, Function2 {

        /* JADX INFO: renamed from: q */
        public final KProperty2Impl2<D, E, V> f25047q;

        /* JADX WARN: Multi-variable type inference failed */
        public a(KProperty2Impl2<D, E, ? extends V> kProperty2Impl2) {
            Intrinsics3.checkNotNullParameter(kProperty2Impl2, "property");
            this.f25047q = kProperty2Impl2;
        }

        @Override // p507d0.p513e0.p514p.p515d.KPropertyImpl.a
        public KProperty2Impl2<D, E, V> getProperty() {
            return this.f25047q;
        }

        @Override // kotlin.jvm.functions.Function2
        public V invoke(D d, E e) {
            return getProperty().get(d, e);
        }

        @Override // p507d0.p513e0.p514p.p515d.KPropertyImpl.a
        public /* bridge */ /* synthetic */ KPropertyImpl getProperty() {
            return getProperty();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.r$b */
    /* JADX INFO: compiled from: KProperty2Impl.kt */
    public static final class b extends Lambda implements Function0<a<D, E, ? extends V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<D, E, V> invoke() {
            return new a<>(KProperty2Impl2.this);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.r$c */
    /* JADX INFO: compiled from: KProperty2Impl.kt */
    public static final class c extends Lambda implements Function0<Field> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Field invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Field invoke2() {
            return KProperty2Impl2.this.m10056c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty2Impl2(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
        ReflectProperties.b<a<D, E, V>> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.f25045u = bVarLazy;
        this.f25046v = LazyJVM.lazy(Lazy5.PUBLICATION, new c());
    }

    public V get(D d, E e) {
        return mo11489getGetter().call(d, e);
    }

    @Override // p507d0.p513e0.p514p.p515d.KPropertyImpl, kotlin.reflect.KProperty6
    /* JADX INFO: renamed from: getGetter */
    public /* bridge */ /* synthetic */ KPropertyImpl.c mo11489getGetter() {
        return mo11489getGetter();
    }

    @Override // kotlin.jvm.functions.Function2
    public V invoke(D d, E e) {
        return get(d, e);
    }

    @Override // p507d0.p513e0.p514p.p515d.KPropertyImpl, kotlin.reflect.KProperty6
    /* JADX INFO: renamed from: getGetter */
    public a<D, E, V> mo11489getGetter() {
        a<D, E, V> aVarInvoke = this.f25045u.invoke();
        Intrinsics3.checkNotNullExpressionValue(aVarInvoke, "_getter()");
        return aVarInvoke;
    }
}
