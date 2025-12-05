package com.discord.restapi;

import com.discord.utilities.logging.Logger;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.HttpUrl;

/* compiled from: RestInterceptors.kt */
/* renamed from: com.discord.restapi.BreadcrumbInterceptor, reason: use source file name */
/* loaded from: classes.dex */
public final class RestInterceptors implements Interceptor {
    private final Logger logger;

    public RestInterceptors(Logger logger) {
        Intrinsics3.checkNotNullParameter(logger, "logger");
        this.logger = logger;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics3.checkNotNullParameter(chain, "chain");
        Request requestMo10230c = chain.mo10230c();
        String str = requestMo10230c.method;
        HttpUrl httpUrl = requestMo10230c.url;
        this.logger.recordBreadcrumb("HTTP[" + str + "] - " + httpUrl, "http");
        return chain.mo10228a(chain.mo10230c());
    }
}
