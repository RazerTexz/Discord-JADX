package com.discord.widgets.guilds.join;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildWelcomeSheet.kt */
/* renamed from: com.discord.widgets.guilds.join.WidgetGuildWelcomeSheet$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheet5 extends Lambda implements Function0<WidgetGuildWelcomeSheetViewModel> {
    public final /* synthetic */ WidgetGuildWelcomeSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildWelcomeSheet5(WidgetGuildWelcomeSheet widgetGuildWelcomeSheet) {
        super(0);
        this.this$0 = widgetGuildWelcomeSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetGuildWelcomeSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildWelcomeSheetViewModel invoke() {
        return new WidgetGuildWelcomeSheetViewModel(WidgetGuildWelcomeSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_GUILD_ID"), null, 2, null);
    }
}
