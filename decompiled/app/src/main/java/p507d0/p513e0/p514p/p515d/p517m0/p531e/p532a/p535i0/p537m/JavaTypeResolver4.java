package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.PrimitiveType;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.JavaToKotlinClassMapper;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.TypeUsage;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.LazyJavaAnnotations;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.resolvers2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11576i;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11592y;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes5;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjectionImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.IndexedValue;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: JavaTypeResolver.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.m.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class JavaTypeResolver4 {

    /* renamed from: a */
    public final context4 f23429a;

    /* renamed from: b */
    public final resolvers2 f23430b;

    public JavaTypeResolver4(context4 context4Var, resolvers2 resolvers2Var) {
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(resolvers2Var, "typeParameterResolver");
        this.f23429a = context4Var;
        this.f23430b = resolvers2Var;
    }

    /* renamed from: c */
    public static final KotlinType4 m9498c(javaTypes3 javatypes3) {
        KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType(Intrinsics3.stringPlus("Unresolved java class ", javatypes3.getPresentableText()));
        Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(\"Unresolved java class ${javaType.presentableText}\")");
        return kotlinType4CreateErrorType;
    }

    public static /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver4 javaTypeResolver4, javaTypes2 javatypes2, JavaTypeResolver javaTypeResolver, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return javaTypeResolver4.transformArrayType(javatypes2, javaTypeResolver, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x012c  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final KotlinType4 m9499a(javaTypes3 javatypes3, JavaTypeResolver javaTypeResolver, KotlinType4 kotlinType4) {
        TypeConstructor typeConstructor;
        TypeConstructor typeConstructor2;
        ClassDescriptor classDescriptorConvertReadOnlyToMutable;
        boolean z2;
        boolean z3;
        List list;
        TypeParameterDescriptor typeParameterDescriptor;
        TypeProjection typeProjectionImpl;
        Variance variance = Variance.OUT_VARIANCE;
        TypeUsage typeUsage = TypeUsage.SUPERTYPE;
        JavaTypeResolver2 javaTypeResolver2 = JavaTypeResolver2.FLEXIBLE_LOWER_BOUND;
        TypeParameterDescriptor typeParameterDescriptor2 = null;
        Annotations4 annotations = kotlinType4 == null ? null : kotlinType4.getAnnotations();
        if (annotations == null) {
            annotations = new LazyJavaAnnotations(this.f23429a, javatypes3, false, 4, null);
        }
        Annotations4 annotations4 = annotations;
        InterfaceC11576i classifier = javatypes3.getClassifier();
        boolean z4 = false;
        if (classifier == null) {
            typeConstructor = m9500b(javatypes3);
        } else if (classifier instanceof InterfaceC11574g) {
            InterfaceC11574g interfaceC11574g = (InterfaceC11574g) classifier;
            FqName fqName = interfaceC11574g.getFqName();
            if (fqName == null) {
                throw new AssertionError(Intrinsics3.stringPlus("Class type should have a FQ name: ", classifier));
            }
            if (javaTypeResolver.isForAnnotationParameter() && Intrinsics3.areEqual(fqName, JavaTypeResolver5.access$getJAVA_LANG_CLASS_FQ_NAME$p$s1946801611())) {
                classDescriptorConvertReadOnlyToMutable = this.f23429a.getComponents().getReflectionTypes().getKClass();
            } else {
                JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.f22630a;
                ClassDescriptor classDescriptorMapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(javaToKotlinClassMapper, fqName, this.f23429a.getModule().getBuiltIns(), null, 4, null);
                if (classDescriptorMapJavaToKotlin$default != null) {
                    if (javaToKotlinClassMapper.isReadOnly(classDescriptorMapJavaToKotlin$default)) {
                        if (javaTypeResolver.getFlexibility() != javaTypeResolver2 && javaTypeResolver.getHowThisTypeIsUsed() != typeUsage) {
                            javaTypes5 javatypes5 = (javaTypes5) _Collections.lastOrNull((List) javatypes3.getTypeArguments());
                            javaTypes javatypes = javatypes5 instanceof javaTypes ? (javaTypes) javatypes5 : null;
                            if ((javatypes == null || javatypes.getBound() == null || javatypes.isExtends()) ? false : true) {
                                List<TypeParameterDescriptor> parameters = javaToKotlinClassMapper.convertReadOnlyToMutable(classDescriptorMapJavaToKotlin$default).getTypeConstructor().getParameters();
                                Intrinsics3.checkNotNullExpressionValue(parameters, "JavaToKotlinClassMapper.convertReadOnlyToMutable(readOnlyContainer)\n            .typeConstructor.parameters");
                                TypeParameterDescriptor typeParameterDescriptor3 = (TypeParameterDescriptor) _Collections.lastOrNull((List) parameters);
                                Variance variance2 = typeParameterDescriptor3 == null ? null : typeParameterDescriptor3.getVariance();
                                if (variance2 != null && variance2 != variance) {
                                    z2 = true;
                                }
                                if (!z2) {
                                }
                            } else {
                                z2 = false;
                                if (!z2) {
                                }
                            }
                        }
                        classDescriptorConvertReadOnlyToMutable = javaToKotlinClassMapper.convertReadOnlyToMutable(classDescriptorMapJavaToKotlin$default);
                    } else {
                        classDescriptorConvertReadOnlyToMutable = classDescriptorMapJavaToKotlin$default;
                    }
                    if (typeConstructor2 == null) {
                        return null;
                    }
                    boolean z5 = javaTypeResolver.getFlexibility() == javaTypeResolver2 ? false : (javaTypeResolver.isForAnnotationParameter() || javaTypeResolver.getHowThisTypeIsUsed() == typeUsage) ? false : true;
                    if (Intrinsics3.areEqual(kotlinType4 == null ? null : kotlinType4.getConstructor(), typeConstructor2) && !javatypes3.isRaw() && z5) {
                        return kotlinType4.makeNullableAsSpecified(true);
                    }
                    boolean zIsRaw = javatypes3.isRaw();
                    if (zIsRaw) {
                        z3 = true;
                    } else {
                        if (javatypes3.getTypeArguments().isEmpty()) {
                            Intrinsics3.checkNotNullExpressionValue(typeConstructor2.getParameters(), "constructor.parameters");
                            if (!r5.isEmpty()) {
                            }
                        }
                        z3 = false;
                    }
                    List<TypeParameterDescriptor> parameters2 = typeConstructor2.getParameters();
                    Intrinsics3.checkNotNullExpressionValue(parameters2, "constructor.parameters");
                    if (z3) {
                        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(parameters2, 10));
                        for (TypeParameterDescriptor typeParameterDescriptor4 : parameters2) {
                            SpecialTypes2 specialTypes2 = new SpecialTypes2(this.f23429a.getStorageManager(), new JavaTypeResolver3(typeParameterDescriptor4, javaTypeResolver, typeConstructor2));
                            RawType rawType = RawType.f23432b;
                            Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor4, "parameter");
                            arrayList.add(rawType.computeProjection(typeParameterDescriptor4, zIsRaw ? javaTypeResolver : javaTypeResolver.withFlexibility(JavaTypeResolver2.INFLEXIBLE), specialTypes2));
                        }
                        list = _Collections.toList(arrayList);
                    } else if (parameters2.size() != javatypes3.getTypeArguments().size()) {
                        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(parameters2, 10));
                        Iterator<T> it = parameters2.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(new TypeProjectionImpl(ErrorUtils.createErrorType(((TypeParameterDescriptor) it.next()).getName().asString())));
                        }
                        list = _Collections.toList(arrayList2);
                    } else {
                        Iterable<IndexedValue> iterableWithIndex = _Collections.withIndex(javatypes3.getTypeArguments());
                        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(iterableWithIndex, 10));
                        for (IndexedValue indexedValue : iterableWithIndex) {
                            int iComponent1 = indexedValue.component1();
                            javaTypes5 javatypes52 = (javaTypes5) indexedValue.component2();
                            parameters2.size();
                            TypeParameterDescriptor typeParameterDescriptor5 = parameters2.get(iComponent1);
                            TypeUsage typeUsage2 = TypeUsage.COMMON;
                            JavaTypeResolver attributes$default = JavaTypeResolver5.toAttributes$default(typeUsage2, z4, typeParameterDescriptor2, 3, typeParameterDescriptor2);
                            Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor5, "parameter");
                            Variance variance3 = Variance.INVARIANT;
                            if (javatypes52 instanceof javaTypes) {
                                javaTypes javatypes2 = (javaTypes) javatypes52;
                                javaTypes5 bound = javatypes2.getBound();
                                Variance variance4 = javatypes2.isExtends() ? variance : Variance.IN_VARIANCE;
                                if (bound == null) {
                                    typeParameterDescriptor = null;
                                    typeProjectionImpl = JavaTypeResolver5.makeStarProjection(typeParameterDescriptor5, attributes$default);
                                } else if (!((typeParameterDescriptor5.getVariance() == variance3 || variance4 == typeParameterDescriptor5.getVariance()) ? false : true)) {
                                    typeParameterDescriptor = null;
                                    typeProjectionImpl = TypeUtils2.createProjection(transformJavaType(bound, JavaTypeResolver5.toAttributes$default(typeUsage2, false, null, 3, null)), variance4, typeParameterDescriptor5);
                                }
                            } else {
                                typeParameterDescriptor = null;
                                typeProjectionImpl = new TypeProjectionImpl(variance3, transformJavaType(javatypes52, attributes$default));
                            }
                            arrayList3.add(typeProjectionImpl);
                            typeParameterDescriptor2 = typeParameterDescriptor;
                            z4 = false;
                        }
                        list = _Collections.toList(arrayList3);
                    }
                    List list2 = list;
                    KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
                    return KotlinTypeFactory.simpleType$default(annotations4, typeConstructor2, list2, z5, null, 16, null);
                }
                classDescriptorConvertReadOnlyToMutable = null;
            }
            if (classDescriptorConvertReadOnlyToMutable == null) {
                classDescriptorConvertReadOnlyToMutable = this.f23429a.getComponents().getModuleClassResolver().resolveClass(interfaceC11574g);
            }
            typeConstructor = classDescriptorConvertReadOnlyToMutable == null ? null : classDescriptorConvertReadOnlyToMutable.getTypeConstructor();
            if (typeConstructor == null) {
                typeConstructor = m9500b(javatypes3);
            }
        } else {
            if (!(classifier instanceof InterfaceC11592y)) {
                throw new IllegalStateException(Intrinsics3.stringPlus("Unknown classifier kind: ", classifier));
            }
            TypeParameterDescriptor typeParameterDescriptorResolveTypeParameter = this.f23430b.resolveTypeParameter((InterfaceC11592y) classifier);
            if (typeParameterDescriptorResolveTypeParameter == null) {
                typeConstructor2 = null;
                if (typeConstructor2 == null) {
                }
            } else {
                typeConstructor = typeParameterDescriptorResolveTypeParameter.getTypeConstructor();
            }
        }
        typeConstructor2 = typeConstructor;
        if (typeConstructor2 == null) {
        }
    }

    /* renamed from: b */
    public final TypeConstructor m9500b(javaTypes3 javatypes3) {
        ClassId classId = ClassId.topLevel(new FqName(javatypes3.getClassifierQualifiedName()));
        Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(FqName(javaType.classifierQualifiedName))");
        TypeConstructor typeConstructor = this.f23429a.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(classId, CollectionsJVM.listOf(0)).getTypeConstructor();
        Intrinsics3.checkNotNullExpressionValue(typeConstructor, "c.components.deserializedDescriptorResolver.components.notFoundClasses.getClass(classId, listOf(0)).typeConstructor");
        return typeConstructor;
    }

    public final KotlinType transformArrayType(javaTypes2 javatypes2, JavaTypeResolver javaTypeResolver, boolean z2) {
        Variance variance = Variance.OUT_VARIANCE;
        Variance variance2 = Variance.INVARIANT;
        Intrinsics3.checkNotNullParameter(javatypes2, "arrayType");
        Intrinsics3.checkNotNullParameter(javaTypeResolver, "attr");
        javaTypes5 componentType = javatypes2.getComponentType();
        javaTypes4 javatypes4 = componentType instanceof javaTypes4 ? (javaTypes4) componentType : null;
        PrimitiveType type = javatypes4 == null ? null : javatypes4.getType();
        LazyJavaAnnotations lazyJavaAnnotations = new LazyJavaAnnotations(this.f23429a, javatypes2, true);
        if (type != null) {
            KotlinType4 primitiveArrayKotlinType = this.f23429a.getModule().getBuiltIns().getPrimitiveArrayKotlinType(type);
            Intrinsics3.checkNotNullExpressionValue(primitiveArrayKotlinType, "c.module.builtIns.getPrimitiveArrayKotlinType(primitiveType)");
            primitiveArrayKotlinType.replaceAnnotations(Annotations4.f22735f.create(_Collections.plus((Iterable) lazyJavaAnnotations, (Iterable) primitiveArrayKotlinType.getAnnotations())));
            if (javaTypeResolver.isForAnnotationParameter()) {
                return primitiveArrayKotlinType;
            }
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
            return KotlinTypeFactory.flexibleType(primitiveArrayKotlinType, primitiveArrayKotlinType.makeNullableAsSpecified(true));
        }
        KotlinType kotlinTypeTransformJavaType = transformJavaType(componentType, JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, javaTypeResolver.isForAnnotationParameter(), null, 2, null));
        if (!javaTypeResolver.isForAnnotationParameter()) {
            KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.f24748a;
            KotlinType4 arrayType = this.f23429a.getModule().getBuiltIns().getArrayType(variance2, kotlinTypeTransformJavaType, lazyJavaAnnotations);
            Intrinsics3.checkNotNullExpressionValue(arrayType, "c.module.builtIns.getArrayType(INVARIANT, componentType, annotations)");
            return KotlinTypeFactory.flexibleType(arrayType, this.f23429a.getModule().getBuiltIns().getArrayType(variance, kotlinTypeTransformJavaType, lazyJavaAnnotations).makeNullableAsSpecified(true));
        }
        if (!z2) {
            variance = variance2;
        }
        KotlinType4 arrayType2 = this.f23429a.getModule().getBuiltIns().getArrayType(variance, kotlinTypeTransformJavaType, lazyJavaAnnotations);
        Intrinsics3.checkNotNullExpressionValue(arrayType2, "c.module.builtIns.getArrayType(projectionKind, componentType, annotations)");
        return arrayType2;
    }

    public final KotlinType transformJavaType(javaTypes5 javatypes5, JavaTypeResolver javaTypeResolver) {
        Intrinsics3.checkNotNullParameter(javaTypeResolver, "attr");
        if (javatypes5 instanceof javaTypes4) {
            PrimitiveType type = ((javaTypes4) javatypes5).getType();
            KotlinType4 primitiveKotlinType = type != null ? this.f23429a.getModule().getBuiltIns().getPrimitiveKotlinType(type) : this.f23429a.getModule().getBuiltIns().getUnitType();
            Intrinsics3.checkNotNullExpressionValue(primitiveKotlinType, "{\n                val primitiveType = javaType.type\n                if (primitiveType != null) c.module.builtIns.getPrimitiveKotlinType(primitiveType)\n                else c.module.builtIns.unitType\n            }");
            return primitiveKotlinType;
        }
        if (!(javatypes5 instanceof javaTypes3)) {
            if (javatypes5 instanceof javaTypes2) {
                return transformArrayType$default(this, (javaTypes2) javatypes5, javaTypeResolver, false, 4, null);
            }
            if (!(javatypes5 instanceof javaTypes)) {
                if (javatypes5 != null) {
                    throw new UnsupportedOperationException(Intrinsics3.stringPlus("Unsupported type: ", javatypes5));
                }
                KotlinType4 defaultBound = this.f23429a.getModule().getBuiltIns().getDefaultBound();
                Intrinsics3.checkNotNullExpressionValue(defaultBound, "c.module.builtIns.defaultBound");
                return defaultBound;
            }
            javaTypes5 bound = ((javaTypes) javatypes5).getBound();
            KotlinType kotlinTypeTransformJavaType = bound == null ? null : transformJavaType(bound, javaTypeResolver);
            if (kotlinTypeTransformJavaType != null) {
                return kotlinTypeTransformJavaType;
            }
            KotlinType4 defaultBound2 = this.f23429a.getModule().getBuiltIns().getDefaultBound();
            Intrinsics3.checkNotNullExpressionValue(defaultBound2, "c.module.builtIns.defaultBound");
            return defaultBound2;
        }
        javaTypes3 javatypes3 = (javaTypes3) javatypes5;
        boolean z2 = (javaTypeResolver.isForAnnotationParameter() || javaTypeResolver.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) ? false : true;
        boolean zIsRaw = javatypes3.isRaw();
        if (!zIsRaw && !z2) {
            KotlinType4 kotlinType4M9499a = m9499a(javatypes3, javaTypeResolver, null);
            if (kotlinType4M9499a == null) {
                kotlinType4M9499a = m9498c(javatypes3);
            }
            return kotlinType4M9499a;
        }
        KotlinType4 kotlinType4M9499a2 = m9499a(javatypes3, javaTypeResolver.withFlexibility(JavaTypeResolver2.FLEXIBLE_LOWER_BOUND), null);
        if (kotlinType4M9499a2 == null) {
            return m9498c(javatypes3);
        }
        KotlinType4 kotlinType4M9499a3 = m9499a(javatypes3, javaTypeResolver.withFlexibility(JavaTypeResolver2.FLEXIBLE_UPPER_BOUND), kotlinType4M9499a2);
        if (kotlinType4M9499a3 == null) {
            return m9498c(javatypes3);
        }
        if (zIsRaw) {
            return new RawType2(kotlinType4M9499a2, kotlinType4M9499a3);
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
        return KotlinTypeFactory.flexibleType(kotlinType4M9499a2, kotlinType4M9499a3);
    }
}
