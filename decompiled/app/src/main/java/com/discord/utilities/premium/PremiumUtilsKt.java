package com.discord.utilities.premium;

import com.discord.api.premium.PremiumTier;
import d0.z.d.m;

/* compiled from: PremiumUtils.kt */
/* loaded from: classes2.dex */
public final class PremiumUtilsKt {
    public static final boolean grantsAccessToCustomTagAndAnimatedAvatarFeatures(PremiumTier premiumTier) {
        m.checkNotNullParameter(premiumTier, "$this$grantsAccessToCustomTagAndAnimatedAvatarFeatures");
        return premiumTier == PremiumTier.TIER_1 || premiumTier == PremiumTier.TIER_2;
    }

    public static final boolean grantsAccessToPremiumStickers(PremiumTier premiumTier) {
        m.checkNotNullParameter(premiumTier, "$this$grantsAccessToPremiumStickers");
        return premiumTier == PremiumTier.TIER_2 || premiumTier == PremiumTier.TIER_0;
    }
}
