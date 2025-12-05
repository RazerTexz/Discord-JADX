package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackInviteOpened.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackInviteOpened implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence inviteCode = null;
    private final Long loadTime = null;
    private final transient String analyticsSchemaTypeName = "invite_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInviteOpened)) {
            return false;
        }
        TrackInviteOpened trackInviteOpened = (TrackInviteOpened) other;
        return Intrinsics3.areEqual(this.inviteCode, trackInviteOpened.inviteCode) && Intrinsics3.areEqual(this.loadTime, trackInviteOpened.loadTime);
    }

    public int hashCode() {
        CharSequence charSequence = this.inviteCode;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.loadTime;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackInviteOpened(inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", loadTime=");
        return outline.m819G(sbM833U, this.loadTime, ")");
    }
}
