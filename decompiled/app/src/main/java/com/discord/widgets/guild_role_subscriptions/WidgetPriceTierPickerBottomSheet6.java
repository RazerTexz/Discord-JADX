package com.discord.widgets.guild_role_subscriptions;

import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.Tuples;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetPriceTierPickerBottomSheet.kt */
/* renamed from: com.discord.widgets.guild_role_subscriptions.WidgetPriceTierPickerBottomSheet$itemClickListener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetPriceTierPickerBottomSheet6 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetPriceTierPickerBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPriceTierPickerBottomSheet6(WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet) {
        super(1);
        this.this$0 = widgetPriceTierPickerBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.f27425a;
    }

    public final void invoke(int i) {
        String string = WidgetPriceTierPickerBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getString("INTENT_EXTRA_REQUEST_CODE", "");
        WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet = this.this$0;
        Intrinsics3.checkNotNullExpressionValue(string, "requestCode");
        Fragment2.setFragmentResult(widgetPriceTierPickerBottomSheet, string, Bundle2.bundleOf(Tuples.m10073to("RESULT_EXTRA_PRICE_TIER", Integer.valueOf(i))));
        this.this$0.dismiss();
    }
}
