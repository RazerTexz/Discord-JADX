package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.widgets.servers.NotificationsOverridesAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p507d0.p512d0._Ranges;
import p507d0.p580t.Iterables2;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func3;

/* compiled from: WidgetServerNotifications.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerNotifications$Companion$getNotificationOverrides$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerNotifications3<T1, T2, T3, R> implements Func3<List<ModelNotificationSettings.ChannelOverride>, Map<Long, ? extends Channel>, GuildChannelsInfo, List<? extends NotificationsOverridesAdapter.Item>> {
    public static final WidgetServerNotifications3 INSTANCE = new WidgetServerNotifications3();

    @Override // p658rx.functions.Func3
    public /* bridge */ /* synthetic */ List<? extends NotificationsOverridesAdapter.Item> call(List<ModelNotificationSettings.ChannelOverride> list, Map<Long, ? extends Channel> map, GuildChannelsInfo guildChannelsInfo) {
        return call2(list, (Map<Long, Channel>) map, guildChannelsInfo);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<NotificationsOverridesAdapter.Item> call2(List<ModelNotificationSettings.ChannelOverride> list, Map<Long, Channel> map, GuildChannelsInfo guildChannelsInfo) {
        Intrinsics3.checkNotNullExpressionValue(map, "guildChannels");
        List<Channel> sortedVisibleChannels = guildChannelsInfo.getSortedVisibleChannels(map);
        Intrinsics3.checkNotNullExpressionValue(list, "channelOverrides");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ModelNotificationSettings.ChannelOverride channelOverride = (ModelNotificationSettings.ChannelOverride) next;
            Intrinsics3.checkNotNullExpressionValue(channelOverride, "it");
            if (channelOverride.getMessageNotifications() != ModelNotificationSettings.FREQUENCY_UNSET || channelOverride.isMuted()) {
                arrayList.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            ModelNotificationSettings.ChannelOverride channelOverride2 = (ModelNotificationSettings.ChannelOverride) obj;
            Intrinsics3.checkNotNullExpressionValue(channelOverride2, "override");
            linkedHashMap.put(Long.valueOf(channelOverride2.getChannelId()), obj);
        }
        ArrayList<Channel> arrayList2 = new ArrayList();
        for (Object obj2 : sortedVisibleChannels) {
            Channel channel = (Channel) obj2;
            if (ChannelUtils.m7687k(channel) || ChannelUtils.m7671F(channel)) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Channel channel2 : arrayList2) {
            ModelNotificationSettings.ChannelOverride channelOverride3 = (ModelNotificationSettings.ChannelOverride) linkedHashMap.get(Long.valueOf(channel2.getId()));
            NotificationsOverridesAdapter.Item item = channelOverride3 != null ? new NotificationsOverridesAdapter.Item(channel2, map.get(Long.valueOf(channel2.getParentId())), channelOverride3) : null;
            if (item != null) {
                arrayList3.add(item);
            }
        }
        return arrayList3;
    }
}
