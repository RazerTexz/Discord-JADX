package com.discord.widgets.guilds.create;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildCreate.kt */
/* JADX INFO: loaded from: classes2.dex */
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
