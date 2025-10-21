package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: TrackMultiAccountAssociation.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackMultiAccountAssociation implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long lastUserId = null;
    private final List<Long> linkedUserIds = null;
    private final transient String analyticsSchemaTypeName = "multi_account_association";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMultiAccountAssociation)) {
            return false;
        }
        TrackMultiAccountAssociation trackMultiAccountAssociation = (TrackMultiAccountAssociation) other;
        return Intrinsics3.areEqual(this.lastUserId, trackMultiAccountAssociation.lastUserId) && Intrinsics3.areEqual(this.linkedUserIds, trackMultiAccountAssociation.linkedUserIds);
    }

    public int hashCode() {
        Long l = this.lastUserId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        List<Long> list = this.linkedUserIds;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMultiAccountAssociation(lastUserId=");
        sbU.append(this.lastUserId);
        sbU.append(", linkedUserIds=");
        return outline.L(sbU, this.linkedUserIds, ")");
    }
}
