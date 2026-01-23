package com.discord.widgets.voice.fullscreen;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildCallOnboardingSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCallOnboardingSheet3 extends Lambda implements Function0<WidgetGuildCallOnboardingSheetViewModel> {
    public final /* synthetic */ WidgetGuildCallOnboardingSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCallOnboardingSheet3(WidgetGuildCallOnboardingSheet widgetGuildCallOnboardingSheet) {
        super(0);
        this.this$0 = widgetGuildCallOnboardingSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetGuildCallOnboardingSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildCallOnboardingSheetViewModel invoke() {
        return new WidgetGuildCallOnboardingSheetViewModel(WidgetGuildCallOnboardingSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID"), null, null, null, null, null, 62, null);
    }
}
