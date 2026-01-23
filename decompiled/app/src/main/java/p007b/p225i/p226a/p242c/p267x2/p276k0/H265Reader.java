package p007b.p225i.p226a.p242c.p267x2.p276k0;

import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.CodecSpecificDataUtil;
import p007b.p225i.p226a.p242c.p259f3.NalUnitUtil;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.ParsableNalUnitBitArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.s, reason: use source file name */
/* JADX INFO: compiled from: H265Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class H265Reader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a */
    public final SeiReader f8837a;

    /* JADX INFO: renamed from: b */
    public String f8838b;

    /* JADX INFO: renamed from: c */
    public TrackOutput2 f8839c;

    /* JADX INFO: renamed from: d */
    public a f8840d;

    /* JADX INFO: renamed from: e */
    public boolean f8841e;

    /* JADX INFO: renamed from: l */
    public long f8848l;

    /* JADX INFO: renamed from: f */
    public final boolean[] f8842f = new boolean[3];

    /* JADX INFO: renamed from: g */
    public final NalUnitTargetBuffer f8843g = new NalUnitTargetBuffer(32, 128);

    /* JADX INFO: renamed from: h */
    public final NalUnitTargetBuffer f8844h = new NalUnitTargetBuffer(33, 128);

    /* JADX INFO: renamed from: i */
    public final NalUnitTargetBuffer f8845i = new NalUnitTargetBuffer(34, 128);

    /* JADX INFO: renamed from: j */
    public final NalUnitTargetBuffer f8846j = new NalUnitTargetBuffer(39, 128);

    /* JADX INFO: renamed from: k */
    public final NalUnitTargetBuffer f8847k = new NalUnitTargetBuffer(40, 128);

    /* JADX INFO: renamed from: m */
    public long f8849m = -9223372036854775807L;

    /* JADX INFO: renamed from: n */
    public final ParsableByteArray f8850n = new ParsableByteArray();

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.s$a */
    /* JADX INFO: compiled from: H265Reader.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final TrackOutput2 f8851a;

        /* JADX INFO: renamed from: b */
        public long f8852b;

        /* JADX INFO: renamed from: c */
        public boolean f8853c;

        /* JADX INFO: renamed from: d */
        public int f8854d;

        /* JADX INFO: renamed from: e */
        public long f8855e;

        /* JADX INFO: renamed from: f */
        public boolean f8856f;

        /* JADX INFO: renamed from: g */
        public boolean f8857g;

        /* JADX INFO: renamed from: h */
        public boolean f8858h;

        /* JADX INFO: renamed from: i */
        public boolean f8859i;

        /* JADX INFO: renamed from: j */
        public boolean f8860j;

        /* JADX INFO: renamed from: k */
        public long f8861k;

        /* JADX INFO: renamed from: l */
        public long f8862l;

        /* JADX INFO: renamed from: m */
        public boolean f8863m;

        public a(TrackOutput2 trackOutput2) {
            this.f8851a = trackOutput2;
        }

        /* JADX INFO: renamed from: a */
        public final void m3785a(int i) {
            long j = this.f8862l;
            if (j == -9223372036854775807L) {
                return;
            }
            boolean z2 = this.f8863m;
            this.f8851a.mo2525d(j, z2 ? 1 : 0, (int) (this.f8852b - this.f8861k), i, null);
        }
    }

    public H265Reader(SeiReader seiReader) {
        this.f8837a = seiReader;
    }

    @RequiresNonNull({"sampleReader"})
    /* JADX INFO: renamed from: a */
    public final void m3784a(byte[] bArr, int i, int i2) {
        a aVar = this.f8840d;
        if (aVar.f8856f) {
            int i3 = aVar.f8854d;
            int i4 = (i + 2) - i3;
            if (i4 < i2) {
                aVar.f8857g = (bArr[i4] & 128) != 0;
                aVar.f8856f = false;
            } else {
                aVar.f8854d = (i2 - i) + i3;
            }
        }
        if (!this.f8841e) {
            this.f8843g.m3788a(bArr, i, i2);
            this.f8844h.m3788a(bArr, i, i2);
            this.f8845i.m3788a(bArr, i, i2);
        }
        this.f8846j.m3788a(bArr, i, i2);
        this.f8847k.m3788a(bArr, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:166:0x0347  */
    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo3758b(ParsableByteArray parsableByteArray) {
        int i;
        int i2;
        byte[] bArr;
        int i3;
        int i4;
        long j;
        long j2;
        long j3;
        int i5;
        long j4;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        AnimatableValueParser.m438H(this.f8839c);
        int i6 = Util2.f6708a;
        while (parsableByteArray.m3081a() > 0) {
            int i7 = parsableByteArray2.f6795c;
            byte[] bArr2 = parsableByteArray2.f6793a;
            this.f8848l += (long) parsableByteArray.m3081a();
            this.f8839c.mo2524c(parsableByteArray2, parsableByteArray.m3081a());
            for (int i8 = parsableByteArray2.f6794b; i8 < i7; i8 = i3) {
                int iM3055b = NalUnitUtil.m3055b(bArr2, i8, i7, this.f8842f);
                if (iM3055b == i7) {
                    m3784a(bArr2, i8, i7);
                    return;
                }
                int i9 = iM3055b + 3;
                int i10 = (bArr2[i9] & 126) >> 1;
                int i11 = iM3055b - i8;
                if (i11 > 0) {
                    m3784a(bArr2, i8, iM3055b);
                }
                int i12 = i7 - iM3055b;
                long j5 = this.f8848l - ((long) i12);
                int i13 = i11 < 0 ? -i11 : 0;
                long j6 = this.f8849m;
                a aVar = this.f8840d;
                boolean z2 = this.f8841e;
                if (aVar.f8860j && aVar.f8857g) {
                    aVar.f8863m = aVar.f8853c;
                    aVar.f8860j = false;
                } else if (aVar.f8858h || aVar.f8857g) {
                    if (z2 && aVar.f8859i) {
                        aVar.m3785a(((int) (j5 - aVar.f8852b)) + i12);
                    }
                    aVar.f8861k = aVar.f8852b;
                    aVar.f8862l = aVar.f8855e;
                    aVar.f8863m = aVar.f8853c;
                    aVar.f8859i = true;
                }
                if (!this.f8841e) {
                    this.f8843g.m3789b(i13);
                    this.f8844h.m3789b(i13);
                    this.f8845i.m3789b(i13);
                    NalUnitTargetBuffer nalUnitTargetBuffer = this.f8843g;
                    if (nalUnitTargetBuffer.f8905c) {
                        NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f8844h;
                        if (nalUnitTargetBuffer2.f8905c) {
                            NalUnitTargetBuffer nalUnitTargetBuffer3 = this.f8845i;
                            if (nalUnitTargetBuffer3.f8905c) {
                                TrackOutput2 trackOutput2 = this.f8839c;
                                String str = this.f8838b;
                                i2 = i7;
                                int i14 = nalUnitTargetBuffer.f8907e;
                                bArr = bArr2;
                                i3 = i9;
                                byte[] bArr3 = new byte[nalUnitTargetBuffer2.f8907e + i14 + nalUnitTargetBuffer3.f8907e];
                                i = i12;
                                System.arraycopy(nalUnitTargetBuffer.f8906d, 0, bArr3, 0, i14);
                                i4 = i10;
                                System.arraycopy(nalUnitTargetBuffer2.f8906d, 0, bArr3, nalUnitTargetBuffer.f8907e, nalUnitTargetBuffer2.f8907e);
                                System.arraycopy(nalUnitTargetBuffer3.f8906d, 0, bArr3, nalUnitTargetBuffer.f8907e + nalUnitTargetBuffer2.f8907e, nalUnitTargetBuffer3.f8907e);
                                ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(nalUnitTargetBuffer2.f8906d, 0, nalUnitTargetBuffer2.f8907e);
                                parsableNalUnitBitArray.m3116j(44);
                                int iM3111e = parsableNalUnitBitArray.m3111e(3);
                                parsableNalUnitBitArray.m3115i();
                                int iM3111e2 = parsableNalUnitBitArray.m3111e(2);
                                boolean zM3110d = parsableNalUnitBitArray.m3110d();
                                int iM3111e3 = parsableNalUnitBitArray.m3111e(5);
                                int i15 = 0;
                                int i16 = 0;
                                for (int i17 = 32; i15 < i17; i17 = 32) {
                                    if (parsableNalUnitBitArray.m3110d()) {
                                        i16 |= 1 << i15;
                                    }
                                    i15++;
                                }
                                int[] iArr = new int[6];
                                for (int i18 = 0; i18 < 6; i18++) {
                                    iArr[i18] = parsableNalUnitBitArray.m3111e(8);
                                }
                                int iM3111e4 = parsableNalUnitBitArray.m3111e(8);
                                int i19 = 0;
                                for (int i20 = 0; i20 < iM3111e; i20++) {
                                    if (parsableNalUnitBitArray.m3110d()) {
                                        i19 += 89;
                                    }
                                    if (parsableNalUnitBitArray.m3110d()) {
                                        i19 += 8;
                                    }
                                }
                                parsableNalUnitBitArray.m3116j(i19);
                                if (iM3111e > 0) {
                                    parsableNalUnitBitArray.m3116j((8 - iM3111e) * 2);
                                }
                                parsableNalUnitBitArray.m3112f();
                                int iM3112f = parsableNalUnitBitArray.m3112f();
                                if (iM3112f == 3) {
                                    parsableNalUnitBitArray.m3115i();
                                }
                                int iM3112f2 = parsableNalUnitBitArray.m3112f();
                                int iM3112f3 = parsableNalUnitBitArray.m3112f();
                                if (parsableNalUnitBitArray.m3110d()) {
                                    int iM3112f4 = parsableNalUnitBitArray.m3112f();
                                    int iM3112f5 = parsableNalUnitBitArray.m3112f();
                                    int iM3112f6 = parsableNalUnitBitArray.m3112f();
                                    int iM3112f7 = parsableNalUnitBitArray.m3112f();
                                    j = j5;
                                    iM3112f2 -= (iM3112f4 + iM3112f5) * ((iM3112f == 1 || iM3112f == 2) ? 2 : 1);
                                    iM3112f3 -= (iM3112f6 + iM3112f7) * (iM3112f == 1 ? 2 : 1);
                                } else {
                                    j = j5;
                                }
                                parsableNalUnitBitArray.m3112f();
                                parsableNalUnitBitArray.m3112f();
                                int iM3112f8 = parsableNalUnitBitArray.m3112f();
                                for (int i21 = parsableNalUnitBitArray.m3110d() ? 0 : iM3111e; i21 <= iM3111e; i21++) {
                                    parsableNalUnitBitArray.m3112f();
                                    parsableNalUnitBitArray.m3112f();
                                    parsableNalUnitBitArray.m3112f();
                                }
                                parsableNalUnitBitArray.m3112f();
                                parsableNalUnitBitArray.m3112f();
                                parsableNalUnitBitArray.m3112f();
                                parsableNalUnitBitArray.m3112f();
                                parsableNalUnitBitArray.m3112f();
                                parsableNalUnitBitArray.m3112f();
                                if (parsableNalUnitBitArray.m3110d() && parsableNalUnitBitArray.m3110d()) {
                                    int i22 = 0;
                                    for (int i23 = 4; i22 < i23; i23 = 4) {
                                        int i24 = 0;
                                        while (i24 < 6) {
                                            if (parsableNalUnitBitArray.m3110d()) {
                                                j4 = j6;
                                                int iMin = Math.min(64, 1 << ((i22 << 1) + 4));
                                                if (i22 > 1) {
                                                    parsableNalUnitBitArray.m3113g();
                                                }
                                                for (int i25 = 0; i25 < iMin; i25++) {
                                                    parsableNalUnitBitArray.m3113g();
                                                }
                                            } else {
                                                parsableNalUnitBitArray.m3112f();
                                                j4 = j6;
                                            }
                                            i24 += i22 == 3 ? 3 : 1;
                                            j6 = j4;
                                        }
                                        i22++;
                                    }
                                }
                                j2 = j6;
                                parsableNalUnitBitArray.m3116j(2);
                                if (parsableNalUnitBitArray.m3110d()) {
                                    parsableNalUnitBitArray.m3116j(8);
                                    parsableNalUnitBitArray.m3112f();
                                    parsableNalUnitBitArray.m3112f();
                                    parsableNalUnitBitArray.m3115i();
                                }
                                int iM3112f9 = parsableNalUnitBitArray.m3112f();
                                int i26 = 0;
                                boolean zM3110d2 = false;
                                int i27 = 0;
                                while (i26 < iM3112f9) {
                                    if (i26 != 0) {
                                        zM3110d2 = parsableNalUnitBitArray.m3110d();
                                    }
                                    if (zM3110d2) {
                                        parsableNalUnitBitArray.m3115i();
                                        parsableNalUnitBitArray.m3112f();
                                        for (int i28 = 0; i28 <= i27; i28++) {
                                            if (parsableNalUnitBitArray.m3110d()) {
                                                parsableNalUnitBitArray.m3115i();
                                            }
                                        }
                                        i5 = iM3112f9;
                                    } else {
                                        int iM3112f10 = parsableNalUnitBitArray.m3112f();
                                        int iM3112f11 = parsableNalUnitBitArray.m3112f();
                                        int i29 = iM3112f10 + iM3112f11;
                                        i5 = iM3112f9;
                                        for (int i30 = 0; i30 < iM3112f10; i30++) {
                                            parsableNalUnitBitArray.m3112f();
                                            parsableNalUnitBitArray.m3115i();
                                        }
                                        for (int i31 = 0; i31 < iM3112f11; i31++) {
                                            parsableNalUnitBitArray.m3112f();
                                            parsableNalUnitBitArray.m3115i();
                                        }
                                        i27 = i29;
                                    }
                                    i26++;
                                    iM3112f9 = i5;
                                }
                                if (parsableNalUnitBitArray.m3110d()) {
                                    for (int i32 = 0; i32 < parsableNalUnitBitArray.m3112f(); i32++) {
                                        parsableNalUnitBitArray.m3116j(iM3112f8 + 4 + 1);
                                    }
                                }
                                parsableNalUnitBitArray.m3116j(2);
                                float f = 1.0f;
                                if (parsableNalUnitBitArray.m3110d()) {
                                    if (parsableNalUnitBitArray.m3110d()) {
                                        int iM3111e5 = parsableNalUnitBitArray.m3111e(8);
                                        if (iM3111e5 == 255) {
                                            int iM3111e6 = parsableNalUnitBitArray.m3111e(16);
                                            int iM3111e7 = parsableNalUnitBitArray.m3111e(16);
                                            if (iM3111e6 != 0 && iM3111e7 != 0) {
                                                f = iM3111e6 / iM3111e7;
                                            }
                                        } else {
                                            float[] fArr = NalUnitUtil.f6754b;
                                            if (iM3111e5 < fArr.length) {
                                                f = fArr[iM3111e5];
                                            } else {
                                                outline.m852g0(46, "Unexpected aspect_ratio_idc value: ", iM3111e5, "H265Reader");
                                            }
                                        }
                                    }
                                    if (parsableNalUnitBitArray.m3110d()) {
                                        parsableNalUnitBitArray.m3115i();
                                    }
                                    if (parsableNalUnitBitArray.m3110d()) {
                                        parsableNalUnitBitArray.m3116j(4);
                                        if (parsableNalUnitBitArray.m3110d()) {
                                            parsableNalUnitBitArray.m3116j(24);
                                        }
                                    }
                                    if (parsableNalUnitBitArray.m3110d()) {
                                        parsableNalUnitBitArray.m3112f();
                                        parsableNalUnitBitArray.m3112f();
                                    }
                                    parsableNalUnitBitArray.m3115i();
                                    if (parsableNalUnitBitArray.m3110d()) {
                                        iM3112f3 *= 2;
                                    }
                                }
                                String strM3023b = CodecSpecificDataUtil.m3023b(iM3111e2, zM3110d, iM3111e3, i16, iArr, iM3111e4);
                                Format2.b bVar = new Format2.b();
                                bVar.f7163a = str;
                                bVar.f7173k = "video/hevc";
                                bVar.f7170h = strM3023b;
                                bVar.f7178p = iM3112f2;
                                bVar.f7179q = iM3112f3;
                                bVar.f7182t = f;
                                bVar.f7175m = Collections.singletonList(bArr3);
                                trackOutput2.mo2526e(bVar.m3277a());
                                this.f8841e = true;
                            } else {
                                i = i12;
                                i2 = i7;
                                bArr = bArr2;
                                i3 = i9;
                                i4 = i10;
                                j = j5;
                                j2 = j6;
                            }
                        }
                    }
                }
                if (this.f8846j.m3789b(i13)) {
                    NalUnitTargetBuffer nalUnitTargetBuffer4 = this.f8846j;
                    this.f8850n.m3077C(this.f8846j.f8906d, NalUnitUtil.m3059f(nalUnitTargetBuffer4.f8906d, nalUnitTargetBuffer4.f8907e));
                    this.f8850n.m3080F(5);
                    j3 = j2;
                    AnimatableValueParser.m444J(j3, this.f8850n, this.f8837a.f8603b);
                } else {
                    j3 = j2;
                }
                if (this.f8847k.m3789b(i13)) {
                    NalUnitTargetBuffer nalUnitTargetBuffer5 = this.f8847k;
                    this.f8850n.m3077C(this.f8847k.f8906d, NalUnitUtil.m3059f(nalUnitTargetBuffer5.f8906d, nalUnitTargetBuffer5.f8907e));
                    this.f8850n.m3080F(5);
                    AnimatableValueParser.m444J(j3, this.f8850n, this.f8837a.f8603b);
                }
                long j7 = this.f8849m;
                a aVar2 = this.f8840d;
                boolean z3 = this.f8841e;
                aVar2.f8857g = false;
                aVar2.f8858h = false;
                aVar2.f8855e = j7;
                aVar2.f8854d = 0;
                aVar2.f8852b = j;
                int i33 = i4;
                if (!(i33 < 32 || i33 == 40)) {
                    if (aVar2.f8859i && !aVar2.f8860j) {
                        if (z3) {
                            aVar2.m3785a(i);
                        }
                        aVar2.f8859i = false;
                    }
                    if ((32 <= i33 && i33 <= 35) || i33 == 39) {
                        aVar2.f8858h = !aVar2.f8860j;
                        aVar2.f8860j = true;
                    }
                }
                boolean z4 = i33 >= 16 && i33 <= 21;
                aVar2.f8853c = z4;
                aVar2.f8856f = z4 || i33 <= 9;
                if (!this.f8841e) {
                    this.f8843g.m3791d(i33);
                    this.f8844h.m3791d(i33);
                    this.f8845i.m3791d(i33);
                }
                this.f8846j.m3791d(i33);
                this.f8847k.m3791d(i33);
                i7 = i2;
                bArr2 = bArr;
            }
            parsableByteArray2 = parsableByteArray;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: c */
    public void mo3759c() {
        this.f8848l = 0L;
        this.f8849m = -9223372036854775807L;
        NalUnitUtil.m3054a(this.f8842f);
        this.f8843g.m3790c();
        this.f8844h.m3790c();
        this.f8845i.m3790c();
        this.f8846j.m3790c();
        this.f8847k.m3790c();
        a aVar = this.f8840d;
        if (aVar != null) {
            aVar.f8856f = false;
            aVar.f8857g = false;
            aVar.f8858h = false;
            aVar.f8859i = false;
            aVar.f8860j = false;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: d */
    public void mo3760d() {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: e */
    public void mo3761e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.m3765a();
        this.f8838b = dVar.m3766b();
        TrackOutput2 trackOutput2Mo2492p = extractorOutput.mo2492p(dVar.m3767c(), 2);
        this.f8839c = trackOutput2Mo2492p;
        this.f8840d = new a(trackOutput2Mo2492p);
        this.f8837a.m3757a(extractorOutput, dVar);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: f */
    public void mo3762f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f8849m = j;
        }
    }
}
