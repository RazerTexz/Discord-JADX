package com.discord.api.guildrolesubscription;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: SubscriptionTrial.kt */
/* loaded from: classes.dex */
public final /* data */ class SubscriptionTrial {
    private final long id;
    private final GuildRoleSubscriptionFreeTrialIntervalTypes interval;
    private final int intervalCount;
    private final long skuId;

    /* renamed from: a, reason: from getter */
    public final GuildRoleSubscriptionFreeTrialIntervalTypes getInterval() {
        return this.interval;
    }

    /* renamed from: b, reason: from getter */
    public final int getIntervalCount() {
        return this.intervalCount;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionTrial)) {
            return false;
        }
        SubscriptionTrial subscriptionTrial = (SubscriptionTrial) other;
        return this.id == subscriptionTrial.id && Intrinsics3.areEqual(this.interval, subscriptionTrial.interval) && this.intervalCount == subscriptionTrial.intervalCount && this.skuId == subscriptionTrial.skuId;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        GuildRoleSubscriptionFreeTrialIntervalTypes guildRoleSubscriptionFreeTrialIntervalTypes = this.interval;
        int iHashCode = (((i + (guildRoleSubscriptionFreeTrialIntervalTypes != null ? guildRoleSubscriptionFreeTrialIntervalTypes.hashCode() : 0)) * 31) + this.intervalCount) * 31;
        long j2 = this.skuId;
        return iHashCode + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("SubscriptionTrial(id=");
        sbU.append(this.id);
        sbU.append(", interval=");
        sbU.append(this.interval);
        sbU.append(", intervalCount=");
        sbU.append(this.intervalCount);
        sbU.append(", skuId=");
        return outline.C(sbU, this.skuId, ")");
    }
}
