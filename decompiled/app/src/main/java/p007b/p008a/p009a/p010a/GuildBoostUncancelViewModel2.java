package p007b.p008a.p009a.p010a;

import com.discord.stores.StoreSubscriptions;
import p007b.p008a.p009a.p010a.GuildBoostUncancelViewModel3;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* compiled from: GuildBoostUncancelViewModel.kt */
/* renamed from: b.a.a.a.j, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildBoostUncancelViewModel2<T, R> implements Func1<StoreSubscriptions.SubscriptionsState, GuildBoostUncancelViewModel3.b> {

    /* renamed from: j */
    public static final GuildBoostUncancelViewModel2 f211j = new GuildBoostUncancelViewModel2();

    @Override // p637j0.p641k.Func1
    public GuildBoostUncancelViewModel3.b call(StoreSubscriptions.SubscriptionsState subscriptionsState) {
        StoreSubscriptions.SubscriptionsState subscriptionsState2 = subscriptionsState;
        Intrinsics3.checkNotNullExpressionValue(subscriptionsState2, "it");
        return new GuildBoostUncancelViewModel3.b(subscriptionsState2);
    }
}
