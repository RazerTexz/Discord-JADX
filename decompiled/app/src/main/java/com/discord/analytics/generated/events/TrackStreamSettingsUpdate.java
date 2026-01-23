package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackStreamSettingsUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStreamSettingsUpdate implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long userPremiumTier = null;
    private final Long guildPremiumTier = null;
    private final Long streamQualityUserPremiumTier = null;
    private final Long streamQualityGuildPremiumTier = null;
    private final Long streamQualityPreset = null;
    private final Long streamQualityResolution = null;
    private final Long streamQualityFrameRate = null;
    private final transient String analyticsSchemaTypeName = "stream_settings_update";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStreamSettingsUpdate)) {
            return false;
        }
        TrackStreamSettingsUpdate trackStreamSettingsUpdate = (TrackStreamSettingsUpdate) other;
        return Intrinsics3.areEqual(this.userPremiumTier, trackStreamSettingsUpdate.userPremiumTier) && Intrinsics3.areEqual(this.guildPremiumTier, trackStreamSettingsUpdate.guildPremiumTier) && Intrinsics3.areEqual(this.streamQualityUserPremiumTier, trackStreamSettingsUpdate.streamQualityUserPremiumTier) && Intrinsics3.areEqual(this.streamQualityGuildPremiumTier, trackStreamSettingsUpdate.streamQualityGuildPremiumTier) && Intrinsics3.areEqual(this.streamQualityPreset, trackStreamSettingsUpdate.streamQualityPreset) && Intrinsics3.areEqual(this.streamQualityResolution, trackStreamSettingsUpdate.streamQualityResolution) && Intrinsics3.areEqual(this.streamQualityFrameRate, trackStreamSettingsUpdate.streamQualityFrameRate);
    }

    public int hashCode() {
        Long l = this.userPremiumTier;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildPremiumTier;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.streamQualityUserPremiumTier;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.streamQualityGuildPremiumTier;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.streamQualityPreset;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.streamQualityResolution;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.streamQualityFrameRate;
        return iHashCode6 + (l7 != null ? l7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackStreamSettingsUpdate(userPremiumTier=");
        sbM833U.append(this.userPremiumTier);
        sbM833U.append(", guildPremiumTier=");
        sbM833U.append(this.guildPremiumTier);
        sbM833U.append(", streamQualityUserPremiumTier=");
        sbM833U.append(this.streamQualityUserPremiumTier);
        sbM833U.append(", streamQualityGuildPremiumTier=");
        sbM833U.append(this.streamQualityGuildPremiumTier);
        sbM833U.append(", streamQualityPreset=");
        sbM833U.append(this.streamQualityPreset);
        sbM833U.append(", streamQualityResolution=");
        sbM833U.append(this.streamQualityResolution);
        sbM833U.append(", streamQualityFrameRate=");
        return outline.m819G(sbM833U, this.streamQualityFrameRate, ")");
    }
}
