package com.discord.widgets.servers.guildboost;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildBoost.kt */
/* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildBoost5 extends Lambda implements Function0<GuildBoostViewModel> {
    public final /* synthetic */ WidgetGuildBoost this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildBoost5(WidgetGuildBoost widgetGuildBoost) {
        super(0);
        this.this$0 = widgetGuildBoost;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildBoostViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildBoostViewModel invoke() {
        return new GuildBoostViewModel(WidgetGuildBoost.access$getGuildId$p(this.this$0), null, null, null, null, 30, null);
    }
}
