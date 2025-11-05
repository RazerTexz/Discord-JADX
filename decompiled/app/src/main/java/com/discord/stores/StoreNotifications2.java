package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.permission.Permission;
import com.discord.utilities.permissions.PermissionUtils;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: StoreNotifications.kt */
/* renamed from: com.discord.stores.StoreNotifications$configureNotificationClient$completedSettings$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreNotifications2<T, R> implements Func1<Map<Long, ? extends Long>, HashSet<Long>> {
    public static final StoreNotifications2 INSTANCE = new StoreNotifications2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ HashSet<Long> call(Map<Long, ? extends Long> map) {
        return call2((Map<Long, Long>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final HashSet<Long> call2(Map<Long, Long> map) {
        Intrinsics3.checkNotNullExpressionValue(map, "channelPermissions");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            if (!PermissionUtils.can(Permission.SEND_MESSAGES, Long.valueOf(entry.getValue().longValue()))) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return _Collections.toHashSet(linkedHashMap.keySet());
    }
}
