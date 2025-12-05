package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackGuildCreationIntentSelected.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildCreationIntentSelected implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean isCommunity = null;
    private final Boolean skipped = null;
    private final transient String analyticsSchemaTypeName = "guild_creation_intent_selected";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildCreationIntentSelected)) {
            return false;
        }
        TrackGuildCreationIntentSelected trackGuildCreationIntentSelected = (TrackGuildCreationIntentSelected) other;
        return Intrinsics3.areEqual(this.isCommunity, trackGuildCreationIntentSelected.isCommunity) && Intrinsics3.areEqual(this.skipped, trackGuildCreationIntentSelected.skipped);
    }

    public int hashCode() {
        Boolean bool = this.isCommunity;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.skipped;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackGuildCreationIntentSelected(isCommunity=");
        sbM833U.append(this.isCommunity);
        sbM833U.append(", skipped=");
        return outline.m816D(sbM833U, this.skipped, ")");
    }
}
