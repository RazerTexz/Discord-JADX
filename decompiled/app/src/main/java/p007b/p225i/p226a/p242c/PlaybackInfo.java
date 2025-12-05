package p007b.p225i.p226a.p242c;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p243a3.TrackGroupArray;
import p007b.p225i.p226a.p242c.p255c3.TrackSelectorResult;
import p007b.p225i.p355b.p357b.AbstractIndexedListIterator;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.RegularImmutableList;

/* compiled from: PlaybackInfo.java */
/* renamed from: b.i.a.c.w1, reason: use source file name */
/* loaded from: classes3.dex */
public final class PlaybackInfo {

    /* renamed from: a */
    public static final MediaSource2.a f7946a = new MediaSource2.a(new Object());

    /* renamed from: b */
    public final Timeline f7947b;

    /* renamed from: c */
    public final MediaSource2.a f7948c;

    /* renamed from: d */
    public final long f7949d;

    /* renamed from: e */
    public final long f7950e;

    /* renamed from: f */
    public final int f7951f;

    /* renamed from: g */
    @Nullable
    public final ExoPlaybackException f7952g;

    /* renamed from: h */
    public final boolean f7953h;

    /* renamed from: i */
    public final TrackGroupArray f7954i;

    /* renamed from: j */
    public final TrackSelectorResult f7955j;

    /* renamed from: k */
    public final List<Metadata> f7956k;

    /* renamed from: l */
    public final MediaSource2.a f7957l;

    /* renamed from: m */
    public final boolean f7958m;

    /* renamed from: n */
    public final int f7959n;

    /* renamed from: o */
    public final PlaybackParameters f7960o;

    /* renamed from: p */
    public final boolean f7961p;

    /* renamed from: q */
    public final boolean f7962q;

    /* renamed from: r */
    public volatile long f7963r;

    /* renamed from: s */
    public volatile long f7964s;

    /* renamed from: t */
    public volatile long f7965t;

    public PlaybackInfo(Timeline timeline, MediaSource2.a aVar, long j, long j2, int i, @Nullable ExoPlaybackException exoPlaybackException, boolean z2, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List<Metadata> list, MediaSource2.a aVar2, boolean z3, int i2, PlaybackParameters playbackParameters, long j3, long j4, long j5, boolean z4, boolean z5) {
        this.f7947b = timeline;
        this.f7948c = aVar;
        this.f7949d = j;
        this.f7950e = j2;
        this.f7951f = i;
        this.f7952g = exoPlaybackException;
        this.f7953h = z2;
        this.f7954i = trackGroupArray;
        this.f7955j = trackSelectorResult;
        this.f7956k = list;
        this.f7957l = aVar2;
        this.f7958m = z3;
        this.f7959n = i2;
        this.f7960o = playbackParameters;
        this.f7963r = j3;
        this.f7964s = j4;
        this.f7965t = j5;
        this.f7961p = z4;
        this.f7962q = z5;
    }

    /* renamed from: h */
    public static PlaybackInfo m3561h(TrackSelectorResult trackSelectorResult) {
        Timeline timeline = Timeline.f7337j;
        MediaSource2.a aVar = f7946a;
        TrackGroupArray trackGroupArray = TrackGroupArray.f5674j;
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
        return new PlaybackInfo(timeline, aVar, -9223372036854775807L, 0L, 1, null, false, trackGroupArray, trackSelectorResult, RegularImmutableList.f12012l, aVar, false, 0, PlaybackParameters.f8026j, 0L, 0L, 0L, false, false);
    }

    @CheckResult
    /* renamed from: a */
    public PlaybackInfo m3562a(MediaSource2.a aVar) {
        return new PlaybackInfo(this.f7947b, this.f7948c, this.f7949d, this.f7950e, this.f7951f, this.f7952g, this.f7953h, this.f7954i, this.f7955j, this.f7956k, aVar, this.f7958m, this.f7959n, this.f7960o, this.f7963r, this.f7964s, this.f7965t, this.f7961p, this.f7962q);
    }

    @CheckResult
    /* renamed from: b */
    public PlaybackInfo m3563b(MediaSource2.a aVar, long j, long j2, long j3, long j4, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List<Metadata> list) {
        return new PlaybackInfo(this.f7947b, aVar, j2, j3, this.f7951f, this.f7952g, this.f7953h, trackGroupArray, trackSelectorResult, list, this.f7957l, this.f7958m, this.f7959n, this.f7960o, this.f7963r, j4, j, this.f7961p, this.f7962q);
    }

    @CheckResult
    /* renamed from: c */
    public PlaybackInfo m3564c(boolean z2) {
        return new PlaybackInfo(this.f7947b, this.f7948c, this.f7949d, this.f7950e, this.f7951f, this.f7952g, this.f7953h, this.f7954i, this.f7955j, this.f7956k, this.f7957l, this.f7958m, this.f7959n, this.f7960o, this.f7963r, this.f7964s, this.f7965t, z2, this.f7962q);
    }

    @CheckResult
    /* renamed from: d */
    public PlaybackInfo m3565d(boolean z2, int i) {
        return new PlaybackInfo(this.f7947b, this.f7948c, this.f7949d, this.f7950e, this.f7951f, this.f7952g, this.f7953h, this.f7954i, this.f7955j, this.f7956k, this.f7957l, z2, i, this.f7960o, this.f7963r, this.f7964s, this.f7965t, this.f7961p, this.f7962q);
    }

    @CheckResult
    /* renamed from: e */
    public PlaybackInfo m3566e(@Nullable ExoPlaybackException exoPlaybackException) {
        return new PlaybackInfo(this.f7947b, this.f7948c, this.f7949d, this.f7950e, this.f7951f, exoPlaybackException, this.f7953h, this.f7954i, this.f7955j, this.f7956k, this.f7957l, this.f7958m, this.f7959n, this.f7960o, this.f7963r, this.f7964s, this.f7965t, this.f7961p, this.f7962q);
    }

    @CheckResult
    /* renamed from: f */
    public PlaybackInfo m3567f(int i) {
        return new PlaybackInfo(this.f7947b, this.f7948c, this.f7949d, this.f7950e, i, this.f7952g, this.f7953h, this.f7954i, this.f7955j, this.f7956k, this.f7957l, this.f7958m, this.f7959n, this.f7960o, this.f7963r, this.f7964s, this.f7965t, this.f7961p, this.f7962q);
    }

    @CheckResult
    /* renamed from: g */
    public PlaybackInfo m3568g(Timeline timeline) {
        return new PlaybackInfo(timeline, this.f7948c, this.f7949d, this.f7950e, this.f7951f, this.f7952g, this.f7953h, this.f7954i, this.f7955j, this.f7956k, this.f7957l, this.f7958m, this.f7959n, this.f7960o, this.f7963r, this.f7964s, this.f7965t, this.f7961p, this.f7962q);
    }
}
