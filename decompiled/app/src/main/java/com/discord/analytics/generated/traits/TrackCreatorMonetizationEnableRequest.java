package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackCreatorMonetizationEnableRequest.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackCreatorMonetizationEnableRequest {
    private final Long creatorMonetizationEnableRequestId = null;
    private final CharSequence state = null;
    private final CharSequence actionedReason = null;
    private final CharSequence actionedNote = null;
    private final Long actionedAt = null;
    private final Long termsAckedAt = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCreatorMonetizationEnableRequest)) {
            return false;
        }
        TrackCreatorMonetizationEnableRequest trackCreatorMonetizationEnableRequest = (TrackCreatorMonetizationEnableRequest) other;
        return Intrinsics3.areEqual(this.creatorMonetizationEnableRequestId, trackCreatorMonetizationEnableRequest.creatorMonetizationEnableRequestId) && Intrinsics3.areEqual(this.state, trackCreatorMonetizationEnableRequest.state) && Intrinsics3.areEqual(this.actionedReason, trackCreatorMonetizationEnableRequest.actionedReason) && Intrinsics3.areEqual(this.actionedNote, trackCreatorMonetizationEnableRequest.actionedNote) && Intrinsics3.areEqual(this.actionedAt, trackCreatorMonetizationEnableRequest.actionedAt) && Intrinsics3.areEqual(this.termsAckedAt, trackCreatorMonetizationEnableRequest.termsAckedAt);
    }

    public int hashCode() {
        Long l = this.creatorMonetizationEnableRequestId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.state;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.actionedReason;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.actionedNote;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l2 = this.actionedAt;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.termsAckedAt;
        return iHashCode5 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackCreatorMonetizationEnableRequest(creatorMonetizationEnableRequestId=");
        sbM833U.append(this.creatorMonetizationEnableRequestId);
        sbM833U.append(", state=");
        sbM833U.append(this.state);
        sbM833U.append(", actionedReason=");
        sbM833U.append(this.actionedReason);
        sbM833U.append(", actionedNote=");
        sbM833U.append(this.actionedNote);
        sbM833U.append(", actionedAt=");
        sbM833U.append(this.actionedAt);
        sbM833U.append(", termsAckedAt=");
        return outline.m819G(sbM833U, this.termsAckedAt, ")");
    }
}
