package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackMarketingSite.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackMarketingSite {
    private final CharSequence marketingVariant = null;

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackMarketingSite) && Intrinsics3.areEqual(this.marketingVariant, ((TrackMarketingSite) other).marketingVariant);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.marketingVariant;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m817E(outline.m833U("TrackMarketingSite(marketingVariant="), this.marketingVariant, ")");
    }
}
