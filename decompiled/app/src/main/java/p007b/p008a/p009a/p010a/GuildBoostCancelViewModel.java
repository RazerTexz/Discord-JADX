package p007b.p008a.p009a.p010a;

import com.discord.C5419R;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreSubscriptions;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.p010a.GuildBoostCancelViewModel3;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: GuildBoostCancelViewModel.kt */
/* renamed from: b.a.a.a.d, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildBoostCancelViewModel extends Lambda implements Function1<GuildBoostCancelViewModel3.b, Unit> {
    public final /* synthetic */ GuildBoostCancelViewModel3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostCancelViewModel(GuildBoostCancelViewModel3 guildBoostCancelViewModel3) {
        super(1);
        this.this$0 = guildBoostCancelViewModel3;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(GuildBoostCancelViewModel3.b bVar) {
        GuildBoostCancelViewModel3.c c13204c;
        ModelSubscription premiumSubscription;
        ModelAppliedGuildBoost premiumGuildSubscription;
        GuildBoostCancelViewModel3.b bVar2 = bVar;
        Intrinsics3.checkNotNullParameter(bVar2, "storeState");
        GuildBoostCancelViewModel3 guildBoostCancelViewModel3 = this.this$0;
        Objects.requireNonNull(guildBoostCancelViewModel3);
        StoreGuildBoost.State state = bVar2.f196a;
        StoreSubscriptions.SubscriptionsState subscriptionsState = bVar2.f197b;
        if (!(guildBoostCancelViewModel3.getViewState() instanceof GuildBoostCancelViewModel3.c.b) && !(guildBoostCancelViewModel3.getViewState() instanceof GuildBoostCancelViewModel3.c.C13204c)) {
            if ((state instanceof StoreGuildBoost.State.Loading) || (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Loading)) {
                c13204c = GuildBoostCancelViewModel3.c.f.f209f;
            } else if ((state instanceof StoreGuildBoost.State.Failure) || (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Failure) || !(state instanceof StoreGuildBoost.State.Loaded) || !(subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Loaded) || (premiumSubscription = ((StoreSubscriptions.SubscriptionsState.Loaded) subscriptionsState).getPremiumSubscription()) == null) {
                c13204c = new GuildBoostCancelViewModel3.c.C13204c(Integer.valueOf(C5419R.string.premium_guild_subscription_cancel_error_mobile));
            } else if (guildBoostCancelViewModel3.getViewState() instanceof GuildBoostCancelViewModel3.c.b) {
                c13204c = new GuildBoostCancelViewModel3.c.b(premiumSubscription);
            } else {
                ModelGuildBoostSlot modelGuildBoostSlot = ((StoreGuildBoost.State.Loaded) state).getBoostSlotMap().get(Long.valueOf(guildBoostCancelViewModel3.f192k));
                c13204c = new GuildBoostCancelViewModel3.c.e(premiumSubscription, ((modelGuildBoostSlot == null || (premiumGuildSubscription = modelGuildBoostSlot.getPremiumGuildSubscription()) == null) ? null : Long.valueOf(premiumGuildSubscription.getGuildId())) != null);
            }
            guildBoostCancelViewModel3.updateViewState(c13204c);
        }
        return Unit.f27425a;
    }
}
