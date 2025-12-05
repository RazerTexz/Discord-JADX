package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitutor2;

/* compiled from: ClassConstructorDescriptor.kt */
/* renamed from: d0.e0.p.d.m0.c.d, reason: use source file name */
/* loaded from: classes3.dex */
public interface ClassConstructorDescriptor extends ConstructorDescriptor {
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    ClassConstructorDescriptor getOriginal();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ConstructorDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    ClassConstructorDescriptor substitute(TypeSubstitutor2 typeSubstitutor2);
}
