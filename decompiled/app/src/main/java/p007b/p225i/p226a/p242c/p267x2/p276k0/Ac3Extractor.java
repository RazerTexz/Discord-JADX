package p007b.p225i.p226a.p242c.p267x2.p276k0;

import java.io.IOException;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p263t2.Ac3Util;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.PositionHolder;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.f, reason: use source file name */
/* JADX INFO: compiled from: Ac3Extractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Ac3Extractor implements Extractor {

    /* JADX INFO: renamed from: a */
    public final Ac3Reader f8604a = new Ac3Reader(null);

    /* JADX INFO: renamed from: b */
    public final ParsableByteArray f8605b = new ParsableByteArray(2786);

    /* JADX INFO: renamed from: c */
    public boolean f8606c;

    static {
        C3070a c3070a = C3070a.f8564a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003d, code lost:
    
        if ((r5 - r3) < 8192) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0034, code lost:
    
        r14.mo3649k();
        r5 = r5 + 1;
     */
    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mo3633b(ExtractorInput extractorInput) throws IOException {
        int iM3491a;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        int i = 0;
        while (true) {
            extractorInput.mo3652o(parsableByteArray.f6793a, 0, 10);
            parsableByteArray.m3079E(0);
            if (parsableByteArray.m3102v() != 4801587) {
                break;
            }
            parsableByteArray.m3080F(3);
            int iM3099s = parsableByteArray.m3099s();
            i += iM3099s + 10;
            extractorInput.mo3646g(iM3099s);
        }
        extractorInput.mo3649k();
        extractorInput.mo3646g(i);
        int i2 = i;
        while (true) {
            int i3 = 0;
            while (true) {
                extractorInput.mo3652o(parsableByteArray.f6793a, 0, 6);
                parsableByteArray.m3079E(0);
                if (parsableByteArray.m3105y() != 2935) {
                    break;
                }
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] bArr = parsableByteArray.f6793a;
                if (bArr.length < 6) {
                    iM3491a = -1;
                } else {
                    iM3491a = ((bArr[5] & 248) >> 3) > 10 ? ((((bArr[2] & 7) << 8) | (bArr[3] & 255)) + 1) * 2 : Ac3Util.m3491a((bArr[4] & 192) >> 6, bArr[4] & 63);
                }
                if (iM3491a == -1) {
                    return false;
                }
                extractorInput.mo3646g(iM3491a - 6);
            }
            extractorInput.mo3646g(i2);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: e */
    public int mo3635e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i = extractorInput.read(this.f8605b.f6793a, 0, 2786);
        if (i == -1) {
            return -1;
        }
        this.f8605b.m3079E(0);
        this.f8605b.m3078D(i);
        if (!this.f8606c) {
            this.f8604a.mo3762f(0L, 4);
            this.f8606c = true;
        }
        this.f8604a.mo3758b(this.f8605b);
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: f */
    public void mo3636f(ExtractorOutput extractorOutput) {
        this.f8604a.mo3761e(extractorOutput, new TsPayloadReader.d(Integer.MIN_VALUE, 0, 1));
        extractorOutput.mo2486j();
        extractorOutput.mo2477a(new SeekMap.b(-9223372036854775807L, 0L));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        this.f8606c = false;
        this.f8604a.mo3759c();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    public void release() {
    }
}
