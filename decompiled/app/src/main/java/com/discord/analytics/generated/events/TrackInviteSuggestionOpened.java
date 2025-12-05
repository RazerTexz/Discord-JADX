package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackInviteSuggestionOpened.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackInviteSuggestionOpened implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long numSuggestions = null;
    private final Long numFriends = null;
    private final Long numDms = null;
    private final Long numGroupDms = null;
    private final Long guildId = null;
    private final transient String analyticsSchemaTypeName = "invite_suggestion_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInviteSuggestionOpened)) {
            return false;
        }
        TrackInviteSuggestionOpened trackInviteSuggestionOpened = (TrackInviteSuggestionOpened) other;
        return Intrinsics3.areEqual(this.numSuggestions, trackInviteSuggestionOpened.numSuggestions) && Intrinsics3.areEqual(this.numFriends, trackInviteSuggestionOpened.numFriends) && Intrinsics3.areEqual(this.numDms, trackInviteSuggestionOpened.numDms) && Intrinsics3.areEqual(this.numGroupDms, trackInviteSuggestionOpened.numGroupDms) && Intrinsics3.areEqual(this.guildId, trackInviteSuggestionOpened.guildId);
    }

    public int hashCode() {
        Long l = this.numSuggestions;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.numFriends;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numDms;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numGroupDms;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.guildId;
        return iHashCode4 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackInviteSuggestionOpened(numSuggestions=");
        sbM833U.append(this.numSuggestions);
        sbM833U.append(", numFriends=");
        sbM833U.append(this.numFriends);
        sbM833U.append(", numDms=");
        sbM833U.append(this.numDms);
        sbM833U.append(", numGroupDms=");
        sbM833U.append(this.numGroupDms);
        sbM833U.append(", guildId=");
        return outline.m819G(sbM833U, this.guildId, ")");
    }
}
