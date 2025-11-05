package b.i.a.c.x2.j0;

import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.c.f3.x;
import b.i.a.c.j1;
import b.i.a.c.x2.a0;
import b.i.a.c.x2.b0;
import b.i.a.c.x2.j0.i;
import b.i.a.c.x2.y;
import b.i.a.c.x2.z;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: VorbisReader.java */
/* loaded from: classes3.dex */
public final class j extends i {

    @Nullable
    public a n;
    public int o;
    public boolean p;

    @Nullable
    public b0 q;

    @Nullable
    public z r;

    /* compiled from: VorbisReader.java */
    public static final class a {
        public final b0 a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f1241b;
        public final a0[] c;
        public final int d;

        public a(b0 b0Var, z zVar, byte[] bArr, a0[] a0VarArr, int i) {
            this.a = b0Var;
            this.f1241b = bArr;
            this.c = a0VarArr;
            this.d = i;
        }
    }

    @Override // b.i.a.c.x2.j0.i
    public void b(long j) {
        this.g = j;
        this.p = j != 0;
        b0 b0Var = this.q;
        this.o = b0Var != null ? b0Var.e : 0;
    }

    @Override // b.i.a.c.x2.j0.i
    public long c(x xVar) {
        byte[] bArr = xVar.a;
        if ((bArr[0] & 1) == 1) {
            return -1L;
        }
        byte b2 = bArr[0];
        a aVar = this.n;
        b.c.a.a0.d.H(aVar);
        a aVar2 = aVar;
        int i = !aVar2.c[(b2 >> 1) & (255 >>> (8 - aVar2.d))].a ? aVar2.a.e : aVar2.a.f;
        long j = this.p ? (this.o + i) / 4 : 0;
        byte[] bArr2 = xVar.a;
        int length = bArr2.length;
        int i2 = xVar.c + 4;
        if (length < i2) {
            xVar.B(Arrays.copyOf(bArr2, i2));
        } else {
            xVar.D(i2);
        }
        byte[] bArr3 = xVar.a;
        int i3 = xVar.c;
        bArr3[i3 - 4] = (byte) (j & 255);
        bArr3[i3 - 3] = (byte) ((j >>> 8) & 255);
        bArr3[i3 - 2] = (byte) ((j >>> 16) & 255);
        bArr3[i3 - 1] = (byte) ((j >>> 24) & 255);
        this.p = true;
        this.o = i;
        return j;
    }

