package com.discord.widgets.guilds.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuildProfiles;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel;
import java.util.List;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func9;

/* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$Companion$observeStores$3, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheetViewModel4<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<Guild, StoreGuildProfiles.GuildProfileData, Boolean, MeUser, GuildMember, List<? extends Long>, List<Emoji>, Boolean, GuildChannelsInfo, WidgetGuildProfileSheetViewModel.StoreState> {
    public static final WidgetGuildProfileSheetViewModel4 INSTANCE = new WidgetGuildProfileSheetViewModel4();

    @Override // p658rx.functions.Func9
    public /* bridge */ /* synthetic */ WidgetGuildProfileSheetViewModel.StoreState call(Guild guild, StoreGuildProfiles.GuildProfileData guildProfileData, Boolean bool, MeUser meUser, GuildMember guildMember, List<? extends Long> list, List<Emoji> list2, Boolean bool2, GuildChannelsInfo guildChannelsInfo) {
        return call2(guild, guildProfileData, bool, meUser, guildMember, (List<Long>) list, list2, bool2, guildChannelsInfo);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildProfileSheetViewModel.StoreState call2(Guild guild, StoreGuildProfiles.GuildProfileData guildProfileData, Boolean bool, MeUser meUser, GuildMember guildMember, List<Long> list, List<Emoji> list2, Boolean bool2, GuildChannelsInfo guildChannelsInfo) {
        Intrinsics3.checkNotNullExpressionValue(guildChannelsInfo, "guildChannelsInfo");
        Intrinsics3.checkNotNullExpressionValue(meUser, "me");
        Intrinsics3.checkNotNullExpressionValue(list, "restrictedGuildIds");
        boolean isDeveloperMode = StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode();
        List<Emoji> listEmptyList = list2 != null ? list2 : Collections2.emptyList();
        Intrinsics3.checkNotNullExpressionValue(bool2, "isLurking");
        boolean zBooleanValue = bool2.booleanValue();
        Intrinsics3.checkNotNullExpressionValue(bool, "isUnread");
        return new WidgetGuildProfileSheetViewModel.StoreState(guild, guildProfileData, guildChannelsInfo, meUser, guildMember, list, isDeveloperMode, listEmptyList, zBooleanValue, bool.booleanValue());
    }
}
