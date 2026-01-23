package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.stores.StoreStream;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice$Model$Companion$get$1<T, R> implements Func1<Boolean, Observable<? extends MediaEngine.LocalVoiceStatus>> {
    public static final WidgetSettingsVoice$Model$Companion$get$1 INSTANCE = new WidgetSettingsVoice$Model$Companion$get$1();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends MediaEngine.LocalVoiceStatus> call(Boolean bool) {
        return call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends MediaEngine.LocalVoiceStatus> call2(Boolean bool) {
        Intrinsics3.checkNotNullExpressionValue(bool, "isListeningForSensitivity");
        return bool.booleanValue() ? StoreStream.INSTANCE.getMediaEngine().getLocalVoiceStatus() : new ScalarSynchronousObservable(WidgetSettingsVoice.access$getLOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED$cp());
    }
}
