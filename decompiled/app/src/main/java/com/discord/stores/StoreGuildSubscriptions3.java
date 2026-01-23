package com.discord.stores;

import com.discord.utilities.lazy.subscriptions.GuildSubscriptions;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.stores.StoreGuildSubscriptions$subscriptionsManager$1, reason: use source file name */
/* JADX INFO: compiled from: StoreGuildSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildSubscriptions3 extends Lambda implements Function2<Long, GuildSubscriptions, Unit> {
    public final /* synthetic */ StoreGuildSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildSubscriptions3(StoreGuildSubscriptions storeGuildSubscriptions) {
        super(2);
        this.this$0 = storeGuildSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, GuildSubscriptions guildSubscriptions) {
        invoke(l.longValue(), guildSubscriptions);
        return Unit.f27425a;
    }

    public final void invoke(long j, GuildSubscriptions guildSubscriptions) {
        Intrinsics3.checkNotNullParameter(guildSubscriptions, "subscriptions");
        StoreGuildSubscriptions.access$getStoreStream$p(this.this$0).getGatewaySocket().updateGuildSubscriptions(j, guildSubscriptions);
    }
}
