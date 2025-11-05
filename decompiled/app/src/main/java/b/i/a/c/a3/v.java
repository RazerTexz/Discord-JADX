package b.i.a.c.a3;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.i.a.c.a3.a0;
import b.i.a.c.a3.o;
import b.i.a.c.o1;
import b.i.a.c.o2;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: MaskingMediaSource.java */
/* loaded from: classes3.dex */
public final class v extends o<Void> {
    public final a0 j;
    public final boolean k;
    public final o2.c l;
    public final o2.b m;
    public a n;

    @Nullable
    public u o;
    public boolean p;
    public boolean q;
    public boolean r;

    /* compiled from: MaskingMediaSource.java */
    public static final class a extends r {
        public static final Object l = new Object();

        @Nullable
        public final Object m;

        @Nullable
        public final Object n;

        public a(o2 o2Var, @Nullable Object obj, @Nullable Object obj2) {
            super(o2Var);
            this.m = obj;
            this.n = obj2;
        }

        @Override // b.i.a.c.a3.r, b.i.a.c.o2
        public int b(Object obj) {
            Object obj2;
            o2 o2Var = this.k;
            if (l.equals(obj) && (obj2 = this.n) != null) {
                obj = obj2;
            }
            return o2Var.b(obj);
        }

        @Override // b.i.a.c.o2
        public o2.b g(int i, o2.b bVar, boolean z2) {
            this.k.g(i, bVar, z2);
            if (b.i.a.c.f3.e0.a(bVar.k, this.n) && z2) {
                bVar.k = l;
            }
            return bVar;
        }

        @Override // b.i.a.c.a3.r, b.i.a.c.o2
        public Object m(int i) {
            Object objM = this.k.m(i);
            return b.i.a.c.f3.e0.a(objM, this.n) ? l : objM;
        }

        @Override // b.i.a.c.o2
        public o2.c o(int i, o2.c cVar, long j) {
            this.k.o(i, cVar, j);
            if (b.i.a.c.f3.e0.a(cVar.n, this.m)) {
                cVar.n = o2.c.j;
            }
            return cVar;
        }
    }

    /* compiled from: MaskingMediaSource.java */
    @VisibleForTesting
    public static final class b extends o2 {
        public final o1 k;

        public b(o1 o1Var) {
            this.k = o1Var;
        }

        @Override // b.i.a.c.o2
        public int b(Object obj) {
            return obj == a.l ? 0 : -1;
        }

        @Override // b.i.a.c.o2
        public o2.b g(int i, o2.b bVar, boolean z2) {
            bVar.f(z2 ? 0 : null, z2 ? a.l : null, 0, -9223372036854775807L, 0L, b.i.a.c.a3.p0.c.j, true);
            return bVar;
        }

        @Override // b.i.a.c.o2
        public int i() {
            return 1;
        }

        @Override // b.i.a.c.o2
        public Object m(int i) {
            return a.l;
        }

        @Override // b.i.a.c.o2
        public o2.c o(int i, o2.c cVar, long j) {
            cVar.e(o2.c.j, this.k, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            cVar.f1044y = true;
            return cVar;
        }

        @Override // b.i.a.c.o2
        public int p() {
            return 1;
        }
    }

    public v(a0 a0Var, boolean z2) {
        this.j = a0Var;
        this.k = z2 && a0Var.i();
        this.l = new o2.c();
        this.m = new o2.b();
        o2 o2VarK = a0Var.k();
        if (o2VarK == null) {
            this.n = new a(new b(a0Var.e()), o2.c.j, a.l);
        } else {
            this.n = new a(o2VarK, null, null);
            this.r = true;
        }
    }

    @Override // b.i.a.c.a3.a0
    public o1 e() {
        return this.j.e();
    }

    @Override // b.i.a.c.a3.a0
    public void h() {
    }

    @Override // b.i.a.c.a3.a0
    public void j(x xVar) {
        u uVar = (u) xVar;
        if (uVar.n != null) {
            a0 a0Var = uVar.m;
            Objects.requireNonNull(a0Var);
            a0Var.j(uVar.n);
        }
        if (xVar == this.o) {
            this.o = null;
        }
    }

    @Override // b.i.a.c.a3.a0
    public /* bridge */ /* synthetic */ x n(a0.a aVar, b.i.a.c.e3.o oVar, long j) {
        return u(aVar, oVar, j);
    }

    @Override // b.i.a.c.a3.l
    public void q(@Nullable b.i.a.c.e3.a0 a0Var) {
        this.i = a0Var;
        this.h = b.i.a.c.f3.e0.j();
        if (this.k) {
            return;
        }
        this.p = true;
        t(null, this.j);
    }

    @Override // b.i.a.c.a3.l
    public void s() {
        this.q = false;
        this.p = false;
        for (o.b bVar : this.g.values()) {
            bVar.a.a(bVar.f831b);
            bVar.a.c(bVar.c);
            bVar.a.g(bVar.c);
        }
        this.g.clear();
    }

    public u u(a0.a aVar, b.i.a.c.e3.o oVar, long j) {
        u uVar = new u(aVar, oVar, j);
        a0 a0Var = this.j;
        b.c.a.a0.d.D(uVar.m == null);
        uVar.m = a0Var;
        if (this.q) {
            Object obj = aVar.a;
            if (this.n.n != null && obj.equals(a.l)) {
                obj = this.n.n;
            }
            uVar.d(aVar.b(obj));
        } else {
            this.o = uVar;
            if (!this.p) {
                this.p = true;
                t(null, this.j);
            }
        }
        return uVar;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    public final void v(long j) {
        u uVar = this.o;
        int iB = this.n.b(uVar.j.a);
        if (iB == -1) {
            return;
        }
        long j2 = this.n.f(iB, this.m).m;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        uVar.p = j;
    }
}
