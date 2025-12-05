package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackImpressionMetadata.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackImpressionMetadata {
    private final CharSequence impressionGroup;
    private final CharSequence impressionName;
    private final CharSequence impressionType;
    private final CharSequence sequenceId;

    public TrackImpressionMetadata() {
        this(null, null, null, null, 15);
    }

    public TrackImpressionMetadata(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, int i) {
        int i2 = i & 1;
        int i3 = i & 2;
        int i4 = i & 4;
        charSequence4 = (i & 8) != 0 ? null : charSequence4;
        this.sequenceId = null;
        this.impressionName = null;
        this.impressionType = null;
        this.impressionGroup = charSequence4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackImpressionMetadata)) {
            return false;
        }
        TrackImpressionMetadata trackImpressionMetadata = (TrackImpressionMetadata) other;
        return Intrinsics3.areEqual(this.sequenceId, trackImpressionMetadata.sequenceId) && Intrinsics3.areEqual(this.impressionName, trackImpressionMetadata.impressionName) && Intrinsics3.areEqual(this.impressionType, trackImpressionMetadata.impressionType) && Intrinsics3.areEqual(this.impressionGroup, trackImpressionMetadata.impressionGroup);
    }

    public int hashCode() {
        CharSequence charSequence = this.sequenceId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.impressionName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.impressionType;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.impressionGroup;
        return iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackImpressionMetadata(sequenceId=");
        sbM833U.append(this.sequenceId);
        sbM833U.append(", impressionName=");
        sbM833U.append(this.impressionName);
        sbM833U.append(", impressionType=");
        sbM833U.append(this.impressionType);
        sbM833U.append(", impressionGroup=");
        return outline.m817E(sbM833U, this.impressionGroup, ")");
    }
}
