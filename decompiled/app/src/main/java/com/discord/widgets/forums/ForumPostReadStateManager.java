package com.discord.widgets.forums;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreForumPostReadStates;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsActive;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.f0.q;
import d0.t.h0;
import d0.t.u;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.subjects.BehaviorSubject;

/* compiled from: ForumPostReadStateManager.kt */
/* loaded from: classes2.dex */
public final class ForumPostReadStateManager {
    public static final ForumPostReadStateManager INSTANCE = new ForumPostReadStateManager();
    private static final BehaviorSubject<StoreMessageAck.Ack> forumChannelAckBeforeChannelSelect;
    private static Subscription forumChannelAckSubscription;
    private static Map<Long, StoreMessageAck.Ack> internalMessageAcks;
    private static final Set<Long> internalThreadSyncedGuilds;
    private static long lastSelectedChannelId;
    private static long lastSyncedGuildId;

    /* compiled from: ForumPostReadStateManager.kt */
    public static final /* data */ class ManagerInitializeState {
        private final Map<Long, StoreMessageAck.Ack> messageAcks;
        private final StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel;
        private final Set<Long> threadSyncedGuilds;

        public ManagerInitializeState(Map<Long, StoreMessageAck.Ack> map, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Set<Long> set) {
            m.checkNotNullParameter(map, "messageAcks");
            m.checkNotNullParameter(resolvedSelectedChannel, "resolvedSelectedChannel");
            m.checkNotNullParameter(set, "threadSyncedGuilds");
            this.messageAcks = map;
            this.resolvedSelectedChannel = resolvedSelectedChannel;
            this.threadSyncedGuilds = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ManagerInitializeState copy$default(ManagerInitializeState managerInitializeState, Map map, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                map = managerInitializeState.messageAcks;
            }
            if ((i & 2) != 0) {
                resolvedSelectedChannel = managerInitializeState.resolvedSelectedChannel;
            }
            if ((i & 4) != 0) {
                set = managerInitializeState.threadSyncedGuilds;
            }
            return managerInitializeState.copy(map, resolvedSelectedChannel, set);
        }

        public final Map<Long, StoreMessageAck.Ack> component1() {
            return this.messageAcks;
        }

        /* renamed from: component2, reason: from getter */
        public final StoreChannelsSelected.ResolvedSelectedChannel getResolvedSelectedChannel() {
            return this.resolvedSelectedChannel;
        }

        public final Set<Long> component3() {
            return this.threadSyncedGuilds;
        }

        public final ManagerInitializeState copy(Map<Long, StoreMessageAck.Ack> messageAcks, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Set<Long> threadSyncedGuilds) {
            m.checkNotNullParameter(messageAcks, "messageAcks");
            m.checkNotNullParameter(resolvedSelectedChannel, "resolvedSelectedChannel");
            m.checkNotNullParameter(threadSyncedGuilds, "threadSyncedGuilds");
            return new ManagerInitializeState(messageAcks, resolvedSelectedChannel, threadSyncedGuilds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ManagerInitializeState)) {
                return false;
            }
            ManagerInitializeState managerInitializeState = (ManagerInitializeState) other;
            return m.areEqual(this.messageAcks, managerInitializeState.messageAcks) && m.areEqual(this.resolvedSelectedChannel, managerInitializeState.resolvedSelectedChannel) && m.areEqual(this.threadSyncedGuilds, managerInitializeState.threadSyncedGuilds);
        }

        public final Map<Long, StoreMessageAck.Ack> getMessageAcks() {
            return this.messageAcks;
        }

        public final StoreChannelsSelected.ResolvedSelectedChannel getResolvedSelectedChannel() {
            return this.resolvedSelectedChannel;
        }

        public final Set<Long> getThreadSyncedGuilds() {
            return this.threadSyncedGuilds;
        }

        public int hashCode() {
            Map<Long, StoreMessageAck.Ack> map = this.messageAcks;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel = this.resolvedSelectedChannel;
            int iHashCode2 = (iHashCode + (resolvedSelectedChannel != null ? resolvedSelectedChannel.hashCode() : 0)) * 31;
            Set<Long> set = this.threadSyncedGuilds;
            return iHashCode2 + (set != null ? set.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("ManagerInitializeState(messageAcks=");
            sbU.append(this.messageAcks);
            sbU.append(", resolvedSelectedChannel=");
            sbU.append(this.resolvedSelectedChannel);
            sbU.append(", threadSyncedGuilds=");
            return a.N(sbU, this.threadSyncedGuilds, ")");
        }
    }

