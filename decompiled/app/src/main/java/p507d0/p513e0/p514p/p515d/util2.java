package p507d0.p513e0.p514p.p515d;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KCallable;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p513e0.p514p.p515d.p516l0.AnnotationConstructorCaller2;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.JavaToKotlinClassMap;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.ReflectAnnotationSource;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.ReflectJavaClassFinder2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.ReflectKotlinClass2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.RuntimeModuleData;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.RuntimeSourceElementFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaAnnotation;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaClass;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.reflectClassUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinarySourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.BinaryVersion;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.TypeTable;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.VersionRequirement2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.inlineClassesUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11819k;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11807a;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11809b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11818j;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11826r;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11828t;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.MemberDeserializer;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.context5;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.context6;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.FunctionReference;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.PropertyReference;

/* compiled from: util.kt */
/* renamed from: d0.e0.p.d.j0, reason: use source file name */
/* loaded from: classes3.dex */
public final class util2 {

    /* renamed from: a */
    public static final FqName f22397a = new FqName("kotlin.jvm.JvmStatic");

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* renamed from: a */
    public static final Class<?> m9349a(ClassLoader classLoader, ClassId classId, int i) {
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.f22614a;
        FqNameUnsafe unsafe = classId.asSingleFqName().toUnsafe();
        Intrinsics3.checkNotNullExpressionValue(unsafe, "kotlinClassId.asSingleFqName().toUnsafe()");
        ClassId classIdMapKotlinToJava = javaToKotlinClassMap.mapKotlinToJava(unsafe);
        if (classIdMapKotlinToJava != null) {
            classId = classIdMapKotlinToJava;
        }
        String strAsString = classId.getPackageFqName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "javaClassId.packageFqName.asString()");
        String strAsString2 = classId.getRelativeClassName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString2, "javaClassId.relativeClassName.asString()");
        if (Intrinsics3.areEqual(strAsString, "kotlin")) {
            switch (strAsString2.hashCode()) {
                case -901856463:
                    if (strAsString2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (strAsString2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (strAsString2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (strAsString2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (strAsString2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (strAsString2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (strAsString2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (strAsString2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (strAsString2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        String str = strAsString + '.' + StringsJVM.replace$default(strAsString2, '.', '$', false, 4, (Object) null);
        if (i > 0) {
            str = StringsJVM.repeat("[", i) + 'L' + str + ';';
        }
        return ReflectJavaClassFinder2.tryLoadClass(classLoader, str);
    }

    public static final KFunctionImpl asKFunctionImpl(Object obj) {
        KFunctionImpl kFunctionImpl = (KFunctionImpl) (!(obj instanceof KFunctionImpl) ? null : obj);
        if (kFunctionImpl != null) {
            return kFunctionImpl;
        }
        if (!(obj instanceof FunctionReference)) {
            obj = null;
        }
        FunctionReference functionReference = (FunctionReference) obj;
        KCallable kCallableCompute = functionReference != null ? functionReference.compute() : null;
        return (KFunctionImpl) (kCallableCompute instanceof KFunctionImpl ? kCallableCompute : null);
    }

    public static final KPropertyImpl<?> asKPropertyImpl(Object obj) {
        KPropertyImpl<?> kPropertyImpl = (KPropertyImpl) (!(obj instanceof KPropertyImpl) ? null : obj);
        if (kPropertyImpl != null) {
            return kPropertyImpl;
        }
        if (!(obj instanceof PropertyReference)) {
            obj = null;
        }
        PropertyReference propertyReference = (PropertyReference) obj;
        KCallable kCallableCompute = propertyReference != null ? propertyReference.compute() : null;
        return (KPropertyImpl) (kCallableCompute instanceof KPropertyImpl ? kCallableCompute : null);
    }

    /* renamed from: b */
    public static final Annotation m9350b(AnnotationDescriptor annotationDescriptor) {
        ClassDescriptor annotationClass = DescriptorUtils2.getAnnotationClass(annotationDescriptor);
        Class<?> javaClass = annotationClass != null ? toJavaClass(annotationClass) : null;
        if (!(javaClass instanceof Class)) {
            javaClass = null;
        }
        if (javaClass == null) {
            return null;
        }
        Set<Map.Entry<Name, AbstractC11815g<?>>> setEntrySet = annotationDescriptor.getAllValueArguments().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Name name = (Name) entry.getKey();
            AbstractC11815g abstractC11815g = (AbstractC11815g) entry.getValue();
            ClassLoader classLoader = javaClass.getClassLoader();
            Intrinsics3.checkNotNullExpressionValue(classLoader, "annotationClass.classLoader");
            Object objM9351c = m9351c(abstractC11815g, classLoader);
            Tuples2 tuples2M10073to = objM9351c != null ? Tuples.m10073to(name.asString(), objM9351c) : null;
            if (tuples2M10073to != null) {
                arrayList.add(tuples2M10073to);
            }
        }
        return (Annotation) AnnotationConstructorCaller2.createAnnotationInstance$default(javaClass, Maps6.toMap(arrayList), null, 4, null);
    }

    /* renamed from: c */
    public static final Object m9351c(AbstractC11815g<?> abstractC11815g, ClassLoader classLoader) {
        if (abstractC11815g instanceof C11807a) {
            return m9350b(((C11807a) abstractC11815g).getValue());
        }
        if (abstractC11815g instanceof C11809b) {
            List<? extends AbstractC11815g<?>> value = ((C11809b) abstractC11815g).getValue();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(value, 10));
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                arrayList.add(m9351c((AbstractC11815g) it.next(), classLoader));
            }
            Object[] array = arrayList.toArray(new Object[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return array;
        }
        if (abstractC11815g instanceof C11818j) {
            Tuples2<? extends ClassId, ? extends Name> value2 = ((C11818j) abstractC11815g).getValue();
            ClassId classIdComponent1 = value2.component1();
            Name nameComponent2 = value2.component2();
            Class<?> clsM9349a = m9349a(classLoader, classIdComponent1, 0);
            if (clsM9349a != null) {
                return Util4.getEnumConstantByName(clsM9349a, nameComponent2.asString());
            }
            return null;
        }
        if (!(abstractC11815g instanceof C11826r)) {
            if ((abstractC11815g instanceof AbstractC11819k) || (abstractC11815g instanceof C11828t)) {
                return null;
            }
            return abstractC11815g.getValue();
        }
        C11826r.b value3 = ((C11826r) abstractC11815g).getValue();
        if (value3 instanceof C11826r.b.C13329b) {
            C11826r.b.C13329b c13329b = (C11826r.b.C13329b) value3;
            return m9349a(classLoader, c13329b.getClassId(), c13329b.getArrayDimensions());
        }
        if (!(value3 instanceof C11826r.b.a)) {
            throw new NoWhenBranchMatchedException();
        }
        ClassifierDescriptor declarationDescriptor = ((C11826r.b.a) value3).getType().getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            declarationDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        if (classDescriptor != null) {
            return toJavaClass(classDescriptor);
        }
        return null;
    }

    public static final List<Annotation> computeAnnotations(Annotations3 annotations3) {
        Intrinsics3.checkNotNullParameter(annotations3, "$this$computeAnnotations");
        Annotations4 annotations = annotations3.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (AnnotationDescriptor annotationDescriptor : annotations) {
            SourceElement source = annotationDescriptor.getSource();
            Annotation annotationM9350b = null;
            if (source instanceof ReflectAnnotationSource) {
                annotationM9350b = ((ReflectAnnotationSource) source).getAnnotation();
            } else if (source instanceof RuntimeSourceElementFactory.a) {
                ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.a) source).getJavaElement();
                if (!(javaElement instanceof ReflectJavaAnnotation)) {
                    javaElement = null;
                }
                ReflectJavaAnnotation reflectJavaAnnotation = (ReflectJavaAnnotation) javaElement;
                if (reflectJavaAnnotation != null) {
                    annotationM9350b = reflectJavaAnnotation.getAnnotation();
                }
            } else {
                annotationM9350b = m9350b(annotationDescriptor);
            }
            if (annotationM9350b != null) {
                arrayList.add(annotationM9350b);
            }
        }
        return arrayList;
    }

    public static final Object defaultPrimitiveValue(Type type) {
        Intrinsics3.checkNotNullParameter(type, "type");
        if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
            return null;
        }
        if (Intrinsics3.areEqual(type, Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (Intrinsics3.areEqual(type, Character.TYPE)) {
            return Character.valueOf((char) 0);
        }
        if (Intrinsics3.areEqual(type, Byte.TYPE)) {
            return Byte.valueOf((byte) 0);
        }
        if (Intrinsics3.areEqual(type, Short.TYPE)) {
            return Short.valueOf((short) 0);
        }
        if (Intrinsics3.areEqual(type, Integer.TYPE)) {
            return 0;
        }
        if (Intrinsics3.areEqual(type, Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (Intrinsics3.areEqual(type, Long.TYPE)) {
            return 0L;
        }
        if (Intrinsics3.areEqual(type, Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (Intrinsics3.areEqual(type, Void.TYPE)) {
            throw new IllegalStateException("Parameter with void type is illegal");
        }
        throw new UnsupportedOperationException(outline.m887z("Unknown primitive: ", type));
    }

    public static final <M extends MessageLite, D extends CallableDescriptor> D deserializeToDescriptor(Class<?> cls, M m, NameResolver nameResolver, TypeTable typeTable, BinaryVersion binaryVersion, Function2<? super MemberDeserializer, ? super M, ? extends D> function2) {
        List<C11694s> typeParameterList;
        Intrinsics3.checkNotNullParameter(cls, "moduleAnchor");
        Intrinsics3.checkNotNullParameter(m, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics3.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics3.checkNotNullParameter(function2, "createDescriptor");
        RuntimeModuleData orCreateModule = moduleByClassLoader.getOrCreateModule(cls);
        if (m instanceof C11684i) {
            typeParameterList = ((C11684i) m).getTypeParameterList();
        } else {
            if (!(m instanceof C11689n)) {
                throw new IllegalStateException(("Unsupported message: " + m).toString());
            }
            typeParameterList = ((C11689n) m).getTypeParameterList();
        }
        List<C11694s> list = typeParameterList;
        context5 deserialization = orCreateModule.getDeserialization();
        ModuleDescriptor2 module = orCreateModule.getModule();
        VersionRequirement2 empty = VersionRequirement2.f24073a.getEMPTY();
        Intrinsics3.checkNotNullExpressionValue(list, "typeParameters");
        return function2.invoke(new MemberDeserializer(new context6(deserialization, nameResolver, module, typeTable, empty, binaryVersion, null, null, list)), m);
    }

    public static final ReceiverParameterDescriptor getInstanceReceiverParameter(CallableDescriptor callableDescriptor) {
        Intrinsics3.checkNotNullParameter(callableDescriptor, "$this$instanceReceiverParameter");
        if (callableDescriptor.getDispatchReceiverParameter() == null) {
            return null;
        }
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((ClassDescriptor) containingDeclaration).getThisAsReceiverParameter();
    }

    public static final FqName getJVM_STATIC() {
        return f22397a;
    }

    public static final boolean isInlineClassType(KType kType) {
        KotlinType type;
        Intrinsics3.checkNotNullParameter(kType, "$this$isInlineClassType");
        if (!(kType instanceof KTypeImpl)) {
            kType = null;
        }
        KTypeImpl kTypeImpl = (KTypeImpl) kType;
        return (kTypeImpl == null || (type = kTypeImpl.getType()) == null || !inlineClassesUtils.isInlineClassType(type)) ? false : true;
    }

    public static final Class<?> toJavaClass(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "$this$toJavaClass");
        SourceElement source = classDescriptor.getSource();
        Intrinsics3.checkNotNullExpressionValue(source, "source");
        if (source instanceof KotlinJvmBinarySourceElement) {
            KotlinJvmBinaryClass binaryClass = ((KotlinJvmBinarySourceElement) source).getBinaryClass();
            Objects.requireNonNull(binaryClass, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((ReflectKotlinClass2) binaryClass).getKlass();
        }
        if (source instanceof RuntimeSourceElementFactory.a) {
            ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.a) source).getJavaElement();
            Objects.requireNonNull(javaElement, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((ReflectJavaClass) javaElement).getElement();
        }
        ClassId classId = DescriptorUtils2.getClassId(classDescriptor);
        if (classId != null) {
            return m9349a(reflectClassUtil.getSafeClassLoader(classDescriptor.getClass()), classId, 0);
        }
        return null;
    }

    public static final KVisibility toKVisibility(DescriptorVisibility2 descriptorVisibility2) {
        Intrinsics3.checkNotNullParameter(descriptorVisibility2, "$this$toKVisibility");
        if (Intrinsics3.areEqual(descriptorVisibility2, DescriptorVisibilities.f23087e)) {
            return KVisibility.PUBLIC;
        }
        if (Intrinsics3.areEqual(descriptorVisibility2, DescriptorVisibilities.f23085c)) {
            return KVisibility.PROTECTED;
        }
        if (Intrinsics3.areEqual(descriptorVisibility2, DescriptorVisibilities.f23086d)) {
            return KVisibility.INTERNAL;
        }
        if (Intrinsics3.areEqual(descriptorVisibility2, DescriptorVisibilities.f23083a) || Intrinsics3.areEqual(descriptorVisibility2, DescriptorVisibilities.f23084b)) {
            return KVisibility.PRIVATE;
        }
        return null;
    }
}
