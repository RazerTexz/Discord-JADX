package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;

/* compiled from: TrackOutputUnmute.kt */
/* loaded from: classes.dex */
public final class TrackOutputUnmute implements AnalyticsSchema, TrackBaseReceiver {
    private final transient String analyticsSchemaTypeName = "output_unmute";
    private TrackBase trackBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
