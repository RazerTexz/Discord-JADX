package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackPaymentMetadata.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackPaymentMetadata {
    private final CharSequence paymentType = null;
    private final Long price = null;
    private final Long regularPrice = null;
    private final CharSequence currency = null;
    private final Boolean isGift = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPaymentMetadata)) {
            return false;
        }
        TrackPaymentMetadata trackPaymentMetadata = (TrackPaymentMetadata) other;
        return Intrinsics3.areEqual(this.paymentType, trackPaymentMetadata.paymentType) && Intrinsics3.areEqual(this.price, trackPaymentMetadata.price) && Intrinsics3.areEqual(this.regularPrice, trackPaymentMetadata.regularPrice) && Intrinsics3.areEqual(this.currency, trackPaymentMetadata.currency) && Intrinsics3.areEqual(this.isGift, trackPaymentMetadata.isGift);
    }

    public int hashCode() {
        CharSequence charSequence = this.paymentType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.price;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.regularPrice;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.currency;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.isGift;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackPaymentMetadata(paymentType=");
        sbM833U.append(this.paymentType);
        sbM833U.append(", price=");
        sbM833U.append(this.price);
        sbM833U.append(", regularPrice=");
        sbM833U.append(this.regularPrice);
        sbM833U.append(", currency=");
        sbM833U.append(this.currency);
        sbM833U.append(", isGift=");
        return outline.m816D(sbM833U, this.isGift, ")");
    }
}
