package com.discord.analytics.utils.hubs;


/* compiled from: HubGuildScheduledEventClickType.kt */
/* loaded from: classes.dex */
public enum HubGuildScheduledEventClickType {
    JoinServer("Join Server"),
    ListenIn("Listen In"),
    ViewEvent("View Event");

    private final String type;

    HubGuildScheduledEventClickType(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
