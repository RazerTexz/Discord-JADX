package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.c, reason: use source file name */
/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeParameterUtils2 implements TypeParameterDescriptor {

    /* JADX INFO: renamed from: j */
    public final TypeParameterDescriptor f22682j;

    /* JADX INFO: renamed from: k */
    public final DeclarationDescriptor f22683k;

    /* JADX INFO: renamed from: l */
    public final int f22684l;

    public typeParameterUtils2(TypeParameterDescriptor typeParameterDescriptor, DeclarationDescriptor declarationDescriptor, int i) {
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "originalDescriptor");
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        this.f22682j = typeParameterDescriptor;
        this.f22683k = declarationDescriptor;
        this.f22684l = i;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return (R) this.f22682j.accept(declarationDescriptorVisitor, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public Annotations4 getAnnotations() {
        return this.f22682j.getAnnotations();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        return this.f22683k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor
    public KotlinType4 getDefaultType() {
        return this.f22682j.getDefaultType();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor
    public int getIndex() {
        return this.f22682j.getIndex() + this.f22684l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public Name getName() {
        return this.f22682j.getName();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return this.f22682j.getSource();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor
    public StorageManager getStorageManager() {
        return this.f22682j.getStorageManager();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.f22682j.getTypeConstructor();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor
    public List<KotlinType> getUpperBounds() {
        return this.f22682j.getUpperBounds();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor
    public Variance getVariance() {
        return this.f22682j.getVariance();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor
    public boolean isCapturedFromOuterDeclaration() {
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor
    public boolean isReified() {
        return this.f22682j.isReified();
    }

    public String toString() {
        return this.f22682j + "[inner-copy]";
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public TypeParameterDescriptor getOriginal() {
        TypeParameterDescriptor original = this.f22682j.getOriginal();
        Intrinsics3.checkNotNullExpressionValue(original, "originalDescriptor.original");
        return original;
    }
}
