package p007b.p225i.p226a.p242c.p267x2.p276k0;

import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ParsableBitArray;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p263t2.Ac4Util;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* compiled from: Ac4Reader.java */
/* renamed from: b.i.a.c.x2.k0.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class Ac4Reader implements ElementaryStreamReader {

    /* renamed from: a */
    public final ParsableBitArray f8661a;

    /* renamed from: b */
    public final ParsableByteArray f8662b;

    /* renamed from: c */
    @Nullable
    public final String f8663c;

    /* renamed from: d */
    public String f8664d;

    /* renamed from: e */
    public TrackOutput2 f8665e;

    /* renamed from: f */
    public int f8666f;

    /* renamed from: g */
    public int f8667g;

    /* renamed from: h */
    public boolean f8668h;

    /* renamed from: i */
    public boolean f8669i;

    /* renamed from: j */
    public long f8670j;

    /* renamed from: k */
    public Format2 f8671k;

    /* renamed from: l */
    public int f8672l;

    /* renamed from: m */
    public long f8673m;

    public Ac4Reader(@Nullable String str) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[16]);
        this.f8661a = parsableBitArray;
        this.f8662b = new ParsableByteArray(parsableBitArray.f6789a);
        this.f8666f = 0;
        this.f8667g = 0;
        this.f8668h = false;
        this.f8669i = false;
        this.f8673m = -9223372036854775807L;
        this.f8663c = str;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: b */
    public void mo3758b(ParsableByteArray parsableByteArray) {
        boolean z2;
        int iM3100t;
        AnimatableValueParser.m438H(this.f8665e);
        while (parsableByteArray.m3081a() > 0) {
            int i = this.f8666f;
            if (i == 0) {
                while (true) {
                    if (parsableByteArray.m3081a() <= 0) {
                        z2 = false;
                        break;
                    } else if (this.f8668h) {
                        iM3100t = parsableByteArray.m3100t();
                        this.f8668h = iM3100t == 172;
                        if (iM3100t == 64 || iM3100t == 65) {
                            break;
                        }
                    } else {
                        this.f8668h = parsableByteArray.m3100t() == 172;
                    }
                }
                this.f8669i = iM3100t == 65;
                z2 = true;
                if (z2) {
                    this.f8666f = 1;
                    byte[] bArr = this.f8662b.f6793a;
                    bArr[0] = -84;
                    bArr[1] = (byte) (this.f8669i ? 65 : 64);
                    this.f8667g = 2;
                }
            } else if (i == 1) {
                byte[] bArr2 = this.f8662b.f6793a;
                int iMin = Math.min(parsableByteArray.m3081a(), 16 - this.f8667g);
                System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr2, this.f8667g, iMin);
                parsableByteArray.f6794b += iMin;
                int i2 = this.f8667g + iMin;
                this.f8667g = i2;
                if (i2 == 16) {
                    this.f8661a.m3071k(0);
                    Ac4Util.b bVarM3493b = Ac4Util.m3493b(this.f8661a);
                    Format2 format2 = this.f8671k;
                    if (format2 == null || 2 != format2.f7136J || bVarM3493b.f7776a != format2.f7137K || !"audio/ac4".equals(format2.f7155w)) {
                        Format2.b bVar = new Format2.b();
                        bVar.f7163a = this.f8664d;
                        bVar.f7173k = "audio/ac4";
                        bVar.f7186x = 2;
                        bVar.f7187y = bVarM3493b.f7776a;
                        bVar.f7165c = this.f8663c;
                        Format2 format2M3277a = bVar.m3277a();
                        this.f8671k = format2M3277a;
                        this.f8665e.mo2526e(format2M3277a);
                    }
                    this.f8672l = bVarM3493b.f7777b;
                    this.f8670j = (bVarM3493b.f7778c * 1000000) / this.f8671k.f7137K;
                    this.f8662b.m3079E(0);
                    this.f8665e.mo2524c(this.f8662b, 16);
                    this.f8666f = 2;
                }
            } else if (i == 2) {
                int iMin2 = Math.min(parsableByteArray.m3081a(), this.f8672l - this.f8667g);
                this.f8665e.mo2524c(parsableByteArray, iMin2);
                int i3 = this.f8667g + iMin2;
                this.f8667g = i3;
                int i4 = this.f8672l;
                if (i3 == i4) {
                    long j = this.f8673m;
                    if (j != -9223372036854775807L) {
                        this.f8665e.mo2525d(j, 1, i4, 0, null);
                        this.f8673m += this.f8670j;
                    }
                    this.f8666f = 0;
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: c */
    public void mo3759c() {
        this.f8666f = 0;
        this.f8667g = 0;
        this.f8668h = false;
        this.f8669i = false;
        this.f8673m = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: d */
    public void mo3760d() {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: e */
    public void mo3761e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.m3765a();
        this.f8664d = dVar.m3766b();
        this.f8665e = extractorOutput.mo2492p(dVar.m3767c(), 1);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: f */
    public void mo3762f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f8673m = j;
        }
    }
}
