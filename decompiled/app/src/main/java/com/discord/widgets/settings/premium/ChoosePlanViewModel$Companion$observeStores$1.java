package com.discord.widgets.settings.premium;

import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreGooglePlaySkuDetails;
import com.discord.stores.StoreSubscriptions;
import com.discord.widgets.settings.premium.ChoosePlanViewModel;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function4;

/* compiled from: ChoosePlanViewModel.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class ChoosePlanViewModel$Companion$observeStores$1 extends k implements Function4<StoreGooglePlaySkuDetails.State, StoreGooglePlayPurchases.State, StoreGooglePlayPurchases.QueryState, StoreSubscriptions.SubscriptionsState, ChoosePlanViewModel.StoreState> {
    public static final ChoosePlanViewModel$Companion$observeStores$1 INSTANCE = new ChoosePlanViewModel$Companion$observeStores$1();

    public ChoosePlanViewModel$Companion$observeStores$1() {
        super(4, ChoosePlanViewModel.StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreGooglePlaySkuDetails$State;Lcom/discord/stores/StoreGooglePlayPurchases$State;Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ ChoosePlanViewModel.StoreState invoke(StoreGooglePlaySkuDetails.State state, StoreGooglePlayPurchases.State state2, StoreGooglePlayPurchases.QueryState queryState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
        return invoke2(state, state2, queryState, subscriptionsState);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ChoosePlanViewModel.StoreState invoke2(StoreGooglePlaySkuDetails.State state, StoreGooglePlayPurchases.State state2, StoreGooglePlayPurchases.QueryState queryState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
        m.checkNotNullParameter(state, "p1");
        m.checkNotNullParameter(state2, "p2");
        m.checkNotNullParameter(queryState, "p3");
        m.checkNotNullParameter(subscriptionsState, "p4");
        return new ChoosePlanViewModel.StoreState(state, state2, queryState, subscriptionsState);
    }
}
