package d0.e0.p.d.m0.e.a.k0;

import java.util.Iterator;

/* compiled from: javaElements.kt */
/* loaded from: classes3.dex */
public interface d0 extends d {

    /* compiled from: javaElements.kt */
    public static final class a {
        public static d0.e0.p.d.m0.e.a.k0.a findAnnotation(d0 d0Var, d0.e0.p.d.m0.g.b bVar) {
            Object obj;
            d0.z.d.m.checkNotNullParameter(d0Var, "this");
            d0.z.d.m.checkNotNullParameter(bVar, "fqName");
            Iterator<T> it = d0Var.getAnnotations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                d0.e0.p.d.m0.g.a classId = ((d0.e0.p.d.m0.e.a.k0.a) next).getClassId();
                if (d0.z.d.m.areEqual(classId != null ? classId.asSingleFqName() : null, bVar)) {
                    obj = next;
                    break;
                }
            }
            return (d0.e0.p.d.m0.e.a.k0.a) obj;
        }
    }
}
