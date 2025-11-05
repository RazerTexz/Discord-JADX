package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import b.d.b.a.a;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreMessageReactions.kt */
/* loaded from: classes2.dex */
public final class StoreMessageReactions extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Map<Long, Map<String, EmojiResults>> reactions;
    private Map<Long, ? extends Map<String, ? extends EmojiResults>> reactionsSnapshot;
    private final StoreUser userStore;

    /* compiled from: StoreMessageReactions.kt */
    public static abstract class EmojiResults {

        /* compiled from: StoreMessageReactions.kt */
        public static final /* data */ class Failure extends EmojiResults {
            private final long channelId;
            private final MessageReactionEmoji emoji;
            private final long messageId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failure(long j, long j2, MessageReactionEmoji messageReactionEmoji) {
                super(null);
                m.checkNotNullParameter(messageReactionEmoji, "emoji");
                this.channelId = j;
                this.messageId = j2;
                this.emoji = messageReactionEmoji;
            }

            public static /* synthetic */ Failure copy$default(Failure failure, long j, long j2, MessageReactionEmoji messageReactionEmoji, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = failure.channelId;
                }
                long j3 = j;
                if ((i & 2) != 0) {
                    j2 = failure.messageId;
                }
                long j4 = j2;
                if ((i & 4) != 0) {
                    messageReactionEmoji = failure.emoji;
                }
                return failure.copy(j3, j4, messageReactionEmoji);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component2, reason: from getter */
            public final long getMessageId() {
                return this.messageId;
            }

            /* renamed from: component3, reason: from getter */
            public final MessageReactionEmoji getEmoji() {
                return this.emoji;
            }

            public final Failure copy(long channelId, long messageId, MessageReactionEmoji emoji) {
                m.checkNotNullParameter(emoji, "emoji");
                return new Failure(channelId, messageId, emoji);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Failure)) {
                    return false;
                }
                Failure failure = (Failure) other;
                return this.channelId == failure.channelId && this.messageId == failure.messageId && m.areEqual(this.emoji, failure.emoji);
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final MessageReactionEmoji getEmoji() {
                return this.emoji;
            }

            public final long getMessageId() {
                return this.messageId;
            }

            public int hashCode() {
                int iA = (b.a(this.messageId) + (b.a(this.channelId) * 31)) * 31;
                MessageReactionEmoji messageReactionEmoji = this.emoji;
                return iA + (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("Failure(channelId=");
                sbU.append(this.channelId);
                sbU.append(", messageId=");
                sbU.append(this.messageId);
                sbU.append(", emoji=");
                sbU.append(this.emoji);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: StoreMessageReactions.kt */
        public static final class Loading extends EmojiResults {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: StoreMessageReactions.kt */
        public static final /* data */ class Users extends EmojiResults {
            private final long channelId;
            private final MessageReactionEmoji emoji;
            private final long messageId;
            private final LinkedHashMap<Long, User> users;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Users(LinkedHashMap<Long, User> linkedHashMap, long j, long j2, MessageReactionEmoji messageReactionEmoji) {
                super(null);
                m.checkNotNullParameter(linkedHashMap, "users");
                m.checkNotNullParameter(messageReactionEmoji, "emoji");
                this.users = linkedHashMap;
                this.channelId = j;
                this.messageId = j2;
                this.emoji = messageReactionEmoji;
            }

            public static /* synthetic */ Users copy$default(Users users, LinkedHashMap linkedHashMap, long j, long j2, MessageReactionEmoji messageReactionEmoji, int i, Object obj) {
                if ((i & 1) != 0) {
                    linkedHashMap = users.users;
                }
                if ((i & 2) != 0) {
                    j = users.channelId;
                }
                long j3 = j;
                if ((i & 4) != 0) {
                    j2 = users.messageId;
                }
                long j4 = j2;
                if ((i & 8) != 0) {
                    messageReactionEmoji = users.emoji;
                }
                return users.copy(linkedHashMap, j3, j4, messageReactionEmoji);
            }

            public final LinkedHashMap<Long, User> component1() {
                return this.users;
            }

            /* renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component3, reason: from getter */
            public final long getMessageId() {
                return this.messageId;
            }

            /* renamed from: component4, reason: from getter */
            public final MessageReactionEmoji getEmoji() {
                return this.emoji;
            }

            public final Users copy(LinkedHashMap<Long, User> users, long channelId, long messageId, MessageReactionEmoji emoji) {
                m.checkNotNullParameter(users, "users");
                m.checkNotNullParameter(emoji, "emoji");
                return new Users(users, channelId, messageId, emoji);
            }

            public final Users deepCopy() {
                return new Users(new LinkedHashMap(this.users), this.channelId, this.messageId, this.emoji);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Users)) {
                    return false;
                }
                Users users = (Users) other;
                return m.areEqual(this.users, users.users) && this.channelId == users.channelId && this.messageId == users.messageId && m.areEqual(this.emoji, users.emoji);
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final MessageReactionEmoji getEmoji() {
                return this.emoji;
            }

            public final long getMessageId() {
                return this.messageId;
            }

            public final LinkedHashMap<Long, User> getUsers() {
                return this.users;
            }

            public int hashCode() {
                LinkedHashMap<Long, User> linkedHashMap = this.users;
                int iA = (b.a(this.messageId) + ((b.a(this.channelId) + ((linkedHashMap != null ? linkedHashMap.hashCode() : 0) * 31)) * 31)) * 31;
                MessageReactionEmoji messageReactionEmoji = this.emoji;
                return iA + (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("Users(users=");
                sbU.append(this.users);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", messageId=");
                sbU.append(this.messageId);
                sbU.append(", emoji=");
                sbU.append(this.emoji);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private EmojiResults() {
        }

        public /* synthetic */ EmojiResults(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreMessageReactions.kt */
    /* renamed from: com.discord.stores.StoreMessageReactions$deleteEmoji$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Void, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* compiled from: StoreMessageReactions.kt */
    /* renamed from: com.discord.stores.StoreMessageReactions$fetchReactions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<List<? extends com.discord.api.user.User>, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ MessageReactionEmoji $emoji;
        public final /* synthetic */ long $messageId;

        /* compiled from: StoreMessageReactions.kt */
        /* renamed from: com.discord.stores.StoreMessageReactions$fetchReactions$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02731 extends o implements Function0<Unit> {
            public final /* synthetic */ List $reactionUsers;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02731(List list) {
                super(0);
                this.$reactionUsers = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                StoreMessageReactions storeMessageReactions = StoreMessageReactions.this;
                long j = anonymousClass1.$channelId;
                long j2 = anonymousClass1.$messageId;
                MessageReactionEmoji messageReactionEmoji = anonymousClass1.$emoji;
                List list = this.$reactionUsers;
                ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new CoreUser((com.discord.api.user.User) it.next()));
                }
                StoreMessageReactions.access$handleReactionUsers(storeMessageReactions, j, j2, messageReactionEmoji, arrayList);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, MessageReactionEmoji messageReactionEmoji) {
            super(1);
            this.$channelId = j;
            this.$messageId = j2;
            this.$emoji = messageReactionEmoji;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.discord.api.user.User> list) {
            invoke2((List<com.discord.api.user.User>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<com.discord.api.user.User> list) {
            m.checkNotNullParameter(list, "reactionUsers");
            StoreMessageReactions.access$getDispatcher$p(StoreMessageReactions.this).schedule(new C02731(list));
        }
    }

    /* compiled from: StoreMessageReactions.kt */
    /* renamed from: com.discord.stores.StoreMessageReactions$fetchReactions$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ MessageReactionEmoji $emoji;
        public final /* synthetic */ long $messageId;

        /* compiled from: StoreMessageReactions.kt */
        /* renamed from: com.discord.stores.StoreMessageReactions$fetchReactions$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StoreMessageReactions.access$handleLoadReactionUsersFailure(StoreMessageReactions.this, anonymousClass2.$channelId, anonymousClass2.$messageId, anonymousClass2.$emoji);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, long j2, MessageReactionEmoji messageReactionEmoji) {
            super(1);
            this.$channelId = j;
            this.$messageId = j2;
            this.$emoji = messageReactionEmoji;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            StoreMessageReactions.access$getDispatcher$p(StoreMessageReactions.this).schedule(new AnonymousClass1());
        }
    }

    /* compiled from: StoreMessageReactions.kt */
    /* renamed from: com.discord.stores.StoreMessageReactions$forceRetryFetchReactions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ MessageReactionEmoji $emoji;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, MessageReactionEmoji messageReactionEmoji, long j2) {
            super(0);
            this.$messageId = j;
            this.$emoji = messageReactionEmoji;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map map = (Map) StoreMessageReactions.access$getReactions$p(StoreMessageReactions.this).get(Long.valueOf(this.$messageId));
            if (map != null) {
            }
            StoreMessageReactions.access$fetchReactions(StoreMessageReactions.this, this.$channelId, this.$messageId, this.$emoji);
            StoreMessageReactions.this.markChanged();
        }
    }

    /* compiled from: StoreMessageReactions.kt */
    /* renamed from: com.discord.stores.StoreMessageReactions$observeMessageReactions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ MessageReactionEmoji $emoji;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, MessageReactionEmoji messageReactionEmoji) {
            super(0);
            this.$channelId = j;
            this.$messageId = j2;
            this.$emoji = messageReactionEmoji;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageReactions.access$fetchReactions(StoreMessageReactions.this, this.$channelId, this.$messageId, this.$emoji);
        }
    }

    /* compiled from: StoreMessageReactions.kt */
    /* renamed from: com.discord.stores.StoreMessageReactions$observeMessageReactions$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<EmojiResults> {
        public final /* synthetic */ MessageReactionEmoji $emoji;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, MessageReactionEmoji messageReactionEmoji) {
            super(0);
            this.$messageId = j;
            this.$emoji = messageReactionEmoji;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ EmojiResults invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final EmojiResults invoke() {
            EmojiResults emojiResults;
            Map map = (Map) StoreMessageReactions.access$getReactionsSnapshot$p(StoreMessageReactions.this).get(Long.valueOf(this.$messageId));
            return (map == null || (emojiResults = (EmojiResults) map.get(this.$emoji.c())) == null) ? EmojiResults.Loading.INSTANCE : emojiResults;
        }
    }

    public /* synthetic */ StoreMessageReactions(Dispatcher dispatcher, StoreUser storeUser, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeUser, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ void access$fetchReactions(StoreMessageReactions storeMessageReactions, long j, long j2, MessageReactionEmoji messageReactionEmoji) {
        storeMessageReactions.fetchReactions(j, j2, messageReactionEmoji);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreMessageReactions storeMessageReactions) {
        return storeMessageReactions.dispatcher;
    }

    public static final /* synthetic */ Map access$getReactions$p(StoreMessageReactions storeMessageReactions) {
        return storeMessageReactions.reactions;
    }

    public static final /* synthetic */ Map access$getReactionsSnapshot$p(StoreMessageReactions storeMessageReactions) {
        return storeMessageReactions.reactionsSnapshot;
    }

    public static final /* synthetic */ void access$handleLoadReactionUsersFailure(StoreMessageReactions storeMessageReactions, long j, long j2, MessageReactionEmoji messageReactionEmoji) {
        storeMessageReactions.handleLoadReactionUsersFailure(j, j2, messageReactionEmoji);
    }

    public static final /* synthetic */ void access$handleReactionUsers(StoreMessageReactions storeMessageReactions, long j, long j2, MessageReactionEmoji messageReactionEmoji, List list) {
        storeMessageReactions.handleReactionUsers(j, j2, messageReactionEmoji, list);
    }

    public static final /* synthetic */ void access$setReactionsSnapshot$p(StoreMessageReactions storeMessageReactions, Map map) {
        storeMessageReactions.reactionsSnapshot = map;
    }

    @StoreThread
    private final EmojiResults ensureReactionResults(long messageId, String emoji) {
        Map<String, EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map == null) {
            map = new HashMap<>();
        }
        EmojiResults emojiResults = map.get(emoji);
        if (emojiResults == null) {
            emojiResults = EmojiResults.Loading.INSTANCE;
        }
        map.put(emoji, emojiResults);
        this.reactions.put(Long.valueOf(messageId), map);
        return emojiResults;
    }

    @StoreThread
    private final void fetchReactions(long channelId, long messageId, MessageReactionEmoji emoji) {
        if ((ensureReactionResults(messageId, emoji.c()) instanceof EmojiResults.Users) && (!((EmojiResults.Users) r0).getUsers().isEmpty())) {
            return;
        }
        String reactionEmojiRequestParam = getReactionEmojiRequestParam(emoji);
        Map<String, EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map != null) {
            map.put(emoji.c(), EmojiResults.Loading.INSTANCE);
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getReactionUsers(channelId, messageId, reactionEmojiRequestParam, 100), false, 1, null), StoreMessageReactions.class, (Context) null, (Function1) null, new AnonymousClass2(channelId, messageId, emoji), (Function0) null, (Function0) null, new AnonymousClass1(channelId, messageId, emoji), 54, (Object) null);
    }

    private final String getReactionEmojiRequestParam(MessageReactionEmoji emoji) {
        if (!emoji.e()) {
            String name = emoji.getName();
            return name != null ? name : "";
        }
        return emoji.getName() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + emoji.getId();
    }

    @StoreThread
    private final void handleLoadReactionUsersFailure(long channelId, long messageId, MessageReactionEmoji emoji) {
        ensureReactionResults(messageId, emoji.c());
        Map<String, EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map != null) {
            map.put(emoji.c(), new EmojiResults.Failure(channelId, messageId, emoji));
        }
        markChanged();
    }

    @StoreThread
    private final void handleReactionUsers(long channelId, long messageId, MessageReactionEmoji emoji, List<? extends User> reactionUsers) {
        ensureReactionResults(messageId, emoji.c());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : reactionUsers) {
            linkedHashMap.put(Long.valueOf(((User) obj).getId()), obj);
        }
        Map<String, EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map != null) {
            map.put(emoji.c(), new EmojiResults.Users(linkedHashMap, channelId, messageId, emoji));
        }
        markChanged();
    }

    public final void deleteEmoji(long channelId, long messageId, MessageReactionEmoji emoji, long userId) {
        m.checkNotNullParameter(emoji, "emoji");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().removeReaction(channelId, messageId, getReactionEmojiRequestParam(emoji), userId), false, 1, null), StoreMessageReactions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
    }

    public final void forceRetryFetchReactions(long channelId, long messageId, MessageReactionEmoji emoji) {
        m.checkNotNullParameter(emoji, "emoji");
        this.dispatcher.schedule(new AnonymousClass1(messageId, emoji, channelId));
    }

    @StoreThread
    public final void handleConnectionOpen() {
        if (!this.reactions.isEmpty()) {
            this.reactions.clear();
            markChanged();
        }
    }

    @StoreThread
    public final void handleReactionAdd(MessageReactionUpdate update) {
        m.checkNotNullParameter(update, "update");
        User user = this.userStore.getUsersInternal$app_productionGoogleRelease().get(Long.valueOf(update.getUserId()));
        if (user != null) {
            EmojiResults emojiResultsEnsureReactionResults = ensureReactionResults(update.getMessageId(), update.getEmoji().c());
            if (!(emojiResultsEnsureReactionResults instanceof EmojiResults.Users)) {
                emojiResultsEnsureReactionResults = null;
            }
            EmojiResults.Users users = (EmojiResults.Users) emojiResultsEnsureReactionResults;
            if (users != null) {
                users.getUsers().put(Long.valueOf(update.getUserId()), user);
                markChanged();
            }
        }
    }

    @StoreThread
    public final void handleReactionRemove(MessageReactionUpdate update) {
        m.checkNotNullParameter(update, "update");
        EmojiResults emojiResultsEnsureReactionResults = ensureReactionResults(update.getMessageId(), update.getEmoji().c());
        if (!(emojiResultsEnsureReactionResults instanceof EmojiResults.Users)) {
            emojiResultsEnsureReactionResults = null;
        }
        EmojiResults.Users users = (EmojiResults.Users) emojiResultsEnsureReactionResults;
        if (users != null) {
            users.getUsers().remove(Long.valueOf(update.getUserId()));
            markChanged();
        }
    }

    @StoreThread
    public final void handleReactionRemoveAll(MessageReactionUpdate update) {
        m.checkNotNullParameter(update, "update");
        this.reactions.remove(Long.valueOf(update.getMessageId()));
        markChanged();
    }

    @StoreThread
    public final void handleReactionRemoveEmoji(MessageReactionUpdate update) {
        m.checkNotNullParameter(update, "update");
        long messageId = update.getMessageId();
        String strC = update.getEmoji().c();
        ensureReactionResults(messageId, strC);
        Map<String, EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map != null) {
            map.remove(strC);
        }
        markChanged();
    }

    public final Observable<EmojiResults> observeMessageReactions(long channelId, long messageId, MessageReactionEmoji emoji) {
        m.checkNotNullParameter(emoji, "emoji");
        this.dispatcher.schedule(new AnonymousClass1(channelId, messageId, emoji));
        Observable<EmojiResults> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass2(messageId, emoji), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        HashMap map = new HashMap(this.reactions);
        for (Map.Entry<Long, Map<String, EmojiResults>> entry : this.reactions.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            HashMap map2 = new HashMap(entry.getValue());
            map.put(Long.valueOf(jLongValue), map2);
            for (Map.Entry entry2 : map2.entrySet()) {
                String str = (String) entry2.getKey();
                Object objDeepCopy = (EmojiResults) entry2.getValue();
                if (objDeepCopy instanceof EmojiResults.Users) {
                    objDeepCopy = ((EmojiResults.Users) objDeepCopy).deepCopy();
                }
                map2.put(str, objDeepCopy);
            }
        }
        this.reactionsSnapshot = map;
    }

    public StoreMessageReactions(Dispatcher dispatcher, StoreUser storeUser, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.userStore = storeUser;
        this.observationDeck = observationDeck;
        this.reactions = new HashMap();
        this.reactionsSnapshot = new HashMap();
    }
}
