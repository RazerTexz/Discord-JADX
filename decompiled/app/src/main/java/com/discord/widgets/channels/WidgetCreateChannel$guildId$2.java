package com.discord.widgets.channels;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetCreateChannel.kt */
/* loaded from: classes2.dex */
public final class WidgetCreateChannel$guildId$2 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetCreateChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreateChannel$guildId$2(WidgetCreateChannel widgetCreateChannel) {
        super(0);
        this.this$0 = widgetCreateChannel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.getMostRecentIntent().getLongExtra("INTENT_GUILD_ID", -1L);
    }
}
