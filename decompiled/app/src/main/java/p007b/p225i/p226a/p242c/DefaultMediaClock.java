package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p259f3.Clock4;
import p007b.p225i.p226a.p242c.p259f3.MediaClock;
import p007b.p225i.p226a.p242c.p259f3.StandaloneMediaClock;

/* compiled from: DefaultMediaClock.java */
/* renamed from: b.i.a.c.a1, reason: use source file name */
/* loaded from: classes3.dex */
public final class DefaultMediaClock implements MediaClock {

    /* renamed from: j */
    public final StandaloneMediaClock f5467j;

    /* renamed from: k */
    public final a f5468k;

    /* renamed from: l */
    @Nullable
    public Renderer2 f5469l;

    /* renamed from: m */
    @Nullable
    public MediaClock f5470m;

    /* renamed from: n */
    public boolean f5471n = true;

    /* renamed from: o */
    public boolean f5472o;

    /* compiled from: DefaultMediaClock.java */
    /* renamed from: b.i.a.c.a1$a */
    public interface a {
    }

    public DefaultMediaClock(a aVar, Clock4 clock4) {
        this.f5468k = aVar;
        this.f5467j = new StandaloneMediaClock(clock4);
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.MediaClock
    /* renamed from: c */
    public PlaybackParameters mo2416c() {
        MediaClock mediaClock = this.f5470m;
        return mediaClock != null ? mediaClock.mo2416c() : this.f5467j.f6804n;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.MediaClock
    /* renamed from: e */
    public long mo2417e() {
        if (this.f5471n) {
            return this.f5467j.mo2417e();
        }
        MediaClock mediaClock = this.f5470m;
        Objects.requireNonNull(mediaClock);
        return mediaClock.mo2417e();
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.MediaClock
    /* renamed from: i */
    public void mo2418i(PlaybackParameters playbackParameters) {
        MediaClock mediaClock = this.f5470m;
        if (mediaClock != null) {
            mediaClock.mo2418i(playbackParameters);
            playbackParameters = this.f5470m.mo2416c();
        }
        this.f5467j.mo2418i(playbackParameters);
    }
}
