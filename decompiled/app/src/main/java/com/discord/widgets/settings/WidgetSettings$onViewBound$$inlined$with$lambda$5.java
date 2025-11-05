package com.discord.widgets.settings;

import android.view.View;
import com.discord.utilities.notifications.NotificationUtils;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$$inlined$with$lambda$5 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettings this$0;

    public WidgetSettings$onViewBound$$inlined$with$lambda$5(WidgetSettings widgetSettings) {
        this.this$0 = widgetSettings;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        NotificationUtils.INSTANCE.showNotificationPage(this.this$0);
    }
}
