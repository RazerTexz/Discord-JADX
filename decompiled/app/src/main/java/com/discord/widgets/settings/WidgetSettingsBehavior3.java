package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreUserSettings;
import d0.z.d.Intrinsics3;
import rx.functions.Action1;

/* compiled from: WidgetSettingsBehavior.kt */
/* renamed from: com.discord.widgets.settings.WidgetSettingsBehavior$onViewBound$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsBehavior3<T> implements Action1<Boolean> {
    public final /* synthetic */ StoreUserSettings $userSettings$inlined;

    public WidgetSettingsBehavior3(StoreUserSettings storeUserSettings) {
        this.$userSettings$inlined = storeUserSettings;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreUserSettings storeUserSettings = this.$userSettings$inlined;
        Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
        storeUserSettings.setIsShiftEnterToSendEnabled(bool.booleanValue());
    }
}
