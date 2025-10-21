package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackPremiumRemoved.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackPremiumRemoved implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence plan = null;
    private final transient String analyticsSchemaTypeName = "premium_removed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackPremiumRemoved) && Intrinsics3.areEqual(this.plan, ((TrackPremiumRemoved) other).plan);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.plan;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("TrackPremiumRemoved(plan="), this.plan, ")");
    }
}
