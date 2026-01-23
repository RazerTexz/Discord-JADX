package com.discord.widgets.status;

import com.discord.databinding.WidgetGlobalStatusIndicatorBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$binding$3, reason: use source file name */
/* JADX INFO: compiled from: WidgetGlobalStatusIndicator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGlobalStatusIndicator3 extends FunctionReferenceImpl implements Function1<WidgetGlobalStatusIndicatorBinding, Unit> {
    public WidgetGlobalStatusIndicator3(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator) {
        super(1, widgetGlobalStatusIndicator, WidgetGlobalStatusIndicator.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetGlobalStatusIndicatorBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorBinding widgetGlobalStatusIndicatorBinding) {
        invoke2(widgetGlobalStatusIndicatorBinding);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGlobalStatusIndicatorBinding widgetGlobalStatusIndicatorBinding) {
        Intrinsics3.checkNotNullParameter(widgetGlobalStatusIndicatorBinding, "p1");
        WidgetGlobalStatusIndicator.access$onViewBindingDestroy((WidgetGlobalStatusIndicator) this.receiver, widgetGlobalStatusIndicatorBinding);
    }
}
