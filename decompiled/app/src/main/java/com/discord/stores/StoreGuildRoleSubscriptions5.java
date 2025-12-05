package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import java.util.List;
import kotlin.Tuples2;
import p637j0.p641k.Func1;

/* compiled from: StoreGuildRoleSubscriptions.kt */
/* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$observable$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions5<T, R> implements Func1<List<? extends GuildRoleSubscriptionGroupListing>, Tuples2> {
    public static final StoreGuildRoleSubscriptions5 INSTANCE = new StoreGuildRoleSubscriptions5();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Tuples2 call(List<? extends GuildRoleSubscriptionGroupListing> list) {
        return call2((List<GuildRoleSubscriptionGroupListing>) list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2 call2(List<GuildRoleSubscriptionGroupListing> list) {
        return new Tuples2(list, null);
    }
}
