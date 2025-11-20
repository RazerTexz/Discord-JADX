package f0.e0.k;

import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import d0.t.o;
import d0.z.d.m;
import f0.e0.k.b;
import f0.e0.k.c;
import f0.e0.k.d;
import f0.e0.k.f;
import f0.e0.k.g;
import f0.x;
import f0.y;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Platform.kt */
/* loaded from: classes3.dex */
public class h {
    public static volatile h a;

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f3650b;
    public static final a c;

    /* compiled from: Platform.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final List<String> a(List<? extends y> list) {
            m.checkParameterIsNotNull(list, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((y) obj) != y.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((y) it.next()).toString());
            }
            return arrayList2;
        }

        public final byte[] b(List<? extends y> list) {
            m.checkParameterIsNotNull(list, "protocols");
            g0.e eVar = new g0.e();
            for (String str : (ArrayList) a(list)) {
                eVar.T(str.length());
                eVar.b0(str);
            }
            return eVar.Z(eVar.k);
        }

        public final boolean c() {
            return m.areEqual("Dalvik", System.getProperty("java.vm.name"));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fe  */
    static {
        h fVar;
        a aVar = new a(null);
        c = aVar;
        if (aVar.c()) {
            f0.e0.k.i.c cVar = f0.e0.k.i.c.c;
            for (Map.Entry<String, String> entry : f0.e0.k.i.c.f3652b.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Logger logger = Logger.getLogger(key);
                if (f0.e0.k.i.c.a.add(logger)) {
                    m.checkExpressionValueIsNotNull(logger, "logger");
                    logger.setUseParentHandlers(false);
                    logger.setLevel(Log.isLoggable(value, 3) ? Level.FINE : Log.isLoggable(value, 4) ? Level.INFO : Level.WARNING);
                    logger.addHandler(f0.e0.k.i.d.a);
                }
            }
            f0.e0.k.a aVar2 = f0.e0.k.a.e;
            fVar = f0.e0.k.a.d ? new f0.e0.k.a() : null;
            if (fVar == null) {
                b.a aVar3 = b.e;
                eVar = b.d ? new b() : null;
                if (eVar == null) {
                    m.throwNpe();
                }
            }
        } else {
            Provider provider = Security.getProviders()[0];
            m.checkExpressionValueIsNotNull(provider, "Security.getProviders()[0]");
            if (m.areEqual("Conscrypt", provider.getName())) {
                d.a aVar4 = d.e;
                fVar = d.d ? new d() : null;
                if (fVar == null) {
                    Provider provider2 = Security.getProviders()[0];
                    m.checkExpressionValueIsNotNull(provider2, "Security.getProviders()[0]");
                    if (m.areEqual("BC", provider2.getName())) {
                        c.a aVar5 = c.e;
                        fVar = c.d ? new c() : null;
                        if (fVar == null) {
                            Provider provider3 = Security.getProviders()[0];
                            m.checkExpressionValueIsNotNull(provider3, "Security.getProviders()[0]");
                            if (m.areEqual("OpenJSSE", provider3.getName())) {
                                g.a aVar6 = g.e;
                                fVar = g.d ? new g() : null;
                                if (fVar == null) {
                                    f.a aVar7 = f.e;
                                    fVar = f.d ? new f() : null;
                                    if (fVar == null) {
                                        String property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                        try {
                                            m.checkExpressionValueIsNotNull(property, "jvmVersion");
                                        } catch (NumberFormatException unused) {
                                        }
                                        if (Integer.parseInt(property) < 9) {
                                            try {
                                                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                                Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                                Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                                Method method = cls.getMethod("put", SSLSocket.class, cls2);
                                                Method method2 = cls.getMethod("get", SSLSocket.class);
                                                Method method3 = cls.getMethod("remove", SSLSocket.class);
                                                m.checkExpressionValueIsNotNull(method, "putMethod");
                                                m.checkExpressionValueIsNotNull(method2, "getMethod");
                                                m.checkExpressionValueIsNotNull(method3, "removeMethod");
                                                m.checkExpressionValueIsNotNull(cls3, "clientProviderClass");
                                                m.checkExpressionValueIsNotNull(cls4, "serverProviderClass");
                                                eVar = new e(method, method2, method3, cls3, cls4);
                                            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                                            }
                                        }
                                        fVar = eVar != null ? eVar : new h();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        a = fVar;
        f3650b = Logger.getLogger(x.class.getName());
    }

    public static /* synthetic */ void j(h hVar, String str, int i, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 4;
        }
        int i3 = i2 & 4;
        hVar.i(str, i, null);
    }

    public void a(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
    }

    public f0.e0.m.c b(X509TrustManager x509TrustManager) {
        m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        return new f0.e0.m.a(c(x509TrustManager));
    }

    public f0.e0.m.e c(X509TrustManager x509TrustManager) {
        m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        m.checkExpressionValueIsNotNull(acceptedIssuers, "trustManager.acceptedIssuers");
        return new f0.e0.m.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void d(SSLSocket sSLSocket, String str, List<y> list) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        m.checkParameterIsNotNull(list, "protocols");
    }

    public void e(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        m.checkParameterIsNotNull(socket, "socket");
        m.checkParameterIsNotNull(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i);
    }

    public String f(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return null;
    }

    public Object g(String str) {
        m.checkParameterIsNotNull(str, "closer");
        if (f3650b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean h(String str) {
        m.checkParameterIsNotNull(str, "hostname");
        return true;
    }

    public void i(String str, int i, Throwable th) {
        m.checkParameterIsNotNull(str, "message");
        f3650b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void k(String str, Object obj) {
        m.checkParameterIsNotNull(str, "message");
        if (obj == null) {
            str = b.d.b.a.a.w(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        i(str, 5, (Throwable) obj);
    }

    public SSLContext l() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        m.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory m(X509TrustManager x509TrustManager) {
        m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            SSLContext sSLContextL = l();
            sSLContextL.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = sSLContextL.getSocketFactory();
            m.checkExpressionValueIsNotNull(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    public X509TrustManager n() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        m.checkExpressionValueIsNotNull(trustManagerFactory, "factory");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers == null) {
            m.throwNpe();
        }
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager != null) {
                return (X509TrustManager) trustManager;
            }
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        StringBuilder sbU = b.d.b.a.a.U("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        m.checkExpressionValueIsNotNull(string, "java.util.Arrays.toString(this)");
        sbU.append(string);
        throw new IllegalStateException(sbU.toString().toString());
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        m.checkExpressionValueIsNotNull(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
