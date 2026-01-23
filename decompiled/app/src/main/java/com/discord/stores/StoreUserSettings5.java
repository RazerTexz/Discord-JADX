package com.discord.stores;

import androidx.core.app.NotificationCompat;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: com.discord.stores.StoreUserSettings$observeStickerAnimationSettings$1$1, reason: use source file name */
/* JADX INFO: compiled from: StoreUserSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSettings5<T1, T2, R> implements Func2<Integer, Boolean, Integer> {
    public static final StoreUserSettings5 INSTANCE = new StoreUserSettings5();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ Integer call(Integer num, Boolean bool) {
        return call2(num, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
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
