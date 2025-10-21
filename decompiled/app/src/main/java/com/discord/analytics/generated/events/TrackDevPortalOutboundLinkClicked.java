package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackDevPortalOutboundLinkClicked.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackDevPortalOutboundLinkClicked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence href = null;
    private final transient String analyticsSchemaTypeName = "dev_portal_outbound_link_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackDevPortalOutboundLinkClicked) && Intrinsics3.areEqual(this.href, ((TrackDevPortalOutboundLinkClicked) other).href);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.href;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("TrackDevPortalOutboundLinkClicked(href="), this.href, ")");
    }
}
