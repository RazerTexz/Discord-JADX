package com.discord.widgets.chat.list.model;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadDraft;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StickerGreetCompactEntry;
import com.discord.widgets.chat.list.entries.StickerGreetEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: WidgetChatListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListModel implements WidgetChatListAdapter.Data {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_MESSAGES_PER_CHANNEL = 25;
    private static final long WUMPUS_PACK_ID = 847199849233514549L;
    private static final long WUMPUS_WAVE_STICKER_ID = 749054660769218631L;
    private final long channelId;
    private final Map<Long, String> channelNames;
    private final Guild guild;
    private final long guildId;
    private final boolean isLoadingMessages;
    private final boolean isSpoilerClickAllowed;
    private final List<ChatListEntry> list;
    private final Set<Long> myRoleIds;
    private final long newMessagesMarkerMessageId;
    private final long newestKnownMessageId;
    private final long oldestMessageId;
    private final long userId;

    /* JADX INFO: compiled from: WidgetChatListModel.kt */
    public enum ChatListState {
        DETACHED,
        DETACHED_UNTOUCHED,
        ATTACHED;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: WidgetChatListModel.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<ChatListState> get(long channelId) {
                Observable observableM11099Y = StoreStream.INSTANCE.getMessages().observeIsDetached(channelId).m11099Y(new WidgetChatListModel2(channelId));
                Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …        }\n              }");
                return observableM11099Y;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* JADX INFO: compiled from: WidgetChatListModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$getChannel(Companion companion, Channel channel) {
            return companion.getChannel(channel);
        }

        public static final /* synthetic */ ChatListEntry access$getGreetMessageItem(Companion companion, WidgetChatListModelMessages widgetChatListModelMessages, Channel channel) {
            return companion.getGreetMessageItem(widgetChatListModelMessages, channel);
        }

        public static final /* synthetic */ Observable access$getThreadDraft(Companion companion, Channel channel, Long l) {
            return companion.getThreadDraft(channel, l);
        }

        public static final /* synthetic */ boolean access$shouldShowStickerGreet(Companion companion, StoreMessagesLoader.ChannelLoadedState channelLoadedState, WidgetChatListModelMessages widgetChatListModelMessages, Channel channel, Map map) {
            return companion.shouldShowStickerGreet(channelLoadedState, widgetChatListModelMessages, channel, map);
        }

        private final Observable<WidgetChatListModel> getChannel(Channel channel) {
            Observable<WidgetChatListModelTop> observable = WidgetChatListModelTop.INSTANCE.get(channel);
            Observable<WidgetChatListModelMessages> observable2 = WidgetChatListModelMessages.INSTANCE.get(channel);
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<WidgetChatListModel> observableM11066c = Observable.m11066c(observable, observable2, observeIsLoadingMessages(companion.getMessagesLoader(), channel.getId()), companion.getChannels().observeNames(), companion.getUsers().observeMeId(), companion.getGuilds().observeComputed(channel.getGuildId()), companion.getGuilds().observeGuild(channel.getGuildId()), companion.getUserRelationships().observe(), ChatListState.INSTANCE.get(channel.getId()), new WidgetChatListModel4(channel));
            Intrinsics3.checkNotNullExpressionValue(observableM11066c, "Observable\n            .…          )\n            }");
            return observableM11066c;
        }

        private final ChatListEntry getGreetMessageItem(WidgetChatListModelMessages messages, Channel channel) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreStickers stickers = companion.getStickers();
            Map<Long, Sticker> stickers2 = stickers.getStickers();
            Long lValueOf = Long.valueOf(WidgetChatListModel.WUMPUS_WAVE_STICKER_ID);
            if (stickers2.get(lValueOf) == null) {
                stickers.fetchStickerPack(WidgetChatListModel.WUMPUS_PACK_ID);
            }
            Sticker sticker = stickers.getStickers().get(lValueOf);
            if (sticker != null) {
                Guild guild = companion.getGuilds().getGuild(channel.getGuildId());
                if (!(((guild != null ? guild.getSystemChannelFlags() : 0) & 8) == 0)) {
                    return null;
                }
                if (messages.getItems().isEmpty()) {
                    return new StickerGreetEntry(sticker, channel.getId(), ChannelUtils.m7679c(channel), channel.getType());
                }
                if (messages.getItems().size() < 25) {
                    return new StickerGreetCompactEntry(sticker, channel.getId(), ChannelUtils.m7679c(channel), channel.getType());
                }
            }
            return null;
        }

        private final Observable<WidgetChatListModel> getThreadDraft(Channel parentChannel, Long parentMessageId) {
            Observable observableM11076j;
            long guildId = parentChannel.getGuildId();
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Map<Long, String>> observableObserveNames = companion.getChannels().observeNames();
            Observable<Long> observableObserveMeId = companion.getUsers().observeMeId();
            Observable<Map<Long, GuildMember>> observableObserveComputed = companion.getGuilds().observeComputed(guildId);
            Observable<Guild> observableObserveGuild = companion.getGuilds().observeGuild(guildId);
            Observable<StoreThreadDraft.ThreadDraftState> observableObserveDraftState = companion.getThreadDraft().observeDraftState();
            Observable<Long> observableObservePermissionsForChannel = companion.getPermissions().observePermissionsForChannel(parentChannel.getId());
            if (parentMessageId != null) {
                Observable<Message> observableObserveMessagesForChannel = companion.getMessages().observeMessagesForChannel(parentChannel.getId(), parentMessageId.longValue());
                Observable<List<ChatListEntry>> singleMessage = WidgetChatListModelMessages.INSTANCE.getSingleMessage(parentChannel, parentMessageId.longValue());
                WidgetChatListModel5 widgetChatListModel5 = WidgetChatListModel5.INSTANCE;
                Object widgetChatListModel8 = widgetChatListModel5;
                if (widgetChatListModel5 != null) {
                    widgetChatListModel8 = new WidgetChatListModel8(widgetChatListModel5);
                }
                observableM11076j = Observable.m11076j(observableObserveMessagesForChannel, singleMessage, (Func2) widgetChatListModel8);
            } else {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
                ScalarSynchronousObservable scalarSynchronousObservable2 = new ScalarSynchronousObservable(new ArrayList());
                WidgetChatListModel6 widgetChatListModel6 = WidgetChatListModel6.INSTANCE;
                Object widgetChatListModel82 = widgetChatListModel6;
                if (widgetChatListModel6 != null) {
                    widgetChatListModel82 = new WidgetChatListModel8(widgetChatListModel6);
                }
                observableM11076j = Observable.m11076j(scalarSynchronousObservable, scalarSynchronousObservable2, (Func2) widgetChatListModel82);
            }
            Observable<WidgetChatListModel> observableM11069e = Observable.m11069e(observableObserveNames, observableObserveMeId, observableObserveComputed, observableObserveGuild, observableObserveDraftState, observableObservePermissionsForChannel, observableM11076j, new WidgetChatListModel7(parentChannel, parentMessageId, guildId));
            Intrinsics3.checkNotNullExpressionValue(observableM11069e, "Observable\n          .co…            )\n          }");
            return observableM11069e;
        }

        private final Observable<StoreMessagesLoader.ChannelLoadedState> observeIsLoadingMessages(StoreMessagesLoader storeMessagesLoader, long j) {
            return storeMessagesLoader.getMessagesLoadedState(j).m11112r();
        }

        private final boolean shouldShowStickerGreet(StoreMessagesLoader.ChannelLoadedState loadingState, WidgetChatListModelMessages messages, Channel channel, Map<Long, Integer> relationships) {
            if (loadingState.isOldestMessagesLoaded() && loadingState.isInitialMessagesLoaded() && loadingState.getNewestSentByUserMessageId() == null && messages.getNewestSentByUserMessageId() == null && messages.getItems().size() < 25 && ChannelUtils.m7689m(channel) && !ChannelUtils.m7670E(channel)) {
                User userM7677a = ChannelUtils.m7677a(channel);
                Integer num = relationships.get(userM7677a != null ? Long.valueOf(userM7677a.getId()) : null);
                if (num == null || num.intValue() != 2) {
                    return true;
                }
            }
            return false;
        }

        public final Observable<WidgetChatListModel> get() {
            Observable observableM11099Y = StoreStream.INSTANCE.getChannelsSelected().observeResolvedSelectedChannel().m11099Y(WidgetChatListModel3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n          .g…            }\n          }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatListModel(long j, long j2, Guild guild, long j3, Map<Long, String> map, long j4, List<? extends ChatListEntry> list, Set<Long> set, long j5, long j6, boolean z2) {
        Intrinsics3.checkNotNullParameter(map, "channelNames");
        Intrinsics3.checkNotNullParameter(list, "list");
        Intrinsics3.checkNotNullParameter(set, "myRoleIds");
        this.userId = j;
        this.channelId = j2;
        this.guild = guild;
        this.guildId = j3;
        this.channelNames = map;
        this.oldestMessageId = j4;
        this.list = list;
        this.myRoleIds = set;
        this.newMessagesMarkerMessageId = j5;
        this.newestKnownMessageId = j6;
        this.isLoadingMessages = z2;
        this.isSpoilerClickAllowed = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChatListModel copy$default(WidgetChatListModel widgetChatListModel, long j, long j2, Guild guild, long j3, Map map, long j4, List list, Set set, long j5, long j6, boolean z2, int i, Object obj) {
        return widgetChatListModel.copy((i & 1) != 0 ? widgetChatListModel.getUserId() : j, (i & 2) != 0 ? widgetChatListModel.getChannelId() : j2, (i & 4) != 0 ? widgetChatListModel.getGuild() : guild, (i & 8) != 0 ? widgetChatListModel.getGuildId() : j3, (i & 16) != 0 ? widgetChatListModel.getChannelNames() : map, (i & 32) != 0 ? widgetChatListModel.getOldestMessageId() : j4, (i & 64) != 0 ? widgetChatListModel.getList() : list, (i & 128) != 0 ? widgetChatListModel.getMyRoleIds() : set, (i & 256) != 0 ? widgetChatListModel.getNewMessagesMarkerMessageId() : j5, (i & 512) != 0 ? widgetChatListModel.newestKnownMessageId : j6, (i & 1024) != 0 ? widgetChatListModel.isLoadingMessages : z2);
    }

    public final long component1() {
        return getUserId();
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getNewestKnownMessageId() {
        return this.newestKnownMessageId;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsLoadingMessages() {
        return this.isLoadingMessages;
    }

    public final long component2() {
        return getChannelId();
    }

    public final Guild component3() {
        return getGuild();
    }

    public final long component4() {
        return getGuildId();
    }

    public final Map<Long, String> component5() {
        return getChannelNames();
    }

    public final long component6() {
        return getOldestMessageId();
    }

    public final List<ChatListEntry> component7() {
        return getList();
    }

    public final Set<Long> component8() {
        return getMyRoleIds();
    }

    public final long component9() {
        return getNewMessagesMarkerMessageId();
    }

    public final WidgetChatListModel copy(long userId, long channelId, Guild guild, long guildId, Map<Long, String> channelNames, long oldestMessageId, List<? extends ChatListEntry> list, Set<Long> myRoleIds, long newMessagesMarkerMessageId, long newestKnownMessageId, boolean isLoadingMessages) {
        Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
        Intrinsics3.checkNotNullParameter(list, "list");
        Intrinsics3.checkNotNullParameter(myRoleIds, "myRoleIds");
        return new WidgetChatListModel(userId, channelId, guild, guildId, channelNames, oldestMessageId, list, myRoleIds, newMessagesMarkerMessageId, newestKnownMessageId, isLoadingMessages);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListModel)) {
            return false;
        }
        WidgetChatListModel widgetChatListModel = (WidgetChatListModel) other;
        return getUserId() == widgetChatListModel.getUserId() && getChannelId() == widgetChatListModel.getChannelId() && Intrinsics3.areEqual(getGuild(), widgetChatListModel.getGuild()) && getGuildId() == widgetChatListModel.getGuildId() && Intrinsics3.areEqual(getChannelNames(), widgetChatListModel.getChannelNames()) && getOldestMessageId() == widgetChatListModel.getOldestMessageId() && Intrinsics3.areEqual(getList(), widgetChatListModel.getList()) && Intrinsics3.areEqual(getMyRoleIds(), widgetChatListModel.getMyRoleIds()) && getNewMessagesMarkerMessageId() == widgetChatListModel.getNewMessagesMarkerMessageId() && this.newestKnownMessageId == widgetChatListModel.newestKnownMessageId && this.isLoadingMessages == widgetChatListModel.isLoadingMessages;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public long getChannelId() {
        return this.channelId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public Map<Long, String> getChannelNames() {
        return this.channelNames;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public Guild getGuild() {
        return this.guild;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public List<ChatListEntry> getList() {
        return this.list;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public Set<Long> getMyRoleIds() {
        return this.myRoleIds;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public long getNewMessagesMarkerMessageId() {
        return this.newMessagesMarkerMessageId;
    }

    public final long getNewestKnownMessageId() {
        return this.newestKnownMessageId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public long getOldestMessageId() {
        return this.oldestMessageId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public long getUserId() {
        return this.userId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v23 */
    public int hashCode() {
        int iM3a = (C0002b.m3a(getChannelId()) + (C0002b.m3a(getUserId()) * 31)) * 31;
        Guild guild = getGuild();
        int iM3a2 = (C0002b.m3a(getGuildId()) + ((iM3a + (guild != null ? guild.hashCode() : 0)) * 31)) * 31;
        Map<Long, String> channelNames = getChannelNames();
        int iM3a3 = (C0002b.m3a(getOldestMessageId()) + ((iM3a2 + (channelNames != null ? channelNames.hashCode() : 0)) * 31)) * 31;
        List<ChatListEntry> list = getList();
        int iHashCode = (iM3a3 + (list != null ? list.hashCode() : 0)) * 31;
        Set<Long> myRoleIds = getMyRoleIds();
        int iM3a4 = (C0002b.m3a(this.newestKnownMessageId) + ((C0002b.m3a(getNewMessagesMarkerMessageId()) + ((iHashCode + (myRoleIds != null ? myRoleIds.hashCode() : 0)) * 31)) * 31)) * 31;
        boolean z2 = this.isLoadingMessages;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return iM3a4 + r0;
    }

    public final boolean isLoadingMessages() {
        return this.isLoadingMessages;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    /* JADX INFO: renamed from: isSpoilerClickAllowed, reason: from getter */
    public boolean getIsSpoilerClickAllowed() {
        return this.isSpoilerClickAllowed;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("WidgetChatListModel(userId=");
        sbM833U.append(getUserId());
        sbM833U.append(", channelId=");
        sbM833U.append(getChannelId());
        sbM833U.append(", guild=");
        sbM833U.append(getGuild());
        sbM833U.append(", guildId=");
        sbM833U.append(getGuildId());
        sbM833U.append(", channelNames=");
        sbM833U.append(getChannelNames());
        sbM833U.append(", oldestMessageId=");
        sbM833U.append(getOldestMessageId());
        sbM833U.append(", list=");
        sbM833U.append(getList());
        sbM833U.append(", myRoleIds=");
        sbM833U.append(getMyRoleIds());
        sbM833U.append(", newMessagesMarkerMessageId=");
        sbM833U.append(getNewMessagesMarkerMessageId());
        sbM833U.append(", newestKnownMessageId=");
        sbM833U.append(this.newestKnownMessageId);
        sbM833U.append(", isLoadingMessages=");
        return outline.m827O(sbM833U, this.isLoadingMessages, ")");
    }

    public /* synthetic */ WidgetChatListModel(long j, long j2, Guild guild, long j3, Map map, long j4, List list, Set set, long j5, long j6, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, guild, j3, map, (i & 32) != 0 ? 0L : j4, list, set, (i & 256) != 0 ? 0L : j5, (i & 512) != 0 ? 0L : j6, z2);
    }
}
