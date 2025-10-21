package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.api.permission.Permission;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMessageReactions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.managereactions.ManageReactionsEmojisAdapter;
import com.discord.widgets.chat.managereactions.ManageReactionsResultsAdapter;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples3;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: ManageReactionsModel.kt */
/* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider, reason: use source file name */
/* loaded from: classes2.dex */
public final class ManageReactionsModel2 {
    private final long channelId;
    private final long messageId;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final SerializedSubject<String, String> targetedEmojiKeySubject;

    /* compiled from: ManageReactionsModel.kt */
    /* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Observable<Boolean>> {

        /* compiled from: ManageReactionsModel.kt */
        /* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02801<T1, T2, R> implements Func2<Long, Guild, Boolean> {
            public final /* synthetic */ boolean $isMeMfaEnabled;

            public C02801(boolean z2) {
                this.$isMeMfaEnabled = z2;
            }

            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Boolean call(Long l, Guild guild) {
                return call2(l, guild);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Long l, Guild guild) {
                return Boolean.valueOf(guild != null && PermissionUtils.canAndIsElevated(Permission.MANAGE_MESSAGES, l, this.$isMeMfaEnabled, guild.getMfaLevel()));
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Observable<Boolean> invoke(Boolean bool) {
            return invoke(bool.booleanValue());
        }

        public final Observable<Boolean> invoke(boolean z2) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Boolean> observableJ = Observable.j(companion.getPermissions().observePermissionsForChannel(ManageReactionsModel2.this.getChannelId()), companion.getGuilds().observeFromChannelId(ManageReactionsModel2.this.getChannelId()), new C02801(z2));
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…ld.mfaLevel\n      )\n    }");
            return observableJ;
        }
    }

    /* compiled from: ManageReactionsModel.kt */
    /* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<MeUser, Observable<? extends ManageReactionsModel>> {
        public final /* synthetic */ AnonymousClass1 $getCanManageMessagesObs$1;
        public final /* synthetic */ Observable $guildMembersObservable;
        public final /* synthetic */ Observable $reactionsObs;

        /* compiled from: ManageReactionsModel.kt */
        /* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Boolean, List<? extends MessageReaction>, Map<Long, ? extends GuildMember>, Tuples3<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>>> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Tuples3<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>> call(Boolean bool, List<? extends MessageReaction> list, Map<Long, ? extends GuildMember> map) {
                return call2(bool, (List<MessageReaction>) list, (Map<Long, GuildMember>) map);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Tuples3<Boolean, List<MessageReaction>, Map<Long, GuildMember>> call2(Boolean bool, List<MessageReaction> list, Map<Long, GuildMember> map) {
                return new Tuples3<>(bool, list, map);
            }
        }

        /* compiled from: ManageReactionsModel.kt */
        /* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C02812<T, R> implements Func1<Tuples3<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>>, Observable<? extends ManageReactionsModel>> {
            public final /* synthetic */ MeUser $me;

            /* compiled from: ManageReactionsModel.kt */
            /* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$2$2$1, reason: invalid class name */
            public static final class AnonymousClass1<T, R> implements Func1<String, MessageReactionEmoji> {
                public final /* synthetic */ List $reactions;

                public AnonymousClass1(List list) {
                    this.$reactions = list;
                }

                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ MessageReactionEmoji call(String str) {
                    return call2(str);
                }

                /* renamed from: call, reason: avoid collision after fix types in other method */
                public final MessageReactionEmoji call2(String str) {
                    T next;
                    MessageReactionEmoji emoji;
                    List list = this.$reactions;
                    Intrinsics3.checkNotNullExpressionValue(list, "reactions");
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = (T) null;
                            break;
                        }
                        next = it.next();
                        if (Intrinsics3.areEqual(((MessageReaction) next).getEmoji().c(), str)) {
                            break;
                        }
                    }
                    MessageReaction messageReaction = next;
                    if (messageReaction != null && (emoji = messageReaction.getEmoji()) != null) {
                        return emoji;
                    }
                    List list2 = this.$reactions;
                    Intrinsics3.checkNotNullExpressionValue(list2, "reactions");
                    return ((MessageReaction) _Collections.first(list2)).getEmoji();
                }
            }

            /* compiled from: ManageReactionsModel.kt */
            /* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$2$2$2, reason: invalid class name and collision with other inner class name */
            public static final class C02822<T, R> implements Func1<MessageReactionEmoji, Observable<? extends ManageReactionsModel>> {
                public final /* synthetic */ Boolean $canManageMessages;
                public final /* synthetic */ Map $guildMembers;
                public final /* synthetic */ List $reactions;

                /* compiled from: ManageReactionsModel.kt */
                /* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$2$2$2$1, reason: invalid class name */
                public static final class AnonymousClass1<T, R> implements Func1<StoreMessageReactions.EmojiResults, ManageReactionsModel> {
                    public final /* synthetic */ MessageReactionEmoji $targetedEmoji;

                    public AnonymousClass1(MessageReactionEmoji messageReactionEmoji) {
                        this.$targetedEmoji = messageReactionEmoji;
                    }

                    @Override // j0.k.Func1
                    public /* bridge */ /* synthetic */ ManageReactionsModel call(StoreMessageReactions.EmojiResults emojiResults) {
                        return call2(emojiResults);
                    }

                    /* renamed from: call, reason: avoid collision after fix types in other method */
                    public final ManageReactionsModel call2(StoreMessageReactions.EmojiResults emojiResults) {
                        C02822 c02822 = C02822.this;
                        ManageReactionsModel2 manageReactionsModel2 = ManageReactionsModel2.this;
                        List list = c02822.$reactions;
                        Intrinsics3.checkNotNullExpressionValue(list, "reactions");
                        Intrinsics3.checkNotNullExpressionValue(emojiResults, "users");
                        MessageReactionEmoji messageReactionEmoji = this.$targetedEmoji;
                        Boolean bool = C02822.this.$canManageMessages;
                        Intrinsics3.checkNotNullExpressionValue(bool, "canManageMessages");
                        boolean zBooleanValue = bool.booleanValue();
                        long id2 = C02812.this.$me.getId();
                        Map map = C02822.this.$guildMembers;
                        Intrinsics3.checkNotNullExpressionValue(map, "guildMembers");
                        return ManageReactionsModel2.access$createModel(manageReactionsModel2, list, emojiResults, messageReactionEmoji, zBooleanValue, id2, map);
                    }
                }

                public C02822(List list, Boolean bool, Map map) {
                    this.$reactions = list;
                    this.$canManageMessages = bool;
                    this.$guildMembers = map;
                }

                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Observable<? extends ManageReactionsModel> call(MessageReactionEmoji messageReactionEmoji) {
                    return call2(messageReactionEmoji);
                }

                /* renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends ManageReactionsModel> call2(MessageReactionEmoji messageReactionEmoji) {
                    ManageReactionsModel2 manageReactionsModel2 = ManageReactionsModel2.this;
                    Intrinsics3.checkNotNullExpressionValue(messageReactionEmoji, "targetedEmoji");
                    return ManageReactionsModel2.access$getUsersForReaction(manageReactionsModel2, messageReactionEmoji).G(new AnonymousClass1(messageReactionEmoji));
                }
            }

            public C02812(MeUser meUser) {
                this.$me = meUser;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends ManageReactionsModel> call(Tuples3<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>> tuples3) {
                return call2((Tuples3<Boolean, ? extends List<MessageReaction>, ? extends Map<Long, GuildMember>>) tuples3);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends ManageReactionsModel> call2(Tuples3<Boolean, ? extends List<MessageReaction>, ? extends Map<Long, GuildMember>> tuples3) {
                Boolean boolComponent1 = tuples3.component1();
                List<MessageReaction> listComponent2 = tuples3.component2();
                return listComponent2.isEmpty() ? new ScalarSynchronousObservable(null) : ManageReactionsModel2.access$getTargetedEmojiKeySubject$p(ManageReactionsModel2.this).r().G(new AnonymousClass1(listComponent2)).Y(new C02822(listComponent2, boolComponent1, tuples3.component3()));
            }
        }

        public AnonymousClass2(AnonymousClass1 anonymousClass1, Observable observable, Observable observable2) {
            this.$getCanManageMessagesObs$1 = anonymousClass1;
            this.$reactionsObs = observable;
            this.$guildMembersObservable = observable2;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends ManageReactionsModel> call(MeUser meUser) {
            return call2(meUser);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends ManageReactionsModel> call2(MeUser meUser) {
            return Observable.i(this.$getCanManageMessagesObs$1.invoke(meUser.getMfaEnabled()), this.$reactionsObs, this.$guildMembersObservable, AnonymousClass1.INSTANCE).Y(new C02812(meUser));
        }
    }

    public ManageReactionsModel2(long j, long j2, String str, StoreChannels storeChannels, StoreGuilds storeGuilds, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.channelId = j;
        this.messageId = j2;
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.observationDeck = observationDeck;
        this.targetedEmojiKeySubject = new SerializedSubject<>(BehaviorSubject.l0(str));
    }

    public static final /* synthetic */ ManageReactionsModel access$createModel(ManageReactionsModel2 manageReactionsModel2, List list, StoreMessageReactions.EmojiResults emojiResults, MessageReactionEmoji messageReactionEmoji, boolean z2, long j, Map map) {
        return manageReactionsModel2.createModel(list, emojiResults, messageReactionEmoji, z2, j, map);
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(ManageReactionsModel2 manageReactionsModel2) {
        return manageReactionsModel2.storeChannels;
    }

    public static final /* synthetic */ StoreGuilds access$getStoreGuilds$p(ManageReactionsModel2 manageReactionsModel2) {
        return manageReactionsModel2.storeGuilds;
    }

    public static final /* synthetic */ SerializedSubject access$getTargetedEmojiKeySubject$p(ManageReactionsModel2 manageReactionsModel2) {
        return manageReactionsModel2.targetedEmojiKeySubject;
    }

    public static final /* synthetic */ Observable access$getUsersForReaction(ManageReactionsModel2 manageReactionsModel2, MessageReactionEmoji messageReactionEmoji) {
        return manageReactionsModel2.getUsersForReaction(messageReactionEmoji);
    }

    private final ManageReactionsModel createModel(List<MessageReaction> reactions, StoreMessageReactions.EmojiResults results, MessageReactionEmoji targetedEmoji, boolean canManageMessages, long myId, Map<Long, GuildMember> guildMembers) {
        List listListOf;
        Map<Long, GuildMember> map;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        for (MessageReaction messageReaction : reactions) {
            arrayList.add(new ManageReactionsEmojisAdapter.ReactionEmojiItem(messageReaction, Intrinsics3.areEqual(messageReaction.getEmoji(), targetedEmoji)));
        }
        if (results instanceof StoreMessageReactions.EmojiResults.Users) {
            StoreMessageReactions.EmojiResults.Users users = (StoreMessageReactions.EmojiResults.Users) results;
            Collection<User> collectionValues = users.getUsers().values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues, "results.users.values");
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(collectionValues, 10));
            for (User user : collectionValues) {
                Intrinsics3.checkNotNullExpressionValue(user, "user");
                long j = this.channelId;
                long j2 = this.messageId;
                MessageReactionEmoji emoji = users.getEmoji();
                if (canManageMessages || user.getId() == myId) {
                    map = guildMembers;
                    z2 = true;
                } else {
                    map = guildMembers;
                    z2 = false;
                }
                arrayList2.add(new ManageReactionsResultsAdapter.ReactionUserItem(user, j, j2, emoji, z2, (GuildMember) outline.f(user, map)));
            }
            listListOf = _Collections.toList(arrayList2);
        } else if (results instanceof StoreMessageReactions.EmojiResults.Loading) {
            listListOf = CollectionsJVM.listOf(new ManageReactionsResultsAdapter.LoadingItem());
        } else {
            if (!(results instanceof StoreMessageReactions.EmojiResults.Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            StoreMessageReactions.EmojiResults.Failure failure = (StoreMessageReactions.EmojiResults.Failure) results;
            listListOf = CollectionsJVM.listOf(new ManageReactionsResultsAdapter.ErrorItem(failure.getChannelId(), failure.getMessageId(), failure.getEmoji()));
        }
        return new ManageReactionsModel(arrayList, listListOf);
    }

    private final Observable<StoreMessageReactions.EmojiResults> getUsersForReaction(MessageReactionEmoji targetedEmoji) {
        return StoreStream.INSTANCE.getMessageReactions().observeMessageReactions(this.channelId, this.messageId, targetedEmoji);
    }

    public final Observable<ManageReactionsModel> get() {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableG = companion.getMessages().observeMessagesForChannel(this.channelId, this.messageId).G(ManageReactionsModel4.INSTANCE).G(ManageReactionsModel5.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream\n        .get…ion -> reaction.count } }");
        Observable observableY = StoreUser.observeMe$default(companion.getUsers(), false, 1, null).Y(new AnonymousClass2(anonymousClass1, observableG, ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeChannels, this.storeGuilds}, false, null, null, new ManageReactionsModel3(this), 14, null)));
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…              }\n        }");
        Observable<ManageReactionsModel> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n        .get…  .distinctUntilChanged()");
        return observableR;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final void onEmojiTargeted(String emojiKey) {
        Intrinsics3.checkNotNullParameter(emojiKey, "emojiKey");
        this.targetedEmojiKeySubject.k.onNext(emojiKey);
    }

    public /* synthetic */ ManageReactionsModel2(long j, long j2, String str, StoreChannels storeChannels, StoreGuilds storeGuilds, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 32) != 0 ? ObservationDeck4.get() : observationDeck);
    }
}
