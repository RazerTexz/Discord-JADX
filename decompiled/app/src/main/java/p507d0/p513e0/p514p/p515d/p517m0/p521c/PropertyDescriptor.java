package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitutor2;

/* compiled from: PropertyDescriptor.java */
/* renamed from: d0.e0.p.d.m0.c.n0, reason: use source file name */
/* loaded from: classes3.dex */
public interface PropertyDescriptor extends CallableMemberDescriptor, VariableDescriptor {
    List<PropertyAccessorDescriptor> getAccessors();

    FieldDescriptor getBackingField();

    FieldDescriptor getDelegateField();

    PropertyGetterDescriptor getGetter();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    PropertyDescriptor getOriginal();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    Collection<? extends PropertyDescriptor> getOverriddenDescriptors();

    PropertySetterDescriptor getSetter();

    boolean isDelegated();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    PropertyDescriptor substitute(TypeSubstitutor2 typeSubstitutor2);
}
