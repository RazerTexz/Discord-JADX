package com.discord.stores;

import com.discord.utilities.fcm.NotificationClient;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreNotifications.kt */
/* renamed from: com.discord.stores.StoreNotifications$setEnabledInApp$oldValue$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreNotifications4 extends Lambda implements Function1<NotificationClient.SettingsV2, NotificationClient.SettingsV2> {
    public final /* synthetic */ boolean $isEnabledInApp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNotifications4(boolean z2) {
        super(1);
        this.$isEnabledInApp = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ NotificationClient.SettingsV2 invoke(NotificationClient.SettingsV2 settingsV2) {
        return invoke2(settingsV2);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final NotificationClient.SettingsV2 invoke2(NotificationClient.SettingsV2 settingsV2) {
        Intrinsics3.checkNotNullParameter(settingsV2, "it");
        return NotificationClient.SettingsV2.copy$default(settingsV2, false, this.$isEnabledInApp, false, false, false, false, null, null, null, 509, null);
    }
}
