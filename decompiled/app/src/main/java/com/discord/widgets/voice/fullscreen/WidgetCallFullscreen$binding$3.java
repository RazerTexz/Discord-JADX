package com.discord.widgets.voice.fullscreen;

import com.discord.databinding.WidgetCallFullscreenBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetCallFullscreen.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetCallFullscreen$binding$3 extends FunctionReferenceImpl implements Function1<WidgetCallFullscreenBinding, Unit> {
    public WidgetCallFullscreen$binding$3(WidgetCallFullscreen widgetCallFullscreen) {
        super(1, widgetCallFullscreen, WidgetCallFullscreen.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetCallFullscreenBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetCallFullscreenBinding widgetCallFullscreenBinding) {
        invoke2(widgetCallFullscreenBinding);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetCallFullscreenBinding widgetCallFullscreenBinding) {
        Intrinsics3.checkNotNullParameter(widgetCallFullscreenBinding, "p1");
        WidgetCallFullscreen.access$onViewBindingDestroy((WidgetCallFullscreen) this.receiver, widgetCallFullscreenBinding);
    }
}
