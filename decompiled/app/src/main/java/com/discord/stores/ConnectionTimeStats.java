package com.discord.stores;

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
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ConnectionTimeStats.kt */
/* JADX INFO: loaded from: classes2.dex */
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

    /* JADX INFO: compiled from: ConnectionTimeStats.kt */
    public static final class Stat {
        private final Clock clock;
        private Long endTime;
        private final ConnectionTimeStats owner;
        private Long startTime;
        private final StatType type;

        public Stat(Clock clock, ConnectionTimeStats connectionTimeStats, StatType statType) {
            Intrinsics3.checkNotNullParameter(clock, "clock");
            Intrinsics3.checkNotNullParameter(connectionTimeStats, "owner");
            Intrinsics3.checkNotNullParameter(statType, "type");
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
                AppLog appLog = AppLog.f14950g;
                StringBuilder sbM833U = outline.m833U("ConnectionTimeStats: \"");
                sbM833U.append(this.type);
                sbM833U.append("\" attempting to end while endTime is set!");
                Logger.w$default(appLog, sbM833U.toString(), null, 2, null);
                return;
            }
            Long l = this.startTime;
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            if (l == null) {
                AppLog appLog2 = AppLog.f14950g;
                StringBuilder sbM833U2 = outline.m833U("ConnectionTimeStats: \"");
                sbM833U2.append(this.type);
                sbM833U2.append("\" ended without starting!");
                Logger.w$default(appLog2, sbM833U2.toString(), null, 2, null);
                return;
            }
            long jLongValue = jCurrentTimeMillis - l.longValue();
            if (jLongValue < 0) {
                AppLog appLog3 = AppLog.f14950g;
                StringBuilder sbM833U3 = outline.m833U("ConnectionTimeStats: \"");
                sbM833U3.append(this.type);
                sbM833U3.append("\" has a negative time!");
                sbM833U3.append(_Collections.joinToString$default(Maps6.mapOf(Tuples.m10073to(this.type.toString(), "type"), Tuples.m10073to(String.valueOf(jLongValue), "elapsedMs"), Tuples.m10073to(String.valueOf(l.longValue()), "start"), Tuples.m10073to(String.valueOf(jCurrentTimeMillis), "end")).entrySet(), "\n\t", null, null, 0, null, null, 62, null));
                Logger.w$default(appLog3, sbM833U3.toString(), null, 2, null);
                return;
            }
            this.endTime = Long.valueOf(jCurrentTimeMillis);
            StringBuilder sbM833U4 = outline.m833U("ConnectionTimeStats: \"");
            sbM833U4.append(this.type);
            sbM833U4.append("\" took ");
            sbM833U4.append(jLongValue);
            sbM833U4.append(" ms (");
            sbM833U4.append(l);
            sbM833U4.append(" to ");
            sbM833U4.append(jCurrentTimeMillis);
            sbM833U4.append(')');
            AppLog.m8358i(sbM833U4.toString());
            ConnectionTimeStats.access$sendAnalyticsEvent(this.owner, this.type);
        }

        public final void start(boolean ignoreSubsequentCalls) {
            if (this.startTime != null) {
                if (ignoreSubsequentCalls) {
                    return;
                }
                AppLog appLog = AppLog.f14950g;
                StringBuilder sbM833U = outline.m833U("ConnectionTimeStats: \"");
                sbM833U.append(this.type);
                sbM833U.append("\" attempting to re-start without reset!");
                Logger.w$default(appLog, sbM833U.toString(), null, 2, null);
                return;
            }
            if (this.endTime != null) {
                AppLog appLog2 = AppLog.f14950g;
                StringBuilder sbM833U2 = outline.m833U("ConnectionTimeStats: \"");
                sbM833U2.append(this.type);
                sbM833U2.append("\" attempting to re-start while endTime is set!");
                Logger.w$default(appLog2, sbM833U2.toString(), null, 2, null);
                return;
            }
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            this.startTime = Long.valueOf(jCurrentTimeMillis);
            StringBuilder sbM833U3 = outline.m833U("ConnectionTimeStats: \"");
            sbM833U3.append(this.type);
            sbM833U3.append("\" started @ ");
            sbM833U3.append(jCurrentTimeMillis);
            AppLog.m8358i(sbM833U3.toString());
        }
    }

    /* JADX INFO: compiled from: ConnectionTimeStats.kt */
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

    /* JADX INFO: renamed from: com.discord.stores.ConnectionTimeStats$addListener$1 */
    /* JADX INFO: compiled from: ConnectionTimeStats.kt */
    public static final class C56641 extends GatewaySocket.DefaultListener {
        public C56641() {
        }

        @Override // com.discord.gateway.GatewaySocket.DefaultListener, com.discord.gateway.GatewaySocket.Listener
        public void onConnected(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
            Stat.end$default(ConnectionTimeStats.access$getGatewayConnection$p(ConnectionTimeStats.this), false, 1, null);
            Stat.start$default(ConnectionTimeStats.access$getGatewayHello$p(ConnectionTimeStats.this), false, 1, null);
        }

        @Override // com.discord.gateway.GatewaySocket.DefaultListener, com.discord.gateway.GatewaySocket.Listener
        public void onConnecting(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
            Stat.start$default(ConnectionTimeStats.access$getGatewayConnection$p(ConnectionTimeStats.this), false, 1, null);
        }

        @Override // com.discord.gateway.GatewaySocket.DefaultListener, com.discord.gateway.GatewaySocket.Listener
        public void onDisconnected(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
            ConnectionTimeStats.access$getGatewayConnection$p(ConnectionTimeStats.this).clear();
            ConnectionTimeStats.access$getGatewayHello$p(ConnectionTimeStats.this).clear();
        }

        @Override // com.discord.gateway.GatewaySocket.DefaultListener, com.discord.gateway.GatewaySocket.Listener
        public void onHello(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
            Stat.end$default(ConnectionTimeStats.access$getGatewayHello$p(ConnectionTimeStats.this), false, 1, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.ConnectionTimeStats$addListener$2 */
    /* JADX INFO: compiled from: ConnectionTimeStats.kt */
    public static final class C56652 extends StoreRtcConnection.DefaultListener {
        public C56652() {
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

    /* JADX INFO: renamed from: com.discord.stores.ConnectionTimeStats$addListener$3 */
    /* JADX INFO: compiled from: ConnectionTimeStats.kt */
    public static final class C56663 extends StoreStreamRtcConnection.DefaultListener {
        public C56663() {
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

    /* JADX INFO: renamed from: com.discord.stores.ConnectionTimeStats$addListener$4 */
    /* JADX INFO: compiled from: ConnectionTimeStats.kt */
    public static final class C56674 extends StoreMediaEngine.DefaultListener {
        public C56674() {
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
        Intrinsics3.checkNotNullParameter(clock, "clock");
        StatType statType = StatType.VideoFirstFrame;
        if (!Intrinsics3.areEqual(statType.toString(), "VideoFirstFrame")) {
            Logger.e$default(AppLog.f14950g, "ConnectionTimeStats.StatType has been renamed!", null, MapsJVM.mapOf(Tuples.m10073to(ModelAuditLogEntry.CHANGE_KEY_NAME, statType.toString())), 2, null);
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
        Intrinsics3.checkNotNullParameter(socket, "socket");
        socket.getListeners().add(new C56641());
    }

    public final void handleApplicationStreamUpdate(long userId, Integer streamId) {
        this.streamFirstFrame.start(true);
    }

    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        clear$default(this, false, 1, null);
        this.myUserId = Long.valueOf(payload.getMe().getId());
    }

    public final void handleStreamWatch(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        Stat.start$default(this.streamRequested, false, 1, null);
    }

    public final void handleVideoStreamUpdate(long userId, Integer streamId, int audioSsrc, int videoSsrc, int rtxSsrc) {
        if (videoSsrc != 0) {
            this.videoFirstFrame.start(true);
        }
    }

    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        long userId = voiceState.getUserId();
        Long l = this.myUserId;
        if (l != null && userId == l.longValue() && voiceState.getChannelId() == null) {
            clear(true);
        }
    }

    public final void addListener(StoreRtcConnection rtcConnection) {
        Intrinsics3.checkNotNullParameter(rtcConnection, "rtcConnection");
        rtcConnection.getListeners().add(new C56652());
    }

    public final void addListener(StoreStreamRtcConnection streamRtcConnection) {
        Intrinsics3.checkNotNullParameter(streamRtcConnection, "streamRtcConnection");
        streamRtcConnection.getListeners().add(new C56663());
    }

    public final void addListener(StoreMediaEngine storeMediaEngine) {
        Intrinsics3.checkNotNullParameter(storeMediaEngine, "storeMediaEngine");
        storeMediaEngine.getListeners().add(new C56674());
    }
}
