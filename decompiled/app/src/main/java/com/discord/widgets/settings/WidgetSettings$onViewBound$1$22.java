package com.discord.widgets.settings;

import android.view.View;
import com.discord.utilities.uri.UriHandler;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$22 implements View.OnClickListener {
    public static final WidgetSettings$onViewBound$1$22 INSTANCE = new WidgetSettings$onViewBound$1$22();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, outline.m885x(view, "it", "it.context"), "https://support.discord.com", false, false, null, 28, null);
    }
}
