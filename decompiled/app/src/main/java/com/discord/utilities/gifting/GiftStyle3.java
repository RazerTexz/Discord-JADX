package com.discord.utilities.gifting;

import com.discord.models.domain.ModelGift;
import d0.z.d.Intrinsics3;

/* compiled from: GiftStyle.kt */
/* renamed from: com.discord.utilities.gifting.GiftStyleKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GiftStyle3 {
    public static final GiftStyle getCustomStyle(ModelGift modelGift) {
        Intrinsics3.checkNotNullParameter(modelGift, "$this$getCustomStyle");
        return GiftStyle.INSTANCE.from(modelGift);
    }

    public static final boolean hasCustomStyle(ModelGift modelGift) {
        Intrinsics3.checkNotNullParameter(modelGift, "$this$hasCustomStyle");
        return getCustomStyle(modelGift) != null;
    }
}
