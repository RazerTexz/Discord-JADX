package com.discord.widgets.auth;

import android.view.View;
import com.discord.app.AppActivity;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$onViewBound$$inlined$forEach$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize8 implements View.OnClickListener {
    public final /* synthetic */ WidgetOauth2Authorize this$0;

    public WidgetOauth2Authorize8(WidgetOauth2Authorize widgetOauth2Authorize) {
        this.this$0 = widgetOauth2Authorize;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Exception {
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.onBackPressed();
        }
    }
}
