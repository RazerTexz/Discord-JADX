package p600f0.p601e0.p606h;

import androidx.browser.trusted.sharing.ShareTarget;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import kotlin.text.Regex;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Address;
import p600f0.CertificatePinner;
import p600f0.EventListener;
import p600f0.Handshake;
import p600f0.HttpUrl;
import p600f0.OkHttpClient;
import p600f0.Protocol2;
import p600f0.Route;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p605g.Exchange;
import p600f0.p601e0.p605g.ExchangeFinder;
import p600f0.p601e0.p605g.RealCall;
import p600f0.p601e0.p605g.RealConnection4;
import p600f0.p601e0.p605g.RealConnectionPool;
import p600f0.p601e0.p605g.RouteSelector;

/* compiled from: RetryAndFollowUpInterceptor.kt */
/* renamed from: f0.e0.h.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {

    /* renamed from: b */
    public final OkHttpClient f25543b;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        Intrinsics3.checkParameterIsNotNull(okHttpClient, "client");
        this.f25543b = okHttpClient;
    }

    /* renamed from: a */
    public final Request m10231a(Response response, Exchange exchange) throws IOException {
        String strM10989a;
        RealConnection4 realConnection4;
        Route route = (exchange == null || (realConnection4 = exchange.f25438b) == null) ? null : realConnection4.f25506q;
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        Request request = response.request;
        String str = request.method;
        if (i != 307 && i != 308) {
            if (i == 401) {
                return this.f25543b.f26018s.mo10102a(route, response);
            }
            if (i == 421) {
                RequestBody requestBody = request.body;
                if ((requestBody != null && requestBody.isOneShot()) || exchange == null || !(!Intrinsics3.areEqual(exchange.f25441e.f25461h.f25353a.f25979g, exchange.f25438b.f25506q.f25370a.f25353a.f25979g))) {
                    return null;
                }
                RealConnection4 realConnection42 = exchange.f25438b;
                synchronized (realConnection42) {
                    realConnection42.f25499j = true;
                }
                return response.request;
            }
            if (i == 503) {
                Response response2 = response.priorResponse;
                if ((response2 == null || response2.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String != 503) && m10233c(response, Integer.MAX_VALUE) == 0) {
                    return response.request;
                }
                return null;
            }
            if (i == 407) {
                if (route == null) {
                    Intrinsics3.throwNpe();
                }
                if (route.f25371b.type() == Proxy.Type.HTTP) {
                    return this.f25543b.f26025z.mo10102a(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (i == 408) {
                if (!this.f25543b.f26017r) {
                    return null;
                }
                RequestBody requestBody2 = request.body;
                if (requestBody2 != null && requestBody2.isOneShot()) {
                    return null;
                }
                Response response3 = response.priorResponse;
                if ((response3 == null || response3.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String != 408) && m10233c(response, 0) <= 0) {
                    return response.request;
                }
                return null;
            }
            switch (i) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.f25543b.f26019t || (strM10989a = Response.m10989a(response, "Location", null, 2)) == null) {
            return null;
        }
        HttpUrl httpUrl = response.request.url;
        Objects.requireNonNull(httpUrl);
        Intrinsics3.checkParameterIsNotNull(strM10989a, "link");
        HttpUrl.a aVarM10405g = httpUrl.m10405g(strM10989a);
        HttpUrl httpUrlM10409b = aVarM10405g != null ? aVarM10405g.m10409b() : null;
        if (httpUrlM10409b == null) {
            return null;
        }
        if (!Intrinsics3.areEqual(httpUrlM10409b.f25976d, response.request.url.f25976d) && !this.f25543b.f26020u) {
            return null;
        }
        Request.C12935a c12935a = new Request.C12935a(response.request);
        if (HttpMethod.m10226a(str)) {
            int i2 = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
            Intrinsics3.checkParameterIsNotNull(str, "method");
            boolean z2 = Intrinsics3.areEqual(str, "PROPFIND") || i2 == 308 || i2 == 307;
            Intrinsics3.checkParameterIsNotNull(str, "method");
            if (!(!Intrinsics3.areEqual(str, "PROPFIND")) || i2 == 308 || i2 == 307) {
                c12935a.m10980c(str, z2 ? response.request.body : null);
            } else {
                c12935a.m10980c(ShareTarget.METHOD_GET, null);
            }
            if (!z2) {
                c12935a.m10981d("Transfer-Encoding");
                c12935a.m10981d("Content-Length");
                c12935a.m10981d("Content-Type");
            }
        }
        if (!Util7.m10120a(response.request.url, httpUrlM10409b)) {
            c12935a.m10981d("Authorization");
        }
        c12935a.m10984g(httpUrlM10409b);
        return c12935a.m10978a();
    }

    /* renamed from: b */
    public final boolean m10232b(IOException iOException, RealCall realCall, Request request, boolean z2) {
        boolean zM10209a;
        RouteSelector routeSelector;
        RealConnection4 realConnection4;
        if (!this.f25543b.f26017r) {
            return false;
        }
        if (z2) {
            RequestBody requestBody = request.body;
            if ((requestBody != null && requestBody.isOneShot()) || (iOException instanceof FileNotFoundException)) {
                return false;
            }
        }
        if (!(!(iOException instanceof ProtocolException) && (!(iOException instanceof InterruptedIOException) ? ((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException) : !((iOException instanceof SocketTimeoutException) && !z2)))) {
            return false;
        }
        ExchangeFinder exchangeFinder = realCall.f25470o;
        if (exchangeFinder == null) {
            Intrinsics3.throwNpe();
        }
        int i = exchangeFinder.f25456c;
        if (i == 0 && exchangeFinder.f25457d == 0 && exchangeFinder.f25458e == 0) {
            zM10209a = false;
        } else if (exchangeFinder.f25459f != null) {
            zM10209a = true;
        } else {
            Route route = null;
            if (i <= 1 && exchangeFinder.f25457d <= 1 && exchangeFinder.f25458e <= 0 && (realConnection4 = exchangeFinder.f25462i.f25471p) != null) {
                synchronized (realConnection4) {
                    if (realConnection4.f25500k == 0 && Util7.m10120a(realConnection4.f25506q.f25370a.f25353a, exchangeFinder.f25461h.f25353a)) {
                        route = realConnection4.f25506q;
                    }
                }
            }
            if (route != null) {
                exchangeFinder.f25459f = route;
            } else {
                RouteSelector.a aVar = exchangeFinder.f25454a;
                if ((aVar == null || !aVar.m10211a()) && (routeSelector = exchangeFinder.f25455b) != null) {
                    zM10209a = routeSelector.m10209a();
                }
            }
            zM10209a = true;
        }
        return zM10209a;
    }

    /* renamed from: c */
    public final int m10233c(Response response, int i) throws NumberFormatException {
        String strM10989a = Response.m10989a(response, "Retry-After", null, 2);
        if (strM10989a == null) {
            return i;
        }
        if (!new Regex("\\d+").matches(strM10989a)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strM10989a);
        Intrinsics3.checkExpressionValueIsNotNull(numValueOf, "Integer.valueOf(header)");
        return numValueOf.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Throwable {
        List list;
        Response response;
        int i;
        RealCall realCall;
        RealInterceptorChain realInterceptorChain;
        Response response2;
        List listPlus;
        boolean z2;
        RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
        RealCall realCall2;
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        RetryAndFollowUpInterceptor retryAndFollowUpInterceptor2 = this;
        Intrinsics3.checkParameterIsNotNull(chain, "chain");
        RealInterceptorChain realInterceptorChain2 = (RealInterceptorChain) chain;
        Request request = realInterceptorChain2.f25536f;
        RealCall realCall3 = realInterceptorChain2.f25532b;
        boolean z3 = true;
        List listEmptyList = Collections2.emptyList();
        Response response3 = null;
        int i2 = 0;
        Request request2 = request;
        boolean z4 = true;
        while (true) {
            Objects.requireNonNull(realCall3);
            Intrinsics3.checkParameterIsNotNull(request2, "request");
            if (!(realCall3.f25473r == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            synchronized (realCall3) {
                try {
                    try {
                        if (!(realCall3.f25475t ^ z3)) {
                            throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                        }
                        if (!(realCall3.f25474s ^ z3)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    retryAndFollowUpInterceptor2 = realCall3;
                }
            }
            if (z4) {
                RealConnectionPool realConnectionPool = realCall3.f25465j;
                HttpUrl httpUrl = request2.url;
                if (httpUrl.f25975c) {
                    OkHttpClient okHttpClient = realCall3.f25480y;
                    SSLSocketFactory sSLSocketFactory2 = okHttpClient.f25998B;
                    if (sSLSocketFactory2 == null) {
                        throw new IllegalStateException("CLEARTEXT-only client");
                    }
                    HostnameVerifier hostnameVerifier2 = okHttpClient.f26002F;
                    certificatePinner = okHttpClient.f26003G;
                    sSLSocketFactory = sSLSocketFactory2;
                    hostnameVerifier = hostnameVerifier2;
                } else {
                    sSLSocketFactory = null;
                    hostnameVerifier = null;
                    certificatePinner = null;
                }
                String str = httpUrl.f25979g;
                int i3 = httpUrl.f25980h;
                OkHttpClient okHttpClient2 = realCall3.f25480y;
                list = listEmptyList;
                i = i2;
                response = response3;
                Address address = new Address(str, i3, okHttpClient2.f26022w, okHttpClient2.f25997A, sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient2.f26025z, okHttpClient2.f26023x, okHttpClient2.f26001E, okHttpClient2.f26000D, okHttpClient2.f26024y);
                EventListener eventListener = realCall3.f25466k;
                realCall3.f25470o = new ExchangeFinder(realConnectionPool, address, realCall3, eventListener);
                realCall = eventListener;
            } else {
                list = listEmptyList;
                response = response3;
                i = i2;
                realCall = retryAndFollowUpInterceptor2;
            }
            try {
                if (realCall3.f25477v) {
                    throw new IOException("Canceled");
                }
                try {
                    try {
                        Response responseMo10228a = realInterceptorChain2.mo10228a(request2);
                        if (response != null) {
                            try {
                                Intrinsics3.checkParameterIsNotNull(responseMo10228a, "response");
                                Request request3 = responseMo10228a.request;
                                Protocol2 protocol2 = responseMo10228a.protocol;
                                int i4 = responseMo10228a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                                String str2 = responseMo10228a.message;
                                Handshake handshake = responseMo10228a.handshake;
                                Headers.C12930a c12930aM10956e = responseMo10228a.headers.m10956e();
                                ResponseBody responseBody = responseMo10228a.body;
                                Response response4 = responseMo10228a.networkResponse;
                                Response response5 = responseMo10228a.cacheResponse;
                                long j = responseMo10228a.sentRequestAtMillis;
                                realInterceptorChain = realInterceptorChain2;
                                realCall2 = realCall3;
                                try {
                                    long j2 = responseMo10228a.receivedResponseAtMillis;
                                    Exchange exchange = responseMo10228a.exchange;
                                    Response response6 = response;
                                    Intrinsics3.checkParameterIsNotNull(response6, "response");
                                    Request request4 = response6.request;
                                    Protocol2 protocol22 = response6.protocol;
                                    int i5 = response6.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                                    String str3 = response6.message;
                                    Handshake handshake2 = response6.handshake;
                                    Headers.C12930a c12930aM10956e2 = response6.headers.m10956e();
                                    Response response7 = response6.networkResponse;
                                    Response response8 = response6.cacheResponse;
                                    Response response9 = response6.priorResponse;
                                    long j3 = response6.sentRequestAtMillis;
                                    long j4 = response6.receivedResponseAtMillis;
                                    Exchange exchange2 = response6.exchange;
                                    if (!(i5 >= 0)) {
                                        throw new IllegalStateException(("code < 0: " + i5).toString());
                                    }
                                    if (request4 == null) {
                                        throw new IllegalStateException("request == null".toString());
                                    }
                                    if (protocol22 == null) {
                                        throw new IllegalStateException("protocol == null".toString());
                                    }
                                    if (str3 == null) {
                                        throw new IllegalStateException("message == null".toString());
                                    }
                                    Response response10 = new Response(request4, protocol22, str3, i5, handshake2, c12930aM10956e2.m10960c(), null, response7, response8, response9, j3, j4, exchange2);
                                    if (!(response10.body == null)) {
                                        throw new IllegalArgumentException("priorResponse.body != null".toString());
                                    }
                                    if (!(i4 >= 0)) {
                                        throw new IllegalStateException(("code < 0: " + i4).toString());
                                    }
                                    if (request3 == null) {
                                        throw new IllegalStateException("request == null".toString());
                                    }
                                    if (protocol2 == null) {
                                        throw new IllegalStateException("protocol == null".toString());
                                    }
                                    if (str2 == null) {
                                        throw new IllegalStateException("message == null".toString());
                                    }
                                    responseMo10228a = new Response(request3, protocol2, str2, i4, handshake, c12930aM10956e.m10960c(), responseBody, response4, response5, response10, j, j2, exchange);
                                } catch (Throwable th3) {
                                    th = th3;
                                    realCall = realCall2;
                                    realCall.m10184i(true);
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                realCall2 = realCall3;
                            }
                        } else {
                            realInterceptorChain = realInterceptorChain2;
                            realCall2 = realCall3;
                        }
                        response3 = responseMo10228a;
                        realCall = realCall2;
                    } catch (IOException e) {
                        realInterceptorChain = realInterceptorChain2;
                        RealCall realCall4 = realCall3;
                        response2 = response;
                        RetryAndFollowUpInterceptor retryAndFollowUpInterceptor3 = this;
                        if (!retryAndFollowUpInterceptor3.m10232b(e, realCall4, request2, !(e instanceof ConnectionShutdownException))) {
                            Util7.m10119D(e, list);
                            throw e;
                        }
                        listPlus = _Collections.plus((Collection<? extends IOException>) list, e);
                        z2 = true;
                        realCall = realCall4;
                        retryAndFollowUpInterceptor = retryAndFollowUpInterceptor3;
                        realCall.m10184i(z2);
                        listEmptyList = listPlus;
                        response3 = response2;
                        i2 = i;
                        z4 = false;
                        realCall3 = realCall;
                        retryAndFollowUpInterceptor2 = retryAndFollowUpInterceptor;
                        realInterceptorChain2 = realInterceptorChain;
                        z3 = true;
                    }
                } catch (RouteException e2) {
                    realInterceptorChain = realInterceptorChain2;
                    RealCall realCall5 = realCall3;
                    List list2 = list;
                    response2 = response;
                    RetryAndFollowUpInterceptor retryAndFollowUpInterceptor4 = this;
                    if (!retryAndFollowUpInterceptor4.m10232b(e2.getLastConnectException(), realCall5, request2, false)) {
                        IOException firstConnectException = e2.getFirstConnectException();
                        Util7.m10119D(firstConnectException, list2);
                        throw firstConnectException;
                    }
                    listPlus = _Collections.plus((Collection<? extends IOException>) list2, e2.getFirstConnectException());
                    z2 = true;
                    realCall = realCall5;
                    retryAndFollowUpInterceptor = retryAndFollowUpInterceptor4;
                    realCall.m10184i(z2);
                    listEmptyList = listPlus;
                    response3 = response2;
                    i2 = i;
                    z4 = false;
                    realCall3 = realCall;
                    retryAndFollowUpInterceptor2 = retryAndFollowUpInterceptor;
                    realInterceptorChain2 = realInterceptorChain;
                    z3 = true;
                }
                try {
                    Exchange exchange3 = realCall.f25473r;
                    retryAndFollowUpInterceptor = this;
                    try {
                        Request requestM10231a = retryAndFollowUpInterceptor.m10231a(response3, exchange3);
                        if (requestM10231a == null) {
                            if (exchange3 != null && exchange3.f25437a) {
                                realCall.m10189n();
                            }
                            realCall.m10184i(false);
                            return response3;
                        }
                        RequestBody requestBody = requestM10231a.body;
                        if (requestBody != null && requestBody.isOneShot()) {
                            realCall.m10184i(false);
                            return response3;
                        }
                        ResponseBody responseBody2 = response3.body;
                        if (responseBody2 != null) {
                            byte[] bArr = Util7.f25397a;
                            Intrinsics3.checkParameterIsNotNull(responseBody2, "$this$closeQuietly");
                            try {
                                responseBody2.close();
                            } catch (RuntimeException e3) {
                                throw e3;
                            } catch (Exception unused) {
                            }
                        }
                        i2 = i + 1;
                        if (i2 > 20) {
                            throw new ProtocolException("Too many follow-up requests: " + i2);
                        }
                        realCall.m10184i(true);
                        request2 = requestM10231a;
                        listEmptyList = list;
                        z4 = true;
                        realCall3 = realCall;
                        retryAndFollowUpInterceptor2 = retryAndFollowUpInterceptor;
                        realInterceptorChain2 = realInterceptorChain;
                        z3 = true;
                    } catch (Throwable th5) {
                        th = th5;
                        realCall.m10184i(true);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    realCall.m10184i(true);
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                realCall = realCall3;
            }
        }
    }
}
