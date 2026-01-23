package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.utilities.user.UserUtils;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$1 */
/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6277x99818c96<T, R> implements Func1<MeUser, Boolean> {
    public static final C6277x99818c96 INSTANCE = new C6277x99818c96();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
        return call2(meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(MeUser meUser) {
        UserUtils userUtils = UserUtils.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(meUser, "me");
        return Boolean.valueOf(userUtils.getHasPhone(meUser));
    }
}
