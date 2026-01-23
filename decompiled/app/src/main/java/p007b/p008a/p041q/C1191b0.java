package p007b.p008a.p041q;

import co.discord.media_engine.StreamParameters;
import co.discord.media_engine.StreamParameters2;
import co.discord.media_engine.VoiceQuality;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.socket.p499io.Payloads;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import org.webrtc.MediaStreamTrack;
import p007b.p008a.p041q.p044m0.Codec2;
import p007b.p008a.p041q.p046n0.RtcControlSocket;
import p007b.p008a.p041q.p047o0.RtcStatsCollector2;
import p007b.p008a.p041q.p047o0.RtcStatsCollector3;
import p007b.p008a.p041q.p047o0.RtcStatsCollector4;
import p007b.p008a.p041q.p047o0.VideoQuality;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t._ArraysJvm;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: renamed from: b.a.q.b0 */
/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1191b0 implements MediaEngineConnection.InterfaceC5648d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ RtcConnection f1606a;

    public C1191b0(RtcConnection rtcConnection) {
        this.f1606a = rtcConnection;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onConnected(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.TransportInfo transportInfo, List<Codec2> list) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(transportInfo, "transportInfo");
        Intrinsics3.checkNotNullParameter(list, "supportedVideoCodecs");
        RtcConnection rtcConnection = this.f1606a;
        rtcConnection.reconnectBackoff.succeed();
        rtcConnection.transportInfo = transportInfo;
        MediaEngineConnection mediaEngineConnection2 = rtcConnection.mediaEngineConnection;
        if (mediaEngineConnection2 != null) {
            RtcStatsCollector4 rtcStatsCollector4 = new RtcStatsCollector4(1000L, rtcConnection.logger, mediaEngineConnection2, new VoiceQuality(), rtcConnection.videoQuality, new KrispOveruseDetector(mediaEngineConnection2), 0, 64);
            rtcStatsCollector4.f1807a.clear();
            Subscription subscription = rtcStatsCollector4.f1808b;
            if (subscription != null && !subscription.isUnsubscribed()) {
                rtcStatsCollector4.m351a();
            }
            rtcStatsCollector4.f1808b = Observable.m11061E(0L, rtcStatsCollector4.f1809c, TimeUnit.MILLISECONDS).m11097W(new RtcStatsCollector2(rtcStatsCollector4), new RtcStatsCollector3(rtcStatsCollector4));
            rtcConnection.rtcStatsCollector = rtcStatsCollector4;
            rtcConnection.sentVideo = false;
        }
        if (transportInfo.protocol.ordinal() != 0) {
            StringBuilder sbM833U = outline.m833U("Unsupported protocol: ");
            sbM833U.append(transportInfo.protocol);
            sbM833U.append('.');
            RtcConnection.m8459j(rtcConnection, true, sbM833U.toString(), null, false, 12);
        } else {
            rtcConnection.logger.recordBreadcrumb("Sending UDP info to RTC server.", rtcConnection.loggingTag);
            RtcControlSocket rtcControlSocket = rtcConnection.socket;
            if (rtcControlSocket == null) {
                RtcConnection.m8460o(rtcConnection, "onEngineConnectionConnected() socket was null.", null, null, 6);
                return;
            }
            String str = transportInfo.address;
            int i = transportInfo.port;
            Intrinsics3.checkNotNullParameter("udp", "protocol");
            Intrinsics3.checkNotNullParameter(str, "address");
            Intrinsics3.checkNotNullParameter("xsalsa20_poly1305", "mode");
            Intrinsics3.checkNotNullParameter(list, "codecs");
            rtcControlSocket.f1773H.m266a();
            Payloads.Protocol.ProtocolInfo protocolInfo = new Payloads.Protocol.ProtocolInfo(str, i, "xsalsa20_poly1305");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            for (Codec2 codec2 : list) {
                arrayList.add(new Payloads.Protocol.CodecInfo(codec2.f1671a, codec2.f1672b, codec2.f1673c, codec2.f1674d, codec2.f1675e));
            }
            rtcControlSocket.m350n(1, new Payloads.Protocol("udp", protocolInfo, arrayList));
        }
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection.InterfaceC5617c) it.next()).onMediaEngineConnectionConnected(rtcConnection);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.ConnectionState connectionState) {
        RtcConnection.State state;
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(connectionState, "connectionState");
        RtcConnection rtcConnection = this.f1606a;
        RtcConnection.StateChange stateChange = rtcConnection.connectionStateChange;
        rtcConnection.m8475r("Connection state change: " + connectionState);
        int iOrdinal = connectionState.ordinal();
        if (iOrdinal == 0) {
            state = RtcConnection.State.C5614h.f18816a;
        } else if (iOrdinal == 1) {
            state = RtcConnection.State.C5613g.f18815a;
        } else if (iOrdinal == 2) {
            state = RtcConnection.State.C5612f.f18814a;
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            state = RtcConnection.State.C5611e.f18813a;
        }
        rtcConnection.m8478u(state);
        if (stateChange.state == RtcConnection.State.C5613g.f18815a && rtcConnection.connectionStateChange.state == RtcConnection.State.C5614h.f18816a) {
            rtcConnection.m8474q();
        }
        if (rtcConnection.connectionStateChange.state == RtcConnection.State.C5612f.f18814a) {
            rtcConnection.connectCompletedTime = Long.valueOf(rtcConnection.clock.currentTimeMillis());
            rtcConnection.connected = true;
            Map<String, Object> mapMutableMapOf = Maps6.mutableMapOf(Tuples.m10073to("connect_count", Integer.valueOf(rtcConnection.connectCount)));
            Long l = rtcConnection.connectStartTime;
            Long l2 = rtcConnection.connectCompletedTime;
            Long lValueOf = (l2 == null || l == null) ? null : Long.valueOf(l2.longValue() - l.longValue());
            if (lValueOf != null) {
                mapMutableMapOf.put("connect_time", Long.valueOf(lValueOf.longValue()));
            }
            rtcConnection.m8461b(mapMutableMapOf);
            rtcConnection.m8473p(RtcConnection.AnalyticsEvent.VOICE_CONNECTION_SUCCESS, mapMutableMapOf);
            MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
            if (mediaSinkWantsManager != null) {
                mediaSinkWantsManager.m8454b(new MediaSinkWantsManager4(mediaSinkWantsManager, rtcConnection.mediaEngineConnection));
            }
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onDestroy(MediaEngineConnection mediaEngineConnection) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onError(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.FailedConnectionException failedConnectionException) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(failedConnectionException, "exception");
        RtcConnection rtcConnection = this.f1606a;
        Objects.requireNonNull(rtcConnection);
        String str = "connection error: " + failedConnectionException.getType();
        int iOrdinal = failedConnectionException.getType().ordinal();
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
            StringBuilder sbM836X = outline.m836X(str, " -- ");
            sbM836X.append(failedConnectionException.getMessage());
            rtcConnection.m8475r(sbM836X.toString());
        } else {
            RtcConnection.AnalyticsEvent analyticsEvent = RtcConnection.AnalyticsEvent.VOICE_CONNECTION_FAILURE;
            Map<String, Object> mapMutableMapOf = Maps6.mutableMapOf(Tuples.m10073to("connect_count", Integer.valueOf(rtcConnection.connectCount)));
            rtcConnection.m8461b(mapMutableMapOf);
            rtcConnection.m8473p(analyticsEvent, mapMutableMapOf);
        }
        RtcConnection.m8459j(rtcConnection, true, str, failedConnectionException, false, 8);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onKrispStatus(MediaEngineConnection mediaEngineConnection, KrispOveruseDetector.Status status) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(status, "status");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onLocalMute(long j, boolean z2) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onLocalVideoOffScreen(long j, boolean z2) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onSpeaking(long j, int i, boolean z2) {
        RtcControlSocket rtcControlSocket;
        RtcConnection rtcConnection = this.f1606a;
        if (j == rtcConnection.userId && (rtcControlSocket = rtcConnection.socket) != null) {
            rtcControlSocket.f1773H.m266a();
            rtcControlSocket.m350n(5, new Payloads.Speaking(i, Integer.valueOf(z2 ? 1 : 0), 0, null, 8, null));
        }
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection.InterfaceC5617c) it.next()).onSpeaking(j, z2);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onTargetBitrate(int i) {
        VideoQuality videoQuality = this.f1606a.videoQuality;
        synchronized (videoQuality) {
            videoQuality.f1827l.f1859k = i;
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onTargetFrameRate(int i) {
        VideoQuality videoQuality = this.f1606a.videoQuality;
        synchronized (videoQuality) {
            videoQuality.f1827l.f1860l = i;
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onVideo(long j, Integer num, int i, int i2, int i3, StreamParameters[] streamParametersArr) {
        Intrinsics3.checkNotNullParameter(streamParametersArr, "streams");
        RtcConnection rtcConnection = this.f1606a;
        List<StreamParameters> listAsList = _ArraysJvm.asList(streamParametersArr);
        if (j == rtcConnection.userId) {
            RtcControlSocket rtcControlSocket = rtcConnection.socket;
            if (rtcControlSocket == null) {
                RtcConnection.m8460o(rtcConnection, "sendVideo() socket was null.", null, null, 6);
            } else {
                rtcConnection.videoSsrc = i2;
                if (i2 != 0) {
                    rtcConnection.sentVideo = true;
                }
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listAsList, 10));
                for (StreamParameters streamParameters : listAsList) {
                    String str = streamParameters.getType() == StreamParameters2.Audio ? MediaStreamTrack.AUDIO_TRACK_KIND : MediaStreamTrack.VIDEO_TRACK_KIND;
                    String rid = streamParameters.getRid();
                    Integer numValueOf = Integer.valueOf(streamParameters.getSsrc());
                    Integer numValueOf2 = Integer.valueOf(streamParameters.getRtxSsrc());
                    Boolean boolValueOf = Boolean.valueOf(streamParameters.getActive());
                    Integer numValueOf3 = Integer.valueOf(streamParameters.getMaxBitrate());
                    Integer numValueOf4 = Integer.valueOf(streamParameters.getQuality());
                    MediaSinkWantsLadder5 mediaSinkWantsLadder5 = MediaSinkWantsLadder4.f1625a;
                    Integer numValueOf5 = Integer.valueOf(mediaSinkWantsLadder5.f1636b.f1604c);
                    Payloads.ResolutionType resolutionType = Payloads.ResolutionType.Fixed;
                    MediaSinkWantsLadder2 mediaSinkWantsLadder2 = mediaSinkWantsLadder5.f1636b;
                    arrayList.add(new Payloads.Stream(str, rid, numValueOf5, numValueOf4, numValueOf, numValueOf2, new Payloads.Stream.MaxResolution(resolutionType, mediaSinkWantsLadder2.f1602a, mediaSinkWantsLadder2.f1603b), boolValueOf, numValueOf3));
                }
                Intrinsics3.checkNotNullParameter(arrayList, "streams");
                rtcControlSocket.f1773H.m266a();
                rtcControlSocket.m350n(12, new Payloads.Video(i, i2, i3, null, arrayList));
            }
            MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
            if (mediaSinkWantsManager != null) {
                mediaSinkWantsManager.m8454b(new MediaSinkWantsManager6(mediaSinkWantsManager, i2 != 0));
            }
        }
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection.InterfaceC5617c) it.next()).onVideoStream(j, num, i, i2, i3);
        }
    }
}
