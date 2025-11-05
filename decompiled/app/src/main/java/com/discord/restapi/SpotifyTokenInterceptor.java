package com.discord.restapi;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RequiredHeadersInterceptor;
import d0.t.h0;
import d0.z.d.m;
import f0.e0.c;
import f0.w;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* compiled from: RestInterceptors.kt */
/* loaded from: classes.dex */
public final class SpotifyTokenInterceptor implements Interceptor {
    private final RequiredHeadersInterceptor.HeadersProvider headersProvider;

    public SpotifyTokenInterceptor(RequiredHeadersInterceptor.HeadersProvider headersProvider) {
        m.checkNotNullParameter(headersProvider, "headersProvider");
        this.headersProvider = headersProvider;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        m.checkNotNullParameter(chain, "chain");
        Request requestC = chain.c();
        m.checkParameterIsNotNull(requestC, "request");
        new LinkedHashMap();
        w wVar = requestC.url;
        String str = requestC.method;
        RequestBody requestBody = requestC.body;
        Map linkedHashMap = requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty() ? new LinkedHashMap() : h0.toMutableMap(requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
        Headers.a aVarE = requestC.headers.e();
        StringBuilder sbU = a.U("Bearer ");
        sbU.append(this.headersProvider.getSpotifyToken());
        String string = sbU.toString();
        m.checkParameterIsNotNull("Authorization", ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkParameterIsNotNull(string, "value");
        aVarE.a("Authorization", string);
        if (wVar != null) {
            return chain.a(new Request(wVar, str, aVarE.c(), requestBody, c.A(linkedHashMap)));
        }
        throw new IllegalStateException("url == null".toString());
    }
}
