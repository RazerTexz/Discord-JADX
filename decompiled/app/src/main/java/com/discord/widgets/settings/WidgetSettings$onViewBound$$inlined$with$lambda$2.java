package com.discord.widgets.settings;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$$inlined$with$lambda$2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettings$onViewBound$$inlined$with$lambda$2(WidgetSettings widgetSettings) {
        super(0);
        this.this$0 = widgetSettings;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetSettings.access$getViewModelUserProfileHeader$p(this.this$0).toggleAllowAnimationInReducedMotion();
    }
}
