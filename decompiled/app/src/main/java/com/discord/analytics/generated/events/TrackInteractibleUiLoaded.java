package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackInteractibleUiLoaded.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackInteractibleUiLoaded implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence loadId = null;
    private final CharSequence type = null;
    private final transient String analyticsSchemaTypeName = "interactible_ui_loaded";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInteractibleUiLoaded)) {
            return false;
        }
        TrackInteractibleUiLoaded trackInteractibleUiLoaded = (TrackInteractibleUiLoaded) other;
        return Intrinsics3.areEqual(this.loadId, trackInteractibleUiLoaded.loadId) && Intrinsics3.areEqual(this.type, trackInteractibleUiLoaded.type);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.type;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackInteractibleUiLoaded(loadId=");
        sbU.append(this.loadId);
        sbU.append(", type=");
        return outline.E(sbU, this.type, ")");
    }
}
