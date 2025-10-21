package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreSlowMode;
import com.discord.utilities.permissions.PermissionUtils;
import j0.k.Func1;

/* compiled from: StoreSlowMode.kt */
/* renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreSlowMode2<T, R> implements Func1<Long, Boolean> {
    public final /* synthetic */ StoreSlowMode.Type $type;

    public StoreSlowMode2(StoreSlowMode.Type type) {
        this.$type = type;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Long l) {
        return Boolean.valueOf(PermissionUtils.INSTANCE.hasBypassSlowmodePermissions(l, this.$type));
    }
}
