package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel;
import d0.z.d.m;
import java.util.Map;
import kotlin.Pair;
import rx.functions.Func2;

/* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
/* loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion$observeStoreState$2<T1, T2, R> implements Func2<EmojiSet, Pair<? extends ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, ? extends Channel>>, ServerSettingsGuildRoleSubscriptionEditTierViewModel.StoreState> {
    public static final ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion$observeStoreState$2 INSTANCE = new ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion$observeStoreState$2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel.StoreState call(EmojiSet emojiSet, Pair<? extends ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, ? extends Channel>> pair) {
        return call2(emojiSet, (Pair<ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, Channel>>) pair);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final ServerSettingsGuildRoleSubscriptionEditTierViewModel.StoreState call2(EmojiSet emojiSet, Pair<ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, Channel>> pair) {
        ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreDataComponent1 = pair.component1();
        Map<Long, Channel> mapComponent2 = pair.component2();
        m.checkNotNullExpressionValue(emojiSet, "emojiSet");
        return new ServerSettingsGuildRoleSubscriptionEditTierViewModel.StoreState(mapComponent2, emojiSet, guildRoleSubscriptionStoreDataComponent1);
    }
}
