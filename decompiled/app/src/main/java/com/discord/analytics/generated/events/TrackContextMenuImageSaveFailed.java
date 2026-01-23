package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackContextMenuImageSaveFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackContextMenuImageSaveFailed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final CharSequence url = null;
    private final transient String analyticsSchemaTypeName = "context_menu_image_save_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackContextMenuImageSaveFailed)) {
            return false;
        }
        TrackContextMenuImageSaveFailed trackContextMenuImageSaveFailed = (TrackContextMenuImageSaveFailed) other;
        return Intrinsics3.areEqual(this.channelId, trackContextMenuImageSaveFailed.channelId) && Intrinsics3.areEqual(this.url, trackContextMenuImageSaveFailed.url);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.url;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackContextMenuImageSaveFailed(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", url=");
        return outline.m817E(sbM833U, this.url, ")");
    }
}
