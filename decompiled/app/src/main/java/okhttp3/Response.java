package okhttp3;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.Closeable;
import java.util.Objects;
import okhttp3.Headers;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Handshake;
import p600f0.Protocol2;
import p600f0.p601e0.p605g.Exchange;

/* compiled from: Response.kt */
/* loaded from: classes3.dex */
public final class Response implements Closeable {

    /* renamed from: j, reason: from kotlin metadata */
    public final Request request;

    /* renamed from: k, reason: from kotlin metadata */
    public final Protocol2 protocol;

    /* renamed from: l, reason: from kotlin metadata */
    public final String message;

    /* renamed from: m, reason: from kotlin metadata */
    public final int code;

    /* renamed from: n, reason: from kotlin metadata */
    public final Handshake handshake;

    /* renamed from: o, reason: from kotlin metadata */
    public final Headers headers;

    /* renamed from: p, reason: from kotlin metadata */
    public final ResponseBody body;

    /* renamed from: q, reason: from kotlin metadata */
    public final Response networkResponse;

    /* renamed from: r, reason: from kotlin metadata */
    public final Response cacheResponse;

    /* renamed from: s, reason: from kotlin metadata */
    public final Response priorResponse;

    /* renamed from: t, reason: from kotlin metadata */
    public final long sentRequestAtMillis;

    /* renamed from: u, reason: from kotlin metadata */
    public final long receivedResponseAtMillis;

    /* renamed from: v, reason: from kotlin metadata */
    public final Exchange exchange;

    public Response(Request request, Protocol2 protocol2, String str, int i, Handshake handshake, Headers headers, ResponseBody responseBody, Response response, Response response2, Response response3, long j, long j2, Exchange exchange) {
        Intrinsics3.checkParameterIsNotNull(request, "request");
        Intrinsics3.checkParameterIsNotNull(protocol2, "protocol");
        Intrinsics3.checkParameterIsNotNull(str, "message");
        Intrinsics3.checkParameterIsNotNull(headers, "headers");
        this.request = request;
        this.protocol = protocol2;
        this.message = str;
        this.code = i;
        this.handshake = handshake;
        this.headers = headers;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j;
        this.receivedResponseAtMillis = j2;
        this.exchange = exchange;
    }

    /* renamed from: a */
    public static String m10989a(Response response, String str, String str2, int i) {
        int i2 = i & 2;
        Objects.requireNonNull(response);
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strM10954c = response.headers.m10954c(str);
        if (strM10954c != null) {
            return strM10954c;
        }
        return null;
    }

    /* renamed from: b */
    public final boolean m10990b() {
        int i = this.code;
        return 200 <= i && 299 >= i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
        }
        responseBody.close();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Response{protocol=");
        sbM833U.append(this.protocol);
        sbM833U.append(", code=");
        sbM833U.append(this.code);
        sbM833U.append(", message=");
        sbM833U.append(this.message);
        sbM833U.append(", url=");
        sbM833U.append(this.request.url);
        sbM833U.append('}');
        return sbM833U.toString();
    }

    /* compiled from: Response.kt */
    /* renamed from: okhttp3.Response$a */
    public static class C12937a {

        /* renamed from: a */
        public Request f27565a;

        /* renamed from: b */
        public Protocol2 f27566b;

        /* renamed from: c */
        public int f27567c;

        /* renamed from: d */
        public String f27568d;

        /* renamed from: e */
        public Handshake f27569e;

        /* renamed from: f */
        public Headers.C12930a f27570f;

        /* renamed from: g */
        public ResponseBody f27571g;

        /* renamed from: h */
        public Response f27572h;

        /* renamed from: i */
        public Response f27573i;

        /* renamed from: j */
        public Response f27574j;

        /* renamed from: k */
        public long f27575k;

        /* renamed from: l */
        public long f27576l;

        /* renamed from: m */
        public Exchange f27577m;

        public C12937a() {
            this.f27567c = -1;
            this.f27570f = new Headers.C12930a();
        }

        /* renamed from: a */
        public Response m10991a() {
            int i = this.f27567c;
            if (!(i >= 0)) {
                StringBuilder sbM833U = outline.m833U("code < 0: ");
                sbM833U.append(this.f27567c);
                throw new IllegalStateException(sbM833U.toString().toString());
            }
            Request request = this.f27565a;
            if (request == null) {
                throw new IllegalStateException("request == null".toString());
            }
            Protocol2 protocol2 = this.f27566b;
            if (protocol2 == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.f27568d;
            if (str != null) {
                return new Response(request, protocol2, str, i, this.f27569e, this.f27570f.m10960c(), this.f27571g, this.f27572h, this.f27573i, this.f27574j, this.f27575k, this.f27576l, this.f27577m);
            }
            throw new IllegalStateException("message == null".toString());
        }

        /* renamed from: b */
        public C12937a m10992b(Response response) {
            m10993c("cacheResponse", response);
            this.f27573i = response;
            return this;
        }

        /* renamed from: c */
        public final void m10993c(String str, Response response) {
            if (response != null) {
                if (!(response.body == null)) {
                    throw new IllegalArgumentException(outline.m883w(str, ".body != null").toString());
                }
                if (!(response.networkResponse == null)) {
                    throw new IllegalArgumentException(outline.m883w(str, ".networkResponse != null").toString());
                }
                if (!(response.cacheResponse == null)) {
                    throw new IllegalArgumentException(outline.m883w(str, ".cacheResponse != null").toString());
                }
                if (!(response.priorResponse == null)) {
                    throw new IllegalArgumentException(outline.m883w(str, ".priorResponse != null").toString());
                }
            }
        }

        /* renamed from: d */
        public C12937a m10994d(Headers headers) {
            Intrinsics3.checkParameterIsNotNull(headers, "headers");
            this.f27570f = headers.m10956e();
            return this;
        }

        /* renamed from: e */
        public C12937a m10995e(String str) {
            Intrinsics3.checkParameterIsNotNull(str, "message");
            this.f27568d = str;
            return this;
        }

        /* renamed from: f */
        public C12937a m10996f(Protocol2 protocol2) {
            Intrinsics3.checkParameterIsNotNull(protocol2, "protocol");
            this.f27566b = protocol2;
            return this;
        }

        /* renamed from: g */
        public C12937a m10997g(Request request) {
            Intrinsics3.checkParameterIsNotNull(request, "request");
            this.f27565a = request;
            return this;
        }

        public C12937a(Response response) {
            Intrinsics3.checkParameterIsNotNull(response, "response");
            this.f27567c = -1;
            this.f27565a = response.request;
            this.f27566b = response.protocol;
            this.f27567c = response.code;
            this.f27568d = response.message;
            this.f27569e = response.handshake;
            this.f27570f = response.headers.m10956e();
            this.f27571g = response.body;
            this.f27572h = response.networkResponse;
            this.f27573i = response.cacheResponse;
            this.f27574j = response.priorResponse;
            this.f27575k = response.sentRequestAtMillis;
            this.f27576l = response.receivedResponseAtMillis;
            this.f27577m = response.exchange;
        }
    }
}
