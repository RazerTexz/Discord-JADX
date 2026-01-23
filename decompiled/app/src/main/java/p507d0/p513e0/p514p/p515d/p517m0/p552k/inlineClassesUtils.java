package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyGetterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.VariableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitutor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.g, reason: use source file name */
/* JADX INFO: compiled from: inlineClassesUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class inlineClassesUtils {
    static {
        new FqName("kotlin.jvm.JvmInline");
    }

    public static final boolean isGetterOfUnderlyingPropertyOfInlineClass(CallableDescriptor callableDescriptor) {
        Intrinsics3.checkNotNullParameter(callableDescriptor, "<this>");
        if (callableDescriptor instanceof PropertyGetterDescriptor) {
            PropertyDescriptor correspondingProperty = ((PropertyGetterDescriptor) callableDescriptor).getCorrespondingProperty();
            Intrinsics3.checkNotNullExpressionValue(correspondingProperty, "correspondingProperty");
            if (isUnderlyingPropertyOfInlineClass(correspondingProperty)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isInlineClass(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        if (declarationDescriptor instanceof ClassDescriptor) {
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            if (classDescriptor.isInline() || classDescriptor.isValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isInlineClassType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return false;
        }
        return isInlineClass(declarationDescriptor);
    }

    public static final boolean isUnderlyingPropertyOfInlineClass(VariableDescriptor variableDescriptor) {
        Intrinsics3.checkNotNullParameter(variableDescriptor, "<this>");
        if (variableDescriptor.getExtensionReceiverParameter() != null) {
            return false;
        }
        DeclarationDescriptor containingDeclaration = variableDescriptor.getContainingDeclaration();
        Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "this.containingDeclaration");
        if (!isInlineClass(containingDeclaration)) {
            return false;
        }
        ValueParameterDescriptor valueParameterDescriptorUnderlyingRepresentation = underlyingRepresentation((ClassDescriptor) containingDeclaration);
        return Intrinsics3.areEqual(valueParameterDescriptorUnderlyingRepresentation == null ? null : valueParameterDescriptorUnderlyingRepresentation.getName(), variableDescriptor.getName());
    }

    public static final KotlinType substitutedUnderlyingType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        ValueParameterDescriptor valueParameterDescriptorUnsubstitutedUnderlyingParameter = unsubstitutedUnderlyingParameter(kotlinType);
        if (valueParameterDescriptorUnsubstitutedUnderlyingParameter == null) {
            return null;
        }
        return TypeSubstitutor2.create(kotlinType).substitute(valueParameterDescriptorUnsubstitutedUnderlyingParameter.getType(), Variance.INVARIANT);
    }

    public static final ValueParameterDescriptor underlyingRepresentation(ClassDescriptor classDescriptor) {
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        List<ValueParameterDescriptor> valueParameters;
        Intrinsics3.checkNotNullParameter(classDescriptor, "<this>");
        if (!isInlineClass(classDescriptor) || (unsubstitutedPrimaryConstructor = classDescriptor.getUnsubstitutedPrimaryConstructor()) == null || (valueParameters = unsubstitutedPrimaryConstructor.getValueParameters()) == null) {
            return null;
        }
        return (ValueParameterDescriptor) _Collections.singleOrNull((List) valueParameters);
    }

    public static final ValueParameterDescriptor unsubstitutedUnderlyingParameter(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            declarationDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        if (classDescriptor == null) {
            return null;
        }
        return underlyingRepresentation(classDescriptor);
    }
}
