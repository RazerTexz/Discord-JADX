package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* compiled from: TrackStarredChannelsLayoutToggled.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackStarredChannelsLayoutToggled implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final CharSequence selectedLayout = null;
    private final transient String analyticsSchemaTypeName = "starred_channels_layout_toggled";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
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
            return (other instanceof TrackStarredChannelsLayoutToggled) && m.areEqual(this.selectedLayout, ((TrackStarredChannelsLayoutToggled) other).selectedLayout);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.selectedLayout;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.E(a.U("TrackStarredChannelsLayoutToggled(selectedLayout="), this.selectedLayout, ")");
    }
}
