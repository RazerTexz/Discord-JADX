package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackJoinedIntegration.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackJoinedIntegration implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guild = null;
    private final Long guildOwner = null;
    private final CharSequence integration = null;
    private final CharSequence integrationType = null;
    private final Long integrationUser = null;
    private final Long userDay = null;
    private final Long userGuilds = null;
    private final transient String analyticsSchemaTypeName = "joined_integration";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackJoinedIntegration)) {
            return false;
        }
        TrackJoinedIntegration trackJoinedIntegration = (TrackJoinedIntegration) other;
        return Intrinsics3.areEqual(this.guild, trackJoinedIntegration.guild) && Intrinsics3.areEqual(this.guildOwner, trackJoinedIntegration.guildOwner) && Intrinsics3.areEqual(this.integration, trackJoinedIntegration.integration) && Intrinsics3.areEqual(this.integrationType, trackJoinedIntegration.integrationType) && Intrinsics3.areEqual(this.integrationUser, trackJoinedIntegration.integrationUser) && Intrinsics3.areEqual(this.userDay, trackJoinedIntegration.userDay) && Intrinsics3.areEqual(this.userGuilds, trackJoinedIntegration.userGuilds);
    }

    public int hashCode() {
        Long l = this.guild;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildOwner;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.integration;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.integrationType;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l3 = this.integrationUser;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.userDay;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.userGuilds;
        return iHashCode6 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackJoinedIntegration(guild=");
        sbM833U.append(this.guild);
        sbM833U.append(", guildOwner=");
        sbM833U.append(this.guildOwner);
        sbM833U.append(", integration=");
        sbM833U.append(this.integration);
        sbM833U.append(", integrationType=");
        sbM833U.append(this.integrationType);
        sbM833U.append(", integrationUser=");
        sbM833U.append(this.integrationUser);
        sbM833U.append(", userDay=");
        sbM833U.append(this.userDay);
        sbM833U.append(", userGuilds=");
        return outline.m819G(sbM833U, this.userGuilds, ")");
    }
}
