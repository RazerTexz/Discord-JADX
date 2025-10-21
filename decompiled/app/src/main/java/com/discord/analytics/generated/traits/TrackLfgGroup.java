package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: TrackLfgGroup.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackLfgGroup {
    private final CharSequence gameName = null;
    private final Long gameId = null;
    private final Long totalSize = null;
    private final Long freeSize = null;
    private final Long ownerId = null;
    private final CharSequence title = null;
    private final CharSequence description = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLfgGroup)) {
            return false;
        }
        TrackLfgGroup trackLfgGroup = (TrackLfgGroup) other;
        return Intrinsics3.areEqual(this.gameName, trackLfgGroup.gameName) && Intrinsics3.areEqual(this.gameId, trackLfgGroup.gameId) && Intrinsics3.areEqual(this.totalSize, trackLfgGroup.totalSize) && Intrinsics3.areEqual(this.freeSize, trackLfgGroup.freeSize) && Intrinsics3.areEqual(this.ownerId, trackLfgGroup.ownerId) && Intrinsics3.areEqual(this.title, trackLfgGroup.title) && Intrinsics3.areEqual(this.description, trackLfgGroup.description);
    }

    public int hashCode() {
        CharSequence charSequence = this.gameName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.gameId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.totalSize;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.freeSize;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.ownerId;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.title;
        int iHashCode6 = (iHashCode5 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.description;
        return iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackLfgGroup(gameName=");
        sbU.append(this.gameName);
        sbU.append(", gameId=");
        sbU.append(this.gameId);
        sbU.append(", totalSize=");
        sbU.append(this.totalSize);
        sbU.append(", freeSize=");
        sbU.append(this.freeSize);
        sbU.append(", ownerId=");
        sbU.append(this.ownerId);
        sbU.append(", title=");
        sbU.append(this.title);
        sbU.append(", description=");
        return outline.E(sbU, this.description, ")");
    }
}
