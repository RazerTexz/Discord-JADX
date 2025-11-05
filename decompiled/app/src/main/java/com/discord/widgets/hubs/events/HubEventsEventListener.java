package com.discord.widgets.hubs.events;


/* compiled from: WidgetHubEventsPage.kt */
/* loaded from: classes2.dex */
public interface HubEventsEventListener {
    void dismissHeader();

    void fetchGuildScheduledEvents();

    void onCardClicked(HubGuildScheduledEventData eventData);

    void onPrimaryButtonClicked(HubGuildScheduledEventData eventData);

    void onSecondaryButtonClicked(HubGuildScheduledEventData eventData);

    void onShareClicked(HubGuildScheduledEventData eventData);
}
