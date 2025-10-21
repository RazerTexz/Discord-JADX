package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackGiftCodeResolved.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGiftCodeResolved implements AnalyticsSchema, TrackBase2, TrackStoreSkuMetadata2, TrackGiftCodeMetadata2 {
    private TrackBase trackBase;
    private TrackGiftCodeMetadata trackGiftCodeMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final Boolean resolved = null;
    private final transient String analyticsSchemaTypeName = "gift_code_resolved";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackGiftCodeResolved) && Intrinsics3.areEqual(this.resolved, ((TrackGiftCodeResolved) other).resolved);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.resolved;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.D(outline.U("TrackGiftCodeResolved(resolved="), this.resolved, ")");
    }
}
