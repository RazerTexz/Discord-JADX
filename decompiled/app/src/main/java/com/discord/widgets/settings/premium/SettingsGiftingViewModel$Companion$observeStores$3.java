package com.discord.widgets.settings.premium;

import com.discord.models.domain.ModelGift;
import com.discord.stores.StoreEntitlements;
import com.discord.stores.StoreOutboundPromotions;
import com.discord.widgets.settings.premium.SettingsGiftingViewModel;
import d0.z.d.k;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.functions.Function4;

/* compiled from: SettingsGiftingViewModel.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class SettingsGiftingViewModel$Companion$observeStores$3 extends k implements Function4<StoreEntitlements.State, List<? extends ModelGift>, StoreOutboundPromotions.State, Boolean, SettingsGiftingViewModel.StoreState> {
    public static final SettingsGiftingViewModel$Companion$observeStores$3 INSTANCE = new SettingsGiftingViewModel$Companion$observeStores$3();

    public SettingsGiftingViewModel$Companion$observeStores$3() {
        super(4, SettingsGiftingViewModel.StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreEntitlements$State;Ljava/util/List;Lcom/discord/stores/StoreOutboundPromotions$State;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ SettingsGiftingViewModel.StoreState invoke(StoreEntitlements.State state, List<? extends ModelGift> list, StoreOutboundPromotions.State state2, Boolean bool) {
        return invoke(state, (List<ModelGift>) list, state2, bool.booleanValue());
    }

    public final SettingsGiftingViewModel.StoreState invoke(StoreEntitlements.State state, List<ModelGift> list, StoreOutboundPromotions.State state2, boolean z2) {
        m.checkNotNullParameter(state, "p1");
        m.checkNotNullParameter(list, "p2");
        m.checkNotNullParameter(state2, "p3");
        return new SettingsGiftingViewModel.StoreState(state, list, state2, z2);
    }
}
