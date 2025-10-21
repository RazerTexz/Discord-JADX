package com.discord.analytics.generated.events.network_action;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackNetworkActionBugReportSubmit.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackNetworkActionBugReportSubmit implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackNetworkMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;
    private final Long priority = null;
    private final CharSequence asanaInboxId = null;
    private final transient String analyticsSchemaTypeName = "network_action_bug_report_submit";

    @Override // com.discord.analytics.generated.traits.TrackNetworkMetadata2
    public void b(TrackNetworkMetadata trackNetworkMetadata) {
        this.trackNetworkMetadata = trackNetworkMetadata;
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
        if (!(other instanceof TrackNetworkActionBugReportSubmit)) {
            return false;
        }
        TrackNetworkActionBugReportSubmit trackNetworkActionBugReportSubmit = (TrackNetworkActionBugReportSubmit) other;
        return Intrinsics3.areEqual(this.priority, trackNetworkActionBugReportSubmit.priority) && Intrinsics3.areEqual(this.asanaInboxId, trackNetworkActionBugReportSubmit.asanaInboxId);
    }

    public int hashCode() {
        Long l = this.priority;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.asanaInboxId;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNetworkActionBugReportSubmit(priority=");
        sbU.append(this.priority);
        sbU.append(", asanaInboxId=");
        return outline.E(sbU, this.asanaInboxId, ")");
    }
}
