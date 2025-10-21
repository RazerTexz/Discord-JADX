package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import com.discord.stores.StoreChangeLog;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$25 implements View.OnClickListener {
    public static final WidgetSettings$onViewBound$1$25 INSTANCE = new WidgetSettings$onViewBound$1$25();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StoreChangeLog changeLog = StoreStream.INSTANCE.getChangeLog();
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "it.context");
        changeLog.openChangeLog(context, true);
    }
}
