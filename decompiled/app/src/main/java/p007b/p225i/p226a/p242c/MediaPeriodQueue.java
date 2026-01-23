package p007b.p225i.p226a.p242c;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Timeline;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p243a3.p244p0.AdPlaybackState;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsCollector;
import p007b.p225i.p355b.p357b.AbstractIndexedListIterator;
import p007b.p225i.p355b.p357b.ImmutableList2;

/* JADX INFO: renamed from: b.i.a.c.s1, reason: use source file name */
/* JADX INFO: compiled from: MediaPeriodQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaPeriodQueue {

    /* JADX INFO: renamed from: a */
    public final Timeline.b f7486a = new Timeline.b();

    /* JADX INFO: renamed from: b */
    public final Timeline.c f7487b = new Timeline.c();

    /* JADX INFO: renamed from: c */
    @Nullable
    public final AnalyticsCollector f7488c;

    /* JADX INFO: renamed from: d */
    public final Handler f7489d;

    /* JADX INFO: renamed from: e */
    public long f7490e;

    /* JADX INFO: renamed from: f */
    public int f7491f;

    /* JADX INFO: renamed from: g */
    public boolean f7492g;

    /* JADX INFO: renamed from: h */
    @Nullable
    public MediaPeriodHolder f7493h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public MediaPeriodHolder f7494i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public MediaPeriodHolder f7495j;

    /* JADX INFO: renamed from: k */
    public int f7496k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public Object f7497l;

    /* JADX INFO: renamed from: m */
    public long f7498m;

    public MediaPeriodQueue(@Nullable AnalyticsCollector analyticsCollector, Handler handler) {
        this.f7488c = analyticsCollector;
        this.f7489d = handler;
    }

    /* JADX INFO: renamed from: p */
    public static MediaSource2.a m3364p(Timeline timeline, Object obj, long j, long j2, Timeline.b bVar) {
        timeline.mo3327h(obj, bVar);
        AdPlaybackState adPlaybackState = bVar.f7344p;
        long j3 = bVar.f7341m;
        int i = adPlaybackState.f5684n - 1;
        while (i >= 0) {
            boolean z2 = false;
            if (j != Long.MIN_VALUE) {
                long j4 = adPlaybackState.m2578a(i).f5690k;
                if (j4 != Long.MIN_VALUE ? j < j4 : !(j3 != -9223372036854775807L && j >= j3)) {
                    z2 = true;
                }
            }
            if (!z2) {
                break;
            }
            i--;
        }
        if (i < 0 || !adPlaybackState.m2578a(i).m2581b()) {
            i = -1;
        }
        if (i == -1) {
            return new MediaSource2.a(obj, j2, bVar.m3333b(j));
        }
        return new MediaSource2.a(obj, i, bVar.m3335d(i), j2);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public MediaPeriodHolder m3365a() {
        MediaPeriodHolder mediaPeriodHolder = this.f7493h;
        if (mediaPeriodHolder == null) {
            return null;
        }
        if (mediaPeriodHolder == this.f7494i) {
            this.f7494i = mediaPeriodHolder.f7453l;
        }
        mediaPeriodHolder.m3354h();
        int i = this.f7496k - 1;
        this.f7496k = i;
        if (i == 0) {
            this.f7495j = null;
            MediaPeriodHolder mediaPeriodHolder2 = this.f7493h;
            this.f7497l = mediaPeriodHolder2.f7443b;
            this.f7498m = mediaPeriodHolder2.f7447f.f7465a.f5735d;
        }
        this.f7493h = this.f7493h.f7453l;
        m3376l();
        return this.f7493h;
    }

    /* JADX INFO: renamed from: b */
    public void m3366b() {
        if (this.f7496k == 0) {
            return;
        }
        MediaPeriodHolder mediaPeriodHolder = this.f7493h;
        AnimatableValueParser.m438H(mediaPeriodHolder);
        MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodHolder;
        this.f7497l = mediaPeriodHolder2.f7443b;
        this.f7498m = mediaPeriodHolder2.f7447f.f7465a.f5735d;
        while (mediaPeriodHolder2 != null) {
            mediaPeriodHolder2.m3354h();
            mediaPeriodHolder2 = mediaPeriodHolder2.f7453l;
        }
        this.f7493h = null;
        this.f7495j = null;
        this.f7494i = null;
        this.f7496k = 0;
        m3376l();
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public final MediaPeriodInfo m3367c(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j) {
        long j2;
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f7447f;
        long j3 = (mediaPeriodHolder.f7456o + mediaPeriodInfo.f7469e) - j;
        long j4 = 0;
        if (mediaPeriodInfo.f7471g) {
            int iM3325d = timeline.m3325d(timeline.mo2554b(mediaPeriodInfo.f7465a.f5732a), this.f7486a, this.f7487b, this.f7491f, this.f7492g);
            if (iM3325d == -1) {
                return null;
            }
            int i = timeline.mo2513g(iM3325d, this.f7486a, true).f7340l;
            Object obj = this.f7486a.f7339k;
            long j5 = mediaPeriodInfo.f7465a.f5735d;
            if (timeline.m3330n(i, this.f7487b).f7350B == iM3325d) {
                Pair<Object, Long> pairM3329k = timeline.m3329k(this.f7487b, this.f7486a, i, -9223372036854775807L, Math.max(0L, j3));
                if (pairM3329k == null) {
                    return null;
                }
                obj = pairM3329k.first;
                long jLongValue = ((Long) pairM3329k.second).longValue();
                MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodHolder.f7453l;
                if (mediaPeriodHolder2 == null || !mediaPeriodHolder2.f7443b.equals(obj)) {
                    j5 = this.f7490e;
                    this.f7490e = 1 + j5;
                } else {
                    j5 = mediaPeriodHolder2.f7447f.f7465a.f5735d;
                }
                j2 = jLongValue;
                j4 = -9223372036854775807L;
            } else {
                j2 = 0;
            }
            return m3368d(timeline, m3364p(timeline, obj, j2, j5, this.f7486a), j4, j2);
        }
        MediaSource2.a aVar = mediaPeriodInfo.f7465a;
        timeline.mo3327h(aVar.f5732a, this.f7486a);
        if (!aVar.m2593a()) {
            int iM3335d = this.f7486a.m3335d(aVar.f5736e);
            if (iM3335d != this.f7486a.f7344p.m2578a(aVar.f5736e).f5691l) {
                return m3369e(timeline, aVar.f5732a, aVar.f5736e, iM3335d, mediaPeriodInfo.f7469e, aVar.f5735d);
            }
            return m3370f(timeline, aVar.f5732a, m3371g(timeline, aVar.f5732a, aVar.f5736e), mediaPeriodInfo.f7469e, aVar.f5735d);
        }
        int i2 = aVar.f5733b;
        int i3 = this.f7486a.f7344p.m2578a(i2).f5691l;
        if (i3 == -1) {
            return null;
        }
        int iM2580a = this.f7486a.f7344p.m2578a(i2).m2580a(aVar.f5734c);
        if (iM2580a < i3) {
            return m3369e(timeline, aVar.f5732a, i2, iM2580a, mediaPeriodInfo.f7467c, aVar.f5735d);
        }
        long jLongValue2 = mediaPeriodInfo.f7467c;
        if (jLongValue2 == -9223372036854775807L) {
            Timeline.c cVar = this.f7487b;
            Timeline.b bVar = this.f7486a;
            Pair<Object, Long> pairM3329k2 = timeline.m3329k(cVar, bVar, bVar.f7340l, -9223372036854775807L, Math.max(0L, j3));
            if (pairM3329k2 == null) {
                return null;
            }
            jLongValue2 = ((Long) pairM3329k2.second).longValue();
        }
        return m3370f(timeline, aVar.f5732a, Math.max(m3371g(timeline, aVar.f5732a, aVar.f5733b), jLongValue2), mediaPeriodInfo.f7467c, aVar.f5735d);
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public final MediaPeriodInfo m3368d(Timeline timeline, MediaSource2.a aVar, long j, long j2) {
        timeline.mo3327h(aVar.f5732a, this.f7486a);
        return aVar.m2593a() ? m3369e(timeline, aVar.f5732a, aVar.f5733b, aVar.f5734c, j, aVar.f5735d) : m3370f(timeline, aVar.f5732a, j2, j, aVar.f5735d);
    }

    /* JADX INFO: renamed from: e */
    public final MediaPeriodInfo m3369e(Timeline timeline, Object obj, int i, int i2, long j, long j2) {
        MediaSource2.a aVar = new MediaSource2.a(obj, i, i2, j2);
        long jM3332a = timeline.mo3327h(obj, this.f7486a).m3332a(i, i2);
        long j3 = i2 == this.f7486a.f7344p.m2578a(i).m2580a(-1) ? this.f7486a.f7344p.f5685o : 0L;
        return new MediaPeriodInfo(aVar, (jM3332a == -9223372036854775807L || j3 < jM3332a) ? j3 : Math.max(0L, jM3332a - 1), j, -9223372036854775807L, jM3332a, this.f7486a.f7344p.m2578a(i).f5696q, false, false, false);
    }

    /* JADX INFO: renamed from: f */
    public final MediaPeriodInfo m3370f(Timeline timeline, Object obj, long j, long j2, long j3) {
        long jMax = j;
        timeline.mo3327h(obj, this.f7486a);
        int iM3333b = this.f7486a.m3333b(jMax);
        MediaSource2.a aVar = new MediaSource2.a(obj, j3, iM3333b);
        boolean zM3373i = m3373i(aVar);
        boolean zM3375k = m3375k(timeline, aVar);
        boolean zM3374j = m3374j(timeline, aVar, zM3373i);
        boolean z2 = iM3333b != -1 && this.f7486a.m3336e(iM3333b);
        long jM3334c = iM3333b != -1 ? this.f7486a.m3334c(iM3333b) : -9223372036854775807L;
        long j4 = (jM3334c == -9223372036854775807L || jM3334c == Long.MIN_VALUE) ? this.f7486a.f7341m : jM3334c;
        if (j4 != -9223372036854775807L && jMax >= j4) {
            jMax = Math.max(0L, j4 - 1);
        }
        return new MediaPeriodInfo(aVar, jMax, j2, jM3334c, j4, z2, zM3373i, zM3375k, zM3374j);
    }

    /* JADX INFO: renamed from: g */
    public final long m3371g(Timeline timeline, Object obj, int i) {
        timeline.mo3327h(obj, this.f7486a);
        long j = this.f7486a.f7344p.m2578a(i).f5690k;
        return j == Long.MIN_VALUE ? this.f7486a.f7341m : j + this.f7486a.f7344p.m2578a(i).f5695p;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /* JADX INFO: renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MediaPeriodInfo m3372h(Timeline timeline, MediaPeriodInfo mediaPeriodInfo) {
        long jM3332a;
        long j;
        boolean zM3336e;
        int i;
        MediaSource2.a aVar = mediaPeriodInfo.f7465a;
        boolean zM3373i = m3373i(aVar);
        boolean zM3375k = m3375k(timeline, aVar);
        boolean zM3374j = m3374j(timeline, aVar, zM3373i);
        timeline.mo3327h(mediaPeriodInfo.f7465a.f5732a, this.f7486a);
        long jM3334c = (aVar.m2593a() || (i = aVar.f5736e) == -1) ? -9223372036854775807L : this.f7486a.m3334c(i);
        if (aVar.m2593a()) {
            jM3332a = this.f7486a.m3332a(aVar.f5733b, aVar.f5734c);
        } else {
            if (jM3334c != -9223372036854775807L && jM3334c != Long.MIN_VALUE) {
                j = jM3334c;
                if (aVar.m2593a()) {
                    int i2 = aVar.f5736e;
                    zM3336e = i2 != -1 && this.f7486a.m3336e(i2);
                } else {
                    zM3336e = this.f7486a.m3336e(aVar.f5733b);
                }
                return new MediaPeriodInfo(aVar, mediaPeriodInfo.f7466b, mediaPeriodInfo.f7467c, jM3334c, j, zM3336e, zM3373i, zM3375k, zM3374j);
            }
            jM3332a = this.f7486a.f7341m;
        }
        j = jM3332a;
        if (aVar.m2593a()) {
        }
        return new MediaPeriodInfo(aVar, mediaPeriodInfo.f7466b, mediaPeriodInfo.f7467c, jM3334c, j, zM3336e, zM3373i, zM3375k, zM3374j);
    }

    /* JADX INFO: renamed from: i */
    public final boolean m3373i(MediaSource2.a aVar) {
        return !aVar.m2593a() && aVar.f5736e == -1;
    }

    /* JADX INFO: renamed from: j */
    public final boolean m3374j(Timeline timeline, MediaSource2.a aVar, boolean z2) {
        int iMo2554b = timeline.mo2554b(aVar.f5732a);
        if (timeline.m3330n(timeline.m3326f(iMo2554b, this.f7486a).f7340l, this.f7487b).f7361v) {
            return false;
        }
        return (timeline.m3325d(iMo2554b, this.f7486a, this.f7487b, this.f7491f, this.f7492g) == -1) && z2;
    }

    /* JADX INFO: renamed from: k */
    public final boolean m3375k(Timeline timeline, MediaSource2.a aVar) {
        if (m3373i(aVar)) {
            return timeline.m3330n(timeline.mo3327h(aVar.f5732a, this.f7486a).f7340l, this.f7487b).f7351C == timeline.mo2554b(aVar.f5732a);
        }
        return false;
    }

    /* JADX INFO: renamed from: l */
    public final void m3376l() {
        if (this.f7488c != null) {
            AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
            ImmutableList2.a aVar = new ImmutableList2.a();
            for (MediaPeriodHolder mediaPeriodHolder = this.f7493h; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.f7453l) {
                aVar.m6271b(mediaPeriodHolder.f7447f.f7465a);
            }
            MediaPeriodHolder mediaPeriodHolder2 = this.f7494i;
            this.f7489d.post(new RunnableC2822m0(this, aVar, mediaPeriodHolder2 == null ? null : mediaPeriodHolder2.f7447f.f7465a));
        }
    }

    /* JADX INFO: renamed from: m */
    public void m3377m(long j) {
        MediaPeriodHolder mediaPeriodHolder = this.f7495j;
        if (mediaPeriodHolder != null) {
            AnimatableValueParser.m426D(mediaPeriodHolder.m3353g());
            if (mediaPeriodHolder.f7445d) {
                mediaPeriodHolder.f7442a.mo2495s(j - mediaPeriodHolder.f7456o);
            }
        }
    }

    /* JADX INFO: renamed from: n */
    public boolean m3378n(MediaPeriodHolder mediaPeriodHolder) {
        boolean z2 = false;
        AnimatableValueParser.m426D(mediaPeriodHolder != null);
        if (mediaPeriodHolder.equals(this.f7495j)) {
            return false;
        }
        this.f7495j = mediaPeriodHolder;
        while (true) {
            mediaPeriodHolder = mediaPeriodHolder.f7453l;
            if (mediaPeriodHolder == null) {
                break;
            }
            if (mediaPeriodHolder == this.f7494i) {
                this.f7494i = this.f7493h;
                z2 = true;
            }
            mediaPeriodHolder.m3354h();
            this.f7496k--;
        }
        MediaPeriodHolder mediaPeriodHolder2 = this.f7495j;
        if (mediaPeriodHolder2.f7453l != null) {
            mediaPeriodHolder2.m3348b();
            mediaPeriodHolder2.f7453l = null;
            mediaPeriodHolder2.m3349c();
        }
        m3376l();
        return z2;
    }

    /* JADX INFO: renamed from: o */
    public MediaSource2.a m3379o(Timeline timeline, Object obj, long j) {
        long j2;
        int iMo2554b;
        int i = timeline.mo3327h(obj, this.f7486a).f7340l;
        Object obj2 = this.f7497l;
        if (obj2 == null || (iMo2554b = timeline.mo2554b(obj2)) == -1 || timeline.m3326f(iMo2554b, this.f7486a).f7340l != i) {
            MediaPeriodHolder mediaPeriodHolder = this.f7493h;
            while (true) {
                if (mediaPeriodHolder == null) {
                    MediaPeriodHolder mediaPeriodHolder2 = this.f7493h;
                    while (true) {
                        if (mediaPeriodHolder2 != null) {
                            int iMo2554b2 = timeline.mo2554b(mediaPeriodHolder2.f7443b);
                            if (iMo2554b2 != -1 && timeline.m3326f(iMo2554b2, this.f7486a).f7340l == i) {
                                j2 = mediaPeriodHolder2.f7447f.f7465a.f5735d;
                                break;
                            }
                            mediaPeriodHolder2 = mediaPeriodHolder2.f7453l;
                        } else {
                            j2 = this.f7490e;
                            this.f7490e = 1 + j2;
                            if (this.f7493h == null) {
                                this.f7497l = obj;
                                this.f7498m = j2;
                            }
                        }
                    }
                } else {
                    if (mediaPeriodHolder.f7443b.equals(obj)) {
                        j2 = mediaPeriodHolder.f7447f.f7465a.f5735d;
                        break;
                    }
                    mediaPeriodHolder = mediaPeriodHolder.f7453l;
                }
            }
        } else {
            j2 = this.f7498m;
        }
        return m3364p(timeline, obj, j, j2, this.f7486a);
    }

    /* JADX INFO: renamed from: q */
    public final boolean m3380q(Timeline timeline) {
        MediaPeriodHolder mediaPeriodHolder;
        MediaPeriodHolder mediaPeriodHolder2 = this.f7493h;
        if (mediaPeriodHolder2 == null) {
            return true;
        }
        int iMo2554b = timeline.mo2554b(mediaPeriodHolder2.f7443b);
        while (true) {
            iMo2554b = timeline.m3325d(iMo2554b, this.f7486a, this.f7487b, this.f7491f, this.f7492g);
            while (true) {
                mediaPeriodHolder = mediaPeriodHolder2.f7453l;
                if (mediaPeriodHolder == null || mediaPeriodHolder2.f7447f.f7471g) {
                    break;
                }
                mediaPeriodHolder2 = mediaPeriodHolder;
            }
            if (iMo2554b == -1 || mediaPeriodHolder == null || timeline.mo2554b(mediaPeriodHolder.f7443b) != iMo2554b) {
                break;
            }
            mediaPeriodHolder2 = mediaPeriodHolder;
        }
        boolean zM3378n = m3378n(mediaPeriodHolder2);
        mediaPeriodHolder2.f7447f = m3372h(timeline, mediaPeriodHolder2.f7447f);
        return !zM3378n;
    }

    /* JADX INFO: renamed from: r */
    public boolean m3381r(Timeline timeline, long j, long j2) {
        boolean zM3378n;
        MediaPeriodInfo mediaPeriodInfoM3372h;
        MediaPeriodHolder mediaPeriodHolder = this.f7493h;
        MediaPeriodHolder mediaPeriodHolder2 = null;
        while (mediaPeriodHolder != null) {
            MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f7447f;
            if (mediaPeriodHolder2 != null) {
                MediaPeriodInfo mediaPeriodInfoM3367c = m3367c(timeline, mediaPeriodHolder2, j);
                if (mediaPeriodInfoM3367c == null) {
                    zM3378n = m3378n(mediaPeriodHolder2);
                } else {
                    if (mediaPeriodInfo.f7466b == mediaPeriodInfoM3367c.f7466b && mediaPeriodInfo.f7465a.equals(mediaPeriodInfoM3367c.f7465a)) {
                        mediaPeriodInfoM3372h = mediaPeriodInfoM3367c;
                    } else {
                        zM3378n = m3378n(mediaPeriodHolder2);
                    }
                }
                return !zM3378n;
            }
            mediaPeriodInfoM3372h = m3372h(timeline, mediaPeriodInfo);
            mediaPeriodHolder.f7447f = mediaPeriodInfoM3372h.m3360a(mediaPeriodInfo.f7467c);
            long j3 = mediaPeriodInfo.f7469e;
            if (!(j3 == -9223372036854775807L || j3 == mediaPeriodInfoM3372h.f7469e)) {
                mediaPeriodHolder.m3356j();
                long j4 = mediaPeriodInfoM3372h.f7469e;
                return (m3378n(mediaPeriodHolder) || (mediaPeriodHolder == this.f7494i && !mediaPeriodHolder.f7447f.f7470f && ((j2 > Long.MIN_VALUE ? 1 : (j2 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j2 > ((j4 > (-9223372036854775807L) ? 1 : (j4 == (-9223372036854775807L) ? 0 : -1)) == 0 ? RecyclerView.FOREVER_NS : j4 + mediaPeriodHolder.f7456o) ? 1 : (j2 == ((j4 > (-9223372036854775807L) ? 1 : (j4 == (-9223372036854775807L) ? 0 : -1)) == 0 ? RecyclerView.FOREVER_NS : j4 + mediaPeriodHolder.f7456o) ? 0 : -1)) >= 0))) ? false : true;
            }
            mediaPeriodHolder2 = mediaPeriodHolder;
            mediaPeriodHolder = mediaPeriodHolder.f7453l;
        }
        return true;
    }
}
