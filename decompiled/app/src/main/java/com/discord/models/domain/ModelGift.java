package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.api.user.User;
import com.discord.models.domain.ModelSku;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.m;

/* compiled from: ModelGift.kt */
/* loaded from: classes.dex */
public final /* data */ class ModelGift {
    private final String code;
    private final String expiresAt;
    private final Integer giftStyle;
    private final int maxUses;
    private final boolean redeemed;
    private final long skuId;
    private final ModelStoreListing storeListing;
    private final SubscriptionPlan subscriptionPlan;
    private final Long subscriptionPlanId;
    private final User user;
    private final int uses;

    public ModelGift(long j, boolean z2, String str, String str2, int i, ModelStoreListing modelStoreListing, int i2, User user, Long l, SubscriptionPlan subscriptionPlan, Integer num) {
        m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_CODE);
        this.skuId = j;
        this.redeemed = z2;
        this.expiresAt = str;
        this.code = str2;
        this.uses = i;
        this.storeListing = modelStoreListing;
        this.maxUses = i2;
        this.user = user;
        this.subscriptionPlanId = l;
        this.subscriptionPlan = subscriptionPlan;
        this.giftStyle = num;
    }

    public static /* synthetic */ ModelGift copy$default(ModelGift modelGift, long j, boolean z2, String str, String str2, int i, ModelStoreListing modelStoreListing, int i2, User user, Long l, SubscriptionPlan subscriptionPlan, Integer num, int i3, Object obj) {
        return modelGift.copy((i3 & 1) != 0 ? modelGift.skuId : j, (i3 & 2) != 0 ? modelGift.redeemed : z2, (i3 & 4) != 0 ? modelGift.expiresAt : str, (i3 & 8) != 0 ? modelGift.code : str2, (i3 & 16) != 0 ? modelGift.uses : i, (i3 & 32) != 0 ? modelGift.storeListing : modelStoreListing, (i3 & 64) != 0 ? modelGift.maxUses : i2, (i3 & 128) != 0 ? modelGift.user : user, (i3 & 256) != 0 ? modelGift.subscriptionPlanId : l, (i3 & 512) != 0 ? modelGift.subscriptionPlan : subscriptionPlan, (i3 & 1024) != 0 ? modelGift.giftStyle : num);
    }

    /* renamed from: component1, reason: from getter */
    public final long getSkuId() {
        return this.skuId;
    }

    /* renamed from: component10, reason: from getter */
    public final SubscriptionPlan getSubscriptionPlan() {
        return this.subscriptionPlan;
    }

    /* renamed from: component11, reason: from getter */
    public final Integer getGiftStyle() {
        return this.giftStyle;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getRedeemed() {
        return this.redeemed;
    }

    /* renamed from: component3, reason: from getter */
    public final String getExpiresAt() {
        return this.expiresAt;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component5, reason: from getter */
    public final int getUses() {
        return this.uses;
    }

    /* renamed from: component6, reason: from getter */
    public final ModelStoreListing getStoreListing() {
        return this.storeListing;
    }

    /* renamed from: component7, reason: from getter */
    public final int getMaxUses() {
        return this.maxUses;
    }

    /* renamed from: component8, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component9, reason: from getter */
    public final Long getSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }

    public final ModelGift copy(long skuId, boolean redeemed, String expiresAt, String code, int uses, ModelStoreListing storeListing, int maxUses, User user, Long subscriptionPlanId, SubscriptionPlan subscriptionPlan, Integer giftStyle) {
        m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return new ModelGift(skuId, redeemed, expiresAt, code, uses, storeListing, maxUses, user, subscriptionPlanId, subscriptionPlan, giftStyle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGift)) {
            return false;
        }
        ModelGift modelGift = (ModelGift) other;
        return this.skuId == modelGift.skuId && this.redeemed == modelGift.redeemed && m.areEqual(this.expiresAt, modelGift.expiresAt) && m.areEqual(this.code, modelGift.code) && this.uses == modelGift.uses && m.areEqual(this.storeListing, modelGift.storeListing) && this.maxUses == modelGift.maxUses && m.areEqual(this.user, modelGift.user) && m.areEqual(this.subscriptionPlanId, modelGift.subscriptionPlanId) && m.areEqual(this.subscriptionPlan, modelGift.subscriptionPlan) && m.areEqual(this.giftStyle, modelGift.giftStyle);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public final long getExpiresDiff(long currentTime) {
        String str = this.expiresAt;
        if (str != null) {
            return TimeUtils.parseUTCDate(str) - currentTime;
        }
        return 0L;
    }

    public final Integer getGiftStyle() {
        return this.giftStyle;
    }

    public final int getMaxUses() {
        return this.maxUses;
    }

    public final boolean getRedeemed() {
        return this.redeemed;
    }

    public final long getSkuId() {
        return this.skuId;
    }

    public final ModelStoreListing getStoreListing() {
        return this.storeListing;
    }

    public final SubscriptionPlan getSubscriptionPlan() {
        return this.subscriptionPlan;
    }

    public final Long getSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }

    public final User getUser() {
        return this.user;
    }

    public final int getUses() {
        return this.uses;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.skuId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        boolean z2 = this.redeemed;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        String str = this.expiresAt;
        int iHashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.code;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.uses) * 31;
        ModelStoreListing modelStoreListing = this.storeListing;
        int iHashCode3 = (((iHashCode2 + (modelStoreListing != null ? modelStoreListing.hashCode() : 0)) * 31) + this.maxUses) * 31;
        User user = this.user;
        int iHashCode4 = (iHashCode3 + (user != null ? user.hashCode() : 0)) * 31;
        Long l = this.subscriptionPlanId;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        SubscriptionPlan subscriptionPlan = this.subscriptionPlan;
        int iHashCode6 = (iHashCode5 + (subscriptionPlan != null ? subscriptionPlan.hashCode() : 0)) * 31;
        Integer num = this.giftStyle;
        return iHashCode6 + (num != null ? num.hashCode() : 0);
    }

    public final boolean isAnyNitroGift() {
        return isNitroGift() || isNitroClassicGift();
    }

    public final boolean isClaimedByMe() {
        return this.redeemed;
    }

    public final boolean isComplete() {
        return this.storeListing != null;
    }

    public final boolean isExpired(long currentTime) {
        String str = this.expiresAt;
        return str != null && currentTime > TimeUtils.parseUTCDate(str);
    }

    public final boolean isNitroClassicGift() {
        ModelSku sku;
        ModelStoreListing modelStoreListing = this.storeListing;
        return ((modelStoreListing == null || (sku = modelStoreListing.getSku()) == null) ? null : sku.getSkuCategory()) == ModelSku.SkuCategory.NITRO_CLASSIC;
    }

    public final boolean isNitroGift() {
        ModelSku sku;
        ModelStoreListing modelStoreListing = this.storeListing;
        return ((modelStoreListing == null || (sku = modelStoreListing.getSku()) == null) ? null : sku.getSkuCategory()) == ModelSku.SkuCategory.NITRO;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelGift(skuId=");
        sbU.append(this.skuId);
        sbU.append(", redeemed=");
        sbU.append(this.redeemed);
        sbU.append(", expiresAt=");
        sbU.append(this.expiresAt);
        sbU.append(", code=");
        sbU.append(this.code);
        sbU.append(", uses=");
        sbU.append(this.uses);
        sbU.append(", storeListing=");
        sbU.append(this.storeListing);
        sbU.append(", maxUses=");
        sbU.append(this.maxUses);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", subscriptionPlanId=");
        sbU.append(this.subscriptionPlanId);
        sbU.append(", subscriptionPlan=");
        sbU.append(this.subscriptionPlan);
        sbU.append(", giftStyle=");
        return a.F(sbU, this.giftStyle, ")");
    }
}
