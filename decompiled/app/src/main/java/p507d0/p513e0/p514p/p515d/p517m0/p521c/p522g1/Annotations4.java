package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.g, reason: use source file name */
/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Annotations4 extends Iterable<AnnotationDescriptor>, KMarkers {

    /* JADX INFO: renamed from: f */
    public static final a f22735f = a.f22736a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.g$a */
    /* JADX INFO: compiled from: Annotations.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ a f22736a = new a();

        /* JADX INFO: renamed from: b */
        public static final Annotations4 f22737b = new C13306a();

        /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Annotations.kt */
        public static final class C13306a implements Annotations4 {
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
            public /* bridge */ /* synthetic */ AnnotationDescriptor findAnnotation(FqName fqName) {
                return (AnnotationDescriptor) m11461findAnnotation(fqName);
            }

            /* JADX INFO: renamed from: findAnnotation, reason: collision with other method in class */
            public Void m11461findAnnotation(FqName fqName) {
                Intrinsics3.checkNotNullParameter(fqName, "fqName");
                return null;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
            public boolean hasAnnotation(FqName fqName) {
                return b.hasAnnotation(this, fqName);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            public Iterator<AnnotationDescriptor> iterator() {
                return Collections2.emptyList().iterator();
            }

            public String toString() {
                return "EMPTY";
            }
        }

        public final Annotations4 create(List<? extends AnnotationDescriptor> list) {
            Intrinsics3.checkNotNullParameter(list, "annotations");
            return list.isEmpty() ? f22737b : new AnnotationsImpl(list);
        }

        public final Annotations4 getEMPTY() {
            return f22737b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.g$b */
    /* JADX INFO: compiled from: Annotations.kt */
    public static final class b {
        public static AnnotationDescriptor findAnnotation(Annotations4 annotations4, FqName fqName) {
            AnnotationDescriptor next;
            Intrinsics3.checkNotNullParameter(annotations4, "this");
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            Iterator<AnnotationDescriptor> it = annotations4.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics3.areEqual(next.getFqName(), fqName)) {
                    break;
                }
            }
            return next;
        }

        public static boolean hasAnnotation(Annotations4 annotations4, FqName fqName) {
            Intrinsics3.checkNotNullParameter(annotations4, "this");
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            return annotations4.findAnnotation(fqName) != null;
        }
    }

    AnnotationDescriptor findAnnotation(FqName fqName);

    boolean hasAnnotation(FqName fqName);

    boolean isEmpty();
}
