package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackActiveChannelClicked.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackActiveChannelClicked implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long textChannelsShown = null;
    private final Long voiceChannelsShown = null;
    private final CharSequence homeSessionId = null;
    private final transient String analyticsSchemaTypeName = "active_channel_clicked";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActiveChannelClicked)) {
            return false;
        }
        TrackActiveChannelClicked trackActiveChannelClicked = (TrackActiveChannelClicked) other;
        return Intrinsics3.areEqual(this.textChannelsShown, trackActiveChannelClicked.textChannelsShown) && Intrinsics3.areEqual(this.voiceChannelsShown, trackActiveChannelClicked.voiceChannelsShown) && Intrinsics3.areEqual(this.homeSessionId, trackActiveChannelClicked.homeSessionId);
    }

    public int hashCode() {
        Long l = this.textChannelsShown;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.voiceChannelsShown;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.homeSessionId;
        return iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackActiveChannelClicked(textChannelsShown=");
        sbM833U.append(this.textChannelsShown);
        sbM833U.append(", voiceChannelsShown=");
        sbM833U.append(this.voiceChannelsShown);
        sbM833U.append(", homeSessionId=");
        return outline.m817E(sbM833U, this.homeSessionId, ")");
    }
}
