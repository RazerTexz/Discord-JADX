package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadMember;
import com.discord.api.thread.ThreadMemberUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelPayload;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.search.network.state.SearchState;
import d0.t.h0;
import d0.t.r;
import d0.z.d.m;
import d0.z.d.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreThreadsJoined.kt */
/* loaded from: classes2.dex */
public final class StoreThreadsJoined extends StoreV2 {
    public static final int ALL_FLAGS = 15;
    public static final int NOTIFICATION_FLAGS = 14;
    private final Map<Long, JoinedThread> joinedThreads;
    private Map<Long, JoinedThread> joinedThreadsSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreUser storeUser;

    /* compiled from: StoreThreadsJoined.kt */
    public static final /* data */ class JoinedThread {
        private final int flags;
        private final long guildId;
        private final UtcDateTime joinTimestamp;
        private final ModelMuteConfig muteConfig;
        private final boolean muted;
        private final long threadId;

        public JoinedThread(long j, long j2, int i, boolean z2, ModelMuteConfig modelMuteConfig, UtcDateTime utcDateTime) {
            m.checkNotNullParameter(modelMuteConfig, "muteConfig");
            m.checkNotNullParameter(utcDateTime, "joinTimestamp");
            this.threadId = j;
            this.guildId = j2;
            this.flags = i;
            this.muted = z2;
            this.muteConfig = modelMuteConfig;
            this.joinTimestamp = utcDateTime;
        }

        public static /* synthetic */ JoinedThread copy$default(JoinedThread joinedThread, long j, long j2, int i, boolean z2, ModelMuteConfig modelMuteConfig, UtcDateTime utcDateTime, int i2, Object obj) {
            return joinedThread.copy((i2 & 1) != 0 ? joinedThread.threadId : j, (i2 & 2) != 0 ? joinedThread.guildId : j2, (i2 & 4) != 0 ? joinedThread.flags : i, (i2 & 8) != 0 ? joinedThread.muted : z2, (i2 & 16) != 0 ? joinedThread.muteConfig : modelMuteConfig, (i2 & 32) != 0 ? joinedThread.joinTimestamp : utcDateTime);
        }

        /* renamed from: component1, reason: from getter */
        public final long getThreadId() {
            return this.threadId;
        }

        /* renamed from: component2, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component3, reason: from getter */
        public final int getFlags() {
            return this.flags;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getMuted() {
            return this.muted;
        }

        /* renamed from: component5, reason: from getter */
        public final ModelMuteConfig getMuteConfig() {
            return this.muteConfig;
        }

        /* renamed from: component6, reason: from getter */
        public final UtcDateTime getJoinTimestamp() {
            return this.joinTimestamp;
        }

        public final JoinedThread copy(long threadId, long guildId, int flags, boolean muted, ModelMuteConfig muteConfig, UtcDateTime joinTimestamp) {
            m.checkNotNullParameter(muteConfig, "muteConfig");
            m.checkNotNullParameter(joinTimestamp, "joinTimestamp");
            return new JoinedThread(threadId, guildId, flags, muted, muteConfig, joinTimestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof JoinedThread)) {
                return false;
            }
            JoinedThread joinedThread = (JoinedThread) other;
            return this.threadId == joinedThread.threadId && this.guildId == joinedThread.guildId && this.flags == joinedThread.flags && this.muted == joinedThread.muted && m.areEqual(this.muteConfig, joinedThread.muteConfig) && m.areEqual(this.joinTimestamp, joinedThread.joinTimestamp);
        }

        public final int getFlags() {
            return this.flags;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final UtcDateTime getJoinTimestamp() {
            return this.joinTimestamp;
        }

        public final ModelMuteConfig getMuteConfig() {
            return this.muteConfig;
        }

        public final boolean getMuted() {
            return this.muted;
        }

        public final long getThreadId() {
            return this.threadId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = (((b.a(this.guildId) + (b.a(this.threadId) * 31)) * 31) + this.flags) * 31;
            boolean z2 = this.muted;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iA + i) * 31;
            ModelMuteConfig modelMuteConfig = this.muteConfig;
            int iHashCode = (i2 + (modelMuteConfig != null ? modelMuteConfig.hashCode() : 0)) * 31;
            UtcDateTime utcDateTime = this.joinTimestamp;
            return iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("JoinedThread(threadId=");
            sbU.append(this.threadId);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", flags=");
            sbU.append(this.flags);
            sbU.append(", muted=");
            sbU.append(this.muted);
            sbU.append(", muteConfig=");
            sbU.append(this.muteConfig);
            sbU.append(", joinTimestamp=");
            sbU.append(this.joinTimestamp);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreThreadsJoined.kt */
    /* renamed from: com.discord.stores.StoreThreadsJoined$observeJoinedThread$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<JoinedThread> {
        public final /* synthetic */ long $threadId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$threadId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ JoinedThread invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final JoinedThread invoke() {
            return StoreThreadsJoined.this.getJoinedThread(this.$threadId);
        }
    }

