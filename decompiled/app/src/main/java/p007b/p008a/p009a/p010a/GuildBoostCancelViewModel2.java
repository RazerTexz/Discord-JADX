package p007b.p008a.p009a.p010a;

import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreSubscriptions;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p009a.p010a.GuildBoostCancelViewModel3;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildBoostCancelViewModel.kt */
/* renamed from: b.a.a.a.e, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class GuildBoostCancelViewModel2 extends FunctionReferenceImpl implements Function2<StoreGuildBoost.State, StoreSubscriptions.SubscriptionsState, GuildBoostCancelViewModel3.b> {

    /* renamed from: j */
    public static final GuildBoostCancelViewModel2 f190j = new GuildBoostCancelViewModel2();

    public GuildBoostCancelViewModel2() {
        super(2, GuildBoostCancelViewModel3.b.class, "<init>", "<init>(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public GuildBoostCancelViewModel3.b invoke(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState) {
        StoreGuildBoost.State state2 = state;
        StoreSubscriptions.SubscriptionsState subscriptionsState2 = subscriptionsState;
        Intrinsics3.checkNotNullParameter(state2, "p1");
        Intrinsics3.checkNotNullParameter(subscriptionsState2, "p2");
        return new GuildBoostCancelViewModel3.b(state2, subscriptionsState2);
    }
}
