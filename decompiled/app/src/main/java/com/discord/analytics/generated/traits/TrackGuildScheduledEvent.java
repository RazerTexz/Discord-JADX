package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackGuildScheduledEvent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildScheduledEvent {
    private final Boolean isEveryoneRoleVisible = null;
    private final Boolean associatedToDirectoryChannel = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildScheduledEvent)) {
            return false;
        }
        TrackGuildScheduledEvent trackGuildScheduledEvent = (TrackGuildScheduledEvent) other;
        return Intrinsics3.areEqual(this.isEveryoneRoleVisible, trackGuildScheduledEvent.isEveryoneRoleVisible) && Intrinsics3.areEqual(this.associatedToDirectoryChannel, trackGuildScheduledEvent.associatedToDirectoryChannel);
    }

    public int hashCode() {
        Boolean bool = this.isEveryoneRoleVisible;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.associatedToDirectoryChannel;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackGuildScheduledEvent(isEveryoneRoleVisible=");
        sbM833U.append(this.isEveryoneRoleVisible);
        sbM833U.append(", associatedToDirectoryChannel=");
        return outline.m816D(sbM833U, this.associatedToDirectoryChannel, ")");
    }
}
