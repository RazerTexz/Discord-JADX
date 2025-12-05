package p600f0.p601e0.p609k;

import android.util.Log;
import androidx.core.os.EnvironmentCompat;
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
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.OkHttpClient;
import p600f0.Protocol2;
import p600f0.p601e0.p609k.AndroidPlatform;
import p600f0.p601e0.p609k.BouncyCastlePlatform;
import p600f0.p601e0.p609k.ConscryptPlatform;
import p600f0.p601e0.p609k.Jdk9Platform;
import p600f0.p601e0.p609k.OpenJSSEPlatform;
import p600f0.p601e0.p609k.p610i.AndroidLog;
import p600f0.p601e0.p609k.p610i.AndroidLog2;
import p600f0.p601e0.p612m.BasicCertificateChainCleaner;
import p600f0.p601e0.p612m.BasicTrustRootIndex;
import p600f0.p601e0.p612m.CertificateChainCleaner;
import p600f0.p601e0.p612m.TrustRootIndex;
import p615g0.Buffer3;

/* compiled from: Platform.kt */
/* renamed from: f0.e0.k.h, reason: use source file name */
/* loaded from: classes3.dex */
public class Platform2 {

    /* renamed from: a */
    public static volatile Platform2 f25783a;

    /* renamed from: b */
    public static final Logger f25784b;

    /* renamed from: c */
    public static final a f25785c;

    /* compiled from: Platform.kt */
    /* renamed from: f0.e0.k.h$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public final List<String> m10331a(List<? extends Protocol2> list) {
            Intrinsics3.checkParameterIsNotNull(list, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((Protocol2) obj) != Protocol2.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Protocol2) it.next()).toString());
            }
            return arrayList2;
        }

        /* renamed from: b */
        public final byte[] m10332b(List<? extends Protocol2> list) {
            Intrinsics3.checkParameterIsNotNull(list, "protocols");
            Buffer3 buffer3 = new Buffer3();
            for (String str : (ArrayList) m10331a(list)) {
                buffer3.m10444T(str.length());
                buffer3.m10452b0(str);
            }
            return buffer3.mo10450Z(buffer3.f26080k);
        }

