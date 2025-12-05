package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Annotations.kt */
/* renamed from: d0.e0.p.d.m0.c.g1.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class Annotations7 implements Annotations4 {

    /* renamed from: j */
    public final Annotations4 f22745j;

    /* renamed from: k */
    public final boolean f22746k;

    /* renamed from: l */
    public final Function1<FqName, Boolean> f22747l;

    /* JADX WARN: Multi-variable type inference failed */
    public Annotations7(Annotations4 annotations4, boolean z2, Function1<? super FqName, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(annotations4, "delegate");
        Intrinsics3.checkNotNullParameter(function1, "fqNameFilter");
        this.f22745j = annotations4;
        this.f22746k = z2;
        this.f22747l = function1;
    }

    /* renamed from: c */
    public final boolean m9386c(AnnotationDescriptor annotationDescriptor) {
        FqName fqName = annotationDescriptor.getFqName();
        return fqName != null && this.f22747l.invoke(fqName).booleanValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public AnnotationDescriptor findAnnotation(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        if (this.f22747l.invoke(fqName).booleanValue()) {
            return this.f22745j.findAnnotation(fqName);
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public boolean hasAnnotation(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        if (this.f22747l.invoke(fqName).booleanValue()) {
            return this.f22745j.hasAnnotation(fqName);
        }
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public boolean isEmpty() {
        boolean z2;
        Annotations4 annotations4 = this.f22745j;
        if ((annotations4 instanceof Collection) && ((Collection) annotations4).isEmpty()) {
            z2 = false;
        } else {
            Iterator<AnnotationDescriptor> it = annotations4.iterator();
            while (it.hasNext()) {
                if (m9386c(it.next())) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        return this.f22746k ? !z2 : z2;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        Annotations4 annotations4 = this.f22745j;
        ArrayList arrayList = new ArrayList();
        for (AnnotationDescriptor annotationDescriptor : annotations4) {
            if (m9386c(annotationDescriptor)) {
                arrayList.add(annotationDescriptor);
            }
        }
        return arrayList.iterator();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Annotations7(Annotations4 annotations4, Function1<? super FqName, Boolean> function1) {
        this(annotations4, false, function1);
        Intrinsics3.checkNotNullParameter(annotations4, "delegate");
        Intrinsics3.checkNotNullParameter(function1, "fqNameFilter");
    }
}
