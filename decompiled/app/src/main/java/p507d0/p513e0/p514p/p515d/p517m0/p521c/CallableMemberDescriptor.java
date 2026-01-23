package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collection;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.b, reason: use source file name */
/* JADX INFO: compiled from: CallableMemberDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface CallableMemberDescriptor extends CallableDescriptor, MemberDescriptor {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.b$a */
    /* JADX INFO: compiled from: CallableMemberDescriptor.java */
    public enum a {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        public boolean isReal() {
            return this != FAKE_OVERRIDE;
        }
    }

    CallableMemberDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, a aVar, boolean z2);

    a getKind();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    CallableMemberDescriptor getOriginal();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    Collection<? extends CallableMemberDescriptor> getOverriddenDescriptors();

    void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection);
}
