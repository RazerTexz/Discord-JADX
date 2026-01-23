package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import java.util.Map;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.d, reason: use source file name */
/* JADX INFO: compiled from: AnnotationDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class AnnotationDescriptorImpl implements AnnotationDescriptor {

    /* JADX INFO: renamed from: a */
    public final KotlinType f22717a;

    /* JADX INFO: renamed from: b */
    public final Map<Name, AbstractC11815g<?>> f22718b;

    /* JADX INFO: renamed from: c */
    public final SourceElement f22719c;

    public AnnotationDescriptorImpl(KotlinType kotlinType, Map<Name, AbstractC11815g<?>> map, SourceElement sourceElement) {
        if (kotlinType == null) {
            m9385a(0);
            throw null;
        }
        if (map == null) {
            m9385a(1);
            throw null;
        }
        if (sourceElement == null) {
            m9385a(2);
            throw null;
        }
        this.f22717a = kotlinType;
        this.f22718b = map;
        this.f22719c = sourceElement;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9385a(int i) {
        String str = (i == 3 || i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "valueArguments";
        } else if (i == 2) {
            objArr[0] = "source";
        } else if (i == 3 || i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i == 3) {
            objArr[1] = "getType";
        } else if (i == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 3 && i != 4 && i != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public Map<Name, AbstractC11815g<?>> getAllValueArguments() {
        Map<Name, AbstractC11815g<?>> map = this.f22718b;
        if (map != null) {
            return map;
        }
        m9385a(4);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public FqName getFqName() {
        return AnnotationDescriptor.a.getFqName(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public SourceElement getSource() {
        SourceElement sourceElement = this.f22719c;
        if (sourceElement != null) {
            return sourceElement;
        }
        m9385a(5);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public KotlinType getType() {
        KotlinType kotlinType = this.f22717a;
        if (kotlinType != null) {
            return kotlinType;
        }
        m9385a(3);
        throw null;
    }

    public String toString() {
        return DescriptorRenderer2.f24226b.renderAnnotation(this, null);
    }
}
