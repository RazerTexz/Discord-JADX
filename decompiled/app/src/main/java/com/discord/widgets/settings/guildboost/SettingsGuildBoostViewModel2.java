package com.discord.widgets.settings.guildboost;

import androidx.core.app.NotificationCompat;
import com.discord.api.premium.PremiumTier;
import com.discord.models.user.MeUser;
import j0.k.Func1;

/* compiled from: SettingsGuildBoostViewModel.kt */
/* renamed from: com.discord.widgets.settings.guildboost.SettingsGuildBoostViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SettingsGuildBoostViewModel2<T, R> implements Func1<MeUser, PremiumTier> {
    public static final SettingsGuildBoostViewModel2 INSTANCE = new SettingsGuildBoostViewModel2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ PremiumTier call(MeUser meUser) {
        return call2(meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final PremiumTier call2(MeUser meUser) {
        return meUser.getPremiumTier();
    }
}
