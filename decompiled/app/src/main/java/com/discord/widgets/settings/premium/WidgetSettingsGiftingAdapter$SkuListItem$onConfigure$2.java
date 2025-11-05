package com.discord.widgets.settings.premium;

import android.view.View;
import com.discord.widgets.settings.premium.WidgetSettingsGiftingAdapter;

/* compiled from: WidgetSettingsGiftingAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter$SkuListItem$onConfigure$2 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsGiftingAdapter.GiftItem $data;
    public final /* synthetic */ WidgetSettingsGiftingAdapter.SkuListItem this$0;

    public WidgetSettingsGiftingAdapter$SkuListItem$onConfigure$2(WidgetSettingsGiftingAdapter.SkuListItem skuListItem, WidgetSettingsGiftingAdapter.GiftItem giftItem) {
        this.this$0 = skuListItem;
        this.$data = giftItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsGiftingAdapter.access$getOnClickSkuListener$p(WidgetSettingsGiftingAdapter.SkuListItem.access$getAdapter$p(this.this$0)).invoke(Long.valueOf(this.$data.getSku().getId()), this.$data.getPlanId());
    }
}
