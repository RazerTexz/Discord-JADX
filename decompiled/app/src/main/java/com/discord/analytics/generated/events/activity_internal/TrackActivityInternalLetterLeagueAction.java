package com.discord.analytics.generated.events.activity_internal;

import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackActivityInternalLetterLeagueAction.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackActivityInternalLetterLeagueAction implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence actionName = null;
    private final CharSequence bag = null;
    private final CharSequence scoringMode = null;
    private final Long numPlayers = null;
    private final Long numSpectators = null;
    private final CharSequence phase = null;
    private final Long durationS = null;
    private final Long score = null;
    private final CharSequence turnType = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_letter_league_action";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalLetterLeagueAction)) {
            return false;
        }
        TrackActivityInternalLetterLeagueAction trackActivityInternalLetterLeagueAction = (TrackActivityInternalLetterLeagueAction) other;
        return Intrinsics3.areEqual(this.actionName, trackActivityInternalLetterLeagueAction.actionName) && Intrinsics3.areEqual(this.bag, trackActivityInternalLetterLeagueAction.bag) && Intrinsics3.areEqual(this.scoringMode, trackActivityInternalLetterLeagueAction.scoringMode) && Intrinsics3.areEqual(this.numPlayers, trackActivityInternalLetterLeagueAction.numPlayers) && Intrinsics3.areEqual(this.numSpectators, trackActivityInternalLetterLeagueAction.numSpectators) && Intrinsics3.areEqual(this.phase, trackActivityInternalLetterLeagueAction.phase) && Intrinsics3.areEqual(this.durationS, trackActivityInternalLetterLeagueAction.durationS) && Intrinsics3.areEqual(this.score, trackActivityInternalLetterLeagueAction.score) && Intrinsics3.areEqual(this.turnType, trackActivityInternalLetterLeagueAction.turnType);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.bag;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.scoringMode;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.numPlayers;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numSpectators;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.phase;
        int iHashCode6 = (iHashCode5 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l3 = this.durationS;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.score;
        int iHashCode8 = (iHashCode7 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.turnType;
        return iHashCode8 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackActivityInternalLetterLeagueAction(actionName=");
        sbM833U.append(this.actionName);
        sbM833U.append(", bag=");
        sbM833U.append(this.bag);
        sbM833U.append(", scoringMode=");
        sbM833U.append(this.scoringMode);
        sbM833U.append(", numPlayers=");
        sbM833U.append(this.numPlayers);
        sbM833U.append(", numSpectators=");
        sbM833U.append(this.numSpectators);
        sbM833U.append(", phase=");
        sbM833U.append(this.phase);
        sbM833U.append(", durationS=");
        sbM833U.append(this.durationS);
        sbM833U.append(", score=");
        sbM833U.append(this.score);
        sbM833U.append(", turnType=");
        return outline.m817E(sbM833U, this.turnType, ")");
    }
}
