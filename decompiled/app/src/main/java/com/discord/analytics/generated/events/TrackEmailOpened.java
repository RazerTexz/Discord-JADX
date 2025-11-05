package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackEmail;
import com.discord.analytics.generated.traits.TrackEmailReceiver;
import com.discord.api.science.AnalyticsSchema;

/* compiled from: TrackEmailOpened.kt */
/* loaded from: classes.dex */
public final class TrackEmailOpened implements AnalyticsSchema, TrackBaseReceiver, TrackEmailReceiver {
    private final transient String analyticsSchemaTypeName = "email_opened";
    private TrackBase trackBase;
    private TrackEmail trackEmail;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
