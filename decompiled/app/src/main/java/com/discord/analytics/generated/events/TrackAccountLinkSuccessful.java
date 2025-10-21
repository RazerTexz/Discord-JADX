package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackAccountLinkSuccessful.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackAccountLinkSuccessful implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence platformType = null;
    private final transient String analyticsSchemaTypeName = "account_link_successful";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackAccountLinkSuccessful) && Intrinsics3.areEqual(this.platformType, ((TrackAccountLinkSuccessful) other).platformType);
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
        return outline.E(outline.U("TrackAccountLinkSuccessful(platformType="), this.platformType, ")");
    }
}
