package com.discord.gateway;


/* compiled from: GatewayEventHandler.kt */
/* loaded from: classes.dex */
public interface GatewayEventHandler {
    void handleConnected(boolean connected);

    void handleConnectionReady(boolean connectionReady);

    void handleDisconnect(boolean authenticationFailed);

    void handleDispatch(String type, Object data);
}
