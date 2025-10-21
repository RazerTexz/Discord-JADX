package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackFriendSuggestionSkipped.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackFriendSuggestionSkipped implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long suggestedUserId = null;
    private final CharSequence platformType = null;
    private final Boolean isNonMutual = null;
    private final Boolean isReverseSuggestion = null;
    private final Long existingRelationshipType = null;
    private final Long userAllowedInSuggestions = null;
    private final Boolean userConsents = null;
    private final Boolean userIsDiscoverable = null;
    private final Long otherUserAllowedInSuggestions = null;
    private final Boolean otherUserConsents = null;
    private final Boolean otherUserDiscoverable = null;
    private final transient String analyticsSchemaTypeName = "friend_suggestion_skipped";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackFriendSuggestionSkipped)) {
            return false;
        }
        TrackFriendSuggestionSkipped trackFriendSuggestionSkipped = (TrackFriendSuggestionSkipped) other;
        return Intrinsics3.areEqual(this.suggestedUserId, trackFriendSuggestionSkipped.suggestedUserId) && Intrinsics3.areEqual(this.platformType, trackFriendSuggestionSkipped.platformType) && Intrinsics3.areEqual(this.isNonMutual, trackFriendSuggestionSkipped.isNonMutual) && Intrinsics3.areEqual(this.isReverseSuggestion, trackFriendSuggestionSkipped.isReverseSuggestion) && Intrinsics3.areEqual(this.existingRelationshipType, trackFriendSuggestionSkipped.existingRelationshipType) && Intrinsics3.areEqual(this.userAllowedInSuggestions, trackFriendSuggestionSkipped.userAllowedInSuggestions) && Intrinsics3.areEqual(this.userConsents, trackFriendSuggestionSkipped.userConsents) && Intrinsics3.areEqual(this.userIsDiscoverable, trackFriendSuggestionSkipped.userIsDiscoverable) && Intrinsics3.areEqual(this.otherUserAllowedInSuggestions, trackFriendSuggestionSkipped.otherUserAllowedInSuggestions) && Intrinsics3.areEqual(this.otherUserConsents, trackFriendSuggestionSkipped.otherUserConsents) && Intrinsics3.areEqual(this.otherUserDiscoverable, trackFriendSuggestionSkipped.otherUserDiscoverable);
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
        Long l2 = this.existingRelationshipType;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.userAllowedInSuggestions;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool3 = this.userConsents;
        int iHashCode7 = (iHashCode6 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.userIsDiscoverable;
        int iHashCode8 = (iHashCode7 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l4 = this.otherUserAllowedInSuggestions;
        int iHashCode9 = (iHashCode8 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool5 = this.otherUserConsents;
        int iHashCode10 = (iHashCode9 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.otherUserDiscoverable;
        return iHashCode10 + (bool6 != null ? bool6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackFriendSuggestionSkipped(suggestedUserId=");
        sbU.append(this.suggestedUserId);
        sbU.append(", platformType=");
        sbU.append(this.platformType);
        sbU.append(", isNonMutual=");
        sbU.append(this.isNonMutual);
        sbU.append(", isReverseSuggestion=");
        sbU.append(this.isReverseSuggestion);
        sbU.append(", existingRelationshipType=");
        sbU.append(this.existingRelationshipType);
        sbU.append(", userAllowedInSuggestions=");
        sbU.append(this.userAllowedInSuggestions);
        sbU.append(", userConsents=");
        sbU.append(this.userConsents);
        sbU.append(", userIsDiscoverable=");
        sbU.append(this.userIsDiscoverable);
        sbU.append(", otherUserAllowedInSuggestions=");
        sbU.append(this.otherUserAllowedInSuggestions);
        sbU.append(", otherUserConsents=");
        sbU.append(this.otherUserConsents);
        sbU.append(", otherUserDiscoverable=");
        return outline.D(sbU, this.otherUserDiscoverable, ")");
    }
}
