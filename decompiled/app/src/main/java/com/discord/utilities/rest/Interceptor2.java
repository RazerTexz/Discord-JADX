package com.discord.utilities.rest;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.AnalyticSuperProperties;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.HttpUrl;
import p600f0.p601e0.Util7;

/* JADX INFO: renamed from: com.discord.utilities.rest.RestAPI$Companion$buildAnalyticsInterceptor$$inlined$invoke$1, reason: use source file name */
/* JADX INFO: compiled from: Interceptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Interceptor2 implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics3.checkParameterIsNotNull(chain, "chain");
        Request requestMo10230c = chain.mo10230c();
        Intrinsics3.checkParameterIsNotNull(requestMo10230c, "request");
        new LinkedHashMap();
        HttpUrl httpUrl = requestMo10230c.url;
        String str = requestMo10230c.method;
        RequestBody requestBody = requestMo10230c.body;
        Map linkedHashMap = requestMo10230c.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty() ? new LinkedHashMap() : Maps6.toMutableMap(requestMo10230c.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
        Headers.C12930a c12930aM10956e = requestMo10230c.headers.m10956e();
        String superPropertiesStringBase64 = AnalyticSuperProperties.INSTANCE.getSuperPropertiesStringBase64();
        Intrinsics3.checkParameterIsNotNull("X-Super-Properties", ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(superPropertiesStringBase64, "value");
        c12930aM10956e.m10958a("X-Super-Properties", superPropertiesStringBase64);
        if (httpUrl != null) {
            return chain.mo10228a(new Request(httpUrl, str, c12930aM10956e.m10960c(), requestBody, Util7.m10116A(linkedHashMap)));
        }
        throw new IllegalStateException("url == null".toString());
    }
}
