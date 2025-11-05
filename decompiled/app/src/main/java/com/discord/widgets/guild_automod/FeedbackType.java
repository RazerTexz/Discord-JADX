package com.discord.widgets.guild_automod;


/* compiled from: ReportIssueWithAutoModViewModel.kt */
/* loaded from: classes2.dex */
public enum FeedbackType {
    BUG("BUG"),
    ALLOWED("ALLOWED");

    private final String value;

    FeedbackType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
