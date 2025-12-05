package com.discord.widgets.settings.billing;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetPaymentSourceEditDialog.kt */
/* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$paymentSourceId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog4 extends Lambda implements Function0<String> {
    public final /* synthetic */ WidgetPaymentSourceEditDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPaymentSourceEditDialog4(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog) {
        super(0);
        this.this$0 = widgetPaymentSourceEditDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        String string;
        Bundle arguments = this.this$0.getArguments();
        if (arguments == null || (string = arguments.getString("ARG_PAYMENT_SOURCE_ID")) == null) {
            string = "";
        }
        Intrinsics3.checkNotNullExpressionValue(string, "arguments?.getString(ARG_PAYMENT_SOURCE_ID) ?: \"\"");
        return string;
    }
}
