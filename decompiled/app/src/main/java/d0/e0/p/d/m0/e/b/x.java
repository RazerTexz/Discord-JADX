package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.n.c0;
import java.util.Collection;

/* compiled from: descriptorBasedTypeSignatureMapping.kt */
/* loaded from: classes3.dex */
public interface x<T> {

    /* compiled from: descriptorBasedTypeSignatureMapping.kt */
    public static final class a {
        public static <T> String getPredefinedFullInternalNameForClass(x<? extends T> xVar, d0.e0.p.d.m0.c.e eVar) {
            d0.z.d.m.checkNotNullParameter(xVar, "this");
            d0.z.d.m.checkNotNullParameter(eVar, "classDescriptor");
            return null;
        }

        public static <T> c0 preprocessType(x<? extends T> xVar, c0 c0Var) {
            d0.z.d.m.checkNotNullParameter(xVar, "this");
            d0.z.d.m.checkNotNullParameter(c0Var, "kotlinType");
            return null;
        }

        public static <T> boolean releaseCoroutines(x<? extends T> xVar) {
            d0.z.d.m.checkNotNullParameter(xVar, "this");
            return true;
        }
    }

    c0 commonSupertype(Collection<c0> collection);

    String getPredefinedFullInternalNameForClass(d0.e0.p.d.m0.c.e eVar);

    String getPredefinedInternalNameForClass(d0.e0.p.d.m0.c.e eVar);

    T getPredefinedTypeForClass(d0.e0.p.d.m0.c.e eVar);

    c0 preprocessType(c0 c0Var);

    void processErrorType(c0 c0Var, d0.e0.p.d.m0.c.e eVar);

    boolean releaseCoroutines();
}
