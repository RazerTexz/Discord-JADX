package com.discord.widgets.settings.premium;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetClaimOutboundPromo.kt */
/* renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetClaimOutboundPromo4 extends Lambda implements Function0<ClaimOutboundPromoViewModel> {
    public final /* synthetic */ WidgetClaimOutboundPromo this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetClaimOutboundPromo4(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
        super(0);
        this.this$0 = widgetClaimOutboundPromo;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ClaimOutboundPromoViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ClaimOutboundPromoViewModel invoke() {
        return new ClaimOutboundPromoViewModel(WidgetClaimOutboundPromo.access$getClaimStatus$p(this.this$0), null, 2, null);
    }
}
