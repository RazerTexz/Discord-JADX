package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreThreadDraft;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.SpacerEntry;
import com.discord.widgets.chat.list.entries.ThreadDraftFormEntry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Tuples2;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func7;

/* compiled from: WidgetChatListModel.kt */
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModel$Companion$getThreadDraft$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModel7<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Map<Long, ? extends String>, Long, Map<Long, ? extends GuildMember>, Guild, StoreThreadDraft.ThreadDraftState, Long, Tuples2<? extends Message, ? extends List<? extends ChatListEntry>>, WidgetChatListModel> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Channel $parentChannel;
    public final /* synthetic */ Long $parentMessageId;

    public WidgetChatListModel7(Channel channel, Long l, long j) {
        this.$parentChannel = channel;
        this.$parentMessageId = l;
        this.$guildId = j;
    }

    @Override // p658rx.functions.Func7
    public /* bridge */ /* synthetic */ WidgetChatListModel call(Map<Long, ? extends String> map, Long l, Map<Long, ? extends GuildMember> map2, Guild guild, StoreThreadDraft.ThreadDraftState threadDraftState, Long l2, Tuples2<? extends Message, ? extends List<? extends ChatListEntry>> tuples2) {
        return call2((Map<Long, String>) map, l, (Map<Long, GuildMember>) map2, guild, threadDraftState, l2, (Tuples2<Message, ? extends List<? extends ChatListEntry>>) tuples2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListModel call2(Map<Long, String> map, Long l, Map<Long, GuildMember> map2, Guild guild, StoreThreadDraft.ThreadDraftState threadDraftState, Long l2, Tuples2<Message, ? extends List<? extends ChatListEntry>> tuples2) {
        List<Long> roles;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SpacerEntry(this.$parentChannel.getId()));
        if (threadDraftState.isSending()) {
            arrayList.add(new LoadingEntry());
        }
        arrayList.addAll(tuples2.getSecond());
        Channel channel = this.$parentChannel;
        Long l3 = this.$parentMessageId;
        long guildId = channel.getGuildId();
        Integer defaultAutoArchiveDuration = this.$parentChannel.getDefaultAutoArchiveDuration();
        Intrinsics3.checkNotNullExpressionValue(threadDraftState, "threadDraft");
        ThreadUtils threadUtils = ThreadUtils.INSTANCE;
        arrayList.add(new ThreadDraftFormEntry(channel, l3, guildId, guild, defaultAutoArchiveDuration, threadDraftState, ThreadUtils.canCreatePrivateThread$default(threadUtils, l2, this.$parentChannel, guild, false, 8, null), threadUtils.canCreatePrivateThread(l2, this.$parentChannel, guild, false), threadUtils.canCreatePublicThread(l2, this.$parentChannel, tuples2.getFirst(), guild)));
        GuildMember guildMember = map2.get(l);
        Set setEmptySet = (guildMember == null || (roles = guildMember.getRoles()) == null) ? Sets5.emptySet() : new HashSet(roles);
        Intrinsics3.checkNotNullExpressionValue(l, "myId");
        long jLongValue = l.longValue();
        long j = this.$guildId;
        Intrinsics3.checkNotNullExpressionValue(map, "channelNames");
        return new WidgetChatListModel(jLongValue, -3L, guild, j, map, 0L, arrayList, setEmptySet, 0L, 0L, false, 800, null);
    }
}
