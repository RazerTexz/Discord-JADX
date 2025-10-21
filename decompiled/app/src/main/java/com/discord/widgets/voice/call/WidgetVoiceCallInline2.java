package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.voice.call.WidgetVoiceCallInline;
import j0.k.Func1;

/* compiled from: WidgetVoiceCallInline.kt */
/* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetVoiceCallInline2<T, R> implements Func1<WidgetVoiceCallInline.Model.VoiceConnected, WidgetVoiceCallInline.Model> {
    public static final WidgetVoiceCallInline2 INSTANCE = new WidgetVoiceCallInline2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ WidgetVoiceCallInline.Model call(WidgetVoiceCallInline.Model.VoiceConnected voiceConnected) {
        return call2(voiceConnected);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetVoiceCallInline.Model call2(WidgetVoiceCallInline.Model.VoiceConnected voiceConnected) {
        return new WidgetVoiceCallInline.Model(voiceConnected);
    }
}
