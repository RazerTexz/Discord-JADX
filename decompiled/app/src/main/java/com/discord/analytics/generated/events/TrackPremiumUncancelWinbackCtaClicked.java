package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackPremiumUncancelWinbackCtaClicked.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackPremiumUncancelWinbackCtaClicked implements AnalyticsSchema, TrackBase2 {
    private final CharSequence action = null;
    private final transient String analyticsSchemaTypeName = "premium_uncancel_winback_cta_clicked";
    private TrackBase trackBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackPremiumUncancelWinbackCtaClicked) && Intrinsics3.areEqual(this.action, ((TrackPremiumUncancelWinbackCtaClicked) other).action);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.action;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("TrackPremiumUncancelWinbackCtaClicked(action="), this.action, ")");
    }
}
