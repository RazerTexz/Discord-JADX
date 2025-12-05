package p007b.p225i.p226a.p242c.p267x2.p273h0;

import android.util.Pair;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.SeekPoint;

/* compiled from: MlltSeeker.java */
/* renamed from: b.i.a.c.x2.h0.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class MlltSeeker implements Seeker {

    /* renamed from: a */
    public final long[] f8312a;

    /* renamed from: b */
    public final long[] f8313b;

    /* renamed from: c */
    public final long f8314c;

    public MlltSeeker(long[] jArr, long[] jArr2, long j) {
        this.f8312a = jArr;
        this.f8313b = jArr2;
        this.f8314c = j == -9223372036854775807L ? Util2.m2981B(jArr2[jArr2.length - 1]) : j;
    }

    /* renamed from: b */
    public static Pair<Long, Long> m3692b(long j, long[] jArr, long[] jArr2) {
        int iM2997e = Util2.m2997e(jArr, j, true, true);
        long j2 = jArr[iM2997e];
        long j3 = jArr2[iM2997e];
        int i = iM2997e + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((jArr[i] == j2 ? 0.0d : (j - j2) / (r6 - j2)) * (jArr2[i] - j3))) + j3));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.Seeker
    /* renamed from: a */
    public long mo3689a() {
        return -1L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: c */
    public boolean mo3619c() {
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.Seeker
    /* renamed from: d */
    public long mo3690d(long j) {
        return Util2.m2981B(((Long) m3692b(j, this.f8312a, this.f8313b).second).longValue());
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: h */
    public SeekMap.a mo3620h(long j) {
        Pair<Long, Long> pairM3692b = m3692b(Util2.m2992M(Util2.m3001i(j, 0L, this.f8314c)), this.f8313b, this.f8312a);
        return new SeekMap.a(new SeekPoint(Util2.m2981B(((Long) pairM3692b.first).longValue()), ((Long) pairM3692b.second).longValue()));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: i */
    public long mo3621i() {
        return this.f8314c;
    }
}
