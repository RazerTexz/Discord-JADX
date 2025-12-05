package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackA11yRuntimeViolation.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackA11yRuntimeViolation implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence ruleId = null;
    private final CharSequence trace = null;
    private final CharSequence message = null;
    private final CharSequence hash = null;
    private final transient String analyticsSchemaTypeName = "a11y_runtime_violation";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackA11yRuntimeViolation)) {
            return false;
        }
        TrackA11yRuntimeViolation trackA11yRuntimeViolation = (TrackA11yRuntimeViolation) other;
        return Intrinsics3.areEqual(this.ruleId, trackA11yRuntimeViolation.ruleId) && Intrinsics3.areEqual(this.trace, trackA11yRuntimeViolation.trace) && Intrinsics3.areEqual(this.message, trackA11yRuntimeViolation.message) && Intrinsics3.areEqual(this.hash, trackA11yRuntimeViolation.hash);
    }

    public int hashCode() {
        CharSequence charSequence = this.ruleId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.trace;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.message;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.hash;
        return iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackA11yRuntimeViolation(ruleId=");
        sbM833U.append(this.ruleId);
        sbM833U.append(", trace=");
        sbM833U.append(this.trace);
        sbM833U.append(", message=");
        sbM833U.append(this.message);
        sbM833U.append(", hash=");
        return outline.m817E(sbM833U, this.hash, ")");
    }
}
