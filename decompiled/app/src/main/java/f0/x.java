package f0;

import com.discord.api.permission.Permission;
import f0.e;
import f0.e0.k.h;
import f0.t;
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

/* compiled from: OkHttpClient.kt */
/* loaded from: classes3.dex */
public class x implements Cloneable, e.a {
    public final SocketFactory A;
    public final SSLSocketFactory B;
    public final X509TrustManager C;
    public final List<m> D;
    public final List<y> E;
    public final HostnameVerifier F;
    public final g G;
    public final f0.e0.m.c H;
    public final int I;
    public final int J;
    public final int K;
    public final int L;
    public final int M;
    public final long N;
    public final f0.e0.g.l O;
    public final q m;
    public final l n;
    public final List<Interceptor> o;
    public final List<Interceptor> p;
    public final t.b q;
    public final boolean r;

    /* renamed from: s, reason: collision with root package name */
    public final c f3683s;
    public final boolean t;
    public final boolean u;
    public final p v;
    public final s w;

    /* renamed from: x, reason: collision with root package name */
    public final Proxy f3684x;

    /* renamed from: y, reason: collision with root package name */
    public final ProxySelector f3685y;

    /* renamed from: z, reason: collision with root package name */
    public final c f3686z;
    public static final b l = new b(null);
    public static final List<y> j = f0.e0.c.m(y.HTTP_2, y.HTTP_1_1);
    public static final List<m> k = f0.e0.c.m(m.c, m.d);

    /* compiled from: OkHttpClient.kt */
    public static final class a {
        public int A;
        public long B;
        public f0.e0.g.l C;
        public q a = new q();

        /* renamed from: b, reason: collision with root package name */
        public l f3687b = new l();
        public final List<Interceptor> c = new ArrayList();
        public final List<Interceptor> d = new ArrayList();
        public t.b e;
        public boolean f;
        public c g;
        public boolean h;
        public boolean i;
        public p j;
        public s k;
        public Proxy l;
        public ProxySelector m;
        public c n;
        public SocketFactory o;
        public SSLSocketFactory p;
        public X509TrustManager q;
        public List<m> r;

        /* renamed from: s, reason: collision with root package name */
        public List<? extends y> f3688s;
        public HostnameVerifier t;
        public g u;
        public f0.e0.m.c v;
        public int w;

        /* renamed from: x, reason: collision with root package name */
        public int f3689x;

        /* renamed from: y, reason: collision with root package name */
        public int f3690y;

        /* renamed from: z, reason: collision with root package name */
        public int f3691z;

        public a() {
            t tVar = t.a;
            d0.z.d.m.checkParameterIsNotNull(tVar, "$this$asFactory");
            this.e = new f0.e0.a(tVar);
            this.f = true;
            c cVar = c.a;
            this.g = cVar;
            this.h = true;
            this.i = true;
            this.j = p.a;
            this.k = s.a;
            this.n = cVar;
            SocketFactory socketFactory = SocketFactory.getDefault();
            d0.z.d.m.checkExpressionValueIsNotNull(socketFactory, "SocketFactory.getDefault()");
            this.o = socketFactory;
            b bVar = x.l;
            this.r = x.k;
            this.f3688s = x.j;
            this.t = f0.e0.m.d.a;
            this.u = g.a;
            this.f3689x = 10000;
            this.f3690y = 10000;
            this.f3691z = 10000;
            this.B = Permission.VIEW_CHANNEL;
        }

        public final a a(long j, TimeUnit timeUnit) {
            d0.z.d.m.checkParameterIsNotNull(timeUnit, "unit");
            this.f3690y = f0.e0.c.b("timeout", j, timeUnit);
            return this;
        }

        public final a b(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            d0.z.d.m.checkParameterIsNotNull(sSLSocketFactory, "sslSocketFactory");
            d0.z.d.m.checkParameterIsNotNull(x509TrustManager, "trustManager");
            if ((!d0.z.d.m.areEqual(sSLSocketFactory, this.p)) || (!d0.z.d.m.areEqual(x509TrustManager, this.q))) {
                this.C = null;
            }
            this.p = sSLSocketFactory;
            d0.z.d.m.checkParameterIsNotNull(x509TrustManager, "trustManager");
            h.a aVar = f0.e0.k.h.c;
            this.v = f0.e0.k.h.a.b(x509TrustManager);
            this.q = x509TrustManager;
            return this;
        }
    }

