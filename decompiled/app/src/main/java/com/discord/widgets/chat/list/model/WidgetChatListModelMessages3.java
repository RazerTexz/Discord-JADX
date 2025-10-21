package com.discord.widgets.chat.list.model;

import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages;
import d0.t.Collections2;
import d0.t.ReversedViews3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function10;

/* compiled from: WidgetChatListModelMessages.kt */
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelMessages$Companion$getSingleMessage$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModelMessages3 extends Lambda implements Function10<Message, WidgetChatListModelMessages.MessagesWithMetadata, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Boolean, Boolean, Long, Boolean, InviteEmbedModel, Boolean, List<? extends ChatListEntry>> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ long $messageId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListModelMessages3(Channel channel, long j) {
        super(10);
        this.$channel = channel;
        this.$messageId = j;
    }

    @Override // kotlin.jvm.functions.Function10
    public /* bridge */ /* synthetic */ List<? extends ChatListEntry> invoke(Message message, WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Map<Long, ? extends GuildMember> map, Map<Long, ? extends GuildRole> map2, Boolean bool, Boolean bool2, Long l, Boolean bool3, InviteEmbedModel inviteEmbedModel, Boolean bool4) {
        return invoke(message, messagesWithMetadata, (Map<Long, GuildMember>) map, (Map<Long, GuildRole>) map2, bool.booleanValue(), bool2.booleanValue(), l.longValue(), bool3.booleanValue(), inviteEmbedModel, bool4.booleanValue());
    }

    public final List<ChatListEntry> invoke(Message message, WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, boolean z2, boolean z3, long j, boolean z4, InviteEmbedModel inviteEmbedModel, boolean z5) {
        Intrinsics3.checkNotNullParameter(messagesWithMetadata, "messagesWithMetadata");
        Intrinsics3.checkNotNullParameter(map2, "guildRoles");
        Intrinsics3.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
        if (message != null) {
            WidgetChatListModelMessages.Companion companion = WidgetChatListModelMessages.INSTANCE;
            Channel channel = this.$channel;
            Intrinsics3.checkNotNullExpressionValue(map, "guildMembers");
            List<ChatListEntry> listAsReversed = ReversedViews3.asReversed(WidgetChatListModelMessages.Companion.getMessageItems$default(companion, channel, map, map2, new HashMap(), null, null, message, messagesWithMetadata.getMessageState().get(Long.valueOf(this.$messageId)), messagesWithMetadata.getMessageReplyState(), false, false, null, z2, z3, z4, j, false, new HashMap(), inviteEmbedModel, false, z5, 524288, null));
            if (listAsReversed != null) {
                return listAsReversed;
            }
        }
        return Collections2.emptyList();
    }
}
