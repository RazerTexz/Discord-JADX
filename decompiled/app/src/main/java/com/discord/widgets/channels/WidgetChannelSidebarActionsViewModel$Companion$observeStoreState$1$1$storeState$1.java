package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.user.MeUser;
import com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel;
import com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1;
import java.util.Map;
import rx.functions.Func3;

/* compiled from: WidgetChannelSidebarActionsViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1$1$storeState$1<T1, T2, T3, R> implements Func3<Map<Long, ? extends ModelNotificationSettings>, MeUser, Channel, WidgetChannelSidebarActionsViewModel.StoreState.ChannelFound> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1.AnonymousClass1 this$0;

    public WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1$1$storeState$1(WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1.AnonymousClass1 anonymousClass1, Channel channel) {
        this.this$0 = anonymousClass1;
        this.$channel = channel;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetChannelSidebarActionsViewModel.StoreState.ChannelFound call(Map<Long, ? extends ModelNotificationSettings> map, MeUser meUser, Channel channel) {
        return call2(map, meUser, channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelSidebarActionsViewModel.StoreState.ChannelFound call2(Map<Long, ? extends ModelNotificationSettings> map, MeUser meUser, Channel channel) {
        boolean zIsGuildNsfwGateAgreed = WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1.this.$storeGuildNSFW.isGuildNsfwGateAgreed(this.$channel.getGuildId());
        Channel channel2 = this.$channel;
        return new WidgetChannelSidebarActionsViewModel.StoreState.ChannelFound(channel2, channel, (ModelNotificationSettings) a.c(channel2, map), this.$channel.getNsfw() && (!zIsGuildNsfwGateAgreed || meUser.getNsfwAllowance() == NsfwAllowance.DISALLOWED));
    }
}
