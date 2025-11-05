package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppLog;
import com.discord.gateway.GatewaySocket;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStreamRtcConnection;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.time.Clock;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.t.u;
import d0.z.d.m;

/* compiled from: ConnectionTimeStats.kt */
/* loaded from: classes2.dex */
public final class ConnectionTimeStats {
    private final Stat connectionStreamFirstFrame;
    private final Stat connectionVideoFirstFrame;
    private final Stat gatewayConnection;
    private final Stat gatewayHello;
    private final Stat mediaEngineConnection;
    private Long myUserId;
    private final Stat streamConnection;
    private final Stat streamFirstFrame;
    private final Stat streamRequested;
    private final Stat videoFirstFrame;
    private final Stat voiceConnection;

    /* compiled from: ConnectionTimeStats.kt */
    public static final class Stat {
        private final Clock clock;
        private Long endTime;
        private final ConnectionTimeStats owner;
        private Long startTime;
        private final StatType type;

        public Stat(Clock clock, ConnectionTimeStats connectionTimeStats, StatType statType) {
            m.checkNotNullParameter(clock, "clock");
            m.checkNotNullParameter(connectionTimeStats, "owner");
            m.checkNotNullParameter(statType, "type");
            this.clock = clock;
            this.owner = connectionTimeStats;
            this.type = statType;
        }

        public static /* synthetic */ void end$default(Stat stat, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            stat.end(z2);
        }

        public static /* synthetic */ void start$default(Stat stat, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            stat.start(z2);
        }

        public final void clear() {
            this.startTime = null;
            this.endTime = null;
        }

        public final Long elapsed() {
            Long l = this.startTime;
            Long l2 = this.endTime;
            if (l == null || l2 == null) {
                return null;
            }
            return Long.valueOf(l2.longValue() - l.longValue());
        }

        public final void end(boolean ignoreSubsequentCalls) {
            if (this.endTime != null) {
                if (ignoreSubsequentCalls) {
                    return;
                }
                AppLog appLog = AppLog.g;
                StringBuilder sbU = a.U("ConnectionTimeStats: \"");
                sbU.append(this.type);
                sbU.append("\" attempting to end while endTime is set!");
                Logger.w$default(appLog, sbU.toString(), null, 2, null);
                return;
            }
            Long l = this.startTime;
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            if (l == null) {
                AppLog appLog2 = AppLog.g;
                StringBuilder sbU2 = a.U("ConnectionTimeStats: \"");
                sbU2.append(this.type);
                sbU2.append("\" ended without starting!");
                Logger.w$default(appLog2, sbU2.toString(), null, 2, null);
                return;
            }
            long jLongValue = jCurrentTimeMillis - l.longValue();
            if (jLongValue < 0) {
                AppLog appLog3 = AppLog.g;
                StringBuilder sbU3 = a.U("ConnectionTimeStats: \"");
                sbU3.append(this.type);
                sbU3.append("\" has a negative time!");
                sbU3.append(u.joinToString$default(h0.mapOf(o.to(this.type.toString(), "type"), o.to(String.valueOf(jLongValue), "elapsedMs"), o.to(String.valueOf(l.longValue()), "start"), o.to(String.valueOf(jCurrentTimeMillis), "end")).entrySet(), "\n\t", null, null, 0, null, null, 62, null));
                Logger.w$default(appLog3, sbU3.toString(), null, 2, null);
                return;
            }
            this.endTime = Long.valueOf(jCurrentTimeMillis);
            StringBuilder sbU4 = a.U("ConnectionTimeStats: \"");
            sbU4.append(this.type);
            sbU4.append("\" took ");
            sbU4.append(jLongValue);
            sbU4.append(" ms (");
            sbU4.append(l);
            sbU4.append(" to ");
            sbU4.append(jCurrentTimeMillis);
            sbU4.append(')');
            AppLog.i(sbU4.toString());
            ConnectionTimeStats.access$sendAnalyticsEvent(this.owner, this.type);
        }

