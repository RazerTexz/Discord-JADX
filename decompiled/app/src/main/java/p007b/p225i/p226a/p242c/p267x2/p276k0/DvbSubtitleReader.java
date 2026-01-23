package p007b.p225i.p226a.p242c.p267x2.p276k0;

import java.util.Collections;
import java.util.List;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.n, reason: use source file name */
/* JADX INFO: compiled from: DvbSubtitleReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DvbSubtitleReader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a */
    public final List<TsPayloadReader.a> f8734a;

    /* JADX INFO: renamed from: b */
    public final TrackOutput2[] f8735b;

    /* JADX INFO: renamed from: c */
    public boolean f8736c;

    /* JADX INFO: renamed from: d */
    public int f8737d;

    /* JADX INFO: renamed from: e */
    public int f8738e;

    /* JADX INFO: renamed from: f */
    public long f8739f = -9223372036854775807L;

    public DvbSubtitleReader(List<TsPayloadReader.a> list) {
        this.f8734a = list;
        this.f8735b = new TrackOutput2[list.size()];
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3778a(ParsableByteArray parsableByteArray, int i) {
        if (parsableByteArray.m3081a() == 0) {
            return false;
        }
        if (parsableByteArray.m3100t() != i) {
            this.f8736c = false;
        }
        this.f8737d--;
        return this.f8736c;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: b */
    public void mo3758b(ParsableByteArray parsableByteArray) {
        if (this.f8736c) {
            if (this.f8737d != 2 || m3778a(parsableByteArray, 32)) {
                if (this.f8737d != 1 || m3778a(parsableByteArray, 0)) {
                    int i = parsableByteArray.f6794b;
                    int iM3081a = parsableByteArray.m3081a();
                    for (TrackOutput2 trackOutput2 : this.f8735b) {
                        parsableByteArray.m3079E(i);
                        trackOutput2.mo2524c(parsableByteArray, iM3081a);
                    }
                    this.f8738e += iM3081a;
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: c */
    public void mo3759c() {
        this.f8736c = false;
        this.f8739f = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: d */
    public void mo3760d() {
        if (this.f8736c) {
            if (this.f8739f != -9223372036854775807L) {
                for (TrackOutput2 trackOutput2 : this.f8735b) {
                    trackOutput2.mo2525d(this.f8739f, 1, this.f8738e, 0, null);
                }
            }
            this.f8736c = false;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: e */
    public void mo3761e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        for (int i = 0; i < this.f8735b.length; i++) {
            TsPayloadReader.a aVar = this.f8734a.get(i);
            dVar.m3765a();
            TrackOutput2 trackOutput2Mo2492p = extractorOutput.mo2492p(dVar.m3767c(), 3);
            Format2.b bVar = new Format2.b();
            bVar.f7163a = dVar.m3766b();
            bVar.f7173k = "application/dvbsubs";
            bVar.f7175m = Collections.singletonList(aVar.f8675b);
            bVar.f7165c = aVar.f8674a;
            trackOutput2Mo2492p.mo2526e(bVar.m3277a());
            this.f8735b[i] = trackOutput2Mo2492p;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: f */
    public void mo3762f(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.f8736c = true;
        if (j != -9223372036854775807L) {
            this.f8739f = j;
        }
        this.f8738e = 0;
        this.f8737d = 2;
    }
}
