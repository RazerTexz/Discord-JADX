package d0.e0.p.d.m0.c.g1;

import java.util.Iterator;
import java.util.List;

/* compiled from: Annotations.kt */
/* loaded from: classes3.dex */
public interface g extends Iterable<c>, d0.z.d.g0.a {
    public static final a f = a.a;

    /* compiled from: Annotations.kt */
    public static final class a {
        public static final /* synthetic */ a a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final g f3251b = new C0512a();

        /* compiled from: Annotations.kt */
        /* renamed from: d0.e0.p.d.m0.c.g1.g$a$a, reason: collision with other inner class name */
        public static final class C0512a implements g {
            @Override // d0.e0.p.d.m0.c.g1.g
            public /* bridge */ /* synthetic */ c findAnnotation(d0.e0.p.d.m0.g.b bVar) {
                return (c) m84findAnnotation(bVar);
            }

            /* renamed from: findAnnotation, reason: collision with other method in class */
            public Void m84findAnnotation(d0.e0.p.d.m0.g.b bVar) {
                d0.z.d.m.checkNotNullParameter(bVar, "fqName");
                return null;
            }

            @Override // d0.e0.p.d.m0.c.g1.g
            public boolean hasAnnotation(d0.e0.p.d.m0.g.b bVar) {
                return b.hasAnnotation(this, bVar);
            }

            @Override // d0.e0.p.d.m0.c.g1.g
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            public Iterator<c> iterator() {
                return d0.t.n.emptyList().iterator();
            }

            public String toString() {
                return "EMPTY";
            }
        }

        public final g create(List<? extends c> list) {
            d0.z.d.m.checkNotNullParameter(list, "annotations");
            return list.isEmpty() ? f3251b : new h(list);
        }

        public final g getEMPTY() {
            return f3251b;
        }
    }

    /* compiled from: Annotations.kt */
    public static final class b {
        public static c findAnnotation(g gVar, d0.e0.p.d.m0.g.b bVar) {
            c next;
            d0.z.d.m.checkNotNullParameter(gVar, "this");
            d0.z.d.m.checkNotNullParameter(bVar, "fqName");
            Iterator<c> it = gVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (d0.z.d.m.areEqual(next.getFqName(), bVar)) {
                    break;
                }
            }
            return next;
        }

        public static boolean hasAnnotation(g gVar, d0.e0.p.d.m0.g.b bVar) {
            d0.z.d.m.checkNotNullParameter(gVar, "this");
            d0.z.d.m.checkNotNullParameter(bVar, "fqName");
            return gVar.findAnnotation(bVar) != null;
        }
    }

    c findAnnotation(d0.e0.p.d.m0.g.b bVar);

    boolean hasAnnotation(d0.e0.p.d.m0.g.b bVar);

    boolean isEmpty();
}
