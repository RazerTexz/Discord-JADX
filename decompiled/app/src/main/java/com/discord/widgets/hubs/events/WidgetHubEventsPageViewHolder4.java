package com.discord.widgets.hubs.events;

import android.view.View;
import com.discord.widgets.hubs.events.WidgetHubEventsPageAdapter2;

/* compiled from: WidgetHubEventsPageViewHolder.kt */
/* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPageFooterViewHolder$bind$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubEventsPageViewHolder4 implements View.OnClickListener {
    public final /* synthetic */ WidgetHubEventsPageAdapter2.Footer $footer$inlined;
    public final /* synthetic */ WidgetHubEventsPageViewHolder3 this$0;

    public WidgetHubEventsPageViewHolder4(WidgetHubEventsPageViewHolder3 widgetHubEventsPageViewHolder3, WidgetHubEventsPageAdapter2.Footer footer) {
        this.this$0 = widgetHubEventsPageViewHolder3;
        this.$footer$inlined = footer;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.getListener().fetchGuildScheduledEvents();
    }
}
