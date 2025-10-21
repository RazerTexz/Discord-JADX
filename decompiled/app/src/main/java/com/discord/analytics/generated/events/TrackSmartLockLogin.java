package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;

/* compiled from: TrackSmartLockLogin.kt */
/* loaded from: classes.dex */
public final class TrackSmartLockLogin implements AnalyticsSchema, TrackBase2 {
    private final transient String analyticsSchemaTypeName = "smart_lock_login";
    private TrackBase trackBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
