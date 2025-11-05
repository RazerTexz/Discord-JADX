package com.discord.widgets.voice.sheet;

import android.view.View;
import b.d.b.a.outline;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet;

/* compiled from: WidgetVoiceSettingsBottomSheet.kt */
/* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheet4 implements View.OnClickListener {
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet.ViewState $viewState$inlined;
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet this$0;

    public WidgetVoiceSettingsBottomSheet4(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet, WidgetVoiceSettingsBottomSheet.ViewState viewState) {
        this.this$0 = widgetVoiceSettingsBottomSheet;
        this.$viewState$inlined = viewState;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChannelNotificationSettings.Companion.launch$default(WidgetChannelNotificationSettings.INSTANCE, outline.x(view, "it", "it.context"), WidgetVoiceSettingsBottomSheet.access$getChannelId$p(this.this$0), false, 4, null);
    }
}
