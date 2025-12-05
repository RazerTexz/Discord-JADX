package p007b.p225i.p226a.p242c.p267x2.p276k0;

import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ParsableBitArray;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.Ac3Util;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* compiled from: Ac3Reader.java */
/* renamed from: b.i.a.c.x2.k0.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class Ac3Reader implements ElementaryStreamReader {

    /* renamed from: a */
    public final ParsableBitArray f8611a;

    /* renamed from: b */
    public final ParsableByteArray f8612b;

    /* renamed from: c */
    @Nullable
    public final String f8613c;

    /* renamed from: d */
    public String f8614d;

    /* renamed from: e */
    public TrackOutput2 f8615e;

    /* renamed from: f */
    public int f8616f;

    /* renamed from: g */
    public int f8617g;

    /* renamed from: h */
    public boolean f8618h;

    /* renamed from: i */
    public long f8619i;

    /* renamed from: j */
    public Format2 f8620j;

    /* renamed from: k */
    public int f8621k;

    /* renamed from: l */
    public long f8622l;

    public Ac3Reader(@Nullable String str) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[128]);
        this.f8611a = parsableBitArray;
        this.f8612b = new ParsableByteArray(parsableBitArray.f6789a);
        this.f8616f = 0;
        this.f8622l = -9223372036854775807L;
        this.f8613c = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x022e  */
    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo3758b(ParsableByteArray parsableByteArray) {
        int i;
        int i2;
        int i3;
        String str;
        int iM3067g;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z2;
        AnimatableValueParser.m438H(this.f8615e);
        while (parsableByteArray.m3081a() > 0) {
            int i12 = this.f8616f;
            if (i12 == 0) {
                while (true) {
                    if (parsableByteArray.m3081a() <= 0) {
                        z2 = false;
                        break;
                    }
                    if (this.f8618h) {
                        int iM3100t = parsableByteArray.m3100t();
                        if (iM3100t == 119) {
                            this.f8618h = false;
                            z2 = true;
                            break;
                        }
                        this.f8618h = iM3100t == 11;
                    } else {
                        this.f8618h = parsableByteArray.m3100t() == 11;
                    }
                }
                if (z2) {
                    this.f8616f = 1;
                    byte[] bArr = this.f8612b.f6793a;
                    bArr[0] = 11;
                    bArr[1] = 119;
                    this.f8617g = 2;
                }
            } else if (i12 == 1) {
                byte[] bArr2 = this.f8612b.f6793a;
                int iMin = Math.min(parsableByteArray.m3081a(), 128 - this.f8617g);
                System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr2, this.f8617g, iMin);
                parsableByteArray.f6794b += iMin;
                int i13 = this.f8617g + iMin;
                this.f8617g = i13;
                if (i13 == 128) {
                    this.f8611a.m3071k(0);
                    ParsableBitArray parsableBitArray = this.f8611a;
                    int iM3065e = parsableBitArray.m3065e();
                    parsableBitArray.m3073m(40);
                    boolean z3 = parsableBitArray.m3067g(5) > 10;
                    parsableBitArray.m3071k(iM3065e);
                    if (z3) {
                        parsableBitArray.m3073m(16);
                        int iM3067g2 = parsableBitArray.m3067g(2);
                        if (iM3067g2 == 0) {
                            i = 0;
                        } else if (iM3067g2 == 1) {
                            i = 1;
                        } else if (iM3067g2 == 2) {
                            i = 2;
                        }
                        parsableBitArray.m3073m(3);
                        iM3067g = (parsableBitArray.m3067g(11) + 1) * 2;
                        int iM3067g3 = parsableBitArray.m3067g(2);
                        if (iM3067g3 == 3) {
                            i6 = Ac3Util.f7771c[parsableBitArray.m3067g(2)];
                            i5 = 6;
                            i4 = 3;
                        } else {
                            int iM3067g4 = parsableBitArray.m3067g(2);
                            i4 = iM3067g4;
                            i5 = Ac3Util.f7769a[iM3067g4];
                            i6 = Ac3Util.f7770b[iM3067g3];
                        }
                        i3 = i5 * 256;
                        int iM3067g5 = parsableBitArray.m3067g(3);
                        boolean zM3066f = parsableBitArray.m3066f();
                        i2 = Ac3Util.f7772d[iM3067g5] + (zM3066f ? 1 : 0);
                        parsableBitArray.m3073m(10);
                        if (parsableBitArray.m3066f()) {
                            parsableBitArray.m3073m(8);
                        }
                        if (iM3067g5 == 0) {
                            parsableBitArray.m3073m(5);
                            if (parsableBitArray.m3066f()) {
                                parsableBitArray.m3073m(8);
                            }
                        }
                        if (i == 1 && parsableBitArray.m3066f()) {
                            parsableBitArray.m3073m(16);
                        }
                        if (parsableBitArray.m3066f()) {
                            if (iM3067g5 > 2) {
                                parsableBitArray.m3073m(2);
                            }
                            if ((iM3067g5 & 1) == 0 || iM3067g5 <= 2) {
                                i9 = 6;
                            } else {
                                i9 = 6;
                                parsableBitArray.m3073m(6);
                            }
                            if ((iM3067g5 & 4) != 0) {
                                parsableBitArray.m3073m(i9);
                            }
                            if (zM3066f && parsableBitArray.m3066f()) {
                                parsableBitArray.m3073m(5);
                            }
                            if (i == 0) {
                                if (parsableBitArray.m3066f()) {
                                    i10 = 6;
                                    parsableBitArray.m3073m(6);
                                } else {
                                    i10 = 6;
                                }
                                if (iM3067g5 == 0 && parsableBitArray.m3066f()) {
                                    parsableBitArray.m3073m(i10);
                                }
                                if (parsableBitArray.m3066f()) {
                                    parsableBitArray.m3073m(i10);
                                }
                                int iM3067g6 = parsableBitArray.m3067g(2);
                                if (iM3067g6 == 1) {
                                    parsableBitArray.m3073m(5);
                                } else if (iM3067g6 == 2) {
                                    parsableBitArray.m3073m(12);
                                } else {
                                    if (iM3067g6 == 3) {
                                        int iM3067g7 = parsableBitArray.m3067g(5);
                                        if (parsableBitArray.m3066f()) {
                                            parsableBitArray.m3073m(5);
                                            if (parsableBitArray.m3066f()) {
                                                parsableBitArray.m3073m(4);
                                            }
                                            if (parsableBitArray.m3066f()) {
                                                parsableBitArray.m3073m(4);
                                            }
                                            if (parsableBitArray.m3066f()) {
                                                parsableBitArray.m3073m(4);
                                            }
                                            if (parsableBitArray.m3066f()) {
                                                parsableBitArray.m3073m(4);
                                            }
                                            if (parsableBitArray.m3066f()) {
                                                parsableBitArray.m3073m(4);
                                            }
                                            if (parsableBitArray.m3066f()) {
                                                parsableBitArray.m3073m(4);
                                            }
                                            if (parsableBitArray.m3066f()) {
                                                parsableBitArray.m3073m(4);
                                            }
                                            if (parsableBitArray.m3066f()) {
                                                if (parsableBitArray.m3066f()) {
                                                    parsableBitArray.m3073m(4);
                                                }
                                                if (parsableBitArray.m3066f()) {
                                                    parsableBitArray.m3073m(4);
                                                }
                                            }
                                        }
                                        if (parsableBitArray.m3066f()) {
                                            parsableBitArray.m3073m(5);
                                            if (parsableBitArray.m3066f()) {
                                                parsableBitArray.m3073m(7);
                                                if (parsableBitArray.m3066f()) {
                                                    parsableBitArray.m3073m(8);
                                                }
                                                i11 = 2;
                                                parsableBitArray.m3073m((iM3067g7 + 2) * 8);
                                                parsableBitArray.m3063c();
                                            }
                                        }
                                    }
                                    if (iM3067g5 < i11) {
                                        if (parsableBitArray.m3066f()) {
                                            parsableBitArray.m3073m(14);
                                        }
                                        if (iM3067g5 == 0 && parsableBitArray.m3066f()) {
                                            parsableBitArray.m3073m(14);
                                        }
                                    }
                                    if (parsableBitArray.m3066f()) {
                                        if (i4 == 0) {
                                            parsableBitArray.m3073m(5);
                                        } else {
                                            for (int i14 = 0; i14 < i5; i14++) {
                                                if (parsableBitArray.m3066f()) {
                                                    parsableBitArray.m3073m(5);
                                                }
                                            }
                                        }
                                    }
                                }
                                i11 = 2;
                                if (iM3067g5 < i11) {
                                }
                                if (parsableBitArray.m3066f()) {
                                }
                            }
                        }
                        if (parsableBitArray.m3066f()) {
                            parsableBitArray.m3073m(5);
                            if (iM3067g5 == 2) {
                                parsableBitArray.m3073m(4);
                            }
                            if (iM3067g5 >= 6) {
                                parsableBitArray.m3073m(2);
                            }
                            if (parsableBitArray.m3066f()) {
                                i8 = 8;
                                parsableBitArray.m3073m(8);
                            } else {
                                i8 = 8;
                            }
                            if (iM3067g5 == 0 && parsableBitArray.m3066f()) {
                                parsableBitArray.m3073m(i8);
                            }
                            if (iM3067g3 < 3) {
                                parsableBitArray.m3072l();
                            }
                        }
                        if (i == 0 && i4 != 3) {
                            parsableBitArray.m3072l();
                        }
                        if (i == 2 && (i4 == 3 || parsableBitArray.m3066f())) {
                            i7 = 6;
                            parsableBitArray.m3073m(6);
                        } else {
                            i7 = 6;
                        }
                        str = (parsableBitArray.m3066f() && parsableBitArray.m3067g(i7) == 1 && parsableBitArray.m3067g(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
                        i = i6;
                    } else {
                        parsableBitArray.m3073m(32);
                        int iM3067g8 = parsableBitArray.m3067g(2);
                        String str2 = iM3067g8 == 3 ? null : "audio/ac3";
                        int iM3491a = Ac3Util.m3491a(iM3067g8, parsableBitArray.m3067g(6));
                        parsableBitArray.m3073m(8);
                        int iM3067g9 = parsableBitArray.m3067g(3);
                        if ((iM3067g9 & 1) == 0 || iM3067g9 == 1) {
                            i = 2;
                        } else {
                            i = 2;
                            parsableBitArray.m3073m(2);
                        }
                        if ((iM3067g9 & 4) != 0) {
                            parsableBitArray.m3073m(i);
                        }
                        if (iM3067g9 == i) {
                            parsableBitArray.m3073m(i);
                        }
                        int[] iArr = Ac3Util.f7770b;
                        i = iM3067g8 < iArr.length ? iArr[iM3067g8] : -1;
                        i2 = Ac3Util.f7772d[iM3067g9] + (parsableBitArray.m3066f() ? 1 : 0);
                        i3 = 1536;
                        str = str2;
                        iM3067g = iM3491a;
                    }
                    int i15 = i2;
                    Format2 format2 = this.f8620j;
                    if (format2 == null || i15 != format2.f7136J || i != format2.f7137K || !Util2.m2993a(str, format2.f7155w)) {
                        Format2.b bVar = new Format2.b();
                        bVar.f7163a = this.f8614d;
                        bVar.f7173k = str;
                        bVar.f7186x = i15;
                        bVar.f7187y = i;
                        bVar.f7165c = this.f8613c;
                        Format2 format2M3277a = bVar.m3277a();
                        this.f8620j = format2M3277a;
                        this.f8615e.mo2526e(format2M3277a);
                    }
                    this.f8621k = iM3067g;
                    this.f8619i = (i3 * 1000000) / this.f8620j.f7137K;
                    this.f8612b.m3079E(0);
                    this.f8615e.mo2524c(this.f8612b, 128);
                    this.f8616f = 2;
                }
            } else if (i12 == 2) {
                int iMin2 = Math.min(parsableByteArray.m3081a(), this.f8621k - this.f8617g);
                this.f8615e.mo2524c(parsableByteArray, iMin2);
                int i16 = this.f8617g + iMin2;
                this.f8617g = i16;
                int i17 = this.f8621k;
                if (i16 == i17) {
                    long j = this.f8622l;
                    if (j != -9223372036854775807L) {
                        this.f8615e.mo2525d(j, 1, i17, 0, null);
                        this.f8622l += this.f8619i;
                    }
                    this.f8616f = 0;
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: c */
    public void mo3759c() {
        this.f8616f = 0;
        this.f8617g = 0;
        this.f8618h = false;
        this.f8622l = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: d */
    public void mo3760d() {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: e */
    public void mo3761e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.m3765a();
        this.f8614d = dVar.m3766b();
        this.f8615e = extractorOutput.mo2492p(dVar.m3767c(), 1);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: f */
    public void mo3762f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f8622l = j;
        }
    }
}
