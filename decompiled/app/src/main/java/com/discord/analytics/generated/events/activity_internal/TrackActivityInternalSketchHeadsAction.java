package com.discord.analytics.generated.events.activity_internal;

import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackActivityInternalSketchHeadsAction.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackActivityInternalSketchHeadsAction implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence actionName = null;
    private final CharSequence mode = null;
    private final CharSequence phase = null;
    private final CharSequence theme = null;
    private final Long numRounds = null;
    private final Long roundLengthMs = null;
    private final Long numPlayers = null;
    private final Long numDrawers = null;
    private final Long numGuessers = null;
    private final Long numSpectators = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_sketch_heads_action";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalSketchHeadsAction)) {
            return false;
        }
        TrackActivityInternalSketchHeadsAction trackActivityInternalSketchHeadsAction = (TrackActivityInternalSketchHeadsAction) other;
        return Intrinsics3.areEqual(this.actionName, trackActivityInternalSketchHeadsAction.actionName) && Intrinsics3.areEqual(this.mode, trackActivityInternalSketchHeadsAction.mode) && Intrinsics3.areEqual(this.phase, trackActivityInternalSketchHeadsAction.phase) && Intrinsics3.areEqual(this.theme, trackActivityInternalSketchHeadsAction.theme) && Intrinsics3.areEqual(this.numRounds, trackActivityInternalSketchHeadsAction.numRounds) && Intrinsics3.areEqual(this.roundLengthMs, trackActivityInternalSketchHeadsAction.roundLengthMs) && Intrinsics3.areEqual(this.numPlayers, trackActivityInternalSketchHeadsAction.numPlayers) && Intrinsics3.areEqual(this.numDrawers, trackActivityInternalSketchHeadsAction.numDrawers) && Intrinsics3.areEqual(this.numGuessers, trackActivityInternalSketchHeadsAction.numGuessers) && Intrinsics3.areEqual(this.numSpectators, trackActivityInternalSketchHeadsAction.numSpectators);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.mode;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.phase;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.theme;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l = this.numRounds;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.roundLengthMs;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numPlayers;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numDrawers;
        int iHashCode8 = (iHashCode7 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.numGuessers;
        int iHashCode9 = (iHashCode8 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.numSpectators;
        return iHashCode9 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackActivityInternalSketchHeadsAction(actionName=");
        sbM833U.append(this.actionName);
        sbM833U.append(", mode=");
        sbM833U.append(this.mode);
        sbM833U.append(", phase=");
        sbM833U.append(this.phase);
        sbM833U.append(", theme=");
        sbM833U.append(this.theme);
        sbM833U.append(", numRounds=");
        sbM833U.append(this.numRounds);
        sbM833U.append(", roundLengthMs=");
        sbM833U.append(this.roundLengthMs);
        sbM833U.append(", numPlayers=");
        sbM833U.append(this.numPlayers);
        sbM833U.append(", numDrawers=");
        sbM833U.append(this.numDrawers);
        sbM833U.append(", numGuessers=");
        sbM833U.append(this.numGuessers);
        sbM833U.append(", numSpectators=");
        return outline.m819G(sbM833U, this.numSpectators, ")");
    }
}
