package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;

/* compiled from: TrackMessageLengthLimitReached.kt */
/* loaded from: classes.dex */
public final class TrackMessageLengthLimitReached implements AnalyticsSchema, TrackBase2 {
    private final transient String analyticsSchemaTypeName = "message_length_limit_reached";
    private TrackBase trackBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
