package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestInterceptors2;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.HttpUrl;
import p600f0.p601e0.Util7;

/* JADX INFO: renamed from: com.discord.restapi.SpotifyTokenInterceptor, reason: use source file name */
/* JADX INFO: compiled from: RestInterceptors.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestInterceptors3 implements Interceptor {
    private final RestInterceptors2.HeadersProvider headersProvider;

    public RestInterceptors3(RestInterceptors2.HeadersProvider headersProvider) {
        Intrinsics3.checkNotNullParameter(headersProvider, "headersProvider");
        this.headersProvider = headersProvider;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics3.checkNotNullParameter(chain, "chain");
        Request requestMo10230c = chain.mo10230c();
        Intrinsics3.checkParameterIsNotNull(requestMo10230c, "request");
        new LinkedHashMap();
        HttpUrl httpUrl = requestMo10230c.url;
        String str = requestMo10230c.method;
        RequestBody requestBody = requestMo10230c.body;
        Map linkedHashMap = requestMo10230c.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty() ? new LinkedHashMap() : Maps6.toMutableMap(requestMo10230c.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
        Headers.C12930a c12930aM10956e = requestMo10230c.headers.m10956e();
        StringBuilder sbM833U = outline.m833U("Bearer ");
        sbM833U.append(this.headersProvider.getSpotifyToken());
        String string = sbM833U.toString();
        Intrinsics3.checkParameterIsNotNull("Authorization", ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(string, "value");
        c12930aM10956e.m10958a("Authorization", string);
        if (httpUrl != null) {
            return chain.mo10228a(new Request(httpUrl, str, c12930aM10956e.m10960c(), requestBody, Util7.m10116A(linkedHashMap)));
        }
        throw new IllegalStateException("url == null".toString());
    }
}
