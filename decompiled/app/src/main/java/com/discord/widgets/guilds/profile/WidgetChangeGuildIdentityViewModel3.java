package com.discord.widgets.guilds.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func4;

/* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel$Companion$observeStoreState$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentityViewModel3<T1, T2, T3, T4, R> implements Func4<GuildChannelsInfo, Guild, MeUser, GuildMember, WidgetChangeGuildIdentityViewModel.StoreState> {
    public static final WidgetChangeGuildIdentityViewModel3 INSTANCE = new WidgetChangeGuildIdentityViewModel3();

    @Override // p658rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetChangeGuildIdentityViewModel.StoreState call(GuildChannelsInfo guildChannelsInfo, Guild guild, MeUser meUser, GuildMember guildMember) {
        return call2(guildChannelsInfo, guild, meUser, guildMember);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChangeGuildIdentityViewModel.StoreState call2(GuildChannelsInfo guildChannelsInfo, Guild guild, MeUser meUser, GuildMember guildMember) {
        Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
        Intrinsics3.checkNotNullExpressionValue(guildChannelsInfo, "guildChannelsInfo");
        return new WidgetChangeGuildIdentityViewModel.StoreState(guild, meUser, guildMember, guildChannelsInfo);
    }
}
