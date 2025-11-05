package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildsSorted;
import com.discord.utilities.streams.StreamContext;
import com.discord.widgets.guilds.list.WidgetGuildsListViewModel;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.functions.Func9;

/* compiled from: WidgetGuildsListViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildsListViewModel$Companion$observeStores$6<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<WidgetGuildsListViewModel.Companion.Chunk, WidgetGuildsListViewModel.Companion.SecondChunk, Set<? extends Long>, Set<? extends Long>, Boolean, Map<Long, ? extends StreamContext>, Map<Long, ? extends Long>, Boolean, Boolean, WidgetGuildsListViewModel.StoreState> {
    public static final WidgetGuildsListViewModel$Companion$observeStores$6 INSTANCE = new WidgetGuildsListViewModel$Companion$observeStores$6();

    @Override // rx.functions.Func9
    public /* bridge */ /* synthetic */ WidgetGuildsListViewModel.StoreState call(WidgetGuildsListViewModel.Companion.Chunk chunk, WidgetGuildsListViewModel.Companion.SecondChunk secondChunk, Set<? extends Long> set, Set<? extends Long> set2, Boolean bool, Map<Long, ? extends StreamContext> map, Map<Long, ? extends Long> map2, Boolean bool2, Boolean bool3) {
        return call2(chunk, secondChunk, (Set<Long>) set, (Set<Long>) set2, bool, (Map<Long, StreamContext>) map, (Map<Long, Long>) map2, bool2, bool3);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildsListViewModel.StoreState call2(WidgetGuildsListViewModel.Companion.Chunk chunk, WidgetGuildsListViewModel.Companion.SecondChunk secondChunk, Set<Long> set, Set<Long> set2, Boolean bool, Map<Long, StreamContext> map, Map<Long, Long> map2, Boolean bool2, Boolean bool3) {
        long selectedGuildId = chunk.getSelectedGuildId();
        long selectedVoiceChannelId = chunk.getSelectedVoiceChannelId();
        Map<Long, ModelNotificationSettings> guildSettings = chunk.getGuildSettings();
        Set<Long> unreadGuildIds = chunk.getUnreadGuildIds();
        Map<Long, Integer> mentionCounts = chunk.getMentionCounts();
        Map<Long, List<Long>> channelIds = chunk.getChannelIds();
        Set<Long> unavailableGuilds = chunk.getUnavailableGuilds();
        Map<Long, Channel> privateChannels = chunk.getPrivateChannels();
        List<StoreGuildsSorted.Entry> sortedGuilds = chunk.getSortedGuilds();
        Map<Long, GuildJoinRequest> guildJoinRequests = secondChunk.getGuildJoinRequests();
        List<Guild> pendingGuilds = secondChunk.getPendingGuilds();
        Set<Long> guildIds = secondChunk.getGuildIds();
        m.checkNotNullExpressionValue(set, "lurkingGuildIds");
        Set<Long> guildIdsWithActiveStageEvents = secondChunk.getGuildIdsWithActiveStageEvents();
        Set<Long> guildIdsWithActiveScheduledEvents = secondChunk.getGuildIdsWithActiveScheduledEvents();
        Map<Long, Channel> channels = secondChunk.getChannels();
        m.checkNotNullExpressionValue(set2, "openFolderIds");
        m.checkNotNullExpressionValue(bool, "isNewUser");
        boolean zBooleanValue = bool.booleanValue();
        m.checkNotNullExpressionValue(map, "allApplicationStreamContexts");
        m.checkNotNullExpressionValue(map2, "allChannelPermissions");
        m.checkNotNullExpressionValue(bool2, "isLeftPanelOpened");
        boolean zBooleanValue2 = bool2.booleanValue();
        m.checkNotNullExpressionValue(bool3, "isOnHomeTab");
        return new WidgetGuildsListViewModel.StoreState(selectedGuildId, selectedVoiceChannelId, guildSettings, unreadGuildIds, mentionCounts, channelIds, unavailableGuilds, privateChannels, sortedGuilds, guildJoinRequests, pendingGuilds, guildIds, set, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, channels, set2, zBooleanValue, map, map2, zBooleanValue2, bool3.booleanValue(), secondChunk.getShowHubSparkle());
    }
}
