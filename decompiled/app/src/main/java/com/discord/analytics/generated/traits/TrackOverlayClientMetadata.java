package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackOverlayClientMetadata.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackOverlayClientMetadata {
    private final Long overlayGameId = null;
    private final CharSequence overlayGameName = null;
    private final Long overlayAppId = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayClientMetadata)) {
            return false;
        }
        TrackOverlayClientMetadata trackOverlayClientMetadata = (TrackOverlayClientMetadata) other;
        return Intrinsics3.areEqual(this.overlayGameId, trackOverlayClientMetadata.overlayGameId) && Intrinsics3.areEqual(this.overlayGameName, trackOverlayClientMetadata.overlayGameName) && Intrinsics3.areEqual(this.overlayAppId, trackOverlayClientMetadata.overlayAppId);
    }

    public int hashCode() {
        Long l = this.overlayGameId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.overlayGameName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.overlayAppId;
        return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackOverlayClientMetadata(overlayGameId=");
        sbM833U.append(this.overlayGameId);
        sbM833U.append(", overlayGameName=");
        sbM833U.append(this.overlayGameName);
        sbM833U.append(", overlayAppId=");
        return outline.m819G(sbM833U, this.overlayAppId, ")");
    }
}
