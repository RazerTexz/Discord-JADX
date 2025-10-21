package com.discord.analytics.generated.events.impression;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.generated.traits.TrackImpressionMetadata2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackImpressionInviteAccept.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackImpressionInviteAccept implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2, TrackLocationMetadata2, TrackImpressionMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final CharSequence deeplinkAttemptId;
    private final CharSequence inviteCode;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackImpressionMetadata trackImpressionMetadata;
    private TrackLocationMetadata trackLocationMetadata;

    public TrackImpressionInviteAccept() {
        this(null, null, 3);
    }

    public TrackImpressionInviteAccept(CharSequence charSequence, CharSequence charSequence2, int i) {
        int i2 = i & 2;
        this.inviteCode = (i & 1) != 0 ? null : charSequence;
        this.deeplinkAttemptId = null;
        this.analyticsSchemaTypeName = "impression_invite_accept";
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
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
        if (!(other instanceof TrackImpressionInviteAccept)) {
            return false;
        }
        TrackImpressionInviteAccept trackImpressionInviteAccept = (TrackImpressionInviteAccept) other;
        return Intrinsics3.areEqual(this.inviteCode, trackImpressionInviteAccept.inviteCode) && Intrinsics3.areEqual(this.deeplinkAttemptId, trackImpressionInviteAccept.deeplinkAttemptId);
    }

    public int hashCode() {
        CharSequence charSequence = this.inviteCode;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.deeplinkAttemptId;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackImpressionInviteAccept(inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", deeplinkAttemptId=");
        return outline.E(sbU, this.deeplinkAttemptId, ")");
    }
}
