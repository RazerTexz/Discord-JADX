package com.discord.widgets.settings.premium;

import android.view.View;
import com.discord.widgets.settings.premium.WidgetSettingsGiftingAdapter;

/* compiled from: WidgetSettingsGiftingAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$3 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsGiftingAdapter.GiftItem $data;
    public final /* synthetic */ WidgetSettingsGiftingAdapter.EntitlementListItem this$0;

    public WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$3(WidgetSettingsGiftingAdapter.EntitlementListItem entitlementListItem, WidgetSettingsGiftingAdapter.GiftItem giftItem) {
        this.this$0 = entitlementListItem;
        this.$data = giftItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsGiftingAdapter.access$getOnClickCopyListener$p(WidgetSettingsGiftingAdapter.EntitlementListItem.access$getAdapter$p(this.this$0)).invoke(this.$data.getGift().getCode());
    }
}
