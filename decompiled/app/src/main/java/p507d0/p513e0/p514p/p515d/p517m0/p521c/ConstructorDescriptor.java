package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitutor2;

/* compiled from: ConstructorDescriptor.java */
/* renamed from: d0.e0.p.d.m0.c.l, reason: use source file name */
/* loaded from: classes3.dex */
public interface ConstructorDescriptor extends FunctionDescriptor {
    ClassDescriptor getConstructedClass();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    ClassifierDescriptorWithTypeParameters getContainingDeclaration();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    KotlinType getReturnType();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    List<TypeParameterDescriptor> getTypeParameters();

    boolean isPrimary();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    ConstructorDescriptor substitute(TypeSubstitutor2 typeSubstitutor2);
}
