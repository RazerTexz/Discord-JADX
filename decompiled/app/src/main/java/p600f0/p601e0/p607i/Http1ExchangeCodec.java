package p600f0.p601e0.p607i;

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
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.CookieJar2;
import p600f0.HttpUrl;
import p600f0.OkHttpClient;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p605g.RealConnection4;
import p600f0.p601e0.p606h.ExchangeCodec;
import p600f0.p601e0.p606h.HttpHeaders;
import p600f0.p601e0.p606h.StatusLine;
import p615g0.Buffer3;
import p615g0.BufferedSource;
import p615g0.ForwardingTimeout;
import p615g0.Sink;
import p615g0.Source2;
import p615g0.Timeout2;

/* compiled from: Http1ExchangeCodec.kt */
/* renamed from: f0.e0.i.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class Http1ExchangeCodec implements ExchangeCodec {

    /* renamed from: a */
    public int f25549a;

    /* renamed from: b */
    public final HeadersReader f25550b;

    /* renamed from: c */
    public Headers f25551c;

    /* renamed from: d */
    public final OkHttpClient f25552d;

    /* renamed from: e */
    public final RealConnection4 f25553e;

    /* renamed from: f */
    public final BufferedSource f25554f;

    /* renamed from: g */
    public final BufferedSink f25555g;

    /* compiled from: Http1ExchangeCodec.kt */
    /* renamed from: f0.e0.i.b$a */
    public abstract class a implements Source2 {

        /* renamed from: j */
        public final ForwardingTimeout f25556j;

        /* renamed from: k */
        public boolean f25557k;

        public a() {
            this.f25556j = new ForwardingTimeout(Http1ExchangeCodec.this.f25554f.timeout());
        }

        /* renamed from: a */
        public final void m10240a() {
            Http1ExchangeCodec http1ExchangeCodec = Http1ExchangeCodec.this;
            int i = http1ExchangeCodec.f25549a;
            if (i == 6) {
                return;
            }
            if (i == 5) {
                Http1ExchangeCodec.m10237i(http1ExchangeCodec, this.f25556j);
                Http1ExchangeCodec.this.f25549a = 6;
            } else {
                StringBuilder sbM833U = outline.m833U("state: ");
                sbM833U.append(Http1ExchangeCodec.this.f25549a);
                throw new IllegalStateException(sbM833U.toString());
            }
        }

        @Override // p615g0.Source2
        /* renamed from: i0 */
        public long mo10176i0(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
            try {
                return Http1ExchangeCodec.this.f25554f.mo10176i0(buffer3, j);
            } catch (IOException e) {
                Http1ExchangeCodec.this.f25553e.m10203l();
                m10240a();
                throw e;
            }
        }

        @Override // p615g0.Source2
        public Timeout2 timeout() {
            return this.f25556j;
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* renamed from: f0.e0.i.b$b */
    public final class b implements Sink {

        /* renamed from: j */
        public final ForwardingTimeout f25559j;

        /* renamed from: k */
        public boolean f25560k;

        public b() {
            this.f25559j = new ForwardingTimeout(Http1ExchangeCodec.this.f25555g.timeout());
        }

        @Override // p615g0.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f25560k) {
                return;
            }
            this.f25560k = true;
            Http1ExchangeCodec.this.f25555g.mo10436K("0\r\n\r\n");
            Http1ExchangeCodec.m10237i(Http1ExchangeCodec.this, this.f25559j);
            Http1ExchangeCodec.this.f25549a = 3;
        }

        @Override // p615g0.Sink, java.io.Flushable
        public synchronized void flush() {
            if (this.f25560k) {
                return;
            }
            Http1ExchangeCodec.this.f25555g.flush();
        }

        @Override // p615g0.Sink
        public Timeout2 timeout() {
            return this.f25559j;
        }

        @Override // p615g0.Sink
        public void write(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "source");
            if (!(!this.f25560k)) {
                throw new IllegalStateException("closed".toString());
            }
            if (j == 0) {
                return;
            }
            Http1ExchangeCodec.this.f25555g.mo10441Q(j);
            Http1ExchangeCodec.this.f25555g.mo10436K("\r\n");
            Http1ExchangeCodec.this.f25555g.write(buffer3, j);
            Http1ExchangeCodec.this.f25555g.mo10436K("\r\n");
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* renamed from: f0.e0.i.b$c */
    public final class c extends a {

        /* renamed from: m */
        public long f25562m;

        /* renamed from: n */
        public boolean f25563n;

        /* renamed from: o */
        public final HttpUrl f25564o;

        /* renamed from: p */
        public final /* synthetic */ Http1ExchangeCodec f25565p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Http1ExchangeCodec http1ExchangeCodec, HttpUrl httpUrl) {
            super();
            Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
            this.f25565p = http1ExchangeCodec;
            this.f25564o = httpUrl;
            this.f25562m = -1L;
            this.f25563n = true;
        }

        @Override // p615g0.Source2, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f25557k) {
                return;
            }
            if (this.f25563n && !Util7.m10128i(this, 100, TimeUnit.MILLISECONDS)) {
                this.f25565p.f25553e.m10203l();
                m10240a();
            }
            this.f25557k = true;
        }

        @Override // p600f0.p601e0.p607i.Http1ExchangeCodec.a, p615g0.Source2
        /* renamed from: i0 */
        public long mo10176i0(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
            boolean z2 = true;
            if (!(j >= 0)) {
                throw new IllegalArgumentException(outline.m877t("byteCount < 0: ", j).toString());
            }
            if (!(!this.f25557k)) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.f25563n) {
                return -1L;
            }
            long j2 = this.f25562m;
            if (j2 == 0 || j2 == -1) {
                if (j2 != -1) {
                    this.f25565p.f25554f.mo10449Y();
                }
                try {
                    this.f25562m = this.f25565p.f25554f.mo10467s0();
                    String strMo10449Y = this.f25565p.f25554f.mo10449Y();
                    if (strMo10449Y == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    String string = Strings4.trim(strMo10449Y).toString();
                    if (this.f25562m >= 0) {
                        if (string.length() <= 0) {
                            z2 = false;
                        }
                        if (!z2 || StringsJVM.startsWith$default(string, ";", false, 2, null)) {
                            if (this.f25562m == 0) {
                                this.f25563n = false;
                                Http1ExchangeCodec http1ExchangeCodec = this.f25565p;
                                http1ExchangeCodec.f25551c = http1ExchangeCodec.f25550b.m10235a();
                                OkHttpClient okHttpClient = this.f25565p.f25552d;
                                if (okHttpClient == null) {
                                    Intrinsics3.throwNpe();
                                }
                                CookieJar2 cookieJar2 = okHttpClient.f26021v;
                                HttpUrl httpUrl = this.f25564o;
                                Headers headers = this.f25565p.f25551c;
                                if (headers == null) {
                                    Intrinsics3.throwNpe();
                                }
                                HttpHeaders.m10224d(cookieJar2, httpUrl, headers);
                                m10240a();
                            }
                            if (!this.f25563n) {
                                return -1L;
                            }
                        }
                    }
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f25562m + string + '\"');
                } catch (NumberFormatException e) {
                    throw new ProtocolException(e.getMessage());
                }
            }
            long jMo10176i0 = super.mo10176i0(buffer3, Math.min(j, this.f25562m));
            if (jMo10176i0 != -1) {
                this.f25562m -= jMo10176i0;
                return jMo10176i0;
            }
            this.f25565p.f25553e.m10203l();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            m10240a();
            throw protocolException;
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* renamed from: f0.e0.i.b$d */
    public final class d extends a {

        /* renamed from: m */
        public long f25566m;

        public d(long j) {
            super();
            this.f25566m = j;
            if (j == 0) {
                m10240a();
            }
        }

        @Override // p615g0.Source2, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f25557k) {
                return;
            }
            if (this.f25566m != 0 && !Util7.m10128i(this, 100, TimeUnit.MILLISECONDS)) {
                Http1ExchangeCodec.this.f25553e.m10203l();
                m10240a();
            }
            this.f25557k = true;
        }

        @Override // p600f0.p601e0.p607i.Http1ExchangeCodec.a, p615g0.Source2
        /* renamed from: i0 */
        public long mo10176i0(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(outline.m877t("byteCount < 0: ", j).toString());
            }
            if (!(!this.f25557k)) {
                throw new IllegalStateException("closed".toString());
            }
            long j2 = this.f25566m;
            if (j2 == 0) {
                return -1L;
            }
            long jMo10176i0 = super.mo10176i0(buffer3, Math.min(j2, j));
            if (jMo10176i0 == -1) {
                Http1ExchangeCodec.this.f25553e.m10203l();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                m10240a();
                throw protocolException;
            }
            long j3 = this.f25566m - jMo10176i0;
            this.f25566m = j3;
            if (j3 == 0) {
                m10240a();
            }
            return jMo10176i0;
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* renamed from: f0.e0.i.b$e */
    public final class e implements Sink {

        /* renamed from: j */
        public final ForwardingTimeout f25568j;

        /* renamed from: k */
        public boolean f25569k;

        public e() {
            this.f25568j = new ForwardingTimeout(Http1ExchangeCodec.this.f25555g.timeout());
        }

        @Override // p615g0.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f25569k) {
                return;
            }
            this.f25569k = true;
            Http1ExchangeCodec.m10237i(Http1ExchangeCodec.this, this.f25568j);
            Http1ExchangeCodec.this.f25549a = 3;
        }

        @Override // p615g0.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.f25569k) {
                return;
            }
            Http1ExchangeCodec.this.f25555g.flush();
        }

        @Override // p615g0.Sink
        public Timeout2 timeout() {
            return this.f25568j;
        }

        @Override // p615g0.Sink
        public void write(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "source");
            if (!(!this.f25569k)) {
                throw new IllegalStateException("closed".toString());
            }
            Util7.m10122c(buffer3.f26080k, 0L, j);
            Http1ExchangeCodec.this.f25555g.write(buffer3, j);
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* renamed from: f0.e0.i.b$f */
    public final class f extends a {

        /* renamed from: m */
        public boolean f25571m;

        public f(Http1ExchangeCodec http1ExchangeCodec) {
            super();
        }

        @Override // p615g0.Source2, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f25557k) {
                return;
            }
            if (!this.f25571m) {
                m10240a();
            }
            this.f25557k = true;
        }

        @Override // p600f0.p601e0.p607i.Http1ExchangeCodec.a, p615g0.Source2
        /* renamed from: i0 */
        public long mo10176i0(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(outline.m877t("byteCount < 0: ", j).toString());
            }
            if (!(!this.f25557k)) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.f25571m) {
                return -1L;
            }
            long jMo10176i0 = super.mo10176i0(buffer3, j);
            if (jMo10176i0 != -1) {
                return jMo10176i0;
            }
            this.f25571m = true;
            m10240a();
            return -1L;
        }
    }

    public Http1ExchangeCodec(OkHttpClient okHttpClient, RealConnection4 realConnection4, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
        Intrinsics3.checkParameterIsNotNull(bufferedSink, "sink");
        this.f25552d = okHttpClient;
        this.f25553e = realConnection4;
        this.f25554f = bufferedSource;
        this.f25555g = bufferedSink;
        this.f25550b = new HeadersReader(bufferedSource);
    }

    /* renamed from: i */
    public static final void m10237i(Http1ExchangeCodec http1ExchangeCodec, ForwardingTimeout forwardingTimeout) {
        Objects.requireNonNull(http1ExchangeCodec);
        Timeout2 timeout2 = forwardingTimeout.f26094e;
        Timeout2 timeout22 = Timeout2.f26133a;
        Intrinsics3.checkParameterIsNotNull(timeout22, "delegate");
        forwardingTimeout.f26094e = timeout22;
        timeout2.mo10478a();
        timeout2.mo10479b();
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    /* renamed from: a */
    public void mo10213a() throws IOException {
        this.f25555g.flush();
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    /* renamed from: b */
    public void mo10214b(Request request) {
        Intrinsics3.checkParameterIsNotNull(request, "request");
        Proxy.Type type = this.f25553e.f25506q.f25371b.type();
        Intrinsics3.checkExpressionValueIsNotNull(type, "connection.route().proxy.type()");
        Intrinsics3.checkParameterIsNotNull(request, "request");
        Intrinsics3.checkParameterIsNotNull(type, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.method);
        sb.append(' ');
        HttpUrl httpUrl = request.url;
        if (!httpUrl.f25975c && type == Proxy.Type.HTTP) {
            sb.append(httpUrl);
        } else {
            Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
            String strM10400b = httpUrl.m10400b();
            String strM10402d = httpUrl.m10402d();
            if (strM10402d != null) {
                strM10400b = strM10400b + '?' + strM10402d;
            }
            sb.append(strM10400b);
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        m10239k(request.headers, string);
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    /* renamed from: c */
    public Source2 mo10215c(Response response) {
        Intrinsics3.checkParameterIsNotNull(response, "response");
        if (!HttpHeaders.m10221a(response)) {
            return m10238j(0L);
        }
        if (StringsJVM.equals("chunked", Response.m10989a(response, "Transfer-Encoding", null, 2), true)) {
            HttpUrl httpUrl = response.request.url;
            if (this.f25549a == 4) {
                this.f25549a = 5;
                return new c(this, httpUrl);
            }
            StringBuilder sbM833U = outline.m833U("state: ");
            sbM833U.append(this.f25549a);
            throw new IllegalStateException(sbM833U.toString().toString());
        }
        long jM10131l = Util7.m10131l(response);
        if (jM10131l != -1) {
            return m10238j(jM10131l);
        }
        if (this.f25549a == 4) {
            this.f25549a = 5;
            this.f25553e.m10203l();
            return new f(this);
        }
        StringBuilder sbM833U2 = outline.m833U("state: ");
        sbM833U2.append(this.f25549a);
        throw new IllegalStateException(sbM833U2.toString().toString());
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    public void cancel() {
        Socket socket = this.f25553e.f25491b;
        if (socket != null) {
            Util7.m10124e(socket);
        }
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    /* renamed from: d */
    public Response.C12937a mo10216d(boolean z2) {
        int i = this.f25549a;
        boolean z3 = true;
        if (i != 1 && i != 3) {
            z3 = false;
        }
        if (!z3) {
            StringBuilder sbM833U = outline.m833U("state: ");
            sbM833U.append(this.f25549a);
            throw new IllegalStateException(sbM833U.toString().toString());
        }
        try {
            StatusLine statusLineM10234a = StatusLine.m10234a(this.f25550b.m10236b());
            Response.C12937a c12937a = new Response.C12937a();
            c12937a.m10996f(statusLineM10234a.f25544a);
            c12937a.f27567c = statusLineM10234a.f25545b;
            c12937a.m10995e(statusLineM10234a.f25546c);
            c12937a.m10994d(this.f25550b.m10235a());
            if (z2 && statusLineM10234a.f25545b == 100) {
                return null;
            }
            if (statusLineM10234a.f25545b == 100) {
                this.f25549a = 3;
                return c12937a;
            }
            this.f25549a = 4;
            return c12937a;
        } catch (EOFException e2) {
            throw new IOException(outline.m883w("unexpected end of stream on ", this.f25553e.f25506q.f25370a.f25353a.m10406h()), e2);
        }
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    /* renamed from: e */
    public RealConnection4 mo10217e() {
        return this.f25553e;
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    /* renamed from: f */
    public void mo10218f() throws IOException {
        this.f25555g.flush();
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    /* renamed from: g */
    public long mo10219g(Response response) {
        Intrinsics3.checkParameterIsNotNull(response, "response");
        if (!HttpHeaders.m10221a(response)) {
            return 0L;
        }
        if (StringsJVM.equals("chunked", Response.m10989a(response, "Transfer-Encoding", null, 2), true)) {
            return -1L;
        }
        return Util7.m10131l(response);
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    /* renamed from: h */
    public Sink mo10220h(Request request, long j) throws ProtocolException {
        Intrinsics3.checkParameterIsNotNull(request, "request");
        RequestBody requestBody = request.body;
        if (requestBody != null && requestBody.isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (StringsJVM.equals("chunked", request.m10977b("Transfer-Encoding"), true)) {
            if (this.f25549a == 1) {
                this.f25549a = 2;
                return new b();
            }
            StringBuilder sbM833U = outline.m833U("state: ");
            sbM833U.append(this.f25549a);
            throw new IllegalStateException(sbM833U.toString().toString());
        }
        if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.f25549a == 1) {
            this.f25549a = 2;
            return new e();
        }
        StringBuilder sbM833U2 = outline.m833U("state: ");
        sbM833U2.append(this.f25549a);
        throw new IllegalStateException(sbM833U2.toString().toString());
    }

    /* renamed from: j */
    public final Source2 m10238j(long j) {
        if (this.f25549a == 4) {
            this.f25549a = 5;
            return new d(j);
        }
        StringBuilder sbM833U = outline.m833U("state: ");
        sbM833U.append(this.f25549a);
        throw new IllegalStateException(sbM833U.toString().toString());
    }

    /* renamed from: k */
    public final void m10239k(Headers headers, String str) {
        Intrinsics3.checkParameterIsNotNull(headers, "headers");
        Intrinsics3.checkParameterIsNotNull(str, "requestLine");
        if (!(this.f25549a == 0)) {
            StringBuilder sbM833U = outline.m833U("state: ");
            sbM833U.append(this.f25549a);
            throw new IllegalStateException(sbM833U.toString().toString());
        }
        this.f25555g.mo10436K(str).mo10436K("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.f25555g.mo10436K(headers.m10955d(i)).mo10436K(": ").mo10436K(headers.m10957g(i)).mo10436K("\r\n");
        }
        this.f25555g.mo10436K("\r\n");
        this.f25549a = 1;
    }
}
