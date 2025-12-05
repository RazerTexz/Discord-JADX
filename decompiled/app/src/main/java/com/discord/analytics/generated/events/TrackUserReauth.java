package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackUserReauth.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackUserReauth implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean success = null;
    private final transient String analyticsSchemaTypeName = "user_reauth";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackUserReauth) && Intrinsics3.areEqual(this.success, ((TrackUserReauth) other).success);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.success;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m816D(outline.m833U("TrackUserReauth(success="), this.success, ")");
    }
}
