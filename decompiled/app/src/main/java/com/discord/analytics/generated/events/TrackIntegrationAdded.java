package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: TrackIntegrationAdded.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackIntegrationAdded implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long id = null;
    private final Long guildId = null;
    private final Long applicationId = null;
    private final List<CharSequence> scopes = null;
    private final transient String analyticsSchemaTypeName = "integration_added";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackIntegrationAdded)) {
            return false;
        }
        TrackIntegrationAdded trackIntegrationAdded = (TrackIntegrationAdded) other;
        return Intrinsics3.areEqual(this.id, trackIntegrationAdded.id) && Intrinsics3.areEqual(this.guildId, trackIntegrationAdded.guildId) && Intrinsics3.areEqual(this.applicationId, trackIntegrationAdded.applicationId) && Intrinsics3.areEqual(this.scopes, trackIntegrationAdded.scopes);
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.applicationId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<CharSequence> list = this.scopes;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackIntegrationAdded(id=");
        sbU.append(this.id);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", scopes=");
        return outline.L(sbU, this.scopes, ")");
    }
}
