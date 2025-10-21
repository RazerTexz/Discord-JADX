package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackGameSpectated.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGameSpectated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence source = null;
    private final Long applicationId = null;
    private final CharSequence partyId = null;
    private final transient String analyticsSchemaTypeName = "game_spectated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGameSpectated)) {
            return false;
        }
        TrackGameSpectated trackGameSpectated = (TrackGameSpectated) other;
        return Intrinsics3.areEqual(this.source, trackGameSpectated.source) && Intrinsics3.areEqual(this.applicationId, trackGameSpectated.applicationId) && Intrinsics3.areEqual(this.partyId, trackGameSpectated.partyId);
    }

    public int hashCode() {
        CharSequence charSequence = this.source;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.applicationId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.partyId;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGameSpectated(source=");
        sbU.append(this.source);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", partyId=");
        return outline.E(sbU, this.partyId, ")");
    }
}