    /* compiled from: OkHttpClient.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public x(a aVar) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelector;
        boolean z2;
        boolean z3;
        d0.z.d.m.checkParameterIsNotNull(aVar, "builder");
        this.m = aVar.a;
        this.n = aVar.f3687b;
        this.o = f0.e0.c.z(aVar.c);
        this.p = f0.e0.c.z(aVar.d);
        this.q = aVar.e;
        this.r = aVar.f;
        this.f3683s = aVar.g;
        this.t = aVar.h;
        this.u = aVar.i;
        this.v = aVar.j;
        this.w = aVar.k;
        Proxy proxy = aVar.l;
        this.f3684x = proxy;
        if (proxy != null) {
            proxySelector = f0.e0.l.a.a;
        } else {
            proxySelector = aVar.m;
            proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
            if (proxySelector == null) {
                proxySelector = f0.e0.l.a.a;
            }
        }
        this.f3685y = proxySelector;
        this.f3686z = aVar.n;
        this.A = aVar.o;
        List<m> list = aVar.r;
        this.D = list;
        this.E = aVar.f3688s;
        this.F = aVar.t;
        this.I = aVar.w;
        this.J = aVar.f3689x;
        this.K = aVar.f3690y;
        this.L = aVar.f3691z;
        this.M = aVar.A;
        this.N = aVar.B;
        f0.e0.g.l lVar = aVar.C;
        this.O = lVar == null ? new f0.e0.g.l() : lVar;
        if ((list instanceof Collection) && list.isEmpty()) {
            z2 = true;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((m) it.next()).e) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
        }
        if (z2) {
            this.B = null;
            this.H = null;
            this.C = null;
            this.G = g.a;
        } else {
            SSLSocketFactory sSLSocketFactory = aVar.p;
            if (sSLSocketFactory != null) {
                this.B = sSLSocketFactory;
                f0.e0.m.c cVar = aVar.v;
                if (cVar == null) {
                    d0.z.d.m.throwNpe();
                }
                this.H = cVar;
                X509TrustManager x509TrustManager = aVar.q;
                if (x509TrustManager == null) {
                    d0.z.d.m.throwNpe();
                }
                this.C = x509TrustManager;
                g gVar = aVar.u;
                if (cVar == null) {
                    d0.z.d.m.throwNpe();
                }
                this.G = gVar.b(cVar);
            } else {
                h.a aVar2 = f0.e0.k.h.c;
                X509TrustManager x509TrustManagerN = f0.e0.k.h.a.n();
                this.C = x509TrustManagerN;
                f0.e0.k.h hVar = f0.e0.k.h.a;
                if (x509TrustManagerN == null) {
                    d0.z.d.m.throwNpe();
                }
                this.B = hVar.m(x509TrustManagerN);
                if (x509TrustManagerN == null) {
                    d0.z.d.m.throwNpe();
                }
                d0.z.d.m.checkParameterIsNotNull(x509TrustManagerN, "trustManager");
                f0.e0.m.c cVarB = f0.e0.k.h.a.b(x509TrustManagerN);
                this.H = cVarB;
                g gVar2 = aVar.u;
                if (cVarB == null) {
                    d0.z.d.m.throwNpe();
                }
                this.G = gVar2.b(cVarB);
            }
        }
        if (this.o == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!r5.contains(null))) {
            StringBuilder sbU = b.d.b.a.a.U("Null interceptor: ");
            sbU.append(this.o);
            throw new IllegalStateException(sbU.toString().toString());
        }
        if (this.p == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!r5.contains(null))) {
            StringBuilder sbU2 = b.d.b.a.a.U("Null network interceptor: ");
            sbU2.append(this.p);
            throw new IllegalStateException(sbU2.toString().toString());
        }
        List<m> list2 = this.D;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            z3 = true;
        } else {
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (((m) it2.next()).e) {
                    z3 = false;
                    break;
                }
            }
            z3 = true;
        }
        if (!z3) {
            if (this.B == null) {
                throw new IllegalStateException("sslSocketFactory == null".toString());
            }
            if (this.H == null) {
                throw new IllegalStateException("certificateChainCleaner == null".toString());
            }
            if (this.C == null) {
                throw new IllegalStateException("x509TrustManager == null".toString());
            }
            return;
        }
        if (!(this.B == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.H == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.C == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!d0.z.d.m.areEqual(this.G, g.a)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @Override // f0.e.a
    public e b(Request request) {
        d0.z.d.m.checkParameterIsNotNull(request, "request");
        return new f0.e0.g.e(this, request, false);
    }

    public Object clone() {
        return super.clone();
    }

    public a f() {
        d0.z.d.m.checkParameterIsNotNull(this, "okHttpClient");
        a aVar = new a();
        aVar.a = this.m;
        aVar.f3687b = this.n;
        d0.t.r.addAll(aVar.c, this.o);
        d0.t.r.addAll(aVar.d, this.p);
        aVar.e = this.q;
        aVar.f = this.r;
        aVar.g = this.f3683s;
        aVar.h = this.t;
        aVar.i = this.u;
        aVar.j = this.v;
        aVar.k = this.w;
        aVar.l = this.f3684x;
        aVar.m = this.f3685y;
        aVar.n = this.f3686z;
        aVar.o = this.A;
        aVar.p = this.B;
        aVar.q = this.C;
        aVar.r = this.D;
        aVar.f3688s = this.E;
        aVar.t = this.F;
        aVar.u = this.G;
        aVar.v = this.H;
        aVar.w = this.I;
        aVar.f3689x = this.J;
        aVar.f3690y = this.K;
        aVar.f3691z = this.L;
        aVar.A = this.M;
        aVar.B = this.N;
        aVar.C = this.O;
        return aVar;
    }

    public WebSocket g(Request request, WebSocketListener webSocketListener) {
        d0.z.d.m.checkParameterIsNotNull(request, "request");
        d0.z.d.m.checkParameterIsNotNull(webSocketListener, "listener");
        f0.e0.n.d dVar = new f0.e0.n.d(f0.e0.f.d.a, request, webSocketListener, new Random(), this.M, null, this.N);
        d0.z.d.m.checkParameterIsNotNull(this, "client");
        if (dVar.u.b("Sec-WebSocket-Extensions") != null) {
            dVar.i(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
        } else {
            a aVarF = f();
            t tVar = t.a;
            d0.z.d.m.checkParameterIsNotNull(tVar, "eventListener");
            byte[] bArr = f0.e0.c.a;
            d0.z.d.m.checkParameterIsNotNull(tVar, "$this$asFactory");
            aVarF.e = new f0.e0.a(tVar);
            List<y> list = f0.e0.n.d.a;
            d0.z.d.m.checkParameterIsNotNull(list, "protocols");
            List mutableList = d0.t.u.toMutableList((Collection) list);
            y yVar = y.H2_PRIOR_KNOWLEDGE;
            if (!(mutableList.contains(yVar) || mutableList.contains(y.HTTP_1_1))) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + mutableList).toString());
            }
            if (!(!mutableList.contains(yVar) || mutableList.size() <= 1)) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + mutableList).toString());
            }
            if (!(!mutableList.contains(y.HTTP_1_0))) {
                throw new IllegalArgumentException(("protocols must not contain http/1.0: " + mutableList).toString());
            }
            if (!(!mutableList.contains(null))) {
                throw new IllegalArgumentException("protocols must not contain null".toString());
            }
            mutableList.remove(y.SPDY_3);
            if (!d0.z.d.m.areEqual(mutableList, aVarF.f3688s)) {
                aVarF.C = null;
            }
            List<? extends y> listUnmodifiableList = Collections.unmodifiableList(mutableList);
            d0.z.d.m.checkExpressionValueIsNotNull(listUnmodifiableList, "Collections.unmodifiableList(protocolsCopy)");
            aVarF.f3688s = listUnmodifiableList;
            x xVar = new x(aVarF);
            Request.a aVar = new Request.a(dVar.u);
            aVar.b("Upgrade", "websocket");
            aVar.b("Connection", "Upgrade");
            aVar.b("Sec-WebSocket-Key", dVar.f3656b);
            aVar.b("Sec-WebSocket-Version", "13");
            aVar.b("Sec-WebSocket-Extensions", "permessage-deflate");
            Request requestA = aVar.a();
            f0.e0.g.e eVar = new f0.e0.g.e(xVar, requestA, true);
            dVar.c = eVar;
            eVar.e(new f0.e0.n.e(dVar, requestA));
        }
        return dVar;
    }

    public x() {
        this(new a());
    }
}
