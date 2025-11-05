package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.voice.call.WidgetVoiceCallInline;
import j0.k.b;

/* compiled from: WidgetVoiceCallInline.kt */
/* loaded from: classes.dex */
public final class WidgetVoiceCallInline$Model$Companion$get$1<T, R> implements b<WidgetVoiceCallInline.Model.VoiceConnected, WidgetVoiceCallInline.Model> {
    public static final WidgetVoiceCallInline$Model$Companion$get$1 INSTANCE = new WidgetVoiceCallInline$Model$Companion$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetVoiceCallInline.Model call(WidgetVoiceCallInline.Model.VoiceConnected voiceConnected) {
        return call2(voiceConnected);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetVoiceCallInline.Model call2(WidgetVoiceCallInline.Model.VoiceConnected voiceConnected) {
        return new WidgetVoiceCallInline.Model(voiceConnected);
    }
}
