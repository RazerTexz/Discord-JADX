package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.MessageReference;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.message.Message;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.collections.SnowflakePartitionMap;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StorePendingReplies.kt */
/* loaded from: classes2.dex */
public final class StorePendingReplies extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final SnowflakePartitionMap.CopiablePartitionMap<PendingReply> pendingReplies;
    private Map<Long, PendingReply> pendingRepliesSnapshot;

    /* compiled from: StorePendingReplies.kt */
    public static final /* data */ class PendingReply {
        private final MessageReference messageReference;
        private final Message originalMessage;
        private boolean shouldMention;
        private final boolean showMentionToggle;

        public PendingReply(MessageReference messageReference, Message message, boolean z2, boolean z3) {
            m.checkNotNullParameter(messageReference, "messageReference");
            m.checkNotNullParameter(message, "originalMessage");
            this.messageReference = messageReference;
            this.originalMessage = message;
            this.shouldMention = z2;
            this.showMentionToggle = z3;
        }

        public static /* synthetic */ PendingReply copy$default(PendingReply pendingReply, MessageReference messageReference, Message message, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                messageReference = pendingReply.messageReference;
            }
            if ((i & 2) != 0) {
                message = pendingReply.originalMessage;
            }
            if ((i & 4) != 0) {
                z2 = pendingReply.shouldMention;
            }
            if ((i & 8) != 0) {
                z3 = pendingReply.showMentionToggle;
            }
            return pendingReply.copy(messageReference, message, z2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final MessageReference getMessageReference() {
            return this.messageReference;
        }

        /* renamed from: component2, reason: from getter */
        public final Message getOriginalMessage() {
            return this.originalMessage;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getShouldMention() {
            return this.shouldMention;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getShowMentionToggle() {
            return this.showMentionToggle;
        }

        public final PendingReply copy(MessageReference messageReference, Message originalMessage, boolean shouldMention, boolean showMentionToggle) {
            m.checkNotNullParameter(messageReference, "messageReference");
            m.checkNotNullParameter(originalMessage, "originalMessage");
            return new PendingReply(messageReference, originalMessage, shouldMention, showMentionToggle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingReply)) {
                return false;
            }
            PendingReply pendingReply = (PendingReply) other;
            return m.areEqual(this.messageReference, pendingReply.messageReference) && m.areEqual(this.originalMessage, pendingReply.originalMessage) && this.shouldMention == pendingReply.shouldMention && this.showMentionToggle == pendingReply.showMentionToggle;
        }

        public final MessageReference getMessageReference() {
            return this.messageReference;
        }

        public final Message getOriginalMessage() {
            return this.originalMessage;
        }

        public final boolean getShouldMention() {
            return this.shouldMention;
        }

        public final boolean getShowMentionToggle() {
            return this.showMentionToggle;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            MessageReference messageReference = this.messageReference;
            int iHashCode = (messageReference != null ? messageReference.hashCode() : 0) * 31;
            Message message = this.originalMessage;
            int iHashCode2 = (iHashCode + (message != null ? message.hashCode() : 0)) * 31;
            boolean z2 = this.shouldMention;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            boolean z3 = this.showMentionToggle;
            return i2 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final void setShouldMention(boolean z2) {
            this.shouldMention = z2;
        }

        public String toString() {
            StringBuilder sbU = a.U("PendingReply(messageReference=");
            sbU.append(this.messageReference);
            sbU.append(", originalMessage=");
            sbU.append(this.originalMessage);
            sbU.append(", shouldMention=");
            sbU.append(this.shouldMention);
            sbU.append(", showMentionToggle=");
            return a.O(sbU, this.showMentionToggle, ")");
        }
    }

    /* compiled from: StorePendingReplies.kt */
    /* renamed from: com.discord.stores.StorePendingReplies$observePendingReply$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<PendingReply> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ PendingReply invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PendingReply invoke() {
            return StorePendingReplies.this.getPendingReply(this.$channelId);
        }
    }

    /* compiled from: StorePendingReplies.kt */
    /* renamed from: com.discord.stores.StorePendingReplies$onCreatePendingReply$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Message $message;
        public final /* synthetic */ boolean $shouldMention;
        public final /* synthetic */ boolean $showMentionToggle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Channel channel, Message message, boolean z2, boolean z3) {
            super(0);
            this.$channel = channel;
            this.$message = message;
            this.$shouldMention = z2;
            this.$showMentionToggle = z3;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StorePendingReplies.access$getPendingReplies$p(StorePendingReplies.this).put(Long.valueOf(this.$channel.getId()), new PendingReply(new MessageReference(ChannelUtils.B(this.$channel) ? null : Long.valueOf(this.$channel.getGuildId()), Long.valueOf(this.$channel.getId()), Long.valueOf(this.$message.getId())), this.$message, this.$shouldMention, this.$showMentionToggle));
            StorePendingReplies.this.markChanged();
        }
    }

    /* compiled from: StorePendingReplies.kt */
    /* renamed from: com.discord.stores.StorePendingReplies$onDeletePendingReply$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StorePendingReplies.access$getPendingReplies$p(StorePendingReplies.this).remove(Long.valueOf(this.$channelId));
            StorePendingReplies.this.markChanged();
        }
    }

    /* compiled from: StorePendingReplies.kt */
    /* renamed from: com.discord.stores.StorePendingReplies$onSetPendingReplyShouldMention$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ boolean $shouldMention;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, boolean z2) {
            super(0);
            this.$channelId = j;
            this.$shouldMention = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PendingReply pendingReply = (PendingReply) StorePendingReplies.access$getPendingReplies$p(StorePendingReplies.this).get(Long.valueOf(this.$channelId));
            if (pendingReply != null) {
                StorePendingReplies.access$getPendingReplies$p(StorePendingReplies.this).put(Long.valueOf(this.$channelId), PendingReply.copy$default(pendingReply, null, null, this.$shouldMention, false, 11, null));
                StorePendingReplies.this.markChanged();
            }
        }
    }

    public /* synthetic */ StorePendingReplies(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ SnowflakePartitionMap.CopiablePartitionMap access$getPendingReplies$p(StorePendingReplies storePendingReplies) {
        return storePendingReplies.pendingReplies;
    }

    public static /* synthetic */ void onCreatePendingReply$default(StorePendingReplies storePendingReplies, Channel channel, Message message, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        if ((i & 8) != 0) {
            z3 = true;
        }
        storePendingReplies.onCreatePendingReply(channel, message, z2, z3);
    }

    public final PendingReply getPendingReply(long channelId) {
        return this.pendingRepliesSnapshot.get(Long.valueOf(channelId));
    }

    @StoreThread
    public final void handleMessageDelete(ModelMessageDelete messageDeleteBulk) {
        m.checkNotNullParameter(messageDeleteBulk, "messageDeleteBulk");
        PendingReply pendingReply = this.pendingReplies.get(Long.valueOf(messageDeleteBulk.getChannelId()));
        if (pendingReply == null || !messageDeleteBulk.getMessageIds().contains(pendingReply.getMessageReference().getMessageId())) {
            return;
        }
        this.pendingReplies.remove(Long.valueOf(messageDeleteBulk.getChannelId()));
        markChanged();
    }

    @StoreThread
    public final void handlePreLogout() {
        this.pendingReplies.clear();
        markChanged();
    }

    public final Observable<PendingReply> observePendingReply(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null);
    }

    public final void onCreatePendingReply(Channel channel, Message message, boolean shouldMention, boolean showMentionToggle) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(message, "message");
        this.dispatcher.schedule(new AnonymousClass1(channel, message, shouldMention, showMentionToggle));
    }

    public final void onDeletePendingReply(long channelId) {
        this.dispatcher.schedule(new AnonymousClass1(channelId));
    }

    public final void onSetPendingReplyShouldMention(long channelId, boolean shouldMention) {
        this.dispatcher.schedule(new AnonymousClass1(channelId, shouldMention));
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.pendingRepliesSnapshot = this.pendingReplies.fastCopy();
    }

    public StorePendingReplies(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.pendingReplies = new SnowflakePartitionMap.CopiablePartitionMap<>(0, 1, null);
        this.pendingRepliesSnapshot = h0.emptyMap();
    }
}
