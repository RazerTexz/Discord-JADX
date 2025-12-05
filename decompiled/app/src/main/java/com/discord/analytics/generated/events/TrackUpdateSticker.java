package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackUpdateSticker.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackUpdateSticker implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long id = null;
    private final Long guildId = null;
    private final Long formatType = null;
    private final transient String analyticsSchemaTypeName = "update_sticker";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUpdateSticker)) {
            return false;
        }
        TrackUpdateSticker trackUpdateSticker = (TrackUpdateSticker) other;
        return Intrinsics3.areEqual(this.id, trackUpdateSticker.id) && Intrinsics3.areEqual(this.guildId, trackUpdateSticker.guildId) && Intrinsics3.areEqual(this.formatType, trackUpdateSticker.formatType);
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.formatType;
        return iHashCode2 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackUpdateSticker(id=");
        sbM833U.append(this.id);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", formatType=");
        return outline.m819G(sbM833U, this.formatType, ")");
    }
}
