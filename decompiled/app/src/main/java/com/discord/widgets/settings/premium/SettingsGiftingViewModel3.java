package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.utilities.user.UserUtils;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$Companion$observeStores$2, reason: use source file name */
/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGiftingViewModel3<T, R> implements Func1<MeUser, Boolean> {
    public static final SettingsGiftingViewModel3 INSTANCE = new SettingsGiftingViewModel3();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
        return call2(meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(MeUser meUser) {
        UserUtils userUtils = UserUtils.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(meUser, "it");
        return Boolean.valueOf(userUtils.isPremium(meUser));
    }
}
