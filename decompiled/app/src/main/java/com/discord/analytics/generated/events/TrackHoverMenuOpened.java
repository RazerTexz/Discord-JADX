package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackHoverMenuOpened.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackHoverMenuOpened implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence loadId = null;
    private final Long numUsers = null;
    private final transient String analyticsSchemaTypeName = "hover_menu_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackHoverMenuOpened)) {
            return false;
        }
        TrackHoverMenuOpened trackHoverMenuOpened = (TrackHoverMenuOpened) other;
        return Intrinsics3.areEqual(this.loadId, trackHoverMenuOpened.loadId) && Intrinsics3.areEqual(this.numUsers, trackHoverMenuOpened.numUsers);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.numUsers;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackHoverMenuOpened(loadId=");
        sbU.append(this.loadId);
        sbU.append(", numUsers=");
        return outline.G(sbU, this.numUsers, ")");
    }
}
