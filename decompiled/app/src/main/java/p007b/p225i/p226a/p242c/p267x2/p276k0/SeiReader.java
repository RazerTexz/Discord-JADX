package p007b.p225i.p226a.p242c.p267x2.p276k0;

import java.util.List;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* compiled from: SeiReader.java */
/* renamed from: b.i.a.c.x2.k0.e0, reason: use source file name */
/* loaded from: classes3.dex */
public final class SeiReader {

    /* renamed from: a */
    public final List<Format2> f8602a;

    /* renamed from: b */
    public final TrackOutput2[] f8603b;

    public SeiReader(List<Format2> list) {
        this.f8602a = list;
        this.f8603b = new TrackOutput2[list.size()];
    }

    /* renamed from: a */
    public void m3757a(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        for (int i = 0; i < this.f8603b.length; i++) {
            dVar.m3765a();
            TrackOutput2 trackOutput2Mo2492p = extractorOutput.mo2492p(dVar.m3767c(), 3);
            Format2 format2 = this.f8602a.get(i);
            String str = format2.f7155w;
            boolean z2 = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            String strValueOf = String.valueOf(str);
            AnimatableValueParser.m543m(z2, strValueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(strValueOf) : new String("Invalid closed caption mime type provided: "));
            String strM3766b = format2.f7144l;
            if (strM3766b == null) {
                strM3766b = dVar.m3766b();
            }
            Format2.b bVar = new Format2.b();
            bVar.f7163a = strM3766b;
            bVar.f7173k = str;
            bVar.f7166d = format2.f7147o;
            bVar.f7165c = format2.f7146n;
            bVar.f7161C = format2.f7141O;
            bVar.f7175m = format2.f7157y;
            trackOutput2Mo2492p.mo2526e(bVar.m3277a());
            this.f8603b[i] = trackOutput2Mo2492p;
        }
    }
}
