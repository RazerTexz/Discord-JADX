package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackGuildTemplateOpened.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildTemplateOpened implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence guildTemplateCode = null;
    private final Long loadTime = null;
    private final transient String analyticsSchemaTypeName = "guild_template_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildTemplateOpened)) {
            return false;
        }
        TrackGuildTemplateOpened trackGuildTemplateOpened = (TrackGuildTemplateOpened) other;
        return Intrinsics3.areEqual(this.guildTemplateCode, trackGuildTemplateOpened.guildTemplateCode) && Intrinsics3.areEqual(this.loadTime, trackGuildTemplateOpened.loadTime);
    }

    public int hashCode() {
        CharSequence charSequence = this.guildTemplateCode;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.loadTime;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackGuildTemplateOpened(guildTemplateCode=");
        sbM833U.append(this.guildTemplateCode);
        sbM833U.append(", loadTime=");
        return outline.m819G(sbM833U, this.loadTime, ")");
    }
}
