package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;

/* compiled from: TrackPremiumPageOpened.kt */
/* loaded from: classes.dex */
public final class TrackPremiumPageOpened implements AnalyticsSchema, TrackBaseReceiver {
    private final transient String analyticsSchemaTypeName = "premium_page_opened";
    private TrackBase trackBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
