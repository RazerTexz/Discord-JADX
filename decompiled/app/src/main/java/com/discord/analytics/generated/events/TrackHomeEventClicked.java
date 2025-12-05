package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackHomeEventClicked.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackHomeEventClicked implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long guildScheduledEventId = null;
    private final CharSequence homeSessionId = null;
    private final Boolean isActive = null;
    private final transient String analyticsSchemaTypeName = "home_event_clicked";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
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
        if (!(other instanceof TrackHomeEventClicked)) {
            return false;
        }
        TrackHomeEventClicked trackHomeEventClicked = (TrackHomeEventClicked) other;
        return Intrinsics3.areEqual(this.guildScheduledEventId, trackHomeEventClicked.guildScheduledEventId) && Intrinsics3.areEqual(this.homeSessionId, trackHomeEventClicked.homeSessionId) && Intrinsics3.areEqual(this.isActive, trackHomeEventClicked.isActive);
    }

    public int hashCode() {
        Long l = this.guildScheduledEventId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.homeSessionId;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.isActive;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackHomeEventClicked(guildScheduledEventId=");
        sbM833U.append(this.guildScheduledEventId);
        sbM833U.append(", homeSessionId=");
        sbM833U.append(this.homeSessionId);
        sbM833U.append(", isActive=");
        return outline.m816D(sbM833U, this.isActive, ")");
    }
}
