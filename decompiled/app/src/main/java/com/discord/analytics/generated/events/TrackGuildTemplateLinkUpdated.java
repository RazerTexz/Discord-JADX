package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackGuildTemplate;
import com.discord.analytics.generated.traits.TrackGuildTemplate2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackGuildTemplateLinkUpdated.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildTemplateLinkUpdated implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackGuildTemplate2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private TrackGuildTemplate trackGuildTemplate;
    private final CharSequence updateType = null;
    private final transient String analyticsSchemaTypeName = "guild_template_link_updated";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackGuildTemplateLinkUpdated) && Intrinsics3.areEqual(this.updateType, ((TrackGuildTemplateLinkUpdated) other).updateType);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.updateType;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("TrackGuildTemplateLinkUpdated(updateType="), this.updateType, ")");
    }
}
