package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.channel.ChannelUtils3;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreMessagesMostRecent;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.stores.StoreUserPresence;
import com.discord.widgets.channels.list.items.ChannelListBottomNavSpaceItem;
import com.discord.widgets.channels.list.items.ChannelListItemPrivate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* compiled from: WidgetChannelListModel.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$getPrivateChannelList$1<T, R> implements Func1<Unit, WidgetChannelListModel> {
    public final /* synthetic */ StoreApplicationStreaming $storeApplicationStreaming;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
    public final /* synthetic */ StoreUserConnections $storeConnections;
    public final /* synthetic */ StoreExperiments $storeExperiments;
    public final /* synthetic */ StoreMentions $storeMentions;
    public final /* synthetic */ StoreMessagesMostRecent $storeMessagesMostRecent;
    public final /* synthetic */ StoreUserPresence $storePresences;
    public final /* synthetic */ StoreUserGuildSettings $storeUserGuildSettings;

    public WidgetChannelListModel$Companion$getPrivateChannelList$1(StoreChannels storeChannels, StoreMessagesMostRecent storeMessagesMostRecent, StoreChannelsSelected storeChannelsSelected, StoreUserPresence storeUserPresence, StoreMentions storeMentions, StoreApplicationStreaming storeApplicationStreaming, StoreUserGuildSettings storeUserGuildSettings, StoreExperiments storeExperiments, StoreUserConnections storeUserConnections) {
        this.$storeChannels = storeChannels;
        this.$storeMessagesMostRecent = storeMessagesMostRecent;
        this.$storeChannelsSelected = storeChannelsSelected;
        this.$storePresences = storeUserPresence;
        this.$storeMentions = storeMentions;
        this.$storeApplicationStreaming = storeApplicationStreaming;
        this.$storeUserGuildSettings = storeUserGuildSettings;
        this.$storeExperiments = storeExperiments;
        this.$storeConnections = storeUserConnections;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ WidgetChannelListModel call(Unit unit) {
        return call2(unit);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelListModel call2(Unit unit) {
        Map<Long, Channel> channelsForGuild = this.$storeChannels.getChannelsForGuild(0L);
        Channel.Companion companion = Channel.INSTANCE;
        Map<Long, Long> mostRecentIds = this.$storeMessagesMostRecent.getMostRecentIds();
        Intrinsics3.checkNotNullParameter(companion, "$this$getSortByMostRecent");
        Intrinsics3.checkNotNullParameter(mostRecentIds, "mostRecentMessageIds");
        ChannelUtils3 channelUtils3 = new ChannelUtils3(mostRecentIds);
        long id2 = this.$storeChannelsSelected.getId();
        Map<Long, Presence> mapM11396getPresences = this.$storePresences.m11396getPresences();
        Map<Long, Integer> mentionCounts = this.$storeMentions.getMentionCounts();
        Map<Long, ModelApplicationStream> streamsByUser = this.$storeApplicationStreaming.getStreamsByUser();
        ModelNotificationSettings modelNotificationSettings = this.$storeUserGuildSettings.getGuildSettings().get(0L);
        if (modelNotificationSettings == null) {
            modelNotificationSettings = new ModelNotificationSettings();
        }
        this.$storeExperiments.getUserExperiment("2021-04_contact_sync_android_main", true);
        this.$storeConnections.getStateSnapshot();
        List listSortedWith = _Collections.sortedWith(channelsForGuild.values(), channelUtils3);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listSortedWith, 10));
        Iterator<T> it = listSortedWith.iterator();
        while (true) {
            if (!it.hasNext()) {
                return new WidgetChannelListModel(null, _Collections.plus((Collection<? extends ChannelListBottomNavSpaceItem>) arrayList, new ChannelListBottomNavSpaceItem(0L, 1, null)), false, false, arrayList.isEmpty(), null, 44, null);
            }
            Channel channel = (Channel) it.next();
            User userM7677a = ChannelUtils.m7677a(channel);
            Presence presence = mapM11396getPresences.get(userM7677a != null ? Long.valueOf(userM7677a.getId()) : null);
            boolean z2 = channel.getId() == id2;
            Integer num = (Integer) outline.m845d(channel, mentionCounts);
            int iIntValue = num != null ? num.intValue() : 0;
            User userM7677a2 = ChannelUtils.m7677a(channel);
            boolean zContainsKey = streamsByUser.containsKey(userM7677a2 != null ? Long.valueOf(userM7677a2.getId()) : null);
            ModelNotificationSettings.ChannelOverride channelOverride = modelNotificationSettings.getChannelOverride(channel.getId());
            arrayList.add(new ChannelListItemPrivate(channel, presence, z2, iIntValue, zContainsKey, channelOverride != null ? channelOverride.isMuted() : false));
        }
    }
}
