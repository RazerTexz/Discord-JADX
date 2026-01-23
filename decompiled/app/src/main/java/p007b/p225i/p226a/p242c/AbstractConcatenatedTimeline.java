package p007b.p225i.p226a.p242c;

import android.util.Pair;
import java.util.Objects;
import p007b.p225i.p226a.p242c.Timeline;
import p007b.p225i.p226a.p242c.p243a3.ShuffleOrder;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.r0, reason: use source file name */
/* JADX INFO: compiled from: AbstractConcatenatedTimeline.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractConcatenatedTimeline extends Timeline {

    /* JADX INFO: renamed from: k */
    public final int f7462k;

    /* JADX INFO: renamed from: l */
    public final ShuffleOrder f7463l;

    /* JADX INFO: renamed from: m */
    public final boolean f7464m;

    public AbstractConcatenatedTimeline(boolean z2, ShuffleOrder shuffleOrder) {
        this.f7464m = z2;
        this.f7463l = shuffleOrder;
        this.f7462k = shuffleOrder.mo2544b();
    }

    @Override // p007b.p225i.p226a.p242c.Timeline
    /* JADX INFO: renamed from: a */
    public int mo2582a(boolean z2) {
        if (this.f7462k == 0) {
            return -1;
        }
        if (this.f7464m) {
            z2 = false;
        }
        int iMo2545c = z2 ? this.f7463l.mo2545c() : 0;
        do {
            PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
            if (!playlistTimeline.f6174r[iMo2545c].m3331q()) {
                return playlistTimeline.f6174r[iMo2545c].mo2582a(z2) + playlistTimeline.f6173q[iMo2545c];
            }
            iMo2545c = m3358r(iMo2545c, z2);
        } while (iMo2545c != -1);
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.Timeline
    /* JADX INFO: renamed from: b */
    public final int mo2554b(Object obj) {
        int iMo2554b;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
        Integer num = playlistTimeline.f6176t.get(obj2);
        int iIntValue = num == null ? -1 : num.intValue();
        if (iIntValue == -1 || (iMo2554b = playlistTimeline.f6174r[iIntValue].mo2554b(obj3)) == -1) {
            return -1;
        }
        return playlistTimeline.f6172p[iIntValue] + iMo2554b;
    }

    @Override // p007b.p225i.p226a.p242c.Timeline
    /* JADX INFO: renamed from: c */
    public int mo2583c(boolean z2) {
        int i = this.f7462k;
        if (i == 0) {
            return -1;
        }
        if (this.f7464m) {
            z2 = false;
        }
        int iMo2549g = z2 ? this.f7463l.mo2549g() : i - 1;
        do {
            PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
            if (!playlistTimeline.f6174r[iMo2549g].m3331q()) {
                return playlistTimeline.f6174r[iMo2549g].mo2583c(z2) + playlistTimeline.f6173q[iMo2549g];
            }
            iMo2549g = m3359s(iMo2549g, z2);
        } while (iMo2549g != -1);
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.Timeline
    /* JADX INFO: renamed from: e */
    public int mo2584e(int i, int i2, boolean z2) {
        if (this.f7464m) {
            if (i2 == 1) {
                i2 = 2;
            }
            z2 = false;
        }
        PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
        int iM2996d = Util2.m2996d(playlistTimeline.f6173q, i + 1, false, false);
        int i3 = playlistTimeline.f6173q[iM2996d];
        int iMo2584e = playlistTimeline.f6174r[iM2996d].mo2584e(i - i3, i2 != 2 ? i2 : 0, z2);
        if (iMo2584e != -1) {
            return i3 + iMo2584e;
        }
        int iM3358r = m3358r(iM2996d, z2);
        while (iM3358r != -1 && playlistTimeline.f6174r[iM3358r].m3331q()) {
            iM3358r = m3358r(iM3358r, z2);
        }
        if (iM3358r != -1) {
            return playlistTimeline.f6174r[iM3358r].mo2582a(z2) + playlistTimeline.f6173q[iM3358r];
        }
        if (i2 == 2) {
            return mo2582a(z2);
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.Timeline
    /* JADX INFO: renamed from: g */
    public final Timeline.b mo2513g(int i, Timeline.b bVar, boolean z2) {
        PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
        int iM2996d = Util2.m2996d(playlistTimeline.f6172p, i + 1, false, false);
        int i2 = playlistTimeline.f6173q[iM2996d];
        playlistTimeline.f6174r[iM2996d].mo2513g(i - playlistTimeline.f6172p[iM2996d], bVar, z2);
        bVar.f7340l += i2;
        if (z2) {
            Object obj = playlistTimeline.f6175s[iM2996d];
            Object obj2 = bVar.f7339k;
            Objects.requireNonNull(obj2);
            bVar.f7339k = Pair.create(obj, obj2);
        }
        return bVar;
    }

    @Override // p007b.p225i.p226a.p242c.Timeline
    /* JADX INFO: renamed from: h */
    public final Timeline.b mo3327h(Object obj, Timeline.b bVar) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
        Integer num = playlistTimeline.f6176t.get(obj2);
        int iIntValue = num == null ? -1 : num.intValue();
        int i = playlistTimeline.f6173q[iIntValue];
        playlistTimeline.f6174r[iIntValue].mo3327h(obj3, bVar);
        bVar.f7340l += i;
        bVar.f7339k = obj;
        return bVar;
    }

    @Override // p007b.p225i.p226a.p242c.Timeline
    /* JADX INFO: renamed from: l */
    public int mo2585l(int i, int i2, boolean z2) {
        if (this.f7464m) {
            if (i2 == 1) {
                i2 = 2;
            }
            z2 = false;
        }
        PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
        int iM2996d = Util2.m2996d(playlistTimeline.f6173q, i + 1, false, false);
        int i3 = playlistTimeline.f6173q[iM2996d];
        int iMo2585l = playlistTimeline.f6174r[iM2996d].mo2585l(i - i3, i2 != 2 ? i2 : 0, z2);
        if (iMo2585l != -1) {
            return i3 + iMo2585l;
        }
        int iM3359s = m3359s(iM2996d, z2);
        while (iM3359s != -1 && playlistTimeline.f6174r[iM3359s].m3331q()) {
            iM3359s = m3359s(iM3359s, z2);
        }
        if (iM3359s != -1) {
            return playlistTimeline.f6174r[iM3359s].mo2583c(z2) + playlistTimeline.f6173q[iM3359s];
        }
        if (i2 == 2) {
            return mo2583c(z2);
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.Timeline
    /* JADX INFO: renamed from: m */
    public final Object mo2556m(int i) {
        PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
        int iM2996d = Util2.m2996d(playlistTimeline.f6172p, i + 1, false, false);
        return Pair.create(playlistTimeline.f6175s[iM2996d], playlistTimeline.f6174r[iM2996d].mo2556m(i - playlistTimeline.f6172p[iM2996d]));
    }

    @Override // p007b.p225i.p226a.p242c.Timeline
    /* JADX INFO: renamed from: o */
    public final Timeline.c mo2514o(int i, Timeline.c cVar, long j) {
        PlaylistTimeline playlistTimeline = (PlaylistTimeline) this;
        int iM2996d = Util2.m2996d(playlistTimeline.f6173q, i + 1, false, false);
        int i2 = playlistTimeline.f6173q[iM2996d];
        int i3 = playlistTimeline.f6172p[iM2996d];
        playlistTimeline.f6174r[iM2996d].mo2514o(i - i2, cVar, j);
        Object objCreate = playlistTimeline.f6175s[iM2996d];
        if (!Timeline.c.f7345j.equals(cVar.f7353n)) {
            objCreate = Pair.create(objCreate, cVar.f7353n);
        }
        cVar.f7353n = objCreate;
        cVar.f7350B += i3;
        cVar.f7351C += i3;
        return cVar;
    }

    /* JADX INFO: renamed from: r */
    public final int m3358r(int i, boolean z2) {
        if (z2) {
            return this.f7463l.mo2547e(i);
        }
        if (i < this.f7462k - 1) {
            return i + 1;
        }
        return -1;
    }

    /* JADX INFO: renamed from: s */
    public final int m3359s(int i, boolean z2) {
        if (z2) {
            return this.f7463l.mo2546d(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }
}
