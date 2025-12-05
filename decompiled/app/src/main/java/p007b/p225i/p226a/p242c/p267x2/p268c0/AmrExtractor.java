package p007b.p225i.p226a.p242c.p267x2.p268c0;

import com.google.android.exoplayer2.ParserException;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.ConstantBitrateSeekMap;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.PositionHolder;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;

/* compiled from: AmrExtractor.java */
/* renamed from: b.i.a.c.x2.c0.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class AmrExtractor implements Extractor {

    /* renamed from: a */
    public static final int[] f8068a;

    /* renamed from: b */
    public static final int[] f8069b;

    /* renamed from: c */
    public static final byte[] f8070c;

    /* renamed from: d */
    public static final byte[] f8071d;

    /* renamed from: e */
    public static final int f8072e;

    /* renamed from: f */
    public final byte[] f8073f;

    /* renamed from: g */
    public final int f8074g;

    /* renamed from: h */
    public boolean f8075h;

    /* renamed from: i */
    public long f8076i;

    /* renamed from: j */
    public int f8077j;

    /* renamed from: k */
    public int f8078k;

    /* renamed from: l */
    public boolean f8079l;

    /* renamed from: m */
    public long f8080m;

    /* renamed from: n */
    public int f8081n;

    /* renamed from: o */
    public int f8082o;

    /* renamed from: p */
    public long f8083p;

    /* renamed from: q */
    public ExtractorOutput f8084q;

    /* renamed from: r */
    public TrackOutput2 f8085r;

    /* renamed from: s */
    public SeekMap f8086s;

    /* renamed from: t */
    public boolean f8087t;

    static {
        C3004a c3004a = C3004a.f8067a;
        f8068a = new int[]{13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f8069b = iArr;
        f8070c = Util2.m3015w("#!AMR\n");
        f8071d = Util2.m3015w("#!AMR-WB\n");
        f8072e = iArr[8];
    }

    public AmrExtractor(int i) {
        this.f8074g = (i & 2) != 0 ? i | 1 : i;
        this.f8073f = new byte[1];
        this.f8081n = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m3632a(ExtractorInput extractorInput) throws IOException {
        extractorInput.mo3649k();
        boolean z2 = false;
        extractorInput.mo3652o(this.f8073f, 0, 1);
        byte b2 = this.f8073f[0];
        if ((b2 & 131) > 0) {
            throw outline.m884w0(42, "Invalid padding bits for frame header ", b2, null);
        }
        int i = (b2 >> 3) & 15;
        if (i >= 0 && i <= 15) {
            boolean z3 = this.f8075h;
            if (z3 && (i < 10 || i > 13)) {
                z2 = true;
            } else {
                if (!z3 && (i < 12 || i > 14)) {
                }
            }
        }
        if (z2) {
            return this.f8075h ? f8069b[i] : f8068a[i];
        }
        String str = this.f8075h ? "WB" : "NB";
        StringBuilder sb = new StringBuilder(str.length() + 35);
        sb.append("Illegal AMR ");
        sb.append(str);
        sb.append(" frame type ");
        sb.append(i);
        throw ParserException.m8755a(sb.toString(), null);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: b */
    public boolean mo3633b(ExtractorInput extractorInput) throws IOException {
        return m3634c(extractorInput);
    }

    /* renamed from: c */
    public final boolean m3634c(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = f8070c;
        extractorInput.mo3649k();
        byte[] bArr2 = new byte[bArr.length];
        extractorInput.mo3652o(bArr2, 0, bArr.length);
        if (Arrays.equals(bArr2, bArr)) {
            this.f8075h = false;
            extractorInput.mo3650l(bArr.length);
            return true;
        }
        byte[] bArr3 = f8071d;
        extractorInput.mo3649k();
        byte[] bArr4 = new byte[bArr3.length];
        extractorInput.mo3652o(bArr4, 0, bArr3.length);
        if (!Arrays.equals(bArr4, bArr3)) {
            return false;
        }
        this.f8075h = true;
        extractorInput.mo3650l(bArr3.length);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008a  */
    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int mo3635e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i;
        int i2;
        int iMo2523b;
        AnimatableValueParser.m438H(this.f8085r);
        if (extractorInput.getPosition() == 0 && !m3634c(extractorInput)) {
            throw ParserException.m8755a("Could not find AMR header.", null);
        }
        if (!this.f8087t) {
            this.f8087t = true;
            boolean z2 = this.f8075h;
            String str = z2 ? "audio/amr-wb" : "audio/3gpp";
            int i3 = z2 ? 16000 : 8000;
            TrackOutput2 trackOutput2 = this.f8085r;
            Format2.b bVar = new Format2.b();
            bVar.f7173k = str;
            bVar.f7174l = f8072e;
            bVar.f7186x = 1;
            bVar.f7187y = i3;
            trackOutput2.mo2526e(bVar.m3277a());
        }
        if (this.f8078k == 0) {
            try {
                int iM3632a = m3632a(extractorInput);
                this.f8077j = iM3632a;
                this.f8078k = iM3632a;
                if (this.f8081n == -1) {
                    this.f8080m = extractorInput.getPosition();
                    this.f8081n = this.f8077j;
                }
                if (this.f8081n == this.f8077j) {
                    this.f8082o++;
                }
                iMo2523b = this.f8085r.mo2523b(extractorInput, this.f8078k, true);
            } catch (EOFException unused) {
            }
            if (iMo2523b != -1) {
                i = -1;
            } else {
                int i4 = this.f8078k - iMo2523b;
                this.f8078k = i4;
                if (i4 <= 0) {
                    this.f8085r.mo2525d(this.f8083p + this.f8076i, 1, this.f8077j, 0, null);
                    this.f8076i += 20000;
                }
                i = 0;
            }
        } else {
            iMo2523b = this.f8085r.mo2523b(extractorInput, this.f8078k, true);
            if (iMo2523b != -1) {
            }
        }
        long jMo3642b = extractorInput.mo3642b();
        if (!this.f8079l) {
            int i5 = this.f8074g;
            if ((i5 & 1) == 0 || jMo3642b == -1 || !((i2 = this.f8081n) == -1 || i2 == this.f8077j)) {
                SeekMap.b bVar2 = new SeekMap.b(-9223372036854775807L, 0L);
                this.f8086s = bVar2;
                this.f8084q.mo2477a(bVar2);
                this.f8079l = true;
            } else if (this.f8082o >= 20 || i == -1) {
                ConstantBitrateSeekMap constantBitrateSeekMap = new ConstantBitrateSeekMap(jMo3642b, this.f8080m, (int) (((i2 * 8) * 1000000) / 20000), i2, (i5 & 2) != 0);
                this.f8086s = constantBitrateSeekMap;
                this.f8084q.mo2477a(constantBitrateSeekMap);
                this.f8079l = true;
            }
        }
        return i;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: f */
    public void mo3636f(ExtractorOutput extractorOutput) {
        this.f8084q = extractorOutput;
        this.f8085r = extractorOutput.mo2492p(0, 1);
        extractorOutput.mo2486j();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: g */
    public void mo3637g(long j, long j2) {
        this.f8076i = 0L;
        this.f8077j = 0;
        this.f8078k = 0;
        if (j != 0) {
            SeekMap seekMap = this.f8086s;
            if (seekMap instanceof ConstantBitrateSeekMap) {
                ConstantBitrateSeekMap constantBitrateSeekMap = (ConstantBitrateSeekMap) seekMap;
                this.f8083p = ConstantBitrateSeekMap.m3638e(j, constantBitrateSeekMap.f8089b, constantBitrateSeekMap.f8092e);
                return;
            }
        }
        this.f8083p = 0L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    public void release() {
    }
}
