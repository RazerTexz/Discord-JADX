package com.discord.stores;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.forum.ForumPostFirstMessages;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.domain.ModelPayload;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import p507d0.p578f0._Sequences2;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t._Collections;
import p507d0.p580t._Sets;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: StoreForumPostMessages.kt */
/* loaded from: classes2.dex */
public final class StoreForumPostMessages extends StoreV2 {
    public static final int MAX_REQUEST_BODY_POST_IDS = 10;
    private final Dispatcher dispatcher;
    private Map<Long, Set<Long>> forumPostFetchQueue;
    private final Map<Long, Message> forumPostFirstMessage;
    private Set<Long> forumPostFirstMessageFetchSent;
    private Map<Long, Message> forumPostFirstMessageSnapshot;
    private boolean forumPostRequestQueueProcessing;
    private final ObservationDeck observationDeck;
    private Set<Long> shouldGetForumPostFirstMessageFromGateway;
    private final StoreUser storeUser;

    /* compiled from: StoreForumPostMessages.kt */
    /* renamed from: com.discord.stores.StoreForumPostMessages$enqueueForumPostFirstMessageFetch$1 */
    public static final class C59311 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $parentChannelId;
        public final /* synthetic */ long $postId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59311(long j, long j2) {
            super(0);
            this.$postId = j;
            this.$parentChannelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreForumPostMessages.access$hasForumPostFirstMessage(StoreForumPostMessages.this, this.$postId) || StoreForumPostMessages.access$isFetchingForumPostFirstMessage(StoreForumPostMessages.this, this.$postId) || StoreForumPostMessages.access$expectForumPostFirstMessageFromGateway(StoreForumPostMessages.this, this.$postId)) {
                return;
            }
            Set linkedHashSet = (Set) StoreForumPostMessages.access$getForumPostFetchQueue$p(StoreForumPostMessages.this).get(Long.valueOf(this.$parentChannelId));
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
            }
            linkedHashSet.add(Long.valueOf(this.$postId));
            StoreForumPostMessages.access$getForumPostFetchQueue$p(StoreForumPostMessages.this).put(Long.valueOf(this.$parentChannelId), linkedHashSet);
        }
    }

    /* compiled from: StoreForumPostMessages.kt */
    /* renamed from: com.discord.stores.StoreForumPostMessages$fetchForumPosts$1 */
    public static final class C59321 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 $onTerminated;

        /* compiled from: StoreForumPostMessages.kt */
        /* renamed from: com.discord.stores.StoreForumPostMessages$fetchForumPosts$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C59321.this.$onTerminated.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59321(Function0 function0) {
            super(0);
            this.$onTerminated = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreForumPostMessages.access$getDispatcher$p(StoreForumPostMessages.this).schedule(new AnonymousClass1());
        }
    }

    /* compiled from: StoreForumPostMessages.kt */
    /* renamed from: com.discord.stores.StoreForumPostMessages$fetchForumPosts$2 */
    public static final class C59332 extends Lambda implements Function1<ForumPostFirstMessages, Unit> {

        /* compiled from: StoreForumPostMessages.kt */
        /* renamed from: com.discord.stores.StoreForumPostMessages$fetchForumPosts$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ForumPostFirstMessages $response;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ForumPostFirstMessages forumPostFirstMessages) {
                super(0);
                this.$response = forumPostFirstMessages;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreForumPostMessages.this.bulkCreateFirstMessage(_Sequences2.toList(_Sequences2.filterNotNull(_Sequences2.map(_Collections.asSequence(this.$response.m7821a().values()), StoreForumPostMessages2.INSTANCE))));
            }
        }

        public C59332() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ForumPostFirstMessages forumPostFirstMessages) {
            invoke2(forumPostFirstMessages);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ForumPostFirstMessages forumPostFirstMessages) {
            Intrinsics3.checkNotNullParameter(forumPostFirstMessages, "response");
            StoreForumPostMessages.access$getDispatcher$p(StoreForumPostMessages.this).schedule(new AnonymousClass1(forumPostFirstMessages));
        }
    }

    /* compiled from: StoreForumPostMessages.kt */
    /* renamed from: com.discord.stores.StoreForumPostMessages$flushForumPostFirstMessageQueue$1 */
    public static final class C59341 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $parentChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59341(long j) {
            super(0);
            this.$parentChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreForumPostMessages.access$getForumPostRequestQueueProcessing$p(StoreForumPostMessages.this)) {
                return;
            }
            StoreForumPostMessages.access$setForumPostRequestQueueProcessing$p(StoreForumPostMessages.this, true);
            StoreForumPostMessages.access$flushForumPostFirstMessageQueueHelper(StoreForumPostMessages.this, this.$parentChannelId);
        }
    }

    /* compiled from: StoreForumPostMessages.kt */
    /* renamed from: com.discord.stores.StoreForumPostMessages$flushForumPostFirstMessageQueueHelper$1 */
    public static final class C59351 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $parentChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59351(long j) {
            super(0);
            this.$parentChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Collection collection = (Collection) StoreForumPostMessages.access$getForumPostFetchQueue$p(StoreForumPostMessages.this).get(Long.valueOf(this.$parentChannelId));
            if (collection == null || collection.isEmpty()) {
                StoreForumPostMessages.access$setForumPostRequestQueueProcessing$p(StoreForumPostMessages.this, false);
            } else {
                StoreForumPostMessages.access$flushForumPostFirstMessageQueueHelper(StoreForumPostMessages.this, this.$parentChannelId);
            }
        }
    }

    /* compiled from: StoreForumPostMessages.kt */
    /* renamed from: com.discord.stores.StoreForumPostMessages$observeForumPostFirstMessage$1 */
    public static final class C59361 extends Lambda implements Function0<Message> {
        public final /* synthetic */ long $postId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59361(long j) {
            super(0);
            this.$postId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Message invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Message invoke() {
            return (Message) StoreForumPostMessages.access$getForumPostFirstMessageSnapshot$p(StoreForumPostMessages.this).get(Long.valueOf(this.$postId));
        }
    }

    /* compiled from: StoreForumPostMessages.kt */
    /* renamed from: com.discord.stores.StoreForumPostMessages$observeForumPostFirstMessages$1 */
    public static final class C59371 extends Lambda implements Function0<Map<Long, ? extends Message>> {
        public C59371() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Message> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Message> invoke2() {
            return StoreForumPostMessages.access$getForumPostFirstMessageSnapshot$p(StoreForumPostMessages.this);
        }
    }

    public /* synthetic */ StoreForumPostMessages(Dispatcher dispatcher, StoreUser storeUser, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeUser, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ boolean access$expectForumPostFirstMessageFromGateway(StoreForumPostMessages storeForumPostMessages, long j) {
        return storeForumPostMessages.expectForumPostFirstMessageFromGateway(j);
    }

    public static final /* synthetic */ void access$flushForumPostFirstMessageQueueHelper(StoreForumPostMessages storeForumPostMessages, long j) {
        storeForumPostMessages.flushForumPostFirstMessageQueueHelper(j);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreForumPostMessages storeForumPostMessages) {
        return storeForumPostMessages.dispatcher;
    }

    public static final /* synthetic */ Map access$getForumPostFetchQueue$p(StoreForumPostMessages storeForumPostMessages) {
        return storeForumPostMessages.forumPostFetchQueue;
    }

    public static final /* synthetic */ Map access$getForumPostFirstMessageSnapshot$p(StoreForumPostMessages storeForumPostMessages) {
        return storeForumPostMessages.forumPostFirstMessageSnapshot;
    }

    public static final /* synthetic */ boolean access$getForumPostRequestQueueProcessing$p(StoreForumPostMessages storeForumPostMessages) {
        return storeForumPostMessages.forumPostRequestQueueProcessing;
    }

    public static final /* synthetic */ boolean access$hasForumPostFirstMessage(StoreForumPostMessages storeForumPostMessages, long j) {
        return storeForumPostMessages.hasForumPostFirstMessage(j);
    }

    public static final /* synthetic */ boolean access$isFetchingForumPostFirstMessage(StoreForumPostMessages storeForumPostMessages, long j) {
        return storeForumPostMessages.isFetchingForumPostFirstMessage(j);
    }

    public static final /* synthetic */ void access$setForumPostFetchQueue$p(StoreForumPostMessages storeForumPostMessages, Map map) {
        storeForumPostMessages.forumPostFetchQueue = map;
    }

    public static final /* synthetic */ void access$setForumPostFirstMessageSnapshot$p(StoreForumPostMessages storeForumPostMessages, Map map) {
        storeForumPostMessages.forumPostFirstMessageSnapshot = map;
    }

    public static final /* synthetic */ void access$setForumPostRequestQueueProcessing$p(StoreForumPostMessages storeForumPostMessages, boolean z2) {
        storeForumPostMessages.forumPostRequestQueueProcessing = z2;
    }

    @Store3
    private final boolean expectForumPostFirstMessageFromGateway(long postId) {
        return this.shouldGetForumPostFirstMessageFromGateway.contains(Long.valueOf(postId));
    }

    @Store3
    private final void fetchForumPosts(long parentChannelId, List<Long> postIds, Function0<Unit> onTerminated) {
        this.forumPostFirstMessageFetchSent.addAll(postIds);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RetryWithDelay.restRetry$default(RetryWithDelay.INSTANCE, RestAPI.INSTANCE.getApi().getForumPostData(parentChannelId, new RestAPIParams.GetForumPostData(postIds)), 0L, null, null, 7, null), false, 1, null), StoreForumPostMessages.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, new C59321(onTerminated), new C59332(), 30, (Object) null);
    }

    @Store3
    private final void flushForumPostFirstMessageQueueHelper(long parentChannelId) {
        Set<Long> set = this.forumPostFetchQueue.get(Long.valueOf(parentChannelId));
        if (set == null || set.isEmpty()) {
            this.forumPostRequestQueueProcessing = false;
            return;
        }
        List<Long> listTake = _Collections.take(set, 10);
        this.forumPostFetchQueue.put(Long.valueOf(parentChannelId), _Collections.toMutableSet(_Sets.minus((Set) set, (Iterable) listTake)));
        fetchForumPosts(parentChannelId, listTake, new C59351(parentChannelId));
    }

    @Store3
    private final Message getFirstMessageForReactionUpdate(MessageReactionUpdate update) {
        Message message = this.forumPostFirstMessage.get(Long.valueOf(update.getChannelId()));
        if (message == null || message.getId() != update.getMessageId()) {
            return null;
        }
        return message;
    }

    @Store3
    private final boolean hasForumPostFirstMessage(long postId) {
        return this.forumPostFirstMessage.containsKey(Long.valueOf(postId));
    }

    @Store3
    private final boolean isFetchingForumPostFirstMessage(long postId) {
        return this.forumPostFirstMessageFetchSent.contains(Long.valueOf(postId));
    }

    private final boolean isFirstMessage(com.discord.api.message.Message message) {
        return message.getId() == message.getChannelId();
    }

    public static /* synthetic */ Observable observeForumPostFirstMessage$default(StoreForumPostMessages storeForumPostMessages, long j, long j2, boolean z2, int i, Object obj) {
        return storeForumPostMessages.observeForumPostFirstMessage(j, j2, (i & 4) != 0 ? false : z2);
    }

    @Store3
    public final void bulkCreateFirstMessage(List<com.discord.api.message.Message> messages) {
        Intrinsics3.checkNotNullParameter(messages, "messages");
        ArrayList<com.discord.api.message.Message> arrayList = new ArrayList();
        for (Object obj : messages) {
            if (isFirstMessage((com.discord.api.message.Message) obj)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            for (com.discord.api.message.Message message : arrayList) {
                this.forumPostFirstMessage.put(Long.valueOf(message.getChannelId()), new Message(message));
                this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(message.getChannelId()));
            }
            markChanged();
        }
    }

    @Store3
    public final void createFirstMessage(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        if (isFirstMessage(message)) {
            this.forumPostFirstMessage.put(Long.valueOf(message.getChannelId()), new Message(message));
            this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(message.getChannelId()));
            markChanged();
        }
    }

    @Store3
    public final void deleteFirstMessage(long channelId) {
        Message messageRemove = this.forumPostFirstMessage.remove(Long.valueOf(channelId));
        this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(channelId));
        if (messageRemove != null) {
            markChanged();
        }
    }

    public final void enqueueForumPostFirstMessageFetch(long parentChannelId, long postId) {
        this.dispatcher.schedule(new C59311(postId, parentChannelId));
    }

    public final void flushForumPostFirstMessageQueue(long parentChannelId) {
        this.dispatcher.schedule(new C59341(parentChannelId));
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.forumPostFirstMessage.clear();
        this.forumPostFetchQueue.clear();
        this.shouldGetForumPostFirstMessageFromGateway.clear();
        this.forumPostFirstMessageFetchSent.clear();
        this.forumPostRequestQueueProcessing = false;
    }

    @Store3
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        createFirstMessage(message);
    }

    @Store3
    public final void handleMessageDelete(ModelMessageDelete messageDelete) {
        Intrinsics3.checkNotNullParameter(messageDelete, "messageDelete");
        Message message = this.forumPostFirstMessage.get(Long.valueOf(messageDelete.getChannelId()));
        if (message == null || !messageDelete.getMessageIds().contains(Long.valueOf(message.getId()))) {
            return;
        }
        deleteFirstMessage(message.getChannelId());
    }

    @Store3
    public final void handleMessageUpdate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        updateFirstMessage(message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object] */
    @Store3
    public final void handleReactionAdd(MessageReactionUpdate update) {
        ArrayList list;
        List arrayList;
        Intrinsics3.checkNotNullParameter(update, "update");
        Message firstMessageForReactionUpdate = getFirstMessageForReactionUpdate(update);
        if (firstMessageForReactionUpdate != null) {
            List<MessageReaction> reactions = firstMessageForReactionUpdate.getReactions();
            MessageReaction messageReaction = null;
            if (reactions != null) {
                Iterator it = reactions.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ?? next = it.next();
                    if (Intrinsics3.areEqual(((MessageReaction) next).getEmoji().m8116c(), update.getEmoji().m8116c())) {
                        messageReaction = next;
                        break;
                    }
                }
                messageReaction = messageReaction;
            }
            if (messageReaction == null) {
                boolean z2 = update.getUserId() == this.storeUser.getMeSnapshot().getId();
                List<MessageReaction> reactions2 = firstMessageForReactionUpdate.getReactions();
                if (reactions2 == null || (arrayList = _Collections.toMutableList((Collection) reactions2)) == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(new MessageReaction(1, update.getEmoji(), z2));
                list = _Collections.toList(arrayList);
            } else {
                List<MessageReaction> reactions3 = firstMessageForReactionUpdate.getReactions();
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(reactions3, 10));
                for (MessageReaction messageReaction2 : reactions3) {
                    if (Intrinsics3.areEqual(messageReaction2.getEmoji().m8116c(), update.getEmoji().m8116c())) {
                        messageReaction2 = new MessageReaction(messageReaction2.getCount() + 1, messageReaction2.getEmoji(), update.getUserId() == this.storeUser.getMeSnapshot().getId() ? true : messageReaction2.getMe());
                    }
                    arrayList2.add(messageReaction2);
                }
                list = arrayList2;
            }
            this.forumPostFirstMessage.put(Long.valueOf(firstMessageForReactionUpdate.getChannelId()), Message.copy$default(firstMessageForReactionUpdate, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, list, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -8193, Opcodes.LAND, null));
            markChanged();
        }
    }

    @Store3
    public final void handleReactionRemove(MessageReactionUpdate update) {
        ArrayList arrayList;
        Intrinsics3.checkNotNullParameter(update, "update");
        Message firstMessageForReactionUpdate = getFirstMessageForReactionUpdate(update);
        if (firstMessageForReactionUpdate != null) {
            List<MessageReaction> reactions = firstMessageForReactionUpdate.getReactions();
            if (reactions != null) {
                ArrayList arrayList2 = new ArrayList();
                for (MessageReaction messageReaction : reactions) {
                    if (Intrinsics3.areEqual(messageReaction.getEmoji().m8116c(), update.getEmoji().m8116c())) {
                        boolean me2 = update.getUserId() == this.storeUser.getMeSnapshot().getId() ? false : messageReaction.getMe();
                        int count = messageReaction.getCount() - 1;
                        messageReaction = count > 0 ? new MessageReaction(count, messageReaction.getEmoji(), me2) : null;
                    }
                    if (messageReaction != null) {
                        arrayList2.add(messageReaction);
                    }
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            this.forumPostFirstMessage.put(Long.valueOf(firstMessageForReactionUpdate.getChannelId()), Message.copy$default(firstMessageForReactionUpdate, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, arrayList, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -8193, Opcodes.LAND, null));
            markChanged();
        }
    }

    @Store3
    public final void handleReactionRemoveAll(MessageReactionUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        Message firstMessageForReactionUpdate = getFirstMessageForReactionUpdate(update);
        if (firstMessageForReactionUpdate != null) {
            this.forumPostFirstMessage.put(Long.valueOf(firstMessageForReactionUpdate.getChannelId()), Message.copy$default(firstMessageForReactionUpdate, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -8193, Opcodes.LAND, null));
            markChanged();
        }
    }

    @Store3
    public final void handleReactionRemoveEmoji(MessageReactionUpdate update) {
        ArrayList arrayList;
        StoreForumPostMessages storeForumPostMessages;
        Intrinsics3.checkNotNullParameter(update, "update");
        Message firstMessageForReactionUpdate = getFirstMessageForReactionUpdate(update);
        if (firstMessageForReactionUpdate != null) {
            List<MessageReaction> reactions = firstMessageForReactionUpdate.getReactions();
            if (reactions != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : reactions) {
                    if (!Intrinsics3.areEqual(((MessageReaction) obj).getEmoji().m8116c(), update.getEmoji().m8116c())) {
                        arrayList2.add(obj);
                    }
                }
                storeForumPostMessages = this;
                arrayList = arrayList2;
            } else {
                arrayList = null;
                storeForumPostMessages = this;
            }
            storeForumPostMessages.forumPostFirstMessage.put(Long.valueOf(firstMessageForReactionUpdate.getChannelId()), Message.copy$default(firstMessageForReactionUpdate, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, arrayList, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -8193, Opcodes.LAND, null));
            markChanged();
        }
    }

    @Store3
    public final void handleThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (hasForumPostFirstMessage(channel.getId()) || isFetchingForumPostFirstMessage(channel.getId())) {
            return;
        }
        this.shouldGetForumPostFirstMessageFromGateway.add(Long.valueOf(channel.getId()));
    }

    @Store3
    public final void handleThreadDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(channel.getId()));
    }

    public final Observable<Message> observeForumPostFirstMessage(long parentChannelId, long postId, boolean fetchIfMissing) {
        if (fetchIfMissing && this.forumPostFirstMessageSnapshot.get(Long.valueOf(postId)) == null) {
            enqueueForumPostFirstMessageFetch(parentChannelId, postId);
            flushForumPostFirstMessageQueue(parentChannelId);
        }
        Observable<Message> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C59361(postId), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, Message>> observeForumPostFirstMessages() {
        Observable<Map<Long, Message>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C59371(), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.forumPostFirstMessageSnapshot = new HashMap(this.forumPostFirstMessage);
    }

    @Store3
    public final void updateFirstMessage(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Message message2 = this.forumPostFirstMessage.get(Long.valueOf(message.getChannelId()));
        if (message2 == null || !isFirstMessage(message)) {
            return;
        }
        this.forumPostFirstMessage.put(Long.valueOf(message.getChannelId()), message2.merge(message));
        this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(message.getChannelId()));
        markChanged();
    }

    public StoreForumPostMessages(Dispatcher dispatcher, StoreUser storeUser, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeUser = storeUser;
        this.observationDeck = observationDeck;
        this.forumPostFirstMessage = new HashMap();
        this.forumPostFirstMessageSnapshot = Maps6.emptyMap();
        this.shouldGetForumPostFirstMessageFromGateway = new LinkedHashSet();
        this.forumPostFirstMessageFetchSent = new HashSet();
        this.forumPostFetchQueue = new HashMap();
    }
}
