package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.panels.PanelState;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* compiled from: WidgetGuildsList.kt */
/* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$AddGuildHint$Companion$getDismissAction$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildsList5<T, R> implements Func1<PanelState, Boolean> {
    public static final WidgetGuildsList5 INSTANCE = new WidgetGuildsList5();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(PanelState panelState) {
        return call2(panelState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(PanelState panelState) {
        return Boolean.valueOf(Intrinsics3.areEqual(panelState, PanelState.C5578a.f18640a));
    }
}
