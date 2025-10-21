package com.discord.utilities.analytics;

import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.OnAttributionChangedListener;

/* compiled from: AdjustConfig.kt */
/* renamed from: com.discord.utilities.analytics.AdjustConfig$init$1$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class AdjustConfig2 implements OnAttributionChangedListener {
    public static final AdjustConfig2 INSTANCE = new AdjustConfig2();

    @Override // com.adjust.sdk.OnAttributionChangedListener
    public final void onAttributionChanged(AdjustAttribution adjustAttribution) {
        if (adjustAttribution != null) {
            AnalyticsTracker.INSTANCE.attributionChange(adjustAttribution);
        }
    }
}
