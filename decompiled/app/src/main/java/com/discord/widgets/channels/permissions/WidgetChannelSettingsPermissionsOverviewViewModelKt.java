package com.discord.widgets.channels.permissions;

import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverviewViewModel;
import d0.t.m;
import d0.t.n;

/* compiled from: WidgetChannelSettingsPermissionsOverviewViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverviewViewModelKt {
    public static final /* synthetic */ WidgetChannelSettingsPermissionsOverviewViewModel.ViewState access$generateInitialViewState(boolean z2) {
        return generateInitialViewState(z2);
    }

    private static final WidgetChannelSettingsPermissionsOverviewViewModel.ViewState generateInitialViewState(boolean z2) {
        if (z2) {
            WidgetChannelSettingsPermissionsOverviewViewModel.Tab tab = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.MODERATOR;
            return new WidgetChannelSettingsPermissionsOverviewViewModel.ViewState(tab, n.listOf((Object[]) new WidgetChannelSettingsPermissionsOverviewViewModel.Tab[]{tab, WidgetChannelSettingsPermissionsOverviewViewModel.Tab.ADVANCED}));
        }
        WidgetChannelSettingsPermissionsOverviewViewModel.Tab tab2 = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.ADVANCED;
        return new WidgetChannelSettingsPermissionsOverviewViewModel.ViewState(tab2, m.listOf(tab2));
    }
}