    /* compiled from: ForumPostReadStateManager.kt */
    /* renamed from: com.discord.widgets.forums.ForumPostReadStateManager$initialize$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Map<Long, ? extends StoreMessageAck.Ack>, StoreChannelsSelected.ResolvedSelectedChannel, Set<? extends Long>, ManagerInitializeState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ ManagerInitializeState call(Map<Long, ? extends StoreMessageAck.Ack> map, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Set<? extends Long> set) {
            return call2((Map<Long, StoreMessageAck.Ack>) map, resolvedSelectedChannel, (Set<Long>) set);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ManagerInitializeState call2(Map<Long, StoreMessageAck.Ack> map, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Set<Long> set) {
            m.checkNotNullExpressionValue(map, "messageAcks");
            m.checkNotNullExpressionValue(resolvedSelectedChannel, "resolvedSelectedChannel");
            m.checkNotNullExpressionValue(set, "threadSyncedGuilds");
            return new ManagerInitializeState(map, resolvedSelectedChannel, set);
        }
    }

    /* compiled from: ForumPostReadStateManager.kt */
    /* renamed from: com.discord.widgets.forums.ForumPostReadStateManager$initialize$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<Subscription, Unit> {
        public AnonymousClass2(ForumPostReadStateManager forumPostReadStateManager) {
            super(1, forumPostReadStateManager, ForumPostReadStateManager.class, "handleSubscription", "handleSubscription(Lrx/Subscription;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, "p1");
            ForumPostReadStateManager.access$handleSubscription((ForumPostReadStateManager) this.receiver, subscription);
        }
    }

    /* compiled from: ForumPostReadStateManager.kt */
    /* renamed from: com.discord.widgets.forums.ForumPostReadStateManager$initialize$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<ManagerInitializeState, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ManagerInitializeState managerInitializeState) {
            invoke2(managerInitializeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ManagerInitializeState managerInitializeState) {
            Map<Long, StoreMessageAck.Ack> mapComponent1 = managerInitializeState.component1();
            StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel = managerInitializeState.getResolvedSelectedChannel();
            Set<Long> setComponent3 = managerInitializeState.component3();
            Channel maybeChannel = resolvedSelectedChannel.getMaybeChannel();
            if (maybeChannel == null || !ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, maybeChannel.getGuildId(), null, 2, null)) {
                return;
            }
            boolean z2 = setComponent3.contains(Long.valueOf(maybeChannel.getGuildId())) && maybeChannel.getGuildId() != ForumPostReadStateManager.access$getLastSyncedGuildId$p(ForumPostReadStateManager.INSTANCE);
            boolean z3 = ChannelUtils.q(maybeChannel) && maybeChannel.getId() != ForumPostReadStateManager.access$getLastSelectedChannelId$p(ForumPostReadStateManager.INSTANCE);
            if (z2) {
                ForumPostReadStateManager forumPostReadStateManager = ForumPostReadStateManager.INSTANCE;
                ForumPostReadStateManager.access$setInternalMessageAcks$p(forumPostReadStateManager, mapComponent1);
                ForumPostReadStateManager.access$setLastSyncedGuildId$p(forumPostReadStateManager, maybeChannel.getGuildId());
            }
            if (z3 || z2) {
                ForumPostReadStateManager forumPostReadStateManager2 = ForumPostReadStateManager.INSTANCE;
                ForumPostReadStateManager.access$getForumChannelAckBeforeChannelSelect$p(forumPostReadStateManager2).onNext(ForumPostReadStateManager.access$getInternalMessageAcks$p(forumPostReadStateManager2).get(Long.valueOf(maybeChannel.getId())));
            }
            ForumPostReadStateManager forumPostReadStateManager3 = ForumPostReadStateManager.INSTANCE;
            ForumPostReadStateManager.access$setLastSelectedChannelId$p(forumPostReadStateManager3, resolvedSelectedChannel.getId());
            ForumPostReadStateManager.access$setInternalMessageAcks$p(forumPostReadStateManager3, mapComponent1);
        }
    }

    /* compiled from: ForumPostReadStateManager.kt */
    /* renamed from: com.discord.widgets.forums.ForumPostReadStateManager$observeForumPostReadStates$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, R> implements Func4<Map<Long, ? extends Channel>, Set<? extends Long>, Set<? extends Long>, StoreMessageAck.Ack, Map<Long, ? extends ForumPostReadState>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* compiled from: ForumPostReadStateManager.kt */
        /* renamed from: com.discord.widgets.forums.ForumPostReadStateManager$observeForumPostReadStates$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04081 extends o implements Function1<Long, ForumPostReadState> {
            public final /* synthetic */ StoreMessageAck.Ack $forumChannelAck;
            public final /* synthetic */ Set $persistedThreadIds;
            public final /* synthetic */ Set $unreadChannelIds;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C04081(StoreMessageAck.Ack ack, Set set, Set set2) {
                super(1);
                this.$forumChannelAck = ack;
                this.$persistedThreadIds = set;
                this.$unreadChannelIds = set2;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ForumPostReadState invoke(Long l) {
                return invoke(l.longValue());
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final ForumPostReadState invoke(long j) {
                boolean z2;
                if (this.$persistedThreadIds.contains(Long.valueOf(j))) {
                    z2 = true;
                } else {
                    StoreMessageAck.Ack ack = this.$forumChannelAck;
                    if ((ack != null ? Long.valueOf(ack.getMessageId()) : null) != null && ForumPostReadStateManager.access$compareChannelIds(ForumPostReadStateManager.INSTANCE, Long.valueOf(j), Long.valueOf(this.$forumChannelAck.getMessageId())) > 0) {
                        z2 = false;
                    }
                }
                return new ForumPostReadState(j, z2, this.$unreadChannelIds.contains(Long.valueOf(j)));
            }
        }

        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ Map<Long, ? extends ForumPostReadState> call(Map<Long, ? extends Channel> map, Set<? extends Long> set, Set<? extends Long> set2, StoreMessageAck.Ack ack) {
            return call2((Map<Long, Channel>) map, (Set<Long>) set, (Set<Long>) set2, ack);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, ForumPostReadState> call2(Map<Long, Channel> map, Set<Long> set, Set<Long> set2, StoreMessageAck.Ack ack) {
            Sequence map2 = q.map(u.asSequence(map.keySet()), new C04081(ack, set, set2));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : map2) {
                linkedHashMap.put(Long.valueOf(((ForumPostReadState) obj).getChannelId()), obj);
            }
            return linkedHashMap;
        }
    }

