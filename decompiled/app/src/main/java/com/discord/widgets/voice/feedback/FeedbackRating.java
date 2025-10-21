package com.discord.widgets.voice.feedback;


/* compiled from: FeedbackRating.kt */
/* loaded from: classes.dex */
public enum FeedbackRating {
    GOOD("good"),
    NEUTRAL("neutral"),
    BAD("bad"),
    NO_RESPONSE("no response");

    private final String analyticsValue;

    FeedbackRating(String str) {
        this.analyticsValue = str;
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
