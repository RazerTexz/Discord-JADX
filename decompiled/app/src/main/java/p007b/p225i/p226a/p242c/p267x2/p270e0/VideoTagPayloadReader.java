package p007b.p225i.p226a.p242c.p267x2.p270e0;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.NalUnitUtil;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p260g3.AvcConfig;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;

/* compiled from: VideoTagPayloadReader.java */
/* renamed from: b.i.a.c.x2.e0.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class VideoTagPayloadReader extends TagPayloadReader {

    /* renamed from: b */
    public final ParsableByteArray f8145b;

    /* renamed from: c */
    public final ParsableByteArray f8146c;

    /* renamed from: d */
    public int f8147d;

    /* renamed from: e */
    public boolean f8148e;

    /* renamed from: f */
    public boolean f8149f;

    /* renamed from: g */
    public int f8150g;

    public VideoTagPayloadReader(TrackOutput2 trackOutput2) {
        super(trackOutput2);
        this.f8145b = new ParsableByteArray(NalUnitUtil.f6753a);
        this.f8146c = new ParsableByteArray(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    /* renamed from: b */
    public boolean mo3657b(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        int iM3100t = parsableByteArray.m3100t();
        int i = (iM3100t >> 4) & 15;
        int i2 = iM3100t & 15;
        if (i2 != 7) {
            throw new TagPayloadReader.UnsupportedFormatException(outline.m851g(39, "Video format not supported: ", i2));
        }
        this.f8150g = i;
        return i != 5;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    /* renamed from: c */
    public boolean mo3658c(ParsableByteArray parsableByteArray, long j) throws ParserException {
        int iM3100t = parsableByteArray.m3100t();
        byte[] bArr = parsableByteArray.f6793a;
        int i = parsableByteArray.f6794b;
        int i2 = i + 1;
        parsableByteArray.f6794b = i2;
        int i3 = ((bArr[i] & 255) << 24) >> 8;
        int i4 = i2 + 1;
        parsableByteArray.f6794b = i4;
        int i5 = i3 | ((bArr[i2] & 255) << 8);
        parsableByteArray.f6794b = i4 + 1;
        long j2 = (((bArr[i4] & 255) | i5) * 1000) + j;
        if (iM3100t == 0 && !this.f8148e) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray(new byte[parsableByteArray.m3081a()]);
            parsableByteArray.m3085e(parsableByteArray2.f6793a, 0, parsableByteArray.m3081a());
            AvcConfig avcConfigM3122b = AvcConfig.m3122b(parsableByteArray2);
            this.f8147d = avcConfigM3122b.f6838b;
            Format2.b bVar = new Format2.b();
            bVar.f7173k = "video/avc";
            bVar.f7170h = avcConfigM3122b.f6842f;
            bVar.f7178p = avcConfigM3122b.f6839c;
            bVar.f7179q = avcConfigM3122b.f6840d;
            bVar.f7182t = avcConfigM3122b.f6841e;
            bVar.f7175m = avcConfigM3122b.f6837a;
            this.f19856a.mo2526e(bVar.m3277a());
            this.f8148e = true;
            return false;
        }
        if (iM3100t != 1 || !this.f8148e) {
            return false;
        }
        int i6 = this.f8150g == 1 ? 1 : 0;
        if (!this.f8149f && i6 == 0) {
            return false;
        }
        byte[] bArr2 = this.f8146c.f6793a;
        bArr2[0] = 0;
        bArr2[1] = 0;
        bArr2[2] = 0;
        int i7 = 4 - this.f8147d;
        int i8 = 0;
        while (parsableByteArray.m3081a() > 0) {
            parsableByteArray.m3085e(this.f8146c.f6793a, i7, this.f8147d);
            this.f8146c.m3079E(0);
            int iM3103w = this.f8146c.m3103w();
            this.f8145b.m3079E(0);
            this.f19856a.mo2524c(this.f8145b, 4);
            this.f19856a.mo2524c(parsableByteArray, iM3103w);
            i8 = i8 + 4 + iM3103w;
        }
        this.f19856a.mo2525d(j2, i6, i8, 0, null);
        this.f8149f = true;
        return true;
    }
}
