package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackSearchStarted.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackSearchStarted implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackGuild2, TrackChannel2 {
    private final transient String analyticsSchemaTypeName;
    private final Long categoryId;
    private final CharSequence loadId;
    private final long modifiers;
    private final Long numModifiers;
    private final CharSequence prevSearchId;
    private final Boolean previewEnabled;
    private final CharSequence searchType;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;

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
        if (!(other instanceof TrackSearchStarted)) {
            return false;
        }
        TrackSearchStarted trackSearchStarted = (TrackSearchStarted) other;
        return Intrinsics3.areEqual(this.searchType, trackSearchStarted.searchType) && Intrinsics3.areEqual(this.loadId, trackSearchStarted.loadId) && Intrinsics3.areEqual(this.prevSearchId, trackSearchStarted.prevSearchId) && this.modifiers == trackSearchStarted.modifiers && Intrinsics3.areEqual(this.numModifiers, trackSearchStarted.numModifiers) && Intrinsics3.areEqual(this.previewEnabled, trackSearchStarted.previewEnabled) && Intrinsics3.areEqual(this.categoryId, trackSearchStarted.categoryId);
    }

    public int hashCode() {
        CharSequence charSequence = this.searchType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.loadId;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.prevSearchId;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        long j = this.modifiers;
        int i = (iHashCode3 + ((int) (j ^ (j >>> 32)))) * 31;
        Long l = this.numModifiers;
        int iHashCode4 = (i + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.previewEnabled;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l2 = this.categoryId;
        return iHashCode5 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSearchStarted(searchType=");
        sbU.append(this.searchType);
        sbU.append(", loadId=");
        sbU.append(this.loadId);
        sbU.append(", prevSearchId=");
        sbU.append(this.prevSearchId);
        sbU.append(", modifiers=");
        sbU.append(this.modifiers);
        sbU.append(", numModifiers=");
        sbU.append(this.numModifiers);
        sbU.append(", previewEnabled=");
        sbU.append(this.previewEnabled);
        sbU.append(", categoryId=");
        return outline.G(sbU, this.categoryId, ")");
    }
}
