package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreNotifications;
import d0.z.d.Intrinsics3;
import rx.functions.Action1;

/* compiled from: WidgetSettingsNotifications.kt */
/* renamed from: com.discord.widgets.settings.WidgetSettingsNotifications$onViewBound$1$5, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsNotifications7<T> implements Action1<Boolean> {
    public final /* synthetic */ StoreNotifications $this_apply;

    public WidgetSettingsNotifications7(StoreNotifications storeNotifications) {
        this.$this_apply = storeNotifications;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreNotifications storeNotifications = this.$this_apply;
        Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
        storeNotifications.setNotificationSoundDisabled(bool.booleanValue());
    }
}
