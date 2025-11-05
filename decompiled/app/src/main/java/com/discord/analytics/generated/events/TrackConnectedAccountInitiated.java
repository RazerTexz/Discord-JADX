package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* compiled from: TrackConnectedAccountInitiated.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackConnectedAccountInitiated implements AnalyticsSchema, TrackBaseReceiver {
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

    public void e(TrackBase trackBase) {
        this.trackBase = trackBase;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackConnectedAccountInitiated) && m.areEqual(this.platformType, ((TrackConnectedAccountInitiated) other).platformType);
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
        return a.E(a.U("TrackConnectedAccountInitiated(platformType="), this.platformType, ")");
    }

    public TrackConnectedAccountInitiated(CharSequence charSequence) {
        this.platformType = charSequence;
        this.analyticsSchemaTypeName = "connected_account_initiated";
    }
}
