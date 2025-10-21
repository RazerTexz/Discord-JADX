package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackPermissionsAcked.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackPermissionsAcked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence type = null;
    private final CharSequence action = null;
    private final CharSequence previousAction = null;
    private final transient String analyticsSchemaTypeName = "permissions_acked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPermissionsAcked)) {
            return false;
        }
        TrackPermissionsAcked trackPermissionsAcked = (TrackPermissionsAcked) other;
        return Intrinsics3.areEqual(this.type, trackPermissionsAcked.type) && Intrinsics3.areEqual(this.action, trackPermissionsAcked.action) && Intrinsics3.areEqual(this.previousAction, trackPermissionsAcked.previousAction);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.action;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.previousAction;
        return iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPermissionsAcked(type=");
        sbU.append(this.type);
        sbU.append(", action=");
        sbU.append(this.action);
        sbU.append(", previousAction=");
        return outline.E(sbU, this.previousAction, ")");
    }
}
