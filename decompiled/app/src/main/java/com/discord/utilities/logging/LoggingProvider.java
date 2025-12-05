package com.discord.utilities.logging;

import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: LoggingProvider.kt */
/* loaded from: classes2.dex */
public final class LoggingProvider {
    public static final LoggingProvider INSTANCE = new LoggingProvider();
    private static Logger logger;

    private LoggingProvider() {
    }

    public final Logger get() {
        Logger logger2 = logger;
        if (logger2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("logger");
        }
        return logger2;
    }

    public final void init(Logger logger2) {
        Intrinsics3.checkNotNullParameter(logger2, "logger");
        logger = logger2;
    }
}
