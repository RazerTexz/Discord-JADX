package com.discord.api.message.role_subscription;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* compiled from: RoleSubscriptionData.kt */
/* loaded from: classes.dex */
public final /* data */ class RoleSubscriptionData {
    private final boolean isRenewal;
    private final long roleSubscriptionListingId;
    private final String tierName;
    private final int totalMonthsSubscribed;

    /* renamed from: a, reason: from getter */
    public final long getRoleSubscriptionListingId() {
        return this.roleSubscriptionListingId;
    }

    /* renamed from: b, reason: from getter */
    public final String getTierName() {
        return this.tierName;
    }

    /* renamed from: c, reason: from getter */
    public final int getTotalMonthsSubscribed() {
        return this.totalMonthsSubscribed;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsRenewal() {
        return this.isRenewal;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoleSubscriptionData)) {
            return false;
        }
        RoleSubscriptionData roleSubscriptionData = (RoleSubscriptionData) other;
        return this.roleSubscriptionListingId == roleSubscriptionData.roleSubscriptionListingId && Intrinsics3.areEqual(this.tierName, roleSubscriptionData.tierName) && this.totalMonthsSubscribed == roleSubscriptionData.totalMonthsSubscribed && this.isRenewal == roleSubscriptionData.isRenewal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.roleSubscriptionListingId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.tierName;
        int iHashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.totalMonthsSubscribed) * 31;
        boolean z2 = this.isRenewal;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        return iHashCode + i2;
    }

    public String toString() {
        StringBuilder sbU = outline.U("RoleSubscriptionData(roleSubscriptionListingId=");
        sbU.append(this.roleSubscriptionListingId);
        sbU.append(", tierName=");
        sbU.append(this.tierName);
        sbU.append(", totalMonthsSubscribed=");
        sbU.append(this.totalMonthsSubscribed);
        sbU.append(", isRenewal=");
        return outline.O(sbU, this.isRenewal, ")");
    }
}
