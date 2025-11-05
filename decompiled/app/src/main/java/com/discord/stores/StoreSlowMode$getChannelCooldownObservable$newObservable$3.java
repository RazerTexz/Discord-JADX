package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* compiled from: StoreSlowMode.kt */
/* loaded from: classes2.dex */
public final class StoreSlowMode$getChannelCooldownObservable$newObservable$3<T, R> implements b<Long, Integer> {
    public static final StoreSlowMode$getChannelCooldownObservable$newObservable$3 INSTANCE = new StoreSlowMode$getChannelCooldownObservable$newObservable$3();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Integer call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Integer call2(Long l) {
        return Integer.valueOf((int) (l.longValue() / 1000));
    }
}
