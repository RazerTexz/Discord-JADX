package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.fcm.NotificationClient;
import d0.z.d.m;
import java.util.HashSet;
import rx.functions.Func4;

/* compiled from: StoreNotifications.kt */
/* loaded from: classes2.dex */
public final class StoreNotifications$configureNotificationClient$completedSettings$2<T1, T2, T3, T4, R> implements Func4<NotificationClient.SettingsV2, String, StoreUserSettingsSystem.Settings, HashSet<Long>, NotificationClient.SettingsV2> {
    public static final StoreNotifications$configureNotificationClient$completedSettings$2 INSTANCE = new StoreNotifications$configureNotificationClient$completedSettings$2();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ NotificationClient.SettingsV2 call(NotificationClient.SettingsV2 settingsV2, String str, StoreUserSettingsSystem.Settings settings, HashSet<Long> hashSet) {
        return call2(settingsV2, str, settings, hashSet);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final NotificationClient.SettingsV2 call2(NotificationClient.SettingsV2 settingsV2, String str, StoreUserSettingsSystem.Settings settings, HashSet<Long> hashSet) {
        String locale = settings.getLocale();
        m.checkNotNullExpressionValue(hashSet, "nonSendableChannelIds");
        return NotificationClient.SettingsV2.copy$default(settingsV2, false, false, false, false, false, false, str, locale, hashSet, 63, null);
    }
}
