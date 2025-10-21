package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* compiled from: TrackStoreSkuMetadata.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackStoreSkuMetadata {
    private final Long skuId = null;
    private final Long skuType = null;
    private final Long applicationId = null;
    private final CharSequence applicationName = null;
    private final CharSequence storeTitle = null;
    private final CharSequence distributionType = null;
    private final Long quantity = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStoreSkuMetadata)) {
            return false;
        }
        TrackStoreSkuMetadata trackStoreSkuMetadata = (TrackStoreSkuMetadata) other;
        return Intrinsics3.areEqual(this.skuId, trackStoreSkuMetadata.skuId) && Intrinsics3.areEqual(this.skuType, trackStoreSkuMetadata.skuType) && Intrinsics3.areEqual(this.applicationId, trackStoreSkuMetadata.applicationId) && Intrinsics3.areEqual(this.applicationName, trackStoreSkuMetadata.applicationName) && Intrinsics3.areEqual(this.storeTitle, trackStoreSkuMetadata.storeTitle) && Intrinsics3.areEqual(this.distributionType, trackStoreSkuMetadata.distributionType) && Intrinsics3.areEqual(this.quantity, trackStoreSkuMetadata.quantity);
    }

    public int hashCode() {
        Long l = this.skuId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.skuType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.applicationId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.applicationName;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.storeTitle;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.distributionType;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l4 = this.quantity;
        return iHashCode6 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStoreSkuMetadata(skuId=");
        sbU.append(this.skuId);
        sbU.append(", skuType=");
        sbU.append(this.skuType);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", applicationName=");
        sbU.append(this.applicationName);
        sbU.append(", storeTitle=");
        sbU.append(this.storeTitle);
        sbU.append(", distributionType=");
        sbU.append(this.distributionType);
        sbU.append(", quantity=");
        return outline.G(sbU, this.quantity, ")");
    }
}
