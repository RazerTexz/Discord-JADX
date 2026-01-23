package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import com.discord.widgets.settings.WidgetSettingsAppearance;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$14 implements View.OnClickListener {
    public static final WidgetSettings$onViewBound$1$14 INSTANCE = new WidgetSettings$onViewBound$1$14();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAppearance.Companion companion = WidgetSettingsAppearance.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "it.context");
        companion.launch(context);
    }
}
