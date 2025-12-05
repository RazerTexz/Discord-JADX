package com.discord.stores;


/* compiled from: StoreMessages.kt */
/* renamed from: com.discord.stores.FailedMessageResolutionType, reason: use source file name */
/* loaded from: classes2.dex */
public enum StoreMessages2 {
    RESENT("Resent"),
    DELETED("Deleted");

    private final String analyticsValue;

    StoreMessages2(String str) {
        this.analyticsValue = str;
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
