package com.discord.stores;

import androidx.core.app.NotificationCompat;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func2;

/* compiled from: StoreUserSettings.kt */
/* renamed from: com.discord.stores.StoreUserSettings$observeIsAnimatedEmojisEnabled$1$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreUserSettings3<T1, T2, R> implements Func2<Boolean, Boolean, Boolean> {
    public static final StoreUserSettings3 INSTANCE = new StoreUserSettings3();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool, Boolean bool2) {
        return call2(bool, bool2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool, Boolean bool2) {
        Intrinsics3.checkNotNullExpressionValue(bool, "allowAnimatedEmojis");
        return Boolean.valueOf(bool.booleanValue() && !bool2.booleanValue());
    }
}
