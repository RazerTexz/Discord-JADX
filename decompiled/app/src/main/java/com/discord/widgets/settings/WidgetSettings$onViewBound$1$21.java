package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import com.discord.widgets.settings.WidgetSettingsVoice;
import d0.z.d.m;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$21 implements View.OnClickListener {
    public static final WidgetSettings$onViewBound$1$21 INSTANCE = new WidgetSettings$onViewBound$1$21();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsVoice.Companion companion = WidgetSettingsVoice.INSTANCE;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        WidgetSettingsVoice.Companion.launch$default(companion, context, null, false, 6, null);
    }
}
