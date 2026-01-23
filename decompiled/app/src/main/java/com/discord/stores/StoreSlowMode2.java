package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreSlowMode;
import com.discord.utilities.permissions.PermissionUtils;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$1, reason: use source file name */
/* JADX INFO: compiled from: StoreSlowMode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSlowMode2<T, R> implements Func1<Long, Boolean> {
    public final /* synthetic */ StoreSlowMode.Type $type;

    public StoreSlowMode2(StoreSlowMode.Type type) {
        this.$type = type;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Long l) {
        return Boolean.valueOf(PermissionUtils.INSTANCE.hasBypassSlowmodePermissions(l, this.$type));
    }
}
