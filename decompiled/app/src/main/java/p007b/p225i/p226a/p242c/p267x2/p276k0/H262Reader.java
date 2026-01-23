package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.NalUnitUtil;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.p, reason: use source file name */
/* JADX INFO: compiled from: H262Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class H262Reader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a */
    public static final double[] f8740a = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* JADX INFO: renamed from: b */
    public String f8741b;

    /* JADX INFO: renamed from: c */
    public TrackOutput2 f8742c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public final UserDataReader f8743d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final ParsableByteArray f8744e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public final NalUnitTargetBuffer f8745f;

    /* JADX INFO: renamed from: g */
    public final boolean[] f8746g = new boolean[4];

    /* JADX INFO: renamed from: h */
    public final a f8747h = new a(128);

    /* JADX INFO: renamed from: i */
    public long f8748i;

    /* JADX INFO: renamed from: j */
    public boolean f8749j;

    /* JADX INFO: renamed from: k */
    public boolean f8750k;

    /* JADX INFO: renamed from: l */
    public long f8751l;

    /* JADX INFO: renamed from: m */
    public long f8752m;

    /* JADX INFO: renamed from: n */
    public long f8753n;

    /* JADX INFO: renamed from: o */
    public long f8754o;

    /* JADX INFO: renamed from: p */
    public boolean f8755p;

    /* JADX INFO: renamed from: q */
    public boolean f8756q;

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.p$a */
    /* JADX INFO: compiled from: H262Reader.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final byte[] f8757a = {0, 0, 1};

        /* JADX INFO: renamed from: b */
        public boolean f8758b;

        /* JADX INFO: renamed from: c */
        public int f8759c;

        /* JADX INFO: renamed from: d */
        public int f8760d;

        /* JADX INFO: renamed from: e */
        public byte[] f8761e;

        public a(int i) {
            this.f8761e = new byte[i];
        }

        /* JADX INFO: renamed from: a */
        public void m3779a(byte[] bArr, int i, int i2) {
            if (this.f8758b) {
                int i3 = i2 - i;
                byte[] bArr2 = this.f8761e;
                int length = bArr2.length;
                int i4 = this.f8759c;
                if (length < i4 + i3) {
                    this.f8761e = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.f8761e, this.f8759c, i3);
                this.f8759c += i3;
            }
        }
    }

    public H262Reader(@Nullable UserDataReader userDataReader) {
        this.f8743d = userDataReader;
        if (userDataReader != null) {
            this.f8745f = new NalUnitTargetBuffer(Opcodes.GETSTATIC, 128);
            this.f8744e = new ParsableByteArray();
        } else {
            this.f8745f = null;
            this.f8744e = null;
        }
        this.f8752m = -9223372036854775807L;
        this.f8754o = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x020b  */
    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo3758b(ParsableByteArray parsableByteArray) {
        int i;
        int i2;
        int i3;
        int i4;
        byte[] bArr;
        long j;
        long j2;
        int i5;
        boolean z2;
        float f;
        int i6;
        float f2;
        int i7;
        long j3;
        AnimatableValueParser.m438H(this.f8742c);
        int i8 = parsableByteArray.f6794b;
        int i9 = parsableByteArray.f6795c;
        byte[] bArr2 = parsableByteArray.f6793a;
        this.f8748i += (long) parsableByteArray.m3081a();
        this.f8742c.mo2524c(parsableByteArray, parsableByteArray.m3081a());
        while (true) {
            int iM3055b = NalUnitUtil.m3055b(bArr2, i8, i9, this.f8746g);
            if (iM3055b == i9) {
                break;
            }
            int i10 = iM3055b + 3;
            int i11 = parsableByteArray.f6793a[i10] & 255;
            int i12 = iM3055b - i8;
            if (this.f8750k) {
                i = i11;
                i2 = i10;
            } else {
                if (i12 > 0) {
                    this.f8747h.m3779a(bArr2, i8, iM3055b);
                }
                int i13 = i12 < 0 ? -i12 : 0;
                a aVar = this.f8747h;
                if (aVar.f8758b) {
                    int i14 = aVar.f8759c - i13;
                    aVar.f8759c = i14;
                    if (aVar.f8760d == 0 && i11 == 181) {
                        aVar.f8760d = i14;
                    } else {
                        aVar.f8758b = false;
                        z2 = true;
                        if (!z2) {
                            a aVar2 = this.f8747h;
                            String str = this.f8741b;
                            Objects.requireNonNull(str);
                            byte[] bArrCopyOf = Arrays.copyOf(aVar2.f8761e, aVar2.f8759c);
                            int i15 = bArrCopyOf[4] & 255;
                            int i16 = bArrCopyOf[5] & 255;
                            int i17 = (i15 << 4) | (i16 >> 4);
                            int i18 = ((i16 & 15) << 8) | (bArrCopyOf[6] & 255);
                            int i19 = (bArrCopyOf[7] & 240) >> 4;
                            if (i19 == 2) {
                                f = i18 * 4;
                                i6 = i17 * 3;
                            } else if (i19 == 3) {
                                f = i18 * 16;
                                i6 = i17 * 9;
                            } else if (i19 != 4) {
                                f2 = 1.0f;
                                Format2.b bVar = new Format2.b();
                                bVar.f7163a = str;
                                bVar.f7173k = "video/mpeg2";
                                bVar.f7178p = i17;
                                bVar.f7179q = i18;
                                bVar.f7182t = f2;
                                bVar.f7175m = Collections.singletonList(bArrCopyOf);
                                Format2 format2M3277a = bVar.m3277a();
                                i7 = (bArrCopyOf[7] & 15) - 1;
                                if (i7 < 0) {
                                    double[] dArr = f8740a;
                                    if (i7 < dArr.length) {
                                        double d = dArr[i7];
                                        int i20 = aVar2.f8760d + 9;
                                        int i21 = (bArrCopyOf[i20] & 96) >> 5;
                                        int i22 = bArrCopyOf[i20] & 31;
                                        if (i21 != i22) {
                                            i = i11;
                                            i2 = i10;
                                            d *= (((double) i21) + 1.0d) / ((double) (i22 + 1));
                                        } else {
                                            i = i11;
                                            i2 = i10;
                                        }
                                        j3 = (long) (1000000.0d / d);
                                    } else {
                                        i = i11;
                                        i2 = i10;
                                        j3 = 0;
                                    }
                                    Pair pairCreate = Pair.create(format2M3277a, Long.valueOf(j3));
                                    this.f8742c.mo2526e((Format2) pairCreate.first);
                                    this.f8751l = ((Long) pairCreate.second).longValue();
                                    this.f8750k = true;
                                }
                            } else {
                                f = i18 * 121;
                                i6 = i17 * 100;
                            }
                            f2 = f / i6;
                            Format2.b bVar2 = new Format2.b();
                            bVar2.f7163a = str;
                            bVar2.f7173k = "video/mpeg2";
                            bVar2.f7178p = i17;
                            bVar2.f7179q = i18;
                            bVar2.f7182t = f2;
                            bVar2.f7175m = Collections.singletonList(bArrCopyOf);
                            Format2 format2M3277a2 = bVar2.m3277a();
                            i7 = (bArrCopyOf[7] & 15) - 1;
                            if (i7 < 0) {
                            }
                        }
                    }
                } else if (i11 == 179) {
                    aVar.f8758b = true;
                }
                byte[] bArr3 = a.f8757a;
                aVar.m3779a(bArr3, 0, bArr3.length);
                z2 = false;
                if (!z2) {
                }
            }
            NalUnitTargetBuffer nalUnitTargetBuffer = this.f8745f;
            if (nalUnitTargetBuffer != null) {
                if (i12 > 0) {
                    nalUnitTargetBuffer.m3788a(bArr2, i8, iM3055b);
                    i5 = 0;
                } else {
                    i5 = -i12;
                }
                if (this.f8745f.m3789b(i5)) {
                    NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f8745f;
                    int iM3059f = NalUnitUtil.m3059f(nalUnitTargetBuffer2.f8906d, nalUnitTargetBuffer2.f8907e);
                    ParsableByteArray parsableByteArray2 = this.f8744e;
                    int i23 = Util2.f6708a;
                    parsableByteArray2.m3077C(this.f8745f.f8906d, iM3059f);
                    this.f8743d.m3769a(this.f8754o, this.f8744e);
                }
                i3 = i;
                if (i3 == 178 && parsableByteArray.f6793a[iM3055b + 2] == 1) {
                    this.f8745f.m3791d(i3);
                }
            } else {
                i3 = i;
            }
            if (i3 == 0 || i3 == 179) {
                int i24 = i9 - iM3055b;
                if (this.f8756q && this.f8750k) {
                    long j4 = this.f8754o;
                    if (j4 != -9223372036854775807L) {
                        i4 = i9;
                        bArr = bArr2;
                        j = -9223372036854775807L;
                        this.f8742c.mo2525d(j4, this.f8755p ? 1 : 0, ((int) (this.f8748i - this.f8753n)) - i24, i24, null);
                    }
                    if (this.f8749j) {
                        this.f8753n = this.f8748i - ((long) i24);
                        j2 = this.f8752m;
                        if (j2 == j) {
                        }
                        this.f8754o = j2;
                        this.f8755p = false;
                        this.f8752m = j;
                        this.f8749j = true;
                        this.f8756q = i3 != 0;
                    }
                } else {
                    i4 = i9;
                    bArr = bArr2;
                    j = -9223372036854775807L;
                    if (this.f8749j || this.f8756q) {
                        this.f8753n = this.f8748i - ((long) i24);
                        j2 = this.f8752m;
                        if (j2 == j) {
                            long j5 = this.f8754o;
                            j2 = j5 != j ? j5 + this.f8751l : j;
                        }
                        this.f8754o = j2;
                        this.f8755p = false;
                        this.f8752m = j;
                        this.f8749j = true;
                    }
                    this.f8756q = i3 != 0;
                }
            } else {
                if (i3 == 184) {
                    this.f8755p = true;
                }
                i4 = i9;
                bArr = bArr2;
            }
            i9 = i4;
            bArr2 = bArr;
            i8 = i2;
        }
        if (!this.f8750k) {
            this.f8747h.m3779a(bArr2, i8, i9);
        }
        NalUnitTargetBuffer nalUnitTargetBuffer3 = this.f8745f;
        if (nalUnitTargetBuffer3 != null) {
            nalUnitTargetBuffer3.m3788a(bArr2, i8, i9);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: c */
    public void mo3759c() {
        NalUnitUtil.m3054a(this.f8746g);
        a aVar = this.f8747h;
        aVar.f8758b = false;
        aVar.f8759c = 0;
        aVar.f8760d = 0;
        NalUnitTargetBuffer nalUnitTargetBuffer = this.f8745f;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.m3790c();
        }
        this.f8748i = 0L;
        this.f8749j = false;
        this.f8752m = -9223372036854775807L;
        this.f8754o = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: d */
    public void mo3760d() {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: e */
    public void mo3761e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.m3765a();
        this.f8741b = dVar.m3766b();
        this.f8742c = extractorOutput.mo2492p(dVar.m3767c(), 2);
        UserDataReader userDataReader = this.f8743d;
        if (userDataReader != null) {
            userDataReader.m3770b(extractorOutput, dVar);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: f */
    public void mo3762f(long j, int i) {
        this.f8752m = j;
    }
}
