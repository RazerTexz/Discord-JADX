package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import kotlin.Tuples2;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$observable$2, reason: use source file name */
/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions3<T, R> implements Func1<GuildRoleSubscriptionGroupListing, Tuples2> {
    public static final StoreGuildRoleSubscriptions3 INSTANCE = new StoreGuildRoleSubscriptions3();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Tuples2 call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        return call2(guildRoleSubscriptionGroupListing);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2 call2(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        return new Tuples2(guildRoleSubscriptionGroupListing, null);
    }
}
