package com.discord.gateway;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: GatewaySocket.kt */
/* loaded from: classes.dex */
public final class GatewaySocket$discoveryFailed$delay$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$discoveryFailed$delay$1(GatewaySocket gatewaySocket) {
        super(0);
        this.this$0 = gatewaySocket;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        GatewaySocket.access$discover(this.this$0);
    }
}
