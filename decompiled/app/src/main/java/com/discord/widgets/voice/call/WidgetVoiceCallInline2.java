package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.voice.call.WidgetVoiceCallInline;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$Model$Companion$get$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallInline2<T, R> implements Func1<WidgetVoiceCallInline.Model.VoiceConnected, WidgetVoiceCallInline.Model> {
    public static final WidgetVoiceCallInline2 INSTANCE = new WidgetVoiceCallInline2();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ WidgetVoiceCallInline.Model call(WidgetVoiceCallInline.Model.VoiceConnected voiceConnected) {
        return call2(voiceConnected);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetVoiceCallInline.Model call2(WidgetVoiceCallInline.Model.VoiceConnected voiceConnected) {
        return new WidgetVoiceCallInline.Model(voiceConnected);
    }
}
