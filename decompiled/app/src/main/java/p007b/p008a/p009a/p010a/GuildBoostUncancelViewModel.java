package p007b.p008a.p009a.p010a;

import com.discord.C5419R;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreSubscriptions;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.p010a.GuildBoostUncancelViewModel3;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.a.a.i, reason: use source file name */
/* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildBoostUncancelViewModel extends Lambda implements Function1<GuildBoostUncancelViewModel3.b, Unit> {
    public final /* synthetic */ GuildBoostUncancelViewModel3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostUncancelViewModel(GuildBoostUncancelViewModel3 guildBoostUncancelViewModel3) {
        super(1);
        this.this$0 = guildBoostUncancelViewModel3;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(GuildBoostUncancelViewModel3.b bVar) {
        Object aVar;
        GuildBoostUncancelViewModel3.b bVar2 = bVar;
        Intrinsics3.checkNotNullParameter(bVar2, "storeState");
        GuildBoostUncancelViewModel3 guildBoostUncancelViewModel3 = this.this$0;
        if (!(guildBoostUncancelViewModel3.getViewState() instanceof GuildBoostUncancelViewModel3.c.d) && !(guildBoostUncancelViewModel3.getViewState() instanceof GuildBoostUncancelViewModel3.c.a)) {
            StoreSubscriptions.SubscriptionsState subscriptionsState = bVar2.f217a;
            if (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Loading) {
                aVar = GuildBoostUncancelViewModel3.c.C13205c.f222a;
            } else if (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Failure) {
                aVar = new GuildBoostUncancelViewModel3.c.a(Integer.valueOf(C5419R.string.premium_guild_subscription_cancel_error_mobile));
            } else if (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Loaded) {
                ModelSubscription premiumSubscription = ((StoreSubscriptions.SubscriptionsState.Loaded) subscriptionsState).getPremiumSubscription();
                aVar = premiumSubscription == null ? new GuildBoostUncancelViewModel3.c.a(Integer.valueOf(C5419R.string.premium_guild_subscription_cancel_error_mobile)) : new GuildBoostUncancelViewModel3.c.b(premiumSubscription, false, false);
            } else {
                aVar = new GuildBoostUncancelViewModel3.c.a(null, 1);
            }
            guildBoostUncancelViewModel3.updateViewState(aVar);
        }
        return Unit.f27425a;
    }
}
