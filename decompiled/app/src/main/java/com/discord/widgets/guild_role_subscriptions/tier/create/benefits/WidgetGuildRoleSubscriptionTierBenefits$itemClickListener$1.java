package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapterItem;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet3;
import java.util.List;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 implements GuildRoleSubscriptionBenefitAdapter.Listener {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits this$0;

    public WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits;
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onActiveTrialUserLimitClick() {
        WidgetRadioSelectorBottomSheet.Companion companion = WidgetRadioSelectorBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = this.this$0.requireContext().getString(C5419R.string.guild_role_subscription_setup_tier_active_trial_user_limit_title);
        Intrinsics3.checkNotNullExpressionValue(string, "requireContext().getStri…e_trial_user_limit_title)");
        companion.show(parentFragmentManager, new WidgetRadioSelectorBottomSheet3(string, (List) WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitsViewModel$p(this.this$0).withViewState(new C8543xb42820e4(this))), new C8545xb42820e5(this));
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onAddBenefitItemClick(GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem benefitAdapterItem) {
        Intrinsics3.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
        WidgetGuildRoleSubscriptionTierBenefit.Companion.launch$default(WidgetGuildRoleSubscriptionTierBenefit.INSTANCE, this.this$0.requireContext(), WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitLauncher$p(this.this$0), WidgetGuildRoleSubscriptionTierBenefits.access$getGuildId$p(this.this$0), benefitAdapterItem.getType(), benefitAdapterItem.getTierName(), null, 32, null);
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onBenefitItemClick(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem) {
        Intrinsics3.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
        if (benefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem.BenefitItem) {
            GuildRoleSubscriptionBenefitAdapterItem.BenefitItem benefitItem = (GuildRoleSubscriptionBenefitAdapterItem.BenefitItem) benefitAdapterItem;
            WidgetGuildRoleSubscriptionTierBenefit.INSTANCE.launch(this.this$0.requireContext(), WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitLauncher$p(this.this$0), WidgetGuildRoleSubscriptionTierBenefits.access$getGuildId$p(this.this$0), benefitItem.getType(), benefitItem.getTierName(), benefitItem.getBenefit());
        }
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onFreeTrialToggle(boolean isEnabled) {
        if (isEnabled) {
            WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitsViewModel$p(this.this$0).withViewState(new C8546xa5534d9a(this));
        } else {
            WidgetGuildRoleSubscriptionTierBenefits.access$getViewModel$p(this.this$0).updateFreeTrialInterval(null);
        }
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onTrialIntervalClick() {
        WidgetRadioSelectorBottomSheet.Companion companion = WidgetRadioSelectorBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = this.this$0.requireContext().getString(C5419R.string.guild_role_subscription_setup_free_trial_time_limit_title);
        Intrinsics3.checkNotNullExpressionValue(string, "requireContext().getStri…e_trial_time_limit_title)");
        companion.show(parentFragmentManager, new WidgetRadioSelectorBottomSheet3(string, (List) WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitsViewModel$p(this.this$0).withViewState(new C8547x81da72ab(this))), new C8549x81da72ac(this));
    }
}
