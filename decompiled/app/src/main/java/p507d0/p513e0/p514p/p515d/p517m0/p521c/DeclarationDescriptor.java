package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;

/* compiled from: DeclarationDescriptor.java */
/* renamed from: d0.e0.p.d.m0.c.m, reason: use source file name */
/* loaded from: classes3.dex */
public interface DeclarationDescriptor extends Annotations3 {
    <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d);

    DeclarationDescriptor getContainingDeclaration();

    Name getName();

    DeclarationDescriptor getOriginal();
}
