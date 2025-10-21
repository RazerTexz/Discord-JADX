package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackGuildProgramStatusUpdated.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildProgramStatusUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long programType = null;
    private final CharSequence programName = null;
    private final Long statusType = null;
    private final CharSequence status = null;
    private final Long guildId = null;
    private final CharSequence actionSource = null;
    private final transient String analyticsSchemaTypeName = "guild_program_status_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildProgramStatusUpdated)) {
            return false;
        }
        TrackGuildProgramStatusUpdated trackGuildProgramStatusUpdated = (TrackGuildProgramStatusUpdated) other;
        return Intrinsics3.areEqual(this.programType, trackGuildProgramStatusUpdated.programType) && Intrinsics3.areEqual(this.programName, trackGuildProgramStatusUpdated.programName) && Intrinsics3.areEqual(this.statusType, trackGuildProgramStatusUpdated.statusType) && Intrinsics3.areEqual(this.status, trackGuildProgramStatusUpdated.status) && Intrinsics3.areEqual(this.guildId, trackGuildProgramStatusUpdated.guildId) && Intrinsics3.areEqual(this.actionSource, trackGuildProgramStatusUpdated.actionSource);
    }

    public int hashCode() {
        Long l = this.programType;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.programName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.statusType;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.status;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.actionSource;
        return iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildProgramStatusUpdated(programType=");
        sbU.append(this.programType);
        sbU.append(", programName=");
        sbU.append(this.programName);
        sbU.append(", statusType=");
        sbU.append(this.statusType);
        sbU.append(", status=");
        sbU.append(this.status);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", actionSource=");
        return outline.E(sbU, this.actionSource, ")");
    }
}
