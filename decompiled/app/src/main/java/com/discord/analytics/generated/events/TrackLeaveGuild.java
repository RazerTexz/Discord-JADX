package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackLeaveGuild.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackLeaveGuild implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final transient String analyticsSchemaTypeName = "leave_guild";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLeaveGuild)) {
            return false;
        }
        TrackLeaveGuild trackLeaveGuild = (TrackLeaveGuild) other;
        return Intrinsics3.areEqual(this.guildId, trackLeaveGuild.guildId) && Intrinsics3.areEqual(this.guildName, trackLeaveGuild.guildName);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.guildName;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackLeaveGuild(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", guildName=");
        return outline.m817E(sbM833U, this.guildName, ")");
    }
}
