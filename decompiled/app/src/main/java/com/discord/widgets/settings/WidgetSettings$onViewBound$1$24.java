package com.discord.widgets.settings;

import android.view.View;
import b.d.b.a.a;
import com.discord.utilities.uri.UriHandler;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$24 implements View.OnClickListener {
    public static final WidgetSettings$onViewBound$1$24 INSTANCE = new WidgetSettings$onViewBound$1$24();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, a.x(view, "it", "it.context"), "https://discord.com/acknowledgements", false, false, null, 28, null);
    }
}
