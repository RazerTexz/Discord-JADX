package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackUpdateUserSettingsLocal.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackUpdateUserSettingsLocal implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean alwaysPreviewVideo = null;
    private final Boolean showSnowsgiving2021 = null;
    private final transient String analyticsSchemaTypeName = "update_user_settings_local";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUpdateUserSettingsLocal)) {
            return false;
        }
        TrackUpdateUserSettingsLocal trackUpdateUserSettingsLocal = (TrackUpdateUserSettingsLocal) other;
        return Intrinsics3.areEqual(this.alwaysPreviewVideo, trackUpdateUserSettingsLocal.alwaysPreviewVideo) && Intrinsics3.areEqual(this.showSnowsgiving2021, trackUpdateUserSettingsLocal.showSnowsgiving2021);
    }

    public int hashCode() {
        Boolean bool = this.alwaysPreviewVideo;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.showSnowsgiving2021;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackUpdateUserSettingsLocal(alwaysPreviewVideo=");
        sbM833U.append(this.alwaysPreviewVideo);
        sbM833U.append(", showSnowsgiving2021=");
        return outline.m816D(sbM833U, this.showSnowsgiving2021, ")");
    }
}
