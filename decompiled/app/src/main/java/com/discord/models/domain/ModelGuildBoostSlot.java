package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;

/* compiled from: ModelGuildBoostSlot.kt */
/* loaded from: classes.dex */
public final /* data */ class ModelGuildBoostSlot {
    private final boolean canceled;
    private final String cooldownEndsAt;
    private final long id;
    private final ModelAppliedGuildBoost premiumGuildSubscription;
    private final long subscriptionId;

    public ModelGuildBoostSlot(String str, long j, long j2, ModelAppliedGuildBoost modelAppliedGuildBoost, boolean z2) {
        this.cooldownEndsAt = str;
        this.id = j;
        this.subscriptionId = j2;
        this.premiumGuildSubscription = modelAppliedGuildBoost;
        this.canceled = z2;
    }

    /* renamed from: component1, reason: from getter */
    private final String getCooldownEndsAt() {
        return this.cooldownEndsAt;
    }

    public static /* synthetic */ ModelGuildBoostSlot copy$default(ModelGuildBoostSlot modelGuildBoostSlot, String str, long j, long j2, ModelAppliedGuildBoost modelAppliedGuildBoost, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelGuildBoostSlot.cooldownEndsAt;
        }
        if ((i & 2) != 0) {
            j = modelGuildBoostSlot.id;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = modelGuildBoostSlot.subscriptionId;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            modelAppliedGuildBoost = modelGuildBoostSlot.premiumGuildSubscription;
        }
        ModelAppliedGuildBoost modelAppliedGuildBoost2 = modelAppliedGuildBoost;
        if ((i & 16) != 0) {
            z2 = modelGuildBoostSlot.canceled;
        }
        return modelGuildBoostSlot.copy(str, j3, j4, modelAppliedGuildBoost2, z2);
    }

    /* renamed from: component2, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSubscriptionId() {
        return this.subscriptionId;
    }

    /* renamed from: component4, reason: from getter */
    public final ModelAppliedGuildBoost getPremiumGuildSubscription() {
        return this.premiumGuildSubscription;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCanceled() {
        return this.canceled;
    }

    public final ModelGuildBoostSlot copy(String cooldownEndsAt, long id2, long subscriptionId, ModelAppliedGuildBoost premiumGuildSubscription, boolean canceled) {
        return new ModelGuildBoostSlot(cooldownEndsAt, id2, subscriptionId, premiumGuildSubscription, canceled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGuildBoostSlot)) {
            return false;
        }
        ModelGuildBoostSlot modelGuildBoostSlot = (ModelGuildBoostSlot) other;
        return Intrinsics3.areEqual(this.cooldownEndsAt, modelGuildBoostSlot.cooldownEndsAt) && this.id == modelGuildBoostSlot.id && this.subscriptionId == modelGuildBoostSlot.subscriptionId && Intrinsics3.areEqual(this.premiumGuildSubscription, modelGuildBoostSlot.premiumGuildSubscription) && this.canceled == modelGuildBoostSlot.canceled;
    }

    public final boolean getCanceled() {
        return this.canceled;
    }

    public final long getCooldownExpiresAtTimestamp() {
        return TimeUtils.parseUTCDate(this.cooldownEndsAt);
    }

    public final long getId() {
        return this.id;
    }

    public final ModelAppliedGuildBoost getPremiumGuildSubscription() {
        return this.premiumGuildSubscription;
    }

    public final long getSubscriptionId() {
        return this.subscriptionId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.cooldownEndsAt;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.id;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.subscriptionId;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        ModelAppliedGuildBoost modelAppliedGuildBoost = this.premiumGuildSubscription;
        int iHashCode2 = (i2 + (modelAppliedGuildBoost != null ? modelAppliedGuildBoost.hashCode() : 0)) * 31;
        boolean z2 = this.canceled;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        return iHashCode2 + i3;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelGuildBoostSlot(cooldownEndsAt=");
        sbU.append(this.cooldownEndsAt);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", premiumGuildSubscription=");
        sbU.append(this.premiumGuildSubscription);
        sbU.append(", canceled=");
        return outline.O(sbU, this.canceled, ")");
    }
}
