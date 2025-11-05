package f0.e0.i;

import d0.g0.t;
import d0.z.d.m;
import f0.e0.g.j;
import f0.p;
import f0.w;
import f0.x;
import g0.g;
import g0.k;
import g0.v;
import g0.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

/* compiled from: Http1ExchangeCodec.kt */
/* loaded from: classes3.dex */
public final class b implements f0.e0.h.d {
    public int a;

    /* renamed from: b, reason: collision with root package name */
    public final f0.e0.i.a f3632b;
    public Headers c;
    public final x d;
    public final j e;
    public final g f;
    public final BufferedSink g;

    /* compiled from: Http1ExchangeCodec.kt */
    public abstract class a implements g0.x {
        public final k j;
        public boolean k;

        public a() {
            this.j = new k(b.this.f.timeout());
        }

        public final void a() {
            b bVar = b.this;
            int i = bVar.a;
            if (i == 6) {
                return;
            }
            if (i == 5) {
                b.i(bVar, this.j);
                b.this.a = 6;
            } else {
                StringBuilder sbU = b.d.b.a.a.U("state: ");
                sbU.append(b.this.a);
                throw new IllegalStateException(sbU.toString());
            }
        }

        @Override // g0.x
        public long i0(g0.e eVar, long j) throws IOException {
            m.checkParameterIsNotNull(eVar, "sink");
            try {
                return b.this.f.i0(eVar, j);
            } catch (IOException e) {
                b.this.e.l();
                a();
                throw e;
            }
        }

        @Override // g0.x
        public y timeout() {
            return this.j;
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* renamed from: f0.e0.i.b$b, reason: collision with other inner class name */
    public final class C0606b implements v {
        public final k j;
        public boolean k;

        public C0606b() {
            this.j = new k(b.this.g.timeout());
        }

        @Override // g0.v, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.k) {
                return;
            }
            this.k = true;
            b.this.g.K("0\r\n\r\n");
            b.i(b.this, this.j);
            b.this.a = 3;
        }

        @Override // g0.v, java.io.Flushable
        public synchronized void flush() {
            if (this.k) {
                return;
            }
            b.this.g.flush();
        }

        @Override // g0.v
        public y timeout() {
            return this.j;
        }

        @Override // g0.v
        public void write(g0.e eVar, long j) throws IOException {
            m.checkParameterIsNotNull(eVar, "source");
            if (!(!this.k)) {
                throw new IllegalStateException("closed".toString());
            }
            if (j == 0) {
                return;
            }
            b.this.g.Q(j);
            b.this.g.K("\r\n");
            b.this.g.write(eVar, j);
            b.this.g.K("\r\n");
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    public final class c extends a {
        public long m;
        public boolean n;
        public final w o;
        public final /* synthetic */ b p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, w wVar) {
            super();
            m.checkParameterIsNotNull(wVar, "url");
            this.p = bVar;
            this.o = wVar;
            this.m = -1L;
            this.n = true;
        }

        @Override // g0.x, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.k) {
                return;
            }
            if (this.n && !f0.e0.c.i(this, 100, TimeUnit.MILLISECONDS)) {
                this.p.e.l();
                a();
            }
            this.k = true;
        }

