package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackQuickswitcherOpened.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackQuickswitcherOpened implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence source = null;
    private final Long currentGuildId = null;
    private final Long currentChannelId = null;
    private final Long currentChannelType = null;
    private final transient String analyticsSchemaTypeName = "quickswitcher_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackQuickswitcherOpened)) {
            return false;
        }
        TrackQuickswitcherOpened trackQuickswitcherOpened = (TrackQuickswitcherOpened) other;
        return Intrinsics3.areEqual(this.source, trackQuickswitcherOpened.source) && Intrinsics3.areEqual(this.currentGuildId, trackQuickswitcherOpened.currentGuildId) && Intrinsics3.areEqual(this.currentChannelId, trackQuickswitcherOpened.currentChannelId) && Intrinsics3.areEqual(this.currentChannelType, trackQuickswitcherOpened.currentChannelType);
    }

    public int hashCode() {
        CharSequence charSequence = this.source;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.currentGuildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.currentChannelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.currentChannelType;
        return iHashCode3 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackQuickswitcherOpened(source=");
        sbM833U.append(this.source);
        sbM833U.append(", currentGuildId=");
        sbM833U.append(this.currentGuildId);
        sbM833U.append(", currentChannelId=");
        sbM833U.append(this.currentChannelId);
        sbM833U.append(", currentChannelType=");
        return outline.m819G(sbM833U, this.currentChannelType, ")");
    }
}
