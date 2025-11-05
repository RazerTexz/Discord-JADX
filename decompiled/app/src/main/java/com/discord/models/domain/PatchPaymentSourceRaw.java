package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.models.domain.billing.ModelBillingAddress;
import d0.z.d.m;

/* compiled from: ModelPaymentSource.kt */
/* loaded from: classes.dex */
public final /* data */ class PatchPaymentSourceRaw {
    private final ModelBillingAddress billingAddress;
    private final boolean default;

    public PatchPaymentSourceRaw(ModelBillingAddress modelBillingAddress, boolean z2) {
        m.checkNotNullParameter(modelBillingAddress, "billingAddress");
        this.billingAddress = modelBillingAddress;
        this.default = z2;
    }

    public static /* synthetic */ PatchPaymentSourceRaw copy$default(PatchPaymentSourceRaw patchPaymentSourceRaw, ModelBillingAddress modelBillingAddress, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            modelBillingAddress = patchPaymentSourceRaw.billingAddress;
        }
        if ((i & 2) != 0) {
            z2 = patchPaymentSourceRaw.default;
        }
        return patchPaymentSourceRaw.copy(modelBillingAddress, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final ModelBillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getDefault() {
        return this.default;
    }

    public final PatchPaymentSourceRaw copy(ModelBillingAddress billingAddress, boolean z2) {
        m.checkNotNullParameter(billingAddress, "billingAddress");
        return new PatchPaymentSourceRaw(billingAddress, z2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PatchPaymentSourceRaw)) {
            return false;
        }
        PatchPaymentSourceRaw patchPaymentSourceRaw = (PatchPaymentSourceRaw) other;
        return m.areEqual(this.billingAddress, patchPaymentSourceRaw.billingAddress) && this.default == patchPaymentSourceRaw.default;
    }

    public final ModelBillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    public final boolean getDefault() {
        return this.default;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        ModelBillingAddress modelBillingAddress = this.billingAddress;
        int iHashCode = (modelBillingAddress != null ? modelBillingAddress.hashCode() : 0) * 31;
        boolean z2 = this.default;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        StringBuilder sbU = a.U("PatchPaymentSourceRaw(billingAddress=");
        sbU.append(this.billingAddress);
        sbU.append(", default=");
        return a.O(sbU, this.default, ")");
    }
}
