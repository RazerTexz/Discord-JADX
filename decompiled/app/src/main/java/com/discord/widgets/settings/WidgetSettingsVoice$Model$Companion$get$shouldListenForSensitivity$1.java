package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Func2;

/* compiled from: WidgetSettingsVoice.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsVoice$Model$Companion$get$shouldListenForSensitivity$1<T1, T2, R> implements Func2<Boolean, Boolean, Boolean> {
    public static final WidgetSettingsVoice$Model$Companion$get$shouldListenForSensitivity$1 INSTANCE = new WidgetSettingsVoice$Model$Companion$get$shouldListenForSensitivity$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool, Boolean bool2) {
        return call2(bool, bool2);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Boolean call2(Boolean bool, Boolean bool2) {
        boolean z2;
        m.checkNotNullExpressionValue(bool, "userRequestedListenForSensitivity");
        if (!bool.booleanValue()) {
            m.checkNotNullExpressionValue(bool2, "isNativeEngineInitialized");
            z2 = bool2.booleanValue();
        }
        return Boolean.valueOf(z2);
    }
}
