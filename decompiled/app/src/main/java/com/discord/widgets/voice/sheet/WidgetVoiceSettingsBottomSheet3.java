package com.discord.widgets.voice.sheet;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetVoiceSettingsBottomSheet.kt */
/* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$channelId$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheet3 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceSettingsBottomSheet3(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet) {
        super(0);
        this.this$0 = widgetVoiceSettingsBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.requireArguments().getLong("ARG_CHANNEL_ID");
    }
}
