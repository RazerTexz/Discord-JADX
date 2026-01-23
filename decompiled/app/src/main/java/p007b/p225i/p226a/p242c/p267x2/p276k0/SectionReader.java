package p007b.p225i.p226a.p242c.p267x2.p276k0;

import androidx.core.view.InputDeviceCompat;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.TimestampAdjuster;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.d0, reason: use source file name */
/* JADX INFO: compiled from: SectionReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SectionReader implements TsPayloadReader {

    /* JADX INFO: renamed from: a */
    public final SectionPayloadReader f8595a;

    /* JADX INFO: renamed from: b */
    public final ParsableByteArray f8596b = new ParsableByteArray(32);

    /* JADX INFO: renamed from: c */
    public int f8597c;

    /* JADX INFO: renamed from: d */
    public int f8598d;

    /* JADX INFO: renamed from: e */
    public boolean f8599e;

    /* JADX INFO: renamed from: f */
    public boolean f8600f;

    public SectionReader(SectionPayloadReader sectionPayloadReader) {
        this.f8595a = sectionPayloadReader;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader
    /* JADX INFO: renamed from: a */
    public void mo3754a(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        this.f8595a.mo3752a(timestampAdjuster, extractorOutput, dVar);
        this.f8600f = true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader
    /* JADX INFO: renamed from: b */
    public void mo3755b(ParsableByteArray parsableByteArray, int i) {
        boolean z2 = (i & 1) != 0;
        int iM3100t = z2 ? parsableByteArray.f6794b + parsableByteArray.m3100t() : -1;
        if (this.f8600f) {
            if (!z2) {
                return;
            }
            this.f8600f = false;
            parsableByteArray.m3079E(iM3100t);
            this.f8598d = 0;
        }
        while (parsableByteArray.m3081a() > 0) {
            int i2 = this.f8598d;
            if (i2 < 3) {
                if (i2 == 0) {
                    int iM3100t2 = parsableByteArray.m3100t();
                    parsableByteArray.m3079E(parsableByteArray.f6794b - 1);
                    if (iM3100t2 == 255) {
                        this.f8600f = true;
                        return;
                    }
                }
                int iMin = Math.min(parsableByteArray.m3081a(), 3 - this.f8598d);
                parsableByteArray.m3085e(this.f8596b.f6793a, this.f8598d, iMin);
                int i3 = this.f8598d + iMin;
                this.f8598d = i3;
                if (i3 == 3) {
                    this.f8596b.m3079E(0);
                    this.f8596b.m3078D(3);
                    this.f8596b.m3080F(1);
                    int iM3100t3 = this.f8596b.m3100t();
                    int iM3100t4 = this.f8596b.m3100t();
                    this.f8599e = (iM3100t3 & 128) != 0;
                    int i4 = (((iM3100t3 & 15) << 8) | iM3100t4) + 3;
                    this.f8597c = i4;
                    byte[] bArr = this.f8596b.f6793a;
                    if (bArr.length < i4) {
                        this.f8596b.m3082b(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i4, bArr.length * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(parsableByteArray.m3081a(), this.f8597c - this.f8598d);
                parsableByteArray.m3085e(this.f8596b.f6793a, this.f8598d, iMin2);
                int i5 = this.f8598d + iMin2;
                this.f8598d = i5;
                int i6 = this.f8597c;
                if (i5 != i6) {
                    continue;
                } else {
                    if (this.f8599e) {
                        byte[] bArr2 = this.f8596b.f6793a;
                        int i7 = Util2.f6708a;
                        int i8 = -1;
                        for (int i9 = 0; i9 < i6; i9++) {
                            i8 = Util2.f6718k[((i8 >>> 24) ^ (bArr2[i9] & 255)) & 255] ^ (i8 << 8);
                        }
                        if (i8 != 0) {
                            this.f8600f = true;
                            return;
                        }
                        this.f8596b.m3078D(this.f8597c - 4);
                    } else {
                        this.f8596b.m3078D(i6);
                    }
                    this.f8596b.m3079E(0);
                    this.f8595a.mo3753b(this.f8596b);
                    this.f8598d = 0;
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader
    /* JADX INFO: renamed from: c */
    public void mo3756c() {
        this.f8600f = true;
    }
}
