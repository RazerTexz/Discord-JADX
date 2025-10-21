package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: TrackRingCall.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackRingCall implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long messageId = null;
    private final Long channelType = null;
    private final List<Long> recipientIds = null;
    private final transient String analyticsSchemaTypeName = "ring_call";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRingCall)) {
            return false;
        }
        TrackRingCall trackRingCall = (TrackRingCall) other;
        return Intrinsics3.areEqual(this.channelId, trackRingCall.channelId) && Intrinsics3.areEqual(this.messageId, trackRingCall.messageId) && Intrinsics3.areEqual(this.channelType, trackRingCall.channelType) && Intrinsics3.areEqual(this.recipientIds, trackRingCall.recipientIds);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.messageId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channelType;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.recipientIds;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackRingCall(channelId=");
        sbU.append(this.channelId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", recipientIds=");
        return outline.L(sbU, this.recipientIds, ")");
    }
}
