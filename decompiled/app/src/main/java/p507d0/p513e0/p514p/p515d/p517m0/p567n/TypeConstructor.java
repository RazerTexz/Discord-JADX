package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11983l;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.u0, reason: use source file name */
/* JADX INFO: compiled from: TypeConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface TypeConstructor extends InterfaceC11983l {
    KotlinBuiltIns getBuiltIns();

    ClassifierDescriptor getDeclarationDescriptor();

    List<TypeParameterDescriptor> getParameters();

    Collection<KotlinType> getSupertypes();

    boolean isDenotable();

    TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner);
}
