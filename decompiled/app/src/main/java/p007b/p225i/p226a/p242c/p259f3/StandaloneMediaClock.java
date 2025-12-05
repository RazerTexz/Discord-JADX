package p007b.p225i.p226a.p242c.p259f3;

import p007b.p225i.p226a.p242c.PlaybackParameters;

/* compiled from: StandaloneMediaClock.java */
/* renamed from: b.i.a.c.f3.z, reason: use source file name */
/* loaded from: classes3.dex */
public final class StandaloneMediaClock implements MediaClock {

    /* renamed from: j */
    public final Clock4 f6800j;

    /* renamed from: k */
    public boolean f6801k;

    /* renamed from: l */
    public long f6802l;

    /* renamed from: m */
    public long f6803m;

    /* renamed from: n */
    public PlaybackParameters f6804n = PlaybackParameters.f8026j;

    public StandaloneMediaClock(Clock4 clock4) {
        this.f6800j = clock4;
    }

    /* renamed from: a */
    public void m3117a(long j) {
        this.f6802l = j;
        if (this.f6801k) {
            this.f6803m = this.f6800j.mo2952d();
        }
    }

    /* renamed from: b */
    public void m3118b() {
        if (this.f6801k) {
            return;
        }
        this.f6803m = this.f6800j.mo2952d();
        this.f6801k = true;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.MediaClock
    /* renamed from: c */
    public PlaybackParameters mo2416c() {
        return this.f6804n;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.MediaClock
    /* renamed from: e */
    public long mo2417e() {
        long j = this.f6802l;
        if (!this.f6801k) {
            return j;
        }
        long jMo2952d = this.f6800j.mo2952d() - this.f6803m;
        return this.f6804n.f8027k == 1.0f ? j + Util2.m2981B(jMo2952d) : j + (jMo2952d * r4.f8029m);
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.MediaClock
    /* renamed from: i */
    public void mo2418i(PlaybackParameters playbackParameters) {
        if (this.f6801k) {
            m3117a(mo2417e());
        }
        this.f6804n = playbackParameters;
    }
}
