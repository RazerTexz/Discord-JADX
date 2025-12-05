package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackGuildTemplateSelected.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildTemplateSelected implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence templateName = null;
    private final CharSequence templateCode = null;
    private final transient String analyticsSchemaTypeName = "guild_template_selected";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildTemplateSelected)) {
            return false;
        }
        TrackGuildTemplateSelected trackGuildTemplateSelected = (TrackGuildTemplateSelected) other;
        return Intrinsics3.areEqual(this.templateName, trackGuildTemplateSelected.templateName) && Intrinsics3.areEqual(this.templateCode, trackGuildTemplateSelected.templateCode);
    }

    public int hashCode() {
        CharSequence charSequence = this.templateName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.templateCode;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackGuildTemplateSelected(templateName=");
        sbM833U.append(this.templateName);
        sbM833U.append(", templateCode=");
        return outline.m817E(sbM833U, this.templateCode, ")");
    }
}
