package com.discord.utilities.rest;


/* compiled from: SendUtils.kt */
/* renamed from: com.discord.utilities.rest.FileUploadAlertType, reason: use source file name */
/* loaded from: classes2.dex */
public enum SendUtils2 {
    NITRO_UPSELL("Nitro Upsell"),
    OVER_MAX_SIZE("Over Max Size");

    private final String analyticsValue;

    SendUtils2(String str) {
        this.analyticsValue = str;
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
