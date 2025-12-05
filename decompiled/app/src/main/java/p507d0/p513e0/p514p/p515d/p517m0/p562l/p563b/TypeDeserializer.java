package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KDeclarationContainer;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.functionTypes;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.suspendFunctionTypes;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.findClassInModule;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.Flags2;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.protoTypeTableUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedAnnotations;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedTypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.StarProjectionImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.StarProjectionImpl2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjectionImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p578f0.C12075n;
import p507d0.p578f0._Sequences2;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReference;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: TypeDeserializer.kt */
/* renamed from: d0.e0.p.d.m0.l.b.c0, reason: use source file name */
/* loaded from: classes3.dex */
public final class TypeDeserializer {

    /* renamed from: a */
    public final context6 f24503a;

    /* renamed from: b */
    public final TypeDeserializer f24504b;

    /* renamed from: c */
    public final String f24505c;

    /* renamed from: d */
    public final String f24506d;

    /* renamed from: e */
    public boolean f24507e;

    /* renamed from: f */
    public final Function1<Integer, ClassifierDescriptor> f24508f;

    /* renamed from: g */
    public final Function1<Integer, ClassifierDescriptor> f24509g;

    /* renamed from: h */
    public final Map<Integer, TypeParameterDescriptor> f24510h;

