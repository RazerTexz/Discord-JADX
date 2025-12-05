package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSite2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackMktgHypesquadFormSubmitted.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackMktgHypesquadFormSubmitted implements AnalyticsSchema, TrackBase2, TrackMarketingSite2 {
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;
    private final CharSequence referredByCode = null;
    private final transient String analyticsSchemaTypeName = "mktg_hypesquad_form_submitted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackMktgHypesquadFormSubmitted) && Intrinsics3.areEqual(this.referredByCode, ((TrackMktgHypesquadFormSubmitted) other).referredByCode);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.referredByCode;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m817E(outline.m833U("TrackMktgHypesquadFormSubmitted(referredByCode="), this.referredByCode, ")");
    }
}