        /* renamed from: c */
        public final boolean m10333c() {
            return Intrinsics3.areEqual("Dalvik", System.getProperty("java.vm.name"));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fe  */
    static {
        Platform2 jdk9Platform;
        a aVar = new a(null);
        f25785c = aVar;
        if (aVar.m10333c()) {
            AndroidLog androidLog = AndroidLog.f25790c;
            for (Map.Entry<String, String> entry : AndroidLog.f25789b.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Logger logger = Logger.getLogger(key);
                if (AndroidLog.f25788a.add(logger)) {
                    Intrinsics3.checkExpressionValueIsNotNull(logger, "logger");
                    logger.setUseParentHandlers(false);
                    logger.setLevel(Log.isLoggable(value, 3) ? Level.FINE : Log.isLoggable(value, 4) ? Level.INFO : Level.WARNING);
                    logger.addHandler(AndroidLog2.f25791a);
                }
            }
            Android10Platform android10Platform = Android10Platform.f25755e;
            jdk9Platform = Android10Platform.f25754d ? new Android10Platform() : null;
            if (jdk9Platform == null) {
                AndroidPlatform.a aVar2 = AndroidPlatform.f25758e;
                jdk8WithJettyBootPlatform = AndroidPlatform.f25757d ? new AndroidPlatform() : null;
                if (jdk8WithJettyBootPlatform == null) {
                    Intrinsics3.throwNpe();
                }
            }
        } else {
            Provider provider = Security.getProviders()[0];
            Intrinsics3.checkExpressionValueIsNotNull(provider, "Security.getProviders()[0]");
            if (Intrinsics3.areEqual("Conscrypt", provider.getName())) {
                ConscryptPlatform.a aVar3 = ConscryptPlatform.f25767e;
                jdk9Platform = ConscryptPlatform.f25766d ? new ConscryptPlatform() : null;
                if (jdk9Platform == null) {
                    Provider provider2 = Security.getProviders()[0];
                    Intrinsics3.checkExpressionValueIsNotNull(provider2, "Security.getProviders()[0]");
                    if (Intrinsics3.areEqual("BC", provider2.getName())) {
                        BouncyCastlePlatform.a aVar4 = BouncyCastlePlatform.f25764e;
                        jdk9Platform = BouncyCastlePlatform.f25763d ? new BouncyCastlePlatform() : null;
                        if (jdk9Platform == null) {
                            Provider provider3 = Security.getProviders()[0];
                            Intrinsics3.checkExpressionValueIsNotNull(provider3, "Security.getProviders()[0]");
                            if (Intrinsics3.areEqual("OpenJSSE", provider3.getName())) {
                                OpenJSSEPlatform.a aVar5 = OpenJSSEPlatform.f25781e;
                                jdk9Platform = OpenJSSEPlatform.f25780d ? new OpenJSSEPlatform() : null;
                                if (jdk9Platform == null) {
                                    Jdk9Platform.a aVar6 = Jdk9Platform.f25779e;
                                    jdk9Platform = Jdk9Platform.f25778d ? new Jdk9Platform() : null;
                                    if (jdk9Platform == null) {
                                        String property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                        try {
                                            Intrinsics3.checkExpressionValueIsNotNull(property, "jvmVersion");
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
                                                Intrinsics3.checkExpressionValueIsNotNull(method, "putMethod");
                                                Intrinsics3.checkExpressionValueIsNotNull(method2, "getMethod");
                                                Intrinsics3.checkExpressionValueIsNotNull(method3, "removeMethod");
                                                Intrinsics3.checkExpressionValueIsNotNull(cls3, "clientProviderClass");
                                                Intrinsics3.checkExpressionValueIsNotNull(cls4, "serverProviderClass");
                                                jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(method, method2, method3, cls3, cls4);
                                            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                                            }
                                        }
                                        jdk9Platform = jdk8WithJettyBootPlatform != null ? jdk8WithJettyBootPlatform : new Platform2();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        f25783a = jdk9Platform;
        f25784b = Logger.getLogger(OkHttpClient.class.getName());
    }

    /* renamed from: j */
    public static /* synthetic */ void m10329j(Platform2 platform2, String str, int i, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 4;
        }
        int i3 = i2 & 4;
        platform2.m10330i(str, i, null);
    }

    /* renamed from: a */
    public void mo10328a(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
    }

    /* renamed from: b */
    public CertificateChainCleaner mo10315b(X509TrustManager x509TrustManager) {
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        return new BasicCertificateChainCleaner(mo10319c(x509TrustManager));
    }

    /* renamed from: c */
    public TrustRootIndex mo10319c(X509TrustManager x509TrustManager) {
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        Intrinsics3.checkExpressionValueIsNotNull(acceptedIssuers, "trustManager.acceptedIssuers");
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    /* renamed from: d */
    public void mo10316d(SSLSocket sSLSocket, String str, List<Protocol2> list) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
    }

    /* renamed from: e */
    public void mo10320e(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        Intrinsics3.checkParameterIsNotNull(socket, "socket");
        Intrinsics3.checkParameterIsNotNull(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i);
    }

    /* renamed from: f */
    public String mo10317f(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return null;
    }

    /* renamed from: g */
    public Object mo10321g(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "closer");
        if (f25784b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* renamed from: h */
    public boolean mo10318h(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "hostname");
        return true;
    }

    /* renamed from: i */
    public void m10330i(String str, int i, Throwable th) {
        Intrinsics3.checkParameterIsNotNull(str, "message");
        f25784b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* renamed from: k */
    public void mo10322k(String str, Object obj) {
        Intrinsics3.checkParameterIsNotNull(str, "message");
        if (obj == null) {
            str = outline.m883w(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        m10330i(str, 5, (Throwable) obj);
    }

    /* renamed from: l */
    public SSLContext mo10324l() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        Intrinsics3.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    /* renamed from: m */
    public SSLSocketFactory mo10326m(X509TrustManager x509TrustManager) {
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            SSLContext sSLContextMo10324l = mo10324l();
            sSLContextMo10324l.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = sSLContextMo10324l.getSocketFactory();
            Intrinsics3.checkExpressionValueIsNotNull(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    /* renamed from: n */
    public X509TrustManager mo10325n() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        Intrinsics3.checkExpressionValueIsNotNull(trustManagerFactory, "factory");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers == null) {
            Intrinsics3.throwNpe();
        }
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager != null) {
                return (X509TrustManager) trustManager;
            }
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        StringBuilder sbM833U = outline.m833U("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        Intrinsics3.checkExpressionValueIsNotNull(string, "java.util.Arrays.toString(this)");
        sbM833U.append(string);
        throw new IllegalStateException(sbM833U.toString().toString());
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        Intrinsics3.checkExpressionValueIsNotNull(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
