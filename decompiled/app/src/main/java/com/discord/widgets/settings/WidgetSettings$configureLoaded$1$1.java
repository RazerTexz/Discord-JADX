package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import com.discord.widgets.settings.developer.WidgetSettingsDeveloper;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$configureLoaded$1$1 implements View.OnClickListener {
    public static final WidgetSettings$configureLoaded$1$1 INSTANCE = new WidgetSettings$configureLoaded$1$1();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsDeveloper.Companion companion = WidgetSettingsDeveloper.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "it.context");
        companion.launch(context);
    }
}
