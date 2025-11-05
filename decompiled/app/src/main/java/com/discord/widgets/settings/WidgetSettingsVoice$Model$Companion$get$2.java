package com.discord.widgets.settings;

import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.stores.StoreMediaSettings;
import com.discord.widgets.settings.WidgetSettingsVoice;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetSettingsVoice.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsVoice$Model$Companion$get$2 extends k implements Function3<StoreMediaSettings.VoiceConfiguration, MediaEngine.OpenSLESConfig, MediaEngine.LocalVoiceStatus, WidgetSettingsVoice.Model> {
    public static final WidgetSettingsVoice$Model$Companion$get$2 INSTANCE = new WidgetSettingsVoice$Model$Companion$get$2();

    public WidgetSettingsVoice$Model$Companion$get$2() {
        super(3, WidgetSettingsVoice.Model.class, "<init>", "<init>(Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;Lcom/discord/rtcconnection/mediaengine/MediaEngine$OpenSLESConfig;Lcom/discord/rtcconnection/mediaengine/MediaEngine$LocalVoiceStatus;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ WidgetSettingsVoice.Model invoke(StoreMediaSettings.VoiceConfiguration voiceConfiguration, MediaEngine.OpenSLESConfig openSLESConfig, MediaEngine.LocalVoiceStatus localVoiceStatus) {
        return invoke2(voiceConfiguration, openSLESConfig, localVoiceStatus);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsVoice.Model invoke2(StoreMediaSettings.VoiceConfiguration voiceConfiguration, MediaEngine.OpenSLESConfig openSLESConfig, MediaEngine.LocalVoiceStatus localVoiceStatus) {
        m.checkNotNullParameter(voiceConfiguration, "p1");
        m.checkNotNullParameter(openSLESConfig, "p2");
        m.checkNotNullParameter(localVoiceStatus, "p3");
        return new WidgetSettingsVoice.Model(voiceConfiguration, openSLESConfig, localVoiceStatus, null);
    }
}
