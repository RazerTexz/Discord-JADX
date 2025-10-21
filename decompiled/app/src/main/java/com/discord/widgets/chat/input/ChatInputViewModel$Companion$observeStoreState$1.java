package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreGuildJoinRequest;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreLurking;
import com.discord.stores.StorePendingReplies;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreThreadDraft;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.ChatInputViewModel;
import com.discord.widgets.forums.ForumPostCreateManager;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.jvm.functions.Function13;
import rx.Observable;

/* compiled from: ChatInputViewModel.kt */
/* loaded from: classes2.dex */
public final class ChatInputViewModel$Companion$observeStoreState$1<T, R> implements Func1<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends ChatInputViewModel.StoreState>> {
    public final /* synthetic */ StoreChat $storeChat;
    public final /* synthetic */ StoreGuildJoinRequest $storeGuildJoinRequest;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreLurking $storeLurking;
    public final /* synthetic */ StorePendingReplies $storePendingReplies;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreSlowMode $storeSlowMode;
    public final /* synthetic */ StoreThreadDraft $storeThreadDraft;
    public final /* synthetic */ StoreUserRelationships $storeUserRelationships;
    public final /* synthetic */ StoreUser $storeUsers;

    /* compiled from: ChatInputViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.ChatInputViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function13<MeUser, StoreChat.EditingMessage, Integer, Long, GuildVerificationLevel, Boolean, Boolean, Guild, ChatInputViewModel.StoreState.Loaded.PendingReply, GuildMember, GuildJoinRequest, StoreThreadDraft.ThreadDraftState, Boolean, ChatInputViewModel.StoreState.Loaded> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ StoreChannelsSelected.ResolvedSelectedChannel $selectedChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Channel channel, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
            super(13);
            this.$channel = channel;
            this.$selectedChannel = resolvedSelectedChannel;
        }

        @Override // kotlin.jvm.functions.Function13
        public /* bridge */ /* synthetic */ ChatInputViewModel.StoreState.Loaded invoke(MeUser meUser, StoreChat.EditingMessage editingMessage, Integer num, Long l, GuildVerificationLevel guildVerificationLevel, Boolean bool, Boolean bool2, Guild guild, ChatInputViewModel.StoreState.Loaded.PendingReply pendingReply, GuildMember guildMember, GuildJoinRequest guildJoinRequest, StoreThreadDraft.ThreadDraftState threadDraftState, Boolean bool3) {
            return invoke(meUser, editingMessage, num, l, guildVerificationLevel, bool.booleanValue(), bool2, guild, pendingReply, guildMember, guildJoinRequest, threadDraftState, bool3.booleanValue());
        }

        public final ChatInputViewModel.StoreState.Loaded invoke(MeUser meUser, StoreChat.EditingMessage editingMessage, Integer num, Long l, GuildVerificationLevel guildVerificationLevel, boolean z2, Boolean bool, Guild guild, ChatInputViewModel.StoreState.Loaded.PendingReply pendingReply, GuildMember guildMember, GuildJoinRequest guildJoinRequest, StoreThreadDraft.ThreadDraftState threadDraftState, boolean z3) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(guildVerificationLevel, "verificationLevelTriggered");
            Intrinsics3.checkNotNullParameter(threadDraftState, "threadDraftState");
            Channel channel = this.$channel;
            Intrinsics3.checkNotNullExpressionValue(bool, "isOnCooldown");
            boolean zBooleanValue = bool.booleanValue();
            StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel = this.$selectedChannel;
            if (!(resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft)) {
                resolvedSelectedChannel = null;
            }
            return new ChatInputViewModel.StoreState.Loaded(channel, meUser, editingMessage, num, l, guildVerificationLevel, z2, zBooleanValue, guild, pendingReply, (StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) resolvedSelectedChannel, guildMember, guildJoinRequest, threadDraftState, z3);
        }
    }

    public ChatInputViewModel$Companion$observeStoreState$1(StoreUser storeUser, StoreChat storeChat, StoreUserRelationships storeUserRelationships, StorePermissions storePermissions, StoreGuilds storeGuilds, StoreLurking storeLurking, StoreSlowMode storeSlowMode, StorePendingReplies storePendingReplies, StoreGuildJoinRequest storeGuildJoinRequest, StoreThreadDraft storeThreadDraft) {
        this.$storeUsers = storeUser;
        this.$storeChat = storeChat;
        this.$storeUserRelationships = storeUserRelationships;
        this.$storePermissions = storePermissions;
        this.$storeGuilds = storeGuilds;
        this.$storeLurking = storeLurking;
        this.$storeSlowMode = storeSlowMode;
        this.$storePendingReplies = storePendingReplies;
        this.$storeGuildJoinRequest = storeGuildJoinRequest;
        this.$storeThreadDraft = storeThreadDraft;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends ChatInputViewModel.StoreState> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return call2(resolvedSelectedChannel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChatInputViewModel.StoreState> call2(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        Channel channelOrParent = resolvedSelectedChannel.getChannelOrParent();
        if (channelOrParent == null) {
            return new ScalarSynchronousObservable(ChatInputViewModel.StoreState.Loading.INSTANCE);
        }
        Observable<MeUser> observableObserveMe = this.$storeUsers.observeMe(true);
        Observable observableComputationBuffered = ObservableExtensionsKt.computationBuffered(this.$storeChat.observeEditingMessage());
        StoreUserRelationships storeUserRelationships = this.$storeUserRelationships;
        User userA = ChannelUtils.a(channelOrParent);
        Observable<Integer> observableObserve = storeUserRelationships.observe(userA != null ? userA.getId() : 0L);
        Observable<Long> observableObservePermissionsForChannel = this.$storePermissions.observePermissionsForChannel(channelOrParent.getId());
        ChatInputViewModel.Companion companion = ChatInputViewModel.INSTANCE;
        Observable observableAccess$getVerificationLevelTriggeredObservable = ChatInputViewModel.Companion.access$getVerificationLevelTriggeredObservable(companion, channelOrParent.getGuildId(), this.$storeGuilds, this.$storeUsers);
        Observable<Boolean> observableIsLurkingObs = this.$storeLurking.isLurkingObs(channelOrParent.getGuildId());
        Observable observableAccess$getIsOnCooldownObservable = ChatInputViewModel.Companion.access$getIsOnCooldownObservable(companion, channelOrParent.getId(), this.$storeSlowMode);
        Intrinsics3.checkNotNullExpressionValue(observableAccess$getIsOnCooldownObservable, "getIsOnCooldownObservabl…hannel.id, storeSlowMode)");
        return ObservableCombineLatestOverloads2.combineLatest(observableObserveMe, observableComputationBuffered, observableObserve, observableObservePermissionsForChannel, observableAccess$getVerificationLevelTriggeredObservable, observableIsLurkingObs, observableAccess$getIsOnCooldownObservable, this.$storeGuilds.observeFromChannelId(channelOrParent.getId()), ChatInputViewModel.Companion.access$getPendingReplyStateObservable(companion, channelOrParent.getId(), this.$storePendingReplies), this.$storeGuilds.observeComputedMember(channelOrParent.getGuildId(), this.$storeUsers.getMeSnapshot().getId()), this.$storeGuildJoinRequest.observeGuildJoinRequest(channelOrParent.getGuildId()), this.$storeThreadDraft.observeDraftState(), ForumPostCreateManager.INSTANCE.observeIsForumPostCreateInProgress(channelOrParent.getGuildId()), new AnonymousClass1(channelOrParent, resolvedSelectedChannel));
    }
}
