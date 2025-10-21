package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackContextMenuImageCopied.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackContextMenuImageCopied implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final CharSequence url = null;
    private final transient String analyticsSchemaTypeName = "context_menu_image_copied";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackContextMenuImageCopied)) {
            return false;
        }
        TrackContextMenuImageCopied trackContextMenuImageCopied = (TrackContextMenuImageCopied) other;
        return Intrinsics3.areEqual(this.channelId, trackContextMenuImageCopied.channelId) && Intrinsics3.areEqual(this.url, trackContextMenuImageCopied.url);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.url;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackContextMenuImageCopied(channelId=");
        sbU.append(this.channelId);
        sbU.append(", url=");
        return outline.E(sbU, this.url, ")");
    }
}
