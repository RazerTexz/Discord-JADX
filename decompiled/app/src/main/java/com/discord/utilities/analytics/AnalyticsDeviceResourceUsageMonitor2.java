package com.discord.utilities.analytics;

import com.discord.utilities.system.DeviceResourceUsageMonitor;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: AnalyticsDeviceResourceUsageMonitor.kt */
/* renamed from: com.discord.utilities.analytics.AnalyticsDeviceResourceUsageMonitor$resourceMonitor$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class AnalyticsDeviceResourceUsageMonitor2 extends Lambda implements Function1<DeviceResourceUsageMonitor.ResourceUsage, Unit> {
    public static final AnalyticsDeviceResourceUsageMonitor2 INSTANCE = new AnalyticsDeviceResourceUsageMonitor2();

    public AnalyticsDeviceResourceUsageMonitor2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DeviceResourceUsageMonitor.ResourceUsage resourceUsage) {
        invoke2(resourceUsage);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DeviceResourceUsageMonitor.ResourceUsage resourceUsage) {
        Intrinsics3.checkNotNullParameter(resourceUsage, "it");
        AnalyticSuperProperties.INSTANCE.setClientPerformanceProperties(resourceUsage.getCpuUsagePercent(), resourceUsage.getMemoryRssBytes() / 1024, resourceUsage.getCpuCoreCount());
    }
}
