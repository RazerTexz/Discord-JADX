package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.panels.PanelState;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import rx.Observable;

/* compiled from: WidgetChannelSidebarActionsViewModel.kt */
/* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSidebarActionsViewModel2<T, R> implements Func1<PanelState, Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState>> {
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
    public final /* synthetic */ StoreGuildsNsfw $storeGuildNSFW;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreUserGuildSettings $storeUserGuildSettings;

    /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Channel, Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState>> {
        public final /* synthetic */ PanelState $panelState;

        public AnonymousClass1(PanelState panelState) {
            this.$panelState = panelState;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState> call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState> call2(Channel channel) {
            Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState> scalarSynchronousObservable = channel == null ? new ScalarSynchronousObservable<>(WidgetChannelSidebarActionsViewModel.StoreState.ChannelNotFound.INSTANCE) : Observable.i(WidgetChannelSidebarActionsViewModel2.this.$storeUserGuildSettings.observeGuildSettings(), StoreUser.observeMe$default(WidgetChannelSidebarActionsViewModel2.this.$storeUser, false, 1, null), WidgetChannelSidebarActionsViewModel2.this.$storeChannels.observeChannel(channel.getParentId()), new WidgetChannelSidebarActionsViewModel3(this, channel));
            return Intrinsics3.areEqual(this.$panelState, PanelState.c.a) ? scalarSynchronousObservable : scalarSynchronousObservable.Z(1);
        }
    }

    public WidgetChannelSidebarActionsViewModel2(StoreChannelsSelected storeChannelsSelected, StoreUserGuildSettings storeUserGuildSettings, StoreUser storeUser, StoreChannels storeChannels, StoreGuildsNsfw storeGuildsNsfw) {
        this.$storeChannelsSelected = storeChannelsSelected;
        this.$storeUserGuildSettings = storeUserGuildSettings;
        this.$storeUser = storeUser;
        this.$storeChannels = storeChannels;
        this.$storeGuildNSFW = storeGuildsNsfw;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState> call(PanelState panelState) {
        return call2(panelState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState> call2(PanelState panelState) {
        return this.$storeChannelsSelected.observeSelectedChannel().Y(new AnonymousClass1(panelState));
    }
}
