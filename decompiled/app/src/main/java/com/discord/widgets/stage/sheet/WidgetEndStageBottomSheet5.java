package com.discord.widgets.stage.sheet;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetEndStageBottomSheet.kt */
/* renamed from: com.discord.widgets.stage.sheet.WidgetEndStageBottomSheet$requestKey$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetEndStageBottomSheet5 extends Lambda implements Function0<String> {
    public final /* synthetic */ WidgetEndStageBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEndStageBottomSheet5(WidgetEndStageBottomSheet widgetEndStageBottomSheet) {
        super(0);
        this.this$0 = widgetEndStageBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return this.this$0.requireArguments().getString("INTENT_EXTRA_REQUEST_KEY", "");
    }
}
