package p007b.p225i.p226a.p242c.p267x2.p273h0;

import p007b.p225i.p226a.p242c.p259f3.LongArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.SeekPoint;

/* JADX INFO: renamed from: b.i.a.c.x2.h0.d, reason: use source file name */
/* JADX INFO: compiled from: IndexSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class IndexSeeker implements Seeker {

    /* JADX INFO: renamed from: a */
    public final long f8308a;

    /* JADX INFO: renamed from: b */
    public final LongArray f8309b;

    /* JADX INFO: renamed from: c */
    public final LongArray f8310c;

    /* JADX INFO: renamed from: d */
    public long f8311d;

    public IndexSeeker(long j, long j2, long j3) {
        this.f8311d = j;
        this.f8308a = j3;
        LongArray longArray = new LongArray();
        this.f8309b = longArray;
        LongArray longArray2 = new LongArray();
        this.f8310c = longArray2;
        longArray.m3041a(0L);
        longArray2.m3041a(j2);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.Seeker
    /* JADX INFO: renamed from: a */
    public long mo3689a() {
        return this.f8308a;
    }

    /* JADX INFO: renamed from: b */
    public boolean m3691b(long j) {
        LongArray longArray = this.f8309b;
        return j - longArray.m3042b(longArray.f6747a - 1) < 100000;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* JADX INFO: renamed from: c */
    public boolean mo3619c() {
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.Seeker
    /* JADX INFO: renamed from: d */
    public long mo3690d(long j) {
        return this.f8309b.m3042b(Util2.m2995c(this.f8310c, j, true, true));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* JADX INFO: renamed from: h */
    public SeekMap.a mo3620h(long j) {
        int iM2995c = Util2.m2995c(this.f8309b, j, true, true);
        long jM3042b = this.f8309b.m3042b(iM2995c);
        SeekPoint seekPoint = new SeekPoint(jM3042b, this.f8310c.m3042b(iM2995c));
        if (jM3042b != j) {
            LongArray longArray = this.f8309b;
            if (iM2995c != longArray.f6747a - 1) {
                int i = iM2995c + 1;
                return new SeekMap.a(seekPoint, new SeekPoint(longArray.m3042b(i), this.f8310c.m3042b(i)));
            }
        }
        return new SeekMap.a(seekPoint);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* JADX INFO: renamed from: i */
    public long mo3621i() {
        return this.f8311d;
    }
}
