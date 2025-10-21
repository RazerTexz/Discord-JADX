package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.guild.Guild;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelApplicationStream3;
import com.discord.models.domain.ModelApplicationStream5;
import com.discord.models.domain.ModelPayload;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.logging.Logger;
import d0.g0.Indent;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreApplicationStreaming.kt */
/* loaded from: classes2.dex */
public final class StoreApplicationStreaming extends StoreV2 {
    private ActiveApplicationStream activeApplicationStream;
    private final ArrayDeque<String> breadCrumbs;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final StoreRtcConnection rtcConnectionStore;
    private final StoreStream storeStream;
    private final HashMap<String, List<Long>> streamSpectators;
    private Map<String, ? extends List<Long>> streamSpectatorsSnapshot;
    private final StreamViewerTracker streamViewerTracker;
    private final HashMap<Long, ModelApplicationStream> streamsByUser;
    private Map<Long, ? extends ModelApplicationStream> streamsByUserSnapshot;
    private ModelApplicationStream targetStream;
    private final StoreUser userStore;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;

    /* compiled from: StoreApplicationStreaming.kt */
    public static final /* data */ class ActiveApplicationStream {
        private final State state;
        private final ModelApplicationStream stream;

        /* compiled from: StoreApplicationStreaming.kt */
        public enum State {
            CONNECTING,
            ACTIVE,
            RECONNECTING,
            ENDED,
            PAUSED,
            DENIED_FULL;


            @Deprecated
            private static final List<State> ACTIVE_STATES;
            private static final Companion Companion;

            /* compiled from: StoreApplicationStreaming.kt */
            public static final class Companion {
                private Companion() {
                }

                public final List<State> getACTIVE_STATES() {
                    return State.access$getACTIVE_STATES$cp();
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            static {
                State state = CONNECTING;
                State state2 = ACTIVE;
                State state3 = RECONNECTING;
                State state4 = PAUSED;
                Companion = new Companion(null);
                ACTIVE_STATES = Collections2.listOf((Object[]) new State[]{state, state2, state3, state4});
            }

            public static final /* synthetic */ List access$getACTIVE_STATES$cp() {
                return ACTIVE_STATES;
            }

            public final boolean isStreamActive() {
                return ACTIVE_STATES.contains(this);
            }
        }

        public ActiveApplicationStream(State state, ModelApplicationStream modelApplicationStream) {
            Intrinsics3.checkNotNullParameter(state, "state");
            Intrinsics3.checkNotNullParameter(modelApplicationStream, "stream");
            this.state = state;
            this.stream = modelApplicationStream;
        }

        public static /* synthetic */ ActiveApplicationStream copy$default(ActiveApplicationStream activeApplicationStream, State state, ModelApplicationStream modelApplicationStream, int i, Object obj) {
            if ((i & 1) != 0) {
                state = activeApplicationStream.state;
            }
            if ((i & 2) != 0) {
                modelApplicationStream = activeApplicationStream.stream;
            }
            return activeApplicationStream.copy(state, modelApplicationStream);
        }

        /* renamed from: component1, reason: from getter */
        public final State getState() {
            return this.state;
        }

        /* renamed from: component2, reason: from getter */
        public final ModelApplicationStream getStream() {
            return this.stream;
        }

        public final ActiveApplicationStream copy(State state, ModelApplicationStream stream) {
            Intrinsics3.checkNotNullParameter(state, "state");
            Intrinsics3.checkNotNullParameter(stream, "stream");
            return new ActiveApplicationStream(state, stream);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActiveApplicationStream)) {
                return false;
            }
            ActiveApplicationStream activeApplicationStream = (ActiveApplicationStream) other;
            return Intrinsics3.areEqual(this.state, activeApplicationStream.state) && Intrinsics3.areEqual(this.stream, activeApplicationStream.stream);
        }

        public final State getState() {
            return this.state;
        }

        public final ModelApplicationStream getStream() {
            return this.stream;
        }

        public int hashCode() {
            State state = this.state;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            ModelApplicationStream modelApplicationStream = this.stream;
            return iHashCode + (modelApplicationStream != null ? modelApplicationStream.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ActiveApplicationStream(state=");
            sbU.append(this.state);
            sbU.append(", stream=");
            sbU.append(this.stream);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    public static final class StreamViewerTracker {
        private final Map<String, Integer> maxViewersByStream = new HashMap();

        public final void clear() {
            this.maxViewersByStream.clear();
        }

        public final Integer getMaxViewers(String streamKey) {
            Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
            return this.maxViewersByStream.get(streamKey);
        }

        public final void onStreamUpdated(String streamKey, int viewerCount) {
            Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
            Integer num = this.maxViewersByStream.get(streamKey);
            this.maxViewersByStream.put(streamKey, Integer.valueOf(Math.max(num != null ? num.intValue() : 0, viewerCount)));
        }

        public final void remove(String streamKey) {
            Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
            this.maxViewersByStream.remove(streamKey);
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    /* renamed from: com.discord.stores.StoreApplicationStreaming$createStream$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ String $preferredRegion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Long l, String str) {
            super(0);
            this.$channelId = j;
            this.$guildId = l;
            this.$preferredRegion = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ActiveApplicationStream.State state;
            ActiveApplicationStream.State state2;
            ModelApplicationStream stream;
            RtcConnection rtcConnection$app_productionGoogleRelease = StoreApplicationStreaming.access$getRtcConnectionStore$p(StoreApplicationStreaming.this).getRtcConnection();
            if (rtcConnection$app_productionGoogleRelease == null || rtcConnection$app_productionGoogleRelease.channelId != this.$channelId || (!Intrinsics3.areEqual(rtcConnection$app_productionGoogleRelease.guildId, this.$guildId))) {
                AppLog appLog = AppLog.g;
                StringBuilder sbU = outline.U("\n                Failed to start stream.\n                rtcConnection == null: ");
                sbU.append(rtcConnection$app_productionGoogleRelease == null);
                sbU.append("\n                rtcConnection.channelId != channelId: ");
                sbU.append(rtcConnection$app_productionGoogleRelease == null || rtcConnection$app_productionGoogleRelease.channelId != this.$channelId);
                sbU.append("\n                rtcConnection.guildId != guildId: ");
                sbU.append(!Intrinsics3.areEqual(rtcConnection$app_productionGoogleRelease != null ? rtcConnection$app_productionGoogleRelease.guildId : null, this.$guildId));
                sbU.append("\n              ");
                Logger.e$default(appLog, "Failed to start stream.", new IllegalStateException(Indent.trimIndent(sbU.toString())), null, 4, null);
                return;
            }
            long id2 = StoreApplicationStreaming.access$getUserStore$p(StoreApplicationStreaming.this).getMeSnapshot().getId();
            ModelApplicationStream guildStream = this.$guildId != null ? new ModelApplicationStream.GuildStream(this.$guildId.longValue(), this.$channelId, id2) : new ModelApplicationStream.CallStream(this.$channelId, id2);
            ActiveApplicationStream activeApplicationStreamAccess$getActiveApplicationStream$p = StoreApplicationStreaming.access$getActiveApplicationStream$p(StoreApplicationStreaming.this);
            if (activeApplicationStreamAccess$getActiveApplicationStream$p != null && (stream = activeApplicationStreamAccess$getActiveApplicationStream$p.getStream()) != null) {
                encodedStreamKey = stream.getEncodedStreamKey();
            }
            if ((encodedStreamKey == guildStream.getEncodedStreamKey()) && activeApplicationStreamAccess$getActiveApplicationStream$p != null && (state2 = activeApplicationStreamAccess$getActiveApplicationStream$p.getState()) != null && state2.isStreamActive()) {
                z = true;
            }
            if (z) {
                return;
            }
            if (activeApplicationStreamAccess$getActiveApplicationStream$p != null && (state = activeApplicationStreamAccess$getActiveApplicationStream$p.getState()) != null && state.isStreamActive()) {
                StoreApplicationStreaming.access$stopStreamInternal(StoreApplicationStreaming.this, activeApplicationStreamAccess$getActiveApplicationStream$p.getStream().getEncodedStreamKey());
            }
            StoreApplicationStreaming.access$getStoreStream$p(StoreApplicationStreaming.this).streamCreate(guildStream.getEncodedStreamKey(), this.$preferredRegion);
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    /* renamed from: com.discord.stores.StoreApplicationStreaming$observeActiveStream$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<ActiveApplicationStream> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ActiveApplicationStream invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ActiveApplicationStream invoke() {
            return StoreApplicationStreaming.access$getActiveApplicationStream$p(StoreApplicationStreaming.this);
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    /* renamed from: com.discord.stores.StoreApplicationStreaming$observeStreamSpectators$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<String, ? extends List<? extends Long>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends List<? extends Long>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends List<? extends Long>> invoke2() {
            return StoreApplicationStreaming.access$getStreamSpectatorsSnapshot$p(StoreApplicationStreaming.this);
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    /* renamed from: com.discord.stores.StoreApplicationStreaming$observeStreamsByUser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends ModelApplicationStream>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends ModelApplicationStream> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends ModelApplicationStream> invoke2() {
            return StoreApplicationStreaming.this.getStreamsByUser();
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    /* renamed from: com.discord.stores.StoreApplicationStreaming$observeStreamsForGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends ModelApplicationStream>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends ModelApplicationStream> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends ModelApplicationStream> invoke2() {
            Map mapAccess$getStreamsByUserSnapshot$p = StoreApplicationStreaming.access$getStreamsByUserSnapshot$p(StoreApplicationStreaming.this);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : mapAccess$getStreamsByUserSnapshot$p.entrySet()) {
                ModelApplicationStream modelApplicationStream = (ModelApplicationStream) entry.getValue();
                if ((modelApplicationStream instanceof ModelApplicationStream.GuildStream) && ((ModelApplicationStream.GuildStream) modelApplicationStream).getGuildId() == this.$guildId) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    /* renamed from: com.discord.stores.StoreApplicationStreaming$observeStreamsForUser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<ModelApplicationStream> {
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ModelApplicationStream invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ModelApplicationStream invoke() {
            return (ModelApplicationStream) StoreApplicationStreaming.access$getStreamsByUserSnapshot$p(StoreApplicationStreaming.this).get(Long.valueOf(this.$userId));
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    /* renamed from: com.discord.stores.StoreApplicationStreaming$stopStream$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationStreaming.access$stopStreamInternal(StoreApplicationStreaming.this, this.$streamKey);
        }
    }

    /* compiled from: StoreApplicationStreaming.kt */
    /* renamed from: com.discord.stores.StoreApplicationStreaming$targetStream$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $force;
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, boolean z2) {
            super(0);
            this.$streamKey = str;
            this.$force = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ActiveApplicationStream.State state;
            ModelApplicationStream stream;
            ActiveApplicationStream activeApplicationStreamAccess$getActiveApplicationStream$p = StoreApplicationStreaming.access$getActiveApplicationStream$p(StoreApplicationStreaming.this);
            boolean z2 = Intrinsics3.areEqual((activeApplicationStreamAccess$getActiveApplicationStream$p == null || (stream = activeApplicationStreamAccess$getActiveApplicationStream$p.getStream()) == null) ? null : stream.getEncodedStreamKey(), this.$streamKey) && activeApplicationStreamAccess$getActiveApplicationStream$p.getState().isStreamActive();
            if (this.$force || !z2) {
                if (activeApplicationStreamAccess$getActiveApplicationStream$p != null && (state = activeApplicationStreamAccess$getActiveApplicationStream$p.getState()) != null && state.isStreamActive()) {
                    StoreApplicationStreaming.access$stopStreamInternal(StoreApplicationStreaming.this, activeApplicationStreamAccess$getActiveApplicationStream$p.getStream().getEncodedStreamKey());
                }
                StoreApplicationStreaming.access$getStoreStream$p(StoreApplicationStreaming.this).handleStreamTargeted(this.$streamKey);
            }
        }
    }

    public /* synthetic */ StoreApplicationStreaming(StoreStream storeStream, Dispatcher dispatcher, StoreUser storeUser, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreRtcConnection storeRtcConnection, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, storeUser, storeVoiceChannelSelected, storeRtcConnection, (i & 32) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ ActiveApplicationStream access$getActiveApplicationStream$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.activeApplicationStream;
    }

    public static final /* synthetic */ StoreRtcConnection access$getRtcConnectionStore$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.rtcConnectionStore;
    }

    public static final /* synthetic */ StoreStream access$getStoreStream$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.storeStream;
    }

    public static final /* synthetic */ Map access$getStreamSpectatorsSnapshot$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.streamSpectatorsSnapshot;
    }

    public static final /* synthetic */ Map access$getStreamsByUserSnapshot$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.streamsByUserSnapshot;
    }

    public static final /* synthetic */ StoreUser access$getUserStore$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.userStore;
    }

    public static final /* synthetic */ void access$setActiveApplicationStream$p(StoreApplicationStreaming storeApplicationStreaming, ActiveApplicationStream activeApplicationStream) {
        storeApplicationStreaming.activeApplicationStream = activeApplicationStream;
    }

    public static final /* synthetic */ void access$setStreamSpectatorsSnapshot$p(StoreApplicationStreaming storeApplicationStreaming, Map map) {
        storeApplicationStreaming.streamSpectatorsSnapshot = map;
    }

    public static final /* synthetic */ void access$setStreamsByUserSnapshot$p(StoreApplicationStreaming storeApplicationStreaming, Map map) {
        storeApplicationStreaming.streamsByUserSnapshot = map;
    }

    public static final /* synthetic */ void access$stopStreamInternal(StoreApplicationStreaming storeApplicationStreaming, String str) {
        storeApplicationStreaming.stopStreamInternal(str);
    }

    private final synchronized void addBreadCrumb(String message) {
        this.breadCrumbs.addLast(message + ", on thread: " + Thread.currentThread());
        ArrayDeque<String> arrayDeque = this.breadCrumbs;
        if (arrayDeque.size() > 50) {
            arrayDeque.removeFirst();
        }
    }

    public static /* synthetic */ void createStream$default(StoreApplicationStreaming storeApplicationStreaming, long j, Long l, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        storeApplicationStreaming.createStream(j, l, str);
    }

    private final synchronized void dumpBreadcrumbs() {
        Iterator<String> it = this.breadCrumbs.iterator();
        while (it.hasNext()) {
            AppLog.g.recordBreadcrumb(it.next(), "StoreApplicationStreaming");
        }
    }

    @Store3
    private final void handleStreamCreateOrUpdate(String streamKey, boolean paused, List<Long> viewerIds) {
        updateActiveApplicationStream(new ActiveApplicationStream(paused ? ActiveApplicationStream.State.PAUSED : ActiveApplicationStream.State.ACTIVE, ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey)));
        this.streamSpectators.put(streamKey, viewerIds);
        this.streamViewerTracker.onStreamUpdated(streamKey, viewerIds.size());
        markChanged();
    }

