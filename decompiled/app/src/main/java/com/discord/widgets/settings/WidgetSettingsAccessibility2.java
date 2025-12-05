package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.settings.WidgetSettingsAccessibility;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func4;

/* compiled from: WidgetSettingsAccessibility.kt */
/* renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsAccessibility2<T1, T2, T3, T4, R> implements Func4<Boolean, Boolean, Boolean, Integer, WidgetSettingsAccessibility.Model> {
    public static final WidgetSettingsAccessibility2 INSTANCE = new WidgetSettingsAccessibility2();

    @Override // p658rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetSettingsAccessibility.Model call(Boolean bool, Boolean bool2, Boolean bool3, Integer num) {
        return call2(bool, bool2, bool3, num);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccessibility.Model call2(Boolean bool, Boolean bool2, Boolean bool3, Integer num) {
        Intrinsics3.checkNotNullExpressionValue(bool, "reducedMotionEnabled");
        boolean zBooleanValue = bool.booleanValue();
        Intrinsics3.checkNotNullExpressionValue(bool2, "allowAnimatedEmoji");
        boolean zBooleanValue2 = bool2.booleanValue();
        Intrinsics3.checkNotNullExpressionValue(bool3, "autoPlayGifs");
        boolean zBooleanValue3 = bool3.booleanValue();
        Intrinsics3.checkNotNullExpressionValue(num, "currentStickerAnimationSettings");
        return new WidgetSettingsAccessibility.Model(zBooleanValue, zBooleanValue2, zBooleanValue3, num.intValue());
    }
}
