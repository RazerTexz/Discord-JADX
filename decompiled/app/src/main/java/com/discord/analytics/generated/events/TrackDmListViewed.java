package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackDmListViewed.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackDmListViewed implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long numUsersVisible = null;
    private final Long numUsersVisibleWithMobileIndicator = null;
    private final transient String analyticsSchemaTypeName = "dm_list_viewed";

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
        if (!(other instanceof TrackDmListViewed)) {
            return false;
        }
        TrackDmListViewed trackDmListViewed = (TrackDmListViewed) other;
        return Intrinsics3.areEqual(this.numUsersVisible, trackDmListViewed.numUsersVisible) && Intrinsics3.areEqual(this.numUsersVisibleWithMobileIndicator, trackDmListViewed.numUsersVisibleWithMobileIndicator);
    }

    public int hashCode() {
        Long l = this.numUsersVisible;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.numUsersVisibleWithMobileIndicator;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackDmListViewed(numUsersVisible=");
        sbM833U.append(this.numUsersVisible);
        sbM833U.append(", numUsersVisibleWithMobileIndicator=");
        return outline.m819G(sbM833U, this.numUsersVisibleWithMobileIndicator, ")");
    }
}
