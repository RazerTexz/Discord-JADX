package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
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

/* JADX INFO: renamed from: com.discord.restapi.RequiredHeadersInterceptor, reason: use source file name */
/* JADX INFO: compiled from: RestInterceptors.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestInterceptors2 implements Interceptor {
    private final HeadersProvider headersProvider;

    /* JADX INFO: renamed from: com.discord.restapi.RequiredHeadersInterceptor$HeadersProvider */
    /* JADX INFO: compiled from: RestInterceptors.kt */
    public interface HeadersProvider {
        String getAcceptLanguages();

        String getAuthToken();

        String getFingerprint();

        String getLocale();

        String getSpotifyToken();

        String getUserAgent();
    }

    public RestInterceptors2(HeadersProvider headersProvider) {
        Intrinsics3.checkNotNullParameter(headersProvider, "headersProvider");
        this.headersProvider = headersProvider;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics3.checkNotNullParameter(chain, "chain");
        String authToken = this.headersProvider.getAuthToken();
        String fingerprint = this.headersProvider.getFingerprint();
        String locale = this.headersProvider.getLocale();
        String userAgent = this.headersProvider.getUserAgent();
        String acceptLanguages = this.headersProvider.getAcceptLanguages();
        Request requestMo10230c = chain.mo10230c();
        Intrinsics3.checkParameterIsNotNull(requestMo10230c, "request");
        new LinkedHashMap();
        HttpUrl httpUrl = requestMo10230c.url;
        String str = requestMo10230c.method;
        RequestBody requestBody = requestMo10230c.body;
        Map linkedHashMap = requestMo10230c.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty() ? new LinkedHashMap() : Maps6.toMutableMap(requestMo10230c.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
        Headers.C12930a c12930aM10956e = requestMo10230c.headers.m10956e();
        Intrinsics3.checkParameterIsNotNull("User-Agent", ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(userAgent, "value");
        c12930aM10956e.m10958a("User-Agent", userAgent);
        if (authToken != null) {
            Intrinsics3.checkParameterIsNotNull("Authorization", ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(authToken, "value");
            c12930aM10956e.m10958a("Authorization", authToken);
        }
        if (fingerprint != null) {
            Intrinsics3.checkParameterIsNotNull("X-Fingerprint", ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(fingerprint, "value");
            c12930aM10956e.m10958a("X-Fingerprint", fingerprint);
        }
        if (locale != null) {
            Intrinsics3.checkParameterIsNotNull("X-Discord-Locale", ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(locale, "value");
            c12930aM10956e.m10958a("X-Discord-Locale", locale);
        }
        if (acceptLanguages != null) {
            Intrinsics3.checkParameterIsNotNull("Accept-Language", ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(acceptLanguages, "value");
            c12930aM10956e.m10958a("Accept-Language", acceptLanguages);
        }
        if (httpUrl != null) {
            return chain.mo10228a(new Request(httpUrl, str, c12930aM10956e.m10960c(), requestBody, Util7.m10116A(linkedHashMap)));
        }
        throw new IllegalStateException("url == null".toString());
    }
}
