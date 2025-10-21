package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.i18n.RenderContext;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$2$1 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ CharSequence $rejectionCooldown;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$2$1(CharSequence charSequence) {
        super(1);
        this.$rejectionCooldown = charSequence;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.args.put("requestCooldownDuration", this.$rejectionCooldown.toString());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }
}
