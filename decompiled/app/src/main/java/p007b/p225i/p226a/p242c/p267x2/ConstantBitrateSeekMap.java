package p007b.p225i.p226a.p242c.p267x2;

import p007b.p225i.p226a.p242c.p267x2.SeekMap;

/* compiled from: ConstantBitrateSeekMap.java */
/* renamed from: b.i.a.c.x2.d, reason: use source file name */
/* loaded from: classes3.dex */
public class ConstantBitrateSeekMap implements SeekMap {

    /* renamed from: a */
    public final long f8088a;

    /* renamed from: b */
    public final long f8089b;

    /* renamed from: c */
    public final int f8090c;

    /* renamed from: d */
    public final long f8091d;

    /* renamed from: e */
    public final int f8092e;

    /* renamed from: f */
    public final long f8093f;

    /* renamed from: g */
    public final boolean f8094g;

    public ConstantBitrateSeekMap(long j, long j2, int i, int i2, boolean z2) {
        this.f8088a = j;
        this.f8089b = j2;
        this.f8090c = i2 == -1 ? 1 : i2;
        this.f8092e = i;
        this.f8094g = z2;
        if (j == -1) {
            this.f8091d = -1L;
            this.f8093f = -9223372036854775807L;
        } else {
            this.f8091d = j - j2;
            this.f8093f = m3638e(j, j2, i);
        }
    }

    /* renamed from: e */
    public static long m3638e(long j, long j2, int i) {
        return ((Math.max(0L, j - j2) * 8) * 1000000) / i;
    }

    /* renamed from: b */
    public long m3639b(long j) {
        return m3638e(j, this.f8089b, this.f8092e);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: c */
    public boolean mo3619c() {
        return this.f8091d != -1 || this.f8094g;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: h */
    public SeekMap.a mo3620h(long j) {
        long j2 = this.f8091d;
        if (j2 == -1 && !this.f8094g) {
            return new SeekMap.a(new SeekPoint(0L, this.f8089b));
        }
        long j3 = this.f8090c;
        long jMin = (((this.f8092e * j) / 8000000) / j3) * j3;
        if (j2 != -1) {
            jMin = Math.min(jMin, j2 - j3);
        }
        long jMax = this.f8089b + Math.max(jMin, 0L);
        long jM3639b = m3639b(jMax);
        SeekPoint seekPoint = new SeekPoint(jM3639b, jMax);
        if (this.f8091d != -1 && jM3639b < j) {
            int i = this.f8090c;
            if (i + jMax < this.f8088a) {
                long j4 = jMax + i;
                return new SeekMap.a(seekPoint, new SeekPoint(m3639b(j4), j4));
            }
        }
        return new SeekMap.a(seekPoint);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: i */
    public long mo3621i() {
        return this.f8093f;
    }
}
