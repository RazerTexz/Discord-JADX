package p507d0.p513e0.p514p.p515d;

import java.lang.reflect.Method;
import p507d0.p513e0.p514p.p515d.RuntimeTypeMapper;
import p507d0.p513e0.p514p.p515d.RuntimeTypeMapper2;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.PrimitiveType;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.CloneableClassScope;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.JavaToKotlinClassMap;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyGetterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertySetterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaClass;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaField;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaMethod;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.reflectClassUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JvmAbi;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaClassConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaMethodDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaPropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p538j0.JavaSourceElementFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11579l;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.specialBuiltinMembers;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.methodSignatureMapping3;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11679d;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.JvmProtoBuf;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMemberSignature;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmProtoBufUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.ProtoBufUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.inlineClassesUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.JvmPrimitiveType;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor4;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: RuntimeTypeMapper.kt */
/* renamed from: d0.e0.p.d.f0, reason: use source file name */
/* loaded from: classes3.dex */
public final class RuntimeTypeMapper3 {

    /* renamed from: a */
    public static final ClassId f22357a;

    /* renamed from: b */
    public static final RuntimeTypeMapper3 f22358b = new RuntimeTypeMapper3();

    static {
        ClassId classId = ClassId.topLevel(new FqName("java.lang.Void"));
        Intrinsics3.checkNotNullExpressionValue(classId, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
        f22357a = classId;
    }

    /* renamed from: a */
    public final PrimitiveType m9338a(Class<?> cls) {
        if (!cls.isPrimitive()) {
            return null;
        }
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.get(cls.getSimpleName());
        Intrinsics3.checkNotNullExpressionValue(jvmPrimitiveType, "JvmPrimitiveType.get(simpleName)");
        return jvmPrimitiveType.getPrimitiveType();
    }

    /* renamed from: b */
    public final RuntimeTypeMapper.e m9339b(FunctionDescriptor functionDescriptor) {
        String jvmMethodNameIfSpecial = specialBuiltinMembers.getJvmMethodNameIfSpecial(functionDescriptor);
        if (jvmMethodNameIfSpecial == null) {
            if (functionDescriptor instanceof PropertyGetterDescriptor) {
                String strAsString = DescriptorUtils2.getPropertyIfAccessor(functionDescriptor).getName().asString();
                Intrinsics3.checkNotNullExpressionValue(strAsString, "descriptor.propertyIfAccessor.name.asString()");
                jvmMethodNameIfSpecial = JvmAbi.getterName(strAsString);
            } else if (functionDescriptor instanceof PropertySetterDescriptor) {
                String strAsString2 = DescriptorUtils2.getPropertyIfAccessor(functionDescriptor).getName().asString();
                Intrinsics3.checkNotNullExpressionValue(strAsString2, "descriptor.propertyIfAccessor.name.asString()");
                jvmMethodNameIfSpecial = JvmAbi.setterName(strAsString2);
            } else {
                jvmMethodNameIfSpecial = functionDescriptor.getName().asString();
                Intrinsics3.checkNotNullExpressionValue(jvmMethodNameIfSpecial, "descriptor.name.asString()");
            }
        }
        return new RuntimeTypeMapper.e(new JvmMemberSignature.b(jvmMethodNameIfSpecial, methodSignatureMapping3.computeJvmDescriptor$default(functionDescriptor, false, false, 1, null)));
    }

    public final ClassId mapJvmClassToKotlinClassId(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "klass");
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            Intrinsics3.checkNotNullExpressionValue(componentType, "klass.componentType");
            PrimitiveType primitiveTypeM9338a = m9338a(componentType);
            if (primitiveTypeM9338a != null) {
                return new ClassId(StandardNames.f22499l, primitiveTypeM9338a.getArrayTypeName());
            }
            ClassId classId = ClassId.topLevel(StandardNames.a.f22544h.toSafe());
            Intrinsics3.checkNotNullExpressionValue(classId, "ClassId.topLevel(Standar…s.FqNames.array.toSafe())");
            return classId;
        }
        if (Intrinsics3.areEqual(cls, Void.TYPE)) {
            return f22357a;
        }
        PrimitiveType primitiveTypeM9338a2 = m9338a(cls);
        if (primitiveTypeM9338a2 != null) {
            return new ClassId(StandardNames.f22499l, primitiveTypeM9338a2.getTypeName());
        }
        ClassId classId2 = reflectClassUtil.getClassId(cls);
        if (!classId2.isLocal()) {
            JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.f22614a;
            FqName fqNameAsSingleFqName = classId2.asSingleFqName();
            Intrinsics3.checkNotNullExpressionValue(fqNameAsSingleFqName, "classId.asSingleFqName()");
            ClassId classIdMapJavaToKotlin = javaToKotlinClassMap.mapJavaToKotlin(fqNameAsSingleFqName);
            if (classIdMapJavaToKotlin != null) {
                return classIdMapJavaToKotlin;
            }
        }
        return classId2;
    }

    public final RuntimeTypeMapper2 mapPropertySignature(PropertyDescriptor propertyDescriptor) {
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "possiblyOverriddenProperty");
        CallableMemberDescriptor callableMemberDescriptorUnwrapFakeOverride = DescriptorUtils.unwrapFakeOverride(propertyDescriptor);
        Intrinsics3.checkNotNullExpressionValue(callableMemberDescriptorUnwrapFakeOverride, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
        PropertyDescriptor original = ((PropertyDescriptor) callableMemberDescriptorUnwrapFakeOverride).getOriginal();
        Intrinsics3.checkNotNullExpressionValue(original, "DescriptorUtils.unwrapFa…rriddenProperty).original");
        if (original instanceof DeserializedMemberDescriptor4) {
            DeserializedMemberDescriptor4 deserializedMemberDescriptor4 = (DeserializedMemberDescriptor4) original;
            C11689n proto = deserializedMemberDescriptor4.getProto();
            GeneratedMessageLite.f<C11689n, JvmProtoBuf.d> fVar = JvmProtoBuf.f23654d;
            Intrinsics3.checkNotNullExpressionValue(fVar, "JvmProtoBuf.propertySignature");
            JvmProtoBuf.d dVar = (JvmProtoBuf.d) ProtoBufUtil.getExtensionOrNull(proto, fVar);
            if (dVar != null) {
                return new RuntimeTypeMapper2.c(original, proto, dVar, deserializedMemberDescriptor4.getNameResolver(), deserializedMemberDescriptor4.getTypeTable());
            }
        } else if (original instanceof JavaPropertyDescriptor) {
            SourceElement source = ((JavaPropertyDescriptor) original).getSource();
            if (!(source instanceof JavaSourceElementFactory)) {
                source = null;
            }
            JavaSourceElementFactory javaSourceElementFactory = (JavaSourceElementFactory) source;
            InterfaceC11579l javaElement = javaSourceElementFactory != null ? javaSourceElementFactory.getJavaElement() : null;
            if (javaElement instanceof ReflectJavaField) {
                return new RuntimeTypeMapper2.a(((ReflectJavaField) javaElement).getMember());
            }
            if (!(javaElement instanceof ReflectJavaMethod)) {
                throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + original + " (source = " + javaElement + ')');
            }
            Method member = ((ReflectJavaMethod) javaElement).getMember();
            PropertySetterDescriptor setter = original.getSetter();
            SourceElement source2 = setter != null ? setter.getSource() : null;
            if (!(source2 instanceof JavaSourceElementFactory)) {
                source2 = null;
            }
            JavaSourceElementFactory javaSourceElementFactory2 = (JavaSourceElementFactory) source2;
            InterfaceC11579l javaElement2 = javaSourceElementFactory2 != null ? javaSourceElementFactory2.getJavaElement() : null;
            if (!(javaElement2 instanceof ReflectJavaMethod)) {
                javaElement2 = null;
            }
            ReflectJavaMethod reflectJavaMethod = (ReflectJavaMethod) javaElement2;
            return new RuntimeTypeMapper2.b(member, reflectJavaMethod != null ? reflectJavaMethod.getMember() : null);
        }
        PropertyGetterDescriptor getter = original.getGetter();
        Intrinsics3.checkNotNull(getter);
        RuntimeTypeMapper.e eVarM9339b = m9339b(getter);
        PropertySetterDescriptor setter2 = original.getSetter();
        return new RuntimeTypeMapper2.d(eVarM9339b, setter2 != null ? m9339b(setter2) : null);
    }

    public final RuntimeTypeMapper mapSignature(FunctionDescriptor functionDescriptor) {
        Method member;
        JvmMemberSignature.b jvmConstructorSignature;
        JvmMemberSignature.b jvmMethodSignature;
        Intrinsics3.checkNotNullParameter(functionDescriptor, "possiblySubstitutedFunction");
        CallableMemberDescriptor callableMemberDescriptorUnwrapFakeOverride = DescriptorUtils.unwrapFakeOverride(functionDescriptor);
        Intrinsics3.checkNotNullExpressionValue(callableMemberDescriptorUnwrapFakeOverride, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
        FunctionDescriptor original = ((FunctionDescriptor) callableMemberDescriptorUnwrapFakeOverride).getOriginal();
        Intrinsics3.checkNotNullExpressionValue(original, "DescriptorUtils.unwrapFa…titutedFunction).original");
        if (original instanceof DeserializedMemberDescriptor) {
            DeserializedMemberDescriptor deserializedMemberDescriptor = (DeserializedMemberDescriptor) original;
            MessageLite proto = deserializedMemberDescriptor.getProto();
            if ((proto instanceof C11684i) && (jvmMethodSignature = JvmProtoBufUtil.f23720a.getJvmMethodSignature((C11684i) proto, deserializedMemberDescriptor.getNameResolver(), deserializedMemberDescriptor.getTypeTable())) != null) {
                return new RuntimeTypeMapper.e(jvmMethodSignature);
            }
            if (!(proto instanceof C11679d) || (jvmConstructorSignature = JvmProtoBufUtil.f23720a.getJvmConstructorSignature((C11679d) proto, deserializedMemberDescriptor.getNameResolver(), deserializedMemberDescriptor.getTypeTable())) == null) {
                return m9339b(original);
            }
            DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
            Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "possiblySubstitutedFunction.containingDeclaration");
            return inlineClassesUtils.isInlineClass(containingDeclaration) ? new RuntimeTypeMapper.e(jvmConstructorSignature) : new RuntimeTypeMapper.d(jvmConstructorSignature);
        }
        if (original instanceof JavaMethodDescriptor) {
            SourceElement source = ((JavaMethodDescriptor) original).getSource();
            if (!(source instanceof JavaSourceElementFactory)) {
                source = null;
            }
            JavaSourceElementFactory javaSourceElementFactory = (JavaSourceElementFactory) source;
            InterfaceC11579l javaElement = javaSourceElementFactory != null ? javaSourceElementFactory.getJavaElement() : null;
            ReflectJavaMethod reflectJavaMethod = (ReflectJavaMethod) (javaElement instanceof ReflectJavaMethod ? javaElement : null);
            if (reflectJavaMethod != null && (member = reflectJavaMethod.getMember()) != null) {
                return new RuntimeTypeMapper.c(member);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + original);
        }
        if (!(original instanceof JavaClassConstructorDescriptor)) {
            boolean z2 = true;
            if (!DescriptorFactory.isEnumValueOfMethod(original) && !DescriptorFactory.isEnumValuesMethod(original) && (!Intrinsics3.areEqual(original.getName(), CloneableClassScope.f22610e.getCLONE_NAME()) || !original.getValueParameters().isEmpty())) {
                z2 = false;
            }
            if (z2) {
                return m9339b(original);
            }
            throw new KotlinReflectionInternalError("Unknown origin of " + original + " (" + original.getClass() + ')');
        }
        SourceElement source2 = ((JavaClassConstructorDescriptor) original).getSource();
        if (!(source2 instanceof JavaSourceElementFactory)) {
            source2 = null;
        }
        JavaSourceElementFactory javaSourceElementFactory2 = (JavaSourceElementFactory) source2;
        InterfaceC11579l javaElement2 = javaSourceElementFactory2 != null ? javaSourceElementFactory2.getJavaElement() : null;
        if (javaElement2 instanceof ReflectJavaConstructor) {
            return new RuntimeTypeMapper.b(((ReflectJavaConstructor) javaElement2).getMember());
        }
        if (javaElement2 instanceof ReflectJavaClass) {
            ReflectJavaClass reflectJavaClass = (ReflectJavaClass) javaElement2;
            if (reflectJavaClass.isAnnotationType()) {
                return new RuntimeTypeMapper.a(reflectJavaClass.getElement());
            }
        }
        throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + original + " (" + javaElement2 + ')');
    }
}
