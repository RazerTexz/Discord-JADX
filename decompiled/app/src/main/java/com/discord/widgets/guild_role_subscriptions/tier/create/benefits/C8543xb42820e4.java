package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitsViewModel;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet2;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1 */
/* loaded from: classes2.dex */
public final class C8543xb42820e4 extends Lambda implements Function1<GuildRoleSubscriptionTierBenefitsViewModel.ViewState, List<? extends WidgetRadioSelectorBottomSheet2>> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8543xb42820e4(WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends WidgetRadioSelectorBottomSheet2> invoke(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
        return invoke2(viewState);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<WidgetRadioSelectorBottomSheet2> invoke2(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "it");
        List<Integer> activeTrialUserLimitOptions = viewState.getActiveTrialUserLimitOptions();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(activeTrialUserLimitOptions, 10));
        int i = 0;
        for (Object obj : activeTrialUserLimitOptions) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            arrayList.add((WidgetRadioSelectorBottomSheet2) WidgetGuildRoleSubscriptionTierBenefits.access$getViewModel$p(this.this$0.this$0).withViewState(new C8544x62fd44f5(i, (Integer) obj, this)));
            i = i2;
        }
        return arrayList;
    }
}
