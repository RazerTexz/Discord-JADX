package b.i.a.c.c3;

import androidx.annotation.Nullable;
import b.i.a.c.a3.n0;
import b.i.a.c.w0;
import b.i.b.b.i0;
import b.i.b.b.n;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: TrackSelectionOverrides.java */
/* loaded from: classes3.dex */
public final class o implements w0 {
    public static final o j = new o(i0.m);
    public static final w0.a<o> k = d.a;
    public final b.i.b.b.q<n0, a> l;

    public o(Map<n0, a> map) {
        this.l = b.i.b.b.q.a(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        return this.l.equals(((o) obj).l);
    }

    public int hashCode() {
        return this.l.hashCode();
    }

    /* compiled from: TrackSelectionOverrides.java */
    public static final class a implements w0 {
        public static final /* synthetic */ int j = 0;
        public final n0 k;
        public final b.i.b.b.p<Integer> l;

        public a(n0 n0Var) {
            this.k = n0Var;
            b.i.a.f.e.o.f.A(4, "initialCapacity");
            Object[] objArrCopyOf = new Object[4];
            int i = 0;
            int i2 = 0;
            while (i < n0Var.k) {
                Integer numValueOf = Integer.valueOf(i);
                Objects.requireNonNull(numValueOf);
                int i3 = i2 + 1;
                if (objArrCopyOf.length < i3) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, n.b.a(objArrCopyOf.length, i3));
                }
                objArrCopyOf[i2] = numValueOf;
                i++;
                i2 = i3;
            }
            this.l = b.i.b.b.p.l(objArrCopyOf, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.k.equals(aVar.k) && this.l.equals(aVar.l);
        }

        public int hashCode() {
            return (this.l.hashCode() * 31) + this.k.hashCode();
        }

        public a(n0 n0Var, List<Integer> list) {
            if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= n0Var.k)) {
                throw new IndexOutOfBoundsException();
            }
            this.k = n0Var;
            this.l = b.i.b.b.p.n(list);
        }
    }
}
