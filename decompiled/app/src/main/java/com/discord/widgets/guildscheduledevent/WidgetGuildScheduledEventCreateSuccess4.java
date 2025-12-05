package com.discord.widgets.guildscheduledevent;

import com.discord.utilities.intent.IntentUtilsKt;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$guildId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess4 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetGuildScheduledEventCreateSuccess this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventCreateSuccess4(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        super(0);
        this.this$0 = widgetGuildScheduledEventCreateSuccess;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        Long longExtraOrNull = IntentUtilsKt.getLongExtraOrNull(this.this$0.getMostRecentIntent(), "com.discord.intent.extra.EXTRA_GUILD_ID");
        if (longExtraOrNull != null) {
            return longExtraOrNull.longValue();
        }
        throw new IllegalStateException();
    }
}
