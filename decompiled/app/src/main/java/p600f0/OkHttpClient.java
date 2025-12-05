package p600f0;

import com.discord.api.permission.Permission;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.MutableCollections;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Call2;
import p600f0.EventListener;
import p600f0.p601e0.Util5;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p604f.TaskRunner;
import p600f0.p601e0.p605g.RealCall;
import p600f0.p601e0.p605g.RouteDatabase;
import p600f0.p601e0.p609k.Platform2;
import p600f0.p601e0.p611l.NullProxySelector;
import p600f0.p601e0.p612m.CertificateChainCleaner;
import p600f0.p601e0.p612m.OkHostnameVerifier;
import p600f0.p601e0.p613n.RealWebSocket;
import p600f0.p601e0.p613n.RealWebSocket2;

/* compiled from: OkHttpClient.kt */
/* renamed from: f0.x, reason: use source file name */
/* loaded from: classes3.dex */
public class OkHttpClient implements Cloneable, Call2.a {

    /* renamed from: A */
    public final SocketFactory f25997A;

    /* renamed from: B */
    public final SSLSocketFactory f25998B;

    /* renamed from: C */
    public final X509TrustManager f25999C;

    /* renamed from: D */
    public final List<ConnectionSpec> f26000D;

    /* renamed from: E */
    public final List<Protocol2> f26001E;

    /* renamed from: F */
    public final HostnameVerifier f26002F;

    /* renamed from: G */
    public final CertificatePinner f26003G;

    /* renamed from: H */
    public final CertificateChainCleaner f26004H;

    /* renamed from: I */
    public final int f26005I;

    /* renamed from: J */
    public final int f26006J;

    /* renamed from: K */
    public final int f26007K;

    /* renamed from: L */
    public final int f26008L;

    /* renamed from: M */
    public final int f26009M;

    /* renamed from: N */
    public final long f26010N;

    /* renamed from: O */
    public final RouteDatabase f26011O;

    /* renamed from: m */
    public final Dispatcher2 f26012m;

    /* renamed from: n */
    public final ConnectionPool f26013n;

    /* renamed from: o */
    public final List<Interceptor> f26014o;

    /* renamed from: p */
    public final List<Interceptor> f26015p;

    /* renamed from: q */
    public final EventListener.b f26016q;

    /* renamed from: r */
    public final boolean f26017r;

    /* renamed from: s */
    public final Authenticator2 f26018s;

    /* renamed from: t */
    public final boolean f26019t;

    /* renamed from: u */
    public final boolean f26020u;

    /* renamed from: v */
    public final CookieJar2 f26021v;

    /* renamed from: w */
    public final Dns2 f26022w;

    /* renamed from: x */
    public final Proxy f26023x;

    /* renamed from: y */
    public final ProxySelector f26024y;

    /* renamed from: z */
    public final Authenticator2 f26025z;

    /* renamed from: l */
    public static final b f25996l = new b(null);

    /* renamed from: j */
    public static final List<Protocol2> f25994j = Util7.m10132m(Protocol2.HTTP_2, Protocol2.HTTP_1_1);

    /* renamed from: k */
    public static final List<ConnectionSpec> f25995k = Util7.m10132m(ConnectionSpec.f25932c, ConnectionSpec.f25933d);

    /* compiled from: OkHttpClient.kt */
    /* renamed from: f0.x$a */
    public static final class a {

        /* renamed from: A */
        public int f26026A;

        /* renamed from: B */
        public long f26027B;

        /* renamed from: C */
        public RouteDatabase f26028C;

        /* renamed from: a */
        public Dispatcher2 f26029a = new Dispatcher2();

        /* renamed from: b */
        public ConnectionPool f26030b = new ConnectionPool();

        /* renamed from: c */
        public final List<Interceptor> f26031c = new ArrayList();

        /* renamed from: d */
        public final List<Interceptor> f26032d = new ArrayList();

        /* renamed from: e */
        public EventListener.b f26033e;

        /* renamed from: f */
        public boolean f26034f;

        /* renamed from: g */
        public Authenticator2 f26035g;

        /* renamed from: h */
        public boolean f26036h;

        /* renamed from: i */
        public boolean f26037i;

        /* renamed from: j */
        public CookieJar2 f26038j;

        /* renamed from: k */
        public Dns2 f26039k;

        /* renamed from: l */
        public Proxy f26040l;

        /* renamed from: m */
        public ProxySelector f26041m;

        /* renamed from: n */
        public Authenticator2 f26042n;

