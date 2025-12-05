package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.view.ViewStub;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$acceptTermsOnlyGuildOwnerNotice$2 */
/* loaded from: classes2.dex */
public final class C9423x1fb02593 extends Lambda implements Function0<ViewStub> {
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9423x1fb02593(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
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
        ViewStub viewStub = WidgetServerSettingsCreatorMonetizationOnboarding.access$getAcceptTermsBinding$p(this.this$0).f17596e;
        Intrinsics3.checkNotNullExpressionValue(viewStub, "acceptTermsBinding.onlyGuildOwnerNotice");
        return viewStub;
    }
}
