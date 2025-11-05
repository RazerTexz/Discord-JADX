package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import com.discord.widgets.settings.WidgetSettingsLanguage;
import d0.z.d.m;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$17 implements View.OnClickListener {
    public static final WidgetSettings$onViewBound$1$17 INSTANCE = new WidgetSettings$onViewBound$1$17();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsLanguage.Companion companion = WidgetSettingsLanguage.INSTANCE;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        companion.launch(context);
    }
}
