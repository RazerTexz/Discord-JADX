package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.servers.SettingsChannelListAdapter;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import rx.functions.Func7;

/* compiled from: WidgetServerSettingsChannels.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsChannels$Model$Companion$get$1<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<MeUser, Long, Guild, Map<Long, ? extends Channel>, List<? extends Channel>, Map<Long, ? extends Long>, Integer, WidgetServerSettingsChannels.Model> {
    public static final WidgetServerSettingsChannels$Model$Companion$get$1 INSTANCE = new WidgetServerSettingsChannels$Model$Companion$get$1();

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ WidgetServerSettingsChannels.Model call(MeUser meUser, Long l, Guild guild, Map<Long, ? extends Channel> map, List<? extends Channel> list, Map<Long, ? extends Long> map2, Integer num) {
        return call2(meUser, l, guild, (Map<Long, Channel>) map, (List<Channel>) list, (Map<Long, Long>) map2, num);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d6  */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WidgetServerSettingsChannels.Model call2(MeUser meUser, Long l, Guild guild, Map<Long, Channel> map, List<Channel> list, Map<Long, Long> map2, Integer num) {
        List list2;
        List list3;
        HashSet hashSet;
        if (guild == null || l == null || map2 == null) {
            return null;
        }
        WidgetServerSettingsChannels.Model.Companion companion = WidgetServerSettingsChannels.Model.INSTANCE;
        m.checkNotNullExpressionValue(map, "guildChannels");
        m.checkNotNullExpressionValue(num, "sortType");
        LinkedHashMap<Long, Channel> sortedGuildChannels = companion.getSortedGuildChannels(map, num.intValue());
        boolean z2 = num.intValue() != -1;
        long j = 16;
        boolean zCanAndIsElevated = PermissionUtils.canAndIsElevated(16L, l, meUser.getMfaEnabled(), guild.getMfaLevel());
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashSet hashSet2 = new HashSet();
        if (!z2 || zCanAndIsElevated) {
            hashSet2.add(0L);
            linkedHashMap.put(0L, new ArrayList());
            List list4 = (List) linkedHashMap.get(0L);
            if (list4 != null) {
                list4.add(new SettingsChannelListAdapter.CategoryItem(null, 0L, 0, false, false, true));
            }
        }
        Collections.sort(list, ChannelUtils.h(Channel.INSTANCE));
        for (Channel channel : list) {
            if (PermissionUtils.hasAccess(channel, map2) || channel.getId() == 0) {
                ArrayList arrayList2 = new ArrayList();
                boolean zCan = PermissionUtils.can(j, (Long) a.d(channel, map2));
                if (zCan || zCanAndIsElevated) {
                    hashSet2.add(Long.valueOf(channel.getId()));
                }
                if (!z2 || zCan) {
                    hashSet = hashSet2;
                    arrayList2.add(new SettingsChannelListAdapter.CategoryItem(ChannelUtils.c(channel), channel.getId(), channel.getPosition(), num.intValue() == 4, zCanAndIsElevated, zCan));
                    linkedHashMap.put(Long.valueOf(channel.getId()), arrayList2);
                } else {
                    hashSet = hashSet2;
                }
            }
            hashSet2 = hashSet;
            j = 16;
        }
        HashSet hashSet3 = hashSet2;
        if (hashSet3.isEmpty()) {
            return null;
        }
        ArrayList<SettingsChannelListAdapter.ChannelItem> arrayList3 = new ArrayList();
        ArrayList<SettingsChannelListAdapter.ChannelItem> arrayList4 = new ArrayList();
        Iterator<Channel> it = sortedGuildChannels.values().iterator();
        while (it.hasNext()) {
            Channel next = it.next();
            m.checkNotNullExpressionValue(next, "channel");
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            Iterator<Channel> it2 = it;
            LinkedHashMap<Long, Channel> linkedHashMap3 = sortedGuildChannels;
            HashSet hashSet4 = hashSet3;
            SettingsChannelListAdapter.ChannelItem channelItem = new SettingsChannelListAdapter.ChannelItem(next, z2, next.getParentId(), hashSet3.contains(Long.valueOf(next.getParentId())));
            if (!z2 || hashSet4.contains(Long.valueOf(next.getParentId()))) {
                if (ChannelUtils.v(next) && PermissionUtils.hasAccess(next, map2)) {
                    arrayList3.add(channelItem);
                } else if (ChannelUtils.w(next) && PermissionUtils.hasAccess(next, map2)) {
                    arrayList4.add(channelItem);
                }
            }
            hashSet3 = hashSet4;
            linkedHashMap = linkedHashMap2;
            it = it2;
            sortedGuildChannels = linkedHashMap3;
        }
        LinkedHashMap<Long, Channel> linkedHashMap4 = sortedGuildChannels;
        LinkedHashMap linkedHashMap5 = linkedHashMap;
        for (SettingsChannelListAdapter.ChannelItem channelItem2 : arrayList3) {
            if (linkedHashMap5.containsKey(Long.valueOf(channelItem2.getChannel().getParentId())) && (list3 = (List) linkedHashMap5.get(Long.valueOf(channelItem2.getChannel().getParentId()))) != null) {
                list3.add(channelItem2);
            }
        }
        for (SettingsChannelListAdapter.ChannelItem channelItem3 : arrayList4) {
            if (linkedHashMap5.containsKey(Long.valueOf(channelItem3.getChannel().getParentId())) && (list2 = (List) linkedHashMap5.get(Long.valueOf(channelItem3.getChannel().getParentId()))) != null) {
                list2.add(channelItem3);
            }
        }
        for (List list5 : linkedHashMap5.values()) {
            m.checkNotNullExpressionValue(list5, "list");
            arrayList.addAll(list5);
        }
        return new WidgetServerSettingsChannels.Model(guild, arrayList, z2, linkedHashMap4, map2);
    }
}
