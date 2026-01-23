package p600f0.p601e0.p608j;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
import okio.ByteString;
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.HttpUrl;
import p600f0.OkHttpClient;
import p600f0.Protocol2;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p605g.RealConnection4;
import p600f0.p601e0.p606h.ExchangeCodec;
import p600f0.p601e0.p606h.HttpHeaders;
import p600f0.p601e0.p606h.RealInterceptorChain;
import p600f0.p601e0.p606h.StatusLine;
import p600f0.p601e0.p608j.Http2Stream;
import p615g0.Sink;
import p615g0.Source2;

/* JADX INFO: renamed from: f0.e0.j.l, reason: use source file name */
/* JADX INFO: compiled from: Http2ExchangeCodec.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Http2ExchangeCodec implements ExchangeCodec {

    /* JADX INFO: renamed from: a */
    public static final List<String> f25692a = Util7.m10132m("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* JADX INFO: renamed from: b */
    public static final List<String> f25693b = Util7.m10132m("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* JADX INFO: renamed from: c */
    public volatile Http2Stream f25694c;

    /* JADX INFO: renamed from: d */
    public final Protocol2 f25695d;

    /* JADX INFO: renamed from: e */
    public volatile boolean f25696e;

    /* JADX INFO: renamed from: f */
    public final RealConnection4 f25697f;

    /* JADX INFO: renamed from: g */
    public final RealInterceptorChain f25698g;

    /* JADX INFO: renamed from: h */
    public final Http2Connection f25699h;

    public Http2ExchangeCodec(OkHttpClient okHttpClient, RealConnection4 realConnection4, RealInterceptorChain realInterceptorChain, Http2Connection http2Connection) {
        Intrinsics3.checkParameterIsNotNull(okHttpClient, "client");
        Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
        Intrinsics3.checkParameterIsNotNull(realInterceptorChain, "chain");
        Intrinsics3.checkParameterIsNotNull(http2Connection, "http2Connection");
        this.f25697f = realConnection4;
        this.f25698g = realInterceptorChain;
        this.f25699h = http2Connection;
        List<Protocol2> list = okHttpClient.f26001E;
        Protocol2 protocol2 = Protocol2.H2_PRIOR_KNOWLEDGE;
        this.f25695d = list.contains(protocol2) ? protocol2 : Protocol2.HTTP_2;
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    /* JADX INFO: renamed from: a */
    public void mo10213a() throws IOException {
        Http2Stream http2Stream = this.f25694c;
        if (http2Stream == null) {
            Intrinsics3.throwNpe();
        }
        ((Http2Stream.a) http2Stream.m10288g()).close();
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    /* JADX INFO: renamed from: b */
    public void mo10214b(Request request) throws IOException {
        int i;
        Http2Stream http2Stream;
        boolean z2;
        Intrinsics3.checkParameterIsNotNull(request, "request");
        if (this.f25694c != null) {
            return;
        }
        boolean z3 = request.body != null;
        Intrinsics3.checkParameterIsNotNull(request, "request");
        Headers headers = request.headers;
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header2(Header2.f25582c, request.method));
        ByteString byteString = Header2.f25583d;
        HttpUrl httpUrl = request.url;
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        String strM10400b = httpUrl.m10400b();
        String strM10402d = httpUrl.m10402d();
        if (strM10402d != null) {
            strM10400b = strM10400b + '?' + strM10402d;
        }
        arrayList.add(new Header2(byteString, strM10400b));
        String strM10977b = request.m10977b("Host");
        if (strM10977b != null) {
            arrayList.add(new Header2(Header2.f25585f, strM10977b));
        }
        arrayList.add(new Header2(Header2.f25584e, request.url.f25976d));
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            String strM10955d = headers.m10955d(i2);
            Locale locale = Locale.US;
            Intrinsics3.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (strM10955d == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strM10955d.toLowerCase(locale);
            Intrinsics3.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (!f25692a.contains(lowerCase) || (Intrinsics3.areEqual(lowerCase, "te") && Intrinsics3.areEqual(headers.m10957g(i2), "trailers"))) {
                arrayList.add(new Header2(lowerCase, headers.m10957g(i2)));
            }
        }
        Http2Connection http2Connection = this.f25699h;
        Objects.requireNonNull(http2Connection);
        Intrinsics3.checkParameterIsNotNull(arrayList, "requestHeaders");
        boolean z4 = !z3;
        synchronized (http2Connection.f25627K) {
            synchronized (http2Connection) {
                if (http2Connection.f25635q > 1073741823) {
                    http2Connection.m10262e(ErrorCode2.REFUSED_STREAM);
                }
                if (http2Connection.f25636r) {
                    throw new ConnectionShutdownException();
                }
                i = http2Connection.f25635q;
                http2Connection.f25635q = i + 2;
                http2Stream = new Http2Stream(i, http2Connection, z4, false, null);
                z2 = !z3 || http2Connection.f25624H >= http2Connection.f25625I || http2Stream.f25714c >= http2Stream.f25715d;
                if (http2Stream.m10290i()) {
                    http2Connection.f25632n.put(Integer.valueOf(i), http2Stream);
                }
            }
            http2Connection.f25627K.m10302e(z4, i, arrayList);
        }
        if (z2) {
            http2Connection.f25627K.flush();
        }
        this.f25694c = http2Stream;
        if (this.f25696e) {
            Http2Stream http2Stream2 = this.f25694c;
            if (http2Stream2 == null) {
                Intrinsics3.throwNpe();
            }
            http2Stream2.m10286e(ErrorCode2.CANCEL);
            throw new IOException("Canceled");
        }
        Http2Stream http2Stream3 = this.f25694c;
        if (http2Stream3 == null) {
            Intrinsics3.throwNpe();
        }
        Http2Stream.c cVar = http2Stream3.f25720i;
        long j = this.f25698g.f25538h;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        cVar.mo10484g(j, timeUnit);
        Http2Stream http2Stream4 = this.f25694c;
        if (http2Stream4 == null) {
            Intrinsics3.throwNpe();
        }
        http2Stream4.f25721j.mo10484g(this.f25698g.f25539i, timeUnit);
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    /* JADX INFO: renamed from: c */
    public Source2 mo10215c(Response response) {
        Intrinsics3.checkParameterIsNotNull(response, "response");
        Http2Stream http2Stream = this.f25694c;
        if (http2Stream == null) {
            Intrinsics3.throwNpe();
        }
        return http2Stream.f25718g;
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    public void cancel() {
        this.f25696e = true;
        Http2Stream http2Stream = this.f25694c;
        if (http2Stream != null) {
            http2Stream.m10286e(ErrorCode2.CANCEL);
        }
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    /* JADX INFO: renamed from: d */
    public Response.C12937a mo10216d(boolean z2) throws IOException {
        Headers headers;
        Http2Stream http2Stream = this.f25694c;
        if (http2Stream == null) {
            Intrinsics3.throwNpe();
        }
        synchronized (http2Stream) {
            http2Stream.f25720i.m10424i();
            while (http2Stream.f25716e.isEmpty() && http2Stream.f25722k == null) {
                try {
                    http2Stream.m10293l();
                } catch (Throwable th) {
                    http2Stream.f25720i.m10297m();
                    throw th;
                }
            }
            http2Stream.f25720i.m10297m();
            if (!(!http2Stream.f25716e.isEmpty())) {
                IOException iOException = http2Stream.f25723l;
                if (iOException != null) {
                    throw iOException;
                }
                ErrorCode2 errorCode2 = http2Stream.f25722k;
                if (errorCode2 == null) {
                    Intrinsics3.throwNpe();
                }
                throw new StreamResetException(errorCode2);
            }
            Headers headersRemoveFirst = http2Stream.f25716e.removeFirst();
            Intrinsics3.checkExpressionValueIsNotNull(headersRemoveFirst, "headersQueue.removeFirst()");
            headers = headersRemoveFirst;
        }
        Protocol2 protocol2 = this.f25695d;
        Intrinsics3.checkParameterIsNotNull(headers, "headerBlock");
        Intrinsics3.checkParameterIsNotNull(protocol2, "protocol");
        ArrayList arrayList = new ArrayList(20);
        int size = headers.size();
        StatusLine statusLineM10234a = null;
        for (int i = 0; i < size; i++) {
            String strM10955d = headers.m10955d(i);
            String strM10957g = headers.m10957g(i);
            if (Intrinsics3.areEqual(strM10955d, ":status")) {
                statusLineM10234a = StatusLine.m10234a("HTTP/1.1 " + strM10957g);
            } else if (!f25693b.contains(strM10955d)) {
                Intrinsics3.checkParameterIsNotNull(strM10955d, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkParameterIsNotNull(strM10957g, "value");
                arrayList.add(strM10955d);
                arrayList.add(Strings4.trim(strM10957g).toString());
            }
        }
        if (statusLineM10234a == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        Response.C12937a c12937a = new Response.C12937a();
        c12937a.m10996f(protocol2);
        c12937a.f27567c = statusLineM10234a.f25545b;
        c12937a.m10995e(statusLineM10234a.f25546c);
        Object[] array = arrayList.toArray(new String[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        c12937a.m10994d(new Headers((String[]) array, null));
        if (z2 && c12937a.f27567c == 100) {
            return null;
        }
        return c12937a;
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    /* JADX INFO: renamed from: e */
    public RealConnection4 mo10217e() {
        return this.f25697f;
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    /* JADX INFO: renamed from: f */
    public void mo10218f() throws IOException {
        this.f25699h.f25627K.flush();
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    /* JADX INFO: renamed from: g */
    public long mo10219g(Response response) {
        Intrinsics3.checkParameterIsNotNull(response, "response");
        if (HttpHeaders.m10221a(response)) {
            return Util7.m10131l(response);
        }
        return 0L;
    }

    @Override // p600f0.p601e0.p606h.ExchangeCodec
    /* JADX INFO: renamed from: h */
    public Sink mo10220h(Request request, long j) {
        Intrinsics3.checkParameterIsNotNull(request, "request");
        Http2Stream http2Stream = this.f25694c;
        if (http2Stream == null) {
            Intrinsics3.throwNpe();
        }
        return http2Stream.m10288g();
    }
}
