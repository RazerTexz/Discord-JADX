package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackMessageReported.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackMessageReported implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence reportType = null;
    private final CharSequence reportSubType = null;
    private final CharSequence subject = null;
    private final CharSequence description = null;
    private final Long reasonEnum = null;
    private final Long messageId = null;
    private final Long reportId = null;
    private final List<Long> mutualGuildIds = null;
    private final Long reportedMessageAuthorId = null;
    private final transient String analyticsSchemaTypeName = "message_reported";

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
        if (!(other instanceof TrackMessageReported)) {
            return false;
        }
        TrackMessageReported trackMessageReported = (TrackMessageReported) other;
        return Intrinsics3.areEqual(this.reportType, trackMessageReported.reportType) && Intrinsics3.areEqual(this.reportSubType, trackMessageReported.reportSubType) && Intrinsics3.areEqual(this.subject, trackMessageReported.subject) && Intrinsics3.areEqual(this.description, trackMessageReported.description) && Intrinsics3.areEqual(this.reasonEnum, trackMessageReported.reasonEnum) && Intrinsics3.areEqual(this.messageId, trackMessageReported.messageId) && Intrinsics3.areEqual(this.reportId, trackMessageReported.reportId) && Intrinsics3.areEqual(this.mutualGuildIds, trackMessageReported.mutualGuildIds) && Intrinsics3.areEqual(this.reportedMessageAuthorId, trackMessageReported.reportedMessageAuthorId);
    }

    public int hashCode() {
        CharSequence charSequence = this.reportType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.reportSubType;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.subject;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.description;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l = this.reasonEnum;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.messageId;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.reportId;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.mutualGuildIds;
        int iHashCode8 = (iHashCode7 + (list != null ? list.hashCode() : 0)) * 31;
        Long l4 = this.reportedMessageAuthorId;
        return iHashCode8 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackMessageReported(reportType=");
        sbM833U.append(this.reportType);
        sbM833U.append(", reportSubType=");
        sbM833U.append(this.reportSubType);
        sbM833U.append(", subject=");
        sbM833U.append(this.subject);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", reasonEnum=");
        sbM833U.append(this.reasonEnum);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", reportId=");
        sbM833U.append(this.reportId);
        sbM833U.append(", mutualGuildIds=");
        sbM833U.append(this.mutualGuildIds);
        sbM833U.append(", reportedMessageAuthorId=");
        return outline.m819G(sbM833U, this.reportedMessageAuthorId, ")");
    }
}
