package com.discord.api.guildrolesubscription;

import b.d.b.a.a;
import com.discord.api.guildscheduledevent.GuildRoleSubscriptionRoleBenefits;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

/* compiled from: GuildRoleSubscriptionTierListing.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildRoleSubscriptionTierListing {
    private final long applicationId;
    private final String description;
    private final long id;
    private final ImageAsset imageAsset;
    private final String name;
    private final boolean published;
    private final GuildRoleSubscriptionRoleBenefits roleBenefits;
    private final long roleId;
    private final List<SubscriptionPlan> subscriptionPlans;

    /* renamed from: a, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* renamed from: b, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: c, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final ImageAsset getImageAsset() {
        return this.imageAsset;
    }

    /* renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionTierListing)) {
            return false;
        }
        GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing = (GuildRoleSubscriptionTierListing) other;
        return this.id == guildRoleSubscriptionTierListing.id && this.applicationId == guildRoleSubscriptionTierListing.applicationId && m.areEqual(this.name, guildRoleSubscriptionTierListing.name) && this.published == guildRoleSubscriptionTierListing.published && m.areEqual(this.description, guildRoleSubscriptionTierListing.description) && m.areEqual(this.imageAsset, guildRoleSubscriptionTierListing.imageAsset) && m.areEqual(this.subscriptionPlans, guildRoleSubscriptionTierListing.subscriptionPlans) && m.areEqual(this.roleBenefits, guildRoleSubscriptionTierListing.roleBenefits) && this.roleId == guildRoleSubscriptionTierListing.roleId;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getPublished() {
        return this.published;
    }

    /* renamed from: g, reason: from getter */
    public final GuildRoleSubscriptionRoleBenefits getRoleBenefits() {
        return this.roleBenefits;
    }

    /* renamed from: h, reason: from getter */
    public final long getRoleId() {
        return this.roleId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.id;
        long j2 = this.applicationId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.published;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (iHashCode + i2) * 31;
        String str2 = this.description;
        int iHashCode2 = (i3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ImageAsset imageAsset = this.imageAsset;
        int iHashCode3 = (iHashCode2 + (imageAsset != null ? imageAsset.hashCode() : 0)) * 31;
        List<SubscriptionPlan> list = this.subscriptionPlans;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        GuildRoleSubscriptionRoleBenefits guildRoleSubscriptionRoleBenefits = this.roleBenefits;
        int iHashCode5 = (iHashCode4 + (guildRoleSubscriptionRoleBenefits != null ? guildRoleSubscriptionRoleBenefits.hashCode() : 0)) * 31;
        long j3 = this.roleId;
        return iHashCode5 + ((int) (j3 ^ (j3 >>> 32)));
    }

    public final List<SubscriptionPlan> i() {
        return this.subscriptionPlans;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildRoleSubscriptionTierListing(id=");
        sbU.append(this.id);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", published=");
        sbU.append(this.published);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", imageAsset=");
        sbU.append(this.imageAsset);
        sbU.append(", subscriptionPlans=");
        sbU.append(this.subscriptionPlans);
        sbU.append(", roleBenefits=");
        sbU.append(this.roleBenefits);
        sbU.append(", roleId=");
        return a.C(sbU, this.roleId, ")");
    }
}
