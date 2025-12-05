package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSite2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackViewAcknowledgements.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackViewAcknowledgements implements AnalyticsSchema, TrackBase2, TrackMarketingSite2 {
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;
    private final CharSequence frompage = null;
    private final transient String analyticsSchemaTypeName = "view_acknowledgements";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackViewAcknowledgements) && Intrinsics3.areEqual(this.frompage, ((TrackViewAcknowledgements) other).frompage);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.frompage;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m817E(outline.m833U("TrackViewAcknowledgements(frompage="), this.frompage, ")");
    }
}
