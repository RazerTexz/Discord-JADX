package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.Func1;

/* compiled from: StoreStream.kt */
/* loaded from: classes2.dex */
public final class StoreStream$startStoreInitializationTimer$isOfflineObservable$1<T, R> implements Func1<Boolean, Boolean> {
    public static final StoreStream$startStoreInitializationTimer$isOfflineObservable$1 INSTANCE = new StoreStream$startStoreInitializationTimer$isOfflineObservable$1();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool) {
        return call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool) {
        return Boolean.valueOf(!bool.booleanValue());
    }
}
