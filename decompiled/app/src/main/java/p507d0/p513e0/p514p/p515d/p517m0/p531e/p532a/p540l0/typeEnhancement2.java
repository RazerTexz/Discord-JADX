package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import java.util.Iterator;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.b, reason: use source file name */
/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeEnhancement2 implements Annotations4 {

    /* JADX INFO: renamed from: j */
    public final FqName f23442j;

    public typeEnhancement2(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqNameToMatch");
        this.f23442j = fqName;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public /* bridge */ /* synthetic */ AnnotationDescriptor findAnnotation(FqName fqName) {
        return findAnnotation(fqName);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public boolean hasAnnotation(FqName fqName) {
        return Annotations4.b.hasAnnotation(this, fqName);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return Collections2.emptyList().iterator();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public typeEnhancement findAnnotation(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        if (Intrinsics3.areEqual(fqName, this.f23442j)) {
            return typeEnhancement.f23441a;
        }
        return null;
    }
}
