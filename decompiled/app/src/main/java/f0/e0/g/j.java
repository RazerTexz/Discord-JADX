package f0.e0.g;

import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.t.u;
import f0.c0;
import f0.e0.i.b;
import f0.e0.j.e;
import f0.e0.j.o;
import f0.e0.j.s;
import f0.e0.k.h;
import f0.t;
import f0.v;
import f0.w;
import f0.x;
import f0.y;
import g0.q;
import g0.r;
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

/* compiled from: RealConnection.kt */
/* loaded from: classes3.dex */
public final class j extends e.c implements f0.k {

    /* renamed from: b, reason: collision with root package name */
    public Socket f3620b;
    public Socket c;
    public v d;
    public y e;
    public f0.e0.j.e f;
    public g0.g g;
    public BufferedSink h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    public final List<Reference<e>> o;
    public long p;
    public final c0 q;

    public j(k kVar, c0 c0Var) {
        d0.z.d.m.checkParameterIsNotNull(kVar, "connectionPool");
        d0.z.d.m.checkParameterIsNotNull(c0Var, "route");
        this.q = c0Var;
        this.n = 1;
        this.o = new ArrayList();
        this.p = RecyclerView.FOREVER_NS;
    }

    @Override // f0.e0.j.e.c
    public synchronized void a(f0.e0.j.e eVar, s sVar) {
        d0.z.d.m.checkParameterIsNotNull(eVar, "connection");
        d0.z.d.m.checkParameterIsNotNull(sVar, "settings");
        this.n = (sVar.a & 16) != 0 ? sVar.f3647b[4] : Integer.MAX_VALUE;
    }

