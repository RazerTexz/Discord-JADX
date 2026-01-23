package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackReceiveFriendSuggestion.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackReceiveFriendSuggestion implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long suggestedUserId = null;
    private final CharSequence platformType = null;
    private final Boolean isNonMutual = null;
    private final Boolean isReverseSuggestion = null;
    private final Boolean dispatched = null;
    private final Boolean pushNotificationSent = null;
    private final Boolean namePresent = null;
    private final transient String analyticsSchemaTypeName = "receive_friend_suggestion";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackReceiveFriendSuggestion)) {
            return false;
        }
        TrackReceiveFriendSuggestion trackReceiveFriendSuggestion = (TrackReceiveFriendSuggestion) other;
        return Intrinsics3.areEqual(this.suggestedUserId, trackReceiveFriendSuggestion.suggestedUserId) && Intrinsics3.areEqual(this.platformType, trackReceiveFriendSuggestion.platformType) && Intrinsics3.areEqual(this.isNonMutual, trackReceiveFriendSuggestion.isNonMutual) && Intrinsics3.areEqual(this.isReverseSuggestion, trackReceiveFriendSuggestion.isReverseSuggestion) && Intrinsics3.areEqual(this.dispatched, trackReceiveFriendSuggestion.dispatched) && Intrinsics3.areEqual(this.pushNotificationSent, trackReceiveFriendSuggestion.pushNotificationSent) && Intrinsics3.areEqual(this.namePresent, trackReceiveFriendSuggestion.namePresent);
    }

    public int hashCode() {
        Long l = this.suggestedUserId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.platformType;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.isNonMutual;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isReverseSuggestion;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.dispatched;
        int iHashCode5 = (iHashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.pushNotificationSent;
        int iHashCode6 = (iHashCode5 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.namePresent;
        return iHashCode6 + (bool5 != null ? bool5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackReceiveFriendSuggestion(suggestedUserId=");
        sbM833U.append(this.suggestedUserId);
        sbM833U.append(", platformType=");
        sbM833U.append(this.platformType);
        sbM833U.append(", isNonMutual=");
        sbM833U.append(this.isNonMutual);
        sbM833U.append(", isReverseSuggestion=");
        sbM833U.append(this.isReverseSuggestion);
        sbM833U.append(", dispatched=");
        sbM833U.append(this.dispatched);
        sbM833U.append(", pushNotificationSent=");
        sbM833U.append(this.pushNotificationSent);
        sbM833U.append(", namePresent=");
        return outline.m816D(sbM833U, this.namePresent, ")");
    }
}
