package com.discord.widgets.user.search;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.functions.Func4;

/* compiled from: WidgetGlobalSearchModel.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$get$guildsListObservable$1<T1, T2, T3, T4, R> implements Func4<WidgetGlobalSearchModel.SearchContext, WidgetGlobalSearchModel.ChannelContext, Map<Long, ? extends ModelNotificationSettings>, LinkedHashMap<Long, Guild>, WidgetGlobalSearchGuildsModel> {
    public static final WidgetGlobalSearchModel$Companion$get$guildsListObservable$1 INSTANCE = new WidgetGlobalSearchModel$Companion$get$guildsListObservable$1();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetGlobalSearchGuildsModel call(WidgetGlobalSearchModel.SearchContext searchContext, WidgetGlobalSearchModel.ChannelContext channelContext, Map<Long, ? extends ModelNotificationSettings> map, LinkedHashMap<Long, Guild> linkedHashMap) {
        return call2(searchContext, channelContext, map, linkedHashMap);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchGuildsModel call2(WidgetGlobalSearchModel.SearchContext searchContext, WidgetGlobalSearchModel.ChannelContext channelContext, Map<Long, ? extends ModelNotificationSettings> map, LinkedHashMap<Long, Guild> linkedHashMap) {
        WidgetGlobalSearchGuildsModel.Companion companion = WidgetGlobalSearchGuildsModel.INSTANCE;
        List<Long> recentGuildIds = searchContext.getRecentGuildIds();
        long selectedVoiceChannelId = searchContext.getSelectedVoiceChannelId();
        Set<Long> unreadGuildIds = channelContext.getUnreadGuildIds();
        Map<Long, Integer> mentionCounts = searchContext.getMentionCounts();
        Map<Long, Channel> channelsPrivate = channelContext.getChannelsPrivate();
        m.checkNotNullExpressionValue(linkedHashMap, "sortedGuilds");
        Map<Long, List<Long>> guildToChannels = channelContext.getGuildToChannels();
        m.checkNotNullExpressionValue(map, "guildSettings");
        return companion.create(recentGuildIds, selectedVoiceChannelId, unreadGuildIds, mentionCounts, channelsPrivate, linkedHashMap, guildToChannels, map);
    }
}
