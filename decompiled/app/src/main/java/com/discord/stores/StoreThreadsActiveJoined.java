package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.thread.ThreadMemberUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreThreadsActiveJoined.kt */
/* loaded from: classes2.dex */
public final class StoreThreadsActiveJoined extends StoreV2 {
    private final Map<Long, ActiveJoinedThread> activeJoinedThreads;
    private Map<Long, ActiveJoinedThread> activeJoinedThreadsByThreadIdSnapshot;
    private Map<Long, ? extends Map<Long, ? extends Map<Long, ActiveJoinedThread>>> activeJoinedThreadsHierarchicalSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreThreadsActive storeThreadsActive;
    private final StoreThreadsJoined storeThreadsJoined;

    /* compiled from: StoreThreadsActiveJoined.kt */
    public static final /* data */ class ActiveJoinedThread {
        private final Channel channel;
        private final UtcDateTime joinTimestamp;
        private final boolean muted;

        public ActiveJoinedThread(Channel channel, UtcDateTime utcDateTime, boolean z2) {
            m.checkNotNullParameter(channel, "channel");
            m.checkNotNullParameter(utcDateTime, "joinTimestamp");
            this.channel = channel;
            this.joinTimestamp = utcDateTime;
            this.muted = z2;
        }

        public static /* synthetic */ ActiveJoinedThread copy$default(ActiveJoinedThread activeJoinedThread, Channel channel, UtcDateTime utcDateTime, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = activeJoinedThread.channel;
            }
            if ((i & 2) != 0) {
                utcDateTime = activeJoinedThread.joinTimestamp;
            }
            if ((i & 4) != 0) {
                z2 = activeJoinedThread.muted;
            }
            return activeJoinedThread.copy(channel, utcDateTime, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final UtcDateTime getJoinTimestamp() {
            return this.joinTimestamp;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getMuted() {
            return this.muted;
        }

        public final ActiveJoinedThread copy(Channel channel, UtcDateTime joinTimestamp, boolean muted) {
            m.checkNotNullParameter(channel, "channel");
            m.checkNotNullParameter(joinTimestamp, "joinTimestamp");
            return new ActiveJoinedThread(channel, joinTimestamp, muted);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActiveJoinedThread)) {
                return false;
            }
            ActiveJoinedThread activeJoinedThread = (ActiveJoinedThread) other;
            return m.areEqual(this.channel, activeJoinedThread.channel) && m.areEqual(this.joinTimestamp, activeJoinedThread.joinTimestamp) && this.muted == activeJoinedThread.muted;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final UtcDateTime getJoinTimestamp() {
            return this.joinTimestamp;
        }

        public final boolean getMuted() {
            return this.muted;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            UtcDateTime utcDateTime = this.joinTimestamp;
            int iHashCode2 = (iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
            boolean z2 = this.muted;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public String toString() {
            StringBuilder sbU = a.U("ActiveJoinedThread(channel=");
            sbU.append(this.channel);
            sbU.append(", joinTimestamp=");
            sbU.append(this.joinTimestamp);
            sbU.append(", muted=");
            return a.O(sbU, this.muted, ")");
        }
    }

    /* compiled from: StoreThreadsActiveJoined.kt */
    /* renamed from: com.discord.stores.StoreThreadsActiveJoined$observeActiveJoinedThreadsChannelsForGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends Channel>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Channel> invoke2() {
            Collection<Map> collectionValues;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Map map = (Map) StoreThreadsActiveJoined.access$getActiveJoinedThreadsHierarchicalSnapshot$p(StoreThreadsActiveJoined.this).get(Long.valueOf(this.$guildId));
            if (map != null && (collectionValues = map.values()) != null) {
                for (Map map2 : collectionValues) {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(map2.size()));
                    for (Map.Entry entry : map2.entrySet()) {
                        linkedHashMap2.put(entry.getKey(), ((ActiveJoinedThread) entry.getValue()).getChannel());
                    }
                    linkedHashMap.putAll(linkedHashMap2);
                }
            }
            return h0.toMap(linkedHashMap);
        }
    }

    /* compiled from: StoreThreadsActiveJoined.kt */
    /* renamed from: com.discord.stores.StoreThreadsActiveJoined$observeActiveJoinedThreadsForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends ActiveJoinedThread>> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends ActiveJoinedThread> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends ActiveJoinedThread> invoke2() {
            Map<Long, ? extends ActiveJoinedThread> map;
            Map map2 = (Map) StoreThreadsActiveJoined.access$getActiveJoinedThreadsHierarchicalSnapshot$p(StoreThreadsActiveJoined.this).get(Long.valueOf(this.$guildId));
            return (map2 == null || (map = (Map) map2.get(Long.valueOf(this.$channelId))) == null) ? h0.emptyMap() : map;
        }
    }

    /* compiled from: StoreThreadsActiveJoined.kt */
    /* renamed from: com.discord.stores.StoreThreadsActiveJoined$observeActiveJoinedThreadsForGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends Map<Long, ? extends ActiveJoinedThread>>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Long, ? extends ActiveJoinedThread>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Map<Long, ? extends ActiveJoinedThread>> invoke2() {
            Map<Long, ? extends Map<Long, ? extends ActiveJoinedThread>> map = (Map) StoreThreadsActiveJoined.access$getActiveJoinedThreadsHierarchicalSnapshot$p(StoreThreadsActiveJoined.this).get(Long.valueOf(this.$guildId));
            return map != null ? map : h0.emptyMap();
        }
    }

    /* compiled from: StoreThreadsActiveJoined.kt */
    /* renamed from: com.discord.stores.StoreThreadsActiveJoined$observeAllActiveJoinedThreadsById$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends ActiveJoinedThread>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends ActiveJoinedThread> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends ActiveJoinedThread> invoke2() {
            return StoreThreadsActiveJoined.access$getActiveJoinedThreadsByThreadIdSnapshot$p(StoreThreadsActiveJoined.this);
        }
    }

    /* compiled from: StoreThreadsActiveJoined.kt */
    /* renamed from: com.discord.stores.StoreThreadsActiveJoined$observeAllActiveJoinedThreadsChannelsById$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends Channel>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Channel> invoke2() {
            Map mapAccess$getActiveJoinedThreadsByThreadIdSnapshot$p = StoreThreadsActiveJoined.access$getActiveJoinedThreadsByThreadIdSnapshot$p(StoreThreadsActiveJoined.this);
            LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(mapAccess$getActiveJoinedThreadsByThreadIdSnapshot$p.size()));
            for (Map.Entry entry : mapAccess$getActiveJoinedThreadsByThreadIdSnapshot$p.entrySet()) {
                linkedHashMap.put(entry.getKey(), ((ActiveJoinedThread) entry.getValue()).getChannel());
            }
            return linkedHashMap;
        }
    }

    public /* synthetic */ StoreThreadsActiveJoined(StoreThreadsActive storeThreadsActive, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeThreadsActive, storeThreadsJoined, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Map access$getActiveJoinedThreadsByThreadIdSnapshot$p(StoreThreadsActiveJoined storeThreadsActiveJoined) {
        return storeThreadsActiveJoined.activeJoinedThreadsByThreadIdSnapshot;
    }

    public static final /* synthetic */ Map access$getActiveJoinedThreadsHierarchicalSnapshot$p(StoreThreadsActiveJoined storeThreadsActiveJoined) {
        return storeThreadsActiveJoined.activeJoinedThreadsHierarchicalSnapshot;
    }

    public static final /* synthetic */ void access$setActiveJoinedThreadsByThreadIdSnapshot$p(StoreThreadsActiveJoined storeThreadsActiveJoined, Map map) {
        storeThreadsActiveJoined.activeJoinedThreadsByThreadIdSnapshot = map;
    }

    public static final /* synthetic */ void access$setActiveJoinedThreadsHierarchicalSnapshot$p(StoreThreadsActiveJoined storeThreadsActiveJoined, Map map) {
        storeThreadsActiveJoined.activeJoinedThreadsHierarchicalSnapshot = map;
    }

    @StoreThread
    private final void saveThreads(Long guildId) {
        Channel channel;
        Map<Long, Map<Long, Channel>> allActiveThreadsInternal$app_productionGoogleRelease = this.storeThreadsActive.getAllActiveThreadsInternal$app_productionGoogleRelease();
        for (StoreThreadsJoined.JoinedThread joinedThread : this.storeThreadsJoined.getAllJoinedThreadsInternal$app_productionGoogleRelease().values()) {
            if (guildId == null || joinedThread.getGuildId() == guildId.longValue()) {
                Map<Long, Channel> map = allActiveThreadsInternal$app_productionGoogleRelease.get(Long.valueOf(joinedThread.getGuildId()));
                if (map != null && (channel = map.get(Long.valueOf(joinedThread.getThreadId()))) != null) {
                    this.activeJoinedThreads.put(Long.valueOf(channel.getId()), new ActiveJoinedThread(channel, joinedThread.getJoinTimestamp(), joinedThread.getMuted()));
                    markChanged();
                }
            }
        }
    }

    public static /* synthetic */ void saveThreads$default(StoreThreadsActiveJoined storeThreadsActiveJoined, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        storeThreadsActiveJoined.saveThreads(l);
    }

    @StoreThread
    private final void updateThread(long guildId, long channelId) {
        Map<Long, Channel> map = this.storeThreadsActive.getAllActiveThreadsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        Channel channel = map != null ? map.get(Long.valueOf(channelId)) : null;
        StoreThreadsJoined.JoinedThread joinedThread = this.storeThreadsJoined.getAllJoinedThreadsInternal$app_productionGoogleRelease().get(Long.valueOf(channelId));
        if (channel != null && joinedThread != null) {
            this.activeJoinedThreads.put(Long.valueOf(channelId), new ActiveJoinedThread(channel, joinedThread.getJoinTimestamp(), joinedThread.getMuted()));
            markChanged();
        } else if (this.activeJoinedThreads.containsKey(Long.valueOf(channelId))) {
            this.activeJoinedThreads.remove(Long.valueOf(channelId));
            markChanged();
        }
    }

    @StoreThread
    public final List<Channel> getActiveJoinedThreadsForChannelInternal$app_productionGoogleRelease(long channelId) {
        Collection<ActiveJoinedThread> collectionValues = this.activeJoinedThreads.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((ActiveJoinedThread) obj).getChannel().getParentId() == channelId) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ActiveJoinedThread) it.next()).getChannel());
        }
        return arrayList2;
    }

    @StoreThread
    public final Map<Long, ActiveJoinedThread> getActiveJoinedThreadsInternal$app_productionGoogleRelease() {
        return this.activeJoinedThreads;
    }

    @StoreThread
    public final void handleChannelCreateOrUpdate(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        for (Channel channel2 : getActiveJoinedThreadsForChannelInternal$app_productionGoogleRelease(channel.getId())) {
            updateThread(channel2.getGuildId(), channel2.getId());
        }
    }

    @StoreThread
    public final void handleConnectionOpen() {
        this.activeJoinedThreads.clear();
        saveThreads$default(this, null, 1, null);
        markChanged();
    }

    @StoreThread
    public final void handleGuildCreate(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        saveThreads(Long.valueOf(guild.getId()));
    }

    @StoreThread
    public final void handleGuildDelete(long guildId) {
        Iterator<ActiveJoinedThread> it = this.activeJoinedThreads.values().iterator();
        while (it.hasNext()) {
            if (it.next().getChannel().getGuildId() == guildId) {
                it.remove();
                markChanged();
            }
        }
    }

    @StoreThread
    public final void handleThreadCreateOrUpdateOrDelete(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        updateThread(channel.getGuildId(), channel.getId());
    }

    @StoreThread
    public final void handleThreadListSync(ModelThreadListSync payload) {
        m.checkNotNullParameter(payload, "payload");
        handleGuildDelete(payload.getGuildId());
        saveThreads(Long.valueOf(payload.getGuildId()));
    }

    @StoreThread
    public final void handleThreadMemberUpdate(ThreadMemberUpdate payload) {
        m.checkNotNullParameter(payload, "payload");
        updateThread(payload.getGuildId(), payload.getId());
    }

    @StoreThread
    public final void handleThreadMembersUpdate(ThreadMembersUpdate payload) {
        m.checkNotNullParameter(payload, "payload");
        updateThread(payload.getGuildId(), payload.getId());
    }

    public final Observable<Map<Long, Channel>> observeActiveJoinedThreadsChannelsForGuild(long guildId) {
        Observable<Map<Long, Channel>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, ActiveJoinedThread>> observeActiveJoinedThreadsForChannel(long guildId, long channelId) {
        Observable<Map<Long, ActiveJoinedThread>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId, channelId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Map<Long, ActiveJoinedThread>>> observeActiveJoinedThreadsForGuild(long guildId) {
        Observable<Map<Long, Map<Long, ActiveJoinedThread>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, ActiveJoinedThread>> observeAllActiveJoinedThreadsById() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Map<Long, Channel>> observeAllActiveJoinedThreadsChannelsById() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.activeJoinedThreadsByThreadIdSnapshot = new HashMap(this.activeJoinedThreads);
        Collection<ActiveJoinedThread> collectionValues = this.activeJoinedThreads.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : collectionValues) {
            Long lValueOf = Long.valueOf(((ActiveJoinedThread) obj).getChannel().getGuildId());
            Object arrayList = linkedHashMap.get(lValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(lValueOf, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            List list = (List) entry.getValue();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Object obj2 : list) {
                Long lValueOf2 = Long.valueOf(((ActiveJoinedThread) obj2).getChannel().getParentId());
                Object arrayList2 = linkedHashMap3.get(lValueOf2);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap3.put(lValueOf2, arrayList2);
                }
                ((List) arrayList2).add(obj2);
            }
            LinkedHashMap linkedHashMap4 = new LinkedHashMap(g0.mapCapacity(linkedHashMap3.size()));
            for (Map.Entry entry2 : linkedHashMap3.entrySet()) {
                Object key2 = entry2.getKey();
                List list2 = (List) entry2.getValue();
                LinkedHashMap linkedHashMap5 = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(list2, 10)), 16));
                for (Object obj3 : list2) {
                    linkedHashMap5.put(Long.valueOf(((ActiveJoinedThread) obj3).getChannel().getId()), obj3);
                }
                linkedHashMap4.put(key2, linkedHashMap5);
            }
            linkedHashMap2.put(key, linkedHashMap4);
        }
        this.activeJoinedThreadsHierarchicalSnapshot = linkedHashMap2;
    }

    public StoreThreadsActiveJoined(StoreThreadsActive storeThreadsActive, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        m.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeThreadsActive = storeThreadsActive;
        this.storeThreadsJoined = storeThreadsJoined;
        this.observationDeck = observationDeck;
        this.activeJoinedThreads = new HashMap();
        this.activeJoinedThreadsByThreadIdSnapshot = new HashMap();
        this.activeJoinedThreadsHierarchicalSnapshot = new HashMap();
    }
}
