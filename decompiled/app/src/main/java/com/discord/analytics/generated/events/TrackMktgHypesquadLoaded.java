package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSite2;
import com.discord.api.science.AnalyticsSchema;

/* compiled from: TrackMktgHypesquadLoaded.kt */
/* loaded from: classes.dex */
public final class TrackMktgHypesquadLoaded implements AnalyticsSchema, TrackBase2, TrackMarketingSite2 {
    private final transient String analyticsSchemaTypeName = "mktg_hypesquad_loaded";
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
