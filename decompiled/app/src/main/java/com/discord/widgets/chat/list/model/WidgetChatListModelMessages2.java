package com.discord.widgets.chat.list.model;

import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.widgets.botuikit.ComponentChatListState;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages;
import d0.t.Collections2;
import d0.t._Collections;
import d0.t._CollectionsJvm;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function15;

/* compiled from: WidgetChatListModelMessages.kt */
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelMessages$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModelMessages2 extends Lambda implements Function15<WidgetChatListModelMessages.MessagesWithMetadata, Channel, Map<Long, ? extends Integer>, List<? extends Long>, Map<Long, ? extends GuildMember>, Long, Map<Long, ? extends GuildRole>, Long, Boolean, Boolean, Boolean, Long, Map<Long, ? extends ComponentChatListState.ComponentStoreState>, InviteEmbedModel, Boolean, WidgetChatListModelMessages> {
    public final /* synthetic */ Channel $channel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListModelMessages2(Channel channel) {
        super(15);
        this.$channel = channel;
    }

    @Override // kotlin.jvm.functions.Function15
    public /* bridge */ /* synthetic */ WidgetChatListModelMessages invoke(WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Channel channel, Map<Long, ? extends Integer> map, List<? extends Long> list, Map<Long, ? extends GuildMember> map2, Long l, Map<Long, ? extends GuildRole> map3, Long l2, Boolean bool, Boolean bool2, Boolean bool3, Long l3, Map<Long, ? extends ComponentChatListState.ComponentStoreState> map4, InviteEmbedModel inviteEmbedModel, Boolean bool4) {
        return invoke(messagesWithMetadata, channel, (Map<Long, Integer>) map, (List<Long>) list, (Map<Long, GuildMember>) map2, l, (Map<Long, GuildRole>) map3, l2, bool.booleanValue(), bool2.booleanValue(), bool3.booleanValue(), l3.longValue(), (Map<Long, ComponentChatListState.ComponentStoreState>) map4, inviteEmbedModel, bool4.booleanValue());
    }

    public final WidgetChatListModelMessages invoke(WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Channel channel, Map<Long, Integer> map, List<Long> list, Map<Long, GuildMember> map2, Long l, Map<Long, GuildRole> map3, Long l2, boolean z2, boolean z3, boolean z4, long j, Map<Long, ComponentChatListState.ComponentStoreState> map4, InviteEmbedModel inviteEmbedModel, boolean z5) {
        Object next;
        boolean zContainsKey;
        boolean zContains;
        Message message;
        Message message2;
        Message message3;
        WidgetChatListModelMessages.Companion companion;
        String str;
        WidgetChatListModelMessages.Items items;
        WidgetChatListModelMessages.Items items2;
        WidgetChatListModelMessages2 widgetChatListModelMessages2 = this;
        WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata2 = messagesWithMetadata;
        Map<Long, Integer> map5 = map;
        Intrinsics3.checkNotNullParameter(messagesWithMetadata2, "messagesWithMetadata");
        Intrinsics3.checkNotNullParameter(map5, "blockedRelationships");
        Intrinsics3.checkNotNullParameter(list, "blockedExpanded");
        Intrinsics3.checkNotNullParameter(map3, "guildRoles");
        Intrinsics3.checkNotNullParameter(map4, "componentStoreState");
        Intrinsics3.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
        WidgetChatListModelMessages.Items items3 = new WidgetChatListModelMessages.Items(messagesWithMetadata.getMessages().size());
        long j2 = 0;
        Message message4 = null;
        Message message5 = null;
        int i = 0;
        int iAccess$addBlockedMessage = 0;
        boolean z6 = false;
        boolean zAccess$tryAddNewMessagesSeparator = false;
        for (Object obj : messagesWithMetadata.getMessages()) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            Message message6 = (Message) obj;
            WidgetChatListModelMessages.Companion companion2 = WidgetChatListModelMessages.INSTANCE;
            UtcDateTime timestamp = message6.getTimestamp();
            if (WidgetChatListModelMessages.Companion.access$willAddTimestamp(companion2, timestamp != null ? timestamp.getDateTimeMillis() : 0L, j2)) {
                iAccess$addBlockedMessage = WidgetChatListModelMessages.Companion.access$addBlockedMessage(companion2, items3, message4, iAccess$addBlockedMessage, z6);
            }
            long id2 = message6.getId();
            UtcDateTime timestamp2 = message6.getTimestamp();
            long jAccess$tryAddTimestamp = WidgetChatListModelMessages.Companion.access$tryAddTimestamp(companion2, items3, id2, timestamp2 != null ? timestamp2.getDateTimeMillis() : 0L, j2);
            boolean z7 = i == messagesWithMetadata.getMessages().size() - 1;
            Integer type = message6.getType();
            if (type != null && type.intValue() == 21) {
                User author = ((Message) WidgetChatListModelMessages.Companion.access$getThreadStarterMessageAndChannel(companion2, channel, widgetChatListModelMessages2.$channel, message6, messagesWithMetadata2).getFirst()).getAuthor();
                zContainsKey = map5.containsKey(author != null ? Long.valueOf(author.getId()) : null);
            } else {
                User author2 = message6.getAuthor();
                zContainsKey = map5.containsKey(author2 != null ? Long.valueOf(author2.getId()) : null);
            }
            if (zContainsKey && (iAccess$addBlockedMessage = iAccess$addBlockedMessage + 1) == 1) {
                zContains = list.contains(Long.valueOf(message6.getId()));
                message = message6;
            } else {
                zContains = z6;
                message = message4;
            }
            int iAccess$addBlockedMessage2 = (!zContainsKey || z7) ? WidgetChatListModelMessages.Companion.access$addBlockedMessage(companion2, items3, message, iAccess$addBlockedMessage, zContains) : iAccess$addBlockedMessage;
            boolean z8 = (zContainsKey || !zContains) ? zContains : false;
            if (!zContainsKey || z8) {
                boolean zAccess$shouldConcatMessage = WidgetChatListModelMessages.Companion.access$shouldConcatMessage(companion2, items3, message6, message5);
                items3.setConcatCount(zAccess$shouldConcatMessage ? items3.getConcatCount() + 1 : 0);
                Integer type2 = message6.getType();
                if (type2 != null && type2.intValue() == 21) {
                    Channel channel2 = widgetChatListModelMessages2.$channel;
                    Intrinsics3.checkNotNullExpressionValue(map2, "guildMembers");
                    message2 = message;
                    WidgetChatListModelMessages.Items items4 = items3;
                    message3 = message6;
                    companion = companion2;
                    str = "newMessagesMarkerMessageId";
                    items4.addItems(companion2.getThreadStarterMessageItems(channel, channel2, map2, map3, map, message6, messagesWithMetadata, z2, z3, z4, j, true, map4, inviteEmbedModel));
                    items = items4;
                } else {
                    message2 = message;
                    message3 = message6;
                    companion = companion2;
                    str = "newMessagesMarkerMessageId";
                    Channel channel3 = widgetChatListModelMessages2.$channel;
                    Intrinsics3.checkNotNullExpressionValue(map2, "guildMembers");
                    items = items3;
                    items.addItems(WidgetChatListModelMessages.Companion.getMessageItems$default(companion, channel3, map2, map3, map, messagesWithMetadata.getMessageThreads().get(Long.valueOf(message3.getId())), messagesWithMetadata.getThreadCountsAndLatestMessages().get(Long.valueOf(message3.getId())), message3, messagesWithMetadata.getMessageState().get(Long.valueOf(message3.getId())), messagesWithMetadata.getMessageReplyState(), z8, zAccess$shouldConcatMessage, l2, z2, z3, z4, j, true, map4, inviteEmbedModel, false, z5, 524288, null));
                }
            } else {
                message2 = message;
                items = items3;
                message3 = message6;
                companion = companion2;
                str = "newMessagesMarkerMessageId";
            }
            if (zAccess$tryAddNewMessagesSeparator) {
                items2 = items;
                widgetChatListModelMessages2 = this;
            } else {
                Intrinsics3.checkNotNullExpressionValue(l, str);
                items2 = items;
                widgetChatListModelMessages2 = this;
                zAccess$tryAddNewMessagesSeparator = WidgetChatListModelMessages.Companion.access$tryAddNewMessagesSeparator(companion, items2, l.longValue(), z7, message3.getId(), widgetChatListModelMessages2.$channel);
            }
            messagesWithMetadata2 = messagesWithMetadata;
            map5 = map;
            items3 = items2;
            i = i2;
            j2 = jAccess$tryAddTimestamp;
            iAccess$addBlockedMessage = iAccess$addBlockedMessage2;
            z6 = z8;
            message4 = message2;
            message5 = message3;
        }
        WidgetChatListModelMessages.Items items5 = items3;
        _CollectionsJvm.reverse(items5.getItems());
        List<ChatListEntry> items6 = items5.getItems();
        Message message7 = (Message) _Collections.firstOrNull((List) messagesWithMetadata.getMessages());
        long id3 = message7 != null ? message7.getId() : 0L;
        Message message8 = (Message) _Collections.lastOrNull((List) messagesWithMetadata.getMessages());
        long id4 = message8 != null ? message8.getId() : 0L;
        Intrinsics3.checkNotNullExpressionValue(l, "newMessagesMarkerMessageId");
        long jLongValue = l.longValue();
        Iterator<T> it = messagesWithMetadata.getMessages().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            User author3 = ((Message) next).getAuthor();
            if (author3 != null && author3.getId() == j) {
                break;
            }
        }
        Message message9 = (Message) next;
        return new WidgetChatListModelMessages(items6, id3, id4, map2, jLongValue, message9 != null ? Long.valueOf(message9.getId()) : null);
    }
}
