package com.discord.widgets.hubs;

import android.view.View;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescription$configureUI$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription4 implements View.OnClickListener {
    public final /* synthetic */ WidgetHubDescriptionViewModel3 $state$inlined;
    public final /* synthetic */ WidgetHubDescription this$0;

    public WidgetHubDescription4(WidgetHubDescription widgetHubDescription, WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
        this.this$0 = widgetHubDescription;
        this.$state$inlined = widgetHubDescriptionViewModel3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetHubDescription.access$maybeAddServer(this.this$0);
    }
}