    /* compiled from: StoreThreadsJoined.kt */
    /* renamed from: com.discord.stores.StoreThreadsJoined$observeJoinedThreads$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends JoinedThread>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends JoinedThread> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends JoinedThread> invoke2() {
            return StoreThreadsJoined.access$getAllJoinedThreads(StoreThreadsJoined.this);
        }
    }

    public /* synthetic */ StoreThreadsJoined(StoreUser storeUser, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeUser, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Map access$getAllJoinedThreads(StoreThreadsJoined storeThreadsJoined) {
        return storeThreadsJoined.getAllJoinedThreads();
    }

    private final void deleteThreads(long guildId) {
        if (r.removeAll(this.joinedThreads.values(), new StoreThreadsJoined$deleteThreads$removed$1(guildId))) {
            markChanged();
        }
    }

    private final Map<Long, JoinedThread> getAllJoinedThreads() {
        return this.joinedThreadsSnapshot;
    }

    private final void saveThreads(Guild guild) {
        ThreadMember member;
        List<Channel> listN = guild.N();
        if (listN != null) {
            for (Channel channel : listN) {
                if (ChannelUtils.H(channel) && (member = channel.getMember()) != null) {
                    this.joinedThreads.put(Long.valueOf(channel.getId()), new JoinedThread(channel.getId(), guild.getId(), member.getFlags(), member.getMuted(), new ModelMuteConfig(member.getMuteConfig()), member.getJoinTimestamp()));
                    markChanged();
                }
            }
        }
    }

    @StoreThread
    public final Map<Long, JoinedThread> getAllJoinedThreadsInternal$app_productionGoogleRelease() {
        return this.joinedThreads;
    }

    public final JoinedThread getJoinedThread(long threadId) {
        return this.joinedThreadsSnapshot.get(Long.valueOf(threadId));
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.joinedThreads.clear();
        List<Guild> guilds = payload.getGuilds();
        m.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            m.checkNotNullExpressionValue(guild, "guild");
            saveThreads(guild);
        }
        markChanged();
    }

    @StoreThread
    public final void handleGuildCreate(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        deleteThreads(guild.getId());
        saveThreads(guild);
    }

    @StoreThread
    public final void handleGuildDelete(long guildId) {
        deleteThreads(guildId);
    }

    @StoreThread
    public final void handleSearchFinish(SearchState searchState) {
        Channel channel;
        m.checkNotNullParameter(searchState, "searchState");
        List<Channel> threads = searchState.getThreads();
        if (threads == null || (channel = threads.get(0)) == null) {
            return;
        }
        long guildId = channel.getGuildId();
        List<ThreadMember> threadMembers = searchState.getThreadMembers();
        if (threadMembers != null) {
            for (ThreadMember threadMember : threadMembers) {
                if (threadMember.getUserId() == this.storeUser.getMeSnapshot().getId()) {
                    this.joinedThreads.put(Long.valueOf(threadMember.getId()), new JoinedThread(threadMember.getId(), guildId, threadMember.getFlags(), threadMember.getMuted(), new ModelMuteConfig(threadMember.getMuteConfig()), threadMember.getJoinTimestamp()));
                }
            }
        }
    }

