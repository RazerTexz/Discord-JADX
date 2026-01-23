package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.h, reason: use source file name */
/* JADX INFO: compiled from: AnnotationsImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationsImpl implements Annotations4 {

    /* JADX INFO: renamed from: j */
    public final List<AnnotationDescriptor> f22738j;

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotationsImpl(List<? extends AnnotationDescriptor> list) {
        Intrinsics3.checkNotNullParameter(list, "annotations");
        this.f22738j = list;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public AnnotationDescriptor findAnnotation(FqName fqName) {
        return Annotations4.b.findAnnotation(this, fqName);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public boolean hasAnnotation(FqName fqName) {
        return Annotations4.b.hasAnnotation(this, fqName);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public boolean isEmpty() {
        return this.f22738j.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return this.f22738j.iterator();
    }

    public String toString() {
        return this.f22738j.toString();
    }
}
