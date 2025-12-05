package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackStartCall.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackStartCall implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long messageId = null;
    private final List<Long> recipientIds = null;
    private final transient String analyticsSchemaTypeName = "start_call";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStartCall)) {
            return false;
        }
        TrackStartCall trackStartCall = (TrackStartCall) other;
        return Intrinsics3.areEqual(this.channelId, trackStartCall.channelId) && Intrinsics3.areEqual(this.channelType, trackStartCall.channelType) && Intrinsics3.areEqual(this.messageId, trackStartCall.messageId) && Intrinsics3.areEqual(this.recipientIds, trackStartCall.recipientIds);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.messageId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.recipientIds;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackStartCall(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", recipientIds=");
        return outline.m824L(sbM833U, this.recipientIds, ")");
    }
}
