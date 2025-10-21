package com.discord.api.application;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: ThirdPartySku.kt */
/* loaded from: classes.dex */
public final /* data */ class ThirdPartySku {
    private final String distributor;
    private final String id;
    private final String sku;

    /* renamed from: a, reason: from getter */
    public final String getDistributor() {
        return this.distributor;
    }

    /* renamed from: b, reason: from getter */
    public final String getSku() {
        return this.sku;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThirdPartySku)) {
            return false;
        }
        ThirdPartySku thirdPartySku = (ThirdPartySku) other;
        return Intrinsics3.areEqual(this.id, thirdPartySku.id) && Intrinsics3.areEqual(this.sku, thirdPartySku.sku) && Intrinsics3.areEqual(this.distributor, thirdPartySku.distributor);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.sku;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.distributor;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ThirdPartySku(id=");
        sbU.append(this.id);
        sbU.append(", sku=");
        sbU.append(this.sku);
        sbU.append(", distributor=");
        return outline.J(sbU, this.distributor, ")");
    }
}
