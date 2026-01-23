package p007b.p008a.p041q;

import co.discord.media_engine.StreamParameters;
import co.discord.media_engine.StreamParameters2;
import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.rtcconnection.MediaSinkWantsManager9;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.socket.p499io.Payloads;
import com.discord.utilities.logging.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import org.webrtc.MediaStreamTrack;
import p007b.p008a.p041q.MediaSinkWantsLadder3;
import p007b.p008a.p041q.p046n0.RtcControlSocket;
import p007b.p008a.p041q.p047o0.RtcStatsCollector4;
import p007b.p008a.p041q.p047o0.VideoQuality;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t.MutableCollections;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.q.h0 */
/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1203h0 implements RtcControlSocket.d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ RtcConnection f1628a;

    public C1203h0(RtcConnection rtcConnection) {
        this.f1628a = rtcConnection;
    }

    @Override // p007b.p008a.p041q.p046n0.RtcControlSocket.d
    /* JADX INFO: renamed from: a */
    public void mo267a(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "audioCodec");
        Intrinsics3.checkNotNullParameter(str2, "videoCodec");
        MediaEngineConnection mediaEngineConnection = this.f1628a.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.mo312r(str, str2);
        }
    }

    @Override // p007b.p008a.p041q.p046n0.RtcControlSocket.d
    /* JADX INFO: renamed from: b */
    public void mo268b(boolean z2, Integer num, String str) {
        RtcConnection rtcConnection = this.f1628a;
        Objects.requireNonNull(rtcConnection);
        rtcConnection.m8475r("Disconnected from RTC server. wasFatal: " + z2 + " -- code: " + num + " -- reason: " + str);
        MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.destroy();
        }
        MediaEngineConnection mediaEngineConnection2 = rtcConnection.mediaEngineConnection;
        if (mediaEngineConnection2 != null) {
            mediaEngineConnection2.mo309o(rtcConnection.mediaEngineConnectionListener);
        }
        Long l = rtcConnection.networkLossTime;
        boolean z3 = (num == null || num.intValue() != 1000) && !(((l != null ? rtcConnection.clock.currentTimeMillis() - l.longValue() : 0L) > 30000L ? 1 : ((l != null ? rtcConnection.clock.currentTimeMillis() - l.longValue() : 0L) == 30000L ? 0 : -1)) > 0);
        if (!(rtcConnection.connectionStateChange.state instanceof RtcConnection.State.C5610d)) {
            rtcConnection.m8472n(z3, str);
            RtcStatsCollector4 rtcStatsCollector4 = rtcConnection.rtcStatsCollector;
            if (rtcStatsCollector4 != null) {
                rtcStatsCollector4.m351a();
            }
            rtcConnection.rtcStatsCollector = null;
            rtcConnection.sentVideo = false;
        }
        rtcConnection.pingBadCount = 0;
        rtcConnection.connectCompletedTime = null;
        MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
        if (mediaSinkWantsManager != null) {
            mediaSinkWantsManager.m8454b(new MediaSinkWantsManager2(mediaSinkWantsManager));
        }
        rtcConnection.m8478u(new RtcConnection.State.C5610d(z3));
        if (z3) {
            Logger.w$default(rtcConnection.logger, rtcConnection.loggingTag, "Disconnect was not clean! Reason: " + str + ", code: " + num + ". Reconnecting in " + (rtcConnection.reconnectBackoff.fail(new C1195d0(rtcConnection)) / ((long) 1000)) + " seconds.", null, 4, null);
        }
    }

    @Override // p007b.p008a.p041q.p046n0.RtcControlSocket.d
    /* JADX INFO: renamed from: c */
    public void mo269c(String str, List<Integer> list) {
        Intrinsics3.checkNotNullParameter(str, "mode");
        Intrinsics3.checkNotNullParameter(list, "secretKey");
        MediaEngineConnection mediaEngineConnection = this.f1628a.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.mo314t(str, _Collections.toIntArray(list));
        }
    }

    @Override // p007b.p008a.p041q.p046n0.RtcControlSocket.d
    /* JADX INFO: renamed from: d */
    public void mo270d(String str) {
        Intrinsics3.checkNotNullParameter(str, "mediaSessionId");
        RtcConnection rtcConnection = this.f1628a;
        rtcConnection.mediaSessionId = str;
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection.InterfaceC5617c) it.next()).onMediaSessionIdReceived();
        }
        rtcConnection.m8473p(RtcConnection.AnalyticsEvent.MEDIA_SESSION_JOINED, new LinkedHashMap());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014e  */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.util.List] */
    @Override // p007b.p008a.p041q.p046n0.RtcControlSocket.d
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo271e(long j, int i, int i2, List<Payloads.Stream> list) {
        VideoMetadata videoMetadata;
        Object next;
        ?? EmptyList;
        RtcConnection rtcConnection = this.f1628a;
        VideoQuality videoQuality = rtcConnection.videoQuality;
        long j2 = i2;
        synchronized (videoQuality) {
            if (j2 != 0) {
                videoQuality.f1829n.put(Long.valueOf(j2), Long.valueOf(videoQuality.f1832q.currentTimeMillis()));
                Logger.i$default(videoQuality.f1831p, "VideoQuality: handleVideoStreamUpdate(userId: " + j + ", videoSsrc: " + j2 + ')', null, 2, null);
            }
        }
        if (j != rtcConnection.userId) {
            if (rtcConnection.localMediaSinkWantsManager != null) {
                if (list != null) {
                    EmptyList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        EmptyList.add(Payloads.Stream.copy$default((Payloads.Stream) it.next(), MediaStreamTrack.VIDEO_TRACK_KIND, null, null, null, null, null, null, Boolean.valueOf(i2 > 0), null, 382, null));
                    }
                } else {
                    EmptyList = Collections2.emptyList();
                }
                boolean zIsEmpty = EmptyList.isEmpty();
                ?? ListOf = EmptyList;
                if (zIsEmpty) {
                    ListOf = CollectionsJVM.listOf(new Payloads.Stream(MediaStreamTrack.VIDEO_TRACK_KIND, "100", null, 100, Integer.valueOf(i2), Integer.valueOf(i2 + 1), null, Boolean.valueOf(i2 > 0), null));
                }
                rtcConnection.localMediaSinkWantsManager.m8455c(j, Long.valueOf(i));
                MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
                Objects.requireNonNull(mediaSinkWantsManager);
                Intrinsics3.checkNotNullParameter(ListOf, "ssrcs");
                mediaSinkWantsManager.m8454b(new MediaSinkWantsManager7(mediaSinkWantsManager, ListOf, j));
                return;
            }
            if (list != null) {
                Iterator it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    Payloads.Stream stream = (Payloads.Stream) next;
                    Integer ssrc = stream.getSsrc();
                    if ((ssrc == null || ssrc.intValue() != i2 || stream.getMaxResolution() == null) ? false : true) {
                        break;
                    }
                }
                Payloads.Stream stream2 = (Payloads.Stream) next;
                if (stream2 != null) {
                    Payloads.Stream.MaxResolution maxResolution = stream2.getMaxResolution();
                    Intrinsics3.checkNotNull(maxResolution);
                    videoMetadata = new VideoMetadata(j, maxResolution.getWidth(), stream2.getMaxResolution().getHeight(), stream2.getMaxFrameRate(), stream2.getMaxResolution().getType());
                } else {
                    videoMetadata = null;
                }
            }
            rtcConnection.m8463d(j, i, j2, videoMetadata);
        }
    }

    @Override // p007b.p008a.p041q.p046n0.RtcControlSocket.d
    /* JADX INFO: renamed from: f */
    public void mo272f(Map<String, Integer> map) {
        Integer num;
        Intrinsics3.checkNotNullParameter(map, "wants");
        RtcConnection rtcConnection = this.f1628a;
        if (rtcConnection.localMediaSinkWantsManager != null) {
            long j = rtcConnection.videoSsrc;
            int iIntValue = (j == 0 || (num = map.get(String.valueOf(j))) == null) ? 0 : num.intValue();
            Integer num2 = map.get("any");
            int iIntValue2 = num2 != null ? num2.intValue() : 0;
            if (iIntValue <= 0) {
                iIntValue = iIntValue2 > 0 ? iIntValue2 : 100;
            }
            MediaSinkWantsLadder3.c cVar = null;
            rtcConnection.logger.mo8366i(rtcConnection.loggingTag, "remote MediaSinkWants: " + map + ", decided on encode quality " + iIntValue, null);
            MediaSinkWantsManager9[] mediaSinkWantsManager9ArrValues = MediaSinkWantsManager9.values();
            for (int i = 10; i >= 0; i--) {
                MediaSinkWantsManager9 mediaSinkWantsManager9 = mediaSinkWantsManager9ArrValues[i];
                if (mediaSinkWantsManager9.getValue() <= iIntValue) {
                    MediaSinkWantsLadder3 mediaSinkWantsLadder3 = rtcConnection.localMediaSinkWantsManager.f18751j;
                    MediaSinkWantsLadder5 mediaSinkWantsLadder5 = mediaSinkWantsLadder3.f1617e;
                    Intrinsics3.checkNotNullParameter(mediaSinkWantsManager9, "wantValue");
                    List<MediaSinkWantsLadder3.c> list = mediaSinkWantsLadder3.f1616d;
                    ListIterator<MediaSinkWantsLadder3.c> listIterator = list.listIterator(list.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            break;
                        }
                        MediaSinkWantsLadder3.c cVarPrevious = listIterator.previous();
                        if (mediaSinkWantsManager9.compareTo(cVarPrevious.f1624c) >= 0) {
                            cVar = cVarPrevious;
                            break;
                        }
                    }
                    MediaSinkWantsLadder3.c cVar2 = cVar;
                    if (cVar2 == null) {
                        cVar2 = (MediaSinkWantsLadder3.c) _Collections.first((List) mediaSinkWantsLadder3.f1616d);
                    }
                    MediaSinkWantsLadder6 mediaSinkWantsLadder6 = cVar2.f1622a;
                    int iMax = Math.max((int) (((double) mediaSinkWantsLadder5.f1637c.f1599a) * mediaSinkWantsLadder6.f1760c), mediaSinkWantsLadder5.f1638d);
                    int iMax2 = Math.max((int) (((double) mediaSinkWantsLadder5.f1637c.f1600b) * mediaSinkWantsLadder6.f1760c), mediaSinkWantsLadder5.f1638d);
                    MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
                    if (mediaEngineConnection != null) {
                        mediaEngineConnection.mo307m(new MediaEngineConnection.C5646b(iMax, iMax2, mediaSinkWantsLadder6.f1758a, mediaSinkWantsLadder6.f1759b, mediaSinkWantsLadder6.f1761d, mediaSinkWantsLadder6.f1762e));
                        return;
                    }
                    return;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
    }

    @Override // p007b.p008a.p041q.p046n0.RtcControlSocket.d
    /* JADX INFO: renamed from: g */
    public void mo273g(long j) {
        RtcConnection rtcConnection = this.f1628a;
        rtcConnection.pings.add(Long.valueOf(j));
        if (rtcConnection.pings.size() > 5) {
            MutableCollections.removeFirst(rtcConnection.pings);
        }
        if (j > 500) {
            rtcConnection.pingBadCount++;
        }
        double d = j;
        Objects.requireNonNull(RtcConnection.Quality.INSTANCE);
        RtcConnection.Quality quality = Double.isNaN(d) ? RtcConnection.Quality.UNKNOWN : d < ((double) 250) ? RtcConnection.Quality.FINE : d < ((double) 500) ? RtcConnection.Quality.AVERAGE : RtcConnection.Quality.BAD;
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection.InterfaceC5617c) it.next()).onQualityUpdate(quality);
        }
    }

    @Override // p007b.p008a.p041q.p046n0.RtcControlSocket.d
    /* JADX INFO: renamed from: h */
    public void mo274h() {
    }

    @Override // p007b.p008a.p041q.p046n0.RtcControlSocket.d
    /* JADX INFO: renamed from: i */
    public void mo275i() {
        RtcConnection rtcConnection = this.f1628a;
        rtcConnection.reconnectBackoff.cancel();
        rtcConnection.logger.recordBreadcrumb("Connected to RTC server.", rtcConnection.loggingTag);
        RtcControlSocket rtcControlSocket = rtcConnection.socket;
        if (rtcControlSocket == null) {
            RtcConnection.m8460o(rtcConnection, "onSocketConnect() socket was null.", null, null, 6);
            return;
        }
        List listListOf = CollectionsJVM.listOf(new Payloads.Stream(MediaStreamTrack.VIDEO_TRACK_KIND, "100", null, 100, null, null, null, null, null));
        String str = rtcConnection.rtcServerId;
        long j = rtcConnection.userId;
        String str2 = rtcConnection.sessionId;
        boolean z2 = rtcConnection.isVideoEnabled;
        Intrinsics3.checkNotNullParameter(str, "serverId");
        Intrinsics3.checkNotNullParameter(str2, "sessionId");
        Intrinsics3.checkNotNullParameter(listListOf, "streams");
        rtcControlSocket.f1773H.m266a();
        rtcControlSocket.f1783t = str;
        rtcControlSocket.f1784u = str2;
        rtcControlSocket.f1767B = RtcControlSocket.c.IDENTIFYING;
        rtcControlSocket.m350n(0, new Payloads.Identify(str, j, str2, rtcControlSocket.f1770E, z2, listListOf));
        rtcConnection.m8478u(RtcConnection.State.C5607a.f18809a);
    }

    @Override // p007b.p008a.p041q.p046n0.RtcControlSocket.d
    /* JADX INFO: renamed from: j */
    public void mo276j(long j) {
        Map<String, Object> mapM354c;
        RtcConnection rtcConnection = this.f1628a;
        if ((rtcConnection.rtcConnectionType instanceof RtcConnection.AbstractC5618d.a) && (mapM354c = rtcConnection.videoQuality.m354c(String.valueOf(j))) != null) {
            rtcConnection.m8470l(j, mapM354c);
        }
        MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
        if (mediaSinkWantsManager != null) {
            mediaSinkWantsManager.m8455c(j, null);
        }
        MediaSinkWantsManager mediaSinkWantsManager2 = rtcConnection.localMediaSinkWantsManager;
        if (mediaSinkWantsManager2 != null) {
            List listEmptyList = Collections2.emptyList();
            Intrinsics3.checkNotNullParameter(listEmptyList, "ssrcs");
            mediaSinkWantsManager2.m8454b(new MediaSinkWantsManager7(mediaSinkWantsManager2, listEmptyList, j));
        }
    }

    @Override // p007b.p008a.p041q.p046n0.RtcControlSocket.d
    /* JADX INFO: renamed from: k */
    public void mo277k(int i, int i2, String str, List<Payloads.Stream> list) {
        MediaEngineConnection.Type type;
        Intrinsics3.checkNotNullParameter(str, "ip");
        Intrinsics3.checkNotNullParameter(list, "streams");
        RtcConnection rtcConnection = this.f1628a;
        Objects.requireNonNull(rtcConnection);
        rtcConnection.m8475r("Discovered dedicated UDP server on port " + i);
        rtcConnection.m8478u(RtcConnection.State.C5613g.f18815a);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        for (Iterator it = list.iterator(); it.hasNext(); it = it) {
            Payloads.Stream stream = (Payloads.Stream) it.next();
            StreamParameters2 streamParameters2 = MediaStreamTrack.VIDEO_TRACK_KIND.equals(stream.getType()) ? StreamParameters2.Video : StreamParameters2.Audio;
            String rid = stream.getRid();
            if (rid == null) {
                rid = "";
            }
            String str2 = rid;
            Integer ssrc = stream.getSsrc();
            int iIntValue = ssrc != null ? ssrc.intValue() : 0;
            Integer rtxSsrc = stream.getRtxSsrc();
            int iIntValue2 = rtxSsrc != null ? rtxSsrc.intValue() : 0;
            Boolean active = stream.getActive();
            boolean zBooleanValue = active != null ? active.booleanValue() : false;
            Integer maxBitrate = stream.getMaxBitrate();
            int iIntValue3 = maxBitrate != null ? maxBitrate.intValue() : 0;
            Integer quality = stream.getQuality();
            arrayList.add(new StreamParameters(streamParameters2, str2, iIntValue, iIntValue2, zBooleanValue, iIntValue3, quality != null ? quality.intValue() : 100, 0));
        }
        boolean zIsEmpty = arrayList.isEmpty();
        List listListOf = arrayList;
        if (zIsEmpty) {
            listListOf = CollectionsJVM.listOf(new StreamParameters(StreamParameters2.Video, "100", i2 + 1, i2 + 2, false, 0, 100, 0));
        }
        MediaEngine mediaEngine = rtcConnection.mediaEngine;
        long j = rtcConnection.userId;
        MediaEngine.C5640a c5640a = new MediaEngine.C5640a(i2, str, i, listListOf);
        RtcConnection.AbstractC5618d abstractC5618d = rtcConnection.rtcConnectionType;
        if (Intrinsics3.areEqual(abstractC5618d, RtcConnection.AbstractC5618d.a.f18819a)) {
            type = MediaEngineConnection.Type.DEFAULT;
        } else {
            if (!(abstractC5618d instanceof RtcConnection.AbstractC5618d.b)) {
                throw new NoWhenBranchMatchedException();
            }
            type = MediaEngineConnection.Type.STREAM;
        }
        MediaEngineConnection mediaEngineConnectionMo327g = mediaEngine.mo327g(j, c5640a, type, new C1197e0(rtcConnection));
        if (mediaEngineConnectionMo327g == null) {
            RtcConnection.m8460o(rtcConnection, "onSocketHello(): connect() return null.", null, null, 6);
        } else {
            mediaEngineConnectionMo327g.mo306l(rtcConnection.mediaEngineConnectionListener);
            rtcConnection.mediaEngineConnection = mediaEngineConnectionMo327g;
        }
    }

    @Override // p007b.p008a.p041q.p046n0.RtcControlSocket.d
    public void onConnecting() {
        RtcConnection rtcConnection = this.f1628a;
        rtcConnection.reconnectBackoff.cancel();
        StringBuilder sb = new StringBuilder();
        sb.append("Connecting to RTC server ");
        RtcControlSocket rtcControlSocket = rtcConnection.socket;
        sb.append(rtcControlSocket != null ? rtcControlSocket.f1769D : null);
        rtcConnection.m8475r(sb.toString());
        rtcConnection.m8478u(RtcConnection.State.C5609c.f18811a);
    }

    @Override // p007b.p008a.p041q.p046n0.RtcControlSocket.d
    public void onSpeaking(long j, int i, boolean z2) {
        RtcConnection rtcConnection = this.f1628a;
        if (j != rtcConnection.userId) {
            MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
            if (mediaEngineConnection != null) {
                mediaEngineConnection.mo313s(j, i, null, rtcConnection.m8466g(j), rtcConnection.m8467h(j));
            }
            MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
            if (mediaSinkWantsManager != null) {
                mediaSinkWantsManager.m8455c(j, Long.valueOf(i));
            }
            Iterator<T> it = rtcConnection.listeners.iterator();
            while (it.hasNext()) {
                ((RtcConnection.InterfaceC5617c) it.next()).onUserCreated(rtcConnection, j);
            }
        }
    }
}
