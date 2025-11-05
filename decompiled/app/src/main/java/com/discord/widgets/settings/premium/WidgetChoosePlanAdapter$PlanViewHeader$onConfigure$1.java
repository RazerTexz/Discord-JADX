package com.discord.widgets.settings.premium;

import android.view.View;
import com.discord.widgets.settings.premium.WidgetChoosePlanAdapter;

/* compiled from: WidgetChoosePlanAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChoosePlanAdapter$PlanViewHeader$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ WidgetChoosePlanAdapter.Item $data;
    public final /* synthetic */ WidgetChoosePlanAdapter.PlanViewHeader this$0;

    public WidgetChoosePlanAdapter$PlanViewHeader$onConfigure$1(WidgetChoosePlanAdapter.PlanViewHeader planViewHeader, WidgetChoosePlanAdapter.Item item) {
        this.this$0 = planViewHeader;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChoosePlanAdapter.access$getOnClickPlan$p(WidgetChoosePlanAdapter.PlanViewHeader.access$getAdapter$p(this.this$0)).invoke(((WidgetChoosePlanAdapter.Item.Plan) this.$data).getPurchaseSku(), ((WidgetChoosePlanAdapter.Item.Plan) this.$data).getOldSkuName(), ((WidgetChoosePlanAdapter.Item.Plan) this.$data).getUpgradeSkuDetails());
    }
}
