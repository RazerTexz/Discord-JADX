package com.discord.widgets.status;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetThreadStatusViewModel.kt */
/* renamed from: com.discord.widgets.status.WidgetThreadStatusViewModel$onUnarchiveTapped$$inlined$let$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadStatusViewModel7 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetThreadStatusViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadStatusViewModel7(WidgetThreadStatusViewModel widgetThreadStatusViewModel) {
        super(0);
        this.this$0 = widgetThreadStatusViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetThreadStatusViewModel.access$updateViewLoading(this.this$0, false);
    }
}
