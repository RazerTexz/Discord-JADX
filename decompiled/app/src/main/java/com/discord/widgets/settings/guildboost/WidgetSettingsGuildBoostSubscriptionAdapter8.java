package com.discord.widgets.settings.guildboost;

import com.discord.models.domain.ModelGuildBoostSlot;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter$transferListener$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter8 extends Lambda implements Function2<ModelGuildBoostSlot, Long, Unit> {
    public static final WidgetSettingsGuildBoostSubscriptionAdapter8 INSTANCE = new WidgetSettingsGuildBoostSubscriptionAdapter8();

    public WidgetSettingsGuildBoostSubscriptionAdapter8() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(ModelGuildBoostSlot modelGuildBoostSlot, Long l) {
        invoke(modelGuildBoostSlot, l.longValue());
        return Unit.f27425a;
    }

    public final void invoke(ModelGuildBoostSlot modelGuildBoostSlot, long j) {
        Intrinsics3.checkNotNullParameter(modelGuildBoostSlot, "<anonymous parameter 0>");
    }
}
