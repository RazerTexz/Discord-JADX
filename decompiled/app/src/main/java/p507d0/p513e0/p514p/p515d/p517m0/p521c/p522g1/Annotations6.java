package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p578f0._Sequences2;
import p507d0.p580t._Arrays;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.k, reason: use source file name */
/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Annotations6 implements Annotations4 {

    /* JADX INFO: renamed from: j */
    public final List<Annotations4> f22743j;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.k$a */
    /* JADX INFO: compiled from: Annotations.kt */
    public static final class a extends Lambda implements Function1<Annotations4, AnnotationDescriptor> {
        public final /* synthetic */ FqName $fqName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FqName fqName) {
            super(1);
            this.$fqName = fqName;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AnnotationDescriptor invoke(Annotations4 annotations4) {
            return invoke2(annotations4);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final AnnotationDescriptor invoke2(Annotations4 annotations4) {
            Intrinsics3.checkNotNullParameter(annotations4, "it");
            return annotations4.findAnnotation(this.$fqName);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.k$b */
    /* JADX INFO: compiled from: Annotations.kt */
    public static final class b extends Lambda implements Function1<Annotations4, Sequence<? extends AnnotationDescriptor>> {

        /* JADX INFO: renamed from: j */
        public static final b f22744j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Sequence<? extends AnnotationDescriptor> invoke(Annotations4 annotations4) {
            return invoke2(annotations4);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Sequence<AnnotationDescriptor> invoke2(Annotations4 annotations4) {
            Intrinsics3.checkNotNullParameter(annotations4, "it");
            return _Collections.asSequence(annotations4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Annotations6(List<? extends Annotations4> list) {
        Intrinsics3.checkNotNullParameter(list, "delegates");
        this.f22743j = list;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public AnnotationDescriptor findAnnotation(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        return (AnnotationDescriptor) _Sequences2.firstOrNull(_Sequences2.mapNotNull(_Collections.asSequence(this.f22743j), new a(fqName)));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public boolean hasAnnotation(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Iterator it = _Collections.asSequence(this.f22743j).iterator();
        while (it.hasNext()) {
            if (((Annotations4) it.next()).hasAnnotation(fqName)) {
                return true;
            }
        }
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public boolean isEmpty() {
        List<Annotations4> list = this.f22743j;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((Annotations4) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return _Sequences2.flatMap(_Collections.asSequence(this.f22743j), b.f22744j).iterator();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Annotations6(Annotations4... annotations4Arr) {
        this((List<? extends Annotations4>) _Arrays.toList(annotations4Arr));
        Intrinsics3.checkNotNullParameter(annotations4Arr, "delegates");
    }
}
