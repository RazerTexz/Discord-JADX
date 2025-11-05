package b.i.a.c.x2.h0;

import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.x;
import b.i.a.c.j1;
import b.i.a.c.t2.a0;
import b.i.a.c.x2.h0.g;
import b.i.a.c.x2.j;
import b.i.a.c.x2.p;
import b.i.a.c.x2.q;
import b.i.a.c.x2.s;
import b.i.a.c.x2.w;
import b.i.a.c.z2.k.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* compiled from: Mp3Extractor.java */
/* loaded from: classes3.dex */
public final class f implements b.i.a.c.x2.h {
    public static final b.a a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1205b;
    public final long c;
    public final x d;
    public final a0.a e;
    public final p f;
    public final q g;
    public final w h;
    public j i;
    public w j;
    public w k;
    public int l;

    @Nullable
    public Metadata m;
    public long n;
    public long o;
    public long p;
    public int q;
    public g r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1206s;
    public boolean t;
    public long u;

    static {
        a aVar = a.a;
        a = b.a;
    }

    public f() {
        this(0);
    }

    public static long d(@Nullable Metadata metadata) {
        if (metadata == null) {
            return -9223372036854775807L;
        }
        int length = metadata.j.length;
        for (int i = 0; i < length; i++) {
            Metadata.Entry entry = metadata.j[i];
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                if (textInformationFrame.j.equals("TLEN")) {
                    return e0.B(Long.parseLong(textInformationFrame.l));
                }
            }
        }
        return -9223372036854775807L;
    }

    public static boolean h(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    public final long a(long j) {
        return ((j * 1000000) / this.e.d) + this.n;
    }

    @Override // b.i.a.c.x2.h
    public boolean b(b.i.a.c.x2.i iVar) throws IOException {
        return j(iVar, true);
    }

    public final g c(b.i.a.c.x2.i iVar, boolean z2) throws IOException {
        iVar.o(this.d.a, 0, 4);
        this.d.E(0);
        this.e.a(this.d.f());
        return new c(iVar.b(), iVar.getPosition(), this.e, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    @Override // b.i.a.c.x2.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e(b.i.a.c.x2.i iVar, s sVar) throws IOException {
        f fVar;
        int i;
        b.i.a.c.x2.i iVar2;
        int iB;
        int i2;
        g gVarC;
        int iW;
        i iVar3;
        e eVar;
        long jD;
        long jI;
        long jA;
        int iT;
        b.c.a.a0.d.H(this.j);
        int i3 = e0.a;
        if (this.l == 0) {
            try {
                j(iVar, false);
                if (this.r != null) {
                    x xVar = new x(this.e.c);
                    iVar.o(xVar.a, 0, this.e.c);
                    a0.a aVar = this.e;
                    int i4 = 21;
                    if ((aVar.a & 1) != 0) {
                        if (aVar.e != 1) {
                            i4 = 36;
                        }
                    } else if (aVar.e == 1) {
                        i4 = 13;
                    }
                    if (xVar.c >= i4 + 4) {
                        xVar.E(i4);
                        int iF = xVar.f();
                        if (iF != 1483304551 && iF != 1231971951) {
                            if (xVar.c >= 40) {
                                xVar.E(36);
                                iF = xVar.f() == 1447187017 ? 1447187017 : 0;
                            }
                        }
                        String str = ", ";
                        if (iF == 1483304551 || iF == 1231971951) {
                            fVar = this;
                            long jB = iVar.b();
                            long position = iVar.getPosition();
                            a0.a aVar2 = fVar.e;
                            int i5 = aVar2.g;
                            int i6 = aVar2.d;
                            int iF2 = xVar.f();
                            if ((iF2 & 1) != 1 || (iW = xVar.w()) == 0) {
                                i2 = i4;
                                gVarC = null;
                            } else {
                                i2 = i4;
                                long jF = e0.F(iW, i5 * 1000000, i6);
                                if ((iF2 & 6) != 6) {
                                    iVar3 = new i(position, aVar2.c, jF, -1L, null);
                                } else {
                                    long jU = xVar.u();
                                    long[] jArr = new long[100];
                                    for (int i7 = 0; i7 < 100; i7++) {
                                        jArr[i7] = xVar.t();
                                    }
                                    if (jB != -1) {
                                        long j = position + jU;
                                        if (jB != j) {
                                            StringBuilder sbR = b.d.b.a.a.R(67, "XING data size mismatch: ", jB, ", ");
                                            sbR.append(j);
                                            Log.w("XingSeeker", sbR.toString());
                                        }
                                    }
                                    iVar3 = new i(position, aVar2.c, jF, jU, jArr);
                                }
                                gVarC = iVar3;
                            }
                            if (gVarC != null) {
                                p pVar = fVar.f;
                                if ((pVar.f1294b == -1 || pVar.c == -1) ? false : true) {
                                    iVar2 = iVar;
                                } else {
                                    iVar.k();
                                    iVar2 = iVar;
                                    iVar2.g(i2 + Opcodes.F2D);
                                    iVar2.o(fVar.d.a, 0, 3);
                                    fVar.d.E(0);
                                    p pVar2 = fVar.f;
                                    int iV = fVar.d.v();
                                    Objects.requireNonNull(pVar2);
                                    int i8 = iV >> 12;
                                    int i9 = iV & 4095;
                                    if (i8 > 0 || i9 > 0) {
                                        pVar2.f1294b = i8;
                                        pVar2.c = i9;
                                    }
                                }
                                iVar2.l(fVar.e.c);
                                if (gVarC != null && !gVarC.c() && iF == 1231971951) {
                                    gVarC = fVar.c(iVar2, false);
                                }
                            }
                        } else if (iF == 1447187017) {
                            long jB2 = iVar.b();
                            long position2 = iVar.getPosition();
                            a0.a aVar3 = this.e;
                            xVar.F(10);
                            int iF3 = xVar.f();
                            if (iF3 <= 0) {
                                gVarC = null;
                                fVar = this;
                                iVar.l(fVar.e.c);
                                iVar2 = iVar;
                            } else {
                                int i10 = aVar3.d;
                                long jF2 = e0.F(iF3, (i10 >= 32000 ? 1152 : 576) * 1000000, i10);
                                int iY = xVar.y();
                                int iY2 = xVar.y();
                                int iY3 = xVar.y();
                                xVar.F(2);
                                long j2 = aVar3.c + position2;
                                long[] jArr2 = new long[iY];
                                long[] jArr3 = new long[iY];
                                int i11 = 0;
                                long j3 = position2;
                                while (i11 < iY) {
                                    String str2 = str;
                                    long j4 = jB2;
                                    jArr2[i11] = (i11 * jF2) / iY;
                                    jArr3[i11] = Math.max(j3, j2);
                                    if (iY3 == 1) {
                                        iT = xVar.t();
                                    } else if (iY3 == 2) {
                                        iT = xVar.y();
                                    } else if (iY3 == 3) {
                                        iT = xVar.v();
                                    } else {
                                        if (iY3 != 4) {
                                            gVarC = null;
                                            break;
                                        }
                                        iT = xVar.w();
                                    }
                                    j3 += iT * iY2;
                                    i11++;
                                    str = str2;
                                    jB2 = j4;
                                }
                                String str3 = str;
                                long j5 = jB2;
                                if (j5 != -1 && j5 != j3) {
                                    StringBuilder sbR2 = b.d.b.a.a.R(67, "VBRI data size mismatch: ", j5, str3);
                                    sbR2.append(j3);
                                    Log.w("VbriSeeker", sbR2.toString());
                                }
                                gVarC = new h(jArr2, jArr3, jF2, j3);
                                fVar = this;
                                iVar.l(fVar.e.c);
                                iVar2 = iVar;
                            }
                        } else {
                            fVar = this;
                            iVar.k();
                            iVar2 = iVar;
                            gVarC = null;
                        }
                        Metadata metadata = fVar.m;
                        long position3 = iVar.getPosition();
                        if (metadata != null) {
                            int length = metadata.j.length;
                            for (int i12 = 0; i12 < length; i12++) {
                                Metadata.Entry entry = metadata.j[i12];
                                if (entry instanceof MlltFrame) {
                                    long jD2 = d(metadata);
                                    int length2 = ((MlltFrame) entry).n.length;
                                    int i13 = length2 + 1;
                                    long[] jArr4 = new long[i13];
                                    long[] jArr5 = new long[i13];
                                    jArr4[0] = position3;
                                    jArr5[0] = 0;
                                    long j6 = 0;
                                    for (int i14 = 1; i14 <= length2; i14++) {
                                        int i15 = i14 - 1;
                                        position3 += r8.l + r8.n[i15];
                                        j6 += r8.m + r8.o[i15];
                                        jArr4[i14] = position3;
                                        jArr5[i14] = j6;
                                    }
                                    eVar = new e(jArr4, jArr5, jD2);
                                    if (fVar.f1206s) {
                                        gVarC = new g.a();
                                    } else {
                                        if ((fVar.f1205b & 4) != 0) {
                                            if (eVar != null) {
                                                jD = eVar.c;
                                            } else if (gVarC != null) {
                                                jI = gVarC.i();
                                                jA = gVarC.a();
                                                gVarC = new d(jI, iVar.getPosition(), jA);
                                            } else {
                                                jD = d(fVar.m);
                                            }
                                            jI = jD;
                                            jA = -1;
                                            gVarC = new d(jI, iVar.getPosition(), jA);
                                        } else if (eVar != null) {
                                            gVarC = eVar;
                                        } else if (gVarC == null) {
                                            gVarC = null;
                                        }
                                        if (gVarC == null || (!gVarC.c() && (fVar.f1205b & 1) != 0)) {
                                            gVarC = fVar.c(iVar2, (fVar.f1205b & 2) != 0);
                                        }
                                    }
                                    fVar.r = gVarC;
                                    fVar.i.a(gVarC);
                                    w wVar = fVar.k;
                                    j1.b bVar = new j1.b();
                                    a0.a aVar4 = fVar.e;
                                    bVar.k = aVar4.f1116b;
                                    bVar.l = 4096;
                                    bVar.f1023x = aVar4.e;
                                    bVar.f1024y = aVar4.d;
                                    p pVar3 = fVar.f;
                                    bVar.A = pVar3.f1294b;
                                    bVar.B = pVar3.c;
                                    bVar.i = (fVar.f1205b & 8) != 0 ? null : fVar.m;
                                    wVar.e(bVar.a());
                                    fVar.p = iVar.getPosition();
                                }
                            }
                            eVar = null;
                            if (fVar.f1206s) {
                            }
                            fVar.r = gVarC;
                            fVar.i.a(gVarC);
                            w wVar2 = fVar.k;
                            j1.b bVar2 = new j1.b();
                            a0.a aVar42 = fVar.e;
                            bVar2.k = aVar42.f1116b;
                            bVar2.l = 4096;
                            bVar2.f1023x = aVar42.e;
                            bVar2.f1024y = aVar42.d;
                            p pVar32 = fVar.f;
                            bVar2.A = pVar32.f1294b;
                            bVar2.B = pVar32.c;
                            bVar2.i = (fVar.f1205b & 8) != 0 ? null : fVar.m;
                            wVar2.e(bVar2.a());
                            fVar.p = iVar.getPosition();
                        } else {
                            eVar = null;
                            if (fVar.f1206s) {
                            }
                            fVar.r = gVarC;
                            fVar.i.a(gVarC);
                            w wVar22 = fVar.k;
                            j1.b bVar22 = new j1.b();
                            a0.a aVar422 = fVar.e;
                            bVar22.k = aVar422.f1116b;
                            bVar22.l = 4096;
                            bVar22.f1023x = aVar422.e;
                            bVar22.f1024y = aVar422.d;
                            p pVar322 = fVar.f;
                            bVar22.A = pVar322.f1294b;
                            bVar22.B = pVar322.c;
                            bVar22.i = (fVar.f1205b & 8) != 0 ? null : fVar.m;
                            wVar22.e(bVar22.a());
                            fVar.p = iVar.getPosition();
                        }
                    }
                } else {
                    iVar2 = iVar;
                    fVar = this;
                    if (fVar.p != 0) {
                        long position4 = iVar.getPosition();
                        long j7 = fVar.p;
                        if (position4 < j7) {
                            iVar2.l((int) (j7 - position4));
                        }
                    }
                }
            } catch (EOFException unused) {
                fVar = this;
            }
            if (fVar.q != 0) {
                iVar.k();
                if (!i(iVar)) {
                    fVar.d.E(0);
                    int iF4 = fVar.d.f();
                    if (!h(iF4, fVar.l) || a0.a(iF4) == -1) {
                        iVar2.l(1);
                        fVar.l = 0;
                        i = 0;
                    } else {
                        fVar.e.a(iF4);
                        if (fVar.n == -9223372036854775807L) {
                            fVar.n = fVar.r.d(iVar.getPosition());
                            if (fVar.c != -9223372036854775807L) {
                                fVar.n = (fVar.c - fVar.r.d(0L)) + fVar.n;
                            }
                        }
                        fVar.q = fVar.e.c;
                        g gVar = fVar.r;
                        if (gVar instanceof d) {
                            d dVar = (d) gVar;
                            long jA2 = fVar.a(fVar.o + r0.g);
                            long position5 = iVar.getPosition() + fVar.e.c;
                            if (!dVar.b(jA2)) {
                                dVar.f1203b.a(jA2);
                                dVar.c.a(position5);
                            }
                            if (fVar.t && dVar.b(fVar.u)) {
                                fVar.t = false;
                                fVar.k = fVar.j;
                            }
                        }
                        iB = fVar.k.b(iVar2, fVar.q, true);
                        if (iB != -1) {
                            int i16 = fVar.q - iB;
                            fVar.q = i16;
                            if (i16 <= 0) {
                                fVar.k.d(fVar.a(fVar.o), 1, fVar.e.c, 0, null);
                                fVar.o += fVar.e.g;
                                fVar.q = 0;
                            }
                            i = 0;
                        }
                    }
                }
                i = -1;
            } else {
                iB = fVar.k.b(iVar2, fVar.q, true);
                if (iB != -1) {
                }
                i = -1;
            }
        } else {
            if (this.r != null) {
            }
            if (fVar.q != 0) {
            }
        }
        if (i == -1 && (fVar.r instanceof d)) {
            long jA3 = fVar.a(fVar.o);
            if (fVar.r.i() != jA3) {
                g gVar2 = fVar.r;
                ((d) gVar2).d = jA3;
                fVar.i.a(gVar2);
            }
        }
        return i;
    }

    @Override // b.i.a.c.x2.h
    public void f(j jVar) {
        this.i = jVar;
        w wVarP = jVar.p(0, 1);
        this.j = wVarP;
        this.k = wVarP;
        this.i.j();
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        this.l = 0;
        this.n = -9223372036854775807L;
        this.o = 0L;
        this.q = 0;
        this.u = j2;
        g gVar = this.r;
        if (!(gVar instanceof d) || ((d) gVar).b(j2)) {
            return;
        }
        this.t = true;
        this.k = this.h;
    }

    public final boolean i(b.i.a.c.x2.i iVar) throws IOException {
        g gVar = this.r;
        if (gVar != null) {
            long jA = gVar.a();
            if (jA != -1 && iVar.f() > jA - 4) {
                return true;
            }
        }
        try {
            return !iVar.e(this.d.a, 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    public final boolean j(b.i.a.c.x2.i iVar, boolean z2) throws IOException {
        int i;
        int iF;
        int iA;
        int i2 = z2 ? 32768 : 131072;
        iVar.k();
        if (iVar.getPosition() == 0) {
            Metadata metadataA = this.g.a(iVar, (this.f1205b & 8) == 0 ? null : a);
            this.m = metadataA;
            if (metadataA != null) {
                this.f.b(metadataA);
            }
            iF = (int) iVar.f();
            if (!z2) {
                iVar.l(iF);
            }
            i = 0;
        } else {
            i = 0;
            iF = 0;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (!i(iVar)) {
                this.d.E(0);
                int iF2 = this.d.f();
                if ((i == 0 || h(iF2, i)) && (iA = a0.a(iF2)) != -1) {
                    i3++;
                    if (i3 != 1) {
                        if (i3 == 4) {
                            break;
                        }
                    } else {
                        this.e.a(iF2);
                        i = iF2;
                    }
                    iVar.g(iA - 4);
                } else {
                    int i5 = i4 + 1;
                    if (i4 == i2) {
                        if (z2) {
                            return false;
                        }
                        throw ParserException.a("Searched too many bytes.", null);
                    }
                    if (z2) {
                        iVar.k();
                        iVar.g(iF + i5);
                    } else {
                        iVar.l(1);
                    }
                    i4 = i5;
                    i = 0;
                    i3 = 0;
                }
            } else if (i3 <= 0) {
                throw new EOFException();
            }
        }
        if (z2) {
            iVar.l(iF + i4);
        } else {
            iVar.k();
        }
        this.l = i;
        return true;
    }

    @Override // b.i.a.c.x2.h
    public void release() {
    }

    public f(int i) {
        this.f1205b = (i & 2) != 0 ? i | 1 : i;
        this.c = -9223372036854775807L;
        this.d = new x(10);
        this.e = new a0.a();
        this.f = new p();
        this.n = -9223372036854775807L;
        this.g = new q();
        b.i.a.c.x2.g gVar = new b.i.a.c.x2.g();
        this.h = gVar;
        this.k = gVar;
    }
}
