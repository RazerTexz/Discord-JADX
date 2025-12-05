package com.discord.api.guildrolesubscription;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: PayoutGroup.kt */
/* renamed from: com.discord.api.guildrolesubscription.Payout, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class PayoutGroup2 {
    private final Long amount;
    private final long id;
    private final String payoutDate;
    private final String periodEnd;
    private final String periodStart;
    private final PayoutStatus status;
    private final long userId;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayoutGroup2)) {
            return false;
        }
        PayoutGroup2 payoutGroup2 = (PayoutGroup2) other;
        return this.id == payoutGroup2.id && this.userId == payoutGroup2.userId && Intrinsics3.areEqual(this.periodStart, payoutGroup2.periodStart) && Intrinsics3.areEqual(this.periodEnd, payoutGroup2.periodEnd) && Intrinsics3.areEqual(this.payoutDate, payoutGroup2.payoutDate) && Intrinsics3.areEqual(this.status, payoutGroup2.status) && Intrinsics3.areEqual(this.amount, payoutGroup2.amount);
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.userId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.periodStart;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.periodEnd;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.payoutDate;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        PayoutStatus payoutStatus = this.status;
        int iHashCode4 = (iHashCode3 + (payoutStatus != null ? payoutStatus.hashCode() : 0)) * 31;
        Long l = this.amount;
        return iHashCode4 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Payout(id=");
        sbM833U.append(this.id);
        sbM833U.append(", userId=");
        sbM833U.append(this.userId);
        sbM833U.append(", periodStart=");
        sbM833U.append(this.periodStart);
        sbM833U.append(", periodEnd=");
        sbM833U.append(this.periodEnd);
        sbM833U.append(", payoutDate=");
        sbM833U.append(this.payoutDate);
        sbM833U.append(", status=");
        sbM833U.append(this.status);
        sbM833U.append(", amount=");
        return outline.m819G(sbM833U, this.amount, ")");
    }
}
