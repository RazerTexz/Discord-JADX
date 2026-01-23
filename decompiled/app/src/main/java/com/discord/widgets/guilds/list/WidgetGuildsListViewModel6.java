package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.tabs.NavigationTab;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$5, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel6<T, R> implements Func1<NavigationTab, Boolean> {
    public static final WidgetGuildsListViewModel6 INSTANCE = new WidgetGuildsListViewModel6();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(NavigationTab navigationTab) {
        return call2(navigationTab);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(NavigationTab navigationTab) {
        return Boolean.valueOf(navigationTab == NavigationTab.HOME);
    }
}
