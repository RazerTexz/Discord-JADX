package com.discord.widgets.settings.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import kotlin.Tuples2;
import p658rx.functions.Func2;

/* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class EditUserOrGuildMemberProfileViewModel3<T1, T2, R> implements Func2<MeUser, Guild, Tuples2<? extends MeUser, ? extends Guild>> {
    public static final EditUserOrGuildMemberProfileViewModel3 INSTANCE = new EditUserOrGuildMemberProfileViewModel3();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends MeUser, ? extends Guild> call(MeUser meUser, Guild guild) {
        return call2(meUser, guild);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<MeUser, Guild> call2(MeUser meUser, Guild guild) {
        return new Tuples2<>(meUser, guild);
    }
}
