package com.discord.widgets.guildscheduledevent;

import com.discord.utilities.intent.IntentUtilsKt;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$channelId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess3 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetGuildScheduledEventCreateSuccess this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventCreateSuccess3(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        super(0);
        this.this$0 = widgetGuildScheduledEventCreateSuccess;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return IntentUtilsKt.getLongExtraOrNull(this.this$0.getMostRecentIntent(), "com.discord.intent.extra.EXTRA_CHANNEL_ID");
    }
}
