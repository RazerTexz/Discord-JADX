package com.discord.widgets.chat.list.model;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.user.UserMutualGuildsManager;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetChatListModelTop.kt */
/* loaded from: classes2.dex */
public final /* data */ class WidgetChatListModelTop {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ChatListEntry item;

    /* compiled from: WidgetChatListModelTop.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$getWelcomeEntry(Companion companion, Channel channel) {
            return companion.getWelcomeEntry(channel);
        }

        private final Observable<ChatListEntry> getWelcomeEntry(Channel channel) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Guild> observableObserveGuild = companion.getGuilds().observeGuild(channel.getGuildId());
            Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
            Observable<Long> observableObservePermissionsForChannel = companion.getPermissions().observePermissionsForChannel(channel.getId());
            Observable observableR = companion.getChannels().observeDefaultChannel(channel.getGuildId()).G(WidgetChatListModelTop3.INSTANCE).r();
            Observable<GuildMember> observableObserveGuildMember = observeGuildMember(channel.getGuildId(), channel.getOwnerId());
            Observable<User> observableObserveUser = companion.getUsers().observeUser(channel.getOwnerId());
            UserMutualGuildsManager userMutualGuildsManager = new UserMutualGuildsManager(null, null, null, 7, null);
            User userA = ChannelUtils.a(channel);
            Observable<ChatListEntry> observableC = Observable.c(observableObserveGuild, observableObserveMe$default, observableObservePermissionsForChannel, observableR, observableObserveGuildMember, observableObserveUser, userMutualGuildsManager.observeMutualGuilds(CollectionsJVM.listOf(Long.valueOf(userA != null ? userA.getId() : 0L))), companion.getChannels().observeChannel(channel.getParentId()), ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, null, 6, null), new WidgetChatListModelTop4(channel));
            Intrinsics3.checkNotNullExpressionValue(observableC, "Observable.combineLatest…      )\n        }\n      }");
            return observableC;
        }

        private final Observable<GuildMember> observeGuildMember(long guildId, long userId) {
            Observable<GuildMember> observableObserveGuildMember = StoreStream.INSTANCE.getGuilds().observeGuildMember(guildId, userId);
            Intrinsics3.checkNotNullExpressionValue(observableObserveGuildMember, "StoreStream.getGuilds().…ldMember(guildId, userId)");
            return ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(observableObserveGuildMember, 1L, TimeUnit.SECONDS));
        }

        public final Observable<WidgetChatListModelTop> get(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Observable<WidgetChatListModelTop> observableR = StoreStream.INSTANCE.getMessagesLoader().getMessagesLoadedState(channel.getId()).Y(new WidgetChatListModelTop2(channel)).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n          .g…  .distinctUntilChanged()");
            return observableR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetChatListModelTop(ChatListEntry chatListEntry) {
        Intrinsics3.checkNotNullParameter(chatListEntry, "item");
        this.item = chatListEntry;
    }

    public static /* synthetic */ WidgetChatListModelTop copy$default(WidgetChatListModelTop widgetChatListModelTop, ChatListEntry chatListEntry, int i, Object obj) {
        if ((i & 1) != 0) {
            chatListEntry = widgetChatListModelTop.item;
        }
        return widgetChatListModelTop.copy(chatListEntry);
    }

    public static final Observable<WidgetChatListModelTop> get(Channel channel) {
        return INSTANCE.get(channel);
    }

    /* renamed from: component1, reason: from getter */
    public final ChatListEntry getItem() {
        return this.item;
    }

    public final WidgetChatListModelTop copy(ChatListEntry item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        return new WidgetChatListModelTop(item);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetChatListModelTop) && Intrinsics3.areEqual(this.item, ((WidgetChatListModelTop) other).item);
        }
        return true;
    }

    public final ChatListEntry getItem() {
        return this.item;
    }

    public int hashCode() {
        ChatListEntry chatListEntry = this.item;
        if (chatListEntry != null) {
            return chatListEntry.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetChatListModelTop(item=");
        sbU.append(this.item);
        sbU.append(")");
        return sbU.toString();
    }
}
