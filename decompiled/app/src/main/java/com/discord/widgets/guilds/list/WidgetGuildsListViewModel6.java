package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.tabs.NavigationTab;
import j0.k.Func1;

/* compiled from: WidgetGuildsListViewModel.kt */
/* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$5, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildsListViewModel6<T, R> implements Func1<NavigationTab, Boolean> {
    public static final WidgetGuildsListViewModel6 INSTANCE = new WidgetGuildsListViewModel6();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(NavigationTab navigationTab) {
        return call2(navigationTab);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(NavigationTab navigationTab) {
        return Boolean.valueOf(navigationTab == NavigationTab.HOME);
    }
}
