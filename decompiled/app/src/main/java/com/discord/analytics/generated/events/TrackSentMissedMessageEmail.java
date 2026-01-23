package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackSentMissedMessageEmail.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSentMissedMessageEmail implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence trackingPixelUuid = null;
    private final CharSequence subjectClassification = null;
    private final Long totalGuildsMissed = null;
    private final Long totalChannelsMissed = null;
    private final Long totalDmsMissed = null;
    private final Long totalApproximateMessagesMissed = null;
    private final Long lastAckAt = null;
    private final Boolean didSend = null;
    private final transient String analyticsSchemaTypeName = "sent_missed_message_email";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSentMissedMessageEmail)) {
            return false;
        }
        TrackSentMissedMessageEmail trackSentMissedMessageEmail = (TrackSentMissedMessageEmail) other;
        return Intrinsics3.areEqual(this.trackingPixelUuid, trackSentMissedMessageEmail.trackingPixelUuid) && Intrinsics3.areEqual(this.subjectClassification, trackSentMissedMessageEmail.subjectClassification) && Intrinsics3.areEqual(this.totalGuildsMissed, trackSentMissedMessageEmail.totalGuildsMissed) && Intrinsics3.areEqual(this.totalChannelsMissed, trackSentMissedMessageEmail.totalChannelsMissed) && Intrinsics3.areEqual(this.totalDmsMissed, trackSentMissedMessageEmail.totalDmsMissed) && Intrinsics3.areEqual(this.totalApproximateMessagesMissed, trackSentMissedMessageEmail.totalApproximateMessagesMissed) && Intrinsics3.areEqual(this.lastAckAt, trackSentMissedMessageEmail.lastAckAt) && Intrinsics3.areEqual(this.didSend, trackSentMissedMessageEmail.didSend);
    }

    public int hashCode() {
        CharSequence charSequence = this.trackingPixelUuid;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.subjectClassification;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.totalGuildsMissed;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.totalChannelsMissed;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.totalDmsMissed;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.totalApproximateMessagesMissed;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.lastAckAt;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool = this.didSend;
        return iHashCode7 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackSentMissedMessageEmail(trackingPixelUuid=");
        sbM833U.append(this.trackingPixelUuid);
        sbM833U.append(", subjectClassification=");
        sbM833U.append(this.subjectClassification);
        sbM833U.append(", totalGuildsMissed=");
        sbM833U.append(this.totalGuildsMissed);
        sbM833U.append(", totalChannelsMissed=");
        sbM833U.append(this.totalChannelsMissed);
        sbM833U.append(", totalDmsMissed=");
        sbM833U.append(this.totalDmsMissed);
        sbM833U.append(", totalApproximateMessagesMissed=");
        sbM833U.append(this.totalApproximateMessagesMissed);
        sbM833U.append(", lastAckAt=");
        sbM833U.append(this.lastAckAt);
        sbM833U.append(", didSend=");
        return outline.m816D(sbM833U, this.didSend, ")");
    }
}
