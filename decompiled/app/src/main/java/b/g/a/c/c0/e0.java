package b.g.a.c.c0;

import java.lang.reflect.Type;

/* compiled from: TypeResolutionContext.java */
/* loaded from: classes3.dex */
public interface e0 {

    /* compiled from: TypeResolutionContext.java */
    public static class a implements e0 {
        public final b.g.a.c.h0.n j;
        public final b.g.a.c.h0.m k;

        public a(b.g.a.c.h0.n nVar, b.g.a.c.h0.m mVar) {
            this.j = nVar;
            this.k = mVar;
        }

        @Override // b.g.a.c.c0.e0
        public b.g.a.c.j a(Type type) {
            return this.j.b(null, type, this.k);
        }
    }

    /* compiled from: TypeResolutionContext.java */
    public static class b implements e0 {
        public final b.g.a.c.h0.n j;

        public b(b.g.a.c.h0.n nVar) {
            this.j = nVar;
        }

        @Override // b.g.a.c.c0.e0
        public b.g.a.c.j a(Type type) {
            return this.j.b(null, type, b.g.a.c.h0.n.l);
        }
    }

    b.g.a.c.j a(Type type);
}
