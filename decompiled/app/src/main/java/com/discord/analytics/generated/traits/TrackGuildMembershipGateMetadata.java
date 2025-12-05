package com.discord.analytics.generated.traits;

import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackGuildMembershipGateMetadata.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildMembershipGateMetadata {
    private final Boolean previewEnabled = null;
    private final List<CharSequence> requirements = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildMembershipGateMetadata)) {
            return false;
        }
        TrackGuildMembershipGateMetadata trackGuildMembershipGateMetadata = (TrackGuildMembershipGateMetadata) other;
        return Intrinsics3.areEqual(this.previewEnabled, trackGuildMembershipGateMetadata.previewEnabled) && Intrinsics3.areEqual(this.requirements, trackGuildMembershipGateMetadata.requirements);
    }

    public int hashCode() {
        Boolean bool = this.previewEnabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        List<CharSequence> list = this.requirements;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackGuildMembershipGateMetadata(previewEnabled=");
        sbM833U.append(this.previewEnabled);
        sbM833U.append(", requirements=");
        return outline.m824L(sbM833U, this.requirements, ")");
    }
}
