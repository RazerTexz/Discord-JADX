package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.JvmBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModalityUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.NotFoundClasses;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.descriptorUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.findClassInModule;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.annotationUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.AdditionalClassPartsProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.PlatformDependentDeclarationFilter;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.PlatformDependentDeclarationFilter2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ClassDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaClassMemberScope2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.SignatureBuildingComponents;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.methodSignatureBuildingUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.methodSignatureMapping3;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.OverridingUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.NameResolverUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage7;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitutor2;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.SmartSet;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: JvmBuiltInsCustomizer.kt */
/* renamed from: d0.e0.p.d.m0.b.q.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer2 implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {

    /* renamed from: a */
    public static final /* synthetic */ KProperty<Object>[] f22649a = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JvmBuiltInsCustomizer2.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JvmBuiltInsCustomizer2.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JvmBuiltInsCustomizer2.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};

    /* renamed from: b */
    public final ModuleDescriptor2 f22650b;

    /* renamed from: c */
    public final JavaToKotlinClassMapper f22651c;

    /* renamed from: d */
    public final storage5 f22652d;

    /* renamed from: e */
    public final KotlinType f22653e;

    /* renamed from: f */
    public final storage5 f22654f;

    /* renamed from: g */
    public final storage<FqName, ClassDescriptor> f22655g;

    /* renamed from: h */
    public final storage5 f22656h;

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* renamed from: d0.e0.p.d.m0.b.q.g$a */
    public enum a {
        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* renamed from: d0.e0.p.d.m0.b.q.g$b */
    public static final class b extends Lambda implements Function0<KotlinType4> {
        public final /* synthetic */ StorageManager $storageManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(StorageManager storageManager) {
            super(0);
            this.$storageManager = storageManager;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ KotlinType4 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KotlinType4 invoke() {
            return findClassInModule.findNonGenericClassAcrossDependencies(JvmBuiltInsCustomizer2.access$getSettings(JvmBuiltInsCustomizer2.this).getOwnerModuleDescriptor(), JvmBuiltInClassDescriptorFactory.f22631a.getCLONEABLE_CLASS_ID(), new NotFoundClasses(this.$storageManager, JvmBuiltInsCustomizer2.access$getSettings(JvmBuiltInsCustomizer2.this).getOwnerModuleDescriptor())).getDefaultType();
        }
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* renamed from: d0.e0.p.d.m0.b.q.g$c */
    public static final class c extends Lambda implements Function1<MemberScope3, Collection<? extends SimpleFunctionDescriptor>> {
        public final /* synthetic */ Name $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Name name) {
            super(1);
            this.$name = name;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Collection<? extends SimpleFunctionDescriptor> invoke(MemberScope3 memberScope3) {
            return invoke2(memberScope3);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<SimpleFunctionDescriptor> invoke2(MemberScope3 memberScope3) {
            Intrinsics3.checkNotNullParameter(memberScope3, "it");
            return memberScope3.getContributedFunctions(this.$name, LookupLocation3.FROM_BUILTINS);
        }
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* renamed from: d0.e0.p.d.m0.b.q.g$d */
    public static final class d extends Lambda implements Function0<Annotations4> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Annotations4 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Annotations4 invoke() {
            return Annotations4.f22735f.create(CollectionsJVM.listOf(annotationUtil.createDeprecatedAnnotation$default(JvmBuiltInsCustomizer2.access$getModuleDescriptor$p(JvmBuiltInsCustomizer2.this).getBuiltIns(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null)));
        }
    }

    public JvmBuiltInsCustomizer2(ModuleDescriptor2 moduleDescriptor2, StorageManager storageManager, Function0<JvmBuiltIns.b> function0) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(function0, "settingsComputation");
        this.f22650b = moduleDescriptor2;
        this.f22651c = JavaToKotlinClassMapper.f22630a;
        this.f22652d = storageManager.createLazyValue(function0);
        ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(new JvmBuiltInsCustomizer3(moduleDescriptor2, new FqName("java.io")), Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, CollectionsJVM.listOf(new SpecialTypes2(storageManager, new JvmBuiltInsCustomizer4(this))), SourceElement.f23099a, false, storageManager);
        classDescriptorImpl.initialize(MemberScope3.b.f24373b, Sets5.emptySet(), null);
        KotlinType4 defaultType = classDescriptorImpl.getDefaultType();
        Intrinsics3.checkNotNullExpressionValue(defaultType, "mockSerializableClass.defaultType");
        this.f22653e = defaultType;
        this.f22654f = storageManager.createLazyValue(new b(storageManager));
        this.f22655g = storageManager.createCacheWithNotNullValues();
        this.f22656h = storageManager.createLazyValue(new d());
    }

    public static final /* synthetic */ JavaToKotlinClassMapper access$getJ2kClassMapper$p(JvmBuiltInsCustomizer2 jvmBuiltInsCustomizer2) {
        return jvmBuiltInsCustomizer2.f22651c;
    }

    public static final /* synthetic */ LazyJavaClassDescriptor access$getJavaAnalogue(JvmBuiltInsCustomizer2 jvmBuiltInsCustomizer2, ClassDescriptor classDescriptor) {
        return jvmBuiltInsCustomizer2.m9381a(classDescriptor);
    }

    public static final /* synthetic */ ModuleDescriptor2 access$getModuleDescriptor$p(JvmBuiltInsCustomizer2 jvmBuiltInsCustomizer2) {
        return jvmBuiltInsCustomizer2.f22650b;
    }

    public static final /* synthetic */ JvmBuiltIns.b access$getSettings(JvmBuiltInsCustomizer2 jvmBuiltInsCustomizer2) {
        return jvmBuiltInsCustomizer2.m9382b();
    }

    /* renamed from: a */
    public final LazyJavaClassDescriptor m9381a(ClassDescriptor classDescriptor) {
        if (KotlinBuiltIns.isAny(classDescriptor) || !KotlinBuiltIns.isUnderKotlinPackage(classDescriptor)) {
            return null;
        }
        FqNameUnsafe fqNameUnsafe = DescriptorUtils2.getFqNameUnsafe(classDescriptor);
        if (!fqNameUnsafe.isSafe()) {
            return null;
        }
        ClassId classIdMapKotlinToJava = JavaToKotlinClassMap.f22614a.mapKotlinToJava(fqNameUnsafe);
        FqName fqNameAsSingleFqName = classIdMapKotlinToJava == null ? null : classIdMapKotlinToJava.asSingleFqName();
        if (fqNameAsSingleFqName == null) {
            return null;
        }
        ClassDescriptor classDescriptorResolveClassByFqName = descriptorUtil.resolveClassByFqName(m9382b().getOwnerModuleDescriptor(), fqNameAsSingleFqName, LookupLocation3.FROM_BUILTINS);
        if (classDescriptorResolveClassByFqName instanceof LazyJavaClassDescriptor) {
            return (LazyJavaClassDescriptor) classDescriptorResolveClassByFqName;
        }
        return null;
    }

    /* renamed from: b */
    public final JvmBuiltIns.b m9382b() {
        return (JvmBuiltIns.b) storage7.getValue(this.f22652d, this, (KProperty<?>) f22649a[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e2  */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.AdditionalClassPartsProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor classDescriptor) {
        ClassDescriptor classDescriptorMapJavaToKotlin$default;
        boolean z2;
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (classDescriptor.getKind() != ClassKind.CLASS || !m9382b().isAdditionalBuiltInsFeatureSupported()) {
            return Collections2.emptyList();
        }
        LazyJavaClassDescriptor lazyJavaClassDescriptorM9381a = m9381a(classDescriptor);
        if (lazyJavaClassDescriptorM9381a != null && (classDescriptorMapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(this.f22651c, DescriptorUtils2.getFqNameSafe(lazyJavaClassDescriptorM9381a), JvmBuiltInsCustomizer.f22612f.getInstance(), null, 4, null)) != null) {
            TypeSubstitutor2 typeSubstitutor2BuildSubstitutor = mappingUtil.createMappedTypeParametersSubstitution(classDescriptorMapJavaToKotlin$default, lazyJavaClassDescriptorM9381a).buildSubstitutor();
            List<ClassConstructorDescriptor> constructors = lazyJavaClassDescriptorM9381a.getConstructors();
            ArrayList<ClassConstructorDescriptor> arrayList = new ArrayList();
            Iterator<T> it = constructors.iterator();
            while (true) {
                boolean z3 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) next;
                if (classConstructorDescriptor.getVisibility().isPublicAPI()) {
                    Collection<ClassConstructorDescriptor> constructors2 = classDescriptorMapJavaToKotlin$default.getConstructors();
                    Intrinsics3.checkNotNullExpressionValue(constructors2, "defaultKotlinVersion.constructors");
                    if (constructors2.isEmpty()) {
                        z2 = true;
                        if (z2) {
                            if (classConstructorDescriptor.getValueParameters().size() == 1) {
                                List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                                Intrinsics3.checkNotNullExpressionValue(valueParameters, "valueParameters");
                                ClassifierDescriptor declarationDescriptor = ((ValueParameterDescriptor) _Collections.single((List) valueParameters)).getType().getConstructor().getDeclarationDescriptor();
                                boolean z4 = Intrinsics3.areEqual(declarationDescriptor == null ? null : DescriptorUtils2.getFqNameUnsafe(declarationDescriptor), DescriptorUtils2.getFqNameUnsafe(classDescriptor));
                                if (!z4 && !KotlinBuiltIns.isDeprecated(classConstructorDescriptor) && !JvmBuiltInsSignatures.f22666a.getHIDDEN_CONSTRUCTOR_SIGNATURES().contains(methodSignatureBuildingUtils.signature(SignatureBuildingComponents.f23636a, lazyJavaClassDescriptorM9381a, methodSignatureMapping3.computeJvmDescriptor$default(classConstructorDescriptor, false, false, 3, null)))) {
                                    z3 = true;
                                }
                            }
                        }
                    } else {
                        for (ClassConstructorDescriptor classConstructorDescriptor2 : constructors2) {
                            Intrinsics3.checkNotNullExpressionValue(classConstructorDescriptor2, "it");
                            if (OverridingUtil.getBothWaysOverridability(classConstructorDescriptor2, classConstructorDescriptor.substitute(typeSubstitutor2BuildSubstitutor)) == OverridingUtil.d.a.OVERRIDABLE) {
                                z2 = false;
                                break;
                            }
                        }
                        z2 = true;
                        if (z2) {
                        }
                    }
                }
                if (z3) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            for (ClassConstructorDescriptor classConstructorDescriptor3 : arrayList) {
                FunctionDescriptor.a<? extends FunctionDescriptor> aVarNewCopyBuilder = classConstructorDescriptor3.newCopyBuilder();
                aVarNewCopyBuilder.setOwner(classDescriptor);
                aVarNewCopyBuilder.setReturnType(classDescriptor.getDefaultType());
                aVarNewCopyBuilder.setPreserveSourceElement();
                aVarNewCopyBuilder.setSubstitution(typeSubstitutor2BuildSubstitutor.getSubstitution());
                if (!JvmBuiltInsSignatures.f22666a.getVISIBLE_CONSTRUCTOR_SIGNATURES().contains(methodSignatureBuildingUtils.signature(SignatureBuildingComponents.f23636a, lazyJavaClassDescriptorM9381a, methodSignatureMapping3.computeJvmDescriptor$default(classConstructorDescriptor3, false, false, 3, null)))) {
                    aVarNewCopyBuilder.setAdditionalAnnotations((Annotations4) storage7.getValue(this.f22656h, this, (KProperty<?>) f22649a[2]));
                }
                FunctionDescriptor functionDescriptorBuild = aVarNewCopyBuilder.build();
                Objects.requireNonNull(functionDescriptorBuild, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                arrayList2.add((ClassConstructorDescriptor) functionDescriptorBuild);
            }
            return arrayList2;
        }
        return Collections2.emptyList();
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ed  */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.AdditionalClassPartsProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<SimpleFunctionDescriptor> getFunctions(Name name, ClassDescriptor classDescriptor) {
        List<SimpleFunctionDescriptor> listEmptyList;
        boolean z2;
        boolean z3;
        boolean zBooleanValue;
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        boolean z4 = false;
        if (Intrinsics3.areEqual(name, CloneableClassScope.f22610e.getCLONE_NAME()) && (classDescriptor instanceof DeserializedClassDescriptor) && KotlinBuiltIns.isArrayOrPrimitiveArray(classDescriptor)) {
            DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) classDescriptor;
            List<C11684i> functionList = deserializedClassDescriptor.getClassProto().getFunctionList();
            Intrinsics3.checkNotNullExpressionValue(functionList, "classDescriptor.classProto.functionList");
            if (!(functionList instanceof Collection) || !functionList.isEmpty()) {
                Iterator<T> it = functionList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (Intrinsics3.areEqual(NameResolverUtil.getName(deserializedClassDescriptor.getC().getNameResolver(), ((C11684i) it.next()).getName()), CloneableClassScope.f22610e.getCLONE_NAME())) {
                        z4 = true;
                        break;
                    }
                }
            }
            if (z4) {
                return Collections2.emptyList();
            }
            FunctionDescriptor.a<? extends SimpleFunctionDescriptor> aVarNewCopyBuilder = ((SimpleFunctionDescriptor) _Collections.single(((KotlinType4) storage7.getValue(this.f22654f, this, (KProperty<?>) f22649a[1])).getMemberScope().getContributedFunctions(name, LookupLocation3.FROM_BUILTINS))).newCopyBuilder();
            aVarNewCopyBuilder.setOwner(deserializedClassDescriptor);
            aVarNewCopyBuilder.setVisibility(DescriptorVisibilities.f23087e);
            aVarNewCopyBuilder.setReturnType(deserializedClassDescriptor.getDefaultType());
            aVarNewCopyBuilder.setDispatchReceiverParameter(deserializedClassDescriptor.getThisAsReceiverParameter());
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) aVarNewCopyBuilder.build();
            Intrinsics3.checkNotNull(simpleFunctionDescriptor2);
            return CollectionsJVM.listOf(simpleFunctionDescriptor2);
        }
        if (!m9382b().isAdditionalBuiltInsFeatureSupported()) {
            return Collections2.emptyList();
        }
        c cVar = new c(name);
        LazyJavaClassDescriptor lazyJavaClassDescriptorM9381a = m9381a(classDescriptor);
        if (lazyJavaClassDescriptorM9381a == null) {
            listEmptyList = Collections2.emptyList();
        } else {
            Collection<ClassDescriptor> collectionMapPlatformClass = this.f22651c.mapPlatformClass(DescriptorUtils2.getFqNameSafe(lazyJavaClassDescriptorM9381a), JvmBuiltInsCustomizer.f22612f.getInstance());
            ClassDescriptor classDescriptor2 = (ClassDescriptor) _Collections.lastOrNull(collectionMapPlatformClass);
            if (classDescriptor2 == null) {
                listEmptyList = Collections2.emptyList();
            } else {
                SmartSet.b bVar = SmartSet.f25003j;
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collectionMapPlatformClass, 10));
                Iterator<T> it2 = collectionMapPlatformClass.iterator();
                while (it2.hasNext()) {
                    arrayList.add(DescriptorUtils2.getFqNameSafe((ClassDescriptor) it2.next()));
                }
                SmartSet smartSetCreate = bVar.create(arrayList);
                boolean zIsMutable = this.f22651c.isMutable(classDescriptor);
                MemberScope3 unsubstitutedMemberScope = ((ClassDescriptor) ((LockBasedStorageManager.d) this.f22655g).computeIfAbsent(DescriptorUtils2.getFqNameSafe(lazyJavaClassDescriptorM9381a), new JvmBuiltInsCustomizer5(lazyJavaClassDescriptorM9381a, classDescriptor2))).getUnsubstitutedMemberScope();
                Intrinsics3.checkNotNullExpressionValue(unsubstitutedMemberScope, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
                Collection<? extends SimpleFunctionDescriptor> collectionInvoke = cVar.invoke(unsubstitutedMemberScope);
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : collectionInvoke) {
                    SimpleFunctionDescriptor simpleFunctionDescriptor3 = (SimpleFunctionDescriptor) obj;
                    if (simpleFunctionDescriptor3.getKind() == CallableMemberDescriptor.a.DECLARATION && simpleFunctionDescriptor3.getVisibility().isPublicAPI() && !KotlinBuiltIns.isDeprecated(simpleFunctionDescriptor3)) {
                        Collection<? extends FunctionDescriptor> overriddenDescriptors = simpleFunctionDescriptor3.getOverriddenDescriptors();
                        Intrinsics3.checkNotNullExpressionValue(overriddenDescriptors, "analogueMember.overriddenDescriptors");
                        if (overriddenDescriptors.isEmpty()) {
                            z3 = false;
                            if (z3) {
                                if (JvmBuiltInsSignatures.f22666a.getMUTABLE_METHOD_SIGNATURES().contains(methodSignatureBuildingUtils.signature(SignatureBuildingComponents.f23636a, (ClassDescriptor) simpleFunctionDescriptor3.getContainingDeclaration(), methodSignatureMapping3.computeJvmDescriptor$default(simpleFunctionDescriptor3, false, false, 3, null))) ^ zIsMutable) {
                                    zBooleanValue = true;
                                } else {
                                    Boolean boolIfAny = DFS.ifAny(CollectionsJVM.listOf(simpleFunctionDescriptor3), JvmBuiltInsCustomizer8.f22665a, new JvmBuiltInsCustomizer9(this));
                                    Intrinsics3.checkNotNullExpressionValue(boolIfAny, "private fun SimpleFunctionDescriptor.isMutabilityViolation(isMutable: Boolean): Boolean {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n\n        if ((SignatureBuildingComponents.signature(owner, jvmDescriptor) in MUTABLE_METHOD_SIGNATURES) xor isMutable) return true\n\n        return DFS.ifAny<CallableMemberDescriptor>(\n            listOf(this),\n            { it.original.overriddenDescriptors }\n        ) { overridden ->\n            overridden.kind == CallableMemberDescriptor.Kind.DECLARATION &&\n                    j2kClassMapper.isMutable(overridden.containingDeclaration as ClassDescriptor)\n        }\n    }");
                                    zBooleanValue = boolIfAny.booleanValue();
                                }
                                if (!zBooleanValue) {
                                    z2 = true;
                                }
                            } else {
                                z2 = false;
                            }
                        } else {
                            Iterator<T> it3 = overriddenDescriptors.iterator();
                            while (it3.hasNext()) {
                                DeclarationDescriptor containingDeclaration = ((FunctionDescriptor) it3.next()).getContainingDeclaration();
                                Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "it.containingDeclaration");
                                if (smartSetCreate.contains(DescriptorUtils2.getFqNameSafe(containingDeclaration))) {
                                    z3 = true;
                                    break;
                                }
                            }
                            z3 = false;
                            if (z3) {
                            }
                        }
                    }
                    if (z2) {
                        arrayList2.add(obj);
                    }
                }
                listEmptyList = arrayList2;
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (SimpleFunctionDescriptor simpleFunctionDescriptor4 : listEmptyList) {
            FunctionDescriptor functionDescriptorSubstitute = simpleFunctionDescriptor4.substitute(mappingUtil.createMappedTypeParametersSubstitution((ClassDescriptor) simpleFunctionDescriptor4.getContainingDeclaration(), classDescriptor).buildSubstitutor());
            Objects.requireNonNull(functionDescriptorSubstitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
            FunctionDescriptor.a<? extends SimpleFunctionDescriptor> aVarNewCopyBuilder2 = ((SimpleFunctionDescriptor) functionDescriptorSubstitute).newCopyBuilder();
            aVarNewCopyBuilder2.setOwner(classDescriptor);
            aVarNewCopyBuilder2.setDispatchReceiverParameter(classDescriptor.getThisAsReceiverParameter());
            aVarNewCopyBuilder2.setPreserveSourceElement();
            Object objDfs = DFS.dfs(CollectionsJVM.listOf((ClassDescriptor) simpleFunctionDescriptor4.getContainingDeclaration()), new JvmBuiltInsCustomizer6(this), new JvmBuiltInsCustomizer7(methodSignatureMapping3.computeJvmDescriptor$default(simpleFunctionDescriptor4, false, false, 3, null), new Ref$ObjectRef()));
            Intrinsics3.checkNotNullExpressionValue(objDfs, "private fun FunctionDescriptor.getJdkMethodStatus(): JDKMemberStatus {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n        var result: JDKMemberStatus? = null\n        return DFS.dfs<ClassDescriptor, JDKMemberStatus>(\n            listOf(owner),\n            {\n                // Search through mapped supertypes to determine that Set.toArray should be invisible, while we have only\n                // Collection.toArray there explicitly\n                // Note, that we can't find j.u.Collection.toArray within overriddenDescriptors of j.u.Set.toArray\n                it.typeConstructor.supertypes.mapNotNull {\n                    (it.constructor.declarationDescriptor?.original as? ClassDescriptor)?.getJavaAnalogue()\n                }\n            },\n            object : DFS.AbstractNodeHandler<ClassDescriptor, JDKMemberStatus>() {\n                override fun beforeChildren(javaClassDescriptor: ClassDescriptor): Boolean {\n                    val signature = SignatureBuildingComponents.signature(javaClassDescriptor, jvmDescriptor)\n                    when (signature) {\n                        in HIDDEN_METHOD_SIGNATURES -> result = JDKMemberStatus.HIDDEN\n                        in VISIBLE_METHOD_SIGNATURES -> result = JDKMemberStatus.VISIBLE\n                        in DROP_LIST_METHOD_SIGNATURES -> result = JDKMemberStatus.DROP\n                    }\n\n                    return result == null\n                }\n\n                override fun result() = result ?: JDKMemberStatus.NOT_CONSIDERED\n            })\n    }");
            int iOrdinal = ((a) objDfs).ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 2) {
                    aVarNewCopyBuilder2.setAdditionalAnnotations((Annotations4) storage7.getValue(this.f22656h, this, (KProperty<?>) f22649a[2]));
                } else if (iOrdinal == 3) {
                    simpleFunctionDescriptor = null;
                }
                simpleFunctionDescriptor = (SimpleFunctionDescriptor) aVarNewCopyBuilder2.build();
                Intrinsics3.checkNotNull(simpleFunctionDescriptor);
            } else {
                if (!ModalityUtils.isFinalClass(classDescriptor)) {
                    aVarNewCopyBuilder2.setHiddenForResolutionEverywhereBesideSupercalls();
                    simpleFunctionDescriptor = (SimpleFunctionDescriptor) aVarNewCopyBuilder2.build();
                    Intrinsics3.checkNotNull(simpleFunctionDescriptor);
                }
                simpleFunctionDescriptor = null;
            }
            if (simpleFunctionDescriptor != null) {
                arrayList3.add(simpleFunctionDescriptor);
            }
        }
        return arrayList3;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.AdditionalClassPartsProvider
    public /* bridge */ /* synthetic */ Collection getFunctionsNames(ClassDescriptor classDescriptor) {
        return getFunctionsNames(classDescriptor);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.AdditionalClassPartsProvider
    public Collection<KotlinType> getSupertypes(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        FqNameUnsafe fqNameUnsafe = DescriptorUtils2.getFqNameUnsafe(classDescriptor);
        JvmBuiltInsSignatures jvmBuiltInsSignatures = JvmBuiltInsSignatures.f22666a;
        if (!jvmBuiltInsSignatures.isArrayOrPrimitiveArray(fqNameUnsafe)) {
            return jvmBuiltInsSignatures.isSerializableInJava(fqNameUnsafe) ? CollectionsJVM.listOf(this.f22653e) : Collections2.emptyList();
        }
        KotlinType4 kotlinType4 = (KotlinType4) storage7.getValue(this.f22654f, this, (KProperty<?>) f22649a[1]);
        Intrinsics3.checkNotNullExpressionValue(kotlinType4, "cloneableType");
        return Collections2.listOf((Object[]) new KotlinType[]{kotlinType4, this.f22653e});
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.PlatformDependentDeclarationFilter
    public boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        Intrinsics3.checkNotNullParameter(simpleFunctionDescriptor, "functionDescriptor");
        LazyJavaClassDescriptor lazyJavaClassDescriptorM9381a = m9381a(classDescriptor);
        if (lazyJavaClassDescriptorM9381a == null || !simpleFunctionDescriptor.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilter2.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME())) {
            return true;
        }
        if (!m9382b().isAdditionalBuiltInsFeatureSupported()) {
            return false;
        }
        String strComputeJvmDescriptor$default = methodSignatureMapping3.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, null);
        LazyJavaClassMemberScope2 unsubstitutedMemberScope = lazyJavaClassDescriptorM9381a.getUnsubstitutedMemberScope();
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics3.checkNotNullExpressionValue(name, "functionDescriptor.name");
        Collection<SimpleFunctionDescriptor> contributedFunctions = unsubstitutedMemberScope.getContributedFunctions(name, LookupLocation3.FROM_BUILTINS);
        if (!(contributedFunctions instanceof Collection) || !contributedFunctions.isEmpty()) {
            Iterator<T> it = contributedFunctions.iterator();
            while (it.hasNext()) {
                if (Intrinsics3.areEqual(methodSignatureMapping3.computeJvmDescriptor$default((SimpleFunctionDescriptor) it.next(), false, false, 3, null), strComputeJvmDescriptor$default)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.AdditionalClassPartsProvider
    public Set<Name> getFunctionsNames(ClassDescriptor classDescriptor) {
        LazyJavaClassMemberScope2 unsubstitutedMemberScope;
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (!m9382b().isAdditionalBuiltInsFeatureSupported()) {
            return Sets5.emptySet();
        }
        LazyJavaClassDescriptor lazyJavaClassDescriptorM9381a = m9381a(classDescriptor);
        Set<Name> functionNames = null;
        if (lazyJavaClassDescriptorM9381a != null && (unsubstitutedMemberScope = lazyJavaClassDescriptorM9381a.getUnsubstitutedMemberScope()) != null) {
            functionNames = unsubstitutedMemberScope.getFunctionNames();
        }
        return functionNames == null ? Sets5.emptySet() : functionNames;
    }
}
