package com.discord.widgets.hubs.events;

import android.view.View;
import com.discord.databinding.WidgetHubEventBinding;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetHubEventsPageViewHolder.kt */
/* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubEventsPageViewHolder2 extends WidgetHubEventsPageViewHolder {
    private final WidgetHubEventBinding binding;
    private final WidgetHubEventsPage3 listener;

    /* compiled from: WidgetHubEventsPageViewHolder.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetHubEventsViewModel2 $eventData;

        public AnonymousClass1(WidgetHubEventsViewModel2 widgetHubEventsViewModel2) {
            this.$eventData = widgetHubEventsViewModel2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEventsPageViewHolder2.this.getListener().onCardClicked(this.$eventData);
        }
    }

    /* compiled from: WidgetHubEventsPageViewHolder.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder$bind$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ WidgetHubEventsViewModel2 $eventData;

        public AnonymousClass2(WidgetHubEventsViewModel2 widgetHubEventsViewModel2) {
            this.$eventData = widgetHubEventsViewModel2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEventsPageViewHolder2.this.getListener().onSecondaryButtonClicked(this.$eventData);
        }
    }

    /* compiled from: WidgetHubEventsPageViewHolder.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder$bind$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ WidgetHubEventsViewModel2 $eventData;

        public AnonymousClass3(WidgetHubEventsViewModel2 widgetHubEventsViewModel2) {
            this.$eventData = widgetHubEventsViewModel2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEventsPageViewHolder2.this.getListener().onPrimaryButtonClicked(this.$eventData);
        }
    }

    /* compiled from: WidgetHubEventsPageViewHolder.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder$bind$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ WidgetHubEventsViewModel2 $eventData;

        public AnonymousClass4(WidgetHubEventsViewModel2 widgetHubEventsViewModel2) {
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
        GuildScheduledEventItemView guildScheduledEventItemView = widgetHubEventBinding.a;
        Intrinsics3.checkNotNullExpressionValue(guildScheduledEventItemView, "binding.root");
        super(guildScheduledEventItemView, null);
        this.binding = widgetHubEventBinding;
        this.listener = widgetHubEventsPage3;
    }

    public final void bind(WidgetHubEventsViewModel2 eventData) {
        Intrinsics3.checkNotNullParameter(eventData, "eventData");
        this.binding.f2474b.configureInDirectoryEventList(eventData, new AnonymousClass1(eventData), new AnonymousClass2(eventData), new AnonymousClass3(eventData), new AnonymousClass4(eventData));
    }

    public final WidgetHubEventBinding getBinding() {
        return this.binding;
    }

    public final WidgetHubEventsPage3 getListener() {
        return this.listener;
    }
}
