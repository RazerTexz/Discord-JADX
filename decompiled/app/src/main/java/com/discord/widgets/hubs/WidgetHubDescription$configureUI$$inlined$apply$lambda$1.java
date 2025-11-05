package com.discord.widgets.hubs;

import android.view.View;

/* compiled from: WidgetHubDescription.kt */
/* loaded from: classes2.dex */
public final class WidgetHubDescription$configureUI$$inlined$apply$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ HubDescriptionState $state$inlined;
    public final /* synthetic */ WidgetHubDescription this$0;

    public WidgetHubDescription$configureUI$$inlined$apply$lambda$1(WidgetHubDescription widgetHubDescription, HubDescriptionState hubDescriptionState) {
        this.this$0 = widgetHubDescription;
        this.$state$inlined = hubDescriptionState;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetHubDescription.access$maybeAddServer(this.this$0);
    }
}
