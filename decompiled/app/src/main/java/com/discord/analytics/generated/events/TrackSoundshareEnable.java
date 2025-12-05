package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackSoundshareEnable.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackSoundshareEnable implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long statusCode = null;
    private final CharSequence message = null;
    private final transient String analyticsSchemaTypeName = "soundshare_enable";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSoundshareEnable)) {
            return false;
        }
        TrackSoundshareEnable trackSoundshareEnable = (TrackSoundshareEnable) other;
        return Intrinsics3.areEqual(this.statusCode, trackSoundshareEnable.statusCode) && Intrinsics3.areEqual(this.message, trackSoundshareEnable.message);
    }

    public int hashCode() {
        Long l = this.statusCode;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.message;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackSoundshareEnable(statusCode=");
        sbM833U.append(this.statusCode);
        sbM833U.append(", message=");
        return outline.m817E(sbM833U, this.message, ")");
    }
}