        /* renamed from: o */
        public SocketFactory f26043o;

        /* renamed from: p */
        public SSLSocketFactory f26044p;

        /* renamed from: q */
        public X509TrustManager f26045q;

        /* renamed from: r */
        public List<ConnectionSpec> f26046r;

        /* renamed from: s */
        public List<? extends Protocol2> f26047s;

        /* renamed from: t */
        public HostnameVerifier f26048t;

        /* renamed from: u */
        public CertificatePinner f26049u;

        /* renamed from: v */
        public CertificateChainCleaner f26050v;

        /* renamed from: w */
        public int f26051w;

        /* renamed from: x */
        public int f26052x;

        /* renamed from: y */
        public int f26053y;

        /* renamed from: z */
        public int f26054z;

        public a() {
            EventListener eventListener = EventListener.f25962a;
            Intrinsics3.checkParameterIsNotNull(eventListener, "$this$asFactory");
            this.f26033e = new Util5(eventListener);
            this.f26034f = true;
            Authenticator2 authenticator2 = Authenticator2.f25369a;
            this.f26035g = authenticator2;
            this.f26036h = true;
            this.f26037i = true;
            this.f26038j = CookieJar2.f25956a;
            this.f26039k = Dns2.f25961a;
            this.f26042n = authenticator2;
            SocketFactory socketFactory = SocketFactory.getDefault();
            Intrinsics3.checkExpressionValueIsNotNull(socketFactory, "SocketFactory.getDefault()");
            this.f26043o = socketFactory;
            b bVar = OkHttpClient.f25996l;
            this.f26046r = OkHttpClient.f25995k;
            this.f26047s = OkHttpClient.f25994j;
            this.f26048t = OkHostnameVerifier.f25811a;
            this.f26049u = CertificatePinner.f25903a;
            this.f26052x = 10000;
            this.f26053y = 10000;
            this.f26054z = 10000;
            this.f26027B = Permission.VIEW_CHANNEL;
        }

