package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import com.discord.widgets.settings.WidgetSettingsAuthorizedApps;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$11 implements View.OnClickListener {
    public static final WidgetSettings$onViewBound$1$11 INSTANCE = new WidgetSettings$onViewBound$1$11();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAuthorizedApps.Companion companion = WidgetSettingsAuthorizedApps.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "it.context");
        companion.launch(context);
    }
}
