package com.discord.utilities.rest;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import f0.f0.HttpLoggingInterceptor;

/* compiled from: RestAPI.kt */
/* renamed from: com.discord.utilities.rest.RestAPI$Companion$buildLoggingInterceptor$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class RestAPI7 implements HttpLoggingInterceptor.b {
    @Override // f0.f0.HttpLoggingInterceptor.b
    public void log(String message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Logger.v$default(AppLog.g, message, null, 2, null);
    }
}
