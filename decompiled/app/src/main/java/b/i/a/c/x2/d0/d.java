package b.i.a.c.x2.d0;

import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.x;
import b.i.a.c.x2.h;
import b.i.a.c.x2.i;
import b.i.a.c.x2.j;
import b.i.a.c.x2.m;
import b.i.a.c.x2.n;
import b.i.a.c.x2.o;
import b.i.a.c.x2.s;
import b.i.a.c.x2.t;
import b.i.a.c.x2.w;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/* compiled from: FlacExtractor.java */
/* loaded from: classes3.dex */
public final class d implements h {
    public final byte[] a = new byte[42];

    /* renamed from: b, reason: collision with root package name */
    public final x f1169b = new x(new byte[32768], 0);
    public final boolean c;
    public final m.a d;
    public j e;
    public w f;
    public int g;

    @Nullable
    public Metadata h;
    public o i;
    public int j;
    public int k;
    public c l;
    public int m;
    public long n;

    static {
        a aVar = a.a;
    }

    public d(int i) {
        this.c = (i & 1) != 0;
        this.d = new m.a();
        this.g = 0;
    }

    public final void a() {
        long j = this.n * 1000000;
        o oVar = this.i;
        int i = e0.a;
        this.f.d(j / oVar.e, 1, this.m, 0, null);
    }

