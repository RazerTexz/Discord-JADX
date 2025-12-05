package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackExperimentDmTriggered.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackExperimentDmTriggered implements AnalyticsSchema, TrackBase2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private final CharSequence name = null;
    private final Long bucket = null;
    private final Long revision = null;
    private final Long otherUserId = null;
    private final transient String analyticsSchemaTypeName = "experiment_dm_triggered";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackExperimentDmTriggered)) {
            return false;
        }
        TrackExperimentDmTriggered trackExperimentDmTriggered = (TrackExperimentDmTriggered) other;
        return Intrinsics3.areEqual(this.name, trackExperimentDmTriggered.name) && Intrinsics3.areEqual(this.bucket, trackExperimentDmTriggered.bucket) && Intrinsics3.areEqual(this.revision, trackExperimentDmTriggered.revision) && Intrinsics3.areEqual(this.otherUserId, trackExperimentDmTriggered.otherUserId);
    }

    public int hashCode() {
        CharSequence charSequence = this.name;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.bucket;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.revision;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.otherUserId;
        return iHashCode3 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackExperimentDmTriggered(name=");
        sbM833U.append(this.name);
        sbM833U.append(", bucket=");
        sbM833U.append(this.bucket);
        sbM833U.append(", revision=");
        sbM833U.append(this.revision);
        sbM833U.append(", otherUserId=");
        return outline.m819G(sbM833U, this.otherUserId, ")");
    }
}
