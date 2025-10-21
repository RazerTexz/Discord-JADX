package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackExternalFingerprintDropped.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackExternalFingerprintDropped implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long fingerprint = null;
    private final Long droppedFingerprint = null;
    private final transient String analyticsSchemaTypeName = "external_fingerprint_dropped";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackExternalFingerprintDropped)) {
            return false;
        }
        TrackExternalFingerprintDropped trackExternalFingerprintDropped = (TrackExternalFingerprintDropped) other;
        return Intrinsics3.areEqual(this.fingerprint, trackExternalFingerprintDropped.fingerprint) && Intrinsics3.areEqual(this.droppedFingerprint, trackExternalFingerprintDropped.droppedFingerprint);
    }

    public int hashCode() {
        Long l = this.fingerprint;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.droppedFingerprint;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackExternalFingerprintDropped(fingerprint=");
        sbU.append(this.fingerprint);
        sbU.append(", droppedFingerprint=");
        return outline.G(sbU, this.droppedFingerprint, ")");
    }
}
