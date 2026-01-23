package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackPremiumGuildPendingModal.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPremiumGuildPendingModal implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final transient String analyticsSchemaTypeName = "premium_guild_pending_modal";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackPremiumGuildPendingModal) && Intrinsics3.areEqual(this.guildId, ((TrackPremiumGuildPendingModal) other).guildId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.guildId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m819G(outline.m833U("TrackPremiumGuildPendingModal(guildId="), this.guildId, ")");
    }
}
