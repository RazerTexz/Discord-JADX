package com.discord.api.activity;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ActivityType.kt */
/* loaded from: classes.dex */
public enum ActivityType {
    PLAYING(0),
    STREAMING(1),
    LISTENING(2),
    WATCHING(3),
    CUSTOM_STATUS(4),
    COMPETING(5),
    UNKNOWN(-1);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apiInt;

    /* compiled from: ActivityType.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    ActivityType(int i) {
        this.apiInt = i;
    }

    /* renamed from: getApiInt$discord_api, reason: from getter */
    public final int getApiInt() {
        return this.apiInt;
    }
}
