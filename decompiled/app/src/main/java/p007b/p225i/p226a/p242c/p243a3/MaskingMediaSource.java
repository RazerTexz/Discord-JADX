package p007b.p225i.p226a.p242c.p243a3;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.MediaItem2;
import p007b.p225i.p226a.p242c.Timeline;
import p007b.p225i.p226a.p242c.p243a3.CompositeMediaSource;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p243a3.p244p0.AdPlaybackState;
import p007b.p225i.p226a.p242c.p257e3.DefaultAllocator;
import p007b.p225i.p226a.p242c.p257e3.TransferListener;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: MaskingMediaSource.java */
/* renamed from: b.i.a.c.a3.v, reason: use source file name */
/* loaded from: classes3.dex */
public final class MaskingMediaSource extends CompositeMediaSource<Void> {

    /* renamed from: j */
    public final MediaSource2 f5712j;

    /* renamed from: k */
    public final boolean f5713k;

    /* renamed from: l */
    public final Timeline.c f5714l;

    /* renamed from: m */
    public final Timeline.b f5715m;

    /* renamed from: n */
    public a f5716n;

    /* renamed from: o */
    @Nullable
    public MaskingMediaPeriod f5717o;

    /* renamed from: p */
    public boolean f5718p;

    /* renamed from: q */
    public boolean f5719q;

    /* renamed from: r */
    public boolean f5720r;

    /* compiled from: MaskingMediaSource.java */
    /* renamed from: b.i.a.c.a3.v$a */
    public static final class a extends ForwardingTimeline {

        /* renamed from: l */
        public static final Object f5721l = new Object();

        /* renamed from: m */
        @Nullable
        public final Object f5722m;

        /* renamed from: n */
        @Nullable
        public final Object f5723n;

