package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import rx.functions.Func2;

/* compiled from: StoreUserSettings.kt */
/* renamed from: com.discord.stores.StoreUserSettings$observeStickerAnimationSettings$1$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreUserSettings5<T1, T2, R> implements Func2<Integer, Boolean, Integer> {
    public static final StoreUserSettings5 INSTANCE = new StoreUserSettings5();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Integer call(Integer num, Boolean bool) {
        return call2(num, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Integer call2(Integer num, Boolean bool) {
        if (num == null || num.intValue() != 0) {
            return num;
        }
        Intrinsics3.checkNotNullExpressionValue(bool, "useReducedMotion");
        if (bool.booleanValue()) {
            return 1;
        }
        return num;
    }
}
