package p007b.p225i.p226a.p242c.p267x2.p277l0;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.SeekPoint;

/* compiled from: WavSeekMap.java */
/* renamed from: b.i.a.c.x2.l0.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class WavSeekMap implements SeekMap {

    /* renamed from: a */
    public final WavFormat f8962a;

    /* renamed from: b */
    public final int f8963b;

    /* renamed from: c */
    public final long f8964c;

    /* renamed from: d */
    public final long f8965d;

    /* renamed from: e */
    public final long f8966e;

    public WavSeekMap(WavFormat wavFormat, int i, long j, long j2) {
        this.f8962a = wavFormat;
        this.f8963b = i;
        this.f8964c = j;
        long j3 = (j2 - j) / wavFormat.f8957d;
        this.f8965d = j3;
        this.f8966e = m3801b(j3);
    }

    /* renamed from: b */
    public final long m3801b(long j) {
        return Util2.m2985F(j * this.f8963b, 1000000L, this.f8962a.f8956c);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: c */
    public boolean mo3619c() {
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: h */
    public SeekMap.a mo3620h(long j) {
        long jM3001i = Util2.m3001i((this.f8962a.f8956c * j) / (this.f8963b * 1000000), 0L, this.f8965d - 1);
        long j2 = (this.f8962a.f8957d * jM3001i) + this.f8964c;
        long jM3801b = m3801b(jM3001i);
        SeekPoint seekPoint = new SeekPoint(jM3801b, j2);
        if (jM3801b >= j || jM3001i == this.f8965d - 1) {
            return new SeekMap.a(seekPoint);
        }
        long j3 = jM3001i + 1;
        return new SeekMap.a(seekPoint, new SeekPoint(m3801b(j3), (this.f8962a.f8957d * j3) + this.f8964c));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: i */
    public long mo3621i() {
        return this.f8966e;
    }
}
