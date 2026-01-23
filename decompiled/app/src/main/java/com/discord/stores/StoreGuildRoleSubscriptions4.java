package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import java.util.List;
import kotlin.Tuples2;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$observable$1, reason: use source file name */
/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions4<T1, T2, R> implements Func2<List<? extends GuildRoleSubscriptionGroupListing>, List<? extends GuildRoleSubscriptionTierFreeTrial>, Tuples2<? extends List<? extends GuildRoleSubscriptionGroupListing>, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>>> {
    public static final StoreGuildRoleSubscriptions4 INSTANCE = new StoreGuildRoleSubscriptions4();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends List<? extends GuildRoleSubscriptionGroupListing>, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>> call(List<? extends GuildRoleSubscriptionGroupListing> list, List<? extends GuildRoleSubscriptionTierFreeTrial> list2) {
        return call2((List<GuildRoleSubscriptionGroupListing>) list, (List<GuildRoleSubscriptionTierFreeTrial>) list2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<List<GuildRoleSubscriptionGroupListing>, List<GuildRoleSubscriptionTierFreeTrial>> call2(List<GuildRoleSubscriptionGroupListing> list, List<GuildRoleSubscriptionTierFreeTrial> list2) {
        return new Tuples2<>(list, list2);
    }
}
