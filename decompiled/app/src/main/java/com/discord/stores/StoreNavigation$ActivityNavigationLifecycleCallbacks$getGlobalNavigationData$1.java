package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import j0.k.Func1;

/* compiled from: StoreNavigation.kt */
/* loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$1<T, R> implements Func1<MeUser, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$1();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
        return call2(meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(MeUser meUser) {
        UserUtils userUtils = UserUtils.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(meUser, "me");
        return Boolean.valueOf(userUtils.getHasPhone(meUser));
    }
}
