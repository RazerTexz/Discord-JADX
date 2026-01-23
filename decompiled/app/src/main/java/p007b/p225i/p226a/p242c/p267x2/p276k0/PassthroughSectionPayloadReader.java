package p007b.p225i.p226a.p242c.p267x2.p276k0;

import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.TimestampAdjuster;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.x, reason: use source file name */
/* JADX INFO: compiled from: PassthroughSectionPayloadReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PassthroughSectionPayloadReader implements SectionPayloadReader {

    /* JADX INFO: renamed from: a */
    public Format2 f8908a;

    /* JADX INFO: renamed from: b */
    public TimestampAdjuster f8909b;

    /* JADX INFO: renamed from: c */
    public TrackOutput2 f8910c;

    public PassthroughSectionPayloadReader(String str) {
        Format2.b bVar = new Format2.b();
        bVar.f7173k = str;
        this.f8908a = bVar.m3277a();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.SectionPayloadReader
    /* JADX INFO: renamed from: a */
    public void mo3752a(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        this.f8909b = timestampAdjuster;
        dVar.m3765a();
        TrackOutput2 trackOutput2Mo2492p = extractorOutput.mo2492p(dVar.m3767c(), 5);
        this.f8910c = trackOutput2Mo2492p;
        trackOutput2Mo2492p.mo2526e(this.f8908a);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.SectionPayloadReader
    /* JADX INFO: renamed from: b */
    public void mo3753b(ParsableByteArray parsableByteArray) {
        long jM2974c;
        AnimatableValueParser.m438H(this.f8909b);
        int i = Util2.f6708a;
        TimestampAdjuster timestampAdjuster = this.f8909b;
        synchronized (timestampAdjuster) {
            long j = timestampAdjuster.f6702c;
            jM2974c = j != -9223372036854775807L ? j + timestampAdjuster.f6701b : timestampAdjuster.m2974c();
        }
        long jM2975d = this.f8909b.m2975d();
        if (jM2974c == -9223372036854775807L || jM2975d == -9223372036854775807L) {
            return;
        }
        Format2 format2 = this.f8908a;
        if (jM2975d != format2.f7127A) {
            Format2.b bVarM3275a = format2.m3275a();
            bVarM3275a.f7177o = jM2975d;
            Format2 format2M3277a = bVarM3275a.m3277a();
            this.f8908a = format2M3277a;
            this.f8910c.mo2526e(format2M3277a);
        }
        int iM3081a = parsableByteArray.m3081a();
        this.f8910c.mo2524c(parsableByteArray, iM3081a);
        this.f8910c.mo2525d(jM2974c, 1, iM3081a, 0, null);
    }
}
