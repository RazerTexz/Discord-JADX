package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.settings.WidgetSettingsAppearance;
import d0.z.d.m;
import rx.functions.Func3;

/* compiled from: WidgetSettingsAppearance.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsAppearance$Model$Companion$get$1<T1, T2, T3, R> implements Func3<MeUser, StoreUserSettingsSystem.Settings, Boolean, WidgetSettingsAppearance.Model> {
    public static final WidgetSettingsAppearance$Model$Companion$get$1 INSTANCE = new WidgetSettingsAppearance$Model$Companion$get$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetSettingsAppearance.Model call(MeUser meUser, StoreUserSettingsSystem.Settings settings, Boolean bool) {
        return call2(meUser, settings, bool);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WidgetSettingsAppearance.Model call2(MeUser meUser, StoreUserSettingsSystem.Settings settings, Boolean bool) {
        boolean z2;
        String theme = settings.getTheme();
        m.checkNotNullExpressionValue(bool, "isPureEvilVisible");
        if (!bool.booleanValue()) {
            UserUtils userUtils = UserUtils.INSTANCE;
            m.checkNotNullExpressionValue(meUser, "meUser");
            z2 = userUtils.isStaff(meUser);
        }
        int fontScale = settings.getFontScale();
        m.checkNotNullExpressionValue(meUser, "meUser");
        return new WidgetSettingsAppearance.Model(theme, z2, fontScale, meUser);
    }
}
