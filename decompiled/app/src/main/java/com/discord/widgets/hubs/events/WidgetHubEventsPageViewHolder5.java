package com.discord.widgets.hubs.events;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.databinding.WidgetHubEventsHeaderBinding;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetHubEventsPageViewHolder.kt */
/* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPageHeaderViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubEventsPageViewHolder5 extends WidgetHubEventsPageViewHolder {
    private final WidgetHubEventsHeaderBinding binding;
    private final WidgetHubEventsPage3 listener;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHubEventsPageViewHolder5(WidgetHubEventsHeaderBinding widgetHubEventsHeaderBinding, WidgetHubEventsPage3 widgetHubEventsPage3) {
        Intrinsics3.checkNotNullParameter(widgetHubEventsHeaderBinding, "binding");
        Intrinsics3.checkNotNullParameter(widgetHubEventsPage3, "listener");
        ConstraintLayout constraintLayout = widgetHubEventsHeaderBinding.f17183a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        super(constraintLayout, null);
        this.binding = widgetHubEventsHeaderBinding;
        this.listener = widgetHubEventsPage3;
    }

    public final void bind() {
        this.binding.f17184b.setOnClickListener(new WidgetHubEventsPageViewHolder6(this));
    }

    public final WidgetHubEventsHeaderBinding getBinding() {
        return this.binding;
    }

    public final WidgetHubEventsPage3 getListener() {
        return this.listener;
    }
}
