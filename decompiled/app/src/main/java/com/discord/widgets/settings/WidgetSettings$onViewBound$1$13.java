package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnections;
import d0.z.d.m;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$13 implements View.OnClickListener {
    public static final WidgetSettings$onViewBound$1$13 INSTANCE = new WidgetSettings$onViewBound$1$13();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsUserConnections.Companion companion = WidgetSettingsUserConnections.INSTANCE;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        companion.launch(context);
    }
}
