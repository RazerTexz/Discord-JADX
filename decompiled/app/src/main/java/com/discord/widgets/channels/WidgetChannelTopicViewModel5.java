package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.tabs.NavigationTab;
import p637j0.p641k.Func1;

/* compiled from: WidgetChannelTopicViewModel.kt */
/* renamed from: com.discord.widgets.channels.WidgetChannelTopicViewModel$Companion$observeNavState$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel5<T, R> implements Func1<NavigationTab, Boolean> {
    public static final WidgetChannelTopicViewModel5 INSTANCE = new WidgetChannelTopicViewModel5();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(NavigationTab navigationTab) {
        return call2(navigationTab);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(NavigationTab navigationTab) {
        return Boolean.valueOf(navigationTab == NavigationTab.HOME);
    }
}
