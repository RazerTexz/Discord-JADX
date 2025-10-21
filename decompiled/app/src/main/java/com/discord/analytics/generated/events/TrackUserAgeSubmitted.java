package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackUserAgeSubmitted.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackUserAgeSubmitted implements AnalyticsSchema, TrackBase2 {
    private final CharSequence ageBucket = null;
    private final transient String analyticsSchemaTypeName = "user_age_submitted";
    private TrackBase trackBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackUserAgeSubmitted) && Intrinsics3.areEqual(this.ageBucket, ((TrackUserAgeSubmitted) other).ageBucket);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.ageBucket;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("TrackUserAgeSubmitted(ageBucket="), this.ageBucket, ")");
    }
}
