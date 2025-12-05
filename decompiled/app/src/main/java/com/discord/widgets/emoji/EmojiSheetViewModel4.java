package com.discord.widgets.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreMediaFavorites;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.emoji.EmojiSheetViewModel;
import java.util.Map;
import java.util.Set;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func5;

/* compiled from: EmojiSheetViewModel.kt */
/* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class EmojiSheetViewModel4<T1, T2, T3, T4, T5, R> implements Func5<EmojiSheetViewModel.Companion.CustomEmojGuildInfo, MeUser, Map<Long, ? extends Guild>, Channel, Set<? extends StoreMediaFavorites.Favorite>, EmojiSheetViewModel.StoreState> {
    public final /* synthetic */ EmojiNode.EmojiIdAndType $emojiIdAndType;

    public EmojiSheetViewModel4(EmojiNode.EmojiIdAndType emojiIdAndType) {
        this.$emojiIdAndType = emojiIdAndType;
    }

    @Override // p658rx.functions.Func5
    public /* bridge */ /* synthetic */ EmojiSheetViewModel.StoreState call(EmojiSheetViewModel.Companion.CustomEmojGuildInfo customEmojGuildInfo, MeUser meUser, Map<Long, ? extends Guild> map, Channel channel, Set<? extends StoreMediaFavorites.Favorite> set) {
        return call2(customEmojGuildInfo, meUser, (Map<Long, Guild>) map, channel, set);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final EmojiSheetViewModel.StoreState call2(EmojiSheetViewModel.Companion.CustomEmojGuildInfo customEmojGuildInfo, MeUser meUser, Map<Long, Guild> map, Channel channel, Set<? extends StoreMediaFavorites.Favorite> set) {
        Intrinsics3.checkNotNullParameter(meUser, "meUser");
        Intrinsics3.checkNotNullParameter(map, "guilds");
        Intrinsics3.checkNotNullParameter(set, "favorites");
        return new EmojiSheetViewModel.StoreState(customEmojGuildInfo, this.$emojiIdAndType, UserUtils.INSTANCE.isPremium(meUser), map.keySet(), channel, set);
    }
}
