package com.discord.widgets.settings.premium;

import android.view.View;
import com.discord.utilities.premium.PremiumUtils;

/* compiled from: WidgetSettingsPremium.kt */
/* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$configureButtons$$inlined$forEach$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsPremium3 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsPremium this$0;

    public WidgetSettingsPremium3(WidgetSettingsPremium widgetSettingsPremium) {
        this.this$0 = widgetSettingsPremium;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PremiumUtils.INSTANCE.openAppleBilling(this.this$0.requireContext());
    }
}
