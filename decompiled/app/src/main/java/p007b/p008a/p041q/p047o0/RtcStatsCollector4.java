package p007b.p008a.p041q.p047o0;

import co.discord.media_engine.Stats;
import co.discord.media_engine.VoiceQuality;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.logging.Logger;
import java.util.Deque;
import java.util.LinkedList;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Subscription;

/* JADX INFO: renamed from: b.a.q.o0.d, reason: use source file name */
/* JADX INFO: compiled from: RtcStatsCollector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RtcStatsCollector4 {

    /* JADX INFO: renamed from: a */
    public final Deque<Stats> f1807a;

    /* JADX INFO: renamed from: b */
    public Subscription f1808b;

    /* JADX INFO: renamed from: c */
    public final long f1809c;

    /* JADX INFO: renamed from: d */
    public final Logger f1810d;

    /* JADX INFO: renamed from: e */
    public final MediaEngineConnection f1811e;

    /* JADX INFO: renamed from: f */
    public final VoiceQuality f1812f;

    /* JADX INFO: renamed from: g */
    public final VideoQuality f1813g;

    /* JADX INFO: renamed from: h */
    public final KrispOveruseDetector f1814h;

    /* JADX INFO: renamed from: i */
    public final int f1815i;

    public RtcStatsCollector4(long j, Logger logger, MediaEngineConnection mediaEngineConnection, VoiceQuality voiceQuality, VideoQuality videoQuality, KrispOveruseDetector krispOveruseDetector, int i, int i2) {
        i = (i2 & 64) != 0 ? 30 : i;
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(voiceQuality, "voiceQuality");
        Intrinsics3.checkNotNullParameter(videoQuality, "videoQuality");
        Intrinsics3.checkNotNullParameter(krispOveruseDetector, "krispOveruseDetector");
        this.f1809c = j;
        this.f1810d = logger;
        this.f1811e = mediaEngineConnection;
        this.f1812f = voiceQuality;
        this.f1813g = videoQuality;
        this.f1814h = krispOveruseDetector;
        this.f1815i = i;
        this.f1807a = new LinkedList();
    }

    /* JADX INFO: renamed from: a */
    public final void m351a() {
        Subscription subscription = this.f1808b;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
