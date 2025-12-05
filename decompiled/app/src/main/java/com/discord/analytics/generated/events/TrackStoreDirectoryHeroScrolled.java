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

/* compiled from: TrackStoreDirectoryHeroScrolled.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackStoreDirectoryHeroScrolled implements AnalyticsSchema, TrackBase2, TrackStoreSkuMetadata2, TrackPaymentMetadata2 {
    private TrackBase trackBase;
    private TrackPaymentMetadata trackPaymentMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final CharSequence loadId = null;
    private final Long cardIndex = null;
    private final CharSequence cardType = null;
    private final transient String analyticsSchemaTypeName = "store_directory_hero_scrolled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStoreDirectoryHeroScrolled)) {
            return false;
        }
        TrackStoreDirectoryHeroScrolled trackStoreDirectoryHeroScrolled = (TrackStoreDirectoryHeroScrolled) other;
        return Intrinsics3.areEqual(this.loadId, trackStoreDirectoryHeroScrolled.loadId) && Intrinsics3.areEqual(this.cardIndex, trackStoreDirectoryHeroScrolled.cardIndex) && Intrinsics3.areEqual(this.cardType, trackStoreDirectoryHeroScrolled.cardType);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.cardIndex;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.cardType;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackStoreDirectoryHeroScrolled(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", cardIndex=");
        sbM833U.append(this.cardIndex);
        sbM833U.append(", cardType=");
        return outline.m817E(sbM833U, this.cardType, ")");
    }
}
