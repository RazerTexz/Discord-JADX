package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitutor2;

/* compiled from: FunctionDescriptor.java */
/* renamed from: d0.e0.p.d.m0.c.x, reason: use source file name */
/* loaded from: classes3.dex */
public interface FunctionDescriptor extends CallableMemberDescriptor {

    /* compiled from: FunctionDescriptor.java */
    /* renamed from: d0.e0.p.d.m0.c.x$a */
    public interface a<D extends FunctionDescriptor> {
        D build();

        a<D> setAdditionalAnnotations(Annotations4 annotations4);

        a<D> setCopyOverrides(boolean z2);

        a<D> setDispatchReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor);

        a<D> setDropOriginalInContainingParts();

        a<D> setExtensionReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor);

        a<D> setHiddenForResolutionEverywhereBesideSupercalls();

        a<D> setHiddenToOvercomeSignatureClash();

        a<D> setKind(CallableMemberDescriptor.a aVar);

        a<D> setModality(Modality modality);

        a<D> setName(Name name);

        a<D> setOriginal(CallableMemberDescriptor callableMemberDescriptor);

        a<D> setOwner(DeclarationDescriptor declarationDescriptor);

        a<D> setPreserveSourceElement();

        a<D> setReturnType(KotlinType kotlinType);

        a<D> setSignatureChange();

        a<D> setSubstitution(TypeSubstitution5 typeSubstitution5);

        a<D> setTypeParameters(List<TypeParameterDescriptor> list);

        a<D> setValueParameters(List<ValueParameterDescriptor> list);

        a<D> setVisibility(DescriptorVisibility2 descriptorVisibility2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    DeclarationDescriptor getContainingDeclaration();

    FunctionDescriptor getInitialSignatureDescriptor();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    FunctionDescriptor getOriginal();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    Collection<? extends FunctionDescriptor> getOverriddenDescriptors();

    boolean isHiddenForResolutionEverywhereBesideSupercalls();

    boolean isHiddenToOvercomeSignatureClash();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();

    boolean isTailrec();

    a<? extends FunctionDescriptor> newCopyBuilder();

    FunctionDescriptor substitute(TypeSubstitutor2 typeSubstitutor2);
}
