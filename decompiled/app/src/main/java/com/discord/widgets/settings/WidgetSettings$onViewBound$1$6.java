package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$6 implements View.OnClickListener {
    public static final WidgetSettings$onViewBound$1$6 INSTANCE = new WidgetSettings$onViewBound$1$6();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsGuildBoost.Companion companion = WidgetSettingsGuildBoost.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "it.context");
        companion.launch(context);
    }
}
