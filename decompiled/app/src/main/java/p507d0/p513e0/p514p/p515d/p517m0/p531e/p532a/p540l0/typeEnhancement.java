package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import java.util.Map;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;

/* compiled from: typeEnhancement.kt */
/* renamed from: d0.e0.p.d.m0.e.a.l0.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class typeEnhancement implements AnnotationDescriptor {

    /* renamed from: a */
    public static final typeEnhancement f23441a = new typeEnhancement();

    /* renamed from: a */
    public final Void m9505a() {
        throw new IllegalStateException("No methods should be called on this descriptor. Only its presence matters".toString());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public Map<Name, AbstractC11815g<?>> getAllValueArguments() {
        m9505a();
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public FqName getFqName() {
        return AnnotationDescriptor.a.getFqName(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public SourceElement getSource() {
        m9505a();
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public KotlinType getType() {
        m9505a();
        throw null;
    }

    public String toString() {
        return "[EnhancedType]";
    }
}
