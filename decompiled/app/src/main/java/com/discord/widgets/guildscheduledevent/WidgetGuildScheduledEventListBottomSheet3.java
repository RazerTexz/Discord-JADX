package com.discord.widgets.guildscheduledevent;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$channelId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventListBottomSheet3 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetGuildScheduledEventListBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventListBottomSheet3(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
        super(0);
        this.this$0 = widgetGuildScheduledEventListBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        long j = this.this$0.requireArguments().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
        if (j == -1) {
            return null;
        }
        return Long.valueOf(j);
    }
}
