package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.widget.CompoundButton;
import android.widget.ScrollView;
import com.discord.utilities.view.extensions.ScrollViewExtensions;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureAcceptTermsState$$inlined$apply$lambda$1 */
/* loaded from: classes2.dex */
public final class C9425xd1ebfe5d implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms $viewState$inlined;
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    public C9425xd1ebfe5d(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding, ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms acceptTerms) {
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
        this.$viewState$inlined = acceptTerms;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        WidgetServerSettingsCreatorMonetizationOnboarding.access$getViewModel$p(this.this$0).setHasAcceptedTerms(z2);
        if (z2) {
            ScrollView scrollView = WidgetServerSettingsCreatorMonetizationOnboarding.access$getAcceptTermsBinding$p(this.this$0).f17595d;
            Intrinsics3.checkNotNullExpressionValue(scrollView, "acceptTermsBinding.acceptTermsScrollView");
            ScrollViewExtensions.flashScrollBars(scrollView);
        }
    }
}
