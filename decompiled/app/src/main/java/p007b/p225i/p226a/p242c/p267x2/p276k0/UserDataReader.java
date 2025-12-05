package p007b.p225i.p226a.p242c.p267x2.p276k0;

import java.util.List;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* compiled from: UserDataReader.java */
/* renamed from: b.i.a.c.x2.k0.j0, reason: use source file name */
/* loaded from: classes3.dex */
public final class UserDataReader {

    /* renamed from: a */
    public final List<Format2> f8697a;

    /* renamed from: b */
    public final TrackOutput2[] f8698b;

    public UserDataReader(List<Format2> list) {
        this.f8697a = list;
        this.f8698b = new TrackOutput2[list.size()];
    }

    /* renamed from: a */
    public void m3769a(long j, ParsableByteArray parsableByteArray) {
        if (parsableByteArray.m3081a() < 9) {
            return;
        }
        int iM3086f = parsableByteArray.m3086f();
        int iM3086f2 = parsableByteArray.m3086f();
        int iM3100t = parsableByteArray.m3100t();
        if (iM3086f == 434 && iM3086f2 == 1195456820 && iM3100t == 3) {
            AnimatableValueParser.m447K(j, parsableByteArray, this.f8698b);
        }
    }

    /* renamed from: b */
    public void m3770b(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        for (int i = 0; i < this.f8698b.length; i++) {
            dVar.m3765a();
            TrackOutput2 trackOutput2Mo2492p = extractorOutput.mo2492p(dVar.m3767c(), 3);
            Format2 format2 = this.f8697a.get(i);
            String str = format2.f7155w;
            boolean z2 = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            String strValueOf = String.valueOf(str);
            AnimatableValueParser.m543m(z2, strValueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(strValueOf) : new String("Invalid closed caption mime type provided: "));
            Format2.b bVar = new Format2.b();
            bVar.f7163a = dVar.m3766b();
            bVar.f7173k = str;
            bVar.f7166d = format2.f7147o;
            bVar.f7165c = format2.f7146n;
            bVar.f7161C = format2.f7141O;
            bVar.f7175m = format2.f7157y;
            trackOutput2Mo2492p.mo2526e(bVar.m3277a());
            this.f8698b[i] = trackOutput2Mo2492p;
        }
    }
}
