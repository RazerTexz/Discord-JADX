package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.e0, reason: use source file name */
/* JADX INFO: compiled from: PackageFragmentDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface PackageFragmentDescriptor extends ClassOrPackageFragmentDescriptor {
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    ModuleDescriptor2 getContainingDeclaration();

    FqName getFqName();

    MemberScope3 getMemberScope();
}
