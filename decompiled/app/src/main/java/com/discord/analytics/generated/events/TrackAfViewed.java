package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;

/* compiled from: TrackAfViewed.kt */
/* loaded from: classes.dex */
public final class TrackAfViewed implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private final transient String analyticsSchemaTypeName = "af_viewed";
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
