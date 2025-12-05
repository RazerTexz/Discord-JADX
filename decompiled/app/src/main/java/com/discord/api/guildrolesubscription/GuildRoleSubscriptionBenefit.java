package com.discord.api.guildrolesubscription;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildRoleSubscriptionBenefit.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildRoleSubscriptionBenefit {
    private final String description;
    private final Long emojiId;
    private final String emojiName;
    private final String name;
    private final Long refId;
    private final GuildRoleSubscriptionBenefitType refType;

    public GuildRoleSubscriptionBenefit(Long l, String str, String str2, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, String str3, Long l2) {
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionBenefitType, "refType");
        this.emojiId = l;
        this.emojiName = str;
        this.name = str2;
        this.refType = guildRoleSubscriptionBenefitType;
        this.description = str3;
        this.refId = l2;
    }

    /* renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: b, reason: from getter */
    public final Long getEmojiId() {
        return this.emojiId;
    }

    /* renamed from: c, reason: from getter */
    public final String getEmojiName() {
        return this.emojiName;
    }

    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: e, reason: from getter */
    public final Long getRefId() {
        return this.refId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionBenefit)) {
            return false;
        }
        GuildRoleSubscriptionBenefit guildRoleSubscriptionBenefit = (GuildRoleSubscriptionBenefit) other;
        return Intrinsics3.areEqual(this.emojiId, guildRoleSubscriptionBenefit.emojiId) && Intrinsics3.areEqual(this.emojiName, guildRoleSubscriptionBenefit.emojiName) && Intrinsics3.areEqual(this.name, guildRoleSubscriptionBenefit.name) && Intrinsics3.areEqual(this.refType, guildRoleSubscriptionBenefit.refType) && Intrinsics3.areEqual(this.description, guildRoleSubscriptionBenefit.description) && Intrinsics3.areEqual(this.refId, guildRoleSubscriptionBenefit.refId);
    }

    /* renamed from: f, reason: from getter */
    public final GuildRoleSubscriptionBenefitType getRefType() {
        return this.refType;
    }

    public int hashCode() {
        Long l = this.emojiId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        String str = this.emojiName;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType = this.refType;
        int iHashCode4 = (iHashCode3 + (guildRoleSubscriptionBenefitType != null ? guildRoleSubscriptionBenefitType.hashCode() : 0)) * 31;
        String str3 = this.description;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Long l2 = this.refId;
        return iHashCode5 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("GuildRoleSubscriptionBenefit(emojiId=");
        sbM833U.append(this.emojiId);
        sbM833U.append(", emojiName=");
        sbM833U.append(this.emojiName);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", refType=");
        sbM833U.append(this.refType);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", refId=");
        return outline.m819G(sbM833U, this.refId, ")");
    }
}
