package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackEmail;
import com.discord.analytics.generated.traits.TrackEmail2;
import com.discord.api.science.AnalyticsSchema;

/* compiled from: TrackEmailUnsubscribed.kt */
/* loaded from: classes.dex */
public final class TrackEmailUnsubscribed implements AnalyticsSchema, TrackBase2, TrackEmail2 {
    private final transient String analyticsSchemaTypeName = "email_unsubscribed";
    private TrackBase trackBase;
    private TrackEmail trackEmail;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
