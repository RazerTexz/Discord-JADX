package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.panels.PanelState;
import d0.z.d.Intrinsics3;
import j0.k.Func1;

/* compiled from: WidgetGuildsListViewModel.kt */
/* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$4, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildsListViewModel5<T, R> implements Func1<PanelState, Boolean> {
    public static final WidgetGuildsListViewModel5 INSTANCE = new WidgetGuildsListViewModel5();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(PanelState panelState) {
        return call2(panelState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(PanelState panelState) {
        return Boolean.valueOf(Intrinsics3.areEqual(panelState, PanelState.c.a));
    }
}
