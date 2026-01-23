package p007b.p225i.p226a.p242c.p257e3;

import p007b.p225i.p226a.p242c.p259f3.NetworkTypeObserver;

/* JADX INFO: renamed from: b.i.a.c.e3.b */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2681b implements NetworkTypeObserver.b {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ DefaultBandwidthMeter f6435a;

    public /* synthetic */ C2681b(DefaultBandwidthMeter defaultBandwidthMeter) {
        this.f6435a = defaultBandwidthMeter;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.NetworkTypeObserver.b
    /* JADX INFO: renamed from: a */
    public final void mo2777a(int i) {
        DefaultBandwidthMeter defaultBandwidthMeter = this.f6435a;
        synchronized (defaultBandwidthMeter) {
            int i2 = defaultBandwidthMeter.f6584p;
            if (i2 == 0 || defaultBandwidthMeter.f6580l) {
                if (i2 == i) {
                    return;
                }
                defaultBandwidthMeter.f6584p = i;
                if (i != 1 && i != 0 && i != 8) {
                    defaultBandwidthMeter.f6587s = defaultBandwidthMeter.m2862h(i);
                    long jMo2952d = defaultBandwidthMeter.f6579k.mo2952d();
                    defaultBandwidthMeter.m2863j(defaultBandwidthMeter.f6581m > 0 ? (int) (jMo2952d - defaultBandwidthMeter.f6582n) : 0, defaultBandwidthMeter.f6583o, defaultBandwidthMeter.f6587s);
                    defaultBandwidthMeter.f6582n = jMo2952d;
                    defaultBandwidthMeter.f6583o = 0L;
                    defaultBandwidthMeter.f6586r = 0L;
                    defaultBandwidthMeter.f6585q = 0L;
                    SlidingPercentile slidingPercentile = defaultBandwidthMeter.f6578j;
                    slidingPercentile.f6632c.clear();
                    slidingPercentile.f6634e = -1;
                    slidingPercentile.f6635f = 0;
                    slidingPercentile.f6636g = 0;
                }
            }
        }
    }
}
