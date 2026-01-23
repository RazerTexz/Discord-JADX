package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.CompanionObjectMapping;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.CompanionObjectMappingUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FieldDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.n, reason: use source file name */
/* JADX INFO: compiled from: DescriptorsJvmAbiUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DescriptorsJvmAbiUtil {
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9517a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1 || i == 2) {
            objArr[0] = "companionObject";
        } else if (i != 3) {
            objArr[0] = "propertyDescriptor";
        } else {
            objArr[0] = "memberDescriptor";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i == 1) {
            objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        } else if (i == 2) {
            objArr[2] = "isMappedIntrinsicCompanionObject";
        } else if (i != 3) {
            objArr[2] = "isPropertyWithBackingFieldInOuterClass";
        } else {
            objArr[2] = "hasJvmFieldAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean hasJvmFieldAnnotation(CallableMemberDescriptor callableMemberDescriptor) {
        FieldDescriptor backingField;
        if (callableMemberDescriptor == null) {
            m9517a(3);
            throw null;
        }
        if ((callableMemberDescriptor instanceof PropertyDescriptor) && (backingField = ((PropertyDescriptor) callableMemberDescriptor).getBackingField()) != null && backingField.getAnnotations().hasAnnotation(JvmAbi.f23532b)) {
            return true;
        }
        return callableMemberDescriptor.getAnnotations().hasAnnotation(JvmAbi.f23532b);
    }

    public static boolean isClassCompanionObjectWithBackingFieldsInOuter(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            return DescriptorUtils.isCompanionObject(declarationDescriptor) && DescriptorUtils.isClassOrEnumClass(declarationDescriptor.getContainingDeclaration()) && !isMappedIntrinsicCompanionObject((ClassDescriptor) declarationDescriptor);
        }
        m9517a(1);
        throw null;
    }

    public static boolean isMappedIntrinsicCompanionObject(ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return CompanionObjectMappingUtils.isMappedIntrinsicCompanionObject(CompanionObjectMapping.f22455a, classDescriptor);
        }
        m9517a(2);
        throw null;
    }

    public static boolean isPropertyWithBackingFieldInOuterClass(PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor == null) {
            m9517a(0);
            throw null;
        }
        if (propertyDescriptor.getKind() == CallableMemberDescriptor.a.FAKE_OVERRIDE) {
            return false;
        }
        if (isClassCompanionObjectWithBackingFieldsInOuter(propertyDescriptor.getContainingDeclaration())) {
            return true;
        }
        return DescriptorUtils.isCompanionObject(propertyDescriptor.getContainingDeclaration()) && hasJvmFieldAnnotation(propertyDescriptor);
    }
}
