package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackCreateEmoji.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackCreateEmoji implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Boolean animated = null;
    private final transient String analyticsSchemaTypeName = "create_emoji";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCreateEmoji)) {
            return false;
        }
        TrackCreateEmoji trackCreateEmoji = (TrackCreateEmoji) other;
        return Intrinsics3.areEqual(this.guildId, trackCreateEmoji.guildId) && Intrinsics3.areEqual(this.animated, trackCreateEmoji.animated);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Boolean bool = this.animated;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackCreateEmoji(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", animated=");
        return outline.m816D(sbM833U, this.animated, ")");
    }
}
