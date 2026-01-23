package p007b.p225i.p226a.p242c.p243a3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.MediaItem2;
import p007b.p225i.p226a.p242c.MediaMetadata;
import p007b.p225i.p226a.p242c.Timeline;
import p007b.p225i.p226a.p242c.p243a3.p244p0.AdPlaybackState;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.RegularImmutableList;

/* JADX INFO: renamed from: b.i.a.c.a3.l0, reason: use source file name */
/* JADX INFO: compiled from: SinglePeriodTimeline.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SinglePeriodTimeline extends Timeline {

    /* JADX INFO: renamed from: k */
    public static final Object f5639k = new Object();

    /* JADX INFO: renamed from: l */
    public final long f5640l;

    /* JADX INFO: renamed from: m */
    public final long f5641m;

    /* JADX INFO: renamed from: n */
    public final boolean f5642n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public final MediaItem2 f5643o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public final MediaItem2.g f5644p;

    static {
        MediaItem2.d.a aVar = new MediaItem2.d.a();
        MediaItem2.f.a aVar2 = new MediaItem2.f.a(null);
        List listEmptyList = Collections.emptyList();
        ImmutableList2<Object> immutableList2 = RegularImmutableList.f12012l;
        MediaItem2.g.a aVar3 = new MediaItem2.g.a();
        Uri uri = Uri.EMPTY;
        AnimatableValueParser.m426D(aVar2.f7299b == null || aVar2.f7298a != null);
        if (uri != null) {
            new MediaItem2.i(uri, null, aVar2.f7298a != null ? new MediaItem2.f(aVar2, null) : null, null, listEmptyList, null, immutableList2, null, null);
        }
        aVar.m3322a();
        new MediaItem2.g(aVar3, null);
        MediaMetadata mediaMetadata = MediaMetadata.f7368j;
    }

    public SinglePeriodTimeline(long j, boolean z2, boolean z3, boolean z4, @Nullable Object obj, MediaItem2 mediaItem2) {
        MediaItem2.g gVar = z4 ? mediaItem2.f7264m : null;
        this.f5640l = j;
        this.f5641m = j;
        this.f5642n = z2;
        Objects.requireNonNull(mediaItem2);
        this.f5643o = mediaItem2;
        this.f5644p = gVar;
    }

    @Override // p007b.p225i.p226a.p242c.Timeline
    /* JADX INFO: renamed from: b */
    public int mo2554b(Object obj) {
        return f5639k.equals(obj) ? 0 : -1;
    }

    @Override // p007b.p225i.p226a.p242c.Timeline
    /* JADX INFO: renamed from: g */
    public Timeline.b mo2513g(int i, Timeline.b bVar, boolean z2) {
        AnimatableValueParser.m571t(i, 0, 1);
        Object obj = z2 ? f5639k : null;
        long j = this.f5640l;
        Objects.requireNonNull(bVar);
        bVar.m3337f(null, obj, 0, j, 0L, AdPlaybackState.f5680j, false);
        return bVar;
    }

    @Override // p007b.p225i.p226a.p242c.Timeline
    /* JADX INFO: renamed from: i */
    public int mo2555i() {
        return 1;
    }

    @Override // p007b.p225i.p226a.p242c.Timeline
    /* JADX INFO: renamed from: m */
    public Object mo2556m(int i) {
        AnimatableValueParser.m571t(i, 0, 1);
        return f5639k;
    }

    @Override // p007b.p225i.p226a.p242c.Timeline
    /* JADX INFO: renamed from: o */
    public Timeline.c mo2514o(int i, Timeline.c cVar, long j) {
        AnimatableValueParser.m571t(i, 0, 1);
        cVar.m3342e(Timeline.c.f7345j, this.f5643o, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.f5642n, false, this.f5644p, 0L, this.f5641m, 0, 0, 0L);
        return cVar;
    }

    @Override // p007b.p225i.p226a.p242c.Timeline
    /* JADX INFO: renamed from: p */
    public int mo2557p() {
        return 1;
    }
}
