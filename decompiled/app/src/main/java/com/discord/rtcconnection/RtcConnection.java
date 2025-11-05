package com.discord.rtcconnection;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import b.a.q.a0;
import b.a.q.b0;
import b.a.q.f0;
import b.a.q.g;
import b.a.q.g0;
import b.a.q.h0;
import b.a.q.j;
import b.a.q.n0.a;
import b.a.q.p;
import b.a.q.q;
import b.a.q.r;
import b.a.q.x;
import b.a.q.z;
import co.discord.media_engine.InboundRtpAudio;
import co.discord.media_engine.OutboundRtpAudio;
import co.discord.media_engine.Stats;
import co.discord.media_engine.VoiceQuality;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.mediaengine.ThumbnailEmitter;
import com.discord.utilities.debug.DebugPrintBuilder;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.time.Clock;
import d0.g0.s;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* compiled from: RtcConnection.kt */
/* loaded from: classes.dex */
public final class RtcConnection implements DebugPrintable, MediaSinkWantsManager.a {
    public static int j;

    /* renamed from: A, reason: from kotlin metadata */
    public int pingBadCount;

    /* renamed from: B, reason: from kotlin metadata */
    public final b.a.q.o0.e videoQuality;

    /* renamed from: C, reason: from kotlin metadata */
    public Long connectStartTime;

    /* renamed from: D, reason: from kotlin metadata */
    public Long connectCompletedTime;

    /* renamed from: E, reason: from kotlin metadata */
    public int connectCount;

    /* renamed from: F, reason: from kotlin metadata */
    public Subscription mediaEnginePrepareSubscription;

    /* renamed from: G, reason: from kotlin metadata */
    public Long networkLossTime;

    /* renamed from: H, reason: from kotlin metadata */
    public final MediaSinkWantsManager localMediaSinkWantsManager;

    /* renamed from: I, reason: from kotlin metadata */
    public final Subscription localMediaSinkWantsSubscription;

    /* renamed from: J, reason: from kotlin metadata */
    public boolean connected;

    /* renamed from: K, reason: from kotlin metadata */
    public String mediaSessionId;

    /* renamed from: L, reason: from kotlin metadata */
    public long videoSsrc;

    /* renamed from: M, reason: from kotlin metadata */
    public final h0 socketListener;

    /* renamed from: N, reason: from kotlin metadata */
    public final b0 mediaEngineConnectionListener;

    /* renamed from: O, reason: from kotlin metadata */
    public final Long guildId;

    /* renamed from: P, reason: from kotlin metadata */
    public final long channelId;

    /* renamed from: Q, reason: from kotlin metadata */
    public String sessionId;

    /* renamed from: R, reason: from kotlin metadata */
    public final boolean isVideoEnabled;

    /* renamed from: S, reason: from kotlin metadata */
    public final String rtcServerId;

    /* renamed from: T, reason: from kotlin metadata */
    public final long userId;

    /* renamed from: U, reason: from kotlin metadata */
    public final MediaEngine mediaEngine;

    /* renamed from: V, reason: from kotlin metadata */
    public final Logger logger;

    /* renamed from: W, reason: from kotlin metadata */
    public final Clock clock;

    /* renamed from: X, reason: from kotlin metadata */
    public final d rtcConnectionType;

    /* renamed from: Y, reason: from kotlin metadata */
    public final Map<Long, Boolean> mutedUsers;

    /* renamed from: Z, reason: from kotlin metadata */
    public final Map<Long, Float> userVolumes;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    public final String parentMediaSessionId;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    public final boolean enableMediaSinkWants;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    public final String loggingTagPrefix;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    public final String streamKey;

    /* renamed from: l, reason: from kotlin metadata */
    public final String loggingTag;

    /* renamed from: m, reason: from kotlin metadata */
    public final String id;

    /* renamed from: n, reason: from kotlin metadata */
    public final CopyOnWriteArrayList<c> listeners;

    /* renamed from: o, reason: from kotlin metadata */
    public b.a.q.o0.d rtcStatsCollector;

    /* renamed from: p, reason: from kotlin metadata */
    public boolean sentVideo;

    /* renamed from: q, reason: from kotlin metadata */
    public final Backoff reconnectBackoff;

    /* renamed from: r, reason: from kotlin metadata */
    public MediaEngineConnection.TransportInfo transportInfo;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public StateChange connectionStateChange;

