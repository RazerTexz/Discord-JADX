package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackVerifyEnqueueSucceeded.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackVerifyEnqueueSucceeded implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence phoneNumber = null;
    private final CharSequence channel = null;
    private final transient String analyticsSchemaTypeName = "verify_enqueue_succeeded";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVerifyEnqueueSucceeded)) {
            return false;
        }
        TrackVerifyEnqueueSucceeded trackVerifyEnqueueSucceeded = (TrackVerifyEnqueueSucceeded) other;
        return Intrinsics3.areEqual(this.phoneNumber, trackVerifyEnqueueSucceeded.phoneNumber) && Intrinsics3.areEqual(this.channel, trackVerifyEnqueueSucceeded.channel);
    }

    public int hashCode() {
        CharSequence charSequence = this.phoneNumber;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.channel;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackVerifyEnqueueSucceeded(phoneNumber=");
        sbM833U.append(this.phoneNumber);
        sbM833U.append(", channel=");
        return outline.m817E(sbM833U, this.channel, ")");
    }
}