    @Override // b.i.a.c.x2.j0.i
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean d(x xVar, long j, i.b bVar) throws IOException {
        a aVar;
        int i;
        int iB;
        int i2;
        int i3;
        int i4;
        if (this.n != null) {
            Objects.requireNonNull(bVar.a);
            return false;
        }
        b0 b0Var = this.q;
        if (b0Var == null) {
            b.c.a.a0.d.n2(1, xVar, false);
            int iK = xVar.k();
            int iT = xVar.t();
            int iK2 = xVar.k();
            int iH = xVar.h();
            int i5 = iH <= 0 ? -1 : iH;
            int iH2 = xVar.h();
            int i6 = iH2 <= 0 ? -1 : iH2;
            int iH3 = xVar.h();
            int i7 = iH3 <= 0 ? -1 : iH3;
            int iT2 = xVar.t();
            this.q = new b0(iK, iT, iK2, i5, i6, i7, (int) Math.pow(2.0d, iT2 & 15), (int) Math.pow(2.0d, (iT2 & 240) >> 4), (xVar.t() & 1) > 0, Arrays.copyOf(xVar.a, xVar.c));
        } else {
            z zVar = this.r;
            if (zVar == null) {
                this.r = b.c.a.a0.d.N1(xVar, true, true);
            } else {
                int i8 = xVar.c;
                byte[] bArr = new byte[i8];
                System.arraycopy(xVar.a, 0, bArr, 0, i8);
                int i9 = b0Var.a;
                int i10 = 5;
                b.c.a.a0.d.n2(5, xVar, false);
                int iT3 = xVar.t() + 1;
                y yVar = new y(xVar.a);
                yVar.c(xVar.f984b * 8);
                int i11 = 0;
                while (true) {
                    int i12 = 16;
                    if (i11 >= iT3) {
                        z zVar2 = zVar;
                        byte[] bArr2 = bArr;
                        int i13 = 6;
                        int iB2 = yVar.b(6) + 1;
                        for (int i14 = 0; i14 < iB2; i14++) {
                            if (yVar.b(16) != 0) {
                                throw ParserException.a("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int i15 = 1;
                        int iB3 = yVar.b(6) + 1;
                        int i16 = 0;
                        while (true) {
                            int i17 = 3;
                            if (i16 < iB3) {
                                int iB4 = yVar.b(i12);
                                if (iB4 == 0) {
                                    i2 = iB3;
                                    int i18 = 8;
                                    yVar.c(8);
                                    yVar.c(16);
                                    yVar.c(16);
                                    yVar.c(6);
                                    yVar.c(8);
                                    int iB5 = yVar.b(4) + 1;
                                    int i19 = 0;
                                    while (i19 < iB5) {
                                        yVar.c(i18);
                                        i19++;
                                        i18 = 8;
                                    }
                                } else {
                                    if (iB4 != i15) {
                                        throw b.d.b.a.a.w0(52, "floor type greater than 1 not decodable: ", iB4, null);
                                    }
                                    int iB6 = yVar.b(5);
                                    int[] iArr = new int[iB6];
                                    int i20 = -1;
                                    for (int i21 = 0; i21 < iB6; i21++) {
                                        iArr[i21] = yVar.b(4);
                                        if (iArr[i21] > i20) {
                                            i20 = iArr[i21];
                                        }
                                    }
                                    int i22 = i20 + 1;
                                    int[] iArr2 = new int[i22];
                                    int i23 = 0;
                                    while (i23 < i22) {
                                        iArr2[i23] = yVar.b(i17) + 1;
                                        int iB7 = yVar.b(2);
                                        int i24 = 8;
                                        if (iB7 > 0) {
                                            yVar.c(8);
                                        }
                                        int i25 = iB3;
                                        int i26 = 0;
                                        for (int i27 = 1; i26 < (i27 << iB7); i27 = 1) {
                                            yVar.c(i24);
                                            i26++;
                                            i24 = 8;
                                        }
                                        i23++;
                                        i17 = 3;
                                        iB3 = i25;
                                    }
                                    i2 = iB3;
                                    yVar.c(2);
                                    int iB8 = yVar.b(4);
                                    int i28 = 0;
                                    int i29 = 0;
                                    for (int i30 = 0; i30 < iB6; i30++) {
                                        i28 += iArr2[iArr[i30]];
                                        while (i29 < i28) {
                                            yVar.c(iB8);
                                            i29++;
                                        }
                                    }
                                }
                                i16++;
                                i13 = 6;
                                i15 = 1;
                                i12 = 16;
                                iB3 = i2;
                            } else {
                                int i31 = 1;
                                int iB9 = yVar.b(i13) + 1;
                                int i32 = 0;
                                while (i32 < iB9) {
                                    if (yVar.b(16) > 2) {
                                        throw ParserException.a("residueType greater than 2 is not decodable", null);
                                    }
                                    yVar.c(24);
                                    yVar.c(24);
                                    yVar.c(24);
                                    int iB10 = yVar.b(i13) + i31;
                                    int i33 = 8;
                                    yVar.c(8);
                                    int[] iArr3 = new int[iB10];
                                    for (int i34 = 0; i34 < iB10; i34++) {
                                        iArr3[i34] = ((yVar.a() ? yVar.b(5) : 0) * 8) + yVar.b(3);
                                    }
                                    int i35 = 0;
                                    while (i35 < iB10) {
                                        int i36 = 0;
                                        while (i36 < i33) {
                                            if ((iArr3[i35] & (1 << i36)) != 0) {
                                                yVar.c(i33);
                                            }
                                            i36++;
                                            i33 = 8;
                                        }
                                        i35++;
                                        i33 = 8;
                                    }
                                    i32++;
                                    i13 = 6;
                                    i31 = 1;
                                }
                                int iB11 = yVar.b(i13) + 1;
                                for (int i37 = 0; i37 < iB11; i37++) {
                                    int iB12 = yVar.b(16);
                                    if (iB12 != 0) {
                                        StringBuilder sb = new StringBuilder(52);
                                        sb.append("mapping type other than 0 not supported: ");
                                        sb.append(iB12);
                                        Log.e("VorbisUtil", sb.toString());
                                    } else {
                                        if (yVar.a()) {
                                            i = 1;
                                            iB = yVar.b(4) + 1;
                                        } else {
                                            i = 1;
                                            iB = 1;
                                        }
                                        if (yVar.a()) {
                                            int iB13 = yVar.b(8) + i;
                                            for (int i38 = 0; i38 < iB13; i38++) {
                                                int i39 = i9 - 1;
                                                yVar.c(b.c.a.a0.d.M0(i39));
                                                yVar.c(b.c.a.a0.d.M0(i39));
                                            }
                                        }
                                        if (yVar.b(2) != 0) {
                                            throw ParserException.a("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iB > 1) {
                                            for (int i40 = 0; i40 < i9; i40++) {
                                                yVar.c(4);
                                            }
                                        }
                                        for (int i41 = 0; i41 < iB; i41++) {
                                            yVar.c(8);
                                            yVar.c(8);
                                            yVar.c(8);
                                        }
                                    }
                                }
                                int iB14 = yVar.b(6) + 1;
                                a0[] a0VarArr = new a0[iB14];
                                for (int i42 = 0; i42 < iB14; i42++) {
                                    a0VarArr[i42] = new a0(yVar.a(), yVar.b(16), yVar.b(16), yVar.b(8));
                                }
                                if (!yVar.a()) {
                                    throw ParserException.a("framing bit after modes not set as expected", null);
                                }
                                aVar = new a(b0Var, zVar2, bArr2, a0VarArr, b.c.a.a0.d.M0(iB14 - 1));
                            }
                        }
                    } else {
                        if (yVar.b(24) != 5653314) {
                            throw b.d.b.a.a.w0(66, "expected code book to start with [0x56, 0x43, 0x42] at ", (yVar.c * 8) + yVar.d, null);
                        }
                        int iB15 = yVar.b(16);
                        int iB16 = yVar.b(24);
                        long[] jArr = new long[iB16];
                        if (yVar.a()) {
                            i3 = iT3;
                            int iB17 = yVar.b(5) + 1;
                            int i43 = 0;
                            while (i43 < iB16) {
                                int iB18 = yVar.b(b.c.a.a0.d.M0(iB16 - i43));
                                int i44 = 0;
                                while (i44 < iB18 && i43 < iB16) {
                                    jArr[i43] = iB17;
                                    i43++;
                                    i44++;
                                    zVar = zVar;
                                    bArr = bArr;
                                }
                                iB17++;
                                zVar = zVar;
                                bArr = bArr;
                            }
                        } else {
                            boolean zA = yVar.a();
                            int i45 = 0;
                            while (i45 < iB16) {
                                if (!zA) {
                                    i4 = iT3;
                                    jArr[i45] = yVar.b(5) + 1;
                                } else if (yVar.a()) {
                                    i4 = iT3;
                                    jArr[i45] = yVar.b(i10) + 1;
                                } else {
                                    i4 = iT3;
                                    jArr[i45] = 0;
                                }
                                i45++;
                                i10 = 5;
                                iT3 = i4;
                            }
                            i3 = iT3;
                        }
                        z zVar3 = zVar;
                        byte[] bArr3 = bArr;
                        int iB19 = yVar.b(4);
                        if (iB19 > 2) {
                            throw b.d.b.a.a.w0(53, "lookup type greater than 2 not decodable: ", iB19, null);
                        }
                        if (iB19 == 1 || iB19 == 2) {
                            yVar.c(32);
                            yVar.c(32);
                            int iB20 = yVar.b(4) + 1;
                            yVar.c(1);
                            yVar.c((int) (iB20 * (iB19 == 1 ? iB15 != 0 ? (long) Math.floor(Math.pow(iB16, 1.0d / iB15)) : 0L : iB16 * iB15)));
                        }
                        i11++;
                        i10 = 5;
                        iT3 = i3;
                        zVar = zVar3;
                        bArr = bArr3;
                    }
                }
            }
        }
        aVar = null;
        this.n = aVar;
        if (aVar == null) {
            return true;
        }
        b0 b0Var2 = aVar.a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(b0Var2.g);
        arrayList.add(aVar.f1241b);
        j1.b bVar2 = new j1.b();
        bVar2.k = "audio/vorbis";
        bVar2.f = b0Var2.d;
        bVar2.g = b0Var2.c;
        bVar2.f1023x = b0Var2.a;
        bVar2.f1024y = b0Var2.f1163b;
        bVar2.m = arrayList;
        bVar.a = bVar2.a();
        return true;
    }

    @Override // b.i.a.c.x2.j0.i
    public void e(boolean z2) {
        super.e(z2);
        if (z2) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }
}
