package com.discord.widgets.channels;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChannelPickerBottomSheet.kt */
/* renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheet$guildId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheet4 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetChannelPickerBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPickerBottomSheet4(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        super(0);
        this.this$0 = widgetChannelPickerBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return WidgetChannelPickerBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_CHANNEL_PICKER_GUILD_ID", -1L);
    }
}