    /* renamed from: t, reason: from kotlin metadata */
    public BehaviorSubject<StateChange> connectionStateSubject;

    /* renamed from: u, reason: from kotlin metadata */
    public boolean destroyed;

    /* renamed from: v, reason: from kotlin metadata */
    public List<Long> pings;

    /* renamed from: w, reason: from kotlin metadata */
    public a socket;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public MediaEngineConnection mediaEngineConnection;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public String hostname;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public Integer port;

    /* compiled from: RtcConnection.kt */
    public enum AnalyticsEvent {
        VOICE_CONNECTION_SUCCESS,
        VOICE_CONNECTION_FAILURE,
        VOICE_DISCONNECT,
        VIDEO_STREAM_ENDED,
        MEDIA_SESSION_JOINED
    }

    /* compiled from: RtcConnection.kt */
    public static final /* data */ class Metadata {

        /* renamed from: a, reason: from kotlin metadata */
        public final String rtcConnectionId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final String mediaSessionId;

        /* renamed from: c, reason: from kotlin metadata */
        public final Long channelId;

        /* renamed from: d, reason: from kotlin metadata */
        public final Long guildId;

        /* renamed from: e, reason: from kotlin metadata */
        public final String streamKey;

        public Metadata(String str, String str2, Long l, Long l2, String str3) {
            m.checkNotNullParameter(str, "rtcConnectionId");
            this.rtcConnectionId = str;
            this.mediaSessionId = str2;
            this.channelId = l;
            this.guildId = l2;
            this.streamKey = str3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Metadata)) {
                return false;
            }
            Metadata metadata = (Metadata) other;
            return m.areEqual(this.rtcConnectionId, metadata.rtcConnectionId) && m.areEqual(this.mediaSessionId, metadata.mediaSessionId) && m.areEqual(this.channelId, metadata.channelId) && m.areEqual(this.guildId, metadata.guildId) && m.areEqual(this.streamKey, metadata.streamKey);
        }

        public int hashCode() {
            String str = this.rtcConnectionId;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.mediaSessionId;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Long l = this.channelId;
            int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
            Long l2 = this.guildId;
            int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
            String str3 = this.streamKey;
            return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("Metadata(rtcConnectionId=");
            sbU.append(this.rtcConnectionId);
            sbU.append(", mediaSessionId=");
            sbU.append(this.mediaSessionId);
            sbU.append(", channelId=");
            sbU.append(this.channelId);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", streamKey=");
            return b.d.b.a.a.J(sbU, this.streamKey, ")");
        }
    }

    /* compiled from: RtcConnection.kt */
    public enum Quality {
        UNKNOWN,
        BAD,
        AVERAGE,
        FINE;


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* compiled from: RtcConnection.kt */
        /* renamed from: com.discord.rtcconnection.RtcConnection$Quality$a, reason: from kotlin metadata */
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }
    }

    /* compiled from: RtcConnection.kt */
    public static abstract class State {

        /* compiled from: RtcConnection.kt */
        public static final class a extends State {
            public static final a a = new a();

            public a() {
                super(null);
            }
        }

        /* compiled from: RtcConnection.kt */
        public static final class b extends State {
            public static final b a = new b();

            public b() {
                super(null);
            }
        }

        /* compiled from: RtcConnection.kt */
        public static final class c extends State {
            public static final c a = new c();

            public c() {
                super(null);
            }
        }

        /* compiled from: RtcConnection.kt */
        public static final class d extends State {
            public final boolean a;

            public d(boolean z2) {
                super(null);
                this.a = z2;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof d) && this.a == ((d) obj).a;
                }
                return true;
            }

            public int hashCode() {
                boolean z2 = this.a;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            @Override // com.discord.rtcconnection.RtcConnection.State
            public String toString() {
                return b.d.b.a.a.O(b.d.b.a.a.U("Disconnected(willReconnect="), this.a, ")");
            }
        }

        /* compiled from: RtcConnection.kt */
        public static final class e extends State {
            public static final e a = new e();

            public e() {
                super(null);
            }
        }

        /* compiled from: RtcConnection.kt */
        public static final class f extends State {
            public static final f a = new f();

            public f() {
                super(null);
            }
        }

        /* compiled from: RtcConnection.kt */
        public static final class g extends State {
            public static final g a = new g();

            public g() {
                super(null);
            }
        }

        /* compiled from: RtcConnection.kt */
        public static final class h extends State {
            public static final h a = new h();

            public h() {
                super(null);
            }
        }

        public State() {
        }

        public String toString() {
            if (this instanceof d) {
                return super.toString();
            }
            String simpleName = getClass().getSimpleName();
            m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            return simpleName;
        }

        public State(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: RtcConnection.kt */
    public static final /* data */ class StateChange {

        /* renamed from: a, reason: from kotlin metadata */
        public final State state;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Metadata metadata;

        public StateChange(State state, Metadata metadata) {
            m.checkNotNullParameter(state, "state");
            this.state = state;
            this.metadata = metadata;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StateChange)) {
                return false;
            }
            StateChange stateChange = (StateChange) other;
            return m.areEqual(this.state, stateChange.state) && m.areEqual(this.metadata, stateChange.metadata);
        }

        public int hashCode() {
            State state = this.state;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            Metadata metadata = this.metadata;
            return iHashCode + (metadata != null ? metadata.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("StateChange(state=");
            sbU.append(this.state);
            sbU.append(", metadata=");
            sbU.append(this.metadata);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: RtcConnection.kt */
    public static abstract class b implements c {
        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onAnalyticsEvent(AnalyticsEvent analyticsEvent, Map<String, Object> map) {
            m.checkNotNullParameter(analyticsEvent, "event");
            m.checkNotNullParameter(map, "properties");
        }

        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onFatalClose() {
        }

        public void onFirstFrameReceived(long j) {
        }

        public void onFirstFrameSent() {
        }

        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onMediaEngineConnectionConnected(RtcConnection rtcConnection) {
            m.checkNotNullParameter(rtcConnection, "connection");
        }

        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onMediaSessionIdReceived() {
        }

        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onQualityUpdate(Quality quality) {
            m.checkNotNullParameter(quality, "quality");
        }

        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onSpeaking(long j, boolean z2) {
        }

        @Override // com.discord.rtcconnection.RtcConnection.c
        public abstract void onStateChange(StateChange stateChange);

        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onUserCreated(RtcConnection rtcConnection, long j) {
            m.checkNotNullParameter(rtcConnection, "connection");
        }

        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onVideoMetadata(VideoMetadata videoMetadata) {
            m.checkNotNullParameter(videoMetadata, "metadata");
        }

        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onVideoStream(long j, Integer num, int i, int i2, int i3) {
        }
    }

    /* compiled from: RtcConnection.kt */
    public interface c {
        void onAnalyticsEvent(AnalyticsEvent analyticsEvent, Map<String, Object> map);

        void onFatalClose();

        void onMediaEngineConnectionConnected(RtcConnection rtcConnection);

        void onMediaSessionIdReceived();

        void onQualityUpdate(Quality quality);

        void onSpeaking(long j, boolean z2);

        void onStateChange(StateChange stateChange);

        void onUserCreated(RtcConnection rtcConnection, long j);

        void onVideoMetadata(VideoMetadata videoMetadata);

        void onVideoStream(long j, Integer num, int i, int i2, int i3);
    }

    /* compiled from: RtcConnection.kt */
    public static abstract class d {

        /* compiled from: RtcConnection.kt */
        public static final class a extends d {
            public static final a a = new a();

            public a() {
                super(null);
            }
        }

        /* compiled from: RtcConnection.kt */
        public static final class b extends d {
            public final long a;

            public b(long j) {
                super(null);
                this.a = j;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof b) && this.a == ((b) obj).a;
                }
                return true;
            }

            public int hashCode() {
                return a0.a.a.b.a(this.a);
            }

            public String toString() {
                return b.d.b.a.a.C(b.d.b.a.a.U("Stream(senderId="), this.a, ")");
            }
        }

        public d(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: RtcConnection.kt */
    public static final class e extends o implements Function0<Unit> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            RtcConnection.this.f("Force Close");
            return Unit.a;
        }
    }

    public RtcConnection(Long l, long j2, String str, boolean z2, String str2, long j3, MediaEngine mediaEngine, Logger logger, Clock clock, d dVar, NetworkMonitor networkMonitor, Map map, Map map2, String str3, boolean z3, String str4, String str5, int i) {
        MediaSinkWantsManager mediaSinkWantsManager;
        Subscription subscriptionV;
        d dVar2 = (i & 512) != 0 ? d.a.a : dVar;
        Map linkedHashMap = (i & 2048) != 0 ? new LinkedHashMap() : map;
        LinkedHashMap linkedHashMap2 = (i & 4096) != 0 ? new LinkedHashMap() : null;
        String str6 = (i & 8192) != 0 ? null : str3;
        boolean z4 = (i & 16384) != 0 ? false : z3;
        String str7 = (i & 65536) != 0 ? null : str5;
        m.checkNotNullParameter(str, "sessionId");
        m.checkNotNullParameter(str2, "rtcServerId");
        m.checkNotNullParameter(mediaEngine, "mediaEngine");
        m.checkNotNullParameter(logger, "logger");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(dVar2, "rtcConnectionType");
        boolean z5 = z4;
        m.checkNotNullParameter(networkMonitor, "networkMonitor");
        m.checkNotNullParameter(linkedHashMap, "mutedUsers");
        m.checkNotNullParameter(linkedHashMap2, "userVolumes");
        m.checkNotNullParameter(str4, "loggingTagPrefix");
        this.guildId = l;
        this.channelId = j2;
        this.sessionId = str;
        this.isVideoEnabled = z2;
        this.rtcServerId = str2;
        this.userId = j3;
        this.mediaEngine = mediaEngine;
        this.logger = logger;
        this.clock = clock;
        this.rtcConnectionType = dVar2;
        this.mutedUsers = linkedHashMap;
        this.userVolumes = linkedHashMap2;
        this.parentMediaSessionId = str6;
        this.enableMediaSinkWants = z5;
        this.loggingTagPrefix = str4;
        this.streamKey = str7;
        StringBuilder sbX = b.d.b.a.a.X(str4, "->RtcConnection ");
        int i2 = j + 1;
        j = i2;
        sbX.append(i2);
        this.loggingTag = sbX.toString();
        String string = UUID.randomUUID().toString();
        m.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
        this.id = string;
        CopyOnWriteArrayList<c> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.listeners = copyOnWriteArrayList;
        this.reconnectBackoff = new Backoff(1000L, 10000L, 0, false, null, 28, null);
        StateChange stateChange = new StateChange(new State.d(false), null);
        this.connectionStateChange = stateChange;
        this.connectionStateSubject = BehaviorSubject.l0(stateChange);
        this.pings = new ArrayList();
        b.a.q.o0.e eVar = new b.a.q.o0.e(logger, clock);
        eVar.f.add(new x(this));
        this.videoQuality = eVar;
        if (z5) {
            subscriptionV = null;
            mediaSinkWantsManager = new MediaSinkWantsManager(j3, mediaEngine.c(), new b.a.q.e(null, 1), logger, this);
        } else {
            mediaSinkWantsManager = null;
            subscriptionV = null;
        }
        this.localMediaSinkWantsManager = mediaSinkWantsManager;
        if (z5) {
            m.checkNotNull(mediaSinkWantsManager);
            Observable<Map<String, EncodeQuality>> observableR = mediaSinkWantsManager.f.r();
            m.checkNotNullExpressionValue(observableR, "mediaSinkWantsSubject.distinctUntilChanged()");
            subscriptionV = Observable.j(observableR, this.connectionStateSubject, z.j).V(new g0(new a0(this)));
        }
        this.localMediaSinkWantsSubscription = subscriptionV;
        r("Created RtcConnection. GuildID: " + l + " ChannelID: " + j2);
        networkMonitor.observeIsConnected().S(1).W(new p(this), new q(this));
        copyOnWriteArrayList.add(new r(this));
        this.socketListener = new h0(this);
        this.mediaEngineConnectionListener = new b0(this);
    }

    public static void j(RtcConnection rtcConnection, boolean z2, String str, Throwable th, boolean z3, int i) {
        if ((i & 4) != 0) {
            th = null;
        }
        if ((i & 8) != 0) {
            z3 = true;
        }
        if (z3) {
            o(rtcConnection, str, th, null, 4);
        } else {
            rtcConnection.logger.i(rtcConnection.loggingTag, str, th);
        }
        b.a.q.o0.d dVar = rtcConnection.rtcStatsCollector;
        if (dVar != null) {
            dVar.a();
        }
        rtcConnection.rtcStatsCollector = null;
        MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.destroy();
        }
        rtcConnection.mediaEngineConnection = null;
        rtcConnection.sentVideo = false;
        rtcConnection.reconnectBackoff.cancel();
        rtcConnection.u(new State.d(z2));
        if (z2) {
            rtcConnection.q();
            return;
        }
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((c) it.next()).onFatalClose();
        }
        rtcConnection.f(str);
    }

    public static void o(RtcConnection rtcConnection, String str, Throwable th, Map map, int i) {
        if ((i & 2) != 0) {
            th = null;
        }
        int i2 = i & 4;
        rtcConnection.logger.e(rtcConnection.loggingTag, str, th, null);
    }

    @Override // com.discord.rtcconnection.MediaSinkWantsManager.a
    public void a(long userId, long audioSsrc, long videoSSRC, VideoMetadata metadata) {
        d(userId, audioSsrc, videoSSRC, metadata);
    }

    public final Map<String, Object> b(Map<String, Object> map) {
        String str = this.hostname;
        if (str != null) {
            map.put("hostname", str);
        }
        Integer num = this.port;
        if (num != null) {
            map.put("port", Integer.valueOf(num.intValue()));
        }
        return map;
    }

    public final void c(c listener) {
        m.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void d(long userId, long audioSsrc, long videoSsrc, VideoMetadata metadata) {
        MediaEngineConnection mediaEngineConnection = this.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.s(userId, (int) audioSsrc, Integer.valueOf((int) videoSsrc), g(userId), h(userId));
        }
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((c) it.next()).onUserCreated(this, userId);
        }
        if (metadata != null) {
            Iterator<T> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                ((c) it2.next()).onVideoMetadata(metadata);
            }
        }
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    public void debugPrint(DebugPrintBuilder dp) {
        m.checkNotNullParameter(dp, "dp");
        dp.appendKeyValue(ModelAuditLogEntry.CHANGE_KEY_ID, this.id);
        dp.appendKeyValue("mediaSessionId", this.mediaSessionId);
        dp.appendKeyValue("parentMediaSessionId", this.parentMediaSessionId);
        dp.appendKeyValue("hostname", this.hostname);
        dp.appendKeyValue("channelId", Long.valueOf(this.channelId));
        dp.appendKeyValue("guildId", this.guildId);
        dp.appendKeyValue("streamKey", this.streamKey);
        dp.appendKeyValue("isVideoEnabled", Boolean.valueOf(this.isVideoEnabled));
        dp.appendKeyValue("rtcServerId", this.rtcServerId);
        dp.appendKeyValue("userId", Long.valueOf(this.userId));
        dp.appendKeyValue("rtcConnectionType", this.rtcConnectionType);
        dp.appendKeyValue("enableMediaSinkWants", Boolean.valueOf(this.enableMediaSinkWants));
        dp.appendKeyValue("socket", (DebugPrintable) this.socket);
        dp.appendKeyValue("sentVideo", Boolean.valueOf(this.sentVideo));
    }

    public final void e() {
        s(new e());
    }

    public final void f(String reason) {
        this.reconnectBackoff.cancel();
        a aVar = this.socket;
        if (aVar != null) {
            aVar.q.clear();
            aVar.c();
        }
        this.socket = null;
        b.a.q.o0.e eVar = this.videoQuality;
        synchronized (eVar) {
            eVar.o.stop();
            eVar.h = Long.valueOf(eVar.q.currentTimeMillis());
        }
        if (!(this.connectionStateChange.state instanceof State.d)) {
            n(false, reason);
            d dVar = this.rtcConnectionType;
            if (dVar instanceof d.b) {
                Map<String, Object> mapC = this.videoQuality.c(String.valueOf(((d.b) dVar).a));
                if (mapC != null) {
                    l(((d.b) this.rtcConnectionType).a, mapC);
                }
                if (this.sentVideo) {
                    m(this.userId, this.videoQuality.d());
                }
            }
        }
        MediaSinkWantsManager mediaSinkWantsManager = this.localMediaSinkWantsManager;
        if (mediaSinkWantsManager != null) {
            mediaSinkWantsManager.b(new g(mediaSinkWantsManager));
        }
        Subscription subscription = this.localMediaSinkWantsSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscription2 = this.mediaEnginePrepareSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.mediaEnginePrepareSubscription = null;
        MediaEngineConnection mediaEngineConnection = this.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.destroy();
        }
        this.mediaEngineConnection = null;
        u(new State.d(false));
        r("Destroy internal RTC connection: " + reason);
        this.listeners.clear();
        this.sentVideo = false;
        this.destroyed = true;
    }

    public final boolean g(long userId) {
        Boolean bool = this.mutedUsers.get(Long.valueOf(userId));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final float h(long userId) {
        Float f = this.userVolumes.get(Long.valueOf(userId));
        if (f != null) {
            return f.floatValue();
        }
        return 1.0f;
    }

    public final Metadata i() {
        return new Metadata(this.id, this.mediaSessionId, Long.valueOf(this.channelId), this.guildId, this.streamKey);
    }

    public final void k(long senderId, Map<String, ? extends Object> properties) {
        HashMap map = new HashMap();
        Long l = this.guildId;
        if (l != null) {
            l.longValue();
            map.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, this.guildId);
        }
        map.put(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(this.channelId));
        map.put("sender_user_id", Long.valueOf(senderId));
        map.putAll(properties);
        p(AnalyticsEvent.VIDEO_STREAM_ENDED, map);
    }

    public final void l(long senderId, Map<String, ? extends Object> properties) {
        if (properties != null) {
            k(senderId, d0.t.h0.plus(properties, d0.t.g0.mapOf(d0.o.to("participant_type", "receiver"))));
        }
    }

    public final void m(long senderId, Map<String, ? extends Object> properties) {
        if (properties != null) {
            k(senderId, d0.t.h0.plus(properties, d0.t.g0.mapOf(d0.o.to("participant_type", this.rtcConnectionType instanceof d.b ? "streamer" : NotificationCompat.MessagingStyle.Message.KEY_SENDER))));
        }
    }

    public final void n(boolean willReconnect, String reason) {
        List<String> list;
        String str;
        Stats stats;
        VoiceQuality voiceQuality;
        Map<String, Object> mapMutableMapOf = d0.t.h0.mutableMapOf(d0.o.to("ping_bad_count", Integer.valueOf(this.pingBadCount)), d0.o.to("connect_count", Integer.valueOf(this.connectCount)), d0.o.to("channel_count", 1));
        b(mapMutableMapOf);
        mapMutableMapOf.put("reconnect", Boolean.valueOf(willReconnect));
        if (reason != null) {
            mapMutableMapOf.put(ModelAuditLogEntry.CHANGE_KEY_REASON, reason);
        }
        double dAverageOfLong = u.averageOfLong(this.pings);
        if (!Double.isNaN(dAverageOfLong)) {
            mapMutableMapOf.put("ping_average", Integer.valueOf(d0.a0.a.roundToInt(dAverageOfLong)));
        }
        String str2 = this.mediaSessionId;
        if (str2 != null) {
            mapMutableMapOf.put("media_session_id", str2);
        }
        b.a.q.o0.d dVar = this.rtcStatsCollector;
        if (dVar != null && (stats = (Stats) u.lastOrNull(dVar.a)) != null) {
            OutboundRtpAudio outboundRtpAudio = stats.getOutboundRtpAudio();
            if (outboundRtpAudio != null) {
                mapMutableMapOf.put("packets_sent", Long.valueOf(outboundRtpAudio.getPacketsSent()));
                mapMutableMapOf.put("packets_sent_lost", Integer.valueOf(outboundRtpAudio.getPacketsLost()));
            }
            long packetsReceived = 0;
            long packetsLost = 0;
            for (InboundRtpAudio inboundRtpAudio : stats.getInboundRtpAudio().values()) {
                packetsLost += inboundRtpAudio.getPacketsLost();
                packetsReceived += inboundRtpAudio.getPacketsReceived();
            }
            mapMutableMapOf.put("packets_received", Long.valueOf(packetsReceived));
            mapMutableMapOf.put("packets_received_lost", Long.valueOf(packetsLost));
            b.a.q.o0.d dVar2 = this.rtcStatsCollector;
            if (dVar2 != null && (voiceQuality = dVar2.f) != null) {
                voiceQuality.getDurationStats(mapMutableMapOf);
                voiceQuality.getMosStats(mapMutableMapOf);
                voiceQuality.getPacketStats(mapMutableMapOf);
                voiceQuality.getBufferStats(mapMutableMapOf);
                voiceQuality.getFrameOpStats(mapMutableMapOf);
            }
        }
        Long l = this.connectCompletedTime;
        Long lValueOf = l != null ? Long.valueOf(this.clock.currentTimeMillis() - l.longValue()) : null;
        if (lValueOf != null) {
            mapMutableMapOf.put("duration", Long.valueOf(lValueOf.longValue()));
        }
        MediaEngineConnection.TransportInfo transportInfo = this.transportInfo;
        MediaEngineConnection.TransportInfo.Protocol protocol = transportInfo != null ? transportInfo.protocol : null;
        if (protocol != null) {
            int iOrdinal = protocol.ordinal();
            if (iOrdinal == 0) {
                str = "udp";
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "tcp";
            }
            mapMutableMapOf.put("protocol", str);
        }
        p(AnalyticsEvent.VOICE_DISCONNECT, mapMutableMapOf);
        if (this.rtcConnectionType instanceof d.a) {
            b.a.q.o0.e eVar = this.videoQuality;
            synchronized (eVar) {
                list = u.toList(eVar.m.keySet());
            }
            for (String str3 : list) {
                Long longOrNull = s.toLongOrNull(str3);
                if (longOrNull != null) {
                    l(longOrNull.longValue(), this.videoQuality.c(str3));
                }
            }
            if (this.sentVideo) {
                m(this.userId, this.videoQuality.d());
            }
        }
    }

    public final void p(AnalyticsEvent event, Map<String, Object> properties) {
        String str;
        properties.put("rtc_connection_id", this.id);
        d dVar = this.rtcConnectionType;
        if (m.areEqual(dVar, d.a.a)) {
            str = "default";
        } else {
            if (!(dVar instanceof d.b)) {
                throw new NoWhenBranchMatchedException();
            }
            str = "stream";
        }
        properties.put("context", str);
        String str2 = this.mediaSessionId;
        if (str2 != null) {
            properties.put("media_session_id", str2);
        }
        String str3 = this.parentMediaSessionId;
        if (str3 != null) {
            properties.put("parent_media_session_id", str3);
        }
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((c) it.next()).onAnalyticsEvent(event, properties);
        }
    }

    public final void q() {
        this.logger.recordBreadcrumb("reconnect", this.loggingTag);
        if (this.connected) {
            this.connectStartTime = Long.valueOf(this.clock.currentTimeMillis());
        }
        this.connectCount++;
        a aVar = this.socket;
        if (aVar != null) {
            aVar.c();
            aVar.d();
        }
    }

    public final void r(String message) {
        this.logger.recordBreadcrumb(message, this.loggingTag);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [b.a.q.f0] */
    @AnyThread
    public final void s(Function0<Unit> action) {
        b.a.q.c cVarC = this.mediaEngine.c();
        if (action != null) {
            action = new f0(action);
        }
        cVarC.l.execute((Runnable) action);
    }

    public final void t(Intent intent, ThumbnailEmitter thumbnailEmitter) {
        if (this.rtcConnectionType instanceof d.b) {
            r("Setting screenshare " + intent + ' ' + this.mediaEngineConnection);
            MediaEngineConnection mediaEngineConnection = this.mediaEngineConnection;
            if (mediaEngineConnection == null) {
                Log.e("RtcConnection", "MediaEngine not connected for setScreenshare.");
            } else if (intent != null) {
                mediaEngineConnection.a(intent, thumbnailEmitter);
            } else {
                mediaEngineConnection.h();
            }
        }
    }

    public final void u(State state) {
        if (!m.areEqual(this.connectionStateChange.state, state)) {
            StateChange stateChange = new StateChange(state, i());
            this.connectionStateChange = stateChange;
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((c) it.next()).onStateChange(stateChange);
            }
        }
    }

    public final void v(long userId, float volume) {
        this.userVolumes.put(Long.valueOf(userId), Float.valueOf(volume));
        MediaEngineConnection mediaEngineConnection = this.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.e(userId, volume);
        }
    }

    public final void w(Long userId) {
        MediaSinkWantsManager mediaSinkWantsManager = this.localMediaSinkWantsManager;
        if (mediaSinkWantsManager != null) {
            mediaSinkWantsManager.b(new j(mediaSinkWantsManager, userId));
        }
    }
}
