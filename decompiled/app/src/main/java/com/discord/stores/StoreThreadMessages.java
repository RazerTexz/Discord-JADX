package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.domain.ModelPayload;
import com.discord.models.message.Message;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.d0.f;
import d0.t.h0;
import d0.t.r;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreThreadMessages.kt */
/* loaded from: classes2.dex */
public final class StoreThreadMessages extends StoreV2 {
    public static final int MAX_THREAD_MESSAGE_COUNT = 50;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;
    private final StoreMessages storeMessages;
    private final Map<Long, ThreadState> threads;
    private Map<Long, ThreadState> threadsSnapshot;

    /* compiled from: StoreThreadMessages.kt */
    public static final /* data */ class ThreadState {
        private int count;
        private final long guildId;
        private Message mostRecentMessage;
        private final long parentId;
        private final long threadId;

        public ThreadState(long j, long j2, long j3, int i, Message message) {
            this.threadId = j;
            this.guildId = j2;
            this.parentId = j3;
            this.count = i;
            this.mostRecentMessage = message;
        }

        public static /* synthetic */ ThreadState copy$default(ThreadState threadState, long j, long j2, long j3, int i, Message message, int i2, Object obj) {
            return threadState.copy((i2 & 1) != 0 ? threadState.threadId : j, (i2 & 2) != 0 ? threadState.guildId : j2, (i2 & 4) != 0 ? threadState.parentId : j3, (i2 & 8) != 0 ? threadState.count : i, (i2 & 16) != 0 ? threadState.mostRecentMessage : message);
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
        public final long getParentId() {
            return this.parentId;
        }

        /* renamed from: component4, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        /* renamed from: component5, reason: from getter */
        public final Message getMostRecentMessage() {
            return this.mostRecentMessage;
        }

        public final ThreadState copy(long threadId, long guildId, long parentId, int count, Message mostRecentMessage) {
            return new ThreadState(threadId, guildId, parentId, count, mostRecentMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThreadState)) {
                return false;
            }
            ThreadState threadState = (ThreadState) other;
            return this.threadId == threadState.threadId && this.guildId == threadState.guildId && this.parentId == threadState.parentId && this.count == threadState.count && m.areEqual(this.mostRecentMessage, threadState.mostRecentMessage);
        }

        public final int getCount() {
            return this.count;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final Message getMostRecentMessage() {
            return this.mostRecentMessage;
        }

        public final long getParentId() {
            return this.parentId;
        }

        public final long getThreadId() {
            return this.threadId;
        }

        public int hashCode() {
            int iA = (((b.a(this.parentId) + ((b.a(this.guildId) + (b.a(this.threadId) * 31)) * 31)) * 31) + this.count) * 31;
            Message message = this.mostRecentMessage;
            return iA + (message != null ? message.hashCode() : 0);
        }

        public final void setCount(int i) {
            this.count = i;
        }

        public final void setMostRecentMessage(Message message) {
            this.mostRecentMessage = message;
        }

        public String toString() {
            StringBuilder sbU = a.U("ThreadState(threadId=");
            sbU.append(this.threadId);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", parentId=");
            sbU.append(this.parentId);
            sbU.append(", count=");
            sbU.append(this.count);
            sbU.append(", mostRecentMessage=");
            sbU.append(this.mostRecentMessage);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreThreadMessages.kt */
    /* renamed from: com.discord.stores.StoreThreadMessages$observeThreadCountAndLatestMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends ThreadState>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends ThreadState> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends ThreadState> invoke2() {
            return StoreThreadMessages.access$getThreadsSnapshot$p(StoreThreadMessages.this);
        }
    }

    /* compiled from: StoreThreadMessages.kt */
    /* renamed from: com.discord.stores.StoreThreadMessages$observeThreadCountAndLatestMessage$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<ThreadState> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ThreadState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ThreadState invoke() {
            return (ThreadState) StoreThreadMessages.access$getThreadsSnapshot$p(StoreThreadMessages.this).get(Long.valueOf(this.$channelId));
        }
    }

    public /* synthetic */ StoreThreadMessages(StoreMessages storeMessages, StoreChannels storeChannels, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeMessages, storeChannels, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Map access$getThreadsSnapshot$p(StoreThreadMessages storeThreadMessages) {
        return storeThreadMessages.threadsSnapshot;
    }

    public static final /* synthetic */ void access$setThreadsSnapshot$p(StoreThreadMessages storeThreadMessages, Map map) {
        storeThreadMessages.threadsSnapshot = map;
    }

    @StoreThread
    private final void deleteForGuild(long guildId) {
        if (r.removeAll(this.threads.values(), new StoreThreadMessages$deleteForGuild$removed$1(guildId))) {
            markChanged();
        }
    }

    @StoreThread
    private final void deleteForParentChannel(long parentChannelId) {
        if (r.removeAll(this.threads.values(), new StoreThreadMessages$deleteForParentChannel$removed$1(parentChannelId))) {
            markChanged();
        }
    }

    @StoreThread
    private final ThreadState getOrAddState(Channel thread) {
        ThreadState threadState = (ThreadState) a.d(thread, this.threads);
        if (threadState == null) {
            long id2 = thread.getId();
            long guildId = thread.getGuildId();
            long parentId = thread.getParentId();
            Integer messageCount = thread.getMessageCount();
            threadState = new ThreadState(id2, guildId, parentId, messageCount != null ? messageCount.intValue() : 0, null);
            this.threads.put(Long.valueOf(thread.getId()), threadState);
            markChanged();
        }
        return threadState;
    }

    @StoreThread
    private final void updateFromGuild(Guild guild) {
        List<Channel> listN = guild.N();
        if (listN != null) {
            Iterator<T> it = listN.iterator();
            while (it.hasNext()) {
                updateFromThread((Channel) it.next());
            }
        }
    }

    @StoreThread
    private final void updateFromThread(Channel thread) {
        ThreadState orAddState = getOrAddState(thread);
        Integer messageCount = thread.getMessageCount();
        if (messageCount != null) {
            this.threads.put(Long.valueOf(thread.getId()), ThreadState.copy$default(orAddState, 0L, 0L, 0L, messageCount.intValue(), null, 23, null));
            markChanged();
        }
        if (thread.getLastMessageId() != 0) {
            Message mostRecentMessage = orAddState.getMostRecentMessage();
            if (mostRecentMessage == null || mostRecentMessage.getId() != thread.getLastMessageId()) {
                this.threads.put(Long.valueOf(thread.getId()), ThreadState.copy$default(orAddState, 0L, 0L, 0L, 0, null, 15, null));
                markChanged();
            }
        }
    }

    public final Integer getThreadMessageCount(long channelId) {
        ThreadState threadState = this.threadsSnapshot.get(Long.valueOf(channelId));
        if (threadState != null) {
            return Integer.valueOf(threadState.getCount());
        }
        return null;
    }

    @StoreThread
    public final void handleChannelDelete(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        deleteForParentChannel(channel.getId());
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        List<Guild> guilds = payload.getGuilds();
        m.checkNotNullExpressionValue(guilds, "payload.guilds");
        Iterator<T> it = guilds.iterator();
        while (it.hasNext()) {
            updateFromGuild((Guild) it.next());
        }
    }

    @StoreThread
    public final void handleGuildCreate(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        updateFromGuild(guild);
    }

    @StoreThread
    public final void handleGuildDelete(long guildId) {
        deleteForGuild(guildId);
    }

    @StoreThread
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        m.checkNotNullParameter(message, "message");
        Channel channel = this.storeChannels.getChannel(message.getChannelId());
        if (channel == null || !ChannelUtils.H(channel)) {
            return;
        }
        ThreadState orAddState = getOrAddState(channel);
        this.threads.put(Long.valueOf(channel.getId()), ThreadState.copy$default(orAddState, 0L, 0L, 0L, f.coerceAtMost(orAddState.getCount() + 1, 50), new Message(message), 7, null));
        markChanged();
    }

    @StoreThread
    public final void handleMessageDelete(ModelMessageDelete messageDeleteBulk) {
        Message mostRecentMessage;
        m.checkNotNullParameter(messageDeleteBulk, "messageDeleteBulk");
        ThreadState threadState = this.threads.get(Long.valueOf(messageDeleteBulk.getChannelId()));
        Long lValueOf = (threadState == null || (mostRecentMessage = threadState.getMostRecentMessage()) == null) ? null : Long.valueOf(mostRecentMessage.getId());
        if (lValueOf != null) {
            lValueOf.longValue();
            Iterator<Long> it = messageDeleteBulk.getMessageIds().iterator();
            while (it.hasNext()) {
                if (!(!m.areEqual(lValueOf, it.next()))) {
                    this.threads.put(Long.valueOf(messageDeleteBulk.getChannelId()), ThreadState.copy$default(threadState, 0L, 0L, 0L, 0, null, 15, null));
                    markChanged();
                    return;
                }
            }
        }
    }

    @StoreThread
    public final void handleMessageUpdate(com.discord.api.message.Message message) {
        Message mostRecentMessage;
        m.checkNotNullParameter(message, "message");
        ThreadState threadState = this.threads.get(Long.valueOf(message.getChannelId()));
        if (threadState == null || (mostRecentMessage = threadState.getMostRecentMessage()) == null || mostRecentMessage.getId() != message.getId()) {
            return;
        }
        this.threads.put(Long.valueOf(message.getChannelId()), ThreadState.copy$default(threadState, 0L, 0L, 0L, 0, this.storeMessages.getMessage(message.getChannelId(), message.getId()), 15, null));
        markChanged();
    }

    @StoreThread
    public final void handleMessagesLoaded(StoreMessagesLoader.ChannelChunk chunk) {
        Channel channel;
        Channel channel2;
        m.checkNotNullParameter(chunk, "chunk");
        boolean z2 = false;
        boolean z3 = false;
        for (Message message : chunk.getMessages()) {
            if (message.hasThread() && !this.threads.containsKey(Long.valueOf(message.getId())) && (channel2 = this.storeChannels.getThreadsByIdInternal$app_productionGoogleRelease().get(Long.valueOf(message.getId()))) != null) {
                updateFromThread(channel2);
                z3 = true;
            }
        }
        if (z3) {
            markChanged();
        }
        if (chunk.isPresent() && (channel = this.storeChannels.getThreadsByIdInternal$app_productionGoogleRelease().get(Long.valueOf(chunk.getChannelId()))) != null && ChannelUtils.H(channel)) {
            ThreadState orAddState = getOrAddState(channel);
            if (chunk.getMessages().isEmpty()) {
                this.threads.put(Long.valueOf(channel.getId()), ThreadState.copy$default(orAddState, 0L, 0L, 0L, 0, null, 7, null));
            } else {
                Message message2 = this.storeMessages.getMessage(chunk.getChannelId(), chunk.getMessages().get(0).getId());
                int size = chunk.getMessages().size();
                List<Message> messages = chunk.getMessages();
                if (!(messages instanceof Collection) || !messages.isEmpty()) {
                    Iterator<T> it = messages.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Integer type = ((Message) it.next()).getType();
                        if (type != null && type.intValue() == 21) {
                            z2 = true;
                            break;
                        }
                    }
                }
                if (z2) {
                    size--;
                }
                Integer type2 = message2 != null ? message2.getType() : null;
                this.threads.put(Long.valueOf(channel.getId()), ThreadState.copy$default(orAddState, 0L, 0L, 0L, f.coerceAtMost(size, 50), (type2 != null && type2.intValue() == 21) ? null : message2, 7, null));
            }
            markChanged();
        }
    }

    @StoreThread
    public final void handleThreadCreateOrUpdate(Channel thread) {
        m.checkNotNullParameter(thread, "thread");
        updateFromThread(thread);
    }

    @StoreThread
    public final void handleThreadDelete(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        if (this.threads.containsKey(Long.valueOf(channel.getId()))) {
            this.threads.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
    }

    @StoreThread
    public final void handleThreadListSync(ModelThreadListSync threadListSync) {
        m.checkNotNullParameter(threadListSync, "threadListSync");
        Iterator<T> it = threadListSync.getThreads().iterator();
        while (it.hasNext()) {
            updateFromThread((Channel) it.next());
        }
        List<com.discord.api.message.Message> mostRecentMessages = threadListSync.getMostRecentMessages();
        if (mostRecentMessages != null) {
            for (com.discord.api.message.Message message : mostRecentMessages) {
                ThreadState threadState = this.threads.get(Long.valueOf(message.getChannelId()));
                if (threadState != null) {
                    this.threads.put(Long.valueOf(message.getChannelId()), ThreadState.copy$default(threadState, 0L, 0L, 0L, 0, new Message(message), 15, null));
                }
            }
        }
    }

    public final Observable<Map<Long, ThreadState>> observeThreadCountAndLatestMessage() {
        Observable<Map<Long, ThreadState>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.threadsSnapshot = new HashMap(this.threads);
    }

    public StoreThreadMessages(StoreMessages storeMessages, StoreChannels storeChannels, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeMessages, "storeMessages");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeMessages = storeMessages;
        this.storeChannels = storeChannels;
        this.observationDeck = observationDeck;
        this.threads = new HashMap();
        this.threadsSnapshot = h0.emptyMap();
    }

    public final Observable<ThreadState> observeThreadCountAndLatestMessage(long channelId) {
        Observable<ThreadState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass2(channelId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }
}
