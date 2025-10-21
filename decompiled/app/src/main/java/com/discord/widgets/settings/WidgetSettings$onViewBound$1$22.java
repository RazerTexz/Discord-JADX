package com.discord.widgets.settings;

import android.view.View;
import b.d.b.a.outline;
import com.discord.utilities.uri.UriHandler;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$22 implements View.OnClickListener {
    public static final WidgetSettings$onViewBound$1$22 INSTANCE = new WidgetSettings$onViewBound$1$22();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, outline.x(view, "it", "it.context"), "https://support.discord.com", false, false, null, 28, null);
    }
}