        public a(Timeline timeline, @Nullable Object obj, @Nullable Object obj2) {
            super(timeline);
            this.f5722m = obj;
            this.f5723n = obj2;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.ForwardingTimeline, p007b.p225i.p226a.p242c.Timeline
        /* renamed from: b */
        public int mo2554b(Object obj) {
            Object obj2;
            Timeline timeline = this.f5697k;
            if (f5721l.equals(obj) && (obj2 = this.f5723n) != null) {
                obj = obj2;
            }
            return timeline.mo2554b(obj);
        }

        @Override // p007b.p225i.p226a.p242c.Timeline
        /* renamed from: g */
        public Timeline.b mo2513g(int i, Timeline.b bVar, boolean z2) {
            this.f5697k.mo2513g(i, bVar, z2);
            if (Util2.m2993a(bVar.f7339k, this.f5723n) && z2) {
                bVar.f7339k = f5721l;
            }
            return bVar;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.ForwardingTimeline, p007b.p225i.p226a.p242c.Timeline
        /* renamed from: m */
        public Object mo2556m(int i) {
            Object objMo2556m = this.f5697k.mo2556m(i);
            return Util2.m2993a(objMo2556m, this.f5723n) ? f5721l : objMo2556m;
        }

        @Override // p007b.p225i.p226a.p242c.Timeline
        /* renamed from: o */
        public Timeline.c mo2514o(int i, Timeline.c cVar, long j) {
            this.f5697k.mo2514o(i, cVar, j);
            if (Util2.m2993a(cVar.f7353n, this.f5722m)) {
                cVar.f7353n = Timeline.c.f7345j;
            }
            return cVar;
        }
    }

    /* compiled from: MaskingMediaSource.java */
    @VisibleForTesting
    /* renamed from: b.i.a.c.a3.v$b */
    public static final class b extends Timeline {

        /* renamed from: k */
        public final MediaItem2 f5724k;

        public b(MediaItem2 mediaItem2) {
            this.f5724k = mediaItem2;
        }

        @Override // p007b.p225i.p226a.p242c.Timeline
        /* renamed from: b */
        public int mo2554b(Object obj) {
            return obj == a.f5721l ? 0 : -1;
        }

        @Override // p007b.p225i.p226a.p242c.Timeline
        /* renamed from: g */
        public Timeline.b mo2513g(int i, Timeline.b bVar, boolean z2) {
            bVar.m3337f(z2 ? 0 : null, z2 ? a.f5721l : null, 0, -9223372036854775807L, 0L, AdPlaybackState.f5680j, true);
            return bVar;
        }

        @Override // p007b.p225i.p226a.p242c.Timeline
        /* renamed from: i */
        public int mo2555i() {
            return 1;
        }

        @Override // p007b.p225i.p226a.p242c.Timeline
        /* renamed from: m */
        public Object mo2556m(int i) {
            return a.f5721l;
        }

        @Override // p007b.p225i.p226a.p242c.Timeline
        /* renamed from: o */
        public Timeline.c mo2514o(int i, Timeline.c cVar, long j) {
            cVar.m3342e(Timeline.c.f7345j, this.f5724k, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            cVar.f7364y = true;
            return cVar;
        }

        @Override // p007b.p225i.p226a.p242c.Timeline
        /* renamed from: p */
        public int mo2557p() {
            return 1;
        }
    }

    public MaskingMediaSource(MediaSource2 mediaSource2, boolean z2) {
        this.f5712j = mediaSource2;
        this.f5713k = z2 && mediaSource2.mo2454i();
        this.f5714l = new Timeline.c();
        this.f5715m = new Timeline.b();
        Timeline timelineMo2456k = mediaSource2.mo2456k();
        if (timelineMo2456k == null) {
            this.f5716n = new a(new b(mediaSource2.mo2450e()), Timeline.c.f7345j, a.f5721l);
        } else {
            this.f5716n = new a(timelineMo2456k, null, null);
            this.f5720r = true;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* renamed from: e */
    public MediaItem2 mo2450e() {
        return this.f5712j.mo2450e();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* renamed from: h */
    public void mo2453h() {
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* renamed from: j */
    public void mo2455j(MediaPeriod mediaPeriod) {
        MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) mediaPeriod;
        if (maskingMediaPeriod.f5709n != null) {
            MediaSource2 mediaSource2 = maskingMediaPeriod.f5708m;
            Objects.requireNonNull(mediaSource2);
            mediaSource2.mo2455j(maskingMediaPeriod.f5709n);
        }
        if (mediaPeriod == this.f5717o) {
            this.f5717o = null;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* renamed from: n */
    public /* bridge */ /* synthetic */ MediaPeriod mo2459n(MediaSource2.a aVar, DefaultAllocator defaultAllocator, long j) {
        return m2591u(aVar, defaultAllocator, j);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.BaseMediaSource
    /* renamed from: q */
    public void mo2509q(@Nullable TransferListener transferListener) {
        this.f5666i = transferListener;
        this.f5665h = Util2.m3002j();
        if (this.f5713k) {
            return;
        }
        this.f5718p = true;
        m2566t(null, this.f5712j);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.BaseMediaSource
    /* renamed from: s */
    public void mo2510s() {
        this.f5719q = false;
        this.f5718p = false;
        for (CompositeMediaSource.b bVar : this.f5664g.values()) {
            bVar.f5671a.mo2446a(bVar.f5672b);
            bVar.f5671a.mo2448c(bVar.f5673c);
            bVar.f5671a.mo2452g(bVar.f5673c);
        }
        this.f5664g.clear();
    }

    /* renamed from: u */
    public MaskingMediaPeriod m2591u(MediaSource2.a aVar, DefaultAllocator defaultAllocator, long j) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(aVar, defaultAllocator, j);
        MediaSource2 mediaSource2 = this.f5712j;
        AnimatableValueParser.m426D(maskingMediaPeriod.f5708m == null);
        maskingMediaPeriod.f5708m = mediaSource2;
        if (this.f5719q) {
            Object obj = aVar.f5732a;
            if (this.f5716n.f5723n != null && obj.equals(a.f5721l)) {
                obj = this.f5716n.f5723n;
            }
            maskingMediaPeriod.m2590d(aVar.m2460b(obj));
        } else {
            this.f5717o = maskingMediaPeriod;
            if (!this.f5718p) {
                this.f5718p = true;
                m2566t(null, this.f5712j);
            }
        }
        return maskingMediaPeriod;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    /* renamed from: v */
    public final void m2592v(long j) {
        MaskingMediaPeriod maskingMediaPeriod = this.f5717o;
        int iMo2554b = this.f5716n.mo2554b(maskingMediaPeriod.f5705j.f5732a);
        if (iMo2554b == -1) {
            return;
        }
        long j2 = this.f5716n.m3326f(iMo2554b, this.f5715m).f7341m;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        maskingMediaPeriod.f5711p = j;
    }
}