        /* renamed from: a */
        public final a m10420a(long j, TimeUnit timeUnit) {
            Intrinsics3.checkParameterIsNotNull(timeUnit, "unit");
            this.f26053y = Util7.m10121b("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: b */
        public final a m10421b(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            Intrinsics3.checkParameterIsNotNull(sSLSocketFactory, "sslSocketFactory");
            Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
            if ((!Intrinsics3.areEqual(sSLSocketFactory, this.f26044p)) || (!Intrinsics3.areEqual(x509TrustManager, this.f26045q))) {
                this.f26028C = null;
            }
            this.f26044p = sSLSocketFactory;
            Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
            Platform2.a aVar = Platform2.f25785c;
            this.f26050v = Platform2.f25783a.mo10315b(x509TrustManager);
            this.f26045q = x509TrustManager;
            return this;
        }
    }

    /* compiled from: OkHttpClient.kt */
    /* renamed from: f0.x$b */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public OkHttpClient(a aVar) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelector;
        boolean z2;
        boolean z3;
        Intrinsics3.checkParameterIsNotNull(aVar, "builder");
        this.f26012m = aVar.f26029a;
        this.f26013n = aVar.f26030b;
        this.f26014o = Util7.m10145z(aVar.f26031c);
        this.f26015p = Util7.m10145z(aVar.f26032d);
        this.f26016q = aVar.f26033e;
        this.f26017r = aVar.f26034f;
        this.f26018s = aVar.f26035g;
        this.f26019t = aVar.f26036h;
        this.f26020u = aVar.f26037i;
        this.f26021v = aVar.f26038j;
        this.f26022w = aVar.f26039k;
        Proxy proxy = aVar.f26040l;
        this.f26023x = proxy;
        if (proxy != null) {
            proxySelector = NullProxySelector.f25808a;
        } else {
            proxySelector = aVar.f26041m;
            proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
            if (proxySelector == null) {
                proxySelector = NullProxySelector.f25808a;
            }
        }
        this.f26024y = proxySelector;
        this.f26025z = aVar.f26042n;
        this.f25997A = aVar.f26043o;
        List<ConnectionSpec> list = aVar.f26046r;
        this.f26000D = list;
        this.f26001E = aVar.f26047s;
        this.f26002F = aVar.f26048t;
        this.f26005I = aVar.f26051w;
        this.f26006J = aVar.f26052x;
        this.f26007K = aVar.f26053y;
        this.f26008L = aVar.f26054z;
        this.f26009M = aVar.f26026A;
        this.f26010N = aVar.f26027B;
        RouteDatabase routeDatabase = aVar.f26028C;
        this.f26011O = routeDatabase == null ? new RouteDatabase() : routeDatabase;
        if ((list instanceof Collection) && list.isEmpty()) {
            z2 = true;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((ConnectionSpec) it.next()).f25934e) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
        }
        if (z2) {
            this.f25998B = null;
            this.f26004H = null;
            this.f25999C = null;
            this.f26003G = CertificatePinner.f25903a;
        } else {
            SSLSocketFactory sSLSocketFactory = aVar.f26044p;
            if (sSLSocketFactory != null) {
                this.f25998B = sSLSocketFactory;
                CertificateChainCleaner certificateChainCleaner = aVar.f26050v;
                if (certificateChainCleaner == null) {
                    Intrinsics3.throwNpe();
                }
                this.f26004H = certificateChainCleaner;
                X509TrustManager x509TrustManager = aVar.f26045q;
                if (x509TrustManager == null) {
                    Intrinsics3.throwNpe();
                }
                this.f25999C = x509TrustManager;
                CertificatePinner certificatePinner = aVar.f26049u;
                if (certificateChainCleaner == null) {
                    Intrinsics3.throwNpe();
                }
                this.f26003G = certificatePinner.m10369b(certificateChainCleaner);
            } else {
                Platform2.a aVar2 = Platform2.f25785c;
                X509TrustManager x509TrustManagerMo10325n = Platform2.f25783a.mo10325n();
                this.f25999C = x509TrustManagerMo10325n;
                Platform2 platform2 = Platform2.f25783a;
                if (x509TrustManagerMo10325n == null) {
                    Intrinsics3.throwNpe();
                }
                this.f25998B = platform2.mo10326m(x509TrustManagerMo10325n);
                if (x509TrustManagerMo10325n == null) {
                    Intrinsics3.throwNpe();
                }
                Intrinsics3.checkParameterIsNotNull(x509TrustManagerMo10325n, "trustManager");
                CertificateChainCleaner certificateChainCleanerMo10315b = Platform2.f25783a.mo10315b(x509TrustManagerMo10325n);
                this.f26004H = certificateChainCleanerMo10315b;
                CertificatePinner certificatePinner2 = aVar.f26049u;
                if (certificateChainCleanerMo10315b == null) {
                    Intrinsics3.throwNpe();
                }
                this.f26003G = certificatePinner2.m10369b(certificateChainCleanerMo10315b);
            }
        }
        if (this.f26014o == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!r5.contains(null))) {
            StringBuilder sbM833U = outline.m833U("Null interceptor: ");
            sbM833U.append(this.f26014o);
            throw new IllegalStateException(sbM833U.toString().toString());
        }
        if (this.f26015p == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!r5.contains(null))) {
            StringBuilder sbM833U2 = outline.m833U("Null network interceptor: ");
            sbM833U2.append(this.f26015p);
            throw new IllegalStateException(sbM833U2.toString().toString());
        }
        List<ConnectionSpec> list2 = this.f26000D;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            z3 = true;
        } else {
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (((ConnectionSpec) it2.next()).f25934e) {
                    z3 = false;
                    break;
                }
            }
            z3 = true;
        }
        if (!z3) {
            if (this.f25998B == null) {
                throw new IllegalStateException("sslSocketFactory == null".toString());
            }
            if (this.f26004H == null) {
                throw new IllegalStateException("certificateChainCleaner == null".toString());
            }
            if (this.f25999C == null) {
                throw new IllegalStateException("x509TrustManager == null".toString());
            }
            return;
        }
        if (!(this.f25998B == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.f26004H == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.f25999C == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!Intrinsics3.areEqual(this.f26003G, CertificatePinner.f25903a)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @Override // p600f0.Call2.a
    /* renamed from: b */
    public Call2 mo10114b(Request request) {
        Intrinsics3.checkParameterIsNotNull(request, "request");
        return new RealCall(this, request, false);
    }

    public Object clone() {
        return super.clone();
    }

    /* renamed from: f */
    public a m10418f() {
        Intrinsics3.checkParameterIsNotNull(this, "okHttpClient");
        a aVar = new a();
        aVar.f26029a = this.f26012m;
        aVar.f26030b = this.f26013n;
        MutableCollections.addAll(aVar.f26031c, this.f26014o);
        MutableCollections.addAll(aVar.f26032d, this.f26015p);
        aVar.f26033e = this.f26016q;
        aVar.f26034f = this.f26017r;
        aVar.f26035g = this.f26018s;
        aVar.f26036h = this.f26019t;
        aVar.f26037i = this.f26020u;
        aVar.f26038j = this.f26021v;
        aVar.f26039k = this.f26022w;
        aVar.f26040l = this.f26023x;
        aVar.f26041m = this.f26024y;
        aVar.f26042n = this.f26025z;
        aVar.f26043o = this.f25997A;
        aVar.f26044p = this.f25998B;
        aVar.f26045q = this.f25999C;
        aVar.f26046r = this.f26000D;
        aVar.f26047s = this.f26001E;
        aVar.f26048t = this.f26002F;
        aVar.f26049u = this.f26003G;
        aVar.f26050v = this.f26004H;
        aVar.f26051w = this.f26005I;
        aVar.f26052x = this.f26006J;
        aVar.f26053y = this.f26007K;
        aVar.f26054z = this.f26008L;
        aVar.f26026A = this.f26009M;
        aVar.f26027B = this.f26010N;
        aVar.f26028C = this.f26011O;
        return aVar;
    }

    /* renamed from: g */
    public WebSocket m10419g(Request request, WebSocketListener webSocketListener) {
        Intrinsics3.checkParameterIsNotNull(request, "request");
        Intrinsics3.checkParameterIsNotNull(webSocketListener, "listener");
        RealWebSocket realWebSocket = new RealWebSocket(TaskRunner.f25420a, request, webSocketListener, new Random(), this.f26009M, null, this.f26010N);
        Intrinsics3.checkParameterIsNotNull(this, "client");
        if (realWebSocket.f25841u.m10977b("Sec-WebSocket-Extensions") != null) {
            realWebSocket.m10353i(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
        } else {
            a aVarM10418f = m10418f();
            EventListener eventListener = EventListener.f25962a;
            Intrinsics3.checkParameterIsNotNull(eventListener, "eventListener");
            byte[] bArr = Util7.f25397a;
            Intrinsics3.checkParameterIsNotNull(eventListener, "$this$asFactory");
            aVarM10418f.f26033e = new Util5(eventListener);
            List<Protocol2> list = RealWebSocket.f25821a;
            Intrinsics3.checkParameterIsNotNull(list, "protocols");
            List mutableList = _Collections.toMutableList((Collection) list);
            Protocol2 protocol2 = Protocol2.H2_PRIOR_KNOWLEDGE;
            if (!(mutableList.contains(protocol2) || mutableList.contains(Protocol2.HTTP_1_1))) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + mutableList).toString());
            }
            if (!(!mutableList.contains(protocol2) || mutableList.size() <= 1)) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + mutableList).toString());
            }
            if (!(!mutableList.contains(Protocol2.HTTP_1_0))) {
                throw new IllegalArgumentException(("protocols must not contain http/1.0: " + mutableList).toString());
            }
            if (!(!mutableList.contains(null))) {
                throw new IllegalArgumentException("protocols must not contain null".toString());
            }
            mutableList.remove(Protocol2.SPDY_3);
            if (!Intrinsics3.areEqual(mutableList, aVarM10418f.f26047s)) {
                aVarM10418f.f26028C = null;
            }
            List<? extends Protocol2> listUnmodifiableList = Collections.unmodifiableList(mutableList);
            Intrinsics3.checkExpressionValueIsNotNull(listUnmodifiableList, "Collections.unmodifiableList(protocolsCopy)");
            aVarM10418f.f26047s = listUnmodifiableList;
            OkHttpClient okHttpClient = new OkHttpClient(aVarM10418f);
            Request.C12935a c12935a = new Request.C12935a(realWebSocket.f25841u);
            c12935a.m10979b("Upgrade", "websocket");
            c12935a.m10979b("Connection", "Upgrade");
            c12935a.m10979b("Sec-WebSocket-Key", realWebSocket.f25822b);
            c12935a.m10979b("Sec-WebSocket-Version", "13");
            c12935a.m10979b("Sec-WebSocket-Extensions", "permessage-deflate");
            Request requestM10978a = c12935a.m10978a();
            RealCall realCall = new RealCall(okHttpClient, requestM10978a, true);
            realWebSocket.f25823c = realCall;
            realCall.mo10113e(new RealWebSocket2(realWebSocket, requestM10978a));
        }
        return realWebSocket;
    }

    public OkHttpClient() {
        this(new a());
    }
}
