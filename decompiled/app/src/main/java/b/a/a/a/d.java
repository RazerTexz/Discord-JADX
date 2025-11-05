package b.a.a.a;

import b.a.a.a.f;
import com.discord.R;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreSubscriptions;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildBoostCancelViewModel.kt */
/* loaded from: classes.dex */
public final class d extends o implements Function1<f.b, Unit> {
    public final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(f fVar) {
        super(1);
        this.this$0 = fVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(f.b bVar) {
        f.c c0011c;
        ModelSubscription premiumSubscription;
        ModelAppliedGuildBoost premiumGuildSubscription;
        f.b bVar2 = bVar;
        m.checkNotNullParameter(bVar2, "storeState");
        f fVar = this.this$0;
        Objects.requireNonNull(fVar);
        StoreGuildBoost.State state = bVar2.a;
        StoreSubscriptions.SubscriptionsState subscriptionsState = bVar2.f41b;
        if (!(fVar.getViewState() instanceof f.c.b) && !(fVar.getViewState() instanceof f.c.C0011c)) {
            if ((state instanceof StoreGuildBoost.State.Loading) || (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Loading)) {
                c0011c = f.c.C0012f.f;
            } else if ((state instanceof StoreGuildBoost.State.Failure) || (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Failure) || !(state instanceof StoreGuildBoost.State.Loaded) || !(subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Loaded) || (premiumSubscription = ((StoreSubscriptions.SubscriptionsState.Loaded) subscriptionsState).getPremiumSubscription()) == null) {
                c0011c = new f.c.C0011c(Integer.valueOf(R.string.premium_guild_subscription_cancel_error_mobile));
            } else if (fVar.getViewState() instanceof f.c.b) {
                c0011c = new f.c.b(premiumSubscription);
            } else {
                ModelGuildBoostSlot modelGuildBoostSlot = ((StoreGuildBoost.State.Loaded) state).getBoostSlotMap().get(Long.valueOf(fVar.k));
                c0011c = new f.c.e(premiumSubscription, ((modelGuildBoostSlot == null || (premiumGuildSubscription = modelGuildBoostSlot.getPremiumGuildSubscription()) == null) ? null : Long.valueOf(premiumGuildSubscription.getGuildId())) != null);
            }
            fVar.updateViewState(c0011c);
        }
        return Unit.a;
    }
}
