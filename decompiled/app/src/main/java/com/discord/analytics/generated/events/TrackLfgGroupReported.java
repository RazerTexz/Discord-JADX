package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackLfgGroup;
import com.discord.analytics.generated.traits.TrackLfgGroup2;
import com.discord.api.science.AnalyticsSchema;

/* compiled from: TrackLfgGroupReported.kt */
/* loaded from: classes.dex */
public final class TrackLfgGroupReported implements AnalyticsSchema, TrackBase2, TrackChannel2, TrackLfgGroup2 {
    private final transient String analyticsSchemaTypeName = "lfg_group_reported";
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackLfgGroup trackLfgGroup;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
