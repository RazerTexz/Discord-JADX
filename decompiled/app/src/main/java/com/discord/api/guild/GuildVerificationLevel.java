package com.discord.api.guild;


/* compiled from: GuildVerificationLevel.kt */
/* loaded from: classes.dex */
public enum GuildVerificationLevel {
    NONE(0),
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    HIGHEST(4);

    private final int apiValue;

    GuildVerificationLevel(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
