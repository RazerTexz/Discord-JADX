package okhttp3;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import f0.e0.g.c;
import f0.v;
import f0.y;
import java.io.Closeable;
import java.util.Objects;
import okhttp3.Headers;

/* compiled from: Response.kt */
/* loaded from: classes3.dex */
public final class Response implements Closeable {

    /* renamed from: j, reason: from kotlin metadata */
    public final Request request;

    /* renamed from: k, reason: from kotlin metadata */
    public final y protocol;

    /* renamed from: l, reason: from kotlin metadata */
    public final String message;

    /* renamed from: m, reason: from kotlin metadata */
    public final int code;

    /* renamed from: n, reason: from kotlin metadata */
    public final v handshake;

    /* renamed from: o, reason: from kotlin metadata */
    public final Headers headers;

    /* renamed from: p, reason: from kotlin metadata */
    public final ResponseBody body;

    /* renamed from: q, reason: from kotlin metadata */
    public final Response networkResponse;

    /* renamed from: r, reason: from kotlin metadata */
    public final Response cacheResponse;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final Response priorResponse;

    /* renamed from: t, reason: from kotlin metadata */
    public final long sentRequestAtMillis;

    /* renamed from: u, reason: from kotlin metadata */
    public final long receivedResponseAtMillis;

    /* renamed from: v, reason: from kotlin metadata */
    public final c exchange;

    public Response(Request request, y yVar, String str, int i, v vVar, Headers headers, ResponseBody responseBody, Response response, Response response2, Response response3, long j, long j2, c cVar) {
        m.checkParameterIsNotNull(request, "request");
        m.checkParameterIsNotNull(yVar, "protocol");
        m.checkParameterIsNotNull(str, "message");
        m.checkParameterIsNotNull(headers, "headers");
        this.request = request;
        this.protocol = yVar;
        this.message = str;
        this.code = i;
        this.handshake = vVar;
        this.headers = headers;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j;
        this.receivedResponseAtMillis = j2;
        this.exchange = cVar;
    }

    public static String a(Response response, String str, String str2, int i) {
        int i2 = i & 2;
        Objects.requireNonNull(response);
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strC = response.headers.c(str);
        if (strC != null) {
            return strC;
        }
        return null;
    }

    public final boolean b() {
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
        StringBuilder sbU = b.d.b.a.a.U("Response{protocol=");
        sbU.append(this.protocol);
        sbU.append(", code=");
        sbU.append(this.code);
        sbU.append(", message=");
        sbU.append(this.message);
        sbU.append(", url=");
        sbU.append(this.request.url);
        sbU.append('}');
        return sbU.toString();
    }

    /* compiled from: Response.kt */
    public static class a {
        public Request a;

        /* renamed from: b, reason: collision with root package name */
        public y f3816b;
        public int c;
        public String d;
        public v e;
        public Headers.a f;
        public ResponseBody g;
        public Response h;
        public Response i;
        public Response j;
        public long k;
        public long l;
        public c m;

        public a() {
            this.c = -1;
            this.f = new Headers.a();
        }

        public Response a() {
            int i = this.c;
            if (!(i >= 0)) {
                StringBuilder sbU = b.d.b.a.a.U("code < 0: ");
                sbU.append(this.c);
                throw new IllegalStateException(sbU.toString().toString());
            }
            Request request = this.a;
            if (request == null) {
                throw new IllegalStateException("request == null".toString());
            }
            y yVar = this.f3816b;
            if (yVar == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.d;
            if (str != null) {
                return new Response(request, yVar, str, i, this.e, this.f.c(), this.g, this.h, this.i, this.j, this.k, this.l, this.m);
            }
            throw new IllegalStateException("message == null".toString());
        }

        public a b(Response response) {
            c("cacheResponse", response);
            this.i = response;
            return this;
        }

        public final void c(String str, Response response) {
            if (response != null) {
                if (!(response.body == null)) {
                    throw new IllegalArgumentException(b.d.b.a.a.w(str, ".body != null").toString());
                }
                if (!(response.networkResponse == null)) {
                    throw new IllegalArgumentException(b.d.b.a.a.w(str, ".networkResponse != null").toString());
                }
                if (!(response.cacheResponse == null)) {
                    throw new IllegalArgumentException(b.d.b.a.a.w(str, ".cacheResponse != null").toString());
                }
                if (!(response.priorResponse == null)) {
                    throw new IllegalArgumentException(b.d.b.a.a.w(str, ".priorResponse != null").toString());
                }
            }
        }

        public a d(Headers headers) {
            m.checkParameterIsNotNull(headers, "headers");
            this.f = headers.e();
            return this;
        }

        public a e(String str) {
            m.checkParameterIsNotNull(str, "message");
            this.d = str;
            return this;
        }

        public a f(y yVar) {
            m.checkParameterIsNotNull(yVar, "protocol");
            this.f3816b = yVar;
            return this;
        }

        public a g(Request request) {
            m.checkParameterIsNotNull(request, "request");
            this.a = request;
            return this;
        }

        public a(Response response) {
            m.checkParameterIsNotNull(response, "response");
            this.c = -1;
            this.a = response.request;
            this.f3816b = response.protocol;
            this.c = response.code;
            this.d = response.message;
            this.e = response.handshake;
            this.f = response.headers.e();
            this.g = response.body;
            this.h = response.networkResponse;
            this.i = response.cacheResponse;
            this.j = response.priorResponse;
            this.k = response.sentRequestAtMillis;
            this.l = response.receivedResponseAtMillis;
            this.m = response.exchange;
        }
    }
}
