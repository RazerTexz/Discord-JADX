package com.discord.widgets.guilds.profile;

import kotlin.jvm.functions.Function0;
import org.objectweb.asm.Opcodes;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$viewModel$2 extends Lambda implements Function0<WidgetGuildProfileSheetViewModel> {
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheet$viewModel$2(WidgetGuildProfileSheet widgetGuildProfileSheet) {
        super(0);
        this.this$0 = widgetGuildProfileSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetGuildProfileSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildProfileSheetViewModel invoke() {
        return new WidgetGuildProfileSheetViewModel(null, null, WidgetGuildProfileSheet.access$getArgumentsOrDefault$p(this.this$0).getBoolean("com.discord.intent.extra.EXTRA_VIEWING_GUILD"), null, null, null, WidgetGuildProfileSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_GUILD_ID"), null, Opcodes.NEW, null);
    }
}
