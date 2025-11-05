package b.i.a.c.x2.l0;

import android.util.Log;
import android.util.Pair;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.x;
import b.i.a.c.j1;
import b.i.a.c.x2.h;
import b.i.a.c.x2.i;
import b.i.a.c.x2.j;
import b.i.a.c.x2.s;
import b.i.a.c.x2.w;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* compiled from: WavExtractor.java */
/* loaded from: classes3.dex */
public final class b implements h {
    public j a;

    /* renamed from: b, reason: collision with root package name */
    public w f1285b;
    public InterfaceC0105b d;
    public int c = 0;
    public int e = -1;
    public long f = -1;

    /* compiled from: WavExtractor.java */
    public static final class a implements InterfaceC0105b {
        public static final int[] a = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* renamed from: b, reason: collision with root package name */
        public static final int[] f1286b = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, Opcodes.D2L, 157, Opcodes.LRETURN, Opcodes.ARRAYLENGTH, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
        public final j c;
        public final w d;
        public final b.i.a.c.x2.l0.c e;
        public final int f;
        public final byte[] g;
        public final x h;
        public final int i;
        public final j1 j;
        public int k;
        public long l;
        public int m;
        public long n;

        public a(j jVar, w wVar, b.i.a.c.x2.l0.c cVar) throws ParserException {
            this.c = jVar;
            this.d = wVar;
            this.e = cVar;
            int iMax = Math.max(1, cVar.c / 10);
            this.i = iMax;
            byte[] bArr = cVar.f;
            int length = bArr.length;
            byte b2 = bArr[0];
            byte b3 = bArr[1];
            int i = ((bArr[3] & 255) << 8) | (bArr[2] & 255);
            this.f = i;
            int i2 = cVar.f1288b;
            int i3 = (((cVar.d - (i2 * 4)) * 8) / (cVar.e * i2)) + 1;
            if (i != i3) {
                throw ParserException.a(b.d.b.a.a.h(56, "Expected frames per block: ", i3, "; got: ", i), null);
            }
            int iF = e0.f(iMax, i);
            this.g = new byte[cVar.d * iF];
            this.h = new x(i * 2 * i2 * iF);
            int i4 = cVar.c;
            int i5 = ((cVar.d * i4) * 8) / i;
            j1.b bVar = new j1.b();
            bVar.k = "audio/raw";
            bVar.f = i5;
            bVar.g = i5;
            bVar.l = iMax * 2 * i2;
            bVar.f1023x = cVar.f1288b;
            bVar.f1024y = i4;
            bVar.f1025z = 2;
            this.j = bVar.a();
        }

        @Override // b.i.a.c.x2.l0.b.InterfaceC0105b
        public void a(long j) {
            this.k = 0;
            this.l = j;
            this.m = 0;
            this.n = 0L;
        }

        @Override // b.i.a.c.x2.l0.b.InterfaceC0105b
        public void b(int i, long j) {
            this.c.a(new e(this.e, this.f, i, j));
            this.d.e(this.j);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:7:0x0029
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
            */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003f -> B:12:0x0041). Please report as a decompilation issue!!! */
        @Override // b.i.a.c.x2.l0.b.InterfaceC0105b
        public boolean c(b.i.a.c.x2.i r19, long r20) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 364
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: b.i.a.c.x2.l0.b.a.c(b.i.a.c.x2.i, long):boolean");
        }

        public final int d(int i) {
            return i / (this.e.f1288b * 2);
        }

