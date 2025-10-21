package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackVerifyAccount.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackVerifyAccount implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence source = null;
    private final Long fingerprint = null;
    private final transient String analyticsSchemaTypeName = "verify_account";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVerifyAccount)) {
            return false;
        }
        TrackVerifyAccount trackVerifyAccount = (TrackVerifyAccount) other;
        return Intrinsics3.areEqual(this.source, trackVerifyAccount.source) && Intrinsics3.areEqual(this.fingerprint, trackVerifyAccount.fingerprint);
    }

    public int hashCode() {
        CharSequence charSequence = this.source;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.fingerprint;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVerifyAccount(source=");
        sbU.append(this.source);
        sbU.append(", fingerprint=");
        return outline.G(sbU, this.fingerprint, ")");
    }
}
