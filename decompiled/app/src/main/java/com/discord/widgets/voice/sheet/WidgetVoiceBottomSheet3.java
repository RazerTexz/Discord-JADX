package com.discord.widgets.voice.sheet;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetVoiceBottomSheet.kt */
/* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$channelId$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetVoiceBottomSheet3 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetVoiceBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheet3(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        super(0);
        this.this$0 = widgetVoiceBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return WidgetVoiceBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID");
    }
}
