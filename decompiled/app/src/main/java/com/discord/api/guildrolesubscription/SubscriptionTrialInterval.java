package com.discord.api.guildrolesubscription;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SubscriptionTrialInterval.kt */
/* loaded from: classes.dex */
public final /* data */ class SubscriptionTrialInterval {
    private final GuildRoleSubscriptionFreeTrialIntervalTypes interval;
    private final int intervalCount;

    public SubscriptionTrialInterval(GuildRoleSubscriptionFreeTrialIntervalTypes guildRoleSubscriptionFreeTrialIntervalTypes, int i) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionFreeTrialIntervalTypes, "interval");
        this.interval = guildRoleSubscriptionFreeTrialIntervalTypes;
        this.intervalCount = i;
    }

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
        if (!(other instanceof SubscriptionTrialInterval)) {
            return false;
        }
        SubscriptionTrialInterval subscriptionTrialInterval = (SubscriptionTrialInterval) other;
        return Intrinsics3.areEqual(this.interval, subscriptionTrialInterval.interval) && this.intervalCount == subscriptionTrialInterval.intervalCount;
    }

    public int hashCode() {
        GuildRoleSubscriptionFreeTrialIntervalTypes guildRoleSubscriptionFreeTrialIntervalTypes = this.interval;
        return ((guildRoleSubscriptionFreeTrialIntervalTypes != null ? guildRoleSubscriptionFreeTrialIntervalTypes.hashCode() : 0) * 31) + this.intervalCount;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("SubscriptionTrialInterval(interval=");
        sbM833U.append(this.interval);
        sbM833U.append(", intervalCount=");
        return outline.m814B(sbM833U, this.intervalCount, ")");
    }
}
