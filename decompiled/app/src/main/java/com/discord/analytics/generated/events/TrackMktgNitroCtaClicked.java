package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackMktgNitroCtaClicked.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackMktgNitroCtaClicked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean desktopProbablyOpen = null;
    private final transient String analyticsSchemaTypeName = "mktg_nitro_cta_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackMktgNitroCtaClicked) && Intrinsics3.areEqual(this.desktopProbablyOpen, ((TrackMktgNitroCtaClicked) other).desktopProbablyOpen);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.desktopProbablyOpen;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m816D(outline.m833U("TrackMktgNitroCtaClicked(desktopProbablyOpen="), this.desktopProbablyOpen, ")");
    }
}
