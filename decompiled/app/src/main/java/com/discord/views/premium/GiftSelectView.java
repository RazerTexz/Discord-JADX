package com.discord.views.premium;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetChoosePlanAdapterPlanItemBinding;
import com.discord.utilities.billing.GooglePlayInAppSku;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GiftSelectView.kt */
/* loaded from: classes2.dex */
public final class GiftSelectView extends FrameLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final WidgetChoosePlanAdapterPlanItemBinding binding;

    /* renamed from: k, reason: from kotlin metadata */
    public Function1<? super GooglePlayInAppSku, Unit> onClickPlan;

    /* renamed from: l, reason: from kotlin metadata */
    public GooglePlayInAppSku inAppSku;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.widget_choose_plan_adapter_plan_item, (ViewGroup) this, false);
        addView(viewInflate);
        WidgetChoosePlanAdapterPlanItemBinding widgetChoosePlanAdapterPlanItemBindingM8412a = WidgetChoosePlanAdapterPlanItemBinding.m8412a(viewInflate);
        Intrinsics3.checkNotNullExpressionValue(widgetChoosePlanAdapterPlanItemBindingM8412a, "WidgetChoosePlanAdapterP…rom(context), this, true)");
        this.binding = widgetChoosePlanAdapterPlanItemBindingM8412a;
    }
}
