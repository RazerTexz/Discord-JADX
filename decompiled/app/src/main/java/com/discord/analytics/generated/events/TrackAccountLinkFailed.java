package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackAccountLinkFailed.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackAccountLinkFailed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence errorMessage = null;
    private final CharSequence statusCode = null;
    private final CharSequence linkMethod = null;
    private final CharSequence sessionId = null;
    private final CharSequence currentStep = null;
    private final CharSequence platformType = null;
    private final transient String analyticsSchemaTypeName = "account_link_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAccountLinkFailed)) {
            return false;
        }
        TrackAccountLinkFailed trackAccountLinkFailed = (TrackAccountLinkFailed) other;
        return Intrinsics3.areEqual(this.errorMessage, trackAccountLinkFailed.errorMessage) && Intrinsics3.areEqual(this.statusCode, trackAccountLinkFailed.statusCode) && Intrinsics3.areEqual(this.linkMethod, trackAccountLinkFailed.linkMethod) && Intrinsics3.areEqual(this.sessionId, trackAccountLinkFailed.sessionId) && Intrinsics3.areEqual(this.currentStep, trackAccountLinkFailed.currentStep) && Intrinsics3.areEqual(this.platformType, trackAccountLinkFailed.platformType);
    }

    public int hashCode() {
        CharSequence charSequence = this.errorMessage;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.statusCode;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.linkMethod;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.sessionId;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.currentStep;
        int iHashCode5 = (iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.platformType;
        return iHashCode5 + (charSequence6 != null ? charSequence6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAccountLinkFailed(errorMessage=");
        sbU.append(this.errorMessage);
        sbU.append(", statusCode=");
        sbU.append(this.statusCode);
        sbU.append(", linkMethod=");
        sbU.append(this.linkMethod);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", currentStep=");
        sbU.append(this.currentStep);
        sbU.append(", platformType=");
        return outline.E(sbU, this.platformType, ")");
    }
}
