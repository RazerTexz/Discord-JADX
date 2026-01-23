package com.discord.stores;

import androidx.core.app.NotificationCompat;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$3, reason: use source file name */
/* JADX INFO: compiled from: StoreSlowMode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSlowMode4<T, R> implements Func1<Long, Integer> {
    public static final StoreSlowMode4 INSTANCE = new StoreSlowMode4();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Integer call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Integer call2(Long l) {
        return Integer.valueOf((int) (l.longValue() / ((long) 1000)));
    }
}
