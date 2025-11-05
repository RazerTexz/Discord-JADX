package com.discord.api.guildscheduledevent;

import d0.t.n0;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildScheduledEventStatus.kt */
/* loaded from: classes.dex */
public enum GuildScheduledEventStatus {
    SCHEDULED(1),
    ACTIVE(2),
    COMPLETED(3),
    CANCELED(4),
    UNKNOWN(0);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Set<GuildScheduledEventStatus> DONE;
    private final int apiValue;

    /* compiled from: GuildScheduledEventStatus.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        GuildScheduledEventStatus guildScheduledEventStatus = COMPLETED;
        GuildScheduledEventStatus guildScheduledEventStatus2 = CANCELED;
        INSTANCE = new Companion(null);
        DONE = n0.setOf((Object[]) new GuildScheduledEventStatus[]{guildScheduledEventStatus, guildScheduledEventStatus2});
    }

    GuildScheduledEventStatus(int i) {
        this.apiValue = i;
    }

    public static final /* synthetic */ Set access$getDONE$cp() {
        return DONE;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
