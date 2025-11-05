package com.discord.widgets.hubs.events;

import android.content.res.Resources;
import android.view.View;
import com.discord.databinding.WidgetHubEventBinding;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import d0.z.d.m;

/* compiled from: WidgetHubEventsPageViewHolder.kt */
/* loaded from: classes2.dex */
public final class WidgetHubEventViewHolder extends WidgetHubEventsPageViewHolder {
    private final WidgetHubEventBinding binding;
    private final HubEventsEventListener listener;

    /* compiled from: WidgetHubEventsPageViewHolder.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ HubGuildScheduledEventData $eventData;

        public AnonymousClass1(HubGuildScheduledEventData hubGuildScheduledEventData) {
            this.$eventData = hubGuildScheduledEventData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEventViewHolder.this.getListener().onCardClicked(this.$eventData);
        }
    }

    /* compiled from: WidgetHubEventsPageViewHolder.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder$bind$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ HubGuildScheduledEventData $eventData;

        public AnonymousClass2(HubGuildScheduledEventData hubGuildScheduledEventData) {
            this.$eventData = hubGuildScheduledEventData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEventViewHolder.this.getListener().onSecondaryButtonClicked(this.$eventData);
        }
    }

    /* compiled from: WidgetHubEventsPageViewHolder.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder$bind$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ HubGuildScheduledEventData $eventData;

        public AnonymousClass3(HubGuildScheduledEventData hubGuildScheduledEventData) {
            this.$eventData = hubGuildScheduledEventData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEventViewHolder.this.getListener().onPrimaryButtonClicked(this.$eventData);
        }
    }

    /* compiled from: WidgetHubEventsPageViewHolder.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder$bind$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ HubGuildScheduledEventData $eventData;

        public AnonymousClass4(HubGuildScheduledEventData hubGuildScheduledEventData) {
            this.$eventData = hubGuildScheduledEventData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEventViewHolder.this.getListener().onShareClicked(this.$eventData);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHubEventViewHolder(WidgetHubEventBinding widgetHubEventBinding, HubEventsEventListener hubEventsEventListener) {
        m.checkNotNullParameter(widgetHubEventBinding, "binding");
        m.checkNotNullParameter(hubEventsEventListener, "listener");
        GuildScheduledEventItemView guildScheduledEventItemView = widgetHubEventBinding.a;
        m.checkNotNullExpressionValue(guildScheduledEventItemView, "binding.root");
        super(guildScheduledEventItemView, null);
        this.binding = widgetHubEventBinding;
        this.listener = hubEventsEventListener;
    }

    public final void bind(HubGuildScheduledEventData eventData) throws Resources.NotFoundException {
        m.checkNotNullParameter(eventData, "eventData");
        this.binding.f2474b.configureInDirectoryEventList(eventData, new AnonymousClass1(eventData), new AnonymousClass2(eventData), new AnonymousClass3(eventData), new AnonymousClass4(eventData));
    }

    public final WidgetHubEventBinding getBinding() {
        return this.binding;
    }

    public final HubEventsEventListener getListener() {
        return this.listener;
    }
}
