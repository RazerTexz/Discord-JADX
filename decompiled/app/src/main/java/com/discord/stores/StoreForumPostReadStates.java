package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.forum.ForumUnread;
import com.discord.api.forum.ForumUnreads;
import com.discord.api.message.Message;
import com.discord.api.user.User;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.updates.ObservationDeck;
import com.discord.widgets.forums.ForumUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.Tuples;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreForumPostReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreForumPostReadStates extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Set<Long> processedForumUnreadRequests;
    private final StoreChannels storeChannels;
    private final StoreGatewayConnection storeGatewayConnection;
    private final StoreMessageAck storeMessageAck;
    private final StoreThreadsActive storeThreadsActive;
    private final StoreUser storeUser;
    private final Set<Long> threadIdsWithPersistedAcks;
    private Set<Long> threadIdsWithPersistedAcksSnapshot;
    private final Map<Long, Integer> threadUnreadCounts;
    private Map<Long, Integer> threadUnreadCountsSnapshot;

    /* JADX INFO: renamed from: com.discord.stores.StoreForumPostReadStates$observeThreadIdsWithPersistedReadStates$1 */
    /* JADX INFO: compiled from: StoreForumPostReadStates.kt */
    public static final class C59381 extends Lambda implements Function0<Set<? extends Long>> {
        public C59381() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Long> invoke2() {
            return StoreForumPostReadStates.access$getThreadIdsWithPersistedAcksSnapshot$p(StoreForumPostReadStates.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreForumPostReadStates$observeThreadUnreadCounts$1 */
    /* JADX INFO: compiled from: StoreForumPostReadStates.kt */
    public static final class C59391 extends Lambda implements Function0<Map<Long, ? extends Integer>> {
        public C59391() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Integer> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Integer> invoke2() {
            return StoreForumPostReadStates.access$getThreadUnreadCountsSnapshot$p(StoreForumPostReadStates.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreForumPostReadStates$requestForumUnreads$1 */
    /* JADX INFO: compiled from: StoreForumPostReadStates.kt */
    public static final class C59401 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59401(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, this.$guildId, null, 2, null) || StoreForumPostReadStates.access$getProcessedForumUnreadRequests$p(StoreForumPostReadStates.this).contains(Long.valueOf(this.$channelId))) {
                return;
            }
            StoreForumPostReadStates.access$getProcessedForumUnreadRequests$p(StoreForumPostReadStates.this).add(Long.valueOf(this.$channelId));
            Map<Long, Channel> mapEmptyMap = StoreForumPostReadStates.access$getStoreThreadsActive$p(StoreForumPostReadStates.this).getAllActiveThreadsInternal$app_productionGoogleRelease().get(Long.valueOf(this.$guildId));
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Channel> entry : mapEmptyMap.entrySet()) {
                if (entry.getValue().getParentId() == this.$channelId) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Map<Long, StoreMessageAck.Ack> all = StoreForumPostReadStates.access$getStoreMessageAck$p(StoreForumPostReadStates.this).getAll();
            Set setKeySet = linkedHashMap.keySet();
            ArrayList arrayList = new ArrayList();
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                StoreMessageAck.Ack ack = all.get(Long.valueOf(jLongValue));
                Tuples2 tuples2M10073to = ack != null ? Tuples.m10073to(Long.valueOf(jLongValue), Long.valueOf(ack.getMessageId())) : null;
                if (tuples2M10073to != null) {
                    arrayList.add(tuples2M10073to);
                }
            }
            StoreForumPostReadStates.access$getStoreGatewayConnection$p(StoreForumPostReadStates.this).requestForumUnreads(this.$guildId, this.$channelId, arrayList);
        }
    }

    public StoreForumPostReadStates(Dispatcher dispatcher, StoreGatewayConnection storeGatewayConnection, StoreThreadsActive storeThreadsActive, StoreMessageAck storeMessageAck, StoreChannels storeChannels, StoreUser storeUser, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeGatewayConnection, "storeGatewayConnection");
        Intrinsics3.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        Intrinsics3.checkNotNullParameter(storeMessageAck, "storeMessageAck");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeGatewayConnection = storeGatewayConnection;
        this.storeThreadsActive = storeThreadsActive;
        this.storeMessageAck = storeMessageAck;
        this.storeChannels = storeChannels;
        this.storeUser = storeUser;
        this.observationDeck = observationDeck;
        this.threadIdsWithPersistedAcks = new LinkedHashSet();
        this.threadIdsWithPersistedAcksSnapshot = Sets5.emptySet();
        this.threadUnreadCounts = new LinkedHashMap();
        this.threadUnreadCountsSnapshot = Maps6.emptyMap();
        this.processedForumUnreadRequests = new LinkedHashSet();
    }

    public static final /* synthetic */ Set access$getProcessedForumUnreadRequests$p(StoreForumPostReadStates storeForumPostReadStates) {
        return storeForumPostReadStates.processedForumUnreadRequests;
    }

    public static final /* synthetic */ StoreGatewayConnection access$getStoreGatewayConnection$p(StoreForumPostReadStates storeForumPostReadStates) {
        return storeForumPostReadStates.storeGatewayConnection;
    }

    public static final /* synthetic */ StoreMessageAck access$getStoreMessageAck$p(StoreForumPostReadStates storeForumPostReadStates) {
        return storeForumPostReadStates.storeMessageAck;
    }

    public static final /* synthetic */ StoreThreadsActive access$getStoreThreadsActive$p(StoreForumPostReadStates storeForumPostReadStates) {
        return storeForumPostReadStates.storeThreadsActive;
    }

    public static final /* synthetic */ Set access$getThreadIdsWithPersistedAcksSnapshot$p(StoreForumPostReadStates storeForumPostReadStates) {
        return storeForumPostReadStates.threadIdsWithPersistedAcksSnapshot;
    }

    public static final /* synthetic */ Map access$getThreadUnreadCountsSnapshot$p(StoreForumPostReadStates storeForumPostReadStates) {
        return storeForumPostReadStates.threadUnreadCountsSnapshot;
    }

    public static final /* synthetic */ void access$setThreadIdsWithPersistedAcksSnapshot$p(StoreForumPostReadStates storeForumPostReadStates, Set set) {
        storeForumPostReadStates.threadIdsWithPersistedAcksSnapshot = set;
    }

    public static final /* synthetic */ void access$setThreadUnreadCountsSnapshot$p(StoreForumPostReadStates storeForumPostReadStates, Map map) {
        storeForumPostReadStates.threadUnreadCountsSnapshot = map;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        ModelPayload.VersionedReadStates readState = payload.getReadState();
        Intrinsics3.checkNotNullExpressionValue(readState, "payload.readState");
        if (!readState.isPartial()) {
            this.threadIdsWithPersistedAcks.clear();
        }
        this.processedForumUnreadRequests.clear();
        this.threadUnreadCounts.clear();
        ModelPayload.VersionedReadStates readState2 = payload.getReadState();
        Intrinsics3.checkNotNullExpressionValue(readState2, "payload.readState");
        List<ModelReadState> entries = readState2.getEntries();
        Intrinsics3.checkNotNullExpressionValue(entries, "payload.readState.entries");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(entries, 10));
        Iterator<T> it = entries.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((ModelReadState) it.next()).getChannelId()));
        }
        this.threadIdsWithPersistedAcks.addAll(arrayList);
        markChanged();
    }

    @Store3
    public final void handleForumUnreads(ForumUnreads forumUnreads) {
        Intrinsics3.checkNotNullParameter(forumUnreads, "forumUnreads");
        if (forumUnreads.getPermissionDenied()) {
            return;
        }
        for (ForumUnread forumUnread : forumUnreads.m7825b()) {
            Map<Long, Integer> map = this.threadUnreadCounts;
            Long lValueOf = Long.valueOf(forumUnread.getThreadId());
            Integer count = forumUnread.getCount();
            map.put(lValueOf, Integer.valueOf(count != null ? count.intValue() : 0));
        }
        markChanged();
    }

    @Store3
    public final void handleMessageAck(ModelReadState readState) {
        Intrinsics3.checkNotNullParameter(readState, "readState");
        long channelId = readState.getChannelId();
        if (this.threadUnreadCounts.containsKey(Long.valueOf(channelId))) {
            this.threadUnreadCounts.put(Long.valueOf(channelId), 0);
            markChanged();
        }
    }

    @Store3
    public final void handleMessageCreate(Message message) {
        Channel channel;
        Intrinsics3.checkNotNullParameter(message, "message");
        long channelId = message.getChannelId();
        Channel channel2 = this.storeChannels.getChannel(channelId);
        if (channel2 == null || (channel = this.storeChannels.getChannel(channel2.getParentId())) == null || !ChannelUtils.m7694r(channel2, channel)) {
            return;
        }
        User author = message.getAuthor();
        if (author == null || author.getId() != this.storeUser.getMeSnapshot().getId()) {
            Integer num = this.threadUnreadCounts.get(Long.valueOf(channelId));
            this.threadUnreadCounts.put(Long.valueOf(channelId), Integer.valueOf((num != null ? num.intValue() : 0) + 1));
        } else {
            this.threadUnreadCounts.put(Long.valueOf(channelId), 0);
        }
        markChanged();
    }

    @Store3
    public final void handleThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (!ChannelUtils.m7686j(channel) || this.threadUnreadCounts.remove(Long.valueOf(channel.getId())) == null) {
            return;
        }
        markChanged();
    }

    @Store3
    public final void handleThreadDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (this.threadUnreadCounts.remove(Long.valueOf(channel.getId())) != null) {
            markChanged();
        }
    }

    public final Observable<Set<Long>> observeThreadIdsWithPersistedReadStates() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C59381(), 14, null);
    }

    public final Observable<Map<Long, Integer>> observeThreadUnreadCounts() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C59391(), 14, null);
    }

    public final void requestForumUnreads(long guildId, long channelId) {
        this.dispatcher.schedule(new C59401(guildId, channelId));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.threadIdsWithPersistedAcksSnapshot = new HashSet(this.threadIdsWithPersistedAcks);
        this.threadUnreadCountsSnapshot = new HashMap(this.threadUnreadCounts);
    }
}
