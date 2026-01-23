package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackSmsEnqueueSucceeded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSmsEnqueueSucceeded implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence phoneNumber = null;
    private final CharSequence phoneCountry = null;
    private final CharSequence carrierName = null;
    private final CharSequence carrierType = null;
    private final CharSequence source = null;
    private final transient String analyticsSchemaTypeName = "sms_enqueue_succeeded";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSmsEnqueueSucceeded)) {
            return false;
        }
        TrackSmsEnqueueSucceeded trackSmsEnqueueSucceeded = (TrackSmsEnqueueSucceeded) other;
        return Intrinsics3.areEqual(this.phoneNumber, trackSmsEnqueueSucceeded.phoneNumber) && Intrinsics3.areEqual(this.phoneCountry, trackSmsEnqueueSucceeded.phoneCountry) && Intrinsics3.areEqual(this.carrierName, trackSmsEnqueueSucceeded.carrierName) && Intrinsics3.areEqual(this.carrierType, trackSmsEnqueueSucceeded.carrierType) && Intrinsics3.areEqual(this.source, trackSmsEnqueueSucceeded.source);
    }

    public int hashCode() {
        CharSequence charSequence = this.phoneNumber;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.phoneCountry;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.carrierName;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.carrierType;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.source;
        return iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackSmsEnqueueSucceeded(phoneNumber=");
        sbM833U.append(this.phoneNumber);
        sbM833U.append(", phoneCountry=");
        sbM833U.append(this.phoneCountry);
        sbM833U.append(", carrierName=");
        sbM833U.append(this.carrierName);
        sbM833U.append(", carrierType=");
        sbM833U.append(this.carrierType);
        sbM833U.append(", source=");
        return outline.m817E(sbM833U, this.source, ")");
    }
}
