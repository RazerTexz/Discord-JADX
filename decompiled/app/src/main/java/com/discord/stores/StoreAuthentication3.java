package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.Func1;

/* compiled from: StoreAuthentication.kt */
/* renamed from: com.discord.stores.StoreAuthentication$getPreLogoutSignal$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreAuthentication3<T, R> implements Func1<Boolean, Boolean> {
    public static final StoreAuthentication3 INSTANCE = new StoreAuthentication3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool) {
        return call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool) {
        return Boolean.valueOf(!bool.booleanValue());
    }
}
