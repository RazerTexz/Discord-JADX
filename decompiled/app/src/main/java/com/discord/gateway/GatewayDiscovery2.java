package com.discord.gateway;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: com.discord.gateway.GatewayDiscovery$sam$rx_functions_Action1$0, reason: use source file name */
/* JADX INFO: compiled from: GatewayDiscovery.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewayDiscovery2 implements Action1 {
    private final /* synthetic */ Function1 function;

    public GatewayDiscovery2(Function1 function1) {
        this.function = function1;
    }

    @Override // p658rx.functions.Action1
    public final /* synthetic */ void call(Object obj) {
        Intrinsics3.checkNotNullExpressionValue(this.function.invoke(obj), "invoke(...)");
    }
}
