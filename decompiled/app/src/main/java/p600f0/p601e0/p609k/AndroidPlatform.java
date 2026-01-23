package p600f0.p601e0.p609k;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Protocol2;
import p600f0.p601e0.p609k.p610i.AndroidCertificateChainCleaner;
import p600f0.p601e0.p609k.p610i.AndroidSocketAdapter2;
import p600f0.p601e0.p609k.p610i.BouncyCastleSocketAdapter;
import p600f0.p601e0.p609k.p610i.CloseGuard;
import p600f0.p601e0.p609k.p610i.ConscryptSocketAdapter;
import p600f0.p601e0.p609k.p610i.DeferredSocketAdapter;
import p600f0.p601e0.p609k.p610i.SocketAdapter;
import p600f0.p601e0.p609k.p610i.StandardAndroidSocketAdapter;
import p600f0.p601e0.p612m.CertificateChainCleaner;
import p600f0.p601e0.p612m.TrustRootIndex;

/* JADX INFO: renamed from: f0.e0.k.b, reason: use source file name */
/* JADX INFO: compiled from: AndroidPlatform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AndroidPlatform extends Platform2 {

    /* JADX INFO: renamed from: d */
    public static final boolean f25757d;

    /* JADX INFO: renamed from: e */
    public static final a f25758e = new a(null);

    /* JADX INFO: renamed from: f */
    public final List<SocketAdapter> f25759f;

    /* JADX INFO: renamed from: g */
    public final CloseGuard f25760g;

    /* JADX INFO: renamed from: f0.e0.k.b$a */
    /* JADX INFO: compiled from: AndroidPlatform.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: f0.e0.k.b$b */
    /* JADX INFO: compiled from: AndroidPlatform.kt */
    public static final class b implements TrustRootIndex {

        /* JADX INFO: renamed from: a */
        public final X509TrustManager f25761a;

        /* JADX INFO: renamed from: b */
        public final Method f25762b;

        public b(X509TrustManager x509TrustManager, Method method) {
            Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
            Intrinsics3.checkParameterIsNotNull(method, "findByIssuerAndSignatureMethod");
            this.f25761a = x509TrustManager;
            this.f25762b = method;
        }

        @Override // p600f0.p601e0.p612m.TrustRootIndex
        /* JADX INFO: renamed from: a */
        public X509Certificate mo10323a(X509Certificate x509Certificate) {
            Intrinsics3.checkParameterIsNotNull(x509Certificate, "cert");
            try {
                Object objInvoke = this.f25762b.invoke(this.f25761a, x509Certificate);
                if (objInvoke != null) {
                    return ((TrustAnchor) objInvoke).getTrustedCert();
                }
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
            } catch (IllegalAccessException e) {
                throw new AssertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics3.areEqual(this.f25761a, bVar.f25761a) && Intrinsics3.areEqual(this.f25762b, bVar.f25762b);
        }

        public int hashCode() {
            X509TrustManager x509TrustManager = this.f25761a;
            int iHashCode = (x509TrustManager != null ? x509TrustManager.hashCode() : 0) * 31;
            Method method = this.f25762b;
            return iHashCode + (method != null ? method.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("CustomTrustRootIndex(trustManager=");
            sbM833U.append(this.f25761a);
            sbM833U.append(", findByIssuerAndSignatureMethod=");
            sbM833U.append(this.f25762b);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    static {
        boolean z2 = false;
        if (Platform2.f25785c.m10333c() && Build.VERSION.SDK_INT < 30) {
            z2 = true;
        }
        f25757d = z2;
    }

    public AndroidPlatform() throws NoSuchMethodException {
        StandardAndroidSocketAdapter standardAndroidSocketAdapter;
        Method method;
        Method method2;
        SocketAdapter[] socketAdapterArr = new SocketAdapter[4];
        StandardAndroidSocketAdapter.a aVar = StandardAndroidSocketAdapter.f25807h;
        Intrinsics3.checkParameterIsNotNull("com.android.org.conscrypt", "packageName");
        Method method3 = null;
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            Class<?> cls2 = Class.forName("com.android.org.conscrypt.OpenSSLSocketFactoryImpl");
            Class<?> cls3 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            Intrinsics3.checkExpressionValueIsNotNull(cls3, "paramsClass");
            standardAndroidSocketAdapter = new StandardAndroidSocketAdapter(cls, cls2, cls3);
        } catch (Exception e) {
            Platform2.f25783a.m10330i("unable to load android socket classes", 5, e);
            standardAndroidSocketAdapter = null;
        }
        socketAdapterArr[0] = standardAndroidSocketAdapter;
        AndroidSocketAdapter2.a aVar2 = AndroidSocketAdapter2.f25794b;
        socketAdapterArr[1] = new DeferredSocketAdapter(AndroidSocketAdapter2.f25793a);
        socketAdapterArr[2] = new DeferredSocketAdapter(ConscryptSocketAdapter.f25804a);
        socketAdapterArr[3] = new DeferredSocketAdapter(BouncyCastleSocketAdapter.f25800a);
        List listListOfNotNull = Collections2.listOfNotNull((Object[]) socketAdapterArr);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOfNotNull) {
            if (((SocketAdapter) obj).mo10335b()) {
                arrayList.add(obj);
            }
        }
        this.f25759f = arrayList;
        try {
            Class<?> cls4 = Class.forName("dalvik.system.CloseGuard");
            Method method4 = cls4.getMethod("get", new Class[0]);
            method2 = cls4.getMethod("open", String.class);
            method = cls4.getMethod("warnIfOpen", new Class[0]);
            method3 = method4;
        } catch (Exception unused) {
            method = null;
            method2 = null;
        }
        this.f25760g = new CloseGuard(method3, method2, method);
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* JADX INFO: renamed from: b */
    public CertificateChainCleaner mo10315b(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        AndroidCertificateChainCleaner androidCertificateChainCleaner = x509TrustManagerExtensions != null ? new AndroidCertificateChainCleaner(x509TrustManager, x509TrustManagerExtensions) : null;
        return androidCertificateChainCleaner != null ? androidCertificateChainCleaner : super.mo10315b(x509TrustManager);
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* JADX INFO: renamed from: c */
    public TrustRootIndex mo10319c(X509TrustManager x509TrustManager) {
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            Intrinsics3.checkExpressionValueIsNotNull(declaredMethod, "method");
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo10319c(x509TrustManager);
        }
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* JADX INFO: renamed from: d */
    public void mo10316d(SSLSocket sSLSocket, String str, List<Protocol2> list) {
        Object next;
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        Iterator<T> it = this.f25759f.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((SocketAdapter) next).mo10334a(sSLSocket)) {
                    break;
                }
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) next;
        if (socketAdapter != null) {
            socketAdapter.mo10337d(sSLSocket, str, list);
        }
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* JADX INFO: renamed from: e */
    public void mo10320e(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        Intrinsics3.checkParameterIsNotNull(socket, "socket");
        Intrinsics3.checkParameterIsNotNull(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e;
            }
            throw new IOException("Exception in connect", e);
        }
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* JADX INFO: renamed from: f */
    public String mo10317f(SSLSocket sSLSocket) {
        Object next;
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Iterator<T> it = this.f25759f.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((SocketAdapter) next).mo10334a(sSLSocket)) {
                break;
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) next;
        if (socketAdapter != null) {
            return socketAdapter.mo10336c(sSLSocket);
        }
        return null;
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* JADX INFO: renamed from: g */
    public Object mo10321g(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "closer");
        CloseGuard closeGuard = this.f25760g;
        Objects.requireNonNull(closeGuard);
        Intrinsics3.checkParameterIsNotNull(str, "closer");
        Method method = closeGuard.f25801a;
        if (method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(null, new Object[0]);
            Method method2 = closeGuard.f25802b;
            if (method2 == null) {
                Intrinsics3.throwNpe();
            }
            method2.invoke(objInvoke, str);
            return objInvoke;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* JADX INFO: renamed from: h */
    public boolean mo10318h(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "hostname");
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
        if (i < 23) {
            return true;
        }
        NetworkSecurityPolicy networkSecurityPolicy = NetworkSecurityPolicy.getInstance();
        Intrinsics3.checkExpressionValueIsNotNull(networkSecurityPolicy, "NetworkSecurityPolicy.getInstance()");
        return networkSecurityPolicy.isCleartextTrafficPermitted();
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* JADX INFO: renamed from: k */
    public void mo10322k(String str, Object obj) {
        Intrinsics3.checkParameterIsNotNull(str, "message");
        CloseGuard closeGuard = this.f25760g;
        Objects.requireNonNull(closeGuard);
        boolean z2 = false;
        if (obj != null) {
            try {
                Method method = closeGuard.f25803c;
                if (method == null) {
                    Intrinsics3.throwNpe();
                }
                method.invoke(obj, new Object[0]);
                z2 = true;
            } catch (Exception unused) {
            }
        }
        if (z2) {
            return;
        }
        Platform2.m10329j(this, str, 5, null, 4, null);
    }
}
