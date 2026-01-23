package p007b.p008a.p041q.p047o0;

import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.q.o0.b, reason: use source file name */
/* JADX INFO: compiled from: RtcStatsCollector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RtcStatsCollector2<T> implements Action1<Long> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ RtcStatsCollector4 f1805j;

    public RtcStatsCollector2(RtcStatsCollector4 rtcStatsCollector4) {
        this.f1805j = rtcStatsCollector4;
    }

    @Override // p658rx.functions.Action1
    public void call(Long l) {
        this.f1805j.f1811e.mo308n(new RtcStatsCollector(this.f1805j));
    }
}
