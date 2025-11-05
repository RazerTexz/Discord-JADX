package b.i.a.c.a3;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.c.a3.x;
import b.i.a.c.j1;
import b.i.a.c.j2;
import b.i.a.c.k1;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.Objects;

/* compiled from: ClippingMediaPeriod.java */
/* loaded from: classes3.dex */
public final class n implements x, x.a {
    public final x j;

    @Nullable
    public x.a k;
    public a[] l = new a[0];
    public long m;
    public long n;
    public long o;

    /* compiled from: ClippingMediaPeriod.java */
    public final class a implements i0 {
        public final i0 a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f830b;

        public a(i0 i0Var) {
            this.a = i0Var;
        }

        @Override // b.i.a.c.a3.i0
        public int a(k1 k1Var, DecoderInputBuffer decoderInputBuffer, int i) {
            if (n.this.d()) {
                return -3;
            }
            if (this.f830b) {
                decoderInputBuffer.j = 4;
                return -4;
            }
            int iA = this.a.a(k1Var, decoderInputBuffer, i);
            if (iA != -5) {
                n nVar = n.this;
                long j = nVar.o;
                if (j == Long.MIN_VALUE || ((iA != -4 || decoderInputBuffer.n < j) && !(iA == -3 && nVar.q() == Long.MIN_VALUE && !decoderInputBuffer.m))) {
                    return iA;
                }
                decoderInputBuffer.p();
                decoderInputBuffer.j = 4;
                this.f830b = true;
                return -4;
            }
            j1 j1Var = k1Var.f1027b;
            Objects.requireNonNull(j1Var);
            int i2 = j1Var.M;
            if (i2 != 0 || j1Var.N != 0) {
                n nVar2 = n.this;
                if (nVar2.n != 0) {
                    i2 = 0;
                }
                int i3 = nVar2.o == Long.MIN_VALUE ? j1Var.N : 0;
                j1.b bVarA = j1Var.a();
                bVarA.A = i2;
                bVarA.B = i3;
                k1Var.f1027b = bVarA.a();
            }
            return -5;
        }

        @Override // b.i.a.c.a3.i0
        public void b() throws IOException {
            this.a.b();
        }

        @Override // b.i.a.c.a3.i0
        public int c(long j) {
            if (n.this.d()) {
                return -3;
            }
            return this.a.c(j);
        }

        @Override // b.i.a.c.a3.i0
        public boolean d() {
            return !n.this.d() && this.a.d();
        }
    }

    public n(x xVar, boolean z2, long j, long j2) {
        this.j = xVar;
        this.m = z2 ? j : -9223372036854775807L;
        this.n = j;
        this.o = j2;
    }

    @Override // b.i.a.c.a3.j0.a
    public void a(j0 j0Var) {
        x.a aVar = this.k;
        Objects.requireNonNull(aVar);
        aVar.a(this);
    }

    @Override // b.i.a.c.a3.x.a
    public void b(x xVar) {
        x.a aVar = this.k;
        Objects.requireNonNull(aVar);
        aVar.b(this);
    }

    @Override // b.i.a.c.a3.x
    public long c() {
        long jC = this.j.c();
        if (jC != Long.MIN_VALUE) {
            long j = this.o;
            if (j == Long.MIN_VALUE || jC < j) {
                return jC;
            }
        }
        return Long.MIN_VALUE;
    }

    public boolean d() {
        return this.m != -9223372036854775807L;
    }

    @Override // b.i.a.c.a3.x
    public void e() throws IOException {
        this.j.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    @Override // b.i.a.c.a3.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long f(long j) {
        this.m = -9223372036854775807L;
        boolean z2 = false;
        for (a aVar : this.l) {
            if (aVar != null) {
                aVar.f830b = false;
            }
        }
        long jF = this.j.f(j);
        if (jF == j) {
            z2 = true;
        } else if (jF >= this.n) {
            long j2 = this.o;
            if (j2 == Long.MIN_VALUE || jF <= j2) {
            }
        }
        b.c.a.a0.d.D(z2);
        return jF;
    }

    @Override // b.i.a.c.a3.x
    public boolean g(long j) {
        return this.j.g(j);
    }

