package com.discord.widgets.hubs.events;

import android.view.View;

/* compiled from: WidgetHubEventsPageViewHolder.kt */
/* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPageHeaderViewHolder$bind$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubEventsPageViewHolder6 implements View.OnClickListener {
    public final /* synthetic */ WidgetHubEventsPageViewHolder5 this$0;

    public WidgetHubEventsPageViewHolder6(WidgetHubEventsPageViewHolder5 widgetHubEventsPageViewHolder5) {
        this.this$0 = widgetHubEventsPageViewHolder5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.getListener().dismissHeader();
    }
}
