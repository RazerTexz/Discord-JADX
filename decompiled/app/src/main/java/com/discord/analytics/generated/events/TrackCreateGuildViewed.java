package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuildTemplate;
import com.discord.analytics.generated.traits.TrackGuildTemplate2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackCreateGuildViewed.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackCreateGuildViewed implements AnalyticsSchema, TrackBase2, TrackGuildTemplate2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackGuildTemplate trackGuildTemplate;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence flowStep = null;
    private final transient String analyticsSchemaTypeName = "create_guild_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackCreateGuildViewed) && Intrinsics3.areEqual(this.flowStep, ((TrackCreateGuildViewed) other).flowStep);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.flowStep;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m817E(outline.m833U("TrackCreateGuildViewed(flowStep="), this.flowStep, ")");
    }
}
