package b.i.a.c;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/* compiled from: TracksInfo.java */
/* loaded from: classes3.dex */
public final class p2 implements w0 {
    public static final p2 j;
    public final b.i.b.b.p<a> k;

    /* compiled from: TracksInfo.java */
    public static final class a implements w0 {
        public final b.i.a.c.a3.n0 j;
        public final int[] k;
        public final int l;
        public final boolean[] m;

        public a(b.i.a.c.a3.n0 n0Var, int[] iArr, int i, boolean[] zArr) {
            int i2 = n0Var.k;
            b.c.a.a0.d.j(i2 == iArr.length && i2 == zArr.length);
            this.j = n0Var;
            this.k = (int[]) iArr.clone();
            this.l = i;
            this.m = (boolean[]) zArr.clone();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.l == aVar.l && this.j.equals(aVar.j) && Arrays.equals(this.k, aVar.k) && Arrays.equals(this.m, aVar.m);
        }

        public int hashCode() {
            return Arrays.hashCode(this.m) + ((((Arrays.hashCode(this.k) + (this.j.hashCode() * 31)) * 31) + this.l) * 31);
        }
    }

    static {
        b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
        j = new p2(b.i.b.b.h0.l);
    }

    public p2(List<a> list) {
        this.k = b.i.b.b.p.n(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p2.class != obj.getClass()) {
            return false;
        }
        return this.k.equals(((p2) obj).k);
    }

    public int hashCode() {
        return this.k.hashCode();
    }
}
