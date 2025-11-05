package com.discord.utilities.gifting;

import com.discord.models.domain.ModelGift;
import d0.z.d.m;

/* compiled from: GiftStyle.kt */
/* loaded from: classes2.dex */
public final class GiftStyleKt {
    public static final GiftStyle getCustomStyle(ModelGift modelGift) {
        m.checkNotNullParameter(modelGift, "$this$getCustomStyle");
        return GiftStyle.INSTANCE.from(modelGift);
    }

    public static final boolean hasCustomStyle(ModelGift modelGift) {
        m.checkNotNullParameter(modelGift, "$this$hasCustomStyle");
        return getCustomStyle(modelGift) != null;
    }
}