    static {
        BehaviorSubject<StoreMessageAck.Ack> behaviorSubjectK0 = BehaviorSubject.k0();
        m.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
        forumChannelAckBeforeChannelSelect = behaviorSubjectK0;
        internalMessageAcks = h0.emptyMap();
        internalThreadSyncedGuilds = new LinkedHashSet();
    }

    private ForumPostReadStateManager() {
    }

    public static final /* synthetic */ int access$compareChannelIds(ForumPostReadStateManager forumPostReadStateManager, Long l, Long l2) {
        return forumPostReadStateManager.compareChannelIds(l, l2);
    }

    public static final /* synthetic */ BehaviorSubject access$getForumChannelAckBeforeChannelSelect$p(ForumPostReadStateManager forumPostReadStateManager) {
        return forumChannelAckBeforeChannelSelect;
    }

    public static final /* synthetic */ Map access$getInternalMessageAcks$p(ForumPostReadStateManager forumPostReadStateManager) {
        return internalMessageAcks;
    }

    public static final /* synthetic */ long access$getLastSelectedChannelId$p(ForumPostReadStateManager forumPostReadStateManager) {
        return lastSelectedChannelId;
    }

    public static final /* synthetic */ long access$getLastSyncedGuildId$p(ForumPostReadStateManager forumPostReadStateManager) {
        return lastSyncedGuildId;
    }

    public static final /* synthetic */ void access$handleSubscription(ForumPostReadStateManager forumPostReadStateManager, Subscription subscription) {
        forumPostReadStateManager.handleSubscription(subscription);
    }

    public static final /* synthetic */ void access$setInternalMessageAcks$p(ForumPostReadStateManager forumPostReadStateManager, Map map) {
        internalMessageAcks = map;
    }

