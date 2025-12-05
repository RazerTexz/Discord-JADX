package com.discord.analytics.generated.events.impression;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.generated.traits.TrackImpressionMetadata2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackImpressionSoundboardPopout.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackImpressionSoundboardPopout implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackImpressionMetadata2, TrackLocationMetadata2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackImpressionMetadata trackImpressionMetadata;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence mediaSessionId = null;
    private final CharSequence source = null;
    private final transient String analyticsSchemaTypeName = "impression_soundboard_popout";

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
        if (!(other instanceof TrackImpressionSoundboardPopout)) {
            return false;
        }
        TrackImpressionSoundboardPopout trackImpressionSoundboardPopout = (TrackImpressionSoundboardPopout) other;
        return Intrinsics3.areEqual(this.mediaSessionId, trackImpressionSoundboardPopout.mediaSessionId) && Intrinsics3.areEqual(this.source, trackImpressionSoundboardPopout.source);
    }

    public int hashCode() {
        CharSequence charSequence = this.mediaSessionId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.source;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackImpressionSoundboardPopout(mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", source=");
        return outline.m817E(sbM833U, this.source, ")");
    }
}
