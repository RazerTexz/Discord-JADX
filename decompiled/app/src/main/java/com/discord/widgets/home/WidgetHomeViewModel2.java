package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import com.discord.panels.PanelState;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreUserConnections;
import com.discord.widgets.home.WidgetHomeViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func8;

/* compiled from: WidgetHomeViewModel.kt */
/* renamed from: com.discord.widgets.home.WidgetHomeViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHomeViewModel2<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<PanelState, PanelState, WidgetHomeViewModel.GuildInfo, MeUser, StoreChannelsSelected.ResolvedSelectedChannel, Experiment, StoreUserConnections.State, Experiment, WidgetHomeViewModel.StoreState> {
    public static final WidgetHomeViewModel2 INSTANCE = new WidgetHomeViewModel2();

    @Override // p658rx.functions.Func8
    public /* bridge */ /* synthetic */ WidgetHomeViewModel.StoreState call(PanelState panelState, PanelState panelState2, WidgetHomeViewModel.GuildInfo guildInfo, MeUser meUser, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Experiment experiment, StoreUserConnections.State state, Experiment experiment2) {
        return call2(panelState, panelState2, guildInfo, meUser, resolvedSelectedChannel, experiment, state, experiment2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetHomeViewModel.StoreState call2(PanelState panelState, PanelState panelState2, WidgetHomeViewModel.GuildInfo guildInfo, MeUser meUser, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Experiment experiment, StoreUserConnections.State state, Experiment experiment2) {
        StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel2;
        NsfwAllowance nsfwAllowance;
        Channel maybeChannel = resolvedSelectedChannel.getMaybeChannel();
        boolean z2 = maybeChannel != null && maybeChannel.getNsfw();
        if (meUser != null) {
            nsfwAllowance = meUser.getNsfwAllowance();
            resolvedSelectedChannel2 = resolvedSelectedChannel;
        } else {
            resolvedSelectedChannel2 = resolvedSelectedChannel;
            nsfwAllowance = null;
        }
        if (!(resolvedSelectedChannel2 instanceof StoreChannelsSelected.ResolvedSelectedChannel.Channel)) {
            resolvedSelectedChannel2 = null;
        }
        StoreChannelsSelected.ResolvedSelectedChannel.Channel channel = (StoreChannelsSelected.ResolvedSelectedChannel.Channel) resolvedSelectedChannel2;
        boolean z3 = (channel != null ? channel.getPeekParent() : null) != null;
        Intrinsics3.checkNotNullExpressionValue(panelState, "leftPanelState");
        Intrinsics3.checkNotNullExpressionValue(panelState2, "rightPanelState");
        Intrinsics3.checkNotNullExpressionValue(guildInfo, "guildInfo");
        Intrinsics3.checkNotNullExpressionValue(meUser, "me");
        boolean z4 = experiment != null && experiment.getBucket() == 1;
        long guildId = guildInfo.getGuildId();
        Intrinsics3.checkNotNullExpressionValue(state, "connectedAccounts");
        return new WidgetHomeViewModel.StoreState(panelState, panelState2, guildInfo, meUser, z3, z4, z2, nsfwAllowance, guildId, state);
    }
}
