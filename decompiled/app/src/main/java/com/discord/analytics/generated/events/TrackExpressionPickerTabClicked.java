package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackExpressionPickerTabClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExpressionPickerTabClicked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence tab = null;
    private final Boolean badged = null;
    private final transient String analyticsSchemaTypeName = "expression_picker_tab_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackExpressionPickerTabClicked)) {
            return false;
        }
        TrackExpressionPickerTabClicked trackExpressionPickerTabClicked = (TrackExpressionPickerTabClicked) other;
        return Intrinsics3.areEqual(this.tab, trackExpressionPickerTabClicked.tab) && Intrinsics3.areEqual(this.badged, trackExpressionPickerTabClicked.badged);
    }

    public int hashCode() {
        CharSequence charSequence = this.tab;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.badged;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackExpressionPickerTabClicked(tab=");
        sbM833U.append(this.tab);
        sbM833U.append(", badged=");
        return outline.m816D(sbM833U, this.badged, ")");
    }
}
