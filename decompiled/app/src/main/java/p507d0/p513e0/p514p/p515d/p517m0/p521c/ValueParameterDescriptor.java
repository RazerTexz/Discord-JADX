package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;

/* compiled from: ValueParameterDescriptor.kt */
/* renamed from: d0.e0.p.d.m0.c.c1, reason: use source file name */
/* loaded from: classes3.dex */
public interface ValueParameterDescriptor extends ParameterDescriptor, VariableDescriptor {
    ValueParameterDescriptor copy(CallableDescriptor callableDescriptor, Name name, int i);

    boolean declaresDefaultValue();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueDescriptor2, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    CallableDescriptor getContainingDeclaration();

    int getIndex();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    ValueParameterDescriptor getOriginal();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    Collection<ValueParameterDescriptor> getOverriddenDescriptors();

    KotlinType getVarargElementType();

    boolean isCrossinline();

    boolean isNoinline();
}
