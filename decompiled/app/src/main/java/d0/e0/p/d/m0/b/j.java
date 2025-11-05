package d0.e0.p.d.m0.b;

import d0.e0.p.d.m0.b.k;
import d0.e0.p.d.m0.c.d0;
import d0.e0.p.d.m0.c.w;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.o0;
import d0.g0.t;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.y;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: ReflectionTypes.kt */
/* loaded from: classes3.dex */
public final class j {
    public static final b a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3214b;
    public final d0 c;
    public final Lazy d;
    public final a e;

    /* compiled from: ReflectionTypes.kt */
    public static final class a {
        public final int a;

        public a(int i) {
            this.a = i;
        }

        public final d0.e0.p.d.m0.c.e getValue(j jVar, KProperty<?> kProperty) {
            d0.z.d.m.checkNotNullParameter(jVar, "types");
            d0.z.d.m.checkNotNullParameter(kProperty, "property");
            return j.access$find(jVar, t.capitalize(kProperty.getName()), this.a);
        }
    }

    /* compiled from: ReflectionTypes.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final c0 createKPropertyStarType(d0.e0.p.d.m0.c.c0 c0Var) {
            d0.z.d.m.checkNotNullParameter(c0Var, "module");
            d0.e0.p.d.m0.c.e eVarFindClassAcrossModuleDependencies = w.findClassAcrossModuleDependencies(c0Var, k.a.Z);
            if (eVarFindClassAcrossModuleDependencies == null) {
                return null;
            }
            d0.e0.p.d.m0.n.d0 d0Var = d0.e0.p.d.m0.n.d0.a;
            d0.e0.p.d.m0.c.g1.g empty = d0.e0.p.d.m0.c.g1.g.f.getEMPTY();
            List<z0> parameters = eVarFindClassAcrossModuleDependencies.getTypeConstructor().getParameters();
            d0.z.d.m.checkNotNullExpressionValue(parameters, "kPropertyClass.typeConstructor.parameters");
            Object objSingle = u.single((List<? extends Object>) parameters);
            d0.z.d.m.checkNotNullExpressionValue(objSingle, "kPropertyClass.typeConstructor.parameters.single()");
            return d0.e0.p.d.m0.n.d0.simpleNotNullType(empty, eVarFindClassAcrossModuleDependencies, d0.t.m.listOf(new o0((z0) objSingle)));
        }
    }

    /* compiled from: ReflectionTypes.kt */
    public static final class c extends d0.z.d.o implements Function0<d0.e0.p.d.m0.k.a0.i> {
        public final /* synthetic */ d0.e0.p.d.m0.c.c0 $module;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d0.e0.p.d.m0.c.c0 c0Var) {
            super(0);
            this.$module = c0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.a0.i invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final d0.e0.p.d.m0.k.a0.i invoke() {
            return this.$module.getPackage(k.i).getMemberScope();
        }
    }

    static {
        KProperty<Object>[] kPropertyArr = new KProperty[9];
        kPropertyArr[1] = a0.property1(new y(a0.getOrCreateKotlinClass(j.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[2] = a0.property1(new y(a0.getOrCreateKotlinClass(j.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[3] = a0.property1(new y(a0.getOrCreateKotlinClass(j.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[4] = a0.property1(new y(a0.getOrCreateKotlinClass(j.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[5] = a0.property1(new y(a0.getOrCreateKotlinClass(j.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[6] = a0.property1(new y(a0.getOrCreateKotlinClass(j.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[7] = a0.property1(new y(a0.getOrCreateKotlinClass(j.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[8] = a0.property1(new y(a0.getOrCreateKotlinClass(j.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        f3214b = kPropertyArr;
    }

    public j(d0.e0.p.d.m0.c.c0 c0Var, d0 d0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        d0.z.d.m.checkNotNullParameter(d0Var, "notFoundClasses");
        this.c = d0Var;
        this.d = d0.g.lazy(d0.i.PUBLICATION, new c(c0Var));
        this.e = new a(1);
        new a(1);
        new a(1);
        new a(2);
        new a(3);
        new a(1);
        new a(2);
        new a(3);
    }

    public static final d0.e0.p.d.m0.c.e access$find(j jVar, String str, int i) {
        Objects.requireNonNull(jVar);
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(str);
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(className)");
        d0.e0.p.d.m0.c.h contributedClassifier = ((d0.e0.p.d.m0.k.a0.i) jVar.d.getValue()).getContributedClassifier(eVarIdentifier, d0.e0.p.d.m0.d.b.d.FROM_REFLECTION);
        d0.e0.p.d.m0.c.e eVar = contributedClassifier instanceof d0.e0.p.d.m0.c.e ? (d0.e0.p.d.m0.c.e) contributedClassifier : null;
        return eVar == null ? jVar.c.getClass(new d0.e0.p.d.m0.g.a(k.i, eVarIdentifier), d0.t.m.listOf(Integer.valueOf(i))) : eVar;
    }

    public final d0.e0.p.d.m0.c.e getKClass() {
        return this.e.getValue(this, f3214b[1]);
    }
}
