package p007b.p195g.p196a.p205c.p219i0;

import java.io.Serializable;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: NameTransformer.java */
/* renamed from: b.g.a.c.i0.n, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class NameTransformer4 {

    /* renamed from: j */
    public static final NameTransformer4 f4961j = new b();

    /* compiled from: NameTransformer.java */
    /* renamed from: b.g.a.c.i0.n$a */
    public static class a extends NameTransformer4 implements Serializable {
        private static final long serialVersionUID = 1;
        public final NameTransformer4 _t1;
        public final NameTransformer4 _t2;

        public a(NameTransformer4 nameTransformer4, NameTransformer4 nameTransformer42) {
            this._t1 = nameTransformer4;
            this._t2 = nameTransformer42;
        }

        @Override // p007b.p195g.p196a.p205c.p219i0.NameTransformer4
        /* renamed from: a */
        public String mo2202a(String str) {
            return this._t1.mo2202a(this._t2.mo2202a(str));
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("[ChainedTransformer(");
            sbM833U.append(this._t1);
            sbM833U.append(", ");
            sbM833U.append(this._t2);
            sbM833U.append(")]");
            return sbM833U.toString();
        }
    }

    /* compiled from: NameTransformer.java */
    /* renamed from: b.g.a.c.i0.n$b */
    public static final class b extends NameTransformer4 implements Serializable {
        private static final long serialVersionUID = 1;

        @Override // p007b.p195g.p196a.p205c.p219i0.NameTransformer4
        /* renamed from: a */
        public String mo2202a(String str) {
            return str;
        }
    }

    /* renamed from: a */
    public abstract String mo2202a(String str);
}
