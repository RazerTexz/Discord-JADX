package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$$inlined$with$lambda$4 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettings this$0;

    public WidgetSettings$onViewBound$$inlined$with$lambda$4(WidgetSettings widgetSettings) {
        this.this$0 = widgetSettings;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SettingsViewModel settingsViewModelAccess$getViewModel$p = WidgetSettings.access$getViewModel$p(this.this$0);
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "it.context");
        settingsViewModelAccess$getViewModel$p.openRoleSubscriptionsManagement(context);
    }
}
