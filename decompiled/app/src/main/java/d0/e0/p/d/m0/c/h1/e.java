package d0.e0.p.d.m0.c.h1;

import d0.e0.p.d.m0.n.j0;
import d0.z.d.m;

/* compiled from: PlatformDependentTypeTransformer.kt */
/* loaded from: classes3.dex */
public interface e {

    /* compiled from: PlatformDependentTypeTransformer.kt */
    public static final class a implements e {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.c.h1.e
        public j0 transformPlatformType(d0.e0.p.d.m0.g.a aVar, j0 j0Var) {
            m.checkNotNullParameter(aVar, "classId");
            m.checkNotNullParameter(j0Var, "computedType");
            return j0Var;
        }
    }

    j0 transformPlatformType(d0.e0.p.d.m0.g.a aVar, j0 j0Var);
}
