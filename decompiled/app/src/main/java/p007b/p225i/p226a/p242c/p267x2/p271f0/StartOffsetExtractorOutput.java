package p007b.p225i.p226a.p242c.p267x2.p271f0;

import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.SeekPoint;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;

/* compiled from: StartOffsetExtractorOutput.java */
/* renamed from: b.i.a.c.x2.f0.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class StartOffsetExtractorOutput implements ExtractorOutput {

    /* renamed from: j */
    public final long f8172j;

    /* renamed from: k */
    public final ExtractorOutput f8173k;

    /* compiled from: StartOffsetExtractorOutput.java */
    /* renamed from: b.i.a.c.x2.f0.d$a */
    public class a implements SeekMap {

        /* renamed from: a */
        public final /* synthetic */ SeekMap f8174a;

        public a(SeekMap seekMap) {
            this.f8174a = seekMap;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
        /* renamed from: c */
        public boolean mo3619c() {
            return this.f8174a.mo3619c();
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
        /* renamed from: h */
        public SeekMap.a mo3620h(long j) {
            SeekMap.a aVarMo3620h = this.f8174a.mo3620h(j);
            SeekPoint seekPoint = aVarMo3620h.f8993a;
            long j2 = seekPoint.f8998b;
            long j3 = seekPoint.f8999c;
            long j4 = StartOffsetExtractorOutput.this.f8172j;
            SeekPoint seekPoint2 = new SeekPoint(j2, j3 + j4);
            SeekPoint seekPoint3 = aVarMo3620h.f8994b;
            return new SeekMap.a(seekPoint2, new SeekPoint(seekPoint3.f8998b, seekPoint3.f8999c + j4));
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
        /* renamed from: i */
        public long mo3621i() {
            return this.f8174a.mo3621i();
        }
    }

    public StartOffsetExtractorOutput(long j, ExtractorOutput extractorOutput) {
        this.f8172j = j;
        this.f8173k = extractorOutput;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorOutput
    /* renamed from: a */
    public void mo2477a(SeekMap seekMap) {
        this.f8173k.mo2477a(new a(seekMap));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorOutput
    /* renamed from: j */
    public void mo2486j() {
        this.f8173k.mo2486j();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorOutput
    /* renamed from: p */
    public TrackOutput2 mo2492p(int i, int i2) {
        return this.f8173k.mo2492p(i, i2);
    }
}
