package p007b.p225i.p226a.p242c.p267x2.p276k0;

import com.google.android.exoplayer2.ParserException;
import java.io.EOFException;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.ParsableBitArray;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.ConstantBitrateSeekMap;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.PositionHolder;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.j, reason: use source file name */
/* JADX INFO: compiled from: AdtsExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AdtsExtractor implements Extractor {

    /* JADX INFO: renamed from: a */
    public final int f8685a;

    /* JADX INFO: renamed from: b */
    public final AdtsReader f8686b;

    /* JADX INFO: renamed from: c */
    public final ParsableByteArray f8687c;

    /* JADX INFO: renamed from: d */
    public final ParsableByteArray f8688d;

    /* JADX INFO: renamed from: e */
    public final ParsableBitArray f8689e;

    /* JADX INFO: renamed from: f */
    public ExtractorOutput f8690f;

    /* JADX INFO: renamed from: g */
    public long f8691g;

    /* JADX INFO: renamed from: h */
    public long f8692h;

    /* JADX INFO: renamed from: i */
    public int f8693i;

    /* JADX INFO: renamed from: j */
    public boolean f8694j;

    /* JADX INFO: renamed from: k */
    public boolean f8695k;

    /* JADX INFO: renamed from: l */
    public boolean f8696l;

    static {
        C3074c c3074c = C3074c.f8593a;
    }

    public AdtsExtractor(int i) {
        this.f8685a = (i & 2) != 0 ? i | 1 : i;
        this.f8686b = new AdtsReader(true, null);
        this.f8687c = new ParsableByteArray(2048);
        this.f8693i = -1;
        this.f8692h = -1L;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        this.f8688d = parsableByteArray;
        this.f8689e = new ParsableBitArray(parsableByteArray.f6793a);
    }

    /* JADX INFO: renamed from: a */
    public final int m3768a(ExtractorInput extractorInput) throws IOException {
        int i = 0;
        while (true) {
            extractorInput.mo3652o(this.f8688d.f6793a, 0, 10);
            this.f8688d.m3079E(0);
            if (this.f8688d.m3102v() != 4801587) {
                break;
            }
            this.f8688d.m3080F(3);
            int iM3099s = this.f8688d.m3099s();
            i += iM3099s + 10;
            extractorInput.mo3646g(iM3099s);
        }
        extractorInput.mo3649k();
        extractorInput.mo3646g(i);
        if (this.f8692h == -1) {
            this.f8692h = i;
        }
        return i;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(ExtractorInput extractorInput) throws IOException {
        int iM3768a = m3768a(extractorInput);
        int i = iM3768a;
        int i2 = 0;
        int i3 = 0;
        do {
            extractorInput.mo3652o(this.f8688d.f6793a, 0, 2);
            this.f8688d.m3079E(0);
            if (AdtsReader.m3771g(this.f8688d.m3105y())) {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                extractorInput.mo3652o(this.f8688d.f6793a, 0, 4);
                this.f8689e.m3071k(14);
                int iM3067g = this.f8689e.m3067g(13);
                if (iM3067g <= 6) {
                    i++;
                    extractorInput.mo3649k();
                    extractorInput.mo3646g(i);
                } else {
                    extractorInput.mo3646g(iM3067g - 6);
                    i3 += iM3067g;
                }
            } else {
                i++;
                extractorInput.mo3649k();
                extractorInput.mo3646g(i);
            }
            i2 = 0;
            i3 = 0;
        } while (i - iM3768a < 8192);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0108  */
    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int mo3635e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        AnimatableValueParser.m438H(this.f8690f);
        long jMo3642b = extractorInput.mo3642b();
        int i = this.f8685a;
        if ((((i & 2) == 0 && ((i & 1) == 0 || jMo3642b == -1)) ? false : true) && !this.f8694j) {
            this.f8693i = -1;
            extractorInput.mo3649k();
            if (extractorInput.getPosition() == 0) {
                m3768a(extractorInput);
            }
            long j = 0;
            int i2 = 0;
            while (true) {
                try {
                    if (!extractorInput.mo3644e(this.f8688d.f6793a, 0, 2, true)) {
                        break;
                    }
                    this.f8688d.m3079E(0);
                    if (!AdtsReader.m3771g(this.f8688d.m3105y())) {
                        i2 = 0;
                        break;
                    }
                    if (!extractorInput.mo3644e(this.f8688d.f6793a, 0, 4, true)) {
                        break;
                    }
                    this.f8689e.m3071k(14);
                    int iM3067g = this.f8689e.m3067g(13);
                    if (iM3067g <= 6) {
                        this.f8694j = true;
                        throw ParserException.m8755a("Malformed ADTS stream", null);
                    }
                    j += (long) iM3067g;
                    i2++;
                    if (i2 != 1000 && extractorInput.mo3651m(iM3067g - 6, true)) {
                    }
                } catch (EOFException unused) {
                }
            }
            extractorInput.mo3649k();
            if (i2 > 0) {
                this.f8693i = (int) (j / ((long) i2));
            } else {
                this.f8693i = -1;
            }
            this.f8694j = true;
        }
        int i3 = extractorInput.read(this.f8687c.f6793a, 0, 2048);
        boolean z2 = i3 == -1;
        if (!this.f8696l) {
            int i4 = this.f8685a;
            boolean z3 = (i4 & 1) != 0 && this.f8693i > 0;
            if (!z3 || this.f8686b.f8716r != -9223372036854775807L || z2) {
                if (z3) {
                    long j2 = this.f8686b.f8716r;
                    if (j2 != -9223372036854775807L) {
                        ExtractorOutput extractorOutput = this.f8690f;
                        boolean z4 = (2 & i4) != 0;
                        int i5 = this.f8693i;
                        extractorOutput.mo2477a(new ConstantBitrateSeekMap(jMo3642b, this.f8692h, (int) ((((long) (i5 * 8)) * 1000000) / j2), i5, z4));
                    } else {
                        this.f8690f.mo2477a(new SeekMap.b(-9223372036854775807L, 0L));
                    }
                    this.f8696l = true;
                }
            }
        }
        if (z2) {
            return -1;
        }
        this.f8687c.m3079E(0);
        this.f8687c.m3078D(i3);
        if (!this.f8695k) {
            this.f8686b.mo3762f(this.f8691g, 4);
            this.f8695k = true;
        }
        this.f8686b.mo3758b(this.f8687c);
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: f */
    public void mo3636f(ExtractorOutput extractorOutput) {
        this.f8690f = extractorOutput;
        this.f8686b.mo3761e(extractorOutput, new TsPayloadReader.d(Integer.MIN_VALUE, 0, 1));
        extractorOutput.mo2486j();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        this.f8695k = false;
        this.f8686b.mo3759c();
        this.f8691g = j2;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    public void release() {
    }
}
