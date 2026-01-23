package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.fcm.NotificationClient;
import java.util.HashSet;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func4;

/* JADX INFO: renamed from: com.discord.stores.StoreNotifications$configureNotificationClient$completedSettings$2, reason: use source file name */
/* JADX INFO: compiled from: StoreNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotifications3<T1, T2, T3, T4, R> implements Func4<NotificationClient.SettingsV2, String, StoreUserSettingsSystem.Settings, HashSet<Long>, NotificationClient.SettingsV2> {
    public static final StoreNotifications3 INSTANCE = new StoreNotifications3();

    @Override // p658rx.functions.Func4
    public /* bridge */ /* synthetic */ NotificationClient.SettingsV2 call(NotificationClient.SettingsV2 settingsV2, String str, StoreUserSettingsSystem.Settings settings, HashSet<Long> hashSet) {
        return call2(settingsV2, str, settings, hashSet);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final NotificationClient.SettingsV2 call2(NotificationClient.SettingsV2 settingsV2, String str, StoreUserSettingsSystem.Settings settings, HashSet<Long> hashSet) {
        String locale = settings.getLocale();
        Intrinsics3.checkNotNullExpressionValue(hashSet, "nonSendableChannelIds");
        return NotificationClient.SettingsV2.copy$default(settingsV2, false, false, false, false, false, false, str, locale, hashSet, 63, null);
    }
}
