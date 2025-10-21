package com.discord.widgets.guildcommunicationdisabled.start;

import com.adjust.sdk.Constants;

/* compiled from: GuildCommunicationDisabledDateUtils.kt */
/* renamed from: com.discord.widgets.guildcommunicationdisabled.start.TimeDurationDisabledCommunication, reason: use source file name */
/* loaded from: classes2.dex */
public enum GuildCommunicationDisabledDateUtils2 {
    SECONDS_60(60000),
    MINUTES_5(300000),
    MINUTES_10(600000),
    HOUR_1(Constants.ONE_HOUR),
    DAY_1(86400000),
    WEEK_1(604800000);

    private final int durationMs;

    GuildCommunicationDisabledDateUtils2(int i) {
        this.durationMs = i;
    }

    public final int getDurationMs() {
        return this.durationMs;
    }
}
