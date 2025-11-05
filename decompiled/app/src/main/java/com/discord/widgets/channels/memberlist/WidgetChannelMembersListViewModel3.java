package com.discord.widgets.channels.memberlist;

import androidx.core.app.NotificationCompat;
import com.discord.panels.PanelState;
import d0.z.d.Intrinsics3;
import j0.k.Func1;

/* compiled from: WidgetChannelMembersListViewModel.kt */
/* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$isPanelOpenObservable$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel3<T, R> implements Func1<PanelState, Boolean> {
    public static final WidgetChannelMembersListViewModel3 INSTANCE = new WidgetChannelMembersListViewModel3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(PanelState panelState) {
        return call2(panelState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(PanelState panelState) {
        return Boolean.valueOf(Intrinsics3.areEqual(panelState, PanelState.c.a));
    }
}
