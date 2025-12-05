package com.discord.utilities.rest;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p614f0.HttpLoggingInterceptor;

/* compiled from: RestAPI.kt */
/* renamed from: com.discord.utilities.rest.RestAPI$Companion$buildLoggingInterceptor$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class RestAPI7 implements HttpLoggingInterceptor.b {
    @Override // p600f0.p614f0.HttpLoggingInterceptor.b
    public void log(String message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Logger.v$default(AppLog.f14950g, message, null, 2, null);
    }
}
