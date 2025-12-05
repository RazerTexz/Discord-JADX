package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;

/* compiled from: ClassifierDescriptor.java */
/* renamed from: d0.e0.p.d.m0.c.h, reason: use source file name */
/* loaded from: classes3.dex */
public interface ClassifierDescriptor extends DeclarationDescriptorNonRoot {
    KotlinType4 getDefaultType();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    ClassifierDescriptor getOriginal();

    TypeConstructor getTypeConstructor();
}
