package com.discord.widgets.chat;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetUrlActions.kt */
/* renamed from: com.discord.widgets.chat.WidgetUrlActions$url$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetUrlActions4 extends Lambda implements Function0<String> {
    public final /* synthetic */ WidgetUrlActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUrlActions4(WidgetUrlActions widgetUrlActions) {
        super(0);
        this.this$0 = widgetUrlActions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return WidgetUrlActions.access$getArgumentsOrDefault$p(this.this$0).getString("INTENT_URL", "");
    }
}
