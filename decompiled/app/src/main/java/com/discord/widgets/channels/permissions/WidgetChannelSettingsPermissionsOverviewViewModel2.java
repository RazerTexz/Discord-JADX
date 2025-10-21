package com.discord.widgets.channels.permissions;

import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverviewViewModel;
import d0.t.Collections2;
import d0.t.CollectionsJVM;

/* compiled from: WidgetChannelSettingsPermissionsOverviewViewModel.kt */
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverviewViewModelKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverviewViewModel2 {
    public static final /* synthetic */ WidgetChannelSettingsPermissionsOverviewViewModel.ViewState access$generateInitialViewState(boolean z2) {
        return generateInitialViewState(z2);
    }

    private static final WidgetChannelSettingsPermissionsOverviewViewModel.ViewState generateInitialViewState(boolean z2) {
        if (z2) {
            WidgetChannelSettingsPermissionsOverviewViewModel.Tab tab = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.MODERATOR;
            return new WidgetChannelSettingsPermissionsOverviewViewModel.ViewState(tab, Collections2.listOf((Object[]) new WidgetChannelSettingsPermissionsOverviewViewModel.Tab[]{tab, WidgetChannelSettingsPermissionsOverviewViewModel.Tab.ADVANCED}));
        }
        WidgetChannelSettingsPermissionsOverviewViewModel.Tab tab2 = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.ADVANCED;
        return new WidgetChannelSettingsPermissionsOverviewViewModel.ViewState(tab2, CollectionsJVM.listOf(tab2));
    }
}
