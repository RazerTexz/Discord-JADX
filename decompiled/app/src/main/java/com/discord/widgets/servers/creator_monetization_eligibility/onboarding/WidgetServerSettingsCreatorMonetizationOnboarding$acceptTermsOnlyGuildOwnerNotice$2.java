package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.view.ViewStub;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding$acceptTermsOnlyGuildOwnerNotice$2 extends Lambda implements Function0<ViewStub> {
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCreatorMonetizationOnboarding$acceptTermsOnlyGuildOwnerNotice$2(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        super(0);
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewStub invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewStub invoke() {
        ViewStub viewStub = WidgetServerSettingsCreatorMonetizationOnboarding.access$getAcceptTermsBinding$p(this.this$0).e;
        Intrinsics3.checkNotNullExpressionValue(viewStub, "acceptTermsBinding.onlyGuildOwnerNotice");
        return viewStub;
    }
}
