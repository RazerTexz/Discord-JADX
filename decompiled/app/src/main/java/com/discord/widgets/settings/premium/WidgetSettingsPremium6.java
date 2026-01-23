package com.discord.widgets.settings.premium;

import com.discord.C5419R;
import com.discord.utilities.billing.GooglePlayBillingManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p018d.AppToast;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$managePlanCallback$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium6 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetSettingsPremium this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPremium6(WidgetSettingsPremium widgetSettingsPremium) {
        super(0);
        this.this$0 = widgetSettingsPremium;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AppToast.m171i(this.this$0, C5419R.string.billing_error_purchase, 0, 4);
        GooglePlayBillingManager.INSTANCE.queryPurchases();
    }
}
