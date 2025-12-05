package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.view.View;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel;

/* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureAcceptTermsState$$inlined$apply$lambda$2 */
/* loaded from: classes2.dex */
public final class ViewOnClickListenerC9426xd1ebfe5e implements View.OnClickListener {
    public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms $viewState$inlined;
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    public ViewOnClickListenerC9426xd1ebfe5e(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding, ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms acceptTerms) {
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
        this.$viewState$inlined = acceptTerms;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsCreatorMonetizationOnboarding.access$getViewModel$p(this.this$0).submitTermsAcceptance();
    }
}
