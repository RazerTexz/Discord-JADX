package p007b.p225i.p226a.p242c.p267x2.p277l0;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.PositionHolder;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;

/* compiled from: WavExtractor.java */
/* renamed from: b.i.a.c.x2.l0.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class WavExtractor implements Extractor {

    /* renamed from: a */
    public ExtractorOutput f8926a;

    /* renamed from: b */
    public TrackOutput2 f8927b;

    /* renamed from: d */
    public b f8929d;

    /* renamed from: c */
    public int f8928c = 0;

    /* renamed from: e */
    public int f8930e = -1;

    /* renamed from: f */
    public long f8931f = -1;

    /* compiled from: WavExtractor.java */
    /* renamed from: b.i.a.c.x2.l0.b$a */
    public static final class a implements b {

        /* renamed from: a */
        public static final int[] f8932a = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* renamed from: b */
        public static final int[] f8933b = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, Opcodes.D2L, 157, Opcodes.LRETURN, Opcodes.ARRAYLENGTH, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* renamed from: c */
        public final ExtractorOutput f8934c;

        /* renamed from: d */
        public final TrackOutput2 f8935d;

        /* renamed from: e */
        public final WavFormat f8936e;

        /* renamed from: f */
        public final int f8937f;

        /* renamed from: g */
        public final byte[] f8938g;

        /* renamed from: h */
        public final ParsableByteArray f8939h;

        /* renamed from: i */
        public final int f8940i;

        /* renamed from: j */
        public final Format2 f8941j;

        /* renamed from: k */
        public int f8942k;

        /* renamed from: l */
        public long f8943l;

        /* renamed from: m */
        public int f8944m;

        /* renamed from: n */
        public long f8945n;

        public a(ExtractorOutput extractorOutput, TrackOutput2 trackOutput2, WavFormat wavFormat) throws ParserException {
            this.f8934c = extractorOutput;
            this.f8935d = trackOutput2;
            this.f8936e = wavFormat;
            int iMax = Math.max(1, wavFormat.f8956c / 10);
            this.f8940i = iMax;
            byte[] bArr = wavFormat.f8959f;
            int length = bArr.length;
            byte b2 = bArr[0];
            byte b3 = bArr[1];
            int i = ((bArr[3] & 255) << 8) | (bArr[2] & 255);
            this.f8937f = i;
            int i2 = wavFormat.f8955b;
            int i3 = (((wavFormat.f8957d - (i2 * 4)) * 8) / (wavFormat.f8958e * i2)) + 1;
            if (i != i3) {
                throw ParserException.m8755a(outline.m853h(56, "Expected frames per block: ", i3, "; got: ", i), null);
            }
            int iM2998f = Util2.m2998f(iMax, i);
            this.f8938g = new byte[wavFormat.f8957d * iM2998f];
            this.f8939h = new ParsableByteArray(i * 2 * i2 * iM2998f);
            int i4 = wavFormat.f8956c;
            int i5 = ((wavFormat.f8957d * i4) * 8) / i;
            Format2.b bVar = new Format2.b();
            bVar.f7173k = "audio/raw";
            bVar.f7168f = i5;
            bVar.f7169g = i5;
            bVar.f7174l = iMax * 2 * i2;
            bVar.f7186x = wavFormat.f8955b;
            bVar.f7187y = i4;
            bVar.f7188z = 2;
            this.f8941j = bVar.m3277a();
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p277l0.WavExtractor.b
        /* renamed from: a */
        public void mo3795a(long j) {
            this.f8942k = 0;
            this.f8943l = j;
            this.f8944m = 0;
            this.f8945n = 0L;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p277l0.WavExtractor.b
        /* renamed from: b */
        public void mo3796b(int i, long j) {
            this.f8934c.mo2477a(new WavSeekMap(this.f8936e, this.f8937f, i, j));
            this.f8935d.mo2526e(this.f8941j);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:7:0x0029
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
            */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003f -> B:12:0x0041). Please report as a decompilation issue!!! */
        @Override // p007b.p225i.p226a.p242c.p267x2.p277l0.WavExtractor.b
        /* renamed from: c */
        public boolean mo3797c(p007b.p225i.p226a.p242c.p267x2.ExtractorInput r19, long r20) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 364
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: p007b.p225i.p226a.p242c.p267x2.p277l0.WavExtractor.a.mo3797c(b.i.a.c.x2.i, long):boolean");
        }

        /* renamed from: d */
        public final int m3798d(int i) {
            return i / (this.f8936e.f8955b * 2);
        }

        /* renamed from: e */
        public final void m3799e(int i) {
            long jM2985F = this.f8943l + Util2.m2985F(this.f8945n, 1000000L, this.f8936e.f8956c);
            int i2 = i * 2 * this.f8936e.f8955b;
            this.f8935d.mo2525d(jM2985F, 1, i2, this.f8944m - i2, null);
            this.f8945n += i;
            this.f8944m -= i2;
        }
    }

    /* compiled from: WavExtractor.java */
    /* renamed from: b.i.a.c.x2.l0.b$b */
    public interface b {
        /* renamed from: a */
        void mo3795a(long j);

        /* renamed from: b */
        void mo3796b(int i, long j) throws ParserException;

        /* renamed from: c */
        boolean mo3797c(ExtractorInput extractorInput, long j) throws IOException;
    }

    /* compiled from: WavExtractor.java */
    /* renamed from: b.i.a.c.x2.l0.b$c */
    public static final class c implements b {

        /* renamed from: a */
        public final ExtractorOutput f8946a;

        /* renamed from: b */
        public final TrackOutput2 f8947b;

        /* renamed from: c */
        public final WavFormat f8948c;

        /* renamed from: d */
        public final Format2 f8949d;

        /* renamed from: e */
        public final int f8950e;

        /* renamed from: f */
        public long f8951f;

        /* renamed from: g */
        public int f8952g;

        /* renamed from: h */
        public long f8953h;

        public c(ExtractorOutput extractorOutput, TrackOutput2 trackOutput2, WavFormat wavFormat, String str, int i) throws ParserException {
            this.f8946a = extractorOutput;
            this.f8947b = trackOutput2;
            this.f8948c = wavFormat;
            int i2 = (wavFormat.f8955b * wavFormat.f8958e) / 8;
            int i3 = wavFormat.f8957d;
            if (i3 != i2) {
                throw ParserException.m8755a(outline.m853h(50, "Expected block size: ", i2, "; got: ", i3), null);
            }
            int i4 = wavFormat.f8956c * i2;
            int i5 = i4 * 8;
            int iMax = Math.max(i2, i4 / 10);
            this.f8950e = iMax;
            Format2.b bVar = new Format2.b();
            bVar.f7173k = str;
            bVar.f7168f = i5;
            bVar.f7169g = i5;
            bVar.f7174l = iMax;
            bVar.f7186x = wavFormat.f8955b;
            bVar.f7187y = wavFormat.f8956c;
            bVar.f7188z = i;
            this.f8949d = bVar.m3277a();
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p277l0.WavExtractor.b
        /* renamed from: a */
        public void mo3795a(long j) {
            this.f8951f = j;
            this.f8952g = 0;
            this.f8953h = 0L;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p277l0.WavExtractor.b
        /* renamed from: b */
        public void mo3796b(int i, long j) {
            this.f8946a.mo2477a(new WavSeekMap(this.f8948c, 1, i, j));
            this.f8947b.mo2526e(this.f8949d);
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p277l0.WavExtractor.b
        /* renamed from: c */
        public boolean mo3797c(ExtractorInput extractorInput, long j) throws IOException {
            int i;
            int i2;
            long j2 = j;
            while (j2 > 0 && (i = this.f8952g) < (i2 = this.f8950e)) {
                int iMo2523b = this.f8947b.mo2523b(extractorInput, (int) Math.min(i2 - i, j2), true);
                if (iMo2523b == -1) {
                    j2 = 0;
                } else {
                    this.f8952g += iMo2523b;
                    j2 -= iMo2523b;
                }
            }
            int i3 = this.f8948c.f8957d;
            int i4 = this.f8952g / i3;
            if (i4 > 0) {
                long jM2985F = this.f8951f + Util2.m2985F(this.f8953h, 1000000L, r1.f8956c);
                int i5 = i4 * i3;
                int i6 = this.f8952g - i5;
                this.f8947b.mo2525d(jM2985F, 1, i5, i6, null);
                this.f8953h += i4;
                this.f8952g = i6;
            }
            return j2 <= 0;
        }
    }

    static {
        C3107a c3107a = C3107a.f8925a;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: b */
    public boolean mo3633b(ExtractorInput extractorInput) throws IOException {
        return AnimatableValueParser.m563r(extractorInput);
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d8  */
    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int mo3635e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        byte[] bArr;
        int iM3010r;
        int i;
        AnimatableValueParser.m438H(this.f8927b);
        int i2 = Util2.f6708a;
        int i3 = this.f8928c;
        if (i3 == 0) {
            AnimatableValueParser.m426D(extractorInput.getPosition() == 0);
            int i4 = this.f8930e;
            if (i4 != -1) {
                extractorInput.mo3650l(i4);
                this.f8928c = 3;
            } else {
                if (!AnimatableValueParser.m563r(extractorInput)) {
                    throw ParserException.m8755a("Unsupported or unrecognized wav file type.", null);
                }
                extractorInput.mo3650l((int) (extractorInput.mo3645f() - extractorInput.getPosition()));
                this.f8928c = 1;
            }
            return 0;
        }
        if (i3 == 1) {
            ParsableByteArray parsableByteArray = new ParsableByteArray(16);
            WavHeaderReader wavHeaderReaderM3800a = WavHeaderReader.m3800a(extractorInput, parsableByteArray);
            while (wavHeaderReaderM3800a.f8960a != 1718449184) {
                extractorInput.mo3650l(((int) wavHeaderReaderM3800a.f8961b) + 8);
                wavHeaderReaderM3800a = WavHeaderReader.m3800a(extractorInput, parsableByteArray);
            }
            AnimatableValueParser.m426D(wavHeaderReaderM3800a.f8961b >= 16);
            extractorInput.mo3652o(parsableByteArray.f6793a, 0, 16);
            parsableByteArray.m3079E(0);
            int iM3092l = parsableByteArray.m3092l();
            int iM3092l2 = parsableByteArray.m3092l();
            int iM3091k = parsableByteArray.m3091k();
            int iM3091k2 = parsableByteArray.m3091k();
            int iM3092l3 = parsableByteArray.m3092l();
            int iM3092l4 = parsableByteArray.m3092l();
            int i5 = ((int) wavHeaderReaderM3800a.f8961b) - 16;
            if (i5 > 0) {
                bArr = new byte[i5];
                extractorInput.mo3652o(bArr, 0, i5);
            } else {
                bArr = Util2.f6713f;
            }
            extractorInput.mo3650l((int) (extractorInput.mo3645f() - extractorInput.getPosition()));
            WavFormat wavFormat = new WavFormat(iM3092l, iM3092l2, iM3091k, iM3091k2, iM3092l3, iM3092l4, bArr);
            if (iM3092l == 17) {
                this.f8929d = new a(this.f8926a, this.f8927b, wavFormat);
            } else if (iM3092l == 6) {
                this.f8929d = new c(this.f8926a, this.f8927b, wavFormat, "audio/g711-alaw", -1);
            } else if (iM3092l == 7) {
                this.f8929d = new c(this.f8926a, this.f8927b, wavFormat, "audio/g711-mlaw", -1);
            } else if (iM3092l == 1) {
                iM3010r = Util2.m3010r(iM3092l4);
                i = iM3010r;
                if (i != 0) {
                    StringBuilder sb = new StringBuilder(40);
                    sb.append("Unsupported WAV format type: ");
                    sb.append(iM3092l);
                    throw ParserException.m8756b(sb.toString());
                }
                this.f8929d = new c(this.f8926a, this.f8927b, wavFormat, "audio/raw", i);
            } else if (iM3092l != 3) {
                if (iM3092l != 65534) {
                    i = 0;
                    if (i != 0) {
                    }
                }
                iM3010r = Util2.m3010r(iM3092l4);
                i = iM3010r;
                if (i != 0) {
                }
            } else {
                iM3010r = iM3092l4 == 32 ? 4 : 0;
                i = iM3010r;
                if (i != 0) {
                }
            }
            this.f8928c = 2;
            return 0;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                throw new IllegalStateException();
            }
            AnimatableValueParser.m426D(this.f8931f != -1);
            long position = this.f8931f - extractorInput.getPosition();
            b bVar = this.f8929d;
            Objects.requireNonNull(bVar);
            return bVar.mo3797c(extractorInput, position) ? -1 : 0;
        }
        extractorInput.mo3649k();
        ParsableByteArray parsableByteArray2 = new ParsableByteArray(8);
        WavHeaderReader wavHeaderReaderM3800a2 = WavHeaderReader.m3800a(extractorInput, parsableByteArray2);
        while (true) {
            int i6 = wavHeaderReaderM3800a2.f8960a;
            if (i6 == 1684108385) {
                extractorInput.mo3650l(8);
                long position2 = extractorInput.getPosition();
                long j = wavHeaderReaderM3800a2.f8961b + position2;
                long jMo3642b = extractorInput.mo3642b();
                if (jMo3642b != -1 && j > jMo3642b) {
                    StringBuilder sbM830R = outline.m830R(69, "Data exceeds input length: ", j, ", ");
                    sbM830R.append(jMo3642b);
                    Log.w("WavHeaderReader", sbM830R.toString());
                    j = jMo3642b;
                }
                Pair pairCreate = Pair.create(Long.valueOf(position2), Long.valueOf(j));
                this.f8930e = ((Long) pairCreate.first).intValue();
                this.f8931f = ((Long) pairCreate.second).longValue();
                b bVar2 = this.f8929d;
                Objects.requireNonNull(bVar2);
                bVar2.mo3796b(this.f8930e, this.f8931f);
                this.f8928c = 3;
                return 0;
            }
            outline.m852g0(39, "Ignoring unknown WAV chunk: ", i6, "WavHeaderReader");
            long j2 = wavHeaderReaderM3800a2.f8961b + 8;
            if (j2 > 2147483647L) {
                int i7 = wavHeaderReaderM3800a2.f8960a;
                StringBuilder sb2 = new StringBuilder(51);
                sb2.append("Chunk is too large (~2GB+) to skip; id: ");
                sb2.append(i7);
                throw ParserException.m8756b(sb2.toString());
            }
            extractorInput.mo3650l((int) j2);
            wavHeaderReaderM3800a2 = WavHeaderReader.m3800a(extractorInput, parsableByteArray2);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: f */
    public void mo3636f(ExtractorOutput extractorOutput) {
        this.f8926a = extractorOutput;
        this.f8927b = extractorOutput.mo2492p(0, 1);
        extractorOutput.mo2486j();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: g */
    public void mo3637g(long j, long j2) {
        this.f8928c = j == 0 ? 0 : 3;
        b bVar = this.f8929d;
        if (bVar != null) {
            bVar.mo3795a(j2);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    public void release() {
    }
}
