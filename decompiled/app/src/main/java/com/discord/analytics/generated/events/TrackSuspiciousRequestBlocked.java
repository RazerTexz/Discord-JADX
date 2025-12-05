package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackSuspiciousRequestBlocked.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackSuspiciousRequestBlocked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence email = null;
    private final CharSequence headers = null;
    private final CharSequence path = null;
    private final CharSequence host = null;
    private final CharSequence endpoint = null;
    private final Boolean wasVerified = null;
    private final Boolean wasEmailVerificationNeeded = null;
    private final transient String analyticsSchemaTypeName = "suspicious_request_blocked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSuspiciousRequestBlocked)) {
            return false;
        }
        TrackSuspiciousRequestBlocked trackSuspiciousRequestBlocked = (TrackSuspiciousRequestBlocked) other;
        return Intrinsics3.areEqual(this.email, trackSuspiciousRequestBlocked.email) && Intrinsics3.areEqual(this.headers, trackSuspiciousRequestBlocked.headers) && Intrinsics3.areEqual(this.path, trackSuspiciousRequestBlocked.path) && Intrinsics3.areEqual(this.host, trackSuspiciousRequestBlocked.host) && Intrinsics3.areEqual(this.endpoint, trackSuspiciousRequestBlocked.endpoint) && Intrinsics3.areEqual(this.wasVerified, trackSuspiciousRequestBlocked.wasVerified) && Intrinsics3.areEqual(this.wasEmailVerificationNeeded, trackSuspiciousRequestBlocked.wasEmailVerificationNeeded);
    }

    public int hashCode() {
        CharSequence charSequence = this.email;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.headers;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.path;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.host;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.endpoint;
        int iHashCode5 = (iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Boolean bool = this.wasVerified;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.wasEmailVerificationNeeded;
        return iHashCode6 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackSuspiciousRequestBlocked(email=");
        sbM833U.append(this.email);
        sbM833U.append(", headers=");
        sbM833U.append(this.headers);
        sbM833U.append(", path=");
        sbM833U.append(this.path);
        sbM833U.append(", host=");
        sbM833U.append(this.host);
        sbM833U.append(", endpoint=");
        sbM833U.append(this.endpoint);
        sbM833U.append(", wasVerified=");
        sbM833U.append(this.wasVerified);
        sbM833U.append(", wasEmailVerificationNeeded=");
        return outline.m816D(sbM833U, this.wasEmailVerificationNeeded, ")");
    }
}
