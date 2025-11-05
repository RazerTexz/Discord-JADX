package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* compiled from: TrackUserAgeSubmitted.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackUserAgeSubmitted implements AnalyticsSchema, TrackBaseReceiver {
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
            return (other instanceof TrackUserAgeSubmitted) && m.areEqual(this.ageBucket, ((TrackUserAgeSubmitted) other).ageBucket);
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
        return a.E(a.U("TrackUserAgeSubmitted(ageBucket="), this.ageBucket, ")");
    }
}
