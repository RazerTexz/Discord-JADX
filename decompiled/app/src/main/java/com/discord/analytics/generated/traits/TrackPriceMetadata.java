package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackPriceMetadata.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackPriceMetadata {
    private final Long price = null;
    private final Long regularPrice = null;
    private final CharSequence currency = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPriceMetadata)) {
            return false;
        }
        TrackPriceMetadata trackPriceMetadata = (TrackPriceMetadata) other;
        return Intrinsics3.areEqual(this.price, trackPriceMetadata.price) && Intrinsics3.areEqual(this.regularPrice, trackPriceMetadata.regularPrice) && Intrinsics3.areEqual(this.currency, trackPriceMetadata.currency);
    }

    public int hashCode() {
        Long l = this.price;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.regularPrice;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.currency;
        return iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackPriceMetadata(price=");
        sbM833U.append(this.price);
        sbM833U.append(", regularPrice=");
        sbM833U.append(this.regularPrice);
        sbM833U.append(", currency=");
        return outline.m817E(sbM833U, this.currency, ")");
    }
}
