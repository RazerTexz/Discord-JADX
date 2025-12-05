package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p507d0.Tuples;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.JavaToKotlinClassMapper;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.findClassInModule;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JvmAnnotationNames;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.DescriptorResolverUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.TypeUsage;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.PossiblyExternalAnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.JavaTypeResolver5;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p538j0.JavaSourceElementFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments5;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments6;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11807a;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11818j;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11826r;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11828t;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.ConstantValueFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage6;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage7;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.l.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class LazyJavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {

    /* renamed from: a */
    public static final /* synthetic */ KProperty<Object>[] f23334a = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* renamed from: b */
    public final context4 f23335b;

    /* renamed from: c */
    public final InterfaceC11564a f23336c;

    /* renamed from: d */
    public final storage6 f23337d;

    /* renamed from: e */
    public final storage5 f23338e;

    /* renamed from: f */
    public final JavaSourceElementFactory f23339f;

    /* renamed from: g */
    public final storage5 f23340g;

    /* renamed from: h */
    public final boolean f23341h;

    /* renamed from: i */
    public final boolean f23342i;

    /* compiled from: LazyJavaAnnotationDescriptor.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.e$a */
    public static final class a extends Lambda implements Function0<Map<Name, ? extends AbstractC11815g<?>>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Name, ? extends AbstractC11815g<?>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Name, ? extends AbstractC11815g<?>> invoke2() {
            Collection<annotationArguments> arguments = LazyJavaAnnotationDescriptor.access$getJavaAnnotation$p(LazyJavaAnnotationDescriptor.this).getArguments();
            LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor = LazyJavaAnnotationDescriptor.this;
            ArrayList arrayList = new ArrayList();
            for (annotationArguments annotationarguments : arguments) {
                Name name = annotationarguments.getName();
                if (name == null) {
                    name = JvmAnnotationNames.f23148b;
                }
                AbstractC11815g abstractC11815gAccess$resolveAnnotationArgument = LazyJavaAnnotationDescriptor.access$resolveAnnotationArgument(lazyJavaAnnotationDescriptor, annotationarguments);
                Tuples2 tuples2M10073to = abstractC11815gAccess$resolveAnnotationArgument == null ? null : Tuples.m10073to(name, abstractC11815gAccess$resolveAnnotationArgument);
                if (tuples2M10073to != null) {
                    arrayList.add(tuples2M10073to);
                }
            }
            return Maps6.toMap(arrayList);
        }
    }

    /* compiled from: LazyJavaAnnotationDescriptor.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.e$b */
    public static final class b extends Lambda implements Function0<FqName> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ FqName invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FqName invoke() {
            ClassId classId = LazyJavaAnnotationDescriptor.access$getJavaAnnotation$p(LazyJavaAnnotationDescriptor.this).getClassId();
            if (classId == null) {
                return null;
            }
            return classId.asSingleFqName();
        }
    }

    /* compiled from: LazyJavaAnnotationDescriptor.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.e$c */
    public static final class c extends Lambda implements Function0<KotlinType4> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ KotlinType4 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KotlinType4 invoke() {
            FqName fqName = LazyJavaAnnotationDescriptor.this.getFqName();
            if (fqName == null) {
                return ErrorUtils.createErrorType(Intrinsics3.stringPlus("No fqName: ", LazyJavaAnnotationDescriptor.access$getJavaAnnotation$p(LazyJavaAnnotationDescriptor.this)));
            }
            ClassDescriptor classDescriptorMapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(JavaToKotlinClassMapper.f22630a, fqName, LazyJavaAnnotationDescriptor.access$getC$p(LazyJavaAnnotationDescriptor.this).getModule().getBuiltIns(), null, 4, null);
            if (classDescriptorMapJavaToKotlin$default == null) {
                InterfaceC11574g interfaceC11574gResolve = LazyJavaAnnotationDescriptor.access$getJavaAnnotation$p(LazyJavaAnnotationDescriptor.this).resolve();
                classDescriptorMapJavaToKotlin$default = interfaceC11574gResolve == null ? null : LazyJavaAnnotationDescriptor.access$getC$p(LazyJavaAnnotationDescriptor.this).getComponents().getModuleClassResolver().resolveClass(interfaceC11574gResolve);
                if (classDescriptorMapJavaToKotlin$default == null) {
                    classDescriptorMapJavaToKotlin$default = LazyJavaAnnotationDescriptor.access$createTypeForMissingDependencies(LazyJavaAnnotationDescriptor.this, fqName);
                }
            }
            return classDescriptorMapJavaToKotlin$default.getDefaultType();
        }
    }

    public LazyJavaAnnotationDescriptor(context4 context4Var, InterfaceC11564a interfaceC11564a, boolean z2) {
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(interfaceC11564a, "javaAnnotation");
        this.f23335b = context4Var;
        this.f23336c = interfaceC11564a;
        this.f23337d = context4Var.getStorageManager().createNullableLazyValue(new b());
        this.f23338e = context4Var.getStorageManager().createLazyValue(new c());
        this.f23339f = context4Var.getComponents().getSourceElementFactory().source(interfaceC11564a);
        this.f23340g = context4Var.getStorageManager().createLazyValue(new a());
        this.f23341h = interfaceC11564a.isIdeExternalAnnotation();
        this.f23342i = interfaceC11564a.isFreshlySupportedTypeUseAnnotation() || z2;
    }

    public static final ClassDescriptor access$createTypeForMissingDependencies(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor, FqName fqName) {
        ModuleDescriptor2 module = lazyJavaAnnotationDescriptor.f23335b.getModule();
        ClassId classId = ClassId.topLevel(fqName);
        Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(fqName)");
        return findClassInModule.findNonGenericClassAcrossDependencies(module, classId, lazyJavaAnnotationDescriptor.f23335b.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses());
    }

    public static final /* synthetic */ context4 access$getC$p(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        return lazyJavaAnnotationDescriptor.f23335b;
    }

    public static final /* synthetic */ InterfaceC11564a access$getJavaAnnotation$p(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        return lazyJavaAnnotationDescriptor.f23336c;
    }

    public static final /* synthetic */ AbstractC11815g access$resolveAnnotationArgument(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor, annotationArguments annotationarguments) {
        return lazyJavaAnnotationDescriptor.m9463a(annotationarguments);
    }

    /* renamed from: a */
    public final AbstractC11815g<?> m9463a(annotationArguments annotationarguments) {
        AbstractC11815g<?> c11807a;
        if (annotationarguments instanceof annotationArguments6) {
            return ConstantValueFactory.f24439a.createConstantValue(((annotationArguments6) annotationarguments).getValue());
        }
        if (annotationarguments instanceof annotationArguments5) {
            annotationArguments5 annotationarguments5 = (annotationArguments5) annotationarguments;
            ClassId enumClassId = annotationarguments5.getEnumClassId();
            Name entryName = annotationarguments5.getEntryName();
            if (enumClassId == null || entryName == null) {
                return null;
            }
            return new C11818j(enumClassId, entryName);
        }
        if (annotationarguments instanceof annotationArguments3) {
            Name name = annotationarguments.getName();
            if (name == null) {
                name = JvmAnnotationNames.f23148b;
            }
            Intrinsics3.checkNotNullExpressionValue(name, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
            List<annotationArguments> elements = ((annotationArguments3) annotationarguments).getElements();
            KotlinType4 type = getType();
            Intrinsics3.checkNotNullExpressionValue(type, "type");
            if (KotlinType2.isError(type)) {
                return null;
            }
            ClassDescriptor annotationClass = DescriptorUtils2.getAnnotationClass(this);
            Intrinsics3.checkNotNull(annotationClass);
            ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(name, annotationClass);
            KotlinType type2 = annotationParameterByName != null ? annotationParameterByName.getType() : null;
            if (type2 == null) {
                type2 = this.f23335b.getComponents().getModule().getBuiltIns().getArrayType(Variance.INVARIANT, ErrorUtils.createErrorType("Unknown array element type"));
            }
            Intrinsics3.checkNotNullExpressionValue(type2, "DescriptorResolverUtils.getAnnotationParameterByName(argumentName, annotationClass!!)?.type\n            // Try to load annotation arguments even if the annotation class is not found\n                ?: c.components.module.builtIns.getArrayType(\n                    Variance.INVARIANT,\n                    ErrorUtils.createErrorType(\"Unknown array element type\")\n                )");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(elements, 10));
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                AbstractC11815g<?> abstractC11815gM9463a = m9463a((annotationArguments) it.next());
                if (abstractC11815gM9463a == null) {
                    abstractC11815gM9463a = new C11828t();
                }
                arrayList.add(abstractC11815gM9463a);
            }
            c11807a = ConstantValueFactory.f24439a.createArrayValue(arrayList, type2);
        } else {
            if (!(annotationarguments instanceof annotationArguments2)) {
                if (annotationarguments instanceof annotationArguments4) {
                    return C11826r.f24451b.create(this.f23335b.getTypeResolver().transformJavaType(((annotationArguments4) annotationarguments).getReferencedType(), JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, false, null, 3, null)));
                }
                return null;
            }
            c11807a = new C11807a(new LazyJavaAnnotationDescriptor(this.f23335b, ((annotationArguments2) annotationarguments).getAnnotation(), false, 4, null));
        }
        return c11807a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public Map<Name, AbstractC11815g<?>> getAllValueArguments() {
        return (Map) storage7.getValue(this.f23340g, this, (KProperty<?>) f23334a[2]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public FqName getFqName() {
        return (FqName) storage7.getValue(this.f23337d, this, (KProperty<?>) f23334a[0]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public /* bridge */ /* synthetic */ SourceElement getSource() {
        return getSource();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public /* bridge */ /* synthetic */ KotlinType getType() {
        return getType();
    }

    public final boolean isFreshlySupportedTypeUseAnnotation() {
        return this.f23342i;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.PossiblyExternalAnnotationDescriptor
    public boolean isIdeExternalAnnotation() {
        return this.f23341h;
    }

    public String toString() {
        return DescriptorRenderer2.renderAnnotation$default(DescriptorRenderer2.f24226b, this, null, 2, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public JavaSourceElementFactory getSource() {
        return this.f23339f;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public KotlinType4 getType() {
        return (KotlinType4) storage7.getValue(this.f23338e, this, (KProperty<?>) f23334a[1]);
    }

    public /* synthetic */ LazyJavaAnnotationDescriptor(context4 context4Var, InterfaceC11564a interfaceC11564a, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context4Var, interfaceC11564a, (i & 4) != 0 ? false : z2);
    }
}
