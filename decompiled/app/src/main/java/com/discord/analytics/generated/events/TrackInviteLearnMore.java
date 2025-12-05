package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackInviteLearnMore.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackInviteLearnMore implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence inviteCode = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long inviterId = null;
    private final transient String analyticsSchemaTypeName = "invite_learn_more";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInviteLearnMore)) {
            return false;
        }
        TrackInviteLearnMore trackInviteLearnMore = (TrackInviteLearnMore) other;
        return Intrinsics3.areEqual(this.inviteCode, trackInviteLearnMore.inviteCode) && Intrinsics3.areEqual(this.guildId, trackInviteLearnMore.guildId) && Intrinsics3.areEqual(this.channelId, trackInviteLearnMore.channelId) && Intrinsics3.areEqual(this.inviterId, trackInviteLearnMore.inviterId);
    }

    public int hashCode() {
        CharSequence charSequence = this.inviteCode;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.guildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.inviterId;
        return iHashCode3 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackInviteLearnMore(inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", inviterId=");
        return outline.m819G(sbM833U, this.inviterId, ")");
    }
}