    @StoreThread
    public final void handleThreadCreateOrUpdate(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        ThreadMember member = channel.getMember();
        if (member == null || member.getUserId() != this.storeUser.getMeSnapshot().getId()) {
            return;
        }
        this.joinedThreads.put(Long.valueOf(channel.getId()), new JoinedThread(channel.getId(), channel.getGuildId(), member.getFlags(), member.getMuted(), new ModelMuteConfig(member.getMuteConfig()), member.getJoinTimestamp()));
        markChanged();
    }

    @StoreThread
    public final void handleThreadDelete(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        if (this.joinedThreads.containsKey(Long.valueOf(channel.getId()))) {
            this.joinedThreads.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
    }

    @StoreThread
    public final void handleThreadListSync(ModelThreadListSync payload) {
        m.checkNotNullParameter(payload, "payload");
        List<ThreadMember> members = payload.getMembers();
        if (members != null) {
            for (ThreadMember threadMember : members) {
                this.joinedThreads.put(Long.valueOf(threadMember.getId()), new JoinedThread(threadMember.getId(), payload.getGuildId(), threadMember.getFlags(), threadMember.getMuted(), new ModelMuteConfig(threadMember.getMuteConfig()), threadMember.getJoinTimestamp()));
                markChanged();
            }
        }
    }

    @StoreThread
    public final void handleThreadMemberUpdate(ThreadMemberUpdate payload) {
        m.checkNotNullParameter(payload, "payload");
        if (payload.getUserId() == this.storeUser.getMeSnapshot().getId()) {
            this.joinedThreads.put(Long.valueOf(payload.getId()), new JoinedThread(payload.getId(), payload.getGuildId(), payload.getFlags(), payload.getMuted(), new ModelMuteConfig(payload.getMuteConfig()), payload.getJoinTimestamp()));
            markChanged();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @StoreThread
    public final void handleThreadMembersUpdate(ThreadMembersUpdate payload) {
        List<Long> listD;
        m.checkNotNullParameter(payload, "payload");
        long id2 = this.storeUser.getMeSnapshot().getId();
        if (this.joinedThreads.containsKey(Long.valueOf(payload.getId())) && (listD = payload.d()) != null && listD.contains(Long.valueOf(id2))) {
            this.joinedThreads.remove(Long.valueOf(payload.getId()));
            markChanged();
        }
        List<AugmentedThreadMember> listA = payload.a();
        AugmentedThreadMember augmentedThreadMember = null;
        if (listA != null) {
            Iterator<T> it = listA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((AugmentedThreadMember) next).getUserId() == id2) {
                    augmentedThreadMember = next;
                    break;
                }
            }
            augmentedThreadMember = augmentedThreadMember;
        }
        if (augmentedThreadMember != null) {
            this.joinedThreads.put(Long.valueOf(payload.getId()), new JoinedThread(payload.getId(), payload.getGuildId(), augmentedThreadMember.getFlags(), augmentedThreadMember.getMuted(), new ModelMuteConfig(augmentedThreadMember.getMuteConfig()), augmentedThreadMember.getJoinTimestamp()));
            markChanged();
        }
    }

    public final boolean hasJoined(long threadId) {
        return this.joinedThreadsSnapshot.containsKey(Long.valueOf(threadId));
    }

    @StoreThread
    public final boolean hasJoinedInternal(long threadId) {
        return this.joinedThreads.containsKey(Long.valueOf(threadId));
    }

    public final Observable<JoinedThread> observeJoinedThread(long threadId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(threadId), 14, null);
    }

    public final Observable<Map<Long, JoinedThread>> observeJoinedThreads() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.joinedThreadsSnapshot = new HashMap(this.joinedThreads);
    }

    public StoreThreadsJoined(StoreUser storeUser, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeUser = storeUser;
        this.observationDeck = observationDeck;
        this.joinedThreads = new HashMap();
        this.joinedThreadsSnapshot = h0.emptyMap();
    }
}
