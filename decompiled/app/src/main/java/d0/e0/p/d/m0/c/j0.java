package d0.e0.p.d.m0.c;

import java.util.List;

/* compiled from: PackageViewDescriptor.kt */
/* loaded from: classes3.dex */
public interface j0 extends m {

    /* compiled from: PackageViewDescriptor.kt */
    public static final class a {
        public static boolean isEmpty(j0 j0Var) {
            d0.z.d.m.checkNotNullParameter(j0Var, "this");
            return j0Var.getFragments().isEmpty();
        }
    }

    d0.e0.p.d.m0.g.b getFqName();

    List<e0> getFragments();

    d0.e0.p.d.m0.k.a0.i getMemberScope();

    c0 getModule();

    boolean isEmpty();
}
