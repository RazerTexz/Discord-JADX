package com.discord.widgets.settings.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import kotlin.Pair;
import rx.functions.Func2;

/* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* loaded from: classes2.dex */
public final class SettingsUserProfileViewModel$Companion$observeStoreState$1<T1, T2, R> implements Func2<MeUser, Guild, Pair<? extends MeUser, ? extends Guild>> {
    public static final SettingsUserProfileViewModel$Companion$observeStoreState$1 INSTANCE = new SettingsUserProfileViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends MeUser, ? extends Guild> call(MeUser meUser, Guild guild) {
        return call2(meUser, guild);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<MeUser, Guild> call2(MeUser meUser, Guild guild) {
        return new Pair<>(meUser, guild);
    }
}
