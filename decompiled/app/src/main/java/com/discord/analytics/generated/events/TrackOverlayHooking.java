package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackOverlayHooking.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOverlayHooking implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence nonce = null;
    private final CharSequence gameName = null;
    private final CharSequence cpu = null;
    private final CharSequence gpu = null;
    private final transient String analyticsSchemaTypeName = "overlay_hooking";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayHooking)) {
            return false;
        }
        TrackOverlayHooking trackOverlayHooking = (TrackOverlayHooking) other;
        return Intrinsics3.areEqual(this.nonce, trackOverlayHooking.nonce) && Intrinsics3.areEqual(this.gameName, trackOverlayHooking.gameName) && Intrinsics3.areEqual(this.cpu, trackOverlayHooking.cpu) && Intrinsics3.areEqual(this.gpu, trackOverlayHooking.gpu);
    }

    public int hashCode() {
        CharSequence charSequence = this.nonce;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.gameName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.cpu;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.gpu;
        return iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackOverlayHooking(nonce=");
        sbM833U.append(this.nonce);
        sbM833U.append(", gameName=");
        sbM833U.append(this.gameName);
        sbM833U.append(", cpu=");
        sbM833U.append(this.cpu);
        sbM833U.append(", gpu=");
        return outline.m817E(sbM833U, this.gpu, ")");
    }
}
