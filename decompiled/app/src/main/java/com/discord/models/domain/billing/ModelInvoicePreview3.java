package com.discord.models.domain.billing;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ModelInvoicePreview.kt */
/* renamed from: com.discord.models.domain.billing.ModelInvoiceItem, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ModelInvoicePreview3 {
    private final int amount;
    private final List<ModelInvoicePreview2> discount;
    private final long id;
    private final boolean proration;
    private final int quantity;
    private final long subscriptionPlanId;
    private final int subscriptionPlanPrice;

    public ModelInvoicePreview3(int i, List<ModelInvoicePreview2> list, long j, boolean z2, int i2, long j2, int i3) {
        Intrinsics3.checkNotNullParameter(list, "discount");
        this.amount = i;
        this.discount = list;
        this.id = j;
        this.proration = z2;
        this.quantity = i2;
        this.subscriptionPlanId = j2;
        this.subscriptionPlanPrice = i3;
    }

    public static /* synthetic */ ModelInvoicePreview3 copy$default(ModelInvoicePreview3 modelInvoicePreview3, int i, List list, long j, boolean z2, int i2, long j2, int i3, int i4, Object obj) {
        return modelInvoicePreview3.copy((i4 & 1) != 0 ? modelInvoicePreview3.amount : i, (i4 & 2) != 0 ? modelInvoicePreview3.discount : list, (i4 & 4) != 0 ? modelInvoicePreview3.id : j, (i4 & 8) != 0 ? modelInvoicePreview3.proration : z2, (i4 & 16) != 0 ? modelInvoicePreview3.quantity : i2, (i4 & 32) != 0 ? modelInvoicePreview3.subscriptionPlanId : j2, (i4 & 64) != 0 ? modelInvoicePreview3.subscriptionPlanPrice : i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    public final List<ModelInvoicePreview2> component2() {
        return this.discount;
    }

    /* renamed from: component3, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getProration() {
        return this.proration;
    }

    /* renamed from: component5, reason: from getter */
    public final int getQuantity() {
        return this.quantity;
    }

    /* renamed from: component6, reason: from getter */
    public final long getSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }

    /* renamed from: component7, reason: from getter */
    public final int getSubscriptionPlanPrice() {
        return this.subscriptionPlanPrice;
    }

    public final ModelInvoicePreview3 copy(int amount, List<ModelInvoicePreview2> discount, long id2, boolean proration, int quantity, long subscriptionPlanId, int subscriptionPlanPrice) {
        Intrinsics3.checkNotNullParameter(discount, "discount");
        return new ModelInvoicePreview3(amount, discount, id2, proration, quantity, subscriptionPlanId, subscriptionPlanPrice);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelInvoicePreview3)) {
            return false;
        }
        ModelInvoicePreview3 modelInvoicePreview3 = (ModelInvoicePreview3) other;
        return this.amount == modelInvoicePreview3.amount && Intrinsics3.areEqual(this.discount, modelInvoicePreview3.discount) && this.id == modelInvoicePreview3.id && this.proration == modelInvoicePreview3.proration && this.quantity == modelInvoicePreview3.quantity && this.subscriptionPlanId == modelInvoicePreview3.subscriptionPlanId && this.subscriptionPlanPrice == modelInvoicePreview3.subscriptionPlanPrice;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final List<ModelInvoicePreview2> getDiscount() {
        return this.discount;
    }

    public final long getId() {
        return this.id;
    }

    public final boolean getProration() {
        return this.proration;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final long getSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }

    public final int getSubscriptionPlanPrice() {
        return this.subscriptionPlanPrice;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.amount * 31;
        List<ModelInvoicePreview2> list = this.discount;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        long j = this.id;
        int i2 = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        boolean z2 = this.proration;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (((i2 + i3) * 31) + this.quantity) * 31;
        long j2 = this.subscriptionPlanId;
        return ((i4 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.subscriptionPlanPrice;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ModelInvoiceItem(amount=");
        sbM833U.append(this.amount);
        sbM833U.append(", discount=");
        sbM833U.append(this.discount);
        sbM833U.append(", id=");
        sbM833U.append(this.id);
        sbM833U.append(", proration=");
        sbM833U.append(this.proration);
        sbM833U.append(", quantity=");
        sbM833U.append(this.quantity);
        sbM833U.append(", subscriptionPlanId=");
        sbM833U.append(this.subscriptionPlanId);
        sbM833U.append(", subscriptionPlanPrice=");
        return outline.m814B(sbM833U, this.subscriptionPlanPrice, ")");
    }
}
