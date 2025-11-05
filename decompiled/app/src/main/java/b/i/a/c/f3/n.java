package b.i.a.c.f3;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;

/* compiled from: FlagSet.java */
/* loaded from: classes3.dex */
public final class n {
    public final SparseBooleanArray a;

    /* compiled from: FlagSet.java */
    public static final class b {
        public final SparseBooleanArray a = new SparseBooleanArray();

        /* renamed from: b, reason: collision with root package name */
        public boolean f972b;

        public b a(int i) {
            b.c.a.a0.d.D(!this.f972b);
            this.a.append(i, true);
            return this;
        }

        public n b() {
            b.c.a.a0.d.D(!this.f972b);
            this.f972b = true;
            return new n(this.a, null);
        }
    }

    public n(SparseBooleanArray sparseBooleanArray, a aVar) {
        this.a = sparseBooleanArray;
    }

    public boolean a(int i) {
        return this.a.get(i);
    }

    public int b(int i) {
        b.c.a.a0.d.t(i, 0, c());
        return this.a.keyAt(i);
    }

    public int c() {
        return this.a.size();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (e0.a >= 24) {
            return this.a.equals(nVar.a);
        }
        if (c() != nVar.c()) {
            return false;
        }
        for (int i = 0; i < c(); i++) {
            if (b(i) != nVar.b(i)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (e0.a >= 24) {
            return this.a.hashCode();
        }
        int iC = c();
        for (int i = 0; i < c(); i++) {
            iC = (iC * 31) + b(i);
        }
        return iC;
    }
}
