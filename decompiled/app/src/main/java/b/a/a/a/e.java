package b.a.a.a;

import b.a.a.a.f;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreSubscriptions;
import d0.z.d.m;
import kotlin.jvm.functions.Function2;

/* compiled from: GuildBoostCancelViewModel.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class e extends d0.z.d.k implements Function2<StoreGuildBoost.State, StoreSubscriptions.SubscriptionsState, f.b> {
    public static final e j = new e();

    public e() {
        super(2, f.b.class, "<init>", "<init>(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public f.b invoke(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState) {
        StoreGuildBoost.State state2 = state;
        StoreSubscriptions.SubscriptionsState subscriptionsState2 = subscriptionsState;
        m.checkNotNullParameter(state2, "p1");
        m.checkNotNullParameter(subscriptionsState2, "p2");
        return new f.b(state2, subscriptionsState2);
    }
}
