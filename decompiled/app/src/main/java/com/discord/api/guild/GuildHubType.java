package com.discord.api.guild;


/* compiled from: GuildHubType.kt */
/* loaded from: classes.dex */
public enum GuildHubType {
    DEFAULT(0),
    HIGH_SCHOOL(1),
    COLLEGE(2);

    private final int apiValue;

    GuildHubType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
