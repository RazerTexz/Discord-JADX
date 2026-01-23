package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.panels.PanelState;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelTopicViewModel$Companion$observeNavState$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel4<T, R> implements Func1<PanelState, Boolean> {
    public static final WidgetChannelTopicViewModel4 INSTANCE = new WidgetChannelTopicViewModel4();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(PanelState panelState) {
        return call2(panelState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(PanelState panelState) {
        return Boolean.valueOf(Intrinsics3.areEqual(panelState, PanelState.C5580c.f18642a));
    }
}
