package p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.inlineClassesUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.y.a, reason: use source file name */
/* JADX INFO: compiled from: inlineClassManglingRules.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class inlineClassManglingRules {
    /* JADX INFO: renamed from: a */
    public static final boolean m9943a(KotlinType kotlinType) {
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        TypeParameterDescriptor typeParameterDescriptor = declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null;
        if (typeParameterDescriptor == null) {
            return false;
        }
        return m9944b(TypeUtils2.getRepresentativeUpperBound(typeParameterDescriptor));
    }

    /* JADX INFO: renamed from: b */
    public static final boolean m9944b(KotlinType kotlinType) {
        return isInlineClassThatRequiresMangling(kotlinType) || m9943a(kotlinType);
    }

    public static final boolean isInlineClassThatRequiresMangling(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        return inlineClassesUtils.isInlineClass(declarationDescriptor) && !Intrinsics3.areEqual(DescriptorUtils2.getFqNameSafe((ClassDescriptor) declarationDescriptor), StandardNames.f22495h);
    }

    public static final boolean shouldHideConstructorDueToInlineClassTypeValueParameters(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        ClassConstructorDescriptor classConstructorDescriptor = callableMemberDescriptor instanceof ClassConstructorDescriptor ? (ClassConstructorDescriptor) callableMemberDescriptor : null;
        if (classConstructorDescriptor == null || DescriptorVisibilities.isPrivate(classConstructorDescriptor.getVisibility())) {
            return false;
        }
        ClassDescriptor constructedClass = classConstructorDescriptor.getConstructedClass();
        Intrinsics3.checkNotNullExpressionValue(constructedClass, "constructorDescriptor.constructedClass");
        if (inlineClassesUtils.isInlineClass(constructedClass) || DescriptorUtils.isSealedClass(classConstructorDescriptor.getConstructedClass())) {
            return false;
        }
        List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "constructorDescriptor.valueParameters");
        if ((valueParameters instanceof Collection) && valueParameters.isEmpty()) {
            return false;
        }
        Iterator<T> it = valueParameters.iterator();
        while (it.hasNext()) {
            KotlinType type = ((ValueParameterDescriptor) it.next()).getType();
            Intrinsics3.checkNotNullExpressionValue(type, "it.type");
            if (m9944b(type)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isInlineClassThatRequiresMangling(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        return Intrinsics3.areEqual(declarationDescriptor == null ? null : Boolean.valueOf(isInlineClassThatRequiresMangling(declarationDescriptor)), Boolean.TRUE);
    }
}
