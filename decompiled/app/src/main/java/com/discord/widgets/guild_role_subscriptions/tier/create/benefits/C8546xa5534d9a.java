package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitsViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onFreeTrialToggle$1 */
/* loaded from: classes2.dex */
public final class C8546xa5534d9a extends Lambda implements Function1<GuildRoleSubscriptionTierBenefitsViewModel.ViewState, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8546xa5534d9a(WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
        invoke2(viewState);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "benefitsViewModelState");
        WidgetGuildRoleSubscriptionTierBenefits.access$getViewModel$p(this.this$0.this$0).updateFreeTrialInterval((SubscriptionTrialInterval) _Collections.getOrNull(viewState.getTrialIntervalOptions(), 0));
    }
}
