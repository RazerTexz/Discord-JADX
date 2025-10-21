package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import com.discord.widgets.settings.premium.WidgetSettingsGifting;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$8 implements View.OnClickListener {
    public static final WidgetSettings$onViewBound$1$8 INSTANCE = new WidgetSettings$onViewBound$1$8();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsGifting.Companion companion = WidgetSettingsGifting.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "it.context");
        WidgetSettingsGifting.Companion.launch$default(companion, context, null, 2, null);
    }
}
