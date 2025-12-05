package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

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
        StringBuilder sbM833U = outline.m833U("TrackAccountLinkFailed(errorMessage=");
        sbM833U.append(this.errorMessage);
        sbM833U.append(", statusCode=");
        sbM833U.append(this.statusCode);
        sbM833U.append(", linkMethod=");
        sbM833U.append(this.linkMethod);
        sbM833U.append(", sessionId=");
        sbM833U.append(this.sessionId);
        sbM833U.append(", currentStep=");
        sbM833U.append(this.currentStep);
        sbM833U.append(", platformType=");
        return outline.m817E(sbM833U, this.platformType, ")");
    }
}
