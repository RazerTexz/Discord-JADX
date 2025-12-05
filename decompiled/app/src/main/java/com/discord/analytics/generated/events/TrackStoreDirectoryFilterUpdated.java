package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackStoreDirectoryFilterUpdated.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackStoreDirectoryFilterUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence loadId = null;
    private final CharSequence sort = null;
    private final transient String analyticsSchemaTypeName = "store_directory_filter_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStoreDirectoryFilterUpdated)) {
            return false;
        }
        TrackStoreDirectoryFilterUpdated trackStoreDirectoryFilterUpdated = (TrackStoreDirectoryFilterUpdated) other;
        return Intrinsics3.areEqual(this.loadId, trackStoreDirectoryFilterUpdated.loadId) && Intrinsics3.areEqual(this.sort, trackStoreDirectoryFilterUpdated.sort);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.sort;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackStoreDirectoryFilterUpdated(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", sort=");
        return outline.m817E(sbM833U, this.sort, ")");
    }
}
