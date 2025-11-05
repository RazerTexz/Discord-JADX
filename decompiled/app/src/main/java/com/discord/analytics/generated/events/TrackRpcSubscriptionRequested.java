package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* compiled from: TrackRpcSubscriptionRequested.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackRpcSubscriptionRequested implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence scope = null;
    private final transient String analyticsSchemaTypeName = "rpc_subscription_requested";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackRpcSubscriptionRequested) && m.areEqual(this.scope, ((TrackRpcSubscriptionRequested) other).scope);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.scope;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.E(a.U("TrackRpcSubscriptionRequested(scope="), this.scope, ")");
    }
}
