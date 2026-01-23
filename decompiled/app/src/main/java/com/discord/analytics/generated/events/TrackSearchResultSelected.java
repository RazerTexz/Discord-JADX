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

/* JADX INFO: compiled from: TrackSearchResultSelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSearchResultSelected implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2, TrackSourceMetadata2, TrackLocationMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final Long indexNum;
    private final Long limit;
    private final CharSequence loadId;
    private final long modifiers;
    private final Long numModifiers;
    private final Long offset;
    private final Long page;
    private final Long pageResults;
    private final Boolean previewEnabled;
    private final CharSequence query;
    private final CharSequence searchId;
    private final CharSequence searchType;
    private final Long totalResults;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSourceMetadata trackSourceMetadata;

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSearchResultSelected)) {
            return false;
        }
        TrackSearchResultSelected trackSearchResultSelected = (TrackSearchResultSelected) other;
        return Intrinsics3.areEqual(this.searchType, trackSearchResultSelected.searchType) && Intrinsics3.areEqual(this.loadId, trackSearchResultSelected.loadId) && Intrinsics3.areEqual(this.searchId, trackSearchResultSelected.searchId) && Intrinsics3.areEqual(this.indexNum, trackSearchResultSelected.indexNum) && Intrinsics3.areEqual(this.limit, trackSearchResultSelected.limit) && Intrinsics3.areEqual(this.offset, trackSearchResultSelected.offset) && Intrinsics3.areEqual(this.page, trackSearchResultSelected.page) && Intrinsics3.areEqual(this.totalResults, trackSearchResultSelected.totalResults) && Intrinsics3.areEqual(this.pageResults, trackSearchResultSelected.pageResults) && this.modifiers == trackSearchResultSelected.modifiers && Intrinsics3.areEqual(this.numModifiers, trackSearchResultSelected.numModifiers) && Intrinsics3.areEqual(this.previewEnabled, trackSearchResultSelected.previewEnabled) && Intrinsics3.areEqual(this.query, trackSearchResultSelected.query);
    }

    public int hashCode() {
        CharSequence charSequence = this.searchType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.loadId;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.searchId;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.indexNum;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.limit;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.offset;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.page;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.totalResults;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.pageResults;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        long j = this.modifiers;
        int i = (iHashCode9 + ((int) (j ^ (j >>> 32)))) * 31;
        Long l7 = this.numModifiers;
        int iHashCode10 = (i + (l7 != null ? l7.hashCode() : 0)) * 31;
        Boolean bool = this.previewEnabled;
        int iHashCode11 = (iHashCode10 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.query;
        return iHashCode11 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackSearchResultSelected(searchType=");
        sbM833U.append(this.searchType);
        sbM833U.append(", loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", searchId=");
        sbM833U.append(this.searchId);
        sbM833U.append(", indexNum=");
        sbM833U.append(this.indexNum);
        sbM833U.append(", limit=");
        sbM833U.append(this.limit);
        sbM833U.append(", offset=");
        sbM833U.append(this.offset);
        sbM833U.append(", page=");
        sbM833U.append(this.page);
        sbM833U.append(", totalResults=");
        sbM833U.append(this.totalResults);
        sbM833U.append(", pageResults=");
        sbM833U.append(this.pageResults);
        sbM833U.append(", modifiers=");
        sbM833U.append(this.modifiers);
        sbM833U.append(", numModifiers=");
        sbM833U.append(this.numModifiers);
        sbM833U.append(", previewEnabled=");
        sbM833U.append(this.previewEnabled);
        sbM833U.append(", query=");
        return outline.m817E(sbM833U, this.query, ")");
    }
}
