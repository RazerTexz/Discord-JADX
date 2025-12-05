package com.discord.stores;

import com.discord.gateway.GatewaySocket;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.FunctionReferenceImpl;

/* compiled from: StoreGatewayConnection.kt */
/* renamed from: com.discord.stores.StoreGatewayConnection$buildGatewaySocket$socket$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class StoreGatewayConnection4 extends FunctionReferenceImpl implements Function0<GatewaySocket.IdentifyData> {
    public StoreGatewayConnection4(StoreGatewayConnection storeGatewayConnection) {
        super(0, storeGatewayConnection, StoreGatewayConnection.class, "getIdentifyData", "getIdentifyData()Lcom/discord/gateway/GatewaySocket$IdentifyData;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GatewaySocket.IdentifyData invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GatewaySocket.IdentifyData invoke() {
        return StoreGatewayConnection.access$getIdentifyData((StoreGatewayConnection) this.receiver);
    }
}
