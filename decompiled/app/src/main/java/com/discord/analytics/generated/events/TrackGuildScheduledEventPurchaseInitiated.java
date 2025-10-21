package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackGuildScheduledEventPurchaseInitiated.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildScheduledEventPurchaseInitiated implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long guildScheduledEventId = null;
    private final transient String analyticsSchemaTypeName = "guild_scheduled_event_purchase_initiated";

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
        if (this != other) {
            return (other instanceof TrackGuildScheduledEventPurchaseInitiated) && Intrinsics3.areEqual(this.guildScheduledEventId, ((TrackGuildScheduledEventPurchaseInitiated) other).guildScheduledEventId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.guildScheduledEventId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.G(outline.U("TrackGuildScheduledEventPurchaseInitiated(guildScheduledEventId="), this.guildScheduledEventId, ")");
    }
}
