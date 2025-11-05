package b.a.a.a;

import b.a.a.a.k;
import com.discord.R;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreSubscriptions;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildBoostUncancelViewModel.kt */
/* loaded from: classes.dex */
public final class i extends o implements Function1<k.b, Unit> {
    public final /* synthetic */ k this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(k kVar) {
        super(1);
        this.this$0 = kVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(k.b bVar) {
        Object aVar;
        k.b bVar2 = bVar;
        m.checkNotNullParameter(bVar2, "storeState");
        k kVar = this.this$0;
        if (!(kVar.getViewState() instanceof k.c.d) && !(kVar.getViewState() instanceof k.c.a)) {
            StoreSubscriptions.SubscriptionsState subscriptionsState = bVar2.a;
            if (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Loading) {
                aVar = k.c.C0013c.a;
            } else if (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Failure) {
                aVar = new k.c.a(Integer.valueOf(R.string.premium_guild_subscription_cancel_error_mobile));
            } else if (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Loaded) {
                ModelSubscription premiumSubscription = ((StoreSubscriptions.SubscriptionsState.Loaded) subscriptionsState).getPremiumSubscription();
                aVar = premiumSubscription == null ? new k.c.a(Integer.valueOf(R.string.premium_guild_subscription_cancel_error_mobile)) : new k.c.b(premiumSubscription, false, false);
            } else {
                aVar = new k.c.a(null, 1);
            }
            kVar.updateViewState(aVar);
        }
        return Unit.a;
    }
}
