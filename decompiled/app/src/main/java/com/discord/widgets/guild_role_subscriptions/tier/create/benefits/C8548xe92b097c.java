package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils2;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet2;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onTrialIntervalClick$1$$special$$inlined$mapIndexed$lambda$1 */
/* loaded from: classes2.dex */
public final class C8548xe92b097c extends Lambda implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, WidgetRadioSelectorBottomSheet2> {
    public final /* synthetic */ int $index;
    public final /* synthetic */ SubscriptionTrialInterval $subscriptionTrialInterval;
    public final /* synthetic */ C8547x81da72ab this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8548xe92b097c(int i, SubscriptionTrialInterval subscriptionTrialInterval, C8547x81da72ab c8547x81da72ab) {
        super(1);
        this.$index = i;
        this.$subscriptionTrialInterval = subscriptionTrialInterval;
        this.this$0 = c8547x81da72ab;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetRadioSelectorBottomSheet2 invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        return invoke2(viewState);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetRadioSelectorBottomSheet2 invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "guildRoleSubscriptionTierViewModelState");
        return new WidgetRadioSelectorBottomSheet2(this.$index, String.valueOf(GuildRoleSubscriptionUtils2.getFormattedLabel(this.$subscriptionTrialInterval, this.this$0.this$0.this$0.requireContext())), Intrinsics3.areEqual(viewState.getGuildRoleSubscriptionTier().getTrialInterval(), this.$subscriptionTrialInterval));
    }
}
