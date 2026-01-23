package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$Model$Companion$get$shouldListenForSensitivity$1 */
/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9689x8d464d17<T1, T2, R> implements Func2<Boolean, Boolean, Boolean> {
    public static final C9689x8d464d17 INSTANCE = new C9689x8d464d17();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool, Boolean bool2) {
        return call2(bool, bool2);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Boolean call2(Boolean bool, Boolean bool2) {
        boolean z2;
        Intrinsics3.checkNotNullExpressionValue(bool, "userRequestedListenForSensitivity");
        if (!bool.booleanValue()) {
            Intrinsics3.checkNotNullExpressionValue(bool2, "isNativeEngineInitialized");
            z2 = bool2.booleanValue();
        }
        return Boolean.valueOf(z2);
    }
}