    @Override // b.i.a.c.x2.h
    public boolean b(i iVar) throws IOException {
        b.c.a.a0.d.y1(iVar, false);
        byte[] bArr = new byte[4];
        iVar.o(bArr, 0, 4);
        return (((((((long) bArr[0]) & 255) << 24) | ((((long) bArr[1]) & 255) << 16)) | ((((long) bArr[2]) & 255) << 8)) | (255 & ((long) bArr[3]))) == 1716281667;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v8, types: [boolean, int] */
    @Override // b.i.a.c.x2.h
    public int e(i iVar, s sVar) throws IOException {
        boolean z2;
        o oVar;
        t bVar;
        long j;
        boolean zB;
        int i = this.g;
        ?? r4 = 0;
        if (i == 0) {
            boolean z3 = !this.c;
            iVar.k();
            long jF = iVar.f();
            Metadata metadataY1 = b.c.a.a0.d.y1(iVar, z3);
            iVar.l((int) (iVar.f() - jF));
            this.h = metadataY1;
            this.g = 1;
            return 0;
        }
        if (i == 1) {
            byte[] bArr = this.a;
            iVar.o(bArr, 0, bArr.length);
            iVar.k();
            this.g = 2;
            return 0;
        }
        int i2 = 4;
        int i3 = 3;
        if (i == 2) {
            iVar.readFully(new byte[4], 0, 4);
            if ((((r10[0] & 255) << 24) | ((r10[1] & 255) << 16) | ((r10[2] & 255) << 8) | (r10[3] & 255)) != 1716281667) {
                throw ParserException.a("Failed to read FLAC stream marker.", null);
            }
            this.g = 3;
            return 0;
        }
        if (i == 3) {
            o oVarB = this.i;
            boolean z4 = false;
            while (!z4) {
                iVar.k();
                b.i.a.c.f3.w wVar = new b.i.a.c.f3.w(new byte[i2]);
                iVar.o(wVar.a, r4, i2);
                boolean zF = wVar.f();
                int iG = wVar.g(i);
                int iG2 = wVar.g(24) + i2;
                if (iG == 0) {
                    byte[] bArr2 = new byte[38];
                    iVar.readFully(bArr2, r4, 38);
                    oVarB = new o(bArr2, i2);
                } else {
                    if (oVarB == null) {
                        throw new IllegalArgumentException();
                    }
                    if (iG == i3) {
                        x xVar = new x(iG2);
                        iVar.readFully(xVar.a, r4, iG2);
                        oVarB = oVarB.b(b.c.a.a0.d.L1(xVar));
                    } else {
                        if (iG == i2) {
                            x xVar2 = new x(iG2);
                            iVar.readFully(xVar2.a, r4, iG2);
                            xVar2.F(i2);
                            z2 = zF;
                            oVar = new o(oVarB.a, oVarB.f1292b, oVarB.c, oVarB.d, oVarB.e, oVarB.g, oVarB.h, oVarB.j, oVarB.k, oVarB.f(o.a(Arrays.asList(b.c.a.a0.d.N1(xVar2, r4, r4).a), Collections.emptyList())));
                        } else {
                            z2 = zF;
                            if (iG == 6) {
                                x xVar3 = new x(iG2);
                                iVar.readFully(xVar3.a, 0, iG2);
                                xVar3.F(i2);
                                int iF = xVar3.f();
                                String strR = xVar3.r(xVar3.f(), b.i.b.a.c.a);
                                String strQ = xVar3.q(xVar3.f());
                                int iF2 = xVar3.f();
                                int iF3 = xVar3.f();
                                int iF4 = xVar3.f();
                                int iF5 = xVar3.f();
                                int iF6 = xVar3.f();
                                byte[] bArr3 = new byte[iF6];
                                System.arraycopy(xVar3.a, xVar3.f984b, bArr3, 0, iF6);
                                xVar3.f984b += iF6;
                                oVar = new o(oVarB.a, oVarB.f1292b, oVarB.c, oVarB.d, oVarB.e, oVarB.g, oVarB.h, oVarB.j, oVarB.k, oVarB.f(o.a(Collections.emptyList(), Collections.singletonList(new PictureFrame(iF, strR, strQ, iF2, iF3, iF4, iF5, bArr3)))));
                            } else {
                                iVar.l(iG2);
                                int i4 = e0.a;
                                this.i = oVarB;
                                z4 = z2;
                                r4 = 0;
                                i2 = 4;
                                i3 = 3;
                                i = 7;
                            }
                        }
                        oVarB = oVar;
                        int i42 = e0.a;
                        this.i = oVarB;
                        z4 = z2;
                        r4 = 0;
                        i2 = 4;
                        i3 = 3;
                        i = 7;
                    }
                }
                z2 = zF;
                int i422 = e0.a;
                this.i = oVarB;
                z4 = z2;
                r4 = 0;
                i2 = 4;
                i3 = 3;
                i = 7;
            }
            Objects.requireNonNull(this.i);
            this.j = Math.max(this.i.c, 6);
            w wVar2 = this.f;
            int i5 = e0.a;
            wVar2.e(this.i.e(this.a, this.h));
            this.g = 4;
            return 0;
        }
        long j2 = 0;
        if (i == 4) {
            iVar.k();
            byte[] bArr4 = new byte[2];
            iVar.o(bArr4, 0, 2);
            int i6 = (bArr4[1] & 255) | ((bArr4[0] & 255) << 8);
            if ((i6 >> 2) != 16382) {
                iVar.k();
                throw ParserException.a("First frame does not start with sync code.", null);
            }
            iVar.k();
            this.k = i6;
            j jVar = this.e;
            int i7 = e0.a;
            long position = iVar.getPosition();
            long jB = iVar.b();
            Objects.requireNonNull(this.i);
            o oVar2 = this.i;
            if (oVar2.k != null) {
                bVar = new n(oVar2, position);
            } else if (jB == -1 || oVar2.j <= 0) {
                bVar = new t.b(oVar2.d(), 0L);
            } else {
                c cVar = new c(oVar2, this.k, position, jB);
                this.l = cVar;
                bVar = cVar.a;
            }
            jVar.a(bVar);
            this.g = 5;
            return 0;
        }
        if (i != 5) {
            throw new IllegalStateException();
        }
        Objects.requireNonNull(this.f);
        Objects.requireNonNull(this.i);
        c cVar2 = this.l;
        if (cVar2 != null && cVar2.b()) {
            return this.l.a(iVar, sVar);
        }
        if (this.n == -1) {
            o oVar3 = this.i;
            iVar.k();
            iVar.g(1);
            byte[] bArr5 = new byte[1];
            iVar.o(bArr5, 0, 1);
            boolean z5 = (bArr5[0] & 1) == 1;
            iVar.g(2);
            i = z5 ? 7 : 6;
            x xVar4 = new x(i);
            xVar4.D(b.c.a.a0.d.z1(iVar, xVar4.a, 0, i));
            iVar.k();
            try {
                long jZ = xVar4.z();
                if (!z5) {
                    jZ *= oVar3.f1292b;
                }
                j2 = jZ;
            } catch (NumberFormatException unused) {
                z = false;
            }
            if (!z) {
                throw ParserException.a(null, null);
            }
            this.n = j2;
            return 0;
        }
        x xVar5 = this.f1169b;
        int i8 = xVar5.c;
        if (i8 < 32768) {
            int i9 = iVar.read(xVar5.a, i8, 32768 - i8);
            z = i9 == -1;
            if (!z) {
                this.f1169b.D(i8 + i9);
            } else if (this.f1169b.a() == 0) {
                a();
                return -1;
            }
        } else {
            z = false;
        }
        x xVar6 = this.f1169b;
        int i10 = xVar6.f984b;
        int i11 = this.m;
        int i12 = this.j;
        if (i11 < i12) {
            xVar6.F(Math.min(i12 - i11, xVar6.a()));
        }
        x xVar7 = this.f1169b;
        Objects.requireNonNull(this.i);
        int i13 = xVar7.f984b;
        while (true) {
            if (i13 <= xVar7.c - 16) {
                xVar7.E(i13);
                if (m.b(xVar7, this.i, this.k, this.d)) {
                    xVar7.E(i13);
                    j = this.d.a;
                    break;
                }
                i13++;
            } else {
                if (z) {
                    while (true) {
                        int i14 = xVar7.c;
                        if (i13 > i14 - this.j) {
                            xVar7.E(i14);
                            break;
                        }
                        xVar7.E(i13);
                        try {
                            zB = m.b(xVar7, this.i, this.k, this.d);
                        } catch (IndexOutOfBoundsException unused2) {
                            zB = false;
                        }
                        if (xVar7.f984b > xVar7.c) {
                            zB = false;
                        }
                        if (zB) {
                            xVar7.E(i13);
                            j = this.d.a;
                            break;
                        }
                        i13++;
                    }
                } else {
                    xVar7.E(i13);
                }
                j = -1;
            }
        }
        x xVar8 = this.f1169b;
        int i15 = xVar8.f984b - i10;
        xVar8.E(i10);
        this.f.c(this.f1169b, i15);
        this.m += i15;
        if (j != -1) {
            a();
            this.m = 0;
            this.n = j;
        }
        if (this.f1169b.a() >= 16) {
            return 0;
        }
        int iA = this.f1169b.a();
        x xVar9 = this.f1169b;
        byte[] bArr6 = xVar9.a;
        System.arraycopy(bArr6, xVar9.f984b, bArr6, 0, iA);
        this.f1169b.E(0);
        this.f1169b.D(iA);
        return 0;
    }

    @Override // b.i.a.c.x2.h
    public void f(j jVar) {
        this.e = jVar;
        this.f = jVar.p(0, 1);
        jVar.j();
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        if (j == 0) {
            this.g = 0;
        } else {
            c cVar = this.l;
            if (cVar != null) {
                cVar.e(j2);
            }
        }
        this.n = j2 != 0 ? -1L : 0L;
        this.m = 0;
        this.f1169b.A(0);
    }

    @Override // b.i.a.c.x2.h
    public void release() {
    }
}
