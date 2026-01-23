package p007b.p225i.p226a.p242c.p267x2;

import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.FlacStreamMetadata;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;

/* JADX INFO: renamed from: b.i.a.c.x2.n, reason: use source file name */
/* JADX INFO: compiled from: FlacSeekTableSeekMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FlacSeekTableSeekMap implements SeekMap {

    /* JADX INFO: renamed from: a */
    public final FlacStreamMetadata f8968a;

    /* JADX INFO: renamed from: b */
    public final long f8969b;

    public FlacSeekTableSeekMap(FlacStreamMetadata flacStreamMetadata, long j) {
        this.f8968a = flacStreamMetadata;
        this.f8969b = j;
    }

    /* JADX INFO: renamed from: b */
    public final SeekPoint m3805b(long j, long j2) {
        return new SeekPoint((j * 1000000) / ((long) this.f8968a.f8974e), this.f8969b + j2);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* JADX INFO: renamed from: c */
    public boolean mo3619c() {
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* JADX INFO: renamed from: h */
    public SeekMap.a mo3620h(long j) {
        AnimatableValueParser.m438H(this.f8968a.f8980k);
        FlacStreamMetadata flacStreamMetadata = this.f8968a;
        FlacStreamMetadata.a aVar = flacStreamMetadata.f8980k;
        long[] jArr = aVar.f8982a;
        long[] jArr2 = aVar.f8983b;
        int iM2997e = Util2.m2997e(jArr, flacStreamMetadata.m3813g(j), true, false);
        SeekPoint seekPointM3805b = m3805b(iM2997e == -1 ? 0L : jArr[iM2997e], iM2997e != -1 ? jArr2[iM2997e] : 0L);
        if (seekPointM3805b.f8998b == j || iM2997e == jArr.length - 1) {
            return new SeekMap.a(seekPointM3805b);
        }
        int i = iM2997e + 1;
        return new SeekMap.a(seekPointM3805b, m3805b(jArr[i], jArr2[i]));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* JADX INFO: renamed from: i */
    public long mo3621i() {
        return this.f8968a.m3810d();
    }
}
