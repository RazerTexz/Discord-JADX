package com.discord.utilities.logging;

import com.discord.gateway.GatewaySocketLogger;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AppGatewaySocketLogger.kt */
/* loaded from: classes2.dex */
public final class AppGatewaySocketLogger implements GatewaySocketLogger {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AppGatewaySocketLogger INSTANCE = new AppGatewaySocketLogger();
    private final GatewaySocketLogger.LogLevel logLevel = GatewaySocketLogger.LogLevel.NONE;

    /* compiled from: AppGatewaySocketLogger.kt */
    public static final class Companion {
        private Companion() {
        }

        public final AppGatewaySocketLogger getINSTANCE() {
            return AppGatewaySocketLogger.access$getINSTANCE$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ AppGatewaySocketLogger access$getINSTANCE$cp() {
        return INSTANCE;
    }

    @Override // com.discord.gateway.GatewaySocketLogger
    public GatewaySocketLogger.LogLevel getLogLevel() {
        return this.logLevel;
    }

    @Override // com.discord.gateway.GatewaySocketLogger
    public void logInboundMessage(String rawMessage) {
        m.checkNotNullParameter(rawMessage, "rawMessage");
    }

    @Override // com.discord.gateway.GatewaySocketLogger
    public void logMessageInflateFailed(Throwable throwable) {
        m.checkNotNullParameter(throwable, "throwable");
    }

    @Override // com.discord.gateway.GatewaySocketLogger
    public void logOutboundMessage(String rawMessage) {
        m.checkNotNullParameter(rawMessage, "rawMessage");
    }
}
