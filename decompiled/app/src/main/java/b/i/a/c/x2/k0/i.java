package b.i.a.c.x2.k0;

import androidx.annotation.Nullable;
import b.i.a.c.j1;
import b.i.a.c.t2.n;
import b.i.a.c.x2.k0.i0;

/* compiled from: Ac4Reader.java */
/* loaded from: classes3.dex */
public final class i implements o {
    public final b.i.a.c.f3.w a;

    /* renamed from: b, reason: collision with root package name */
    public final b.i.a.c.f3.x f1256b;

    @Nullable
    public final String c;
    public String d;
    public b.i.a.c.x2.w e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public long j;
    public j1 k;
    public int l;
    public long m;

    public i(@Nullable String str) {
        b.i.a.c.f3.w wVar = new b.i.a.c.f3.w(new byte[16]);
        this.a = wVar;
        this.f1256b = new b.i.a.c.f3.x(wVar.a);
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.m = -9223372036854775807L;
        this.c = str;
    }

    @Override // b.i.a.c.x2.k0.o
    public void b(b.i.a.c.f3.x xVar) {
        boolean z2;
        int iT;
        b.c.a.a0.d.H(this.e);
        while (xVar.a() > 0) {
            int i = this.f;
            if (i == 0) {
                while (true) {
                    if (xVar.a() <= 0) {
                        z2 = false;
                        break;
                    } else if (this.h) {
                        iT = xVar.t();
                        this.h = iT == 172;
                        if (iT == 64 || iT == 65) {
                            break;
                        }
                    } else {
                        this.h = xVar.t() == 172;
                    }
                }
                this.i = iT == 65;
                z2 = true;
                if (z2) {
                    this.f = 1;
                    byte[] bArr = this.f1256b.a;
                    bArr[0] = -84;
                    bArr[1] = (byte) (this.i ? 65 : 64);
                    this.g = 2;
                }
            } else if (i == 1) {
                byte[] bArr2 = this.f1256b.a;
                int iMin = Math.min(xVar.a(), 16 - this.g);
                System.arraycopy(xVar.a, xVar.f984b, bArr2, this.g, iMin);
                xVar.f984b += iMin;
                int i2 = this.g + iMin;
                this.g = i2;
                if (i2 == 16) {
                    this.a.k(0);
                    n.b bVarB = b.i.a.c.t2.n.b(this.a);
                    j1 j1Var = this.k;
                    if (j1Var == null || 2 != j1Var.J || bVarB.a != j1Var.K || !"audio/ac4".equals(j1Var.w)) {
                        j1.b bVar = new j1.b();
                        bVar.a = this.d;
                        bVar.k = "audio/ac4";
                        bVar.f1023x = 2;
                        bVar.f1024y = bVarB.a;
                        bVar.c = this.c;
                        j1 j1VarA = bVar.a();
                        this.k = j1VarA;
                        this.e.e(j1VarA);
                    }
                    this.l = bVarB.f1124b;
                    this.j = (bVarB.c * 1000000) / this.k.K;
                    this.f1256b.E(0);
                    this.e.c(this.f1256b, 16);
                    this.f = 2;
                }
            } else if (i == 2) {
                int iMin2 = Math.min(xVar.a(), this.l - this.g);
                this.e.c(xVar, iMin2);
                int i3 = this.g + iMin2;
                this.g = i3;
                int i4 = this.l;
                if (i3 == i4) {
                    long j = this.m;
                    if (j != -9223372036854775807L) {
                        this.e.d(j, 1, i4, 0, null);
                        this.m += this.j;
                    }
                    this.f = 0;
                }
            }
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void c() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.m = -9223372036854775807L;
    }

    @Override // b.i.a.c.x2.k0.o
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.o
    public void e(b.i.a.c.x2.j jVar, i0.d dVar) {
        dVar.a();
        this.d = dVar.b();
        this.e = jVar.p(dVar.c(), 1);
    }

    @Override // b.i.a.c.x2.k0.o
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
    }
}
