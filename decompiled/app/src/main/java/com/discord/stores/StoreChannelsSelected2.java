package com.discord.stores;


/* compiled from: StoreChannelsSelected.kt */
/* renamed from: com.discord.stores.ChannelAnalyticsViewType, reason: use source file name */
/* loaded from: classes2.dex */
public enum StoreChannelsSelected2 {
    FULL_VIEW("Full View"),
    PEEK_VIEW("Peek View");

    private final String analyticsValue;

    StoreChannelsSelected2(String str) {
        this.analyticsValue = str;
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
