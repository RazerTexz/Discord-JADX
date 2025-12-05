package p007b.p225i.p226a.p242c.p267x2.p276k0;

import java.io.IOException;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.PositionHolder;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* compiled from: Ac4Extractor.java */
/* renamed from: b.i.a.c.x2.k0.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class Ac4Extractor implements Extractor {

    /* renamed from: a */
    public final Ac4Reader f8632a = new Ac4Reader(null);

    /* renamed from: b */
    public final ParsableByteArray f8633b = new ParsableByteArray(16384);

    /* renamed from: c */
    public boolean f8634c;

    static {
        C3072b c3072b = C3072b.f8573a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
    
        r15.mo3649k();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
    
        if ((r4 - r3) < 8192) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0045, code lost:
    
        return false;
     */
    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mo3633b(ExtractorInput extractorInput) throws IOException {
        int i;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        int i2 = 0;
        while (true) {
            extractorInput.mo3652o(parsableByteArray.f6793a, 0, 10);
            parsableByteArray.m3079E(0);
            if (parsableByteArray.m3102v() != 4801587) {
                break;
            }
            parsableByteArray.m3080F(3);
            int iM3099s = parsableByteArray.m3099s();
            i2 += iM3099s + 10;
            extractorInput.mo3646g(iM3099s);
        }
        extractorInput.mo3649k();
        extractorInput.mo3646g(i2);
        int i3 = i2;
        while (true) {
            int i4 = 0;
            while (true) {
                int i5 = 7;
                extractorInput.mo3652o(parsableByteArray.f6793a, 0, 7);
                parsableByteArray.m3079E(0);
                int iM3105y = parsableByteArray.m3105y();
                if (iM3105y != 44096 && iM3105y != 44097) {
                    break;
                }
                i4++;
                if (i4 >= 4) {
                    return true;
                }
                byte[] bArr = parsableByteArray.f6793a;
                if (bArr.length < 7) {
                    i = -1;
                } else {
                    int i6 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
                    if (i6 == 65535) {
                        i6 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
                    } else {
                        i5 = 4;
                    }
                    if (iM3105y == 44097) {
                        i5 += 2;
                    }
                    i = i6 + i5;
                }
                if (i == -1) {
                    return false;
                }
                extractorInput.mo3646g(i - 7);
            }
            extractorInput.mo3646g(i3);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: e */
    public int mo3635e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i = extractorInput.read(this.f8633b.f6793a, 0, 16384);
        if (i == -1) {
            return -1;
        }
        this.f8633b.m3079E(0);
        this.f8633b.m3078D(i);
        if (!this.f8634c) {
            this.f8632a.mo3762f(0L, 4);
            this.f8634c = true;
        }
        this.f8632a.mo3758b(this.f8633b);
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: f */
    public void mo3636f(ExtractorOutput extractorOutput) {
        this.f8632a.mo3761e(extractorOutput, new TsPayloadReader.d(Integer.MIN_VALUE, 0, 1));
        extractorOutput.mo2486j();
        extractorOutput.mo2477a(new SeekMap.b(-9223372036854775807L, 0L));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: g */
    public void mo3637g(long j, long j2) {
        this.f8634c = false;
        this.f8632a.mo3759c();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    public void release() {
    }
}
