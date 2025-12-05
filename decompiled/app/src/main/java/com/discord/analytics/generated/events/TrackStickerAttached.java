package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackStickerAttached.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackStickerAttached implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence source = null;
    private final Long stickerId = null;
    private final Boolean replaced = null;
    private final transient String analyticsSchemaTypeName = "sticker_attached";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStickerAttached)) {
            return false;
        }
        TrackStickerAttached trackStickerAttached = (TrackStickerAttached) other;
        return Intrinsics3.areEqual(this.source, trackStickerAttached.source) && Intrinsics3.areEqual(this.stickerId, trackStickerAttached.stickerId) && Intrinsics3.areEqual(this.replaced, trackStickerAttached.replaced);
    }

    public int hashCode() {
        CharSequence charSequence = this.source;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.stickerId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.replaced;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackStickerAttached(source=");
        sbM833U.append(this.source);
        sbM833U.append(", stickerId=");
        sbM833U.append(this.stickerId);
        sbM833U.append(", replaced=");
        return outline.m816D(sbM833U, this.replaced, ")");
    }
}
