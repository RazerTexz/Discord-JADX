package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackMultiAccountSwitchSuccess.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackMultiAccountSwitchSuccess implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long fromUserId = null;
    private final List<Long> linkedUserIds = null;
    private final transient String analyticsSchemaTypeName = "multi_account_switch_success";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMultiAccountSwitchSuccess)) {
            return false;
        }
        TrackMultiAccountSwitchSuccess trackMultiAccountSwitchSuccess = (TrackMultiAccountSwitchSuccess) other;
        return Intrinsics3.areEqual(this.fromUserId, trackMultiAccountSwitchSuccess.fromUserId) && Intrinsics3.areEqual(this.linkedUserIds, trackMultiAccountSwitchSuccess.linkedUserIds);
    }

    public int hashCode() {
        Long l = this.fromUserId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        List<Long> list = this.linkedUserIds;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackMultiAccountSwitchSuccess(fromUserId=");
        sbM833U.append(this.fromUserId);
        sbM833U.append(", linkedUserIds=");
        return outline.m824L(sbM833U, this.linkedUserIds, ")");
    }
}
