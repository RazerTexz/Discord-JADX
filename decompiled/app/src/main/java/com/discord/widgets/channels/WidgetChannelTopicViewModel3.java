package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreUserSettings;
import com.discord.widgets.channels.WidgetChannelTopicViewModel;
import j0.k.Func1;
import java.util.Map;

/* compiled from: WidgetChannelTopicViewModel.kt */
/* renamed from: com.discord.widgets.channels.WidgetChannelTopicViewModel$Companion$mapChannelToPrivateStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel3<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends GuildMember>>, WidgetChannelTopicViewModel.StoreState> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetChannelTopicViewModel.Companion.NavState $navState;
    public final /* synthetic */ StoreUserSettings $storeUserSettings;

    public WidgetChannelTopicViewModel3(Channel channel, StoreUserSettings storeUserSettings, WidgetChannelTopicViewModel.Companion.NavState navState) {
        this.$channel = channel;
        this.$storeUserSettings = storeUserSettings;
        this.$navState = navState;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ WidgetChannelTopicViewModel.StoreState call(Map<Long, ? extends Map<Long, ? extends GuildMember>> map) {
        return call2((Map<Long, ? extends Map<Long, GuildMember>>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelTopicViewModel.StoreState call2(Map<Long, ? extends Map<Long, GuildMember>> map) {
        return new WidgetChannelTopicViewModel.StoreState.DM(this.$channel, map.values(), this.$storeUserSettings.getIsDeveloperMode(), this.$navState.isRightPanelOpened(), this.$navState.isOnHomeTab());
    }
}
