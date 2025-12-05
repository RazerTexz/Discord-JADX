package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreMessagesLoader;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.SpacerEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func9;

/* compiled from: WidgetChatListModel.kt */
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModel$Companion$getChannel$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModel4<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<WidgetChatListModelTop, WidgetChatListModelMessages, StoreMessagesLoader.ChannelLoadedState, Map<Long, ? extends String>, Long, Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends Integer>, WidgetChatListModel.ChatListState, WidgetChatListModel> {
    public final /* synthetic */ Channel $channel;

    public WidgetChatListModel4(Channel channel) {
        this.$channel = channel;
    }

    @Override // p658rx.functions.Func9
    public /* bridge */ /* synthetic */ WidgetChatListModel call(WidgetChatListModelTop widgetChatListModelTop, WidgetChatListModelMessages widgetChatListModelMessages, StoreMessagesLoader.ChannelLoadedState channelLoadedState, Map<Long, ? extends String> map, Long l, Map<Long, ? extends GuildMember> map2, Guild guild, Map<Long, ? extends Integer> map3, WidgetChatListModel.ChatListState chatListState) {
        return call2(widgetChatListModelTop, widgetChatListModelMessages, channelLoadedState, (Map<Long, String>) map, l, (Map<Long, GuildMember>) map2, guild, (Map<Long, Integer>) map3, chatListState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListModel call2(WidgetChatListModelTop widgetChatListModelTop, WidgetChatListModelMessages widgetChatListModelMessages, StoreMessagesLoader.ChannelLoadedState channelLoadedState, Map<Long, String> map, Long l, Map<Long, GuildMember> map2, Guild guild, Map<Long, Integer> map3, WidgetChatListModel.ChatListState chatListState) {
        ChatListEntry chatListEntryAccess$getGreetMessageItem;
        List<Long> roles;
        WidgetChatListModel.Companion companion = WidgetChatListModel.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(channelLoadedState, "loadingState");
        Intrinsics3.checkNotNullExpressionValue(widgetChatListModelMessages, "messages");
        Channel channel = this.$channel;
        Intrinsics3.checkNotNullExpressionValue(map3, "relationships");
        boolean zAccess$shouldShowStickerGreet = WidgetChatListModel.Companion.access$shouldShowStickerGreet(companion, channelLoadedState, widgetChatListModelMessages, channel, map3);
        int size = widgetChatListModelMessages.getItems().size() + 2;
        if (zAccess$shouldShowStickerGreet) {
            size++;
        }
        ArrayList arrayList = new ArrayList(size);
        if (chatListState == WidgetChatListModel.ChatListState.DETACHED) {
            arrayList.add(new LoadingEntry());
        } else {
            arrayList.add(new SpacerEntry(this.$channel.getId()));
            if (zAccess$shouldShowStickerGreet && (chatListEntryAccess$getGreetMessageItem = WidgetChatListModel.Companion.access$getGreetMessageItem(companion, widgetChatListModelMessages, this.$channel)) != null) {
                arrayList.add(chatListEntryAccess$getGreetMessageItem);
            }
        }
        arrayList.addAll(widgetChatListModelMessages.getItems());
        arrayList.add(widgetChatListModelTop.getItem());
        GuildMember guildMember = map2.get(l);
        Set setEmptySet = (guildMember == null || (roles = guildMember.getRoles()) == null) ? Sets5.emptySet() : new HashSet(roles);
        Intrinsics3.checkNotNullExpressionValue(l, "myId");
        long jLongValue = l.longValue();
        long id2 = this.$channel.getId();
        long guildId = this.$channel.getGuildId();
        Intrinsics3.checkNotNullExpressionValue(map, "channelNames");
        return new WidgetChatListModel(jLongValue, id2, guild, guildId, map, widgetChatListModelMessages.getOldestMessageId(), arrayList, setEmptySet, widgetChatListModelMessages.getNewMessagesMarkerMessageId(), widgetChatListModelMessages.getNewestKnownMessageId(), channelLoadedState.isLoadingMessages());
    }
}
