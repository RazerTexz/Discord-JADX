package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackAuthorizeLoginLocation.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAuthorizeLoginLocation implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence authorizedIp = null;
    private final transient String analyticsSchemaTypeName = "authorize_login_location";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackAuthorizeLoginLocation) && Intrinsics3.areEqual(this.authorizedIp, ((TrackAuthorizeLoginLocation) other).authorizedIp);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.authorizedIp;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m817E(outline.m833U("TrackAuthorizeLoginLocation(authorizedIp="), this.authorizedIp, ")");
    }
}
