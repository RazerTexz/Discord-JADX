package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Tuples2;
import rx.functions.Func2;

/* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
/* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion$observeStoreState$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionEditTierViewModel3<T1, T2, R> implements Func2<EmojiSet, Tuples2<? extends ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, ? extends Channel>>, ServerSettingsGuildRoleSubscriptionEditTierViewModel.StoreState> {
    public static final ServerSettingsGuildRoleSubscriptionEditTierViewModel3 INSTANCE = new ServerSettingsGuildRoleSubscriptionEditTierViewModel3();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel.StoreState call(EmojiSet emojiSet, Tuples2<? extends ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, ? extends Channel>> tuples2) {
        return call2(emojiSet, (Tuples2<ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, Channel>>) tuples2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final ServerSettingsGuildRoleSubscriptionEditTierViewModel.StoreState call2(EmojiSet emojiSet, Tuples2<ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, Channel>> tuples2) {
        ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreDataComponent1 = tuples2.component1();
        Map<Long, Channel> mapComponent2 = tuples2.component2();
        Intrinsics3.checkNotNullExpressionValue(emojiSet, "emojiSet");
        return new ServerSettingsGuildRoleSubscriptionEditTierViewModel.StoreState(mapComponent2, emojiSet, guildRoleSubscriptionStoreDataComponent1);
    }
}
