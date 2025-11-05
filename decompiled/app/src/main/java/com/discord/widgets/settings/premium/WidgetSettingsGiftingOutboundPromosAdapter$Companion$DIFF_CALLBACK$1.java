package com.discord.widgets.settings.premium;

import com.discord.widgets.settings.premium.SettingsGiftingViewModel;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsGiftingOutboundPromosAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsGiftingOutboundPromosAdapter$Companion$DIFF_CALLBACK$1 extends o implements Function1<SettingsGiftingViewModel.OutboundPromoItem, Object> {
    public static final WidgetSettingsGiftingOutboundPromosAdapter$Companion$DIFF_CALLBACK$1 INSTANCE = new WidgetSettingsGiftingOutboundPromosAdapter$Companion$DIFF_CALLBACK$1();

    public WidgetSettingsGiftingOutboundPromosAdapter$Companion$DIFF_CALLBACK$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
        return invoke2(outboundPromoItem);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
        m.checkNotNullParameter(outboundPromoItem, "it");
        return Long.valueOf(outboundPromoItem.getId());
    }
}
