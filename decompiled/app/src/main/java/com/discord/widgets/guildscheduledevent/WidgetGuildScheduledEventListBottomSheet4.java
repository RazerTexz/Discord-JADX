package com.discord.widgets.guildscheduledevent;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$guildId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventListBottomSheet4 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetGuildScheduledEventListBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventListBottomSheet4(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
        super(0);
        this.this$0 = widgetGuildScheduledEventListBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.requireArguments().getLong("com.discord.intent.extra.EXTRA_GUILD_ID");
    }
}
