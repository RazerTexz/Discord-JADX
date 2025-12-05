package com.discord.widgets.voice.sheet;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetVoiceSettingsBottomSheet.kt */
/* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$viewModel$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheet5 extends Lambda implements Function0<WidgetVoiceSettingsBottomSheetViewModel> {
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceSettingsBottomSheet5(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet) {
        super(0);
        this.this$0 = widgetVoiceSettingsBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetVoiceSettingsBottomSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetVoiceSettingsBottomSheetViewModel invoke() {
        return new WidgetVoiceSettingsBottomSheetViewModel(WidgetVoiceSettingsBottomSheet.access$getChannelId$p(this.this$0), null, null, null, 14, null);
    }
}
