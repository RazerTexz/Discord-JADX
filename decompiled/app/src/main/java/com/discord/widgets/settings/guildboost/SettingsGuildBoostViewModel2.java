package com.discord.widgets.settings.guildboost;

import androidx.core.app.NotificationCompat;
import com.discord.api.premium.PremiumTier;
import com.discord.models.user.MeUser;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.SettingsGuildBoostViewModel$Companion$observeStores$1, reason: use source file name */
/* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGuildBoostViewModel2<T, R> implements Func1<MeUser, PremiumTier> {
    public static final SettingsGuildBoostViewModel2 INSTANCE = new SettingsGuildBoostViewModel2();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ PremiumTier call(MeUser meUser) {
        return call2(meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final PremiumTier call2(MeUser meUser) {
        return meUser.getPremiumTier();
    }
}
