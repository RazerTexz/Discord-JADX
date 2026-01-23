package p007b.p225i.p226a.p242c.p267x2.p276k0;

import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.TimestampAdjuster;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.g0, reason: use source file name */
/* JADX INFO: compiled from: TsDurationReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TsDurationReader {

    /* JADX INFO: renamed from: a */
    public final int f8623a;

    /* JADX INFO: renamed from: d */
    public boolean f8626d;

    /* JADX INFO: renamed from: e */
    public boolean f8627e;

    /* JADX INFO: renamed from: f */
    public boolean f8628f;

    /* JADX INFO: renamed from: b */
    public final TimestampAdjuster f8624b = new TimestampAdjuster(0);

    /* JADX INFO: renamed from: g */
    public long f8629g = -9223372036854775807L;

    /* JADX INFO: renamed from: h */
    public long f8630h = -9223372036854775807L;

    /* JADX INFO: renamed from: i */
    public long f8631i = -9223372036854775807L;

    /* JADX INFO: renamed from: c */
    public final ParsableByteArray f8625c = new ParsableByteArray();

    public TsDurationReader(int i) {
        this.f8623a = i;
    }

    /* JADX INFO: renamed from: a */
    public final int m3763a(ExtractorInput extractorInput) {
        this.f8625c.m3076B(Util2.f6713f);
        this.f8626d = true;
        extractorInput.mo3649k();
        return 0;
    }
}
