package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackFileSizeLimitExceeded.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackFileSizeLimitExceeded implements AnalyticsSchema, TrackBase2, TrackChannel2, TrackGuild2, TrackLocationMetadata2, TrackSourceMetadata2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private final Long limit = null;
    private final Long filesize = null;
    private final CharSequence type = null;
    private final transient String analyticsSchemaTypeName = "file_size_limit_exceeded";

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
        if (!(other instanceof TrackFileSizeLimitExceeded)) {
            return false;
        }
        TrackFileSizeLimitExceeded trackFileSizeLimitExceeded = (TrackFileSizeLimitExceeded) other;
        return Intrinsics3.areEqual(this.limit, trackFileSizeLimitExceeded.limit) && Intrinsics3.areEqual(this.filesize, trackFileSizeLimitExceeded.filesize) && Intrinsics3.areEqual(this.type, trackFileSizeLimitExceeded.type);
    }

    public int hashCode() {
        Long l = this.limit;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.filesize;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.type;
        return iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackFileSizeLimitExceeded(limit=");
        sbM833U.append(this.limit);
        sbM833U.append(", filesize=");
        sbM833U.append(this.filesize);
        sbM833U.append(", type=");
        return outline.m817E(sbM833U, this.type, ")");
    }
}
