package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.n.j0;

/* compiled from: FlexibleTypeDeserializer.kt */
/* loaded from: classes3.dex */
public interface q {

    /* compiled from: FlexibleTypeDeserializer.kt */
    public static final class a implements q {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.l.b.q
        public d0.e0.p.d.m0.n.c0 create(d0.e0.p.d.m0.f.q qVar, String str, j0 j0Var, j0 j0Var2) {
            d0.z.d.m.checkNotNullParameter(qVar, "proto");
            d0.z.d.m.checkNotNullParameter(str, "flexibleId");
            d0.z.d.m.checkNotNullParameter(j0Var, "lowerBound");
            d0.z.d.m.checkNotNullParameter(j0Var2, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    d0.e0.p.d.m0.n.c0 create(d0.e0.p.d.m0.f.q qVar, String str, j0 j0Var, j0 j0Var2);
}
