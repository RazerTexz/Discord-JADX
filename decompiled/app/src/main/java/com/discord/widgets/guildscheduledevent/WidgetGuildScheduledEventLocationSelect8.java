package com.discord.widgets.guildscheduledevent;

import com.discord.utilities.intent.IntentUtilsKt;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelect8 extends Lambda implements Function0<WidgetGuildScheduledEventLocationSelectViewModel> {
    public final /* synthetic */ WidgetGuildScheduledEventLocationSelect this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventLocationSelect8(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        super(0);
        this.this$0 = widgetGuildScheduledEventLocationSelect;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetGuildScheduledEventLocationSelectViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildScheduledEventLocationSelectViewModel invoke() {
        return new WidgetGuildScheduledEventLocationSelectViewModel(WidgetGuildScheduledEventLocationSelect.access$getGuildId$p(this.this$0), IntentUtilsKt.getLongExtraOrNull(this.this$0.getMostRecentIntent(), "com.discord.intent.extra.EXTRA_CHANNEL_ID"), WidgetGuildScheduledEventLocationSelect.access$getExistingGuildScheduledEventId$p(this.this$0), null, null, null, null, null, 248, null);
    }
}
