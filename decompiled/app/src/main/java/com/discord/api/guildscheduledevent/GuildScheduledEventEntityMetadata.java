package com.discord.api.guildscheduledevent;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildScheduledEventEntityMetadata.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildScheduledEventEntityMetadata implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String location;

    /* compiled from: GuildScheduledEventEntityMetadata.kt */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                GuildScheduledEventEntityType.values();
                int[] iArr = new int[5];
                $EnumSwitchMapping$0 = iArr;
                iArr[GuildScheduledEventEntityType.EXTERNAL.ordinal()] = 1;
            }
        }

        public Companion() {
        }

        /* renamed from: a */
        public final GuildScheduledEventEntityMetadata m7992a(GuildScheduledEventEntityType entityType, String location) {
            Intrinsics3.checkNotNullParameter(entityType, "entityType");
            return entityType.ordinal() != 3 ? new GuildScheduledEventEntityMetadata(null, 1) : new GuildScheduledEventEntityMetadata(location);
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public GuildScheduledEventEntityMetadata() {
        this.location = null;
    }

    /* renamed from: a, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* renamed from: b */
    public final boolean m7991b() {
        return this.location == null;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildScheduledEventEntityMetadata) && Intrinsics3.areEqual(this.location, ((GuildScheduledEventEntityMetadata) other).location);
        }
        return true;
    }

    public int hashCode() {
        String str = this.location;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m822J(outline.m833U("GuildScheduledEventEntityMetadata(location="), this.location, ")");
    }

    public GuildScheduledEventEntityMetadata(String str) {
        this.location = str;
    }

    public GuildScheduledEventEntityMetadata(String str, int i) {
        int i2 = i & 1;
        this.location = null;
    }
}
