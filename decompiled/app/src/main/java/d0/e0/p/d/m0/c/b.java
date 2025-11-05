package d0.e0.p.d.m0.c;

import java.util.Collection;

/* compiled from: CallableMemberDescriptor.java */
/* loaded from: classes3.dex */
public interface b extends d0.e0.p.d.m0.c.a, y {

    /* compiled from: CallableMemberDescriptor.java */
    public enum a {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        public boolean isReal() {
            return this != FAKE_OVERRIDE;
        }
    }

    b copy(m mVar, z zVar, u uVar, a aVar, boolean z2);

    a getKind();

    @Override // d0.e0.p.d.m0.c.a, d0.e0.p.d.m0.c.m
    b getOriginal();

    @Override // d0.e0.p.d.m0.c.a
    Collection<? extends b> getOverriddenDescriptors();

    void setOverriddenDescriptors(Collection<? extends b> collection);
}
