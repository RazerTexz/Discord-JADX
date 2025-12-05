package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackUpdateRelationship.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackUpdateRelationship implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean isInitiator = null;
    private final Long mutualGuilds = null;
    private final Long otherUser = null;
    private final Long type = null;
    private final Long userGuilds = null;
    private final transient String analyticsSchemaTypeName = "update_relationship";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUpdateRelationship)) {
            return false;
        }
        TrackUpdateRelationship trackUpdateRelationship = (TrackUpdateRelationship) other;
        return Intrinsics3.areEqual(this.isInitiator, trackUpdateRelationship.isInitiator) && Intrinsics3.areEqual(this.mutualGuilds, trackUpdateRelationship.mutualGuilds) && Intrinsics3.areEqual(this.otherUser, trackUpdateRelationship.otherUser) && Intrinsics3.areEqual(this.type, trackUpdateRelationship.type) && Intrinsics3.areEqual(this.userGuilds, trackUpdateRelationship.userGuilds);
    }

    public int hashCode() {
        Boolean bool = this.isInitiator;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.mutualGuilds;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.otherUser;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.type;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.userGuilds;
        return iHashCode4 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackUpdateRelationship(isInitiator=");
        sbM833U.append(this.isInitiator);
        sbM833U.append(", mutualGuilds=");
        sbM833U.append(this.mutualGuilds);
        sbM833U.append(", otherUser=");
        sbM833U.append(this.otherUser);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", userGuilds=");
        return outline.m819G(sbM833U, this.userGuilds, ")");
    }
}
