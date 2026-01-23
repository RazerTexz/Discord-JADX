package p007b.p225i.p226a.p242c.p243a3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.upstream.Loader;
import java.util.Objects;
import p007b.p225i.p226a.p242c.MediaItem2;
import p007b.p225i.p226a.p242c.Timeline;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p243a3.ProgressiveMediaExtractor;
import p007b.p225i.p226a.p242c.p243a3.ProgressiveMediaPeriod;
import p007b.p225i.p226a.p242c.p257e3.DataSource3;
import p007b.p225i.p226a.p242c.p257e3.DefaultAllocator;
import p007b.p225i.p226a.p242c.p257e3.LoadErrorHandlingPolicy;
import p007b.p225i.p226a.p242c.p257e3.TransferListener;
import p007b.p225i.p226a.p242c.p266w2.DrmSessionManager2;

/* JADX INFO: renamed from: b.i.a.c.a3.f0, reason: use source file name */
/* JADX INFO: compiled from: ProgressiveMediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ProgressiveMediaSource extends BaseMediaSource implements ProgressiveMediaPeriod.b {

    /* JADX INFO: renamed from: g */
    public final MediaItem2 f5565g;

    /* JADX INFO: renamed from: h */
    public final MediaItem2.h f5566h;

    /* JADX INFO: renamed from: i */
    public final DataSource3.a f5567i;

    /* JADX INFO: renamed from: j */
    public final ProgressiveMediaExtractor.a f5568j;

    /* JADX INFO: renamed from: k */
    public final DrmSessionManager2 f5569k;

    /* JADX INFO: renamed from: l */
    public final LoadErrorHandlingPolicy f5570l;

    /* JADX INFO: renamed from: m */
    public final int f5571m;

    /* JADX INFO: renamed from: n */
    public boolean f5572n;

    /* JADX INFO: renamed from: o */
    public long f5573o;

    /* JADX INFO: renamed from: p */
    public boolean f5574p;

    /* JADX INFO: renamed from: q */
    public boolean f5575q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public TransferListener f5576r;

    /* JADX INFO: renamed from: b.i.a.c.a3.f0$a */
    /* JADX INFO: compiled from: ProgressiveMediaSource.java */
    public class a extends ForwardingTimeline {
        public a(Timeline timeline) {
            super(timeline);
        }

        @Override // p007b.p225i.p226a.p242c.Timeline
        /* JADX INFO: renamed from: g */
        public Timeline.b mo2513g(int i, Timeline.b bVar, boolean z2) {
            this.f5697k.mo2513g(i, bVar, z2);
            bVar.f7343o = true;
            return bVar;
        }

        @Override // p007b.p225i.p226a.p242c.Timeline
        /* JADX INFO: renamed from: o */
        public Timeline.c mo2514o(int i, Timeline.c cVar, long j) {
            this.f5697k.mo2514o(i, cVar, j);
            cVar.f7364y = true;
            return cVar;
        }
    }

    public ProgressiveMediaSource(MediaItem2 mediaItem2, DataSource3.a aVar, ProgressiveMediaExtractor.a aVar2, DrmSessionManager2 drmSessionManager2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i, a aVar3) {
        MediaItem2.h hVar = mediaItem2.f7263l;
        Objects.requireNonNull(hVar);
        this.f5566h = hVar;
        this.f5565g = mediaItem2;
        this.f5567i = aVar;
        this.f5568j = aVar2;
        this.f5569k = drmSessionManager2;
        this.f5570l = loadErrorHandlingPolicy;
        this.f5571m = i;
        this.f5572n = true;
        this.f5573o = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* JADX INFO: renamed from: e */
    public MediaItem2 mo2450e() {
        return this.f5565g;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* JADX INFO: renamed from: h */
    public void mo2453h() {
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* JADX INFO: renamed from: j */
    public void mo2455j(MediaPeriod mediaPeriod) {
        ProgressiveMediaPeriod progressiveMediaPeriod = (ProgressiveMediaPeriod) mediaPeriod;
        if (progressiveMediaPeriod.f5506G) {
            for (SampleQueue sampleQueue : progressiveMediaPeriod.f5503D) {
                sampleQueue.m2529h();
                DrmSession drmSession = sampleQueue.f5604i;
                if (drmSession != null) {
                    drmSession.mo3607b(sampleQueue.f5600e);
                    sampleQueue.f5604i = null;
                    sampleQueue.f5603h = null;
                }
            }
        }
        Loader loader = progressiveMediaPeriod.f5533v;
        Loader.HandlerC10769d<? extends Loader.InterfaceC10770e> handlerC10769d = loader.f20232d;
        if (handlerC10769d != null) {
            handlerC10769d.m8941a(true);
        }
        loader.f20231c.execute(new Loader.RunnableC10772g(progressiveMediaPeriod));
        loader.f20231c.shutdown();
        progressiveMediaPeriod.f5500A.removeCallbacksAndMessages(null);
        progressiveMediaPeriod.f5501B = null;
        progressiveMediaPeriod.f5522W = true;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2
    /* JADX INFO: renamed from: n */
    public MediaPeriod mo2459n(MediaSource2.a aVar, DefaultAllocator defaultAllocator, long j) {
        DataSource3 dataSource3Mo234a = this.f5567i.mo234a();
        TransferListener transferListener = this.f5576r;
        if (transferListener != null) {
            dataSource3Mo234a.mo2587d(transferListener);
        }
        return new ProgressiveMediaPeriod(this.f5566h.f7318a, dataSource3Mo234a, new BundledExtractorsAdapter(((C2547j) this.f5568j).f5628a), this.f5569k, this.f5636d.m3593g(0, aVar), this.f5570l, this.f5635c.m2472g(0, aVar, 0L), this, defaultAllocator, this.f5566h.f7322e, this.f5571m);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.BaseMediaSource
    /* JADX INFO: renamed from: q */
    public void mo2509q(@Nullable TransferListener transferListener) {
        this.f5576r = transferListener;
        this.f5569k.mo3597a();
        m2511t();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.BaseMediaSource
    /* JADX INFO: renamed from: s */
    public void mo2510s() {
        this.f5569k.release();
    }

    /* JADX INFO: renamed from: t */
    public final void m2511t() {
        Timeline singlePeriodTimeline = new SinglePeriodTimeline(this.f5573o, this.f5574p, false, this.f5575q, null, this.f5565g);
        if (this.f5572n) {
            singlePeriodTimeline = new a(singlePeriodTimeline);
        }
        m2553r(singlePeriodTimeline);
    }

    /* JADX INFO: renamed from: u */
    public void m2512u(long j, boolean z2, boolean z3) {
        if (j == -9223372036854775807L) {
            j = this.f5573o;
        }
        if (!this.f5572n && this.f5573o == j && this.f5574p == z2 && this.f5575q == z3) {
            return;
        }
        this.f5573o = j;
        this.f5574p = z2;
        this.f5575q = z3;
        this.f5572n = false;
        m2511t();
    }
}
