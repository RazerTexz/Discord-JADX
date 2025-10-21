package com.discord.widgets.settings;

import android.view.View;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreStream;
import com.discord.widgets.settings.WidgetSettingsVoice;

/* compiled from: WidgetSettingsVoice.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsVoice$InputModeSelector$onViewCreated$2 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsVoice.InputModeSelector this$0;

    public WidgetSettingsVoice$InputModeSelector$onViewCreated$2(WidgetSettingsVoice.InputModeSelector inputModeSelector) {
        this.this$0 = inputModeSelector;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StoreStream.INSTANCE.getMediaSettings().setVoiceInputMode(MediaEngineConnection.InputMode.VOICE_ACTIVITY);
        this.this$0.dismiss();
    }
}
