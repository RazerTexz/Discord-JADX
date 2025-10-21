package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackDetectPlatformAccount.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackDetectPlatformAccount implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence platformType = null;
    private final CharSequence displayType = null;
    private final transient String analyticsSchemaTypeName = "detect_platform_account";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDetectPlatformAccount)) {
            return false;
        }
        TrackDetectPlatformAccount trackDetectPlatformAccount = (TrackDetectPlatformAccount) other;
        return Intrinsics3.areEqual(this.platformType, trackDetectPlatformAccount.platformType) && Intrinsics3.areEqual(this.displayType, trackDetectPlatformAccount.displayType);
    }

    public int hashCode() {
        CharSequence charSequence = this.platformType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.displayType;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackDetectPlatformAccount(platformType=");
        sbU.append(this.platformType);
        sbU.append(", displayType=");
        return outline.E(sbU, this.displayType, ")");
    }
}
