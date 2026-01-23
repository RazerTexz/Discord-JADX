package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.q, reason: use source file name */
/* JADX INFO: compiled from: IntegerValueTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class IntegerValueTypeConstructor implements TypeConstructor {
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getDeclarationDescriptor() {
        return (ClassifierDescriptor) m11471getDeclarationDescriptor();
    }

    /* JADX INFO: renamed from: getDeclarationDescriptor, reason: collision with other method in class */
    public Void m11471getDeclarationDescriptor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public Collection<KotlinType> getSupertypes() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public String toString() {
        return "IntegerValueType(0)";
    }
}
