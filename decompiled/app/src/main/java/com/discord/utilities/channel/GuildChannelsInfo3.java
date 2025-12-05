package com.discord.utilities.channel;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.channel.ChannelUtils4;
import java.util.Comparator;
import java.util.Map;

/* compiled from: GuildChannelsInfo.kt */
/* renamed from: com.discord.utilities.channel.GuildChannelsInfo$getSortedCategories$sortedCategories$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildChannelsInfo3<T> implements Comparator<Long> {
    public final /* synthetic */ Map $guildChannels;

    public GuildChannelsInfo3(Map map) {
        this.$guildChannels = map;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Long l, Long l2) {
        return compare2(l, l2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(Long l, Long l2) {
        return ((ChannelUtils4) ChannelUtils.m7684h(Channel.INSTANCE)).compare(this.$guildChannels.get(l), this.$guildChannels.get(l2));
    }
}
