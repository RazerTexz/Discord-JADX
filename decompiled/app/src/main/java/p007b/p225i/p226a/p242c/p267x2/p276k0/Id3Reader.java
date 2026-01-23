package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.util.Log;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.t, reason: use source file name */
/* JADX INFO: compiled from: Id3Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Id3Reader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: b */
    public TrackOutput2 f8865b;

    /* JADX INFO: renamed from: c */
    public boolean f8866c;

    /* JADX INFO: renamed from: e */
    public int f8868e;

    /* JADX INFO: renamed from: f */
    public int f8869f;

    /* JADX INFO: renamed from: a */
    public final ParsableByteArray f8864a = new ParsableByteArray(10);

    /* JADX INFO: renamed from: d */
    public long f8867d = -9223372036854775807L;

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: b */
    public void mo3758b(ParsableByteArray parsableByteArray) {
        AnimatableValueParser.m438H(this.f8865b);
        if (this.f8866c) {
            int iM3081a = parsableByteArray.m3081a();
            int i = this.f8869f;
            if (i < 10) {
                int iMin = Math.min(iM3081a, 10 - i);
                System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, this.f8864a.f6793a, this.f8869f, iMin);
                if (this.f8869f + iMin == 10) {
                    this.f8864a.m3079E(0);
                    if (73 != this.f8864a.m3100t() || 68 != this.f8864a.m3100t() || 51 != this.f8864a.m3100t()) {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.f8866c = false;
                        return;
                    } else {
                        this.f8864a.m3080F(3);
                        this.f8868e = this.f8864a.m3099s() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iM3081a, this.f8868e - this.f8869f);
            this.f8865b.mo2524c(parsableByteArray, iMin2);
            this.f8869f += iMin2;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: c */
    public void mo3759c() {
        this.f8866c = false;
        this.f8867d = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: d */
    public void mo3760d() {
        int i;
        AnimatableValueParser.m438H(this.f8865b);
        if (this.f8866c && (i = this.f8868e) != 0 && this.f8869f == i) {
            long j = this.f8867d;
            if (j != -9223372036854775807L) {
                this.f8865b.mo2525d(j, 1, i, 0, null);
            }
            this.f8866c = false;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: e */
    public void mo3761e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.m3765a();
        TrackOutput2 trackOutput2Mo2492p = extractorOutput.mo2492p(dVar.m3767c(), 5);
        this.f8865b = trackOutput2Mo2492p;
        Format2.b bVar = new Format2.b();
        bVar.f7163a = dVar.m3766b();
        bVar.f7173k = "application/id3";
        trackOutput2Mo2492p.mo2526e(bVar.m3277a());
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: f */
    public void mo3762f(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.f8866c = true;
        if (j != -9223372036854775807L) {
            this.f8867d = j;
        }
        this.f8868e = 0;
        this.f8869f = 0;
    }
}
