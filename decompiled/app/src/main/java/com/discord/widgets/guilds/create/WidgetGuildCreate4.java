package com.discord.widgets.guilds.create;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildCreate.kt */
/* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildCreate4 extends Lambda implements Function0<WidgetGuildCreateViewModel> {
    public final /* synthetic */ WidgetGuildCreate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCreate4(WidgetGuildCreate widgetGuildCreate) {
        super(0);
        this.this$0 = widgetGuildCreate;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetGuildCreateViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildCreateViewModel invoke() {
        return this.this$0.createViewModelFactory();
    }
}
