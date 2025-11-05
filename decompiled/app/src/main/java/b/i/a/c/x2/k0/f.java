package b.i.a.c.x2.k0;

import b.i.a.c.x2.k0.i0;
import b.i.a.c.x2.t;
import java.io.IOException;

/* compiled from: Ac3Extractor.java */
/* loaded from: classes3.dex */
public final class f implements b.i.a.c.x2.h {
    public final g a = new g(null);

    /* renamed from: b, reason: collision with root package name */
    public final b.i.a.c.f3.x f1247b = new b.i.a.c.f3.x(2786);
    public boolean c;

    static {
        a aVar = a.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003d, code lost:
    
        if ((r5 - r3) < 8192) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0034, code lost:
    
        r14.k();
        r5 = r5 + 1;
     */
    @Override // b.i.a.c.x2.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(b.i.a.c.x2.i iVar) throws IOException {
        int iA;
        b.i.a.c.f3.x xVar = new b.i.a.c.f3.x(10);
        int i = 0;
        while (true) {
            iVar.o(xVar.a, 0, 10);
            xVar.E(0);
            if (xVar.v() != 4801587) {
                break;
            }
            xVar.F(3);
            int iS = xVar.s();
            i += iS + 10;
            iVar.g(iS);
        }
        iVar.k();
        iVar.g(i);
        int i2 = i;
        while (true) {
            int i3 = 0;
            while (true) {
                iVar.o(xVar.a, 0, 6);
                xVar.E(0);
                if (xVar.y() != 2935) {
                    break;
                }
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] bArr = xVar.a;
                if (bArr.length < 6) {
                    iA = -1;
                } else {
                    iA = ((bArr[5] & 248) >> 3) > 10 ? ((((bArr[2] & 7) << 8) | (bArr[3] & 255)) + 1) * 2 : b.i.a.c.t2.m.a((bArr[4] & 192) >> 6, bArr[4] & 63);
                }
                if (iA == -1) {
                    return false;
                }
                iVar.g(iA - 6);
            }
            iVar.g(i2);
        }
    }

    @Override // b.i.a.c.x2.h
    public int e(b.i.a.c.x2.i iVar, b.i.a.c.x2.s sVar) throws IOException {
        int i = iVar.read(this.f1247b.a, 0, 2786);
        if (i == -1) {
            return -1;
        }
        this.f1247b.E(0);
        this.f1247b.D(i);
        if (!this.c) {
            this.a.f(0L, 4);
            this.c = true;
        }
        this.a.b(this.f1247b);
        return 0;
    }

    @Override // b.i.a.c.x2.h
    public void f(b.i.a.c.x2.j jVar) {
        this.a.e(jVar, new i0.d(Integer.MIN_VALUE, 0, 1));
        jVar.j();
        jVar.a(new t.b(-9223372036854775807L, 0L));
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        this.c = false;
        this.a.c();
    }

    @Override // b.i.a.c.x2.h
    public void release() {
    }
}
