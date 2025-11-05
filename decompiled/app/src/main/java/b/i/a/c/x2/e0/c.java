package b.i.a.c.x2.e0;

import b.i.a.c.f3.x;
import b.i.a.c.x2.h;
import b.i.a.c.x2.i;
import b.i.a.c.x2.j;
import b.i.a.c.x2.r;
import b.i.a.c.x2.s;
import b.i.a.c.x2.t;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: FlvExtractor.java */
/* loaded from: classes3.dex */
public final class c implements h {
    public j f;
    public boolean h;
    public long i;
    public int j;
    public int k;
    public int l;
    public long m;
    public boolean n;
    public b o;
    public e p;
    public final x a = new x(4);

    /* renamed from: b, reason: collision with root package name */
    public final x f1172b = new x(9);
    public final x c = new x(11);
    public final x d = new x();
    public final d e = new d();
    public int g = 1;

    static {
        a aVar = a.a;
    }

    @RequiresNonNull({"extractorOutput"})
    public final void a() {
        if (this.n) {
            return;
        }
        this.f.a(new t.b(-9223372036854775807L, 0L));
        this.n = true;
    }

    @Override // b.i.a.c.x2.h
    public boolean b(i iVar) throws IOException {
        iVar.o(this.a.a, 0, 3);
        this.a.E(0);
        if (this.a.v() != 4607062) {
            return false;
        }
        iVar.o(this.a.a, 0, 2);
        this.a.E(0);
        if ((this.a.y() & 250) != 0) {
            return false;
        }
        iVar.o(this.a.a, 0, 4);
        this.a.E(0);
        int iF = this.a.f();
        iVar.k();
        iVar.g(iF);
        iVar.o(this.a.a, 0, 4);
        this.a.E(0);
        return this.a.f() == 0;
    }

    public final x c(i iVar) throws IOException {
        int i = this.l;
        x xVar = this.d;
        byte[] bArr = xVar.a;
        if (i > bArr.length) {
            xVar.a = new byte[Math.max(bArr.length * 2, i)];
            xVar.c = 0;
            xVar.f984b = 0;
        } else {
            xVar.E(0);
        }
        this.d.D(this.l);
        iVar.readFully(this.d.a, 0, this.l);
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0009 A[SYNTHETIC] */
    @Override // b.i.a.c.x2.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e(i iVar, s sVar) throws IOException {
        boolean zA;
        boolean z2;
        b.c.a.a0.d.H(this.f);
        while (true) {
            int i = this.g;
            if (i == 1) {
                if (iVar.c(this.f1172b.a, 0, 9, true)) {
                    this.f1172b.E(0);
                    this.f1172b.F(4);
                    int iT = this.f1172b.t();
                    boolean z3 = (iT & 4) != 0;
                    z = (iT & 1) != 0;
                    if (z3 && this.o == null) {
                        this.o = new b(this.f.p(8, 1));
                    }
                    if (z && this.p == null) {
                        this.p = new e(this.f.p(9, 2));
                    }
                    this.f.j();
                    this.j = (this.f1172b.f() - 9) + 4;
                    this.g = 2;
                    z = true;
                }
                if (!z) {
                    return -1;
                }
            } else if (i == 2) {
                iVar.l(this.j);
                this.j = 0;
                this.g = 3;
            } else if (i == 3) {
                if (iVar.c(this.c.a, 0, 11, true)) {
                    this.c.E(0);
                    this.k = this.c.t();
                    this.l = this.c.v();
                    this.m = this.c.v();
                    this.m = ((this.c.t() << 24) | this.m) * 1000;
                    this.c.F(3);
                    this.g = 4;
                    z = true;
                }
                if (!z) {
                    return -1;
                }
            } else {
                if (i != 4) {
                    throw new IllegalStateException();
                }
                long j = this.h ? this.i + this.m : this.e.f1173b == -9223372036854775807L ? 0L : this.m;
                int i2 = this.k;
                if (i2 == 8 && this.o != null) {
                    a();
                    zA = this.o.a(c(iVar), j);
                } else if (i2 == 9 && this.p != null) {
                    a();
                    zA = this.p.a(c(iVar), j);
                } else if (i2 != 18 || this.n) {
                    iVar.l(this.l);
                    zA = false;
                    z2 = false;
                    if (!this.h && zA) {
                        this.h = true;
                        this.i = this.e.f1173b != -9223372036854775807L ? -this.m : 0L;
                    }
                    this.j = 4;
                    this.g = 2;
                    if (!z2) {
                        return 0;
                    }
                } else {
                    zA = this.e.a(c(iVar), j);
                    d dVar = this.e;
                    long j2 = dVar.f1173b;
                    if (j2 != -9223372036854775807L) {
                        this.f.a(new r(dVar.d, dVar.c, j2));
                        this.n = true;
                    }
                }
                z2 = true;
                if (!this.h) {
                    this.h = true;
                    this.i = this.e.f1173b != -9223372036854775807L ? -this.m : 0L;
                }
                this.j = 4;
                this.g = 2;
                if (!z2) {
                }
            }
        }
    }

    @Override // b.i.a.c.x2.h
    public void f(j jVar) {
        this.f = jVar;
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        if (j == 0) {
            this.g = 1;
            this.h = false;
        } else {
            this.g = 3;
        }
        this.j = 0;
    }

    @Override // b.i.a.c.x2.h
    public void release() {
    }
}
