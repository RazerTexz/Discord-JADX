package com.discord.widgets.stickers;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.widgets.stickers.GuildStickerSheetViewModel;
import java.util.Map;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func4;

/* JADX INFO: renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildStickerSheetViewModel4<T1, T2, T3, T4, R> implements Func4<GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo, MeUser, Channel, Map<Long, ? extends Guild>, GuildStickerSheetViewModel.StoreState> {
    public static final GuildStickerSheetViewModel4 INSTANCE = new GuildStickerSheetViewModel4();

    @Override // p658rx.functions.Func4
    public /* bridge */ /* synthetic */ GuildStickerSheetViewModel.StoreState call(GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo guildStickerGuildInfo, MeUser meUser, Channel channel, Map<Long, ? extends Guild> map) {
        return call2(guildStickerGuildInfo, meUser, channel, (Map<Long, Guild>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildStickerSheetViewModel.StoreState call2(GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo guildStickerGuildInfo, MeUser meUser, Channel channel, Map<Long, Guild> map) {
        Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
        Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
        Intrinsics3.checkNotNullExpressionValue(map, "userGuilds");
        Intrinsics3.checkNotNullExpressionValue(guildStickerGuildInfo, "guildStickerGuildInfo");
        return new GuildStickerSheetViewModel.StoreState(meUser, lValueOf, map, guildStickerGuildInfo);
    }
}