    @Override // b.i.a.c.a3.x
    public boolean h() {
        return this.j.h();
    }

    @Override // b.i.a.c.a3.x
    public long i(long j, j2 j2Var) {
        long j2 = this.n;
        if (j == j2) {
            return j2;
        }
        long jI = b.i.a.c.f3.e0.i(j2Var.c, 0L, j - j2);
        long j3 = j2Var.d;
        long j4 = this.o;
        long jI2 = b.i.a.c.f3.e0.i(j3, 0L, j4 == Long.MIN_VALUE ? RecyclerView.FOREVER_NS : j4 - j);
        if (jI != j2Var.c || jI2 != j2Var.d) {
            j2Var = new j2(jI, jI2);
        }
        return this.j.i(j, j2Var);
    }

    @Override // b.i.a.c.a3.x
    public long k() {
        if (d()) {
            long j = this.m;
            this.m = -9223372036854775807L;
            long jK = k();
            return jK != -9223372036854775807L ? jK : j;
        }
        long jK2 = this.j.k();
        if (jK2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z2 = true;
        b.c.a.a0.d.D(jK2 >= this.n);
        long j2 = this.o;
        if (j2 != Long.MIN_VALUE && jK2 > j2) {
            z2 = false;
        }
        b.c.a.a0.d.D(z2);
        return jK2;
    }

    @Override // b.i.a.c.a3.x
    public void l(x.a aVar, long j) {
        this.k = aVar;
        this.j.l(this, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0088  */
    @Override // b.i.a.c.a3.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long m(b.i.a.c.c3.j[] jVarArr, boolean[] zArr, i0[] i0VarArr, boolean[] zArr2, long j) {
        long j2;
        boolean z2;
        this.l = new a[i0VarArr.length];
        i0[] i0VarArr2 = new i0[i0VarArr.length];
        int i = 0;
        while (true) {
            i0 i0Var = null;
            if (i >= i0VarArr.length) {
                break;
            }
            a[] aVarArr = this.l;
            aVarArr[i] = (a) i0VarArr[i];
            if (aVarArr[i] != null) {
                i0Var = aVarArr[i].a;
            }
            i0VarArr2[i] = i0Var;
            i++;
        }
        long jM = this.j.m(jVarArr, zArr, i0VarArr2, zArr2, j);
        boolean z3 = true;
        if (d()) {
            long j3 = this.n;
            if (j != j3) {
                j2 = -9223372036854775807L;
            } else if (j3 != 0) {
                for (b.i.a.c.c3.j jVar : jVarArr) {
                    if (jVar != null) {
                        j1 j1VarH = jVar.h();
                        if (!b.i.a.c.f3.t.a(j1VarH.w, j1VarH.t)) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    j2 = jM;
                }
            } else {
                z2 = false;
                if (!z2) {
                }
            }
        }
        this.m = j2;
        if (jM != j) {
            if (jM >= this.n) {
                long j4 = this.o;
                if (j4 != Long.MIN_VALUE && jM > j4) {
                    z3 = false;
                }
            }
        }
        b.c.a.a0.d.D(z3);
        for (int i2 = 0; i2 < i0VarArr.length; i2++) {
            if (i0VarArr2[i2] == null) {
                this.l[i2] = null;
            } else {
                a[] aVarArr2 = this.l;
                if (aVarArr2[i2] == null || aVarArr2[i2].a != i0VarArr2[i2]) {
                    aVarArr2[i2] = new a(i0VarArr2[i2]);
                }
            }
            i0VarArr[i2] = this.l[i2];
        }
        return jM;
    }

    @Override // b.i.a.c.a3.x
    public o0 n() {
        return this.j.n();
    }

    @Override // b.i.a.c.a3.x
    public long q() {
        long jQ = this.j.q();
        if (jQ != Long.MIN_VALUE) {
            long j = this.o;
            if (j == Long.MIN_VALUE || jQ < j) {
                return jQ;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // b.i.a.c.a3.x
    public void r(long j, boolean z2) {
        this.j.r(j, z2);
    }

    @Override // b.i.a.c.a3.x
    public void s(long j) {
        this.j.s(j);
    }
}
