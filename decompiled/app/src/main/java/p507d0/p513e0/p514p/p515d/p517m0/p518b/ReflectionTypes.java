package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p507d0.Lazy5;
import p507d0.LazyJVM;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.NotFoundClasses;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.findClassInModule;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation3;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.StarProjectionImpl2;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: ReflectionTypes.kt */
/* renamed from: d0.e0.p.d.m0.b.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class ReflectionTypes {

    /* renamed from: a */
    public static final b f22482a = new b(null);

    /* renamed from: b */
    public static final /* synthetic */ KProperty<Object>[] f22483b;

    /* renamed from: c */
    public final NotFoundClasses f22484c;

    /* renamed from: d */
    public final Lazy f22485d;

    /* renamed from: e */
    public final a f22486e;

    /* compiled from: ReflectionTypes.kt */
    /* renamed from: d0.e0.p.d.m0.b.j$a */
    public static final class a {

        /* renamed from: a */
        public final int f22487a;

        public a(int i) {
            this.f22487a = i;
        }

        public final ClassDescriptor getValue(ReflectionTypes reflectionTypes, KProperty<?> kProperty) {
            Intrinsics3.checkNotNullParameter(reflectionTypes, "types");
            Intrinsics3.checkNotNullParameter(kProperty, "property");
            return ReflectionTypes.access$find(reflectionTypes, StringsJVM.capitalize(kProperty.getName()), this.f22487a);
        }
    }

    /* compiled from: ReflectionTypes.kt */
    /* renamed from: d0.e0.p.d.m0.b.j$b */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final KotlinType createKPropertyStarType(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
            ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = findClassInModule.findClassAcrossModuleDependencies(moduleDescriptor2, StandardNames.a.f22529Z);
            if (classDescriptorFindClassAcrossModuleDependencies == null) {
                return null;
            }
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
            Annotations4 empty = Annotations4.f22735f.getEMPTY();
            List<TypeParameterDescriptor> parameters = classDescriptorFindClassAcrossModuleDependencies.getTypeConstructor().getParameters();
            Intrinsics3.checkNotNullExpressionValue(parameters, "kPropertyClass.typeConstructor.parameters");
            Object objSingle = _Collections.single((List<? extends Object>) parameters);
            Intrinsics3.checkNotNullExpressionValue(objSingle, "kPropertyClass.typeConstructor.parameters.single()");
            return KotlinTypeFactory.simpleNotNullType(empty, classDescriptorFindClassAcrossModuleDependencies, CollectionsJVM.listOf(new StarProjectionImpl2((TypeParameterDescriptor) objSingle)));
        }
    }

    /* compiled from: ReflectionTypes.kt */
    /* renamed from: d0.e0.p.d.m0.b.j$c */
    public static final class c extends Lambda implements Function0<MemberScope3> {
        public final /* synthetic */ ModuleDescriptor2 $module;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ModuleDescriptor2 moduleDescriptor2) {
            super(0);
            this.$module = moduleDescriptor2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ MemberScope3 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MemberScope3 invoke() {
            return this.$module.getPackage(StandardNames.f22496i).getMemberScope();
        }
    }

    static {
        KProperty<Object>[] kPropertyArr = new KProperty[9];
        kPropertyArr[1] = Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ReflectionTypes.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[2] = Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ReflectionTypes.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[3] = Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ReflectionTypes.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[4] = Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ReflectionTypes.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[5] = Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ReflectionTypes.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[6] = Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ReflectionTypes.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[7] = Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ReflectionTypes.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[8] = Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ReflectionTypes.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        f22483b = kPropertyArr;
    }

    public ReflectionTypes(ModuleDescriptor2 moduleDescriptor2, NotFoundClasses notFoundClasses) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        this.f22484c = notFoundClasses;
        this.f22485d = LazyJVM.lazy(Lazy5.PUBLICATION, new c(moduleDescriptor2));
        this.f22486e = new a(1);
        new a(1);
        new a(1);
        new a(2);
        new a(3);
        new a(1);
        new a(2);
        new a(3);
    }

    public static final ClassDescriptor access$find(ReflectionTypes reflectionTypes, String str, int i) {
        Objects.requireNonNull(reflectionTypes);
        Name nameIdentifier = Name.identifier(str);
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(className)");
        ClassifierDescriptor contributedClassifier = ((MemberScope3) reflectionTypes.f22485d.getValue()).getContributedClassifier(nameIdentifier, LookupLocation3.FROM_REFLECTION);
        ClassDescriptor classDescriptor = contributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier : null;
        return classDescriptor == null ? reflectionTypes.f22484c.getClass(new ClassId(StandardNames.f22496i, nameIdentifier), CollectionsJVM.listOf(Integer.valueOf(i))) : classDescriptor;
    }

    public final ClassDescriptor getKClass() {
        return this.f22486e.getValue(this, f22483b[1]);
    }
}
