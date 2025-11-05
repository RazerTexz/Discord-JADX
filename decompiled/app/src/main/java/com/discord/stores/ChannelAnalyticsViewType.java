package com.discord.stores;


/* compiled from: StoreChannelsSelected.kt */
/* loaded from: classes2.dex */
public enum ChannelAnalyticsViewType {
    FULL_VIEW("Full View"),
    PEEK_VIEW("Peek View");

    private final String analyticsValue;

    ChannelAnalyticsViewType(String str) {
        this.analyticsValue = str;
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
