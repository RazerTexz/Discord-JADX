package com.discord.widgets.servers.guildboost;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildBoost.kt */
/* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$choosePlanLauncher$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildBoost3 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetGuildBoost this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildBoost3(WidgetGuildBoost widgetGuildBoost) {
        super(0);
        this.this$0 = widgetGuildBoost;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetGuildBoost.access$fetchData(this.this$0);
    }
}
