package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackPaymentMetadata;
import com.discord.analytics.generated.traits.TrackPaymentMetadata2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackStoreListingMediaScrolled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStoreListingMediaScrolled implements AnalyticsSchema, TrackBase2, TrackStoreSkuMetadata2, TrackPaymentMetadata2 {
    private TrackBase trackBase;
    private TrackPaymentMetadata trackPaymentMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final Long cardIndex = null;
    private final CharSequence cardType = null;
    private final transient String analyticsSchemaTypeName = "store_listing_media_scrolled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStoreListingMediaScrolled)) {
            return false;
        }
        TrackStoreListingMediaScrolled trackStoreListingMediaScrolled = (TrackStoreListingMediaScrolled) other;
        return Intrinsics3.areEqual(this.cardIndex, trackStoreListingMediaScrolled.cardIndex) && Intrinsics3.areEqual(this.cardType, trackStoreListingMediaScrolled.cardType);
    }

    public int hashCode() {
        Long l = this.cardIndex;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.cardType;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackStoreListingMediaScrolled(cardIndex=");
        sbM833U.append(this.cardIndex);
        sbM833U.append(", cardType=");
        return outline.m817E(sbM833U, this.cardType, ")");
    }
}
