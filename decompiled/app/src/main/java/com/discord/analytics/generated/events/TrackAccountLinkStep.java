package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackAccountLinkStep.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackAccountLinkStep implements AnalyticsSchema, TrackBase2 {
    private final transient String analyticsSchemaTypeName;
    private final CharSequence currentStep;
    private final CharSequence platformType;
    private final CharSequence previousStep;
    private final CharSequence sessionId;
    private TrackBase trackBase;

    public TrackAccountLinkStep() {
        this(null, null, null, null, 15);
    }

    public TrackAccountLinkStep(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, int i) {
        charSequence = (i & 1) != 0 ? null : charSequence;
        int i2 = i & 2;
        int i3 = i & 4;
        charSequence4 = (i & 8) != 0 ? null : charSequence4;
        this.previousStep = charSequence;
        this.currentStep = null;
        this.sessionId = null;
        this.platformType = charSequence4;
        this.analyticsSchemaTypeName = "account_link_step";
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAccountLinkStep)) {
            return false;
        }
        TrackAccountLinkStep trackAccountLinkStep = (TrackAccountLinkStep) other;
        return Intrinsics3.areEqual(this.previousStep, trackAccountLinkStep.previousStep) && Intrinsics3.areEqual(this.currentStep, trackAccountLinkStep.currentStep) && Intrinsics3.areEqual(this.sessionId, trackAccountLinkStep.sessionId) && Intrinsics3.areEqual(this.platformType, trackAccountLinkStep.platformType);
    }

    public int hashCode() {
        CharSequence charSequence = this.previousStep;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.currentStep;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.sessionId;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.platformType;
        return iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAccountLinkStep(previousStep=");
        sbU.append(this.previousStep);
        sbU.append(", currentStep=");
        sbU.append(this.currentStep);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", platformType=");
        return outline.E(sbU, this.platformType, ")");
    }
}