    public static /* synthetic */ void handleVoiceStateUpdate$default(StoreApplicationStreaming storeApplicationStreaming, VoiceState voiceState, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = voiceState.getGuildId();
        }
        storeApplicationStreaming.handleVoiceStateUpdate(voiceState, j);
    }

    private final void stopStreamInternal(String streamKey) {
        this.storeStream.handleStreamDelete(new ModelApplicationStream5(streamKey, ModelApplicationStream5.Reason.USER_REQUESTED, false), true);
    }

    public static /* synthetic */ void targetStream$default(StoreApplicationStreaming storeApplicationStreaming, String str, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        storeApplicationStreaming.targetStream(str, z2);
    }

    @Store3
    private final void updateActiveApplicationStream(ActiveApplicationStream activeApplicationStream) {
        boolean zIsScreenSharing = isScreenSharing(this.activeApplicationStream);
        boolean zIsScreenSharing2 = isScreenSharing(activeApplicationStream);
        if (zIsScreenSharing != zIsScreenSharing2) {
            this.storeStream.handleIsScreenSharingChanged(zIsScreenSharing2);
        }
        this.activeApplicationStream = activeApplicationStream;
    }

    public final void createStream(long channelId, Long guildId, String preferredRegion) {
        this.dispatcher.schedule(new AnonymousClass1(channelId, guildId, preferredRegion));
    }

    @Store3
    public final String getActiveApplicationStreamKeyInternal$app_productionGoogleRelease() {
        ModelApplicationStream stream;
        ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
        if (activeApplicationStream == null || (stream = activeApplicationStream.getStream()) == null) {
            return null;
        }
        return stream.getEncodedStreamKey();
    }

    @Store3
    public final Integer getMaxViewersForStream(long userId, long channelId, Long guildId) {
        return this.streamViewerTracker.getMaxViewers((guildId != null ? new ModelApplicationStream.GuildStream(guildId.longValue(), channelId, userId) : new ModelApplicationStream.CallStream(channelId, userId)).getEncodedStreamKey());
    }

    public final Map<Long, ModelApplicationStream> getStreamsByUser() {
        return this.streamsByUserSnapshot;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        addBreadCrumb("Connection open, clearing streams by user.");
        this.streamsByUser.clear();
        this.streamViewerTracker.clear();
        ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
        if (activeApplicationStream != null && activeApplicationStream.getState() != ActiveApplicationStream.State.ENDED) {
            targetStream(activeApplicationStream.getStream().getEncodedStreamKey(), true);
        }
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            List<VoiceState> listR = guild.R();
            if (listR != null) {
                Iterator<T> it = listR.iterator();
                while (it.hasNext()) {
                    handleVoiceStateUpdate((VoiceState) it.next(), guild.getId());
                }
            }
        }
        markChanged();
    }

    @Store3
    public final void handleStreamCreate(ModelApplicationStream3 streamCreate) {
        Intrinsics3.checkNotNullParameter(streamCreate, "streamCreate");
        this.streamViewerTracker.remove(streamCreate.getStreamKey());
        handleStreamCreateOrUpdate(streamCreate.getStreamKey(), streamCreate.getPaused(), streamCreate.getViewerIds());
    }

    @Store3
    public final void handleStreamCreateRequest(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        updateActiveApplicationStream(new ActiveApplicationStream(ActiveApplicationStream.State.CONNECTING, ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey)));
        markChanged();
    }

    @Store3
    public final void handleStreamDelete(ModelApplicationStream5 streamDelete) {
        ModelApplicationStream stream;
        ActiveApplicationStream activeApplicationStream;
        Intrinsics3.checkNotNullParameter(streamDelete, "streamDelete");
        this.streamSpectators.remove(streamDelete.getStreamKey());
        if (streamDelete.getReason() == ModelApplicationStream5.Reason.STREAM_FULL) {
            updateActiveApplicationStream(new ActiveApplicationStream(ActiveApplicationStream.State.DENIED_FULL, ModelApplicationStream.INSTANCE.decodeStreamKey(streamDelete.getStreamKey())));
            markChanged();
            return;
        }
        ActiveApplicationStream activeApplicationStream2 = this.activeApplicationStream;
        if (activeApplicationStream2 == null || (stream = activeApplicationStream2.getStream()) == null) {
            stream = this.targetStream;
        }
        ActiveApplicationStream activeApplicationStreamCopy$default = null;
        if (Intrinsics3.areEqual(stream != null ? stream.getEncodedStreamKey() : null, streamDelete.getStreamKey())) {
            if (streamDelete.getUnavailable()) {
                ActiveApplicationStream activeApplicationStream3 = this.activeApplicationStream;
                if (activeApplicationStream3 != null) {
                    activeApplicationStreamCopy$default = ActiveApplicationStream.copy$default(activeApplicationStream3, ActiveApplicationStream.State.RECONNECTING, null, 2, null);
                }
            } else if (streamDelete.getReason() != ModelApplicationStream5.Reason.USER_REQUESTED && (activeApplicationStream = this.activeApplicationStream) != null) {
                activeApplicationStreamCopy$default = ActiveApplicationStream.copy$default(activeApplicationStream, ActiveApplicationStream.State.ENDED, null, 2, null);
            }
            updateActiveApplicationStream(activeApplicationStreamCopy$default);
            markChanged();
        }
    }

    @Store3
    public final void handleStreamTargeted(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        ModelApplicationStream modelApplicationStreamDecodeStreamKey = ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey);
        ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
        if (Intrinsics3.areEqual(modelApplicationStreamDecodeStreamKey, activeApplicationStream != null ? activeApplicationStream.getStream() : null) && activeApplicationStream.getState().isStreamActive()) {
            return;
        }
        if (this.voiceChannelSelectedStore.getSelectedVoiceChannelId() != modelApplicationStreamDecodeStreamKey.getChannelId()) {
            this.targetStream = modelApplicationStreamDecodeStreamKey;
        } else {
            this.storeStream.streamWatch(modelApplicationStreamDecodeStreamKey.getEncodedStreamKey());
            this.targetStream = null;
        }
    }

    @Store3
    public final void handleStreamUpdate(ModelApplicationStream3 streamUpdate) {
        Intrinsics3.checkNotNullParameter(streamUpdate, "streamUpdate");
        handleStreamCreateOrUpdate(streamUpdate.getStreamKey(), streamUpdate.getPaused(), streamUpdate.getViewerIds());
    }

    @Store3
    public final void handleStreamWatch(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        updateActiveApplicationStream(new ActiveApplicationStream(ActiveApplicationStream.State.CONNECTING, ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey)));
        markChanged();
    }

    @Store3
    public final void handleVoiceChannelSelected(long channelId) {
        ModelApplicationStream stream;
        ModelApplicationStream modelApplicationStream = this.targetStream;
        if (modelApplicationStream != null && channelId == modelApplicationStream.getChannelId()) {
            StoreStream storeStream = this.storeStream;
            ModelApplicationStream modelApplicationStream2 = this.targetStream;
            Intrinsics3.checkNotNull(modelApplicationStream2);
            storeStream.streamWatch(modelApplicationStream2.getEncodedStreamKey());
            this.targetStream = null;
            return;
        }
        ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
        if (activeApplicationStream == null || (stream = activeApplicationStream.getStream()) == null || stream.getChannelId() != channelId) {
            updateActiveApplicationStream(null);
            this.targetStream = null;
            markChanged();
        }
    }

    @Store3
    public final void handleVoiceStateUpdate(VoiceState voiceState, long guildId) {
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        addBreadCrumb("Handling a voice state update for " + voiceState.getUserId());
        Long channelId = voiceState.getChannelId();
        long userId = voiceState.getUserId();
        boolean selfStream = voiceState.getSelfStream();
        boolean z2 = guildId != 0;
        boolean z3 = (channelId == null || channelId.longValue() == 0) ? false : true;
        if (selfStream && z2 && z3) {
            HashMap<Long, ModelApplicationStream> map = this.streamsByUser;
            Long lValueOf = Long.valueOf(userId);
            Intrinsics3.checkNotNull(channelId);
            map.put(lValueOf, new ModelApplicationStream.GuildStream(guildId, channelId.longValue(), userId));
            markChanged();
        } else if (selfStream && z3) {
            HashMap<Long, ModelApplicationStream> map2 = this.streamsByUser;
            Long lValueOf2 = Long.valueOf(userId);
            Intrinsics3.checkNotNull(channelId);
            map2.put(lValueOf2, new ModelApplicationStream.CallStream(channelId.longValue(), userId));
            markChanged();
        } else if (this.streamsByUser.containsKey(Long.valueOf(userId))) {
            this.streamsByUser.remove(Long.valueOf(userId));
            markChanged();
        }
        ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
        if (activeApplicationStream != null && userId == this.userStore.getMe().getId()) {
            long channelId2 = activeApplicationStream.getStream().getChannelId();
            Long channelId3 = voiceState.getChannelId();
            if (channelId3 == null || channelId2 != channelId3.longValue()) {
                updateActiveApplicationStream(null);
                markChanged();
            }
        }
        ModelApplicationStream modelApplicationStream = this.streamsByUser.get(Long.valueOf(userId));
        if (selfStream && modelApplicationStream != null && activeApplicationStream != null && Intrinsics3.areEqual(modelApplicationStream.getEncodedStreamKey(), activeApplicationStream.getStream().getEncodedStreamKey()) && activeApplicationStream.getState() == ActiveApplicationStream.State.ENDED) {
            handleStreamTargeted(modelApplicationStream.getEncodedStreamKey());
        }
    }

    @Store3
    public final boolean isScreenSharing() {
        return isScreenSharing(this.activeApplicationStream);
    }

    @Store3
    public final boolean isUserStreaming(long userId) {
        addBreadCrumb("Asking if " + userId + " is streaming");
        return this.streamsByUser.containsKey(Long.valueOf(userId));
    }

    public final Observable<ActiveApplicationStream> observeActiveStream() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Map<String, List<Long>>> observeStreamSpectators() {
        Observable<Map<String, List<Long>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, ModelApplicationStream>> observeStreamsByUser() {
        Observable<Map<Long, ModelApplicationStream>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, ModelApplicationStream>> observeStreamsForGuild(long guildId) {
        Observable<Map<Long, ModelApplicationStream>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<ModelApplicationStream> observeStreamsForUser(long userId) {
        Observable<ModelApplicationStream> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(userId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() throws Exception {
        super.snapshotData();
        StringBuilder sbU = outline.U("Snapshotting 'streamsByUser' of size, ");
        sbU.append(this.streamsByUser.size());
        addBreadCrumb(sbU.toString());
        try {
            this.streamsByUserSnapshot = new HashMap(this.streamsByUser);
            this.streamSpectatorsSnapshot = new HashMap(this.streamSpectators);
        } catch (Exception e) {
            dumpBreadcrumbs();
            throw e;
        }
    }

    public final void stopStream(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        this.dispatcher.schedule(new AnonymousClass1(streamKey));
    }

    public final void targetStream(String streamKey, boolean force) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        this.dispatcher.schedule(new AnonymousClass1(streamKey, force));
    }

    public StoreApplicationStreaming(StoreStream storeStream, Dispatcher dispatcher, StoreUser storeUser, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreRtcConnection storeRtcConnection, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        Intrinsics3.checkNotNullParameter(storeRtcConnection, "rtcConnectionStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.userStore = storeUser;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.rtcConnectionStore = storeRtcConnection;
        this.observationDeck = observationDeck;
        this.breadCrumbs = new ArrayDeque<>();
        this.streamsByUser = new HashMap<>();
        this.streamsByUserSnapshot = Maps6.emptyMap();
        this.streamSpectators = new HashMap<>();
        this.streamSpectatorsSnapshot = Maps6.emptyMap();
        this.streamViewerTracker = new StreamViewerTracker();
        addBreadCrumb("Initializing the store.");
    }

    private final boolean isScreenSharing(ActiveApplicationStream activeApplicationStream) {
        return activeApplicationStream != null && activeApplicationStream.getStream().getOwnerId() == this.userStore.getMe().getId();
    }
}
