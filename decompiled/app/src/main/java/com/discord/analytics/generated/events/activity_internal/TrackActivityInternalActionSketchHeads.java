package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackActivityInternalActionSketchHeads.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackActivityInternalActionSketchHeads implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
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
    private final transient String analyticsSchemaTypeName = "activity_internal_action_sketch_heads";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalActionSketchHeads)) {
            return false;
        }
        TrackActivityInternalActionSketchHeads trackActivityInternalActionSketchHeads = (TrackActivityInternalActionSketchHeads) other;
        return Intrinsics3.areEqual(this.actionName, trackActivityInternalActionSketchHeads.actionName) && Intrinsics3.areEqual(this.mode, trackActivityInternalActionSketchHeads.mode) && Intrinsics3.areEqual(this.phase, trackActivityInternalActionSketchHeads.phase) && Intrinsics3.areEqual(this.theme, trackActivityInternalActionSketchHeads.theme) && Intrinsics3.areEqual(this.numRounds, trackActivityInternalActionSketchHeads.numRounds) && Intrinsics3.areEqual(this.roundLengthMs, trackActivityInternalActionSketchHeads.roundLengthMs) && Intrinsics3.areEqual(this.numPlayers, trackActivityInternalActionSketchHeads.numPlayers) && Intrinsics3.areEqual(this.numDrawers, trackActivityInternalActionSketchHeads.numDrawers) && Intrinsics3.areEqual(this.numGuessers, trackActivityInternalActionSketchHeads.numGuessers) && Intrinsics3.areEqual(this.numSpectators, trackActivityInternalActionSketchHeads.numSpectators);
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
        StringBuilder sbU = outline.U("TrackActivityInternalActionSketchHeads(actionName=");
        sbU.append(this.actionName);
        sbU.append(", mode=");
        sbU.append(this.mode);
        sbU.append(", phase=");
        sbU.append(this.phase);
        sbU.append(", theme=");
        sbU.append(this.theme);
        sbU.append(", numRounds=");
        sbU.append(this.numRounds);
        sbU.append(", roundLengthMs=");
        sbU.append(this.roundLengthMs);
        sbU.append(", numPlayers=");
        sbU.append(this.numPlayers);
        sbU.append(", numDrawers=");
        sbU.append(this.numDrawers);
        sbU.append(", numGuessers=");
        sbU.append(this.numGuessers);
        sbU.append(", numSpectators=");
        return outline.G(sbU, this.numSpectators, ")");
    }
}
