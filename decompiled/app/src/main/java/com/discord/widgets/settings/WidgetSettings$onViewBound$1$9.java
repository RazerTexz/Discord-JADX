package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import d0.z.d.m;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$9 implements View.OnClickListener {
    public static final WidgetSettings$onViewBound$1$9 INSTANCE = new WidgetSettings$onViewBound$1$9();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAccount.Companion companion = WidgetSettingsAccount.INSTANCE;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        WidgetSettingsAccount.Companion.launch$default(companion, context, false, null, 6, null);
    }
}
