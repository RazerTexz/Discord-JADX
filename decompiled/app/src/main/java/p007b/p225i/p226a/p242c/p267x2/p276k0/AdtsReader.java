package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ParsableBitArray;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.AacUtil;
import p007b.p225i.p226a.p242c.p267x2.DummyTrackOutput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* compiled from: AdtsReader.java */
/* renamed from: b.i.a.c.x2.k0.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class AdtsReader implements ElementaryStreamReader {

    /* renamed from: a */
    public static final byte[] f8699a = {73, 68, 51};

    /* renamed from: b */
    public final boolean f8700b;

    /* renamed from: c */
    public final ParsableBitArray f8701c = new ParsableBitArray(new byte[7]);

    /* renamed from: d */
    public final ParsableByteArray f8702d = new ParsableByteArray(Arrays.copyOf(f8699a, 10));

    /* renamed from: e */
    @Nullable
    public final String f8703e;

    /* renamed from: f */
    public String f8704f;

    /* renamed from: g */
    public TrackOutput2 f8705g;

    /* renamed from: h */
    public TrackOutput2 f8706h;

    /* renamed from: i */
    public int f8707i;

    /* renamed from: j */
    public int f8708j;

    /* renamed from: k */
    public int f8709k;

    /* renamed from: l */
    public boolean f8710l;

    /* renamed from: m */
    public boolean f8711m;

    /* renamed from: n */
    public int f8712n;

    /* renamed from: o */
    public int f8713o;

    /* renamed from: p */
    public int f8714p;

    /* renamed from: q */
    public boolean f8715q;

    /* renamed from: r */
    public long f8716r;

    /* renamed from: s */
    public int f8717s;

    /* renamed from: t */
    public long f8718t;

    /* renamed from: u */
    public TrackOutput2 f8719u;

    /* renamed from: v */
    public long f8720v;

    public AdtsReader(boolean z2, @Nullable String str) {
        m3773h();
        this.f8712n = -1;
        this.f8713o = -1;
        this.f8716r = -9223372036854775807L;
        this.f8718t = -9223372036854775807L;
        this.f8700b = z2;
        this.f8703e = str;
    }

    /* renamed from: g */
    public static boolean m3771g(int i) {
        return (i & 65526) == 65520;
    }

    /* renamed from: a */
    public final boolean m3772a(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int iMin = Math.min(parsableByteArray.m3081a(), i - this.f8708j);
        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr, this.f8708j, iMin);
        parsableByteArray.f6794b += iMin;
        int i2 = this.f8708j + iMin;
        this.f8708j = i2;
        return i2 == i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x0275, code lost:
    
        r17.f8714p = (r11 & 8) >> 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x027c, code lost:
    
        if ((r11 & 1) != 0) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x027e, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0280, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0281, code lost:
    
        r17.f8710l = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0285, code lost:
    
        if (r17.f8711m != false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0287, code lost:
    
        r17.f8707i = 1;
        r17.f8708j = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x028d, code lost:
    
        r17.f8707i = 3;
        r17.f8708j = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0292, code lost:
    
        r18.m3079E(r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0275 A[EDGE_INSN: B:160:0x0275->B:111:0x0275 BREAK  A[LOOP:1: B:52:0x01a6->B:137:0x02e4], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x021d  */
    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo3758b(ParsableByteArray parsableByteArray) throws ParserException {
        int i;
        boolean z2;
        int i2;
        int i3;
        int i4;
        Objects.requireNonNull(this.f8705g);
        int i5 = Util2.f6708a;
        while (parsableByteArray.m3081a() > 0) {
            int i6 = this.f8707i;
            int i7 = 13;
            int i8 = 2;
            if (i6 == 0) {
                byte[] bArr = parsableByteArray.f6793a;
                int i9 = parsableByteArray.f6794b;
                int i10 = parsableByteArray.f6795c;
                while (true) {
                    if (i9 >= i10) {
                        parsableByteArray.m3079E(i9);
                        break;
                    }
                    int i11 = i9 + 1;
                    int i12 = bArr[i9] & 255;
                    if (this.f8709k != 512 || !m3771g((((byte) i12) & 255) | 65280)) {
                        int i13 = this.f8709k;
                        i = i12 | i13;
                        if (i == 329) {
                            this.f8709k = 768;
                        } else if (i == 511) {
                            this.f8709k = 512;
                        } else if (i == 836) {
                            this.f8709k = 1024;
                        } else {
                            if (i == 1075) {
                                this.f8707i = 2;
                                this.f8708j = f8699a.length;
                                this.f8717s = 0;
                                this.f8702d.m3079E(0);
                                parsableByteArray.m3079E(i11);
                                break;
                            }
                            if (i13 != 256) {
                                this.f8709k = 256;
                                i9 = i11 - 1;
                                i7 = 13;
                                i8 = 2;
                            }
                        }
                        i9 = i11;
                        i7 = 13;
                        i8 = 2;
                    } else {
                        if (this.f8711m) {
                            break;
                        }
                        int i14 = i11 - 2;
                        parsableByteArray.m3079E(i14 + 1);
                        if (m3774i(parsableByteArray, this.f8701c.f6789a, 1)) {
                            this.f8701c.m3071k(4);
                            int iM3067g = this.f8701c.m3067g(1);
                            int i15 = this.f8712n;
                            if (i15 == -1 || iM3067g == i15) {
                                if (this.f8713o == -1) {
                                    if (m3774i(parsableByteArray, this.f8701c.f6789a, 4)) {
                                        this.f8701c.m3071k(14);
                                        int iM3067g2 = this.f8701c.m3067g(i7);
                                        if (iM3067g2 >= 7) {
                                            byte[] bArr2 = parsableByteArray.f6793a;
                                            int i16 = parsableByteArray.f6795c;
                                            int i17 = i14 + iM3067g2;
                                            if (i17 < i16 && (bArr2[i17] != -1 ? !(bArr2[i17] == 73 && ((i2 = i17 + 1) == i16 || (bArr2[i2] == 68 && ((i3 = i17 + 2) == i16 || bArr2[i3] == 51)))) : !((i4 = i17 + 1) == i16 || (m3771g((bArr2[i4] & 255) | 65280) && ((bArr2[i4] & 8) >> 3) == iM3067g)))) {
                                            }
                                            if (z2) {
                                            }
                                            int i132 = this.f8709k;
                                            i = i12 | i132;
                                            if (i == 329) {
                                            }
                                            i9 = i11;
                                            i7 = 13;
                                            i8 = 2;
                                        }
                                        z2 = false;
                                        if (z2) {
                                        }
                                        int i1322 = this.f8709k;
                                        i = i12 | i1322;
                                        if (i == 329) {
                                        }
                                        i9 = i11;
                                        i7 = 13;
                                        i8 = 2;
                                    }
                                    z2 = true;
                                    if (z2) {
                                    }
                                    int i13222 = this.f8709k;
                                    i = i12 | i13222;
                                    if (i == 329) {
                                    }
                                    i9 = i11;
                                    i7 = 13;
                                    i8 = 2;
                                } else {
                                    if (m3774i(parsableByteArray, this.f8701c.f6789a, 1)) {
                                        this.f8701c.m3071k(i8);
                                        if (this.f8701c.m3067g(4) == this.f8713o) {
                                            parsableByteArray.m3079E(i14 + 2);
                                            if (m3774i(parsableByteArray, this.f8701c.f6789a, 4)) {
                                            }
                                        }
                                        z2 = false;
                                        if (z2) {
                                        }
                                        int i132222 = this.f8709k;
                                        i = i12 | i132222;
                                        if (i == 329) {
                                        }
                                        i9 = i11;
                                        i7 = 13;
                                        i8 = 2;
                                    }
                                    z2 = true;
                                    if (z2) {
                                    }
                                    int i1322222 = this.f8709k;
                                    i = i12 | i1322222;
                                    if (i == 329) {
                                    }
                                    i9 = i11;
                                    i7 = 13;
                                    i8 = 2;
                                }
                            }
                        } else {
                            z2 = false;
                            if (z2) {
                                break;
                            }
                            int i13222222 = this.f8709k;
                            i = i12 | i13222222;
                            if (i == 329) {
                            }
                            i9 = i11;
                            i7 = 13;
                            i8 = 2;
                        }
                    }
                }
            } else if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 == 3) {
                        if (m3772a(parsableByteArray, this.f8701c.f6789a, this.f8710l ? 7 : 5)) {
                            this.f8701c.m3071k(0);
                            if (this.f8715q) {
                                this.f8701c.m3073m(10);
                            } else {
                                int iM3067g3 = this.f8701c.m3067g(2) + 1;
                                if (iM3067g3 != 2) {
                                    StringBuilder sb = new StringBuilder(61);
                                    sb.append("Detected audio object type: ");
                                    sb.append(iM3067g3);
                                    sb.append(", but assuming AAC LC.");
                                    Log.w("AdtsReader", sb.toString());
                                    iM3067g3 = 2;
                                }
                                this.f8701c.m3073m(5);
                                int iM3067g4 = this.f8701c.m3067g(3);
                                int i18 = this.f8713o;
                                byte[] bArr3 = {(byte) (((iM3067g3 << 3) & 248) | ((i18 >> 1) & 7)), (byte) (((i18 << 7) & 128) | ((iM3067g4 << 3) & 120))};
                                AacUtil.b bVarM3489b = AacUtil.m3489b(new ParsableBitArray(bArr3), false);
                                Format2.b bVar = new Format2.b();
                                bVar.f7163a = this.f8704f;
                                bVar.f7173k = "audio/mp4a-latm";
                                bVar.f7170h = bVarM3489b.f7768c;
                                bVar.f7186x = bVarM3489b.f7767b;
                                bVar.f7187y = bVarM3489b.f7766a;
                                bVar.f7175m = Collections.singletonList(bArr3);
                                bVar.f7165c = this.f8703e;
                                Format2 format2M3277a = bVar.m3277a();
                                this.f8716r = 1024000000 / format2M3277a.f7137K;
                                this.f8705g.mo2526e(format2M3277a);
                                this.f8715q = true;
                            }
                            this.f8701c.m3073m(4);
                            int iM3067g5 = (this.f8701c.m3067g(13) - 2) - 5;
                            if (this.f8710l) {
                                iM3067g5 -= 2;
                            }
                            TrackOutput2 trackOutput2 = this.f8705g;
                            long j = this.f8716r;
                            this.f8707i = 4;
                            this.f8708j = 0;
                            this.f8719u = trackOutput2;
                            this.f8720v = j;
                            this.f8717s = iM3067g5;
                        }
                    } else {
                        if (i6 != 4) {
                            throw new IllegalStateException();
                        }
                        int iMin = Math.min(parsableByteArray.m3081a(), this.f8717s - this.f8708j);
                        this.f8719u.mo2524c(parsableByteArray, iMin);
                        int i19 = this.f8708j + iMin;
                        this.f8708j = i19;
                        int i20 = this.f8717s;
                        if (i19 == i20) {
                            long j2 = this.f8718t;
                            if (j2 != -9223372036854775807L) {
                                this.f8719u.mo2525d(j2, 1, i20, 0, null);
                                this.f8718t += this.f8720v;
                            }
                            m3773h();
                        }
                    }
                } else if (m3772a(parsableByteArray, this.f8702d.f6793a, 10)) {
                    this.f8706h.mo2524c(this.f8702d, 10);
                    this.f8702d.m3079E(6);
                    TrackOutput2 trackOutput22 = this.f8706h;
                    int iM3099s = this.f8702d.m3099s() + 10;
                    this.f8707i = 4;
                    this.f8708j = 10;
                    this.f8719u = trackOutput22;
                    this.f8720v = 0L;
                    this.f8717s = iM3099s;
                }
            } else if (parsableByteArray.m3081a() != 0) {
                ParsableBitArray parsableBitArray = this.f8701c;
                parsableBitArray.f6789a[0] = parsableByteArray.f6793a[parsableByteArray.f6794b];
                parsableBitArray.m3071k(2);
                int iM3067g6 = this.f8701c.m3067g(4);
                int i21 = this.f8713o;
                if (i21 == -1 || iM3067g6 == i21) {
                    if (!this.f8711m) {
                        this.f8711m = true;
                        this.f8712n = this.f8714p;
                        this.f8713o = iM3067g6;
                    }
                    this.f8707i = 3;
                    this.f8708j = 0;
                } else {
                    this.f8711m = false;
                    m3773h();
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: c */
    public void mo3759c() {
        this.f8718t = -9223372036854775807L;
        this.f8711m = false;
        m3773h();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: d */
    public void mo3760d() {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: e */
    public void mo3761e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.m3765a();
        this.f8704f = dVar.m3766b();
        TrackOutput2 trackOutput2Mo2492p = extractorOutput.mo2492p(dVar.m3767c(), 1);
        this.f8705g = trackOutput2Mo2492p;
        this.f8719u = trackOutput2Mo2492p;
        if (!this.f8700b) {
            this.f8706h = new DummyTrackOutput();
            return;
        }
        dVar.m3765a();
        TrackOutput2 trackOutput2Mo2492p2 = extractorOutput.mo2492p(dVar.m3767c(), 5);
        this.f8706h = trackOutput2Mo2492p2;
        Format2.b bVar = new Format2.b();
        bVar.f7163a = dVar.m3766b();
        bVar.f7173k = "application/id3";
        trackOutput2Mo2492p2.mo2526e(bVar.m3277a());
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: f */
    public void mo3762f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f8718t = j;
        }
    }

    /* renamed from: h */
    public final void m3773h() {
        this.f8707i = 0;
        this.f8708j = 0;
        this.f8709k = 256;
    }

    /* renamed from: i */
    public final boolean m3774i(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        if (parsableByteArray.m3081a() < i) {
            return false;
        }
        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr, 0, i);
        parsableByteArray.f6794b += i;
        return true;
    }
}
