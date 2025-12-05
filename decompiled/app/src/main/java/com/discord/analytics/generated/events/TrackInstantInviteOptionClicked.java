package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackInstantInviteOptionClicked.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackInstantInviteOptionClicked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence inviteType = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final CharSequence inviteCode = null;
    private final Long inviteChannelType = null;
    private final Long inviteInviterId = null;
    private final transient String analyticsSchemaTypeName = "instant_invite_option_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInstantInviteOptionClicked)) {
            return false;
        }
        TrackInstantInviteOptionClicked trackInstantInviteOptionClicked = (TrackInstantInviteOptionClicked) other;
        return Intrinsics3.areEqual(this.inviteType, trackInstantInviteOptionClicked.inviteType) && Intrinsics3.areEqual(this.guildId, trackInstantInviteOptionClicked.guildId) && Intrinsics3.areEqual(this.channelId, trackInstantInviteOptionClicked.channelId) && Intrinsics3.areEqual(this.inviteCode, trackInstantInviteOptionClicked.inviteCode) && Intrinsics3.areEqual(this.inviteChannelType, trackInstantInviteOptionClicked.inviteChannelType) && Intrinsics3.areEqual(this.inviteInviterId, trackInstantInviteOptionClicked.inviteInviterId);
    }

    public int hashCode() {
        CharSequence charSequence = this.inviteType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.guildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.inviteCode;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l3 = this.inviteChannelType;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.inviteInviterId;
        return iHashCode5 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackInstantInviteOptionClicked(inviteType=");
        sbM833U.append(this.inviteType);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", inviteChannelType=");
        sbM833U.append(this.inviteChannelType);
        sbM833U.append(", inviteInviterId=");
        return outline.m819G(sbM833U, this.inviteInviterId, ")");
    }
}