    /* compiled from: TypeDeserializer.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.c0$a */
    public static final class a extends Lambda implements Function1<Integer, ClassifierDescriptor> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ClassifierDescriptor invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final ClassifierDescriptor invoke(int i) {
            return TypeDeserializer.access$computeClassifierDescriptor(TypeDeserializer.this, i);
        }
    }

    /* compiled from: TypeDeserializer.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.c0$b */
    public static final class b extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
        public final /* synthetic */ C11692q $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C11692q c11692q) {
            super(0);
            this.$proto = c11692q;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends AnnotationDescriptor> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends AnnotationDescriptor> invoke2() {
            return TypeDeserializer.access$getC$p(TypeDeserializer.this).getComponents().getAnnotationAndConstantLoader().loadTypeAnnotations(this.$proto, TypeDeserializer.access$getC$p(TypeDeserializer.this).getNameResolver());
        }
    }

    /* compiled from: TypeDeserializer.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.c0$c */
    public static final class c extends Lambda implements Function1<Integer, ClassifierDescriptor> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ClassifierDescriptor invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final ClassifierDescriptor invoke(int i) {
            return TypeDeserializer.access$computeTypeAliasDescriptor(TypeDeserializer.this, i);
        }
    }

    /* compiled from: TypeDeserializer.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.c0$d */
    public /* synthetic */ class d extends FunctionReference implements Function1<ClassId, ClassId> {

        /* renamed from: j */
        public static final d f24511j = new d();

        public d() {
            super(1);
        }

        @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(ClassId.class);
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ClassId invoke(ClassId classId) {
            return invoke2(classId);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ClassId invoke2(ClassId classId) {
            Intrinsics3.checkNotNullParameter(classId, "p0");
            return classId.getOuterClassId();
        }
    }

    /* compiled from: TypeDeserializer.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.c0$e */
    public static final class e extends Lambda implements Function1<C11692q, C11692q> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ C11692q invoke(C11692q c11692q) {
            return invoke2(c11692q);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final C11692q invoke2(C11692q c11692q) {
            Intrinsics3.checkNotNullParameter(c11692q, "it");
            return protoTypeTableUtil.outerType(c11692q, TypeDeserializer.access$getC$p(TypeDeserializer.this).getTypeTable());
        }
    }

    /* compiled from: TypeDeserializer.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.c0$f */
    public static final class f extends Lambda implements Function1<C11692q, Integer> {

        /* renamed from: j */
        public static final f f24512j = new f();

        public f() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(C11692q c11692q) {
            Intrinsics3.checkNotNullParameter(c11692q, "it");
            return c11692q.getArgumentCount();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(C11692q c11692q) {
            return Integer.valueOf(invoke2(c11692q));
        }
    }

    public TypeDeserializer(context6 context6Var, TypeDeserializer typeDeserializer, List<C11694s> list, String str, String str2, boolean z2) {
        Map<Integer, TypeParameterDescriptor> linkedHashMap;
        Intrinsics3.checkNotNullParameter(context6Var, "c");
        Intrinsics3.checkNotNullParameter(list, "typeParameterProtos");
        Intrinsics3.checkNotNullParameter(str, "debugName");
        Intrinsics3.checkNotNullParameter(str2, "containerPresentableName");
        this.f24503a = context6Var;
        this.f24504b = typeDeserializer;
        this.f24505c = str;
        this.f24506d = str2;
        this.f24507e = z2;
        this.f24508f = context6Var.getStorageManager().createMemoizedFunctionWithNullableValues(new a());
        this.f24509g = context6Var.getStorageManager().createMemoizedFunctionWithNullableValues(new c());
        if (list.isEmpty()) {
            linkedHashMap = Maps6.emptyMap();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i = 0;
            for (C11694s c11694s : list) {
                linkedHashMap.put(Integer.valueOf(c11694s.getId()), new DeserializedTypeParameterDescriptor(this.f24503a, c11694s, i));
                i++;
            }
        }
        this.f24510h = linkedHashMap;
    }

    public static final ClassifierDescriptor access$computeClassifierDescriptor(TypeDeserializer typeDeserializer, int i) {
        ClassId classId = NameResolverUtil.getClassId(typeDeserializer.f24503a.getNameResolver(), i);
        return classId.isLocal() ? typeDeserializer.f24503a.getComponents().deserializeClass(classId) : findClassInModule.findClassifierAcrossModuleDependencies(typeDeserializer.f24503a.getComponents().getModuleDescriptor(), classId);
    }

    public static final ClassifierDescriptor access$computeTypeAliasDescriptor(TypeDeserializer typeDeserializer, int i) {
        ClassId classId = NameResolverUtil.getClassId(typeDeserializer.f24503a.getNameResolver(), i);
        if (classId.isLocal()) {
            return null;
        }
        return findClassInModule.findTypeAliasAcrossModuleDependencies(typeDeserializer.f24503a.getComponents().getModuleDescriptor(), classId);
    }

    public static final /* synthetic */ context6 access$getC$p(TypeDeserializer typeDeserializer) {
        return typeDeserializer.f24503a;
    }

    /* renamed from: c */
    public static final List<C11692q.b> m9947c(C11692q c11692q, TypeDeserializer typeDeserializer) {
        List<C11692q.b> argumentList = c11692q.getArgumentList();
        Intrinsics3.checkNotNullExpressionValue(argumentList, "argumentList");
        C11692q c11692qOuterType = protoTypeTableUtil.outerType(c11692q, typeDeserializer.f24503a.getTypeTable());
        List<C11692q.b> listM9947c = c11692qOuterType == null ? null : m9947c(c11692qOuterType, typeDeserializer);
        if (listM9947c == null) {
            listM9947c = Collections2.emptyList();
        }
        return _Collections.plus((Collection) argumentList, (Iterable) listM9947c);
    }

    /* renamed from: d */
    public static final ClassDescriptor m9948d(TypeDeserializer typeDeserializer, C11692q c11692q, int i) {
        ClassId classId = NameResolverUtil.getClassId(typeDeserializer.f24503a.getNameResolver(), i);
        List<Integer> mutableList = _Sequences2.toMutableList(_Sequences2.map(C12075n.generateSequence(c11692q, typeDeserializer.new e()), f.f24512j));
        int iCount = _Sequences2.count(C12075n.generateSequence(classId, d.f24511j));
        while (mutableList.size() < iCount) {
            mutableList.add(0);
        }
        return typeDeserializer.f24503a.getComponents().getNotFoundClasses().getClass(classId, mutableList);
    }

    public static /* synthetic */ KotlinType4 simpleType$default(TypeDeserializer typeDeserializer, C11692q c11692q, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return typeDeserializer.simpleType(c11692q, z2);
    }

    /* renamed from: a */
    public final KotlinType4 m9949a(int i) {
        if (NameResolverUtil.getClassId(this.f24503a.getNameResolver(), i).isLocal()) {
            return this.f24503a.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    /* renamed from: b */
    public final KotlinType4 m9950b(KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinBuiltIns builtIns = TypeUtils2.getBuiltIns(kotlinType);
        Annotations4 annotations = kotlinType.getAnnotations();
        KotlinType receiverTypeFromFunctionType = functionTypes.getReceiverTypeFromFunctionType(kotlinType);
        List listDropLast = _Collections.dropLast(functionTypes.getValueParameterTypesFromFunctionType(kotlinType), 1);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listDropLast, 10));
        Iterator it = listDropLast.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeProjection) it.next()).getType());
        }
        return functionTypes.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, arrayList, null, kotlinType2, true).makeNullableAsSpecified(kotlinType.isMarkedNullable());
    }

    /* renamed from: e */
    public final TypeConstructor m9951e(int i) {
        TypeParameterDescriptor typeParameterDescriptor = this.f24510h.get(Integer.valueOf(i));
        TypeConstructor typeConstructor = typeParameterDescriptor == null ? null : typeParameterDescriptor.getTypeConstructor();
        if (typeConstructor != null) {
            return typeConstructor;
        }
        TypeDeserializer typeDeserializer = this.f24504b;
        if (typeDeserializer == null) {
            return null;
        }
        return typeDeserializer.m9951e(i);
    }

    public final boolean getExperimentalSuspendFunctionTypeEncountered() {
        return this.f24507e;
    }

    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        return _Collections.toList(this.f24510h.values());
    }

    public final KotlinType4 simpleType(C11692q c11692q, boolean z2) {
        TypeConstructor typeConstructorCreateErrorTypeConstructor;
        Object next;
        KotlinType4 kotlinType4SimpleType$default;
        int size;
        KotlinType4 kotlinType4WithAbbreviation;
        Object typeProjectionImpl;
        Intrinsics3.checkNotNullParameter(c11692q, "proto");
        KotlinType4 kotlinType4SimpleType$default2 = null;
        kotlinType4SimpleType$default2 = null;
        kotlinType4SimpleType$default2 = null;
        kotlinType4SimpleType$default2 = null;
        KotlinType4 kotlinType4M9949a = c11692q.hasClassName() ? m9949a(c11692q.getClassName()) : c11692q.hasTypeAliasName() ? m9949a(c11692q.getTypeAliasName()) : null;
        if (kotlinType4M9949a != null) {
            return kotlinType4M9949a;
        }
        if (c11692q.hasClassName()) {
            ClassifierDescriptor classifierDescriptorInvoke = this.f24508f.invoke(Integer.valueOf(c11692q.getClassName()));
            if (classifierDescriptorInvoke == null) {
                classifierDescriptorInvoke = m9948d(this, c11692q, c11692q.getClassName());
            }
            typeConstructorCreateErrorTypeConstructor = classifierDescriptorInvoke.getTypeConstructor();
            Intrinsics3.checkNotNullExpressionValue(typeConstructorCreateErrorTypeConstructor, "classifierDescriptors(proto.className) ?: notFoundClass(proto.className)).typeConstructor");
        } else if (c11692q.hasTypeParameter()) {
            typeConstructorCreateErrorTypeConstructor = m9951e(c11692q.getTypeParameter());
            if (typeConstructorCreateErrorTypeConstructor == null) {
                StringBuilder sbM833U = outline.m833U("Unknown type parameter ");
                sbM833U.append(c11692q.getTypeParameter());
                sbM833U.append(". Please try recompiling module containing \"");
                sbM833U.append(this.f24506d);
                sbM833U.append('\"');
                typeConstructorCreateErrorTypeConstructor = ErrorUtils.createErrorTypeConstructor(sbM833U.toString());
                Intrinsics3.checkNotNullExpressionValue(typeConstructorCreateErrorTypeConstructor, "createErrorTypeConstructor(\n                        \"Unknown type parameter ${proto.typeParameter}. Please try recompiling module containing \\\"$containerPresentableName\\\"\"\n                    )");
            }
        } else if (c11692q.hasTypeParameterName()) {
            DeclarationDescriptor containingDeclaration = this.f24503a.getContainingDeclaration();
            String string = this.f24503a.getNameResolver().getString(c11692q.getTypeParameterName());
            Iterator<T> it = getOwnTypeParameters().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics3.areEqual(((TypeParameterDescriptor) next).getName().asString(), string)) {
                    break;
                }
            }
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) next;
            TypeConstructor typeConstructor = typeParameterDescriptor == null ? null : typeParameterDescriptor.getTypeConstructor();
            typeConstructorCreateErrorTypeConstructor = typeConstructor == null ? ErrorUtils.createErrorTypeConstructor("Deserialized type parameter " + string + " in " + containingDeclaration) : typeConstructor;
            Intrinsics3.checkNotNullExpressionValue(typeConstructorCreateErrorTypeConstructor, "{\n                val container = c.containingDeclaration\n                val name = c.nameResolver.getString(proto.typeParameterName)\n                val parameter = ownTypeParameters.find { it.name.asString() == name }\n                parameter?.typeConstructor ?: ErrorUtils.createErrorTypeConstructor(\"Deserialized type parameter $name in $container\")\n            }");
        } else if (c11692q.hasTypeAliasName()) {
            ClassifierDescriptor classifierDescriptorInvoke2 = this.f24509g.invoke(Integer.valueOf(c11692q.getTypeAliasName()));
            if (classifierDescriptorInvoke2 == null) {
                classifierDescriptorInvoke2 = m9948d(this, c11692q, c11692q.getTypeAliasName());
            }
            typeConstructorCreateErrorTypeConstructor = classifierDescriptorInvoke2.getTypeConstructor();
            Intrinsics3.checkNotNullExpressionValue(typeConstructorCreateErrorTypeConstructor, "typeAliasDescriptors(proto.typeAliasName) ?: notFoundClass(proto.typeAliasName)).typeConstructor");
        } else {
            typeConstructorCreateErrorTypeConstructor = ErrorUtils.createErrorTypeConstructor("Unknown type");
            Intrinsics3.checkNotNullExpressionValue(typeConstructorCreateErrorTypeConstructor, "createErrorTypeConstructor(\"Unknown type\")");
        }
        if (ErrorUtils.isError(typeConstructorCreateErrorTypeConstructor.getDeclarationDescriptor())) {
            KotlinType4 kotlinType4CreateErrorTypeWithCustomConstructor = ErrorUtils.createErrorTypeWithCustomConstructor(typeConstructorCreateErrorTypeConstructor.toString(), typeConstructorCreateErrorTypeConstructor);
            Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorTypeWithCustomConstructor, "createErrorTypeWithCustomConstructor(constructor.toString(), constructor)");
            return kotlinType4CreateErrorTypeWithCustomConstructor;
        }
        DeserializedAnnotations deserializedAnnotations = new DeserializedAnnotations(this.f24503a.getStorageManager(), new b(c11692q));
        List<C11692q.b> listM9947c = m9947c(c11692q, this);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listM9947c, 10));
        int i = 0;
        for (Object obj : listM9947c) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            C11692q.b bVar = (C11692q.b) obj;
            List<TypeParameterDescriptor> parameters = typeConstructorCreateErrorTypeConstructor.getParameters();
            Intrinsics3.checkNotNullExpressionValue(parameters, "constructor.parameters");
            TypeParameterDescriptor typeParameterDescriptor2 = (TypeParameterDescriptor) _Collections.getOrNull(parameters, i);
            if (bVar.getProjection() == C11692q.b.c.STAR) {
                typeProjectionImpl = typeParameterDescriptor2 == null ? new StarProjectionImpl(this.f24503a.getComponents().getModuleDescriptor().getBuiltIns()) : new StarProjectionImpl2(typeParameterDescriptor2);
            } else {
                ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.f24700a;
                C11692q.b.c projection = bVar.getProjection();
                Intrinsics3.checkNotNullExpressionValue(projection, "typeArgumentProto.projection");
                Variance variance = protoEnumFlags.variance(projection);
                C11692q c11692qType = protoTypeTableUtil.type(bVar, this.f24503a.getTypeTable());
                typeProjectionImpl = c11692qType == null ? new TypeProjectionImpl(ErrorUtils.createErrorType("No type recorded")) : new TypeProjectionImpl(variance, type(c11692qType));
            }
            arrayList.add(typeProjectionImpl);
            i = i2;
        }
        List list = _Collections.toList(arrayList);
        ClassifierDescriptor declarationDescriptor = typeConstructorCreateErrorTypeConstructor.getDeclarationDescriptor();
        boolean z3 = true;
        if (z2 && (declarationDescriptor instanceof TypeAliasDescriptor)) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
            KotlinType4 kotlinType4ComputeExpandedType = KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor) declarationDescriptor, list);
            if (!KotlinType2.isNullable(kotlinType4ComputeExpandedType) && !c11692q.getNullable()) {
                z3 = false;
            }
            kotlinType4SimpleType$default = kotlinType4ComputeExpandedType.makeNullableAsSpecified(z3).replaceAnnotations(Annotations4.f22735f.create(_Collections.plus((Iterable) deserializedAnnotations, (Iterable) kotlinType4ComputeExpandedType.getAnnotations())));
        } else {
            Boolean bool = Flags2.f24030a.get(c11692q.getFlags());
            Intrinsics3.checkNotNullExpressionValue(bool, "SUSPEND_TYPE.get(proto.flags)");
            if (bool.booleanValue()) {
                boolean nullable = c11692q.getNullable();
                int size2 = typeConstructorCreateErrorTypeConstructor.getParameters().size() - list.size();
                if (size2 == 0) {
                    KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.f24748a;
                    KotlinType4 kotlinType4SimpleType$default3 = KotlinTypeFactory.simpleType$default(deserializedAnnotations, typeConstructorCreateErrorTypeConstructor, list, nullable, null, 16, null);
                    if (functionTypes.isFunctionType(kotlinType4SimpleType$default3)) {
                        boolean releaseCoroutines = this.f24503a.getComponents().getConfiguration().getReleaseCoroutines();
                        TypeProjection typeProjection = (TypeProjection) _Collections.lastOrNull((List) functionTypes.getValueParameterTypesFromFunctionType(kotlinType4SimpleType$default3));
                        KotlinType type = typeProjection == null ? null : typeProjection.getType();
                        if (type != null) {
                            ClassifierDescriptor declarationDescriptor2 = type.getConstructor().getDeclarationDescriptor();
                            FqName fqNameSafe = declarationDescriptor2 == null ? null : DescriptorUtils2.getFqNameSafe(declarationDescriptor2);
                            if (type.getArguments().size() == 1 && (suspendFunctionTypes.isContinuation(fqNameSafe, true) || suspendFunctionTypes.isContinuation(fqNameSafe, false))) {
                                KotlinType type2 = ((TypeProjection) _Collections.single((List) type.getArguments())).getType();
                                Intrinsics3.checkNotNullExpressionValue(type2, "continuationArgumentType.arguments.single().type");
                                DeclarationDescriptor containingDeclaration2 = this.f24503a.getContainingDeclaration();
                                if (!(containingDeclaration2 instanceof CallableDescriptor)) {
                                    containingDeclaration2 = null;
                                }
                                CallableDescriptor callableDescriptor = (CallableDescriptor) containingDeclaration2;
                                if (Intrinsics3.areEqual(callableDescriptor != null ? DescriptorUtils2.fqNameOrNull(callableDescriptor) : null, suspendFunctionTypeUtil.f24502a)) {
                                    kotlinType4SimpleType$default3 = m9950b(kotlinType4SimpleType$default3, type2);
                                } else {
                                    if (!this.f24507e && (!releaseCoroutines || !suspendFunctionTypes.isContinuation(fqNameSafe, !releaseCoroutines))) {
                                        z3 = false;
                                    }
                                    this.f24507e = z3;
                                    kotlinType4SimpleType$default3 = m9950b(kotlinType4SimpleType$default3, type2);
                                }
                            }
                            kotlinType4SimpleType$default2 = kotlinType4SimpleType$default3;
                        }
                    }
                } else if (size2 == 1 && (size = list.size() - 1) >= 0) {
                    KotlinTypeFactory kotlinTypeFactory3 = KotlinTypeFactory.f24748a;
                    TypeConstructor typeConstructor2 = typeConstructorCreateErrorTypeConstructor.getBuiltIns().getSuspendFunction(size).getTypeConstructor();
                    Intrinsics3.checkNotNullExpressionValue(typeConstructor2, "functionTypeConstructor.builtIns.getSuspendFunction(arity).typeConstructor");
                    kotlinType4SimpleType$default2 = KotlinTypeFactory.simpleType$default(deserializedAnnotations, typeConstructor2, list, nullable, null, 16, null);
                }
                if (kotlinType4SimpleType$default2 == null) {
                    kotlinType4SimpleType$default = ErrorUtils.createErrorTypeWithArguments(Intrinsics3.stringPlus("Bad suspend function in metadata with constructor: ", typeConstructorCreateErrorTypeConstructor), list);
                    Intrinsics3.checkNotNullExpressionValue(kotlinType4SimpleType$default, "createErrorTypeWithArguments(\n            \"Bad suspend function in metadata with constructor: $functionTypeConstructor\",\n            arguments\n        )");
                } else {
                    kotlinType4SimpleType$default = kotlinType4SimpleType$default2;
                }
            } else {
                KotlinTypeFactory kotlinTypeFactory4 = KotlinTypeFactory.f24748a;
                kotlinType4SimpleType$default = KotlinTypeFactory.simpleType$default(deserializedAnnotations, typeConstructorCreateErrorTypeConstructor, list, c11692q.getNullable(), null, 16, null);
            }
        }
        C11692q c11692qAbbreviatedType = protoTypeTableUtil.abbreviatedType(c11692q, this.f24503a.getTypeTable());
        if (c11692qAbbreviatedType != null && (kotlinType4WithAbbreviation = SpecialTypes5.withAbbreviation(kotlinType4SimpleType$default, simpleType(c11692qAbbreviatedType, false))) != null) {
            kotlinType4SimpleType$default = kotlinType4WithAbbreviation;
        }
        return c11692q.hasClassName() ? this.f24503a.getComponents().getPlatformDependentTypeTransformer().transformPlatformType(NameResolverUtil.getClassId(this.f24503a.getNameResolver(), c11692q.getClassName()), kotlinType4SimpleType$default) : kotlinType4SimpleType$default;
    }

    public String toString() {
        String str = this.f24505c;
        TypeDeserializer typeDeserializer = this.f24504b;
        return Intrinsics3.stringPlus(str, typeDeserializer == null ? "" : Intrinsics3.stringPlus(". Child of ", typeDeserializer.f24505c));
    }

    public final KotlinType type(C11692q c11692q) {
        Intrinsics3.checkNotNullParameter(c11692q, "proto");
        if (!c11692q.hasFlexibleTypeCapabilitiesId()) {
            return simpleType(c11692q, true);
        }
        String string = this.f24503a.getNameResolver().getString(c11692q.getFlexibleTypeCapabilitiesId());
        KotlinType4 kotlinType4SimpleType$default = simpleType$default(this, c11692q, false, 2, null);
        C11692q c11692qFlexibleUpperBound = protoTypeTableUtil.flexibleUpperBound(c11692q, this.f24503a.getTypeTable());
        Intrinsics3.checkNotNull(c11692qFlexibleUpperBound);
        return this.f24503a.getComponents().getFlexibleTypeDeserializer().create(c11692q, string, kotlinType4SimpleType$default, simpleType$default(this, c11692qFlexibleUpperBound, false, 2, null));
    }

    public /* synthetic */ TypeDeserializer(context6 context6Var, TypeDeserializer typeDeserializer, List list, String str, String str2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context6Var, typeDeserializer, list, str, str2, (i & 32) != 0 ? false : z2);
    }
}
