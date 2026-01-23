package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.models.message.Message;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreForumPostMessages;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.status.WidgetForumPostStatusViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func5;

/* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatusViewModel2<T, R> implements Func1<Channel, Observable<? extends WidgetForumPostStatusViewModel.StoreState>> {
    public final /* synthetic */ StoreEmoji $storeEmoji;
    public final /* synthetic */ StoreForumPostMessages $storeForumPostMessages;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreThreadMessages $storeThreadMessages;
    public final /* synthetic */ StoreThreadsJoined $storeThreadsJoined;
    public final /* synthetic */ StoreUser $storeUser;

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$Companion$observeStoreState$1$1 */
    /* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
    public static final class C100911<T1, T2, T3, T4, T5, R> implements Func5<Long, StoreThreadsJoined.JoinedThread, Message, StoreThreadMessages.ThreadState, Long, WidgetForumPostStatusViewModel.StoreState.Loaded> {
        public final /* synthetic */ Channel $channel;

        public C100911(Channel channel) {
            this.$channel = channel;
        }

        @Override // p658rx.functions.Func5
        public /* bridge */ /* synthetic */ WidgetForumPostStatusViewModel.StoreState.Loaded call(Long l, StoreThreadsJoined.JoinedThread joinedThread, Message message, StoreThreadMessages.ThreadState threadState, Long l2) {
            return call2(l, joinedThread, message, threadState, l2);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetForumPostStatusViewModel.StoreState.Loaded call2(Long l, StoreThreadsJoined.JoinedThread joinedThread, Message message, StoreThreadMessages.ThreadState threadState, Long l2) {
            boolean zCan = PermissionUtils.can(64L, l2);
            ForumUtils forumUtils = ForumUtils.INSTANCE;
            MessageReaction placeholderMessageReaction = forumUtils.getPlaceholderMessageReaction(WidgetForumPostStatusViewModel2.this.$storeEmoji);
            MessageReaction messageReactionMostCommonReaction = message != null ? forumUtils.mostCommonReaction(message, WidgetForumPostStatusViewModel2.this.$storeEmoji) : null;
            boolean z2 = messageReactionMostCommonReaction != null && forumUtils.isDefaultPostReaction(messageReactionMostCommonReaction, WidgetForumPostStatusViewModel2.this.$storeEmoji);
            Intrinsics3.checkNotNullExpressionValue(l, "myUserId");
            long jLongValue = l.longValue();
            long id2 = this.$channel.getId();
            long guildId = this.$channel.getGuildId();
            boolean zM7686j = ChannelUtils.m7686j(this.$channel);
            boolean z3 = joinedThread != null;
            Long lValueOf = message != null ? Long.valueOf(message.getId()) : null;
            if (messageReactionMostCommonReaction != null) {
                placeholderMessageReaction = messageReactionMostCommonReaction;
            }
            return new WidgetForumPostStatusViewModel.StoreState.Loaded(jLongValue, id2, guildId, lValueOf, z3, zM7686j, threadState != null ? Integer.valueOf(threadState.getCount()) : null, zCan, z2, placeholderMessageReaction);
        }
    }

    public WidgetForumPostStatusViewModel2(StoreUser storeUser, StoreThreadsJoined storeThreadsJoined, StoreForumPostMessages storeForumPostMessages, StoreThreadMessages storeThreadMessages, StorePermissions storePermissions, StoreEmoji storeEmoji) {
        this.$storeUser = storeUser;
        this.$storeThreadsJoined = storeThreadsJoined;
        this.$storeForumPostMessages = storeForumPostMessages;
        this.$storeThreadMessages = storeThreadMessages;
        this.$storePermissions = storePermissions;
        this.$storeEmoji = storeEmoji;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetForumPostStatusViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetForumPostStatusViewModel.StoreState> call2(Channel channel) {
        return channel == null ? new ScalarSynchronousObservable(WidgetForumPostStatusViewModel.StoreState.Invalid.INSTANCE) : Observable.m11072g(this.$storeUser.observeMeId(), this.$storeThreadsJoined.observeJoinedThread(channel.getId()), this.$storeForumPostMessages.observeForumPostFirstMessage(channel.getParentId(), channel.getId(), true), this.$storeThreadMessages.observeThreadCountAndLatestMessage(channel.getId()), this.$storePermissions.observePermissionsForChannel(channel.getId()), new C100911(channel));
    }
}
