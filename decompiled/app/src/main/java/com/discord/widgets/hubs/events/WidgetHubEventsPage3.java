package com.discord.widgets.hubs.events;


/* compiled from: WidgetHubEventsPage.kt */
/* renamed from: com.discord.widgets.hubs.events.HubEventsEventListener, reason: use source file name */
/* loaded from: classes2.dex */
public interface WidgetHubEventsPage3 {
    void dismissHeader();

    void fetchGuildScheduledEvents();

    void onCardClicked(WidgetHubEventsViewModel2 eventData);

    void onPrimaryButtonClicked(WidgetHubEventsViewModel2 eventData);

    void onSecondaryButtonClicked(WidgetHubEventsViewModel2 eventData);

    void onShareClicked(WidgetHubEventsViewModel2 eventData);
}
