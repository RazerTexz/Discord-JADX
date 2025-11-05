package b.g.a.c.i0;

import java.io.Serializable;

/* compiled from: NameTransformer.java */
/* loaded from: classes3.dex */
public abstract class n {
    public static final n j = new b();

    /* compiled from: NameTransformer.java */
    public static class a extends n implements Serializable {
        private static final long serialVersionUID = 1;
        public final n _t1;
        public final n _t2;

        public a(n nVar, n nVar2) {
            this._t1 = nVar;
            this._t2 = nVar2;
        }

        @Override // b.g.a.c.i0.n
        public String a(String str) {
            return this._t1.a(this._t2.a(str));
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("[ChainedTransformer(");
            sbU.append(this._t1);
            sbU.append(", ");
            sbU.append(this._t2);
            sbU.append(")]");
            return sbU.toString();
        }
    }

    /* compiled from: NameTransformer.java */
    public static final class b extends n implements Serializable {
        private static final long serialVersionUID = 1;

        @Override // b.g.a.c.i0.n
        public String a(String str) {
            return str;
        }
    }

    public abstract String a(String str);
}
