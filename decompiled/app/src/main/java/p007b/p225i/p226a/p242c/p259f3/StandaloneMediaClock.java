package p007b.p225i.p226a.p242c.p259f3;

import p007b.p225i.p226a.p242c.PlaybackParameters;

/* JADX INFO: renamed from: b.i.a.c.f3.z, reason: use source file name */
/* JADX INFO: compiled from: StandaloneMediaClock.java */
/* JADX INFO: loaded from: classes3.dex */
public final class StandaloneMediaClock implements MediaClock {

    /* JADX INFO: renamed from: j */
    public final Clock4 f6800j;

    /* JADX INFO: renamed from: k */
    public boolean f6801k;

    /* JADX INFO: renamed from: l */
    public long f6802l;

    /* JADX INFO: renamed from: m */
    public long f6803m;

    /* JADX INFO: renamed from: n */
    public PlaybackParameters f6804n = PlaybackParameters.f8026j;

    public StandaloneMediaClock(Clock4 clock4) {
        this.f6800j = clock4;
    }

    /* JADX INFO: renamed from: a */
    public void m3117a(long j) {
        this.f6802l = j;
        if (this.f6801k) {
            this.f6803m = this.f6800j.mo2952d();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3118b() {
        if (this.f6801k) {
            return;
        }
        this.f6803m = this.f6800j.mo2952d();
        this.f6801k = true;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.MediaClock
    /* JADX INFO: renamed from: c */
    public PlaybackParameters mo2416c() {
        return this.f6804n;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.MediaClock
    /* JADX INFO: renamed from: e */
    public long mo2417e() {
        long j = this.f6802l;
        if (!this.f6801k) {
            return j;
        }
        long jMo2952d = this.f6800j.mo2952d() - this.f6803m;
        PlaybackParameters playbackParameters = this.f6804n;
        return playbackParameters.f8027k == 1.0f ? j + Util2.m2981B(jMo2952d) : j + (jMo2952d * ((long) playbackParameters.f8029m));
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.MediaClock
    /* JADX INFO: renamed from: i */
    public void mo2418i(PlaybackParameters playbackParameters) {
        if (this.f6801k) {
            m3117a(mo2417e());
        }
        this.f6804n = playbackParameters;
    }
}