        @Override // f0.e0.i.b.a, g0.x
        public long i0(g0.e eVar, long j) throws IOException {
            m.checkParameterIsNotNull(eVar, "sink");
            boolean z2 = true;
            if (!(j >= 0)) {
                throw new IllegalArgumentException(b.d.b.a.a.t("byteCount < 0: ", j).toString());
            }
            if (!(!this.k)) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.n) {
                return -1L;
            }
            long j2 = this.m;
            if (j2 == 0 || j2 == -1) {
                if (j2 != -1) {
                    this.p.f.Y();
                }
                try {
                    this.m = this.p.f.s0();
                    String strY = this.p.f.Y();
                    if (strY == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    String string = d0.g0.w.trim(strY).toString();
                    if (this.m >= 0) {
                        if (string.length() <= 0) {
                            z2 = false;
                        }
                        if (!z2 || t.startsWith$default(string, ";", false, 2, null)) {
                            if (this.m == 0) {
                                this.n = false;
                                b bVar = this.p;
                                bVar.c = bVar.f3632b.a();
                                x xVar = this.p.d;
                                if (xVar == null) {
                                    m.throwNpe();
                                }
                                p pVar = xVar.v;
                                w wVar = this.o;
                                Headers headers = this.p.c;
                                if (headers == null) {
                                    m.throwNpe();
                                }
                                f0.e0.h.e.d(pVar, wVar, headers);
                                a();
                            }
                            if (!this.n) {
                                return -1L;
                            }
                        }
                    }
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.m + string + '\"');
                } catch (NumberFormatException e) {
                    throw new ProtocolException(e.getMessage());
                }
            }
            long jI0 = super.i0(eVar, Math.min(j, this.m));
            if (jI0 != -1) {
                this.m -= jI0;
                return jI0;
            }
            this.p.e.l();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a();
            throw protocolException;
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    public final class d extends a {
        public long m;

        public d(long j) {
            super();
            this.m = j;
            if (j == 0) {
                a();
            }
        }

        @Override // g0.x, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.k) {
                return;
            }
            if (this.m != 0 && !f0.e0.c.i(this, 100, TimeUnit.MILLISECONDS)) {
                b.this.e.l();
                a();
            }
            this.k = true;
        }

        @Override // f0.e0.i.b.a, g0.x
        public long i0(g0.e eVar, long j) throws IOException {
            m.checkParameterIsNotNull(eVar, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(b.d.b.a.a.t("byteCount < 0: ", j).toString());
            }
            if (!(!this.k)) {
                throw new IllegalStateException("closed".toString());
            }
            long j2 = this.m;
            if (j2 == 0) {
                return -1L;
            }
            long jI0 = super.i0(eVar, Math.min(j2, j));
            if (jI0 == -1) {
                b.this.e.l();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a();
                throw protocolException;
            }
            long j3 = this.m - jI0;
            this.m = j3;
            if (j3 == 0) {
                a();
            }
            return jI0;
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    public final class e implements v {
        public final k j;
        public boolean k;

        public e() {
            this.j = new k(b.this.g.timeout());
        }

        @Override // g0.v, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.k) {
                return;
            }
            this.k = true;
            b.i(b.this, this.j);
            b.this.a = 3;
        }

        @Override // g0.v, java.io.Flushable
        public void flush() throws IOException {
            if (this.k) {
                return;
            }
            b.this.g.flush();
        }

        @Override // g0.v
        public y timeout() {
            return this.j;
        }

        @Override // g0.v
        public void write(g0.e eVar, long j) throws IOException {
            m.checkParameterIsNotNull(eVar, "source");
            if (!(!this.k)) {
                throw new IllegalStateException("closed".toString());
            }
            f0.e0.c.c(eVar.k, 0L, j);
            b.this.g.write(eVar, j);
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    public final class f extends a {
        public boolean m;

        public f(b bVar) {
            super();
        }

        @Override // g0.x, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.k) {
                return;
            }
            if (!this.m) {
                a();
            }
            this.k = true;
        }

        @Override // f0.e0.i.b.a, g0.x
        public long i0(g0.e eVar, long j) throws IOException {
            m.checkParameterIsNotNull(eVar, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(b.d.b.a.a.t("byteCount < 0: ", j).toString());
            }
            if (!(!this.k)) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.m) {
                return -1L;
            }
            long jI0 = super.i0(eVar, j);
            if (jI0 != -1) {
                return jI0;
            }
            this.m = true;
            a();
            return -1L;
        }
    }

    public b(x xVar, j jVar, g gVar, BufferedSink bufferedSink) {
        m.checkParameterIsNotNull(jVar, "connection");
        m.checkParameterIsNotNull(gVar, "source");
        m.checkParameterIsNotNull(bufferedSink, "sink");
        this.d = xVar;
        this.e = jVar;
        this.f = gVar;
        this.g = bufferedSink;
        this.f3632b = new f0.e0.i.a(gVar);
    }

    public static final void i(b bVar, k kVar) {
        Objects.requireNonNull(bVar);
        y yVar = kVar.e;
        y yVar2 = y.a;
        m.checkParameterIsNotNull(yVar2, "delegate");
        kVar.e = yVar2;
        yVar.a();
        yVar.b();
    }

    @Override // f0.e0.h.d
    public void a() throws IOException {
        this.g.flush();
    }

    @Override // f0.e0.h.d
    public void b(Request request) {
        m.checkParameterIsNotNull(request, "request");
        Proxy.Type type = this.e.q.f3603b.type();
        m.checkExpressionValueIsNotNull(type, "connection.route().proxy.type()");
        m.checkParameterIsNotNull(request, "request");
        m.checkParameterIsNotNull(type, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.method);
        sb.append(' ');
        w wVar = request.url;
        if (!wVar.c && type == Proxy.Type.HTTP) {
            sb.append(wVar);
        } else {
            m.checkParameterIsNotNull(wVar, "url");
            String strB = wVar.b();
            String strD = wVar.d();
            if (strD != null) {
                strB = strB + '?' + strD;
            }
            sb.append(strB);
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        k(request.headers, string);
    }

    @Override // f0.e0.h.d
    public g0.x c(Response response) {
        m.checkParameterIsNotNull(response, "response");
        if (!f0.e0.h.e.a(response)) {
            return j(0L);
        }
        if (t.equals("chunked", Response.a(response, "Transfer-Encoding", null, 2), true)) {
            w wVar = response.request.url;
            if (this.a == 4) {
                this.a = 5;
                return new c(this, wVar);
            }
            StringBuilder sbU = b.d.b.a.a.U("state: ");
            sbU.append(this.a);
            throw new IllegalStateException(sbU.toString().toString());
        }
        long jL = f0.e0.c.l(response);
        if (jL != -1) {
            return j(jL);
        }
        if (this.a == 4) {
            this.a = 5;
            this.e.l();
            return new f(this);
        }
        StringBuilder sbU2 = b.d.b.a.a.U("state: ");
        sbU2.append(this.a);
        throw new IllegalStateException(sbU2.toString().toString());
    }

    @Override // f0.e0.h.d
    public void cancel() {
        Socket socket = this.e.f3620b;
        if (socket != null) {
            f0.e0.c.e(socket);
        }
    }

    @Override // f0.e0.h.d
    public Response.a d(boolean z2) {
        int i = this.a;
        boolean z3 = true;
        if (i != 1 && i != 3) {
            z3 = false;
        }
        if (!z3) {
            StringBuilder sbU = b.d.b.a.a.U("state: ");
            sbU.append(this.a);
            throw new IllegalStateException(sbU.toString().toString());
        }
        try {
            f0.e0.h.j jVarA = f0.e0.h.j.a(this.f3632b.b());
            Response.a aVar = new Response.a();
            aVar.f(jVarA.a);
            aVar.c = jVarA.f3630b;
            aVar.e(jVarA.c);
            aVar.d(this.f3632b.a());
            if (z2 && jVarA.f3630b == 100) {
                return null;
            }
            if (jVarA.f3630b == 100) {
                this.a = 3;
                return aVar;
            }
            this.a = 4;
            return aVar;
        } catch (EOFException e2) {
            throw new IOException(b.d.b.a.a.w("unexpected end of stream on ", this.e.q.a.a.h()), e2);
        }
    }

    @Override // f0.e0.h.d
    public j e() {
        return this.e;
    }

    @Override // f0.e0.h.d
    public void f() throws IOException {
        this.g.flush();
    }

    @Override // f0.e0.h.d
    public long g(Response response) {
        m.checkParameterIsNotNull(response, "response");
        if (!f0.e0.h.e.a(response)) {
            return 0L;
        }
        if (t.equals("chunked", Response.a(response, "Transfer-Encoding", null, 2), true)) {
            return -1L;
        }
        return f0.e0.c.l(response);
    }

    @Override // f0.e0.h.d
    public v h(Request request, long j) throws ProtocolException {
        m.checkParameterIsNotNull(request, "request");
        RequestBody requestBody = request.body;
        if (requestBody != null && requestBody.isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (t.equals("chunked", request.b("Transfer-Encoding"), true)) {
            if (this.a == 1) {
                this.a = 2;
                return new C0606b();
            }
            StringBuilder sbU = b.d.b.a.a.U("state: ");
            sbU.append(this.a);
            throw new IllegalStateException(sbU.toString().toString());
        }
        if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.a == 1) {
            this.a = 2;
            return new e();
        }
        StringBuilder sbU2 = b.d.b.a.a.U("state: ");
        sbU2.append(this.a);
        throw new IllegalStateException(sbU2.toString().toString());
    }

    public final g0.x j(long j) {
        if (this.a == 4) {
            this.a = 5;
            return new d(j);
        }
        StringBuilder sbU = b.d.b.a.a.U("state: ");
        sbU.append(this.a);
        throw new IllegalStateException(sbU.toString().toString());
    }

    public final void k(Headers headers, String str) {
        m.checkParameterIsNotNull(headers, "headers");
        m.checkParameterIsNotNull(str, "requestLine");
        if (!(this.a == 0)) {
            StringBuilder sbU = b.d.b.a.a.U("state: ");
            sbU.append(this.a);
            throw new IllegalStateException(sbU.toString().toString());
        }
        this.g.K(str).K("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.g.K(headers.d(i)).K(": ").K(headers.g(i)).K("\r\n");
        }
        this.g.K("\r\n");
        this.a = 1;
    }
}
