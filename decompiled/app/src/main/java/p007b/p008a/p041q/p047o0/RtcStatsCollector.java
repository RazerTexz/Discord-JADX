package p007b.p008a.p041q.p047o0;

import co.discord.media_engine.InboundRtpVideo;
import co.discord.media_engine.OutboundRtpAudio;
import co.discord.media_engine.OutboundRtpVideo;
import co.discord.media_engine.ReceiverReport;
import co.discord.media_engine.Stats;
import co.discord.media_engine.Transport;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.logging.Logger;
import java.util.Map;
import java.util.Objects;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p041q.p047o0.VideoQuality;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.Util7;

/* JADX INFO: renamed from: b.a.q.o0.a, reason: use source file name */
/* JADX INFO: compiled from: RtcStatsCollector.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RtcStatsCollector extends FunctionReferenceImpl implements Function1<Stats, Unit> {
    public RtcStatsCollector(RtcStatsCollector4 rtcStatsCollector4) {
        super(1, rtcStatsCollector4, RtcStatsCollector4.class, "onStatsReceived", "onStatsReceived(Lco/discord/media_engine/Stats;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Stats stats) {
        long j;
        OutboundRtpVideo outboundRtpVideo;
        ReceiverReport[] receiverReports;
        Stats stats2 = stats;
        Intrinsics3.checkNotNullParameter(stats2, "p1");
        RtcStatsCollector4 rtcStatsCollector4 = (RtcStatsCollector4) this.receiver;
        rtcStatsCollector4.f1807a.add(stats2);
        if (rtcStatsCollector4.f1807a.size() > rtcStatsCollector4.f1815i) {
            rtcStatsCollector4.f1807a.removeFirst();
        }
        rtcStatsCollector4.f1812f.update(stats2);
        VideoQuality videoQuality = rtcStatsCollector4.f1813g;
        synchronized (videoQuality) {
            Intrinsics3.checkNotNullParameter(stats2, "stats");
            long jCurrentTimeMillis = videoQuality.f1832q.currentTimeMillis();
            Transport transport = stats2.getTransport();
            videoQuality.m358g(null, Integer.valueOf((transport == null || (receiverReports = transport.getReceiverReports()) == null) ? 0 : receiverReports.length), jCurrentTimeMillis);
            if (!videoQuality.f1826k.m360a() && (outboundRtpVideo = stats2.getOutboundRtpVideo()) != null) {
                videoQuality.m352a(videoQuality.f1827l, new VideoQuality.g(outboundRtpVideo.getResolution().getHeight(), jCurrentTimeMillis, new VideoQuality.a(outboundRtpVideo.getFramesEncoded(), outboundRtpVideo.getFramesSent(), outboundRtpVideo.getPacketsSent(), outboundRtpVideo.getPacketsLost(), 0L, outboundRtpVideo.getBytesSent(), outboundRtpVideo.getNackCount(), outboundRtpVideo.getPliCount(), outboundRtpVideo.getQpSum(), 0L, 0L, 0L, 0L, 0L)));
                if (videoQuality.f1827l.f1852d == null && outboundRtpVideo.getFramesEncoded() > 0) {
                    videoQuality.f1827l.f1852d = Long.valueOf(jCurrentTimeMillis - videoQuality.f1822g);
                    Logger.i$default(videoQuality.f1831p, "VideoQuality: outboundStats.timeToFirstFrame: " + videoQuality.f1827l.f1852d, null, 2, null);
                }
                videoQuality.m353b(outboundRtpVideo.getBitrateTarget());
            }
            if (!videoQuality.f1824i.m360a()) {
                for (Map.Entry<String, InboundRtpVideo> entry : stats2.getInboundRtpVideo().entrySet()) {
                    String key = entry.getKey();
                    InboundRtpVideo value = entry.getValue();
                    Map<String, VideoQuality.e> map = videoQuality.f1828m;
                    VideoQuality.e eVar = map.get(key);
                    if (eVar == null) {
                        eVar = new VideoQuality.e();
                        map.put(key, eVar);
                    }
                    VideoQuality.e eVar2 = eVar;
                    videoQuality.m352a(eVar2, videoQuality.m357f(value, jCurrentTimeMillis));
                    if (eVar2.f1852d == null && value.getFramesDecoded() > 0) {
                        byte[] bArr = Util7.f25397a;
                        Intrinsics3.checkParameterIsNotNull(key, "$this$toLongOrDefault");
                        try {
                            j = Long.parseLong(key);
                        } catch (NumberFormatException unused) {
                            j = 0;
                        }
                        Long l = videoQuality.f1829n.get(Long.valueOf(value.getSsrc()));
                        if (l != null) {
                            eVar2.f1852d = Long.valueOf(jCurrentTimeMillis - l.longValue());
                            Logger.i$default(videoQuality.f1831p, "VideoQuality: inbound.timeToFirstFrame: " + eVar2.f1852d + " (userId: " + j + ", ssrc: " + value.getSsrc() + ')', null, 2, null);
                        } else {
                            Logger.e$default(videoQuality.f1831p, "VideoQuality: inbound.timeToFirstFrame: Unable to locate start time. (userId: " + j + ", ssrc: " + value.getSsrc() + ')', null, null, 6, null);
                        }
                    }
                }
            }
        }
        KrispOveruseDetector krispOveruseDetector = rtcStatsCollector4.f1814h;
        Objects.requireNonNull(krispOveruseDetector);
        Intrinsics3.checkNotNullParameter(stats2, "stats");
        if (krispOveruseDetector.f18739d.getType() == MediaEngineConnection.Type.DEFAULT && krispOveruseDetector.f18739d.mo296b()) {
            OutboundRtpAudio outboundRtpAudio = stats2.getOutboundRtpAudio();
            if (outboundRtpAudio != null && outboundRtpAudio.getNoiseCancellerIsEnabled()) {
                OutboundRtpAudio outboundRtpAudio2 = krispOveruseDetector.f18737b;
                if (outboundRtpAudio2 != null) {
                    Tuples2<Boolean, Long> tuples2M8451a = krispOveruseDetector.m8451a(outboundRtpAudio2, stats2.getOutboundRtpAudio(), 8.0d);
                    boolean zBooleanValue = tuples2M8451a.component1().booleanValue();
                    long jLongValue = tuples2M8451a.component2().longValue();
                    if (zBooleanValue) {
                        krispOveruseDetector.f18739d.mo300f(KrispOveruseDetector.Status.CPU_OVERUSE);
                    } else if (jLongValue == 0) {
                        int i = krispOveruseDetector.f18738c + 1;
                        krispOveruseDetector.f18738c = i;
                        if (i > 2) {
                            krispOveruseDetector.f18739d.mo300f(KrispOveruseDetector.Status.FAILED);
                        }
                    } else {
                        krispOveruseDetector.f18738c = 0;
                    }
                }
                krispOveruseDetector.f18737b = stats2.getOutboundRtpAudio();
            }
            OutboundRtpAudio outboundRtpAudio3 = stats2.getOutboundRtpAudio();
            if (outboundRtpAudio3 != null && outboundRtpAudio3.getVoiceActivityDetectorIsEnabled()) {
                OutboundRtpAudio outboundRtpAudio4 = krispOveruseDetector.f18736a;
                if (outboundRtpAudio4 != null && krispOveruseDetector.m8451a(outboundRtpAudio4, stats2.getOutboundRtpAudio(), 4.0d).component1().booleanValue()) {
                    krispOveruseDetector.f18739d.mo300f(KrispOveruseDetector.Status.VAD_CPU_OVERUSE);
                }
                krispOveruseDetector.f18736a = stats2.getOutboundRtpAudio();
            }
        }
        return Unit.f27425a;
    }
}
