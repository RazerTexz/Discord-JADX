package p600f0.p601e0.p606h;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.EventListener;
import p600f0.Handshake;
import p600f0.Protocol2;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p605g.Exchange;
import p600f0.p601e0.p605g.RealCall;
import p615g0.RealBufferedSink;
import p615g0.RealBufferedSource;
import p615g0.Sink;

/* compiled from: CallServerInterceptor.kt */
/* renamed from: f0.e0.h.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class CallServerInterceptor implements Interceptor {

    /* renamed from: b */
    public final boolean f25525b;

    public CallServerInterceptor(boolean z2) {
        this.f25525b = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0289  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) throws Throwable {
        boolean z2;
        int i;
        Response response;
        Long lValueOf;
        int i2;
        ResponseBody responseBody;
        Response.C12937a c12937aM10171e;
        Intrinsics3.checkParameterIsNotNull(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchange = realInterceptorChain.f25535e;
        if (exchange == null) {
            Intrinsics3.throwNpe();
        }
        Request request = realInterceptorChain.f25536f;
        RequestBody requestBody = request.body;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Objects.requireNonNull(exchange);
        Intrinsics3.checkParameterIsNotNull(request, "request");
        try {
            EventListener eventListener = exchange.f25440d;
            RealCall realCall = exchange.f25439c;
            Objects.requireNonNull(eventListener);
            Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
            exchange.f25442f.mo10214b(request);
            EventListener eventListener2 = exchange.f25440d;
            RealCall realCall2 = exchange.f25439c;
            Objects.requireNonNull(eventListener2);
            Intrinsics3.checkParameterIsNotNull(realCall2, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(request, "request");
            Response.C12937a c12937aM10171e2 = null;
            if (!HttpMethod.m10226a(request.method) || requestBody == null) {
                exchange.f25439c.m10186k(exchange, true, false, null);
                z2 = true;
            } else {
                if (StringsJVM.equals("100-continue", request.m10977b("Expect"), true)) {
                    exchange.m10169c();
                    c12937aM10171e = exchange.m10171e(true);
                    exchange.m10172f();
                    z2 = false;
                } else {
                    z2 = true;
                    c12937aM10171e = null;
                }
                if (c12937aM10171e != null) {
                    exchange.f25439c.m10186k(exchange, true, false, null);
                    if (!exchange.f25438b.m10201j()) {
                        exchange.f25442f.mo10217e().m10203l();
                    }
                } else if (requestBody.isDuplex()) {
                    exchange.m10169c();
                    Sink sinkM10168b = exchange.m10168b(request, true);
                    Intrinsics3.checkParameterIsNotNull(sinkM10168b, "$this$buffer");
                    requestBody.writeTo(new RealBufferedSink(sinkM10168b));
                } else {
                    Sink sinkM10168b2 = exchange.m10168b(request, false);
                    Intrinsics3.checkParameterIsNotNull(sinkM10168b2, "$this$buffer");
                    RealBufferedSink realBufferedSink = new RealBufferedSink(sinkM10168b2);
                    requestBody.writeTo(realBufferedSink);
                    realBufferedSink.close();
                }
                c12937aM10171e2 = c12937aM10171e;
            }
            if (requestBody == null || !requestBody.isDuplex()) {
                try {
                    exchange.f25442f.mo10213a();
                } catch (IOException e) {
                    EventListener eventListener3 = exchange.f25440d;
                    RealCall realCall3 = exchange.f25439c;
                    Objects.requireNonNull(eventListener3);
                    Intrinsics3.checkParameterIsNotNull(realCall3, NotificationCompat.CATEGORY_CALL);
                    Intrinsics3.checkParameterIsNotNull(e, "ioe");
                    exchange.m10173g(e);
                    throw e;
                }
            }
            if (c12937aM10171e2 == null) {
                c12937aM10171e2 = exchange.m10171e(false);
                if (c12937aM10171e2 == null) {
                    Intrinsics3.throwNpe();
                }
                if (z2) {
                    exchange.m10172f();
                    z2 = false;
                }
            }
            c12937aM10171e2.m10997g(request);
            c12937aM10171e2.f27569e = exchange.f25438b.f25493d;
            c12937aM10171e2.f27575k = jCurrentTimeMillis;
            c12937aM10171e2.f27576l = System.currentTimeMillis();
            Response responseM10991a = c12937aM10171e2.m10991a();
            int i3 = responseM10991a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
            if (i3 == 100) {
                Response.C12937a c12937aM10171e3 = exchange.m10171e(false);
                if (c12937aM10171e3 == null) {
                    Intrinsics3.throwNpe();
                }
                if (z2) {
                    exchange.m10172f();
                }
                c12937aM10171e3.m10997g(request);
                c12937aM10171e3.f27569e = exchange.f25438b.f25493d;
                c12937aM10171e3.f27575k = jCurrentTimeMillis;
                c12937aM10171e3.f27576l = System.currentTimeMillis();
                responseM10991a = c12937aM10171e3.m10991a();
                i3 = responseM10991a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
            }
            Intrinsics3.checkParameterIsNotNull(responseM10991a, "response");
            EventListener eventListener4 = exchange.f25440d;
            RealCall realCall4 = exchange.f25439c;
            Objects.requireNonNull(eventListener4);
            Intrinsics3.checkParameterIsNotNull(realCall4, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(responseM10991a, "response");
            if (this.f25525b && i3 == 101) {
                Intrinsics3.checkParameterIsNotNull(responseM10991a, "response");
                Request request2 = responseM10991a.request;
                Protocol2 protocol2 = responseM10991a.protocol;
                int i4 = responseM10991a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                String str = responseM10991a.message;
                Handshake handshake = responseM10991a.handshake;
                Headers.C12930a c12930aM10956e = responseM10991a.headers.m10956e();
                Response response2 = responseM10991a.networkResponse;
                Response response3 = responseM10991a.cacheResponse;
                Response response4 = responseM10991a.priorResponse;
                long j = responseM10991a.sentRequestAtMillis;
                long j2 = responseM10991a.receivedResponseAtMillis;
                Exchange exchange2 = responseM10991a.exchange;
                ResponseBody responseBody2 = Util7.f25399c;
                if (!(i4 >= 0)) {
                    throw new IllegalStateException(outline.m871q("code < 0: ", i4).toString());
                }
                if (request2 == null) {
                    throw new IllegalStateException("request == null".toString());
                }
                if (protocol2 == null) {
                    throw new IllegalStateException("protocol == null".toString());
                }
                if (str == null) {
                    throw new IllegalStateException("message == null".toString());
                }
                response = new Response(request2, protocol2, str, i4, handshake, c12930aM10956e.m10960c(), responseBody2, response2, response3, response4, j, j2, exchange2);
                i = i3;
            } else {
                Intrinsics3.checkParameterIsNotNull(responseM10991a, "response");
                Request request3 = responseM10991a.request;
                Protocol2 protocol22 = responseM10991a.protocol;
                int i5 = responseM10991a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                String str2 = responseM10991a.message;
                Handshake handshake2 = responseM10991a.handshake;
                Headers.C12930a c12930aM10956e2 = responseM10991a.headers.m10956e();
                Response response5 = responseM10991a.networkResponse;
                Response response6 = responseM10991a.cacheResponse;
                Response response7 = responseM10991a.priorResponse;
                long j3 = responseM10991a.sentRequestAtMillis;
                long j4 = responseM10991a.receivedResponseAtMillis;
                Exchange exchange3 = responseM10991a.exchange;
                Intrinsics3.checkParameterIsNotNull(responseM10991a, "response");
                try {
                    String strM10989a = Response.m10989a(responseM10991a, "Content-Type", null, 2);
                    long jMo10219g = exchange.f25442f.mo10219g(responseM10991a);
                    i = i3;
                    Exchange.b bVar = new Exchange.b(exchange, exchange.f25442f.mo10215c(responseM10991a), jMo10219g);
                    Intrinsics3.checkParameterIsNotNull(bVar, "$this$buffer");
                    RealResponseBody realResponseBody = new RealResponseBody(strM10989a, jMo10219g, new RealBufferedSource(bVar));
                    if (!(i5 >= 0)) {
                        throw new IllegalStateException(outline.m871q("code < 0: ", i5).toString());
                    }
                    if (request3 == null) {
                        throw new IllegalStateException("request == null".toString());
                    }
                    if (protocol22 == null) {
                        throw new IllegalStateException("protocol == null".toString());
                    }
                    if (str2 == null) {
                        throw new IllegalStateException("message == null".toString());
                    }
                    response = new Response(request3, protocol22, str2, i5, handshake2, c12930aM10956e2.m10960c(), realResponseBody, response5, response6, response7, j3, j4, exchange3);
                } catch (IOException e2) {
                    EventListener eventListener5 = exchange.f25440d;
                    RealCall realCall5 = exchange.f25439c;
                    Objects.requireNonNull(eventListener5);
                    Intrinsics3.checkParameterIsNotNull(realCall5, NotificationCompat.CATEGORY_CALL);
                    Intrinsics3.checkParameterIsNotNull(e2, "ioe");
                    exchange.m10173g(e2);
                    throw e2;
                }
            }
            if (!StringsJVM.equals("close", response.request.m10977b("Connection"), true)) {
                lValueOf = null;
                if (StringsJVM.equals("close", Response.m10989a(response, "Connection", null, 2), true)) {
                }
                i2 = i;
                if (i2 != 204 || i2 == 205) {
                    responseBody = response.body;
                    if ((responseBody == null ? responseBody.mo10103a() : -1L) > 0) {
                        StringBuilder sbM834V = outline.m834V("HTTP ", i2, " had non-zero Content-Length: ");
                        ResponseBody responseBody3 = response.body;
                        if (responseBody3 != null) {
                            lValueOf = Long.valueOf(responseBody3.mo10103a());
                        }
                        sbM834V.append(lValueOf);
                        throw new ProtocolException(sbM834V.toString());
                    }
                }
                return response;
            }
            lValueOf = null;
            exchange.f25442f.mo10217e().m10203l();
            i2 = i;
            if (i2 != 204) {
                responseBody = response.body;
                if ((responseBody == null ? responseBody.mo10103a() : -1L) > 0) {
                }
            }
            return response;
        } catch (IOException e3) {
            EventListener eventListener6 = exchange.f25440d;
            RealCall realCall6 = exchange.f25439c;
            Objects.requireNonNull(eventListener6);
            Intrinsics3.checkParameterIsNotNull(realCall6, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(e3, "ioe");
            exchange.m10173g(e3);
            throw e3;
        }
    }
}
