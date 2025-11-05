package com.discord.widgets.hubs.events;

import android.view.View;
import com.discord.widgets.hubs.events.HubEventsPage;

/* compiled from: WidgetHubEventsPageViewHolder.kt */
/* loaded from: classes2.dex */
public final class WidgetHubEventsPageFooterViewHolder$bind$$inlined$apply$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ HubEventsPage.Footer $footer$inlined;
    public final /* synthetic */ WidgetHubEventsPageFooterViewHolder this$0;

    public WidgetHubEventsPageFooterViewHolder$bind$$inlined$apply$lambda$1(WidgetHubEventsPageFooterViewHolder widgetHubEventsPageFooterViewHolder, HubEventsPage.Footer footer) {
        this.this$0 = widgetHubEventsPageFooterViewHolder;
        this.$footer$inlined = footer;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.getListener().fetchGuildScheduledEvents();
    }
}
