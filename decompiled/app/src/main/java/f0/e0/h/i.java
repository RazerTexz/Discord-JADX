package f0.e0.h;

import androidx.browser.trusted.sharing.ShareTarget;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import f0.c0;
import f0.e0.g.k;
import f0.e0.g.m;
import f0.t;
import f0.v;
import f0.w;
import f0.x;
import f0.y;
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

/* compiled from: RetryAndFollowUpInterceptor.kt */
/* loaded from: classes3.dex */
public final class i implements Interceptor {

    /* renamed from: b, reason: collision with root package name */
    public final x f3629b;

    public i(x xVar) {
        m.checkParameterIsNotNull(xVar, "client");
        this.f3629b = xVar;
    }

    public final Request a(Response response, f0.e0.g.c cVar) throws IOException {
        String strA;
        f0.e0.g.j jVar;
        c0 c0Var = (cVar == null || (jVar = cVar.f3614b) == null) ? null : jVar.q;
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        Request request = response.request;
        String str = request.method;
        if (i != 307 && i != 308) {
            if (i == 401) {
                return this.f3629b.f3683s.a(c0Var, response);
            }
            if (i == 421) {
                RequestBody requestBody = request.body;
                if ((requestBody != null && requestBody.isOneShot()) || cVar == null || !(!m.areEqual(cVar.e.h.a.g, cVar.f3614b.q.a.a.g))) {
                    return null;
                }
                f0.e0.g.j jVar2 = cVar.f3614b;
                synchronized (jVar2) {
                    jVar2.j = true;
                }
                return response.request;
            }
            if (i == 503) {
                Response response2 = response.priorResponse;
                if ((response2 == null || response2.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String != 503) && c(response, Integer.MAX_VALUE) == 0) {
                    return response.request;
                }
                return null;
            }
            if (i == 407) {
                if (c0Var == null) {
                    m.throwNpe();
                }
                if (c0Var.f3603b.type() == Proxy.Type.HTTP) {
                    return this.f3629b.f3686z.a(c0Var, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (i == 408) {
                if (!this.f3629b.r) {
                    return null;
                }
                RequestBody requestBody2 = request.body;
                if (requestBody2 != null && requestBody2.isOneShot()) {
                    return null;
                }
                Response response3 = response.priorResponse;
                if ((response3 == null || response3.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String != 408) && c(response, 0) <= 0) {
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
        if (!this.f3629b.t || (strA = Response.a(response, "Location", null, 2)) == null) {
            return null;
        }
        w wVar = response.request.url;
        Objects.requireNonNull(wVar);
        m.checkParameterIsNotNull(strA, "link");
        w.a aVarG = wVar.g(strA);
        w wVarB = aVarG != null ? aVarG.b() : null;
        if (wVarB == null) {
            return null;
        }
        if (!m.areEqual(wVarB.d, response.request.url.d) && !this.f3629b.u) {
            return null;
        }
        Request.a aVar = new Request.a(response.request);
        if (f.a(str)) {
            int i2 = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
            m.checkParameterIsNotNull(str, "method");
            boolean z2 = m.areEqual(str, "PROPFIND") || i2 == 308 || i2 == 307;
            m.checkParameterIsNotNull(str, "method");
            if (!(!m.areEqual(str, "PROPFIND")) || i2 == 308 || i2 == 307) {
                aVar.c(str, z2 ? response.request.body : null);
            } else {
                aVar.c(ShareTarget.METHOD_GET, null);
            }
            if (!z2) {
                aVar.d("Transfer-Encoding");
                aVar.d("Content-Length");
                aVar.d("Content-Type");
            }
        }
        if (!f0.e0.c.a(response.request.url, wVarB)) {
            aVar.d("Authorization");
        }
        aVar.g(wVarB);
        return aVar.a();
    }

    public final boolean b(IOException iOException, f0.e0.g.e eVar, Request request, boolean z2) {
        boolean zA;
        f0.e0.g.m mVar;
        f0.e0.g.j jVar;
        if (!this.f3629b.r) {
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
        f0.e0.g.d dVar = eVar.o;
        if (dVar == null) {
            m.throwNpe();
        }
        int i = dVar.c;
        if (i == 0 && dVar.d == 0 && dVar.e == 0) {
            zA = false;
        } else if (dVar.f != null) {
            zA = true;
        } else {
            c0 c0Var = null;
            if (i <= 1 && dVar.d <= 1 && dVar.e <= 0 && (jVar = dVar.i.p) != null) {
                synchronized (jVar) {
                    if (jVar.k == 0 && f0.e0.c.a(jVar.q.a.a, dVar.h.a)) {
                        c0Var = jVar.q;
                    }
                }
            }
            if (c0Var != null) {
                dVar.f = c0Var;
            } else {
                m.a aVar = dVar.a;
                if ((aVar == null || !aVar.a()) && (mVar = dVar.f3615b) != null) {
                    zA = mVar.a();
                }
            }
            zA = true;
        }
        return zA;
    }

    public final int c(Response response, int i) throws NumberFormatException {
        String strA = Response.a(response, "Retry-After", null, 2);
        if (strA == null) {
            return i;
        }
        if (!new Regex("\\d+").matches(strA)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strA);
        d0.z.d.m.checkExpressionValueIsNotNull(numValueOf, "Integer.valueOf(header)");
        return numValueOf.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Throwable {
        List list;
        Response response;
        int i;
        f0.e0.g.e eVar;
        g gVar;
        Response response2;
        List listPlus;
        boolean z2;
        i iVar;
        f0.e0.g.e eVar2;
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        f0.g gVar2;
        i iVar2 = this;
        d0.z.d.m.checkParameterIsNotNull(chain, "chain");
        g gVar3 = (g) chain;
        Request request = gVar3.f;
        f0.e0.g.e eVar3 = gVar3.f3628b;
        boolean z3 = true;
        List listEmptyList = n.emptyList();
        Response response3 = null;
        int i2 = 0;
        Request request2 = request;
        boolean z4 = true;
        while (true) {
            Objects.requireNonNull(eVar3);
            d0.z.d.m.checkParameterIsNotNull(request2, "request");
            if (!(eVar3.r == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            synchronized (eVar3) {
                try {
                    try {
                        if (!(eVar3.t ^ z3)) {
                            throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                        }
                        if (!(eVar3.f3616s ^ z3)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    iVar2 = eVar3;
                }
            }
            if (z4) {
                k kVar = eVar3.j;
                w wVar = request2.url;
                if (wVar.c) {
                    x xVar = eVar3.f3618y;
                    SSLSocketFactory sSLSocketFactory2 = xVar.B;
                    if (sSLSocketFactory2 == null) {
                        throw new IllegalStateException("CLEARTEXT-only client");
                    }
                    HostnameVerifier hostnameVerifier2 = xVar.F;
                    gVar2 = xVar.G;
                    sSLSocketFactory = sSLSocketFactory2;
                    hostnameVerifier = hostnameVerifier2;
                } else {
                    sSLSocketFactory = null;
                    hostnameVerifier = null;
                    gVar2 = null;
                }
                String str = wVar.g;
                int i3 = wVar.h;
                x xVar2 = eVar3.f3618y;
                list = listEmptyList;
                i = i2;
                response = response3;
                f0.a aVar = new f0.a(str, i3, xVar2.w, xVar2.A, sSLSocketFactory, hostnameVerifier, gVar2, xVar2.f3686z, xVar2.f3684x, xVar2.E, xVar2.D, xVar2.f3685y);
                t tVar = eVar3.k;
                eVar3.o = new f0.e0.g.d(kVar, aVar, eVar3, tVar);
                eVar = tVar;
            } else {
                list = listEmptyList;
                response = response3;
                i = i2;
                eVar = iVar2;
            }
            try {
                if (eVar3.v) {
                    throw new IOException("Canceled");
                }
                try {
                    try {
                        Response responseA = gVar3.a(request2);
                        if (response != null) {
                            try {
                                d0.z.d.m.checkParameterIsNotNull(responseA, "response");
                                Request request3 = responseA.request;
                                y yVar = responseA.protocol;
                                int i4 = responseA.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                                String str2 = responseA.message;
                                v vVar = responseA.handshake;
                                Headers.a aVarE = responseA.headers.e();
                                ResponseBody responseBody = responseA.body;
                                Response response4 = responseA.networkResponse;
                                Response response5 = responseA.cacheResponse;
                                long j = responseA.sentRequestAtMillis;
                                gVar = gVar3;
                                eVar2 = eVar3;
                                try {
                                    long j2 = responseA.receivedResponseAtMillis;
                                    f0.e0.g.c cVar = responseA.exchange;
                                    Response response6 = response;
                                    d0.z.d.m.checkParameterIsNotNull(response6, "response");
                                    Request request4 = response6.request;
                                    y yVar2 = response6.protocol;
                                    int i5 = response6.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                                    String str3 = response6.message;
                                    v vVar2 = response6.handshake;
                                    Headers.a aVarE2 = response6.headers.e();
                                    Response response7 = response6.networkResponse;
                                    Response response8 = response6.cacheResponse;
                                    Response response9 = response6.priorResponse;
                                    long j3 = response6.sentRequestAtMillis;
                                    long j4 = response6.receivedResponseAtMillis;
                                    f0.e0.g.c cVar2 = response6.exchange;
                                    if (!(i5 >= 0)) {
                                        throw new IllegalStateException(("code < 0: " + i5).toString());
                                    }
                                    if (request4 == null) {
                                        throw new IllegalStateException("request == null".toString());
                                    }
                                    if (yVar2 == null) {
                                        throw new IllegalStateException("protocol == null".toString());
                                    }
                                    if (str3 == null) {
                                        throw new IllegalStateException("message == null".toString());
                                    }
                                    Response response10 = new Response(request4, yVar2, str3, i5, vVar2, aVarE2.c(), null, response7, response8, response9, j3, j4, cVar2);
                                    if (!(response10.body == null)) {
                                        throw new IllegalArgumentException("priorResponse.body != null".toString());
                                    }
                                    if (!(i4 >= 0)) {
                                        throw new IllegalStateException(("code < 0: " + i4).toString());
                                    }
                                    if (request3 == null) {
                                        throw new IllegalStateException("request == null".toString());
                                    }
                                    if (yVar == null) {
                                        throw new IllegalStateException("protocol == null".toString());
                                    }
                                    if (str2 == null) {
                                        throw new IllegalStateException("message == null".toString());
                                    }
                                    responseA = new Response(request3, yVar, str2, i4, vVar, aVarE.c(), responseBody, response4, response5, response10, j, j2, cVar);
                                } catch (Throwable th3) {
                                    th = th3;
                                    eVar = eVar2;
                                    eVar.i(true);
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                eVar2 = eVar3;
                            }
                        } else {
                            gVar = gVar3;
                            eVar2 = eVar3;
                        }
                        response3 = responseA;
                        eVar = eVar2;
                    } catch (IOException e) {
                        gVar = gVar3;
                        f0.e0.g.e eVar4 = eVar3;
                        response2 = response;
                        i iVar3 = this;
                        if (!iVar3.b(e, eVar4, request2, !(e instanceof ConnectionShutdownException))) {
                            f0.e0.c.D(e, list);
                            throw e;
                        }
                        listPlus = u.plus((Collection<? extends IOException>) list, e);
                        z2 = true;
                        eVar = eVar4;
                        iVar = iVar3;
                        eVar.i(z2);
                        listEmptyList = listPlus;
                        response3 = response2;
                        i2 = i;
                        z4 = false;
                        eVar3 = eVar;
                        iVar2 = iVar;
                        gVar3 = gVar;
                        z3 = true;
                    }
                } catch (RouteException e2) {
                    gVar = gVar3;
                    f0.e0.g.e eVar5 = eVar3;
                    List list2 = list;
                    response2 = response;
                    i iVar4 = this;
                    if (!iVar4.b(e2.getLastConnectException(), eVar5, request2, false)) {
                        IOException firstConnectException = e2.getFirstConnectException();
                        f0.e0.c.D(firstConnectException, list2);
                        throw firstConnectException;
                    }
                    listPlus = u.plus((Collection<? extends IOException>) list2, e2.getFirstConnectException());
                    z2 = true;
                    eVar = eVar5;
                    iVar = iVar4;
                    eVar.i(z2);
                    listEmptyList = listPlus;
                    response3 = response2;
                    i2 = i;
                    z4 = false;
                    eVar3 = eVar;
                    iVar2 = iVar;
                    gVar3 = gVar;
                    z3 = true;
                }
                try {
                    f0.e0.g.c cVar3 = eVar.r;
                    iVar = this;
                    try {
                        Request requestA = iVar.a(response3, cVar3);
                        if (requestA == null) {
                            if (cVar3 != null && cVar3.a) {
                                eVar.n();
                            }
                            eVar.i(false);
                            return response3;
                        }
                        RequestBody requestBody = requestA.body;
                        if (requestBody != null && requestBody.isOneShot()) {
                            eVar.i(false);
                            return response3;
                        }
                        ResponseBody responseBody2 = response3.body;
                        if (responseBody2 != null) {
                            byte[] bArr = f0.e0.c.a;
                            d0.z.d.m.checkParameterIsNotNull(responseBody2, "$this$closeQuietly");
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
                        eVar.i(true);
                        request2 = requestA;
                        listEmptyList = list;
                        z4 = true;
                        eVar3 = eVar;
                        iVar2 = iVar;
                        gVar3 = gVar;
                        z3 = true;
                    } catch (Throwable th5) {
                        th = th5;
                        eVar.i(true);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    eVar.i(true);
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                eVar = eVar3;
            }
        }
    }
}
