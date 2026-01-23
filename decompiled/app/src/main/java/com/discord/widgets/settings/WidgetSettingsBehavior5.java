package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreUserSettings;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsBehavior$onViewBound$$inlined$apply$lambda$3, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsBehavior.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBehavior5<T> implements Action1<Boolean> {
    public final /* synthetic */ StoreUserSettings $userSettings$inlined;

    public WidgetSettingsBehavior5(StoreUserSettings storeUserSettings) {
        this.$userSettings$inlined = storeUserSettings;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreUserSettings storeUserSettings = this.$userSettings$inlined;
        Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
        storeUserSettings.setIsChromeCustomTabsEnabled(bool.booleanValue());
    }
}
