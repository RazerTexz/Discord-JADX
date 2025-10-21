package com.discord.utilities.analytics;

import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: AppStartAnalyticsTracker.kt */
/* renamed from: com.discord.utilities.analytics.AppStartAnalyticsTracker$Companion$instance$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class AppStartAnalyticsTracker2 extends Lambda implements Function0<AppStartAnalyticsTracker> {
    public static final AppStartAnalyticsTracker2 INSTANCE = new AppStartAnalyticsTracker2();

    public AppStartAnalyticsTracker2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AppStartAnalyticsTracker invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AppStartAnalyticsTracker invoke() {
        return new AppStartAnalyticsTracker(AnalyticsUtils.Tracker.INSTANCE.getInstance(), ClockFactory.get(), StoreStream.INSTANCE.getUserSettingsSystem());
    }
}
