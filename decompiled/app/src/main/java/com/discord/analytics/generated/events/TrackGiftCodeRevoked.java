package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.api.science.AnalyticsSchema;

/* compiled from: TrackGiftCodeRevoked.kt */
/* loaded from: classes.dex */
public final class TrackGiftCodeRevoked implements AnalyticsSchema, TrackBase2, TrackStoreSkuMetadata2, TrackGiftCodeMetadata2 {
    private final transient String analyticsSchemaTypeName = "gift_code_revoked";
    private TrackBase trackBase;
    private TrackGiftCodeMetadata trackGiftCodeMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
