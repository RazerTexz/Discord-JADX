package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackInviteLogin.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackInviteLogin implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence inviteCode = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long inviterId = null;
    private final transient String analyticsSchemaTypeName = "invite_login";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInviteLogin)) {
            return false;
        }
        TrackInviteLogin trackInviteLogin = (TrackInviteLogin) other;
        return Intrinsics3.areEqual(this.inviteCode, trackInviteLogin.inviteCode) && Intrinsics3.areEqual(this.guildId, trackInviteLogin.guildId) && Intrinsics3.areEqual(this.channelId, trackInviteLogin.channelId) && Intrinsics3.areEqual(this.inviterId, trackInviteLogin.inviterId);
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
        StringBuilder sbU = outline.U("TrackInviteLogin(inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", inviterId=");
        return outline.G(sbU, this.inviterId, ")");
    }
}
