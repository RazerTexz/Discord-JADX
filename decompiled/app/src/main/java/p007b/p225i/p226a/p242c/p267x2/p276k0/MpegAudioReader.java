package p007b.p225i.p226a.p242c.p267x2.p276k0;

import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p263t2.MpegAudioUtil;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.v, reason: use source file name */
/* JADX INFO: compiled from: MpegAudioReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MpegAudioReader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a */
    public final ParsableByteArray f8891a;

    /* JADX INFO: renamed from: b */
    public final MpegAudioUtil.a f8892b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final String f8893c;

    /* JADX INFO: renamed from: d */
    public TrackOutput2 f8894d;

    /* JADX INFO: renamed from: e */
    public String f8895e;

    /* JADX INFO: renamed from: f */
    public int f8896f = 0;

    /* JADX INFO: renamed from: g */
    public int f8897g;

    /* JADX INFO: renamed from: h */
    public boolean f8898h;

    /* JADX INFO: renamed from: i */
    public boolean f8899i;

    /* JADX INFO: renamed from: j */
    public long f8900j;

    /* JADX INFO: renamed from: k */
    public int f8901k;

    /* JADX INFO: renamed from: l */
    public long f8902l;

    public MpegAudioReader(@Nullable String str) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        this.f8891a = parsableByteArray;
        parsableByteArray.f6793a[0] = -1;
        this.f8892b = new MpegAudioUtil.a();
        this.f8902l = -9223372036854775807L;
        this.f8893c = str;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: b */
    public void mo3758b(ParsableByteArray parsableByteArray) {
        AnimatableValueParser.m438H(this.f8894d);
        while (parsableByteArray.m3081a() > 0) {
            int i = this.f8896f;
            if (i == 0) {
                byte[] bArr = parsableByteArray.f6793a;
                int i2 = parsableByteArray.f6794b;
                int i3 = parsableByteArray.f6795c;
                while (true) {
                    if (i2 >= i3) {
                        parsableByteArray.m3079E(i3);
                        break;
                    }
                    boolean z2 = (bArr[i2] & 255) == 255;
                    boolean z3 = this.f8899i && (bArr[i2] & 224) == 224;
                    this.f8899i = z2;
                    if (z3) {
                        parsableByteArray.m3079E(i2 + 1);
                        this.f8899i = false;
                        this.f8891a.f6793a[1] = bArr[i2];
                        this.f8897g = 2;
                        this.f8896f = 1;
                        break;
                    }
                    i2++;
                }
            } else if (i == 1) {
                int iMin = Math.min(parsableByteArray.m3081a(), 4 - this.f8897g);
                parsableByteArray.m3085e(this.f8891a.f6793a, this.f8897g, iMin);
                int i4 = this.f8897g + iMin;
                this.f8897g = i4;
                if (i4 >= 4) {
                    this.f8891a.m3079E(0);
                    if (this.f8892b.m3469a(this.f8891a.m3086f())) {
                        MpegAudioUtil.a aVar = this.f8892b;
                        this.f8901k = aVar.f7679c;
                        if (!this.f8898h) {
                            long j = ((long) aVar.f7683g) * 1000000;
                            int i5 = aVar.f7680d;
                            this.f8900j = j / ((long) i5);
                            Format2.b bVar = new Format2.b();
                            bVar.f7163a = this.f8895e;
                            bVar.f7173k = aVar.f7678b;
                            bVar.f7174l = 4096;
                            bVar.f7186x = aVar.f7681e;
                            bVar.f7187y = i5;
                            bVar.f7165c = this.f8893c;
                            this.f8894d.mo2526e(bVar.m3277a());
                            this.f8898h = true;
                        }
                        this.f8891a.m3079E(0);
                        this.f8894d.mo2524c(this.f8891a, 4);
                        this.f8896f = 2;
                    } else {
                        this.f8897g = 0;
                        this.f8896f = 1;
                    }
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                int iMin2 = Math.min(parsableByteArray.m3081a(), this.f8901k - this.f8897g);
                this.f8894d.mo2524c(parsableByteArray, iMin2);
                int i6 = this.f8897g + iMin2;
                this.f8897g = i6;
                int i7 = this.f8901k;
                if (i6 >= i7) {
                    long j2 = this.f8902l;
                    if (j2 != -9223372036854775807L) {
                        this.f8894d.mo2525d(j2, 1, i7, 0, null);
                        this.f8902l += this.f8900j;
                    }
                    this.f8897g = 0;
                    this.f8896f = 0;
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: c */
    public void mo3759c() {
        this.f8896f = 0;
        this.f8897g = 0;
        this.f8899i = false;
        this.f8902l = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: d */
    public void mo3760d() {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: e */
    public void mo3761e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.m3765a();
        this.f8895e = dVar.m3766b();
        this.f8894d = extractorOutput.mo2492p(dVar.m3767c(), 1);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: f */
    public void mo3762f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f8902l = j;
        }
    }
}
