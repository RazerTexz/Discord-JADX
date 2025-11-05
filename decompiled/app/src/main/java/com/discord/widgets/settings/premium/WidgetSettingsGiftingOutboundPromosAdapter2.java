package com.discord.widgets.settings.premium;

import com.discord.widgets.settings.premium.SettingsGiftingViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsGiftingOutboundPromosAdapter.kt */
/* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGiftingOutboundPromosAdapter$Companion$DIFF_CALLBACK$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsGiftingOutboundPromosAdapter2 extends Lambda implements Function1<SettingsGiftingViewModel.OutboundPromoItem, Object> {
    public static final WidgetSettingsGiftingOutboundPromosAdapter2 INSTANCE = new WidgetSettingsGiftingOutboundPromosAdapter2();

    public WidgetSettingsGiftingOutboundPromosAdapter2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
        return invoke2(outboundPromoItem);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
        Intrinsics3.checkNotNullParameter(outboundPromoItem, "it");
        return Long.valueOf(outboundPromoItem.getId());
    }
}
