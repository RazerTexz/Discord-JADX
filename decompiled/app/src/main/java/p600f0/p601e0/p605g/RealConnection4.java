package p600f0.p601e0.p605g;

import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.TypeCastException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RouteException;
import okio.BufferedSink;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p579g0.Indent;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Address;
import p600f0.Call2;
import p600f0.CertificatePinner;
import p600f0.CertificatePinner2;
import p600f0.Connection2;
import p600f0.ConnectionSpec;
import p600f0.EventListener;
import p600f0.Handshake;
import p600f0.HttpUrl;
import p600f0.OkHttpClient;
import p600f0.Protocol2;
import p600f0.Route;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p604f.TaskQueue;
import p600f0.p601e0.p604f.TaskQueue2;
import p600f0.p601e0.p604f.TaskRunner;
import p600f0.p601e0.p606h.ExchangeCodec;
import p600f0.p601e0.p606h.RealInterceptorChain;
import p600f0.p601e0.p607i.Http1ExchangeCodec;
import p600f0.p601e0.p608j.ErrorCode2;
import p600f0.p601e0.p608j.Http2;
import p600f0.p601e0.p608j.Http2Connection;
import p600f0.p601e0.p608j.Http2ExchangeCodec;
import p600f0.p601e0.p608j.Http2Stream;
import p600f0.p601e0.p608j.Http2Writer;
import p600f0.p601e0.p608j.Settings3;
import p600f0.p601e0.p609k.Platform2;
import p600f0.p601e0.p612m.OkHostnameVerifier;
import p615g0.BufferedSource;
import p615g0.RealBufferedSink;
import p615g0.RealBufferedSource;
import p615g0.Sink;
import p615g0.Source2;
import p615g0.Timeout2;

