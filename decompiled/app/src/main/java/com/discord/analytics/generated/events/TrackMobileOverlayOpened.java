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

/* compiled from: TrackMobileOverlayOpened.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackMobileOverlayOpened implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence type = null;
    private final CharSequence rtcConnectionId = null;
    private final Boolean previewEnabled = null;
    private final transient String analyticsSchemaTypeName = "mobile_overlay_opened";

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
        if (!(other instanceof TrackMobileOverlayOpened)) {
            return false;
        }
        TrackMobileOverlayOpened trackMobileOverlayOpened = (TrackMobileOverlayOpened) other;
        return Intrinsics3.areEqual(this.type, trackMobileOverlayOpened.type) && Intrinsics3.areEqual(this.rtcConnectionId, trackMobileOverlayOpened.rtcConnectionId) && Intrinsics3.areEqual(this.previewEnabled, trackMobileOverlayOpened.previewEnabled);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.rtcConnectionId;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.previewEnabled;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackMobileOverlayOpened(type=");
        sbM833U.append(this.type);
        sbM833U.append(", rtcConnectionId=");
        sbM833U.append(this.rtcConnectionId);
        sbM833U.append(", previewEnabled=");
        return outline.m816D(sbM833U, this.previewEnabled, ")");
    }
}
