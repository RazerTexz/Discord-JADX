package com.discord.widgets.hubs.events;

import android.view.View;
import com.discord.databinding.WidgetHubEventBinding;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetHubEventsPageViewHolder.kt */
/* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubEventsPageViewHolder2 extends WidgetHubEventsPageViewHolder {
    private final WidgetHubEventBinding binding;
    private final WidgetHubEventsPage3 listener;

    /* compiled from: WidgetHubEventsPageViewHolder.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder$bind$1 */
    public static final class ViewOnClickListenerC90491 implements View.OnClickListener {
        public final /* synthetic */ WidgetHubEventsViewModel2 $eventData;

        public ViewOnClickListenerC90491(WidgetHubEventsViewModel2 widgetHubEventsViewModel2) {
            this.$eventData = widgetHubEventsViewModel2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEventsPageViewHolder2.this.getListener().onCardClicked(this.$eventData);
        }
    }

    /* compiled from: WidgetHubEventsPageViewHolder.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder$bind$2 */
    public static final class ViewOnClickListenerC90502 implements View.OnClickListener {
        public final /* synthetic */ WidgetHubEventsViewModel2 $eventData;

        public ViewOnClickListenerC90502(WidgetHubEventsViewModel2 widgetHubEventsViewModel2) {
            this.$eventData = widgetHubEventsViewModel2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEventsPageViewHolder2.this.getListener().onSecondaryButtonClicked(this.$eventData);
        }
    }

    /* compiled from: WidgetHubEventsPageViewHolder.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder$bind$3 */
    public static final class ViewOnClickListenerC90513 implements View.OnClickListener {
        public final /* synthetic */ WidgetHubEventsViewModel2 $eventData;

        public ViewOnClickListenerC90513(WidgetHubEventsViewModel2 widgetHubEventsViewModel2) {
            this.$eventData = widgetHubEventsViewModel2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEventsPageViewHolder2.this.getListener().onPrimaryButtonClicked(this.$eventData);
        }
    }

    /* compiled from: WidgetHubEventsPageViewHolder.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder$bind$4 */
    public static final class ViewOnClickListenerC90524 implements View.OnClickListener {
        public final /* synthetic */ WidgetHubEventsViewModel2 $eventData;

        public ViewOnClickListenerC90524(WidgetHubEventsViewModel2 widgetHubEventsViewModel2) {
            this.$eventData = widgetHubEventsViewModel2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEventsPageViewHolder2.this.getListener().onShareClicked(this.$eventData);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHubEventsPageViewHolder2(WidgetHubEventBinding widgetHubEventBinding, WidgetHubEventsPage3 widgetHubEventsPage3) {
        Intrinsics3.checkNotNullParameter(widgetHubEventBinding, "binding");
        Intrinsics3.checkNotNullParameter(widgetHubEventsPage3, "listener");
        GuildScheduledEventItemView guildScheduledEventItemView = widgetHubEventBinding.f17179a;
        Intrinsics3.checkNotNullExpressionValue(guildScheduledEventItemView, "binding.root");
        super(guildScheduledEventItemView, null);
        this.binding = widgetHubEventBinding;
        this.listener = widgetHubEventsPage3;
    }

    public final void bind(WidgetHubEventsViewModel2 eventData) {
        Intrinsics3.checkNotNullParameter(eventData, "eventData");
        this.binding.f17180b.configureInDirectoryEventList(eventData, new ViewOnClickListenerC90491(eventData), new ViewOnClickListenerC90502(eventData), new ViewOnClickListenerC90513(eventData), new ViewOnClickListenerC90524(eventData));
    }

    public final WidgetHubEventBinding getBinding() {
        return this.binding;
    }

    public final WidgetHubEventsPage3 getListener() {
        return this.listener;
    }
}