/* compiled from: RealConnection.kt */
/* renamed from: f0.e0.g.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class RealConnection4 extends Http2Connection.c implements Connection2 {

    /* renamed from: b */
    public Socket f25491b;

    /* renamed from: c */
    public Socket f25492c;

    /* renamed from: d */
    public Handshake f25493d;

    /* renamed from: e */
    public Protocol2 f25494e;

    /* renamed from: f */
    public Http2Connection f25495f;

    /* renamed from: g */
    public BufferedSource f25496g;

    /* renamed from: h */
    public BufferedSink f25497h;

    /* renamed from: i */
    public boolean f25498i;

    /* renamed from: j */
    public boolean f25499j;

    /* renamed from: k */
    public int f25500k;

    /* renamed from: l */
    public int f25501l;

    /* renamed from: m */
    public int f25502m;

    /* renamed from: n */
    public int f25503n;

    /* renamed from: o */
    public final List<Reference<RealCall>> f25504o;

    /* renamed from: p */
    public long f25505p;

    /* renamed from: q */
    public final Route f25506q;

    public RealConnection4(RealConnectionPool realConnectionPool, Route route) {
        Intrinsics3.checkParameterIsNotNull(realConnectionPool, "connectionPool");
        Intrinsics3.checkParameterIsNotNull(route, "route");
        this.f25506q = route;
        this.f25503n = 1;
        this.f25504o = new ArrayList();
        this.f25505p = RecyclerView.FOREVER_NS;
    }

    @Override // p600f0.p601e0.p608j.Http2Connection.c
    /* renamed from: a */
    public synchronized void mo10192a(Http2Connection http2Connection, Settings3 settings3) {
        Intrinsics3.checkParameterIsNotNull(http2Connection, "connection");
        Intrinsics3.checkParameterIsNotNull(settings3, "settings");
        this.f25503n = (settings3.f25752a & 16) != 0 ? settings3.f25753b[4] : Integer.MAX_VALUE;
    }

    @Override // p600f0.p601e0.p608j.Http2Connection.c
    /* renamed from: b */
    public void mo10193b(Http2Stream http2Stream) throws IOException {
        Intrinsics3.checkParameterIsNotNull(http2Stream, "stream");
        http2Stream.m10284c(ErrorCode2.REFUSED_STREAM, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x015b A[SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m10194c(int i, int i2, int i3, int i4, boolean z2, Call2 call2, EventListener eventListener) throws Throwable {
        Socket socket;
        Socket socket2;
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(eventListener, "eventListener");
        if (!(this.f25494e == null)) {
            throw new IllegalStateException("already connected".toString());
        }
        List<ConnectionSpec> list = this.f25506q.f25370a.f25355c;
        ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(list);
        Address address = this.f25506q.f25370a;
        if (address.f25358f == null) {
            if (!list.contains(ConnectionSpec.f25933d)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String str = this.f25506q.f25370a.f25353a.f25979g;
            Platform2.a aVar = Platform2.f25785c;
            if (!Platform2.f25783a.mo10318h(str)) {
                throw new RouteException(new UnknownServiceException(outline.m886y("CLEARTEXT communication to ", str, " not permitted by network security policy")));
            }
        } else if (address.f25354b.contains(Protocol2.H2_PRIOR_KNOWLEDGE)) {
            throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        RouteException routeException = null;
        do {
            try {
            } catch (IOException e) {
                e = e;
            }
            try {
                if (this.f25506q.m10106a()) {
                    m10197f(i, i2, i3, call2, eventListener);
                    if (this.f25491b == null) {
                        if (!this.f25506q.m10106a() && this.f25491b == null) {
                            throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
                        }
                        this.f25505p = System.nanoTime();
                        return;
                    }
                } else {
                    try {
                        m10196e(i, i2, call2, eventListener);
                    } catch (IOException e2) {
                        e = e2;
                        socket = this.f25492c;
                        if (socket != null) {
                            Util7.m10124e(socket);
                        }
                        socket2 = this.f25491b;
                        if (socket2 != null) {
                            Util7.m10124e(socket2);
                        }
                        this.f25492c = null;
                        this.f25491b = null;
                        this.f25496g = null;
                        this.f25497h = null;
                        this.f25493d = null;
                        this.f25494e = null;
                        this.f25495f = null;
                        this.f25503n = 1;
                        Route route = this.f25506q;
                        InetSocketAddress inetSocketAddress = route.f25372c;
                        Proxy proxy = route.f25371b;
                        Objects.requireNonNull(eventListener);
                        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
                        Intrinsics3.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
                        Intrinsics3.checkParameterIsNotNull(proxy, "proxy");
                        Intrinsics3.checkParameterIsNotNull(e, "ioe");
                        if (routeException != null) {
                            routeException = new RouteException(e);
                        } else {
                            routeException.m10999a(e);
                        }
                        if (z2) {
                            throw routeException;
                        }
                        Intrinsics3.checkParameterIsNotNull(e, "e");
                        connectionSpecSelector.f25435c = true;
                    }
                }
                m10198g(connectionSpecSelector, i4, call2, eventListener);
                Route route2 = this.f25506q;
                InetSocketAddress inetSocketAddress2 = route2.f25372c;
                Proxy proxy2 = route2.f25371b;
                Objects.requireNonNull(eventListener);
                Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
                Intrinsics3.checkParameterIsNotNull(inetSocketAddress2, "inetSocketAddress");
                Intrinsics3.checkParameterIsNotNull(proxy2, "proxy");
                if (!this.f25506q.m10106a()) {
                }
                this.f25505p = System.nanoTime();
                return;
            } catch (IOException e3) {
                e = e3;
                socket = this.f25492c;
                if (socket != null) {
                }
                socket2 = this.f25491b;
                if (socket2 != null) {
                }
                this.f25492c = null;
                this.f25491b = null;
                this.f25496g = null;
                this.f25497h = null;
                this.f25493d = null;
                this.f25494e = null;
                this.f25495f = null;
                this.f25503n = 1;
                Route route3 = this.f25506q;
                InetSocketAddress inetSocketAddress3 = route3.f25372c;
                Proxy proxy3 = route3.f25371b;
                Objects.requireNonNull(eventListener);
                Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
                Intrinsics3.checkParameterIsNotNull(inetSocketAddress3, "inetSocketAddress");
                Intrinsics3.checkParameterIsNotNull(proxy3, "proxy");
                Intrinsics3.checkParameterIsNotNull(e, "ioe");
                if (routeException != null) {
                }
                if (z2) {
                }
            }
        } while ((!connectionSpecSelector.f25434b || (e instanceof ProtocolException) || (e instanceof InterruptedIOException) || ((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) || (e instanceof SSLPeerUnverifiedException) || !(e instanceof SSLException)) ? false : true);
        throw routeException;
    }

    /* renamed from: d */
    public final void m10195d(OkHttpClient okHttpClient, Route route, IOException iOException) {
        Intrinsics3.checkParameterIsNotNull(okHttpClient, "client");
        Intrinsics3.checkParameterIsNotNull(route, "failedRoute");
        Intrinsics3.checkParameterIsNotNull(iOException, "failure");
        if (route.f25371b.type() != Proxy.Type.DIRECT) {
            Address address = route.f25370a;
            address.f25363k.connectFailed(address.f25353a.m10407i(), route.f25371b.address(), iOException);
        }
        RouteDatabase routeDatabase = okHttpClient.f26011O;
        synchronized (routeDatabase) {
            Intrinsics3.checkParameterIsNotNull(route, "failedRoute");
            routeDatabase.f25513a.add(route);
        }
    }

    /* renamed from: e */
    public final void m10196e(int i, int i2, Call2 call2, EventListener eventListener) throws IOException {
        Socket socket;
        int i3;
        Route route = this.f25506q;
        Proxy proxy = route.f25371b;
        Address address = route.f25370a;
        Proxy.Type type = proxy.type();
        if (type != null && ((i3 = C12286f.f25487a[type.ordinal()]) == 1 || i3 == 2)) {
            socket = address.f25357e.createSocket();
            if (socket == null) {
                Intrinsics3.throwNpe();
            }
        } else {
            socket = new Socket(proxy);
        }
        this.f25491b = socket;
        InetSocketAddress inetSocketAddress = this.f25506q.f25372c;
        Objects.requireNonNull(eventListener);
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
        Intrinsics3.checkParameterIsNotNull(proxy, "proxy");
        socket.setSoTimeout(i2);
        try {
            Platform2.a aVar = Platform2.f25785c;
            Platform2.f25783a.mo10320e(socket, this.f25506q.f25372c, i);
            try {
                Source2 source2M4281d1 = C3404f.m4281d1(socket);
                Intrinsics3.checkParameterIsNotNull(source2M4281d1, "$this$buffer");
                this.f25496g = new RealBufferedSource(source2M4281d1);
                Sink sinkM4273b1 = C3404f.m4273b1(socket);
                Intrinsics3.checkParameterIsNotNull(sinkM4273b1, "$this$buffer");
                this.f25497h = new RealBufferedSink(sinkM4273b1);
            } catch (NullPointerException e) {
                if (Intrinsics3.areEqual(e.getMessage(), "throw with null exception")) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            StringBuilder sbM833U = outline.m833U("Failed to connect to ");
            sbM833U.append(this.f25506q.f25372c);
            ConnectException connectException = new ConnectException(sbM833U.toString());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* renamed from: f */
    public final void m10197f(int i, int i2, int i3, Call2 call2, EventListener eventListener) throws IOException {
        Request.C12935a c12935a = new Request.C12935a();
        c12935a.m10984g(this.f25506q.f25370a.f25353a);
        OkHttpClient okHttpClient = null;
        c12935a.m10980c("CONNECT", null);
        boolean z2 = true;
        c12935a.m10979b("Host", Util7.m10144y(this.f25506q.f25370a.f25353a, true));
        c12935a.m10979b("Proxy-Connection", "Keep-Alive");
        c12935a.m10979b("User-Agent", "okhttp/4.8.0");
        Request requestM10978a = c12935a.m10978a();
        Response.C12937a c12937a = new Response.C12937a();
        c12937a.m10997g(requestM10978a);
        c12937a.m10996f(Protocol2.HTTP_1_1);
        c12937a.f27567c = 407;
        c12937a.m10995e("Preemptive Authenticate");
        c12937a.f27571g = Util7.f25399c;
        c12937a.f27575k = -1L;
        c12937a.f27576l = -1L;
        Intrinsics3.checkParameterIsNotNull("Proxy-Authenticate", ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull("OkHttp-Preemptive", "value");
        Headers.C12930a c12930a = c12937a.f27570f;
        Objects.requireNonNull(c12930a);
        Intrinsics3.checkParameterIsNotNull("Proxy-Authenticate", ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull("OkHttp-Preemptive", "value");
        Headers.Companion companion = Headers.INSTANCE;
        companion.m10962a("Proxy-Authenticate");
        companion.m10963b("OkHttp-Preemptive", "Proxy-Authenticate");
        c12930a.m10961d("Proxy-Authenticate");
        c12930a.m10959b("Proxy-Authenticate", "OkHttp-Preemptive");
        Response responseM10991a = c12937a.m10991a();
        Route route = this.f25506q;
        Request requestMo10102a = route.f25370a.f25361i.mo10102a(route, responseM10991a);
        if (requestMo10102a != null) {
            requestM10978a = requestMo10102a;
        }
        HttpUrl httpUrl = requestM10978a.url;
        int i4 = 0;
        while (i4 < 21) {
            m10196e(i, i2, call2, eventListener);
            String str = "CONNECT " + Util7.m10144y(httpUrl, z2) + " HTTP/1.1";
            while (true) {
                BufferedSource bufferedSource = this.f25496g;
                if (bufferedSource == null) {
                    Intrinsics3.throwNpe();
                }
                BufferedSink bufferedSink = this.f25497h;
                if (bufferedSink == null) {
                    Intrinsics3.throwNpe();
                }
                Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(okHttpClient, this, bufferedSource, bufferedSink);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                bufferedSource.timeout().mo10484g(i2, timeUnit);
                bufferedSink.timeout().mo10484g(i3, timeUnit);
                http1ExchangeCodec.m10239k(requestM10978a.headers, str);
                http1ExchangeCodec.f25555g.flush();
                Response.C12937a c12937aMo10216d = http1ExchangeCodec.mo10216d(false);
                if (c12937aMo10216d == null) {
                    Intrinsics3.throwNpe();
                }
                c12937aMo10216d.m10997g(requestM10978a);
                Response responseM10991a2 = c12937aMo10216d.m10991a();
                Intrinsics3.checkParameterIsNotNull(responseM10991a2, "response");
                long jM10131l = Util7.m10131l(responseM10991a2);
                if (jM10131l != -1) {
                    Source2 source2M10238j = http1ExchangeCodec.m10238j(jM10131l);
                    Util7.m10141v(source2M10238j, Integer.MAX_VALUE, timeUnit);
                    ((Http1ExchangeCodec.d) source2M10238j).close();
                }
                int i5 = responseM10991a2.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                if (i5 != 200) {
                    if (i5 != 407) {
                        StringBuilder sbM833U = outline.m833U("Unexpected response code for CONNECT: ");
                        sbM833U.append(responseM10991a2.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String);
                        throw new IOException(sbM833U.toString());
                    }
                    Route route2 = this.f25506q;
                    Request requestMo10102a2 = route2.f25370a.f25361i.mo10102a(route2, responseM10991a2);
                    if (requestMo10102a2 == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                    if (StringsJVM.equals("close", Response.m10989a(responseM10991a2, "Connection", null, 2), true)) {
                        requestM10978a = requestMo10102a2;
                        break;
                    } else {
                        okHttpClient = null;
                        requestM10978a = requestMo10102a2;
                    }
                } else {
                    if (!bufferedSource.mo10457g().mo10472w() || !bufferedSink.mo10457g().mo10472w()) {
                        throw new IOException("TLS tunnel buffered too many bytes!");
                    }
                    requestM10978a = null;
                }
            }
            if (requestM10978a == null) {
                return;
            }
            Socket socket = this.f25491b;
            if (socket != null) {
                Util7.m10124e(socket);
            }
            okHttpClient = null;
            this.f25491b = null;
            this.f25497h = null;
            this.f25496g = null;
            Route route3 = this.f25506q;
            InetSocketAddress inetSocketAddress = route3.f25372c;
            Proxy proxy = route3.f25371b;
            Objects.requireNonNull(eventListener);
            Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
            Intrinsics3.checkParameterIsNotNull(proxy, "proxy");
            i4++;
            z2 = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a A[Catch: all -> 0x019b, TRY_LEAVE, TryCatch #1 {all -> 0x019b, blocks: (B:12:0x0038, B:13:0x003b, B:15:0x004a, B:51:0x0193, B:52:0x019a), top: B:61:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0193 A[Catch: all -> 0x019b, TRY_ENTER, TryCatch #1 {all -> 0x019b, blocks: (B:12:0x0038, B:13:0x003b, B:15:0x004a, B:51:0x0193, B:52:0x019a), top: B:61:0x0038 }] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m10198g(ConnectionSpecSelector connectionSpecSelector, int i, Call2 call2, EventListener eventListener) throws Throwable {
        SSLSocket sSLSocket;
        Socket socketCreateSocket;
        String strMo10317f;
        Protocol2 protocol2M10423a = Protocol2.HTTP_1_1;
        Address address = this.f25506q.f25370a;
        if (address.f25358f == null) {
            List<Protocol2> list = address.f25354b;
            Protocol2 protocol2 = Protocol2.H2_PRIOR_KNOWLEDGE;
            if (!list.contains(protocol2)) {
                this.f25492c = this.f25491b;
                this.f25494e = protocol2M10423a;
                return;
            } else {
                this.f25492c = this.f25491b;
                this.f25494e = protocol2;
                m10206o(i);
                return;
            }
        }
        Objects.requireNonNull(eventListener);
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Address address2 = this.f25506q.f25370a;
        SSLSocketFactory sSLSocketFactory = address2.f25358f;
        if (sSLSocketFactory == null) {
            try {
                Intrinsics3.throwNpe();
                Socket socket = this.f25491b;
                HttpUrl httpUrl = address2.f25353a;
                socketCreateSocket = sSLSocketFactory.createSocket(socket, httpUrl.f25979g, httpUrl.f25980h, true);
                if (socketCreateSocket != null) {
                    throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
                }
                sSLSocket = (SSLSocket) socketCreateSocket;
                try {
                    ConnectionSpec connectionSpecM10166a = connectionSpecSelector.m10166a(sSLSocket);
                    if (connectionSpecM10166a.f25935f) {
                        Platform2.a aVar = Platform2.f25785c;
                        Platform2.f25783a.mo10316d(sSLSocket, address2.f25353a.f25979g, address2.f25354b);
                    }
                    sSLSocket.startHandshake();
                    SSLSession session = sSLSocket.getSession();
                    Intrinsics3.checkExpressionValueIsNotNull(session, "sslSocketSession");
                    Handshake handshakeM10395a = Handshake.m10395a(session);
                    HostnameVerifier hostnameVerifier = address2.f25359g;
                    if (hostnameVerifier == null) {
                        Intrinsics3.throwNpe();
                    }
                    if (hostnameVerifier.verify(address2.f25353a.f25979g, session)) {
                        CertificatePinner certificatePinner = address2.f25360h;
                        if (certificatePinner == null) {
                            Intrinsics3.throwNpe();
                        }
                        this.f25493d = new Handshake(handshakeM10395a.f25970b, handshakeM10395a.f25971c, handshakeM10395a.f25972d, new RealConnection(certificatePinner, handshakeM10395a, address2));
                        certificatePinner.m10368a(address2.f25353a.f25979g, new RealConnection2(this));
                        if (connectionSpecM10166a.f25935f) {
                            Platform2.a aVar2 = Platform2.f25785c;
                            strMo10317f = Platform2.f25783a.mo10317f(sSLSocket);
                        } else {
                            strMo10317f = null;
                        }
                        this.f25492c = sSLSocket;
                        Source2 source2M4281d1 = C3404f.m4281d1(sSLSocket);
                        Intrinsics3.checkParameterIsNotNull(source2M4281d1, "$this$buffer");
                        this.f25496g = new RealBufferedSource(source2M4281d1);
                        Sink sinkM4273b1 = C3404f.m4273b1(sSLSocket);
                        Intrinsics3.checkParameterIsNotNull(sinkM4273b1, "$this$buffer");
                        this.f25497h = new RealBufferedSink(sinkM4273b1);
                        if (strMo10317f != null) {
                            protocol2M10423a = Protocol2.f26062q.m10423a(strMo10317f);
                        }
                        this.f25494e = protocol2M10423a;
                        Platform2.a aVar3 = Platform2.f25785c;
                        Platform2.f25783a.mo10328a(sSLSocket);
                        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
                        if (this.f25494e == Protocol2.HTTP_2) {
                            m10206o(i);
                            return;
                        }
                        return;
                    }
                    List<Certificate> listM10398c = handshakeM10395a.m10398c();
                    if (!(!listM10398c.isEmpty())) {
                        throw new SSLPeerUnverifiedException("Hostname " + address2.f25353a.f25979g + " not verified (no certificates)");
                    }
                    Certificate certificate = listM10398c.get(0);
                    if (certificate == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                    X509Certificate x509Certificate = (X509Certificate) certificate;
                    StringBuilder sb = new StringBuilder();
                    sb.append("\n              |Hostname ");
                    sb.append(address2.f25353a.f25979g);
                    sb.append(" not verified:\n              |    certificate: ");
                    sb.append(CertificatePinner.f25904b.m10370a(x509Certificate));
                    sb.append("\n              |    DN: ");
                    Principal subjectDN = x509Certificate.getSubjectDN();
                    Intrinsics3.checkExpressionValueIsNotNull(subjectDN, "cert.subjectDN");
                    sb.append(subjectDN.getName());
                    sb.append("\n              |    subjectAltNames: ");
                    OkHostnameVerifier okHostnameVerifier = OkHostnameVerifier.f25811a;
                    Intrinsics3.checkParameterIsNotNull(x509Certificate, "certificate");
                    sb.append(_Collections.plus((Collection) okHostnameVerifier.m10343a(x509Certificate, 7), (Iterable) okHostnameVerifier.m10343a(x509Certificate, 2)));
                    sb.append("\n              ");
                    throw new SSLPeerUnverifiedException(Indent.trimMargin$default(sb.toString(), null, 1, null));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                sSLSocket = null;
            }
        } else {
            Socket socket2 = this.f25491b;
            HttpUrl httpUrl2 = address2.f25353a;
            socketCreateSocket = sSLSocketFactory.createSocket(socket2, httpUrl2.f25979g, httpUrl2.f25980h, true);
            if (socketCreateSocket != null) {
            }
        }
        if (sSLSocket != null) {
            Platform2.a aVar4 = Platform2.f25785c;
            Platform2.f25783a.mo10328a(sSLSocket);
        }
        if (sSLSocket != null) {
            Util7.m10124e(sSLSocket);
        }
        throw th;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m10199h(Address address, List<Route> list) {
        boolean z2;
        boolean z3;
        Handshake handshake;
        Intrinsics3.checkParameterIsNotNull(address, "address");
        byte[] bArr = Util7.f25397a;
        if (this.f25504o.size() >= this.f25503n || this.f25498i || !this.f25506q.f25370a.m10101a(address)) {
            return false;
        }
        if (Intrinsics3.areEqual(address.f25353a.f25979g, this.f25506q.f25370a.f25353a.f25979g)) {
            return true;
        }
        if (this.f25495f != null && list != null) {
            if (list.isEmpty()) {
                z2 = false;
                if (z2) {
                    HostnameVerifier hostnameVerifier = address.f25359g;
                    OkHostnameVerifier okHostnameVerifier = OkHostnameVerifier.f25811a;
                    if (hostnameVerifier != okHostnameVerifier) {
                        return false;
                    }
                    HttpUrl httpUrl = address.f25353a;
                    byte[] bArr2 = Util7.f25397a;
                    HttpUrl httpUrl2 = this.f25506q.f25370a.f25353a;
                    if (httpUrl.f25980h == httpUrl2.f25980h) {
                        if (!Intrinsics3.areEqual(httpUrl.f25979g, httpUrl2.f25979g)) {
                            if (!this.f25499j && (handshake = this.f25493d) != null) {
                                List<Certificate> listM10398c = handshake.m10398c();
                                if (!listM10398c.isEmpty()) {
                                    String str = httpUrl.f25979g;
                                    Certificate certificate = listM10398c.get(0);
                                    if (certificate == null) {
                                        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                                    }
                                    boolean z4 = okHostnameVerifier.m10344b(str, (X509Certificate) certificate);
                                    if (z4) {
                                    }
                                    if (z3) {
                                        return false;
                                    }
                                    try {
                                        CertificatePinner certificatePinner = address.f25360h;
                                        if (certificatePinner == null) {
                                            Intrinsics3.throwNpe();
                                        }
                                        String str2 = address.f25353a.f25979g;
                                        Handshake handshake2 = this.f25493d;
                                        if (handshake2 == null) {
                                            Intrinsics3.throwNpe();
                                        }
                                        List<Certificate> listM10398c2 = handshake2.m10398c();
                                        Objects.requireNonNull(certificatePinner);
                                        Intrinsics3.checkParameterIsNotNull(str2, "hostname");
                                        Intrinsics3.checkParameterIsNotNull(listM10398c2, "peerCertificates");
                                        certificatePinner.m10368a(str2, new CertificatePinner2(certificatePinner, listM10398c2, str2));
                                        return true;
                                    } catch (SSLPeerUnverifiedException unused) {
                                    }
                                }
                            }
                            z3 = false;
                            if (z3) {
                            }
                        }
                        z3 = true;
                        if (z3) {
                        }
                    } else {
                        z3 = false;
                        if (z3) {
                        }
                    }
                }
            } else {
                for (Route route : list) {
                    if (route.f25371b.type() == Proxy.Type.DIRECT && this.f25506q.f25371b.type() == Proxy.Type.DIRECT && Intrinsics3.areEqual(this.f25506q.f25372c, route.f25372c)) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                if (z2) {
                }
            }
        }
        return false;
    }

    /* renamed from: i */
    public final boolean m10200i(boolean z2) {
        long j;
        byte[] bArr = Util7.f25397a;
        long jNanoTime = System.nanoTime();
        Socket socket = this.f25491b;
        if (socket == null) {
            Intrinsics3.throwNpe();
        }
        Socket socket2 = this.f25492c;
        if (socket2 == null) {
            Intrinsics3.throwNpe();
        }
        BufferedSource bufferedSource = this.f25496g;
        if (bufferedSource == null) {
            Intrinsics3.throwNpe();
        }
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.f25495f;
        if (http2Connection != null) {
            synchronized (http2Connection) {
                if (http2Connection.f25636r) {
                    return false;
                }
                if (http2Connection.f25617A < http2Connection.f25644z) {
                    if (jNanoTime >= http2Connection.f25619C) {
                        return false;
                    }
                }
                return true;
            }
        }
        synchronized (this) {
            j = jNanoTime - this.f25505p;
        }
        if (j < 10000000000L || !z2) {
            return true;
        }
        Intrinsics3.checkParameterIsNotNull(socket2, "$this$isHealthy");
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                boolean z3 = !bufferedSource.mo10472w();
                socket2.setSoTimeout(soTimeout);
                return z3;
            } catch (Throwable th) {
                socket2.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    /* renamed from: j */
    public final boolean m10201j() {
        return this.f25495f != null;
    }

    /* renamed from: k */
    public final ExchangeCodec m10202k(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain) throws SocketException {
        Intrinsics3.checkParameterIsNotNull(okHttpClient, "client");
        Intrinsics3.checkParameterIsNotNull(realInterceptorChain, "chain");
        Socket socket = this.f25492c;
        if (socket == null) {
            Intrinsics3.throwNpe();
        }
        BufferedSource bufferedSource = this.f25496g;
        if (bufferedSource == null) {
            Intrinsics3.throwNpe();
        }
        BufferedSink bufferedSink = this.f25497h;
        if (bufferedSink == null) {
            Intrinsics3.throwNpe();
        }
        Http2Connection http2Connection = this.f25495f;
        if (http2Connection != null) {
            return new Http2ExchangeCodec(okHttpClient, this, realInterceptorChain, http2Connection);
        }
        socket.setSoTimeout(realInterceptorChain.f25538h);
        Timeout2 timeout2Timeout = bufferedSource.timeout();
        long j = realInterceptorChain.f25538h;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout2Timeout.mo10484g(j, timeUnit);
        bufferedSink.timeout().mo10484g(realInterceptorChain.f25539i, timeUnit);
        return new Http1ExchangeCodec(okHttpClient, this, bufferedSource, bufferedSink);
    }

    /* renamed from: l */
    public final synchronized void m10203l() {
        this.f25498i = true;
    }

    /* renamed from: m */
    public Protocol2 m10204m() {
        Protocol2 protocol2 = this.f25494e;
        if (protocol2 == null) {
            Intrinsics3.throwNpe();
        }
        return protocol2;
    }

    /* renamed from: n */
    public Socket m10205n() {
        Socket socket = this.f25492c;
        if (socket == null) {
            Intrinsics3.throwNpe();
        }
        return socket;
    }

    /* renamed from: o */
    public final void m10206o(int i) throws IOException {
        String strM883w;
        Socket socket = this.f25492c;
        if (socket == null) {
            Intrinsics3.throwNpe();
        }
        BufferedSource bufferedSource = this.f25496g;
        if (bufferedSource == null) {
            Intrinsics3.throwNpe();
        }
        BufferedSink bufferedSink = this.f25497h;
        if (bufferedSink == null) {
            Intrinsics3.throwNpe();
        }
        socket.setSoTimeout(0);
        TaskRunner taskRunner = TaskRunner.f25420a;
        Http2Connection.b bVar = new Http2Connection.b(true, taskRunner);
        String str = this.f25506q.f25370a.f25353a.f25979g;
        Intrinsics3.checkParameterIsNotNull(socket, "socket");
        Intrinsics3.checkParameterIsNotNull(str, "peerName");
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
        Intrinsics3.checkParameterIsNotNull(bufferedSink, "sink");
        bVar.f25647a = socket;
        if (bVar.f25654h) {
            strM883w = Util7.f25403g + ' ' + str;
        } else {
            strM883w = outline.m883w("MockWebServer ", str);
        }
        bVar.f25648b = strM883w;
        bVar.f25649c = bufferedSource;
        bVar.f25650d = bufferedSink;
        Intrinsics3.checkParameterIsNotNull(this, "listener");
        bVar.f25651e = this;
        bVar.f25653g = i;
        Http2Connection http2Connection = new Http2Connection(bVar);
        this.f25495f = http2Connection;
        Http2Connection http2Connection2 = Http2Connection.f25616k;
        Settings3 settings3 = Http2Connection.f25615j;
        this.f25503n = (settings3.f25752a & 16) != 0 ? settings3.f25753b[4] : Integer.MAX_VALUE;
        Intrinsics3.checkParameterIsNotNull(taskRunner, "taskRunner");
        Http2Writer http2Writer = http2Connection.f25627K;
        synchronized (http2Writer) {
            if (http2Writer.f25740m) {
                throw new IOException("closed");
            }
            if (http2Writer.f25743p) {
                Logger logger = Http2Writer.f25737j;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Util7.m10129j(">> CONNECTION " + Http2.f25610a.mo10503k(), new Object[0]));
                }
                http2Writer.f25742o.mo10455e0(Http2.f25610a);
                http2Writer.f25742o.flush();
            }
        }
        Http2Writer http2Writer2 = http2Connection.f25627K;
        Settings3 settings32 = http2Connection.f25620D;
        synchronized (http2Writer2) {
            Intrinsics3.checkParameterIsNotNull(settings32, "settings");
            if (http2Writer2.f25740m) {
                throw new IOException("closed");
            }
            http2Writer2.m10300c(0, Integer.bitCount(settings32.f25752a) * 6, 4, 0);
            int i2 = 0;
            while (i2 < 10) {
                if (((1 << i2) & settings32.f25752a) != 0) {
                    http2Writer2.f25742o.writeShort(i2 != 4 ? i2 != 7 ? i2 : 4 : 3);
                    http2Writer2.f25742o.writeInt(settings32.f25753b[i2]);
                }
                i2++;
            }
            http2Writer2.f25742o.flush();
        }
        if (http2Connection.f25620D.m10312a() != 65535) {
            http2Connection.f25627K.m10305q(0, r0 - 65535);
        }
        TaskQueue2 taskQueue2M10162f = taskRunner.m10162f();
        String str2 = http2Connection.f25633o;
        taskQueue2M10162f.m10154c(new TaskQueue(http2Connection.f25628L, str2, true, str2, true), 0L);
    }

    public String toString() {
        Object obj;
        StringBuilder sbM833U = outline.m833U("Connection{");
        sbM833U.append(this.f25506q.f25370a.f25353a.f25979g);
        sbM833U.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        sbM833U.append(this.f25506q.f25370a.f25353a.f25980h);
        sbM833U.append(',');
        sbM833U.append(" proxy=");
        sbM833U.append(this.f25506q.f25371b);
        sbM833U.append(" hostAddress=");
        sbM833U.append(this.f25506q.f25372c);
        sbM833U.append(" cipherSuite=");
        Handshake handshake = this.f25493d;
        if (handshake == null || (obj = handshake.f25971c) == null) {
            obj = "none";
        }
        sbM833U.append(obj);
        sbM833U.append(" protocol=");
        sbM833U.append(this.f25494e);
        sbM833U.append('}');
        return sbM833U.toString();
    }
}
