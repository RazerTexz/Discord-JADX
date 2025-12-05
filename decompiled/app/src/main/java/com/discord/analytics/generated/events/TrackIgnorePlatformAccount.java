package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackIgnorePlatformAccount.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackIgnorePlatformAccount implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence platformType = null;
    private final CharSequence displayType = null;
    private final transient String analyticsSchemaTypeName = "ignore_platform_account";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackIgnorePlatformAccount)) {
            return false;
        }
        TrackIgnorePlatformAccount trackIgnorePlatformAccount = (TrackIgnorePlatformAccount) other;
        return Intrinsics3.areEqual(this.platformType, trackIgnorePlatformAccount.platformType) && Intrinsics3.areEqual(this.displayType, trackIgnorePlatformAccount.displayType);
    }

    public int hashCode() {
        CharSequence charSequence = this.platformType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.displayType;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackIgnorePlatformAccount(platformType=");
        sbM833U.append(this.platformType);
        sbM833U.append(", displayType=");
        return outline.m817E(sbM833U, this.displayType, ")");
    }
}
