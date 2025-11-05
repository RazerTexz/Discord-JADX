package com.discord.utilities.analytics;

import com.discord.utilities.system.DeviceResourceUsageMonitor;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: AnalyticsDeviceResourceUsageMonitor.kt */
/* loaded from: classes2.dex */
public final class AnalyticsDeviceResourceUsageMonitor$resourceMonitor$1 extends o implements Function1<DeviceResourceUsageMonitor.ResourceUsage, Unit> {
    public static final AnalyticsDeviceResourceUsageMonitor$resourceMonitor$1 INSTANCE = new AnalyticsDeviceResourceUsageMonitor$resourceMonitor$1();

    public AnalyticsDeviceResourceUsageMonitor$resourceMonitor$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DeviceResourceUsageMonitor.ResourceUsage resourceUsage) {
        invoke2(resourceUsage);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DeviceResourceUsageMonitor.ResourceUsage resourceUsage) {
        m.checkNotNullParameter(resourceUsage, "it");
        AnalyticSuperProperties.INSTANCE.setClientPerformanceProperties(resourceUsage.getCpuUsagePercent(), resourceUsage.getMemoryRssBytes() / 1024, resourceUsage.getCpuCoreCount());
    }
}