        public final void start(boolean ignoreSubsequentCalls) {
            if (this.startTime != null) {
                if (ignoreSubsequentCalls) {
                    return;
                }
                AppLog appLog = AppLog.g;
                StringBuilder sbU = a.U("ConnectionTimeStats: \"");
                sbU.append(this.type);
                sbU.append("\" attempting to re-start without reset!");
                Logger.w$default(appLog, sbU.toString(), null, 2, null);
                return;
            }
            if (this.endTime != null) {
                AppLog appLog2 = AppLog.g;
                StringBuilder sbU2 = a.U("ConnectionTimeStats: \"");
                sbU2.append(this.type);
                sbU2.append("\" attempting to re-start while endTime is set!");
                Logger.w$default(appLog2, sbU2.toString(), null, 2, null);
                return;
            }
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            this.startTime = Long.valueOf(jCurrentTimeMillis);
            StringBuilder sbU3 = a.U("ConnectionTimeStats: \"");
            sbU3.append(this.type);
            sbU3.append("\" started @ ");
            sbU3.append(jCurrentTimeMillis);
            AppLog.i(sbU3.toString());
        }
    }

    /* compiled from: ConnectionTimeStats.kt */
    public enum StatType {
        GatewayConnection,
        GatewayHello,
        VoiceConnection,
        StreamRequested,
        StreamConnection,
        MediaEngineConnection,
        StreamFirstFrame,
        VideoFirstFrame,
        ConnectionStreamFirstFrame,
        ConnectionVideoFirstFrame
    }

    /* compiled from: ConnectionTimeStats.kt */
    /* renamed from: com.discord.stores.ConnectionTimeStats$addListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends GatewaySocket.DefaultListener {
        public AnonymousClass1() {
        }

        @Override // com.discord.gateway.GatewaySocket.DefaultListener, com.discord.gateway.GatewaySocket.Listener
        public void onConnected(GatewaySocket gatewaySocket) {
            m.checkNotNullParameter(gatewaySocket, "gatewaySocket");
            Stat.end$default(ConnectionTimeStats.access$getGatewayConnection$p(ConnectionTimeStats.this), false, 1, null);
            Stat.start$default(ConnectionTimeStats.access$getGatewayHello$p(ConnectionTimeStats.this), false, 1, null);
        }

        @Override // com.discord.gateway.GatewaySocket.DefaultListener, com.discord.gateway.GatewaySocket.Listener
        public void onConnecting(GatewaySocket gatewaySocket) {
            m.checkNotNullParameter(gatewaySocket, "gatewaySocket");
            Stat.start$default(ConnectionTimeStats.access$getGatewayConnection$p(ConnectionTimeStats.this), false, 1, null);
        }

        @Override // com.discord.gateway.GatewaySocket.DefaultListener, com.discord.gateway.GatewaySocket.Listener
        public void onDisconnected(GatewaySocket gatewaySocket) {
            m.checkNotNullParameter(gatewaySocket, "gatewaySocket");
            ConnectionTimeStats.access$getGatewayConnection$p(ConnectionTimeStats.this).clear();
            ConnectionTimeStats.access$getGatewayHello$p(ConnectionTimeStats.this).clear();
        }

        @Override // com.discord.gateway.GatewaySocket.DefaultListener, com.discord.gateway.GatewaySocket.Listener
        public void onHello(GatewaySocket gatewaySocket) {
            m.checkNotNullParameter(gatewaySocket, "gatewaySocket");
            Stat.end$default(ConnectionTimeStats.access$getGatewayHello$p(ConnectionTimeStats.this), false, 1, null);
        }
    }

    /* compiled from: ConnectionTimeStats.kt */
    /* renamed from: com.discord.stores.ConnectionTimeStats$addListener$2, reason: invalid class name */
    public static final class AnonymousClass2 extends StoreRtcConnection.DefaultListener {
        public AnonymousClass2() {
        }

        @Override // com.discord.stores.StoreRtcConnection.DefaultListener, com.discord.stores.StoreRtcConnection.Listener
        public void onConnected() {
            Stat.end$default(ConnectionTimeStats.access$getVoiceConnection$p(ConnectionTimeStats.this), false, 1, null);
        }

        @Override // com.discord.stores.StoreRtcConnection.DefaultListener, com.discord.stores.StoreRtcConnection.Listener
        public void onConnecting() {
            Stat.start$default(ConnectionTimeStats.access$getVoiceConnection$p(ConnectionTimeStats.this), false, 1, null);
            Stat.start$default(ConnectionTimeStats.access$getConnectionVideoFirstFrame$p(ConnectionTimeStats.this), false, 1, null);
            Stat.start$default(ConnectionTimeStats.access$getConnectionStreamFirstFrame$p(ConnectionTimeStats.this), false, 1, null);
        }

