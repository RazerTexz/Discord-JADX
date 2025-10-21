package com.discord.utilities.analytics;

import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Lambda;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.functions.Function0;

/* compiled from: AnalyticsUtils.kt */
/* renamed from: com.discord.utilities.analytics.AnalyticsUtils$Tracker$Companion$instance$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class AnalyticsUtils2 extends Lambda implements Function0<AnalyticsUtils.Tracker> {
    public static final AnalyticsUtils2 INSTANCE = new AnalyticsUtils2();

    public AnalyticsUtils2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsUtils.Tracker invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsUtils.Tracker invoke() {
        return new AnalyticsUtils.Tracker(ClockFactory.get(), RestAPI.INSTANCE.getApi(), new ConcurrentLinkedQueue());
    }
}
