package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackUpdateConnectedAccount.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackUpdateConnectedAccount implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence accountId = null;
    private final CharSequence accountName = null;
    private final Boolean connected = null;
    private final CharSequence platformType = null;
    private final Long visibility = null;
    private final Boolean friendSync = null;
    private final Boolean partner = null;
    private final CharSequence linkMethod = null;
    private final transient String analyticsSchemaTypeName = "update_connected_account";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUpdateConnectedAccount)) {
            return false;
        }
        TrackUpdateConnectedAccount trackUpdateConnectedAccount = (TrackUpdateConnectedAccount) other;
        return Intrinsics3.areEqual(this.accountId, trackUpdateConnectedAccount.accountId) && Intrinsics3.areEqual(this.accountName, trackUpdateConnectedAccount.accountName) && Intrinsics3.areEqual(this.connected, trackUpdateConnectedAccount.connected) && Intrinsics3.areEqual(this.platformType, trackUpdateConnectedAccount.platformType) && Intrinsics3.areEqual(this.visibility, trackUpdateConnectedAccount.visibility) && Intrinsics3.areEqual(this.friendSync, trackUpdateConnectedAccount.friendSync) && Intrinsics3.areEqual(this.partner, trackUpdateConnectedAccount.partner) && Intrinsics3.areEqual(this.linkMethod, trackUpdateConnectedAccount.linkMethod);
    }

    public int hashCode() {
        CharSequence charSequence = this.accountId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.accountName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.connected;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.platformType;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.visibility;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool2 = this.friendSync;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.partner;
        int iHashCode7 = (iHashCode6 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.linkMethod;
        return iHashCode7 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackUpdateConnectedAccount(accountId=");
        sbM833U.append(this.accountId);
        sbM833U.append(", accountName=");
        sbM833U.append(this.accountName);
        sbM833U.append(", connected=");
        sbM833U.append(this.connected);
        sbM833U.append(", platformType=");
        sbM833U.append(this.platformType);
        sbM833U.append(", visibility=");
        sbM833U.append(this.visibility);
        sbM833U.append(", friendSync=");
        sbM833U.append(this.friendSync);
        sbM833U.append(", partner=");
        sbM833U.append(this.partner);
        sbM833U.append(", linkMethod=");
        return outline.m817E(sbM833U, this.linkMethod, ")");
    }
}
