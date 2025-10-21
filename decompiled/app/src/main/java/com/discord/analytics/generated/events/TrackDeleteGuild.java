package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackDeleteGuild.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackDeleteGuild implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final Long guildSizeTotal = null;
    private final Long guildNumChannels = null;
    private final Long guildNumTextChannels = null;
    private final Long guildNumVoiceChannels = null;
    private final Long guildNumRoles = null;
    private final Boolean guildIsVip = null;
    private final transient String analyticsSchemaTypeName = "delete_guild";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDeleteGuild)) {
            return false;
        }
        TrackDeleteGuild trackDeleteGuild = (TrackDeleteGuild) other;
        return Intrinsics3.areEqual(this.guildId, trackDeleteGuild.guildId) && Intrinsics3.areEqual(this.guildName, trackDeleteGuild.guildName) && Intrinsics3.areEqual(this.guildSizeTotal, trackDeleteGuild.guildSizeTotal) && Intrinsics3.areEqual(this.guildNumChannels, trackDeleteGuild.guildNumChannels) && Intrinsics3.areEqual(this.guildNumTextChannels, trackDeleteGuild.guildNumTextChannels) && Intrinsics3.areEqual(this.guildNumVoiceChannels, trackDeleteGuild.guildNumVoiceChannels) && Intrinsics3.areEqual(this.guildNumRoles, trackDeleteGuild.guildNumRoles) && Intrinsics3.areEqual(this.guildIsVip, trackDeleteGuild.guildIsVip);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.guildName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.guildSizeTotal;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildNumChannels;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildNumTextChannels;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.guildNumVoiceChannels;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.guildNumRoles;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Boolean bool = this.guildIsVip;
        return iHashCode7 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackDeleteGuild(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", guildSizeTotal=");
        sbU.append(this.guildSizeTotal);
        sbU.append(", guildNumChannels=");
        sbU.append(this.guildNumChannels);
        sbU.append(", guildNumTextChannels=");
        sbU.append(this.guildNumTextChannels);
        sbU.append(", guildNumVoiceChannels=");
        sbU.append(this.guildNumVoiceChannels);
        sbU.append(", guildNumRoles=");
        sbU.append(this.guildNumRoles);
        sbU.append(", guildIsVip=");
        return outline.D(sbU, this.guildIsVip, ")");
    }
}
