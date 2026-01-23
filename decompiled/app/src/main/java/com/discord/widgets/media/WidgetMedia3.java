package com.discord.widgets.media;

import com.discord.databinding.WidgetMediaBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$binding$3, reason: use source file name */
/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMedia3 extends FunctionReferenceImpl implements Function1<WidgetMediaBinding, Unit> {
    public WidgetMedia3(WidgetMedia widgetMedia) {
        super(1, widgetMedia, WidgetMedia.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetMediaBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetMediaBinding widgetMediaBinding) {
        invoke2(widgetMediaBinding);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetMediaBinding widgetMediaBinding) {
        Intrinsics3.checkNotNullParameter(widgetMediaBinding, "p1");
        WidgetMedia.access$onViewBindingDestroy((WidgetMedia) this.receiver, widgetMediaBinding);
    }
}
