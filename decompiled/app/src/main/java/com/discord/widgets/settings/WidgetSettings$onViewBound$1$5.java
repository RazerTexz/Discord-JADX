package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import d0.z.d.m;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$5 implements View.OnClickListener {
    public static final WidgetSettings$onViewBound$1$5 INSTANCE = new WidgetSettings$onViewBound$1$5();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        WidgetSettingsPremium.Companion.launch$default(companion, context, null, null, 6, null);
    }
}
