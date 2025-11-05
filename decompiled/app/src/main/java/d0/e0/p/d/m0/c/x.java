package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.c.b;
import java.util.Collection;
import java.util.List;

/* compiled from: FunctionDescriptor.java */
/* loaded from: classes3.dex */
public interface x extends b {

    /* compiled from: FunctionDescriptor.java */
    public interface a<D extends x> {
        D build();

        a<D> setAdditionalAnnotations(d0.e0.p.d.m0.c.g1.g gVar);

        a<D> setCopyOverrides(boolean z2);

        a<D> setDispatchReceiverParameter(q0 q0Var);

        a<D> setDropOriginalInContainingParts();

        a<D> setExtensionReceiverParameter(q0 q0Var);

        a<D> setHiddenForResolutionEverywhereBesideSupercalls();

        a<D> setHiddenToOvercomeSignatureClash();

        a<D> setKind(b.a aVar);

        a<D> setModality(z zVar);

        a<D> setName(d0.e0.p.d.m0.g.e eVar);

        a<D> setOriginal(b bVar);

        a<D> setOwner(m mVar);

        a<D> setPreserveSourceElement();

        a<D> setReturnType(d0.e0.p.d.m0.n.c0 c0Var);

        a<D> setSignatureChange();

        a<D> setSubstitution(d0.e0.p.d.m0.n.z0 z0Var);

        a<D> setTypeParameters(List<z0> list);

        a<D> setValueParameters(List<c1> list);

        a<D> setVisibility(u uVar);
    }

    @Override // d0.e0.p.d.m0.c.n, d0.e0.p.d.m0.c.m
    m getContainingDeclaration();

    x getInitialSignatureDescriptor();

    @Override // d0.e0.p.d.m0.c.b, d0.e0.p.d.m0.c.a, d0.e0.p.d.m0.c.m
    x getOriginal();

    @Override // d0.e0.p.d.m0.c.b, d0.e0.p.d.m0.c.a
    Collection<? extends x> getOverriddenDescriptors();

    boolean isHiddenForResolutionEverywhereBesideSupercalls();

    boolean isHiddenToOvercomeSignatureClash();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();

    boolean isTailrec();

    a<? extends x> newCopyBuilder();

    x substitute(d0.e0.p.d.m0.n.c1 c1Var);
}
