package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11984m;

/* compiled from: TypeParameterDescriptor.java */
/* renamed from: d0.e0.p.d.m0.c.z0, reason: use source file name */
/* loaded from: classes3.dex */
public interface TypeParameterDescriptor extends ClassifierDescriptor, InterfaceC11984m {
    int getIndex();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    TypeParameterDescriptor getOriginal();

    StorageManager getStorageManager();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor
    TypeConstructor getTypeConstructor();

    List<KotlinType> getUpperBounds();

    Variance getVariance();

    boolean isCapturedFromOuterDeclaration();

    boolean isReified();
}
