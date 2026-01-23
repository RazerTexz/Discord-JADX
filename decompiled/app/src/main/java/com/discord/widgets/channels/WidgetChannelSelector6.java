package com.discord.widgets.channels;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSelector$requestCode$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSelector6 extends Lambda implements Function0<String> {
    public final /* synthetic */ WidgetChannelSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSelector6(WidgetChannelSelector widgetChannelSelector) {
        super(0);
        this.this$0 = widgetChannelSelector;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return WidgetChannelSelector.access$getArgumentsOrDefault$p(this.this$0).getString("INTENT_EXTRA_REQUEST_CODE", "");
    }
}
