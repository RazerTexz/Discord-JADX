package com.discord.utilities.system;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: DeviceResourceUsageMonitor.kt */
/* renamed from: com.discord.utilities.system.DeviceResourceUsageMonitor$start$$inlined$synchronized$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class DeviceResourceUsageMonitor2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ DeviceResourceUsageMonitor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceResourceUsageMonitor2(DeviceResourceUsageMonitor deviceResourceUsageMonitor) {
        super(0);
        this.this$0 = deviceResourceUsageMonitor;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        try {
            DeviceResourceUsageMonitor.access$monitor(this.this$0);
        } catch (InterruptedException unused) {
        }
    }
}
