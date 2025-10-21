package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackExpressionPickerOpened.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackExpressionPickerOpened implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence tab = null;
    private final Long width = null;
    private final Boolean badged = null;
    private final transient String analyticsSchemaTypeName = "expression_picker_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackExpressionPickerOpened)) {
            return false;
        }
        TrackExpressionPickerOpened trackExpressionPickerOpened = (TrackExpressionPickerOpened) other;
        return Intrinsics3.areEqual(this.tab, trackExpressionPickerOpened.tab) && Intrinsics3.areEqual(this.width, trackExpressionPickerOpened.width) && Intrinsics3.areEqual(this.badged, trackExpressionPickerOpened.badged);
    }

    public int hashCode() {
        CharSequence charSequence = this.tab;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.width;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.badged;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackExpressionPickerOpened(tab=");
        sbU.append(this.tab);
        sbU.append(", width=");
        sbU.append(this.width);
        sbU.append(", badged=");
        return outline.D(sbU, this.badged, ")");
    }
}
