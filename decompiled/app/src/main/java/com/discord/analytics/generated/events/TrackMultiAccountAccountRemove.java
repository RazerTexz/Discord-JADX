package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;

/* compiled from: TrackMultiAccountAccountRemove.kt */
/* loaded from: classes.dex */
public final class TrackMultiAccountAccountRemove implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private final transient String analyticsSchemaTypeName = "multi_account_account_remove";
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
