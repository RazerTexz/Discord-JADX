package p507d0.p513e0.p514p.p515d.p516l0;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.KotlinReflectionInternalError;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.VariableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.inlineClassesUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.util2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.l0.h, reason: use source file name */
/* JADX INFO: compiled from: InlineClassAwareCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InlineClassAwareCaller2 {
    /* JADX INFO: renamed from: a */
    public static final KotlinType m9354a(CallableMemberDescriptor callableMemberDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        ReceiverParameterDescriptor dispatchReceiverParameter = callableMemberDescriptor.getDispatchReceiverParameter();
        if (extensionReceiverParameter != null) {
            return extensionReceiverParameter.getType();
        }
        if (dispatchReceiverParameter == null) {
            return null;
        }
        if (callableMemberDescriptor instanceof ConstructorDescriptor) {
            return dispatchReceiverParameter.getType();
        }
        DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            containingDeclaration = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        if (classDescriptor != null) {
            return classDescriptor.getDefaultType();
        }
        return null;
    }

    public static final Object coerceToExpectedReceiverType(Object obj, CallableMemberDescriptor callableMemberDescriptor) {
        KotlinType kotlinTypeM9354a;
        Class<?> inlineClass;
        Method unboxMethod;
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        return (((callableMemberDescriptor instanceof PropertyDescriptor) && inlineClassesUtils.isUnderlyingPropertyOfInlineClass((VariableDescriptor) callableMemberDescriptor)) || (kotlinTypeM9354a = m9354a(callableMemberDescriptor)) == null || (inlineClass = toInlineClass(kotlinTypeM9354a)) == null || (unboxMethod = getUnboxMethod(inlineClass, callableMemberDescriptor)) == null) ? obj : unboxMethod.invoke(obj, new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <M extends Member> Caller2<M> createInlineClassAwareCallerIfNeeded(Caller2<? extends M> caller2, CallableMemberDescriptor callableMemberDescriptor, boolean z2) {
        boolean z3;
        KotlinType returnType;
        Intrinsics3.checkNotNullParameter(caller2, "$this$createInlineClassAwareCallerIfNeeded");
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        boolean z4 = false;
        if (!inlineClassesUtils.isGetterOfUnderlyingPropertyOfInlineClass(callableMemberDescriptor)) {
            List<ValueParameterDescriptor> valueParameters = callableMemberDescriptor.getValueParameters();
            Intrinsics3.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            if ((valueParameters instanceof Collection) && valueParameters.isEmpty()) {
                z3 = false;
                if (z3) {
                    z4 = true;
                }
            } else {
                for (ValueParameterDescriptor valueParameterDescriptor : valueParameters) {
                    Intrinsics3.checkNotNullExpressionValue(valueParameterDescriptor, "it");
                    KotlinType type = valueParameterDescriptor.getType();
                    Intrinsics3.checkNotNullExpressionValue(type, "it.type");
                    if (inlineClassesUtils.isInlineClassType(type)) {
                        z3 = true;
                        break;
                    }
                }
                z3 = false;
                if (!z3 || ((returnType = callableMemberDescriptor.getReturnType()) != null && inlineClassesUtils.isInlineClassType(returnType))) {
                    z4 = true;
                } else if (!(caller2 instanceof Caller)) {
                    KotlinType kotlinTypeM9354a = m9354a(callableMemberDescriptor);
                    if (kotlinTypeM9354a != null && inlineClassesUtils.isInlineClassType(kotlinTypeM9354a)) {
                    }
                }
            }
        }
        return z4 ? new InlineClassAwareCaller(callableMemberDescriptor, caller2, z2) : caller2;
    }

    public static /* synthetic */ Caller2 createInlineClassAwareCallerIfNeeded$default(Caller2 caller2, CallableMemberDescriptor callableMemberDescriptor, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return createInlineClassAwareCallerIfNeeded(caller2, callableMemberDescriptor, z2);
    }

    public static final Method getBoxMethod(Class<?> cls, CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(cls, "$this$getBoxMethod");
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", getUnboxMethod(cls, callableMemberDescriptor).getReturnType());
            Intrinsics3.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(\"box\" …d(descriptor).returnType)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No box method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    public static final Method getUnboxMethod(Class<?> cls, CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(cls, "$this$getUnboxMethod");
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", new Class[0]);
            Intrinsics3.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(\"unbox…FOR_INLINE_CLASS_MEMBERS)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    public static final Class<?> toInlineClass(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "$this$toInlineClass");
        return toInlineClass(kotlinType.getConstructor().getDeclarationDescriptor());
    }

    public static final Class<?> toInlineClass(DeclarationDescriptor declarationDescriptor) {
        if (!(declarationDescriptor instanceof ClassDescriptor) || !inlineClassesUtils.isInlineClass(declarationDescriptor)) {
            return null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        Class<?> javaClass = util2.toJavaClass(classDescriptor);
        if (javaClass != null) {
            return javaClass;
        }
        StringBuilder sbM833U = outline.m833U("Class object for the class ");
        sbM833U.append(classDescriptor.getName());
        sbM833U.append(" cannot be found (classId=");
        sbM833U.append(DescriptorUtils2.getClassId((ClassifierDescriptor) declarationDescriptor));
        sbM833U.append(')');
        throw new KotlinReflectionInternalError(sbM833U.toString());
    }
}
