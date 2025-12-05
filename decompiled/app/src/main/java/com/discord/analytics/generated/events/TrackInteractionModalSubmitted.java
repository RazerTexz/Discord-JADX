package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackInteractionModalSubmitted.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackInteractionModalSubmitted implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long interactionId = null;
    private final transient String analyticsSchemaTypeName = "interaction_modal_submitted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInteractionModalSubmitted)) {
            return false;
        }
        TrackInteractionModalSubmitted trackInteractionModalSubmitted = (TrackInteractionModalSubmitted) other;
        return Intrinsics3.areEqual(this.applicationId, trackInteractionModalSubmitted.applicationId) && Intrinsics3.areEqual(this.interactionId, trackInteractionModalSubmitted.interactionId);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.interactionId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackInteractionModalSubmitted(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", interactionId=");
        return outline.m819G(sbM833U, this.interactionId, ")");
    }
}
