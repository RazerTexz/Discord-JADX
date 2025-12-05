package com.discord.widgets.changelog;

import com.discord.databinding.WidgetChangeLogSpecialBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetChangeLogSpecial.kt */
/* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$binding$3, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChangeLogSpecial3 extends FunctionReferenceImpl implements Function1<WidgetChangeLogSpecialBinding, Unit> {
    public WidgetChangeLogSpecial3(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        super(1, widgetChangeLogSpecial, WidgetChangeLogSpecial.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetChangeLogSpecialBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChangeLogSpecialBinding widgetChangeLogSpecialBinding) {
        invoke2(widgetChangeLogSpecialBinding);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChangeLogSpecialBinding widgetChangeLogSpecialBinding) {
        Intrinsics3.checkNotNullParameter(widgetChangeLogSpecialBinding, "p1");
        WidgetChangeLogSpecial.access$onViewBindingDestroy((WidgetChangeLogSpecial) this.receiver, widgetChangeLogSpecialBinding);
    }
}
