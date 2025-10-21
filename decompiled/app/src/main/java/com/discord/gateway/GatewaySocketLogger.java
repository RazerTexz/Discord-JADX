package com.discord.gateway;


/* compiled from: GatewaySocketLogger.kt */
/* loaded from: classes.dex */
public interface GatewaySocketLogger {

    /* compiled from: GatewaySocketLogger.kt */
    public enum LogLevel {
        NONE,
        VERBOSE
    }

    LogLevel getLogLevel();

    void logInboundMessage(String rawMessage);

    void logMessageInflateFailed(Throwable throwable);

    void logOutboundMessage(String rawMessage);
}
