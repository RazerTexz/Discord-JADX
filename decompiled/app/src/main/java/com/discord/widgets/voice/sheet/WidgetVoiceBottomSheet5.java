package com.discord.widgets.voice.sheet;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetVoiceBottomSheet.kt */
/* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$forwardToFullscreenIfVideoActivated$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetVoiceBottomSheet5 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ WidgetVoiceBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheet5(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        super(0);
        this.this$0 = widgetVoiceBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return WidgetVoiceBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getBoolean("ARG_FORWARD_TO_FULLSCREEN_IF_VIDEO_ACTIVATED");
    }
}
