package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackDispatchStats.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackDispatchStats {
    private final CharSequence stage = null;
    private final Long progressPercent = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDispatchStats)) {
            return false;
        }
        TrackDispatchStats trackDispatchStats = (TrackDispatchStats) other;
        return Intrinsics3.areEqual(this.stage, trackDispatchStats.stage) && Intrinsics3.areEqual(this.progressPercent, trackDispatchStats.progressPercent);
    }

    public int hashCode() {
        CharSequence charSequence = this.stage;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.progressPercent;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackDispatchStats(stage=");
        sbM833U.append(this.stage);
        sbM833U.append(", progressPercent=");
        return outline.m819G(sbM833U, this.progressPercent, ")");
    }
}