        @Override // com.discord.stores.StoreRtcConnection.DefaultListener, com.discord.stores.StoreRtcConnection.Listener
        public void onFirstFrameReceived(long ssrc) {
            Stat.end$default(ConnectionTimeStats.access$getVideoFirstFrame$p(ConnectionTimeStats.this), false, 1, null);
            Stat.end$default(ConnectionTimeStats.access$getConnectionVideoFirstFrame$p(ConnectionTimeStats.this), false, 1, null);
        }
    }

    /* compiled from: ConnectionTimeStats.kt */
    /* renamed from: com.discord.stores.ConnectionTimeStats$addListener$3, reason: invalid class name */
    public static final class AnonymousClass3 extends StoreStreamRtcConnection.DefaultListener {
        public AnonymousClass3() {
        }

        @Override // com.discord.stores.StoreStreamRtcConnection.DefaultListener, com.discord.stores.StoreStreamRtcConnection.Listener
        public void onConnected() {
            Stat.end$default(ConnectionTimeStats.access$getStreamConnection$p(ConnectionTimeStats.this), false, 1, null);
            ConnectionTimeStats.access$getStreamFirstFrame$p(ConnectionTimeStats.this).start(true);
        }

        @Override // com.discord.stores.StoreStreamRtcConnection.DefaultListener, com.discord.stores.StoreStreamRtcConnection.Listener
        public void onConnecting() {
            Stat.end$default(ConnectionTimeStats.access$getStreamRequested$p(ConnectionTimeStats.this), false, 1, null);
            Stat.start$default(ConnectionTimeStats.access$getStreamConnection$p(ConnectionTimeStats.this), false, 1, null);
        }

        @Override // com.discord.stores.StoreStreamRtcConnection.DefaultListener, com.discord.stores.StoreStreamRtcConnection.Listener
        public void onFirstFrameReceived(long ssrc) {
            Stat.end$default(ConnectionTimeStats.access$getStreamFirstFrame$p(ConnectionTimeStats.this), false, 1, null);
            Stat.end$default(ConnectionTimeStats.access$getConnectionStreamFirstFrame$p(ConnectionTimeStats.this), false, 1, null);
        }
    }

    /* compiled from: ConnectionTimeStats.kt */
    /* renamed from: com.discord.stores.ConnectionTimeStats$addListener$4, reason: invalid class name */
    public static final class AnonymousClass4 extends StoreMediaEngine.DefaultListener {
        public AnonymousClass4() {
        }

        @Override // com.discord.stores.StoreMediaEngine.DefaultListener, com.discord.stores.StoreMediaEngine.Listener
        public void onConnected() {
            ConnectionTimeStats.access$getMediaEngineConnection$p(ConnectionTimeStats.this).end(true);
        }

        @Override // com.discord.stores.StoreMediaEngine.DefaultListener, com.discord.stores.StoreMediaEngine.Listener
        public void onConnecting() {
            Stat.start$default(ConnectionTimeStats.access$getMediaEngineConnection$p(ConnectionTimeStats.this), false, 1, null);
        }
    }

    public ConnectionTimeStats(Clock clock) {
        m.checkNotNullParameter(clock, "clock");
        StatType statType = StatType.VideoFirstFrame;
        if (!m.areEqual(statType.toString(), "VideoFirstFrame")) {
            Logger.e$default(AppLog.g, "ConnectionTimeStats.StatType has been renamed!", null, g0.mapOf(o.to(ModelAuditLogEntry.CHANGE_KEY_NAME, statType.toString())), 2, null);
        }
        this.gatewayConnection = new Stat(clock, this, StatType.GatewayConnection);
        this.gatewayHello = new Stat(clock, this, StatType.GatewayHello);
        this.voiceConnection = new Stat(clock, this, StatType.VoiceConnection);
        this.streamRequested = new Stat(clock, this, StatType.StreamRequested);
        this.streamConnection = new Stat(clock, this, StatType.StreamConnection);
        this.streamFirstFrame = new Stat(clock, this, StatType.StreamFirstFrame);
        this.videoFirstFrame = new Stat(clock, this, statType);
        this.mediaEngineConnection = new Stat(clock, this, StatType.MediaEngineConnection);
        this.connectionVideoFirstFrame = new Stat(clock, this, StatType.ConnectionVideoFirstFrame);
        this.connectionStreamFirstFrame = new Stat(clock, this, StatType.ConnectionStreamFirstFrame);
    }

