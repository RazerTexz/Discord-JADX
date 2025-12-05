package com.discord.api.guildscheduledevent;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefit;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildRoleSubscriptionRoleBenefits.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildRoleSubscriptionRoleBenefits {
    private final List<GuildRoleSubscriptionBenefit> benefits;
    private final long skuId;

    /* renamed from: a */
    public final List<GuildRoleSubscriptionBenefit> m7971a() {
        return this.benefits;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionRoleBenefits)) {
            return false;
        }
        GuildRoleSubscriptionRoleBenefits guildRoleSubscriptionRoleBenefits = (GuildRoleSubscriptionRoleBenefits) other;
        return this.skuId == guildRoleSubscriptionRoleBenefits.skuId && Intrinsics3.areEqual(this.benefits, guildRoleSubscriptionRoleBenefits.benefits);
    }

    public int hashCode() {
        long j = this.skuId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<GuildRoleSubscriptionBenefit> list = this.benefits;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("GuildRoleSubscriptionRoleBenefits(skuId=");
        sbM833U.append(this.skuId);
        sbM833U.append(", benefits=");
        return outline.m824L(sbM833U, this.benefits, ")");
    }
}
