package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter;
import com.discord.utilities.mg_recycler.DragAndDropAdapter;
import com.discord.widgets.servers.SettingsChannelListAdapter;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rx.functions.Func3;

/* compiled from: WidgetServerNotificationsOverrideSelector.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerNotificationsOverrideSelector$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerNotificationsOverrideSelector2<T1, T2, T3, R> implements Func3<Map<Long, ? extends Channel>, GuildChannelsInfo, String, List<? extends CategoricalDragAndDropAdapter.Payload>> {
    public static final WidgetServerNotificationsOverrideSelector2 INSTANCE = new WidgetServerNotificationsOverrideSelector2();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ List<? extends CategoricalDragAndDropAdapter.Payload> call(Map<Long, ? extends Channel> map, GuildChannelsInfo guildChannelsInfo, String str) {
        return call2((Map<Long, Channel>) map, guildChannelsInfo, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<CategoricalDragAndDropAdapter.Payload> call2(Map<Long, Channel> map, GuildChannelsInfo guildChannelsInfo, String str) {
        boolean z2;
        Intrinsics3.checkNotNullExpressionValue(map, "channels");
        List<Channel> sortedVisibleChannels = guildChannelsInfo.getSortedVisibleChannels(map);
        ArrayList<Channel> arrayList = new ArrayList();
        for (Object obj : sortedVisibleChannels) {
            Channel channel = (Channel) obj;
            if (ChannelUtils.F(channel) || ChannelUtils.k(channel)) {
                String strC = ChannelUtils.c(channel);
                Intrinsics3.checkNotNullExpressionValue(str, "filter");
                z2 = Strings4.contains((CharSequence) strC, (CharSequence) str, true);
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Channel channel2 : arrayList) {
            DragAndDropAdapter.Payload categoryItem = ChannelUtils.k(channel2) ? new SettingsChannelListAdapter.CategoryItem(ChannelUtils.c(channel2), channel2.getId(), channel2.getPosition(), false, false, false) : ChannelUtils.F(channel2) ? new SettingsChannelListAdapter.ChannelItem(channel2, false, channel2.getParentId(), false) : null;
            if (categoryItem != null) {
                arrayList2.add(categoryItem);
            }
        }
        return arrayList2;
    }
}
