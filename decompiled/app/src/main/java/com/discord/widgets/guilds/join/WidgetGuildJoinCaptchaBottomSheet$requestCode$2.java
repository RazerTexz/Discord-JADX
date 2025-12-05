package com.discord.widgets.guilds.join;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildJoinCaptchaBottomSheet$requestCode$2 extends Lambda implements Function0<String> {
    public final /* synthetic */ WidgetGuildJoinCaptchaBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildJoinCaptchaBottomSheet$requestCode$2(WidgetGuildJoinCaptchaBottomSheet widgetGuildJoinCaptchaBottomSheet) {
        super(0);
        this.this$0 = widgetGuildJoinCaptchaBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return WidgetGuildJoinCaptchaBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getString("INTENT_EXTRA_REQUEST_CODE", "");
    }
}
