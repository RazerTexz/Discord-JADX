package com.discord.widgets.settings;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.uri.UriHandler;
import com.discord.views.CheckedSetting;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsBehavior$onViewBound$2$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsBehavior.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBehavior6 implements Action0 {
    public final /* synthetic */ CheckedSetting $this_apply;

    public WidgetSettingsBehavior6(CheckedSetting checkedSetting) {
        this.$this_apply = checkedSetting;
    }

    @Override // p658rx.functions.Action0
    public final void call() {
        UriHandler uriHandler = UriHandler.INSTANCE;
        Context context = this.$this_apply.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        UriHandler.handle$default(uriHandler, context, "https://discord.com/developers/docs/intro", false, false, null, 28, null);
    }
}
