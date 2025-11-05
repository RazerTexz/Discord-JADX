package com.discord.api.application;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ApplicationType.kt */
/* loaded from: classes.dex */
public enum ApplicationType {
    UNKNOWN(0),
    GAME(1),
    MUSIC(2),
    TICKETED_EVENTS(3),
    GUILD_ROLE_SUBSCRIPTIONS(4);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apiValue;

    /* compiled from: ApplicationType.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    ApplicationType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
