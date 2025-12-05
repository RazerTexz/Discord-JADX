package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackSearchResultEmpty.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackSearchResultEmpty implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2, TrackSourceMetadata2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private final CharSequence query = null;
    private final CharSequence searchType = null;
    private final transient String analyticsSchemaTypeName = "search_result_empty";

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
        if (!(other instanceof TrackSearchResultEmpty)) {
            return false;
        }
        TrackSearchResultEmpty trackSearchResultEmpty = (TrackSearchResultEmpty) other;
        return Intrinsics3.areEqual(this.query, trackSearchResultEmpty.query) && Intrinsics3.areEqual(this.searchType, trackSearchResultEmpty.searchType);
    }

    public int hashCode() {
        CharSequence charSequence = this.query;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.searchType;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackSearchResultEmpty(query=");
        sbM833U.append(this.query);
        sbM833U.append(", searchType=");
        return outline.m817E(sbM833U, this.searchType, ")");
    }
}