        public final void e(int i) {
            long jF = this.l + e0.F(this.n, 1000000L, this.e.c);
            int i2 = i * 2 * this.e.f1288b;
            this.d.d(jF, 1, i2, this.m - i2, null);
            this.n += i;
            this.m -= i2;
        }
    }

    /* compiled from: WavExtractor.java */
    /* renamed from: b.i.a.c.x2.l0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0105b {
        void a(long j);

        void b(int i, long j) throws ParserException;

        boolean c(i iVar, long j) throws IOException;
    }

    /* compiled from: WavExtractor.java */
    public static final class c implements InterfaceC0105b {
        public final j a;

        /* renamed from: b, reason: collision with root package name */
        public final w f1287b;
        public final b.i.a.c.x2.l0.c c;
        public final j1 d;
        public final int e;
        public long f;
        public int g;
        public long h;

        public c(j jVar, w wVar, b.i.a.c.x2.l0.c cVar, String str, int i) throws ParserException {
            this.a = jVar;
            this.f1287b = wVar;
            this.c = cVar;
            int i2 = (cVar.f1288b * cVar.e) / 8;
            int i3 = cVar.d;
            if (i3 != i2) {
                throw ParserException.a(b.d.b.a.a.h(50, "Expected block size: ", i2, "; got: ", i3), null);
            }
            int i4 = cVar.c * i2;
            int i5 = i4 * 8;
            int iMax = Math.max(i2, i4 / 10);
            this.e = iMax;
            j1.b bVar = new j1.b();
            bVar.k = str;
            bVar.f = i5;
            bVar.g = i5;
            bVar.l = iMax;
            bVar.f1023x = cVar.f1288b;
            bVar.f1024y = cVar.c;
            bVar.f1025z = i;
            this.d = bVar.a();
        }

        @Override // b.i.a.c.x2.l0.b.InterfaceC0105b
        public void a(long j) {
            this.f = j;
            this.g = 0;
            this.h = 0L;
        }

        @Override // b.i.a.c.x2.l0.b.InterfaceC0105b
        public void b(int i, long j) {
            this.a.a(new e(this.c, 1, i, j));
            this.f1287b.e(this.d);
        }

        @Override // b.i.a.c.x2.l0.b.InterfaceC0105b
        public boolean c(i iVar, long j) throws IOException {
            int i;
            int i2;
            long j2 = j;
            while (j2 > 0 && (i = this.g) < (i2 = this.e)) {
                int iB = this.f1287b.b(iVar, (int) Math.min(i2 - i, j2), true);
                if (iB == -1) {
                    j2 = 0;
                } else {
                    this.g += iB;
                    j2 -= iB;
                }
            }
            int i3 = this.c.d;
            int i4 = this.g / i3;
            if (i4 > 0) {
                long jF = this.f + e0.F(this.h, 1000000L, r1.c);
                int i5 = i4 * i3;
                int i6 = this.g - i5;
                this.f1287b.d(jF, 1, i5, i6, null);
                this.h += i4;
                this.g = i6;
            }
            return j2 <= 0;
        }
    }

    static {
        b.i.a.c.x2.l0.a aVar = b.i.a.c.x2.l0.a.a;
    }

    @Override // b.i.a.c.x2.h
    public boolean b(i iVar) throws IOException {
        return b.c.a.a0.d.r(iVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d8  */
    @Override // b.i.a.c.x2.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e(i iVar, s sVar) throws IOException {
        byte[] bArr;
        int iR;
        int i;
        b.c.a.a0.d.H(this.f1285b);
        int i2 = e0.a;
        int i3 = this.c;
        if (i3 == 0) {
            b.c.a.a0.d.D(iVar.getPosition() == 0);
            int i4 = this.e;
            if (i4 != -1) {
                iVar.l(i4);
                this.c = 3;
            } else {
                if (!b.c.a.a0.d.r(iVar)) {
                    throw ParserException.a("Unsupported or unrecognized wav file type.", null);
                }
                iVar.l((int) (iVar.f() - iVar.getPosition()));
                this.c = 1;
            }
            return 0;
        }
        if (i3 == 1) {
            x xVar = new x(16);
            d dVarA = d.a(iVar, xVar);
            while (dVarA.a != 1718449184) {
                iVar.l(((int) dVarA.f1289b) + 8);
                dVarA = d.a(iVar, xVar);
            }
            b.c.a.a0.d.D(dVarA.f1289b >= 16);
            iVar.o(xVar.a, 0, 16);
            xVar.E(0);
            int iL = xVar.l();
            int iL2 = xVar.l();
            int iK = xVar.k();
            int iK2 = xVar.k();
            int iL3 = xVar.l();
            int iL4 = xVar.l();
            int i5 = ((int) dVarA.f1289b) - 16;
            if (i5 > 0) {
                bArr = new byte[i5];
                iVar.o(bArr, 0, i5);
            } else {
                bArr = e0.f;
            }
            iVar.l((int) (iVar.f() - iVar.getPosition()));
            b.i.a.c.x2.l0.c cVar = new b.i.a.c.x2.l0.c(iL, iL2, iK, iK2, iL3, iL4, bArr);
            if (iL == 17) {
                this.d = new a(this.a, this.f1285b, cVar);
            } else if (iL == 6) {
                this.d = new c(this.a, this.f1285b, cVar, "audio/g711-alaw", -1);
            } else if (iL == 7) {
                this.d = new c(this.a, this.f1285b, cVar, "audio/g711-mlaw", -1);
            } else if (iL == 1) {
                iR = e0.r(iL4);
                i = iR;
                if (i != 0) {
                    StringBuilder sb = new StringBuilder(40);
                    sb.append("Unsupported WAV format type: ");
                    sb.append(iL);
                    throw ParserException.b(sb.toString());
                }
                this.d = new c(this.a, this.f1285b, cVar, "audio/raw", i);
            } else if (iL != 3) {
                if (iL != 65534) {
                    i = 0;
                    if (i != 0) {
                    }
                }
                iR = e0.r(iL4);
                i = iR;
                if (i != 0) {
                }
            } else {
                iR = iL4 == 32 ? 4 : 0;
                i = iR;
                if (i != 0) {
                }
            }
            this.c = 2;
            return 0;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                throw new IllegalStateException();
            }
            b.c.a.a0.d.D(this.f != -1);
            long position = this.f - iVar.getPosition();
            InterfaceC0105b interfaceC0105b = this.d;
            Objects.requireNonNull(interfaceC0105b);
            return interfaceC0105b.c(iVar, position) ? -1 : 0;
        }
        iVar.k();
        x xVar2 = new x(8);
        d dVarA2 = d.a(iVar, xVar2);
        while (true) {
            int i6 = dVarA2.a;
            if (i6 == 1684108385) {
                iVar.l(8);
                long position2 = iVar.getPosition();
                long j = dVarA2.f1289b + position2;
                long jB = iVar.b();
                if (jB != -1 && j > jB) {
                    StringBuilder sbR = b.d.b.a.a.R(69, "Data exceeds input length: ", j, ", ");
                    sbR.append(jB);
                    Log.w("WavHeaderReader", sbR.toString());
                    j = jB;
                }
                Pair pairCreate = Pair.create(Long.valueOf(position2), Long.valueOf(j));
                this.e = ((Long) pairCreate.first).intValue();
                this.f = ((Long) pairCreate.second).longValue();
                InterfaceC0105b interfaceC0105b2 = this.d;
                Objects.requireNonNull(interfaceC0105b2);
                interfaceC0105b2.b(this.e, this.f);
                this.c = 3;
                return 0;
            }
            b.d.b.a.a.g0(39, "Ignoring unknown WAV chunk: ", i6, "WavHeaderReader");
            long j2 = dVarA2.f1289b + 8;
            if (j2 > 2147483647L) {
                int i7 = dVarA2.a;
                StringBuilder sb2 = new StringBuilder(51);
                sb2.append("Chunk is too large (~2GB+) to skip; id: ");
                sb2.append(i7);
                throw ParserException.b(sb2.toString());
            }
            iVar.l((int) j2);
            dVarA2 = d.a(iVar, xVar2);
        }
    }

    @Override // b.i.a.c.x2.h
    public void f(j jVar) {
        this.a = jVar;
        this.f1285b = jVar.p(0, 1);
        jVar.j();
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        this.c = j == 0 ? 0 : 3;
        InterfaceC0105b interfaceC0105b = this.d;
        if (interfaceC0105b != null) {
            interfaceC0105b.a(j2);
        }
    }

    @Override // b.i.a.c.x2.h
    public void release() {
    }
}
