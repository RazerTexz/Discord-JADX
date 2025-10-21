package com.discord.api.guildscheduledevent;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildScheduledEventEntityType.kt */
/* loaded from: classes.dex */
public enum GuildScheduledEventEntityType {
    NONE(0),
    STAGE_INSTANCE(1),
    VOICE(2),
    EXTERNAL(3),
    UNKNOWN(-1);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apiValue;

    /* compiled from: GuildScheduledEventEntityType.kt */
    public static final class Companion {
        public Companion() {
        }

        public final GuildScheduledEventEntityType a(int type) {
            return type != 0 ? type != 1 ? type != 2 ? type != 3 ? GuildScheduledEventEntityType.UNKNOWN : GuildScheduledEventEntityType.EXTERNAL : GuildScheduledEventEntityType.VOICE : GuildScheduledEventEntityType.STAGE_INSTANCE : GuildScheduledEventEntityType.NONE;
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    GuildScheduledEventEntityType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
