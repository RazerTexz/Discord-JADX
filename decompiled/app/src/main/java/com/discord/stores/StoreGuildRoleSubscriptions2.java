package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import java.util.List;
import kotlin.Tuples2;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$observable$1, reason: use source file name */
/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions2<T1, T2, R> implements Func2<GuildRoleSubscriptionGroupListing, List<? extends GuildRoleSubscriptionTierFreeTrial>, Tuples2<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>>> {
    public static final StoreGuildRoleSubscriptions2 INSTANCE = new StoreGuildRoleSubscriptions2();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>> call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, List<? extends GuildRoleSubscriptionTierFreeTrial> list) {
        return call2(guildRoleSubscriptionGroupListing, (List<GuildRoleSubscriptionTierFreeTrial>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<GuildRoleSubscriptionGroupListing, List<GuildRoleSubscriptionTierFreeTrial>> call2(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, List<GuildRoleSubscriptionTierFreeTrial> list) {
        return new Tuples2<>(guildRoleSubscriptionGroupListing, list);
    }
}
