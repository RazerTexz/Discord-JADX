package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.JavaDescriptorUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.ExternalOverridabilityCondition;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: FieldOverridabilityCondition.kt */
/* renamed from: d0.e0.p.d.m0.e.a.r, reason: use source file name */
/* loaded from: classes3.dex */
public final class FieldOverridabilityCondition implements ExternalOverridabilityCondition {
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.a getContract() {
        return ExternalOverridabilityCondition.a.BOTH;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.b isOverridable(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        ExternalOverridabilityCondition.b bVar = ExternalOverridabilityCondition.b.UNKNOWN;
        Intrinsics3.checkNotNullParameter(callableDescriptor, "superDescriptor");
        Intrinsics3.checkNotNullParameter(callableDescriptor2, "subDescriptor");
        if (!(callableDescriptor2 instanceof PropertyDescriptor) || !(callableDescriptor instanceof PropertyDescriptor)) {
            return bVar;
        }
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) callableDescriptor2;
        PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) callableDescriptor;
        return !Intrinsics3.areEqual(propertyDescriptor.getName(), propertyDescriptor2.getName()) ? bVar : (JavaDescriptorUtil.isJavaField(propertyDescriptor) && JavaDescriptorUtil.isJavaField(propertyDescriptor2)) ? ExternalOverridabilityCondition.b.OVERRIDABLE : (JavaDescriptorUtil.isJavaField(propertyDescriptor) || JavaDescriptorUtil.isJavaField(propertyDescriptor2)) ? ExternalOverridabilityCondition.b.INCOMPATIBLE : bVar;
    }
}
