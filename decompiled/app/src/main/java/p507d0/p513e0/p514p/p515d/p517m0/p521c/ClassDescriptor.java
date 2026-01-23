package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.e, reason: use source file name */
/* JADX INFO: compiled from: ClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ClassDescriptor extends ClassOrPackageFragmentDescriptor, ClassifierDescriptorWithTypeParameters {
    ClassDescriptor getCompanionObjectDescriptor();

    Collection<ClassConstructorDescriptor> getConstructors();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    DeclarationDescriptor getContainingDeclaration();

    List<TypeParameterDescriptor> getDeclaredTypeParameters();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor
    KotlinType4 getDefaultType();

    ClassKind getKind();

    MemberScope3 getMemberScope(TypeSubstitution5 typeSubstitution5);

    Modality getModality();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    ClassDescriptor getOriginal();

    Collection<ClassDescriptor> getSealedSubclasses();

    MemberScope3 getStaticScope();

    ReceiverParameterDescriptor getThisAsReceiverParameter();

    MemberScope3 getUnsubstitutedInnerClassesScope();

    MemberScope3 getUnsubstitutedMemberScope();

    ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor();

    DescriptorVisibility2 getVisibility();

    boolean isCompanionObject();

    boolean isData();

    boolean isFun();

    boolean isInline();

    boolean isValue();
}
