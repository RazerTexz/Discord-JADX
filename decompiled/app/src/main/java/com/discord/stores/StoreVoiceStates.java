package com.discord.stores;

import androidx.core.app.NotificationCompat;
import b.c.a.a0.d;
import com.discord.api.guild.Guild;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import d0.t.h0;
import d0.z.d.o;
import j0.k.b;
import j0.l.a.l0;
import j0.l.e.m;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import rx.Observable;

/* compiled from: StoreVoiceStates.kt */
/* loaded from: classes2.dex */
public final class StoreVoiceStates extends StoreV2 {
    private final HashSet<Long> dirtyGuildIds;
    private Long myUserId;
    private final Function3<Long, Long, Long, Unit> notifyVoiceStatesUpdated;
    private final ObservationDeck observationDeck;
    private String sessionId;
    private final HashMap<Long, HashMap<Long, VoiceState>> voiceStates;
    private Map<Long, ? extends Map<Long, VoiceState>> voiceStatesSnapshot;

    /* compiled from: StoreVoiceStates.kt */
    /* renamed from: com.discord.stores.StoreVoiceStates$observe$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends VoiceState>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends VoiceState> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends VoiceState> invoke2() {
            Map<Long, ? extends VoiceState> map = (Map) StoreVoiceStates.access$getVoiceStatesSnapshot$p(StoreVoiceStates.this).get(Long.valueOf(this.$guildId));
            return map != null ? map : h0.emptyMap();
        }
    }

    /* compiled from: StoreVoiceStates.kt */
    /* renamed from: com.discord.stores.StoreVoiceStates$observe$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Map<Long, ? extends VoiceState>, Observable<? extends Map<Long, VoiceState>>> {
        public final /* synthetic */ long $channelId;

        /* compiled from: StoreVoiceStates.kt */
        /* renamed from: com.discord.stores.StoreVoiceStates$observe$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements b<VoiceState, Boolean> {
            public AnonymousClass1() {
            }

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ Boolean call(VoiceState voiceState) {
                return call2(voiceState);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(VoiceState voiceState) {
                Long channelId = voiceState.getChannelId();
                return Boolean.valueOf(channelId != null && channelId.longValue() == AnonymousClass2.this.$channelId);
            }
        }

        /* compiled from: StoreVoiceStates.kt */
        /* renamed from: com.discord.stores.StoreVoiceStates$observe$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C03202<T, R> implements b<VoiceState, Long> {
            public static final C03202 INSTANCE = new C03202();

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ Long call(VoiceState voiceState) {
                return call2(voiceState);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Long call2(VoiceState voiceState) {
                return Long.valueOf(voiceState.getUserId());
            }
        }

        public AnonymousClass2(long j) {
            this.$channelId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends Map<Long, VoiceState>> call(Map<Long, ? extends VoiceState> map) {
            return call2((Map<Long, VoiceState>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Map<Long, VoiceState>> call2(Map<Long, VoiceState> map) {
            return Observable.h0(new l0(Observable.B(map.values()).y(new AnonymousClass1()), C03202.INSTANCE, m.a.INSTANCE));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreVoiceStates(Function3<? super Long, ? super Long, ? super Long, Unit> function3, ObservationDeck observationDeck) {
        d0.z.d.m.checkNotNullParameter(function3, "notifyVoiceStatesUpdated");
        d0.z.d.m.checkNotNullParameter(observationDeck, "observationDeck");
        this.notifyVoiceStatesUpdated = function3;
        this.observationDeck = observationDeck;
        HashMap<Long, HashMap<Long, VoiceState>> map = new HashMap<>();
        this.voiceStates = map;
        this.voiceStatesSnapshot = new HashMap(map);
        this.dirtyGuildIds = new HashSet<>();
    }

    public static final /* synthetic */ Map access$getVoiceStatesSnapshot$p(StoreVoiceStates storeVoiceStates) {
        return storeVoiceStates.voiceStatesSnapshot;
    }

    public static final /* synthetic */ void access$setVoiceStatesSnapshot$p(StoreVoiceStates storeVoiceStates, Map map) {
        storeVoiceStates.voiceStatesSnapshot = map;
    }

