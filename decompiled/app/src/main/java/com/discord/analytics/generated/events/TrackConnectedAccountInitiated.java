package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackConnectedAccountInitiated.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackConnectedAccountInitiated implements AnalyticsSchema, TrackBase2 {
    private final transient String analyticsSchemaTypeName;
    private final CharSequence platformType;
    private TrackBase trackBase;

    public TrackConnectedAccountInitiated() {
        this.platformType = null;
        this.analyticsSchemaTypeName = "connected_account_initiated";
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    /* renamed from: e */
    public void m7510e(TrackBase trackBase) {
        this.trackBase = trackBase;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackConnectedAccountInitiated) && Intrinsics3.areEqual(this.platformType, ((TrackConnectedAccountInitiated) other).platformType);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.platformType;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m817E(outline.m833U("TrackConnectedAccountInitiated(platformType="), this.platformType, ")");
    }

    public TrackConnectedAccountInitiated(CharSequence charSequence) {
        this.platformType = charSequence;
        this.analyticsSchemaTypeName = "connected_account_initiated";
    }
}