    @Override // f0.e0.j.e.c
    public void b(f0.e0.j.n nVar) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(nVar, "stream");
        nVar.c(f0.e0.j.a.REFUSED_STREAM, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x015b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(int i, int i2, int i3, int i4, boolean z2, f0.e eVar, t tVar) throws Throwable {
        Socket socket;
        Socket socket2;
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        d0.z.d.m.checkParameterIsNotNull(tVar, "eventListener");
        if (!(this.e == null)) {
            throw new IllegalStateException("already connected".toString());
        }
        List<f0.m> list = this.q.a.c;
        b bVar = new b(list);
        f0.a aVar = this.q.a;
        if (aVar.f == null) {
            if (!list.contains(f0.m.d)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String str = this.q.a.a.g;
            h.a aVar2 = f0.e0.k.h.c;
            if (!f0.e0.k.h.a.h(str)) {
                throw new RouteException(new UnknownServiceException(b.d.b.a.a.y("CLEARTEXT communication to ", str, " not permitted by network security policy")));
            }
        } else if (aVar.f3601b.contains(y.H2_PRIOR_KNOWLEDGE)) {
            throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        RouteException routeException = null;
        do {
            try {
            } catch (IOException e) {
                e = e;
            }
            try {
                if (this.q.a()) {
                    f(i, i2, i3, eVar, tVar);
                    if (this.f3620b == null) {
                        if (!this.q.a() && this.f3620b == null) {
                            throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
                        }
                        this.p = System.nanoTime();
                        return;
                    }
                } else {
                    try {
                        e(i, i2, eVar, tVar);
                    } catch (IOException e2) {
                        e = e2;
                        socket = this.c;
                        if (socket != null) {
                            f0.e0.c.e(socket);
                        }
                        socket2 = this.f3620b;
                        if (socket2 != null) {
                            f0.e0.c.e(socket2);
                        }
                        this.c = null;
                        this.f3620b = null;
                        this.g = null;
                        this.h = null;
                        this.d = null;
                        this.e = null;
                        this.f = null;
                        this.n = 1;
                        c0 c0Var = this.q;
                        InetSocketAddress inetSocketAddress = c0Var.c;
                        Proxy proxy = c0Var.f3603b;
                        Objects.requireNonNull(tVar);
                        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                        d0.z.d.m.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
                        d0.z.d.m.checkParameterIsNotNull(proxy, "proxy");
                        d0.z.d.m.checkParameterIsNotNull(e, "ioe");
                        if (routeException != null) {
                            routeException = new RouteException(e);
                        } else {
                            routeException.a(e);
                        }
                        if (z2) {
                            throw routeException;
                        }
                        d0.z.d.m.checkParameterIsNotNull(e, "e");
                        bVar.c = true;
                    }
                }
                g(bVar, i4, eVar, tVar);
                c0 c0Var2 = this.q;
                InetSocketAddress inetSocketAddress2 = c0Var2.c;
                Proxy proxy2 = c0Var2.f3603b;
                Objects.requireNonNull(tVar);
                d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                d0.z.d.m.checkParameterIsNotNull(inetSocketAddress2, "inetSocketAddress");
                d0.z.d.m.checkParameterIsNotNull(proxy2, "proxy");
                if (!this.q.a()) {
                }
                this.p = System.nanoTime();
                return;
            } catch (IOException e3) {
                e = e3;
                socket = this.c;
                if (socket != null) {
                }
                socket2 = this.f3620b;
                if (socket2 != null) {
                }
                this.c = null;
                this.f3620b = null;
                this.g = null;
                this.h = null;
                this.d = null;
                this.e = null;
                this.f = null;
                this.n = 1;
                c0 c0Var3 = this.q;
                InetSocketAddress inetSocketAddress3 = c0Var3.c;
                Proxy proxy3 = c0Var3.f3603b;
                Objects.requireNonNull(tVar);
                d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                d0.z.d.m.checkParameterIsNotNull(inetSocketAddress3, "inetSocketAddress");
                d0.z.d.m.checkParameterIsNotNull(proxy3, "proxy");
                d0.z.d.m.checkParameterIsNotNull(e, "ioe");
                if (routeException != null) {
                }
                if (z2) {
                }
            }
        } while ((!bVar.f3613b || (e instanceof ProtocolException) || (e instanceof InterruptedIOException) || ((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) || (e instanceof SSLPeerUnverifiedException) || !(e instanceof SSLException)) ? false : true);
        throw routeException;
    }

    public final void d(x xVar, c0 c0Var, IOException iOException) {
        d0.z.d.m.checkParameterIsNotNull(xVar, "client");
        d0.z.d.m.checkParameterIsNotNull(c0Var, "failedRoute");
        d0.z.d.m.checkParameterIsNotNull(iOException, "failure");
        if (c0Var.f3603b.type() != Proxy.Type.DIRECT) {
            f0.a aVar = c0Var.a;
            aVar.k.connectFailed(aVar.a.i(), c0Var.f3603b.address(), iOException);
        }
        l lVar = xVar.O;
        synchronized (lVar) {
            d0.z.d.m.checkParameterIsNotNull(c0Var, "failedRoute");
            lVar.a.add(c0Var);
        }
    }

    public final void e(int i, int i2, f0.e eVar, t tVar) throws IOException {
        Socket socket;
        int i3;
        c0 c0Var = this.q;
        Proxy proxy = c0Var.f3603b;
        f0.a aVar = c0Var.a;
        Proxy.Type type = proxy.type();
        if (type != null && ((i3 = f.a[type.ordinal()]) == 1 || i3 == 2)) {
            socket = aVar.e.createSocket();
            if (socket == null) {
                d0.z.d.m.throwNpe();
            }
        } else {
            socket = new Socket(proxy);
        }
        this.f3620b = socket;
        InetSocketAddress inetSocketAddress = this.q.c;
        Objects.requireNonNull(tVar);
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        d0.z.d.m.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
        d0.z.d.m.checkParameterIsNotNull(proxy, "proxy");
        socket.setSoTimeout(i2);
        try {
            h.a aVar2 = f0.e0.k.h.c;
            f0.e0.k.h.a.e(socket, this.q.c, i);
            try {
                g0.x xVarD1 = b.i.a.f.e.o.f.d1(socket);
                d0.z.d.m.checkParameterIsNotNull(xVarD1, "$this$buffer");
                this.g = new r(xVarD1);
                g0.v vVarB1 = b.i.a.f.e.o.f.b1(socket);
                d0.z.d.m.checkParameterIsNotNull(vVarB1, "$this$buffer");
                this.h = new q(vVarB1);
            } catch (NullPointerException e) {
                if (d0.z.d.m.areEqual(e.getMessage(), "throw with null exception")) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            StringBuilder sbU = b.d.b.a.a.U("Failed to connect to ");
            sbU.append(this.q.c);
            ConnectException connectException = new ConnectException(sbU.toString());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    public final void f(int i, int i2, int i3, f0.e eVar, t tVar) throws IOException {
        Request.a aVar = new Request.a();
        aVar.g(this.q.a.a);
        x xVar = null;
        aVar.c("CONNECT", null);
        boolean z2 = true;
        aVar.b("Host", f0.e0.c.y(this.q.a.a, true));
        aVar.b("Proxy-Connection", "Keep-Alive");
        aVar.b("User-Agent", "okhttp/4.8.0");
        Request requestA = aVar.a();
        Response.a aVar2 = new Response.a();
        aVar2.g(requestA);
        aVar2.f(y.HTTP_1_1);
        aVar2.c = 407;
        aVar2.e("Preemptive Authenticate");
        aVar2.g = f0.e0.c.c;
        aVar2.k = -1L;
        aVar2.l = -1L;
        d0.z.d.m.checkParameterIsNotNull("Proxy-Authenticate", ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkParameterIsNotNull("OkHttp-Preemptive", "value");
        Headers.a aVar3 = aVar2.f;
        Objects.requireNonNull(aVar3);
        d0.z.d.m.checkParameterIsNotNull("Proxy-Authenticate", ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkParameterIsNotNull("OkHttp-Preemptive", "value");
        Headers.Companion companion = Headers.INSTANCE;
        companion.a("Proxy-Authenticate");
        companion.b("OkHttp-Preemptive", "Proxy-Authenticate");
        aVar3.d("Proxy-Authenticate");
        aVar3.b("Proxy-Authenticate", "OkHttp-Preemptive");
        Response responseA = aVar2.a();
        c0 c0Var = this.q;
        Request requestA2 = c0Var.a.i.a(c0Var, responseA);
        if (requestA2 != null) {
            requestA = requestA2;
        }
        w wVar = requestA.url;
        int i4 = 0;
        while (i4 < 21) {
            e(i, i2, eVar, tVar);
            String str = "CONNECT " + f0.e0.c.y(wVar, z2) + " HTTP/1.1";
            while (true) {
                g0.g gVar = this.g;
                if (gVar == null) {
                    d0.z.d.m.throwNpe();
                }
                BufferedSink bufferedSink = this.h;
                if (bufferedSink == null) {
                    d0.z.d.m.throwNpe();
                }
                f0.e0.i.b bVar = new f0.e0.i.b(xVar, this, gVar, bufferedSink);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                gVar.timeout().g(i2, timeUnit);
                bufferedSink.timeout().g(i3, timeUnit);
                bVar.k(requestA.headers, str);
                bVar.g.flush();
                Response.a aVarD = bVar.d(false);
                if (aVarD == null) {
                    d0.z.d.m.throwNpe();
                }
                aVarD.g(requestA);
                Response responseA2 = aVarD.a();
                d0.z.d.m.checkParameterIsNotNull(responseA2, "response");
                long jL = f0.e0.c.l(responseA2);
                if (jL != -1) {
                    g0.x xVarJ = bVar.j(jL);
                    f0.e0.c.v(xVarJ, Integer.MAX_VALUE, timeUnit);
                    ((b.d) xVarJ).close();
                }
                int i5 = responseA2.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                if (i5 != 200) {
                    if (i5 != 407) {
                        StringBuilder sbU = b.d.b.a.a.U("Unexpected response code for CONNECT: ");
                        sbU.append(responseA2.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String);
                        throw new IOException(sbU.toString());
                    }
                    c0 c0Var2 = this.q;
                    Request requestA3 = c0Var2.a.i.a(c0Var2, responseA2);
                    if (requestA3 == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                    if (d0.g0.t.equals("close", Response.a(responseA2, "Connection", null, 2), true)) {
                        requestA = requestA3;
                        break;
                    } else {
                        xVar = null;
                        requestA = requestA3;
                    }
                } else {
                    if (!gVar.g().w() || !bufferedSink.g().w()) {
                        throw new IOException("TLS tunnel buffered too many bytes!");
                    }
                    requestA = null;
                }
            }
            if (requestA == null) {
                return;
            }
            Socket socket = this.f3620b;
            if (socket != null) {
                f0.e0.c.e(socket);
            }
            xVar = null;
            this.f3620b = null;
            this.h = null;
            this.g = null;
            c0 c0Var3 = this.q;
            InetSocketAddress inetSocketAddress = c0Var3.c;
            Proxy proxy = c0Var3.f3603b;
            Objects.requireNonNull(tVar);
            d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            d0.z.d.m.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
            d0.z.d.m.checkParameterIsNotNull(proxy, "proxy");
            i4++;
            z2 = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a A[Catch: all -> 0x019b, TRY_LEAVE, TryCatch #1 {all -> 0x019b, blocks: (B:12:0x0038, B:13:0x003b, B:15:0x004a, B:51:0x0193, B:52:0x019a), top: B:61:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0193 A[Catch: all -> 0x019b, TRY_ENTER, TryCatch #1 {all -> 0x019b, blocks: (B:12:0x0038, B:13:0x003b, B:15:0x004a, B:51:0x0193, B:52:0x019a), top: B:61:0x0038 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(b bVar, int i, f0.e eVar, t tVar) throws Throwable {
        SSLSocket sSLSocket;
        Socket socketCreateSocket;
        String strF;
        y yVarA = y.HTTP_1_1;
        f0.a aVar = this.q.a;
        if (aVar.f == null) {
            List<y> list = aVar.f3601b;
            y yVar = y.H2_PRIOR_KNOWLEDGE;
            if (!list.contains(yVar)) {
                this.c = this.f3620b;
                this.e = yVarA;
                return;
            } else {
                this.c = this.f3620b;
                this.e = yVar;
                o(i);
                return;
            }
        }
        Objects.requireNonNull(tVar);
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        f0.a aVar2 = this.q.a;
        SSLSocketFactory sSLSocketFactory = aVar2.f;
        if (sSLSocketFactory == null) {
            try {
                d0.z.d.m.throwNpe();
                Socket socket = this.f3620b;
                w wVar = aVar2.a;
                socketCreateSocket = sSLSocketFactory.createSocket(socket, wVar.g, wVar.h, true);
                if (socketCreateSocket != null) {
                    throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
                }
                sSLSocket = (SSLSocket) socketCreateSocket;
                try {
                    f0.m mVarA = bVar.a(sSLSocket);
                    if (mVarA.f) {
                        h.a aVar3 = f0.e0.k.h.c;
                        f0.e0.k.h.a.d(sSLSocket, aVar2.a.g, aVar2.f3601b);
                    }
                    sSLSocket.startHandshake();
                    SSLSession session = sSLSocket.getSession();
                    d0.z.d.m.checkExpressionValueIsNotNull(session, "sslSocketSession");
                    v vVarA = v.a(session);
                    HostnameVerifier hostnameVerifier = aVar2.g;
                    if (hostnameVerifier == null) {
                        d0.z.d.m.throwNpe();
                    }
                    if (hostnameVerifier.verify(aVar2.a.g, session)) {
                        f0.g gVar = aVar2.h;
                        if (gVar == null) {
                            d0.z.d.m.throwNpe();
                        }
                        this.d = new v(vVarA.f3680b, vVarA.c, vVarA.d, new g(gVar, vVarA, aVar2));
                        gVar.a(aVar2.a.g, new h(this));
                        if (mVarA.f) {
                            h.a aVar4 = f0.e0.k.h.c;
                            strF = f0.e0.k.h.a.f(sSLSocket);
                        } else {
                            strF = null;
                        }
                        this.c = sSLSocket;
                        g0.x xVarD1 = b.i.a.f.e.o.f.d1(sSLSocket);
                        d0.z.d.m.checkParameterIsNotNull(xVarD1, "$this$buffer");
                        this.g = new r(xVarD1);
                        g0.v vVarB1 = b.i.a.f.e.o.f.b1(sSLSocket);
                        d0.z.d.m.checkParameterIsNotNull(vVarB1, "$this$buffer");
                        this.h = new q(vVarB1);
                        if (strF != null) {
                            yVarA = y.q.a(strF);
                        }
                        this.e = yVarA;
                        h.a aVar5 = f0.e0.k.h.c;
                        f0.e0.k.h.a.a(sSLSocket);
                        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                        if (this.e == y.HTTP_2) {
                            o(i);
                            return;
                        }
                        return;
                    }
                    List<Certificate> listC = vVarA.c();
                    if (!(!listC.isEmpty())) {
                        throw new SSLPeerUnverifiedException("Hostname " + aVar2.a.g + " not verified (no certificates)");
                    }
                    Certificate certificate = listC.get(0);
                    if (certificate == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                    X509Certificate x509Certificate = (X509Certificate) certificate;
                    StringBuilder sb = new StringBuilder();
                    sb.append("\n              |Hostname ");
                    sb.append(aVar2.a.g);
                    sb.append(" not verified:\n              |    certificate: ");
                    sb.append(f0.g.f3670b.a(x509Certificate));
                    sb.append("\n              |    DN: ");
                    Principal subjectDN = x509Certificate.getSubjectDN();
                    d0.z.d.m.checkExpressionValueIsNotNull(subjectDN, "cert.subjectDN");
                    sb.append(subjectDN.getName());
                    sb.append("\n              |    subjectAltNames: ");
                    f0.e0.m.d dVar = f0.e0.m.d.a;
                    d0.z.d.m.checkParameterIsNotNull(x509Certificate, "certificate");
                    sb.append(u.plus((Collection) dVar.a(x509Certificate, 7), (Iterable) dVar.a(x509Certificate, 2)));
                    sb.append("\n              ");
                    throw new SSLPeerUnverifiedException(d0.g0.m.trimMargin$default(sb.toString(), null, 1, null));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                sSLSocket = null;
            }
        } else {
            Socket socket2 = this.f3620b;
            w wVar2 = aVar2.a;
            socketCreateSocket = sSLSocketFactory.createSocket(socket2, wVar2.g, wVar2.h, true);
            if (socketCreateSocket != null) {
            }
        }
        if (sSLSocket != null) {
            h.a aVar6 = f0.e0.k.h.c;
            f0.e0.k.h.a.a(sSLSocket);
        }
        if (sSLSocket != null) {
            f0.e0.c.e(sSLSocket);
        }
        throw th;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean h(f0.a aVar, List<c0> list) {
        boolean z2;
        boolean z3;
        v vVar;
        d0.z.d.m.checkParameterIsNotNull(aVar, "address");
        byte[] bArr = f0.e0.c.a;
        if (this.o.size() >= this.n || this.i || !this.q.a.a(aVar)) {
            return false;
        }
        if (d0.z.d.m.areEqual(aVar.a.g, this.q.a.a.g)) {
            return true;
        }
        if (this.f != null && list != null) {
            if (list.isEmpty()) {
                z2 = false;
                if (z2) {
                    HostnameVerifier hostnameVerifier = aVar.g;
                    f0.e0.m.d dVar = f0.e0.m.d.a;
                    if (hostnameVerifier != dVar) {
                        return false;
                    }
                    w wVar = aVar.a;
                    byte[] bArr2 = f0.e0.c.a;
                    w wVar2 = this.q.a.a;
                    if (wVar.h == wVar2.h) {
                        if (!d0.z.d.m.areEqual(wVar.g, wVar2.g)) {
                            if (!this.j && (vVar = this.d) != null) {
                                List<Certificate> listC = vVar.c();
                                if (!listC.isEmpty()) {
                                    String str = wVar.g;
                                    Certificate certificate = listC.get(0);
                                    if (certificate == null) {
                                        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                                    }
                                    boolean z4 = dVar.b(str, (X509Certificate) certificate);
                                    if (z4) {
                                    }
                                    if (z3) {
                                        return false;
                                    }
                                    try {
                                        f0.g gVar = aVar.h;
                                        if (gVar == null) {
                                            d0.z.d.m.throwNpe();
                                        }
                                        String str2 = aVar.a.g;
                                        v vVar2 = this.d;
                                        if (vVar2 == null) {
                                            d0.z.d.m.throwNpe();
                                        }
                                        List<Certificate> listC2 = vVar2.c();
                                        Objects.requireNonNull(gVar);
                                        d0.z.d.m.checkParameterIsNotNull(str2, "hostname");
                                        d0.z.d.m.checkParameterIsNotNull(listC2, "peerCertificates");
                                        gVar.a(str2, new f0.h(gVar, listC2, str2));
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
                for (c0 c0Var : list) {
                    if (c0Var.f3603b.type() == Proxy.Type.DIRECT && this.q.f3603b.type() == Proxy.Type.DIRECT && d0.z.d.m.areEqual(this.q.c, c0Var.c)) {
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

    public final boolean i(boolean z2) {
        long j;
        byte[] bArr = f0.e0.c.a;
        long jNanoTime = System.nanoTime();
        Socket socket = this.f3620b;
        if (socket == null) {
            d0.z.d.m.throwNpe();
        }
        Socket socket2 = this.c;
        if (socket2 == null) {
            d0.z.d.m.throwNpe();
        }
        g0.g gVar = this.g;
        if (gVar == null) {
            d0.z.d.m.throwNpe();
        }
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        f0.e0.j.e eVar = this.f;
        if (eVar != null) {
            synchronized (eVar) {
                if (eVar.r) {
                    return false;
                }
                if (eVar.A < eVar.f3641z) {
                    if (jNanoTime >= eVar.C) {
                        return false;
                    }
                }
                return true;
            }
        }
        synchronized (this) {
            j = jNanoTime - this.p;
        }
        if (j < 10000000000L || !z2) {
            return true;
        }
        d0.z.d.m.checkParameterIsNotNull(socket2, "$this$isHealthy");
        d0.z.d.m.checkParameterIsNotNull(gVar, "source");
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                boolean z3 = !gVar.w();
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

    public final boolean j() {
        return this.f != null;
    }

    public final f0.e0.h.d k(x xVar, f0.e0.h.g gVar) throws SocketException {
        d0.z.d.m.checkParameterIsNotNull(xVar, "client");
        d0.z.d.m.checkParameterIsNotNull(gVar, "chain");
        Socket socket = this.c;
        if (socket == null) {
            d0.z.d.m.throwNpe();
        }
        g0.g gVar2 = this.g;
        if (gVar2 == null) {
            d0.z.d.m.throwNpe();
        }
        BufferedSink bufferedSink = this.h;
        if (bufferedSink == null) {
            d0.z.d.m.throwNpe();
        }
        f0.e0.j.e eVar = this.f;
        if (eVar != null) {
            return new f0.e0.j.l(xVar, this, gVar, eVar);
        }
        socket.setSoTimeout(gVar.h);
        g0.y yVarTimeout = gVar2.timeout();
        long j = gVar.h;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        yVarTimeout.g(j, timeUnit);
        bufferedSink.timeout().g(gVar.i, timeUnit);
        return new f0.e0.i.b(xVar, this, gVar2, bufferedSink);
    }

    public final synchronized void l() {
        this.i = true;
    }

    public y m() {
        y yVar = this.e;
        if (yVar == null) {
            d0.z.d.m.throwNpe();
        }
        return yVar;
    }

    public Socket n() {
        Socket socket = this.c;
        if (socket == null) {
            d0.z.d.m.throwNpe();
        }
        return socket;
    }

    public final void o(int i) throws IOException {
        String strW;
        Socket socket = this.c;
        if (socket == null) {
            d0.z.d.m.throwNpe();
        }
        g0.g gVar = this.g;
        if (gVar == null) {
            d0.z.d.m.throwNpe();
        }
        BufferedSink bufferedSink = this.h;
        if (bufferedSink == null) {
            d0.z.d.m.throwNpe();
        }
        socket.setSoTimeout(0);
        f0.e0.f.d dVar = f0.e0.f.d.a;
        e.b bVar = new e.b(true, dVar);
        String str = this.q.a.a.g;
        d0.z.d.m.checkParameterIsNotNull(socket, "socket");
        d0.z.d.m.checkParameterIsNotNull(str, "peerName");
        d0.z.d.m.checkParameterIsNotNull(gVar, "source");
        d0.z.d.m.checkParameterIsNotNull(bufferedSink, "sink");
        bVar.a = socket;
        if (bVar.h) {
            strW = f0.e0.c.g + ' ' + str;
        } else {
            strW = b.d.b.a.a.w("MockWebServer ", str);
        }
        bVar.f3642b = strW;
        bVar.c = gVar;
        bVar.d = bufferedSink;
        d0.z.d.m.checkParameterIsNotNull(this, "listener");
        bVar.e = this;
        bVar.g = i;
        f0.e0.j.e eVar = new f0.e0.j.e(bVar);
        this.f = eVar;
        f0.e0.j.e eVar2 = f0.e0.j.e.k;
        s sVar = f0.e0.j.e.j;
        this.n = (sVar.a & 16) != 0 ? sVar.f3647b[4] : Integer.MAX_VALUE;
        d0.z.d.m.checkParameterIsNotNull(dVar, "taskRunner");
        o oVar = eVar.K;
        synchronized (oVar) {
            if (oVar.m) {
                throw new IOException("closed");
            }
            if (oVar.p) {
                Logger logger = o.j;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(f0.e0.c.j(">> CONNECTION " + f0.e0.j.d.a.k(), new Object[0]));
                }
                oVar.o.e0(f0.e0.j.d.a);
                oVar.o.flush();
            }
        }
        o oVar2 = eVar.K;
        s sVar2 = eVar.D;
        synchronized (oVar2) {
            d0.z.d.m.checkParameterIsNotNull(sVar2, "settings");
            if (oVar2.m) {
                throw new IOException("closed");
            }
            oVar2.c(0, Integer.bitCount(sVar2.a) * 6, 4, 0);
            int i2 = 0;
            while (i2 < 10) {
                if (((1 << i2) & sVar2.a) != 0) {
                    oVar2.o.writeShort(i2 != 4 ? i2 != 7 ? i2 : 4 : 3);
                    oVar2.o.writeInt(sVar2.f3647b[i2]);
                }
                i2++;
            }
            oVar2.o.flush();
        }
        if (eVar.D.a() != 65535) {
            eVar.K.q(0, r0 - 65535);
        }
        f0.e0.f.c cVarF = dVar.f();
        String str2 = eVar.o;
        cVarF.c(new f0.e0.f.b(eVar.L, str2, true, str2, true), 0L);
    }

    public String toString() {
        Object obj;
        StringBuilder sbU = b.d.b.a.a.U("Connection{");
        sbU.append(this.q.a.a.g);
        sbU.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        sbU.append(this.q.a.a.h);
        sbU.append(',');
        sbU.append(" proxy=");
        sbU.append(this.q.f3603b);
        sbU.append(" hostAddress=");
        sbU.append(this.q.c);
        sbU.append(" cipherSuite=");
        v vVar = this.d;
        if (vVar == null || (obj = vVar.c) == null) {
            obj = "none";
        }
        sbU.append(obj);
        sbU.append(" protocol=");
        sbU.append(this.e);
        sbU.append('}');
        return sbU.toString();
    }
}
