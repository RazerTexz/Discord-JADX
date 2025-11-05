package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
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
public final class RequiredHeadersInterceptor implements Interceptor {
    private final HeadersProvider headersProvider;

    /* compiled from: RestInterceptors.kt */
    public interface HeadersProvider {
        String getAcceptLanguages();

        String getAuthToken();

        String getFingerprint();

        String getLocale();

        String getSpotifyToken();

        String getUserAgent();
    }

    public RequiredHeadersInterceptor(HeadersProvider headersProvider) {
        m.checkNotNullParameter(headersProvider, "headersProvider");
        this.headersProvider = headersProvider;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        m.checkNotNullParameter(chain, "chain");
        String authToken = this.headersProvider.getAuthToken();
        String fingerprint = this.headersProvider.getFingerprint();
        String locale = this.headersProvider.getLocale();
        String userAgent = this.headersProvider.getUserAgent();
        String acceptLanguages = this.headersProvider.getAcceptLanguages();
        Request requestC = chain.c();
        m.checkParameterIsNotNull(requestC, "request");
        new LinkedHashMap();
        w wVar = requestC.url;
        String str = requestC.method;
        RequestBody requestBody = requestC.body;
        Map linkedHashMap = requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty() ? new LinkedHashMap() : h0.toMutableMap(requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
        Headers.a aVarE = requestC.headers.e();
        m.checkParameterIsNotNull("User-Agent", ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkParameterIsNotNull(userAgent, "value");
        aVarE.a("User-Agent", userAgent);
        if (authToken != null) {
            m.checkParameterIsNotNull("Authorization", ModelAuditLogEntry.CHANGE_KEY_NAME);
            m.checkParameterIsNotNull(authToken, "value");
            aVarE.a("Authorization", authToken);
        }
        if (fingerprint != null) {
            m.checkParameterIsNotNull("X-Fingerprint", ModelAuditLogEntry.CHANGE_KEY_NAME);
            m.checkParameterIsNotNull(fingerprint, "value");
            aVarE.a("X-Fingerprint", fingerprint);
        }
        if (locale != null) {
            m.checkParameterIsNotNull("X-Discord-Locale", ModelAuditLogEntry.CHANGE_KEY_NAME);
            m.checkParameterIsNotNull(locale, "value");
            aVarE.a("X-Discord-Locale", locale);
        }
        if (acceptLanguages != null) {
            m.checkParameterIsNotNull("Accept-Language", ModelAuditLogEntry.CHANGE_KEY_NAME);
            m.checkParameterIsNotNull(acceptLanguages, "value");
            aVarE.a("Accept-Language", acceptLanguages);
        }
        if (wVar != null) {
            return chain.a(new Request(wVar, str, aVarE.c(), requestBody, c.A(linkedHashMap)));
        }
        throw new IllegalStateException("url == null".toString());
    }
}
