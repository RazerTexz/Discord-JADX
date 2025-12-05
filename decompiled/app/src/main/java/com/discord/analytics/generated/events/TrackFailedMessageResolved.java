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

/* compiled from: TrackFailedMessageResolved.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackFailedMessageResolved implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long numAttachments = null;
    private final Long maxAttachmentSize = null;
    private final Long totalAttachmentSize = null;
    private final Boolean hasImage = null;
    private final Boolean hasVideo = null;
    private final CharSequence resolutionType = null;
    private final Long initialAttemptTs = null;
    private final Long numRetries = null;
    private final Boolean previewEnabled = null;
    private final transient String analyticsSchemaTypeName = "failed_message_resolved";

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
        if (!(other instanceof TrackFailedMessageResolved)) {
            return false;
        }
        TrackFailedMessageResolved trackFailedMessageResolved = (TrackFailedMessageResolved) other;
        return Intrinsics3.areEqual(this.numAttachments, trackFailedMessageResolved.numAttachments) && Intrinsics3.areEqual(this.maxAttachmentSize, trackFailedMessageResolved.maxAttachmentSize) && Intrinsics3.areEqual(this.totalAttachmentSize, trackFailedMessageResolved.totalAttachmentSize) && Intrinsics3.areEqual(this.hasImage, trackFailedMessageResolved.hasImage) && Intrinsics3.areEqual(this.hasVideo, trackFailedMessageResolved.hasVideo) && Intrinsics3.areEqual(this.resolutionType, trackFailedMessageResolved.resolutionType) && Intrinsics3.areEqual(this.initialAttemptTs, trackFailedMessageResolved.initialAttemptTs) && Intrinsics3.areEqual(this.numRetries, trackFailedMessageResolved.numRetries) && Intrinsics3.areEqual(this.previewEnabled, trackFailedMessageResolved.previewEnabled);
    }

    public int hashCode() {
        Long l = this.numAttachments;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.maxAttachmentSize;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.totalAttachmentSize;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.hasImage;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasVideo;
        int iHashCode5 = (iHashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.resolutionType;
        int iHashCode6 = (iHashCode5 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l4 = this.initialAttemptTs;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.numRetries;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool3 = this.previewEnabled;
        return iHashCode8 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackFailedMessageResolved(numAttachments=");
        sbM833U.append(this.numAttachments);
        sbM833U.append(", maxAttachmentSize=");
        sbM833U.append(this.maxAttachmentSize);
        sbM833U.append(", totalAttachmentSize=");
        sbM833U.append(this.totalAttachmentSize);
        sbM833U.append(", hasImage=");
        sbM833U.append(this.hasImage);
        sbM833U.append(", hasVideo=");
        sbM833U.append(this.hasVideo);
        sbM833U.append(", resolutionType=");
        sbM833U.append(this.resolutionType);
        sbM833U.append(", initialAttemptTs=");
        sbM833U.append(this.initialAttemptTs);
        sbM833U.append(", numRetries=");
        sbM833U.append(this.numRetries);
        sbM833U.append(", previewEnabled=");
        return outline.m816D(sbM833U, this.previewEnabled, ")");
    }
}
