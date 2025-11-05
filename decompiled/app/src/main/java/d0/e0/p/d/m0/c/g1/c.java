package d0.e0.p.d.m0.c.g1;

import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.t;
import java.util.Map;

/* compiled from: AnnotationDescriptor.kt */
/* loaded from: classes3.dex */
public interface c {

    /* compiled from: AnnotationDescriptor.kt */
    public static final class a {
        public static d0.e0.p.d.m0.g.b getFqName(c cVar) {
            d0.z.d.m.checkNotNullParameter(cVar, "this");
            d0.e0.p.d.m0.c.e annotationClass = d0.e0.p.d.m0.k.x.a.getAnnotationClass(cVar);
            if (annotationClass == null) {
                return null;
            }
            if (t.isError(annotationClass)) {
                annotationClass = null;
            }
            if (annotationClass == null) {
                return null;
            }
            return d0.e0.p.d.m0.k.x.a.fqNameOrNull(annotationClass);
        }
    }

    Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>> getAllValueArguments();

    d0.e0.p.d.m0.g.b getFqName();

    u0 getSource();

    c0 getType();
}
