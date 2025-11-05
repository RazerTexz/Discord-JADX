package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import b.a.d.AppScreen2;

/* compiled from: WidgetHubDomains.kt */
/* renamed from: com.discord.widgets.hubs.WidgetHubDomains$onViewBound$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubDomains8 implements View.OnClickListener {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ WidgetHubDomains this$0;

    public WidgetHubDomains8(Context context, WidgetHubDomains widgetHubDomains) {
        this.$context = context;
        this.this$0 = widgetHubDomains;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AppScreen2.g(AppScreen2.g, this.this$0.getParentFragmentManager(), this.$context, WidgetHubWaitlist.class, 0, true, null, new WidgetHubWaitlistViewModel2(this.this$0.getArgs().getEmail()), 40);
    }
}
