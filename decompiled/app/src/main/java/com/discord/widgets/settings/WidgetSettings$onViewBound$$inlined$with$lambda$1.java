package com.discord.widgets.settings;

import android.view.View;
import com.discord.widgets.user.WidgetUserStatusSheet;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$$inlined$with$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettings this$0;

    public WidgetSettings$onViewBound$$inlined$with$lambda$1(WidgetSettings widgetSettings) {
        this.this$0 = widgetSettings;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetUserStatusSheet.INSTANCE.show(this.this$0);
    }
}
