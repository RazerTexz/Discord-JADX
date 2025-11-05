package com.discord.widgets.voice.sheet;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetVoiceBottomSheet.kt */
/* loaded from: classes.dex */
public final class WidgetVoiceBottomSheet$forwardToFullscreenIfVideoActivated$2 extends o implements Function0<Boolean> {
    public final /* synthetic */ WidgetVoiceBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheet$forwardToFullscreenIfVideoActivated$2(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
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