    public static final /* synthetic */ Stat access$getConnectionStreamFirstFrame$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.connectionStreamFirstFrame;
    }

    public static final /* synthetic */ Stat access$getConnectionVideoFirstFrame$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.connectionVideoFirstFrame;
    }

    public static final /* synthetic */ Stat access$getGatewayConnection$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.gatewayConnection;
    }

    public static final /* synthetic */ Stat access$getGatewayHello$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.gatewayHello;
    }

    public static final /* synthetic */ Stat access$getMediaEngineConnection$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.mediaEngineConnection;
    }

    public static final /* synthetic */ Stat access$getStreamConnection$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.streamConnection;
    }

    public static final /* synthetic */ Stat access$getStreamFirstFrame$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.streamFirstFrame;
    }

    public static final /* synthetic */ Stat access$getStreamRequested$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.streamRequested;
    }

    public static final /* synthetic */ Stat access$getVideoFirstFrame$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.videoFirstFrame;
    }

    public static final /* synthetic */ Stat access$getVoiceConnection$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.voiceConnection;
    }

    public static final /* synthetic */ void access$sendAnalyticsEvent(ConnectionTimeStats connectionTimeStats, StatType statType) {
        connectionTimeStats.sendAnalyticsEvent(statType);
    }

    private final void clear(boolean onlyCallStats) {
        if (!onlyCallStats) {
            this.gatewayConnection.clear();
            this.gatewayHello.clear();
        }
        this.voiceConnection.clear();
        this.streamRequested.clear();
        this.streamConnection.clear();
        this.streamFirstFrame.clear();
        this.videoFirstFrame.clear();
        this.mediaEngineConnection.clear();
        this.connectionVideoFirstFrame.clear();
        this.connectionStreamFirstFrame.clear();
    }

    public static /* synthetic */ void clear$default(ConnectionTimeStats connectionTimeStats, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        connectionTimeStats.clear(z2);
    }

    private final void sendAnalyticsEvent(StatType statType) {
        AnalyticsTracker.INSTANCE.videoEventTimes(statType.toString(), this.gatewayConnection.elapsed(), this.gatewayHello.elapsed(), this.voiceConnection.elapsed(), this.streamRequested.elapsed(), this.streamConnection.elapsed(), this.streamFirstFrame.elapsed(), this.videoFirstFrame.elapsed(), this.mediaEngineConnection.elapsed(), this.connectionVideoFirstFrame.elapsed(), this.connectionStreamFirstFrame.elapsed());
    }

    public final void addListener(GatewaySocket socket) {
        m.checkNotNullParameter(socket, "socket");
        socket.getListeners().add(new AnonymousClass1());
    }

    public final void handleApplicationStreamUpdate(long userId, Integer streamId) {
        this.streamFirstFrame.start(true);
    }

    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        clear$default(this, false, 1, null);
        this.myUserId = Long.valueOf(payload.getMe().getId());
    }

    public final void handleStreamWatch(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        Stat.start$default(this.streamRequested, false, 1, null);
    }

    public final void handleVideoStreamUpdate(long userId, Integer streamId, int audioSsrc, int videoSsrc, int rtxSsrc) {
        if (videoSsrc != 0) {
            this.videoFirstFrame.start(true);
        }
    }

    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        m.checkNotNullParameter(voiceState, "voiceState");
        long userId = voiceState.getUserId();
        Long l = this.myUserId;
        if (l != null && userId == l.longValue() && voiceState.getChannelId() == null) {
            clear(true);
        }
    }

    public final void addListener(StoreRtcConnection rtcConnection) {
        m.checkNotNullParameter(rtcConnection, "rtcConnection");
        rtcConnection.getListeners().add(new AnonymousClass2());
    }

    public final void addListener(StoreStreamRtcConnection streamRtcConnection) {
        m.checkNotNullParameter(streamRtcConnection, "streamRtcConnection");
        streamRtcConnection.getListeners().add(new AnonymousClass3());
    }

    public final void addListener(StoreMediaEngine storeMediaEngine) {
        m.checkNotNullParameter(storeMediaEngine, "storeMediaEngine");
        storeMediaEngine.getListeners().add(new AnonymousClass4());
    }
}
