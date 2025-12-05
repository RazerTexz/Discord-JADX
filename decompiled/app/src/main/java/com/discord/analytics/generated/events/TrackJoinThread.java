package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackThread;
import com.discord.analytics.generated.traits.TrackThread2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackJoinThread.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackJoinThread implements AnalyticsSchema, TrackBase2, TrackThread2 {
    private TrackBase trackBase;
    private TrackThread trackThread;
    private final Long channelId = null;
    private final Long parentId = null;
    private final Long guildId = null;
    private final Long channelType = null;
    private final Long targetUserId = null;
    private final Boolean isSelfJoin = null;
    private final transient String analyticsSchemaTypeName = "join_thread";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackJoinThread)) {
            return false;
        }
        TrackJoinThread trackJoinThread = (TrackJoinThread) other;
        return Intrinsics3.areEqual(this.channelId, trackJoinThread.channelId) && Intrinsics3.areEqual(this.parentId, trackJoinThread.parentId) && Intrinsics3.areEqual(this.guildId, trackJoinThread.guildId) && Intrinsics3.areEqual(this.channelType, trackJoinThread.channelType) && Intrinsics3.areEqual(this.targetUserId, trackJoinThread.targetUserId) && Intrinsics3.areEqual(this.isSelfJoin, trackJoinThread.isSelfJoin);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.parentId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.channelType;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.targetUserId;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool = this.isSelfJoin;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackJoinThread(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", parentId=");
        sbM833U.append(this.parentId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", targetUserId=");
        sbM833U.append(this.targetUserId);
        sbM833U.append(", isSelfJoin=");
        return outline.m816D(sbM833U, this.isSelfJoin, ")");
    }
}
