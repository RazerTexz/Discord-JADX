package p007b.p225i.p226a.p242c.p267x2.p275j0;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.VorbisBitArray;
import p007b.p225i.p226a.p242c.p267x2.VorbisUtil;
import p007b.p225i.p226a.p242c.p267x2.VorbisUtil2;
import p007b.p225i.p226a.p242c.p267x2.VorbisUtil3;
import p007b.p225i.p226a.p242c.p267x2.p275j0.StreamReader;

/* compiled from: VorbisReader.java */
/* renamed from: b.i.a.c.x2.j0.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class VorbisReader extends StreamReader {

    /* renamed from: n */
    @Nullable
    public a f8555n;

    /* renamed from: o */
    public int f8556o;

    /* renamed from: p */
    public boolean f8557p;

    /* renamed from: q */
    @Nullable
    public VorbisUtil2 f8558q;

    /* renamed from: r */
    @Nullable
    public VorbisUtil3 f8559r;

    /* compiled from: VorbisReader.java */
    /* renamed from: b.i.a.c.x2.j0.j$a */
    public static final class a {

        /* renamed from: a */
        public final VorbisUtil2 f8560a;

        /* renamed from: b */
        public final byte[] f8561b;

        /* renamed from: c */
        public final VorbisUtil[] f8562c;

        /* renamed from: d */
        public final int f8563d;

        public a(VorbisUtil2 vorbisUtil2, VorbisUtil3 vorbisUtil3, byte[] bArr, VorbisUtil[] vorbisUtilArr, int i) {
            this.f8560a = vorbisUtil2;
            this.f8561b = bArr;
            this.f8562c = vorbisUtilArr;
            this.f8563d = i;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.StreamReader
    /* renamed from: b */
    public void mo3747b(long j) {
        this.f8546g = j;
        this.f8557p = j != 0;
        VorbisUtil2 vorbisUtil2 = this.f8558q;
        this.f8556o = vorbisUtil2 != null ? vorbisUtil2.f8058e : 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.StreamReader
    /* renamed from: c */
    public long mo3737c(ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.f6793a;
        if ((bArr[0] & 1) == 1) {
            return -1L;
        }
        byte b2 = bArr[0];
        a aVar = this.f8555n;
        AnimatableValueParser.m438H(aVar);
        a aVar2 = aVar;
        int i = !aVar2.f8562c[(b2 >> 1) & (255 >>> (8 - aVar2.f8563d))].f8053a ? aVar2.f8560a.f8058e : aVar2.f8560a.f8059f;
        long j = this.f8557p ? (this.f8556o + i) / 4 : 0;
        byte[] bArr2 = parsableByteArray.f6793a;
        int length = bArr2.length;
        int i2 = parsableByteArray.f6795c + 4;
        if (length < i2) {
            parsableByteArray.m3076B(Arrays.copyOf(bArr2, i2));
        } else {
            parsableByteArray.m3078D(i2);
        }
        byte[] bArr3 = parsableByteArray.f6793a;
        int i3 = parsableByteArray.f6795c;
        bArr3[i3 - 4] = (byte) (j & 255);
        bArr3[i3 - 3] = (byte) ((j >>> 8) & 255);
        bArr3[i3 - 2] = (byte) ((j >>> 16) & 255);
        bArr3[i3 - 1] = (byte) ((j >>> 24) & 255);
        this.f8557p = true;
        this.f8556o = i;
        return j;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.StreamReader
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    /* renamed from: d */
    public boolean mo3738d(ParsableByteArray parsableByteArray, long j, StreamReader.b bVar) throws IOException {
        a aVar;
        int i;
        int iM3823b;
        int i2;
        int i3;
        int i4;
        if (this.f8555n != null) {
            Objects.requireNonNull(bVar.f8553a);
            return false;
        }
        VorbisUtil2 vorbisUtil2 = this.f8558q;
        if (vorbisUtil2 == null) {
            AnimatableValueParser.m550n2(1, parsableByteArray, false);
            int iM3091k = parsableByteArray.m3091k();
            int iM3100t = parsableByteArray.m3100t();
            int iM3091k2 = parsableByteArray.m3091k();
            int iM3088h = parsableByteArray.m3088h();
            int i5 = iM3088h <= 0 ? -1 : iM3088h;
            int iM3088h2 = parsableByteArray.m3088h();
            int i6 = iM3088h2 <= 0 ? -1 : iM3088h2;
            int iM3088h3 = parsableByteArray.m3088h();
            int i7 = iM3088h3 <= 0 ? -1 : iM3088h3;
            int iM3100t2 = parsableByteArray.m3100t();
            this.f8558q = new VorbisUtil2(iM3091k, iM3100t, iM3091k2, i5, i6, i7, (int) Math.pow(2.0d, iM3100t2 & 15), (int) Math.pow(2.0d, (iM3100t2 & 240) >> 4), (parsableByteArray.m3100t() & 1) > 0, Arrays.copyOf(parsableByteArray.f6793a, parsableByteArray.f6795c));
        } else {
            VorbisUtil3 vorbisUtil3 = this.f8559r;
            if (vorbisUtil3 == null) {
                this.f8559r = AnimatableValueParser.m458N1(parsableByteArray, true, true);
            } else {
                int i8 = parsableByteArray.f6795c;
                byte[] bArr = new byte[i8];
                System.arraycopy(parsableByteArray.f6793a, 0, bArr, 0, i8);
                int i9 = vorbisUtil2.f8054a;
                int i10 = 5;
                AnimatableValueParser.m550n2(5, parsableByteArray, false);
                int iM3100t3 = parsableByteArray.m3100t() + 1;
                VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.f6793a);
                vorbisBitArray.m3824c(parsableByteArray.f6794b * 8);
                int i11 = 0;
                while (true) {
                    int i12 = 16;
                    if (i11 >= iM3100t3) {
                        VorbisUtil3 vorbisUtil32 = vorbisUtil3;
                        byte[] bArr2 = bArr;
                        int i13 = 6;
                        int iM3823b2 = vorbisBitArray.m3823b(6) + 1;
                        for (int i14 = 0; i14 < iM3823b2; i14++) {
                            if (vorbisBitArray.m3823b(16) != 0) {
                                throw ParserException.m8755a("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int i15 = 1;
                        int iM3823b3 = vorbisBitArray.m3823b(6) + 1;
                        int i16 = 0;
                        while (true) {
                            int i17 = 3;
                            if (i16 < iM3823b3) {
                                int iM3823b4 = vorbisBitArray.m3823b(i12);
                                if (iM3823b4 == 0) {
                                    i2 = iM3823b3;
                                    int i18 = 8;
                                    vorbisBitArray.m3824c(8);
                                    vorbisBitArray.m3824c(16);
                                    vorbisBitArray.m3824c(16);
                                    vorbisBitArray.m3824c(6);
                                    vorbisBitArray.m3824c(8);
                                    int iM3823b5 = vorbisBitArray.m3823b(4) + 1;
                                    int i19 = 0;
                                    while (i19 < iM3823b5) {
                                        vorbisBitArray.m3824c(i18);
                                        i19++;
                                        i18 = 8;
                                    }
                                } else {
                                    if (iM3823b4 != i15) {
                                        throw outline.m884w0(52, "floor type greater than 1 not decodable: ", iM3823b4, null);
                                    }
                                    int iM3823b6 = vorbisBitArray.m3823b(5);
                                    int[] iArr = new int[iM3823b6];
                                    int i20 = -1;
                                    for (int i21 = 0; i21 < iM3823b6; i21++) {
                                        iArr[i21] = vorbisBitArray.m3823b(4);
                                        if (iArr[i21] > i20) {
                                            i20 = iArr[i21];
                                        }
                                    }
                                    int i22 = i20 + 1;
                                    int[] iArr2 = new int[i22];
                                    int i23 = 0;
                                    while (i23 < i22) {
                                        iArr2[i23] = vorbisBitArray.m3823b(i17) + 1;
                                        int iM3823b7 = vorbisBitArray.m3823b(2);
                                        int i24 = 8;
                                        if (iM3823b7 > 0) {
                                            vorbisBitArray.m3824c(8);
                                        }
                                        int i25 = iM3823b3;
                                        int i26 = 0;
                                        for (int i27 = 1; i26 < (i27 << iM3823b7); i27 = 1) {
                                            vorbisBitArray.m3824c(i24);
                                            i26++;
                                            i24 = 8;
                                        }
                                        i23++;
                                        i17 = 3;
                                        iM3823b3 = i25;
                                    }
                                    i2 = iM3823b3;
                                    vorbisBitArray.m3824c(2);
                                    int iM3823b8 = vorbisBitArray.m3823b(4);
                                    int i28 = 0;
                                    int i29 = 0;
                                    for (int i30 = 0; i30 < iM3823b6; i30++) {
                                        i28 += iArr2[iArr[i30]];
                                        while (i29 < i28) {
                                            vorbisBitArray.m3824c(iM3823b8);
                                            i29++;
                                        }
                                    }
                                }
                                i16++;
                                i13 = 6;
                                i15 = 1;
                                i12 = 16;
                                iM3823b3 = i2;
                            } else {
                                int i31 = 1;
                                int iM3823b9 = vorbisBitArray.m3823b(i13) + 1;
                                int i32 = 0;
                                while (i32 < iM3823b9) {
                                    if (vorbisBitArray.m3823b(16) > 2) {
                                        throw ParserException.m8755a("residueType greater than 2 is not decodable", null);
                                    }
                                    vorbisBitArray.m3824c(24);
                                    vorbisBitArray.m3824c(24);
                                    vorbisBitArray.m3824c(24);
                                    int iM3823b10 = vorbisBitArray.m3823b(i13) + i31;
                                    int i33 = 8;
                                    vorbisBitArray.m3824c(8);
                                    int[] iArr3 = new int[iM3823b10];
                                    for (int i34 = 0; i34 < iM3823b10; i34++) {
                                        iArr3[i34] = ((vorbisBitArray.m3822a() ? vorbisBitArray.m3823b(5) : 0) * 8) + vorbisBitArray.m3823b(3);
                                    }
                                    int i35 = 0;
                                    while (i35 < iM3823b10) {
                                        int i36 = 0;
                                        while (i36 < i33) {
                                            if ((iArr3[i35] & (1 << i36)) != 0) {
                                                vorbisBitArray.m3824c(i33);
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
                                int iM3823b11 = vorbisBitArray.m3823b(i13) + 1;
                                for (int i37 = 0; i37 < iM3823b11; i37++) {
                                    int iM3823b12 = vorbisBitArray.m3823b(16);
                                    if (iM3823b12 != 0) {
                                        StringBuilder sb = new StringBuilder(52);
                                        sb.append("mapping type other than 0 not supported: ");
                                        sb.append(iM3823b12);
                                        Log.e("VorbisUtil", sb.toString());
                                    } else {
                                        if (vorbisBitArray.m3822a()) {
                                            i = 1;
                                            iM3823b = vorbisBitArray.m3823b(4) + 1;
                                        } else {
                                            i = 1;
                                            iM3823b = 1;
                                        }
                                        if (vorbisBitArray.m3822a()) {
                                            int iM3823b13 = vorbisBitArray.m3823b(8) + i;
                                            for (int i38 = 0; i38 < iM3823b13; i38++) {
                                                int i39 = i9 - 1;
                                                vorbisBitArray.m3824c(AnimatableValueParser.m454M0(i39));
                                                vorbisBitArray.m3824c(AnimatableValueParser.m454M0(i39));
                                            }
                                        }
                                        if (vorbisBitArray.m3823b(2) != 0) {
                                            throw ParserException.m8755a("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iM3823b > 1) {
                                            for (int i40 = 0; i40 < i9; i40++) {
                                                vorbisBitArray.m3824c(4);
                                            }
                                        }
                                        for (int i41 = 0; i41 < iM3823b; i41++) {
                                            vorbisBitArray.m3824c(8);
                                            vorbisBitArray.m3824c(8);
                                            vorbisBitArray.m3824c(8);
                                        }
                                    }
                                }
                                int iM3823b14 = vorbisBitArray.m3823b(6) + 1;
                                VorbisUtil[] vorbisUtilArr = new VorbisUtil[iM3823b14];
                                for (int i42 = 0; i42 < iM3823b14; i42++) {
                                    vorbisUtilArr[i42] = new VorbisUtil(vorbisBitArray.m3822a(), vorbisBitArray.m3823b(16), vorbisBitArray.m3823b(16), vorbisBitArray.m3823b(8));
                                }
                                if (!vorbisBitArray.m3822a()) {
                                    throw ParserException.m8755a("framing bit after modes not set as expected", null);
                                }
                                aVar = new a(vorbisUtil2, vorbisUtil32, bArr2, vorbisUtilArr, AnimatableValueParser.m454M0(iM3823b14 - 1));
                            }
                        }
                    } else {
                        if (vorbisBitArray.m3823b(24) != 5653314) {
                            throw outline.m884w0(66, "expected code book to start with [0x56, 0x43, 0x42] at ", (vorbisBitArray.f9013c * 8) + vorbisBitArray.f9014d, null);
                        }
                        int iM3823b15 = vorbisBitArray.m3823b(16);
                        int iM3823b16 = vorbisBitArray.m3823b(24);
                        long[] jArr = new long[iM3823b16];
                        if (vorbisBitArray.m3822a()) {
                            i3 = iM3100t3;
                            int iM3823b17 = vorbisBitArray.m3823b(5) + 1;
                            int i43 = 0;
                            while (i43 < iM3823b16) {
                                int iM3823b18 = vorbisBitArray.m3823b(AnimatableValueParser.m454M0(iM3823b16 - i43));
                                int i44 = 0;
                                while (i44 < iM3823b18 && i43 < iM3823b16) {
                                    jArr[i43] = iM3823b17;
                                    i43++;
                                    i44++;
                                    vorbisUtil3 = vorbisUtil3;
                                    bArr = bArr;
                                }
                                iM3823b17++;
                                vorbisUtil3 = vorbisUtil3;
                                bArr = bArr;
                            }
                        } else {
                            boolean zM3822a = vorbisBitArray.m3822a();
                            int i45 = 0;
                            while (i45 < iM3823b16) {
                                if (!zM3822a) {
                                    i4 = iM3100t3;
                                    jArr[i45] = vorbisBitArray.m3823b(5) + 1;
                                } else if (vorbisBitArray.m3822a()) {
                                    i4 = iM3100t3;
                                    jArr[i45] = vorbisBitArray.m3823b(i10) + 1;
                                } else {
                                    i4 = iM3100t3;
                                    jArr[i45] = 0;
                                }
                                i45++;
                                i10 = 5;
                                iM3100t3 = i4;
                            }
                            i3 = iM3100t3;
                        }
                        VorbisUtil3 vorbisUtil33 = vorbisUtil3;
                        byte[] bArr3 = bArr;
                        int iM3823b19 = vorbisBitArray.m3823b(4);
                        if (iM3823b19 > 2) {
                            throw outline.m884w0(53, "lookup type greater than 2 not decodable: ", iM3823b19, null);
                        }
                        if (iM3823b19 == 1 || iM3823b19 == 2) {
                            vorbisBitArray.m3824c(32);
                            vorbisBitArray.m3824c(32);
                            int iM3823b20 = vorbisBitArray.m3823b(4) + 1;
                            vorbisBitArray.m3824c(1);
                            vorbisBitArray.m3824c((int) (iM3823b20 * (iM3823b19 == 1 ? iM3823b15 != 0 ? (long) Math.floor(Math.pow(iM3823b16, 1.0d / iM3823b15)) : 0L : iM3823b16 * iM3823b15)));
                        }
                        i11++;
                        i10 = 5;
                        iM3100t3 = i3;
                        vorbisUtil3 = vorbisUtil33;
                        bArr = bArr3;
                    }
                }
            }
        }
        aVar = null;
        this.f8555n = aVar;
        if (aVar == null) {
            return true;
        }
        VorbisUtil2 vorbisUtil22 = aVar.f8560a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(vorbisUtil22.f8060g);
        arrayList.add(aVar.f8561b);
        Format2.b bVar2 = new Format2.b();
        bVar2.f7173k = "audio/vorbis";
        bVar2.f7168f = vorbisUtil22.f8057d;
        bVar2.f7169g = vorbisUtil22.f8056c;
        bVar2.f7186x = vorbisUtil22.f8054a;
        bVar2.f7187y = vorbisUtil22.f8055b;
        bVar2.f7175m = arrayList;
        bVar.f8553a = bVar2.m3277a();
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.StreamReader
    /* renamed from: e */
    public void mo3739e(boolean z2) {
        super.mo3739e(z2);
        if (z2) {
            this.f8555n = null;
            this.f8558q = null;
            this.f8559r = null;
        }
        this.f8556o = 0;
        this.f8557p = false;
    }
}
