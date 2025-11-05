package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.permission.Permission;
import com.discord.utilities.permissions.PermissionUtils;
import d0.t.u;
import d0.z.d.m;
import j0.k.b;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: StoreNotifications.kt */
/* loaded from: classes2.dex */
public final class StoreNotifications$configureNotificationClient$completedSettings$1<T, R> implements b<Map<Long, ? extends Long>, HashSet<Long>> {
    public static final StoreNotifications$configureNotificationClient$completedSettings$1 INSTANCE = new StoreNotifications$configureNotificationClient$completedSettings$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ HashSet<Long> call(Map<Long, ? extends Long> map) {
        return call2((Map<Long, Long>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final HashSet<Long> call2(Map<Long, Long> map) {
        m.checkNotNullExpressionValue(map, "channelPermissions");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            if (!PermissionUtils.can(Permission.SEND_MESSAGES, Long.valueOf(entry.getValue().longValue()))) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return u.toHashSet(linkedHashMap.keySet());
    }
}