    public static final /* synthetic */ void access$setLastSelectedChannelId$p(ForumPostReadStateManager forumPostReadStateManager, long j) {
        lastSelectedChannelId = j;
    }

    public static final /* synthetic */ void access$setLastSyncedGuildId$p(ForumPostReadStateManager forumPostReadStateManager, long j) {
        lastSyncedGuildId = j;
    }

    private final int compareChannelIds(Long channelId1, Long channelId2) {
        long jLongValue = channelId1 != null ? channelId1.longValue() : 0L;
        long jLongValue2 = channelId2 != null ? channelId2.longValue() : 0L;
        if (jLongValue == jLongValue2) {
            return 0;
        }
        return jLongValue < jLongValue2 ? -1 : 1;
    }

    private final void handleSubscription(Subscription subscription) {
        forumChannelAckSubscription = subscription;
    }

    public static /* synthetic */ void initialize$default(ForumPostReadStateManager forumPostReadStateManager, StoreMessageAck storeMessageAck, StoreChannelsSelected storeChannelsSelected, StoreThreadsActive storeThreadsActive, int i, Object obj) {
        if ((i & 1) != 0) {
            storeMessageAck = StoreStream.INSTANCE.getMessageAck();
        }
        if ((i & 2) != 0) {
            storeChannelsSelected = StoreStream.INSTANCE.getChannelsSelected();
        }
        if ((i & 4) != 0) {
            storeThreadsActive = StoreStream.INSTANCE.getThreadsActive();
        }
        forumPostReadStateManager.initialize(storeMessageAck, storeChannelsSelected, storeThreadsActive);
    }

    private final BehaviorSubject<StoreMessageAck.Ack> observeForumChannelAckBeforeChannelSelect() {
        return forumChannelAckBeforeChannelSelect;
    }

    public static /* synthetic */ Observable observeForumPostReadStates$default(ForumPostReadStateManager forumPostReadStateManager, long j, long j2, StoreReadStates storeReadStates, StoreThreadsActive storeThreadsActive, StoreForumPostReadStates storeForumPostReadStates, int i, Object obj) {
        return forumPostReadStateManager.observeForumPostReadStates(j, j2, (i & 4) != 0 ? StoreStream.INSTANCE.getReadStates() : storeReadStates, (i & 8) != 0 ? StoreStream.INSTANCE.getThreadsActive() : storeThreadsActive, (i & 16) != 0 ? StoreStream.INSTANCE.getForumPostReadStates() : storeForumPostReadStates);
    }

    public final void initialize(StoreMessageAck storeMessageAck, StoreChannelsSelected storeChannelsSelected, StoreThreadsActive storeThreadsActive) {
        m.checkNotNullParameter(storeMessageAck, "storeMessageAck");
        m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        m.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        Subscription subscription = forumChannelAckSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable observableI = Observable.i(storeMessageAck.observeAll(), storeChannelsSelected.observeResolvedSelectedChannel(), storeThreadsActive.observeThreadSyncedGuilds(), AnonymousClass1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…threadSyncedGuilds)\n    }");
        ObservableExtensionsKt.appSubscribe$default(observableI, ForumPostReadStateManager.class, (Context) null, new AnonymousClass2(this), (Function1) null, (Function0) null, (Function0) null, AnonymousClass3.INSTANCE, 58, (Object) null);
    }

    public final Observable<Map<Long, ForumPostReadState>> observeForumPostReadStates(long guildId, long channelId, StoreReadStates storeReadStates, StoreThreadsActive storeThreadsActive, StoreForumPostReadStates storeForumPostReadStates) {
        m.checkNotNullParameter(storeReadStates, "storeReadStates");
        m.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        m.checkNotNullParameter(storeForumPostReadStates, "storeForumPostReadStates");
        Observable<Map<Long, ForumPostReadState>> observableH = Observable.h(storeThreadsActive.observeActiveThreadsForChannel(guildId, Long.valueOf(channelId)), storeForumPostReadStates.observeThreadIdsWithPersistedReadStates(), storeReadStates.getUnreadChannelIds(), observeForumChannelAckBeforeChannelSelect(), AnonymousClass1.INSTANCE);
        m.checkNotNullExpressionValue(observableH, "Observable.combineLatest…By { it.channelId }\n    }");
        return observableH;
    }
}