    @StoreThread
    private final void clear() {
        this.dirtyGuildIds.addAll(this.voiceStates.keySet());
        this.voiceStates.clear();
        markChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00bf  */
    @StoreThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateVoiceState(VoiceState voiceState, Long guildId) {
        Long channelId;
        Long l;
        long jLongValue = guildId != null ? guildId.longValue() : voiceState.getGuildId();
        long userId = voiceState.getUserId();
        if ((!d0.z.d.m.areEqual(voiceState.getSessionId(), this.sessionId)) && (l = this.myUserId) != null && userId == l.longValue()) {
            HashMap<Long, VoiceState> map = this.voiceStates.get(Long.valueOf(jLongValue));
            if (map != null && map.remove(Long.valueOf(userId)) != null) {
                this.dirtyGuildIds.add(Long.valueOf(jLongValue));
            }
        } else {
            boolean z2 = false;
            HashMap<Long, HashMap<Long, VoiceState>> map2 = this.voiceStates;
            Long lValueOf = Long.valueOf(jLongValue);
            HashMap<Long, VoiceState> map3 = this.voiceStates.get(Long.valueOf(jLongValue));
            if (map3 == null) {
                map3 = new HashMap<>();
            }
            long jLongValue2 = 0;
            if (d.X0(voiceState)) {
                VoiceState voiceStateRemove = map3.remove(Long.valueOf(userId));
                if (voiceStateRemove != null) {
                    Long channelId2 = voiceStateRemove.getChannelId();
                    if (channelId2 != null) {
                        jLongValue2 = channelId2.longValue();
                    }
                    z2 = true;
                }
                map2.put(lValueOf, map3);
                if (z2) {
                    this.dirtyGuildIds.add(Long.valueOf(jLongValue));
                    this.notifyVoiceStatesUpdated.invoke(Long.valueOf(jLongValue), Long.valueOf(jLongValue2), Long.valueOf(userId));
                }
            } else {
                if (!d0.z.d.m.areEqual(voiceState, map3.get(Long.valueOf(userId)))) {
                    VoiceState voiceState2 = map3.get(Long.valueOf(userId));
                    if (voiceState2 != null && (channelId = voiceState2.getChannelId()) != null) {
                        jLongValue2 = channelId.longValue();
                    }
                    map3.put(Long.valueOf(userId), voiceState);
                    z2 = true;
                }
                map2.put(lValueOf, map3);
                if (z2) {
                }
            }
        }
        if (!this.dirtyGuildIds.isEmpty()) {
            markChanged();
        }
    }

    public static /* synthetic */ void updateVoiceState$default(StoreVoiceStates storeVoiceStates, VoiceState voiceState, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        storeVoiceStates.updateVoiceState(voiceState, l);
    }

    public final Map<Long, Map<Long, VoiceState>> get() {
        return this.voiceStatesSnapshot;
    }

    public final Map<Long, VoiceState> getForChannel(long guildId, long channelId) {
        Map<Long, VoiceState> mapEmptyMap = this.voiceStatesSnapshot.get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, VoiceState> entry : mapEmptyMap.entrySet()) {
            Long channelId2 = entry.getValue().getChannelId();
            if (channelId2 != null && channelId2.longValue() == channelId) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @StoreThread
    public final Map<Long, Map<Long, VoiceState>> getInternal$app_productionGoogleRelease() {
        return this.voiceStates;
    }

    @StoreThread
    public final void handleAuthToken(String authToken) {
        if (authToken == null) {
            clear();
        }
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        d0.z.d.m.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
        this.myUserId = Long.valueOf(payload.getMe().getId());
        clear();
        List<Guild> guilds = payload.getGuilds();
        d0.z.d.m.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            List<VoiceState> listR = guild.R();
            if (listR != null) {
                Iterator<T> it = listR.iterator();
                while (it.hasNext()) {
                    updateVoiceState((VoiceState) it.next(), Long.valueOf(guild.getId()));
                }
            }
        }
    }

    @StoreThread
    public final void handleGuildAdd(Guild guild) {
        d0.z.d.m.checkNotNullParameter(guild, "guild");
        List<VoiceState> listR = guild.R();
        if (listR != null) {
            Iterator<T> it = listR.iterator();
            while (it.hasNext()) {
                updateVoiceState((VoiceState) it.next(), Long.valueOf(guild.getId()));
            }
        }
    }

    @StoreThread
    public final void handleGuildRemove(Guild guild) {
        d0.z.d.m.checkNotNullParameter(guild, "guild");
        this.voiceStates.remove(Long.valueOf(guild.getId()));
        this.dirtyGuildIds.add(Long.valueOf(guild.getId()));
        markChanged();
    }

    @StoreThread
    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        d0.z.d.m.checkNotNullParameter(voiceState, "voiceState");
        updateVoiceState$default(this, voiceState, null, 2, null);
    }

    public final Observable<Map<Long, VoiceState>> observe(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null);
    }

    public final Observable<Map<Long, VoiceState>> observeForPrivateChannels(long channelId) {
        return observe(0L, channelId);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        HashMap map = new HashMap(this.voiceStates.size());
        for (Map.Entry<Long, HashMap<Long, VoiceState>> entry : this.voiceStates.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            HashMap<Long, VoiceState> value = entry.getValue();
            if (this.dirtyGuildIds.contains(Long.valueOf(jLongValue))) {
                map.put(Long.valueOf(jLongValue), new HashMap(value));
            } else {
                Map<Long, VoiceState> map2 = this.voiceStatesSnapshot.get(Long.valueOf(jLongValue));
                if (map2 != null) {
                    map.put(Long.valueOf(jLongValue), map2);
                }
            }
        }
        this.voiceStatesSnapshot = map;
        this.dirtyGuildIds.clear();
    }

    public final Observable<Map<Long, VoiceState>> observe(long guildId, long channelId) {
        Observable<Map<Long, VoiceState>> observableR = observe(guildId).Y(new AnonymousClass2(channelId)).r();
        d0.z.d.m.checkNotNullExpressionValue(observableR, "observe(guildId)\n       …  .distinctUntilChanged()");
        return observableR;
    }
}
