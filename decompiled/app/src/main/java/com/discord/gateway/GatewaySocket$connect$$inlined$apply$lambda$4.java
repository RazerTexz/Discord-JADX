package com.discord.gateway;

import com.discord.utilities.websocket.RawMessageHandler;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$connect$$inlined$apply$lambda$4 implements RawMessageHandler {
    public final /* synthetic */ String $gatewayUrl$inlined;
    public final /* synthetic */ GatewaySocket this$0;

    public GatewaySocket$connect$$inlined$apply$lambda$4(GatewaySocket gatewaySocket, String str) {
        this.this$0 = gatewaySocket;
        this.$gatewayUrl$inlined = str;
    }

    @Override // com.discord.utilities.websocket.RawMessageHandler
    public void onRawMessage(String rawMessage) {
        Intrinsics3.checkNotNullParameter(rawMessage, "rawMessage");
        GatewaySocket.access$getGatewaySocketLogger$p(this.this$0).logInboundMessage(rawMessage);
    }

    @Override // com.discord.utilities.websocket.RawMessageHandler
    public void onRawMessageInflateFailed(Throwable throwable) {
        Intrinsics3.checkNotNullParameter(throwable, "throwable");
        GatewaySocket.access$getGatewaySocketLogger$p(this.this$0).logMessageInflateFailed(throwable);
    }
}
