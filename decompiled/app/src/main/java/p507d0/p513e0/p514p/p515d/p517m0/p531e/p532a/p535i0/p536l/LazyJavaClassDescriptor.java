package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.mappingUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.NotFoundClasses;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ScopesHolderForClass;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SupertypeLoopChecker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Visibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ClassDescriptorBase;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.typeParameterUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.FakePureImplementationsProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JavaDescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JvmAnnotationNames;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.JavaResolverCache;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.TypeUsage;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.LazyJavaAnnotations2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.JavaTypeResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.JavaTypeResolver5;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11592y;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes5;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.utils2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNamesUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InnerClassesScopeWrapper;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11831w;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ErrorReporter;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractClassTypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjectionImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.collections;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Iterators4;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.f, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaClassDescriptor extends ClassDescriptorBase implements JavaClassDescriptor {

    /* JADX INFO: renamed from: A */
    public final LazyJavaClassMemberScope2 f23343A;

    /* JADX INFO: renamed from: B */
    public final ScopesHolderForClass<LazyJavaClassMemberScope2> f23344B;

    /* JADX INFO: renamed from: C */
    public final InnerClassesScopeWrapper f23345C;

    /* JADX INFO: renamed from: D */
    public final LazyJavaStaticClassScope2 f23346D;

    /* JADX INFO: renamed from: E */
    public final Annotations4 f23347E;

    /* JADX INFO: renamed from: F */
    public final storage5<List<TypeParameterDescriptor>> f23348F;

    /* JADX INFO: renamed from: r */
    public final context4 f23349r;

    /* JADX INFO: renamed from: s */
    public final InterfaceC11574g f23350s;

    /* JADX INFO: renamed from: t */
    public final ClassDescriptor f23351t;

    /* JADX INFO: renamed from: u */
    public final context4 f23352u;

    /* JADX INFO: renamed from: v */
    public final ClassKind f23353v;

    /* JADX INFO: renamed from: w */
    public final Modality f23354w;

    /* JADX INFO: renamed from: x */
    public final Visibility2 f23355x;

    /* JADX INFO: renamed from: y */
    public final boolean f23356y;

    /* JADX INFO: renamed from: z */
    public final b f23357z;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.f$a */
    /* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.f$b */
    /* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
    public final class b extends AbstractClassTypeConstructor {

        /* JADX INFO: renamed from: c */
        public final storage5<List<TypeParameterDescriptor>> f23358c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ LazyJavaClassDescriptor f23359d;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.f$b$a */
        /* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
        public static final class a extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
            public final /* synthetic */ LazyJavaClassDescriptor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
                super(0);
                this.this$0 = lazyJavaClassDescriptor;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends TypeParameterDescriptor> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends TypeParameterDescriptor> invoke2() {
                return typeParameterUtils.computeConstructorTypeParameters(this.this$0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
            super(LazyJavaClassDescriptor.access$getC$p(lazyJavaClassDescriptor).getStorageManager());
            Intrinsics3.checkNotNullParameter(lazyJavaClassDescriptor, "this$0");
            this.f23359d = lazyJavaClassDescriptor;
            this.f23358c = LazyJavaClassDescriptor.access$getC$p(lazyJavaClassDescriptor).getStorageManager().createLazyValue(new a(lazyJavaClassDescriptor));
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0135  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01b1  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x01d0  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x020f  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0214  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Collection<KotlinType> mo9370a() {
            FqName fqName;
            FqName purelyImplementedInterface;
            ArrayList arrayList;
            KotlinType4 kotlinType4SimpleNotNullType;
            Variance variance = Variance.INVARIANT;
            Collection<javaTypes3> supertypes = this.f23359d.getJClass().getSupertypes();
            ArrayList arrayList2 = new ArrayList(supertypes.size());
            ArrayList arrayList3 = new ArrayList(0);
            Annotations4 annotations = this.f23359d.getAnnotations();
            FqName fqName2 = JvmAnnotationNames.f23160n;
            Intrinsics3.checkNotNullExpressionValue(fqName2, "PURELY_IMPLEMENTS_ANNOTATION");
            AnnotationDescriptor annotationDescriptorFindAnnotation = annotations.findAnnotation(fqName2);
            if (annotationDescriptorFindAnnotation == null) {
                fqName = null;
            } else {
                Object objSingleOrNull = _Collections.singleOrNull(annotationDescriptorFindAnnotation.getAllValueArguments().values());
                C11831w c11831w = objSingleOrNull instanceof C11831w ? (C11831w) objSingleOrNull : null;
                String value = c11831w == null ? null : c11831w.getValue();
                if (value != null && FqNamesUtil.isValidJavaFqName(value)) {
                    fqName = new FqName(value);
                }
            }
            if (fqName != null) {
                if (!(!fqName.isRoot() && fqName.startsWith(StandardNames.f22498k))) {
                    fqName = null;
                }
            }
            if (fqName == null) {
                purelyImplementedInterface = FakePureImplementationsProvider.f23516a.getPurelyImplementedInterface(DescriptorUtils2.getFqNameSafe(this.f23359d));
                if (purelyImplementedInterface == null) {
                    kotlinType4SimpleNotNullType = null;
                }
                for (javaTypes3 javatypes3 : supertypes) {
                    KotlinType kotlinTypeTransformJavaType = LazyJavaClassDescriptor.access$getC$p(this.f23359d).getTypeResolver().transformJavaType(javatypes3, JavaTypeResolver5.toAttributes$default(TypeUsage.SUPERTYPE, false, null, 3, null));
                    if (LazyJavaClassDescriptor.access$getC$p(this.f23359d).getComponents().getSettings().getTypeEnhancementImprovements()) {
                        kotlinTypeTransformJavaType = LazyJavaClassDescriptor.access$getC$p(this.f23359d).getComponents().getSignatureEnhancement().enhanceSuperType(kotlinTypeTransformJavaType, LazyJavaClassDescriptor.access$getC$p(this.f23359d));
                    }
                    if (kotlinTypeTransformJavaType.getConstructor().getDeclarationDescriptor() instanceof NotFoundClasses.b) {
                        arrayList3.add(javatypes3);
                    }
                    if (!Intrinsics3.areEqual(kotlinTypeTransformJavaType.getConstructor(), kotlinType4SimpleNotNullType == null ? null : kotlinType4SimpleNotNullType.getConstructor()) && !KotlinBuiltIns.isAnyOrNullableAny(kotlinTypeTransformJavaType)) {
                        arrayList2.add(kotlinTypeTransformJavaType);
                    }
                }
                ClassDescriptor classDescriptorAccess$getAdditionalSupertypeClassDescriptor$p = LazyJavaClassDescriptor.access$getAdditionalSupertypeClassDescriptor$p(this.f23359d);
                collections.addIfNotNull(arrayList2, classDescriptorAccess$getAdditionalSupertypeClassDescriptor$p != null ? mappingUtil.createMappedTypeParametersSubstitution(classDescriptorAccess$getAdditionalSupertypeClassDescriptor$p, this.f23359d).buildSubstitutor().substitute(classDescriptorAccess$getAdditionalSupertypeClassDescriptor$p.getDefaultType(), variance) : null);
                collections.addIfNotNull(arrayList2, kotlinType4SimpleNotNullType);
                if (!arrayList3.isEmpty()) {
                    ErrorReporter errorReporter = LazyJavaClassDescriptor.access$getC$p(this.f23359d).getComponents().getErrorReporter();
                    ClassDescriptor declarationDescriptor = getDeclarationDescriptor();
                    ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList3, 10));
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        arrayList4.add(((javaTypes3) ((javaTypes5) it.next())).getPresentableText());
                    }
                    errorReporter.reportIncompleteHierarchy(declarationDescriptor, arrayList4);
                }
                return !(arrayList2.isEmpty() ^ true) ? _Collections.toList(arrayList2) : CollectionsJVM.listOf(LazyJavaClassDescriptor.access$getC$p(this.f23359d).getModule().getBuiltIns().getAnyType());
            }
            purelyImplementedInterface = fqName;
            ClassDescriptor classDescriptorResolveTopLevelClass = DescriptorUtils2.resolveTopLevelClass(LazyJavaClassDescriptor.access$getC$p(this.f23359d).getModule(), purelyImplementedInterface, LookupLocation3.FROM_JAVA_LOADER);
            if (classDescriptorResolveTopLevelClass != null) {
                int size = classDescriptorResolveTopLevelClass.getTypeConstructor().getParameters().size();
                List<TypeParameterDescriptor> parameters = this.f23359d.getTypeConstructor().getParameters();
                Intrinsics3.checkNotNullExpressionValue(parameters, "getTypeConstructor().parameters");
                int size2 = parameters.size();
                if (size2 == size) {
                    arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(parameters, 10));
                    Iterator<T> it2 = parameters.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(new TypeProjectionImpl(variance, ((TypeParameterDescriptor) it2.next()).getDefaultType()));
                    }
                } else {
                    if (size2 == 1 && size > 1 && fqName == null) {
                        TypeProjectionImpl typeProjectionImpl = new TypeProjectionImpl(variance, ((TypeParameterDescriptor) _Collections.single((List) parameters)).getDefaultType());
                        Ranges2 ranges2 = new Ranges2(1, size);
                        ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2, 10));
                        Iterator<Integer> it3 = ranges2.iterator();
                        while (it3.hasNext()) {
                            ((Iterators4) it3).nextInt();
                            arrayList5.add(typeProjectionImpl);
                        }
                        arrayList = arrayList5;
                    }
                    kotlinType4SimpleNotNullType = null;
                }
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
                kotlinType4SimpleNotNullType = KotlinTypeFactory.simpleNotNullType(Annotations4.f22735f.getEMPTY(), classDescriptorResolveTopLevelClass, arrayList);
            }
            while (r1.hasNext()) {
            }
            ClassDescriptor classDescriptorAccess$getAdditionalSupertypeClassDescriptor$p2 = LazyJavaClassDescriptor.access$getAdditionalSupertypeClassDescriptor$p(this.f23359d);
            collections.addIfNotNull(arrayList2, classDescriptorAccess$getAdditionalSupertypeClassDescriptor$p2 != null ? mappingUtil.createMappedTypeParametersSubstitution(classDescriptorAccess$getAdditionalSupertypeClassDescriptor$p2, this.f23359d).buildSubstitutor().substitute(classDescriptorAccess$getAdditionalSupertypeClassDescriptor$p2.getDefaultType(), variance) : null);
            collections.addIfNotNull(arrayList2, kotlinType4SimpleNotNullType);
            if (!arrayList3.isEmpty()) {
            }
            if (!(arrayList2.isEmpty() ^ true)) {
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor
        /* JADX INFO: renamed from: d */
        public SupertypeLoopChecker mo9371d() {
            return LazyJavaClassDescriptor.access$getC$p(this.f23359d).getComponents().getSupertypeLoopChecker();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor, p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public /* bridge */ /* synthetic */ ClassifierDescriptor getDeclarationDescriptor() {
            return getDeclarationDescriptor();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return this.f23358c.invoke();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        public String toString() {
            String strAsString = this.f23359d.getName().asString();
            Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
            return strAsString;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractClassTypeConstructor, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor, p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public ClassDescriptor getDeclarationDescriptor() {
            return this.f23359d;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.f$c */
    /* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
    public static final class c extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends TypeParameterDescriptor> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends TypeParameterDescriptor> invoke2() {
            List<InterfaceC11592y> typeParameters = LazyJavaClassDescriptor.this.getJClass().getTypeParameters();
            LazyJavaClassDescriptor lazyJavaClassDescriptor = LazyJavaClassDescriptor.this;
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(typeParameters, 10));
            for (InterfaceC11592y interfaceC11592y : typeParameters) {
                TypeParameterDescriptor typeParameterDescriptorResolveTypeParameter = LazyJavaClassDescriptor.access$getC$p(lazyJavaClassDescriptor).getTypeParameterResolver().resolveTypeParameter(interfaceC11592y);
                if (typeParameterDescriptorResolveTypeParameter == null) {
                    throw new AssertionError("Parameter " + interfaceC11592y + " surely belongs to class " + lazyJavaClassDescriptor.getJClass() + ", so it must be resolved");
                }
                arrayList.add(typeParameterDescriptorResolveTypeParameter);
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.f$d */
    /* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
    public static final class d extends Lambda implements Function1<KotlinTypeRefiner, LazyJavaClassMemberScope2> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ LazyJavaClassMemberScope2 invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            return invoke2(kotlinTypeRefiner);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final LazyJavaClassMemberScope2 invoke2(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "it");
            context4 context4VarAccess$getC$p = LazyJavaClassDescriptor.access$getC$p(LazyJavaClassDescriptor.this);
            LazyJavaClassDescriptor lazyJavaClassDescriptor = LazyJavaClassDescriptor.this;
            return new LazyJavaClassMemberScope2(context4VarAccess$getC$p, lazyJavaClassDescriptor, lazyJavaClassDescriptor.getJClass(), LazyJavaClassDescriptor.access$getAdditionalSupertypeClassDescriptor$p(LazyJavaClassDescriptor.this) != null, LazyJavaClassDescriptor.access$getUnsubstitutedMemberScope$p(LazyJavaClassDescriptor.this));
        }
    }

    static {
        new a(null);
        Sets5.setOf((Object[]) new String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"});
    }

    public /* synthetic */ LazyJavaClassDescriptor(context4 context4Var, DeclarationDescriptor declarationDescriptor, InterfaceC11574g interfaceC11574g, ClassDescriptor classDescriptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context4Var, declarationDescriptor, interfaceC11574g, (i & 8) != 0 ? null : classDescriptor);
    }

    public static final /* synthetic */ ClassDescriptor access$getAdditionalSupertypeClassDescriptor$p(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        return lazyJavaClassDescriptor.f23351t;
    }

    public static final /* synthetic */ context4 access$getC$p(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        return lazyJavaClassDescriptor.f23352u;
    }

    public static final /* synthetic */ LazyJavaClassMemberScope2 access$getUnsubstitutedMemberScope$p(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        return lazyJavaClassDescriptor.f23343A;
    }

    public final LazyJavaClassDescriptor copy$descriptors_jvm(JavaResolverCache javaResolverCache, ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        context4 context4Var = this.f23352u;
        context4 context4VarReplaceComponents = context.replaceComponents(context4Var, context4Var.getComponents().replace(javaResolverCache));
        DeclarationDescriptor containingDeclaration = getContainingDeclaration();
        Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        return new LazyJavaClassDescriptor(context4VarReplaceComponents, containingDeclaration, this.f23350s, classDescriptor);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public Annotations4 getAnnotations() {
        return this.f23347E;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.f23348F.invoke();
    }

    public final InterfaceC11574g getJClass() {
        return this.f23350s;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public ClassKind getKind() {
        return this.f23353v;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public Modality getModality() {
        return this.f23354w;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        if (this.f23354w != Modality.SEALED) {
            return Collections2.emptyList();
        }
        JavaTypeResolver attributes$default = JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, false, null, 3, null);
        Collection<javaTypes3> permittedTypes = this.f23350s.getPermittedTypes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = permittedTypes.iterator();
        while (it.hasNext()) {
            ClassifierDescriptor declarationDescriptor = this.f23352u.getTypeResolver().transformJavaType((javaTypes3) it.next(), attributes$default).getConstructor().getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            if (classDescriptor != null) {
                arrayList.add(classDescriptor);
            }
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public MemberScope3 getStaticScope() {
        return this.f23346D;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.f23357z;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public MemberScope3 getUnsubstitutedInnerClassesScope() {
        return this.f23345C;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ModuleAwareClassDescriptor
    public MemberScope3 getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return (LazyJavaClassMemberScope2) this.f23344B.getScope(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithVisibility, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        if (!Intrinsics3.areEqual(this.f23355x, DescriptorVisibilities.f23083a) || this.f23350s.getOuterClass() != null) {
            return utils2.toDescriptorVisibility(this.f23355x);
        }
        DescriptorVisibility2 descriptorVisibility2 = JavaDescriptorVisibilities.f23525a;
        Intrinsics3.checkNotNullExpressionValue(descriptorVisibility2, "{\n            JavaDescriptorVisibilities.PACKAGE_VISIBILITY\n        }");
        return descriptorVisibility2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isCompanionObject() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isData() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isFun() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return this.f23356y;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    public String toString() {
        return Intrinsics3.stringPlus("Lazy Java class ", DescriptorUtils2.getFqNameUnsafe(this));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassDescriptor(context4 context4Var, DeclarationDescriptor declarationDescriptor, InterfaceC11574g interfaceC11574g, ClassDescriptor classDescriptor) {
        Modality modalityConvertFromFlags;
        super(context4Var.getStorageManager(), declarationDescriptor, interfaceC11574g.getName(), context4Var.getComponents().getSourceElementFactory().source(interfaceC11574g), false);
        Intrinsics3.checkNotNullParameter(context4Var, "outerContext");
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(interfaceC11574g, "jClass");
        this.f23349r = context4Var;
        this.f23350s = interfaceC11574g;
        this.f23351t = classDescriptor;
        context4 context4VarChildForClassOrPackage$default = context.childForClassOrPackage$default(context4Var, this, interfaceC11574g, 0, 4, null);
        this.f23352u = context4VarChildForClassOrPackage$default;
        ((JavaResolverCache.a) context4VarChildForClassOrPackage$default.getComponents().getJavaResolverCache()).recordClass(interfaceC11574g, this);
        interfaceC11574g.getLightClassOriginKind();
        this.f23353v = interfaceC11574g.isAnnotationType() ? ClassKind.ANNOTATION_CLASS : interfaceC11574g.isInterface() ? ClassKind.INTERFACE : interfaceC11574g.isEnum() ? ClassKind.ENUM_CLASS : ClassKind.CLASS;
        if (interfaceC11574g.isAnnotationType() || interfaceC11574g.isEnum()) {
            modalityConvertFromFlags = Modality.FINAL;
        } else {
            modalityConvertFromFlags = Modality.f23104j.convertFromFlags(false, interfaceC11574g.isSealed() || interfaceC11574g.isAbstract() || interfaceC11574g.isInterface(), !interfaceC11574g.isFinal());
        }
        this.f23354w = modalityConvertFromFlags;
        this.f23355x = interfaceC11574g.getVisibility();
        this.f23356y = (interfaceC11574g.getOuterClass() == null || interfaceC11574g.isStatic()) ? false : true;
        this.f23357z = new b(this);
        LazyJavaClassMemberScope2 lazyJavaClassMemberScope2 = new LazyJavaClassMemberScope2(context4VarChildForClassOrPackage$default, this, interfaceC11574g, classDescriptor != null, null, 16, null);
        this.f23343A = lazyJavaClassMemberScope2;
        this.f23344B = ScopesHolderForClass.f23077a.create(this, context4VarChildForClassOrPackage$default.getStorageManager(), context4VarChildForClassOrPackage$default.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new d());
        this.f23345C = new InnerClassesScopeWrapper(lazyJavaClassMemberScope2);
        this.f23346D = new LazyJavaStaticClassScope2(context4VarChildForClassOrPackage$default, interfaceC11574g, this);
        this.f23347E = LazyJavaAnnotations2.resolveAnnotations(context4VarChildForClassOrPackage$default, interfaceC11574g);
        this.f23348F = context4VarChildForClassOrPackage$default.getStorageManager().createLazyValue(new c());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public List<ClassConstructorDescriptor> getConstructors() {
        return this.f23343A.getConstructors$descriptors_jvm().invoke();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public /* bridge */ /* synthetic */ MemberScope3 getUnsubstitutedMemberScope() {
        return getUnsubstitutedMemberScope();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public LazyJavaClassMemberScope2 getUnsubstitutedMemberScope() {
        return (LazyJavaClassMemberScope2) super.getUnsubstitutedMemberScope();
    }
}
