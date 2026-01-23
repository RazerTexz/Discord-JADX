package p007b.p008a.p041q.p047o0;

import com.discord.utilities.logging.Logger;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.q.o0.c, reason: use source file name */
/* JADX INFO: compiled from: RtcStatsCollector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RtcStatsCollector3<T> implements Action1<Throwable> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ RtcStatsCollector4 f1806j;

    public RtcStatsCollector3(RtcStatsCollector4 rtcStatsCollector4) {
        this.f1806j = rtcStatsCollector4;
    }

    @Override // p658rx.functions.Action1
    public void call(Throwable th) {
        Logger.e$default(this.f1806j.f1810d, "RtcStatsCollector: Error collecting stats", th, null, 4, null);
    }
}
