package com.discord.widgets.captcha;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetCaptchaBottomSheet.kt */
/* renamed from: com.discord.widgets.captcha.WidgetCaptchaBottomSheet$requestCode$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetCaptchaBottomSheet6 extends Lambda implements Function0<String> {
    public final /* synthetic */ WidgetCaptchaBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCaptchaBottomSheet6(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet) {
        super(0);
        this.this$0 = widgetCaptchaBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return WidgetCaptchaBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getString("INTENT_EXTRA_REQUEST_CODE", "");
    }
}
