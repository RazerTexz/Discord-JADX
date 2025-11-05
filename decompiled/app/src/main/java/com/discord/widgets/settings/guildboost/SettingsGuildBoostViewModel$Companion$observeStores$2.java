package com.discord.widgets.settings.guildboost;

import com.discord.api.premium.PremiumTier;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreSubscriptions;
import com.discord.widgets.settings.guildboost.SettingsGuildBoostViewModel;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.functions.Function4;

/* compiled from: SettingsGuildBoostViewModel.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class SettingsGuildBoostViewModel$Companion$observeStores$2 extends k implements Function4<StoreGuildBoost.State, StoreSubscriptions.SubscriptionsState, Map<Long, ? extends Guild>, PremiumTier, SettingsGuildBoostViewModel.StoreState> {
    public static final SettingsGuildBoostViewModel$Companion$observeStores$2 INSTANCE = new SettingsGuildBoostViewModel$Companion$observeStores$2();

    public SettingsGuildBoostViewModel$Companion$observeStores$2() {
        super(4, SettingsGuildBoostViewModel.StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Ljava/util/Map;Lcom/discord/api/premium/PremiumTier;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ SettingsGuildBoostViewModel.StoreState invoke(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, Map<Long, ? extends Guild> map, PremiumTier premiumTier) {
        return invoke2(state, subscriptionsState, (Map<Long, Guild>) map, premiumTier);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final SettingsGuildBoostViewModel.StoreState invoke2(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, Map<Long, Guild> map, PremiumTier premiumTier) {
        m.checkNotNullParameter(state, "p1");
        m.checkNotNullParameter(subscriptionsState, "p2");
        m.checkNotNullParameter(map, "p3");
        m.checkNotNullParameter(premiumTier, "p4");
        return new SettingsGuildBoostViewModel.StoreState(state, subscriptionsState, map, premiumTier);
    }
}
