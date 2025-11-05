package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;

/* compiled from: TrackMktgHypesquadFormOpened.kt */
/* loaded from: classes.dex */
public final class TrackMktgHypesquadFormOpened implements AnalyticsSchema, TrackBaseReceiver, TrackMarketingSiteReceiver {
    private final transient String analyticsSchemaTypeName = "mktg_hypesquad_form_opened";
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
