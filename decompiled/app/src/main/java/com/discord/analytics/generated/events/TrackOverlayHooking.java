package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackOverlayHooking.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackOverlayHooking implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence nonce = null;
    private final CharSequence gameName = null;
    private final CharSequence cpu = null;
    private final CharSequence gpu = null;
    private final transient String analyticsSchemaTypeName = "overlay_hooking";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
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
        StringBuilder sbU = outline.U("TrackOverlayHooking(nonce=");
        sbU.append(this.nonce);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", cpu=");
        sbU.append(this.cpu);
        sbU.append(", gpu=");
        return outline.E(sbU, this.gpu, ")");
    }
}
