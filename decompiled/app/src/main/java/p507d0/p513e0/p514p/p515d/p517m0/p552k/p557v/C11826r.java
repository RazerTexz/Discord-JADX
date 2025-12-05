package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.findClassInModule;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjectionImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: constantValues.kt */
/* renamed from: d0.e0.p.d.m0.k.v.r */
/* loaded from: classes3.dex */
public final class C11826r extends AbstractC11815g<b> {

    /* renamed from: b */
    public static final a f24451b = new a(null);

    /* compiled from: constantValues.kt */
    /* renamed from: d0.e0.p.d.m0.k.v.r$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final AbstractC11815g<?> create(KotlinType kotlinType) {
            Intrinsics3.checkNotNullParameter(kotlinType, "argumentType");
            if (KotlinType2.isError(kotlinType)) {
                return null;
            }
            KotlinType type = kotlinType;
            int i = 0;
            while (KotlinBuiltIns.isArray(type)) {
                type = ((TypeProjection) _Collections.single((List) type.getArguments())).getType();
                Intrinsics3.checkNotNullExpressionValue(type, "type.arguments.single().type");
                i++;
            }
            ClassifierDescriptor declarationDescriptor = type.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassDescriptor) {
                ClassId classId = DescriptorUtils2.getClassId(declarationDescriptor);
                return classId == null ? new C11826r(new b.a(kotlinType)) : new C11826r(classId, i);
            }
            if (!(declarationDescriptor instanceof TypeParameterDescriptor)) {
                return null;
            }
            ClassId classId2 = ClassId.topLevel(StandardNames.a.f22532b.toSafe());
            Intrinsics3.checkNotNullExpressionValue(classId2, "topLevel(StandardNames.FqNames.any.toSafe())");
            return new C11826r(classId2, 0);
        }
    }

    /* compiled from: constantValues.kt */
    /* renamed from: d0.e0.p.d.m0.k.v.r$b */
    public static abstract class b {

        /* compiled from: constantValues.kt */
        /* renamed from: d0.e0.p.d.m0.k.v.r$b$a */
        public static final class a extends b {

            /* renamed from: a */
            public final KotlinType f24452a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(KotlinType kotlinType) {
                super(null);
                Intrinsics3.checkNotNullParameter(kotlinType, "type");
                this.f24452a = kotlinType;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && Intrinsics3.areEqual(this.f24452a, ((a) obj).f24452a);
            }

            public final KotlinType getType() {
                return this.f24452a;
            }

            public int hashCode() {
                return this.f24452a.hashCode();
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("LocalClass(type=");
                sbM833U.append(this.f24452a);
                sbM833U.append(')');
                return sbM833U.toString();
            }
        }

        /* compiled from: constantValues.kt */
        /* renamed from: d0.e0.p.d.m0.k.v.r$b$b, reason: collision with other inner class name */
        public static final class C13329b extends b {

            /* renamed from: a */
            public final ClassLiteralValue f24453a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C13329b(ClassLiteralValue classLiteralValue) {
                super(null);
                Intrinsics3.checkNotNullParameter(classLiteralValue, "value");
                this.f24453a = classLiteralValue;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C13329b) && Intrinsics3.areEqual(this.f24453a, ((C13329b) obj).f24453a);
            }

            public final int getArrayDimensions() {
                return this.f24453a.getArrayNestedness();
            }

            public final ClassId getClassId() {
                return this.f24453a.getClassId();
            }

            public final ClassLiteralValue getValue() {
                return this.f24453a;
            }

            public int hashCode() {
                return this.f24453a.hashCode();
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("NormalClass(value=");
                sbM833U.append(this.f24453a);
                sbM833U.append(')');
                return sbM833U.toString();
            }
        }

        public b() {
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11826r(b bVar) {
        super(bVar);
        Intrinsics3.checkNotNullParameter(bVar, "value");
    }

    public final KotlinType getArgumentType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        b value = getValue();
        if (value instanceof b.a) {
            return ((b.a) getValue()).getType();
        }
        if (!(value instanceof b.C13329b)) {
            throw new NoWhenBranchMatchedException();
        }
        ClassLiteralValue value2 = ((b.C13329b) getValue()).getValue();
        ClassId classIdComponent1 = value2.component1();
        int iComponent2 = value2.component2();
        ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = findClassInModule.findClassAcrossModuleDependencies(moduleDescriptor2, classIdComponent1);
        if (classDescriptorFindClassAcrossModuleDependencies == null) {
            KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType("Unresolved type: " + classIdComponent1 + " (arrayDimensions=" + iComponent2 + ')');
            Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(\"Unresolved type: $classId (arrayDimensions=$arrayDimensions)\")");
            return kotlinType4CreateErrorType;
        }
        KotlinType4 defaultType = classDescriptorFindClassAcrossModuleDependencies.getDefaultType();
        Intrinsics3.checkNotNullExpressionValue(defaultType, "descriptor.defaultType");
        KotlinType kotlinTypeReplaceArgumentsWithStarProjections = TypeUtils2.replaceArgumentsWithStarProjections(defaultType);
        for (int i = 0; i < iComponent2; i++) {
            kotlinTypeReplaceArgumentsWithStarProjections = moduleDescriptor2.getBuiltIns().getArrayType(Variance.INVARIANT, kotlinTypeReplaceArgumentsWithStarProjections);
            Intrinsics3.checkNotNullExpressionValue(kotlinTypeReplaceArgumentsWithStarProjections, "module.builtIns.getArrayType(Variance.INVARIANT, type)");
        }
        return kotlinTypeReplaceArgumentsWithStarProjections;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public KotlinType getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
        Annotations4 empty = Annotations4.f22735f.getEMPTY();
        ClassDescriptor kClass = moduleDescriptor2.getBuiltIns().getKClass();
        Intrinsics3.checkNotNullExpressionValue(kClass, "module.builtIns.kClass");
        return KotlinTypeFactory.simpleNotNullType(empty, kClass, CollectionsJVM.listOf(new TypeProjectionImpl(getArgumentType(moduleDescriptor2))));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C11826r(ClassLiteralValue classLiteralValue) {
        this(new b.C13329b(classLiteralValue));
        Intrinsics3.checkNotNullParameter(classLiteralValue, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C11826r(ClassId classId, int i) {
        this(new ClassLiteralValue(classId, i));
        Intrinsics3.checkNotNullParameter(classId, "classId");
    }
}
