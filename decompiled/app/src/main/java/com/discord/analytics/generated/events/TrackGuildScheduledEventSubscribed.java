package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackGuildScheduledEventSubscribed.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildScheduledEventSubscribed implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long guildScheduledEventId = null;
    private final Long privacyLevel = null;
    private final transient String analyticsSchemaTypeName = "guild_scheduled_event_subscribed";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildScheduledEventSubscribed)) {
            return false;
        }
        TrackGuildScheduledEventSubscribed trackGuildScheduledEventSubscribed = (TrackGuildScheduledEventSubscribed) other;
        return Intrinsics3.areEqual(this.guildScheduledEventId, trackGuildScheduledEventSubscribed.guildScheduledEventId) && Intrinsics3.areEqual(this.privacyLevel, trackGuildScheduledEventSubscribed.privacyLevel);
    }

    public int hashCode() {
        Long l = this.guildScheduledEventId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.privacyLevel;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildScheduledEventSubscribed(guildScheduledEventId=");
        sbU.append(this.guildScheduledEventId);
        sbU.append(", privacyLevel=");
        return outline.G(sbU, this.privacyLevel, ")");
    }
}
